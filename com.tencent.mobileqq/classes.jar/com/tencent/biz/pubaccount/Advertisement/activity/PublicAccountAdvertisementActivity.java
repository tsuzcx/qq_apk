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
  public static boolean a = false;
  public static long b;
  public static HashMap<String, Integer> d = new HashMap();
  private int A = 0;
  private String B;
  private String C;
  private String D;
  private String E;
  private String F = "";
  private boolean G = false;
  private boolean H = true;
  private boolean I = false;
  private long J;
  private long K;
  private long L;
  private long M;
  private long N;
  private AudioManager O = null;
  private boolean P = false;
  private boolean Q = true;
  private boolean R = false;
  private ImaxShareActionSheet S;
  private ActionSheet.OnButtonClickListener T;
  private ActionSheet.OnButtonClickListener U;
  private View.OnClickListener V;
  public long c;
  protected Handler e = new PublicAccountAdvertisementActivity.12(this, Looper.getMainLooper());
  private int f;
  private int g;
  private AdvertisementItem h;
  private boolean i;
  private boolean j = true;
  private DragFrameLayout k;
  private VerticalPagerView l;
  private VideoCoverFragment m;
  private WebpageFragment n;
  private View o;
  private AdControlView p;
  private DragFrameLayout.OnDraggingListener q;
  private ViewPager.OnPageChangeListener r;
  private VerticalPagerView.OnPagerChangedListener s;
  private VerticalPagerView.OnInterceptTouchListener t;
  private View.OnClickListener u;
  private ActionSheet v;
  private int w = 0;
  private boolean x = false;
  private boolean y = false;
  private boolean z = true;
  
  public static void a(Context paramContext, AdvertisementItem paramAdvertisementItem)
  {
    if (paramAdvertisementItem == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("arg_ad_json", paramAdvertisementItem.c());
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    paramContext.startActivity(localIntent);
  }
  
  private void a(VideoDownloadItem paramVideoDownloadItem)
  {
    if (paramVideoDownloadItem == null) {
      return;
    }
    boolean bool;
    if ((paramVideoDownloadItem.i) && (paramVideoDownloadItem.n == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    this.G = bool;
    this.B = paramVideoDownloadItem.q;
    this.C = paramVideoDownloadItem.r;
    this.E = paramVideoDownloadItem.o;
    this.D = paramVideoDownloadItem.s;
    this.F = paramVideoDownloadItem.c;
    this.I = paramVideoDownloadItem.t;
    if ((TextUtils.isEmpty(this.B)) || (TextUtils.isEmpty(this.C)) || (TextUtils.isEmpty(this.E))) {
      this.G = false;
    }
    if (!this.G) {
      return;
    }
    DownloadNativeApi.a().a(this);
    paramVideoDownloadItem = new DownloadTaskInfo(this.B, this.C, this.D, this.E, true);
    paramVideoDownloadItem.f = false;
    if (f()) {
      return;
    }
    if (g()) {
      return;
    }
    if (!this.G) {
      return;
    }
    if ((this.I) && (NetworkUtil.isWifiEnabled(this)))
    {
      int i1 = DownloadNativeApi.a().a(this, paramVideoDownloadItem);
      this.H = true;
      if ((QLog.isColorLevel()) && (200 == i1)) {
        QLog.i("PublicAccountAdvertisementActivity", 2, "app download silent start success");
      }
      ReportController.a(null, "dc00898", "", this.h.g.a, "0X8008F6D", "0X8008F6D", 0, 0, this.h.g.c, "1", "", this.h.g.b);
    }
  }
  
  private void b(int paramInt)
  {
    ReportController.a(null, "dc00898", "", this.h.g.a, "0X80090FB", "0X80090FB", 0, 0, this.h.g.c, "", "", this.h.g.b);
    this.v = ActionSheet.createFullScreenMenuSheet(this);
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        this.v.addButton(2131889658);
        this.v.addButton(2131890789);
        this.v.addCancelButton(2131887648);
        if (this.U == null) {
          this.U = new PublicAccountAdvertisementActivity.15(this);
        }
        this.v.setOnButtonClickListener(this.U);
      }
    }
    else
    {
      this.v.addButton(2131890789);
      this.v.addCancelButton(2131887648);
      if (this.T == null) {
        this.T = new PublicAccountAdvertisementActivity.14(this);
      }
      this.v.setOnButtonClickListener(this.T);
    }
    if (this.V == null) {
      this.V = new PublicAccountAdvertisementActivity.16(this);
    }
    this.v.setOnBottomCancelListener(this.V);
    this.v.show();
  }
  
  private void h()
  {
    this.p = ((AdControlView)super.findViewById(2131427668));
    this.k = ((DragFrameLayout)super.findViewById(2131432141));
    FrameLayout localFrameLayout = (FrameLayout)super.findViewById(2131432161);
    this.k.setDraggableView(localFrameLayout);
    this.k.setOnDraggingListener(this.q);
    this.k.a = (this.f / 4);
    this.p.bringToFront();
    this.p.setVisibility(4);
    this.p.getMoreBtn().setOnClickListener(this.u);
    this.p.getAdMoreBtn().setOnClickListener(this.u);
    this.p.getAdShareBtn().setOnClickListener(this.u);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.k.setFitsSystemWindows(true);
    }
  }
  
  private void i()
  {
    this.q = new PublicAccountAdvertisementActivity.1(this);
    this.r = new PublicAccountAdvertisementActivity.2(this);
    this.u = new PublicAccountAdvertisementActivity.3(this);
    if (a())
    {
      this.s = new PublicAccountAdvertisementActivity.4(this);
      this.t = new PublicAccountAdvertisementActivity.5(this);
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download start get download progress");
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new DownloadTaskInfo(this.B, this.C));
    DownloadNativeApi.a().a(localLinkedList);
  }
  
  private void k()
  {
    if (f())
    {
      n();
      return;
    }
    if (g())
    {
      m();
      return;
    }
    if (NetworkState.isNetSupport())
    {
      if (NetworkState.isWifiConn())
      {
        l();
        return;
      }
      e();
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = 202;
    this.e.sendMessage(localMessage);
  }
  
  private void l()
  {
    if (!this.G) {
      return;
    }
    Object localObject = new DownloadTaskInfo(this.B, this.C, this.D, this.E, false);
    this.H = false;
    ((DownloadTaskInfo)localObject).f = false;
    ((DownloadTaskInfo)localObject).g = false;
    int i1 = DownloadNativeApi.a().a(this, (DownloadTaskInfo)localObject);
    if (i1 != 200)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("app download start failed ");
        ((StringBuilder)localObject).append(i1);
        QLog.i("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      ReportController.a(null, "dc00898", "", this.h.g.a, "0X8008F6E", "0X8008F6E", 0, 0, this.F, "", "", this.h.g.b);
      localObject = new Message();
      ((Message)localObject).what = 4;
      ((Message)localObject).arg1 = 1;
      this.e.sendMessage((Message)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("PublicAccountAdvertisementActivity", 2, "app download start succeeded");
      }
      ReportController.a(null, "dc00898", "", this.h.g.a, "0X8008F6D", "0X8008F6D", 0, 0, this.h.g.c, "2", "", this.h.g.b);
    }
  }
  
  private void m()
  {
    if (!this.G) {
      return;
    }
    ReportController.a(null, "dc00898", "", this.h.g.a, "0X8008F72", "0X8008F72", 0, 0, this.F, String.valueOf(System.currentTimeMillis() / 1000L), "", this.h.g.b);
    DownloadNativeApi.a().a(this.B, this.C);
  }
  
  private void n()
  {
    if (!this.G) {
      return;
    }
    if (f())
    {
      localObject = getPackageManager().getLaunchIntentForPackage(this.C);
      if (localObject != null) {
        startActivity((Intent)localObject);
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007F7B", "0X8007F7B", 0, 0, this.F, "", "", "", false);
      return;
    }
    Object localObject = new Message();
    ((Message)localObject).what = 3;
    this.e.sendMessage((Message)localObject);
  }
  
  private void o()
  {
    if (this.h.c.size() == 1)
    {
      ReportController.a(null, "dc00898", "", this.h.g.a, "0X8008F79", "0X8008F79", 0, 0, this.h.g.c, String.valueOf(this.c / 1000L), ((VideoCoverItem)this.h.c.get(this.w)).c, this.h.g.b);
      return;
    }
    Iterator localIterator = d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = this.h.g.a;
      String str2 = this.h.g.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Integer)localEntry.getValue()).intValue());
      localStringBuilder.append("");
      ReportController.a(null, "dc00898", "", str1, "0X8008F79", "0X8008F79", 0, 0, str2, localStringBuilder.toString(), (String)localEntry.getKey(), this.h.g.b);
    }
    d.clear();
  }
  
  private void p()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    String str1 = this.h.g.a;
    String str2 = this.h.g.c;
    int i1;
    if (VideoCoverFragment.d) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ReportController.a(localAppRuntime, "dc00898", "", str1, "0X8008F61", "0X8008F61", 0, 0, str2, String.valueOf(i1), ((VideoCoverItem)this.h.c.get(this.w)).c, this.h.g.b);
    localAppRuntime = getAppRuntime();
    str1 = this.h.g.a;
    str2 = this.h.g.c;
    String str3 = ((VideoCoverItem)this.h.c.get(this.w)).c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PublicAccountAdUtil.c());
    localStringBuilder.append("(");
    localStringBuilder.append(this.h.g.b);
    localStringBuilder.append(")");
    ReportController.a(localAppRuntime, "dc00898", "", str1, "0X8008F66", "0X8008F66", 0, 0, str2, "", str3, localStringBuilder.toString());
  }
  
  private void q()
  {
    if (this.h.c.size() == 1)
    {
      this.N = System.currentTimeMillis();
      this.c += this.N - b;
      return;
    }
    int i1 = (int)(((VideoCoverView)((VideoCoverItem)this.h.c.get(this.w)).d).getPlayVideoProgress() / 1000L);
    String str = ((VideoCoverItem)this.h.c.get(this.w)).c;
    if (i1 > 0)
    {
      Object localObject = (Integer)d.get(str);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("current time =");
          ((StringBuilder)localObject).append(i1);
          QLog.d("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
        }
        d.put(str, Integer.valueOf(i1));
        return;
      }
      d.put(str, Integer.valueOf(((Integer)localObject).intValue() + i1));
    }
  }
  
  private void r()
  {
    int i1 = this.O.getRingerMode();
    if (a) {
      return;
    }
    if ((i1 == 0) || (i1 == 1)) {
      ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountAdvertisementActivity.13(this), 300L);
    }
  }
  
  private void s()
  {
    if (this.S == null) {
      this.S = new ImaxShareActionSheet(this, this.h);
    }
    this.S.a();
  }
  
  void a(int paramInt)
  {
    QQToast.makeText(this, 1, paramInt, 0).show(getTitleBarHeight());
  }
  
  public void a(DownloadStateInfo paramDownloadStateInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app download state change ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.b);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.c);
      QLog.d("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.G) && (paramDownloadStateInfo.a.equals(this.B)) && (paramDownloadStateInfo.b.equals(this.C)))
    {
      if (paramDownloadStateInfo.c != 3) {
        return;
      }
      ReportController.a(null, "dc00898", "", this.h.g.a, "0X8008F70", "0X8008F70", 0, 0, this.F, String.valueOf(System.currentTimeMillis() / 1000L), "", this.h.g.b);
      if (!this.H)
      {
        localObject = new Message();
        ((Message)localObject).what = 1;
        ((Message)localObject).arg1 = paramDownloadStateInfo.d;
        this.e.sendMessage((Message)localObject);
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
    return (this.i) && (this.h.g.E);
  }
  
  public void b()
  {
    this.e.post(new PublicAccountAdvertisementActivity.6(this));
  }
  
  public void b(DownloadStateInfo paramDownloadStateInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app download error ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.b);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.g);
      QLog.i("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.G) && (paramDownloadStateInfo.a.equals(this.B)) && (paramDownloadStateInfo.b.equals(this.C)) && (!this.H))
    {
      localObject = new Message();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = paramDownloadStateInfo.g;
      this.e.sendMessage((Message)localObject);
    }
  }
  
  void b(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131953338);
    localReportDialog.setContentView(2131627374);
    ((TextView)localReportDialog.findViewById(2131431915)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131431902);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131431900);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131431907);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131886183);
    localTextView3.setText(2131886187);
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
  
  public void c()
  {
    Object localObject = this.h.g;
    if (localObject != null)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("videoDownloadItem jumpType = ");
        localStringBuilder.append(((VideoDownloadItem)localObject).n);
        QLog.d("PublicAccountAdvertisementActivity", 2, localStringBuilder.toString());
      }
      if (((VideoDownloadItem)localObject).n == 1)
      {
        if ((((VideoDownloadItem)localObject).p != null) && (!TextUtils.isEmpty(((VideoDownloadItem)localObject).p)))
        {
          a(((VideoDownloadItem)localObject).p);
          return;
        }
        k();
        return;
      }
      if (((VideoDownloadItem)localObject).n == 2)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("videoDownloadItem jumpUrl = ");
          localStringBuilder.append(((VideoDownloadItem)localObject).n);
          QLog.d("PublicAccountAdvertisementActivity", 2, localStringBuilder.toString());
        }
        if ((((VideoDownloadItem)localObject).v != null) && (!TextUtils.isEmpty(((VideoDownloadItem)localObject).v)))
        {
          a(((VideoDownloadItem)localObject).v);
          ReportController.a(null, "dc00898", "", this.h.g.a, "0X8008F74", "0X8008F74", 0, 0, this.F, "", "", this.h.g.b);
        }
      }
      else
      {
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof ToolAppRuntime)) {
          ImaxAdPresenter.a().a(this.h, this, (AppInterface)((ToolAppRuntime)localObject).onGetSubRuntime("imax"));
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("PublicAccountAdvertisementActivity", 2, "videoDownloadItem is null");
    }
  }
  
  public void c(DownloadStateInfo paramDownloadStateInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app download progress ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.b);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.d);
      QLog.d("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.G) && (paramDownloadStateInfo.a.equals(this.B)) && (paramDownloadStateInfo.b.equals(this.C)) && (!this.H))
    {
      localObject = new Message();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = paramDownloadStateInfo.d;
      this.e.sendMessage((Message)localObject);
    }
  }
  
  public void d()
  {
    v(this);
  }
  
  public void d(DownloadStateInfo paramDownloadStateInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app download get progress");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.b);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramDownloadStateInfo.d);
      QLog.d("PublicAccountAdvertisementActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.G) && (paramDownloadStateInfo.a.equals(this.B)) && (paramDownloadStateInfo.b.equals(this.C)) && ((!this.H) || (paramDownloadStateInfo.d == 0)))
    {
      localObject = new Message();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = paramDownloadStateInfo.d;
      this.e.sendMessage((Message)localObject);
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
    this.f = localDisplayMetrics.widthPixels;
    this.g = localDisplayMetrics.heightPixels;
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.directSuperDoOnCreate(paramBundle);
    setContentView(2131625617);
    overridePendingTransition(2130772238, 0);
    getWindow().addFlags(1024);
    getWindow().addFlags(128);
    i();
    h();
    this.O = ((AudioManager)getSystemService("audio"));
    this.m = new VideoCoverFragment();
    this.m.a(this.h, this.r, this.u, this.O, this.p, this.Q);
    paramBundle = super.getSupportFragmentManager().beginTransaction();
    if (a())
    {
      this.l = ((VerticalPagerView)findViewById(2131449394));
      this.l.setOnPagerChangedListener(this.s);
      this.l.setOnInterceptTouchListener(this.t);
      this.l.setVisibility(0);
      this.o = findViewById(2131437976);
      paramBundle.add(2131449445, this.m);
    }
    else
    {
      paramBundle.add(2131432161, this.m);
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
    Object localObject = this.e;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    DownloadNativeApi.a().b(this);
    this.k.b();
    this.q = null;
    this.r = null;
    this.s = null;
    this.t = null;
    this.u = null;
    localObject = this.l;
    if (localObject != null) {
      ((VerticalPagerView)localObject).a();
    }
    a = false;
    ReportController.a(getAppRuntime(), "dc00898", "", this.h.g.a, "0X8008F69", "0X8008F69", 0, 0, this.h.g.c, String.valueOf(this.J / 1000L), "", this.h.g.b);
    o();
    b = 0L;
    this.p.d();
    localObject = this.S;
    if (localObject != null)
    {
      ((ImaxShareActionSheet)localObject).c();
      this.S = null;
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
          this.p.b();
          a = true;
          if (!this.P)
          {
            this.O.setStreamVolume(3, this.m.e, 0);
            this.P = true;
          }
          if (this.O.getStreamVolume(3) <= 1)
          {
            this.p.getVideoVolumeBtn().setBackgroundResource(2130842578);
            VideoCoverFragment.d = true;
          }
        }
      }
      else
      {
        this.p.b();
        a = true;
        if (!this.P)
        {
          this.O.setStreamVolume(3, this.m.e, 0);
          this.P = true;
        }
        this.p.getVideoVolumeBtn().setBackgroundResource(2130842579);
        VideoCoverFragment.d = false;
        this.m.c();
      }
    }
    else
    {
      Object localObject = this.p;
      if (localObject != null) {
        ((AdControlView)localObject).setVisibility(8);
      }
      localObject = this.l;
      if (localObject != null) {
        if (((VerticalPagerView)localObject).d == 1)
        {
          this.M = System.currentTimeMillis();
          this.J += this.M - this.L;
        }
        else
        {
          r();
          q();
          p();
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
    if (this.G)
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.arg1 = 0;
      this.e.sendMessage(localMessage);
      j();
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      AdvertisementStatistics.a().b();
    }
  }
  
  void e()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131953338);
    localReportDialog.setContentView(2131627374);
    ((TextView)localReportDialog.findViewById(2131431915)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131431902);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131431900);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131431907);
    localTextView1.setText(2131886184);
    localTextView1.setGravity(3);
    localTextView2.setText(2131886185);
    localTextView3.setText(2131886186);
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
  
  public boolean f()
  {
    return DownloadNativeApi.a().b(this.C);
  }
  
  public void finish()
  {
    a = false;
    this.k.a(this.f / 2, this.g / 2, 0, 0, 300, new PublicAccountAdvertisementActivity.7(this));
  }
  
  public boolean g()
  {
    int i1 = DownloadNativeApi.a().a(new DownloadTaskInfo(this.B, this.C));
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        this.G = false;
        return false;
      }
      return true;
    }
    return false;
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
      this.h = AdvertisementItem.a(localIntent.getStringExtra("arg_ad_json"));
      if (this.h != null)
      {
        a(this.h.g);
        long l1 = localIntent.getLongExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
        bool = localIntent.getBooleanExtra("is_first_open_imax_ad", true);
        AdvertisementStatistics.a().a(this.F, l1, bool);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.h = null;
    }
    AdvertisementItem localAdvertisementItem = this.h;
    if (localAdvertisementItem == null)
    {
      finish();
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountAdvertisementActivity", 2, "onCreate object null");
      }
      return;
    }
    if ((localAdvertisementItem.c != null) && (this.h.c.size() > 0))
    {
      int i1 = this.h.g.n;
      if (i1 > 3)
      {
        bool = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture();
        if (i1 == 5) {
          this.Q = false;
        } else {
          this.Q = bool;
        }
      }
      if (this.Q)
      {
        if (!TextUtils.isEmpty(this.h.g.v))
        {
          this.i = true;
          localIntent.putExtra("isFullScreen", true);
          localIntent.putExtra("isTransparentTitle", true);
          localIntent.putExtra("url", this.h.g.v);
        }
        else if (!TextUtils.isEmpty(this.h.g.p))
        {
          this.i = true;
          localIntent.putExtra("isFullScreen", true);
          localIntent.putExtra("isTransparentTitle", true);
          localIntent.putExtra("url", this.h.g.p);
        }
        else
        {
          this.i = false;
        }
      }
      else {
        this.i = false;
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
    getWindow().setFeatureInt(7, 2131624631);
    try
    {
      ((View)findViewById(2131433232).getParent()).setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity
 * JD-Core Version:    0.7.0.1
 */