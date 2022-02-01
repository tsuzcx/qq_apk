import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class azlx
  extends aqwt<azly>
{
  @NonNull
  public azly a(int paramInt)
  {
    return new azly();
  }
  
  @Nullable
  public azly a(aqxa[] paramArrayOfaqxa)
  {
    azly localazly = new azly();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null)) {
      azly.a(localazly, paramArrayOfaqxa[0].a);
    }
    return localazly;
  }
  
  public void a(azly paramazly) {}
  
  public Class<azly> clazz()
  {
    return azly.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 495;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlx
 * JD-Core Version:    0.7.0.1
 */