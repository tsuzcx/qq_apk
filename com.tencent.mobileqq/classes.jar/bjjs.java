import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bjjs
{
  protected boolean a;
  
  private bjjs(bjjk parambjjk) {}
  
  public void a()
  {
    if (this.a) {
      bjjk.a(this.b).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    bjjd localbjjd2;
    do
    {
      return;
      localbjjd2 = bjjk.a(this.b).a(paramInt1);
    } while ((localbjjd2 != null) && (paramString1.equals(localbjjd2.jdField_b_of_type_JavaLangString)) && (paramString2.equals(localbjjd2.jdField_a_of_type_JavaLangString)) && (paramInt2 == localbjjd2.jdField_b_of_type_Int) && (paramInt3 == localbjjd2.c));
    bjjd localbjjd1;
    if (localbjjd2 == null) {
      localbjjd1 = new bjjd();
    }
    for (;;)
    {
      localbjjd1.jdField_a_of_type_Int = paramInt1;
      localbjjd1.jdField_b_of_type_Int = paramInt2;
      localbjjd1.c = paramInt3;
      localbjjd1.jdField_b_of_type_JavaLangString = paramString1;
      localbjjd1.jdField_a_of_type_JavaLangString = paramString2;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(localbjjd1.jdField_a_of_type_Int), Integer.valueOf(localbjjd1.jdField_b_of_type_Int), Integer.valueOf(localbjjd1.c), localbjjd1.jdField_b_of_type_JavaLangString }));
      }
      bjjk.a(this.b).a(localbjjd1, false);
      this.a = true;
      return;
      bjjk.a(this.b).a(paramInt1, false);
      localbjjd1 = localbjjd2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QSec", 2, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
        localbjjd1 = localbjjd2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjjs
 * JD-Core Version:    0.7.0.1
 */