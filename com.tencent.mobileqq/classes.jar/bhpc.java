import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bhpc
{
  protected boolean a;
  
  private bhpc(bhou parambhou) {}
  
  public void a()
  {
    if (this.a) {
      bhou.a(this.b).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    bhon localbhon2;
    do
    {
      return;
      localbhon2 = bhou.a(this.b).a(paramInt1);
    } while ((localbhon2 != null) && (paramString1.equals(localbhon2.jdField_b_of_type_JavaLangString)) && (paramString2.equals(localbhon2.jdField_a_of_type_JavaLangString)) && (paramInt2 == localbhon2.jdField_b_of_type_Int) && (paramInt3 == localbhon2.c));
    bhon localbhon1;
    if (localbhon2 == null) {
      localbhon1 = new bhon();
    }
    for (;;)
    {
      localbhon1.jdField_a_of_type_Int = paramInt1;
      localbhon1.jdField_b_of_type_Int = paramInt2;
      localbhon1.c = paramInt3;
      localbhon1.jdField_b_of_type_JavaLangString = paramString1;
      localbhon1.jdField_a_of_type_JavaLangString = paramString2;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(localbhon1.jdField_a_of_type_Int), Integer.valueOf(localbhon1.jdField_b_of_type_Int), Integer.valueOf(localbhon1.c), localbhon1.jdField_b_of_type_JavaLangString }));
      }
      bhou.a(this.b).a(localbhon1, false);
      this.a = true;
      return;
      bhou.a(this.b).a(paramInt1, false);
      localbhon1 = localbhon2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QSec", 2, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
        localbhon1 = localbhon2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhpc
 * JD-Core Version:    0.7.0.1
 */