import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class ayom
  implements ayof
{
  private int jdField_a_of_type_Int;
  protected Context a;
  private ayoh jdField_a_of_type_Ayoh;
  private ayol jdField_a_of_type_Ayol = new ayol();
  protected QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<ayog> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ayoh a()
  {
    return this.jdField_a_of_type_Ayoh;
  }
  
  protected abstract ayoh a(Context paramContext);
  
  public String a()
  {
    return this.jdField_a_of_type_Ayol.a();
  }
  
  protected void a() {}
  
  public void a(ayog paramayog)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramayog);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "create, serverdata:" + paramString1 + "  extredata:" + paramString2 + " config:" + paramString3 + " templateid:" + paramInt);
    }
    this.jdField_a_of_type_Ayol.a(true);
    this.jdField_a_of_type_Ayol.a(paramString1);
    this.jdField_a_of_type_Ayol.b(paramString2);
    this.jdField_a_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ayoh = a(paramContext);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "updateData, serverdata:" + paramString1 + "  extredata:" + paramString2 + " config:" + paramString3);
    }
    this.jdField_a_of_type_Ayol.a(paramString1);
    this.jdField_a_of_type_Ayol.b(paramString2);
    this.jdField_a_of_type_JavaLangString = paramString3;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "pause");
    }
  }
  
  protected void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "fireEvent, key:" + paramString1 + " value:" + paramString2);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      ayog localayog = (ayog)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localayog != null) {
        localayog.a(this, paramString1, paramString2);
      }
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "resume");
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "destroy");
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_Ayoh != null)
    {
      this.jdField_a_of_type_Ayoh.f();
      this.jdField_a_of_type_Ayoh = null;
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Ayol = null;
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "fireOnRichViewChangedEvent");
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      ayog localayog = (ayog)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localayog != null) {
        localayog.a(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayom
 * JD-Core Version:    0.7.0.1
 */