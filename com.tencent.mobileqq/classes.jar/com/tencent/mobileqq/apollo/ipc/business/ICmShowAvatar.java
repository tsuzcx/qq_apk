package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.apollo.player.ICMSRecordCallback;

@ServletImpl(a=CmShowAvatarImpl.class)
public abstract interface ICmShowAvatar
{
  public abstract void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ICMSRecordCallback paramICMSRecordCallback);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, int paramInt3, ICmShowAvatar.IAvatarInterface paramIAvatarInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.ICmShowAvatar
 * JD-Core Version:    0.7.0.1
 */