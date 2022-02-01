package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import java.util.HashMap;
import sgl;
import sgm;
import sgo;
import slr;

public class VideoWebPreDownload$3$1
  implements Runnable
{
  public VideoWebPreDownload$3$1(sgm paramsgm, slr paramslr) {}
  
  public void run()
  {
    if (!sgl.a(this.jdField_a_of_type_Sgm.jdField_a_of_type_Sgl, this.jdField_a_of_type_Slr.a, this.jdField_a_of_type_Slr.b, this.jdField_a_of_type_Sgm.jdField_a_of_type_Int)) {
      sgl.a(this.jdField_a_of_type_Sgm.jdField_a_of_type_Sgl, this.jdField_a_of_type_Slr.a, this.jdField_a_of_type_Slr.b, this.jdField_a_of_type_Sgm.jdField_a_of_type_Long, this.jdField_a_of_type_Sgm.jdField_a_of_type_Int);
    }
    String str;
    do
    {
      do
      {
        return;
      } while (sgl.a(this.jdField_a_of_type_Sgm.jdField_a_of_type_Sgl) == null);
      str = (String)sgl.a(this.jdField_a_of_type_Sgm.jdField_a_of_type_Sgl).get(this.jdField_a_of_type_Slr.b);
    } while (TextUtils.isEmpty(str));
    sgl.a(this.jdField_a_of_type_Sgm.jdField_a_of_type_Sgl).a(this.jdField_a_of_type_Slr.b, 1, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.3.1
 * JD-Core Version:    0.7.0.1
 */