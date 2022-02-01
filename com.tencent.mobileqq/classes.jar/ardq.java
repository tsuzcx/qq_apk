import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ardq
  extends aqwt<ardp>
{
  public static int a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "poke_msg_btn_is_show", 0);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_msg_btn_is_show", paramInt);
    paramContext.apply();
  }
  
  @NonNull
  public ardp a(int paramInt)
  {
    return new ardp(0);
  }
  
  @Nullable
  public ardp a(aqxa[] paramArrayOfaqxa)
  {
    j = 0;
    i = j;
    if (paramArrayOfaqxa != null)
    {
      i = j;
      if (paramArrayOfaqxa.length > 0) {
        paramArrayOfaqxa = paramArrayOfaqxa[0].a;
      }
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("handlePushMsgBtnConfig", 2, "handlePushMsgBtnConfig. strContent = " + paramArrayOfaqxa);
      }
      i = new JSONObject(paramArrayOfaqxa).getInt("isPushSwitchShow");
    }
    catch (Exception paramArrayOfaqxa)
    {
      for (;;)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("handlePushMsgBtnConfig", 2, "PushMsgBtnConfig parse error", paramArrayOfaqxa);
          i = j;
        }
      }
    }
    return new ardp(i);
  }
  
  public void a(ardp paramardp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("handlePushMsgBtnConfig", 2, "handlePushMsgBtnConfig. onUpdate = " + paramardp.a);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), paramardp.a);
  }
  
  public Class clazz()
  {
    return ardp.class;
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
    return 439;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardq
 * JD-Core Version:    0.7.0.1
 */