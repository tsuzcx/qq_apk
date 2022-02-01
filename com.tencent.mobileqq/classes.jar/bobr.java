import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.1;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.2;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean;
import java.io.File;
import mqq.os.MqqHandler;

public class bobr
{
  private static volatile bobr jdField_a_of_type_Bobr;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private bobs jdField_a_of_type_Bobs;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  private bobr()
  {
    bnzb.b("AEEditorEffectConfigManager", "AEEditorEffectConfigManager init.");
  }
  
  public static bobr a()
  {
    if (jdField_a_of_type_Bobr == null) {}
    try
    {
      if (jdField_a_of_type_Bobr == null) {
        jdField_a_of_type_Bobr = new bobr();
      }
      return jdField_a_of_type_Bobr;
    }
    finally {}
  }
  
  public static String a()
  {
    return bnzv.f + File.separator + "effect_group_list.json";
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = new AEEditorEffectConfigManager.2(this);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(bobs parambobs)
  {
    this.jdField_a_of_type_Bobs = parambobs;
    a();
  }
  
  public void a(AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean)
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorEffectConfigManager.1(this, paramAEEditorEffectGroupListBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bobr
 * JD-Core Version:    0.7.0.1
 */