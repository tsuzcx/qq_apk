package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import java.util.ArrayList;
import oec;
import scq;
import scv;

public final class FastWebRequestUtil$4
  implements Runnable
{
  public FastWebRequestUtil$4(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt1, long paramLong, String paramString7, int paramInt2, scv paramscv) {}
  
  public void run()
  {
    boolean bool2 = false;
    ArrayList localArrayList = new ArrayList();
    String str = scq.a(scq.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.d, this.e, this.f, this.jdField_a_of_type_Boolean, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long), scq.a(this.g, this.jdField_b_of_type_Int));
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (scq.a(str, this.jdField_b_of_type_JavaLangString, localArrayList, oec.a(this.jdField_a_of_type_JavaLangString, this.d, this.g))) {
        bool1 = true;
      }
    }
    if (this.jdField_a_of_type_Scv != null) {
      this.jdField_a_of_type_Scv.a(bool1, localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.4
 * JD-Core Version:    0.7.0.1
 */