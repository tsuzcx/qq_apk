import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class ares
  extends arac<aret>
{
  public static boolean a()
  {
    if ((Build.VERSION.SDK_INT >= 26) && (Build.MODEL.toLowerCase().contains("vivo")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "hide entrance for vivo");
      }
      return false;
    }
    aret localaret = (aret)aran.a().a(552);
    if ((localaret != null) && (!TextUtils.isEmpty(localaret.a))) {
      aobf.a = "1".equals(localaret.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, new Object[] { "isLocaleEntranceEnable: ", Boolean.valueOf(aobf.a) });
    }
    if (!aobf.a()) {
      return true;
    }
    return aobf.a;
  }
  
  @NonNull
  public aret a(int paramInt)
  {
    return new aret();
  }
  
  @Nullable
  public aret a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      aret localaret = aret.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localaret;
    }
    return new aret();
  }
  
  public void a(aret paramaret)
  {
    if ((paramaret != null) && (!TextUtils.isEmpty(paramaret.a))) {
      aobf.a = "1".equals(paramaret.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, "onUpdate, isConfShowEntrance: " + aobf.a);
    }
  }
  
  public Class<aret> clazz()
  {
    return aret.class;
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
    return 552;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ares
 * JD-Core Version:    0.7.0.1
 */