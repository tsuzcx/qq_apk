package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.List;
import oru;
import orv;
import orw;

public class GiftPkgSelectDialog$1$1
  implements Runnable
{
  public GiftPkgSelectDialog$1$1(orv paramorv, int paramInt) {}
  
  public void run()
  {
    try
    {
      GiftServiceBean localGiftServiceBean = (GiftServiceBean)oru.a(this.jdField_a_of_type_Orv.a).get(this.jdField_a_of_type_Int);
      if (oru.a(this.jdField_a_of_type_Orv.a) != null) {
        oru.a(this.jdField_a_of_type_Orv.a).a(localGiftServiceBean);
      }
      this.jdField_a_of_type_Orv.a.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPkgSelectDialog.1.1
 * JD-Core Version:    0.7.0.1
 */