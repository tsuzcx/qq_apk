import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ardg
  extends arac<ardh>
{
  @NonNull
  public ardh a(int paramInt)
  {
    return new ardh();
  }
  
  @Nullable
  public ardh a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      paramArrayOfaraj = paramArrayOfaraj[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("BroadcastConfProcessor", 2, "onParsed, content:" + paramArrayOfaraj);
      }
      ardh localardh = ardh.a(paramArrayOfaraj);
      if (!TextUtils.isEmpty(paramArrayOfaraj))
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("broadcast_white_pref", 4).edit().putString("white_list", paramArrayOfaraj).apply();
        MobileQQ.addBroadcastWhitList(localardh.a);
      }
    }
    return new ardh();
  }
  
  public void a(ardh paramardh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onUpdate");
    }
  }
  
  public Class<ardh> clazz()
  {
    return ardh.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 567;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardg
 * JD-Core Version:    0.7.0.1
 */