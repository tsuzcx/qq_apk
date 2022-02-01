package com.tencent.av.app;

import com.tencent.qphone.base.util.QLog;

public class SessionInfoBase
  extends DeprecatedClass.Session
{
  protected long cM = 0L;
  protected int cN = 0;
  
  public long D()
  {
    return this.cM;
  }
  
  public int E()
  {
    return this.cN;
  }
  
  public void e(int paramInt)
  {
    this.cN = paramInt;
  }
  
  public void e(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRoomId old room id[");
    localStringBuilder.append(this.cM);
    localStringBuilder.append("], new room id[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("].");
    QLog.i("SessionInfoBase", 1, localStringBuilder.toString());
    this.cM = paramLong;
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
      return this.cM == paramObject.cM;
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.cM;
    return (int)(l ^ l >>> 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.SessionInfoBase
 * JD-Core Version:    0.7.0.1
 */