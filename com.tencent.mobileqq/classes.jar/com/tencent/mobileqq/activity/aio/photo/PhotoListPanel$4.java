package com.tencent.mobileqq.activity.aio.photo;

import bcst;
import com.tencent.util.Pair;
import java.util.ArrayList;

class PhotoListPanel$4
  implements Runnable
{
  PhotoListPanel$4(PhotoListPanel paramPhotoListPanel, Pair paramPair, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if ((!((ArrayList)this.jdField_a_of_type_ComTencentUtilPair.first).isEmpty()) || (!((ArrayList)this.jdField_a_of_type_ComTencentUtilPair.second).isEmpty()))
    {
      this.this$0.a(this.jdField_a_of_type_ComTencentUtilPair, this.jdField_a_of_type_Boolean);
      bcec.b = System.currentTimeMillis();
    }
    bcst.b(null, "CliOper", "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, this.b, this.c, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.4
 * JD-Core Version:    0.7.0.1
 */