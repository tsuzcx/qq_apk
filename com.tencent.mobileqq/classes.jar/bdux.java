import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class bdux
{
  public int a;
  public boolean a;
  
  public static bdux a(araj[] paramArrayOfaraj)
  {
    bdux localbdux = new bdux();
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i < paramArrayOfaraj.length)
        {
          String str = paramArrayOfaraj[i].a;
          try
          {
            localbdux.jdField_a_of_type_Int = new JSONObject(str).optInt("ConfigEnableStudyMode");
            localbdux.jdField_a_of_type_Boolean = true;
            bduy.c(a(localbdux));
            QLog.i("StudyModeConfigProcessor", 1, "[study mode config], mGraySwitch:" + localbdux.jdField_a_of_type_Int);
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              QLog.e("StudyModeConfigProcessor", 1, localThrowable, new Object[0]);
            }
          }
        }
      }
    }
    return localbdux;
  }
  
  public static boolean a(bdux parambdux)
  {
    return parambdux.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdux
 * JD-Core Version:    0.7.0.1
 */