package com.tencent.biz.pubaccount.readinjoy.view;

import aybc;
import aycw;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import noo;
import onk;
import onr;
import org.json.JSONException;
import rfg;

public class ReadInJoySkinGuideView$1$1$1
  implements Runnable
{
  public ReadInJoySkinGuideView$1$1$1(rfg paramrfg, aybc paramaybc) {}
  
  public void run()
  {
    this.jdField_a_of_type_Rfg.a.this$0.a.a((aycw)this.jdField_a_of_type_Aybc);
    this.jdField_a_of_type_Rfg.a.this$0.a.a();
    onr localonr = new onr();
    try
    {
      localonr.e();
      localonr.a("guide_id", this.jdField_a_of_type_Rfg.a.b);
      localonr.a("channel_id", this.jdField_a_of_type_Rfg.a.jdField_a_of_type_Int);
      noo.a(this.jdField_a_of_type_Rfg.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008C80", "0X8008C80", 0, 0, this.jdField_a_of_type_Rfg.a.b, "" + onk.e(), "" + ReadInJoySkinGuideView.a(this.jdField_a_of_type_Rfg.a.this$0), localonr.a(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView.1.1.1
 * JD-Core Version:    0.7.0.1
 */