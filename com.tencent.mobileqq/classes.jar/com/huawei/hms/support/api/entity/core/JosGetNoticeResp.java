package com.huawei.hms.support.api.entity.core;

import android.content.Intent;
import com.huawei.hms.core.aidl.annotation.Packed;

public class JosGetNoticeResp
  extends JosBaseResp
{
  @Packed
  private Intent noticeIntent;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public Intent getNoticeIntent()
  {
    return (Intent)get(this.noticeIntent);
  }
  
  public void setNoticeIntent(Intent paramIntent)
  {
    this.noticeIntent = paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.core.JosGetNoticeResp
 * JD-Core Version:    0.7.0.1
 */