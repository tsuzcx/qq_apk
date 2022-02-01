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
    int i = this.model;
    String str;
    if (i != 101)
    {
      if (i != 102)
      {
        if (i != 104)
        {
          if (i != 230)
          {
            if (i != 122)
            {
              if (i != 123) {
                str = " MODEL_UNKNOW ";
              } else {
                str = " MODEL_JAVA_LOGIC_ERR ";
              }
            }
            else {
              str = " MODEL_PLAYER_CORE_ERR ";
            }
          }
          else {
            str = " MODEL_DOWNLOAD_ERR ";
          }
        }
        else {
          str = " MODEL_CGI_GETPROGINFO_ERR ";
        }
      }
      else {
        str = " MODEL_CGI_GETKEY_ERR ";
      }
    }
    else {
      str = " MODEL_CGI_GETVINFO_ERR ";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ErrorInfo : [ model =");
    localStringBuilder.append(this.model);
    localStringBuilder.append("\n modelDesc = ");
    localStringBuilder.append(str);
    localStringBuilder.append("\n what = ");
    localStringBuilder.append(this.what);
    localStringBuilder.append("\n extra = ");
    localStringBuilder.append(this.extra);
    localStringBuilder.append("\n detainInfo = ");
    localStringBuilder.append(this.detailInfo);
    localStringBuilder.append("\n info = ");
    localStringBuilder.append(this.info);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.QQLiveDrawable.ErrorInfo
 * JD-Core Version:    0.7.0.1
 */