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
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.inject.GdtWebViewProxy;
import com.tencent.gdtad.inject.IGdtWebView;
import com.tencent.mobileqq.apollo.game.process.video.api.ICmGameVideoPlayer;
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
  public long a;
  public Handler a;
  public View a;
  public FrameLayout a;
  public TouchWebView a;
  public GdtMotiveVideoModel a;
  public IOnWebBottomCardCallback a;
  public GdtWebViewProxy a;
  public IGdtWebView a;
  public Runnable a;
  public ArrayList<View> a;
  public boolean a;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  private final String jdField_e_of_type_JavaLangString = "GdtMVWebBottomCardController";
  private boolean jdField_e_of_type_Boolean;
  
  public GdtMVWebBottomCardController(IOnWebBottomCardCallback paramIOnWebBottomCardCallback, Handler paramHandler)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new GdtMVWebBottomCardController.1(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentGdtadInjectGdtWebViewProxy = new GdtWebViewProxy();
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradIOnWebBottomCardCallback = paramIOnWebBottomCardCallback;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  private void a(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    }
  }
  
  private void g()
  {
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131363716));
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131362177));
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131362150));
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131362169));
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131362086));
    a(this.jdField_a_of_type_AndroidViewView.findViewById(2131362145));
    h();
  }
  
  private void h()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      GdtMotiveVideoModel localGdtMotiveVideoModel = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel;
      if (localGdtMotiveVideoModel != null)
      {
        if (localGdtMotiveVideoModel.a() == null) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a().isHitDownloadLayer()) {
          a(this.jdField_a_of_type_AndroidViewView.findViewById(2131367572));
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
    int i = paramICmGameVideoPlayer.getStatus();
    if (i <= 3) {
      return "PLAYING";
    }
    if (i == 4) {
      return jdField_a_of_type_JavaLangString;
    }
    return jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtMVWebBottomCardController", 2, "showWebBottomCard");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((View)this.jdField_a_of_type_JavaUtilArrayList.get(i)).setVisibility(4);
      i += 1;
    }
    GdtADFlyingStreamingReportHelper.a().a(1);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      QLog.i("GdtMVWebBottomCardController", 1, "addWebBottomCardUrlParams url is null");
      return;
    }
    this.jdField_c_of_type_JavaLangString = URLUtil.a(this.jdField_c_of_type_JavaLangString, "width", String.valueOf(paramInt1));
    this.jdField_c_of_type_JavaLangString = URLUtil.a(this.jdField_c_of_type_JavaLangString, "height", String.valueOf(paramInt2));
    String str = this.jdField_c_of_type_JavaLangString;
    if (paramBoolean) {
      localObject = "vertical";
    } else {
      localObject = "horizontal";
    }
    this.jdField_c_of_type_JavaLangString = URLUtil.a(str, "direction", (String)localObject);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("encoded Url :");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
    QLog.d("GdtMVWebBottomCardController", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GdtMVWebBottomCardController", 2, "showNativeBottomCard");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if ((!paramBoolean) || (!this.jdField_e_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a().isHitDownloadLayer()) || (2131367572 != ((View)this.jdField_a_of_type_JavaUtilArrayList.get(i)).getId())) {
        ((View)this.jdField_a_of_type_JavaUtilArrayList.get(i)).setVisibility(0);
      }
      i += 1;
    }
    e();
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localTouchWebView == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
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
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(paramActivity);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView = this.jdField_a_of_type_ComTencentGdtadInjectGdtWebViewProxy.a();
      if (this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView != null)
      {
        this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView.a(paramActivity, paramActivity, null, localAppInterface, new GdtMVWebBottomCardController.2(this));
        this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
        this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView.a(null);
        this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView.a(null, localAppInterface, null);
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramActivity = new StringBuilder();
      paramActivity.append("initWebView url = ");
      paramActivity.append(this.jdField_c_of_type_JavaLangString);
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
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131381060));
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
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
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_JavaLangString = localGdtMotiveVideoPageData.bottomCardUrl;
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel = paramGdtMotiveVideoModel;
    this.jdField_a_of_type_Long = localGdtMotiveVideoPageData.bottomCardLoadTime;
    this.jdField_d_of_type_JavaLangString = localGdtMotiveVideoPageData.traceId;
    a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a().getImageWidth(), this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a().getImageHeight(), paramBoolean);
    this.jdField_a_of_type_AndroidViewView = paramView;
    g();
    return a(paramActivity);
  }
  
  public void b()
  {
    QLog.i("GdtMVWebBottomCardController", 1, "onLoadFail");
    this.jdField_b_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradIOnWebBottomCardCallback;
    if (localObject != null) {
      ((IOnWebBottomCardCallback)localObject).a();
    }
  }
  
  public void c()
  {
    QLog.i("GdtMVWebBottomCardController", 1, "onLoadSuccess");
    IOnWebBottomCardCallback localIOnWebBottomCardCallback = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoWebBottomcradIOnWebBottomCardCallback;
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
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView != null)
      {
        this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView.c();
        this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView = null;
      }
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
      {
        ViewParent localViewParent = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent();
        if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
          ((ViewGroup)localViewParent).removeAllViewsInLayout();
        }
        this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
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
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Long <= 0L) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject != null)
    {
      ((TouchWebView)localObject).loadUrl(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject != null) {
        ((Handler)localObject).postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long * 1000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.web.bottomcrad.GdtMVWebBottomCardController
 * JD-Core Version:    0.7.0.1
 */