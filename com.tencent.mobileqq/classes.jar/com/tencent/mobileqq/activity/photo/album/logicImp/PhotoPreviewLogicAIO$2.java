package com.tencent.mobileqq.activity.photo.album.logicImp;

import aktn;
import akvn;
import android.content.Intent;
import bdll;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class PhotoPreviewLogicAIO$2
  implements Runnable
{
  public PhotoPreviewLogicAIO$2(akvn paramakvn, boolean paramBoolean, Intent paramIntent, Pair paramPair, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PhotoUtils.a(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, (ArrayList)this.jdField_a_of_type_ComTencentUtilPair.first, akvn.a(this.this$0).b, akvn.a(this.this$0).currentQualityType, true);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).setResult(-1);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).finish();
    }
    for (;;)
    {
      bdll.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      bcwu.b = System.currentTimeMillis();
      return;
      PhotoUtils.a(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, (ArrayList)this.jdField_a_of_type_ComTencentUtilPair.first, akvn.b(this.this$0).currentQualityType, akvn.b(this.this$0).jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoPreviewLogicAIO.2
 * JD-Core Version:    0.7.0.1
 */