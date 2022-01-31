import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class amss
  extends ampa<amst>
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
    amst localamst = (amst)ampl.a().a(552);
    if ((localamst != null) && (!TextUtils.isEmpty(localamst.a))) {
      ajzt.a = "1".equals(localamst.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, new Object[] { "isLocaleEntranceEnable: ", Boolean.valueOf(ajzt.a) });
    }
    if (!ajzt.a()) {
      return true;
    }
    return ajzt.a;
  }
  
  public int a()
  {
    return 552;
  }
  
  @NonNull
  public amst a(int paramInt)
  {
    return new amst();
  }
  
  @Nullable
  public amst a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amst localamst = amst.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamst;
    }
    return new amst();
  }
  
  public Class<amst> a()
  {
    return amst.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amst paramamst)
  {
    if ((paramamst != null) && (!TextUtils.isEmpty(paramamst.a))) {
      ajzt.a = "1".equals(paramamst.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, "onUpdate, isConfShowEntrance: " + ajzt.a);
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
 * Qualified Name:     amss
 * JD-Core Version:    0.7.0.1
 */