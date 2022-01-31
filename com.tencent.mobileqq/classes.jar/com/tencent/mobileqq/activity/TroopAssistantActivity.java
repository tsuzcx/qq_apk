package com.tencent.mobileqq.activity;

import acfu;
import acfv;
import acfw;
import acfx;
import acfy;
import acfz;
import acga;
import acgb;
import acgc;
import acgd;
import acge;
import acgf;
import acgg;
import acgh;
import acgi;
import acgj;
import acgk;
import actj;
import ahmo;
import ahmv;
import ahpd;
import ahpo;
import aiqf;
import ajsx;
import ajsy;
import ajxj;
import ajxl;
import ajya;
import akat;
import akil;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
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
import asfd;
import aukq;
import axqy;
import axrc;
import axrw;
import ayph;
import aypl;
import ayqr;
import ayvx;
import aywb;
import baqr;
import bbbr;
import bbjl;
import bcqi;
import bduf;
import bfpc;
import bfpp;
import bfut;
import bfuw;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupDynamicEntrancePicture;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import lno;
import mqq.os.MqqHandler;
import mxf;
import naz;
import sxm;
import tcw;
import tcz;
import tdl;
import vei;
import vwm;
import vwn;

public class TroopAssistantActivity
  extends IphoneTitleBarActivity
  implements ahmo, ahpo, GestureDetector.OnGestureListener, View.OnTouchListener, Observer
{
  public static final String a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  public long a;
  public ahmv a;
  public aiqf a;
  protected ajsy a;
  protected ajxj a;
  protected akat a;
  protected akil a;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected View a;
  protected Button a;
  public ImageView a;
  protected TextView a;
  protected aywb a;
  protected baqr a;
  public bbjl a;
  public bcqi a;
  protected bfut a;
  protected DragFrameLayout a;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new acga(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  Comparator<RecentBaseData> jdField_a_of_type_JavaUtilComparator = new acgd(this);
  public List<Long> a;
  private lno jdField_a_of_type_Lno = new acgi(this);
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
    jdField_a_of_type_JavaLangString = sxm.a("StoryGroupSvc.get_dynamic_entrance_info");
  }
  
  public TroopAssistantActivity()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Aywb = new acgj(this);
    this.jdField_a_of_type_Akat = new acgk(this);
    this.jdField_a_of_type_Ajsy = new acfu(this);
    this.jdField_a_of_type_Ajxj = new acfv(this);
    this.jdField_a_of_type_Akil = new acfw(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new acfz(this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Resources localResources = getResources();
    bfpc localbfpc = (bfpc)bfpp.a(this, null);
    localbfpc.a(localResources.getString(2131720083, new Object[] { paramString2 }));
    localbfpc.a(localResources.getString(2131697899), false);
    localbfpc.a(localResources.getString(2131697904), false);
    localbfpc.a(localResources.getString(2131697900), false);
    localbfpc.a(localResources.getString(2131697896), false);
    int j = this.app.b(String.valueOf(paramString1));
    switch (j)
    {
    }
    for (;;)
    {
      localbfpc.c(2131690596);
      localbfpc.a(new acgc(this, j, paramString1, localbfpc));
      localbfpc.show();
      return;
      localbfpc.d(0);
      continue;
      localbfpc.d(1);
      continue;
      localbfpc.d(2);
      continue;
      localbfpc.d(3);
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
        localView = localView.findViewById(2131378655);
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
    if (asfd.a().c(this.app))
    {
      QLog.e("TroopAssistantActivity", 2, "initContentView, initContentViewSettingModal");
      g();
      axqy.b(this.app, "dc00899", "Grp_msg", "", "helper-guide", "exp_guide", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("TroopAssistantActivity", 2, "initContentView, initContentViewNormalModal");
    f();
  }
  
  private void f()
  {
    this.jdField_b_of_type_JavaLangString = "normal";
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377835));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377741);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (!this.g)
    {
      this.jdField_b_of_type_AndroidViewView = View.inflate(this, 2131562527, null);
      ViewCompat.setImportantForAccessibility(this.jdField_b_of_type_AndroidViewView, 2);
      this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131377738);
      this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131377737);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375279));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
      View localView = View.inflate(this, 2131558820, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(localView);
      this.jdField_a_of_type_Ahmv = new ahmv(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this, 1);
      this.jdField_a_of_type_Ahmv.a(4);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahmv);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
      }
      this.jdField_a_of_type_Ahmv.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.g = true;
    }
    h();
  }
  
  private void g()
  {
    this.jdField_b_of_type_JavaLangString = "batch_setting";
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377835));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377741);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int j = ((DisplayMetrics)localObject).heightPixels;
    int k = actj.a(154.0F, getBaseContext().getResources());
    int m = getTitleBarHeight();
    int n = ImmersiveUtils.getStatusBarHeight(getBaseContext());
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377742));
    this.jdField_b_of_type_ComTencentWidgetXListView.setMaxHeight(j - k - m - n);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377736);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131377737);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377738);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375279));
    localObject = (TextView)this.jdField_d_of_type_AndroidViewView;
    ((TextView)localObject).setText(2131720417);
    ((TextView)localObject).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131377739));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131377735));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new acgb(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new acge(this));
    this.jdField_a_of_type_Aiqf = new aiqf(this, this.app, null);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aiqf);
    localObject = asfd.a();
    ((asfd)localObject).a(this.app, new acgf(this, (asfd)localObject));
    h();
  }
  
  private void h()
  {
    Object localObject = (vwn)this.app.getManager(208);
    if ((localObject != null) && (((vwn)localObject).a != null) && (((vwn)localObject).a.jdField_a_of_type_Boolean))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new acgg(this));
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject = new qqstory_group.ReqGetGroupDynamicEntrancePicture();
        ((qqstory_group.ReqGetGroupDynamicEntrancePicture)localObject).version.set(ByteStringMicro.copyFromUtf8("8.3.0"));
        mxf.a(this.app, new acgh(this), ((qqstory_group.ReqGetGroupDynamicEntrancePicture)localObject).toByteArray(), jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Aywb.addFilter(new Class[] { ayph.class, aypl.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class, ayqr.class });
    this.app.a().a(this.jdField_a_of_type_Aywb);
  }
  
  private void k()
  {
    QLog.e("TroopAssistantActivity", 2, "initTitleBar");
    setTitle(2131720433);
    Object localObject = this.rightViewImg;
    int j = 2130839753;
    if (this.e)
    {
      ((TextView)findViewById(2131368472)).setTextColor(getResources().getColorStateList(2131166852));
      j = 2130843094;
    }
    ((ImageView)localObject).setImageResource(j);
    ((ImageView)localObject).setContentDescription(getString(2131720584));
    ((ImageView)localObject).setOnClickListener(new acfx(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368464));
    b();
    if ("batch_setting".equals(this.jdField_b_of_type_JavaLangString)) {
      ((ImageView)localObject).setVisibility(8);
    }
    for (;;)
    {
      localObject = (RelativeLayout)findViewById(2131375329);
      if (!this.e) {
        break;
      }
      ((RelativeLayout)localObject).setBackgroundResource(2130849033);
      return;
      ((ImageView)localObject).setVisibility(0);
    }
    ((RelativeLayout)localObject).setBackgroundResource(2130849032);
  }
  
  private void l()
  {
    this.jdField_d_of_type_Boolean = asfd.a().b();
    Object localObject;
    if (this.jdField_d_of_type_Boolean) {
      localObject = getString(2131720576);
    }
    for (int j = 2130841968;; j = 2130841969)
    {
      String str = getString(2131720585);
      ArrayList localArrayList = new ArrayList();
      bfuw localbfuw = new bfuw();
      localbfuw.jdField_a_of_type_Int = 0;
      localbfuw.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbfuw.c = localbfuw.jdField_a_of_type_JavaLangString;
      localbfuw.b = j;
      localArrayList.add(localbfuw);
      localObject = new bfuw();
      ((bfuw)localObject).jdField_a_of_type_Int = 1;
      ((bfuw)localObject).jdField_a_of_type_JavaLangString = str;
      ((bfuw)localObject).c = ((bfuw)localObject).jdField_a_of_type_JavaLangString;
      ((bfuw)localObject).b = 2130841966;
      localArrayList.add(localObject);
      this.jdField_a_of_type_Bfut = bfut.a(this, localArrayList, new acfy(this));
      localObject = super.getTitleBarView();
      this.jdField_a_of_type_Bfut.showAsDropDown((View)localObject, ((View)localObject).getWidth() - getResources().getDimensionPixelSize(2131298619) - getResources().getDimensionPixelSize(2131298615), getResources().getDimensionPixelSize(2131298616));
      return;
      localObject = getString(2131720577);
    }
  }
  
  protected List<RecentBaseData> a()
  {
    QLog.e("TroopAssistantActivity", 2, "makeRecetBaseData");
    List localList = asfd.a().b(this.app);
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
          QLog.i("Q.recent.cost", 2, "[" + (l - 0L) + ", " + ((RecentTroopAssistantItem)localObject).a() + "," + localObject.getClass().getName() + "]");
          ((RecentTroopAssistantItem)localObject).a();
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
    if (asfd.a().a(this.app) == true) {
      asfd.a().a(this.app.getEntityManagerFactory().createEntityManager(), this.app);
    }
    addObserver(this.jdField_a_of_type_Ajxj);
    addObserver(this.jdField_a_of_type_Akat);
    addObserver(this.jdField_a_of_type_Akil);
    addObserver(this.jdField_a_of_type_Ajsy);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.app.a().addObserver(this);
    this.app.a().addObserver(this.jdField_a_of_type_Lno);
    if (this.jdField_a_of_type_Ahmv != null) {
      this.jdField_a_of_type_Ahmv.a(this.app);
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
    Object localObject = (TroopManager)this.app.getManager(52);
    String str = ((TroopManager)localObject).d(paramRecentBaseData.a());
    if (!TextUtils.isEmpty(str))
    {
      localajsx = (ajsx)this.app.a(22);
      if (paramBoolean)
      {
        paramInt = 0;
        if (localajsx.a(str, paramInt)) {
          break label70;
        }
      }
    }
    label70:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        ajsx localajsx;
        return;
        paramInt = 1;
      }
      localObject = ((TroopManager)localObject).c(paramRecentBaseData.a());
      if (localObject != null) {}
      switch (((TroopInfo)localObject).troopmask)
      {
      default: 
        paramInt = 0;
        localObject = new axrc(this.app).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
        str = paramRecentBaseData.a();
        if (!paramBoolean) {
          break;
        }
      }
      for (paramRecentBaseData = "0";; paramRecentBaseData = "1")
      {
        ((axrc)localObject).a(new String[] { str, String.valueOf(paramInt), paramRecentBaseData }).a();
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
    if (paramRecentBaseData.b() > 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    a(paramRecentBaseData.a(), paramRecentBaseData.a(), paramString);
  }
  
  public void a(View paramView, Object paramObject)
  {
    if (paramView == null) {}
    int j;
    do
    {
      return;
      j = paramView.getId();
      if (j == 2131377741)
      {
        this.jdField_c_of_type_Boolean = false;
        if (this.jdField_a_of_type_Ahmv != null)
        {
          this.jdField_a_of_type_Ahmv.a(4);
          d();
          this.jdField_a_of_type_Ahmv.notifyDataSetChanged();
        }
        paramView = new Intent(this, TroopAssisSettingActivity.class);
        paramView.setFlags(67108864);
        startActivity(paramView);
        if (asfd.a().c()) {
          asfd.a().f(this.app);
        }
        axqy.b(this.app, "P_CliOper", "Grp_msg", "", "help_nav", "Clk_set", 0, 0, "", "", "", "");
        return;
      }
    } while (j != 2131377740);
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ahmv != null)
    {
      this.jdField_a_of_type_Ahmv.a(4);
      d();
      this.jdField_a_of_type_Ahmv.notifyDataSetChanged();
      c();
    }
    asfd.a().f(this.app);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    a(paramRecentBaseData.a());
  }
  
  void a(String paramString)
  {
    asfd.a().b(paramString, this.app);
    c();
    ahpd.b(this.app, paramString, 1);
    this.app.a().c(paramString, 1);
    paramString = this.app.getHandler(Conversation.class);
    if (paramString != null) {
      paramString.sendEmptyMessage(1014);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    asfd.a().a(this.app, paramString, paramInt);
    this.jdField_a_of_type_Bbjl.c.put(paramString, Boolean.valueOf(true));
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
      paramString1 = ((TroopManager)this.app.getManager(52)).b(paramString1);
      if ((paramString1 != null) && (paramString1.troopcode != null)) {
        localIntent.putExtra("troop_uin", paramString1.troopcode);
      }
    }
    for (;;)
    {
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString2);
      startActivity(localIntent);
      this.jdField_a_of_type_Baqr.b();
      return;
      if (paramInt == 0)
      {
        paramString1 = ((ajxl)this.app.getManager(51)).e(paramString1 + "");
        if (paramString1 != null)
        {
          localIntent.putExtra("cSpecialFlag", paramString1.cSpecialFlag);
          if ((naz.a(paramString1.cSpecialFlag)) || (bduf.b(paramString1.cSpecialFlag)))
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
    int j = paramRecentBaseData.a();
    if (j == 1) {
      if (bbbr.a(paramString1, paramString2.getString(ahnw.a[2]))) {
        a(j, paramRecentBaseData, false);
      }
    }
    while ((paramRecentBaseData.a() != 1) || (!bbbr.a(paramString2.getString(ahnw.a[1]), paramString1)))
    {
      do
      {
        return;
      } while (!bbbr.a(paramString1, paramString2.getString(ahnw.a[3])));
      a(j, paramRecentBaseData, true);
      return;
    }
    a(paramRecentBaseData.a(), paramRecentBaseData.b());
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean) {
      axqy.b(this.app, "CliOper", "", "", "0X800419E", "0X800419E", 0, 0, "", "", "", "");
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
      this.mLeftBackIcon.setContentDescription(ajya.a(2131715213));
      this.mLeftBackText.setVisibility(0);
      localObject1 = this.mLeftBackText;
      a((View)localObject1, 0, 0, 0, (int)(30.0F * this.mDensity + 0.5F));
      if (localObject1 == null) {
        break label307;
      }
      localObject2 = this.app.a();
    } while (localObject2 == null);
    ThreadManager.post(new TroopAssistantActivity.15(this, (QQMessageFacade)localObject2, (TextView)localObject1), 8, null, true);
    return;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.leftView.setVisibility(0);
    Object localObject1 = getResources().getColorStateList(2131166851);
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
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = actj.a(28.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (RelativeLayout.LayoutParams)this.leftView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = actj.a(5.0F, getResources());
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
    ThreadManager.excute(new TroopAssistantActivity.18(this), 32, this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_Ahmv != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      if (!this.jdField_a_of_type_Ahmv.b()) {
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
    if ((this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
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
      super.setContentView(2131562525);
      getWindow().setBackgroundDrawable(null);
      setStatusBarBlue();
      this.e = ThemeUtil.isDefaultOrDIYTheme(false);
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this);
      paramBundle = (LinearLayout)findViewById(2131377891);
      paramBundle.setOnTouchListener(this);
      paramBundle.setLongClickable(true);
      e();
      k();
      a();
      j();
      vei.a("grp_help", "exp", 0, 0, new String[] { "", "", "", "" });
      this.jdField_a_of_type_Baqr = new baqr(this.app, null, "Grp_time", "helper", "visit_time");
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
    if (this.jdField_a_of_type_Baqr != null) {
      this.jdField_a_of_type_Baqr.b();
    }
    super.doOnDestroy();
    if (this.app == null) {
      return;
    }
    this.app.a().b(this.jdField_a_of_type_Aywb);
    this.app.a().deleteObserver(this.jdField_a_of_type_Lno);
    removeObserver(this.jdField_a_of_type_Ajxj);
    removeObserver(this.jdField_a_of_type_Akil);
    removeObserver(this.jdField_a_of_type_Akat);
    removeObserver(this.jdField_a_of_type_Ajsy);
    if (this.app.a() != null) {
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    if (this.jdField_a_of_type_Ahmv != null) {
      this.jdField_a_of_type_Ahmv.b();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    this.jdField_a_of_type_Ahmv = null;
    ((tcw)tcz.a(5)).c();
    ((tdl)tcz.a(2)).d();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if ((this.app != null) && (this.jdField_a_of_type_Ahmv != null))
    {
      Object localObject = this.jdField_a_of_type_Ahmv.getItem(0);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        localObject = this.app.a().a(((RecentBaseData)localObject).a(), ((RecentBaseData)localObject).a());
        if (localObject != null)
        {
          asfd.a().a(this.app, ((QQMessageFacade.Message)localObject).time);
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
    this.jdField_a_of_type_Baqr.a();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (!this.jdField_a_of_type_Boolean) {
      axrw.e(this, this.app.getCurrentAccountUin());
    }
    for (;;)
    {
      return super.onBackEvent();
      c();
      if (this.jdField_b_of_type_Boolean) {
        axrw.c(this, this.app.getCurrentAccountUin());
      } else {
        axrw.d(this, this.app.getCurrentAccountUin());
      }
    }
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