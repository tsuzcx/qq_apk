package com.tencent.mobileqq.avatar.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IQQAvatarBroadcastService
  extends IRuntimeService
{
  public abstract void headQQHeadBroadcast(Intent paramIntent);
  
  public abstract void sendQQHeadBroadcast(int paramInt1, String paramString1, int paramInt2, String paramString2);
  
  public abstract void sendSelfQQHeadBroadcast(int paramInt1, String paramString1, int paramInt2, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastService
 * JD-Core Version:    0.7.0.1
 */