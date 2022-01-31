package com.tencent.biz.pubaccount.readinjoy.view;

import axba;
import axcu;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import ndn;
import obz;
import ocg;
import org.json.JSONException;
import qsu;

public class ReadInJoySkinGuideView$1$1$1
  implements Runnable
{
  public ReadInJoySkinGuideView$1$1$1(qsu paramqsu, axba paramaxba) {}
  
  public void run()
  {
    this.jdField_a_of_type_Qsu.a.this$0.a.a((axcu)this.jdField_a_of_type_Axba);
    this.jdField_a_of_type_Qsu.a.this$0.a.a();
    ocg localocg = new ocg();
    try
    {
      localocg.e();
      localocg.a("guide_id", this.jdField_a_of_type_Qsu.a.b);
      localocg.a("channel_id", this.jdField_a_of_type_Qsu.a.jdField_a_of_type_Int);
      ndn.a(this.jdField_a_of_type_Qsu.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008C80", "0X8008C80", 0, 0, this.jdField_a_of_type_Qsu.a.b, "" + obz.e(), "" + ReadInJoySkinGuideView.a(this.jdField_a_of_type_Qsu.a.this$0), localocg.a(), false);
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