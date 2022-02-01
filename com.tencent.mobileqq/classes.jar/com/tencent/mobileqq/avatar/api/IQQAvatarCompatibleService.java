package com.tencent.mobileqq.avatar.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface IQQAvatarCompatibleService
  extends IRuntimeService
{
  public abstract Bitmap getFaceBitmap(int paramInt1, String paramString, byte paramByte1, int paramInt2, boolean paramBoolean, byte paramByte2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService
 * JD-Core Version:    0.7.0.1
 */