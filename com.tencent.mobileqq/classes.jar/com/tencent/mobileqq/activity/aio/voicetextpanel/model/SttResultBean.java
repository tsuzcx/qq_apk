package com.tencent.mobileqq.activity.aio.voicetextpanel.model;

public class SttResultBean
{
  public String a;
  public boolean b;
  
  public SttResultBean(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResultBean{rtext='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isFinish=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.model.SttResultBean
 * JD-Core Version:    0.7.0.1
 */