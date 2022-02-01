package com.tencent.mobileqq.apollo.api.handler.impl;

import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.apollo.api.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.apollo.api.model.CmAvatarFaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ApolloExtensionObserverImpl
  implements IApolloExtensionObserver
{
  private void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 1))
    {
      a(paramBoolean, ((Integer)paramArrayOfObject[0]).intValue(), (String)paramArrayOfObject[1]);
      return;
    }
    a(paramBoolean, 0, "");
  }
  
  protected void a(int paramInt, List<ApolloBattleGameInfo> paramList) {}
  
  protected void a(List<CmAvatarFaceInfo> paramList, String paramString1, String paramString2, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b(int paramInt, List<Integer> paramList) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject) {}
  
  protected void h(boolean paramBoolean, Object paramObject) {}
  
  protected void i(boolean paramBoolean, Object paramObject) {}
  
  protected void j(boolean paramBoolean, Object paramObject) {}
  
  protected void k(boolean paramBoolean, Object paramObject) {}
  
  protected void l(boolean paramBoolean, Object paramObject) {}
  
  protected void m(boolean paramBoolean, Object paramObject) {}
  
  protected void n(boolean paramBoolean, Object paramObject) {}
  
  protected void o(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      b(paramBoolean, paramObject);
      return;
      c(paramBoolean, paramObject);
      return;
      d(paramBoolean, paramObject);
      return;
      e(paramBoolean, paramObject);
      return;
      f(paramBoolean, paramObject);
      return;
      g(paramBoolean, paramObject);
      return;
      h(paramBoolean, paramObject);
      return;
      i(paramBoolean, paramObject);
      return;
      j(paramBoolean, paramObject);
      return;
      k(paramBoolean, paramObject);
      return;
      l(paramBoolean, paramObject);
      return;
      m(paramBoolean, paramObject);
      return;
      n(paramBoolean, paramObject);
      return;
      o(paramBoolean, paramObject);
      return;
      p(paramBoolean, paramObject);
      return;
      q(paramBoolean, paramObject);
      return;
      r(paramBoolean, paramObject);
      return;
      s(paramBoolean, paramObject);
      return;
      t(paramBoolean, paramObject);
      return;
      u(paramBoolean, paramObject);
      return;
      v(paramBoolean, paramObject);
      return;
      a(paramBoolean, paramObject);
      return;
      a(paramBoolean, (Object[])paramObject);
      return;
      if (paramObject != null)
      {
        try
        {
          paramObject = (Object[])paramObject;
          if (paramObject.length <= 1) {
            continue;
          }
          a(((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
          return;
        }
        catch (Throwable paramObject)
        {
          QLog.e("VasExtensionObserver", 1, "[onUpdate] NOTIFY_TYPE_GET_APOLLO_BATTLE_GAME_LIST. exception = ", paramObject);
          return;
        }
        if (paramObject != null)
        {
          try
          {
            paramObject = (Object[])paramObject;
            if (paramObject.length <= 1) {
              continue;
            }
            b(((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
            return;
          }
          catch (Throwable paramObject)
          {
            QLog.e("VasExtensionObserver", 1, "[onUpdate] NOTIFY_TYPE_GET_APOLLO_ACTION_USED_LIST. exception = ", paramObject);
            return;
          }
          if (paramObject != null) {
            try
            {
              paramObject = (Object[])paramObject;
              if (paramObject.length > 1)
              {
                a((List)paramObject[0], (String)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue());
                return;
              }
            }
            catch (Throwable paramObject)
            {
              QLog.e("VasExtensionObserver", 1, "[onUpdate] NOTIFY_TYPE_GET_APOLLO_BATTLE_GAME_LIST. exception = ", paramObject);
            }
          }
        }
      }
    }
  }
  
  protected void p(boolean paramBoolean, Object paramObject) {}
  
  protected void q(boolean paramBoolean, Object paramObject) {}
  
  protected void r(boolean paramBoolean, Object paramObject) {}
  
  protected void s(boolean paramBoolean, Object paramObject) {}
  
  protected void t(boolean paramBoolean, Object paramObject) {}
  
  protected void u(boolean paramBoolean, Object paramObject) {}
  
  protected void v(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl
 * JD-Core Version:    0.7.0.1
 */