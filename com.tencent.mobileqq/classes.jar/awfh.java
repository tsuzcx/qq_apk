import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class awfh
{
  public static awfj a(String paramString)
  {
    awfj localawfj = new awfj();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_status_sp", 4);
    localawfj.a = localSharedPreferences.getInt(paramString + "_version_k", 0);
    localawfj.b = localSharedPreferences.getInt(paramString + "_status_k", -1);
    localawfj.c = localSharedPreferences.getInt(paramString + "_last_error_k", -1);
    return localawfj;
  }
  
  public static boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_status_sp", 4).edit();
    localEditor.putInt(paramString + "_version_k", paramInt1);
    localEditor.putInt(paramString + "_status_k", paramInt2);
    localEditor.putInt(paramString + "_last_error_k", paramInt3);
    return localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awfh
 * JD-Core Version:    0.7.0.1
 */