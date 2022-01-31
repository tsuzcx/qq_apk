package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import java.util.HashMap;
import ocs;
import qjr;
import qjs;
import qju;

public class VideoWebPreDownload$3$1
  implements Runnable
{
  public VideoWebPreDownload$3$1(qjs paramqjs, ocs paramocs) {}
  
  public void run()
  {
    if (!qjr.a(this.jdField_a_of_type_Qjs.jdField_a_of_type_Qjr, this.jdField_a_of_type_Ocs.a, this.jdField_a_of_type_Ocs.b, this.jdField_a_of_type_Qjs.jdField_a_of_type_Int)) {
      qjr.a(this.jdField_a_of_type_Qjs.jdField_a_of_type_Qjr, this.jdField_a_of_type_Ocs.a, this.jdField_a_of_type_Ocs.b, this.jdField_a_of_type_Qjs.jdField_a_of_type_Long, this.jdField_a_of_type_Qjs.jdField_a_of_type_Int);
    }
    String str;
    do
    {
      do
      {
        return;
      } while (qjr.a(this.jdField_a_of_type_Qjs.jdField_a_of_type_Qjr) == null);
      str = (String)qjr.a(this.jdField_a_of_type_Qjs.jdField_a_of_type_Qjr).get(this.jdField_a_of_type_Ocs.b);
    } while (TextUtils.isEmpty(str));
    qjr.a(this.jdField_a_of_type_Qjs.jdField_a_of_type_Qjr).a(this.jdField_a_of_type_Ocs.b, 1, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.3.1
 * JD-Core Version:    0.7.0.1
 */