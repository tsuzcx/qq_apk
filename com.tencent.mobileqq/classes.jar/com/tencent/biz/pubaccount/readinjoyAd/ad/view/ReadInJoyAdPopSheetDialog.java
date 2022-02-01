package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
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
import com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdPopSheetDialog;
import com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdPopSheetDialog.OnPopSheetDismissListener;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoyAdPopSheetDialog
  extends IRIJAdPopSheetDialog
  implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener
{
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog";
  private long jdField_a_of_type_Long = 0L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private GdtWebViewBuilder jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder;
  private IRIJAdPopSheetDialog.OnPopSheetDismissListener jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdPopSheetDialog$OnPopSheetDismissListener;
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
    super(paramActivity, 2131756189);
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
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("&acttype=9000&rsptype=1");
      localObject1 = ((StringBuilder)localObject1).toString();
      long l = SystemClock.currentThreadTimeMillis();
      localObject2 = "";
      localObject3 = new Bundle();
      localObject1 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), (String)localObject1, "GET", null, (Bundle)localObject3);
      if (localObject1 != null)
      {
        localObject1 = new String((byte[])localObject1);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "loadForm result = ", localObject1 });
        }
        localObject1 = new JSONObject((String)localObject1);
        int i = ((JSONObject)localObject1).getInt("ret");
        if (i == 0)
        {
          localObject3 = ((JSONObject)localObject1).getJSONObject("data");
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject2 = ((JSONObject)localObject3).optString("clickid");
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              localObject1 = jdField_a_of_type_JavaLangString;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("loadForm clickid = ");
              ((StringBuilder)localObject3).append((String)localObject2);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
              localObject1 = localObject2;
            }
          }
        }
        else
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = jdField_a_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("retCode = ");
            ((StringBuilder)localObject3).append(i);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { Integer.valueOf(2), "requestAdData bytes null" });
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.d;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("loadForm: get click id costTime=");
        ((StringBuilder)localObject3).append(SystemClock.currentThreadTimeMillis() - l);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("&click_id=");
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
      ThreadManager.getUIHandler().post(new ReadInJoyAdPopSheetDialog.3(this, (String)localObject1));
      return;
    }
    catch (Exception localException)
    {
      Object localObject2;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("loadForm exception:");
        ((StringBuilder)localObject3).append(localException.getMessage());
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
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
    View localView = getLayoutInflater().inflate(2131560067, null);
    ((RelativeLayout)localView.findViewById(2131372943)).setOnClickListener(new ReadInJoyAdPopSheetDialog.4(this));
    localView.setOnClickListener(new ReadInJoyAdPopSheetDialog.5(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)localView.findViewById(2131373133));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController = new WebViewProgressBarController();
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131372946));
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper = new SoftKeyboardStateHelper(localView);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131372944));
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper.a(new ReadInJoyAdPopSheetDialog.6(this, (RelativeLayout.LayoutParams)localObject));
    setOnDismissListener(this);
    setOnShowListener(this);
    localObject = BaseApplicationImpl.getContext();
    int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
    int j = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
    double d1 = i;
    Double.isNaN(d1);
    int k = (int)(d1 * 0.85D);
    localObject = (RelativeLayout)localView.findViewById(2131372944);
    if (localObject != null)
    {
      localObject = ((RelativeLayout)localObject).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = k;
      ((ViewGroup.LayoutParams)localObject).height = k;
    }
    setContentView(localView);
    getWindow().setLayout(i, j);
  }
  
  public void a(IRIJAdPopSheetDialog.OnPopSheetDismissListener paramOnPopSheetDismissListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdPopSheetDialog$OnPopSheetDismissListener = paramOnPopSheetDismissListener;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel())
    {
      paramDialogInterface = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDismiss h5Url = ");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      QLog.d(paramDialogInterface, 2, localStringBuilder.toString());
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder;
    if (paramDialogInterface != null)
    {
      paramDialogInterface.c();
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtWebViewBuilder = null;
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRIJAdPopSheetDialog$OnPopSheetDismissListener;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel())
    {
      paramDialogInterface = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShow h5Url = ");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      QLog.d(paramDialogInterface, 2, localStringBuilder.toString());
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
    if (paramDialogInterface != null) {
      paramDialogInterface.setVisibility(0);
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
    if (paramDialogInterface != null) {
      paramDialogInterface.a((byte)0);
    }
    paramDialogInterface = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (paramDialogInterface != null) {
      paramDialogInterface.setVisibility(4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog
 * JD-Core Version:    0.7.0.1
 */