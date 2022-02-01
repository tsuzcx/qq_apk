package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.BusinessObserver;

public class DynamicAvatarInfoObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean1, DynamicAvatarInfo paramDynamicAvatarInfo, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1001) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    long l = -1L;
    int j;
    int i;
    boolean bool;
    if ((arrayOfObject != null) && (arrayOfObject.length == 6))
    {
      paramObject = (DynamicAvatarInfo)arrayOfObject[0];
      l = ((Long)arrayOfObject[1]).longValue();
      j = ((Integer)arrayOfObject[2]).intValue();
      paramInt = ((Integer)arrayOfObject[3]).intValue();
      i = ((Integer)arrayOfObject[4]).intValue();
      bool = ((Boolean)arrayOfObject[5]).booleanValue();
    }
    else
    {
      paramObject = null;
      j = -1;
      paramInt = -1;
      i = -1;
      bool = false;
    }
    a(paramBoolean, paramObject, Long.valueOf(l), j, paramInt, i, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfoObserver
 * JD-Core Version:    0.7.0.1
 */