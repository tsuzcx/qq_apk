package com.tencent.mobileqq.applets;

import android.text.TextUtils;
import anxs;
import blbw;
import blbx;

public final class PublicAccountEventReport$4
  implements Runnable
{
  public PublicAccountEventReport$4(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3, String paramString4) {}
  
  public void run()
  {
    Object localObject = anxs.a(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = (int)(System.currentTimeMillis() / 1000L);
      localObject = new blbx(this.b + "_" + i, 1, this.jdField_a_of_type_Int, 1, "vab_push", "vab_push", (String)localObject, "vab_push", i);
      ((blbx)localObject).l = this.jdField_a_of_type_JavaLangString;
      ((blbx)localObject).jdField_f_of_type_JavaLangString = "vab_push";
      if (!this.jdField_a_of_type_Boolean) {
        break label125;
      }
    }
    label125:
    for (int i = 6;; i = -1)
    {
      ((blbx)localObject).jdField_f_of_type_Int = i;
      ((blbx)localObject).m = this.c;
      ((blbx)localObject).k = this.d;
      blbw.a().a((blbx)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.4
 * JD-Core Version:    0.7.0.1
 */