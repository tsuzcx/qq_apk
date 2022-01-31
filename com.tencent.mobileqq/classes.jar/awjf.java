import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class awjf
{
  public int a;
  public String a;
  public boolean a;
  public int b = 3;
  public int c = 1000;
  public int d = 3600;
  public int e = 1;
  public int f = 5;
  
  public awjf()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  private static int a(String paramString, int paramInt)
  {
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0) {
        return paramInt;
      }
    }
    catch (Throwable paramString)
    {
      return paramInt;
    }
    return i;
  }
  
  public static awjf a()
  {
    awjf localawjf3 = new awjf();
    str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.precover.name());
    localawjf3.jdField_a_of_type_JavaLangString = str;
    localawjf3.jdField_a_of_type_Boolean = true;
    awjf localawjf1 = localawjf3;
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        localawjf1 = localawjf3;
        if (arrayOfString.length >= 6)
        {
          localawjf3.jdField_a_of_type_Boolean = false;
          localawjf3.jdField_a_of_type_Int = a(arrayOfString[0], 0);
          localawjf3.b = a(arrayOfString[1], 3);
          localawjf3.c = a(arrayOfString[2], 1000);
          localawjf3.d = a(arrayOfString[3], 3600);
          localawjf3.e = a(arrayOfString[4], 1);
          localawjf3.f = a(arrayOfString[5], 5);
          if ((localawjf3.jdField_a_of_type_Int != 0) && (localawjf3.jdField_a_of_type_Int != 1) && (localawjf3.jdField_a_of_type_Int != 2)) {
            localawjf3.jdField_a_of_type_Int = 0;
          }
          localawjf1 = localawjf3;
          if (localawjf3.e != 0)
          {
            localawjf1 = localawjf3;
            if (localawjf3.e != 1)
            {
              localawjf3.e = 1;
              localawjf1 = localawjf3;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("PrecoverControl", 1, "create Exception:" + localException.toString());
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        awjf localawjf2 = new awjf();
        localawjf2.jdField_a_of_type_JavaLangString = str;
        localawjf2.jdField_a_of_type_Boolean = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverControl", 2, "PrecoverControl.create, control=" + localawjf1);
    }
    return localawjf1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("PrecoverControl:isUsingDefaultValue=").append(this.jdField_a_of_type_Boolean).append(", network=").append(this.jdField_a_of_type_Int).append(", itemRetry=").append(this.b).append(", totalRetry=").append(this.c).append(", lbsExpire=").append(this.d).append(", open=").append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjf
 * JD-Core Version:    0.7.0.1
 */