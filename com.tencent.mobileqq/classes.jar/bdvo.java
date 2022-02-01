import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bdvo
  extends aptq<bdvn>
{
  @NonNull
  public bdvn a(int paramInt)
  {
    QLog.d("TroopBlockConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bdvn();
  }
  
  @Nullable
  public bdvn a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return bdvn.a(paramArrayOfaptx[0].a);
    }
    return null;
  }
  
  public void a(bdvn parambdvn) {}
  
  public Class<bdvn> clazz()
  {
    return bdvn.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("TroopBlockConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 673;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvo
 * JD-Core Version:    0.7.0.1
 */