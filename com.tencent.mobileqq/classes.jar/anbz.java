import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class anbz
  extends ampb<anby>
{
  public static anby a()
  {
    return (anby)ampm.a().a(483);
  }
  
  public int a()
  {
    return 483;
  }
  
  @NonNull
  public anby a(int paramInt)
  {
    return new anby();
  }
  
  @Nullable
  public anby a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return anby.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<anby> a()
  {
    return anby.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(anby paramanby)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("key_tencent_doc_history_tab_tips_count", 0).apply();
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anbz
 * JD-Core Version:    0.7.0.1
 */