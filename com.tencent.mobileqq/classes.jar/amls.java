import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class amls
  extends alzl<amlr>
{
  public static amlr a()
  {
    return (amlr)alzw.a().a(483);
  }
  
  public int a()
  {
    return 483;
  }
  
  @NonNull
  public amlr a(int paramInt)
  {
    return new amlr();
  }
  
  @Nullable
  public amlr a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return amlr.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<amlr> a()
  {
    return amlr.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amlr paramamlr)
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
 * Qualified Name:     amls
 * JD-Core Version:    0.7.0.1
 */