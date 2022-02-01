package com.huawei.secure.android.common.util;

public class a
{
  private int index = 0;
  private int mark = 0;
  private String q;
  private Character r;
  private Character s;
  
  public a(String paramString)
  {
    this.q = paramString;
  }
  
  public static boolean b(Character paramCharacter)
  {
    if (paramCharacter == null) {}
    int i;
    do
    {
      return false;
      i = paramCharacter.charValue();
    } while (((i < 48) || (i > 57)) && ((i < 97) || (i > 102)) && ((i < 65) || (i > 70)));
    return true;
  }
  
  public static boolean c(Character paramCharacter)
  {
    if (paramCharacter == null) {}
    int i;
    do
    {
      return false;
      i = paramCharacter.charValue();
    } while ((i < 48) || (i > 55));
    return true;
  }
  
  public int a()
  {
    return this.index;
  }
  
  public void a(Character paramCharacter)
  {
    this.r = paramCharacter;
  }
  
  public Character b()
  {
    if (this.r != null)
    {
      localObject = this.r;
      this.r = null;
      return localObject;
    }
    if (this.q == null) {
      return null;
    }
    if (this.q.length() == 0) {
      return null;
    }
    if (this.index >= this.q.length()) {
      return null;
    }
    Object localObject = this.q;
    int i = this.index;
    this.index = (i + 1);
    return Character.valueOf(((String)localObject).charAt(i));
  }
  
  public Character c()
  {
    Character localCharacter = b();
    if (localCharacter == null) {}
    while (!b(localCharacter)) {
      return null;
    }
    return localCharacter;
  }
  
  public boolean c(char paramChar)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if ((this.r != null) && (this.r.charValue() == paramChar)) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (this.q == null);
        bool1 = bool3;
      } while (this.q.length() == 0);
      bool1 = bool3;
    } while (this.index >= this.q.length());
    if (this.q.charAt(this.index) == paramChar) {}
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public Character d()
  {
    Character localCharacter = b();
    if (localCharacter == null) {}
    while (!c(localCharacter)) {
      return null;
    }
    return localCharacter;
  }
  
  public Character e()
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.r != null) {
      localObject1 = this.r;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (this.q == null);
        localObject1 = localObject2;
      } while (this.q.length() == 0);
      localObject1 = localObject2;
    } while (this.index >= this.q.length());
    return Character.valueOf(this.q.charAt(this.index));
  }
  
  public void f()
  {
    this.s = this.r;
    this.mark = this.index;
  }
  
  protected String g()
  {
    String str2 = this.q.substring(this.index);
    String str1 = str2;
    if (this.r != null) {
      str1 = this.r + str2;
    }
    return str1;
  }
  
  public boolean hasNext()
  {
    if (this.r != null) {}
    do
    {
      return true;
      if (this.q == null) {
        return false;
      }
      if (this.q.length() == 0) {
        return false;
      }
    } while (this.index < this.q.length());
    return false;
  }
  
  public void reset()
  {
    this.r = this.s;
    this.index = this.mark;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.util.a
 * JD-Core Version:    0.7.0.1
 */