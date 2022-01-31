package com.tencent.biz.pubaccount.Advertisement.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import aqiw;
import aqjh;
import autt;
import awmd;
import awqx;
import badq;
import bbmy;
import bcce;
import bcch;
import bcci;
import bccj;
import begr;
import begw;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import mxf;
import mxg;
import mxh;
import mxi;
import mxj;
import mxk;
import mxl;
import mxm;
import mxn;
import mxo;
import mxp;
import mxq;
import mxr;
import mxs;
import mxu;
import mxv;
import mxw;
import mye;
import myn;
import myq;
import myt;
import myu;
import ndn;

public class PublicAccountAdvertisementActivity
  extends QQBrowserActivity
  implements bcch
{
  public static long a;
  public static HashMap<String, Integer> a;
  public static boolean a;
  private int jdField_a_of_type_Int;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  public Handler a;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private aqjh jdField_a_of_type_Aqjh;
  private begr jdField_a_of_type_Begr;
  private begw jdField_a_of_type_Begw;
  private VideoCoverFragment jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment;
  private WebpageFragment jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentWebpageFragment;
  private AdControlView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView;
  private DragFrameLayout jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout;
  private VerticalPagerView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView;
  private String jdField_a_of_type_JavaLangString;
  private mxu jdField_a_of_type_Mxu;
  private myq jdField_a_of_type_Myq;
  private myt jdField_a_of_type_Myt;
  private myu jdField_a_of_type_Myu;
  public long b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private begw jdField_b_of_type_Begw;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean;
  private boolean h = true;
  private boolean i;
  private boolean j;
  private boolean k = true;
  private boolean l;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public PublicAccountAdvertisementActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new mxi(this, Looper.getMainLooper());
  }
  
  public static void a(Context paramContext, mxu parammxu)
  {
    if (parammxu == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("arg_ad_json", parammxu.a());
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    paramContext.startActivity(localIntent);
  }
  
  private void a(mxw parammxw)
  {
    if (parammxw == null) {
      return;
    }
    if ((parammxw.jdField_b_of_type_Boolean) && (parammxw.jdField_d_of_type_Int == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = parammxw.k;
      this.jdField_b_of_type_JavaLangString = parammxw.l;
      this.jdField_d_of_type_JavaLangString = parammxw.i;
      this.jdField_c_of_type_JavaLangString = parammxw.m;
      this.jdField_e_of_type_JavaLangString = parammxw.jdField_c_of_type_JavaLangString;
      this.i = parammxw.jdField_c_of_type_Boolean;
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
        this.jdField_g_of_type_Boolean = false;
      }
      if (!this.jdField_g_of_type_Boolean) {
        break;
      }
      bcce.a().a(this);
      parammxw = new bccj(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true);
      parammxw.jdField_a_of_type_Boolean = false;
      if ((b()) || (c()) || (!this.jdField_g_of_type_Boolean) || (!this.i) || (!badq.a(this))) {
        break;
      }
      int m = bcce.a().a(this, parammxw);
      this.h = true;
      if ((QLog.isColorLevel()) && (200 == m)) {
        QLog.i("PublicAccountAdvertisementActivity", 2, "app download silent start success");
      }
      awqx.a(null, "dc00898", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString, "0X8008F6D", "0X8008F6D", 0, 0, this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_c_of_type_JavaLangString, "1", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_b_of_type_JavaLangString);
      return;
    }
  }
  
  private void b(int paramInt)
  {
    awqx.a(null, "dc00898", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString, "0X80090FB", "0X80090FB", 0, 0, this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_c_of_type_JavaLangString, "", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Begr = begr.d(this);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener == null) {
        this.jdField_b_of_type_AndroidViewView$OnClickListener = new mxl(this);
      }
      this.jdField_a_of_type_Begr.a(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Begr.show();
      return;
      this.jdField_a_of_type_Begr.b(2131627727);
      this.jdField_a_of_type_Begr.c(2131625035);
      if (this.jdField_a_of_type_Begw == null) {
        this.jdField_a_of_type_Begw = new mxj(this);
      }
      this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_Begw);
      continue;
      this.jdField_a_of_type_Begr.b(2131627103);
      this.jdField_a_of_type_Begr.b(2131627727);
      this.jdField_a_of_type_Begr.c(2131625035);
      if (this.jdField_b_of_type_Begw == null) {
        this.jdField_b_of_type_Begw = new mxk(this);
      }
      this.jdField_a_of_type_Begr.a(this.jdField_b_of_type_Begw);
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView = ((AdControlView)super.findViewById(2131296433));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout = ((DragFrameLayout)super.findViewById(2131299813));
    FrameLayout localFrameLayout = (FrameLayout)super.findViewById(2131299825);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.setDraggableView(localFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.setOnDraggingListener(this.jdField_a_of_type_Myq);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.jdField_a_of_type_Int = (this.jdField_a_of_type_Int / 4);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.bringToFront();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.e().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.c().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.d().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.setFitsSystemWindows(true);
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_Myq = new mxf(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new mxm(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new mxn(this);
    if (a())
    {
      this.jdField_a_of_type_Myu = new mxo(this);
      this.jdField_a_of_type_Myt = new mxp(this);
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download start get download progress");
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new bccj(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
    bcce.a().a(localLinkedList);
  }
  
  private void l()
  {
    if (b())
    {
      o();
      return;
    }
    if (c())
    {
      n();
      return;
    }
    if (NetworkState.isNetSupport())
    {
      if (NetworkState.isWifiConn())
      {
        m();
        return;
      }
      d();
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = 202;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void m()
  {
    if (!this.jdField_g_of_type_Boolean) {}
    int m;
    do
    {
      return;
      localObject = new bccj(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, false);
      this.h = false;
      ((bccj)localObject).jdField_a_of_type_Boolean = false;
      ((bccj)localObject).jdField_b_of_type_Boolean = false;
      m = bcce.a().a(this, (bccj)localObject);
      switch (m)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.i("PublicAccountAdvertisementActivity", 2, "app download start failed " + m);
    return;
    awqx.a(null, "dc00898", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString, "0X8008F6E", "0X8008F6E", 0, 0, this.jdField_e_of_type_JavaLangString, "", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_b_of_type_JavaLangString);
    Object localObject = new Message();
    ((Message)localObject).what = 4;
    ((Message)localObject).arg1 = 1;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "app download start succeeded");
    }
    awqx.a(null, "dc00898", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString, "0X8008F6D", "0X8008F6D", 0, 0, this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_c_of_type_JavaLangString, "2", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_b_of_type_JavaLangString);
  }
  
  private void n()
  {
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    awqx.a(null, "dc00898", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString, "0X8008F72", "0X8008F72", 0, 0, this.jdField_e_of_type_JavaLangString, String.valueOf(System.currentTimeMillis() / 1000L), "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_b_of_type_JavaLangString);
    bcce.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
  }
  
  private void o()
  {
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    if (b())
    {
      localObject = getPackageManager().getLaunchIntentForPackage(this.jdField_b_of_type_JavaLangString);
      if (localObject != null) {
        startActivity((Intent)localObject);
      }
      ndn.a(null, "", "0X8007F7B", "0X8007F7B", 0, 0, this.jdField_e_of_type_JavaLangString, "", "", "", false);
      return;
    }
    Object localObject = new Message();
    ((Message)localObject).what = 3;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Mxu.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      awqx.a(null, "dc00898", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString, "0X8008F79", "0X8008F79", 0, 0, this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_Long / 1000L), ((mxv)this.jdField_a_of_type_Mxu.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_f_of_type_Int)).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_b_of_type_JavaLangString);
      return;
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      awqx.a(null, "dc00898", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString, "0X8008F79", "0X8008F79", 0, 0, this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_c_of_type_JavaLangString, ((Integer)localEntry.getValue()).intValue() + "", (String)localEntry.getKey(), this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_b_of_type_JavaLangString);
    }
    jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  private void q()
  {
    QQAppInterface localQQAppInterface = this.app;
    String str1 = this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_c_of_type_JavaLangString;
    if (VideoCoverFragment.jdField_c_of_type_Boolean) {}
    for (int m = 1;; m = 2)
    {
      awqx.a(localQQAppInterface, "dc00898", "", str1, "0X8008F61", "0X8008F61", 0, 0, str2, String.valueOf(m), ((mxv)this.jdField_a_of_type_Mxu.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_f_of_type_Int)).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_b_of_type_JavaLangString);
      awqx.a(this.app, "dc00898", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString, "0X8008F66", "0X8008F66", 0, 0, this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_c_of_type_JavaLangString, "", ((mxv)this.jdField_a_of_type_Mxu.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_f_of_type_Int)).jdField_b_of_type_JavaLangString, myn.a() + "(" + this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_b_of_type_JavaLangString + ")");
      return;
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Mxu.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Long += this.jdField_g_of_type_Long - jdField_a_of_type_Long;
    }
    int m;
    String str;
    do
    {
      return;
      m = (int)(((mxv)this.jdField_a_of_type_Mxu.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_f_of_type_Int)).a.a() / 1000L);
      str = ((mxv)this.jdField_a_of_type_Mxu.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_f_of_type_Int)).jdField_b_of_type_JavaLangString;
    } while (m <= 0);
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(str);
    if (localInteger == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountAdvertisementActivity", 2, "current time =" + m);
      }
      jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(m));
      return;
    }
    jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(localInteger.intValue() + m));
  }
  
  private void s()
  {
    int m = this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode();
    if (jdField_a_of_type_Boolean) {}
    while ((m != 0) && (m != 1)) {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountAdvertisementActivity.13(this), 300L);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Aqjh == null) {
      this.jdField_a_of_type_Aqjh = new aqjh(this, this.jdField_a_of_type_Mxu);
    }
    this.jdField_a_of_type_Aqjh.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PublicAccountAdvertisementActivity.6(this));
  }
  
  public void a(int paramInt)
  {
    bbmy.a(this, 1, paramInt, 0).b(getTitleBarHeight());
  }
  
  public void a(bcci parambcci)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download state change " + parambcci.jdField_b_of_type_JavaLangString + " " + parambcci.jdField_a_of_type_Int);
    }
    if ((this.jdField_g_of_type_Boolean) && (parambcci.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (parambcci.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) {
      switch (parambcci.jdField_a_of_type_Int)
      {
      }
    }
    do
    {
      return;
      awqx.a(null, "dc00898", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString, "0X8008F70", "0X8008F70", 0, 0, this.jdField_e_of_type_JavaLangString, String.valueOf(System.currentTimeMillis() / 1000L), "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_b_of_type_JavaLangString);
    } while (this.h);
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.arg1 = parambcci.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    startActivity(localIntent);
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_d_of_type_Boolean);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw;
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountAdvertisementActivity", 2, "videoDownloadItem jumpType = " + ((mxw)localObject).jdField_d_of_type_Int);
      }
      if (((mxw)localObject).jdField_d_of_type_Int == 1) {
        if ((((mxw)localObject).j != null) && (!TextUtils.isEmpty(((mxw)localObject).j))) {
          a(((mxw)localObject).j);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          return;
          l();
          return;
          if (((mxw)localObject).jdField_d_of_type_Int != 2) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountAdvertisementActivity", 2, "videoDownloadItem jumpUrl = " + ((mxw)localObject).jdField_d_of_type_Int);
          }
        } while ((((mxw)localObject).n == null) || (TextUtils.isEmpty(((mxw)localObject).n)));
        a(((mxw)localObject).n);
        awqx.a(null, "dc00898", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString, "0X8008F74", "0X8008F74", 0, 0, this.jdField_e_of_type_JavaLangString, "", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_b_of_type_JavaLangString);
        return;
        localObject = BaseApplicationImpl.getApplication().getRuntime();
      } while (!(localObject instanceof ToolAppRuntime));
      aqiw.a().a(this.jdField_a_of_type_Mxu, this, (AppInterface)((ToolAppRuntime)localObject).onGetSubRuntime("imax"));
      return;
    }
    QLog.d("PublicAccountAdvertisementActivity", 2, "videoDownloadItem is null");
  }
  
  public void b(bcci parambcci)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "app download error " + parambcci.jdField_b_of_type_JavaLangString + " " + parambcci.c);
    }
    if ((this.jdField_g_of_type_Boolean) && (parambcci.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (parambcci.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && (!this.h))
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.arg1 = parambcci.c;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public void b(String paramString)
  {
    Dialog localDialog = new Dialog(this, 2131690181);
    localDialog.setContentView(2131495138);
    ((TextView)localDialog.findViewById(2131299617)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131299606);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131299604);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131299610);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131624075);
    localTextView3.setText(2131624079);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new mxg(this, localDialog));
    localTextView3.setOnClickListener(new mxh(this, localDialog));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean b()
  {
    return bcce.a().a(this.jdField_b_of_type_JavaLangString);
  }
  
  public void c()
  {
    f(this);
  }
  
  public void c(bcci parambcci)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download progress " + parambcci.jdField_b_of_type_JavaLangString + " " + parambcci.jdField_b_of_type_Int);
    }
    if ((this.jdField_g_of_type_Boolean) && (parambcci.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (parambcci.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && (!this.h))
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.arg1 = parambcci.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public boolean c()
  {
    switch (bcce.a().a(new bccj(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString)))
    {
    default: 
      this.jdField_g_of_type_Boolean = false;
    case 0: 
      return false;
    }
    return true;
  }
  
  void d()
  {
    Dialog localDialog = new Dialog(this, 2131690181);
    localDialog.setContentView(2131495138);
    ((TextView)localDialog.findViewById(2131299617)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131299606);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131299604);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131299610);
    localTextView1.setText(2131624076);
    localTextView1.setGravity(3);
    localTextView2.setText(2131624077);
    localTextView3.setText(2131624078);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new mxr(this, localDialog));
    localTextView3.setOnClickListener(new mxs(this, localDialog));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void d(bcci parambcci)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download get progress" + parambcci.jdField_b_of_type_JavaLangString + " " + parambcci.jdField_b_of_type_Int);
    }
    if ((this.jdField_g_of_type_Boolean) && (parambcci.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (parambcci.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && ((!this.h) || (parambcci.jdField_b_of_type_Int == 0)))
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.arg1 = parambcci.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public void doOnBackPressed()
  {
    finish();
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
    this.jdField_e_of_type_Int = localDisplayMetrics.heightPixels;
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.a(paramBundle);
    setContentView(2131493843);
    overridePendingTransition(2130772115, 0);
    getWindow().addFlags(1024);
    getWindow().addFlags(128);
    j();
    i();
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment = new VideoCoverFragment();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.a(this.jdField_a_of_type_Mxu, this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidMediaAudioManager, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView, this.k);
    paramBundle = super.getSupportFragmentManager().beginTransaction();
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView = ((VerticalPagerView)findViewById(2131313047));
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.setOnPagerChangedListener(this.jdField_a_of_type_Myu);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.setOnInterceptTouchListener(this.jdField_a_of_type_Myt);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131304131);
      paramBundle.add(2131313063, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment);
    }
    for (;;)
    {
      paramBundle.commit();
      paramBundle = Build.MANUFACTURER + "_" + Build.MODEL;
      if ((Build.VERSION.SDK_INT > 10) && (!jdField_a_of_type_JavaUtilHashSet.contains(paramBundle))) {
        getWindow().addFlags(16777216);
      }
      getWindow().setFormat(-3);
      return true;
      paramBundle.add(2131299825, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment);
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    bcce.a().b(this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.b();
    this.jdField_a_of_type_Myq = null;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = null;
    this.jdField_a_of_type_Myu = null;
    this.jdField_a_of_type_Myt = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.a();
    }
    jdField_a_of_type_Boolean = false;
    awqx.a(this.app, "dc00898", "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString, "0X8008F69", "0X8008F69", 0, 0, this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_c_of_type_Long / 1000L), "", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_b_of_type_JavaLangString);
    p();
    jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.c();
    if (this.jdField_a_of_type_Aqjh != null)
    {
      this.jdField_a_of_type_Aqjh.b();
      this.jdField_a_of_type_Aqjh = null;
    }
    super.doOnDestroy();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b();
      jdField_a_of_type_Boolean = true;
      if (!this.j)
      {
        this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.jdField_a_of_type_Int, 0);
        this.j = true;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841081);
      VideoCoverFragment.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.a();
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b();
      jdField_a_of_type_Boolean = true;
      if (!this.j)
      {
        this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.jdField_a_of_type_Int, 0);
        this.j = true;
      }
      if (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3) <= 1)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841080);
        VideoCoverFragment.jdField_c_of_type_Boolean = true;
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView != null) {
          if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.c == 1)
          {
            this.jdField_f_of_type_Long = System.currentTimeMillis();
            this.jdField_c_of_type_Long += this.jdField_f_of_type_Long - this.jdField_e_of_type_Long;
          }
          else
          {
            s();
            r();
            q();
          }
        }
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "doOnNewIntent");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_g_of_type_Boolean)
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.arg1 = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      k();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      mye.a().a();
    }
  }
  
  public void finish()
  {
    jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.a(this.jdField_a_of_type_Int / 2, this.jdField_e_of_type_Int / 2, 0, 0, 300, new mxq(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    int m;
    try
    {
      this.jdField_a_of_type_Mxu = mxu.a(localIntent.getStringExtra("arg_ad_json"));
      if (this.jdField_a_of_type_Mxu != null)
      {
        a(this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw);
        long l1 = localIntent.getLongExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
        bool1 = localIntent.getBooleanExtra("is_first_open_imax_ad", true);
        mye.a().a(this.jdField_e_of_type_JavaLangString, l1, bool1);
      }
      if (this.jdField_a_of_type_Mxu == null)
      {
        finish();
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountAdvertisementActivity", 2, "onCreate object null");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localException.printStackTrace();
          this.jdField_a_of_type_Mxu = null;
        }
        if ((this.jdField_a_of_type_Mxu.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Mxu.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          break;
        }
        finish();
      } while (!QLog.isColorLevel());
      QLog.d("PublicAccountAdvertisementActivity", 2, "onCreate no video");
      return;
      m = this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.jdField_d_of_type_Int;
      if (m <= 3) {
        break label212;
      }
    }
    boolean bool1 = autt.a();
    boolean bool2 = awmd.g(this.app);
    if (m == 5) {
      if ((bool1) && (bool2))
      {
        bool1 = true;
        this.k = bool1;
        label212:
        if (!this.k) {
          break label371;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.n)) {
          break label300;
        }
        this.jdField_b_of_type_Boolean = true;
        localIntent.putExtra("isFullScreen", true);
        localIntent.putExtra("isTransparentTitle", true);
        localIntent.putExtra("url", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.n);
      }
    }
    for (;;)
    {
      super.b(paramBundle);
      return;
      bool1 = false;
      break;
      this.k = bool1;
      break label212;
      label300:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.j))
      {
        this.jdField_b_of_type_Boolean = true;
        localIntent.putExtra("isFullScreen", true);
        localIntent.putExtra("isTransparentTitle", true);
        localIntent.putExtra("url", this.jdField_a_of_type_Mxu.jdField_a_of_type_Mxw.j);
      }
      else
      {
        this.jdField_b_of_type_Boolean = false;
        continue;
        label371:
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void setContentView(int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(paramInt, null, false);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      localView.setFitsSystemWindows(true);
    }
    super.setContentView(localView);
    getWindow().setFeatureInt(7, 2131493363);
    try
    {
      ((View)findViewById(2131300712).getParent()).setVisibility(8);
      label65:
      super.setContentView(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label65;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity
 * JD-Core Version:    0.7.0.1
 */