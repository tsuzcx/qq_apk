import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bfkb
{
  protected boolean a;
  
  private bfkb(bfjt parambfjt) {}
  
  public void a()
  {
    if (this.a) {
      bfjt.a(this.b).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    bfjm localbfjm2;
    do
    {
      return;
      localbfjm2 = bfjt.a(this.b).a(paramInt1);
    } while ((localbfjm2 != null) && (paramString1.equals(localbfjm2.jdField_b_of_type_JavaLangString)) && (paramString2.equals(localbfjm2.jdField_a_of_type_JavaLangString)) && (paramInt2 == localbfjm2.jdField_b_of_type_Int) && (paramInt3 == localbfjm2.c));
    bfjm localbfjm1;
    if (localbfjm2 == null) {
      localbfjm1 = new bfjm();
    }
    for (;;)
    {
      localbfjm1.jdField_a_of_type_Int = paramInt1;
      localbfjm1.jdField_b_of_type_Int = paramInt2;
      localbfjm1.c = paramInt3;
      localbfjm1.jdField_b_of_type_JavaLangString = paramString1;
      localbfjm1.jdField_a_of_type_JavaLangString = paramString2;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(localbfjm1.jdField_a_of_type_Int), Integer.valueOf(localbfjm1.jdField_b_of_type_Int), Integer.valueOf(localbfjm1.c), localbfjm1.jdField_b_of_type_JavaLangString }));
      }
      bfjt.a(this.b).a(localbfjm1, false);
      this.a = true;
      return;
      bfjt.a(this.b).a(paramInt1, false);
      localbfjm1 = localbfjm2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QSec", 2, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
        localbfjm1 = localbfjm2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfkb
 * JD-Core Version:    0.7.0.1
 */