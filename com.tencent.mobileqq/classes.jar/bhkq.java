import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class bhkq
  extends bhkv
{
  private boolean b;
  
  bhkq(bhkn parambhkn)
  {
    super(parambhkn, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      bhkn.a(this.jdField_a_of_type_Bhkn).a();
    }
    if (this.b) {
      bhkn.d(this.jdField_a_of_type_Bhkn);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      if ((paramInt4 == 1) || (paramInt4 == 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQProtect.QSec", 2, String.format("Invalid mode: %d", new Object[] { Integer.valueOf(paramInt4) }));
    return;
    bhkg localbhkg = bhkn.a(this.jdField_a_of_type_Bhkn).a(paramInt1);
    if (localbhkg != null) {
      bhkn.a(this.jdField_a_of_type_Bhkn).a(localbhkg.jdField_a_of_type_Int, false);
    }
    for (;;)
    {
      localbhkg.jdField_a_of_type_Int = paramInt1;
      localbhkg.jdField_b_of_type_Int = paramInt2;
      localbhkg.c = paramInt3;
      localbhkg.jdField_b_of_type_JavaLangString = paramString1;
      localbhkg.jdField_a_of_type_JavaLangString = paramString2;
      bhkn.a(this.jdField_a_of_type_Bhkn).a(localbhkg, false);
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt4 != 1) || (bhkn.a(this.jdField_a_of_type_Bhkn).a(paramInt1) != 1)) {
        break;
      }
      this.b = true;
      bhks localbhks = (bhks)bhkn.a(this.jdField_a_of_type_Bhkn).get(Integer.valueOf(paramInt1));
      if (localbhks == null) {
        break label236;
      }
      bhkn.a(this.jdField_a_of_type_Bhkn, localbhks, paramString2, paramString1);
      if (localbhks.d == 0) {
        break;
      }
      bhkn.a(this.jdField_a_of_type_Bhkn).remove(Integer.valueOf(localbhks.jdField_a_of_type_Int));
      return;
      localbhkg = new bhkg();
    }
    label236:
    paramString1 = bhkn.a(this.jdField_a_of_type_Bhkn, localbhkg);
    bhkn.a(this.jdField_a_of_type_Bhkn, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhkq
 * JD-Core Version:    0.7.0.1
 */