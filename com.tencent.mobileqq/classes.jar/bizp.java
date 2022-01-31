import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class bizp
  extends QIPCModule
{
  private static boolean a;
  
  public bizp(String paramString)
  {
    super(paramString);
  }
  
  public static bizp a()
  {
    return bizq.a;
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
      bizt.a().a(Long.valueOf(paramBundle.getLong("key_receiver_type")));
    }
    for (;;)
    {
      return null;
      if ("action_get_cancle_send_info".equals(paramString)) {
        bizt.a().B();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizp
 * JD-Core Version:    0.7.0.1
 */