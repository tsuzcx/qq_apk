package com.tencent.mobileqq.activity.photo.album;

import aggf;
import aggs;
import aggt;
import android.content.Intent;
import awqx;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;

class NewPhotoPreviewActivity$2
  implements Runnable
{
  NewPhotoPreviewActivity$2(NewPhotoPreviewActivity paramNewPhotoPreviewActivity, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PhotoUtils.a(this.this$0, this.jdField_a_of_type_AndroidContentIntent, this.this$0.jdField_a_of_type_Aggt.a.jdField_a_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_Aggs.jdField_c_of_type_JavaUtilHashMap, this.this$0.jdField_a_of_type_Aggs.jdField_c_of_type_Int, true);
      this.this$0.setResult(-1);
      this.this$0.finish();
    }
    for (;;)
    {
      awqx.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      aweg.b = System.currentTimeMillis();
      return;
      PhotoUtils.a(this.this$0, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_Aggs.jdField_c_of_type_Int, this.this$0.jdField_a_of_type_Aggs.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */