package com.tencent.mobileqq.activity.photo.album;

import aiqy;
import aiqz;
import aira;
import android.content.Intent;
import azqs;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;

public class PhotoListLogicDefault$1
  implements Runnable
{
  public PhotoListLogicDefault$1(aira paramaira, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      PhotoUtils.a(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.a.jdField_a_of_type_JavaUtilHashMap, this.this$0.mPhotoCommonData.currentQualityType, false);
    }
    for (;;)
    {
      azqs.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      azdd.b = System.currentTimeMillis();
      return;
      PhotoUtils.a(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.mPhotoCommonData.currentQualityType, this.this$0.a.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.1
 * JD-Core Version:    0.7.0.1
 */