package com.tencent.ilinkservice;

import java.util.Vector;

final class ab
{
  private ar a = null;
  private final String b = "IlinkImSessionImpl";
  private String c;
  private Vector<Integer> d = new Vector();
  
  public ab(String paramString)
  {
    this.c = paramString;
  }
  
  void a()
  {
    ??? = af.a();
    int i = 0;
    ((af)???).a("IlinkImSessionImpl", "cancel all request", new Object[0]);
    synchronized (this.d)
    {
      while (i < this.d.size())
      {
        IlinkServiceImpl.getInstance().removeAppRequestTask(((Integer)this.d.get(i)).intValue());
        i += 1;
      }
      this.d.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(int paramInt)
  {
    af.a().a("IlinkImSessionImpl", "onLoginComplete", new Object[0]);
    ar localar = this.a;
    if (localar != null) {
      localar.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetDeviceShadow error:");
    localStringBuilder.append(paramInt2);
    ((af)localObject).a("IlinkImSessionImpl", localStringBuilder.toString(), new Object[0]);
    localObject = new Integer(paramInt1);
    if (this.d.contains(localObject))
    {
      this.d.remove(localObject);
      localObject = this.a;
      if (localObject != null) {
        ((ar)localObject).a(paramInt1, paramInt2, paramArrayOfByte);
      }
      return;
    }
    af.a().c("IlinkImSessionImpl", "Local task not exit!", new Object[0]);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    af.a().a("IlinkImSessionImpl", "onDeviceShadowUpdate", new Object[0]);
    ar localar = this.a;
    if (localar != null) {
      localar.a(paramArrayOfByte);
    }
  }
  
  public void b(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpdateDeviceShadow error:");
    localStringBuilder.append(paramInt2);
    ((af)localObject).a("IlinkImSessionImpl", localStringBuilder.toString(), new Object[0]);
    localObject = new Integer(paramInt1);
    if (this.d.contains(localObject))
    {
      this.d.remove(localObject);
      localObject = this.a;
      if (localObject != null) {
        ((ar)localObject).b(paramInt1, paramInt2, paramArrayOfByte);
      }
      return;
    }
    af.a().c("IlinkImSessionImpl", "Local task not exit!", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.ab
 * JD-Core Version:    0.7.0.1
 */