import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class beww
  extends aptq<bewv>
{
  @NonNull
  public bewv a(int paramInt)
  {
    QLog.d("TroopMemberLevelMapCofigProcessor", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new bewv();
  }
  
  @Nullable
  public bewv a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelMapCofigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return bewv.a(paramArrayOfaptx[0].a);
    }
    return null;
  }
  
  public void a(bewv parambewv) {}
  
  public Class<bewv> clazz()
  {
    return bewv.class;
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
 * Qualified Name:     beww
 * JD-Core Version:    0.7.0.1
 */