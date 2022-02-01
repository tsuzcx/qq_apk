package com.tencent.ad.tangram.preorder;

import android.text.TextUtils;

public final class AdAppPreOrderTask$a
  implements Cloneable
{
  public static final int STAGE_QQREMINDER_BEGIN = 0;
  public static final int STAGE_QQREMINDER_CLICKED = 6;
  public static final int STAGE_QQREMINDER_DISPLAYED = 5;
  public static final int STAGE_QQREMINDER_END = 6;
  public static final int STAGE_QQREMINDER_NOTIFIED = 4;
  public static final int STAGE_QQREMINDER_SCHEDULED = 3;
  public static final int STAGE_QQREMINDER_SWITCH_FAILED = 1;
  public static final int STAGE_QQREMINDER_SWITCH_ON_START = 0;
  public static final int STAGE_QQREMINDER_SWITCH_SUCCESS = 2;
  public String id;
  public long scheduleTimeMillis = -2147483648L;
  
  public static int getIndex(int paramInt)
  {
    if ((paramInt >= 12) && (paramInt <= AdAppPreOrderTask.Status.QQREMINDER_END)) {
      return (paramInt - 12) / 7;
    }
    return -2147483648;
  }
  
  public static int getStage(int paramInt)
  {
    if ((paramInt >= 12) && (paramInt <= AdAppPreOrderTask.Status.QQREMINDER_END)) {
      return (paramInt - 12) % 7;
    }
    return -2147483648;
  }
  
  public static int getStatus(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {
      return paramInt2 * 7 + 12 + paramInt1;
    }
    return -2147483648;
  }
  
  protected Object clone()
  {
    return super.clone();
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.id)) && (this.scheduleTimeMillis != -2147483648L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderTask.a
 * JD-Core Version:    0.7.0.1
 */