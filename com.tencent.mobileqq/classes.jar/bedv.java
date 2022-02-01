import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bedv
  extends aptq<bedu>
{
  @NonNull
  public bedu a(int paramInt)
  {
    QLog.d("TroopEssenceMsgEntryConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bedu();
  }
  
  @Nullable
  public bedu a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return bedu.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(bedu parambedu) {}
  
  public Class<bedu> clazz()
  {
    return bedu.class;
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
    QLog.d("TroopEssenceMsgEntryConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 668;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedv
 * JD-Core Version:    0.7.0.1
 */