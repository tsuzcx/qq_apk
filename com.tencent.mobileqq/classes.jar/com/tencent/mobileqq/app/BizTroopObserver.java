package com.tencent.mobileqq.app;

import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BizTroopObserver
  implements BusinessObserver
{
  private final String a = "BizTroopObserver";
  
  public void a(int paramInt1, int paramInt2, Map paramMap, String paramString) {}
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString) {}
  
  public void a(TroopGagMgr.GagStatus paramGagStatus) {}
  
  public void a(Object paramObject) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList paramArrayList, int paramInt4) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, List paramList) {}
  
  protected void a(boolean paramBoolean, List paramList) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(Object paramObject) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void c(Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject) {}
  
  protected void h(boolean paramBoolean, Object paramObject) {}
  
  protected void i(boolean paramBoolean, Object paramObject) {}
  
  public void j(boolean paramBoolean, Object paramObject) {}
  
  protected void k(boolean paramBoolean, Object paramObject) {}
  
  public void l(boolean paramBoolean, Object paramObject) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = 0;
    if ((paramObject instanceof Object[])) {}
    for (Object localObject = (Object[])paramObject;; localObject = null)
    {
      switch (paramInt)
      {
      }
      label545:
      label580:
      label585:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        e(paramBoolean, paramObject);
                        return;
                        a(paramObject);
                        return;
                        h(paramBoolean, paramObject);
                        return;
                      } while (localObject == null);
                      if (paramBoolean)
                      {
                        a(paramBoolean, (String)localObject[0], ((Boolean)localObject[1]).booleanValue(), (List)localObject[2]);
                        return;
                      }
                      a(paramBoolean, (String)localObject[0], ((Boolean)localObject[1]).booleanValue(), null);
                      return;
                      f(paramBoolean, paramObject);
                      return;
                      g(paramBoolean, paramObject);
                      return;
                      a(paramBoolean, (List)paramObject);
                      return;
                    } while (localObject == null);
                    if (paramBoolean)
                    {
                      a(true, ((Integer)localObject[0]).intValue(), ((Integer)localObject[1]).intValue(), ((Integer)localObject[2]).intValue(), (ArrayList)localObject[3], 0);
                      return;
                    }
                    a(false, ((Integer)localObject[2]).intValue(), 0, 0, null, ((Integer)localObject[4]).intValue());
                    return;
                    b(paramObject);
                    return;
                    c(paramObject);
                    return;
                  } while (localObject == null);
                  a((String)localObject[0], ((Integer)localObject[1]).intValue(), ((Integer)localObject[2]).intValue(), (String)localObject[3]);
                  return;
                  if ((localObject != null) && (localObject.length > 0)) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("BizTroopObserver", 2, "onUpdate(), case BizTroopHandler.TYPE_SET_COMMONLY_USED_TROOP_LIST, array is null or empty ...");
                return;
                if ((localObject[0] instanceof Integer))
                {
                  paramInt = ((Integer)localObject[0]).intValue();
                  if ((localObject[1] instanceof Integer)) {
                    i = ((Integer)localObject[1]).intValue();
                  }
                  if (!(localObject[2] instanceof Map)) {
                    break label580;
                  }
                  paramObject = (Map)localObject[2];
                  if (!(localObject[3] instanceof String)) {
                    break label585;
                  }
                }
                for (localObject = (String)localObject[3];; localObject = null)
                {
                  a(paramInt, i, paramObject, (String)localObject);
                  return;
                  paramInt = -1;
                  break;
                  paramObject = null;
                  break label545;
                }
                i(paramBoolean, paramObject);
                return;
                j(paramBoolean, paramObject);
                return;
                if ((localObject == null) || (localObject.length == 0))
                {
                  a(false, -1L, "");
                  return;
                }
                a(paramBoolean, ((Long)localObject[0]).longValue(), (String)localObject[1]);
                return;
                c(paramBoolean, paramObject);
                return;
                if (QLog.isDevelopLevel()) {
                  QLog.d("BizTroopObserver", 4, "TroopHandler.TYPE_TROOP_GAG_STATUS");
                }
                a((TroopGagMgr.GagStatus)paramObject);
                return;
                a(paramBoolean, ((Boolean)paramObject).booleanValue());
                return;
                c(paramBoolean, ((Boolean)paramObject).booleanValue());
                return;
                d(paramBoolean, paramObject);
                return;
              } while (localObject == null);
              a(paramBoolean, ((Long)localObject[0]).longValue(), ((Long)localObject[1]).longValue());
              return;
            } while (localObject == null);
            a(paramBoolean, ((Integer)localObject[1]).intValue(), ((Integer)localObject[2]).intValue());
            return;
          } while (localObject == null);
          b(paramBoolean, ((Boolean)localObject[1]).booleanValue());
          return;
          a(paramBoolean, paramObject);
          return;
          b(paramBoolean, paramObject);
          return;
          if ((paramBoolean) && (localObject != null))
          {
            a(((Long)localObject[0]).longValue(), ((Long)localObject[1]).longValue(), ((Long)localObject[2]).longValue(), (String)localObject[3]);
            return;
          }
          a(-1L, -1L, -1L, "");
          return;
          k(paramBoolean, paramObject);
          return;
        } while ((localObject == null) || (localObject.length != 2));
        a((String)localObject[0], (String)localObject[1]);
        return;
        l(paramBoolean, paramObject);
        return;
        if ((localObject != null) && (localObject.length >= 1)) {}
        for (paramInt = ((Integer)localObject[0]).intValue(); (paramBoolean) && (localObject != null) && (localObject.length >= 4); paramInt = 2131429864)
        {
          a(paramBoolean, paramInt, (String)localObject[1], (String)localObject[2], (Boolean)localObject[3]);
          return;
        }
        a(paramBoolean, paramInt, null, null, Boolean.valueOf(true));
        return;
      } while (localObject == null);
      a(paramBoolean, (String)localObject[0], (String)localObject[1], (String)localObject[2]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BizTroopObserver
 * JD-Core Version:    0.7.0.1
 */