import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aqgn
  extends aqwt<aqgo>
{
  @NonNull
  public aqgo a(int paramInt)
  {
    return new aqgo();
  }
  
  @Nullable
  public aqgo a(aqxa[] paramArrayOfaqxa)
  {
    aqgo localaqgo = new aqgo();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null)) {
      aqgo.a(localaqgo, paramArrayOfaqxa[0].a);
    }
    return localaqgo;
  }
  
  public void a(aqgo paramaqgo) {}
  
  public Class<aqgo> clazz()
  {
    return aqgo.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 416;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgn
 * JD-Core Version:    0.7.0.1
 */