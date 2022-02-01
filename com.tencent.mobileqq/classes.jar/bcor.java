import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bcor
  extends aptq<bcos>
{
  public static bcos a()
  {
    return (bcos)apub.a().a(615);
  }
  
  @NonNull
  public bcos a(int paramInt)
  {
    return new bcos();
  }
  
  @Nullable
  public bcos a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModePushConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return bcos.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(bcos parambcos) {}
  
  public Class<bcos> clazz()
  {
    return bcos.class;
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
    return 615;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcor
 * JD-Core Version:    0.7.0.1
 */