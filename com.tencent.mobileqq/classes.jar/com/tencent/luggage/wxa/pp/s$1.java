package com.tencent.luggage.wxa.pp;

import android.text.method.NumberKeyListener;

class s$1
  extends NumberKeyListener
{
  s$1(s params) {}
  
  protected char[] getAcceptedChars()
  {
    return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 46, 88, 120 };
  }
  
  public int getInputType()
  {
    int i;
    if (this.a.n()) {
      i = 16;
    } else {
      i = 0;
    }
    return i | 0x2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.s.1
 * JD-Core Version:    0.7.0.1
 */