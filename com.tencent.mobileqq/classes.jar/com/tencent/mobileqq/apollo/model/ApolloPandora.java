package com.tencent.mobileqq.apollo.model;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ApolloPandora
  extends Entity
{
  public static final int BOX_TYPE_BEAN = 3;
  public static final int BOX_TYPE_CARD = 1;
  public static final int BOX_TYPE_CRYSTAL = 2;
  public static final int BOX_TYPE_NONE = -1;
  public short boxSubType;
  public short boxType;
  public short canSteal;
  public long checkPoint;
  public short hadStolen;
  public String mBoxTipUrl;
  public long queryInterval;
  @unique
  public String uin;
  public long updateTime;
  
  public boolean needShow(int paramInt)
  {
    boolean bool2 = TextUtils.isEmpty(this.mBoxTipUrl);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramInt == this.boxType) {
      return false;
    }
    if (this.hadStolen == 0) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloPandora
 * JD-Core Version:    0.7.0.1
 */