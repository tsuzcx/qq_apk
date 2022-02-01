import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bldo
{
  protected boolean a;
  
  private bldo(bldg parambldg) {}
  
  public void a()
  {
    if (this.a) {
      bldg.a(this.b).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    blcz localblcz2;
    do
    {
      return;
      localblcz2 = bldg.a(this.b).a(paramInt1);
    } while ((localblcz2 != null) && (paramString1.equals(localblcz2.jdField_b_of_type_JavaLangString)) && (paramString2.equals(localblcz2.jdField_a_of_type_JavaLangString)) && (paramInt2 == localblcz2.jdField_b_of_type_Int) && (paramInt3 == localblcz2.c));
    blcz localblcz1;
    if (localblcz2 == null) {
      localblcz1 = new blcz();
    }
    for (;;)
    {
      localblcz1.jdField_a_of_type_Int = paramInt1;
      localblcz1.jdField_b_of_type_Int = paramInt2;
      localblcz1.c = paramInt3;
      localblcz1.jdField_b_of_type_JavaLangString = paramString1;
      localblcz1.jdField_a_of_type_JavaLangString = paramString2;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(localblcz1.jdField_a_of_type_Int), Integer.valueOf(localblcz1.jdField_b_of_type_Int), Integer.valueOf(localblcz1.c), localblcz1.jdField_b_of_type_JavaLangString }));
      }
      bldg.a(this.b).a(localblcz1, false);
      this.a = true;
      return;
      bldg.a(this.b).a(paramInt1, false);
      localblcz1 = localblcz2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QSec", 2, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
        localblcz1 = localblcz2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldo
 * JD-Core Version:    0.7.0.1
 */