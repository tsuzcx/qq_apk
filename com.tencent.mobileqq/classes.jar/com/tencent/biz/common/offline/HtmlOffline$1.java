package com.tencent.biz.common.offline;

import android.content.Context;
import mod;
import mof;
import mok;
import mos;

public final class HtmlOffline$1
  implements Runnable
{
  public HtmlOffline$1(Context paramContext, String paramString, mod parammod) {}
  
  public void run()
  {
    if (mof.a.a()) {
      mof.a.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,Begin transThread:");
    }
    new mok(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Mod).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.1
 * JD-Core Version:    0.7.0.1
 */