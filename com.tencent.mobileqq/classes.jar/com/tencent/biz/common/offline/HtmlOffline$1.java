package com.tencent.biz.common.offline;

import android.content.Context;
import nbt;
import nbv;
import nca;
import nci;

public final class HtmlOffline$1
  implements Runnable
{
  public HtmlOffline$1(Context paramContext, String paramString, nbt paramnbt) {}
  
  public void run()
  {
    if (nbv.a.a()) {
      nbv.a.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,Begin transThread:");
    }
    new nca(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Nbt).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.1
 * JD-Core Version:    0.7.0.1
 */