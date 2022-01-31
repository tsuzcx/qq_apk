import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class bhox
  extends bhpc
{
  private boolean b;
  
  bhox(bhou parambhou)
  {
    super(parambhou, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      bhou.a(this.jdField_a_of_type_Bhou).a();
    }
    if (this.b) {
      bhou.d(this.jdField_a_of_type_Bhou);
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
    bhon localbhon = bhou.a(this.jdField_a_of_type_Bhou).a(paramInt1);
    if (localbhon != null) {
      bhou.a(this.jdField_a_of_type_Bhou).a(localbhon.jdField_a_of_type_Int, false);
    }
    for (;;)
    {
      localbhon.jdField_a_of_type_Int = paramInt1;
      localbhon.jdField_b_of_type_Int = paramInt2;
      localbhon.c = paramInt3;
      localbhon.jdField_b_of_type_JavaLangString = paramString1;
      localbhon.jdField_a_of_type_JavaLangString = paramString2;
      bhou.a(this.jdField_a_of_type_Bhou).a(localbhon, false);
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt4 != 1) || (bhou.a(this.jdField_a_of_type_Bhou).a(paramInt1) != 1)) {
        break;
      }
      this.b = true;
      bhoz localbhoz = (bhoz)bhou.a(this.jdField_a_of_type_Bhou).get(Integer.valueOf(paramInt1));
      if (localbhoz == null) {
        break label236;
      }
      bhou.a(this.jdField_a_of_type_Bhou, localbhoz, paramString2, paramString1);
      if (localbhoz.d == 0) {
        break;
      }
      bhou.a(this.jdField_a_of_type_Bhou).remove(Integer.valueOf(localbhoz.jdField_a_of_type_Int));
      return;
      localbhon = new bhon();
    }
    label236:
    paramString1 = bhou.a(this.jdField_a_of_type_Bhou, localbhon);
    bhou.a(this.jdField_a_of_type_Bhou, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhox
 * JD-Core Version:    0.7.0.1
 */