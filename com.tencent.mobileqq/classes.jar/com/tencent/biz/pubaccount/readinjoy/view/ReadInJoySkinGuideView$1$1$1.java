package com.tencent.biz.pubaccount.readinjoy.view;

import azzb;
import baav;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import nrt;
import org.json.JSONException;
import ors;
import orz;
import ruz;

public class ReadInJoySkinGuideView$1$1$1
  implements Runnable
{
  public ReadInJoySkinGuideView$1$1$1(ruz paramruz, azzb paramazzb) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ruz.a.this$0.a.a((baav)this.jdField_a_of_type_Azzb);
    this.jdField_a_of_type_Ruz.a.this$0.a.a();
    orz localorz = new orz();
    try
    {
      localorz.e();
      localorz.a("guide_id", this.jdField_a_of_type_Ruz.a.b);
      localorz.a("channel_id", this.jdField_a_of_type_Ruz.a.jdField_a_of_type_Int);
      nrt.a(this.jdField_a_of_type_Ruz.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008C80", "0X8008C80", 0, 0, this.jdField_a_of_type_Ruz.a.b, "" + ors.e(), "" + ReadInJoySkinGuideView.a(this.jdField_a_of_type_Ruz.a.this$0), localorz.a(), false);
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