import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class axkc
  implements bapx
{
  axka jdField_a_of_type_Axka;
  axkb jdField_a_of_type_Axkb;
  
  axkc(axjt paramaxjt, axkb paramaxkb, axka paramaxka)
  {
    this.jdField_a_of_type_Axkb = paramaxkb;
    this.jdField_a_of_type_Axka = paramaxka;
  }
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(parambaqw.c), this.jdField_a_of_type_Axka.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Axka.c }));
    }
    parambaqw = (axka)parambaqw.a.a();
    if (parambaqw == null) {}
    label269:
    label286:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!parambaqw.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Axka.jdField_a_of_type_JavaLangString)) {
            break label286;
          }
          if (axjt.b(parambaqw.jdField_a_of_type_JavaLangString, parambaqw.jdField_b_of_type_JavaLangString, false)) {}
          try
          {
            ndr.a(new File(axjt.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Axka.jdField_a_of_type_JavaLangString), axjt.jdField_a_of_type_JavaLangString);
            if (parambaqw.jdField_b_of_type_Boolean) {
              break label269;
            }
            parambaqw = (axjx)this.jdField_a_of_type_Axjt.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Axkb.a));
            if (parambaqw != null)
            {
              parambaqw = parambaqw.b.iterator();
              while (parambaqw.hasNext())
              {
                axkb localaxkb = (axkb)parambaqw.next();
                if (axjt.a(this.jdField_a_of_type_Axjt, localaxkb, this.jdField_a_of_type_Axka)) {
                  parambaqw.remove();
                }
              }
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              localIOException.printStackTrace();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: BusinessParam=null  kind=" + this.jdField_a_of_type_Axkb.a + " mItem.mName=" + this.jdField_a_of_type_Axka.jdField_a_of_type_JavaLangString);
      return;
      axjt.a(this.jdField_a_of_type_Axjt, this.jdField_a_of_type_Axkb, this.jdField_a_of_type_Axka);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: download information no match current=" + this.jdField_a_of_type_Axka.jdField_a_of_type_JavaLangString + " callback=" + parambaqw.jdField_a_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    parambaqv = (axka)parambaqv.a();
    if (parambaqv == null) {}
    label134:
    label187:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!parambaqv.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Axka.jdField_a_of_type_JavaLangString)) {
            break label187;
          }
          Object localObject = (axjx)this.jdField_a_of_type_Axjt.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Axkb.a));
          if (localObject == null) {
            break label134;
          }
          if (parambaqv.jdField_b_of_type_Boolean) {
            break;
          }
          parambaqv = ((axjx)localObject).b.iterator();
          while (parambaqv.hasNext())
          {
            localObject = (axkb)parambaqv.next();
            axjt.a(this.jdField_a_of_type_Axjt, (axkb)localObject, this.jdField_a_of_type_Axka, paramLong1, paramLong2);
          }
        }
        axjt.a(this.jdField_a_of_type_Axjt, this.jdField_a_of_type_Axkb, this.jdField_a_of_type_Axka, paramLong1, paramLong2);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: BusinessParam=null  kind=" + this.jdField_a_of_type_Axkb.a + " mItem.mName=" + this.jdField_a_of_type_Axka.jdField_a_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: download information no match current=" + this.jdField_a_of_type_Axka.jdField_a_of_type_JavaLangString + " callback=" + parambaqv.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axkc
 * JD-Core Version:    0.7.0.1
 */