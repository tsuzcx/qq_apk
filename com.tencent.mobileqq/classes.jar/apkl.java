import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apkl
  extends aptq<apkk>
{
  public static apkk a()
  {
    return (apkk)apub.a().a(549);
  }
  
  @NonNull
  public apkk a(int paramInt)
  {
    return new apkk();
  }
  
  @Nullable
  public apkk a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      apkk localapkk = apkk.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteConfigProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localapkk;
    }
    return null;
  }
  
  public void a(apkk paramapkk) {}
  
  public Class clazz()
  {
    return apkk.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteConfigProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 549;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkl
 * JD-Core Version:    0.7.0.1
 */