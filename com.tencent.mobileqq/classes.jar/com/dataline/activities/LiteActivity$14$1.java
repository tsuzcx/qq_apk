package com.dataline.activities;

import ag;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import apgf;
import bdpt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class LiteActivity$14$1
  implements Runnable
{
  public LiteActivity$14$1(ag paramag, boolean paramBoolean, Bitmap paramBitmap) {}
  
  public void run()
  {
    Bundle localBundle;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDrawable(2130838924);
      localBundle = new Bundle();
      localBundle.putBoolean("key_use_rect", true);
      localBundle.putBoolean("key_double_bitmap", true);
    }
    for (Object localObject = bdpt.a(BaseApplicationImpl.sApplication.getRuntime(), this.this$0.jdField_a_of_type_JavaLangString, "-chatBg-", (Drawable)localObject, new int[] { 0 }, "-chatBg-", localBundle);; localObject = new apgf(this.this$0.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap))
    {
      this.this$0.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
      this.this$0.jdField_a_of_type_AndroidViewViewGroup.setTag(2131361806, this.this$0.jdField_a_of_type_JavaLangString);
      this.this$0.jdField_a_of_type_AndroidViewViewGroup.setTag(2131361805, localObject);
      LiteActivity.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.14.1
 * JD-Core Version:    0.7.0.1
 */