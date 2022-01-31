import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class amcr
  extends alzl<amcs>
{
  public static boolean e()
  {
    if ((Build.VERSION.SDK_INT >= 26) && (Build.MODEL.toLowerCase().contains("vivo")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "hide entrance for vivo");
      }
      return false;
    }
    amcs localamcs = (amcs)alzw.a().a(552);
    if ((localamcs != null) && (!TextUtils.isEmpty(localamcs.a))) {
      ajlo.a = "1".equals(localamcs.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, new Object[] { "isLocaleEntranceEnable: ", Boolean.valueOf(ajlo.a) });
    }
    if (!ajlo.a()) {
      return true;
    }
    return ajlo.a;
  }
  
  public int a()
  {
    return 552;
  }
  
  @NonNull
  public amcs a(int paramInt)
  {
    return new amcs();
  }
  
  @Nullable
  public amcs a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      amcs localamcs = amcs.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamcs;
    }
    return new amcs();
  }
  
  public Class<amcs> a()
  {
    return amcs.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amcs paramamcs)
  {
    if ((paramamcs != null) && (!TextUtils.isEmpty(paramamcs.a))) {
      ajlo.a = "1".equals(paramamcs.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, "onUpdate, isConfShowEntrance: " + ajlo.a);
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amcr
 * JD-Core Version:    0.7.0.1
 */