import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class avto
  implements avth
{
  private int jdField_a_of_type_Int;
  protected Context a;
  private avtj jdField_a_of_type_Avtj;
  private avtn jdField_a_of_type_Avtn = new avtn();
  protected QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<avti> jdField_a_of_type_JavaLangRefWeakReference;
  
  public avtj a()
  {
    return this.jdField_a_of_type_Avtj;
  }
  
  protected abstract avtj a(Context paramContext);
  
  public String a()
  {
    return this.jdField_a_of_type_Avtn.a();
  }
  
  protected void a() {}
  
  public void a(avti paramavti)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramavti);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "create, serverdata:" + paramString1 + "  extredata:" + paramString2 + " config:" + paramString3 + " templateid:" + paramInt);
    }
    this.jdField_a_of_type_Avtn.a(true);
    this.jdField_a_of_type_Avtn.a(paramString1);
    this.jdField_a_of_type_Avtn.b(paramString2);
    this.jdField_a_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Avtj = a(paramContext);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "updateData, serverdata:" + paramString1 + "  extredata:" + paramString2 + " config:" + paramString3);
    }
    this.jdField_a_of_type_Avtn.a(paramString1);
    this.jdField_a_of_type_Avtn.b(paramString2);
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
      avti localavti = (avti)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localavti != null) {
        localavti.a(this, paramString1, paramString2);
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
    if (this.jdField_a_of_type_Avtj != null)
    {
      this.jdField_a_of_type_Avtj.f();
      this.jdField_a_of_type_Avtj = null;
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Avtn = null;
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "fireOnRichViewChangedEvent");
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      avti localavti = (avti)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localavti != null) {
        localavti.a(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avto
 * JD-Core Version:    0.7.0.1
 */