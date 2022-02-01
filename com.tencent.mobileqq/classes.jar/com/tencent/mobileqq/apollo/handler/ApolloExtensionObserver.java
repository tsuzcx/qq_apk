package com.tencent.mobileqq.apollo.handler;

import com.tencent.mobileqq.apollo.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ApolloExtensionObserver
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
    case 4: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 19: 
    case 20: 
    case 24: 
    case 30: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    default: 
    case 39: 
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
          QLog.e("[cmshow]VasExtensionObserver", 1, "[onUpdate] NOTIFY_TYPE_GET_APOLLO_BATTLE_GAME_LIST. exception = ", paramObject);
          return;
        }
      }
      break;
    case 38: 
      if (paramObject != null) {
        try
        {
          paramObject = (Object[])paramObject;
          if (paramObject.length > 1)
          {
            b(((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
            return;
          }
        }
        catch (Throwable paramObject)
        {
          QLog.e("[cmshow]VasExtensionObserver", 1, "[onUpdate] NOTIFY_TYPE_GET_APOLLO_ACTION_USED_LIST. exception = ", paramObject);
          return;
        }
      }
      break;
    case 37: 
      if (paramObject != null) {
        try
        {
          paramObject = (Object[])paramObject;
          if (paramObject.length > 1)
          {
            a(((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
            return;
          }
        }
        catch (Throwable paramObject)
        {
          QLog.e("[cmshow]VasExtensionObserver", 1, "[onUpdate] NOTIFY_TYPE_GET_APOLLO_BATTLE_GAME_LIST. exception = ", paramObject);
          return;
        }
      }
      break;
    case 31: 
      t(paramBoolean, paramObject);
      return;
    case 29: 
      s(paramBoolean, paramObject);
      return;
    case 28: 
      c(paramBoolean, paramObject);
      return;
    case 27: 
      a(paramBoolean, (Object[])paramObject);
      return;
    case 26: 
      r(paramBoolean, paramObject);
      return;
    case 25: 
      q(paramBoolean, paramObject);
      return;
    case 23: 
      p(paramBoolean, paramObject);
      return;
    case 22: 
      o(paramBoolean, paramObject);
      return;
    case 21: 
      n(paramBoolean, paramObject);
      return;
    case 18: 
      m(paramBoolean, paramObject);
      return;
    case 17: 
      k(paramBoolean, paramObject);
      return;
    case 16: 
      j(paramBoolean, paramObject);
      return;
    case 10: 
      l(paramBoolean, paramObject);
      return;
    case 9: 
      i(paramBoolean, paramObject);
      return;
    case 8: 
      h(paramBoolean, paramObject);
      return;
    case 7: 
      g(paramBoolean, paramObject);
      return;
    case 6: 
      f(paramBoolean, paramObject);
      return;
    case 5: 
      a(paramBoolean, paramObject);
      return;
    case 3: 
      e(paramBoolean, paramObject);
      return;
    case 2: 
      b(paramBoolean, paramObject);
      return;
    case 1: 
      d(paramBoolean, paramObject);
    }
  }
  
  protected void p(boolean paramBoolean, Object paramObject) {}
  
  protected void q(boolean paramBoolean, Object paramObject) {}
  
  protected void r(boolean paramBoolean, Object paramObject) {}
  
  protected void s(boolean paramBoolean, Object paramObject) {}
  
  protected void t(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver
 * JD-Core Version:    0.7.0.1
 */