import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class aust
  implements axrt
{
  ausr jdField_a_of_type_Ausr;
  auss jdField_a_of_type_Auss;
  
  aust(ausk paramausk, auss paramauss, ausr paramausr)
  {
    this.jdField_a_of_type_Auss = paramauss;
    this.jdField_a_of_type_Ausr = paramausr;
  }
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(paramaxsq.c), this.jdField_a_of_type_Ausr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ausr.c }));
    }
    paramaxsq = (ausr)paramaxsq.a.a();
    if (paramaxsq == null) {}
    label269:
    label286:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramaxsq.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Ausr.jdField_a_of_type_JavaLangString)) {
            break label286;
          }
          if (ausk.b(paramaxsq.jdField_a_of_type_JavaLangString, paramaxsq.jdField_b_of_type_JavaLangString, false)) {}
          try
          {
            mpx.a(new File(ausk.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Ausr.jdField_a_of_type_JavaLangString), ausk.jdField_a_of_type_JavaLangString);
            if (paramaxsq.jdField_b_of_type_Boolean) {
              break label269;
            }
            paramaxsq = (auso)this.jdField_a_of_type_Ausk.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Auss.a));
            if (paramaxsq != null)
            {
              paramaxsq = paramaxsq.b.iterator();
              while (paramaxsq.hasNext())
              {
                auss localauss = (auss)paramaxsq.next();
                if (ausk.a(this.jdField_a_of_type_Ausk, localauss, this.jdField_a_of_type_Ausr)) {
                  paramaxsq.remove();
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
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: BusinessParam=null  kind=" + this.jdField_a_of_type_Auss.a + " mItem.mName=" + this.jdField_a_of_type_Ausr.jdField_a_of_type_JavaLangString);
      return;
      ausk.a(this.jdField_a_of_type_Ausk, this.jdField_a_of_type_Auss, this.jdField_a_of_type_Ausr);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: download information no match current=" + this.jdField_a_of_type_Ausr.jdField_a_of_type_JavaLangString + " callback=" + paramaxsq.jdField_a_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    paramaxsp = (ausr)paramaxsp.a();
    if (paramaxsp == null) {}
    label134:
    label187:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramaxsp.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_Ausr.jdField_a_of_type_JavaLangString)) {
            break label187;
          }
          Object localObject = (auso)this.jdField_a_of_type_Ausk.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Auss.a));
          if (localObject == null) {
            break label134;
          }
          if (paramaxsp.jdField_b_of_type_Boolean) {
            break;
          }
          paramaxsp = ((auso)localObject).b.iterator();
          while (paramaxsp.hasNext())
          {
            localObject = (auss)paramaxsp.next();
            ausk.a(this.jdField_a_of_type_Ausk, (auss)localObject, this.jdField_a_of_type_Ausr, paramLong1, paramLong2);
          }
        }
        ausk.a(this.jdField_a_of_type_Ausk, this.jdField_a_of_type_Auss, this.jdField_a_of_type_Ausr, paramLong1, paramLong2);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: BusinessParam=null  kind=" + this.jdField_a_of_type_Auss.a + " mItem.mName=" + this.jdField_a_of_type_Ausr.jdField_a_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: download information no match current=" + this.jdField_a_of_type_Ausr.jdField_a_of_type_JavaLangString + " callback=" + paramaxsp.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aust
 * JD-Core Version:    0.7.0.1
 */