package com.tencent.aelight.camera.aioeditor.share.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.share.AIOShareObject;
import com.tencent.mobileqq.app.utils.RouteUtils;

class AIOShareHelperImpl$1
  implements Runnable
{
  AIOShareHelperImpl$1(AIOShareHelperImpl paramAIOShareHelperImpl, Intent paramIntent, Activity paramActivity, String paramString, int paramInt, AIOShareObject paramAIOShareObject) {}
  
  public void run()
  {
    this.this$0.dismissLoading();
    this.jdField_a_of_type_AndroidContentIntent.putExtra("caller_name", this.jdField_a_of_type_AndroidAppActivity.getClass().getSimpleName());
    this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_source_business_type", -1);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_source_sub_business_type", "");
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_allow_multiple_forward_from_limit", false);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("is_need_show_toast", false);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("selection_mode", 2);
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString) ^ true;
    Object localObject;
    if (bool)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_req", 1);
      ((Bundle)localObject).putInt("key_direct_show_uin_type", this.jdField_a_of_type_Int);
      ((Bundle)localObject).putString("key_direct_show_uin", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidContentIntent.putExtras((Bundle)localObject);
    }
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
    if (bool) {
      localObject = "/base/forwardRecentTrans";
    } else {
      localObject = "/base/forwardRecent";
    }
    RouteUtils.a(localActivity, localIntent, (String)localObject, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */