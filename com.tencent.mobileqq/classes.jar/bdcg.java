import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class bdcg
{
  public int a;
  public boolean a;
  
  public static bdcg a(aqlg[] paramArrayOfaqlg)
  {
    bdcg localbdcg = new bdcg();
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i < paramArrayOfaqlg.length)
        {
          String str = paramArrayOfaqlg[i].a;
          try
          {
            localbdcg.jdField_a_of_type_Int = new JSONObject(str).optInt("ConfigEnableStudyMode");
            localbdcg.jdField_a_of_type_Boolean = true;
            bdch.c(a(localbdcg));
            QLog.i("StudyModeConfigProcessor", 1, "[study mode config], mGraySwitch:" + localbdcg.jdField_a_of_type_Int);
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
    return localbdcg;
  }
  
  public static boolean a(bdcg parambdcg)
  {
    return parambdcg.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcg
 * JD-Core Version:    0.7.0.1
 */