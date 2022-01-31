import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bhkv
{
  protected boolean a;
  
  private bhkv(bhkn parambhkn) {}
  
  public void a()
  {
    if (this.a) {
      bhkn.a(this.b).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    bhkg localbhkg2;
    do
    {
      return;
      localbhkg2 = bhkn.a(this.b).a(paramInt1);
    } while ((localbhkg2 != null) && (paramString1.equals(localbhkg2.jdField_b_of_type_JavaLangString)) && (paramString2.equals(localbhkg2.jdField_a_of_type_JavaLangString)) && (paramInt2 == localbhkg2.jdField_b_of_type_Int) && (paramInt3 == localbhkg2.c));
    bhkg localbhkg1;
    if (localbhkg2 == null) {
      localbhkg1 = new bhkg();
    }
    for (;;)
    {
      localbhkg1.jdField_a_of_type_Int = paramInt1;
      localbhkg1.jdField_b_of_type_Int = paramInt2;
      localbhkg1.c = paramInt3;
      localbhkg1.jdField_b_of_type_JavaLangString = paramString1;
      localbhkg1.jdField_a_of_type_JavaLangString = paramString2;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(localbhkg1.jdField_a_of_type_Int), Integer.valueOf(localbhkg1.jdField_b_of_type_Int), Integer.valueOf(localbhkg1.c), localbhkg1.jdField_b_of_type_JavaLangString }));
      }
      bhkn.a(this.b).a(localbhkg1, false);
      this.a = true;
      return;
      bhkn.a(this.b).a(paramInt1, false);
      localbhkg1 = localbhkg2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QSec", 2, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
        localbhkg1 = localbhkg2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhkv
 * JD-Core Version:    0.7.0.1
 */