package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupDynamicEntrancePicture;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopDynamicConfig;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.adapter.TroopMessageSettingSingleAdapter;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticTroopAssist;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class TroopAssistantActivity
  extends IphoneTitleBarActivity
  implements GestureDetector.OnGestureListener, View.OnTouchListener, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, Observer
{
  public static final String a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  protected long a;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected View a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  private AVObserver jdField_a_of_type_ComTencentAvGaudioAVObserver = new TroopAssistantActivity.6(this);
  protected RecentAdapter a;
  protected DragFrameLayout a;
  protected TroopMessageSettingSingleAdapter a;
  protected BizTroopObserver a;
  protected FriendListObserver a;
  protected MessageObserver a;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new TroopAssistantActivity.17(this);
  protected TroopBusinessObserver a;
  protected TransProcessorHandler a;
  protected TroopUsingTimeReport a;
  protected RoamSettingController a;
  protected QQProgressNotifier a;
  protected PopupMenuDialog a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  Comparator<RecentBaseData> jdField_a_of_type_JavaUtilComparator = new TroopAssistantActivity.21(this);
  protected List<Long> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new TroopAssistantActivity.16(this);
  boolean jdField_a_of_type_Boolean;
  protected View b;
  protected Button b;
  XListView b;
  protected String b;
  protected boolean b;
  protected View c;
  boolean c;
  protected View d;
  protected boolean d;
  protected boolean e;
  protected boolean f = true;
  private boolean g = false;
  private boolean h = false;
  private boolean i = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StoryGroupSvc.get_dynamic_entrance_info");
  }
  
  public TroopAssistantActivity()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new TroopAssistantActivity.7(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new TroopAssistantActivity.8(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopAssistantActivity.9(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TroopAssistantActivity.10(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopAssistantActivity.11(this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Resources localResources = getResources();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.setMainTitle(localResources.getString(2131719761, new Object[] { paramString2 }));
    localActionSheet.addRadioButton(localResources.getString(2131697646), false);
    localActionSheet.addRadioButton(localResources.getString(2131697651), false);
    localActionSheet.addRadioButton(localResources.getString(2131697647), false);
    localActionSheet.addRadioButton(localResources.getString(2131697643), false);
    int j = this.app.getTroopMask(String.valueOf(paramString1));
    switch (j)
    {
    }
    for (;;)
    {
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new TroopAssistantActivity.20(this, j, paramString1, localActionSheet));
      localActionSheet.show();
      return;
      localActionSheet.setRadioButtonChecked(0);
      continue;
      localActionSheet.setRadioButtonChecked(1);
      continue;
      localActionSheet.setRadioButtonChecked(2);
      continue;
      localActionSheet.setRadioButtonChecked(3);
    }
  }
  
  private boolean c()
  {
    int k = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int j = 0;
    while (j < k)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(j);
      if (localView != null)
      {
        localView = localView.findViewById(2131380944);
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          this.jdField_b_of_type_Boolean = false;
          return this.jdField_b_of_type_Boolean;
        }
      }
      j += 1;
    }
    this.jdField_b_of_type_Boolean = true;
    return this.jdField_b_of_type_Boolean;
  }
  
  private void e()
  {
    QLog.e("TroopAssistantActivity", 2, "initContentView");
    if (TroopAssistantManager.a().c(this.app))
    {
      QLog.e("TroopAssistantActivity", 2, "initContentView, initContentViewSettingModal");
      g();
      ReportController.b(this.app, "dc00899", "Grp_msg", "", "helper-guide", "exp_guide", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("TroopAssistantActivity", 2, "initContentView, initContentViewNormalModal");
    f();
  }
  
  private void f()
  {
    this.jdField_b_of_type_JavaLangString = "normal";
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131379948));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379844);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (!this.g)
    {
      this.jdField_b_of_type_AndroidViewView = View.inflate(this, 2131563124, null);
      ViewCompat.setImportantForAccessibility(this.jdField_b_of_type_AndroidViewView, 2);
      this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379841);
      this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379840);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377091));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
      View localView = View.inflate(this, 2131559002, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(localView);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this, 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(4);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.g = true;
    }
    h();
  }
  
  private void g()
  {
    this.jdField_b_of_type_JavaLangString = "batch_setting";
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131379948));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379844);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int j = ((DisplayMetrics)localObject).heightPixels;
    int k = AIOUtils.a(154.0F, getBaseContext().getResources());
    int m = getTitleBarHeight();
    int n = ImmersiveUtils.getStatusBarHeight(getBaseContext());
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131379845));
    this.jdField_b_of_type_ComTencentWidgetXListView.setMaxHeight(j - k - m - n);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379839);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379840);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379841);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377091));
    localObject = (TextView)this.jdField_d_of_type_AndroidViewView;
    ((TextView)localObject).setText(2131720051);
    ((TextView)localObject).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131379842));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131379838));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new TroopAssistantActivity.2(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new TroopAssistantActivity.3(this));
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingSingleAdapter = new TroopMessageSettingSingleAdapter(this, this.app, null);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingSingleAdapter);
    TroopAssistantManager.a().a(this.app, new TroopAssistantActivity.TroopProtocolObserver(new WeakReference(this)));
    h();
  }
  
  private void h()
  {
    Object localObject = (TroopStoryManager)this.app.getManager(QQManagerFactory.TROOP_STORY_MANAGER);
    if ((localObject != null) && (((TroopStoryManager)localObject).a != null) && (((TroopStoryManager)localObject).a.jdField_a_of_type_Boolean))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new TroopAssistantActivity.4(this));
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject = new qqstory_group.ReqGetGroupDynamicEntrancePicture();
        ((qqstory_group.ReqGetGroupDynamicEntrancePicture)localObject).version.set(ByteStringMicro.copyFromUtf8("8.5.5"));
        ProtoUtils.a(this.app, new TroopAssistantActivity.5(this), ((qqstory_group.ReqGetGroupDynamicEntrancePicture)localObject).toByteArray(), jdField_a_of_type_JavaLangString);
      }
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void i()
  {
    f();
    this.rightViewImg.setVisibility(0);
    c();
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class, ForwardImageProcessor.class });
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  private void k()
  {
    QLog.e("TroopAssistantActivity", 2, "initTitleBar");
    setTitle(2131720065);
    Object localObject = this.rightViewImg;
    int j = 2130840478;
    if (this.e)
    {
      ((TextView)findViewById(2131369534)).setTextColor(getResources().getColorStateList(2131167031));
      j = 2130843941;
    }
    ((ImageView)localObject).setImageResource(j);
    ((ImageView)localObject).setContentDescription(getString(2131720311));
    ((ImageView)localObject).setOnClickListener(new TroopAssistantActivity.12(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369525));
    b();
    if ("batch_setting".equals(this.jdField_b_of_type_JavaLangString)) {
      ((ImageView)localObject).setVisibility(8);
    }
    for (;;)
    {
      localObject = (RelativeLayout)findViewById(2131377159);
      if (!this.e) {
        break;
      }
      ((RelativeLayout)localObject).setBackgroundResource(2130850508);
      return;
      ((ImageView)localObject).setVisibility(0);
    }
    ((RelativeLayout)localObject).setBackgroundResource(2130850507);
  }
  
  private void l()
  {
    this.jdField_d_of_type_Boolean = TroopAssistantManager.a().b();
    Object localObject;
    if (this.jdField_d_of_type_Boolean) {
      localObject = getString(2131720306);
    }
    for (int j = 2130842678;; j = 2130842679)
    {
      String str = getString(2131720312);
      ArrayList localArrayList = new ArrayList();
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = 0;
      localMenuItem.jdField_a_of_type_JavaLangString = ((String)localObject);
      localMenuItem.c = localMenuItem.jdField_a_of_type_JavaLangString;
      localMenuItem.b = j;
      localArrayList.add(localMenuItem);
      localObject = new PopupMenuDialog.MenuItem();
      ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_Int = 1;
      ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangString = str;
      ((PopupMenuDialog.MenuItem)localObject).c = ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangString;
      ((PopupMenuDialog.MenuItem)localObject).b = 2130842676;
      localArrayList.add(localObject);
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this, localArrayList, new TroopAssistantActivity.13(this), new TroopAssistantActivity.14(this));
      localObject = super.getTitleBarView();
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown((View)localObject, ((View)localObject).getWidth() - getResources().getDimensionPixelSize(2131298898) - getResources().getDimensionPixelSize(2131298894), getResources().getDimensionPixelSize(2131298895));
      AccessibilityUtil.b(findViewById(2131379546), false);
      return;
      localObject = getString(2131720307);
    }
  }
  
  protected List<RecentBaseData> a()
  {
    QLog.e("TroopAssistantActivity", 2, "makeRecetBaseData");
    List localList = TroopAssistantManager.a().b(this.app);
    int j;
    ArrayList localArrayList;
    HashSet localHashSet;
    int k;
    label81:
    Object localObject;
    if (localList == null)
    {
      j = 0;
      localArrayList = new ArrayList(j);
      if (QLog.isColorLevel()) {
        QLog.i("TroopAssistantActivity", 2, "makeRecetBaseData before, data.size:" + j);
      }
      localHashSet = new HashSet();
      k = 0;
      if (k >= j) {
        break label263;
      }
      localObject = (TroopAssistantData)localList.get(k);
      if (localObject != null) {
        break label122;
      }
    }
    for (;;)
    {
      k += 1;
      break label81;
      j = localList.size();
      break;
      label122:
      if (!localHashSet.contains(((TroopAssistantData)localObject).troopUin))
      {
        localHashSet.add(((TroopAssistantData)localObject).troopUin);
        localObject = new RecentTroopAssistantItem((TroopAssistantData)localObject);
        ((RecentTroopAssistantItem)localObject).a(this.app, BaseApplication.getContext());
        if (QLog.isColorLevel())
        {
          long l = System.currentTimeMillis();
          QLog.i("Q.recent.cost", 2, "[" + (l - 0L) + ", " + ((RecentTroopAssistantItem)localObject).getRecentUserUin() + "," + localObject.getClass().getName() + "]");
          ((RecentTroopAssistantItem)localObject).printDataItem();
        }
        localArrayList.add(localObject);
      }
    }
    label263:
    if (QLog.isColorLevel()) {
      QLog.i("TroopAssistantActivity", 2, "makeRecetBaseData end, items.size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (TroopAssistantManager.a().a(this.app) == true) {
      TroopAssistantManager.a().a(this.app.getEntityManagerFactory().createEntityManager(), this.app);
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.app.getMessageFacade().addObserver(this);
    this.app.getAVNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.app);
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int & (paramInt ^ 0xFFFFFFFF) | paramInt);
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = ((TroopManager)localObject).d(paramRecentBaseData.getRecentUserUin());
    if (!TextUtils.isEmpty(str))
    {
      localBizTroopHandler = (BizTroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      if (paramBoolean)
      {
        paramInt = 0;
        if (localBizTroopHandler.a(str, paramInt)) {
          break label72;
        }
      }
    }
    label72:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        BizTroopHandler localBizTroopHandler;
        return;
        paramInt = 1;
      }
      localObject = ((TroopManager)localObject).c(paramRecentBaseData.getRecentUserUin());
      if (localObject != null) {}
      switch (((TroopInfo)localObject).troopmask)
      {
      default: 
        paramInt = 0;
        localObject = new ReportTask(this.app).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
        str = paramRecentBaseData.getRecentUserUin();
        if (!paramBoolean) {
          break;
        }
      }
      for (paramRecentBaseData = "0";; paramRecentBaseData = "1")
      {
        ((ReportTask)localObject).a(new String[] { str, String.valueOf(paramInt), paramRecentBaseData }).a();
        return;
        paramInt = 1;
        break;
        paramInt = 2;
        break;
      }
    }
    QLog.e("TroopAssistantActivity", 2, "TroopManage.getTroopCodeByTroopUin return null...");
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new TroopAssistantActivity.1(this, paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    if (paramRecentBaseData.getUnreadNum() > 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), paramString);
  }
  
  public void a(View paramView, Object paramObject)
  {
    if (paramView == null) {}
    int j;
    do
    {
      return;
      j = paramView.getId();
      if (j == 2131379844)
      {
        this.jdField_c_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(4);
          d();
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
        }
        paramView = new Intent(this, TroopAssisSettingActivity.class);
        paramView.setFlags(67108864);
        startActivity(paramView);
        if (TroopAssistantManager.a().c()) {
          TroopAssistantManager.a().f(this.app);
        }
        ReportController.b(this.app, "P_CliOper", "Grp_msg", "", "help_nav", "Clk_set", 0, 0, "", "", "", "");
        return;
      }
    } while (j != 2131379843);
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(4);
      d();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      c();
    }
    TroopAssistantManager.a().f(this.app);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    a(paramRecentBaseData.getRecentUserUin());
  }
  
  void a(String paramString)
  {
    TroopAssistantManager.a().b(paramString, this.app);
    c();
    RecentUtil.b(this.app, paramString, 1);
    this.app.getMessageFacade().c(paramString, 1);
    paramString = this.app.getHandler(Conversation.class);
    if (paramString != null) {
      paramString.sendEmptyMessage(1014);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    TroopAssistantManager.a().a(this.app, paramString, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.put(paramString, Boolean.valueOf(true));
  }
  
  void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    if (paramInt == 1)
    {
      paramString1 = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
      if ((paramString1 != null) && (paramString1.troopcode != null)) {
        localIntent.putExtra("troop_uin", paramString1.troopcode);
      }
    }
    for (;;)
    {
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString2);
      startActivity(localIntent);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.b();
      return;
      if (paramInt == 0)
      {
        paramString1 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1 + "");
        if (paramString1 != null)
        {
          localIntent.putExtra("cSpecialFlag", paramString1.cSpecialFlag);
          if ((CrmUtils.a(paramString1.cSpecialFlag)) || (QidianManager.b(paramString1.cSpecialFlag)))
          {
            localIntent.setClass(this, ChatActivity.class);
            localIntent.putExtra("chat_subType", 1);
          }
        }
      }
      else if (paramInt != 3000) {}
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    paramString2 = getResources();
    int j = paramRecentBaseData.getRecentUserType();
    if (j == 1) {
      if (Utils.a(paramString1, paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[2]))) {
        a(j, paramRecentBaseData, false);
      }
    }
    while ((paramRecentBaseData.getRecentUserType() != 1) || (!Utils.a(paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[1]), paramString1)))
    {
      do
      {
        return;
      } while (!Utils.a(paramString1, paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[3])));
      a(j, paramRecentBaseData, true);
      return;
    }
    a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getTitleName());
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800419E", "0X800419E", 0, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public boolean a(int paramInt)
  {
    return (!b()) && ((this.jdField_a_of_type_Int & paramInt) == paramInt);
  }
  
  void b()
  {
    if ((this.leftView == null) || (this.mLeftBackText == null) || (this.mLeftBackText == null)) {}
    do
    {
      return;
      if (!this.e) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.leftView.setVisibility(8);
      this.mLeftBackIcon.setVisibility(0);
      this.mLeftBackIcon.setContentDescription(HardCodeUtil.a(2131715061));
      this.mLeftBackText.setVisibility(0);
      localObject1 = this.mLeftBackText;
      a((View)localObject1, 0, 0, 0, (int)(30.0F * this.mDensity + 0.5F));
      localObject2 = this.app.getMessageFacade();
    } while (localObject2 == null);
    ThreadManager.post(new TroopAssistantActivity.15(this, (QQMessageFacade)localObject2, (TextView)localObject1), 8, null, true);
    return;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.leftView.setVisibility(0);
    Object localObject1 = getResources().getColorStateList(2131167030);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
    Object localObject2 = (GradientDrawable)this.jdField_a_of_type_AndroidWidgetTextView.getBackground();
    if (localObject2 != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label305;
      }
      ((GradientDrawable)localObject2).setColor((ColorStateList)localObject1);
    }
    for (;;)
    {
      ((GradientDrawable)localObject2).setAlpha(46);
      if (!ThemeUtil.isNowThemeIsSimple(this.app, false, null))
      {
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(28.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (RelativeLayout.LayoutParams)this.leftView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(5.0F, getResources());
        this.leftView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.mLeftBackIcon.setVisibility(8);
      this.mLeftBackText.setVisibility(8);
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      break;
      label305:
      ((GradientDrawable)localObject2).setColor(((ColorStateList)localObject1).getDefaultColor());
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  void c()
  {
    QLog.e("TroopAssistantActivity", 2, "refreshTroopList:" + new Exception("this is a log").getStackTrace());
    QLog.e("TroopAssistantActivity", 2, "mIsRefreshing:" + this.h);
    if (this.h) {
      return;
    }
    ThreadManager.excute(new TroopAssistantActivity.18(this), 32, this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b()) {
        break label41;
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    label41:
    while (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0) {
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if ((this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {}
    for (;;)
    {
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.e("TroopAssistantActivity", 2, "doOnCreate");
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_Float = (ViewConfiguration.get(this).getScaledTouchSlop() * 2);
    try
    {
      super.setContentView(2131563122);
      getWindow().setBackgroundDrawable(null);
      setStatusBarBlue();
      this.e = ThemeUtil.isDefaultOrDIYTheme(false);
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this);
      paramBundle = (LinearLayout)findViewById(2131380024);
      paramBundle.setOnTouchListener(this);
      paramBundle.setLongClickable(true);
      e();
      k();
      a();
      j();
      StoryReportor.a("grp_help", "exp", 0, 0, new String[] { "", "", "", "" });
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport = new TroopUsingTimeReport(this.app, null, "Grp_time", "helper", "visit_time");
      return true;
    }
    catch (Exception paramBundle)
    {
      QLog.e("TroopAssistantActivity", 1, "doOnCreateFailed", paramBundle);
      finish();
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.b();
    }
    super.doOnDestroy();
    if (this.app == null) {
      return;
    }
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.app.getAVNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
    ((StoryManager)SuperManager.a(5)).c();
    ((UserManager)SuperManager.a(2)).d();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(0);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        localObject = this.app.getMessageFacade().a(((RecentBaseData)localObject).getRecentUserUin(), ((RecentBaseData)localObject).getRecentUserType());
        if (localObject != null)
        {
          TroopAssistantManager.a().a(this.app, ((Message)localObject).time);
          localObject = this.app.getHandler(Conversation.class);
          if (localObject != null) {
            ((MqqHandler)localObject).sendEmptyMessage(1009);
          }
        }
      }
    }
  }
  
  public void doOnResume()
  {
    QLog.e("TroopAssistantActivity", 2, "doOnResume");
    super.doOnResume();
    c();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.a();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (!this.jdField_a_of_type_Boolean) {
      StatisticTroopAssist.e(this, this.app.getCurrentAccountUin());
    }
    for (;;)
    {
      return super.onBackEvent();
      c();
      if (this.jdField_b_of_type_Boolean) {
        StatisticTroopAssist.c(this, this.app.getCurrentAccountUin());
      } else {
        StatisticTroopAssist.d(this, this.app.getCurrentAccountUin());
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    a(0);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((a()) || (b())) {
      return false;
    }
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return false;
    }
    paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
    if (a(1))
    {
      if ((paramFloat1 < 0.0F) && (paramFloat2 < 0.5F))
      {
        a(-1);
        if (this.i)
        {
          finish();
          return true;
        }
        this.i = true;
        return false;
      }
    }
    else if ((a(2)) && (paramFloat1 > 0.0F) && (paramFloat2 < 0.5F))
    {
      a(-1);
      this.i = false;
      return false;
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (b()) {}
    float f1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while ((paramMotionEvent1 == null) || (paramMotionEvent2 == null));
            paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
            f1 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
            if (!a()) {
              break;
            }
          } while (Math.abs(paramFloat2) <= this.jdField_a_of_type_Float);
          if ((paramFloat1 < 0.0F) && (f1 < 0.5F))
          {
            a(1);
            return true;
          }
        } while ((paramFloat1 <= 0.0F) || (f1 >= 0.5F));
        a(2);
        return true;
        if (!a(1)) {
          break;
        }
      } while ((paramFloat1 <= 0.0F) && (f1 < 0.5F));
      a(-1);
      return false;
    } while ((!a(2)) || ((paramFloat1 >= 0.0F) && (f1 < 0.5F)));
    a(-1);
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    a(-1);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return (this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent));
  }
  
  public String setLastActivityName()
  {
    return "";
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new TroopAssistantActivity.19(this));
      }
      if ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == -2002)) {
        return;
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity
 * JD-Core Version:    0.7.0.1
 */