package com.tencent.luggage.wxa.pp;

final class m$a
  implements CharSequence
{
  private CharSequence a;
  
  m$a(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
  }
  
  public char charAt(int paramInt)
  {
    return '●';
  }
  
  public int length()
  {
    return this.a.length();
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return this.a.subSequence(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.m.a
 * JD-Core Version:    0.7.0.1
 */