package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.List;
import obj;
import obk;
import obl;

public class GiftPkgSelectDialog$1$1
  implements Runnable
{
  public GiftPkgSelectDialog$1$1(obk paramobk, int paramInt) {}
  
  public void run()
  {
    try
    {
      GiftServiceBean localGiftServiceBean = (GiftServiceBean)obj.a(this.jdField_a_of_type_Obk.a).get(this.jdField_a_of_type_Int);
      if (obj.a(this.jdField_a_of_type_Obk.a) != null) {
        obj.a(this.jdField_a_of_type_Obk.a).a(localGiftServiceBean);
      }
      this.jdField_a_of_type_Obk.a.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPkgSelectDialog.1.1
 * JD-Core Version:    0.7.0.1
 */