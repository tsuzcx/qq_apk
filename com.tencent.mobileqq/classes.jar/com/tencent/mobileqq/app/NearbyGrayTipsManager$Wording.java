package com.tencent.mobileqq.app;

import java.io.Serializable;

public class NearbyGrayTipsManager$Wording
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String highlightText;
  public String text;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wording{text='");
    localStringBuilder.append(this.text);
    localStringBuilder.append('\'');
    localStringBuilder.append(", highlightText='");
    localStringBuilder.append(this.highlightText);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager.Wording
 * JD-Core Version:    0.7.0.1
 */