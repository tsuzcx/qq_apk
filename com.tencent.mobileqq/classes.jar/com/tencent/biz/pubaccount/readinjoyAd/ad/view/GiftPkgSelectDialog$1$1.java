package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import java.util.List;
import trm;
import trn;
import tro;

public class GiftPkgSelectDialog$1$1
  implements Runnable
{
  public GiftPkgSelectDialog$1$1(trn paramtrn, int paramInt) {}
  
  public void run()
  {
    try
    {
      GiftServiceBean localGiftServiceBean = (GiftServiceBean)trm.a(this.jdField_a_of_type_Trn.a).get(this.jdField_a_of_type_Int);
      if (trm.a(this.jdField_a_of_type_Trn.a) != null) {
        trm.a(this.jdField_a_of_type_Trn.a).a(localGiftServiceBean);
      }
      this.jdField_a_of_type_Trn.a.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPkgSelectDialog.1.1
 * JD-Core Version:    0.7.0.1
 */