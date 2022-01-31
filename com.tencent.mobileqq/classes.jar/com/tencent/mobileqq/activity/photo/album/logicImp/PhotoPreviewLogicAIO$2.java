package com.tencent.mobileqq.activity.photo.album.logicImp;

import aimj;
import aimr;
import aior;
import android.content.Intent;
import azmj;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class PhotoPreviewLogicAIO$2
  implements Runnable
{
  public PhotoPreviewLogicAIO$2(aior paramaior, boolean paramBoolean, Intent paramIntent, Pair paramPair, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PhotoUtils.a(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, (ArrayList)this.jdField_a_of_type_ComTencentUtilPair.first, aior.a(this.this$0).b, aior.a(this.this$0).currentQualityType, true);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).setResult(-1);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).finish();
    }
    for (;;)
    {
      azmj.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      ayyu.b = System.currentTimeMillis();
      return;
      PhotoUtils.a(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, (ArrayList)this.jdField_a_of_type_ComTencentUtilPair.first, aior.b(this.this$0).currentQualityType, aior.b(this.this$0).jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoPreviewLogicAIO.2
 * JD-Core Version:    0.7.0.1
 */