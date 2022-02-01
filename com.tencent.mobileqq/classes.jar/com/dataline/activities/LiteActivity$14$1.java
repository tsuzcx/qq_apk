package com.dataline.activities;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;

class LiteActivity$14$1
  implements Runnable
{
  LiteActivity$14$1(LiteActivity.14 param14, boolean paramBoolean, Bitmap paramBitmap) {}
  
  public void run()
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDrawable(2130839075);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("key_use_rect", true);
      localBundle.putBoolean("key_double_bitmap", true);
      localObject = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), this.this$0.jdField_a_of_type_JavaLangString, "-chatBg-", (Drawable)localObject, new int[] { 0 }, "-chatBg-", localBundle);
    }
    else
    {
      localObject = new ChatBackgroundDrawable(this.this$0.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.this$0.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
    this.this$0.jdField_a_of_type_AndroidViewViewGroup.setTag(2131361813, this.this$0.jdField_a_of_type_JavaLangString);
    this.this$0.jdField_a_of_type_AndroidViewViewGroup.setTag(2131361812, localObject);
    LiteActivity.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.14.1
 * JD-Core Version:    0.7.0.1
 */