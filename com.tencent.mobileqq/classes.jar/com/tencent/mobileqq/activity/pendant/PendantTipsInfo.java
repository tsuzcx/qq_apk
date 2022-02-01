package com.tencent.mobileqq.activity.pendant;

import java.io.Serializable;

public class PendantTipsInfo
  implements Serializable
{
  public static final int TYPE_JUMP_URL = 2;
  public static final int TYPE_JUMP_URL_WITHOUT_TIPS = 3;
  public static final int TYPE_PAYMENT = 1;
  public String leftBtnWording;
  public int ret;
  public String rightBtnWording;
  public String titleWording;
  public int type = -1;
  public String url;
  public boolean valid = false;
  public int vipMonth;
  public String vipType;
  public String wording;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TipsInfo{valid=");
    localStringBuilder.append(this.valid);
    localStringBuilder.append(", ret=");
    localStringBuilder.append(this.ret);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", titleWording='");
    localStringBuilder.append(this.titleWording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", wording='");
    localStringBuilder.append(this.wording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rightBtnWording='");
    localStringBuilder.append(this.rightBtnWording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", leftBtnWording='");
    localStringBuilder.append(this.leftBtnWording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", vipType='");
    localStringBuilder.append(this.vipType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", vipMonth=");
    localStringBuilder.append(this.vipMonth);
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.PendantTipsInfo
 * JD-Core Version:    0.7.0.1
 */