import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class aurt
{
  public int a;
  public String a;
  public boolean a;
  public int b = 3;
  public int c = 1000;
  public int d = 3600;
  public int e = 1;
  public int f = 5;
  
  public aurt()
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
  
  public static aurt a()
  {
    aurt localaurt3 = new aurt();
    str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.precover.name());
    localaurt3.jdField_a_of_type_JavaLangString = str;
    localaurt3.jdField_a_of_type_Boolean = true;
    aurt localaurt1 = localaurt3;
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        localaurt1 = localaurt3;
        if (arrayOfString.length >= 6)
        {
          localaurt3.jdField_a_of_type_Boolean = false;
          localaurt3.jdField_a_of_type_Int = a(arrayOfString[0], 0);
          localaurt3.b = a(arrayOfString[1], 3);
          localaurt3.c = a(arrayOfString[2], 1000);
          localaurt3.d = a(arrayOfString[3], 3600);
          localaurt3.e = a(arrayOfString[4], 1);
          localaurt3.f = a(arrayOfString[5], 5);
          if ((localaurt3.jdField_a_of_type_Int != 0) && (localaurt3.jdField_a_of_type_Int != 1) && (localaurt3.jdField_a_of_type_Int != 2)) {
            localaurt3.jdField_a_of_type_Int = 0;
          }
          localaurt1 = localaurt3;
          if (localaurt3.e != 0)
          {
            localaurt1 = localaurt3;
            if (localaurt3.e != 1)
            {
              localaurt3.e = 1;
              localaurt1 = localaurt3;
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
        aurt localaurt2 = new aurt();
        localaurt2.jdField_a_of_type_JavaLangString = str;
        localaurt2.jdField_a_of_type_Boolean = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverControl", 2, "PrecoverControl.create, control=" + localaurt1);
    }
    return localaurt1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("PrecoverControl:isUsingDefaultValue=").append(this.jdField_a_of_type_Boolean).append(", network=").append(this.jdField_a_of_type_Int).append(", itemRetry=").append(this.b).append(", totalRetry=").append(this.c).append(", lbsExpire=").append(this.d).append(", open=").append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aurt
 * JD-Core Version:    0.7.0.1
 */