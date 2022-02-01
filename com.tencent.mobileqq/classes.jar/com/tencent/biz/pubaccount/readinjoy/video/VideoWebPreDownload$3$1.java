package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import java.util.HashMap;
import rxp;
import rxq;
import rxs;
import scv;

public class VideoWebPreDownload$3$1
  implements Runnable
{
  public VideoWebPreDownload$3$1(rxq paramrxq, scv paramscv) {}
  
  public void run()
  {
    if (!rxp.a(this.jdField_a_of_type_Rxq.jdField_a_of_type_Rxp, this.jdField_a_of_type_Scv.a, this.jdField_a_of_type_Scv.b, this.jdField_a_of_type_Rxq.jdField_a_of_type_Int)) {
      rxp.a(this.jdField_a_of_type_Rxq.jdField_a_of_type_Rxp, this.jdField_a_of_type_Scv.a, this.jdField_a_of_type_Scv.b, this.jdField_a_of_type_Rxq.jdField_a_of_type_Long, this.jdField_a_of_type_Rxq.jdField_a_of_type_Int);
    }
    String str;
    do
    {
      do
      {
        return;
      } while (rxp.a(this.jdField_a_of_type_Rxq.jdField_a_of_type_Rxp) == null);
      str = (String)rxp.a(this.jdField_a_of_type_Rxq.jdField_a_of_type_Rxp).get(this.jdField_a_of_type_Scv.b);
    } while (TextUtils.isEmpty(str));
    rxp.a(this.jdField_a_of_type_Rxq.jdField_a_of_type_Rxp).a(this.jdField_a_of_type_Scv.b, 1, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.3.1
 * JD-Core Version:    0.7.0.1
 */