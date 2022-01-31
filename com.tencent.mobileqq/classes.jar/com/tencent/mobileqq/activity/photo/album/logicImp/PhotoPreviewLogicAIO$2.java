package com.tencent.mobileqq.activity.photo.album.logicImp;

import agrz;
import agsp;
import agut;
import android.app.Activity;
import android.content.Intent;
import axqy;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class PhotoPreviewLogicAIO$2
  implements Runnable
{
  public PhotoPreviewLogicAIO$2(agut paramagut, boolean paramBoolean, Intent paramIntent, Pair paramPair, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PhotoUtils.a((Activity)this.this$0.a.get(), this.jdField_a_of_type_AndroidContentIntent, (ArrayList)this.jdField_a_of_type_ComTencentUtilPair.first, agut.a(this.this$0).c, agut.a(this.this$0).c, true);
      ((NewPhotoPreviewActivity)this.this$0.a.get()).setResult(-1);
      ((NewPhotoPreviewActivity)this.this$0.a.get()).finish();
    }
    for (;;)
    {
      axqy.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      axdq.b = System.currentTimeMillis();
      return;
      PhotoUtils.a((Activity)this.this$0.a.get(), this.jdField_a_of_type_AndroidContentIntent, (ArrayList)this.jdField_a_of_type_ComTencentUtilPair.first, agut.b(this.this$0).c, agut.b(this.this$0).e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoPreviewLogicAIO.2
 * JD-Core Version:    0.7.0.1
 */