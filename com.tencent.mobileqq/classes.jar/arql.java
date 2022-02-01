import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class arql
  extends arac<arqk>
{
  public static arqk a()
  {
    return (arqk)aran.a().a(483);
  }
  
  @NonNull
  public arqk a(int paramInt)
  {
    return new arqk();
  }
  
  @Nullable
  public arqk a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arqk.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arqk paramarqk)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("key_tencent_doc_history_tab_tips_count", 0).apply();
  }
  
  public Class<arqk> clazz()
  {
    return arqk.class;
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
 * Qualified Name:     arql
 * JD-Core Version:    0.7.0.1
 */