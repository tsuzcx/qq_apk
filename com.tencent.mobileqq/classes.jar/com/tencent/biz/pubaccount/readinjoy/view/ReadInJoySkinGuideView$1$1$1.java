package com.tencent.biz.pubaccount.readinjoy.view;

import aybe;
import aycy;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import nol;
import onh;
import ono;
import org.json.JSONException;
import rfd;

public class ReadInJoySkinGuideView$1$1$1
  implements Runnable
{
  public ReadInJoySkinGuideView$1$1$1(rfd paramrfd, aybe paramaybe) {}
  
  public void run()
  {
    this.jdField_a_of_type_Rfd.a.this$0.a.a((aycy)this.jdField_a_of_type_Aybe);
    this.jdField_a_of_type_Rfd.a.this$0.a.a();
    ono localono = new ono();
    try
    {
      localono.e();
      localono.a("guide_id", this.jdField_a_of_type_Rfd.a.b);
      localono.a("channel_id", this.jdField_a_of_type_Rfd.a.jdField_a_of_type_Int);
      nol.a(this.jdField_a_of_type_Rfd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008C80", "0X8008C80", 0, 0, this.jdField_a_of_type_Rfd.a.b, "" + onh.e(), "" + ReadInJoySkinGuideView.a(this.jdField_a_of_type_Rfd.a.this$0), localono.a(), false);
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