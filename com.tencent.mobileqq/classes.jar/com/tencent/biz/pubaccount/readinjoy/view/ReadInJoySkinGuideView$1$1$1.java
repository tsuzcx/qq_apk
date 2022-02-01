package com.tencent.biz.pubaccount.readinjoy.view;

import bcra;
import bcsu;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import odq;
import org.json.JSONException;
import pay;
import pbg;
import soa;

public class ReadInJoySkinGuideView$1$1$1
  implements Runnable
{
  public ReadInJoySkinGuideView$1$1$1(soa paramsoa, bcra parambcra) {}
  
  public void run()
  {
    this.jdField_a_of_type_Soa.a.this$0.a.a((bcsu)this.jdField_a_of_type_Bcra);
    this.jdField_a_of_type_Soa.a.this$0.a.a();
    pbg localpbg = new pbg();
    try
    {
      localpbg.e();
      localpbg.a("guide_id", this.jdField_a_of_type_Soa.a.b);
      localpbg.a("channel_id", this.jdField_a_of_type_Soa.a.jdField_a_of_type_Int);
      odq.a(this.jdField_a_of_type_Soa.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008C80", "0X8008C80", 0, 0, this.jdField_a_of_type_Soa.a.b, "" + pay.e(), "" + ReadInJoySkinGuideView.a(this.jdField_a_of_type_Soa.a.this$0), localpbg.a(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView.1.1.1
 * JD-Core Version:    0.7.0.1
 */