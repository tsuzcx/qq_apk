package com.tencent.biz.common.offline;

import android.content.Context;
import nmh;
import nmj;
import nmo;
import nmw;

public final class HtmlOffline$1
  implements Runnable
{
  public HtmlOffline$1(Context paramContext, String paramString, nmh paramnmh) {}
  
  public void run()
  {
    if (nmj.a.a()) {
      nmj.a.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,Begin transThread:");
    }
    new nmo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Nmh).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.1
 * JD-Core Version:    0.7.0.1
 */