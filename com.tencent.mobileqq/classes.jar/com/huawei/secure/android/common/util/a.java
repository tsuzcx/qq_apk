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
    boolean bool2 = false;
    if (paramCharacter == null) {
      return false;
    }
    int i = paramCharacter.charValue();
    boolean bool1;
    if (((i < 48) || (i > 57)) && ((i < 97) || (i > 102)))
    {
      bool1 = bool2;
      if (i >= 65)
      {
        bool1 = bool2;
        if (i > 70) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean c(Character paramCharacter)
  {
    boolean bool2 = false;
    if (paramCharacter == null) {
      return false;
    }
    int i = paramCharacter.charValue();
    boolean bool1 = bool2;
    if (i >= 48)
    {
      bool1 = bool2;
      if (i <= 55) {
        bool1 = true;
      }
    }
    return bool1;
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
    Object localObject = this.r;
    if (localObject != null)
    {
      this.r = null;
      return localObject;
    }
    localObject = this.q;
    if (localObject == null) {
      return null;
    }
    if (((String)localObject).length() == 0) {
      return null;
    }
    if (this.index >= this.q.length()) {
      return null;
    }
    localObject = this.q;
    int i = this.index;
    this.index = (i + 1);
    return Character.valueOf(((String)localObject).charAt(i));
  }
  
  public Character c()
  {
    Character localCharacter = b();
    if (localCharacter == null) {
      return null;
    }
    if (b(localCharacter)) {
      return localCharacter;
    }
    return null;
  }
  
  public boolean c(char paramChar)
  {
    Object localObject = this.r;
    if ((localObject != null) && (((Character)localObject).charValue() == paramChar)) {
      return true;
    }
    localObject = this.q;
    if (localObject == null) {
      return false;
    }
    if (((String)localObject).length() == 0) {
      return false;
    }
    if (this.index >= this.q.length()) {
      return false;
    }
    return this.q.charAt(this.index) == paramChar;
  }
  
  public Character d()
  {
    Character localCharacter = b();
    if (localCharacter == null) {
      return null;
    }
    if (c(localCharacter)) {
      return localCharacter;
    }
    return null;
  }
  
  public Character e()
  {
    Object localObject = this.r;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.q;
    if (localObject == null) {
      return null;
    }
    if (((String)localObject).length() == 0) {
      return null;
    }
    if (this.index >= this.q.length()) {
      return null;
    }
    return Character.valueOf(this.q.charAt(this.index));
  }
  
  public void f()
  {
    this.s = this.r;
    this.mark = this.index;
  }
  
  protected String g()
  {
    String str = this.q.substring(this.index);
    Object localObject = str;
    if (this.r != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public boolean hasNext()
  {
    if (this.r != null) {
      return true;
    }
    String str = this.q;
    if (str == null) {
      return false;
    }
    if (str.length() == 0) {
      return false;
    }
    return this.index < this.q.length();
  }
  
  public void reset()
  {
    this.r = this.s;
    this.index = this.mark;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.a
 * JD-Core Version:    0.7.0.1
 */