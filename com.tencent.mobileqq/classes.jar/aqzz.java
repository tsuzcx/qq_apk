import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class aqzz
  extends aqwt<araa>
{
  @NonNull
  public araa a(int paramInt)
  {
    return new araa();
  }
  
  @Nullable
  public araa a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("BroadcastConfProcessor", 2, "onParsed, content:" + paramArrayOfaqxa);
      }
      araa localaraa = araa.a(paramArrayOfaqxa);
      if (!TextUtils.isEmpty(paramArrayOfaqxa))
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("broadcast_white_pref", 4).edit().putString("white_list", paramArrayOfaqxa).apply();
        MobileQQ.addBroadcastWhitList(localaraa.a);
      }
    }
    return new araa();
  }
  
  public void a(araa paramaraa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onUpdate");
    }
  }
  
  public Class<araa> clazz()
  {
    return araa.class;
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
 * Qualified Name:     aqzz
 * JD-Core Version:    0.7.0.1
 */