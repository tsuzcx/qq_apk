package com.tencent.mobileqq.apollo.game.process.ui;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.CustomerLoadingDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class CmGameDialog
  extends NativeUIComponent
{
  private CustomerLoadingDialog jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  int a(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    return 0;
  }
  
  public String a()
  {
    return "Dialog";
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog;
    if (localObject != null)
    {
      ((CustomerLoadingDialog)localObject).dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog = null;
    }
  }
  
  public void a(NativeUIManager paramNativeUIManager)
  {
    CustomerLoadingDialog localCustomerLoadingDialog = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog;
    if (localCustomerLoadingDialog != null)
    {
      localCustomerLoadingDialog.hide();
      if (paramNativeUIManager != null) {
        paramNativeUIManager.a(a(), "sc.xy_loading_hide_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString, int paramInt, NativeUIManager paramNativeUIManager)
  {
    int j = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null)
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = 1500;
      }
      localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      j = i;
      if (localObject != null)
      {
        localObject = (Context)((WeakReference)localObject).get();
        j = i;
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a((Context)localObject, paramString, i);
          j = i;
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
    paramInt = 1;
    if (localObject != null)
    {
      if (j <= 2000) {
        paramInt = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
      if (paramNativeUIManager != null) {
        paramNativeUIManager.a(a(), "sc.xy_toast_show_complete.local", "{}");
      }
    }
    else
    {
      QLog.e("[cmshow]CmGameDialog", 1, "no toast");
    }
  }
  
  public void a(String paramString, NativeUIManager paramNativeUIManager)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog == null)
    {
      localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (Context)((WeakReference)localObject).get();
        if ((localObject != null) && ((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog = new CustomerLoadingDialog((Context)localObject, paramString);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog;
    if (localObject != null)
    {
      if (((CustomerLoadingDialog)localObject).isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog.hide();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog.a(2131371534);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setText(paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog.setOnKeyListener(new CmGameDialog.2(this, paramNativeUIManager));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog.show();
      if (paramNativeUIManager != null) {
        paramNativeUIManager.a(a(), "sc.xy_loading_show_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString1, String paramString2, NativeUIManager paramNativeUIManager)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      String str = paramString2.optString("action");
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localContext != null) && ((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing()))
        {
          ((Activity)localContext).runOnUiThread(new CmGameDialog.1(this, paramString1, str, paramNativeUIManager, paramString2));
          return;
        }
      }
    }
    catch (Throwable paramString2)
    {
      if (paramNativeUIManager != null) {
        paramNativeUIManager.a(a(), paramString1, paramString2.getMessage());
      }
      QLog.e("[cmshow]CmGameDialog", 1, paramString2, new Object[0]);
    }
  }
  
  public void b()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.hide();
    }
  }
  
  public void b(NativeUIManager paramNativeUIManager)
  {
    QQToast localQQToast = this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
    if (localQQToast != null)
    {
      localQQToast.d(0);
      if (paramNativeUIManager != null) {
        paramNativeUIManager.a(a(), "sc.xy_toast_hide_complete.local", "{}");
      }
    }
  }
  
  public void b(String paramString1, String paramString2, NativeUIManager paramNativeUIManager)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (Context)((WeakReference)localObject).get();
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a((Context)localObject, 230, paramString1, paramString2, new CmGameDialog.3(this, paramNativeUIManager), new CmGameDialog.4(this, paramNativeUIManager));
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      if (((QQCustomDialog)localObject).isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.hide();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new CmGameDialog.5(this, paramNativeUIManager));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(paramString1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      if (paramNativeUIManager != null) {
        paramNativeUIManager.a(a(), "sc.xy_alert_show_complete.local", "{\"confirm\":1}");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.ui.CmGameDialog
 * JD-Core Version:    0.7.0.1
 */