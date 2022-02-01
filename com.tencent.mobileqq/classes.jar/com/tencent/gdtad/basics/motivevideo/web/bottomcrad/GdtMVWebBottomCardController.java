package com.tencent.gdtad.basics.motivevideo.web.bottomcrad;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.ICmGameVideoPlayer;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.inject.GdtWebViewProxy;
import com.tencent.gdtad.inject.IGdtWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GdtMVWebBottomCardController
{
  public static String a = "PAUSE";
  public static String b = "COMPLETE";
  public FrameLayout c;
  public TouchWebView d;
  public IGdtWebView e;
  public View f;
  public String g = "";
  public GdtMotiveVideoModel h;
  public long i;
  public String j;
  public boolean k = false;
  public boolean l = false;
  public boolean m = false;
  public boolean n = false;
  public IOnWebBottomCardCallback o;
  public Runnable p = new GdtMVWebBottomCardController.1(this);
  public ArrayList<View> q = new ArrayList();
  public Handler r;
  public GdtWebViewProxy s = new GdtWebViewProxy();
  private final String t = "GdtMVWebBottomCardController";
  private boolean u;
  
  public GdtMVWebBottomCardController(IOnWebBottomCardCallback paramIOnWebBottomCardCallback, Handler paramHandler)
  {
    this.o = paramIOnWebBottomCardCallback;
    this.r = paramHandler;
  }
  
  private void a(View paramView)
  {
    if (paramView != null) {
      this.q.add(paramView);
    }
  }
  
  private void g()
  {
    a(this.f.findViewById(2131429639));
    a(this.f.findViewById(2131427758));
    a(this.f.findViewById(2131427749));
    a(this.f.findViewById(2131427729));
    a(this.f.findViewById(2131427750));
    a(this.f.findViewById(2131427664));
    a(this.f.findViewById(2131427724));
    h();
  }
  
  private void h()
  {
    if (this.u)
    {
      GdtMotiveVideoModel localGdtMotiveVideoModel = this.h;
      if (localGdtMotiveVideoModel != null)
      {
        if (localGdtMotiveVideoModel.d() == null) {
          return;
        }
        if (this.h.d().isHitDownloadLayer()) {
          a(this.f.findViewById(2131434114));
        }
      }
    }
  }
  
  public String a(ICmGameVideoPlayer paramICmGameVideoPlayer)
  {
    if (paramICmGameVideoPlayer == null)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "calPlayStatus player is null");
      return "";
    }
    int i1 = paramICmGameVideoPlayer.getStatus();
    if (i1 <= 3) {
      return "PLAYING";
    }
    if (i1 == 4) {
      return a;
    }
    return b;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtMVWebBottomCardController", 2, "showWebBottomCard");
    }
    int i1 = 0;
    while (i1 < this.q.size())
    {
      ((View)this.q.get(i1)).setVisibility(4);
      i1 += 1;
    }
    GdtADFlyingStreamingReportHelper.a().a(1);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.g))
    {
      QLog.i("GdtMVWebBottomCardController", 1, "addWebBottomCardUrlParams url is null");
      return;
    }
    this.g = URLUtil.a(this.g, "width", String.valueOf(paramInt1));
    this.g = URLUtil.a(this.g, "height", String.valueOf(paramInt2));
    String str = this.g;
    if (paramBoolean) {
      localObject = "vertical";
    } else {
      localObject = "horizontal";
    }
    this.g = URLUtil.a(str, "direction", (String)localObject);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("encoded Url :");
    ((StringBuilder)localObject).append(this.g);
    QLog.d("GdtMVWebBottomCardController", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtMVWebBottomCardController", 2, "showNativeBottomCard");
    }
    int i1 = 0;
    while (i1 < this.q.size())
    {
      if ((!paramBoolean) || (((!this.u) || (!this.h.d().isHitDownloadLayer()) || (2131434114 != ((View)this.q.get(i1)).getId())) && (2131427749 != ((View)this.q.get(i1)).getId()))) {
        ((View)this.q.get(i1)).setVisibility(0);
      }
      i1 += 1;
    }
    e();
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    TouchWebView localTouchWebView = this.d;
    if (localTouchWebView == null) {
      return;
    }
    if (this.k)
    {
      if (this.l) {
        return;
      }
      paramLong1 /= 1000L;
      paramLong2 /= 1000L;
      localTouchWebView.callJs("getVideoStatus", new String[] { String.format(Locale.getDefault(), "{isMute:%b,totalDuration:%d,currentPosition:%d,rewardPosition:%d,status:\"%s\"}", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), paramString }) });
    }
  }
  
  public boolean a(Activity paramActivity)
  {
    try
    {
      AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      this.d = new TouchWebView(paramActivity);
      this.d.setBackgroundColor(0);
      this.c.addView(this.d);
      this.e = this.s.a();
      if (this.e != null)
      {
        this.e.a(paramActivity, paramActivity, null, localAppInterface, new GdtMVWebBottomCardController.2(this));
        this.e.a(this.d);
        this.e.a(null);
        this.e.a(null, localAppInterface, null);
      }
      this.m = true;
      this.c.setVisibility(8);
      paramActivity = new StringBuilder();
      paramActivity.append("initWebView url = ");
      paramActivity.append(this.g);
      QLog.i("GdtMVWebBottomCardController", 1, paramActivity.toString());
      return true;
    }
    catch (Exception paramActivity)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView", paramActivity);
    }
    return false;
  }
  
  public boolean a(GdtMotiveVideoModel paramGdtMotiveVideoModel, View paramView, Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView activity == null");
      return false;
    }
    if (paramGdtMotiveVideoModel == null)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView model == null");
      return false;
    }
    if (paramView == null)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView rootView == null");
      return false;
    }
    this.c = ((FrameLayout)paramView.findViewById(2131450071));
    if (this.c == null)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView webFrameLayout == null");
      return false;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = paramGdtMotiveVideoModel.a();
    if (localGdtMotiveVideoPageData == null)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "initWebView data == null");
      return false;
    }
    if (TextUtils.isEmpty(localGdtMotiveVideoPageData.bottomCardUrl))
    {
      QLog.i("GdtMVWebBottomCardController", 1, "TextUtils.isEmpty(data.bottomCardUrl)");
      return false;
    }
    this.u = paramBoolean;
    this.g = localGdtMotiveVideoPageData.bottomCardUrl;
    this.h = paramGdtMotiveVideoModel;
    this.i = localGdtMotiveVideoPageData.bottomCardLoadTime;
    this.j = localGdtMotiveVideoPageData.traceId;
    a(this.h.d().getImageWidth(), this.h.d().getImageHeight(), paramBoolean);
    this.f = paramView;
    g();
    return a(paramActivity);
  }
  
  public void b()
  {
    QLog.i("GdtMVWebBottomCardController", 1, "onLoadFail");
    this.l = true;
    Object localObject = this.c;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = this.o;
    if (localObject != null) {
      ((IOnWebBottomCardCallback)localObject).a();
    }
  }
  
  public void c()
  {
    QLog.i("GdtMVWebBottomCardController", 1, "onLoadSuccess");
    IOnWebBottomCardCallback localIOnWebBottomCardCallback = this.o;
    if (localIOnWebBottomCardCallback != null) {
      localIOnWebBottomCardCallback.b();
    }
  }
  
  public void d()
  {
    a(true);
  }
  
  public void e()
  {
    try
    {
      if (this.c != null) {
        this.c.setVisibility(8);
      }
      if (this.e != null)
      {
        this.e.c();
        this.e = null;
      }
      if (this.d != null)
      {
        ViewParent localViewParent = this.d.getParent();
        if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
          ((ViewGroup)localViewParent).removeAllViewsInLayout();
        }
        this.d = null;
      }
      if (this.r != null)
      {
        this.r.removeCallbacks(this.p);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("GdtMVWebBottomCardController", 1, "onDestroy", localException);
    }
  }
  
  public void f()
  {
    if (!this.m) {
      return;
    }
    if (this.k) {
      return;
    }
    if (this.i <= 0L) {
      return;
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      ((TouchWebView)localObject).loadUrl(this.g);
      this.k = true;
      localObject = this.r;
      if (localObject != null) {
        ((Handler)localObject).postDelayed(this.p, this.i * 1000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.web.bottomcrad.GdtMVWebBottomCardController
 * JD-Core Version:    0.7.0.1
 */