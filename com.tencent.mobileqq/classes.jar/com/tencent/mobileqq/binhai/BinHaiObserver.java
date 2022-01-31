package com.tencent.mobileqq.binhai;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class BinHaiObserver
  implements BusinessObserver
{
  public void a(int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, long paramLong, int paramInt3) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean1, String paramString1, int paramInt1, boolean paramBoolean2, int paramInt2, String paramString2, ArrayList paramArrayList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiObserver", 2, "type=" + paramInt + ", isSuccess=" + paramBoolean);
    }
    String str;
    label162:
    int i;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), String.valueOf(paramObject[1]));
      return;
    case 2: 
      localObject = (Object[])paramObject;
      int m = ((Integer)localObject[0]).intValue();
      str = localObject[1].toString();
      int j;
      int k;
      long l1;
      if (paramBoolean)
      {
        paramObject = localObject[2].toString();
        if (!paramBoolean) {
          break label273;
        }
        paramInt = ((Integer)localObject[3]).intValue();
        if (!paramBoolean) {
          break label278;
        }
        i = ((Integer)localObject[4]).intValue();
        if (!paramBoolean) {
          break label284;
        }
        j = ((Integer)localObject[5]).intValue();
        if (!paramBoolean) {
          break label290;
        }
        k = ((Integer)localObject[6]).intValue();
        if (!paramBoolean) {
          break label296;
        }
        l1 = ((Long)localObject[7]).longValue();
        if (!paramBoolean) {
          break label302;
        }
      }
      for (long l2 = ((Long)localObject[8]).longValue();; l2 = 1L)
      {
        a(paramBoolean, m, str, paramObject, paramInt, i, j, k, l1, l2);
        return;
        paramObject = "";
        break;
        paramInt = 0;
        break label162;
        i = 0;
        break label178;
        j = 0;
        break label194;
        k = 0;
        break label211;
        l1 = 1L;
        break label228;
      }
    case 3: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 4: 
      label178:
      label194:
      label211:
      label228:
      Object[] arrayOfObject = (Object[])paramObject;
      label273:
      label278:
      label284:
      label290:
      label296:
      label302:
      localObject = (String)arrayOfObject[0];
      paramInt = ((Integer)arrayOfObject[1]).intValue();
      boolean bool = ((Boolean)arrayOfObject[2]).booleanValue();
      i = ((Integer)arrayOfObject[3]).intValue();
      str = (String)arrayOfObject[4];
      paramObject = null;
      if (paramBoolean) {
        paramObject = (ArrayList)arrayOfObject[5];
      }
      a(paramBoolean, (String)localObject, paramInt, bool, i, str, paramObject);
      return;
    }
    paramObject = (Object[])paramObject;
    Object localObject = (String)paramObject[0];
    a(paramBoolean, ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (String)localObject, (String)paramObject[3]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.binhai.BinHaiObserver
 * JD-Core Version:    0.7.0.1
 */