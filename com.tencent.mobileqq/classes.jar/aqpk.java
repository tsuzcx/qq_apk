import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aqpk
  extends aqkz<aqpl>
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
    aqpl localaqpl = (aqpl)aqlk.a().a(552);
    if ((localaqpl != null) && (!TextUtils.isEmpty(localaqpl.a))) {
      anpe.a = "1".equals(localaqpl.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, new Object[] { "isLocaleEntranceEnable: ", Boolean.valueOf(anpe.a) });
    }
    if (!anpe.a()) {
      return true;
    }
    return anpe.a;
  }
  
  @NonNull
  public aqpl a(int paramInt)
  {
    return new aqpl();
  }
  
  @Nullable
  public aqpl a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aqpl localaqpl = aqpl.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqpl;
    }
    return new aqpl();
  }
  
  public void a(aqpl paramaqpl)
  {
    if ((paramaqpl != null) && (!TextUtils.isEmpty(paramaqpl.a))) {
      anpe.a = "1".equals(paramaqpl.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, "onUpdate, isConfShowEntrance: " + anpe.a);
    }
  }
  
  public Class<aqpl> clazz()
  {
    return aqpl.class;
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
 * Qualified Name:     aqpk
 * JD-Core Version:    0.7.0.1
 */