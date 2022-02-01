import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class bckr
  implements bckk
{
  private int jdField_a_of_type_Int;
  protected Context a;
  private bckm jdField_a_of_type_Bckm;
  private bckq jdField_a_of_type_Bckq = new bckq();
  protected QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<bckl> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bckm a()
  {
    return this.jdField_a_of_type_Bckm;
  }
  
  protected abstract bckm a(Context paramContext);
  
  public String a()
  {
    return this.jdField_a_of_type_Bckq.a();
  }
  
  protected void a() {}
  
  public void a(bckl parambckl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambckl);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "create, serverdata:" + paramString1 + "  extredata:" + paramString2 + " config:" + paramString3 + " templateid:" + paramInt);
    }
    this.jdField_a_of_type_Bckq.a(true);
    this.jdField_a_of_type_Bckq.a(paramString1);
    this.jdField_a_of_type_Bckq.b(paramString2);
    this.jdField_a_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bckm = a(paramContext);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "updateData, serverdata:" + paramString1 + "  extredata:" + paramString2 + " config:" + paramString3);
    }
    this.jdField_a_of_type_Bckq.a(paramString1);
    this.jdField_a_of_type_Bckq.b(paramString2);
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
      bckl localbckl = (bckl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbckl != null) {
        localbckl.a(this, paramString1, paramString2);
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
    if (this.jdField_a_of_type_Bckm != null)
    {
      this.jdField_a_of_type_Bckm.f();
      this.jdField_a_of_type_Bckm = null;
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Bckq = null;
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "fireOnRichViewChangedEvent");
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bckl localbckl = (bckl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbckl != null) {
        localbckl.a(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckr
 * JD-Core Version:    0.7.0.1
 */