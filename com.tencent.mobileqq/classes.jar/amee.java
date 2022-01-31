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

public class amee
  extends alzl<amed>
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
  public amed a(int paramInt)
  {
    return new amed(0);
  }
  
  @Nullable
  public amed a(alzs[] paramArrayOfalzs)
  {
    j = 0;
    i = j;
    if (paramArrayOfalzs != null)
    {
      i = j;
      if (paramArrayOfalzs.length > 0) {
        paramArrayOfalzs = paramArrayOfalzs[0].a;
      }
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("handlePushMsgBtnConfig", 2, "handlePushMsgBtnConfig. strContent = " + paramArrayOfalzs);
      }
      i = new JSONObject(paramArrayOfalzs).getInt("isPushSwitchShow");
    }
    catch (Exception paramArrayOfalzs)
    {
      for (;;)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("handlePushMsgBtnConfig", 2, "PushMsgBtnConfig parse error", paramArrayOfalzs);
          i = j;
        }
      }
    }
    return new amed(i);
  }
  
  public Class a()
  {
    return amed.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amed paramamed)
  {
    if (QLog.isColorLevel()) {
      QLog.d("handlePushMsgBtnConfig", 2, "handlePushMsgBtnConfig. onUpdate = " + paramamed.a);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), paramamed.a);
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
 * Qualified Name:     amee
 * JD-Core Version:    0.7.0.1
 */