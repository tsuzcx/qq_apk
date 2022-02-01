package com.tencent.biz.pubaccount.readinjoy.view;

import bdxz;
import bdzt;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import olh;
import org.json.JSONException;
import pqg;
import pqu;
import tbl;

public class ReadInJoySkinGuideView$1$1$1
  implements Runnable
{
  public ReadInJoySkinGuideView$1$1$1(tbl paramtbl, bdxz parambdxz) {}
  
  public void run()
  {
    this.jdField_a_of_type_Tbl.a.this$0.a.a((bdzt)this.jdField_a_of_type_Bdxz);
    this.jdField_a_of_type_Tbl.a.this$0.a.a();
    pqg localpqg = new pqg();
    try
    {
      localpqg.e();
      localpqg.a("guide_id", this.jdField_a_of_type_Tbl.a.b);
      localpqg.a("channel_id", this.jdField_a_of_type_Tbl.a.jdField_a_of_type_Int);
      olh.a(this.jdField_a_of_type_Tbl.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008C80", "0X8008C80", 0, 0, this.jdField_a_of_type_Tbl.a.b, "" + pqu.a(), "" + ReadInJoySkinGuideView.a(this.jdField_a_of_type_Tbl.a.this$0), localpqg.a(), false);
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