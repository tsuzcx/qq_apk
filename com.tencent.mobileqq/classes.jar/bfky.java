import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bfky
  extends aqwt<bfkx>
{
  @NonNull
  public bfkx a(int paramInt)
  {
    QLog.d("TroopEssenceMsgEntryConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bfkx();
  }
  
  @Nullable
  public bfkx a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return bfkx.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(bfkx parambfkx) {}
  
  public Class<bfkx> clazz()
  {
    return bfkx.class;
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
 * Qualified Name:     bfky
 * JD-Core Version:    0.7.0.1
 */