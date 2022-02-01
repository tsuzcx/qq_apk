package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.ipc.annotation.RemoteCallBack;
import com.tencent.mobileqq.apollo.ipc.annotation.ServletImpl;

@ServletImpl(a=Cm3DMakeupImpl.class)
public abstract interface ICm3DMakeup
{
  public abstract void a(String paramString, @RemoteCallBack ICm3DMakeup.Save3DFaceListener paramSave3DFaceListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.ICm3DMakeup
 * JD-Core Version:    0.7.0.1
 */