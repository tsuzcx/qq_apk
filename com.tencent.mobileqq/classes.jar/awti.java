import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class awti
  implements almm, Manager
{
  private QQAppInterface a;
  
  public awti(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    String str = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.SilkCfg.name(), "null");
    if (!"null".equalsIgnoreCase(str))
    {
      bdic.a(paramQQAppInterface, str);
      bdic.a(paramQQAppInterface, true);
      str = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.StreamCfg.name(), "null");
      if ("null".equalsIgnoreCase(str)) {
        break label161;
      }
      awtq.a(paramQQAppInterface, str);
      awtq.a(paramQQAppInterface, true);
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
          azlt.a(BaseApplicationImpl.sApplication, bool);
        }
      }
      DeviceProfileManager.a(this);
      return;
      bdic.a(paramQQAppInterface, false);
      break;
      label161:
      awtq.a(paramQQAppInterface, false);
    }
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = this.a;
    baqx.a();
    if (localQQAppInterface != null)
    {
      awtq.b(localQQAppInterface, paramString);
      awtq.b(localQQAppInterface, true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if ((localObject != null) && (paramBoolean))
    {
      bdic.a((QQAppInterface)localObject, DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.SilkCfg.name(), ""));
      bdic.a((QQAppInterface)localObject, true);
      awtq.a((QQAppInterface)localObject, DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.StreamCfg.name(), ""));
      awtq.a((QQAppInterface)localObject, true);
      localObject = DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.aio_config.name(), "").split("\\|");
      if (localObject.length > 13)
      {
        paramBoolean = "1".equals(localObject[12]);
        SyncService.b(BaseApplicationImpl.sApplication, paramBoolean);
        if (localObject.length > 14)
        {
          paramBoolean = "1".equals(localObject[13]);
          azlt.a(BaseApplicationImpl.sApplication, paramBoolean);
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      awtk.a(localQQAppInterface, paramString);
      awtk.a(localQQAppInterface, true);
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    baqx.a();
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      awtz.a(localQQAppInterface, paramString);
      awtz.a(localQQAppInterface, true);
    }
  }
  
  public void onDestroy()
  {
    awtz.a();
    DeviceProfileManager.b(this);
    bdic.a();
    awtq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awti
 * JD-Core Version:    0.7.0.1
 */