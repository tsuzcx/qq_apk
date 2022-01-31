import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class avbv
  implements ajuz, Manager
{
  private QQAppInterface a;
  
  public avbv(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    String str = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.SilkCfg.name(), "null");
    if (!"null".equalsIgnoreCase(str))
    {
      bbjg.a(paramQQAppInterface, str);
      bbjg.a(paramQQAppInterface, true);
      str = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.StreamCfg.name(), "null");
      if ("null".equalsIgnoreCase(str)) {
        break label161;
      }
      avcd.a(paramQQAppInterface, str);
      avcd.a(paramQQAppInterface, true);
    }
    for (;;)
    {
      paramQQAppInterface = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.aio_config.name(), "").split("\\|");
      if (paramQQAppInterface.length > 13)
      {
        boolean bool = "1".equals(paramQQAppInterface[12]);
        SyncService.b(BaseApplicationImpl.sApplication, bool);
        if (paramQQAppInterface.length > 14)
        {
          bool = "1".equals(paramQQAppInterface[13]);
          axqi.a(BaseApplicationImpl.sApplication, bool);
        }
      }
      DeviceProfileManager.a(this);
      return;
      bbjg.a(paramQQAppInterface, false);
      break;
      label161:
      avcd.a(paramQQAppInterface, false);
    }
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = this.a;
    ayta.a();
    if (localQQAppInterface != null)
    {
      avcd.b(localQQAppInterface, paramString);
      avcd.b(localQQAppInterface, true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if ((localObject != null) && (paramBoolean))
    {
      bbjg.a((QQAppInterface)localObject, DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.SilkCfg.name(), ""));
      bbjg.a((QQAppInterface)localObject, true);
      avcd.a((QQAppInterface)localObject, DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.StreamCfg.name(), ""));
      avcd.a((QQAppInterface)localObject, true);
      localObject = DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.aio_config.name(), "").split("\\|");
      if (localObject.length > 13)
      {
        paramBoolean = "1".equals(localObject[12]);
        SyncService.b(BaseApplicationImpl.sApplication, paramBoolean);
        if (localObject.length > 14)
        {
          paramBoolean = "1".equals(localObject[13]);
          axqi.a(BaseApplicationImpl.sApplication, paramBoolean);
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      avbx.a(localQQAppInterface, paramString);
      avbx.a(localQQAppInterface, true);
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ayta.a();
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      avcm.a(localQQAppInterface, paramString);
      avcm.a(localQQAppInterface, true);
    }
  }
  
  public void onDestroy()
  {
    avcm.a();
    DeviceProfileManager.b(this);
    bbjg.a();
    avcd.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avbv
 * JD-Core Version:    0.7.0.1
 */