package com.tencent.biz.common.offline;

import android.content.Context;
import myz;
import mzb;
import mzg;
import mzo;

public final class HtmlOffline$1
  implements Runnable
{
  public HtmlOffline$1(Context paramContext, String paramString, myz parammyz) {}
  
  public void run()
  {
    if (mzb.a.a()) {
      mzb.a.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,Begin transThread:");
    }
    new mzg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Myz).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.1
 * JD-Core Version:    0.7.0.1
 */