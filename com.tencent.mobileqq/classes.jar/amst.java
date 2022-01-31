import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class amst
  extends ampb<amsu>
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
    amsu localamsu = (amsu)ampm.a().a(552);
    if ((localamsu != null) && (!TextUtils.isEmpty(localamsu.a))) {
      ajzv.a = "1".equals(localamsu.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, new Object[] { "isLocaleEntranceEnable: ", Boolean.valueOf(ajzv.a) });
    }
    if (!ajzv.a()) {
      return true;
    }
    return ajzv.a;
  }
  
  public int a()
  {
    return 552;
  }
  
  @NonNull
  public amsu a(int paramInt)
  {
    return new amsu();
  }
  
  @Nullable
  public amsu a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amsu localamsu = amsu.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamsu;
    }
    return new amsu();
  }
  
  public Class<amsu> a()
  {
    return amsu.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amsu paramamsu)
  {
    if ((paramamsu != null) && (!TextUtils.isEmpty(paramamsu.a))) {
      ajzv.a = "1".equals(paramamsu.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, "onUpdate, isConfShowEntrance: " + ajzv.a);
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
 * Qualified Name:     amst
 * JD-Core Version:    0.7.0.1
 */