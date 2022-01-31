package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.List;
import nqb;
import nqc;
import nqd;

public class GiftPkgSelectDialog$1$1
  implements Runnable
{
  public GiftPkgSelectDialog$1$1(nqc paramnqc, int paramInt) {}
  
  public void run()
  {
    try
    {
      GiftServiceBean localGiftServiceBean = (GiftServiceBean)nqb.a(this.jdField_a_of_type_Nqc.a).get(this.jdField_a_of_type_Int);
      if (nqb.a(this.jdField_a_of_type_Nqc.a) != null) {
        nqb.a(this.jdField_a_of_type_Nqc.a).a(localGiftServiceBean);
      }
      this.jdField_a_of_type_Nqc.a.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPkgSelectDialog.1.1
 * JD-Core Version:    0.7.0.1
 */