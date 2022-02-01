package com.tencent.featuretoggle.hltxkg.common.a;

final class n$a
{
  public String a;
  public boolean a;
  private String[] a;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  
  public n$a(n paramn, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    paramn = paramString1.split("-");
    if (paramn.length < 5)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "all", "all", "all", "all", "all" };
      int i = 0;
      while (i < paramn.length)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = paramn[i];
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramn;
    paramn = new StringBuilder();
    paramn.append(paramInt);
    this.b = a(0, paramn.toString());
    this.c = a(1, paramString2);
    this.d = a(2, paramString3);
    this.e = a(3, paramString4);
    this.f = a(4, paramString5);
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    boolean bool1;
    if (arrayOfString.length >= paramInt + 1)
    {
      boolean bool2 = arrayOfString[paramInt].equals(paramString);
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ArrayOfJavaLangString[paramInt].equals("all"))
        {
          this.jdField_a_of_type_Boolean = false;
          return bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.n.a
 * JD-Core Version:    0.7.0.1
 */