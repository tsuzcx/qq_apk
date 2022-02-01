package com.tencent.mobileqq.browser;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.BrowserOpenConfProcessorKt;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.pm.PackageUtil;
import com.tencent.widget.XListView;

public class BrowserDialogViewModel
  implements View.OnClickListener
{
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final DraggablePopup jdField_a_of_type_ComTencentMobileqqBrowserDraggablePopup;
  private final RecommendBrowserAdapter jdField_a_of_type_ComTencentMobileqqBrowserRecommendBrowserAdapter;
  private final String jdField_a_of_type_JavaLangString;
  
  private BrowserDialogViewModel(Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqBrowserRecommendBrowserAdapter = new RecommendBrowserAdapter(paramActivity);
    paramActivity = BrowserUtilKt.a(paramActivity, BrowserOpenConfProcessorKt.a());
    this.jdField_a_of_type_ComTencentMobileqqBrowserRecommendBrowserAdapter.a(paramActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqBrowserDraggablePopup = DraggablePopup.a(this.jdField_a_of_type_AndroidAppActivity, -1, -1);
    c();
  }
  
  private static int a(BrowserItem paramBrowserItem)
  {
    if (paramBrowserItem.a()) {
      return 2;
    }
    return 1;
  }
  
  public static String a(String paramString)
  {
    paramString = (String)SharedPreUtils.a(BaseApplicationImpl.context, paramString, "key_selected_browser_name", "");
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, new Object[] { "[sp] getSpSelectedBrowserPackage: invoked. ", " pkg: ", paramString });
    }
    return paramString;
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    String str = a(paramString2);
    paramString2 = str;
    if (!TextUtils.isEmpty(str))
    {
      paramString2 = str;
      if (!PackageUtil.a(BaseApplication.context, str))
      {
        a(BrowserUtilKt.a(), "");
        paramString2 = "";
      }
    }
    if (TextUtils.isEmpty(paramString2))
    {
      new BrowserDialogViewModel(paramActivity, paramString1).b();
      return;
    }
    BrowserUtilKt.a(paramActivity, paramString1, paramString2);
  }
  
  private void a(BrowserItem paramBrowserItem)
  {
    Object localObject = BaseApplication.context.getResources();
    BrowserDialogViewModel.1 local1 = new BrowserDialogViewModel.1(this, paramBrowserItem);
    BrowserDialogViewModel.2 local2 = new BrowserDialogViewModel.2(this);
    localObject = String.format(((Resources)localObject).getString(2131690699), new Object[] { paramBrowserItem.a() });
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, (String)localObject, local1, local2).show();
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, new Object[] { "[dialog] showDownloadBrowserConfirmDialog: invoked. ", " browser: ", paramBrowserItem });
    }
    ReportHelperKt.a("0X800ADEE");
  }
  
  private static void a(String paramString1, String paramString2)
  {
    SharedPreUtils.a(BaseApplicationImpl.context, paramString1, true, "key_selected_browser_name", paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, new Object[] { "[sp] saveSpSelectedBrowserPackage: invoked. ", " pkg: ", paramString2 });
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBrowserRecommendBrowserAdapter.getCount() <= 0)
    {
      QRUtils.a(1, 2131695222);
      if (QLog.isColorLevel()) {
        QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, "[error] showPopupWindow: invoked. [没有任何浏览器时，对齐旧的错误toast]");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBrowserDraggablePopup.a();
    if (localObject != null) {
      ((XListView)localObject).setAdapter(this.jdField_a_of_type_ComTencentMobileqqBrowserRecommendBrowserAdapter);
    }
    localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setDimAmount(0.5F);
      this.jdField_a_of_type_ComTencentMobileqqBrowserDraggablePopup.showAtLocation(((Window)localObject).getDecorView(), 80, 0, 0);
    }
    ReportHelperKt.a("0X800ADEA");
  }
  
  private void c()
  {
    Button localButton = this.jdField_a_of_type_ComTencentMobileqqBrowserDraggablePopup.a();
    if (localButton != null) {
      localButton.setOnClickListener(this);
    }
    localButton = this.jdField_a_of_type_ComTencentMobileqqBrowserDraggablePopup.b();
    if (localButton != null) {
      localButton.setOnClickListener(this);
    }
  }
  
  private void d()
  {
    e();
    BrowserItem localBrowserItem = this.jdField_a_of_type_ComTencentMobileqqBrowserRecommendBrowserAdapter.a();
    if (localBrowserItem != null)
    {
      a(BrowserUtilKt.a(), localBrowserItem.e());
      ReportHelperKt.a("0X800ADED", a(localBrowserItem), "", localBrowserItem.a());
    }
  }
  
  private void e()
  {
    a();
    BrowserItem localBrowserItem = this.jdField_a_of_type_ComTencentMobileqqBrowserRecommendBrowserAdapter.a();
    if (localBrowserItem == null) {
      return;
    }
    if (localBrowserItem.a()) {
      BrowserUtilKt.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, localBrowserItem.e());
    } else if (PackageUtil.a(BaseApplication.context, localBrowserItem.e())) {
      BrowserUtilKt.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, localBrowserItem.e());
    } else {
      a(localBrowserItem);
    }
    QLog.d("[BrowserOpt] BrowserDialogViewModel", 1, new Object[] { "[action] onAnyButtonClicked: invoked. ", " browser: ", localBrowserItem });
  }
  
  private void f()
  {
    e();
    BrowserItem localBrowserItem = this.jdField_a_of_type_ComTencentMobileqqBrowserRecommendBrowserAdapter.a();
    if (localBrowserItem != null) {
      ReportHelperKt.a("0X800ADEC", a(localBrowserItem), "", localBrowserItem.a());
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBrowserDraggablePopup.isShowing()) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqBrowserDraggablePopup.dismiss();
      }
      catch (Exception localException)
      {
        QLog.e("[BrowserOpt] BrowserDialogViewModel", 1, "dismissPopupWindow: failed. ", localException);
      }
    }
    RecommendBrowserAdapter localRecommendBrowserAdapter = this.jdField_a_of_type_ComTencentMobileqqBrowserRecommendBrowserAdapter;
    if (localRecommendBrowserAdapter != null) {
      localRecommendBrowserAdapter.a();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362668) {
      d();
    } else if (paramView.getId() == 2131372089) {
      f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.browser.BrowserDialogViewModel
 * JD-Core Version:    0.7.0.1
 */