package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import atra;
import baae;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class SendPhotoActivity$sendPhotoTask$1
  implements Runnable
{
  SendPhotoActivity$sendPhotoTask$1(SendPhotoActivity.sendPhotoTask paramsendPhotoTask) {}
  
  public void run()
  {
    try
    {
      this.this$0.a();
      this.this$0.jdField_a_of_type_AndroidContentIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      this.this$0.jdField_a_of_type_AndroidContentIntent.putExtra(baae.h, 2);
      if (!this.this$0.jdField_a_of_type_AndroidContentIntent.hasExtra("extra_image_sender_tag")) {
        this.this$0.jdField_a_of_type_AndroidContentIntent.putExtra("extra_image_sender_tag", "SendPhotoActivity.handlePhoto");
      }
      this.this$0.jdField_a_of_type_AndroidContentIntent.putExtra("open_chatfragment_fromphoto", true);
      this.this$0.jdField_a_of_type_AndroidContentIntent.putExtra("param_selNum", this.this$0.jdField_b_of_type_JavaUtilArrayList.size());
      if (!this.this$0.c)
      {
        ((BaseActivity)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).setResult(-1, this.this$0.jdField_a_of_type_AndroidContentIntent);
        ((BaseActivity)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
        ((BaseActivity)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).overridePendingTransition(0, 2130771980);
        if (!this.this$0.jdField_b_of_type_Boolean)
        {
          String str1 = this.this$0.jdField_a_of_type_AndroidContentIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          String str2 = this.this$0.jdField_a_of_type_AndroidContentIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
          this.this$0.jdField_a_of_type_AndroidContentIntent.setClassName(str2, str1);
          this.this$0.jdField_a_of_type_AndroidContentIntent.addFlags(603979776);
          ((BaseActivity)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(this.this$0.jdField_a_of_type_AndroidContentIntent);
        }
      }
      atra.a(BaseApplication.getContext(), this.this$0.d);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask.1
 * JD-Core Version:    0.7.0.1
 */