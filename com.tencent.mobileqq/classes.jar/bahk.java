import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.transfile.NetworkCenter;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class bahk
  implements ante, Manager
{
  private QQAppInterface a;
  
  public bahk(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    String str = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.SilkCfg.name(), "null");
    if (!"null".equalsIgnoreCase(str))
    {
      bhhd.a(paramQQAppInterface, str);
      bhhd.a(paramQQAppInterface, true);
      str = DeviceProfileManager.a(paramQQAppInterface).a(DeviceProfileManager.DpcNames.StreamCfg.name(), "null");
      if ("null".equalsIgnoreCase(str)) {
        break label161;
      }
      bahs.a(paramQQAppInterface, str);
      bahs.a(paramQQAppInterface, true);
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
          bdkk.a(BaseApplicationImpl.sApplication, bool);
        }
      }
      DeviceProfileManager.a(this);
      return;
      bhhd.a(paramQQAppInterface, false);
      break;
      label161:
      bahs.a(paramQQAppInterface, false);
    }
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = this.a;
    NetworkCenter.getInstance();
    if (localQQAppInterface != null)
    {
      bahs.b(localQQAppInterface, paramString);
      bahs.b(localQQAppInterface, true);
    }
  }
  
  public void b(String paramString)
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      bahm.a(localQQAppInterface, paramString);
      bahm.a(localQQAppInterface, true);
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    NetworkCenter.getInstance();
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      baib.a(localQQAppInterface, paramString);
      baib.a(localQQAppInterface, true);
    }
  }
  
  public void onDestroy()
  {
    baib.a();
    DeviceProfileManager.b(this);
    bhhd.a();
    bahs.a();
  }
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    Object localObject = this.a;
    if ((localObject != null) && (paramBoolean))
    {
      bhhd.a((QQAppInterface)localObject, DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.SilkCfg.name(), ""));
      bhhd.a((QQAppInterface)localObject, true);
      bahs.a((QQAppInterface)localObject, DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.StreamCfg.name(), ""));
      bahs.a((QQAppInterface)localObject, true);
      localObject = DeviceProfileManager.a((AppRuntime)localObject).a(DeviceProfileManager.DpcNames.aio_config.name(), "").split("\\|");
      if (localObject.length > 13)
      {
        paramBoolean = "1".equals(localObject[12]);
        SyncService.b(BaseApplicationImpl.sApplication, paramBoolean);
        if (localObject.length > 14)
        {
          paramBoolean = "1".equals(localObject[13]);
          bdkk.a(BaseApplicationImpl.sApplication, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahk
 * JD-Core Version:    0.7.0.1
 */