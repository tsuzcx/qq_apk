import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apig
  extends aptq<apif>
{
  @NonNull
  public static apif a()
  {
    apif localapif2 = (apif)apub.a().a(670);
    apif localapif1 = localapif2;
    if (localapif2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarConfProcessor", 2, "loadConfig(): bean is null then new C2CShortcutBarConfBean()");
      }
      localapif1 = new apif();
    }
    return localapif1;
  }
  
  @NonNull
  public apif a(int paramInt)
  {
    return new apif();
  }
  
  @Nullable
  public apif a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length == 0))
    {
      QLog.d("C2CShortcutBarConfProcessor", 1, "C2CShortcutBarConfProcessor onParsed, confFiles is null empty");
      return null;
    }
    paramArrayOfaptx = paramArrayOfaptx[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarConfProcessor", 2, "C2CShortcutBarConfProcessor onParsed, content:" + paramArrayOfaptx);
    }
    return apif.a(paramArrayOfaptx);
  }
  
  public void a(apif paramapif)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarConfProcessor", 2, "onUpdate " + paramapif.toString());
    }
  }
  
  public Class<apif> clazz()
  {
    return apif.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 670;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apig
 * JD-Core Version:    0.7.0.1
 */