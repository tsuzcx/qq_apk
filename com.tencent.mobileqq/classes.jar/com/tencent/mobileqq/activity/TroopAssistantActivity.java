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
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticTroopAssist;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopCommonlyUsedHandler;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  protected FriendListObserver a;
  protected MessageObserver a;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new TroopAssistantActivity.19(this);
  protected TransProcessorHandler a;
  protected TroopCommonlyUsedObserver a;
  protected TroopMngObserver a;
  protected TroopOnlinePushObserver a;
  protected RoamSettingObserver a;
  protected IRoamSettingService a;
  protected TroopUsingTimeReport a;
  protected QQProgressNotifier a;
  protected PopupMenuDialog a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  Comparator<RecentBaseData> jdField_a_of_type_JavaUtilComparator = new TroopAssistantActivity.23(this);
  protected List<Long> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new TroopAssistantActivity.18(this);
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
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver = new TroopAssistantActivity.9(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver = new TroopAssistantActivity.10(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TroopAssistantActivity.11(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopAssistantActivity.12(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver = new TroopAssistantActivity.13(this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Resources localResources = getResources();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.setMainTitle(localResources.getString(2131719485, new Object[] { paramString2 }));
    localActionSheet.addRadioButton(localResources.getString(2131697652), false);
    localActionSheet.addRadioButton(localResources.getString(2131697657), false);
    localActionSheet.addRadioButton(localResources.getString(2131697653), false);
    localActionSheet.addRadioButton(localResources.getString(2131697649), false);
    int j = this.app.getTroopMask(String.valueOf(paramString1));
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j == 4) {
            localActionSheet.setRadioButtonChecked(1);
          }
        }
        else {
          localActionSheet.setRadioButtonChecked(3);
        }
      }
      else {
        localActionSheet.setRadioButtonChecked(2);
      }
    }
    else {
      localActionSheet.setRadioButtonChecked(0);
    }
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new TroopAssistantActivity.22(this, j, paramString1, localActionSheet));
    localActionSheet.show();
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
        localView = localView.findViewById(2131380210);
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
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131379277));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379173);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (!this.g)
    {
      this.jdField_b_of_type_AndroidViewView = View.inflate(this, 2131562947, null);
      ViewCompat.setImportantForAccessibility(this.jdField_b_of_type_AndroidViewView, 2);
      this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379170);
      this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379169);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376568));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
      View localView = View.inflate(this, 2131558896, null);
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
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131379277));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379173);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int j = ((DisplayMetrics)localObject).heightPixels;
    int k = AIOUtils.b(154.0F, getBaseContext().getResources());
    int m = getTitleBarHeight();
    int n = ImmersiveUtils.getStatusBarHeight(getBaseContext());
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131379174));
    this.jdField_b_of_type_ComTencentWidgetXListView.setMaxHeight(j - k - m - n);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379168);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379169);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379170);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376568));
    localObject = (TextView)this.jdField_d_of_type_AndroidViewView;
    ((TextView)localObject).setText(2131719783);
    ((TextView)localObject).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131379171));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131379167));
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
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(8);
        localObject = new qqstory_group.ReqGetGroupDynamicEntrancePicture();
        ((qqstory_group.ReqGetGroupDynamicEntrancePicture)localObject).version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
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
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BuddyTransfileProcessor.class, ((IPicTransFile)this.app.getRuntimeService(IPicTransFile.class)).getC2CUploadProClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getGroupPttDownloadProcessorClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getC2CPttDownloadProcessorClass(), ForwardImageProcessor.class });
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  private void k()
  {
    QLog.e("TroopAssistantActivity", 2, "initTitleBar");
    setTitle(2131719797);
    Object localObject = this.rightViewImg;
    int j;
    if (this.e)
    {
      ((TextView)findViewById(2131369249)).setTextColor(getResources().getColorStateList(2131167054));
      j = 2130843861;
    }
    else
    {
      j = 2130840347;
    }
    ((ImageView)localObject).setImageResource(j);
    ((ImageView)localObject).setContentDescription(getString(2131720050));
    ((ImageView)localObject).setOnClickListener(new TroopAssistantActivity.14(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369240));
    b();
    if ("batch_setting".equals(this.jdField_b_of_type_JavaLangString)) {
      ((ImageView)localObject).setVisibility(8);
    } else {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = (RelativeLayout)findViewById(2131376636);
    if (this.e)
    {
      ((RelativeLayout)localObject).setBackgroundResource(2130850434);
      return;
    }
    ((RelativeLayout)localObject).setBackgroundResource(2130850433);
  }
  
  private void l()
  {
    this.jdField_d_of_type_Boolean = TroopAssistantManager.a().b();
    int j;
    if (this.jdField_d_of_type_Boolean)
    {
      localObject = getString(2131720045);
      j = 2130842577;
    }
    else
    {
      localObject = getString(2131720046);
      j = 2130842578;
    }
    String str = getString(2131720051);
    ArrayList localArrayList = new ArrayList();
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = 0;
    localMenuItem.title = ((String)localObject);
    localMenuItem.contentDescription = localMenuItem.title;
    localMenuItem.iconId = j;
    localArrayList.add(localMenuItem);
    Object localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).id = 1;
    ((PopupMenuDialog.MenuItem)localObject).title = str;
    ((PopupMenuDialog.MenuItem)localObject).contentDescription = ((PopupMenuDialog.MenuItem)localObject).title;
    ((PopupMenuDialog.MenuItem)localObject).iconId = 2130842575;
    localArrayList.add(localObject);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.build(this, localArrayList, new TroopAssistantActivity.15(this), new TroopAssistantActivity.16(this));
    localObject = super.getTitleBarView();
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown((View)localObject, ((View)localObject).getWidth() - getResources().getDimensionPixelSize(2131298902) - getResources().getDimensionPixelSize(2131298898), getResources().getDimensionPixelSize(2131298899));
    AccessibilityUtil.b(findViewById(2131378893), false);
  }
  
  protected List<RecentBaseData> a()
  {
    QLog.e("TroopAssistantActivity", 2, "makeRecetBaseData");
    Object localObject1 = TroopAssistantManager.a().b(this.app);
    int k = 0;
    int j;
    if (localObject1 == null) {
      j = 0;
    } else {
      j = ((List)localObject1).size();
    }
    ArrayList localArrayList = new ArrayList(j);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("makeRecetBaseData before, data.size:");
      ((StringBuilder)localObject2).append(j);
      QLog.i("TroopAssistantActivity", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new HashSet();
    while (k < j)
    {
      Object localObject3 = (TroopAssistantData)((List)localObject1).get(k);
      if ((localObject3 != null) && (!((HashSet)localObject2).contains(((TroopAssistantData)localObject3).troopUin)))
      {
        ((HashSet)localObject2).add(((TroopAssistantData)localObject3).troopUin);
        localObject3 = new RecentTroopAssistantItem((TroopAssistantData)localObject3);
        ((RecentTroopAssistantItem)localObject3).a(this.app, BaseApplication.getContext());
        if (QLog.isColorLevel())
        {
          long l = System.currentTimeMillis();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(l - 0L);
          localStringBuilder.append(", ");
          localStringBuilder.append(((RecentTroopAssistantItem)localObject3).getRecentUserUin());
          localStringBuilder.append(",");
          localStringBuilder.append(localObject3.getClass().getName());
          localStringBuilder.append("]");
          QLog.i("Q.recent.cost", 2, localStringBuilder.toString());
          ((RecentTroopAssistantItem)localObject3).printDataItem();
        }
        localArrayList.add(localObject3);
      }
      k += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("makeRecetBaseData end, items.size:");
      ((StringBuilder)localObject1).append(localArrayList.size());
      QLog.i("TroopAssistantActivity", 2, ((StringBuilder)localObject1).toString());
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (TroopAssistantManager.a().a(this.app) == true) {
      TroopAssistantManager.a().a(this.app.getEntityManagerFactory().createEntityManager(), this.app);
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.app.getMessageFacade().addObserver(this);
    this.app.getAVNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    RecentAdapter localRecentAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
    if (localRecentAdapter != null) {
      localRecentAdapter.a(this.app);
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != -1))
    {
      this.jdField_a_of_type_Int = (paramInt | this.jdField_a_of_type_Int & (paramInt ^ 0xFFFFFFFF));
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = ((TroopManager)localObject).d(paramRecentBaseData.getRecentUserUin());
    if (!TextUtils.isEmpty(str))
    {
      if (!((ITroopCommonlyUsedHandler)this.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName())).a(str, paramBoolean ^ true)) {
        return;
      }
      localObject = ((TroopManager)localObject).c(paramRecentBaseData.getRecentUserUin());
      if (localObject != null)
      {
        paramInt = ((TroopInfo)localObject).troopmask;
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            paramInt = 2;
            break label119;
          }
        }
        else
        {
          paramInt = 1;
          break label119;
        }
      }
      paramInt = 0;
      label119:
      localObject = new ReportTask(this.app).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
      str = paramRecentBaseData.getRecentUserUin();
      if (paramBoolean) {
        paramRecentBaseData = "0";
      } else {
        paramRecentBaseData = "1";
      }
      ((ReportTask)localObject).a(new String[] { str, String.valueOf(paramInt), paramRecentBaseData }).a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopAssistantActivity", 2, "TroopManage.getTroopCodeByTroopUin return null...");
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new TroopAssistantActivity.1(this, paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  void a(String paramString)
  {
    TroopAssistantManager.a().b(paramString, this.app);
    c();
    RecentUtil.b(this.app, paramString, 1);
    this.app.getMessageFacade().a(paramString, 1);
    paramString = this.app.getHandler(Conversation.class);
    if (paramString != null) {
      paramString.sendEmptyMessage(1014);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    TroopAssistantManager.a().a(this.app, paramString, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService.getMapRequest().put(paramString, Boolean.valueOf(true));
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
    else if (paramInt == 0)
    {
      FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("");
      paramString1 = localFriendsManager.e(localStringBuilder.toString());
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
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.b();
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
    if ((this.leftView != null) && (this.mLeftBackText != null))
    {
      if (this.mLeftBackText == null) {
        return;
      }
      Object localObject1;
      if (this.e)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.leftView.setVisibility(8);
        this.mLeftBackIcon.setVisibility(0);
        this.mLeftBackIcon.setContentDescription(HardCodeUtil.a(2131714984));
        this.mLeftBackText.setVisibility(0);
        localObject1 = this.mLeftBackText;
        a((View)localObject1, 0, 0, 0, (int)(this.mDensity * 30.0F + 0.5F));
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.leftView.setVisibility(0);
        localObject1 = getResources().getColorStateList(2131167053);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
        localObject2 = (GradientDrawable)this.jdField_a_of_type_AndroidWidgetTextView.getBackground();
        if (localObject2 != null)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            ((GradientDrawable)localObject2).setColor((ColorStateList)localObject1);
          } else {
            ((GradientDrawable)localObject2).setColor(((ColorStateList)localObject1).getDefaultColor());
          }
          ((GradientDrawable)localObject2).setAlpha(46);
        }
        if (!ThemeUtil.isNowThemeIsSimple(this.app, false, null))
        {
          localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(28.0F, getResources());
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = (RelativeLayout.LayoutParams)this.leftView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(5.0F, getResources());
          this.leftView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.mLeftBackIcon.setVisibility(8);
        this.mLeftBackText.setVisibility(8);
        localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      }
      Object localObject2 = this.app.getMessageFacade();
      if (localObject2 != null) {
        ThreadManager.post(new TroopAssistantActivity.17(this, (QQMessageFacade)localObject2, (TextView)localObject1), 8, null, true);
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshTroopList:");
    localStringBuilder.append(new Exception("this is a log").getStackTrace());
    QLog.e("TroopAssistantActivity", 2, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsRefreshing:");
    localStringBuilder.append(this.h);
    QLog.e("TroopAssistantActivity", 2, localStringBuilder.toString());
    if (this.h) {
      return;
    }
    ThreadManager.excute(new TroopAssistantActivity.20(this), 32, this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      RecentAdapter localRecentAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
      if ((localRecentAdapter != null) && (this.jdField_d_of_type_AndroidViewView != null))
      {
        if (localRecentAdapter.b())
        {
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        if (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) {
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = EventCollector.getInstance();
    boolean bool = true;
    ((EventCollector)localObject).onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    localObject = this.jdField_a_of_type_AndroidViewGestureDetector;
    if ((localObject == null) || (!((GestureDetector)localObject).onTouchEvent(paramMotionEvent))) {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    QLog.e("TroopAssistantActivity", 2, "doOnCreate");
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_Float = (ViewConfiguration.get(this).getScaledTouchSlop() * 2);
    try
    {
      super.setContentView(2131562945);
      getWindow().setBackgroundDrawable(null);
      setStatusBarBlue();
      this.e = ThemeUtil.isDefaultOrDIYTheme(false);
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this);
      paramBundle = (LinearLayout)findViewById(2131379353);
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
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport;
    if (localObject != null) {
      ((TroopUsingTimeReport)localObject).b();
    }
    super.doOnDestroy();
    if (this.app == null) {
      return;
    }
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.app.getAVNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver);
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a(this);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
    if (localObject != null) {
      ((RecentAdapter)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null) {
      ((XListView)localObject).setAdapter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
    ((StoryManager)SuperManager.a(5)).c();
    ((UserManager)SuperManager.a(2)).d();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a();
    }
    if (this.app != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
      if (localObject != null)
      {
        localObject = ((RecentAdapter)localObject).getItem(0);
        if ((localObject instanceof RecentBaseData))
        {
          localObject = (RecentBaseData)localObject;
          localObject = this.app.getMessageFacade().getLastMessage(((RecentBaseData)localObject).getRecentUserUin(), ((RecentBaseData)localObject).getRecentUserType());
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
  }
  
  protected void doOnResume()
  {
    QLog.e("TroopAssistantActivity", 2, "doOnResume");
    super.doOnResume();
    c();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.a();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      StatisticTroopAssist.e(this, this.app.getCurrentAccountUin());
    }
    else
    {
      c();
      if (this.jdField_b_of_type_Boolean) {
        StatisticTroopAssist.c(this, this.app.getCurrentAccountUin());
      } else {
        StatisticTroopAssist.d(this, this.app.getCurrentAccountUin());
      }
    }
    return super.onBackEvent();
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800419E", "0X800419E", 0, 0, "", "", "", "");
    }
    paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if ((paramDragFrameLayout != null) && (paramDragFrameLayout.a() == -1)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
  }
  
  public void onClick(View paramView, Object paramObject)
  {
    if (paramView == null) {
      return;
    }
    int j = paramView.getId();
    if (j == 2131379173)
    {
      this.jdField_c_of_type_Boolean = false;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
      if (paramView != null)
      {
        paramView.a(4);
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
    if (j == 2131379172)
    {
      this.jdField_c_of_type_Boolean = false;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
      if (paramView != null)
      {
        paramView.a(4);
        d();
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
        c();
      }
      TroopAssistantManager.a().f(this.app);
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
    if (!a())
    {
      if (b()) {
        return false;
      }
      if (paramMotionEvent1 != null)
      {
        if (paramMotionEvent2 == null) {
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
        }
      }
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    paramString2 = getResources();
    int j = paramRecentBaseData.getRecentUserType();
    if (j == 1)
    {
      if (Utils.a(paramString1, paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[2])))
      {
        a(j, paramRecentBaseData, false);
        return;
      }
      if (Utils.a(paramString1, paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[3]))) {
        a(j, paramRecentBaseData, true);
      }
    }
    else if ((paramRecentBaseData.getRecentUserType() == 1) && (Utils.a(paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[1]), paramString1)))
    {
      a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getTitleName());
    }
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    if (paramRecentBaseData.getUnreadNum() > 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), paramString);
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    a(paramRecentBaseData.getRecentUserUin());
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (b()) {
      return false;
    }
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f1 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
      if (a())
      {
        if (Math.abs(paramFloat2) > this.jdField_a_of_type_Float)
        {
          if ((paramFloat1 < 0.0F) && (f1 < 0.5F))
          {
            a(1);
            return true;
          }
          if ((paramFloat1 > 0.0F) && (f1 < 0.5F))
          {
            a(2);
            return true;
          }
        }
      }
      else if (a(1))
      {
        if ((paramFloat1 > 0.0F) || (f1 >= 0.5F))
        {
          a(-1);
          return false;
        }
      }
      else if ((a(2)) && ((paramFloat1 < 0.0F) || (f1 >= 0.5F))) {
        a(-1);
      }
    }
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
    paramView = this.jdField_a_of_type_AndroidViewGestureDetector;
    return (paramView != null) && (paramView.onTouchEvent(paramMotionEvent));
  }
  
  protected String setLastActivityName()
  {
    return "";
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new TroopAssistantActivity.21(this));
      }
      if ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == -2002)) {
        return;
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity
 * JD-Core Version:    0.7.0.1
 */