package com.tencent.gdtad.basics.motivebrowsing;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingExperimentReportHelper;", "Landroid/view/View$OnTouchListener;", "()V", "clickDownTime", "", "getClickDownTime", "()J", "setClickDownTime", "(J)V", "clickJSONObject", "Lorg/json/JSONObject;", "getClickJSONObject", "()Lorg/json/JSONObject;", "setClickJSONObject", "(Lorg/json/JSONObject;)V", "clickUpTime", "getClickUpTime", "setClickUpTime", "exposeRunnable", "Ljava/lang/Runnable;", "getExposeRunnable", "()Ljava/lang/Runnable;", "firstClickReport", "", "getFirstClickReport", "()Z", "setFirstClickReport", "(Z)V", "firstExposeReport", "getFirstExposeReport", "setFirstExposeReport", "model", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "getModel", "()Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "setModel", "(Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;)V", "reportCallback", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingExperimentReportHelper$ReportCallback;", "getReportCallback", "()Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingExperimentReportHelper$ReportCallback;", "setReportCallback", "(Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingExperimentReportHelper$ReportCallback;)V", "checkClickAction", "motionEvent", "Landroid/view/MotionEvent;", "checkExperiment", "url", "", "getClickReportUrl", "originalUrl", "initModel", "", "initReport", "webView", "Landroid/view/View;", "gdtMotiveVideoModel", "isExperiment", "onDestroy", "onTouch", "v", "event", "Companion", "ReportCallback", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingExperimentReportHelper
  implements View.OnTouchListener
{
  public static final GdtMotiveBrowsingExperimentReportHelper.Companion a = new GdtMotiveBrowsingExperimentReportHelper.Companion(null);
  @Nullable
  private GdtMotiveBrowsingExperimentReportHelper.ReportCallback b;
  @Nullable
  private GdtMotiveVideoModel c;
  private boolean d = true;
  @NotNull
  private final Runnable e = (Runnable)new GdtMotiveBrowsingExperimentReportHelper.exposeRunnable.1(this);
  private boolean f = true;
  private long g;
  private long h;
  @Nullable
  private JSONObject i;
  
  @Nullable
  public final GdtMotiveBrowsingExperimentReportHelper.ReportCallback a()
  {
    return this.b;
  }
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "originalUrl");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&s=");
    localStringBuilder.append(URLEncoder.encode(String.valueOf(this.i)));
    return localStringBuilder.toString();
  }
  
  public final void a(@Nullable View paramView, @Nullable GdtMotiveVideoModel paramGdtMotiveVideoModel, @Nullable GdtMotiveBrowsingExperimentReportHelper.ReportCallback paramReportCallback)
  {
    if (!this.d) {
      return;
    }
    a(paramGdtMotiveVideoModel);
    if (!c()) {
      return;
    }
    if (paramView != null) {
      paramView.setOnTouchListener((View.OnTouchListener)this);
    }
    this.b = paramReportCallback;
    ThreadManager.getUIHandler().postDelayed((Runnable)new GdtMotiveBrowsingExperimentReportHelper.initReport.1(this, paramReportCallback), 1000L);
    this.d = false;
  }
  
  public final void a(@Nullable GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    this.c = paramGdtMotiveVideoModel;
  }
  
  public final boolean a(@Nullable MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null)
    {
      int j = paramMotionEvent.getAction();
      if (j != 0)
      {
        if (j == 1)
        {
          this.h = System.currentTimeMillis();
          return true;
        }
      }
      else {
        this.g = System.currentTimeMillis();
      }
    }
    return false;
  }
  
  @Nullable
  public final GdtMotiveVideoModel b()
  {
    return this.c;
  }
  
  public final boolean c()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((GdtMotiveVideoModel)localObject).d();
      if ((localObject != null) && (((GdtAd)localObject).isMotiveBrowserStatisticsExperiment() == true)) {
        return true;
      }
    }
    return false;
  }
  
  public final void d()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.e);
  }
  
  public boolean onTouch(@Nullable View paramView, @Nullable MotionEvent paramMotionEvent)
  {
    if (!this.f) {
      return false;
    }
    if (a(paramMotionEvent))
    {
      GdtLog.b("GdtMotiveBrowsingExperimentReportHelper", "report click");
      paramView = new JSONObject();
      try
      {
        long l = Math.abs(this.h - this.g);
        BaseApplication localBaseApplication = BaseApplication.context;
        Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "context");
        Object localObject = localBaseApplication.getResources();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources");
        localObject = ((Resources)localObject).getDisplayMetrics();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.displayMetrics");
        int m = ScreenUtil.getInstantScreenWidth((Context)localBaseApplication);
        int j = ScreenUtil.getInstantScreenHeight((Context)localBaseApplication);
        int k = ScreenUtil.getNavigationBarHeight((Context)localBaseApplication);
        m = DisplayUtil.b((Context)localBaseApplication, m);
        j = DisplayUtil.b((Context)localBaseApplication, j + k);
        paramView.put("da", String.valueOf(m));
        paramView.put("db", String.valueOf(j));
        paramView.put("px", String.valueOf(0));
        paramView.put("py", String.valueOf(0));
        paramView.put("sh", DisplayUtil.b((Context)localBaseApplication, ((DisplayMetrics)localObject).heightPixels));
        paramView.put("sw", DisplayUtil.b((Context)localBaseApplication, ((DisplayMetrics)localObject).widthPixels));
        if (paramMotionEvent != null)
        {
          paramView.put("aa", String.valueOf(DisplayUtil.b((Context)localBaseApplication, paramMotionEvent.getRawX())));
          paramView.put("ab", String.valueOf(DisplayUtil.b((Context)localBaseApplication, paramMotionEvent.getRawY())));
        }
        paramView.put("g", String.valueOf(l));
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("按下间隔:");
        paramMotionEvent.append(l);
        paramMotionEvent.append(" ; 上报内容:");
        paramMotionEvent.append(paramView.toString());
        GdtLog.b("GdtMotiveBrowsingExperimentReportHelper", paramMotionEvent.toString());
      }
      catch (Exception paramMotionEvent)
      {
        GdtLog.d("GdtMotiveBrowsingExperimentReportHelper", "getReportString error", (Throwable)paramMotionEvent);
      }
      this.i = paramView;
      paramView = this.b;
      if (paramView != null) {
        paramView.a("gdtmsg://e.qq.com/reportClickRewardAd/rewardAD/", this.c);
      }
      this.f = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingExperimentReportHelper
 * JD-Core Version:    0.7.0.1
 */