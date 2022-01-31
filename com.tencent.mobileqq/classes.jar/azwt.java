import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class azwt
{
  public int a;
  public boolean a;
  
  public static azwt a(aogf[] paramArrayOfaogf)
  {
    azwt localazwt = new azwt();
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i < paramArrayOfaogf.length)
        {
          String str = paramArrayOfaogf[i].a;
          try
          {
            localazwt.jdField_a_of_type_Int = new JSONObject(str).optInt("ConfigEnableStudyMode");
            localazwt.jdField_a_of_type_Boolean = true;
            azwu.c(a(localazwt));
            QLog.i("StudyModeConfigProcessor", 1, "[study mode config], mGraySwitch:" + localazwt.jdField_a_of_type_Int);
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
    return localazwt;
  }
  
  public static boolean a(azwt paramazwt)
  {
    return paramazwt.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwt
 * JD-Core Version:    0.7.0.1
 */