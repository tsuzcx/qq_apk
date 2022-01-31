package com.google.gson.internal;

class Streams$AppendableWriter$CurrentWrite
  implements CharSequence
{
  char[] chars;
  
  public char charAt(int paramInt)
  {
    return this.chars[paramInt];
  }
  
  public int length()
  {
    return this.chars.length;
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return new String(this.chars, paramInt1, paramInt2 - paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.internal.Streams.AppendableWriter.CurrentWrite
 * JD-Core Version:    0.7.0.1
 */