import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aqop
  extends aqwt<aqoo>
{
  public static aqoo a()
  {
    return (aqoo)aqxe.a().a(586);
  }
  
  @NonNull
  public aqoo a(int paramInt)
  {
    return new aqoo();
  }
  
  @Nullable
  public aqoo a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return aqoo.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(aqoo paramaqoo) {}
  
  public Class<aqoo> clazz()
  {
    return aqoo.class;
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
    return 586;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqop
 * JD-Core Version:    0.7.0.1
 */