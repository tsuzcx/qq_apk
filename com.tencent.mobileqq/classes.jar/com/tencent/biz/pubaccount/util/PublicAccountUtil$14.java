package com.tencent.biz.pubaccount.util;

import android.net.Uri;
import ndn;

public final class PublicAccountUtil$14
  implements Runnable
{
  public PublicAccountUtil$14(Uri paramUri, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      ndn.a(null, "dc00899", "Pb_account_lifeservice", "", "0X8006510", "0X8006510", 0, 0, this.jdField_a_of_type_AndroidNetUri.getQueryParameter("article_id"), this.jdField_a_of_type_Int + "", this.jdField_a_of_type_JavaLangString, "", false);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.14
 * JD-Core Version:    0.7.0.1
 */