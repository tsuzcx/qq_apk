import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class babc
{
  public int a;
  public boolean a;
  
  public static babc a(aoko[] paramArrayOfaoko)
  {
    babc localbabc = new babc();
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i < paramArrayOfaoko.length)
        {
          String str = paramArrayOfaoko[i].a;
          try
          {
            localbabc.jdField_a_of_type_Int = new JSONObject(str).optInt("ConfigEnableStudyMode");
            localbabc.jdField_a_of_type_Boolean = true;
            babd.c(a(localbabc));
            QLog.i("StudyModeConfigProcessor", 1, "[study mode config], mGraySwitch:" + localbabc.jdField_a_of_type_Int);
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
    return localbabc;
  }
  
  public static boolean a(babc parambabc)
  {
    return parambabc.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babc
 * JD-Core Version:    0.7.0.1
 */