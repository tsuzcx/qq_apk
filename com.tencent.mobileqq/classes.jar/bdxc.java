import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.mobileqq.vas.wallpaper.VipWallpaperService;
import com.tencent.mobileqq.vas.wallpaper.WallpaperHelper;
import java.lang.ref.WeakReference;

public class bdxc
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private final WeakReference<WallpaperHelper> a;
  
  public bdxc(WallpaperHelper paramWallpaperHelper)
  {
    this.a = new WeakReference(paramWallpaperHelper);
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramString = (WallpaperHelper)this.a.get();
    if (paramString != null) {
      WallpaperHelper.a(paramString, VipWallpaperService.a(paramSharedPreferences), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxc
 * JD-Core Version:    0.7.0.1
 */