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

public class aoln
  extends aofy<aolm>
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
  
  public int a()
  {
    return 439;
  }
  
  @NonNull
  public aolm a(int paramInt)
  {
    return new aolm(0);
  }
  
  @Nullable
  public aolm a(aogf[] paramArrayOfaogf)
  {
    j = 0;
    i = j;
    if (paramArrayOfaogf != null)
    {
      i = j;
      if (paramArrayOfaogf.length > 0) {
        paramArrayOfaogf = paramArrayOfaogf[0].a;
      }
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("handlePushMsgBtnConfig", 2, "handlePushMsgBtnConfig. strContent = " + paramArrayOfaogf);
      }
      i = new JSONObject(paramArrayOfaogf).getInt("isPushSwitchShow");
    }
    catch (Exception paramArrayOfaogf)
    {
      for (;;)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("handlePushMsgBtnConfig", 2, "PushMsgBtnConfig parse error", paramArrayOfaogf);
          i = j;
        }
      }
    }
    return new aolm(i);
  }
  
  public Class a()
  {
    return aolm.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aolm paramaolm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("handlePushMsgBtnConfig", 2, "handlePushMsgBtnConfig. onUpdate = " + paramaolm.a);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), paramaolm.a);
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
 * Qualified Name:     aoln
 * JD-Core Version:    0.7.0.1
 */