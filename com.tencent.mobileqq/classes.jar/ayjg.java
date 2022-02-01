import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class ayjg
{
  public int a;
  public String a;
  public boolean a;
  public int b = 3;
  public int c = 1000;
  public int d = 3600;
  public int e = 1;
  public int f = 5;
  
  public ayjg()
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
  
  public static ayjg a()
  {
    ayjg localayjg3 = new ayjg();
    str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.precover.name());
    localayjg3.jdField_a_of_type_JavaLangString = str;
    localayjg3.jdField_a_of_type_Boolean = true;
    ayjg localayjg1 = localayjg3;
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        localayjg1 = localayjg3;
        if (arrayOfString.length >= 6)
        {
          localayjg3.jdField_a_of_type_Boolean = false;
          localayjg3.jdField_a_of_type_Int = a(arrayOfString[0], 0);
          localayjg3.b = a(arrayOfString[1], 3);
          localayjg3.c = a(arrayOfString[2], 1000);
          localayjg3.d = a(arrayOfString[3], 3600);
          localayjg3.e = a(arrayOfString[4], 1);
          localayjg3.f = a(arrayOfString[5], 5);
          if ((localayjg3.jdField_a_of_type_Int != 0) && (localayjg3.jdField_a_of_type_Int != 1) && (localayjg3.jdField_a_of_type_Int != 2)) {
            localayjg3.jdField_a_of_type_Int = 0;
          }
          localayjg1 = localayjg3;
          if (localayjg3.e != 0)
          {
            localayjg1 = localayjg3;
            if (localayjg3.e != 1)
            {
              localayjg3.e = 1;
              localayjg1 = localayjg3;
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
        ayjg localayjg2 = new ayjg();
        localayjg2.jdField_a_of_type_JavaLangString = str;
        localayjg2.jdField_a_of_type_Boolean = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverControl", 2, "PrecoverControl.create, control=" + localayjg1);
    }
    return localayjg1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("PrecoverControl:isUsingDefaultValue=").append(this.jdField_a_of_type_Boolean).append(", network=").append(this.jdField_a_of_type_Int).append(", itemRetry=").append(this.b).append(", totalRetry=").append(this.c).append(", lbsExpire=").append(this.d).append(", open=").append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjg
 * JD-Core Version:    0.7.0.1
 */