import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aoxu
  extends aokh<aoxt>
{
  public static aoxt a()
  {
    return (aoxt)aoks.a().a(483);
  }
  
  public int a()
  {
    return 483;
  }
  
  @NonNull
  public aoxt a(int paramInt)
  {
    return new aoxt();
  }
  
  @Nullable
  public aoxt a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return aoxt.a(paramArrayOfaoko);
    }
    return null;
  }
  
  public Class<aoxt> a()
  {
    return aoxt.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoxt paramaoxt)
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
 * Qualified Name:     aoxu
 * JD-Core Version:    0.7.0.1
 */