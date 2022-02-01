import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class balw
  implements anwh, Manager
{
  private QQAppInterface a;
  
  public balw(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    String str = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.SilkCfg.name(), "null");
    if (!"null".equalsIgnoreCase(str))
    {
      bhrp.a(paramQQAppInterface, str);
      bhrp.a(paramQQAppInterface, true);
      str = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.StreamCfg.name(), "null");
      if ("null".equalsIgnoreCase(str)) {
        break label161;
      }
      bame.a(paramQQAppInterface, str);
      bame.a(paramQQAppInterface, true);
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
          bdkv.a(BaseApplicationImpl.sApplication, bool);
        }
      }
      DeviceProfileManager.a(this);
      return;
      bhrp.a(paramQQAppInterface, false);
      break;
      label161:
      bame.a(paramQQAppInterface, false);
    }
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = this.a;
    bevn.a();
    if (localQQAppInterface != null)
    {
      bame.b(localQQAppInterface, paramString);
      bame.b(localQQAppInterface, true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if ((localObject != null) && (paramBoolean))
    {
      bhrp.a((QQAppInterface)localObject, DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.SilkCfg.name(), ""));
      bhrp.a((QQAppInterface)localObject, true);
      bame.a((QQAppInterface)localObject, DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.StreamCfg.name(), ""));
      bame.a((QQAppInterface)localObject, true);
      localObject = DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.aio_config.name(), "").split("\\|");
      if (localObject.length > 13)
      {
        paramBoolean = "1".equals(localObject[12]);
        SyncService.b(BaseApplicationImpl.sApplication, paramBoolean);
        if (localObject.length > 14)
        {
          paramBoolean = "1".equals(localObject[13]);
          bdkv.a(BaseApplicationImpl.sApplication, paramBoolean);
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      baly.a(localQQAppInterface, paramString);
      baly.a(localQQAppInterface, true);
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    bevn.a();
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      bamn.a(localQQAppInterface, paramString);
      bamn.a(localQQAppInterface, true);
    }
  }
  
  public void onDestroy()
  {
    bamn.a();
    DeviceProfileManager.b(this);
    bhrp.a();
    bame.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     balw
 * JD-Core Version:    0.7.0.1
 */