package com.tencent.biz.pubaccount.readinjoy.view;

import bdxj;
import bdzd;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import ocd;
import org.json.JSONException;
import ozs;
import paa;
import sjz;

public class ReadInJoySkinGuideView$1$1$1
  implements Runnable
{
  public ReadInJoySkinGuideView$1$1$1(sjz paramsjz, bdxj parambdxj) {}
  
  public void run()
  {
    this.jdField_a_of_type_Sjz.a.this$0.a.a((bdzd)this.jdField_a_of_type_Bdxj);
    this.jdField_a_of_type_Sjz.a.this$0.a.a();
    paa localpaa = new paa();
    try
    {
      localpaa.e();
      localpaa.a("guide_id", this.jdField_a_of_type_Sjz.a.b);
      localpaa.a("channel_id", this.jdField_a_of_type_Sjz.a.jdField_a_of_type_Int);
      ocd.a(this.jdField_a_of_type_Sjz.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008C80", "0X8008C80", 0, 0, this.jdField_a_of_type_Sjz.a.b, "" + ozs.e(), "" + ReadInJoySkinGuideView.a(this.jdField_a_of_type_Sjz.a.this$0), localpaa.a(), false);
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