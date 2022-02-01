import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class bpxu
  extends QIPCModule
{
  private static bpxu jdField_a_of_type_Bpxu;
  public static boolean a;
  private String jdField_a_of_type_JavaLangString;
  private boolean b;
  
  private bpxu()
  {
    super("PeakIpcModuleClient");
    b();
  }
  
  /* Error */
  public static bpxu a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 22	bpxu:jdField_a_of_type_Bpxu	Lbpxu;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 22	bpxu:jdField_a_of_type_Bpxu	Lbpxu;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	bpxu
    //   21: dup
    //   22: invokespecial 24	bpxu:<init>	()V
    //   25: putstatic 22	bpxu:jdField_a_of_type_Bpxu	Lbpxu;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 22	bpxu:jdField_a_of_type_Bpxu	Lbpxu;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localbpxu	bpxu
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  public static void a()
  {
    bpxu localbpxu = a();
    if (!jdField_a_of_type_Boolean)
    {
      QIPCClientHelper.getInstance().register(localbpxu);
      jdField_a_of_type_Boolean = true;
    }
  }
  
  private void b()
  {
    QIPCClientHelper.getInstance().getClient().connect(new bpxv(this));
    QIPCClientHelper.getInstance().getClient().addListener(new bpxw(this));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (("action_update_status".equals(paramString)) && (paramBundle != null))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramInt = paramBundle.getInt("key_status");
      int i = paramBundle.getInt("key_progress");
      paramString = paramBundle.getString("uin");
      int j = paramBundle.getInt("uintype");
      paramBundle.getString("key_file_md5");
      long l = paramBundle.getLong("key_uinsequence");
      bqvm.a().a(paramString, j, paramInt, i, l);
      localBundle.putBoolean("key_result", false);
    }
    return EIPCResult.createSuccessResult(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxu
 * JD-Core Version:    0.7.0.1
 */