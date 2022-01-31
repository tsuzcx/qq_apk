package com.tencent.mobileqq.activity.aio.helper;

import ajjy;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import bbmy;
import com.tencent.mobileqq.activity.BaseChatPie;

class AIOLongShotHelper$1
  implements Runnable
{
  AIOLongShotHelper$1(AIOLongShotHelper paramAIOLongShotHelper, boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  public void run()
  {
    FragmentActivity localFragmentActivity = AIOLongShotHelper.a(this.this$0).jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
      if (!this.jdField_a_of_type_Boolean) {
        break label41;
      }
    }
    for (;;)
    {
      AIOLongShotHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      return;
      label41:
      if (!this.b)
      {
        bbmy.a(AIOLongShotHelper.a(this.this$0).jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131634309), 0).a();
        AIOLongShotHelper.a("0X800A50D");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper.1
 * JD-Core Version:    0.7.0.1
 */