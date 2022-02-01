import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class arbl
  extends aqwt<arbm>
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
    arbm localarbm = (arbm)aqxe.a().a(552);
    if ((localarbm != null) && (!TextUtils.isEmpty(localarbm.a))) {
      anxv.a = "1".equals(localarbm.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, new Object[] { "isLocaleEntranceEnable: ", Boolean.valueOf(anxv.a) });
    }
    if (!anxv.a()) {
      return true;
    }
    return anxv.a;
  }
  
  @NonNull
  public arbm a(int paramInt)
  {
    return new arbm();
  }
  
  @Nullable
  public arbm a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      arbm localarbm = arbm.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarbm;
    }
    return new arbm();
  }
  
  public void a(arbm paramarbm)
  {
    if ((paramarbm != null) && (!TextUtils.isEmpty(paramarbm.a))) {
      anxv.a = "1".equals(paramarbm.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, "onUpdate, isConfShowEntrance: " + anxv.a);
    }
  }
  
  public Class<arbm> clazz()
  {
    return arbm.class;
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
 * Qualified Name:     arbl
 * JD-Core Version:    0.7.0.1
 */