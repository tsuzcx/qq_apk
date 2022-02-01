package com.tencent.biz.pubaccount.Advertisement.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.imaxad.ImaxAdPresenter;
import com.tencent.mobileqq.imaxad.ImaxShareActionSheet;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.IDownloadObserver;
import com.tencent.open.appcommon.now.download.local.DownloadStateInfo;
import com.tencent.open.appcommon.now.download.local.DownloadTaskInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
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
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class PublicAccountAdvertisementActivity
  extends QQBrowserActivity
  implements DownloadNativeApi.IDownloadObserver
{
  public static long a = 0L;
  public static HashMap<String, Integer> a;
  public static boolean a = false;
  private int jdField_a_of_type_Int;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  protected Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
  private AdvertisementItem jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
  private VideoCoverFragment jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment;
  private WebpageFragment jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentWebpageFragment;
  private AdControlView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView;
  private DragFrameLayout.OnDraggingListener jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener;
  private DragFrameLayout jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout;
  private VerticalPagerView.OnInterceptTouchListener jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnInterceptTouchListener;
  private VerticalPagerView.OnPagerChangedListener jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener;
  private VerticalPagerView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView;
  private ImaxShareActionSheet jdField_a_of_type_ComTencentMobileqqImaxadImaxShareActionSheet;
  private ActionSheet.OnButtonClickListener jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  public long b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private ActionSheet.OnButtonClickListener jdField_b_of_type_ComTencentWidgetActionSheet$OnButtonClickListener;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean = false;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h = true;
  private boolean i = false;
  private boolean j = false;
  private boolean k = true;
  private boolean l = false;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public PublicAccountAdvertisementActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new PublicAccountAdvertisementActivity.12(this, Looper.getMainLooper());
  }
  
  public static void a(Context paramContext, AdvertisementItem paramAdvertisementItem)
  {
    if (paramAdvertisementItem == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("arg_ad_json", paramAdvertisementItem.a());
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    paramContext.startActivity(localIntent);
  }
  
  private void a(VideoDownloadItem paramVideoDownloadItem)
  {
    if (paramVideoDownloadItem == null) {
      return;
    }
    boolean bool;
    if ((paramVideoDownloadItem.jdField_b_of_type_Boolean) && (paramVideoDownloadItem.jdField_d_of_type_Int == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_g_of_type_Boolean = bool;
    this.jdField_a_of_type_JavaLangString = paramVideoDownloadItem.k;
    this.jdField_b_of_type_JavaLangString = paramVideoDownloadItem.l;
    this.jdField_d_of_type_JavaLangString = paramVideoDownloadItem.i;
    this.jdField_c_of_type_JavaLangString = paramVideoDownloadItem.m;
    this.jdField_e_of_type_JavaLangString = paramVideoDownloadItem.jdField_c_of_type_JavaLangString;
    this.i = paramVideoDownloadItem.jdField_c_of_type_Boolean;
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
      this.jdField_g_of_type_Boolean = false;
    }
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    DownloadNativeApi.a().a(this);
    paramVideoDownloadItem = new DownloadTaskInfo(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true);
    paramVideoDownloadItem.jdField_a_of_type_Boolean = false;
    if (b()) {
      return;
    }
    if (c()) {
      return;
    }
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    if ((this.i) && (NetworkUtil.isWifiEnabled(this)))
    {
      int m = DownloadNativeApi.a().a(this, paramVideoDownloadItem);
      this.h = true;
      if ((QLog.isColorLevel()) && (200 == m)) {
        QLog.i("PublicAccountAdvertisementActivity", 2, "app download silent start success");
      }
      ReportController.a(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F6D", "0X8008F6D", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "1", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void b(int paramInt)
  {
    ReportController.a(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X80090FB", "0X80090FB", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createFullScreenMenuSheet(this);
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131692635);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131693241);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
        if (this.jdField_b_of_type_ComTencentWidgetActionSheet$OnButtonClickListener == null) {
          this.jdField_b_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new PublicAccountAdvertisementActivity.15(this);
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this.jdField_b_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131693241);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener == null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new PublicAccountAdvertisementActivity.14(this);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
    }
    if (this.jdField_b_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_b_of_type_AndroidViewView$OnClickListener = new PublicAccountAdvertisementActivity.16(this);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnBottomCancelListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView = ((AdControlView)super.findViewById(2131362090));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout = ((DragFrameLayout)super.findViewById(2131365880));
    FrameLayout localFrameLayout = (FrameLayout)super.findViewById(2131365893);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.setDraggableView(localFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.setOnDraggingListener(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener);
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
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener = new PublicAccountAdvertisementActivity.1(this);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = new PublicAccountAdvertisementActivity.2(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new PublicAccountAdvertisementActivity.3(this);
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener = new PublicAccountAdvertisementActivity.4(this);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnInterceptTouchListener = new PublicAccountAdvertisementActivity.5(this);
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download start get download progress");
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new DownloadTaskInfo(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
    DownloadNativeApi.a().a(localLinkedList);
  }
  
  private void h()
  {
    if (b())
    {
      k();
      return;
    }
    if (c())
    {
      j();
      return;
    }
    if (NetworkState.isNetSupport())
    {
      if (NetworkState.isWifiConn())
      {
        i();
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
  
  private void i()
  {
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    Object localObject = new DownloadTaskInfo(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, false);
    this.h = false;
    ((DownloadTaskInfo)localObject).jdField_a_of_type_Boolean = false;
    ((DownloadTaskInfo)localObject).jdField_b_of_type_Boolean = false;
    int m = DownloadNativeApi.a().a(this, (DownloadTaskInfo)localObject);
    if (m != 200)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("app download start failed ");
        ((StringBuilder)localObject).append(m);
        QLog.i("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      ReportController.a(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F6E", "0X8008F6E", 0, 0, this.jdField_e_of_type_JavaLangString, "", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
      localObject = new Message();
      ((Message)localObject).what = 4;
      ((Message)localObject).arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("PublicAccountAdvertisementActivity", 2, "app download start succeeded");
      }
      ReportController.a(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F6D", "0X8008F6D", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "2", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void j()
  {
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    ReportController.a(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F72", "0X8008F72", 0, 0, this.jdField_e_of_type_JavaLangString, String.valueOf(System.currentTimeMillis() / 1000L), "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
    DownloadNativeApi.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
  }
  
  private void k()
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
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007F7B", "0X8007F7B", 0, 0, this.jdField_e_of_type_JavaLangString, "", "", "", false);
      return;
    }
    Object localObject = new Message();
    ((Message)localObject).what = 3;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      ReportController.a(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F79", "0X8008F79", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_Long / 1000L), ((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int)).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
      return;
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString;
      String str2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Integer)localEntry.getValue()).intValue());
      localStringBuilder.append("");
      ReportController.a(null, "dc00898", "", str1, "0X8008F79", "0X8008F79", 0, 0, str2, localStringBuilder.toString(), (String)localEntry.getKey(), this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
    }
    jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  private void m()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString;
    int m;
    if (VideoCoverFragment.jdField_c_of_type_Boolean) {
      m = 1;
    } else {
      m = 2;
    }
    ReportController.a(localAppRuntime, "dc00898", "", str1, "0X8008F61", "0X8008F61", 0, 0, str2, String.valueOf(m), ((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int)).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
    localAppRuntime = getAppRuntime();
    str1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString;
    str2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString;
    String str3 = ((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int)).jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PublicAccountAdUtil.a());
    localStringBuilder.append("(");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(")");
    ReportController.a(localAppRuntime, "dc00898", "", str1, "0X8008F66", "0X8008F66", 0, 0, str2, "", str3, localStringBuilder.toString());
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Long += this.jdField_g_of_type_Long - jdField_a_of_type_Long;
      return;
    }
    int m = (int)(((VideoCoverView)((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int)).a).a() / 1000L);
    String str = ((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int)).jdField_b_of_type_JavaLangString;
    if (m > 0)
    {
      Object localObject = (Integer)jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("current time =");
          ((StringBuilder)localObject).append(m);
          QLog.d("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
        }
        jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(m));
        return;
      }
      jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(((Integer)localObject).intValue() + m));
    }
  }
  
  private void o()
  {
    int m = this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode();
    if (jdField_a_of_type_Boolean) {
      return;
    }
    if ((m == 0) || (m == 1)) {
      ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountAdvertisementActivity.13(this), 300L);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqImaxadImaxShareActionSheet == null) {
      this.jdField_a_of_type_ComTencentMobileqqImaxadImaxShareActionSheet = new ImaxShareActionSheet(this, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem);
    }
    this.jdField_a_of_type_ComTencentMobileqqImaxadImaxShareActionSheet.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PublicAccountAdvertisementActivity.6(this));
  }
  
  void a(int paramInt)
  {
    QQToast.a(this, 1, paramInt, 0).b(getTitleBarHeight());
  }
  
  public void a(DownloadStateInfo paramDownloadStateInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app download state change ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.jdField_a_of_type_Int);
      QLog.d("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_g_of_type_Boolean) && (paramDownloadStateInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (paramDownloadStateInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)))
    {
      if (paramDownloadStateInfo.jdField_a_of_type_Int != 3) {
        return;
      }
      ReportController.a(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F70", "0X8008F70", 0, 0, this.jdField_e_of_type_JavaLangString, String.valueOf(System.currentTimeMillis() / 1000L), "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
      if (!this.h)
      {
        localObject = new Message();
        ((Message)localObject).what = 1;
        ((Message)localObject).arg1 = paramDownloadStateInfo.jdField_b_of_type_Int;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      }
    }
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
    return (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_d_of_type_Boolean);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
    if (localObject != null)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("videoDownloadItem jumpType = ");
        localStringBuilder.append(((VideoDownloadItem)localObject).jdField_d_of_type_Int);
        QLog.d("PublicAccountAdvertisementActivity", 2, localStringBuilder.toString());
      }
      if (((VideoDownloadItem)localObject).jdField_d_of_type_Int == 1)
      {
        if ((((VideoDownloadItem)localObject).j != null) && (!TextUtils.isEmpty(((VideoDownloadItem)localObject).j)))
        {
          a(((VideoDownloadItem)localObject).j);
          return;
        }
        h();
        return;
      }
      if (((VideoDownloadItem)localObject).jdField_d_of_type_Int == 2)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("videoDownloadItem jumpUrl = ");
          localStringBuilder.append(((VideoDownloadItem)localObject).jdField_d_of_type_Int);
          QLog.d("PublicAccountAdvertisementActivity", 2, localStringBuilder.toString());
        }
        if ((((VideoDownloadItem)localObject).n != null) && (!TextUtils.isEmpty(((VideoDownloadItem)localObject).n)))
        {
          a(((VideoDownloadItem)localObject).n);
          ReportController.a(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F74", "0X8008F74", 0, 0, this.jdField_e_of_type_JavaLangString, "", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
        }
      }
      else
      {
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof ToolAppRuntime)) {
          ImaxAdPresenter.a().a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem, this, (AppInterface)((ToolAppRuntime)localObject).onGetSubRuntime("imax"));
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("PublicAccountAdvertisementActivity", 2, "videoDownloadItem is null");
    }
  }
  
  public void b(DownloadStateInfo paramDownloadStateInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app download error ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.jdField_c_of_type_Int);
      QLog.i("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_g_of_type_Boolean) && (paramDownloadStateInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (paramDownloadStateInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && (!this.h))
    {
      localObject = new Message();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = paramDownloadStateInfo.jdField_c_of_type_Int;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
  }
  
  void b(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756189);
    localReportDialog.setContentView(2131561033);
    ((TextView)localReportDialog.findViewById(2131365681)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365669);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365667);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365673);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131689573);
    localTextView3.setText(2131689577);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new PublicAccountAdvertisementActivity.10(this, localReportDialog));
    localTextView3.setOnClickListener(new PublicAccountAdvertisementActivity.11(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean b()
  {
    return DownloadNativeApi.a().a(this.jdField_b_of_type_JavaLangString);
  }
  
  public void c()
  {
    f(this);
  }
  
  public void c(DownloadStateInfo paramDownloadStateInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app download progress ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.jdField_b_of_type_Int);
      QLog.d("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_g_of_type_Boolean) && (paramDownloadStateInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (paramDownloadStateInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && (!this.h))
    {
      localObject = new Message();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = paramDownloadStateInfo.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
  }
  
  public boolean c()
  {
    int m = DownloadNativeApi.a().a(new DownloadTaskInfo(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
    if (m != 0)
    {
      if (m != 1)
      {
        this.jdField_g_of_type_Boolean = false;
        return false;
      }
      return true;
    }
    return false;
  }
  
  void d()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756189);
    localReportDialog.setContentView(2131561033);
    ((TextView)localReportDialog.findViewById(2131365681)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365669);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365667);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365673);
    localTextView1.setText(2131689574);
    localTextView1.setGravity(3);
    localTextView2.setText(2131689575);
    localTextView3.setText(2131689576);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new PublicAccountAdvertisementActivity.8(this, localReportDialog));
    localTextView3.setOnClickListener(new PublicAccountAdvertisementActivity.9(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void d(DownloadStateInfo paramDownloadStateInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app download get progress");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.jdField_b_of_type_Int);
      QLog.d("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_g_of_type_Boolean) && (paramDownloadStateInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (paramDownloadStateInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) && ((!this.h) || (paramDownloadStateInfo.jdField_b_of_type_Int == 0)))
    {
      localObject = new Message();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = paramDownloadStateInfo.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
    this.jdField_b_of_type_Int = localDisplayMetrics.heightPixels;
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.directSuperDoOnCreate(paramBundle);
    setContentView(2131559588);
    overridePendingTransition(2130772172, 0);
    getWindow().addFlags(1024);
    getWindow().addFlags(128);
    f();
    e();
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment = new VideoCoverFragment();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem, this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidMediaAudioManager, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView, this.k);
    paramBundle = super.getSupportFragmentManager().beginTransaction();
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView = ((VerticalPagerView)findViewById(2131380442));
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.setOnPagerChangedListener(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.setOnInterceptTouchListener(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnInterceptTouchListener);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131370699);
      paramBundle.add(2131380491, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment);
    }
    else
    {
      paramBundle.add(2131365893, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment);
    }
    paramBundle.commit();
    paramBundle = new StringBuilder();
    paramBundle.append(Build.MANUFACTURER);
    paramBundle.append("_");
    paramBundle.append(Build.MODEL);
    paramBundle = paramBundle.toString();
    if ((Build.VERSION.SDK_INT > 10) && (!HW_FORBINDDEN_LIST.contains(paramBundle))) {
      getWindow().addFlags(16777216);
    }
    getWindow().setFormat(-3);
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    DownloadNativeApi.a().b(this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.b();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener = null;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = null;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener = null;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnInterceptTouchListener = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView;
    if (localObject != null) {
      ((VerticalPagerView)localObject).a();
    }
    jdField_a_of_type_Boolean = false;
    ReportController.a(getAppRuntime(), "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F69", "0X8008F69", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_c_of_type_Long / 1000L), "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
    l();
    jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.c();
    localObject = this.jdField_a_of_type_ComTencentMobileqqImaxadImaxShareActionSheet;
    if (localObject != null)
    {
      ((ImaxShareActionSheet)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqImaxadImaxShareActionSheet = null;
    }
    super.doOnDestroy();
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4)
    {
      if (paramInt != 24)
      {
        if (paramInt == 25)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b();
          jdField_a_of_type_Boolean = true;
          if (!this.j)
          {
            this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.jdField_a_of_type_Int, 0);
            this.j = true;
          }
          if (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3) <= 1)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841663);
            VideoCoverFragment.jdField_c_of_type_Boolean = true;
          }
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b();
        jdField_a_of_type_Boolean = true;
        if (!this.j)
        {
          this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.jdField_a_of_type_Int, 0);
          this.j = true;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841664);
        VideoCoverFragment.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.a();
      }
    }
    else
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView;
      if (localObject != null) {
        ((AdControlView)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView;
      if (localObject != null) {
        if (((VerticalPagerView)localObject).jdField_c_of_type_Int == 1)
        {
          this.jdField_f_of_type_Long = System.currentTimeMillis();
          this.jdField_c_of_type_Long += this.jdField_f_of_type_Long - this.jdField_e_of_type_Long;
        }
        else
        {
          o();
          n();
          m();
        }
      }
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "doOnNewIntent");
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
      g();
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
    jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.a(this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2, 0, 0, 300, new PublicAccountAdvertisementActivity.7(this));
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    boolean bool;
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = AdvertisementItem.a(localIntent.getStringExtra("arg_ad_json"));
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem != null)
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem);
        long l1 = localIntent.getLongExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
        bool = localIntent.getBooleanExtra("is_first_open_imax_ad", true);
        AdvertisementStatistics.a().a(this.jdField_e_of_type_JavaLangString, l1, bool);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = null;
    }
    AdvertisementItem localAdvertisementItem = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
    if (localAdvertisementItem == null)
    {
      finish();
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountAdvertisementActivity", 2, "onCreate object null");
      }
      return;
    }
    if ((localAdvertisementItem.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int m = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_d_of_type_Int;
      if (m > 3)
      {
        bool = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture();
        if (m == 5) {
          this.k = false;
        } else {
          this.k = bool;
        }
      }
      if (this.k)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.n))
        {
          this.jdField_b_of_type_Boolean = true;
          localIntent.putExtra("isFullScreen", true);
          localIntent.putExtra("isTransparentTitle", true);
          localIntent.putExtra("url", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.n);
        }
        else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.j))
        {
          this.jdField_b_of_type_Boolean = true;
          localIntent.putExtra("isFullScreen", true);
          localIntent.putExtra("isTransparentTitle", true);
          localIntent.putExtra("url", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.j);
        }
        else
        {
          this.jdField_b_of_type_Boolean = false;
        }
      }
      else {
        this.jdField_b_of_type_Boolean = false;
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_ads");
      localIntent.putExtra("big_brother_ref_source_key", "biz_src_jc_aio");
      super.onCreate(paramBundle);
      return;
    }
    finish();
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "onCreate no video");
    }
  }
  
  public void setContentView(int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(paramInt, null, false);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      localView.setFitsSystemWindows(true);
    }
    super.setContentView(localView);
    getWindow().setFeatureInt(7, 2131558998);
    try
    {
      ((View)findViewById(2131366900).getParent()).setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity
 * JD-Core Version:    0.7.0.1
 */