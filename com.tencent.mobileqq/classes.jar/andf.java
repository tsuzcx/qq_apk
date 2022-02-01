import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class andf
  extends andg
{
  public andf(int paramInt, andi paramandi, ande paramande)
  {
    super(paramInt, paramandi, paramande);
  }
  
  public andf(int paramInt, String paramString, andi paramandi, ande paramande)
  {
    super(paramInt, paramString, paramandi, paramande);
  }
  
  private amqr a(String paramString, ApolloRender paramApolloRender)
  {
    try
    {
      paramString = new JSONObject(paramString);
      float f1 = (float)paramString.optDouble("x");
      float f2 = (float)paramString.optDouble("y");
      float f3 = (float)paramString.optDouble("w");
      float f4 = (float)paramString.optDouble("h");
      float f5 = (float)paramString.optDouble("bX");
      float f6 = (float)paramString.optDouble("bY");
      float f7 = (float)paramString.optDouble("bW");
      float f8 = (float)paramString.optDouble("bH");
      float f9 = (float)paramString.optDouble("gX");
      float f10 = (float)paramString.optDouble("gY");
      float f11 = (float)paramString.optDouble("gW");
      float f12 = (float)paramString.optDouble("gH");
      ApolloRender.AABBCallback(f1, f2, f3, f4, paramString.optString("name"), paramString.optString("extendString"), f5, f6, f7, f8, f9, f10, f11, f12, paramString.optInt("dispose"));
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleBoundingListUpdate exception = " + paramString.toString());
      }
    }
  }
  
  private amqr b()
  {
    amqr localamqr = new amqr();
    localamqr.jdField_b_of_type_Boolean = true;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      QQAppInterface localQQAppInterface = ApolloUtil.a();
      if (localQQAppInterface != null)
      {
        localJSONObject.put("is3DBetaTester", anck.a(localQQAppInterface));
        localamqr.jdField_a_of_type_JavaLangString = localJSONObject.toString();
      }
      return localamqr;
    }
    catch (Exception localException)
    {
      QLog.e("CmShow_SpriteActionScript", 1, localException, new Object[0]);
    }
    return localamqr;
  }
  
  private amqr d(String paramString)
  {
    try
    {
      QLog.d("CmShow_SpriteActionScript", 1, new Object[] { "handleJsError mSpriteFrom:", Integer.valueOf(this.jdField_a_of_type_Andi.e) });
      paramString = new JSONObject(paramString).optString("data");
      anis.a(anck.b(this.jdField_a_of_type_Andi.e), 1000, 50, new Object[] { paramString });
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleJsError:", paramString);
      }
    }
  }
  
  private amqr e(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Andi == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      anis.a(paramString.optInt("featureId"), paramString.optString("receiveUin"));
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceBegin:", paramString);
    }
    return null;
  }
  
  private amqr f(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Andi == null) {
        return null;
      }
      int i = new JSONObject(paramString).optInt("featureId");
      if ((i == anck.b(1)) || (i == anck.b(2))) {
        anis.a(i, null, new int[] { anir.a(i, false, this.jdField_a_of_type_Andi.jdField_b_of_type_Int, -1, true) });
      }
      anis.b(i);
      if ((i == anck.b(1)) || (i == anck.b(2)))
      {
        anis.a(anck.b(this.jdField_a_of_type_Andi.e), false);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceEnd:", paramString);
    }
    return null;
  }
  
  private amqr g(String paramString)
  {
    long l2 = 0L;
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_Andi == null) {
        return null;
      }
      Object localObject = new JSONObject(paramString);
      int k = ((JSONObject)localObject).optInt("featureId");
      int m = ((JSONObject)localObject).optInt("spanId");
      paramString = ((JSONObject)localObject).optString("msg");
      long l3 = ((JSONObject)localObject).optLong("timestamp");
      localObject = ((JSONObject)localObject).optString("spanDesc");
      long l1 = l2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int j = ApolloUtil.g(m);
        i = j;
        l1 = l2;
        if (j > 0)
        {
          l1 = ApolloUtil.b((String)localObject);
          i = j;
        }
      }
      anis.a(k, null, m, -100, l3, i, l1, new Object[] { paramString });
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceSpanBegin:", paramString);
    }
    return null;
  }
  
  private amqr h(String paramString)
  {
    long l2 = 0L;
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_Andi == null) {
        return null;
      }
      Object localObject = new JSONObject(paramString);
      int k = ((JSONObject)localObject).optInt("featureId");
      int m = ((JSONObject)localObject).optInt("spanId");
      int n = ((JSONObject)localObject).optInt("errCode");
      paramString = ((JSONObject)localObject).optString("msg");
      long l3 = ((JSONObject)localObject).optLong("timestamp");
      localObject = ((JSONObject)localObject).optString("spanDesc");
      long l1 = l2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int j = ApolloUtil.g(m);
        i = j;
        l1 = l2;
        if (j > 0)
        {
          l1 = ApolloUtil.b((String)localObject);
          i = j;
        }
      }
      anis.a(k, null, m, n, l3, i, l1, new Object[] { paramString });
      if ((n == 57) && (!c()))
      {
        f();
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceSpanEnd:", paramString);
    }
    return null;
  }
  
  private amqr i(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Andi == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("featureId");
      int j = paramString.optInt("spanId");
      String str = paramString.optString("msg");
      anis.a(i, j, -100, paramString.optLong("timestamp"), new Object[] { str });
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceLog:", paramString);
    }
    return null;
  }
  
  private amqr j(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Andi.e != 0) {
        return null;
      }
      ApolloUtil.c(new JSONObject(paramString).optString("text"));
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private amqr k(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("uinList");
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        a(paramString.optString(i), true);
        i += 1;
      }
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
  }
  
  private amqr l(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Andi.e != 0) {
        return null;
      }
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("status");
      int j = paramString.optInt("whiteHeight");
      if (QLog.isColorLevel())
      {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[handleSpriteStatus], status:", Integer.valueOf(i), ",whiteHeight:", Integer.valueOf(j) });
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private amqr m(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Andi.e != 0) {
        return null;
      }
      new JSONObject(paramString).optInt("status");
      paramString = this.jdField_a_of_type_Ande;
      if (paramString != null) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private amqr n(String paramString)
  {
    int i;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      i = paramString.optInt("taskId");
      j = paramString.optInt("status");
      paramString = paramString.optString("uin");
      if (!QLog.isColorLevel()) {
        break label137;
      }
      QLog.d("CmShow_SpriteActionScript.callback", 2, new Object[] { "taskId:", Integer.valueOf(i), ",status:", Integer.valueOf(j) });
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
      break label164;
    }
    if (this.jdField_a_of_type_Ancl != null)
    {
      this.jdField_a_of_type_Ancl.a(paramString, i);
      break label164;
      if (this.jdField_a_of_type_Ancl != null)
      {
        this.jdField_a_of_type_Ancl.a(paramString, i, j);
        break label164;
        label137:
        switch (j)
        {
        }
      }
    }
    label164:
    return null;
  }
  
  private amqr o(String paramString)
  {
    label124:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        JSONObject localJSONObject = new JSONObject();
        if ("pet".equals(paramString.getString("config_name")))
        {
          paramString = new JSONArray();
          Object localObject = ApolloUtil.a();
          if (localObject != null)
          {
            localObject = (amme)((QQAppInterface)localObject).getManager(QQManagerFactory.APOLLO_MANAGER);
            if (((amme)localObject).f == null) {
              break label124;
            }
            paramString = new JSONArray(((amme)localObject).f);
            localJSONObject.put("petConfig", paramString);
            paramString = new amqr();
            paramString.jdField_b_of_type_Boolean = true;
            paramString.jdField_a_of_type_JavaLangString = localJSONObject.toString();
            return paramString;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleGetLocalData error:", paramString);
      }
      return null;
    }
  }
  
  private amqr p(String paramString)
  {
    int i = 0;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      j = paramString.optInt("from");
      if (!QLog.isColorLevel()) {
        break label181;
      }
      QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "handlePlayAction from:", Integer.valueOf(j) });
    }
    catch (JSONException paramString)
    {
      label71:
      Object localObject;
      paramString.printStackTrace();
      return null;
    }
    paramString = this.jdField_a_of_type_Andi.a();
    if (paramString != null)
    {
      paramString.a();
      return null;
      if (j == 0)
      {
        paramString = paramString.optString("uinList");
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new JSONArray(paramString);
          paramString = new ArrayList();
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject).length())
      {
        String str = ((JSONArray)localObject).optString(i);
        if (!TextUtils.isEmpty(str)) {
          paramString.add(str);
        }
      }
      else
      {
        if (paramString.size() != 0)
        {
          localObject = anck.a(ApolloUtil.a());
          if (localObject != null)
          {
            ((ancd)localObject).a(paramString);
            return null;
            label181:
            if (j == 1) {
              break;
            }
            if (j != 2) {
              break label71;
            }
            break;
          }
        }
        return null;
      }
      i += 1;
    }
  }
  
  private amqr q(String paramString)
  {
    int i = 0;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      j = paramString.optInt("from");
      if (j != 0) {
        break label177;
      }
      localObject = paramString.optString("url");
      if ((this.jdField_a_of_type_Andi == null) || (this.jdField_a_of_type_Andi.a() == null))
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleOnApolloClick mSpriteContent is nil");
        return null;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label122;
      }
      if (this.jdField_a_of_type_Andi.a().getActivity() == null)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleOnApolloClick activity is nil");
        return null;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "Exception:", paramString);
      return null;
    }
    ApolloUtil.a(this.jdField_a_of_type_Andi.a().getActivity(), (String)localObject);
    return null;
    label122:
    paramString = paramString.optString("gameId");
    if (!TextUtils.isEmpty(paramString)) {
      i = Integer.parseInt(paramString);
    }
    if (i > 0)
    {
      ApolloGameUtil.a(this.jdField_a_of_type_Andi.a(), i, 333002, "message", 1);
      return null;
    }
    QLog.e("CmShow_SpriteActionScript", 1, "handleOnApolloClick gameStr is nil");
    return null;
    label177:
    i = paramString.optInt("apolloStatus");
    int k = paramString.optInt("clickPart");
    paramString = paramString.optString("apolloId");
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "handleOnApolloClick", ",from:", Integer.valueOf(j), ",apolloStatus:", Integer.valueOf(i), ",clickPart:", Integer.valueOf(k), "apolloId:", paramString });
    }
    Object localObject = this.jdField_a_of_type_Andi.a();
    if (localObject != null) {
      ((ancn)localObject).a(i, k, paramString);
    }
    return null;
  }
  
  public amqr a()
  {
    amqr localamqr;
    label247:
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = ApolloUtil.a();
        if (localQQAppInterface == null) {
          return null;
        }
        localamqr = new amqr();
        localamqr.jdField_b_of_type_Boolean = true;
        JSONObject localJSONObject = new JSONObject();
        if ((1 == localQQAppInterface.getALLGeneralSettingRing()) && (((this.jdField_a_of_type_Andi.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Andi.jdField_a_of_type_Int != 3000)) || (((1 == localQQAppInterface.getTroopGeneralSettingRing()) || (this.jdField_a_of_type_Andi.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Andi.jdField_a_of_type_Int == -2)) && (!localQQAppInterface.isRingerVibrate()) && (!localQQAppInterface.isRingEqualsZero()) && (localQQAppInterface.isCallIdle()) && (!MediaPlayerManager.a(localQQAppInterface).a()) && ((localQQAppInterface.getCheckPttListener() == null) || (!localQQAppInterface.getCheckPttListener().isRecordingOrPlaying())) && (!localQQAppInterface.isVideoChatting()))))
        {
          if (localQQAppInterface.getCheckPtvListener() == null) {
            break label247;
          }
          if (!localQQAppInterface.getCheckPtvListener().isPTVRecording())
          {
            break label247;
            localJSONObject.put("isAllowed", i);
            localamqr.jdField_a_of_type_JavaLangString = localJSONObject.toString();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "isAllowPlayAudio:", Integer.valueOf(i) });
            break;
          }
        }
        anck.b(localQQAppInterface);
        int i = 0;
        continue;
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("CmShow_SpriteActionScript", 1, localThrowable, new Object[0]);
        return null;
      }
    }
    return localamqr;
  }
  
  public amqr a(long paramLong, String paramString1, String paramString2)
  {
    ampv localampv = a();
    if ((localampv == null) || (localampv.getLuaState() != paramLong)) {}
    do
    {
      do
      {
        return null;
        if ((!paramString1.startsWith("apollo_")) || (paramString1.startsWith("cs.")) || (paramString1.endsWith(".local")) || (amqp.a(paramString1))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CmShow_SpriteActionScript", 2, "ssoCmdRule, [aio],cmd:" + paramString1);
      return null;
      if ("cs.script_action_status_notify.local".equals(paramString1)) {
        return n(paramString2);
      }
      if ("cs.script_change_panel_status.local".equals(paramString1)) {
        return m(paramString2);
      }
      if ("cs.script_get_dress_data.local".equals(paramString1)) {
        return k(paramString2);
      }
      if ("cs.script_sprite_status_change.local".equals(paramString1)) {
        return l(paramString2);
      }
      if ("cs.script_get_show_action.local".equals(paramString1)) {
        return a(paramString2);
      }
      if ("cs.script_is_allow_play_audio.local".equals(paramString1)) {
        return a();
      }
      if ("cs.script_show_barrage.local".equals(paramString1)) {
        return b(paramString2);
      }
      if ("cs.script_send_action_msg.local".equals(paramString1)) {
        return c(paramString2);
      }
      if ("cs.script_show_toast.local".equals(paramString1)) {
        return j(paramString2);
      }
      if ("cs.script_get_config.local".equals(paramString1)) {
        return o(paramString2);
      }
      if ("cs.script_play_action.local".equals(paramString1)) {
        return p(paramString2);
      }
      if ("cs.script_action_apollo_click.local".equals(paramString1)) {
        return q(paramString2);
      }
      if ("cs.script_update_boundinglist.local".equals(paramString1)) {
        return a(paramString2, localampv.getRenderImpl().a());
      }
      if ("cs.get_cm3D_state.local".equals(paramString1)) {
        return b();
      }
      if ("cs.trace_begin.local".equals(paramString1)) {
        return e(paramString2);
      }
      if ("cs.trace_end.local".equals(paramString1)) {
        return f(paramString2);
      }
      if ("cs.trace_span_begin.local".equals(paramString1)) {
        return g(paramString2);
      }
      if ("cs.trace_span_end.local".equals(paramString1)) {
        return h(paramString2);
      }
      if ("cs.trace_log.local".equals(paramString1)) {
        return i(paramString2);
      }
    } while (("cs.script_sprite_model_change_notify.local".equals(paramString1)) || (!"cs.xy_error_info.local".equals(paramString1)));
    return d(paramString2);
  }
  
  public amqr a(String paramString)
  {
    amqr localamqr;
    JSONObject localJSONObject1;
    try
    {
      if (this.jdField_a_of_type_Andi.e != 0) {
        return null;
      }
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray1 = new JSONArray(paramString.optString("uinList"));
      JSONArray localJSONArray2 = new JSONArray();
      localamqr = new amqr();
      localamqr.jdField_b_of_type_Boolean = true;
      localJSONObject1 = new JSONObject();
      int j = paramString.optInt("type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[handleGetShowAction] type:", Integer.valueOf(j) });
      }
      ando localando = this.jdField_a_of_type_Ande.a();
      if (localando != null)
      {
        int i = 0;
        if (i < localJSONArray1.length())
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject = localJSONArray1.optString(i);
          localJSONObject2.put("uin", localObject);
          if (j == 1) {
            localJSONObject2.put("petPath", localando.a(new JSONArray(paramString.optString("actionList"))));
          }
          for (;;)
          {
            localJSONArray2.put(localJSONObject2);
            i += 1;
            break;
            localObject = localando.a((String)localObject);
            localJSONObject2.put("path", ((Pair)localObject).first);
            localJSONObject2.put("actionType", ((Pair)localObject).second);
          }
        }
      }
      localJSONObject1.put("path", localJSONArray2);
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localamqr.jdField_a_of_type_JavaLangString = localJSONObject1.toString();
    return localamqr;
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[notifyUsrOperation], status:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("status", paramInt);
      ApolloUtil.a().callbackFromRequest(this.jdField_a_of_type_Andi.a().getLuaState(), 0, "sc.script_notify_user_operation.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    int i = 2;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[init], width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2), ",vHeight:", Integer.valueOf(paramInt3), ",aioType:", Integer.valueOf(paramInt4), "friendUin:", paramString, ",spriteFrom:", Integer.valueOf(paramInt5) });
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Andi == null) {
          return;
        }
        Object localObject = ApolloUtil.a();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("platform", "android");
        if (!this.jdField_a_of_type_Andi.jdField_b_of_type_Boolean) {
          break label890;
        }
        localJSONObject.put("panelStatus", i);
        if (localObject != null)
        {
          localJSONObject.put("phoneModel", anmi.jdField_a_of_type_JavaLangString);
          localJSONObject.put("osVersion", anmi.jdField_b_of_type_JavaLangString);
          localJSONObject.put("cpuType", anmi.jdField_c_of_type_JavaLangString);
          localJSONObject.put("cpuNumber", anmi.jdField_a_of_type_Int);
          localJSONObject.put("cpuFrequency", anmi.jdField_a_of_type_Long);
          localJSONObject.put("freeMemory", ((anmi)localObject).d);
          localJSONObject.put("totalMemory", ((anmi)localObject).jdField_c_of_type_Long);
          localJSONObject.put("maxMemory", ((anmi)localObject).jdField_b_of_type_Long);
        }
        localJSONObject.put("aioType", ApolloGameUtil.a(ApolloUtil.a(), paramInt4, this.jdField_a_of_type_Andi.jdField_a_of_type_JavaLangString));
        localJSONObject.put("friendUin", paramString);
        localJSONObject.put("width", paramInt1);
        localJSONObject.put("height", paramInt2);
        localJSONObject.put("vHeight", paramInt3);
        localJSONObject.put("screenW", DeviceInfoUtil.getPortraitWidth());
        localJSONObject.put("screenH", DeviceInfoUtil.getPortraitHeight());
        localJSONObject.put("qqVer", "8.4.10");
        localJSONObject.put("uin", this.jdField_a_of_type_Andi.jdField_b_of_type_JavaLangString);
        localJSONObject.put("density", DeviceInfoUtil.density);
        localJSONObject.put("wait", "def/basic/action/1/action/action");
        localJSONObject.put("standup", "def/basic/action/4/action/action");
        localJSONObject.put("think", "def/basic/action/3/action/action");
        localJSONObject.put("sitdown", "def/basic/action/2/action/action");
        localJSONObject.put("isHide", 0);
        a(localJSONObject, paramInt5);
        paramString = new JSONArray();
        localObject = new int[7];
        Object tmp482_480 = localObject;
        tmp482_480[0] = 1;
        Object tmp486_482 = tmp482_480;
        tmp486_482[1] = 2;
        Object tmp490_486 = tmp486_482;
        tmp490_486[2] = 3;
        Object tmp494_490 = tmp490_486;
        tmp494_490[3] = 4;
        Object tmp498_494 = tmp494_490;
        tmp498_494[4] = 5;
        Object tmp502_498 = tmp498_494;
        tmp502_498[5] = 6;
        Object tmp507_502 = tmp502_498;
        tmp507_502[6] = 7;
        tmp507_502;
        paramInt4 = localObject.length;
        paramInt2 = 0;
        if (paramInt2 < paramInt4)
        {
          paramString.put(anhm.a(1, Integer.valueOf(localObject[paramInt2]).intValue()));
          paramInt2 += 1;
          continue;
        }
        localJSONObject.put("defDress", paramString);
        localJSONObject.put("defRole", anhm.a(0, 0));
        localJSONObject.put("from", paramInt5);
        localJSONObject.put("traceFeatureId", this.jdField_a_of_type_Andi.a());
        paramString = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/shader_code/");
        if (!paramString.isDirectory()) {
          break label865;
        }
        paramString = paramString.listFiles();
        if ((paramString != null) && (paramString.length > 0))
        {
          localObject = new JSONArray();
          paramInt2 = j;
          if (paramInt2 < paramString.length)
          {
            ((JSONArray)localObject).put(paramString[paramInt2].getName());
            if (!QLog.isColorLevel()) {
              break label896;
            }
            QLog.i("CmShow_SpriteActionScript", 2, "init shaderCode name:" + paramString[paramInt2].getName());
            break label896;
          }
          localJSONObject.put("shaderCodes", localObject);
          if (QLog.isColorLevel()) {
            QLog.i("CmShow_SpriteActionScript", 1, "commonInit shaderCodes jsonArray:" + localObject);
          }
          paramString = new StringBuilder();
          paramString.append("if(commonInit){commonInit('").append(localJSONObject.toString()).append("');}");
          QLog.d("CmShow_SpriteActionScript", 1, "sava TraceReport CmShowStatUtil commitJS:(commonInit)");
          if ((paramInt1 != 0) && (paramInt3 != 0)) {
            break label877;
          }
          a(paramString.toString(), 0, true);
          if (!QLog.isColorLevel()) {
            break label889;
          }
          QLog.d("CmShow_SpriteActionScript", 2, localJSONObject.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "[getCommonInit], errInfo->", paramString);
        return;
      }
      QLog.i("CmShow_SpriteActionScript", 1, "commonInit shaderCodes file no exist");
      continue;
      label865:
      QLog.i("CmShow_SpriteActionScript", 1, "commonInit shaderCodes dir no exist");
      continue;
      label877:
      a(paramString.toString());
      continue;
      label889:
      return;
      label890:
      i = 1;
      continue;
      label896:
      paramInt2 += 1;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[notifySpriteClicked], clickPart:", Integer.valueOf(paramInt), ",url:", paramString1 });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("clickPart", paramInt);
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("url", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("apolloId", paramString2);
      }
      paramString1 = ApolloUtil.a();
      if (paramString1 != null)
      {
        ApolloCmdChannel.getChannel(paramString1).callbackFromRequest(this.jdField_a_of_type_Andi.a().getLuaState(), 0, "sc.script_on_sprite_single_clicked.local", localJSONObject.toString());
        return;
      }
      paramString1 = ApolloUtil.a();
      if (paramString1 != null)
      {
        ApolloCmdChannel.getChannelFromOtherProcess(paramString1).callbackFromRequest(this.jdField_a_of_type_Andi.a().getLuaState(), 0, "sc.script_on_sprite_single_clicked.local", localJSONObject.toString());
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "[notifySpriteClicked],", paramString1);
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2;
    try
    {
      localObject2 = new File(anka.jdField_a_of_type_JavaLangString + "/def/role/0/3D");
      localObject1 = new File(anka.jdField_a_of_type_JavaLangString + "/def/role/0/3D/3DConfig.json");
      if (!((File)localObject2).exists())
      {
        QLog.w("CmShow_SpriteActionScript", 1, "3D dir NOT exist.");
        return;
      }
      if (!((File)localObject1).exists())
      {
        QLog.w("CmShow_SpriteActionScript", 1, "3DConfig NOT exist.");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramJSONObject, new Object[0]);
      return;
    }
    Object localObject1 = new JSONObject();
    if (new File((File)localObject2, "1/action.bin").exists()) {
      ((JSONObject)localObject1).put("wait", "def/role/0/3D/" + "1");
    }
    if (new File((File)localObject2, "4/action.bin").exists()) {
      ((JSONObject)localObject1).put("standup", "def/role/0/3D/" + "4");
    }
    if (new File((File)localObject2, "3/action.bin").exists()) {
      ((JSONObject)localObject1).put("think", "def/role/0/3D/" + "3");
    }
    if (new File((File)localObject2, "2/action.bin").exists()) {
      ((JSONObject)localObject1).put("sitdown", "def/role/0/3D/" + "2");
    }
    if (new File((File)localObject2, "android/skeleton/skeleton.bin").exists()) {
      ((JSONObject)localObject1).put("defRole", "def/role/0/3D/" + "android/skeleton");
    }
    if (new File((File)localObject2, "transformAction/3to2/action.bin").exists()) {
      ((JSONObject)localObject1).put("3to2DAction", "def/role/0/3D/" + "transformAction/3to2");
    }
    if ((new File((File)localObject2, "transformAction/2to3/action.atlas").exists()) && (new File((File)localObject2, "transformAction/2to3/action.png").exists()) && (new File((File)localObject2, "transformAction/2to3/action.json").exists())) {
      ((JSONObject)localObject1).put("2to3DAction", "def/role/0/3D/" + "transformAction/2to3");
    }
    if ((paramInt == 2) && (new File((File)localObject2, "friendcard/1/action.bin").exists()))
    {
      ((JSONObject)localObject1).put("friendcard_up", "def/role/0/3D/" + "friendcard/1");
      ((JSONObject)localObject1).put("friendcard_down", "def/role/0/3D/" + "friendcard/2");
    }
    if (new File((File)localObject2, "sayhi/1/action.bin").exists()) {
      ((JSONObject)localObject1).put("sayhi", "def/role/0/3D/" + "sayhi/1");
    }
    if (new File((File)localObject2, "bubble").exists()) {
      ((JSONObject)localObject1).put("bubble", "def/role/0/3D/" + "bubble");
    }
    Object localObject3 = new File((File)localObject2, "android/dress");
    int i;
    if (((File)localObject3).exists())
    {
      localObject2 = new JSONArray();
      localObject3 = ((File)localObject3).listFiles();
      i = localObject3.length;
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < i)
      {
        Object localObject4 = localObject3[paramInt];
        if ((localObject4 != null) && (localObject4.exists()) && (localObject4.isDirectory())) {
          ((JSONArray)localObject2).put("def/role/0/3D/" + "android/dress/" + localObject4.getName());
        }
      }
      else
      {
        ((JSONObject)localObject1).put("defDress", localObject2);
        paramJSONObject.put("3DObject", localObject1);
        return;
      }
      paramInt += 1;
    }
  }
  
  public amqr b(String paramString)
  {
    ampv localampv;
    try
    {
      localampv = a();
      if (localampv == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      if (1 == paramString.optInt("isShow"))
      {
        localampv.bulkApolloBarrages("", new String(bhcu.decode(paramString.optString("text").getBytes("utf-8"), 0)), true);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localampv.removeAllApolloBarrages(true);
    return null;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Andi != null) && (this.jdField_a_of_type_Andi.a() != null)) {
      a(this.jdField_a_of_type_Andi.a().getRenderWidth(), this.jdField_a_of_type_Andi.a().getInitHeight(), this.jdField_a_of_type_Andi.a().getRenderHeight(), this.jdField_a_of_type_Andi.jdField_a_of_type_Int, this.jdField_a_of_type_Andi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Andi.e);
    }
  }
  
  public amqr c(String paramString)
  {
    try
    {
      int i = this.jdField_a_of_type_Andi.e;
      if (i != 0) {}
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andf
 * JD-Core Version:    0.7.0.1
 */