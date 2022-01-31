package com.tencent.mobileqq.activity.photo.album;

import aimj;
import aimr;
import aimu;
import android.content.Intent;
import azmj;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;

public class PhotoPreviewLogicDefault$5
  implements Runnable
{
  public PhotoPreviewLogicDefault$5(aimu paramaimu, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PhotoUtils.a(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.a.b, this.this$0.mPhotoCommonData.currentQualityType, true);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).setResult(-1);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).finish();
    }
    for (;;)
    {
      azmj.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      ayyu.b = System.currentTimeMillis();
      return;
      PhotoUtils.a(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.mPhotoCommonData.currentQualityType, this.this$0.a.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.5
 * JD-Core Version:    0.7.0.1
 */