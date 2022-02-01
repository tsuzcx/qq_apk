import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class avyi
  extends arac<avyj>
{
  @NonNull
  public avyj a(int paramInt)
  {
    return new avyj();
  }
  
  @Nullable
  public avyj a(araj[] paramArrayOfaraj)
  {
    avyj localavyj = new avyj();
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null)) {
      avyj.a(localavyj, paramArrayOfaraj[0].a);
    }
    return localavyj;
  }
  
  public void a(avyj paramavyj) {}
  
  public Class<avyj> clazz()
  {
    return avyj.class;
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
 * Qualified Name:     avyi
 * JD-Core Version:    0.7.0.1
 */