package com.tencent.mobileqq.app.friendlist.receiver;

import GeneralSettings.RespGetSettings;
import GeneralSettings.RespSetSettings;
import GeneralSettings.Setting;
import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GeneralSettingsReceiver
  extends BaseHandlerReceiver
{
  public GeneralSettingsReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private Map<String, Integer> a(ArrayList<Setting> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      int i = 0;
      if (i < paramArrayList.size())
      {
        Setting localSetting = (Setting)paramArrayList.get(i);
        Object localObject = localSetting.Path;
        if ((localObject == null) || (((String)localObject).length() == 0)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((String)localObject).split("\\.");
          if ((localObject != null) && (localObject.length != 0)) {
            localHashMap.put(localObject[(localObject.length - 1)], Integer.valueOf(Integer.parseInt(localSetting.Value)));
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespGetSettings paramRespGetSettings)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "handleGetGeneralSettingAll cmd=" + paramFromServiceMsg.getMsfCommand() + " resp.isSucc=" + paramFromServiceMsg.isSuccess() + " resultCode=" + paramFromServiceMsg.getResultCode());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      int k = paramToServiceMsg.extraData.getInt("Revision");
      int j = paramToServiceMsg.extraData.getInt("respRevision", -1);
      boolean bool = paramToServiceMsg.extraData.getBoolean("needTroopSettings");
      long l = paramToServiceMsg.extraData.getLong("Offset");
      paramToServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("Paths");
      if (paramRespGetSettings == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "handlerGetGeneralSettingAll, data == null");
        }
        this.a.endGetAllGeneralSettings(false, true);
        a(35, false, new Object[] { Boolean.valueOf(true) });
        return;
      }
      if ((paramRespGetSettings.Settings == null) || (paramRespGetSettings.Settings.size() == 0))
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder().append("handlerGetGeneralSettingAll, data.Settings=");
          if (paramRespGetSettings.Settings != null) {
            break label275;
          }
        }
        label275:
        for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size()))
        {
          QLog.d("RoamSetting", 2, paramToServiceMsg);
          DBUtils.a().a(paramRespGetSettings.Revision, this.a);
          this.a.endGetAllGeneralSettings(true, true);
          a(35, true, new Object[] { Boolean.valueOf(true) });
          return;
        }
      }
      if ((j != -1) && (j < paramRespGetSettings.Revision))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "respRevision != data.Revision, load settings again, respRev=" + j + " data.Rev=" + paramRespGetSettings.Revision);
        }
        this.a.endGetAllGeneralSettings(false, false);
        this.a.getAllGeneralSettings(bool);
        a(35, true, new Object[] { Boolean.valueOf(false) });
        return;
      }
      int i = j;
      if (j == -1) {
        i = paramRespGetSettings.Revision;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder().append("oldRevision=").append(k).append(" lastRespRevision=").append(i).append(" total=").append(paramRespGetSettings.Total).append(" offset=").append(l).append(" data.settings.size=");
        if (paramRespGetSettings.Settings != null) {
          break label568;
        }
      }
      label568:
      for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size()))
      {
        QLog.d("RoamSetting", 2, paramToServiceMsg);
        DBUtils.a().a(paramRespGetSettings.Settings, this.a);
        l += paramRespGetSettings.Settings.size();
        if (paramRespGetSettings.Total <= l) {
          break;
        }
        ((RoamSettingController)this.a.getManager(QQManagerFactory.MGR_TROOP_FILTER)).a(k, l, i, bool, null);
        a(35, true, new Object[] { Boolean.valueOf(false) });
        return;
      }
      DBUtils.a().a(paramRespGetSettings.Revision, this.a);
      this.a.endGetAllGeneralSettings(true, true);
      a(35, true, new Object[] { Boolean.valueOf(true) });
      return;
    }
    this.a.endGetAllGeneralSettings(false, true);
    a(35, false, new Object[] { Boolean.valueOf(true) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespSetSettings paramRespSetSettings)
  {
    ArrayList localArrayList = (ArrayList)paramToServiceMsg.extraData.getSerializable("Settings");
    int i = paramToServiceMsg.extraData.getInt("localRevision");
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handlerUploadRoamSettingNewValue isSuccess = ").append(paramFromServiceMsg.isSuccess()).append(" reqLocalRevision=").append(i).append(" data.Revision=");
      if (paramRespSetSettings == null)
      {
        paramToServiceMsg = "null";
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg);
      }
    }
    else
    {
      if (!paramFromServiceMsg.isSuccess()) {
        break label195;
      }
      if (paramRespSetSettings == null) {
        break label219;
      }
      if (i + 1 != paramRespSetSettings.Revision) {
        break label180;
      }
      DBUtils.a().a(localArrayList, this.a);
      DBUtils.a().a(paramRespSetSettings.Revision, this.a);
      this.a.onUploadRomingSettingsFinish(true, false);
      bool = true;
    }
    for (;;)
    {
      if (localArrayList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "handlerUploadRoamSettingNewValue  settings is null.");
        }
        return;
        paramToServiceMsg = Integer.valueOf(paramRespSetSettings.Revision);
        break;
        label180:
        this.a.onUploadRomingSettingsFinish(true, true);
        bool = true;
        continue;
        label195:
        this.a.onUploadRomingSettingsFinish(false, false);
        bool = false;
        continue;
      }
      a(localArrayList, bool);
      return;
      label219:
      bool = true;
    }
  }
  
  private void a(ArrayList<Setting> paramArrayList, boolean paramBoolean)
  {
    Map localMap = a(paramArrayList);
    RoamSettingController localRoamSettingController = (RoamSettingController)this.a.getManager(QQManagerFactory.MGR_TROOP_FILTER);
    paramArrayList = paramArrayList.iterator();
    boolean bool = false;
    while (paramArrayList.hasNext())
    {
      Object localObject = (Setting)paramArrayList.next();
      if (((Setting)localObject).Path != null)
      {
        if (((Setting)localObject).Path.startsWith("message.group.policy.")) {
          if ((!bool) && ((paramBoolean) || ((!paramBoolean) && (localRoamSettingController.a()))))
          {
            localObject = localMap.keySet().iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              Boolean localBoolean = (Boolean)localRoamSettingController.c.get(str);
              if ((localBoolean != null) && (localBoolean.booleanValue())) {
                localRoamSettingController.c.put(str, Boolean.valueOf(false));
              }
            }
            a(38, paramBoolean, localMap);
            bool = true;
          }
        }
        for (;;)
        {
          break;
          if (QLog.isColorLevel())
          {
            QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((Setting)localObject).Path + " value=" + ((Setting)localObject).Value + " hasNotifyTroop=" + bool + "uploadSuccess=" + paramBoolean + " enableRetry=" + localRoamSettingController.a());
            continue;
            if (((Setting)localObject).Path.startsWith("message.ring.switch")) {
              a(paramBoolean, localMap, localRoamSettingController, (Setting)localObject, 43, "handleUploadRoamsSettingNewValue");
            } else if (((Setting)localObject).Path.startsWith("message.vibrate.switch")) {
              a(paramBoolean, localMap, localRoamSettingController, (Setting)localObject, 44, "handleUploadRoamsSettingNewValue");
            } else if (((Setting)localObject).Path.startsWith("sync.c2c_message")) {
              a(paramBoolean, localMap, localRoamSettingController, (Setting)localObject, 47, "handleUploadRoamsSettingNewValue");
            } else if (((Setting)localObject).Path.startsWith("message.group.ring")) {
              a(paramBoolean, localMap, localRoamSettingController, (Setting)localObject, 41, "handleUploadRoamsSettingNewValue");
            } else if (((Setting)localObject).Path.startsWith("message.group.vibrate")) {
              a(paramBoolean, localMap, localRoamSettingController, (Setting)localObject, 42, "handleUploadRoamsSettingNewValue");
            } else if (((Setting)localObject).Path.startsWith("message.ring.care")) {
              a(paramBoolean, localMap, localRoamSettingController, (Setting)localObject, 78, "handleUploadRoamsSettingNewValue ");
            }
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, Map<String, Integer> paramMap, RoamSettingController paramRoamSettingController, Setting paramSetting, int paramInt, String paramString)
  {
    if ((paramBoolean) || ((!paramBoolean) && (paramRoamSettingController.a()))) {
      a(paramInt, paramBoolean, paramMap);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("RoamSetting", 2, "-->" + paramString + " not notifyUI, path=" + paramSetting.Path + " value=" + paramSetting.Value + "uploadSuccess=" + paramBoolean + " enableRetry=" + paramRoamSettingController.a());
  }
  
  public boolean a(String paramString)
  {
    return ("ProfileService.ReqGetSettings".equals(paramString)) || ("ProfileService.ReqSetSettings".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("ProfileService.ReqGetSettings".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, (RespGetSettings)paramObject);
    }
    while (!"ProfileService.ReqSetSettings".equals(str)) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, (RespSetSettings)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.GeneralSettingsReceiver
 * JD-Core Version:    0.7.0.1
 */