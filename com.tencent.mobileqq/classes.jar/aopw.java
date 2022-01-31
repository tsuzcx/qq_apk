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

public class aopw
  extends aokh<aopv>
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
  public aopv a(int paramInt)
  {
    return new aopv(0);
  }
  
  @Nullable
  public aopv a(aoko[] paramArrayOfaoko)
  {
    j = 0;
    i = j;
    if (paramArrayOfaoko != null)
    {
      i = j;
      if (paramArrayOfaoko.length > 0) {
        paramArrayOfaoko = paramArrayOfaoko[0].a;
      }
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("handlePushMsgBtnConfig", 2, "handlePushMsgBtnConfig. strContent = " + paramArrayOfaoko);
      }
      i = new JSONObject(paramArrayOfaoko).getInt("isPushSwitchShow");
    }
    catch (Exception paramArrayOfaoko)
    {
      for (;;)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("handlePushMsgBtnConfig", 2, "PushMsgBtnConfig parse error", paramArrayOfaoko);
          i = j;
        }
      }
    }
    return new aopv(i);
  }
  
  public Class a()
  {
    return aopv.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aopv paramaopv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("handlePushMsgBtnConfig", 2, "handlePushMsgBtnConfig. onUpdate = " + paramaopv.a);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), paramaopv.a);
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
 * Qualified Name:     aopw
 * JD-Core Version:    0.7.0.1
 */