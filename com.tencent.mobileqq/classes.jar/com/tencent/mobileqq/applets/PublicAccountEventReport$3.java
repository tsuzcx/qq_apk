package com.tencent.mobileqq.applets;

import amrz;
import android.text.TextUtils;
import bkgp;
import bkgq;

public final class PublicAccountEventReport$3
  implements Runnable
{
  public PublicAccountEventReport$3(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = amrz.a(this.jdField_a_of_type_JavaLangString);
    int j;
    String str;
    int k;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      j = (int)(System.currentTimeMillis() / 1000L);
      str = this.b + "_" + j;
      k = this.jdField_a_of_type_Int;
      if (!this.jdField_a_of_type_Boolean) {
        break label117;
      }
    }
    label117:
    for (int i = 6;; i = 1)
    {
      localObject = new bkgq(str, 1, k, i, "vab_push", "vab_push", (String)localObject, "vab_push", j);
      ((bkgq)localObject).l = this.jdField_a_of_type_JavaLangString;
      ((bkgq)localObject).f = "vab_push";
      bkgp.a().a((bkgq)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.3
 * JD-Core Version:    0.7.0.1
 */