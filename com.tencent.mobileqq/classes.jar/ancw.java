import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class ancw
  extends ampb<anct>
{
  public static anct a()
  {
    return (anct)ampm.a().a(346);
  }
  
  public int a()
  {
    return 346;
  }
  
  @NonNull
  public anct a(int paramInt)
  {
    return new anct();
  }
  
  @Nullable
  public anct a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return anct.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<anct> a()
  {
    return anct.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(anct paramanct)
  {
    if ((paramanct != null) && (!TextUtils.isEmpty(paramanct.d()))) {
      ((aygv)BaseApplicationImpl.getApplication().getRuntime().getManager(272)).a(paramanct);
    }
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
 * Qualified Name:     ancw
 * JD-Core Version:    0.7.0.1
 */