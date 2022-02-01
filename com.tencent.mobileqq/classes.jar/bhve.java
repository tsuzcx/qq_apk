import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.wallpaper.VipWallpaperService;
import com.tencent.mobileqq.vas.wallpaper.WallpaperHelper;
import com.tencent.mobileqq.vas.wallpaper.WallpaperHelper.ConfigChangeListener.1;
import java.lang.ref.WeakReference;

public class bhve
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private bhvc jdField_a_of_type_Bhvc;
  private final WeakReference<WallpaperHelper> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bhve(WallpaperHelper paramWallpaperHelper)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWallpaperHelper);
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramString = (WallpaperHelper)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString != null)
    {
      paramSharedPreferences = VipWallpaperService.a(paramSharedPreferences);
      if ((this.jdField_a_of_type_Bhvc == null) || (!this.jdField_a_of_type_Bhvc.equals(paramSharedPreferences)))
      {
        this.jdField_a_of_type_Bhvc = paramSharedPreferences;
        ThreadManagerV2.getUIHandlerV2().post(new WallpaperHelper.ConfigChangeListener.1(this, paramString, paramSharedPreferences));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhve
 * JD-Core Version:    0.7.0.1
 */