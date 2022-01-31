import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class ayxc
{
  public static int a = -1;
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_EXIF_Info_Switch", 4).edit();
    localEditor.putInt("SP_KEY_EXIF_Info_Switch_VALUE", paramInt);
    localEditor.commit();
    a = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("PicUploadExifInfoSwitch", 2, "setSwitch:" + paramInt);
    }
  }
  
  public static boolean a()
  {
    if (aqwf.a().g()) {}
    do
    {
      return true;
      if (a < 0) {
        a = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_EXIF_Info_Switch", 4).getInt("SP_KEY_EXIF_Info_Switch_VALUE", 0);
      }
    } while (a == 1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxc
 * JD-Core Version:    0.7.0.1
 */