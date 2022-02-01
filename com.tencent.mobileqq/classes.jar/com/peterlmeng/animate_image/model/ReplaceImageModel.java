package com.peterlmeng.animate_image.model;

public class ReplaceImageModel
{
  public int index;
  public String packagePath;
  public String path;
  
  public ReplaceImageModel(int paramInt, String paramString)
  {
    this(paramInt, paramString, null);
  }
  
  public ReplaceImageModel(int paramInt, String paramString1, String paramString2)
  {
    this.index = paramInt;
    this.path = paramString1;
    this.packagePath = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.model.ReplaceImageModel
 * JD-Core Version:    0.7.0.1
 */