import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bfnj
  extends aqkz<bfni>
{
  @NonNull
  public bfni a(int paramInt)
  {
    QLog.d("TroopMemberLevelMapCofigProcessor", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new bfni();
  }
  
  @Nullable
  public bfni a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelMapCofigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return bfni.a(paramArrayOfaqlg[0].a);
    }
    return null;
  }
  
  public void a(bfni parambfni) {}
  
  public Class<bfni> clazz()
  {
    return bfni.class;
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
 * Qualified Name:     bfnj
 * JD-Core Version:    0.7.0.1
 */