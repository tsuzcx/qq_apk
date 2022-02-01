import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IliveLaunchFragment;

public class bkiw
  implements LoadSoCallback
{
  public bkiw(IliveLaunchFragment paramIliveLaunchFragment, long paramLong) {}
  
  public void onLoad(boolean paramBoolean)
  {
    QLog.e("IliveLaunchActivity", 1, "initVideoSDK loadSo = " + paramBoolean);
    bkkd.b("IliveLaunch initVideoSDK");
    if (paramBoolean)
    {
      bkkd.a("IliveLaunch initSDKAsync");
      azjl.a(BaseApplicationImpl.getApplication(), new bkix(this));
      return;
    }
    this.jdField_a_of_type_CooperationIliveIliveLaunchFragment.onFail(108, "media play so load fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkiw
 * JD-Core Version:    0.7.0.1
 */