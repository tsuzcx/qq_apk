package com.tencent.biz.pubaccount.readinjoy.view;

import bdeo;
import bdgi;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import oat;
import org.json.JSONException;
import pha;
import phi;
import ssv;

public class ReadInJoySkinGuideView$1$1$1
  implements Runnable
{
  public ReadInJoySkinGuideView$1$1$1(ssv paramssv, bdeo parambdeo) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ssv.a.this$0.a.a((bdgi)this.jdField_a_of_type_Bdeo);
    this.jdField_a_of_type_Ssv.a.this$0.a.a();
    phi localphi = new phi();
    try
    {
      localphi.e();
      localphi.a("guide_id", this.jdField_a_of_type_Ssv.a.b);
      localphi.a("channel_id", this.jdField_a_of_type_Ssv.a.jdField_a_of_type_Int);
      oat.a(this.jdField_a_of_type_Ssv.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008C80", "0X8008C80", 0, 0, this.jdField_a_of_type_Ssv.a.b, "" + pha.e(), "" + ReadInJoySkinGuideView.a(this.jdField_a_of_type_Ssv.a.this$0), localphi.a(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView.1.1.1
 * JD-Core Version:    0.7.0.1
 */