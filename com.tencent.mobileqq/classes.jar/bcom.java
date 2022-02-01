import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bcom
  extends aptq<bcon>
{
  public static bcon a()
  {
    return (bcon)apub.a().a(610);
  }
  
  @NonNull
  public bcon a(int paramInt)
  {
    return new bcon();
  }
  
  @Nullable
  public bcon a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModeConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return bcon.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(bcon parambcon) {}
  
  public Class<bcon> clazz()
  {
    return bcon.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 610;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcom
 * JD-Core Version:    0.7.0.1
 */