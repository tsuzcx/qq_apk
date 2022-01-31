import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class axol
  implements baug
{
  axoj jdField_a_of_type_Axoj;
  axok jdField_a_of_type_Axok;
  
  axol(axoc paramaxoc, axok paramaxok, axoj paramaxoj)
  {
    this.jdField_a_of_type_Axok = paramaxok;
    this.jdField_a_of_type_Axoj = paramaxoj;
  }
  
  public void onResp(bavf parambavf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(parambavf.c), this.jdField_a_of_type_Axoj.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Axoj.c }));
    }
    parambavf = (axoj)parambavf.a.a();
    if (parambavf == null) {}
    label269:
    label286:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!parambavf.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Axoj.jdField_a_of_type_JavaLangString)) {
            break label286;
          }
          if (axoc.b(parambavf.jdField_a_of_type_JavaLangString, parambavf.jdField_b_of_type_JavaLangString, false)) {}
          try
          {
            ndr.a(new File(axoc.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Axoj.jdField_a_of_type_JavaLangString), axoc.jdField_a_of_type_JavaLangString);
            if (parambavf.jdField_b_of_type_Boolean) {
              break label269;
            }
            parambavf = (axog)this.jdField_a_of_type_Axoc.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Axok.a));
            if (parambavf != null)
            {
              parambavf = parambavf.b.iterator();
              while (parambavf.hasNext())
              {
                axok localaxok = (axok)parambavf.next();
                if (axoc.a(this.jdField_a_of_type_Axoc, localaxok, this.jdField_a_of_type_Axoj)) {
                  parambavf.remove();
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
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: BusinessParam=null  kind=" + this.jdField_a_of_type_Axok.a + " mItem.mName=" + this.jdField_a_of_type_Axoj.jdField_a_of_type_JavaLangString);
      return;
      axoc.a(this.jdField_a_of_type_Axoc, this.jdField_a_of_type_Axok, this.jdField_a_of_type_Axoj);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: download information no match current=" + this.jdField_a_of_type_Axoj.jdField_a_of_type_JavaLangString + " callback=" + parambavf.jdField_a_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    parambave = (axoj)parambave.a();
    if (parambave == null) {}
    label134:
    label187:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!parambave.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Axoj.jdField_a_of_type_JavaLangString)) {
            break label187;
          }
          Object localObject = (axog)this.jdField_a_of_type_Axoc.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Axok.a));
          if (localObject == null) {
            break label134;
          }
          if (parambave.jdField_b_of_type_Boolean) {
            break;
          }
          parambave = ((axog)localObject).b.iterator();
          while (parambave.hasNext())
          {
            localObject = (axok)parambave.next();
            axoc.a(this.jdField_a_of_type_Axoc, (axok)localObject, this.jdField_a_of_type_Axoj, paramLong1, paramLong2);
          }
        }
        axoc.a(this.jdField_a_of_type_Axoc, this.jdField_a_of_type_Axok, this.jdField_a_of_type_Axoj, paramLong1, paramLong2);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: BusinessParam=null  kind=" + this.jdField_a_of_type_Axok.a + " mItem.mName=" + this.jdField_a_of_type_Axoj.jdField_a_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: download information no match current=" + this.jdField_a_of_type_Axoj.jdField_a_of_type_JavaLangString + " callback=" + parambave.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axol
 * JD-Core Version:    0.7.0.1
 */