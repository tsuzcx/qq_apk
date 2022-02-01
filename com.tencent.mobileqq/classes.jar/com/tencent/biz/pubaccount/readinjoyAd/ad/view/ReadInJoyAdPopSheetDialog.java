package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoyAdPopSheetDialog
  extends ReportDialog
  implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener
{
  private static final String jdField_a_of_type_JavaLangString = ReadInJoyAdPopSheetDialog.class.getName();
  private long jdField_a_of_type_Long = 0L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ReadInJoyAdPopSheetDialog.OnPopSheetDismissListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdPopSheetDialog$OnPopSheetDismissListener;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private GdtWebViewBuilder jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder;
  private SoftKeyboardStateHelper jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper;
  private WebViewProgressBar jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private WebViewProgressBarController jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
  private long jdField_b_of_type_Long = 0L;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long = -1L;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  
  public ReadInJoyAdPopSheetDialog(Activity paramActivity)
  {
    super(paramActivity, 2131755842);
    b();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public ReadInJoyAdPopSheetDialog(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    this(paramActivity);
    if (paramString1 != null)
    {
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_c_of_type_JavaLangString = paramString2;
      this.d = paramString3;
    }
    this.jdField_b_of_type_Long = SystemClock.currentThreadTimeMillis();
  }
  
  public static ReadInJoyAdPopSheetDialog a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    return new ReadInJoyAdPopSheetDialog(paramActivity, paramString1, paramString2, paramString3);
  }
  
  private void a()
  {
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_c_of_type_JavaLangString + "&acttype=9000&rsptype=1";
        l = SystemClock.currentThreadTimeMillis();
        localObject3 = "";
        Object localObject4 = new Bundle();
        localObject1 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), (String)localObject1, "GET", null, (Bundle)localObject4);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = new String((byte[])localObject1);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "loadForm result = ", localObject1 });
        }
        localObject1 = new JSONObject((String)localObject1);
        i = ((JSONObject)localObject1).getInt("ret");
        if (i != 0) {
          continue;
        }
        localObject4 = ((JSONObject)localObject1).getJSONObject("data");
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject3 = ((JSONObject)localObject4).optString("clickid");
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "loadForm clickid = " + (String)localObject3);
            localObject1 = localObject3;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        long l;
        Object localObject3;
        int i;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "loadForm exception:" + localException.getMessage());
        return;
        Object localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { Integer.valueOf(2), "requestAdData bytes null" });
        localObject2 = localObject3;
        continue;
      }
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = this.d;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "loadForm: get click id costTime=" + (SystemClock.currentThreadTimeMillis() - l));
      }
      localObject1 = this.jdField_b_of_type_JavaLangString + "&click_id=" + (String)localObject3;
      ThreadManager.getUIHandler().post(new ReadInJoyAdPopSheetDialog.3(this, (String)localObject1));
      return;
      localObject1 = localObject3;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "retCode = " + i);
        localObject1 = localObject3;
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(paramActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView, new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder = new ReadInJoyAdPopSheetDialog.7(this, paramActivity.getApplicationContext(), paramActivity, null, localAppInterface);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    new WebViewDirector(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder).a(null, localAppInterface, null);
  }
  
  private void b()
  {
    View localView = getLayoutInflater().inflate(2131560180, null);
    ((RelativeLayout)localView.findViewById(2131373364)).setOnClickListener(new ReadInJoyAdPopSheetDialog.4(this));
    localView.setOnClickListener(new ReadInJoyAdPopSheetDialog.5(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)localView.findViewById(2131373555));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController = new WebViewProgressBarController();
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131373367));
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper = new SoftKeyboardStateHelper(localView);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131373365));
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper.a(new ReadInJoyAdPopSheetDialog.6(this, (RelativeLayout.LayoutParams)localObject));
    setOnDismissListener(this);
    setOnShowListener(this);
    localObject = BaseApplicationImpl.getContext();
    int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
    int j = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
    int k = (int)(i * 0.85D);
    int m = (int)(k * 0.72D);
    localObject = (RelativeLayout)localView.findViewById(2131373365);
    if (localObject != null)
    {
      localObject = ((RelativeLayout)localObject).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = k;
      ((ViewGroup.LayoutParams)localObject).height = k;
    }
    setContentView(localView);
    getWindow().setLayout(i, j);
  }
  
  public void a(ReadInJoyAdPopSheetDialog.OnPopSheetDismissListener paramOnPopSheetDismissListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdPopSheetDialog$OnPopSheetDismissListener = paramOnPopSheetDismissListener;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDismiss h5Url = " + this.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder != null)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder.c();
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdPopSheetDialog$OnPopSheetDismissListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdPopSheetDialog$OnPopSheetDismissListener.a();
    }
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onShow h5Url = " + this.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)0);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
    ThreadManager.excute(new ReadInJoyAdPopSheetDialog.2(this), 128, null, true);
  }
  
  public void show()
  {
    getWindow().setFlags(8, 8);
    super.show();
    getWindow().getDecorView().setSystemUiVisibility(2);
    getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new ReadInJoyAdPopSheetDialog.1(this));
    getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog
 * JD-Core Version:    0.7.0.1
 */