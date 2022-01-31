package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import axqw;
import java.util.ArrayList;

class PhotoPreviewActivity$15
  implements Runnable
{
  PhotoPreviewActivity$15(PhotoPreviewActivity paramPhotoPreviewActivity, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PhotoUtils.a(this.this$0, this.jdField_a_of_type_AndroidContentIntent, this.this$0.b, this.this$0.c, this.this$0.e, true);
      this.this$0.setResult(-1);
      this.this$0.finish();
    }
    for (;;)
    {
      axqw.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      axdo.b = System.currentTimeMillis();
      return;
      PhotoUtils.a(this.this$0, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.e, this.this$0.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoPreviewActivity.15
 * JD-Core Version:    0.7.0.1
 */