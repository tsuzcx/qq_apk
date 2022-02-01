import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class bnqi
  extends QIPCModule
{
  private static boolean a;
  
  public bnqi(String paramString)
  {
    super(paramString);
  }
  
  public static bnqi a()
  {
    return bnqj.a;
  }
  
  public static void a()
  {
    if (!a)
    {
      QIPCClientHelper.getInstance().getClient().registerModule(a());
      a = true;
    }
  }
  
  public static void b()
  {
    if (a)
    {
      QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
      a = false;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_get_send_to_info".equals(paramString)) {
      bnqm.a().a(Long.valueOf(paramBundle.getLong("key_receiver_type")));
    }
    for (;;)
    {
      return null;
      if ("action_get_cancle_send_info".equals(paramString)) {
        bnqm.a().aa();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqi
 * JD-Core Version:    0.7.0.1
 */