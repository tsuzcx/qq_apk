import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class bobu
  extends QIPCModule
{
  private static volatile bobu jdField_a_of_type_Bobu;
  private static boolean jdField_a_of_type_Boolean;
  
  private bobu()
  {
    super("AEEditorEffectIpcModule");
  }
  
  public static bobu a()
  {
    if (jdField_a_of_type_Bobu == null) {}
    try
    {
      if (jdField_a_of_type_Bobu == null) {
        jdField_a_of_type_Bobu = new bobu();
      }
      return jdField_a_of_type_Bobu;
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
      bobr.a().a(new bobv(this, paramInt));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bobu
 * JD-Core Version:    0.7.0.1
 */