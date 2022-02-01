import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class bdkq
  extends aqwt<bdkr>
{
  @NonNull
  public bdkr a(int paramInt)
  {
    return new bdkr();
  }
  
  @Nullable
  public bdkr a(aqxa[] paramArrayOfaqxa)
  {
    bdkr localbdkr = new bdkr();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null)) {
      bdkr.a(localbdkr, paramArrayOfaqxa[0].a);
    }
    return localbdkr;
  }
  
  public void a(bdkr parambdkr) {}
  
  public Class<bdkr> clazz()
  {
    return bdkr.class;
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
    return 577;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkq
 * JD-Core Version:    0.7.0.1
 */