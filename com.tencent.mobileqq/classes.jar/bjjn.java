import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class bjjn
  extends bjjs
{
  private boolean b;
  
  bjjn(bjjk parambjjk)
  {
    super(parambjjk, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      bjjk.a(this.jdField_a_of_type_Bjjk).a();
    }
    if (this.b) {
      bjjk.d(this.jdField_a_of_type_Bjjk);
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
    bjjd localbjjd = bjjk.a(this.jdField_a_of_type_Bjjk).a(paramInt1);
    if (localbjjd != null) {
      bjjk.a(this.jdField_a_of_type_Bjjk).a(localbjjd.jdField_a_of_type_Int, false);
    }
    for (;;)
    {
      localbjjd.jdField_a_of_type_Int = paramInt1;
      localbjjd.jdField_b_of_type_Int = paramInt2;
      localbjjd.c = paramInt3;
      localbjjd.jdField_b_of_type_JavaLangString = paramString1;
      localbjjd.jdField_a_of_type_JavaLangString = paramString2;
      bjjk.a(this.jdField_a_of_type_Bjjk).a(localbjjd, false);
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt4 != 1) || (bjjk.a(this.jdField_a_of_type_Bjjk).a(paramInt1) != 1)) {
        break;
      }
      this.b = true;
      bjjp localbjjp = (bjjp)bjjk.a(this.jdField_a_of_type_Bjjk).get(Integer.valueOf(paramInt1));
      if (localbjjp == null) {
        break label236;
      }
      bjjk.a(this.jdField_a_of_type_Bjjk, localbjjp, paramString2, paramString1);
      if (localbjjp.d == 0) {
        break;
      }
      bjjk.a(this.jdField_a_of_type_Bjjk).remove(Integer.valueOf(localbjjp.jdField_a_of_type_Int));
      return;
      localbjjd = new bjjd();
    }
    label236:
    paramString1 = bjjk.a(this.jdField_a_of_type_Bjjk, localbjjd);
    bjjk.a(this.jdField_a_of_type_Bjjk, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjjn
 * JD-Core Version:    0.7.0.1
 */