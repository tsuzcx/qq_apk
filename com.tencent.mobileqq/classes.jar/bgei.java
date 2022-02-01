import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bgei
  extends aqwt<bgeh>
{
  @NonNull
  public bgeh a(int paramInt)
  {
    QLog.d("TroopMemberLevelMapCofigProcessor", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new bgeh();
  }
  
  @Nullable
  public bgeh a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelMapCofigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return bgeh.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(bgeh parambgeh) {}
  
  public Class<bgeh> clazz()
  {
    return bgeh.class;
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
 * Qualified Name:     bgei
 * JD-Core Version:    0.7.0.1
 */