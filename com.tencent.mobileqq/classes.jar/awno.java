import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class awno
{
  public int a;
  public String a;
  public boolean a;
  public int b = 3;
  public int c = 1000;
  public int d = 3600;
  public int e = 1;
  public int f = 5;
  
  public awno()
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
  
  public static awno a()
  {
    awno localawno3 = new awno();
    str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.precover.name());
    localawno3.jdField_a_of_type_JavaLangString = str;
    localawno3.jdField_a_of_type_Boolean = true;
    awno localawno1 = localawno3;
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        localawno1 = localawno3;
        if (arrayOfString.length >= 6)
        {
          localawno3.jdField_a_of_type_Boolean = false;
          localawno3.jdField_a_of_type_Int = a(arrayOfString[0], 0);
          localawno3.b = a(arrayOfString[1], 3);
          localawno3.c = a(arrayOfString[2], 1000);
          localawno3.d = a(arrayOfString[3], 3600);
          localawno3.e = a(arrayOfString[4], 1);
          localawno3.f = a(arrayOfString[5], 5);
          if ((localawno3.jdField_a_of_type_Int != 0) && (localawno3.jdField_a_of_type_Int != 1) && (localawno3.jdField_a_of_type_Int != 2)) {
            localawno3.jdField_a_of_type_Int = 0;
          }
          localawno1 = localawno3;
          if (localawno3.e != 0)
          {
            localawno1 = localawno3;
            if (localawno3.e != 1)
            {
              localawno3.e = 1;
              localawno1 = localawno3;
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
        awno localawno2 = new awno();
        localawno2.jdField_a_of_type_JavaLangString = str;
        localawno2.jdField_a_of_type_Boolean = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverControl", 2, "PrecoverControl.create, control=" + localawno1);
    }
    return localawno1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("PrecoverControl:isUsingDefaultValue=").append(this.jdField_a_of_type_Boolean).append(", network=").append(this.jdField_a_of_type_Int).append(", itemRetry=").append(this.b).append(", totalRetry=").append(this.c).append(", lbsExpire=").append(this.d).append(", open=").append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awno
 * JD-Core Version:    0.7.0.1
 */