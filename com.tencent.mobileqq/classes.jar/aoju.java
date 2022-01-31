import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aoju
  extends aofy<aojv>
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
    aojv localaojv = (aojv)aogj.a().a(552);
    if ((localaojv != null) && (!TextUtils.isEmpty(localaojv.a))) {
      alrh.a = "1".equals(localaojv.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, new Object[] { "isLocaleEntranceEnable: ", Boolean.valueOf(alrh.a) });
    }
    if (!alrh.a()) {
      return true;
    }
    return alrh.a;
  }
  
  public int a()
  {
    return 552;
  }
  
  @NonNull
  public aojv a(int paramInt)
  {
    return new aojv();
  }
  
  @Nullable
  public aojv a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aojv localaojv = aojv.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaojv;
    }
    return new aojv();
  }
  
  public Class<aojv> a()
  {
    return aojv.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aojv paramaojv)
  {
    if ((paramaojv != null) && (!TextUtils.isEmpty(paramaojv.a))) {
      alrh.a = "1".equals(paramaojv.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, "onUpdate, isConfShowEntrance: " + alrh.a);
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
 * Qualified Name:     aoju
 * JD-Core Version:    0.7.0.1
 */