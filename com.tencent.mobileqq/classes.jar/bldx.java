import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IliveLaunchFragment;
import java.util.HashMap;

class bldx
  implements SDKInitListener
{
  bldx(bldw parambldw) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    blet.b("IliveLaunch initSDKAsync");
    HashMap localHashMap = new HashMap();
    if (azwq.b()) {}
    for (String str = "sucess";; str = "error")
    {
      localHashMap.put("status_msg", str);
      localHashMap.put("isDebug", "0");
      bhak.a("live_player_load", localHashMap, System.currentTimeMillis() - this.a.jdField_a_of_type_Long);
      QLog.e("IliveLaunchActivity", 1, "initVideoSDK status = " + azwq.b());
      IliveLaunchFragment.access$202(this.a.jdField_a_of_type_CooperationIliveIliveLaunchFragment, azwq.b());
      QLog.e("IliveLaunchActivity", 1, "initVideoSDK onSDKInited = " + paramBoolean);
      if (!IliveLaunchFragment.access$200(this.a.jdField_a_of_type_CooperationIliveIliveLaunchFragment)) {
        this.a.jdField_a_of_type_CooperationIliveIliveLaunchFragment.onFail(108, "media play so load fail");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldx
 * JD-Core Version:    0.7.0.1
 */