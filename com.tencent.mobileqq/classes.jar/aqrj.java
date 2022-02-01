import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import eipc.EIPCResult;

public class aqrj
  extends QIPCModule
  implements Handler.Callback
{
  private static aqrj jdField_a_of_type_Aqrj;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private aqri jdField_a_of_type_Aqri;
  private boolean jdField_a_of_type_Boolean;
  
  private aqrj()
  {
    super("ColorNoteIPCServer");
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Aqri = new aqri(localQQAppInterface, localQQAppInterface.a().a());
    a(localQQAppInterface);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static aqrj a()
  {
    if (jdField_a_of_type_Aqrj == null) {}
    try
    {
      if (jdField_a_of_type_Aqrj == null) {
        jdField_a_of_type_Aqrj = new aqrj();
      }
      return jdField_a_of_type_Aqrj;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aqrk(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGIN");
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      aqry localaqry = localQQAppInterface.a().a();
      this.jdField_a_of_type_Aqri.a(localQQAppInterface);
      this.jdField_a_of_type_Aqri.a(localaqry);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Aqri.a(null);
    this.jdField_a_of_type_Aqri.a(null);
  }
  
  EIPCResult a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("extra_unikey");
    boolean bool = this.jdField_a_of_type_Aqri.a(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_is_colornote_exists", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  public void a()
  {
    d();
    if (this.jdField_a_of_type_Boolean)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        localQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  EIPCResult b(Bundle paramBundle)
  {
    boolean bool = this.jdField_a_of_type_Aqri.a(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_add_colornote_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  public void b()
  {
    c();
    if (!this.jdField_a_of_type_Boolean)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        a(localQQAppInterface);
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  EIPCResult c(Bundle paramBundle)
  {
    String str = paramBundle.getString("extra_unikey");
    int i = paramBundle.getInt("color_note_extra_type");
    boolean bool = this.jdField_a_of_type_Aqri.b(str, i);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_delete_colornote_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult d(Bundle paramBundle)
  {
    boolean bool = this.jdField_a_of_type_Aqri.c();
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_can_add_colornote", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult e(Bundle paramBundle)
  {
    String str = paramBundle.getString("extra_unikey");
    boolean bool = paramBundle.getBoolean("extra_update_colornote_state");
    return EIPCResult.createResult(0, this.jdField_a_of_type_Aqri.a(str, bool));
  }
  
  EIPCResult f(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("extra_unikey");
    String str2 = paramBundle.getString("extra_field_name");
    String str3 = paramBundle.getString("extra_field_value");
    int i = paramBundle.getInt("extra_field_type");
    boolean bool = this.jdField_a_of_type_Aqri.b(str1, str2, str3, i);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_update_colornote_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult g(Bundle paramBundle)
  {
    paramBundle = (ColorNote)paramBundle.getSerializable("color_note_recently_viewed_comparator");
    boolean bool = this.jdField_a_of_type_Aqri.c(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("color_note_clear_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult h(Bundle paramBundle)
  {
    boolean bool = aqts.a(paramBundle.getInt("color_note_service_type"));
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_clear_history_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bhsr.a(paramString))
    {
      if (!paramString.equalsIgnoreCase("cmd_query_isexists")) {
        break label33;
      }
      localObject1 = a(paramBundle);
    }
    label33:
    do
    {
      return localObject1;
      if (paramString.equalsIgnoreCase("cmd_add_colornote")) {
        return b(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_delete_colornote")) {
        return c(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_can_add_colornote")) {
        return d(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_update_colornote_state")) {
        return e(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_update_colornote")) {
        return f(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_clear_color_note")) {
        return g(paramBundle);
      }
      localObject1 = localObject2;
    } while (!paramString.equalsIgnoreCase("cmd_clear_history_color_notes"));
    return h(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqrj
 * JD-Core Version:    0.7.0.1
 */