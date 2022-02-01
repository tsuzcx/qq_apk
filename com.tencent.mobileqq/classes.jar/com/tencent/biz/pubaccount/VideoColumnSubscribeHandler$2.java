package com.tencent.biz.pubaccount;

import oma;
import rao;
import rap;

public class VideoColumnSubscribeHandler$2
  implements Runnable
{
  public VideoColumnSubscribeHandler$2(oma paramoma, int paramInt1, boolean paramBoolean, String paramString, int paramInt2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Boolean)) {
      rao.a.a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, String.valueOf(this.b), 1);
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    rao.a.a().a(true, "MATCH_ALL_UIN");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoColumnSubscribeHandler.2
 * JD-Core Version:    0.7.0.1
 */