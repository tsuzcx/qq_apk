package com.dataline.activities;

import android.content.Context;
import com.dataline.util.file.FileUtil;

final class LiteActivity$20
  implements Runnable
{
  LiteActivity$20(Context paramContext, String paramString, LiteActivity.CreateThumbCB paramCreateThumbCB) {}
  
  public void run()
  {
    String str = FileUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    LiteActivity.CreateThumbCB localCreateThumbCB = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$CreateThumbCB;
    if (localCreateThumbCB != null) {
      localCreateThumbCB.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.20
 * JD-Core Version:    0.7.0.1
 */