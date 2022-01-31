import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class anbp
  extends ampb<anbm>
{
  public static anbm a()
  {
    return (anbm)ampm.a().a(383);
  }
  
  public int a()
  {
    return 383;
  }
  
  @NonNull
  public anbm a(int paramInt)
  {
    return new anbm();
  }
  
  @Nullable
  public anbm a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return anbm.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<anbm> a()
  {
    return anbm.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(anbm paramanbm)
  {
    if ((paramanbm != null) && (!TextUtils.isEmpty(paramanbm.b()))) {
      ((ayhh)BaseApplicationImpl.getApplication().getRuntime().getManager(305)).a(paramanbm);
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
 * Qualified Name:     anbp
 * JD-Core Version:    0.7.0.1
 */