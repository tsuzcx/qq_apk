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
    boolean bool = false;
    if (paramAvTipsItemBase2 == null) {
      return false;
    }
    if (paramAvTipsItemBase1 == null) {
      return true;
    }
    int i = paramAvTipsItemBase2.e();
    int j = paramAvTipsItemBase1.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CheckAvTipsItemLevelCanShow, lvNew[");
    localStringBuilder.append(i);
    localStringBuilder.append("], lvOld[");
    localStringBuilder.append(j);
    localStringBuilder.append("], idNew[");
    localStringBuilder.append(paramAvTipsItemBase2.b());
    localStringBuilder.append("], idOld[");
    localStringBuilder.append(paramAvTipsItemBase1.b());
    localStringBuilder.append("]");
    TipsManager.a(localStringBuilder.toString());
    if (i < j) {
      return true;
    }
    if (i > j) {
      return false;
    }
    if (paramAvTipsItemBase1.a()) {
      return true;
    }
    if (paramAvTipsItemBase2.a()) {
      return false;
    }
    if (paramAvTipsItemBase2.c() <= paramAvTipsItemBase1.c()) {
      bool = true;
    }
    return bool;
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof AvTipsItemBase)) {
        return false;
      }
      paramObject = (AvTipsItemBase)paramObject;
      bool1 = bool2;
      if (b() == paramObject.b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.data.AvTipsItemBase
 * JD-Core Version:    0.7.0.1
 */