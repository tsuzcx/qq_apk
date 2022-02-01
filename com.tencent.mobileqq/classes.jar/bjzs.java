import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;

@ProxyService(proxy=VoIPProxy.class)
public class bjzs
  extends VoIPProxy
{
  private bjcp jdField_a_of_type_Bjcp = new bjzu(this);
  private VoIPProxy.VoIPListener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener;
  
  private void a()
  {
    QLog.i("VoIPProxyImpl", 1, "qavDeInitSDK");
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    bjce localbjce = bjce.a();
    localbjce.b(this.jdField_a_of_type_Bjcp);
    localbjce.a();
  }
  
  public int enableLocalAudio(boolean paramBoolean)
  {
    bjcm localbjcm = bjce.a().a();
    if (localbjcm != null)
    {
      localbjcm.a(paramBoolean);
      return 0;
    }
    return -1;
  }
  
  public int enableRemoteAudio(boolean paramBoolean)
  {
    bjcm localbjcm = bjce.a().a();
    if (localbjcm != null)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localbjcm.b(paramBoolean);
        return 0;
      }
    }
    return -1;
  }
  
  public void exitRoom()
  {
    bjcm localbjcm = bjce.a().a();
    if (localbjcm != null) {
      localbjcm.e();
    }
  }
  
  public void init(long paramLong, VoIPProxy.VoIPListener paramVoIPListener)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ((PushManager)((AppRuntime)localObject).getManager(5)).registProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName(), "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c" });
    bjcq.a(new bjcs());
    bjch localbjch = bjch.a();
    localbjch.a((AppRuntime)localObject);
    localbjch.a(new bjzt(this));
    localObject = bjce.a();
    ((bjce)localObject).a(BaseApplicationImpl.getApplication().getApplicationContext(), paramLong, localbjch);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener = paramVoIPListener;
    ((bjce)localObject).a(this.jdField_a_of_type_Bjcp);
  }
  
  public int joinRoom(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    bjcm localbjcm = bjce.a().a();
    if (localbjcm != null)
    {
      bjcd localbjcd = new bjcd();
      localbjcd.jdField_a_of_type_Int = 11;
      localbjcd.b = 14;
      localbjcd.c = 1;
      localbjcd.d = paramInt;
      localbjcd.jdField_a_of_type_Long = paramLong;
      localbjcd.jdField_a_of_type_JavaLangString = paramString;
      localbjcd.e = 1;
      localbjcd.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      return localbjcm.a(localbjcd);
    }
    return -4;
  }
  
  public void setAudioRoute(int paramInt)
  {
    bjcm localbjcm = bjce.a().a();
    if (localbjcm != null) {
      localbjcm.b(paramInt);
    }
  }
  
  public void unInit()
  {
    a();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener = null;
  }
  
  public void updateRoomInfo()
  {
    bjcm localbjcm = bjce.a().a();
    if (localbjcm != null) {
      localbjcm.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjzs
 * JD-Core Version:    0.7.0.1
 */