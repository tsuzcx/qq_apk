import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class aurr
{
  public int a;
  public String a;
  public boolean a;
  public int b = 3;
  public int c = 1000;
  public int d = 3600;
  public int e = 1;
  public int f = 5;
  
  public aurr()
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
  
  public static aurr a()
  {
    aurr localaurr3 = new aurr();
    str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.precover.name());
    localaurr3.jdField_a_of_type_JavaLangString = str;
    localaurr3.jdField_a_of_type_Boolean = true;
    aurr localaurr1 = localaurr3;
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        localaurr1 = localaurr3;
        if (arrayOfString.length >= 6)
        {
          localaurr3.jdField_a_of_type_Boolean = false;
          localaurr3.jdField_a_of_type_Int = a(arrayOfString[0], 0);
          localaurr3.b = a(arrayOfString[1], 3);
          localaurr3.c = a(arrayOfString[2], 1000);
          localaurr3.d = a(arrayOfString[3], 3600);
          localaurr3.e = a(arrayOfString[4], 1);
          localaurr3.f = a(arrayOfString[5], 5);
          if ((localaurr3.jdField_a_of_type_Int != 0) && (localaurr3.jdField_a_of_type_Int != 1) && (localaurr3.jdField_a_of_type_Int != 2)) {
            localaurr3.jdField_a_of_type_Int = 0;
          }
          localaurr1 = localaurr3;
          if (localaurr3.e != 0)
          {
            localaurr1 = localaurr3;
            if (localaurr3.e != 1)
            {
              localaurr3.e = 1;
              localaurr1 = localaurr3;
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
        aurr localaurr2 = new aurr();
        localaurr2.jdField_a_of_type_JavaLangString = str;
        localaurr2.jdField_a_of_type_Boolean = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverControl", 2, "PrecoverControl.create, control=" + localaurr1);
    }
    return localaurr1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("PrecoverControl:isUsingDefaultValue=").append(this.jdField_a_of_type_Boolean).append(", network=").append(this.jdField_a_of_type_Int).append(", itemRetry=").append(this.b).append(", totalRetry=").append(this.c).append(", lbsExpire=").append(this.d).append(", open=").append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aurr
 * JD-Core Version:    0.7.0.1
 */