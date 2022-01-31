package com.tencent.biz.pubaccount;

import bdcb;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.qqmini.sdk.utils.LiuHaiUtils;
import com.tencent.widget.FadeIconImageView;
import npx;
import xee;

public class PublicAccountBrowser$12$1
  implements Runnable
{
  public PublicAccountBrowser$12$1(npx paramnpx, String paramString) {}
  
  public void run()
  {
    int i = (int)(bdcb.k() - PublicAccountBrowser.b(this.jdField_a_of_type_Npx.a).getWidth() - xee.b(this.jdField_a_of_type_Npx.a, 10.0F));
    int j = PublicAccountBrowser.a(this.jdField_a_of_type_Npx.a).getHeight();
    int k = xee.b(this.jdField_a_of_type_Npx.a, 15.0F);
    int m = LiuHaiUtils.getStatusBarHeight(this.jdField_a_of_type_Npx.a);
    PublicAccountBrowser.a(this.jdField_a_of_type_Npx.a, PublicAccountBrowser.b(this.jdField_a_of_type_Npx.a), i, j + k + m, false, false, this.jdField_a_of_type_JavaLangString, RIJRedPacketManager.a().d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.12.1
 * JD-Core Version:    0.7.0.1
 */