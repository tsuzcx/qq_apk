import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class bozn
  extends QIPCModule
{
  private static boolean a;
  
  public bozn(String paramString)
  {
    super(paramString);
  }
  
  public static bozn a()
  {
    return bozo.a;
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
      bozr.a().a(Long.valueOf(paramBundle.getLong("key_receiver_type")));
    }
    for (;;)
    {
      return null;
      if ("action_get_cancle_send_info".equals(paramString)) {
        bozr.a().W();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozn
 * JD-Core Version:    0.7.0.1
 */