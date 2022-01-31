import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class amrv
  extends ampb<amrw>
{
  public int a()
  {
    return 567;
  }
  
  @NonNull
  public amrw a(int paramInt)
  {
    return new amrw();
  }
  
  @Nullable
  public amrw a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onParsed");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      paramArrayOfampi = paramArrayOfampi[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("BroadcastConfProcessor", 2, "onParsed, content:" + paramArrayOfampi);
      }
      amrw localamrw = amrw.a(paramArrayOfampi);
      if (!TextUtils.isEmpty(paramArrayOfampi))
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("broadcast_white_pref", 4).edit().putString("white_list", paramArrayOfampi).apply();
        MobileQQ.addBroadcastWhitList(localamrw.a);
      }
    }
    return new amrw();
  }
  
  public Class<amrw> a()
  {
    return amrw.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amrw paramamrw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onUpdate");
    }
  }
  
  public boolean a()
  {
    return false;
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
 * Qualified Name:     amrv
 * JD-Core Version:    0.7.0.1
 */