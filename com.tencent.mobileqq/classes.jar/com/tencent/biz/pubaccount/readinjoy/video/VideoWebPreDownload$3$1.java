package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import java.util.HashMap;
import ood;
import qvw;
import qvx;
import qvz;

public class VideoWebPreDownload$3$1
  implements Runnable
{
  public VideoWebPreDownload$3$1(qvx paramqvx, ood paramood) {}
  
  public void run()
  {
    if (!qvw.a(this.jdField_a_of_type_Qvx.jdField_a_of_type_Qvw, this.jdField_a_of_type_Ood.a, this.jdField_a_of_type_Ood.b, this.jdField_a_of_type_Qvx.jdField_a_of_type_Int)) {
      qvw.a(this.jdField_a_of_type_Qvx.jdField_a_of_type_Qvw, this.jdField_a_of_type_Ood.a, this.jdField_a_of_type_Ood.b, this.jdField_a_of_type_Qvx.jdField_a_of_type_Long, this.jdField_a_of_type_Qvx.jdField_a_of_type_Int);
    }
    String str;
    do
    {
      do
      {
        return;
      } while (qvw.a(this.jdField_a_of_type_Qvx.jdField_a_of_type_Qvw) == null);
      str = (String)qvw.a(this.jdField_a_of_type_Qvx.jdField_a_of_type_Qvw).get(this.jdField_a_of_type_Ood.b);
    } while (TextUtils.isEmpty(str));
    qvw.a(this.jdField_a_of_type_Qvx.jdField_a_of_type_Qvw).a(this.jdField_a_of_type_Ood.b, 1, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.3.1
 * JD-Core Version:    0.7.0.1
 */