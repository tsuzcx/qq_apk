import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.wallpaper.VipWallpaperService;
import com.tencent.mobileqq.vas.wallpaper.WallpaperHelper;
import com.tencent.mobileqq.vas.wallpaper.WallpaperHelper.ConfigChangeListener.1;
import java.lang.ref.WeakReference;

public class biej
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private bieh jdField_a_of_type_Bieh;
  private final WeakReference<WallpaperHelper> jdField_a_of_type_JavaLangRefWeakReference;
  
  public biej(WallpaperHelper paramWallpaperHelper)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWallpaperHelper);
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramString = (WallpaperHelper)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString != null)
    {
      paramSharedPreferences = VipWallpaperService.a(paramSharedPreferences);
      if ((this.jdField_a_of_type_Bieh == null) || (!this.jdField_a_of_type_Bieh.equals(paramSharedPreferences)))
      {
        this.jdField_a_of_type_Bieh = paramSharedPreferences;
        ThreadManagerV2.getUIHandlerV2().post(new WallpaperHelper.ConfigChangeListener.1(this, paramString, paramSharedPreferences));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biej
 * JD-Core Version:    0.7.0.1
 */