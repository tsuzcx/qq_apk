import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class bmez
  extends QIPCModule
{
  private static volatile bmez jdField_a_of_type_Bmez;
  private static boolean jdField_a_of_type_Boolean;
  
  private bmez()
  {
    super("AEEditorEffectIpcModule");
  }
  
  public static bmez a()
  {
    if (jdField_a_of_type_Bmez == null) {}
    try
    {
      if (jdField_a_of_type_Bmez == null) {
        jdField_a_of_type_Bmez = new bmez();
      }
      return jdField_a_of_type_Bmez;
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
      bmew.a().a(new bmfa(this, paramInt));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmez
 * JD-Core Version:    0.7.0.1
 */