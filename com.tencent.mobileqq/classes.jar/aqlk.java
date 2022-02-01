import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqlk
  extends aqwt<aqlj>
{
  @NonNull
  public static aqlj a()
  {
    aqlj localaqlj2 = (aqlj)aqxe.a().a(670);
    aqlj localaqlj1 = localaqlj2;
    if (localaqlj2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarConfProcessor", 2, "loadConfig(): bean is null then new C2CShortcutBarConfBean()");
      }
      localaqlj1 = new aqlj();
    }
    return localaqlj1;
  }
  
  @NonNull
  public aqlj a(int paramInt)
  {
    return new aqlj();
  }
  
  @Nullable
  public aqlj a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0))
    {
      QLog.d("C2CShortcutBarConfProcessor", 1, "C2CShortcutBarConfProcessor onParsed, confFiles is null empty");
      return null;
    }
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarConfProcessor", 2, "C2CShortcutBarConfProcessor onParsed, content:" + paramArrayOfaqxa);
    }
    return aqlj.a(paramArrayOfaqxa);
  }
  
  public void a(aqlj paramaqlj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarConfProcessor", 2, "onUpdate " + paramaqlj.toString());
    }
  }
  
  public Class<aqlj> clazz()
  {
    return aqlj.class;
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
 * Qualified Name:     aqlk
 * JD-Core Version:    0.7.0.1
 */