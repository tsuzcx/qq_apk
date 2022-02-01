import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/intervideo/now/webplugin/AudioRoomSettingHandler;", "", "()V", "ACT_GET_TMP_MSG_PUSH_SETTING", "", "ACT_SET_TMP_MSG_PUSH_SETTING", "TAG", "", "handleGetTmpMsgPushSetting", "", "plugin", "Lcom/tencent/mobileqq/intervideo/now/NowWebViewPlugin;", "reqJson", "Lorg/json/JSONObject;", "callback", "handleRequest", "args", "", "(Lcom/tencent/mobileqq/intervideo/now/NowWebViewPlugin;[Ljava/lang/String;)V", "handleSetTmpMsgPushSetting", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class auqo
{
  public static final auqo a = new auqo();
  
  private final void a(auoy paramauoy, JSONObject paramJSONObject, String paramString)
  {
    paramauoy.a().a((short)-23161, (zop)new auqp(paramauoy, paramString));
  }
  
  @JvmStatic
  public static final void a(@NotNull auoy paramauoy, @NotNull String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramauoy, "plugin");
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
      catch (Exception paramauoy)
      {
        QLog.w("AudioRoomSettingHandler", 1, "handleRequest catch: " + paramauoy);
        return;
      }
      auqo localauqo = a;
      Intrinsics.checkExpressionValueIsNotNull(str, "callback");
      localauqo.a(paramauoy, paramArrayOfString, str);
      return;
      localauqo = a;
      Intrinsics.checkExpressionValueIsNotNull(str, "callback");
      localauqo.b(paramauoy, paramArrayOfString, str);
      return;
    }
  }
  
  private final void b(auoy paramauoy, JSONObject paramJSONObject, String paramString)
  {
    boolean bool = false;
    int i = paramJSONObject.optInt("pushSwitch", -1);
    QLog.i("AudioRoomSettingHandler", 1, "handleSetTmpMsgPushSetting request: toStatus=" + i);
    if ((i != 0) && (i != 1))
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", "fail");
      paramauoy.callJs(paramString, new String[] { paramJSONObject.toString() });
      return;
    }
    paramJSONObject = paramauoy.a();
    if (i == 1) {
      bool = true;
    }
    paramJSONObject.a((short)-23161, bool, (zop)new auqq(i, paramauoy, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqo
 * JD-Core Version:    0.7.0.1
 */