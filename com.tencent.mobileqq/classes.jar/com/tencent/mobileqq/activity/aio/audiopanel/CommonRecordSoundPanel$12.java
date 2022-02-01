package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class CommonRecordSoundPanel$12
  implements QQPermissionCallback
{
  CommonRecordSoundPanel$12(CommonRecordSoundPanel paramCommonRecordSoundPanel) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel.12
 * JD-Core Version:    0.7.0.1
 */