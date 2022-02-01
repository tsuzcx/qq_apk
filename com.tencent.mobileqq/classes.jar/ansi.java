import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.util.Pair;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceRespInfo;

public class ansi
  implements BusinessObserver
{
  protected void onBgResourceUpdate(boolean paramBoolean, long paramLong) {}
  
  protected void onCheckAuthCode(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetAppShareInfo(boolean paramBoolean, AppShareID paramAppShareID) {}
  
  protected void onGetAuthCode(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onGetRealNameStatus(Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {}
  
  protected void onGetRealNameStatusForAV(boolean paramBoolean) {}
  
  protected void onGetRealNameStatusForExtendFriend(Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, String paramString3) {}
  
  protected void onGetRedPacketRainConfig(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onOrginConfigUpdate(boolean paramBoolean, long paramLong) {}
  
  protected void onShowVoipTips(String paramString, int paramInt, ArrayList<QQOperationViopTipTask> paramArrayList) {}
  
  protected void onSmallPicDownloadSuccess(boolean paramBoolean, String paramString) {}
  
  protected void onThemeResourceUpdate(boolean paramBoolean, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
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
              onBgResourceUpdate(paramBoolean, ((GetResourceRespInfo)paramObject).uiNewVer);
              return;
              onThemeResourceUpdate(paramBoolean, (GetResourceRespInfo)paramObject);
              return;
              onSmallPicDownloadSuccess(paramBoolean, (String)paramObject);
              return;
              onUpgradeConfig(paramBoolean, (UpgradeDetailWrapper)paramObject);
              return;
              onGetAppShareInfo(paramBoolean, (AppShareID)paramObject);
              return;
              onOrginConfigUpdate(paramBoolean, ((GetResourceRespInfo)paramObject).uiNewVer);
              return;
              onUpdateStatusActions(paramBoolean, ((Integer)paramObject).intValue());
              return;
              if ((paramObject != null) && ((paramObject instanceof OperateVoipTipsInfo)))
              {
                paramObject = (OperateVoipTipsInfo)paramObject;
                onShowVoipTips(paramObject.uin, paramObject.uinType, paramObject.taskList);
              }
              onUpdateWeatherResources(paramBoolean);
              return;
              paramObject = (Pair)paramObject;
              onGetAuthCode(paramBoolean, (String)paramObject.first, (String)paramObject.second);
              return;
              onCheckAuthCode(paramBoolean, ((Boolean)paramObject).booleanValue());
              return;
            } while (!(paramObject instanceof Object[]));
            paramObject = (Object[])paramObject;
            onGetRedPacketRainConfig(((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
            return;
          } while (!(paramObject instanceof Object[]));
          paramObject = (Object[])paramObject;
          onGetRealNameStatus((Boolean)paramObject[0], (Boolean)paramObject[1], (String)paramObject[2], (String)paramObject[3], (String)paramObject[4]);
          return;
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
      } while (paramObject.length <= 4);
      onGetRealNameStatusForExtendFriend((Boolean)paramObject[0], (Boolean)paramObject[1], (String)paramObject[2], (String)paramObject[3], (String)paramObject[4]);
      return;
    } while (!(paramObject instanceof Object[]));
    onGetRealNameStatusForAV(((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
  }
  
  protected void onUpdateStatusActions(boolean paramBoolean, int paramInt) {}
  
  protected void onUpdateWeatherResources(boolean paramBoolean) {}
  
  protected void onUpgradeConfig(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansi
 * JD-Core Version:    0.7.0.1
 */