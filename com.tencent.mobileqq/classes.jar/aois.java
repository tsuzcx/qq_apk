import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class aois
  extends aofy<aoit>
{
  public int a()
  {
    return 567;
  }
  
  @NonNull
  public aoit a(int paramInt)
  {
    return new aoit();
  }
  
  @Nullable
  public aoit a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      paramArrayOfaogf = paramArrayOfaogf[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("BroadcastConfProcessor", 2, "onParsed, content:" + paramArrayOfaogf);
      }
      aoit localaoit = aoit.a(paramArrayOfaogf);
      if (!TextUtils.isEmpty(paramArrayOfaogf))
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("broadcast_white_pref", 4).edit().putString("white_list", paramArrayOfaogf).apply();
        MobileQQ.addBroadcastWhitList(localaoit.a);
      }
    }
    return new aoit();
  }
  
  public Class<aoit> a()
  {
    return aoit.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoit paramaoit)
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
 * Qualified Name:     aois
 * JD-Core Version:    0.7.0.1
 */