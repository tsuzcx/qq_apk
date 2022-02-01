import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.1;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.2;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean;
import java.io.File;
import mqq.os.MqqHandler;

public class bnuo
{
  private static volatile bnuo jdField_a_of_type_Bnuo;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private bnup jdField_a_of_type_Bnup;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  private bnuo()
  {
    bnrh.b("AEEditorEffectConfigManager", "AEEditorEffectConfigManager init.");
  }
  
  public static bnuo a()
  {
    if (jdField_a_of_type_Bnuo == null) {}
    try
    {
      if (jdField_a_of_type_Bnuo == null) {
        jdField_a_of_type_Bnuo = new bnuo();
      }
      return jdField_a_of_type_Bnuo;
    }
    finally {}
  }
  
  public static String a()
  {
    return bnss.f + File.separator + "effect_group_list.json";
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = new AEEditorEffectConfigManager.2(this);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(bnup parambnup)
  {
    this.jdField_a_of_type_Bnup = parambnup;
    a();
  }
  
  public void a(AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean)
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorEffectConfigManager.1(this, paramAEEditorEffectGroupListBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnuo
 * JD-Core Version:    0.7.0.1
 */