package com.tencent.biz.common.offline;

import android.content.Context;
import nux;
import nuz;
import nve;
import nvm;

public final class HtmlOffline$1
  implements Runnable
{
  public HtmlOffline$1(Context paramContext, String paramString, nux paramnux) {}
  
  public void run()
  {
    if (nuz.a.a()) {
      nuz.a.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,Begin transThread:");
    }
    new nve(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Nux).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.1
 * JD-Core Version:    0.7.0.1
 */