package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class CommonRecordSoundPanel$4
  implements QQPermissionCallback
{
  CommonRecordSoundPanel$4(CommonRecordSoundPanel paramCommonRecordSoundPanel) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel.4
 * JD-Core Version:    0.7.0.1
 */