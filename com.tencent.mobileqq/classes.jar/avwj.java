import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/intervideo/now/webplugin/AudioRoomSettingHandler;", "", "()V", "ACT_GET_TMP_MSG_PUSH_SETTING", "", "ACT_SET_TMP_MSG_PUSH_SETTING", "TAG", "", "handleGetTmpMsgPushSetting", "", "plugin", "Lcom/tencent/mobileqq/intervideo/now/NowWebViewPlugin;", "reqJson", "Lorg/json/JSONObject;", "callback", "handleRequest", "args", "", "(Lcom/tencent/mobileqq/intervideo/now/NowWebViewPlugin;[Ljava/lang/String;)V", "handleSetTmpMsgPushSetting", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class avwj
{
  public static final avwj a = new avwj();
  
  private final void a(avut paramavut, JSONObject paramJSONObject, String paramString)
  {
    paramavut.a().a((short)-23161, (aaea)new avwk(paramavut, paramString));
  }
  
  @JvmStatic
  public static final void a(@NotNull avut paramavut, @NotNull String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramavut, "plugin");
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "args");
    for (;;)
    {
      String str;
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        str = paramArrayOfString.optString("callback");
        int i = paramArrayOfString.optInt("act", -1);
        switch (i)
        {
        case 1: 
          QLog.w("AudioRoomSettingHandler", 1, "unknown action: " + i);
          return;
        }
      }
      catch (Exception paramavut)
      {
        QLog.w("AudioRoomSettingHandler", 1, "handleRequest catch: " + paramavut);
        return;
      }
      avwj localavwj = a;
      Intrinsics.checkExpressionValueIsNotNull(str, "callback");
      localavwj.a(paramavut, paramArrayOfString, str);
      return;
      localavwj = a;
      Intrinsics.checkExpressionValueIsNotNull(str, "callback");
      localavwj.b(paramavut, paramArrayOfString, str);
      return;
    }
  }
  
  private final void b(avut paramavut, JSONObject paramJSONObject, String paramString)
  {
    boolean bool = false;
    int i = paramJSONObject.optInt("pushSwitch", -1);
    QLog.i("AudioRoomSettingHandler", 1, "handleSetTmpMsgPushSetting request: toStatus=" + i);
    if ((i != 0) && (i != 1))
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", "fail");
      paramavut.callJs(paramString, new String[] { paramJSONObject.toString() });
      return;
    }
    paramJSONObject = paramavut.a();
    if (i == 1) {
      bool = true;
    }
    paramJSONObject.a((short)-23161, bool, (aaea)new avwl(i, paramavut, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwj
 * JD-Core Version:    0.7.0.1
 */