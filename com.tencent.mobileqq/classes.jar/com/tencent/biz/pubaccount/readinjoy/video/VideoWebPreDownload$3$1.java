package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import java.util.HashMap;
import ooa;
import qvt;
import qvu;
import qvw;

public class VideoWebPreDownload$3$1
  implements Runnable
{
  public VideoWebPreDownload$3$1(qvu paramqvu, ooa paramooa) {}
  
  public void run()
  {
    if (!qvt.a(this.jdField_a_of_type_Qvu.jdField_a_of_type_Qvt, this.jdField_a_of_type_Ooa.a, this.jdField_a_of_type_Ooa.b, this.jdField_a_of_type_Qvu.jdField_a_of_type_Int)) {
      qvt.a(this.jdField_a_of_type_Qvu.jdField_a_of_type_Qvt, this.jdField_a_of_type_Ooa.a, this.jdField_a_of_type_Ooa.b, this.jdField_a_of_type_Qvu.jdField_a_of_type_Long, this.jdField_a_of_type_Qvu.jdField_a_of_type_Int);
    }
    String str;
    do
    {
      do
      {
        return;
      } while (qvt.a(this.jdField_a_of_type_Qvu.jdField_a_of_type_Qvt) == null);
      str = (String)qvt.a(this.jdField_a_of_type_Qvu.jdField_a_of_type_Qvt).get(this.jdField_a_of_type_Ooa.b);
    } while (TextUtils.isEmpty(str));
    qvt.a(this.jdField_a_of_type_Qvu.jdField_a_of_type_Qvt).a(this.jdField_a_of_type_Ooa.b, 1, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.3.1
 * JD-Core Version:    0.7.0.1
 */