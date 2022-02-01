import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bggx
  extends arac<bggw>
{
  @NonNull
  public bggw a(int paramInt)
  {
    QLog.d("JoinTroopSecurityTipsConfigProcessor", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new bggw();
  }
  
  @Nullable
  public bggw a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JoinTroopSecurityTipsConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return bggw.a(paramArrayOfaraj[0].a);
    }
    return null;
  }
  
  public void a(bggw parambggw) {}
  
  public Class<bggw> clazz()
  {
    return bggw.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("JoinTroopSecurityTipsConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 669;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggx
 * JD-Core Version:    0.7.0.1
 */