import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bfxh
  extends aqwt<bfxg>
{
  @NonNull
  public bfxg a(int paramInt)
  {
    QLog.d("JoinTroopSecurityTipsConfigProcessor", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new bfxg();
  }
  
  @Nullable
  public bfxg a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JoinTroopSecurityTipsConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return bfxg.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(bfxg parambfxg) {}
  
  public Class<bfxg> clazz()
  {
    return bfxg.class;
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
 * Qualified Name:     bfxh
 * JD-Core Version:    0.7.0.1
 */