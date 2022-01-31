import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class avse
  implements aysc
{
  avsc jdField_a_of_type_Avsc;
  avsd jdField_a_of_type_Avsd;
  
  avse(avrv paramavrv, avsd paramavsd, avsc paramavsc)
  {
    this.jdField_a_of_type_Avsd = paramavsd;
    this.jdField_a_of_type_Avsc = paramavsc;
  }
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(paramaysz.c), this.jdField_a_of_type_Avsc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Avsc.c }));
    }
    paramaysz = (avsc)paramaysz.a.a();
    if (paramaysz == null) {}
    label269:
    label286:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramaysz.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Avsc.jdField_a_of_type_JavaLangString)) {
            break label286;
          }
          if (avrv.b(paramaysz.jdField_a_of_type_JavaLangString, paramaysz.jdField_b_of_type_JavaLangString, false)) {}
          try
          {
            nav.a(new File(avrv.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Avsc.jdField_a_of_type_JavaLangString), avrv.jdField_a_of_type_JavaLangString);
            if (paramaysz.jdField_b_of_type_Boolean) {
              break label269;
            }
            paramaysz = (avrz)this.jdField_a_of_type_Avrv.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Avsd.a));
            if (paramaysz != null)
            {
              paramaysz = paramaysz.b.iterator();
              while (paramaysz.hasNext())
              {
                avsd localavsd = (avsd)paramaysz.next();
                if (avrv.a(this.jdField_a_of_type_Avrv, localavsd, this.jdField_a_of_type_Avsc)) {
                  paramaysz.remove();
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
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: BusinessParam=null  kind=" + this.jdField_a_of_type_Avsd.a + " mItem.mName=" + this.jdField_a_of_type_Avsc.jdField_a_of_type_JavaLangString);
      return;
      avrv.a(this.jdField_a_of_type_Avrv, this.jdField_a_of_type_Avsd, this.jdField_a_of_type_Avsc);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: download information no match current=" + this.jdField_a_of_type_Avsc.jdField_a_of_type_JavaLangString + " callback=" + paramaysz.jdField_a_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    paramaysy = (avsc)paramaysy.a();
    if (paramaysy == null) {}
    label134:
    label187:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramaysy.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Avsc.jdField_a_of_type_JavaLangString)) {
            break label187;
          }
          Object localObject = (avrz)this.jdField_a_of_type_Avrv.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Avsd.a));
          if (localObject == null) {
            break label134;
          }
          if (paramaysy.jdField_b_of_type_Boolean) {
            break;
          }
          paramaysy = ((avrz)localObject).b.iterator();
          while (paramaysy.hasNext())
          {
            localObject = (avsd)paramaysy.next();
            avrv.a(this.jdField_a_of_type_Avrv, (avsd)localObject, this.jdField_a_of_type_Avsc, paramLong1, paramLong2);
          }
        }
        avrv.a(this.jdField_a_of_type_Avrv, this.jdField_a_of_type_Avsd, this.jdField_a_of_type_Avsc, paramLong1, paramLong2);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: BusinessParam=null  kind=" + this.jdField_a_of_type_Avsd.a + " mItem.mName=" + this.jdField_a_of_type_Avsc.jdField_a_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: download information no match current=" + this.jdField_a_of_type_Avsc.jdField_a_of_type_JavaLangString + " callback=" + paramaysy.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avse
 * JD-Core Version:    0.7.0.1
 */