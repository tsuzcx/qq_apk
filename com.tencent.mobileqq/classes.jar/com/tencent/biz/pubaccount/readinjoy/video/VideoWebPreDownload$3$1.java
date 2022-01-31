package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import java.util.HashMap;
import osl;
import rlk;
import rll;
import rln;

public class VideoWebPreDownload$3$1
  implements Runnable
{
  public VideoWebPreDownload$3$1(rll paramrll, osl paramosl) {}
  
  public void run()
  {
    if (!rlk.a(this.jdField_a_of_type_Rll.jdField_a_of_type_Rlk, this.jdField_a_of_type_Osl.a, this.jdField_a_of_type_Osl.b, this.jdField_a_of_type_Rll.jdField_a_of_type_Int)) {
      rlk.a(this.jdField_a_of_type_Rll.jdField_a_of_type_Rlk, this.jdField_a_of_type_Osl.a, this.jdField_a_of_type_Osl.b, this.jdField_a_of_type_Rll.jdField_a_of_type_Long, this.jdField_a_of_type_Rll.jdField_a_of_type_Int);
    }
    String str;
    do
    {
      do
      {
        return;
      } while (rlk.a(this.jdField_a_of_type_Rll.jdField_a_of_type_Rlk) == null);
      str = (String)rlk.a(this.jdField_a_of_type_Rll.jdField_a_of_type_Rlk).get(this.jdField_a_of_type_Osl.b);
    } while (TextUtils.isEmpty(str));
    rlk.a(this.jdField_a_of_type_Rll.jdField_a_of_type_Rlk).a(this.jdField_a_of_type_Osl.b, 1, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.3.1
 * JD-Core Version:    0.7.0.1
 */