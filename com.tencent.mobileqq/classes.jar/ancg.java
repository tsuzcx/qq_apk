import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ancg
  extends ampb<ancc>
{
  public static ancc a()
  {
    return (ancc)ampm.a().a(525);
  }
  
  public int a()
  {
    return 525;
  }
  
  @NonNull
  public ancc a(int paramInt)
  {
    return new ancc();
  }
  
  @Nullable
  public ancc a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return ancc.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<ancc> a()
  {
    return ancc.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TencentDocLocalCooperationProcessor", 1, "TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:" + paramInt);
  }
  
  public void a(ancc paramancc) {}
  
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
 * Qualified Name:     ancg
 * JD-Core Version:    0.7.0.1
 */