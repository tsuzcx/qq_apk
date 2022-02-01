import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IliveLaunchFragment;

public class bldw
  implements LoadSoCallback
{
  public bldw(IliveLaunchFragment paramIliveLaunchFragment, long paramLong) {}
  
  public void onLoad(boolean paramBoolean)
  {
    QLog.e("IliveLaunchActivity", 1, "initVideoSDK loadSo = " + paramBoolean);
    blet.b("IliveLaunch initVideoSDK");
    if (paramBoolean)
    {
      blet.a("IliveLaunch initSDKAsync");
      azwq.a(BaseApplicationImpl.getApplication(), new bldx(this));
      return;
    }
    this.jdField_a_of_type_CooperationIliveIliveLaunchFragment.onFail(108, "media play so load fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldw
 * JD-Core Version:    0.7.0.1
 */