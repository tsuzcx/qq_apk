import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class azce
{
  public int a;
  public String a;
  public boolean a;
  public int b = 3;
  public int c = 1000;
  public int d = 3600;
  public int e = 1;
  public int f = 5;
  
  public azce()
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
  
  public static azce a()
  {
    azce localazce3 = new azce();
    str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.precover.name());
    localazce3.jdField_a_of_type_JavaLangString = str;
    localazce3.jdField_a_of_type_Boolean = true;
    azce localazce1 = localazce3;
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        localazce1 = localazce3;
        if (arrayOfString.length >= 6)
        {
          localazce3.jdField_a_of_type_Boolean = false;
          localazce3.jdField_a_of_type_Int = a(arrayOfString[0], 0);
          localazce3.b = a(arrayOfString[1], 3);
          localazce3.c = a(arrayOfString[2], 1000);
          localazce3.d = a(arrayOfString[3], 3600);
          localazce3.e = a(arrayOfString[4], 1);
          localazce3.f = a(arrayOfString[5], 5);
          if ((localazce3.jdField_a_of_type_Int != 0) && (localazce3.jdField_a_of_type_Int != 1) && (localazce3.jdField_a_of_type_Int != 2)) {
            localazce3.jdField_a_of_type_Int = 0;
          }
          localazce1 = localazce3;
          if (localazce3.e != 0)
          {
            localazce1 = localazce3;
            if (localazce3.e != 1)
            {
              localazce3.e = 1;
              localazce1 = localazce3;
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
        azce localazce2 = new azce();
        localazce2.jdField_a_of_type_JavaLangString = str;
        localazce2.jdField_a_of_type_Boolean = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverControl", 2, "PrecoverControl.create, control=" + localazce1);
    }
    return localazce1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("PrecoverControl:isUsingDefaultValue=").append(this.jdField_a_of_type_Boolean).append(", network=").append(this.jdField_a_of_type_Int).append(", itemRetry=").append(this.b).append(", totalRetry=").append(this.c).append(", lbsExpire=").append(this.d).append(", open=").append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azce
 * JD-Core Version:    0.7.0.1
 */