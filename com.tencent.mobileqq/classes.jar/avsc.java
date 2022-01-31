import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class avsc
  implements aysa
{
  avsa jdField_a_of_type_Avsa;
  avsb jdField_a_of_type_Avsb;
  
  avsc(avrt paramavrt, avsb paramavsb, avsa paramavsa)
  {
    this.jdField_a_of_type_Avsb = paramavsb;
    this.jdField_a_of_type_Avsa = paramavsa;
  }
  
  public void onResp(aysx paramaysx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(paramaysx.c), this.jdField_a_of_type_Avsa.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Avsa.c }));
    }
    paramaysx = (avsa)paramaysx.a.a();
    if (paramaysx == null) {}
    label269:
    label286:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramaysx.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Avsa.jdField_a_of_type_JavaLangString)) {
            break label286;
          }
          if (avrt.b(paramaysx.jdField_a_of_type_JavaLangString, paramaysx.jdField_b_of_type_JavaLangString, false)) {}
          try
          {
            nay.a(new File(avrt.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Avsa.jdField_a_of_type_JavaLangString), avrt.jdField_a_of_type_JavaLangString);
            if (paramaysx.jdField_b_of_type_Boolean) {
              break label269;
            }
            paramaysx = (avrx)this.jdField_a_of_type_Avrt.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Avsb.a));
            if (paramaysx != null)
            {
              paramaysx = paramaysx.b.iterator();
              while (paramaysx.hasNext())
              {
                avsb localavsb = (avsb)paramaysx.next();
                if (avrt.a(this.jdField_a_of_type_Avrt, localavsb, this.jdField_a_of_type_Avsa)) {
                  paramaysx.remove();
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
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: BusinessParam=null  kind=" + this.jdField_a_of_type_Avsb.a + " mItem.mName=" + this.jdField_a_of_type_Avsa.jdField_a_of_type_JavaLangString);
      return;
      avrt.a(this.jdField_a_of_type_Avrt, this.jdField_a_of_type_Avsb, this.jdField_a_of_type_Avsa);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: download information no match current=" + this.jdField_a_of_type_Avsa.jdField_a_of_type_JavaLangString + " callback=" + paramaysx.jdField_a_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    paramaysw = (avsa)paramaysw.a();
    if (paramaysw == null) {}
    label134:
    label187:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramaysw.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Avsa.jdField_a_of_type_JavaLangString)) {
            break label187;
          }
          Object localObject = (avrx)this.jdField_a_of_type_Avrt.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Avsb.a));
          if (localObject == null) {
            break label134;
          }
          if (paramaysw.jdField_b_of_type_Boolean) {
            break;
          }
          paramaysw = ((avrx)localObject).b.iterator();
          while (paramaysw.hasNext())
          {
            localObject = (avsb)paramaysw.next();
            avrt.a(this.jdField_a_of_type_Avrt, (avsb)localObject, this.jdField_a_of_type_Avsa, paramLong1, paramLong2);
          }
        }
        avrt.a(this.jdField_a_of_type_Avrt, this.jdField_a_of_type_Avsb, this.jdField_a_of_type_Avsa, paramLong1, paramLong2);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: BusinessParam=null  kind=" + this.jdField_a_of_type_Avsb.a + " mItem.mName=" + this.jdField_a_of_type_Avsa.jdField_a_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: download information no match current=" + this.jdField_a_of_type_Avsa.jdField_a_of_type_JavaLangString + " callback=" + paramaysw.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avsc
 * JD-Core Version:    0.7.0.1
 */