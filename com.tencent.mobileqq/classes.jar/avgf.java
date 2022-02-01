import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class avgf
  extends aqkz<avgg>
{
  @NonNull
  public avgg a(int paramInt)
  {
    return new avgg();
  }
  
  @Nullable
  public avgg a(aqlg[] paramArrayOfaqlg)
  {
    avgg localavgg = new avgg();
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null)) {
      avgg.a(localavgg, paramArrayOfaqlg[0].a);
    }
    return localavgg;
  }
  
  public void a(avgg paramavgg) {}
  
  public Class<avgg> clazz()
  {
    return avgg.class;
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
    return 445;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avgf
 * JD-Core Version:    0.7.0.1
 */