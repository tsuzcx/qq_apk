import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aqsc
  extends arac<aqsb>
{
  public static aqsb a()
  {
    return (aqsb)aran.a().a(586);
  }
  
  @NonNull
  public aqsb a(int paramInt)
  {
    return new aqsb();
  }
  
  @Nullable
  public aqsb a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return aqsb.a(paramArrayOfaraj[0].a);
    }
    return null;
  }
  
  public void a(aqsb paramaqsb) {}
  
  public Class<aqsb> clazz()
  {
    return aqsb.class;
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
 * Qualified Name:     aqsc
 * JD-Core Version:    0.7.0.1
 */