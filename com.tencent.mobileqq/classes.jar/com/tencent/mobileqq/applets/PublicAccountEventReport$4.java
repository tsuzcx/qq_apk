package com.tencent.mobileqq.applets;

import android.text.TextUtils;
import apeg;
import bnwq;
import bnwr;

public final class PublicAccountEventReport$4
  implements Runnable
{
  public PublicAccountEventReport$4(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = apeg.a(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = (int)(System.currentTimeMillis() / 1000L);
      localObject = new bnwr(this.b + "_" + i, 1, this.jdField_a_of_type_Int, 1, "vab_push", "vab_push", (String)localObject, "vab_push", i);
      ((bnwr)localObject).l = this.jdField_a_of_type_JavaLangString;
      ((bnwr)localObject).jdField_f_of_type_JavaLangString = "vab_push";
      if (!this.jdField_a_of_type_Boolean) {
        break label109;
      }
    }
    label109:
    for (int i = 6;; i = -1)
    {
      ((bnwr)localObject).jdField_f_of_type_Int = i;
      bnwq.a().a((bnwr)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.4
 * JD-Core Version:    0.7.0.1
 */