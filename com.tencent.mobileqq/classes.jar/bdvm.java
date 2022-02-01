import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class bdvm
{
  public int a;
  public boolean a;
  
  public static bdvm a(aqxa[] paramArrayOfaqxa)
  {
    bdvm localbdvm = new bdvm();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i < paramArrayOfaqxa.length)
        {
          String str = paramArrayOfaqxa[i].a;
          try
          {
            localbdvm.jdField_a_of_type_Int = new JSONObject(str).optInt("ConfigEnableStudyMode");
            localbdvm.jdField_a_of_type_Boolean = true;
            bdvn.c(a(localbdvm));
            QLog.i("StudyModeConfigProcessor", 1, "[study mode config], mGraySwitch:" + localbdvm.jdField_a_of_type_Int);
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
    return localbdvm;
  }
  
  public static boolean a(bdvm parambdvm)
  {
    return parambdvm.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvm
 * JD-Core Version:    0.7.0.1
 */