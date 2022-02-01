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
  public long a;
  public View a;
  public FrameLayout a;
  public TouchWebView a;
  public GdtMotiveVideoModel a;
  private final GdtMvElementsHelper jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsHelper = new GdtMvElementsHelper();
  public GdtThirdProcessorProxy a;
  public GdtWebViewProxy a;
  public IGdtWebView a;
  private Integer jdField_a_of_type_JavaLangInteger;
  public String a;
  private Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");
  public boolean a;
  private long b;
  public View b;
  public boolean b;
  public View c;
  public boolean c;
  private boolean d = false;
  
  public GdtMVEndcardWebController(GdtThirdProcessorProxy paramGdtThirdProcessorProxy)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentGdtadInjectGdtWebViewProxy = new GdtWebViewProxy();
    this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy = paramGdtThirdProcessorProxy;
  }
  
  private boolean a(WebView paramWebView, String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.startsWith("gdtmsg://e.qq.com/reportClickRewardAd/rewardAD/"))
      {
        if ((this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel != null) && (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a() != null) && (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a().getUrlForClick())))
        {
          Object localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a().getUrlForClick();
          this.jdField_a_of_type_ComTencentGdtadInjectGdtThirdProcessorProxy.a(1, 0, this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a());
          GdtReporter.doCgiReport((String)localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleSchema url= ");
          ((StringBuilder)localObject).append(paramString);
          QLog.i("EndCardWebGdtMVEndcardWebController", 1, ((StringBuilder)localObject).toString());
          this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoElementsGdtMvElementsHelper.a(paramWebView, paramString);
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
    this.jdField_b_of_type_Boolean = true;
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if ((localFrameLayout != null) && (localFrameLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public void a(long paramLong)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    long l = this.jdField_a_of_type_Long;
    if (l <= 0L) {
      return;
    }
    if (paramLong / 1000L > l) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preLoadUrl   ");
    localStringBuilder.append(paramLong);
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(Activity paramActivity, GdtMotiveVideoModel paramGdtMotiveVideoModel, boolean paramBoolean)
  {
    int j;
    int i;
    if ((paramActivity != null) && (paramGdtMotiveVideoModel != null) && (paramGdtMotiveVideoModel.a() != null))
    {
      j = paramGdtMotiveVideoModel.a().getEndcardDirection();
      if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      paramGdtMotiveVideoModel = new StringBuilder();
      paramGdtMotiveVideoModel.append("changeScreenOrientation endcard = ");
      paramGdtMotiveVideoModel.append(j);
      paramGdtMotiveVideoModel.append(",curr = ");
      paramGdtMotiveVideoModel.append(i);
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, paramGdtMotiveVideoModel.toString());
      if ((j != 1) && (j != 2)) {
        return;
      }
      if (j == i) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        d();
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramActivity.getRequestedOrientation());
        if (j != 1) {
          break label161;
        }
        i = 1;
        paramActivity.setRequestedOrientation(i);
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.e("EndCardWebGdtMVEndcardWebController", 1, "changeScreenOrientation", paramActivity);
        return;
      }
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "changeScreenOrientation error");
      return;
      label161:
      i = 0;
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
      {
        QLog.i("EndCardWebGdtMVEndcardWebController", 1, "fitSpecialScreen webview == null");
        return;
      }
      if (!paramBoolean)
      {
        QLog.i("EndCardWebGdtMVEndcardWebController", 1, "fitSpecialScreen !isPortait");
        return;
      }
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizUiTouchWebView.getLayoutParams();
      LiuHaiUtils.a(paramActivity);
      if (LiuHaiUtils.b())
      {
        ((FrameLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.b(paramActivity);
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367581);
    paramView = this.jdField_a_of_type_AndroidViewView;
    if (paramView == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "initLoadingContainer container == null");
      return;
    }
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131367582);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367583);
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131381066));
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
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
    this.jdField_a_of_type_JavaLangString = localGdtMotiveVideoPageData.endcardUrl;
    a(paramBoolean);
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel = paramGdtMotiveVideoModel;
    this.jdField_a_of_type_Long = localGdtMotiveVideoPageData.endcardLoadTime;
    a(paramView);
    try
    {
      paramGdtMotiveVideoModel = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(paramActivity);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView = this.jdField_a_of_type_ComTencentGdtadInjectGdtWebViewProxy.a();
      if (this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView != null)
      {
        this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView.a(paramActivity, paramActivity, null, paramGdtMotiveVideoModel, new GdtMVEndcardWebController.1(this));
        this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
        this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView.a(null);
        this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView.a(null, paramGdtMotiveVideoModel, null);
      }
      this.jdField_c_of_type_Boolean = true;
      a(paramActivity, paramBoolean);
      paramGdtMotiveVideoModel = new StringBuilder();
      paramGdtMotiveVideoModel.append("initWebView url = ");
      paramGdtMotiveVideoModel.append(this.jdField_a_of_type_JavaLangString);
      paramGdtMotiveVideoModel.append(",time = ");
      paramGdtMotiveVideoModel.append(this.jdField_a_of_type_Long);
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
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1;
    if (paramBoolean) {
      str1 = "vertical";
    } else {
      str1 = "horizontal";
    }
    this.jdField_a_of_type_JavaLangString = URLUtil.a(str2, "direction", str1);
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
    {
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
      if ((localObject != null) && (((TouchWebView)localObject).canGoBack()))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
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
  
  public boolean a(Activity paramActivity, GdtMotiveVideoModel paramGdtMotiveVideoModel, boolean paramBoolean)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb !mHasInit");
      return false;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb mHasError");
      return false;
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb mWebViewContainer == null");
      return false;
    }
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showEndCardWeb");
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
    }
    a(paramActivity, paramGdtMotiveVideoModel, paramBoolean);
    return true;
  }
  
  public void b()
  {
    IGdtWebView localIGdtWebView = this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView;
    if (localIGdtWebView != null) {
      localIGdtWebView.a();
    }
  }
  
  public void b(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView != null)
      {
        this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView.c();
        this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView = null;
      }
      Object localObject;
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent();
        if ((localObject != null) && ((localObject instanceof ViewGroup))) {
          ((ViewGroup)localObject).removeAllViewsInLayout();
        }
        this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
      }
      if ((this.jdField_a_of_type_JavaLangInteger != null) && (paramBoolean) && (paramActivity != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDestroy setRequestedOrientation ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangInteger);
        QLog.i("EndCardWebGdtMVEndcardWebController", 1, ((StringBuilder)localObject).toString());
        paramActivity.setRequestedOrientation(this.jdField_a_of_type_JavaLangInteger.intValue());
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "onDestroy", paramActivity);
    }
  }
  
  public void c()
  {
    IGdtWebView localIGdtWebView = this.jdField_a_of_type_ComTencentGdtadInjectIGdtWebView;
    if (localIGdtWebView != null) {
      localIGdtWebView.b();
    }
  }
  
  public void d()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      localView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showLoadingContainer");
      return;
    }
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showLoadingContainer error");
  }
  
  public void e()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      if (localView.getVisibility() != 0) {
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showLoadingError");
      return;
    }
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, "showLoadingError error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.web.endcrad.GdtMVEndcardWebController
 * JD-Core Version:    0.7.0.1
 */