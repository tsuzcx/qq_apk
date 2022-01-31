import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class bebp
  extends bebu
{
  private boolean b;
  
  bebp(bebm parambebm)
  {
    super(parambebm, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      bebm.a(this.jdField_a_of_type_Bebm).a();
    }
    if (this.b) {
      bebm.d(this.jdField_a_of_type_Bebm);
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
    bebf localbebf = bebm.a(this.jdField_a_of_type_Bebm).a(paramInt1);
    if (localbebf != null) {
      bebm.a(this.jdField_a_of_type_Bebm).a(localbebf.jdField_a_of_type_Int, false);
    }
    for (;;)
    {
      localbebf.jdField_a_of_type_Int = paramInt1;
      localbebf.jdField_b_of_type_Int = paramInt2;
      localbebf.c = paramInt3;
      localbebf.jdField_b_of_type_JavaLangString = paramString1;
      localbebf.jdField_a_of_type_JavaLangString = paramString2;
      bebm.a(this.jdField_a_of_type_Bebm).a(localbebf, false);
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt4 != 1) || (bebm.a(this.jdField_a_of_type_Bebm).a(paramInt1) != 1)) {
        break;
      }
      this.b = true;
      bebr localbebr = (bebr)bebm.a(this.jdField_a_of_type_Bebm).get(Integer.valueOf(paramInt1));
      if (localbebr == null) {
        break label236;
      }
      bebm.a(this.jdField_a_of_type_Bebm, localbebr, paramString2, paramString1);
      if (localbebr.d == 0) {
        break;
      }
      bebm.a(this.jdField_a_of_type_Bebm).remove(Integer.valueOf(localbebr.jdField_a_of_type_Int));
      return;
      localbebf = new bebf();
    }
    label236:
    paramString1 = bebm.a(this.jdField_a_of_type_Bebm, localbebf);
    bebm.a(this.jdField_a_of_type_Bebm, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bebp
 * JD-Core Version:    0.7.0.1
 */