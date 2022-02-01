import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bkvd
{
  protected boolean a;
  
  private bkvd(bkuv parambkuv) {}
  
  public void a()
  {
    if (this.a) {
      bkuv.a(this.b).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    bkuo localbkuo2;
    do
    {
      return;
      localbkuo2 = bkuv.a(this.b).a(paramInt1);
    } while ((localbkuo2 != null) && (paramString1.equals(localbkuo2.jdField_b_of_type_JavaLangString)) && (paramString2.equals(localbkuo2.jdField_a_of_type_JavaLangString)) && (paramInt2 == localbkuo2.jdField_b_of_type_Int) && (paramInt3 == localbkuo2.c));
    bkuo localbkuo1;
    if (localbkuo2 == null) {
      localbkuo1 = new bkuo();
    }
    for (;;)
    {
      localbkuo1.jdField_a_of_type_Int = paramInt1;
      localbkuo1.jdField_b_of_type_Int = paramInt2;
      localbkuo1.c = paramInt3;
      localbkuo1.jdField_b_of_type_JavaLangString = paramString1;
      localbkuo1.jdField_a_of_type_JavaLangString = paramString2;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(localbkuo1.jdField_a_of_type_Int), Integer.valueOf(localbkuo1.jdField_b_of_type_Int), Integer.valueOf(localbkuo1.c), localbkuo1.jdField_b_of_type_JavaLangString }));
      }
      bkuv.a(this.b).a(localbkuo1, false);
      this.a = true;
      return;
      bkuv.a(this.b).a(paramInt1, false);
      localbkuo1 = localbkuo2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QSec", 2, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
        localbkuo1 = localbkuo2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvd
 * JD-Core Version:    0.7.0.1
 */