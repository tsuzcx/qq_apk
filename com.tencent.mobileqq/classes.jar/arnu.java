import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class arnu
  extends aqwt<arnt>
{
  public static arnt a()
  {
    return (arnt)aqxe.a().a(483);
  }
  
  @NonNull
  public arnt a(int paramInt)
  {
    return new arnt();
  }
  
  @Nullable
  public arnt a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arnt.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arnt paramarnt)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("key_tencent_doc_history_tab_tips_count", 0).apply();
  }
  
  public Class<arnt> clazz()
  {
    return arnt.class;
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
 * Qualified Name:     arnu
 * JD-Core Version:    0.7.0.1
 */