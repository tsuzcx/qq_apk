package com.tencent.mobileqq.apollo.handler;

import com.tencent.mobileqq.apollo.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import trpc.cmshow.game.OpenGameBox.StOpenGameBoxRsp;

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
  
  protected void a(int paramInt, List<Integer> paramList) {}
  
  protected void a(List<CmAvatarFaceInfo> paramList, String paramString1, String paramString2, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, OpenGameBox.StOpenGameBoxRsp paramStOpenGameBoxRsp) {}
  
  protected void b(int paramInt, List<ApolloBattleGameInfo> paramList) {}
  
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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 16)
          {
            if (paramInt != 17) {
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      return;
                    case 40: 
                      try
                      {
                        if ((paramObject instanceof OpenGameBox.StOpenGameBoxRsp))
                        {
                          a(paramBoolean, (OpenGameBox.StOpenGameBoxRsp)paramObject);
                          return;
                        }
                        a(false, null);
                        return;
                      }
                      catch (Throwable paramObject)
                      {
                        QLog.e("[cmshow]VasExtensionObserver", 1, "[onUpdate] NOTIFY_TYPE_GET_APOLLO_ACTION_USED_LIST. exception = ", paramObject);
                        return;
                      }
                    case 39: 
                      if (paramObject == null) {
                        return;
                      }
                      try
                      {
                        paramObject = (Object[])paramObject;
                        if (paramObject.length <= 1) {
                          return;
                        }
                        a((List)paramObject[0], (String)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue());
                        return;
                      }
                      catch (Throwable paramObject)
                      {
                        QLog.e("[cmshow]VasExtensionObserver", 1, "[onUpdate] NOTIFY_TYPE_GET_APOLLO_BATTLE_GAME_LIST. exception = ", paramObject);
                        return;
                      }
                    case 38: 
                      if (paramObject == null) {
                        return;
                      }
                      try
                      {
                        paramObject = (Object[])paramObject;
                        if (paramObject.length <= 1) {
                          return;
                        }
                        a(((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
                        return;
                      }
                      catch (Throwable paramObject)
                      {
                        QLog.e("[cmshow]VasExtensionObserver", 1, "[onUpdate] NOTIFY_TYPE_GET_APOLLO_ACTION_USED_LIST. exception = ", paramObject);
                        return;
                      }
                    }
                    if (paramObject == null) {
                      break;
                    }
                    try
                    {
                      paramObject = (Object[])paramObject;
                      if (paramObject.length <= 1) {
                        break;
                      }
                      b(((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
                      return;
                    }
                    catch (Throwable paramObject)
                    {
                      QLog.e("[cmshow]VasExtensionObserver", 1, "[onUpdate] NOTIFY_TYPE_GET_APOLLO_BATTLE_GAME_LIST. exception = ", paramObject);
                      return;
                    }
                  case 29: 
                    p(paramBoolean, paramObject);
                    return;
                  case 28: 
                    e(paramBoolean, paramObject);
                    return;
                  case 27: 
                    a(paramBoolean, (Object[])paramObject);
                    return;
                  case 26: 
                    o(paramBoolean, paramObject);
                    return;
                  }
                  break;
                case 23: 
                  n(paramBoolean, paramObject);
                  return;
                case 22: 
                  m(paramBoolean, paramObject);
                  return;
                case 21: 
                  l(paramBoolean, paramObject);
                  return;
                }
                break;
              case 9: 
                c(paramBoolean, paramObject);
                return;
              case 8: 
                i(paramBoolean, paramObject);
                return;
              case 7: 
                h(paramBoolean, paramObject);
                return;
              case 6: 
                g(paramBoolean, paramObject);
                return;
              case 5: 
                d(paramBoolean, paramObject);
                return;
              }
            } else {
              k(paramBoolean, paramObject);
            }
          }
          else {
            j(paramBoolean, paramObject);
          }
        }
        else {
          b(paramBoolean, paramObject);
        }
      }
      else {
        a(paramBoolean, paramObject);
      }
    }
    else {
      f(paramBoolean, paramObject);
    }
  }
  
  protected void p(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver
 * JD-Core Version:    0.7.0.1
 */