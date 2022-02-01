import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bfuk
  extends arac<bfuj>
{
  @NonNull
  public bfuj a(int paramInt)
  {
    QLog.d("TroopEssenceMsgEntryConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bfuj();
  }
  
  @Nullable
  public bfuj a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return bfuj.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(bfuj parambfuj) {}
  
  public Class<bfuj> clazz()
  {
    return bfuj.class;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfuk
 * JD-Core Version:    0.7.0.1
 */