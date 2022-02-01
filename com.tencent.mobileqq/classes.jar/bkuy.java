import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class bkuy
  extends bkvd
{
  private boolean b;
  
  bkuy(bkuv parambkuv)
  {
    super(parambkuv, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      bkuv.a(this.jdField_a_of_type_Bkuv).a();
    }
    if (this.b) {
      bkuv.d(this.jdField_a_of_type_Bkuv);
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
    bkuo localbkuo = bkuv.a(this.jdField_a_of_type_Bkuv).a(paramInt1);
    if (localbkuo != null) {
      bkuv.a(this.jdField_a_of_type_Bkuv).a(localbkuo.jdField_a_of_type_Int, false);
    }
    for (;;)
    {
      localbkuo.jdField_a_of_type_Int = paramInt1;
      localbkuo.jdField_b_of_type_Int = paramInt2;
      localbkuo.c = paramInt3;
      localbkuo.jdField_b_of_type_JavaLangString = paramString1;
      localbkuo.jdField_a_of_type_JavaLangString = paramString2;
      bkuv.a(this.jdField_a_of_type_Bkuv).a(localbkuo, false);
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt4 != 1) || (bkuv.a(this.jdField_a_of_type_Bkuv).a(paramInt1) != 1)) {
        break;
      }
      this.b = true;
      bkva localbkva = (bkva)bkuv.a(this.jdField_a_of_type_Bkuv).get(Integer.valueOf(paramInt1));
      if (localbkva == null) {
        break label236;
      }
      bkuv.a(this.jdField_a_of_type_Bkuv, localbkva, paramString2, paramString1);
      if (localbkva.d == 0) {
        break;
      }
      bkuv.a(this.jdField_a_of_type_Bkuv).remove(Integer.valueOf(localbkva.jdField_a_of_type_Int));
      return;
      localbkuo = new bkuo();
    }
    label236:
    paramString1 = bkuv.a(this.jdField_a_of_type_Bkuv, localbkuo);
    bkuv.a(this.jdField_a_of_type_Bkuv, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkuy
 * JD-Core Version:    0.7.0.1
 */