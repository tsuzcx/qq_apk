package com.tencent.mobileqq.activity.phone;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import wrh;
import wri;
import wrj;
import wrk;
import wrl;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  private View jdField_a_of_type_AndroidViewView;
  public PhoneContactManagerImp a;
  public QQProgressDialog a;
  private wrl jdField_a_of_type_Wrl;
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Wrl;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((wrl)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_Wrl.sendMessageDelayed((Message)localObject, paramLong);
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((!isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new wrk(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      DialogUtil.a(this, 231, paramString1, paramString2, new wrh(this), null).show();
    }
  }
  
  void a(boolean paramBoolean)
  {
    String str3;
    String str1;
    if (!isFinishing())
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      str3 = getResources().getString(2131436843);
      if (!paramBoolean) {
        break label94;
      }
      str1 = "确定跳过吗？";
      if (!paramBoolean) {
        break label100;
      }
    }
    label94:
    label100:
    for (String str2 = "跳过";; str2 = "关闭")
    {
      DialogUtil.a(this, 230, str1, str3, "继续绑定", str2, new wri(this, paramBoolean), new wrj(this, paramBoolean)).show();
      return;
      str1 = "确定关闭吗？";
      break;
    }
  }
  
  public void b(int paramInt)
  {
    b(getResources().getString(paramInt));
  }
  
  public void b(String paramString)
  {
    if (!isFinishing()) {
      QQToast.a(this, 0, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Wrl.hasMessages(1))
    {
      this.jdField_a_of_type_Wrl.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return true;
    }
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Wrl = new wrl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(10));
    return true;
  }
  
  public View findViewById(int paramInt)
  {
    View localView1 = null;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
    }
    View localView2 = localView1;
    if (localView1 == null) {
      localView2 = super.findViewById(paramInt);
    }
    return localView2;
  }
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = setContentViewB(paramInt);
  }
  
  protected String setLastActivityName()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity
 * JD-Core Version:    0.7.0.1
 */