package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.List;
import ofb;
import ofc;
import ofd;

public class GiftPkgSelectDialog$1$1
  implements Runnable
{
  public GiftPkgSelectDialog$1$1(ofc paramofc, int paramInt) {}
  
  public void run()
  {
    try
    {
      GiftServiceBean localGiftServiceBean = (GiftServiceBean)ofb.a(this.jdField_a_of_type_Ofc.a).get(this.jdField_a_of_type_Int);
      if (ofb.a(this.jdField_a_of_type_Ofc.a) != null) {
        ofb.a(this.jdField_a_of_type_Ofc.a).a(localGiftServiceBean);
      }
      this.jdField_a_of_type_Ofc.a.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPkgSelectDialog.1.1
 * JD-Core Version:    0.7.0.1
 */