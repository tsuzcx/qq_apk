package com.qq.taf.jce.dynamic;

public class StringField
  extends JceField
{
  private String data;
  
  StringField(String paramString, int paramInt)
  {
    super(paramInt);
    this.data = paramString;
  }
  
  public String get()
  {
    return this.data;
  }
  
  public void set(String paramString)
  {
    this.data = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.StringField
 * JD-Core Version:    0.7.0.1
 */