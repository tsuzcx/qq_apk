package com.rookery.translate.model;

public class Trans_entity
{
  private final String a;
  private Boolean b;
  
  public Trans_entity(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = Boolean.valueOf(paramBoolean);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void b()
  {
    this.b = Boolean.valueOf(this.b.booleanValue() ^ true);
  }
  
  public Boolean c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.model.Trans_entity
 * JD-Core Version:    0.7.0.1
 */