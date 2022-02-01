import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class azob
{
  public int a;
  public String a;
  public boolean a;
  public int b = 3;
  public int c = 1000;
  public int d = 3600;
  public int e = 1;
  public int f = 5;
  
  public azob()
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
  
  public static azob a()
  {
    azob localazob3 = new azob();
    str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.precover.name());
    localazob3.jdField_a_of_type_JavaLangString = str;
    localazob3.jdField_a_of_type_Boolean = true;
    azob localazob1 = localazob3;
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        localazob1 = localazob3;
        if (arrayOfString.length >= 6)
        {
          localazob3.jdField_a_of_type_Boolean = false;
          localazob3.jdField_a_of_type_Int = a(arrayOfString[0], 0);
          localazob3.b = a(arrayOfString[1], 3);
          localazob3.c = a(arrayOfString[2], 1000);
          localazob3.d = a(arrayOfString[3], 3600);
          localazob3.e = a(arrayOfString[4], 1);
          localazob3.f = a(arrayOfString[5], 5);
          if ((localazob3.jdField_a_of_type_Int != 0) && (localazob3.jdField_a_of_type_Int != 1) && (localazob3.jdField_a_of_type_Int != 2)) {
            localazob3.jdField_a_of_type_Int = 0;
          }
          localazob1 = localazob3;
          if (localazob3.e != 0)
          {
            localazob1 = localazob3;
            if (localazob3.e != 1)
            {
              localazob3.e = 1;
              localazob1 = localazob3;
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
        azob localazob2 = new azob();
        localazob2.jdField_a_of_type_JavaLangString = str;
        localazob2.jdField_a_of_type_Boolean = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverControl", 2, "PrecoverControl.create, control=" + localazob1);
    }
    return localazob1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("PrecoverControl:isUsingDefaultValue=").append(this.jdField_a_of_type_Boolean).append(", network=").append(this.jdField_a_of_type_Int).append(", itemRetry=").append(this.b).append(", totalRetry=").append(this.c).append(", lbsExpire=").append(this.d).append(", open=").append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azob
 * JD-Core Version:    0.7.0.1
 */