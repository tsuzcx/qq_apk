package com.tencent.mobileqq.activity.photo.album.logicImp;

import akmr;
import akov;
import android.content.Intent;
import bdla;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class PhotoPreviewLogicAIO$2
  implements Runnable
{
  public PhotoPreviewLogicAIO$2(akov paramakov, boolean paramBoolean, Intent paramIntent, Pair paramPair, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PhotoUtils.sendPhoto(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, (ArrayList)this.jdField_a_of_type_ComTencentUtilPair.first, akov.a(this.this$0).b, akov.a(this.this$0).currentQualityType, true);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).setResult(-1);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).finish();
    }
    for (;;)
    {
      bdla.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      bcwz.b = System.currentTimeMillis();
      return;
      PhotoUtils.sendPhoto(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, (ArrayList)this.jdField_a_of_type_ComTencentUtilPair.first, akov.b(this.this$0).currentQualityType, akov.b(this.this$0).jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoPreviewLogicAIO.2
 * JD-Core Version:    0.7.0.1
 */