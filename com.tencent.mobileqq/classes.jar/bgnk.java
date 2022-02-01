import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bgnk
  extends arac<bgnj>
{
  @NonNull
  public bgnj a(int paramInt)
  {
    QLog.d("TroopMemberLevelMapCofigProcessor", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new bgnj();
  }
  
  @Nullable
  public bgnj a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelMapCofigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return bgnj.a(paramArrayOfaraj[0].a);
    }
    return null;
  }
  
  public void a(bgnj parambgnj) {}
  
  public Class<bgnj> clazz()
  {
    return bgnj.class;
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
    QLog.d("TroopMemberLevelMapCofigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 659;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgnk
 * JD-Core Version:    0.7.0.1
 */