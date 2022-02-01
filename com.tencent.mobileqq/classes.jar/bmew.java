import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.1;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.2;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean;
import java.io.File;
import mqq.os.MqqHandler;

public class bmew
{
  private static volatile bmew jdField_a_of_type_Bmew;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private bmex jdField_a_of_type_Bmex;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  private bmew()
  {
    bmbx.b("AEEditorEffectConfigManager", "AEEditorEffectConfigManager init.");
  }
  
  public static bmew a()
  {
    if (jdField_a_of_type_Bmew == null) {}
    try
    {
      if (jdField_a_of_type_Bmew == null) {
        jdField_a_of_type_Bmew = new bmew();
      }
      return jdField_a_of_type_Bmew;
    }
    finally {}
  }
  
  public static String a()
  {
    return bmda.f + File.separator + "effect_group_list.json";
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = new AEEditorEffectConfigManager.2(this);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(bmex parambmex)
  {
    this.jdField_a_of_type_Bmex = parambmex;
    a();
  }
  
  public void a(AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean)
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorEffectConfigManager.1(this, paramAEEditorEffectGroupListBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmew
 * JD-Core Version:    0.7.0.1
 */