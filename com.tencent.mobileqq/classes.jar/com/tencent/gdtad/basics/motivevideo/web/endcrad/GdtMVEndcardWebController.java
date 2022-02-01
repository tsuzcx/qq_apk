package com.tencent.gdtad.basics.motivevideo.web.endcrad;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.elements.GdtMvElementsHelper;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.inject.GdtWebViewProxy;
import com.tencent.gdtad.inject.IGdtWebView;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.URLUtil;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GdtMVEndcardWebController
{
  public IGdtWebView a;
  public TouchWebView b;
  public FrameLayout c;
  public String d;
  public GdtMotiveVideoModel e;
  public long f;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public View j;
  public View k;
  public View l;
  public GdtThirdProcessorProxy m;
  public GdtWebViewProxy n = new GdtWebViewProxy();
  private Integer o;
  private Pattern p = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");
  private long q;
  private boolean r = false;
  private final GdtMvElementsHelper s = new GdtMvElementsHelper();
  
  public GdtMVEndcardWebController(GdtThirdProcessorProxy paramGdtThirdProcessorProxy)
  {
    this.m = paramGdtThirdProcessorProxy;
  }
  
  private boolean a(WebView paramWebView, String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.startsWith("gdtmsg://e.qq.com/reportClickRewardAd/rewardAD/"))
      {
        if ((this.e != null) && (this.e.d() != null) && (this.e.b() != null) && (!TextUtils.isEmpty(this.e.d().getUrlForClick())))
        {
          Object localObject = this.e.d().getUrlForClick();
          this.m.a(1, 0, this.e.b());
          GdtReporter.doCgiReport((String)localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleSchema url= ");
          ((StringBuilder)localObject).append(paramString);
          QLog.i("EndCardWebGdtMVEndcardWebController", 1, ((StringBuilder)localObject).toString());
          this.s.a(paramWebView, paramString);
          return true;
        }
        QLog.i("EndCardWebGdtMVEndcardWebController", 1, "handleSchema urlForClick is Empty");
        return false;
      }
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "handleSchema error");
      return false;
    }
    catch (Exception paramWebView)
    {
      label155:
      break label155;
    }
    QLog.e("EndCardWebGdtMVEndcardWebController", 1, "fitSpecialScreen", paramWebView);
    return false;
  }
  
  public void a()
  {
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "onWebError");
    this.h = true;
    FrameLayout localFrameLayout = this.c;
    if ((localFrameLayout != null) && (localFrameLayout.getVisibility() == 0)) {
      this.c.setVisibility(8);
    }
  }
  
  public void a(long paramLong)
  {
    if (!this.i) {
      return;
    }
    if (this.g) {
      return;
    }
    long l1 = this.f;
    if (l1 <= 0L) {
      return;
    }
    if (paramLong / 1000L > l1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preLoadUrl   ");
    localStringBuilder.append(paramLong);
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, localStringBuilder.toString());
    this.c.setVisibility(4);
    if (this.b != null)
    {
      this.q = System.currentTimeMillis();
      this.b.loadUrl(this.d);
      this.g = true;
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      if (this.b == null)
      {
        QLog.i("EndCardWebGdtMVEndcardWebController", 1, "fitSpecialScreen webview == null");
        return;
      }
      if (!paramBoolean)
      {
        QLog.i("EndCardWebGdtMVEndcardWebController", 1, "fitSpecialScreen !isPortait");
        return;
      }
      localObject = (FrameLayout.LayoutParams)this.b.getLayoutParams();
      LiuHaiUtils.f(paramActivity);
      if (LiuHaiUtils.b())
      {
        ((FrameLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.e(paramActivity);
        this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramActivity = new StringBuilder();
        paramActivity.append("fitSpecialScreen addHeight = ");
        paramActivity.append(((FrameLayout.LayoutParams)localObject).topMargin);
        QLog.i("EndCardWebGdtMVEndcardWebController", 1, paramActivity.toString());
        return;
      }
    }
    catch (Exception paramActivity)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fitSpecialScreen e:");
      ((StringBuilder)localObject).append(paramActivity);
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(View paramView)
  {
    this.j = paramView.findViewById(2131434124);
    paramView = this.j;
    if (paramView == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initLoadingContainer container == null");
      return;
    }
    this.l = paramView.findViewById(2131434125);
    this.k = this.j.findViewById(2131434126);
    if ((this.l != null) && (this.k != null))
    {
      this.j.setVisibility(8);
      return;
    }
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initLoadingContainer view == null");
  }
  
  public void a(GdtMotiveVideoModel paramGdtMotiveVideoModel, View paramView, Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView activity == null");
      return;
    }
    if (paramGdtMotiveVideoModel == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView model == null");
      return;
    }
    this.c = ((FrameLayout)paramView.findViewById(2131450077));
    if (this.c == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView webFrameLayout == null");
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = paramGdtMotiveVideoModel.a();
    if (localGdtMotiveVideoPageData == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView data == null");
      return;
    }
    if (TextUtils.isEmpty(localGdtMotiveVideoPageData.endcardUrl))
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "TextUtils.isEmpty(data.endcardUrl)");
      return;
    }
    this.d = localGdtMotiveVideoPageData.endcardUrl;
    a(paramBoolean);
    this.e = paramGdtMotiveVideoModel;
    this.f = localGdtMotiveVideoPageData.endcardLoadTime;
    a(paramView);
    try
    {
      paramGdtMotiveVideoModel = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      this.b = new TouchWebView(paramActivity);
      this.b.setBackgroundColor(0);
      this.c.addView(this.b);
      this.a = this.n.a();
      if (this.a != null)
      {
        this.a.a(paramActivity, paramActivity, null, paramGdtMotiveVideoModel, new GdtMVEndcardWebController.1(this));
        this.a.a(this.b);
        this.a.a(null);
        this.a.a(null, paramGdtMotiveVideoModel, null);
      }
      this.i = true;
      a(paramActivity, paramBoolean);
      paramGdtMotiveVideoModel = new StringBuilder();
      paramGdtMotiveVideoModel.append("initWebView url = ");
      paramGdtMotiveVideoModel.append(this.d);
      paramGdtMotiveVideoModel.append(",time = ");
      paramGdtMotiveVideoModel.append(this.f);
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, paramGdtMotiveVideoModel.toString());
      return;
    }
    catch (Exception paramGdtMotiveVideoModel)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initWebView", paramGdtMotiveVideoModel);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str2 = this.d;
    String str1;
    if (paramBoolean) {
      str1 = "vertical";
    } else {
      str1 = "horizontal";
    }
    this.d = URLUtil.a(str2, "direction", str1);
  }
  
  public boolean a(Activity paramActivity, GdtMotiveVideoModel paramGdtMotiveVideoModel, boolean paramBoolean)
  {
    if (!this.i)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb !mHasInit");
      return false;
    }
    if (this.h)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb mHasError");
      return false;
    }
    if (this.c == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb mWebViewContainer == null");
      return false;
    }
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb");
    this.c.setVisibility(0);
    if (!this.g) {
      this.b.loadUrl(this.d);
    }
    b(paramActivity, paramGdtMotiveVideoModel, paramBoolean);
    return true;
  }
  
  public void b(Activity paramActivity, GdtMotiveVideoModel paramGdtMotiveVideoModel, boolean paramBoolean)
  {
    int i2;
    int i1;
    if ((paramActivity != null) && (paramGdtMotiveVideoModel != null) && (paramGdtMotiveVideoModel.d() != null))
    {
      i2 = paramGdtMotiveVideoModel.d().getEndcardDirection();
      if (paramBoolean) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      paramGdtMotiveVideoModel = new StringBuilder();
      paramGdtMotiveVideoModel.append("changeScreenOrientation endcard = ");
      paramGdtMotiveVideoModel.append(i2);
      paramGdtMotiveVideoModel.append(",curr = ");
      paramGdtMotiveVideoModel.append(i1);
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, paramGdtMotiveVideoModel.toString());
      if ((i2 != 1) && (i2 != 2)) {
        return;
      }
      if (i2 == i1) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        e();
        this.o = Integer.valueOf(paramActivity.getRequestedOrientation());
        if (i2 != 1) {
          break label165;
        }
        i1 = 1;
        paramActivity.setRequestedOrientation(i1);
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.e("EndCardWebGdtMVEndcardWebController", 1, "changeScreenOrientation", paramActivity);
        return;
      }
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "changeScreenOrientation error");
      return;
      label165:
      i1 = 0;
    }
  }
  
  public void b(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      if (this.a != null)
      {
        this.a.c();
        this.a = null;
      }
      Object localObject;
      if (this.b != null)
      {
        localObject = this.b.getParent();
        if ((localObject != null) && ((localObject instanceof ViewGroup))) {
          ((ViewGroup)localObject).removeAllViewsInLayout();
        }
        this.b = null;
      }
      if ((this.o != null) && (paramBoolean) && (paramActivity != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDestroy setRequestedOrientation ");
        ((StringBuilder)localObject).append(this.o);
        QLog.i("EndCardWebGdtMVEndcardWebController", 1, ((StringBuilder)localObject).toString());
        paramActivity.setRequestedOrientation(this.o.intValue());
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "onDestroy", paramActivity);
    }
  }
  
  public boolean b()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
    {
      localObject = this.b;
      if ((localObject != null) && (((TouchWebView)localObject).canGoBack()))
      {
        this.b.goBack();
        bool = true;
        break label46;
      }
    }
    boolean bool = false;
    label46:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onBackEvent return ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public void c()
  {
    IGdtWebView localIGdtWebView = this.a;
    if (localIGdtWebView != null) {
      localIGdtWebView.a();
    }
  }
  
  public void d()
  {
    IGdtWebView localIGdtWebView = this.a;
    if (localIGdtWebView != null) {
      localIGdtWebView.b();
    }
  }
  
  public void e()
  {
    View localView = this.j;
    if ((localView != null) && (this.l != null) && (this.k != null))
    {
      localView.setVisibility(0);
      this.l.setVisibility(8);
      this.k.setVisibility(0);
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showLoadingContainer");
      return;
    }
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showLoadingContainer error");
  }
  
  public void f()
  {
    View localView = this.j;
    if ((localView != null) && (this.l != null) && (this.k != null))
    {
      if (localView.getVisibility() != 0) {
        return;
      }
      this.l.setVisibility(0);
      this.k.setVisibility(8);
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showLoadingError");
      return;
    }
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showLoadingError error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.web.endcrad.GdtMVEndcardWebController
 * JD-Core Version:    0.7.0.1
 */