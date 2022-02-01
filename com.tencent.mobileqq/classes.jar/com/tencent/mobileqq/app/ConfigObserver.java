package com.tencent.mobileqq.app;

import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.util.Pair;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigObserver
  implements BusinessObserver
{
  protected void a(Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {}
  
  protected void a(String paramString, int paramInt, ArrayList<QQOperationViopTipTask> paramArrayList) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, long paramLong) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 15: 
      if (!(paramObject instanceof Object[])) {
        return;
      }
      a(((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
      return;
    case 14: 
      if (!(paramObject instanceof Object[])) {
        return;
      }
      paramObject = (Object[])paramObject;
      if (paramObject.length <= 4) {
        return;
      }
      b((Boolean)paramObject[0], (Boolean)paramObject[1], (String)paramObject[2], (String)paramObject[3], (String)paramObject[4]);
      return;
    case 13: 
      if (!(paramObject instanceof Object[])) {
        return;
      }
      paramObject = (Object[])paramObject;
      a((Boolean)paramObject[0], (Boolean)paramObject[1], (String)paramObject[2], (String)paramObject[3], (String)paramObject[4]);
      return;
    case 12: 
      if (!(paramObject instanceof Object[])) {
        return;
      }
      paramObject = (Object[])paramObject;
      a(((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
      return;
    case 11: 
      b(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 10: 
      paramObject = (Pair)paramObject;
      a(paramBoolean, (String)paramObject.first, (String)paramObject.second);
      return;
    case 8: 
      if ((paramObject != null) && ((paramObject instanceof OperateVoipTipsInfo)))
      {
        paramObject = (OperateVoipTipsInfo)paramObject;
        a(paramObject.uin, paramObject.uinType, paramObject.taskList);
      }
    case 9: 
      b(paramBoolean);
      return;
    case 7: 
      a(paramBoolean, ((Integer)paramObject).intValue());
      return;
    case 6: 
      b(paramBoolean, ((GetResourceRespInfo)paramObject).uiNewVer);
      return;
    case 5: 
      a(paramBoolean, (AppShareID)paramObject);
      return;
    case 4: 
      a(paramBoolean, (UpgradeDetailWrapper)paramObject);
      return;
    case 3: 
      a(paramBoolean, (String)paramObject);
      return;
    case 2: 
      a(paramBoolean, (GetResourceRespInfo)paramObject);
      return;
    }
    a(paramBoolean, ((GetResourceRespInfo)paramObject).uiNewVer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigObserver
 * JD-Core Version:    0.7.0.1
 */