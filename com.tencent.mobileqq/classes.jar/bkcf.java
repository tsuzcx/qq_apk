import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class bkcf
  extends bkck
{
  private boolean b;
  
  bkcf(bkcc parambkcc)
  {
    super(parambkcc, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      bkcc.a(this.jdField_a_of_type_Bkcc).a();
    }
    if (this.b) {
      bkcc.d(this.jdField_a_of_type_Bkcc);
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
    bkbv localbkbv = bkcc.a(this.jdField_a_of_type_Bkcc).a(paramInt1);
    if (localbkbv != null) {
      bkcc.a(this.jdField_a_of_type_Bkcc).a(localbkbv.jdField_a_of_type_Int, false);
    }
    for (;;)
    {
      localbkbv.jdField_a_of_type_Int = paramInt1;
      localbkbv.jdField_b_of_type_Int = paramInt2;
      localbkbv.c = paramInt3;
      localbkbv.jdField_b_of_type_JavaLangString = paramString1;
      localbkbv.jdField_a_of_type_JavaLangString = paramString2;
      bkcc.a(this.jdField_a_of_type_Bkcc).a(localbkbv, false);
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt4 != 1) || (bkcc.a(this.jdField_a_of_type_Bkcc).a(paramInt1) != 1)) {
        break;
      }
      this.b = true;
      bkch localbkch = (bkch)bkcc.a(this.jdField_a_of_type_Bkcc).get(Integer.valueOf(paramInt1));
      if (localbkch == null) {
        break label236;
      }
      bkcc.a(this.jdField_a_of_type_Bkcc, localbkch, paramString2, paramString1);
      if (localbkch.d == 0) {
        break;
      }
      bkcc.a(this.jdField_a_of_type_Bkcc).remove(Integer.valueOf(localbkch.jdField_a_of_type_Int));
      return;
      localbkbv = new bkbv();
    }
    label236:
    paramString1 = bkcc.a(this.jdField_a_of_type_Bkcc, localbkbv);
    bkcc.a(this.jdField_a_of_type_Bkcc, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkcf
 * JD-Core Version:    0.7.0.1
 */