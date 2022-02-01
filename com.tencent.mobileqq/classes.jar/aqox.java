import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqox
  extends arac<aqow>
{
  @NonNull
  public static aqow a()
  {
    aqow localaqow2 = (aqow)aran.a().a(670);
    aqow localaqow1 = localaqow2;
    if (localaqow2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarConfProcessor", 2, "loadConfig(): bean is null then new C2CShortcutBarConfBean()");
      }
      localaqow1 = new aqow();
    }
    return localaqow1;
  }
  
  @NonNull
  public aqow a(int paramInt)
  {
    return new aqow();
  }
  
  @Nullable
  public aqow a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0))
    {
      QLog.d("C2CShortcutBarConfProcessor", 1, "C2CShortcutBarConfProcessor onParsed, confFiles is null empty");
      return null;
    }
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarConfProcessor", 2, "C2CShortcutBarConfProcessor onParsed, content:" + paramArrayOfaraj);
    }
    return aqow.a(paramArrayOfaraj);
  }
  
  public void a(aqow paramaqow)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarConfProcessor", 2, "onUpdate " + paramaqow.toString());
    }
  }
  
  public Class<aqow> clazz()
  {
    return aqow.class;
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
 * Qualified Name:     aqox
 * JD-Core Version:    0.7.0.1
 */