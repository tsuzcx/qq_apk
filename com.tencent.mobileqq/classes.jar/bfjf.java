import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class bfjf
  extends bfjk
{
  private boolean b;
  
  bfjf(bfjc parambfjc)
  {
    super(parambfjc, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      bfjc.a(this.jdField_a_of_type_Bfjc).a();
    }
    if (this.b) {
      bfjc.d(this.jdField_a_of_type_Bfjc);
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
    bfiv localbfiv = bfjc.a(this.jdField_a_of_type_Bfjc).a(paramInt1);
    if (localbfiv != null) {
      bfjc.a(this.jdField_a_of_type_Bfjc).a(localbfiv.jdField_a_of_type_Int, false);
    }
    for (;;)
    {
      localbfiv.jdField_a_of_type_Int = paramInt1;
      localbfiv.jdField_b_of_type_Int = paramInt2;
      localbfiv.c = paramInt3;
      localbfiv.jdField_b_of_type_JavaLangString = paramString1;
      localbfiv.jdField_a_of_type_JavaLangString = paramString2;
      bfjc.a(this.jdField_a_of_type_Bfjc).a(localbfiv, false);
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt4 != 1) || (bfjc.a(this.jdField_a_of_type_Bfjc).a(paramInt1) != 1)) {
        break;
      }
      this.b = true;
      bfjh localbfjh = (bfjh)bfjc.a(this.jdField_a_of_type_Bfjc).get(Integer.valueOf(paramInt1));
      if (localbfjh == null) {
        break label236;
      }
      bfjc.a(this.jdField_a_of_type_Bfjc, localbfjh, paramString2, paramString1);
      if (localbfjh.d == 0) {
        break;
      }
      bfjc.a(this.jdField_a_of_type_Bfjc).remove(Integer.valueOf(localbfjh.jdField_a_of_type_Int));
      return;
      localbfiv = new bfiv();
    }
    label236:
    paramString1 = bfjc.a(this.jdField_a_of_type_Bfjc, localbfiv);
    bfjc.a(this.jdField_a_of_type_Bfjc, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfjf
 * JD-Core Version:    0.7.0.1
 */