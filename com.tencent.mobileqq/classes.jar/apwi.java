import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class apwi
  extends aqkz<apwj>
{
  @NonNull
  public apwj a(int paramInt)
  {
    return new apwj();
  }
  
  @Nullable
  public apwj a(aqlg[] paramArrayOfaqlg)
  {
    apwj localapwj = new apwj();
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null)) {
      apwj.a(localapwj, paramArrayOfaqlg[0].a);
    }
    return localapwj;
  }
  
  public void a(apwj paramapwj) {}
  
  public Class<apwj> clazz()
  {
    return apwj.class;
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
 * Qualified Name:     apwi
 * JD-Core Version:    0.7.0.1
 */