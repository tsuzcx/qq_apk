import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class bcyh
{
  public static int a;
  public static boolean a;
  public static boolean b = true;
  
  static
  {
    jdField_a_of_type_Int = 18;
  }
  
  public static void a()
  {
    Object localObject;
    if (!jdField_a_of_type_Boolean)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.ShortVideoPlayInAIO.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideo.ShortVideoPlayConfig", 2, "initConfig(), videoPlayConfig=" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 2))
        {
          if (!TextUtils.isEmpty(localObject[0])) {
            b = localObject[0].equals("1");
          }
          if (TextUtils.isEmpty(localObject[1])) {}
        }
      }
    }
    try
    {
      jdField_a_of_type_Int = Integer.parseInt(localObject[1]);
      jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideo.ShortVideoPlayConfig", 2, "initVideoPlayConfig(), sReadFromDPC=" + jdField_a_of_type_Boolean + ", sAutoPlayInAIO:" + b + ", sRequestedFPS:" + jdField_a_of_type_Int);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        jdField_a_of_type_Int = 18;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyh
 * JD-Core Version:    0.7.0.1
 */