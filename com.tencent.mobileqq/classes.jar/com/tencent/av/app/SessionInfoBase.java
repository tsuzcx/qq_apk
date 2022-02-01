package com.tencent.av.app;

import com.tencent.qphone.base.util.QLog;

public class SessionInfoBase
  extends DeprecatedClass.Session
{
  protected int ah = 0;
  protected long l = 0L;
  
  public long b()
  {
    return this.l;
  }
  
  public void c(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRoomId old room id[");
    localStringBuilder.append(this.l);
    localStringBuilder.append("], new room id[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("].");
    QLog.i("SessionInfoBase", 1, localStringBuilder.toString());
    this.l = paramLong;
  }
  
  public int d()
  {
    return this.ah;
  }
  
  public void e(int paramInt)
  {
    this.ah = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (SessionInfoBase)paramObject;
      return this.l == paramObject.l;
    }
    return false;
  }
  
  public int hashCode()
  {
    long l1 = this.l;
    return (int)(l1 ^ l1 >>> 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.SessionInfoBase
 * JD-Core Version:    0.7.0.1
 */