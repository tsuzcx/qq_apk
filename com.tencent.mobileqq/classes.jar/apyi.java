import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class apyi
  extends aptq<apyj>
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
    apyj localapyj = (apyj)apub.a().a(552);
    if ((localapyj != null) && (!TextUtils.isEmpty(localapyj.a))) {
      amvi.a = "1".equals(localapyj.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, new Object[] { "isLocaleEntranceEnable: ", Boolean.valueOf(amvi.a) });
    }
    if (!amvi.a()) {
      return true;
    }
    return amvi.a;
  }
  
  @NonNull
  public apyj a(int paramInt)
  {
    return new apyj();
  }
  
  @Nullable
  public apyj a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      apyj localapyj = apyj.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localapyj;
    }
    return new apyj();
  }
  
  public void a(apyj paramapyj)
  {
    if ((paramapyj != null) && (!TextUtils.isEmpty(paramapyj.a))) {
      amvi.a = "1".equals(paramapyj.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, "onUpdate, isConfShowEntrance: " + amvi.a);
    }
  }
  
  public Class<apyj> clazz()
  {
    return apyj.class;
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
 * Qualified Name:     apyi
 * JD-Core Version:    0.7.0.1
 */