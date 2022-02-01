import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;

@ProxyService(proxy=VoIPProxy.class)
public class blaw
  extends VoIPProxy
{
  private bkdo jdField_a_of_type_Bkdo = new blay(this);
  private VoIPProxy.VoIPListener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener;
  
  private void a()
  {
    QLog.i("VoIPProxyImpl", 1, "qavDeInitSDK");
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    bkdd localbkdd = bkdd.a();
    localbkdd.b(this.jdField_a_of_type_Bkdo);
    localbkdd.a();
  }
  
  public int enableLocalAudio(boolean paramBoolean)
  {
    bkdl localbkdl = bkdd.a().a();
    if (localbkdl != null)
    {
      localbkdl.a(paramBoolean);
      return 0;
    }
    return -1;
  }
  
  public int enableRemoteAudio(boolean paramBoolean)
  {
    bkdl localbkdl = bkdd.a().a();
    if (localbkdl != null)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localbkdl.b(paramBoolean);
        return 0;
      }
    }
    return -1;
  }
  
  public void exitRoom()
  {
    bkdl localbkdl = bkdd.a().a();
    if (localbkdl != null) {
      localbkdl.e();
    }
  }
  
  public void init(long paramLong, VoIPProxy.VoIPListener paramVoIPListener)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ((PushManager)((AppRuntime)localObject).getManager(5)).registProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName(), "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c" });
    bkdp.a(new bkdr());
    bkdg localbkdg = bkdg.a();
    localbkdg.a((AppRuntime)localObject);
    localbkdg.a(new blax(this));
    localObject = bkdd.a();
    ((bkdd)localObject).a(BaseApplicationImpl.getApplication().getApplicationContext(), paramLong, localbkdg);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener = paramVoIPListener;
    ((bkdd)localObject).a(this.jdField_a_of_type_Bkdo);
  }
  
  public int joinRoom(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    bkdl localbkdl = bkdd.a().a();
    if (localbkdl != null)
    {
      bkdc localbkdc = new bkdc();
      localbkdc.jdField_a_of_type_Int = 11;
      localbkdc.b = 14;
      localbkdc.c = 1;
      localbkdc.d = paramInt;
      localbkdc.jdField_a_of_type_Long = paramLong;
      localbkdc.jdField_a_of_type_JavaLangString = paramString;
      localbkdc.e = 1;
      localbkdc.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      return localbkdl.a(localbkdc);
    }
    return -4;
  }
  
  public void setAudioRoute(int paramInt)
  {
    bkdl localbkdl = bkdd.a().a();
    if (localbkdl != null) {
      localbkdl.b(paramInt);
    }
  }
  
  public void unInit()
  {
    a();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyVoIPProxy$VoIPListener = null;
  }
  
  public void updateRoomInfo()
  {
    bkdl localbkdl = bkdd.a().a();
    if (localbkdl != null) {
      localbkdl.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blaw
 * JD-Core Version:    0.7.0.1
 */