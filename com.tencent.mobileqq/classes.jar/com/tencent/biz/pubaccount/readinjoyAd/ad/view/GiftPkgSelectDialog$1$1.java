package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import java.util.List;
import tyf;
import tyg;
import tyh;

public class GiftPkgSelectDialog$1$1
  implements Runnable
{
  public GiftPkgSelectDialog$1$1(tyg paramtyg, int paramInt) {}
  
  public void run()
  {
    try
    {
      GiftServiceBean localGiftServiceBean = (GiftServiceBean)tyf.a(this.jdField_a_of_type_Tyg.a).get(this.jdField_a_of_type_Int);
      if (tyf.a(this.jdField_a_of_type_Tyg.a) != null) {
        tyf.a(this.jdField_a_of_type_Tyg.a).a(localGiftServiceBean);
      }
      this.jdField_a_of_type_Tyg.a.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPkgSelectDialog.1.1
 * JD-Core Version:    0.7.0.1
 */