package com.tencent.mobileqq.activity.photo.album.logicImp;

import akum;
import android.content.Intent;
import bdll;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;

public class PhotoListLogicDataline$1
  implements Runnable
{
  public PhotoListLogicDataline$1(akum paramakum, Intent paramIntent, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, akum.a(this.this$0).selectedPhotoList);
    bdll.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
    bcwu.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicDataline.1
 * JD-Core Version:    0.7.0.1
 */