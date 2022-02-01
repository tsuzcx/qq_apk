import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class azlr
  extends aqwt<azlt>
{
  abstract int a();
  
  @NonNull
  public azlt a(int paramInt)
  {
    return new azlt();
  }
  
  @Nullable
  public azlt a(aqxa[] paramArrayOfaqxa)
  {
    azlt localazlt = new azlt();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null)) {
      azlt.a(localazlt, paramArrayOfaqxa[0].a);
    }
    return localazlt;
  }
  
  public void a(azlt paramazlt) {}
  
  public Class<azlt> clazz()
  {
    return azlt.class;
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
 * Qualified Name:     azlr
 * JD-Core Version:    0.7.0.1
 */