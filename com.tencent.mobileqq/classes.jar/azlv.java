import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class azlv
  extends aqwt<azlw>
{
  protected abstract int a();
  
  @NonNull
  public azlw a(int paramInt)
  {
    return new azlw();
  }
  
  @Nullable
  public azlw a(aqxa[] paramArrayOfaqxa)
  {
    azlw localazlw = new azlw();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null)) {
      azlw.a(localazlw, paramArrayOfaqxa[0].a);
    }
    return localazlw;
  }
  
  public void a(azlw paramazlw) {}
  
  public Class<azlw> clazz()
  {
    return azlw.class;
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
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlv
 * JD-Core Version:    0.7.0.1
 */