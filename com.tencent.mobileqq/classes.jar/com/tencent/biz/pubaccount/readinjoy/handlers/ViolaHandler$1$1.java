package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.net.Uri;
import rvd;

class ViolaHandler$1$1
  implements Runnable
{
  ViolaHandler$1$1(ViolaHandler.1 param1, String paramString) {}
  
  public void run()
  {
    if ("1".equals(Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("v_feeds_preload"))) {
      rvd.a().b(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.ViolaHandler.1.1
 * JD-Core Version:    0.7.0.1
 */