import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;

@ProxyService(proxy=VoIPProxy.class)
public class bjgt
  extends VoIPProxy
{
  private biiz jdField_a_of_type_Biiz = new bjgv(this);
  private VoIPProxy.VoIPListener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener;
  
  private void a()
  {
    QLog.i("VoIPProxyImpl", 1, "qavDeInitSDK");
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    biin localbiin = biin.a();
    localbiin.b(this.jdField_a_of_type_Biiz);
    localbiin.a();
  }
  
  public int enableLocalAudio(boolean paramBoolean)
  {
    biiw localbiiw = biin.a().a();
    if (localbiiw != null)
    {
      localbiiw.b(paramBoolean);
      return 0;
    }
    return -1;
  }
  
  public int enableRemoteAudio(boolean paramBoolean)
  {
    biiw localbiiw = biin.a().a();
    if (localbiiw != null)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localbiiw.c(paramBoolean);
        return 0;
      }
    }
    return -1;
  }
  
  public void exitRoom()
  {
    biiw localbiiw = biin.a().a();
    if (localbiiw != null) {
      localbiiw.e();
    }
  }
  
  public void init(long paramLong, VoIPProxy.VoIPListener paramVoIPListener)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ((PushManager)((AppRuntime)localObject).getManager(5)).registProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName(), "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c" });
    bija.a(new bijc());
    biiq localbiiq = biiq.a();
    localbiiq.a((AppRuntime)localObject);
    localbiiq.a(new bjgu(this));
    localObject = biin.a();
    ((biin)localObject).a(BaseApplicationImpl.getApplication().getApplicationContext(), paramLong, localbiiq);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener = paramVoIPListener;
    ((biin)localObject).a(this.jdField_a_of_type_Biiz);
  }
  
  public int joinRoom(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    biiw localbiiw = biin.a().a();
    if (localbiiw != null)
    {
      biim localbiim = new biim();
      localbiim.jdField_a_of_type_Int = 11;
      localbiim.b = 14;
      localbiim.c = 1;
      localbiim.d = paramInt;
      localbiim.jdField_a_of_type_Long = paramLong;
      localbiim.jdField_a_of_type_JavaLangString = paramString;
      localbiim.e = 1;
      localbiim.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      return localbiiw.a(localbiim);
    }
    return -4;
  }
  
  public void setAudioRoute(int paramInt)
  {
    biiw localbiiw = biin.a().a();
    if (localbiiw != null) {
      localbiiw.b(paramInt);
    }
  }
  
  public void unInit()
  {
    a();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener = null;
  }
  
  public void updateRoomInfo()
  {
    biiw localbiiw = biin.a().a();
    if (localbiiw != null) {
      localbiiw.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgt
 * JD-Core Version:    0.7.0.1
 */