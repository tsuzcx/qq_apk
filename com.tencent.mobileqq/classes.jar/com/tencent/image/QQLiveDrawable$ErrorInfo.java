package com.tencent.image;

public class QQLiveDrawable$ErrorInfo
{
  public String detailInfo;
  public int extra;
  public Object info;
  public int model;
  public int what;
  
  public String toString()
  {
    String str;
    switch (this.model)
    {
    default: 
      str = " MODEL_UNKNOW ";
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ErrorInfo : [ model =").append(this.model);
      localStringBuilder.append("\n modelDesc = ").append(str);
      localStringBuilder.append("\n what = ").append(this.what);
      localStringBuilder.append("\n extra = ").append(this.extra);
      localStringBuilder.append("\n detainInfo = ").append(this.detailInfo);
      localStringBuilder.append("\n info = ").append(this.info);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      str = " MODEL_JAVA_LOGIC_ERR ";
      continue;
      str = " MODEL_PLAYER_CORE_ERR ";
      continue;
      str = " MODEL_CGI_GETVINFO_ERR ";
      continue;
      str = " MODEL_CGI_GETKEY_ERR ";
      continue;
      str = " MODEL_CGI_GETPROGINFO_ERR ";
      continue;
      str = " MODEL_DOWNLOAD_ERR ";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveDrawable.ErrorInfo
 * JD-Core Version:    0.7.0.1
 */