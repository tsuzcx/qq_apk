import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class amrs
  extends ampa<amrt>
{
  public int a()
  {
    return 566;
  }
  
  @NonNull
  public amrt a(int paramInt)
  {
    return new amrt();
  }
  
  @Nullable
  public amrt a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amrt localamrt = amrt.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamrt;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amrt> a()
  {
    return amrt.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amrt paramamrt)
  {
    if (paramamrt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onUpdate " + paramamrt.toString());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ahon.a(localQQAppInterface, paramamrt.jdField_a_of_type_Boolean);
    localQQAppInterface.getApp().getSharedPreferences("acc_info" + localQQAppInterface.getAccount(), 0).edit().putLong("PREF_PLUGIN_DELAY_TIME", paramamrt.jdField_a_of_type_Long).apply();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "migrateOldVersion");
    }
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
 * Qualified Name:     amrs
 * JD-Core Version:    0.7.0.1
 */