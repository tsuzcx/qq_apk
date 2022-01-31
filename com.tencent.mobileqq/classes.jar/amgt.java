import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class amgt
  extends QIPCModule
  implements Handler.Callback
{
  private static amgt jdField_a_of_type_Amgt;
  private Handler jdField_a_of_type_AndroidOsHandler;
  
  private amgt()
  {
    super("ColorNoteIPCServer");
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("mini_msg", 0);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper(), this);
  }
  
  public static amgt a()
  {
    if (jdField_a_of_type_Amgt == null) {}
    try
    {
      if (jdField_a_of_type_Amgt == null) {
        jdField_a_of_type_Amgt = new amgt();
      }
      return jdField_a_of_type_Amgt;
    }
    finally {}
  }
  
  private EIPCResult a(Bundle paramBundle)
  {
    boolean bool = amgs.a(paramBundle.getString("extra_unikey"));
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_is_colornote_exists", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  private EIPCResult b(Bundle paramBundle)
  {
    boolean bool = amgs.b(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_add_colornote_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  private EIPCResult c(Bundle paramBundle)
  {
    boolean bool = amgs.a(paramBundle.getString("extra_unikey"), paramBundle.getInt("color_note_extra_type"));
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_delete_colornote_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  private EIPCResult d(Bundle paramBundle)
  {
    boolean bool = amgs.b();
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_can_add_colornote", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  private EIPCResult e(Bundle paramBundle)
  {
    return EIPCResult.createResult(0, amgs.a(paramBundle.getString("extra_unikey"), paramBundle.getBoolean("extra_update_colornote_state")));
  }
  
  private EIPCResult f(Bundle paramBundle)
  {
    boolean bool = amgs.a(paramBundle.getString("extra_unikey"), paramBundle.getString("extra_field_name"), paramBundle.getString("extra_field_value"));
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_update_colornote_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  private EIPCResult g(Bundle paramBundle)
  {
    boolean bool = amgs.a((ColorNote)paramBundle.getSerializable("color_note_recently_viewed_comparator"));
    paramBundle = new Bundle();
    paramBundle.putBoolean("color_note_clear_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  private EIPCResult h(Bundle paramBundle)
  {
    boolean bool = amiv.a(paramBundle.getInt("color_note_service_type"));
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
    if (!TextUtils.isEmpty(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgt
 * JD-Core Version:    0.7.0.1
 */