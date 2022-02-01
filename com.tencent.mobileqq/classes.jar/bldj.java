import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class bldj
  extends bldo
{
  private boolean b;
  
  bldj(bldg parambldg)
  {
    super(parambldg, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      bldg.a(this.jdField_a_of_type_Bldg).a();
    }
    if (this.b) {
      bldg.d(this.jdField_a_of_type_Bldg);
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
    blcz localblcz = bldg.a(this.jdField_a_of_type_Bldg).a(paramInt1);
    if (localblcz != null) {
      bldg.a(this.jdField_a_of_type_Bldg).a(localblcz.jdField_a_of_type_Int, false);
    }
    for (;;)
    {
      localblcz.jdField_a_of_type_Int = paramInt1;
      localblcz.jdField_b_of_type_Int = paramInt2;
      localblcz.c = paramInt3;
      localblcz.jdField_b_of_type_JavaLangString = paramString1;
      localblcz.jdField_a_of_type_JavaLangString = paramString2;
      bldg.a(this.jdField_a_of_type_Bldg).a(localblcz, false);
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt4 != 1) || (bldg.a(this.jdField_a_of_type_Bldg).a(paramInt1) != 1)) {
        break;
      }
      this.b = true;
      bldl localbldl = (bldl)bldg.a(this.jdField_a_of_type_Bldg).get(Integer.valueOf(paramInt1));
      if (localbldl == null) {
        break label236;
      }
      bldg.a(this.jdField_a_of_type_Bldg, localbldl, paramString2, paramString1);
      if (localbldl.d == 0) {
        break;
      }
      bldg.a(this.jdField_a_of_type_Bldg).remove(Integer.valueOf(localbldl.jdField_a_of_type_Int));
      return;
      localblcz = new blcz();
    }
    label236:
    paramString1 = bldg.a(this.jdField_a_of_type_Bldg, localblcz);
    bldg.a(this.jdField_a_of_type_Bldg, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldj
 * JD-Core Version:    0.7.0.1
 */