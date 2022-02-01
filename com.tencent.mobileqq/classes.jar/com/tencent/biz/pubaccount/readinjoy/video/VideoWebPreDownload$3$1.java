package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import java.util.HashMap;
import sqy;
import sqz;
import srb;
import sxc;

public class VideoWebPreDownload$3$1
  implements Runnable
{
  public VideoWebPreDownload$3$1(sqz paramsqz, sxc paramsxc) {}
  
  public void run()
  {
    if (!sqy.a(this.jdField_a_of_type_Sqz.jdField_a_of_type_Sqy, this.jdField_a_of_type_Sxc.a, this.jdField_a_of_type_Sxc.b, this.jdField_a_of_type_Sqz.jdField_a_of_type_Int)) {
      sqy.a(this.jdField_a_of_type_Sqz.jdField_a_of_type_Sqy, this.jdField_a_of_type_Sxc.a, this.jdField_a_of_type_Sxc.b, this.jdField_a_of_type_Sqz.jdField_a_of_type_Long, this.jdField_a_of_type_Sqz.jdField_a_of_type_Int);
    }
    String str;
    do
    {
      do
      {
        return;
      } while (sqy.a(this.jdField_a_of_type_Sqz.jdField_a_of_type_Sqy) == null);
      str = (String)sqy.a(this.jdField_a_of_type_Sqz.jdField_a_of_type_Sqy).get(this.jdField_a_of_type_Sxc.b);
    } while (TextUtils.isEmpty(str));
    sqy.a(this.jdField_a_of_type_Sqz.jdField_a_of_type_Sqy).a(this.jdField_a_of_type_Sxc.b, 1, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.3.1
 * JD-Core Version:    0.7.0.1
 */