package com.tencent.gdtad.views.videoimax;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.statistics.canvas.AdTimeStatistics;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtActionReporter;
import com.tencent.gdtad.statistics.GdtActionReporter.Params;
import com.tencent.gdtad.statistics.GdtTraceReporter;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuPresenter;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoCommonView.VideoListener;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qzone.util.SystemUtil;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class GdtVideoImaxFragment
  extends PublicBaseFragment
{
  protected AdTimeStatistics a = new AdTimeStatistics();
  private GdtImaxData b;
  private boolean c;
  private GdtVideoCommonView d;
  private TouchWebView e;
  private GdtWebViewBuilder f;
  private FrameLayout g;
  private GdtVideoCeilingTitleBar h;
  private GdtVideoCeilingLandView i;
  private GdtDanmakuPresenter j;
  private RelativeLayout k;
  private URLImageView l;
  private TextView m;
  private View n;
  private Button o;
  private ResultReceiver p;
  private GdtVideoCommonView.VideoListener q = new GdtVideoImaxFragment.1(this);
  private View r;
  private AdTimeStatistics s = new AdTimeStatistics();
  private boolean t = false;
  private Handler u = new Handler(Looper.getMainLooper());
  private Runnable v = new GdtVideoImaxFragment.2(this);
  private View.OnClickListener w = new GdtVideoImaxFragment.3(this);
  
  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showWebView() called with: total = [");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], from = [");
    ((StringBuilder)localObject).append(paramFloat1);
    ((StringBuilder)localObject).append("], to = [");
    ((StringBuilder)localObject).append(paramFloat2);
    ((StringBuilder)localObject).append("]");
    GdtLog.a("GdtVideoImaxFragment", ((StringBuilder)localObject).toString());
    localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).setDuration(250L);
    ((ValueAnimator)localObject).addUpdateListener(new GdtVideoImaxFragment.4(this, paramFloat1, paramFloat2, paramInt));
    ((ValueAnimator)localObject).start();
    ((ViewGroup)getBaseActivity().getWindow().getDecorView()).setSystemUiVisibility(7942);
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportLoadTimeForAction() called with: time = [");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], success = [");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("]");
    GdtLog.a("GdtVideoImaxFragment", ((StringBuilder)localObject).toString());
    localObject = new GdtActionReporter.Params();
    ((GdtActionReporter.Params)localObject).a = this.b.getAd();
    PBUInt32Field localPBUInt32Field = ((GdtActionReporter.Params)localObject).b.landing_page_action_type;
    int i1;
    if (paramBoolean) {
      i1 = 3;
    } else {
      i1 = 4;
    }
    localPBUInt32Field.set(i1);
    ((GdtActionReporter.Params)localObject).b.latency_ms.set(paramLong);
    GdtActionReporter.a((GdtActionReporter.Params)localObject);
  }
  
  private void a(GdtVideoCommonView paramGdtVideoCommonView, GdtVideoData paramGdtVideoData)
  {
    paramGdtVideoCommonView.setData(paramGdtVideoData);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramGdtVideoCommonView.getLayoutParams();
    paramGdtVideoData = GdtUIUtils.a(getBaseActivity());
    localMarginLayoutParams.height = paramGdtVideoData[1];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bindVideo() called with: width = [");
    localStringBuilder.append(localMarginLayoutParams.width);
    localStringBuilder.append("], height = [");
    localStringBuilder.append(localMarginLayoutParams.height);
    localStringBuilder.append("]");
    GdtLog.a("GdtVideoImaxFragment", localStringBuilder.toString());
    localMarginLayoutParams.leftMargin = (getResources().getDisplayMetrics().widthPixels - 1);
    paramGdtVideoCommonView.setLayoutParams(localMarginLayoutParams);
    this.r = getView().findViewById(2131433308);
    localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.r.getLayoutParams();
    localMarginLayoutParams.height = paramGdtVideoData[1];
    this.r.setLayoutParams(localMarginLayoutParams);
    paramGdtVideoData = (RelativeLayout.LayoutParams)((RelativeLayout)paramGdtVideoCommonView.findViewById(2131430806)).getLayoutParams();
    paramGdtVideoData.addRule(9, 0);
    paramGdtVideoData.addRule(11);
    paramGdtVideoData = (ImageView)paramGdtVideoCommonView.findViewById(2131436322);
    paramGdtVideoData.setImageResource(2130840553);
    paramGdtVideoData = (RelativeLayout.LayoutParams)paramGdtVideoData.getLayoutParams();
    paramGdtVideoData.addRule(11);
    paramGdtVideoData.width = -2;
    paramGdtVideoData.leftMargin = 0;
    paramGdtVideoData.rightMargin = GdtUIUtils.a(15.0F, getResources());
    paramGdtVideoCommonView.a(this.q);
  }
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWebViewLoadFinish() called with: success = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    GdtLog.a("GdtVideoImaxFragment", localStringBuilder.toString());
    if (!this.t)
    {
      this.t = true;
      this.a.stop();
      a(this.a.getTime(), paramBoolean);
    }
  }
  
  private void b()
  {
    this.u.postDelayed(this.v, 500L);
  }
  
  private void b(View paramView)
  {
    paramView.findViewById(2131436259).setVisibility(8);
    this.k = ((RelativeLayout)paramView.findViewById(2131444908));
    this.k.setVisibility(0);
    this.l = ((URLImageView)paramView.findViewById(2131435568));
    this.m = ((TextView)paramView.findViewById(2131448253));
    this.o = ((Button)paramView.findViewById(2131427860));
    paramView = this.b;
    if ((paramView != null) && (paramView.getAd() != null))
    {
      if (!TextUtils.isEmpty(this.b.getAd().getAdvertiser_corporate_logo()))
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = ImageUtil.j();
        paramView.mLoadingDrawable = localDrawable;
        paramView.mFailedDrawable = localDrawable;
        paramView = URLDrawable.getDrawable(this.b.getAd().getAdvertiser_corporate_logo(), paramView);
        paramView.setDecodeHandler(URLDrawableDecodeHandler.b);
        paramView.setFadeInImage(true);
        this.l.setImageDrawable(paramView);
      }
      this.m.setText(this.b.getAd().getAdvertiser_corporate_image_name());
      g();
    }
    this.l.setOnClickListener(this.w);
    this.m.setOnClickListener(this.w);
    this.o.setOnClickListener(this.w);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (((GdtImaxData)localObject1).getAd() != null))
    {
      if (this.b.getAd().info == null) {
        return;
      }
      try
      {
        Object localObject2 = getBaseActivity();
        localObject1 = localObject2;
        if ((localObject2 instanceof BasePluginActivity)) {
          localObject1 = ((BasePluginActivity)localObject2).getOutActivity();
        }
        localObject2 = new GdtHandler.Params();
        ((GdtHandler.Params)localObject2).q = 7;
        ((GdtHandler.Params)localObject2).r = new WeakReference((Activity)localObject1);
        ((GdtHandler.Params)localObject2).a = new GdtAd(this.b.getAd().info);
        ((GdtHandler.Params)localObject2).b = false;
        ((GdtHandler.Params)localObject2).e = paramBoolean;
        ((GdtHandler.Params)localObject2).i = false;
        ((GdtHandler.Params)localObject2).p = new Bundle();
        ((GdtHandler.Params)localObject2).s = new WeakReference(new GdtAppReceiver());
        ((GdtHandler.Params)localObject2).p.putString("big_brother_ref_source_key", "biz_src_jc_qzone");
        GdtHandler.a((GdtHandler.Params)localObject2);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void c()
  {
    GdtLog.a("GdtVideoImaxFragment", "startPlay() called");
    this.d.b();
  }
  
  private void d()
  {
    GdtLog.a("GdtVideoImaxFragment", "setPreviewImageVisible() called");
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.d.getLayoutParams();
    localMarginLayoutParams.leftMargin = 0;
    this.d.setLayoutParams(localMarginLayoutParams);
  }
  
  private boolean e()
  {
    Object localObject = this.j;
    if (localObject == null) {
      return false;
    }
    if (((GdtDanmakuPresenter)localObject).c())
    {
      this.j.setVisibility(0);
      return true;
    }
    localObject = this.b.getDanmakuContents();
    if ((localObject != null) && (localObject.length != 0))
    {
      this.j.setOnClickListener(this.w);
      this.j.a(AdUIUtils.getScreenWidth(getContext()), (String[])localObject);
      if (this.j.a())
      {
        this.j.setVisibility(0);
        return true;
      }
      this.j.setVisibility(8);
      QLog.i("GdtVideoImaxFragment", 4, "mDanmakuPresenter cannot start");
      return true;
    }
    this.j.setVisibility(8);
    return false;
  }
  
  private void f()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((GdtImaxData)localObject).getAd() != null))
    {
      if (!this.b.getAd().isValid()) {
        return;
      }
      localObject = this.b.getAd();
      GdtPreLoader.a().a((GdtAd)localObject);
    }
  }
  
  private void g()
  {
    if (this.o == null) {
      return;
    }
    GdtImaxData localGdtImaxData = this.b;
    if ((localGdtImaxData != null) && (localGdtImaxData.getAd() != null) && (this.b.getAd().getProductType() == 12))
    {
      if (AdAppUtil.isInstalled(getBaseActivity(), this.b.getAd().getAppPackageName()))
      {
        this.o.setText(HardCodeUtil.a(2131903215));
        return;
      }
      this.o.setText(HardCodeUtil.a(2131903214));
      return;
    }
    this.o.setText(HardCodeUtil.a(2131903209));
  }
  
  private void h()
  {
    GdtImaxData localGdtImaxData = this.b;
    if (localGdtImaxData != null)
    {
      if (localGdtImaxData.getAd() == null) {
        return;
      }
      GdtTraceReporter.a(this.b.getAd(), 280);
    }
  }
  
  private void i()
  {
    this.i.setIgnoreInterceptTouchEvent(true);
    this.i.setIgnoreTouchEvent(true);
  }
  
  private void j()
  {
    this.h.b();
    this.h.setAppName(this.b.getAd().getAppName());
    this.h.setStyle(1);
    this.h.a();
    if (SystemUtil.getNotchHeight(getBaseActivity(), getBaseActivity()) > 0)
    {
      this.n.setVisibility(0);
      ViewGroup.LayoutParams localLayoutParams = this.n.getLayoutParams();
      localLayoutParams.height = SystemUtil.getNotchHeight(getBaseActivity(), getBaseActivity());
      this.n.setLayoutParams(localLayoutParams);
    }
    this.h.setOnBtnClickListener(new GdtVideoImaxFragment.5(this));
  }
  
  private boolean k()
  {
    return this.i.getLayoutParams().height > 0;
  }
  
  private void l()
  {
    Object localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    BaseActivity localBaseActivity = getBaseActivity();
    this.e = new TouchWebView(localBaseActivity);
    this.g.addView(this.e);
    this.f = new GdtVideoImaxFragment.6(this, localBaseActivity, localBaseActivity, localBaseActivity.getIntent(), (AppInterface)localObject);
    this.f.a(this.e);
    new WebViewDirector(this.f).a(null, (AppRuntime)localObject, getBaseActivity().getIntent());
    localObject = this.i.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = 0;
    this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.b.getWebUrl();
    this.e.loadUrl((String)localObject);
    this.a.start();
  }
  
  private void m()
  {
    GdtLog.a("GdtVideoImaxFragment", "reportStayTimeForAction() called");
    GdtActionReporter.Params localParams = new GdtActionReporter.Params();
    localParams.a = this.b.getAd();
    localParams.b.landing_page_action_type.set(7);
    localParams.b.latency_ms.set(this.s.getTime());
    GdtActionReporter.a(localParams);
  }
  
  private void n()
  {
    GdtLog.a("GdtVideoImaxFragment", "onAnimationEnd() called");
    this.c = true;
    c();
    d();
    b();
  }
  
  public boolean a()
  {
    GdtLog.a("GdtVideoImaxFragment", "----back click");
    int i1 = this.b.getVideoSplicePageStyle();
    boolean bool = true;
    if ((i1 == 1) && (getBaseActivity() != null))
    {
      getBaseActivity().finish();
      return true;
    }
    String str;
    if (this.e.canGoBack())
    {
      this.e.goBack();
      str = " mWebView.goBack() result = true";
    }
    else if (k())
    {
      a(this.i.getLayoutParams().height, this.i.getLayoutParams().height, 0.0F);
      this.d.b();
      str = " webViewIsShowing result = true";
    }
    else if (getBaseActivity() != null)
    {
      getBaseActivity().finish();
      str = " getActivity().finish() result = true";
    }
    else
    {
      str = "";
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("----back return ");
    localStringBuilder.append(bool);
    localStringBuilder.append(str);
    GdtLog.a("GdtVideoImaxFragment", localStringBuilder.toString());
    return bool;
  }
  
  public boolean a(View paramView)
  {
    boolean bool = false;
    if (paramView == null)
    {
      QLog.i("GdtVideoImaxFragment", 1, "appAutoDownload() view is null");
      return false;
    }
    int i1 = paramView.getId();
    if ((i1 == 2131435568) || (i1 == 2131448253) || (i1 == 2131427860)) {
      bool = true;
    }
    paramView = new StringBuilder();
    paramView.append("appAutoDownload:");
    paramView.append(bool);
    QLog.i("GdtVideoImaxFragment", 1, paramView.toString());
    return bool;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(1);
    Window localWindow = paramActivity.getWindow();
    localWindow.addFlags(1024);
    ((ViewGroup)localWindow.getDecorView()).setSystemUiVisibility(7942);
    if (GdtUIUtils.b(paramActivity)) {
      GdtUIUtils.c(paramActivity);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    paramActivity = paramActivity.getIntent();
    this.b = ((GdtImaxData)paramActivity.getSerializableExtra("data"));
    this.p = ((ResultReceiver)paramActivity.getParcelableExtra("callback"));
    paramActivity = new Bundle();
    GdtVideoImaxFragment.MyResultReceiver localMyResultReceiver = new GdtVideoImaxFragment.MyResultReceiver(new Handler(Looper.getMainLooper()));
    localMyResultReceiver.a(this);
    ClassLoader localClassLoader = localMyResultReceiver.getClass().getClassLoader();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAttach() classLoader = [");
    localStringBuilder.append(localClassLoader);
    localStringBuilder.append("]");
    GdtLog.a("GdtVideoImaxFragment", localStringBuilder.toString());
    paramActivity.setClassLoader(localClassLoader);
    paramActivity.putParcelable("callback", localMyResultReceiver);
    this.p.send(0, paramActivity);
  }
  
  public boolean onBackEvent()
  {
    return a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131624955, paramViewGroup, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.d.h();
    if (this.b.getVideoSplicePageStyle() == 0)
    {
      this.f.c();
      localObject = this.e.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeAllViewsInLayout();
      }
    }
    Object localObject = this.j;
    if ((localObject != null) && (((GdtDanmakuPresenter)localObject).c()))
    {
      this.j.b();
      this.j = null;
    }
  }
  
  public void onDetach()
  {
    GdtImaxData localGdtImaxData = this.b;
    if ((localGdtImaxData != null) && (localGdtImaxData.getVideoSplicePageStyle() == 0)) {
      m();
    }
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    this.d.d();
    this.s.stop();
  }
  
  public void onResume()
  {
    super.onResume();
    this.d.f();
    this.s.start();
    g();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    f();
    this.d = ((GdtVideoCommonView)paramView.findViewById(2131449438));
    this.g = ((FrameLayout)paramView.findViewById(2131450086));
    this.h = ((GdtVideoCeilingTitleBar)paramView.findViewById(2131450083));
    this.n = paramView.findViewById(2131439403);
    this.i = ((GdtVideoCeilingLandView)paramView.findViewById(2131434066));
    this.j = ((GdtDanmakuPresenter)paramView.findViewById(2131435497));
    a(this.d, this.b.getVideoData());
    if (this.b.getVideoSplicePageStyle() == 1)
    {
      b(paramView);
    }
    else if (this.b.getVideoSplicePageStyle() == 0)
    {
      j();
      l();
    }
    i();
    if (this.b.isDanmakuAdv()) {
      e();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment
 * JD-Core Version:    0.7.0.1
 */