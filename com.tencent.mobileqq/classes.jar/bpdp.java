import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class bpdp
  extends QIPCModule
{
  private static volatile bpdp jdField_a_of_type_Bpdp;
  private static boolean jdField_a_of_type_Boolean;
  
  private bpdp()
  {
    super("AEEditorEffectIpcModule");
  }
  
  public static bpdp a()
  {
    if (jdField_a_of_type_Bpdp == null) {}
    try
    {
      if (jdField_a_of_type_Bpdp == null) {
        jdField_a_of_type_Bpdp = new bpdp();
      }
      return jdField_a_of_type_Bpdp;
    }
    finally {}
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      QIPCClientHelper.getInstance().getClient().registerModule(a());
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_get_effect_list".equals(paramString)) {
      bpdm.a().a(new bpdq(this, paramInt));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdp
 * JD-Core Version:    0.7.0.1
 */