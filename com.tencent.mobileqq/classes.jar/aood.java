import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aood
  extends aokh<aooe>
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
    aooe localaooe = (aooe)aoks.a().a(552);
    if ((localaooe != null) && (!TextUtils.isEmpty(localaooe.a))) {
      alvw.a = "1".equals(localaooe.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, new Object[] { "isLocaleEntranceEnable: ", Boolean.valueOf(alvw.a) });
    }
    if (!alvw.a()) {
      return true;
    }
    return alvw.a;
  }
  
  public int a()
  {
    return 552;
  }
  
  @NonNull
  public aooe a(int paramInt)
  {
    return new aooe();
  }
  
  @Nullable
  public aooe a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aooe localaooe = aooe.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaooe;
    }
    return new aooe();
  }
  
  public Class<aooe> a()
  {
    return aooe.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aooe paramaooe)
  {
    if ((paramaooe != null) && (!TextUtils.isEmpty(paramaooe.a))) {
      alvw.a = "1".equals(paramaooe.a);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, "onUpdate, isConfShowEntrance: " + alvw.a);
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
 * Qualified Name:     aood
 * JD-Core Version:    0.7.0.1
 */