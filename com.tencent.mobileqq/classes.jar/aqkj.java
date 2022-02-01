import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aqkj
  extends aptq<aqki>
{
  public static aqki a()
  {
    return (aqki)apub.a().a(483);
  }
  
  @NonNull
  public aqki a(int paramInt)
  {
    return new aqki();
  }
  
  @Nullable
  public aqki a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqki.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqki paramaqki)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("key_tencent_doc_history_tab_tips_count", 0).apply();
  }
  
  public Class<aqki> clazz()
  {
    return aqki.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 483;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqkj
 * JD-Core Version:    0.7.0.1
 */