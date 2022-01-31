import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aotl
  extends aofy<aotk>
{
  public static aotk a()
  {
    return (aotk)aogj.a().a(483);
  }
  
  public int a()
  {
    return 483;
  }
  
  @NonNull
  public aotk a(int paramInt)
  {
    return new aotk();
  }
  
  @Nullable
  public aotk a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return aotk.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public Class<aotk> a()
  {
    return aotk.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aotk paramaotk)
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
 * Qualified Name:     aotl
 * JD-Core Version:    0.7.0.1
 */