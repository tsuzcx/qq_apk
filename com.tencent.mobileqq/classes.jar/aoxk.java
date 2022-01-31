import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aoxk
  extends aokh<aoxh>
{
  public static aoxh a()
  {
    return (aoxh)aoks.a().a(383);
  }
  
  public int a()
  {
    return 383;
  }
  
  @NonNull
  public aoxh a(int paramInt)
  {
    return new aoxh();
  }
  
  @Nullable
  public aoxh a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return aoxh.a(paramArrayOfaoko);
    }
    return null;
  }
  
  public Class<aoxh> a()
  {
    return aoxh.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoxh paramaoxh)
  {
    if ((paramaoxh != null) && (!TextUtils.isEmpty(paramaoxh.b()))) {
      ((bajo)BaseApplicationImpl.getApplication().getRuntime().getManager(305)).a(paramaoxh);
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
 * Qualified Name:     aoxk
 * JD-Core Version:    0.7.0.1
 */