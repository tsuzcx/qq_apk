import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class bdlb
  extends arac<bdlc>
{
  @NonNull
  public bdlc a(int paramInt)
  {
    return new bdlc();
  }
  
  @Nullable
  public bdlc a(araj[] paramArrayOfaraj)
  {
    bdlc localbdlc = new bdlc();
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null)) {
      bdlc.a(localbdlc, paramArrayOfaraj[0].a);
    }
    return localbdlc;
  }
  
  public void a(bdlc parambdlc) {}
  
  public Class<bdlc> clazz()
  {
    return bdlc.class;
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
 * Qualified Name:     bdlb
 * JD-Core Version:    0.7.0.1
 */