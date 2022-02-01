import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class bcon
{
  public int a;
  public boolean a;
  
  public static bcon a(aptx[] paramArrayOfaptx)
  {
    bcon localbcon = new bcon();
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i < paramArrayOfaptx.length)
        {
          String str = paramArrayOfaptx[i].a;
          try
          {
            localbcon.jdField_a_of_type_Int = new JSONObject(str).optInt("ConfigEnableStudyMode");
            localbcon.jdField_a_of_type_Boolean = true;
            bcoo.c(a(localbcon));
            QLog.i("StudyModeConfigProcessor", 1, "[study mode config], mGraySwitch:" + localbcon.jdField_a_of_type_Int);
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
    return localbcon;
  }
  
  public static boolean a(bcon parambcon)
  {
    return parambcon.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcon
 * JD-Core Version:    0.7.0.1
 */