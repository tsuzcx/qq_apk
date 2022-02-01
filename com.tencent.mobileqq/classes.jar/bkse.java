import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;

@ProxyService(proxy=VoIPProxy.class)
public class bkse
  extends VoIPProxy
{
  private bjub jdField_a_of_type_Bjub = new bksg(this);
  private VoIPProxy.VoIPListener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener;
  
  private void a()
  {
    QLog.i("VoIPProxyImpl", 1, "qavDeInitSDK");
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    bjtp localbjtp = bjtp.a();
    localbjtp.b(this.jdField_a_of_type_Bjub);
    localbjtp.a();
  }
  
  public int enableLocalAudio(boolean paramBoolean)
  {
    bjty localbjty = bjtp.a().a();
    if (localbjty != null)
    {
      localbjty.a(paramBoolean);
      return 0;
    }
    return -1;
  }
  
  public int enableRemoteAudio(boolean paramBoolean)
  {
    bjty localbjty = bjtp.a().a();
    if (localbjty != null)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localbjty.b(paramBoolean);
        return 0;
      }
    }
    return -1;
  }
  
  public void exitRoom()
  {
    bjty localbjty = bjtp.a().a();
    if (localbjty != null) {
      localbjty.e();
    }
  }
  
  public void init(long paramLong, VoIPProxy.VoIPListener paramVoIPListener)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ((PushManager)((AppRuntime)localObject).getManager(5)).registProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName(), "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c" });
    bjuc.a(new bjue());
    bjts localbjts = bjts.a();
    localbjts.a((AppRuntime)localObject);
    localbjts.a(new bksf(this));
    localObject = bjtp.a();
    ((bjtp)localObject).a(BaseApplicationImpl.getApplication().getApplicationContext(), paramLong, localbjts);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener = paramVoIPListener;
    ((bjtp)localObject).a(this.jdField_a_of_type_Bjub);
  }
  
  public int joinRoom(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    bjty localbjty = bjtp.a().a();
    if (localbjty != null)
    {
      bjto localbjto = new bjto();
      localbjto.jdField_a_of_type_Int = 11;
      localbjto.b = 14;
      localbjto.c = 1;
      localbjto.d = paramInt;
      localbjto.jdField_a_of_type_Long = paramLong;
      localbjto.jdField_a_of_type_JavaLangString = paramString;
      localbjto.e = 1;
      localbjto.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      return localbjty.a(localbjto);
    }
    return -4;
  }
  
  public void setAudioRoute(int paramInt)
  {
    bjty localbjty = bjtp.a().a();
    if (localbjty != null) {
      localbjty.b(paramInt);
    }
  }
  
  public void unInit()
  {
    a();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener = null;
  }
  
  public void updateRoomInfo()
  {
    bjty localbjty = bjtp.a().a();
    if (localbjty != null) {
      localbjty.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkse
 * JD-Core Version:    0.7.0.1
 */