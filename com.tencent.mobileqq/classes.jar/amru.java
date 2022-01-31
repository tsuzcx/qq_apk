import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class amru
  extends ampa<amrv>
{
  public int a()
  {
    return 567;
  }
  
  @NonNull
  public amrv a(int paramInt)
  {
    return new amrv();
  }
  
  @Nullable
  public amrv a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onParsed");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      paramArrayOfamph = paramArrayOfamph[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("BroadcastConfProcessor", 2, "onParsed, content:" + paramArrayOfamph);
      }
      amrv localamrv = amrv.a(paramArrayOfamph);
      if (!TextUtils.isEmpty(paramArrayOfamph))
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("broadcast_white_pref", 4).edit().putString("white_list", paramArrayOfamph).apply();
        MobileQQ.addBroadcastWhitList(localamrv.a);
      }
    }
    return new amrv();
  }
  
  public Class<amrv> a()
  {
    return amrv.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amrv paramamrv)
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
 * Qualified Name:     amru
 * JD-Core Version:    0.7.0.1
 */