import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class bani
{
  public static int a()
  {
    int j = 2;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4);
    long l = localSharedPreferences.getLong("key_open_camera_time", 0L);
    int i = j;
    if (l != 0L)
    {
      i = j;
      if (System.currentTimeMillis() - l < 300000L) {
        i = localSharedPreferences.getInt("camera", 2);
      }
    }
    return i;
  }
  
  public static void a()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    localEditor.putLong("key_open_camera_time", System.currentTimeMillis());
    localEditor.apply();
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    localEditor.putInt("camera", paramInt);
    localEditor.putLong("key_open_camera_time", System.currentTimeMillis());
    localEditor.apply();
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).contains("camera");
  }
  
  public static int b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bani
 * JD-Core Version:    0.7.0.1
 */