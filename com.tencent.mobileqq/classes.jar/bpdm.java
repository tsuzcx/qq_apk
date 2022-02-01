import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.1;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.2;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean;
import java.io.File;
import mqq.os.MqqHandler;

public class bpdm
{
  private static volatile bpdm jdField_a_of_type_Bpdm;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private bpdn jdField_a_of_type_Bpdn;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  private bpdm()
  {
    bpam.b("AEEditorEffectConfigManager", "AEEditorEffectConfigManager init.");
  }
  
  public static bpdm a()
  {
    if (jdField_a_of_type_Bpdm == null) {}
    try
    {
      if (jdField_a_of_type_Bpdm == null) {
        jdField_a_of_type_Bpdm = new bpdm();
      }
      return jdField_a_of_type_Bpdm;
    }
    finally {}
  }
  
  public static String a()
  {
    return bpbq.f + File.separator + "effect_group_list.json";
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = new AEEditorEffectConfigManager.2(this);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(bpdn parambpdn)
  {
    this.jdField_a_of_type_Bpdn = parambpdn;
    a();
  }
  
  public void a(AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean)
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorEffectConfigManager.1(this, paramAEEditorEffectGroupListBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdm
 * JD-Core Version:    0.7.0.1
 */