import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bebu
{
  protected boolean a;
  
  private bebu(bebm parambebm) {}
  
  public void a()
  {
    if (this.a) {
      bebm.a(this.b).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    bebf localbebf2;
    do
    {
      return;
      localbebf2 = bebm.a(this.b).a(paramInt1);
    } while ((localbebf2 != null) && (paramString1.equals(localbebf2.jdField_b_of_type_JavaLangString)) && (paramString2.equals(localbebf2.jdField_a_of_type_JavaLangString)) && (paramInt2 == localbebf2.jdField_b_of_type_Int) && (paramInt3 == localbebf2.c));
    bebf localbebf1;
    if (localbebf2 == null) {
      localbebf1 = new bebf();
    }
    for (;;)
    {
      localbebf1.jdField_a_of_type_Int = paramInt1;
      localbebf1.jdField_b_of_type_Int = paramInt2;
      localbebf1.c = paramInt3;
      localbebf1.jdField_b_of_type_JavaLangString = paramString1;
      localbebf1.jdField_a_of_type_JavaLangString = paramString2;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(localbebf1.jdField_a_of_type_Int), Integer.valueOf(localbebf1.jdField_b_of_type_Int), Integer.valueOf(localbebf1.c), localbebf1.jdField_b_of_type_JavaLangString }));
      }
      bebm.a(this.b).a(localbebf1, false);
      this.a = true;
      return;
      bebm.a(this.b).a(paramInt1, false);
      localbebf1 = localbebf2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QSec", 2, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
        localbebf1 = localbebf2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bebu
 * JD-Core Version:    0.7.0.1
 */