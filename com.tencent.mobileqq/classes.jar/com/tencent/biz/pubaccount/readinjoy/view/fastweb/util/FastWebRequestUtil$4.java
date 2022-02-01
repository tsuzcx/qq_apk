package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import java.util.ArrayList;
import tjm;
import tjr;
import ukp;

public final class FastWebRequestUtil$4
  implements Runnable
{
  public FastWebRequestUtil$4(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt1, long paramLong, String paramString7, int paramInt2, tjr paramtjr) {}
  
  public void run()
  {
    boolean bool2 = false;
    ArrayList localArrayList = new ArrayList();
    String str = tjm.a(tjm.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.d, this.e, this.f, this.jdField_a_of_type_Boolean, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long), tjm.a(this.g, this.jdField_b_of_type_Int));
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (tjm.a(str, this.jdField_b_of_type_JavaLangString, localArrayList, ukp.a(this.jdField_a_of_type_JavaLangString, this.d, this.g)))
      {
        bool1 = true;
        tjm.a(localArrayList);
      }
    }
    if (this.jdField_a_of_type_Tjr != null) {
      this.jdField_a_of_type_Tjr.a(bool1, localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.4
 * JD-Core Version:    0.7.0.1
 */