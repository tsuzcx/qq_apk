package com.tencent.mobileqq.avatar.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.Setting;
import java.util.ArrayList;
import java.util.List;

public class AvatarObserver
  implements BusinessObserver
{
  public void onGetApolloHeadInfo(boolean paramBoolean, String paramString, byte paramByte) {}
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting) {}
  
  public void onGetHeadInfoEmpty(boolean paramBoolean, int paramInt, List<String> paramList) {}
  
  protected void onStrangerHeadReady(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 2: 
    case 0: 
    case 6: 
    case 7: 
    case 8: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              onUpdateMobileQQHead(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
              return;
              onGetHeadInfo(paramBoolean, (Setting)paramObject);
              return;
            } while (!(paramObject instanceof Object[]));
            paramObject = (Object[])paramObject;
          } while (paramObject.length <= 1);
          onGetHeadInfoEmpty(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1]);
          return;
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
        onGetApolloHeadInfo(paramBoolean, (String)paramObject[0], ((Byte)paramObject[1]).byteValue());
        return;
      } while (!(paramObject instanceof Object[]));
      Object[] arrayOfObject = (Object[])paramObject;
      paramObject = (Object[])paramObject;
      onUpdateApolloHead(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 1: 
      onUpdateCustomHead(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
      return;
    case 4: 
      paramObject = (Object[])paramObject;
      onUpdateStrangerHead(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 5: 
      paramObject = (Object[])paramObject;
      onUpdateQCallHead(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 3: 
      onUpdateTroopHead(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
      return;
    }
    paramObject = (Object[])paramObject;
    onStrangerHeadReady(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
  }
  
  protected void onUpdateApolloHead(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString) {}
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString) {}
  
  protected void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  protected void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.observer.AvatarObserver
 * JD-Core Version:    0.7.0.1
 */