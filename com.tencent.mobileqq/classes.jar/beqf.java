import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class beqf
  extends aptq<beqe>
{
  @NonNull
  public beqe a(int paramInt)
  {
    QLog.d("JoinTroopSecurityTipsConfigProcessor", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new beqe();
  }
  
  @Nullable
  public beqe a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JoinTroopSecurityTipsConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return beqe.a(paramArrayOfaptx[0].a);
    }
    return null;
  }
  
  public void a(beqe parambeqe) {}
  
  public Class<beqe> clazz()
  {
    return beqe.class;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqf
 * JD-Core Version:    0.7.0.1
 */