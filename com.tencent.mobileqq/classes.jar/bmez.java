import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IliveLaunchFragment;

public class bmez
  implements LoadSoCallback
{
  public bmez(IliveLaunchFragment paramIliveLaunchFragment, long paramLong) {}
  
  public void onLoad(boolean paramBoolean)
  {
    QLog.e("IliveLaunchActivity", 1, "initVideoSDK loadSo = " + paramBoolean);
    bmfw.b("IliveLaunch initVideoSDK");
    if (paramBoolean)
    {
      bmfw.a("IliveLaunch initSDKAsync");
      bapg.a(BaseApplicationImpl.getApplication(), new bmfa(this));
      return;
    }
    this.jdField_a_of_type_CooperationIliveIliveLaunchFragment.onFail(108, "media play so load fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmez
 * JD-Core Version:    0.7.0.1
 */