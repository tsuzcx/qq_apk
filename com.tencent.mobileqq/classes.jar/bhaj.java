import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class bhaj
  extends QIPCModule
{
  public static boolean a;
  
  public bhaj(String paramString)
  {
    super(paramString);
  }
  
  public static bhaj a()
  {
    return bhak.a();
  }
  
  public static void a()
  {
    bhaj localbhaj = a();
    if (!a)
    {
      QIPCClientHelper.getInstance().register(localbhaj);
      a = true;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_get_send_to_info".equals(paramString)) {
      bhci.a().a(Long.valueOf(paramBundle.getLong("key_receiver_type")));
    }
    for (;;)
    {
      return null;
      if ("action_get_cancle_send_info".equals(paramString)) {
        bhci.a().z();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhaj
 * JD-Core Version:    0.7.0.1
 */