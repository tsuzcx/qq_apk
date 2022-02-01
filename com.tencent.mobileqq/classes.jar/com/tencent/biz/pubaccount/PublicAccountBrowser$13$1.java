package com.tencent.biz.pubaccount;

import bgln;
import bqcd;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.widget.FadeIconImageView;
import nyt;
import zby;

public class PublicAccountBrowser$13$1
  implements Runnable
{
  public PublicAccountBrowser$13$1(nyt paramnyt, String paramString) {}
  
  public void run()
  {
    int i = (int)(bgln.k() - PublicAccountBrowser.b(this.jdField_a_of_type_Nyt.a).getWidth() - zby.b(this.jdField_a_of_type_Nyt.a, 10.0F));
    int j = PublicAccountBrowser.a(this.jdField_a_of_type_Nyt.a).getHeight();
    int k = zby.b(this.jdField_a_of_type_Nyt.a, 15.0F);
    int m = bqcd.a(this.jdField_a_of_type_Nyt.a);
    PublicAccountBrowser.a(this.jdField_a_of_type_Nyt.a, PublicAccountBrowser.b(this.jdField_a_of_type_Nyt.a), i, j + k + m, false, false, this.jdField_a_of_type_JavaLangString, RIJRedPacketManager.a().d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.13.1
 * JD-Core Version:    0.7.0.1
 */