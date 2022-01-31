package com.tencent.biz.pubaccount.Advertisement.activity;

import android.app.Dialog;
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
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout;
import com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout.OnDraggingListener;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView.OnInterceptTouchListener;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView.OnPagerChangedListener;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.IDownloadObserver;
import com.tencent.open.appcommon.now.download.local.DownloadStateInfo;
import com.tencent.open.appcommon.now.download.local.DownloadTaskInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
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
import ktb;
import ktc;
import ktd;
import kte;
import ktf;
import ktg;
import ktk;
import ktl;
import ktm;
import ktn;
import kto;
import ktp;
import mqq.os.MqqHandler;

public class PublicAccountAdvertisementActivity
  extends QQBrowserActivity
  implements DownloadNativeApi.IDownloadObserver
{
  public static long a;
  public static HashMap a;
  public static boolean a;
  private int jdField_a_of_type_Int;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private AdvertisementItem jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
  private VideoCoverFragment jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment;
  private WebpageFragment jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentWebpageFragment;
  private AdControlView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView;
  private DragFrameLayout.OnDraggingListener jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener;
  private DragFrameLayout jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout;
  private VerticalPagerView.OnInterceptTouchListener jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnInterceptTouchListener;
  private VerticalPagerView.OnPagerChangedListener jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener;
  private VerticalPagerView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  public long b;
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
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean;
  private boolean h = true;
  private boolean i;
  private boolean j;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public PublicAccountAdvertisementActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new ktd(this, Looper.getMainLooper());
  }
  
  private void a(VideoDownloadItem paramVideoDownloadItem)
  {
    if (paramVideoDownloadItem == null) {
      return;
    }
    if ((paramVideoDownloadItem.jdField_a_of_type_Boolean) && (paramVideoDownloadItem.jdField_b_of_type_Int == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = paramVideoDownloadItem.f;
      this.jdField_b_of_type_JavaLangString = paramVideoDownloadItem.g;
      this.jdField_d_of_type_JavaLangString = paramVideoDownloadItem.h;
      this.jdField_c_of_type_JavaLangString = paramVideoDownloadItem.l;
      this.jdField_e_of_type_JavaLangString = paramVideoDownloadItem.jdField_c_of_type_JavaLangString;
      this.i = paramVideoDownloadItem.jdField_b_of_type_Boolean;
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
        this.jdField_g_of_type_Boolean = false;
      }
      if (!this.jdField_g_of_type_Boolean) {
        break;
      }
      DownloadNativeApi.a().a(this);
      paramVideoDownloadItem = new DownloadTaskInfo(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true);
      paramVideoDownloadItem.jdField_a_of_type_Boolean = false;
      if ((a()) || (b()) || (!this.jdField_g_of_type_Boolean) || (!this.i) || (!NetworkUtil.a(this))) {
        break;
      }
      int k = DownloadNativeApi.a().a(this, paramVideoDownloadItem);
      this.h = true;
      if ((QLog.isColorLevel()) && (200 == k)) {
        QLog.i("PublicAccountAdvertisementActivity", 2, "app download silent start success");
      }
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F6D", "0X8008F6D", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "1", "", "");
      return;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView = ((AdControlView)super.findViewById(2131365576));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout = ((DragFrameLayout)super.findViewById(2131365572));
    FrameLayout localFrameLayout = (FrameLayout)super.findViewById(2131365573);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.setDraggableView(localFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.setOnDraggingListener(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.jdField_a_of_type_Int = (this.jdField_a_of_type_Int / 4);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.bringToFront();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.d().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.c().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.setFitsSystemWindows(true);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener = new ktb(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new ktf(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ktg(this);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener = new ktk(this);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnInterceptTouchListener = new ktl(this);
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download start get download progress");
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new DownloadTaskInfo(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
    DownloadNativeApi.a().a(localLinkedList);
  }
  
  private void f()
  {
    if (a())
    {
      i();
      return;
    }
    if (b())
    {
      h();
      return;
    }
    if (NetworkState.isNetSupport())
    {
      if (NetworkState.isWifiConn())
      {
        g();
        return;
      }
      a();
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = 202;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void g()
  {
    if (!this.jdField_g_of_type_Boolean) {}
    int k;
    do
    {
      return;
      localObject = new DownloadTaskInfo(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, false);
      this.h = false;
      ((DownloadTaskInfo)localObject).jdField_a_of_type_Boolean = false;
      ((DownloadTaskInfo)localObject).jdField_b_of_type_Boolean = false;
      k = DownloadNativeApi.a().a(this, (DownloadTaskInfo)localObject);
      switch (k)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.i("PublicAccountAdvertisementActivity", 2, "app download start failed " + k);
    return;
    ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F6E", "0X8008F6E", 0, 0, this.jdField_e_of_type_JavaLangString, "", "", "");
    Object localObject = new Message();
    ((Message)localObject).what = 4;
    ((Message)localObject).arg1 = 1;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "app download start succeeded");
    }
    ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F6D", "0X8008F6D", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "2", "", "");
  }
  
  private void h()
  {
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F72", "0X8008F72", 0, 0, this.jdField_e_of_type_JavaLangString, String.valueOf(System.currentTimeMillis() / 1000L), "", "");
    DownloadNativeApi.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
  }
  
  private void i()
  {
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    if (a())
    {
      localObject = getPackageManager().getLaunchIntentForPackage(this.jdField_b_of_type_JavaLangString);
      if (localObject != null) {
        startActivity((Intent)localObject);
      }
      PublicAccountReportUtils.a(null, "", "0X8007F7B", "0X8007F7B", 0, 0, this.jdField_e_of_type_JavaLangString, "", "", "", false);
      return;
    }
    Object localObject = new Message();
    ((Message)localObject).what = 3;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F79", "0X8008F79", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_Long / 1000L), ((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_f_of_type_Int)).jdField_b_of_type_JavaLangString, "");
      return;
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F79", "0X8008F79", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, ((Integer)localEntry.getValue()).intValue() + "", (String)localEntry.getKey(), "");
    }
    jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  private void k()
  {
    QQAppInterface localQQAppInterface = this.app;
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString;
    if (VideoCoverFragment.jdField_c_of_type_Boolean) {}
    for (int k = 1;; k = 2)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", str1, "0X8008F61", "0X8008F61", 0, 0, str2, String.valueOf(k), ((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_f_of_type_Int)).jdField_b_of_type_JavaLangString, "");
      ReportController.b(this.app, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F66", "0X8008F66", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "", ((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_f_of_type_Int)).jdField_b_of_type_JavaLangString, PublicAccountAdUtil.a());
      return;
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Long += this.jdField_g_of_type_Long - jdField_a_of_type_Long;
    }
    int k;
    String str;
    do
    {
      return;
      k = (int)(((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_f_of_type_Int)).a.a() / 1000L);
      str = ((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_f_of_type_Int)).jdField_b_of_type_JavaLangString;
    } while (k <= 0);
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(str);
    if (localInteger == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountAdvertisementActivity", 2, "current time =" + k);
      }
      jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(k));
      return;
    }
    jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(localInteger.intValue() + k));
  }
  
  private void m()
  {
    int k = this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode();
    if (jdField_a_of_type_Boolean) {}
    while ((k != 0) && (k != 1)) {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new kte(this), 300L);
  }
  
  void a()
  {
    Dialog localDialog = new Dialog(this, 2131624516);
    localDialog.setContentView(2130970302);
    ((TextView)localDialog.findViewById(2131369987)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131369988);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131369989);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131369990);
    localTextView1.setText(2131438959);
    localTextView1.setGravity(3);
    localTextView2.setText(2131438960);
    localTextView3.setText(2131438961);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new ktn(this, localDialog));
    localTextView3.setOnClickListener(new kto(this, localDialog));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt)
  {
    QQToast.a(this, 1, paramInt, 0).b(getTitleBarHeight());
  }
  
  public void a(DownloadStateInfo paramDownloadStateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download state change " + paramDownloadStateInfo.jdField_b_of_type_JavaLangString + " " + paramDownloadStateInfo.jdField_a_of_type_Int);
    }
    if ((this.jdField_g_of_type_Boolean) && (paramDownloadStateInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (paramDownloadStateInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) {
      switch (paramDownloadStateInfo.jdField_a_of_type_Int)
      {
      }
    }
    do
    {
      return;
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F70", "0X8008F70", 0, 0, this.jdField_e_of_type_JavaLangString, String.valueOf(System.currentTimeMillis() / 1000L), "", "");
    } while (this.h);
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.arg1 = paramDownloadStateInfo.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString)
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
    return DownloadNativeApi.a().a(this.jdField_b_of_type_JavaLangString);
  }
  
  public void b(DownloadStateInfo paramDownloadStateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "app download error " + paramDownloadStateInfo.jdField_b_of_type_JavaLangString + " " + paramDownloadStateInfo.c);
    }
    if ((this.jdField_g_of_type_Boolean) && (paramDownloadStateInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (paramDownloadStateInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && (!this.h))
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.arg1 = paramDownloadStateInfo.c;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public void b(String paramString)
  {
    Dialog localDialog = new Dialog(this, 2131624516);
    localDialog.setContentView(2130970302);
    ((TextView)localDialog.findViewById(2131369987)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131369988);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131369989);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131369990);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131438967);
    localTextView3.setText(2131438968);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new ktp(this, localDialog));
    localTextView3.setOnClickListener(new ktc(this, localDialog));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean b()
  {
    switch (DownloadNativeApi.a().a(new DownloadTaskInfo(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString)))
    {
    default: 
      this.jdField_g_of_type_Boolean = false;
    case 0: 
      return false;
    }
    return true;
  }
  
  public void c(DownloadStateInfo paramDownloadStateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download progress " + paramDownloadStateInfo.jdField_b_of_type_JavaLangString + " " + paramDownloadStateInfo.jdField_b_of_type_Int);
    }
    if ((this.jdField_g_of_type_Boolean) && (paramDownloadStateInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (paramDownloadStateInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && (!this.h))
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.arg1 = paramDownloadStateInfo.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public void d(DownloadStateInfo paramDownloadStateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download get progress" + paramDownloadStateInfo.jdField_b_of_type_JavaLangString + " " + paramDownloadStateInfo.jdField_b_of_type_Int);
    }
    if ((this.jdField_g_of_type_Boolean) && (paramDownloadStateInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (paramDownloadStateInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && ((!this.h) || (paramDownloadStateInfo.jdField_b_of_type_Int == 0)))
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.arg1 = paramDownloadStateInfo.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public void doOnBackPressed()
  {
    finish();
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
    this.jdField_e_of_type_Int = localDisplayMetrics.heightPixels;
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.a(paramBundle);
    setContentView(2130969200);
    overridePendingTransition(2131034221, 0);
    getWindow().addFlags(1024);
    getWindow().addFlags(128);
    c();
    b();
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment = new VideoCoverFragment();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem, this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidMediaAudioManager, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView);
    paramBundle = super.getSupportFragmentManager().beginTransaction();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView = ((VerticalPagerView)findViewById(2131365574));
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.setOnPagerChangedListener(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.setOnInterceptTouchListener(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnInterceptTouchListener);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365597);
      paramBundle.add(2131365575, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment);
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
      paramBundle.add(2131365573, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment);
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    DownloadNativeApi.a().b(this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.b();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener = null;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = null;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener = null;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnInterceptTouchListener = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.a();
    }
    jdField_a_of_type_Boolean = false;
    ReportController.b(this.app, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F69", "0X8008F69", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_c_of_type_Long / 1000L), "", "");
    j();
    jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.c();
    super.doOnDestroy();
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
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
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130839661);
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
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130839660);
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
            m();
            l();
            k();
          }
        }
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_g_of_type_Boolean)
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.arg1 = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      e();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 600L);
      }
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      AdvertisementStatistics.a().a();
    }
  }
  
  public void finish()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.a(this.jdField_a_of_type_Int / 2, this.jdField_e_of_type_Int / 2, 0, 0, 300, new ktm(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = AdvertisementItem.a(localIntent.getStringExtra("arg_ad_json"));
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem != null)
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem);
        long l = localIntent.getLongExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
        boolean bool = localIntent.getBooleanExtra("is_first_open_imax_ad", true);
        AdvertisementStatistics.a().a(this.jdField_e_of_type_JavaLangString, l, bool);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem == null)
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
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = null;
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          break;
        }
        finish();
      } while (!QLog.isColorLevel());
      QLog.d("PublicAccountAdvertisementActivity", 2, "onCreate no video");
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_Boolean = false;
        super.b(paramBundle);
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      localIntent.putExtra("isFullScreen", true);
      localIntent.putExtra("isTransparentTitle", true);
      localIntent.putExtra("url", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_b_of_type_JavaLangString);
      super.onCreate(paramBundle);
    }
  }
  
  public void setContentView(int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(paramInt, null, false);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      localView.setFitsSystemWindows(true);
    }
    super.setContentView(localView);
    getWindow().setFeatureInt(7, 2130968865);
    try
    {
      ((View)findViewById(2131364092).getParent()).setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity
 * JD-Core Version:    0.7.0.1
 */