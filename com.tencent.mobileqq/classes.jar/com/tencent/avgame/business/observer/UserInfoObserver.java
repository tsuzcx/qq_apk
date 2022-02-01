package com.tencent.avgame.business.observer;

import com.tencent.avgame.ipc.UserInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.HashMap;

public class UserInfoObserver
  implements BusinessObserver
{
  public void a(int paramInt1, String paramString, int paramInt2) {}
  
  public void a(int paramInt, String paramString, UserInfo paramUserInfo) {}
  
  public void a(boolean paramBoolean, int paramInt, HashMap<String, String> paramHashMap) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        paramObject = (Object[])paramObject;
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (HashMap)paramObject[1]);
        return;
      }
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], ((Integer)paramObject[2]).intValue());
      return;
    }
    paramObject = (Object[])paramObject;
    a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (UserInfo)paramObject[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.observer.UserInfoObserver
 * JD-Core Version:    0.7.0.1
 */