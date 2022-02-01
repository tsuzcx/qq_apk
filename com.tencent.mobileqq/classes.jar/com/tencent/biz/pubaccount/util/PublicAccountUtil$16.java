package com.tencent.biz.pubaccount.util;

import android.net.Uri;
import ocd;

public final class PublicAccountUtil$16
  implements Runnable
{
  public PublicAccountUtil$16(Uri paramUri, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        String str = this.jdField_a_of_type_AndroidNetUri.getQueryParameter("article_id");
        int i = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_Int == 0)
        {
          i = 100;
          ocd.a(null, "dc00899", "Pb_account_lifeservice", "", "0X8006DF8", "0X8006DF8", this.b, 0, str, this.jdField_a_of_type_JavaLangString, "" + i, "", false);
          ocd.a("0X8006DF8", "", str, this.jdField_a_of_type_JavaLangString, "" + i, "" + this.b);
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.16
 * JD-Core Version:    0.7.0.1
 */