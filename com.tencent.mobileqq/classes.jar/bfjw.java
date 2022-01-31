import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class bfjw
  extends bfkb
{
  private boolean b;
  
  bfjw(bfjt parambfjt)
  {
    super(parambfjt, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      bfjt.a(this.jdField_a_of_type_Bfjt).a();
    }
    if (this.b) {
      bfjt.d(this.jdField_a_of_type_Bfjt);
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
    bfjm localbfjm = bfjt.a(this.jdField_a_of_type_Bfjt).a(paramInt1);
    if (localbfjm != null) {
      bfjt.a(this.jdField_a_of_type_Bfjt).a(localbfjm.jdField_a_of_type_Int, false);
    }
    for (;;)
    {
      localbfjm.jdField_a_of_type_Int = paramInt1;
      localbfjm.jdField_b_of_type_Int = paramInt2;
      localbfjm.c = paramInt3;
      localbfjm.jdField_b_of_type_JavaLangString = paramString1;
      localbfjm.jdField_a_of_type_JavaLangString = paramString2;
      bfjt.a(this.jdField_a_of_type_Bfjt).a(localbfjm, false);
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt4 != 1) || (bfjt.a(this.jdField_a_of_type_Bfjt).a(paramInt1) != 1)) {
        break;
      }
      this.b = true;
      bfjy localbfjy = (bfjy)bfjt.a(this.jdField_a_of_type_Bfjt).get(Integer.valueOf(paramInt1));
      if (localbfjy == null) {
        break label236;
      }
      bfjt.a(this.jdField_a_of_type_Bfjt, localbfjy, paramString2, paramString1);
      if (localbfjy.d == 0) {
        break;
      }
      bfjt.a(this.jdField_a_of_type_Bfjt).remove(Integer.valueOf(localbfjy.jdField_a_of_type_Int));
      return;
      localbfjm = new bfjm();
    }
    label236:
    paramString1 = bfjt.a(this.jdField_a_of_type_Bfjt, localbfjm);
    bfjt.a(this.jdField_a_of_type_Bfjt, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfjw
 * JD-Core Version:    0.7.0.1
 */