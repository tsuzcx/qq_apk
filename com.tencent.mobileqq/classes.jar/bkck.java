import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bkck
{
  protected boolean a;
  
  private bkck(bkcc parambkcc) {}
  
  public void a()
  {
    if (this.a) {
      bkcc.a(this.b).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    bkbv localbkbv2;
    do
    {
      return;
      localbkbv2 = bkcc.a(this.b).a(paramInt1);
    } while ((localbkbv2 != null) && (paramString1.equals(localbkbv2.jdField_b_of_type_JavaLangString)) && (paramString2.equals(localbkbv2.jdField_a_of_type_JavaLangString)) && (paramInt2 == localbkbv2.jdField_b_of_type_Int) && (paramInt3 == localbkbv2.c));
    bkbv localbkbv1;
    if (localbkbv2 == null) {
      localbkbv1 = new bkbv();
    }
    for (;;)
    {
      localbkbv1.jdField_a_of_type_Int = paramInt1;
      localbkbv1.jdField_b_of_type_Int = paramInt2;
      localbkbv1.c = paramInt3;
      localbkbv1.jdField_b_of_type_JavaLangString = paramString1;
      localbkbv1.jdField_a_of_type_JavaLangString = paramString2;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(localbkbv1.jdField_a_of_type_Int), Integer.valueOf(localbkbv1.jdField_b_of_type_Int), Integer.valueOf(localbkbv1.c), localbkbv1.jdField_b_of_type_JavaLangString }));
      }
      bkcc.a(this.b).a(localbkbv1, false);
      this.a = true;
      return;
      bkcc.a(this.b).a(paramInt1, false);
      localbkbv1 = localbkbv2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QSec", 2, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
        localbkbv1 = localbkbv2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkck
 * JD-Core Version:    0.7.0.1
 */