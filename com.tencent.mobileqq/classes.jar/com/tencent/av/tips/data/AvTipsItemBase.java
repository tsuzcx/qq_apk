package com.tencent.av.tips.data;

import com.tencent.av.business.manager.tips.TipsManager;

public abstract class AvTipsItemBase
{
  protected int a;
  protected String a;
  protected int b = 0;
  protected int c = 3;
  protected int d = 0;
  protected int e = 1;
  
  protected AvTipsItemBase(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.d = paramInt2;
    this.c = paramInt3;
    this.e = paramInt4;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean a(AvTipsItemBase paramAvTipsItemBase1, AvTipsItemBase paramAvTipsItemBase2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramAvTipsItemBase2 == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramAvTipsItemBase1 == null);
          i = paramAvTipsItemBase2.e();
          j = paramAvTipsItemBase1.e();
          TipsManager.a("CheckAvTipsItemLevelCanShow, lvNew[" + i + "], lvOld[" + j + "], idNew[" + paramAvTipsItemBase2.b() + "], idOld[" + paramAvTipsItemBase1.b() + "]");
          bool1 = bool2;
        } while (i < j);
        if (i > j) {
          return false;
        }
        bool1 = bool2;
      } while (paramAvTipsItemBase1.a());
      if (paramAvTipsItemBase2.a()) {
        return false;
      }
      bool1 = bool2;
    } while (paramAvTipsItemBase2.c() <= paramAvTipsItemBase1.c());
    return false;
  }
  
  public abstract int a();
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public boolean a()
  {
    return this.c == 0;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof AvTipsItemBase))) {}
    do
    {
      return false;
      paramObject = (AvTipsItemBase)paramObject;
    } while (b() != paramObject.b());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.tips.data.AvTipsItemBase
 * JD-Core Version:    0.7.0.1
 */