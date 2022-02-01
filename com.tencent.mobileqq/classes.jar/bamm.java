import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class bamm
  implements bdvw
{
  bamk jdField_a_of_type_Bamk;
  baml jdField_a_of_type_Baml;
  
  bamm(bamd parambamd, baml parambaml, bamk parambamk)
  {
    this.jdField_a_of_type_Baml = parambaml;
    this.jdField_a_of_type_Bamk = parambamk;
  }
  
  public void onResp(bdwt parambdwt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(parambdwt.c), this.jdField_a_of_type_Bamk.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bamk.c }));
    }
    parambdwt = (bamk)parambdwt.a.a();
    if (parambdwt == null) {}
    label269:
    label286:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!parambdwt.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Bamk.jdField_a_of_type_JavaLangString)) {
            break label286;
          }
          if (bamd.b(parambdwt.jdField_a_of_type_JavaLangString, parambdwt.jdField_b_of_type_JavaLangString, false)) {}
          try
          {
            nmk.a(new File(bamd.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Bamk.jdField_a_of_type_JavaLangString), bamd.jdField_a_of_type_JavaLangString);
            if (parambdwt.jdField_b_of_type_Boolean) {
              break label269;
            }
            parambdwt = (bamh)this.jdField_a_of_type_Bamd.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Baml.a));
            if (parambdwt != null)
            {
              parambdwt = parambdwt.b.iterator();
              while (parambdwt.hasNext())
              {
                baml localbaml = (baml)parambdwt.next();
                if (bamd.a(this.jdField_a_of_type_Bamd, localbaml, this.jdField_a_of_type_Bamk)) {
                  parambdwt.remove();
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
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: BusinessParam=null  kind=" + this.jdField_a_of_type_Baml.a + " mItem.mName=" + this.jdField_a_of_type_Bamk.jdField_a_of_type_JavaLangString);
      return;
      bamd.a(this.jdField_a_of_type_Bamd, this.jdField_a_of_type_Baml, this.jdField_a_of_type_Bamk);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: download information no match current=" + this.jdField_a_of_type_Bamk.jdField_a_of_type_JavaLangString + " callback=" + parambdwt.jdField_a_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    parambdws = (bamk)parambdws.a();
    if (parambdws == null) {}
    label134:
    label187:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!parambdws.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Bamk.jdField_a_of_type_JavaLangString)) {
            break label187;
          }
          Object localObject = (bamh)this.jdField_a_of_type_Bamd.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Baml.a));
          if (localObject == null) {
            break label134;
          }
          if (parambdws.jdField_b_of_type_Boolean) {
            break;
          }
          parambdws = ((bamh)localObject).b.iterator();
          while (parambdws.hasNext())
          {
            localObject = (baml)parambdws.next();
            bamd.a(this.jdField_a_of_type_Bamd, (baml)localObject, this.jdField_a_of_type_Bamk, paramLong1, paramLong2);
          }
        }
        bamd.a(this.jdField_a_of_type_Bamd, this.jdField_a_of_type_Baml, this.jdField_a_of_type_Bamk, paramLong1, paramLong2);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: BusinessParam=null  kind=" + this.jdField_a_of_type_Baml.a + " mItem.mName=" + this.jdField_a_of_type_Bamk.jdField_a_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: download information no match current=" + this.jdField_a_of_type_Bamk.jdField_a_of_type_JavaLangString + " callback=" + parambdws.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamm
 * JD-Core Version:    0.7.0.1
 */