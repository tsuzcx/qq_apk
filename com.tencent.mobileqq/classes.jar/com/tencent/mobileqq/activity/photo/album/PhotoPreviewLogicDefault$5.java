package com.tencent.mobileqq.activity.photo.album;

import agsb;
import agsr;
import agtc;
import android.app.Activity;
import android.content.Intent;
import axqw;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class PhotoPreviewLogicDefault$5
  implements Runnable
{
  public PhotoPreviewLogicDefault$5(agtc paramagtc, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PhotoUtils.a((Activity)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_Agsr.c, this.this$0.jdField_a_of_type_Agsb.c, true);
      ((NewPhotoPreviewActivity)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1);
      ((NewPhotoPreviewActivity)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
    }
    for (;;)
    {
      axqw.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      axdo.b = System.currentTimeMillis();
      return;
      PhotoUtils.a((Activity)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_Agsb.c, this.this$0.jdField_a_of_type_Agsr.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.5
 * JD-Core Version:    0.7.0.1
 */