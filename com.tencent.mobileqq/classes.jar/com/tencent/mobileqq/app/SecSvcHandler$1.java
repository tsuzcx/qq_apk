package com.tencent.mobileqq.app;

import akgd;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class SecSvcHandler$1
  implements Runnable
{
  public SecSvcHandler$1(akgd paramakgd, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    try
    {
      Intent localIntent = new Intent(this.this$0.app.getApp(), NotificationActivity.class);
      localIntent.putExtra("type", 11);
      Bundle localBundle = new Bundle();
      localBundle.putString("dlg_title", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("dlg_content", this.jdField_b_of_type_JavaLangString);
      localBundle.putString("dlg_lbutton", this.jdField_c_of_type_JavaLangString);
      localBundle.putString("dlg_rbutton", this.d);
      localBundle.putString("dlg_url", this.e);
      localBundle.putInt("dlg_lbtnid", this.jdField_a_of_type_Int);
      localBundle.putInt("dlg_rbtnid", this.jdField_b_of_type_Int);
      localBundle.putInt("dlg_seccmd", this.jdField_c_of_type_Int);
      localIntent.putExtras(localBundle);
      localIntent.setFlags(872415232);
      if (!this.this$0.app.isBackground_Stop) {
        this.this$0.app.getApp().startActivity(localIntent);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSvcHandler.1
 * JD-Core Version:    0.7.0.1
 */