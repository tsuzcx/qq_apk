import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bfjk
{
  protected boolean a;
  
  private bfjk(bfjc parambfjc) {}
  
  public void a()
  {
    if (this.a) {
      bfjc.a(this.b).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    bfiv localbfiv2;
    do
    {
      return;
      localbfiv2 = bfjc.a(this.b).a(paramInt1);
    } while ((localbfiv2 != null) && (paramString1.equals(localbfiv2.jdField_b_of_type_JavaLangString)) && (paramString2.equals(localbfiv2.jdField_a_of_type_JavaLangString)) && (paramInt2 == localbfiv2.jdField_b_of_type_Int) && (paramInt3 == localbfiv2.c));
    bfiv localbfiv1;
    if (localbfiv2 == null) {
      localbfiv1 = new bfiv();
    }
    for (;;)
    {
      localbfiv1.jdField_a_of_type_Int = paramInt1;
      localbfiv1.jdField_b_of_type_Int = paramInt2;
      localbfiv1.c = paramInt3;
      localbfiv1.jdField_b_of_type_JavaLangString = paramString1;
      localbfiv1.jdField_a_of_type_JavaLangString = paramString2;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(localbfiv1.jdField_a_of_type_Int), Integer.valueOf(localbfiv1.jdField_b_of_type_Int), Integer.valueOf(localbfiv1.c), localbfiv1.jdField_b_of_type_JavaLangString }));
      }
      bfjc.a(this.b).a(localbfiv1, false);
      this.a = true;
      return;
      bfjc.a(this.b).a(paramInt1, false);
      localbfiv1 = localbfiv2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QSec", 2, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
        localbfiv1 = localbfiv2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfjk
 * JD-Core Version:    0.7.0.1
 */