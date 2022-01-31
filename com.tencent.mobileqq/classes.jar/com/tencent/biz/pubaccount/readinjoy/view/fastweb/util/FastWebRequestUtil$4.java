package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import java.util.ArrayList;
import oas;
import rmu;
import rmz;

public final class FastWebRequestUtil$4
  implements Runnable
{
  public FastWebRequestUtil$4(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt, String paramString7, rmz paramrmz) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    String str = rmu.a(rmu.a(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.e, this.f, this.jdField_a_of_type_Boolean, 2, this.jdField_a_of_type_Int), rmu.a(this.g));
    if ((str != null) && (rmu.a(str, this.b, localArrayList, oas.a(this.jdField_a_of_type_JavaLangString, this.d, this.g)))) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_Rmz != null) {
        this.jdField_a_of_type_Rmz.a(bool, localArrayList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.4
 * JD-Core Version:    0.7.0.1
 */