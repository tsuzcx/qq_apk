import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class bnur
  extends QIPCModule
{
  private static volatile bnur jdField_a_of_type_Bnur;
  private static boolean jdField_a_of_type_Boolean;
  
  private bnur()
  {
    super("AEEditorEffectIpcModule");
  }
  
  public static bnur a()
  {
    if (jdField_a_of_type_Bnur == null) {}
    try
    {
      if (jdField_a_of_type_Bnur == null) {
        jdField_a_of_type_Bnur = new bnur();
      }
      return jdField_a_of_type_Bnur;
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
      bnuo.a().a(new bnus(this, paramInt));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnur
 * JD-Core Version:    0.7.0.1
 */