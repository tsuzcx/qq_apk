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
    return "TipsInfo{valid=" + this.valid + ", ret=" + this.ret + ", type=" + this.type + ", titleWording='" + this.titleWording + '\'' + ", wording='" + this.wording + '\'' + ", rightBtnWording='" + this.rightBtnWording + '\'' + ", leftBtnWording='" + this.leftBtnWording + '\'' + ", vipType='" + this.vipType + '\'' + ", vipMonth=" + this.vipMonth + ", url='" + this.url + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.PendantTipsInfo
 * JD-Core Version:    0.7.0.1
 */