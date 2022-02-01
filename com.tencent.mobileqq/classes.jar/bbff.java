import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class bbff
  implements beuq
{
  bbfd jdField_a_of_type_Bbfd;
  bbfe jdField_a_of_type_Bbfe;
  
  bbff(bbew parambbew, bbfe parambbfe, bbfd parambbfd)
  {
    this.jdField_a_of_type_Bbfe = parambbfe;
    this.jdField_a_of_type_Bbfd = parambbfd;
  }
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(parambevm.c), this.jdField_a_of_type_Bbfd.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bbfd.c }));
    }
    parambevm = (bbfd)parambevm.a.a();
    if (parambevm == null) {}
    label269:
    label286:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!parambevm.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Bbfd.jdField_a_of_type_JavaLangString)) {
            break label286;
          }
          if (bbew.b(parambevm.jdField_a_of_type_JavaLangString, parambevm.jdField_b_of_type_JavaLangString, false)) {}
          try
          {
            nof.a(new File(bbew.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Bbfd.jdField_a_of_type_JavaLangString), bbew.jdField_a_of_type_JavaLangString);
            if (parambevm.jdField_b_of_type_Boolean) {
              break label269;
            }
            parambevm = (bbfa)this.jdField_a_of_type_Bbew.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Bbfe.a));
            if (parambevm != null)
            {
              parambevm = parambevm.b.iterator();
              while (parambevm.hasNext())
              {
                bbfe localbbfe = (bbfe)parambevm.next();
                if (bbew.a(this.jdField_a_of_type_Bbew, localbbfe, this.jdField_a_of_type_Bbfd)) {
                  parambevm.remove();
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
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: BusinessParam=null  kind=" + this.jdField_a_of_type_Bbfe.a + " mItem.mName=" + this.jdField_a_of_type_Bbfd.jdField_a_of_type_JavaLangString);
      return;
      bbew.a(this.jdField_a_of_type_Bbew, this.jdField_a_of_type_Bbfe, this.jdField_a_of_type_Bbfd);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: download information no match current=" + this.jdField_a_of_type_Bbfd.jdField_a_of_type_JavaLangString + " callback=" + parambevm.jdField_a_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    parambevl = (bbfd)parambevl.a();
    if (parambevl == null) {}
    label134:
    label187:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!parambevl.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Bbfd.jdField_a_of_type_JavaLangString)) {
            break label187;
          }
          Object localObject = (bbfa)this.jdField_a_of_type_Bbew.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Bbfe.a));
          if (localObject == null) {
            break label134;
          }
          if (parambevl.jdField_b_of_type_Boolean) {
            break;
          }
          parambevl = ((bbfa)localObject).b.iterator();
          while (parambevl.hasNext())
          {
            localObject = (bbfe)parambevl.next();
            bbew.a(this.jdField_a_of_type_Bbew, (bbfe)localObject, this.jdField_a_of_type_Bbfd, paramLong1, paramLong2);
          }
        }
        bbew.a(this.jdField_a_of_type_Bbew, this.jdField_a_of_type_Bbfe, this.jdField_a_of_type_Bbfd, paramLong1, paramLong2);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: BusinessParam=null  kind=" + this.jdField_a_of_type_Bbfe.a + " mItem.mName=" + this.jdField_a_of_type_Bbfd.jdField_a_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: download information no match current=" + this.jdField_a_of_type_Bbfd.jdField_a_of_type_JavaLangString + " callback=" + parambevl.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbff
 * JD-Core Version:    0.7.0.1
 */