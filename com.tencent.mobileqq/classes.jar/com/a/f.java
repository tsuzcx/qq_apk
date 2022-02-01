package com.a;

public final class f
{
  private char[] a = new char[16];
  private int b;
  
  public f(int paramInt) {}
  
  private void a(int paramInt)
  {
    char[] arrayOfChar = new char[Math.max(this.a.length << 1, paramInt)];
    System.arraycopy(this.a, 0, arrayOfChar, 0, this.b);
    this.a = arrayOfChar;
  }
  
  public final void a(char paramChar)
  {
    int i = this.b + 1;
    if (i > this.a.length) {
      a(i);
    }
    this.a[this.b] = paramChar;
    this.b = i;
  }
  
  public final void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "null";
    }
    int i = str.length();
    int j = this.b + i;
    if (j > this.a.length) {
      a(j);
    }
    str.getChars(0, i, this.a, this.b);
    this.b = j;
  }
  
  public final String toString()
  {
    return new String(this.a, 0, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.a.f
 * JD-Core Version:    0.7.0.1
 */