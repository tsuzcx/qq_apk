import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.haoliyou.JefsClass;
import java.lang.ref.WeakReference;

public class avpj
  implements aqji
{
  public avpj(JefsClass paramJefsClass, Runnable paramRunnable, WeakReference paramWeakReference, String paramString) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    if ((!paramBoolean1) || ((paramBoolean2) && (this.jdField_a_of_type_JavaLangRunnable != null)))
    {
      JefsClass.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass, this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    paramString1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString1 != null) {
      if ((paramString1 instanceof BaseActivity))
      {
        paramString1 = ((BaseActivity)paramString1).app;
        if (this.jdField_a_of_type_JavaLangString != null) {
          break label111;
        }
      }
    }
    label111:
    for (paramString2 = "";; paramString2 = this.jdField_a_of_type_JavaLangString)
    {
      bdll.b(paramString1, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "1", "", paramString2, "");
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangRunnable != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpj
 * JD-Core Version:    0.7.0.1
 */