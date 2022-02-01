package com.tencent.mobileqq.activity.photo.album;

import ajrd;
import ajrg;
import android.content.Intent;
import bcef;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;

public class PhotoPreviewLogicDefault$5
  implements Runnable
{
  public PhotoPreviewLogicDefault$5(ajrg paramajrg, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PhotoUtils.sendPhoto(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.a.b, this.this$0.mPhotoCommonData.currentQualityType, true);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).setResult(-1);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).finish();
    }
    for (;;)
    {
      bcef.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      bbqf.b = System.currentTimeMillis();
      return;
      PhotoUtils.sendPhoto(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.mPhotoCommonData.currentQualityType, this.this$0.a.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.5
 * JD-Core Version:    0.7.0.1
 */