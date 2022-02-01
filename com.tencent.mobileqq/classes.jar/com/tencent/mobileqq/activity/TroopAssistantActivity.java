package com.tencent.mobileqq.activity;

import Override;
import afbi;
import afbj;
import afbk;
import afbl;
import afbm;
import afbn;
import afbo;
import afbp;
import afbq;
import afbr;
import afbs;
import afbt;
import afbu;
import afbv;
import afbw;
import afbx;
import afby;
import afbz;
import alfv;
import algc;
import alik;
import alje;
import amkn;
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
import anrb;
import anrc;
import anvi;
import anvk;
import anvx;
import anyz;
import aofu;
import awtz;
import bdla;
import bdlf;
import bdls;
import bgqj;
import bgyd;
import bhbx;
import bhhi;
import biso;
import bjxa;
import bkzi;
import bkzz;
import bleh;
import blek;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupDynamicEntrancePicture;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import lng;
import mqq.os.MqqHandler;
import ntb;
import nwu;
import weg;
import wjp;
import wjs;
import wke;
import ykv;
import zci;
import zcj;

public class TroopAssistantActivity
  extends IphoneTitleBarActivity
  implements alfv, alje, GestureDetector.OnGestureListener, View.OnTouchListener, Observer
{
  public static final String a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  public long a;
  public algc a;
  public amkn a;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected View a;
  protected Button a;
  public ImageView a;
  protected TextView a;
  protected anrc a;
  protected anvi a;
  protected anyz a;
  protected aofu a;
  protected bgqj a;
  public bhhi a;
  public biso a;
  protected bleh a;
  protected DragFrameLayout a;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new afbp(this);
  protected TransProcessorHandler a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  Comparator<RecentBaseData> jdField_a_of_type_JavaUtilComparator = new afbs(this);
  public List<Long> a;
  private lng jdField_a_of_type_Lng = new afbx(this);
  public MqqHandler a;
  boolean jdField_a_of_type_Boolean;
  protected View b;
  public Button b;
  XListView b;
  public String b;
  protected boolean b;
  protected View c;
  public boolean c;
  protected View d;
  public boolean d;
  protected boolean e;
  protected boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = weg.a("StoryGroupSvc.get_dynamic_entrance_info");
  }
  
  public TroopAssistantActivity()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new afby(this);
    this.jdField_a_of_type_Anyz = new afbz(this);
    this.jdField_a_of_type_Anrc = new afbi(this);
    this.jdField_a_of_type_Anvi = new afbj(this);
    this.jdField_a_of_type_Aofu = new afbk(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new afbo(this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Resources localResources = getResources();
    bkzi localbkzi = (bkzi)bkzz.a(this, null);
    localbkzi.a(localResources.getString(2131719206, new Object[] { paramString2 }));
    localbkzi.a(localResources.getString(2131697392), false);
    localbkzi.a(localResources.getString(2131697397), false);
    localbkzi.a(localResources.getString(2131697393), false);
    localbkzi.a(localResources.getString(2131697389), false);
    int j = this.app.getTroopMask(String.valueOf(paramString1));
    switch (j)
    {
    }
    for (;;)
    {
      localbkzi.c(2131690697);
      localbkzi.a(new afbr(this, j, paramString1, localbkzi));
      localbkzi.show();
      return;
      localbkzi.d(0);
      continue;
      localbkzi.d(1);
      continue;
      localbkzi.d(2);
      continue;
      localbkzi.d(3);
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
        localView = localView.findViewById(2131380501);
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
    if (awtz.a().c(this.app))
    {
      QLog.e("TroopAssistantActivity", 2, "initContentView, initContentViewSettingModal");
      g();
      bdla.b(this.app, "dc00899", "Grp_msg", "", "helper-guide", "exp_guide", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("TroopAssistantActivity", 2, "initContentView, initContentViewNormalModal");
    f();
  }
  
  private void f()
  {
    this.jdField_b_of_type_JavaLangString = "normal";
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131379525));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379421);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (!this.g)
    {
      this.jdField_b_of_type_AndroidViewView = View.inflate(this, 2131562975, null);
      ViewCompat.setImportantForAccessibility(this.jdField_b_of_type_AndroidViewView, 2);
      this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379418);
      this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379417);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376696));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
      View localView = View.inflate(this, 2131558961, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(localView);
      this.jdField_a_of_type_Algc = new algc(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this, 1);
      this.jdField_a_of_type_Algc.a(4);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Algc);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
      }
      this.jdField_a_of_type_Algc.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.g = true;
    }
    h();
  }
  
  private void g()
  {
    this.jdField_b_of_type_JavaLangString = "batch_setting";
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131379525));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379421);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int j = ((DisplayMetrics)localObject).heightPixels;
    int k = AIOUtils.dp2px(154.0F, getBaseContext().getResources());
    int m = getTitleBarHeight();
    int n = ImmersiveUtils.getStatusBarHeight(getBaseContext());
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131379422));
    this.jdField_b_of_type_ComTencentWidgetXListView.setMaxHeight(j - k - m - n);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379416);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379417);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379418);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376696));
    localObject = (TextView)this.jdField_d_of_type_AndroidViewView;
    ((TextView)localObject).setText(2131719487);
    ((TextView)localObject).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131379419));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131379415));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new afbq(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new afbt(this));
    this.jdField_a_of_type_Amkn = new amkn(this, this.app, null);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Amkn);
    localObject = awtz.a();
    ((awtz)localObject).a(this.app, new afbu(this, (awtz)localObject));
    h();
  }
  
  private void h()
  {
    Object localObject = (zcj)this.app.getManager(QQManagerFactory.TROOP_STORY_MANAGER);
    if ((localObject != null) && (((zcj)localObject).a != null) && (((zcj)localObject).a.jdField_a_of_type_Boolean))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new afbv(this));
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject = new qqstory_group.ReqGetGroupDynamicEntrancePicture();
        ((qqstory_group.ReqGetGroupDynamicEntrancePicture)localObject).version.set(ByteStringMicro.copyFromUtf8("8.4.10"));
        ntb.a(this.app, new afbw(this), ((qqstory_group.ReqGetGroupDynamicEntrancePicture)localObject).toByteArray(), jdField_a_of_type_JavaLangString);
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
    this.app.getTransFileController().addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  private void k()
  {
    QLog.e("TroopAssistantActivity", 2, "initTitleBar");
    setTitle(2131719501);
    Object localObject = this.rightViewImg;
    int j = 2130840365;
    if (this.e)
    {
      ((TextView)findViewById(2131369278)).setTextColor(getResources().getColorStateList(2131167024));
      j = 2130843770;
    }
    ((ImageView)localObject).setImageResource(j);
    ((ImageView)localObject).setContentDescription(getString(2131719733));
    ((ImageView)localObject).setOnClickListener(new afbl(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369269));
    b();
    if ("batch_setting".equals(this.jdField_b_of_type_JavaLangString)) {
      ((ImageView)localObject).setVisibility(8);
    }
    for (;;)
    {
      localObject = (RelativeLayout)findViewById(2131376760);
      if (!this.e) {
        break;
      }
      ((RelativeLayout)localObject).setBackgroundResource(2130850110);
      return;
      ((ImageView)localObject).setVisibility(0);
    }
    ((RelativeLayout)localObject).setBackgroundResource(2130850109);
  }
  
  private void l()
  {
    this.jdField_d_of_type_Boolean = awtz.a().b();
    Object localObject;
    if (this.jdField_d_of_type_Boolean) {
      localObject = getString(2131719728);
    }
    for (int j = 2130842532;; j = 2130842533)
    {
      String str = getString(2131719734);
      ArrayList localArrayList = new ArrayList();
      blek localblek = new blek();
      localblek.jdField_a_of_type_Int = 0;
      localblek.jdField_a_of_type_JavaLangString = ((String)localObject);
      localblek.c = localblek.jdField_a_of_type_JavaLangString;
      localblek.b = j;
      localArrayList.add(localblek);
      localObject = new blek();
      ((blek)localObject).jdField_a_of_type_Int = 1;
      ((blek)localObject).jdField_a_of_type_JavaLangString = str;
      ((blek)localObject).c = ((blek)localObject).jdField_a_of_type_JavaLangString;
      ((blek)localObject).b = 2130842530;
      localArrayList.add(localObject);
      this.jdField_a_of_type_Bleh = bleh.a(this, localArrayList, new afbm(this), new afbn(this));
      localObject = super.getTitleBarView();
      this.jdField_a_of_type_Bleh.showAsDropDown((View)localObject, ((View)localObject).getWidth() - getResources().getDimensionPixelSize(2131298811) - getResources().getDimensionPixelSize(2131298807), getResources().getDimensionPixelSize(2131298808));
      bgyd.b(findViewById(2131379112), false);
      return;
      localObject = getString(2131719729);
    }
  }
  
  protected List<RecentBaseData> a()
  {
    QLog.e("TroopAssistantActivity", 2, "makeRecetBaseData");
    List localList = awtz.a().b(this.app);
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
    if (awtz.a().a(this.app) == true) {
      awtz.a().a(this.app.getEntityManagerFactory().createEntityManager(), this.app);
    }
    addObserver(this.jdField_a_of_type_Anvi);
    addObserver(this.jdField_a_of_type_Anyz);
    addObserver(this.jdField_a_of_type_Aofu);
    addObserver(this.jdField_a_of_type_Anrc);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.app.getMessageFacade().addObserver(this);
    this.app.getAVNotifyCenter().addObserver(this.jdField_a_of_type_Lng);
    if (this.jdField_a_of_type_Algc != null) {
      this.jdField_a_of_type_Algc.a(this.app);
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
      localanrb = (anrb)this.app.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      if (paramBoolean)
      {
        paramInt = 0;
        if (localanrb.a(str, paramInt)) {
          break label72;
        }
      }
    }
    label72:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        anrb localanrb;
        return;
        paramInt = 1;
      }
      localObject = ((TroopManager)localObject).c(paramRecentBaseData.getRecentUserUin());
      if (localObject != null) {}
      switch (((TroopInfo)localObject).troopmask)
      {
      default: 
        paramInt = 0;
        localObject = new bdlf(this.app).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
        str = paramRecentBaseData.getRecentUserUin();
        if (!paramBoolean) {
          break;
        }
      }
      for (paramRecentBaseData = "0";; paramRecentBaseData = "1")
      {
        ((bdlf)localObject).a(new String[] { str, String.valueOf(paramInt), paramRecentBaseData }).a();
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
      if (j == 2131379421)
      {
        this.jdField_c_of_type_Boolean = false;
        if (this.jdField_a_of_type_Algc != null)
        {
          this.jdField_a_of_type_Algc.a(4);
          d();
          this.jdField_a_of_type_Algc.notifyDataSetChanged();
        }
        paramView = new Intent(this, TroopAssisSettingActivity.class);
        paramView.setFlags(67108864);
        startActivity(paramView);
        if (awtz.a().c()) {
          awtz.a().f(this.app);
        }
        bdla.b(this.app, "P_CliOper", "Grp_msg", "", "help_nav", "Clk_set", 0, 0, "", "", "", "");
        return;
      }
    } while (j != 2131379420);
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Algc != null)
    {
      this.jdField_a_of_type_Algc.a(4);
      d();
      this.jdField_a_of_type_Algc.notifyDataSetChanged();
      c();
    }
    awtz.a().f(this.app);
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
    awtz.a().b(paramString, this.app);
    c();
    alik.b(this.app, paramString, 1);
    this.app.getMessageFacade().setReaded(paramString, 1);
    paramString = this.app.getHandler(Conversation.class);
    if (paramString != null) {
      paramString.sendEmptyMessage(1014);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    awtz.a().a(this.app, paramString, paramInt);
    this.jdField_a_of_type_Bhhi.c.put(paramString, Boolean.valueOf(true));
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
      this.jdField_a_of_type_Bgqj.b();
      return;
      if (paramInt == 0)
      {
        paramString1 = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1 + "");
        if (paramString1 != null)
        {
          localIntent.putExtra("cSpecialFlag", paramString1.cSpecialFlag);
          if ((nwu.a(paramString1.cSpecialFlag)) || (bjxa.b(paramString1.cSpecialFlag)))
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
      if (bhbx.a(paramString1, paramString2.getString(alhd.a[2]))) {
        a(j, paramRecentBaseData, false);
      }
    }
    while ((paramRecentBaseData.getRecentUserType() != 1) || (!bhbx.a(paramString2.getString(alhd.a[1]), paramString1)))
    {
      do
      {
        return;
      } while (!bhbx.a(paramString1, paramString2.getString(alhd.a[3])));
      a(j, paramRecentBaseData, true);
      return;
    }
    a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getTitleName());
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean) {
      bdla.b(this.app, "CliOper", "", "", "0X800419E", "0X800419E", 0, 0, "", "", "", "");
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
    label102:
    do
    {
      return;
      if (!this.e) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.leftView.setVisibility(8);
      this.mLeftBackIcon.setVisibility(0);
      this.mLeftBackIcon.setContentDescription(anvx.a(2131714566));
      this.mLeftBackText.setVisibility(0);
      localObject1 = this.mLeftBackText;
      a((View)localObject1, 0, 0, 0, (int)(30.0F * this.mDensity + 0.5F));
      if (localObject1 == null) {
        break label307;
      }
      localObject2 = this.app.getMessageFacade();
    } while (localObject2 == null);
    ThreadManager.post(new TroopAssistantActivity.16(this, (QQMessageFacade)localObject2, (TextView)localObject1), 8, null, true);
    return;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.leftView.setVisibility(0);
    Object localObject1 = getResources().getColorStateList(2131167023);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
    Object localObject2 = (GradientDrawable)this.jdField_a_of_type_AndroidWidgetTextView.getBackground();
    if (localObject2 != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label309;
      }
      ((GradientDrawable)localObject2).setColor((ColorStateList)localObject1);
    }
    for (;;)
    {
      ((GradientDrawable)localObject2).setAlpha(46);
      if (!ThemeUtil.isNowThemeIsSimple(this.app, false, null))
      {
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.dp2px(28.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (RelativeLayout.LayoutParams)this.leftView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.dp2px(5.0F, getResources());
        this.leftView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.mLeftBackIcon.setVisibility(8);
      this.mLeftBackText.setVisibility(8);
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      break label102;
      label307:
      break;
      label309:
      ((GradientDrawable)localObject2).setColor(((ColorStateList)localObject1).getDefaultColor());
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public void c()
  {
    QLog.e("TroopAssistantActivity", 2, "refreshTroopList:" + new Exception("this is a log").getStackTrace());
    QLog.e("TroopAssistantActivity", 2, "mIsRefreshing:" + this.h);
    if (this.h) {
      return;
    }
    ThreadManager.excute(new TroopAssistantActivity.19(this), 32, this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_Algc != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      if (!this.jdField_a_of_type_Algc.b()) {
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
      super.setContentView(2131562973);
      getWindow().setBackgroundDrawable(null);
      setStatusBarBlue();
      this.e = ThemeUtil.isDefaultOrDIYTheme(false);
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this);
      paramBundle = (LinearLayout)findViewById(2131379598);
      paramBundle.setOnTouchListener(this);
      paramBundle.setLongClickable(true);
      e();
      k();
      a();
      j();
      ykv.a("grp_help", "exp", 0, 0, new String[] { "", "", "", "" });
      this.jdField_a_of_type_Bgqj = new bgqj(this.app, null, "Grp_time", "helper", "visit_time");
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
    if (this.jdField_a_of_type_Bgqj != null) {
      this.jdField_a_of_type_Bgqj.b();
    }
    super.doOnDestroy();
    if (this.app == null) {
      return;
    }
    this.app.getTransFileController().removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.app.getAVNotifyCenter().deleteObserver(this.jdField_a_of_type_Lng);
    removeObserver(this.jdField_a_of_type_Anvi);
    removeObserver(this.jdField_a_of_type_Aofu);
    removeObserver(this.jdField_a_of_type_Anyz);
    removeObserver(this.jdField_a_of_type_Anrc);
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    if (this.jdField_a_of_type_Algc != null) {
      this.jdField_a_of_type_Algc.b();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    this.jdField_a_of_type_Algc = null;
    ((wjp)wjs.a(5)).c();
    ((wke)wjs.a(2)).d();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if ((this.app != null) && (this.jdField_a_of_type_Algc != null))
    {
      Object localObject = this.jdField_a_of_type_Algc.getItem(0);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        localObject = this.app.getMessageFacade().getLastMessage(((RecentBaseData)localObject).getRecentUserUin(), ((RecentBaseData)localObject).getRecentUserType());
        if (localObject != null)
        {
          awtz.a().a(this.app, ((QQMessageFacade.Message)localObject).time);
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
    this.jdField_a_of_type_Bgqj.a();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (!this.jdField_a_of_type_Boolean) {
      bdls.e(this, this.app.getCurrentAccountUin());
    }
    for (;;)
    {
      return super.onBackEvent();
      c();
      if (this.jdField_b_of_type_Boolean) {
        bdls.c(this, this.app.getCurrentAccountUin());
      } else {
        bdls.d(this, this.app.getCurrentAccountUin());
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
        runOnUiThread(new TroopAssistantActivity.20(this));
      }
      if ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == -2002)) {
        return;
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity
 * JD-Core Version:    0.7.0.1
 */