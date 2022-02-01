import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bdvi
  extends aptq<bdvh>
{
  @NonNull
  public bdvh a(int paramInt)
  {
    QLog.d("TroopAssociationsEntryConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bdvh();
  }
  
  @Nullable
  public bdvh a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return bdvh.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(bdvh parambdvh) {}
  
  public Class<bdvh> clazz()
  {
    return bdvh.class;
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
    QLog.d("TroopAssociationsEntryConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 686;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvi
 * JD-Core Version:    0.7.0.1
 */