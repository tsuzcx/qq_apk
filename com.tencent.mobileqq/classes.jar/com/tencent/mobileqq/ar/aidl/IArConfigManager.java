package com.tencent.mobileqq.ar.aidl;

import android.os.IInterface;

public abstract interface IArConfigManager
  extends IInterface
{
  public abstract ARCommonConfigInfo a();
  
  public abstract ArConfigInfo a();
  
  public abstract ArEffectConfig a();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(ArConfigInfo paramArConfigInfo);
  
  public abstract void a(IArFaceCallback paramIArFaceCallback);
  
  public abstract void a(IArRemoteCallback paramIArRemoteCallback);
  
  public abstract void a(IArSoCallback paramIArSoCallback);
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(IArFaceCallback paramIArFaceCallback);
  
  public abstract void b(IArRemoteCallback paramIArRemoteCallback);
  
  public abstract void b(IArSoCallback paramIArSoCallback);
  
  public abstract boolean b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.IArConfigManager
 * JD-Core Version:    0.7.0.1
 */