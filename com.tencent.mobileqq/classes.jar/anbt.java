import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anbt
  extends anbu
{
  public anbt(int paramInt, ancc paramancc)
  {
    super(paramInt, paramancc);
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
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleBoundingListUpdate exception = " + paramString.toString());
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[init], width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2), ",vHeight:", Integer.valueOf(paramInt3), ",aioType:", Integer.valueOf(paramInt4), "friendUin:", paramString, ",spriteFrom:", Integer.valueOf(paramInt5), ", isBubbleMeme:", Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Ancc == null) {
          return;
        }
        Object localObject1 = this.jdField_a_of_type_Ancc.a();
        if (localObject1 == null) {
          break label1009;
        }
        Object localObject2 = ApolloUtil.a();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("platform", "android");
        if (!this.jdField_a_of_type_Ancc.jdField_b_of_type_Boolean) {
          break label1010;
        }
        i = 2;
        localJSONObject.put("panelStatus", i);
        if (localObject2 != null)
        {
          localJSONObject.put("phoneModel", anmi.jdField_a_of_type_JavaLangString);
          localJSONObject.put("osVersion", anmi.jdField_b_of_type_JavaLangString);
          localJSONObject.put("cpuType", anmi.jdField_c_of_type_JavaLangString);
          localJSONObject.put("cpuNumber", anmi.jdField_a_of_type_Int);
          localJSONObject.put("cpuFrequency", anmi.jdField_a_of_type_Long);
          localJSONObject.put("freeMemory", ((anmi)localObject2).d);
          localJSONObject.put("totalMemory", ((anmi)localObject2).jdField_c_of_type_Long);
          localJSONObject.put("maxMemory", ((anmi)localObject2).jdField_b_of_type_Long);
        }
        localJSONObject.put("aioType", ApolloGameUtil.a((AppInterface)localObject1, paramInt4, this.jdField_a_of_type_Ancc.jdField_a_of_type_JavaLangString));
        localJSONObject.put("friendUin", paramString);
        localJSONObject.put("width", paramInt1);
        localJSONObject.put("height", paramInt2);
        localJSONObject.put("vHeight", paramInt3);
        localJSONObject.put("screenW", DeviceInfoUtil.getPortraitWidth());
        localJSONObject.put("screenH", DeviceInfoUtil.getPortraitHeight());
        localJSONObject.put("qqVer", "8.4.10");
        localJSONObject.put("uin", this.jdField_a_of_type_Ancc.jdField_b_of_type_JavaLangString);
        localJSONObject.put("density", DeviceInfoUtil.density);
        localJSONObject.put("wait", "def/basic/action/1/action/action");
        localJSONObject.put("standup", "def/basic/action/4/action/action");
        localJSONObject.put("think", "def/basic/action/3/action/action");
        localJSONObject.put("sitdown", "def/basic/action/2/action/action");
        if (!anck.a((QQAppInterface)localObject1)) {
          break label1016;
        }
        paramInt2 = 1;
        localJSONObject.put("isHide", paramInt2);
        localJSONObject.put("isBubbleMeme", paramBoolean);
        a(localJSONObject, paramInt5);
        paramString = new JSONArray();
        localObject2 = new int[7];
        Object tmp495_493 = localObject2;
        tmp495_493[0] = 1;
        Object tmp499_495 = tmp495_493;
        tmp499_495[1] = 2;
        Object tmp503_499 = tmp499_495;
        tmp503_499[2] = 3;
        Object tmp507_503 = tmp503_499;
        tmp507_503[3] = 4;
        Object tmp511_507 = tmp507_503;
        tmp511_507[4] = 5;
        Object tmp515_511 = tmp511_507;
        tmp515_511[5] = 6;
        Object tmp520_515 = tmp515_511;
        tmp520_515[6] = 7;
        tmp520_515;
        paramInt4 = localObject2.length;
        paramInt2 = 0;
        if (paramInt2 < paramInt4)
        {
          paramString.put(anhm.a(1, Integer.valueOf(localObject2[paramInt2]).intValue()));
          paramInt2 += 1;
          continue;
        }
        localJSONObject.put("defDress", paramString);
        localJSONObject.put("defRole", anhm.a(0, 0));
        localJSONObject.put("from", paramInt5);
        if ((anhm.a((QQAppInterface)localObject1)) && ((paramInt5 == 1) || (paramInt5 == 2)))
        {
          localJSONObject.put("drawer_up", "def/role/0/drawer/1/action/action");
          localJSONObject.put("drawer_down", "def/role/0/drawer/2/action/action");
          localJSONObject.put("friendcard_up", "def/role/0/friendcard/1/action/action");
          localJSONObject.put("friendcard_down", "def/role/0/friendcard/2/action/action");
          localJSONObject.put("drawer_pet_up", "def/role/0/drawer/3/action/action");
          localJSONObject.put("drawer_pet_down", "def/role/0/drawer/4/action/action");
          paramString = (amme)((QQAppInterface)localObject1).getManager(QQManagerFactory.APOLLO_MANAGER);
          if (paramString != null) {
            localJSONObject.put("drawerGameBoxUser", paramString.e);
          }
        }
        paramString = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/shader_code/");
        if (!paramString.isDirectory()) {
          break label985;
        }
        paramString = paramString.listFiles();
        if ((paramString != null) && (paramString.length > 0))
        {
          localObject1 = new JSONArray();
          paramInt2 = 0;
          if (paramInt2 < paramString.length)
          {
            ((JSONArray)localObject1).put(paramString[paramInt2].getName());
            if (!QLog.isColorLevel()) {
              break label1021;
            }
            QLog.i("cmshow_scripted_SpriteActionScript", 2, "init shaderCode name:" + paramString[paramInt2].getName());
            break label1021;
          }
          localJSONObject.put("shaderCodes", localObject1);
          if (QLog.isColorLevel()) {
            QLog.i("cmshow_scripted_SpriteActionScript", 1, "commonInit shaderCodes jsonArray:" + localObject1);
          }
          paramString = new StringBuilder();
          paramString.append("if(commonInit){commonInit('").append(localJSONObject.toString()).append("');}");
          QLog.d("cmshow_scripted_SpriteActionScript", 1, "sava TraceReport CmShowStatUtil commitJS:(commonInit)");
          if ((paramInt1 != 0) && (paramInt3 != 0)) {
            break label997;
          }
          a(paramString.toString(), 0, true);
          if (!QLog.isColorLevel()) {
            break label1009;
          }
          QLog.d("cmshow_scripted_SpriteActionScript", 2, localJSONObject.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "[getCommonInit], errInfo->", paramString);
        return;
      }
      QLog.i("cmshow_scripted_SpriteActionScript", 1, "commonInit shaderCodes file no exist");
      continue;
      label985:
      QLog.i("cmshow_scripted_SpriteActionScript", 1, "commonInit shaderCodes dir no exist");
      continue;
      label997:
      a(paramString.toString());
      continue;
      label1009:
      return;
      label1010:
      int i = 1;
      continue;
      label1016:
      paramInt2 = 0;
      continue;
      label1021:
      paramInt2 += 1;
    }
  }
  
  private amqr b()
  {
    amqr localamqr = new amqr();
    localamqr.jdField_b_of_type_Boolean = true;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("is3DBetaTester", anck.a(this.jdField_a_of_type_Ancc.a()));
      localamqr.jdField_a_of_type_JavaLangString = localJSONObject.toString();
      return localamqr;
    }
    catch (Exception localException)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, localException, new Object[0]);
    }
    return localamqr;
  }
  
  private amqr d(String paramString)
  {
    try
    {
      QLog.d("cmshow_scripted_SpriteActionScript", 1, new Object[] { "handleJsError mSpriteFrom:", Integer.valueOf(this.jdField_a_of_type_Ancc.e) });
      paramString = new JSONObject(paramString).optString("data");
      anis.a(anck.b(this.jdField_a_of_type_Ancc.e), 1000, 50, new Object[] { paramString });
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleJsError:", paramString);
      }
    }
  }
  
  private amqr e(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Ancc == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      anis.a(paramString.optInt("featureId"), paramString.optString("receiveUin"));
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleTraceBegin:", paramString);
    }
    return null;
  }
  
  private amqr f(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Ancc == null) {
        return null;
      }
      int i = new JSONObject(paramString).optInt("featureId");
      if ((i == anck.b(1)) || (i == anck.b(2))) {
        anis.a(i, null, new int[] { anir.a(i, false, this.jdField_a_of_type_Ancc.jdField_b_of_type_Int, -1, true) });
      }
      anis.b(i);
      if ((i == anck.b(1)) || (i == anck.b(2)))
      {
        anis.a(anck.b(this.jdField_a_of_type_Ancc.e), false);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleTraceEnd:", paramString);
    }
    return null;
  }
  
  private amqr g(String paramString)
  {
    long l2 = 0L;
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_Ancc == null) {
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
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleTraceSpanBegin:", paramString);
    }
    return null;
  }
  
  private amqr h(String paramString)
  {
    long l2 = 0L;
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_Ancc == null) {
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
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleTraceSpanEnd:", paramString);
    }
    return null;
  }
  
  private amqr i(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Ancc == null) {
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
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleTraceLog:", paramString);
    }
    return null;
  }
  
  private amqr j(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Ancc.e != 0) {
        return null;
      }
      paramString = new JSONObject(paramString).optString("text");
      this.jdField_a_of_type_Anch.a().a(paramString);
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
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
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
    }
  }
  
  private amqr l(String paramString)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        if (this.jdField_a_of_type_Ancc.e != 0) {
          return null;
        }
        paramString = new JSONObject(paramString);
        i = paramString.optInt("status");
        j = paramString.optInt("whiteHeight");
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[handleSpriteStatus], status:", Integer.valueOf(i), ",whiteHeight:", Integer.valueOf(j) });
        }
        if (this.jdField_a_of_type_Ancc.c)
        {
          QLog.i("cmshow_scripted_SpriteActionScript", 1, "[handleSpriteStatus], isBubbleMeme no need margin");
          this.jdField_a_of_type_Anch.a().a(i);
          return null;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
        return null;
      }
      this.jdField_a_of_type_Anch.a().a(i, j);
    }
  }
  
  private amqr m(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Ancc.e != 0) {
        return null;
      }
      int i = new JSONObject(paramString).optInt("status");
      if (this.jdField_a_of_type_Anch != null)
      {
        this.jdField_a_of_type_Anch.a().a(i);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
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
        break label136;
      }
      QLog.d("cmshow_scripted_SpriteActionScript.callback", 2, new Object[] { "taskId:", Integer.valueOf(i), ",status:", Integer.valueOf(j) });
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
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
        label136:
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
    label122:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        JSONObject localJSONObject = new JSONObject();
        if ("pet".equals(paramString.getString("config_name")))
        {
          paramString = new JSONArray();
          amme localamme = (amme)this.jdField_a_of_type_Ancc.a().getManager(QQManagerFactory.APOLLO_MANAGER);
          if (localamme.f == null) {
            break label122;
          }
          paramString = new JSONArray(localamme.f);
          localJSONObject.put("petConfig", paramString);
          paramString = new amqr();
          paramString.jdField_b_of_type_Boolean = true;
          paramString.jdField_a_of_type_JavaLangString = localJSONObject.toString();
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleGetLocalData error:", paramString);
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
        break label183;
      }
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "handlePlayAction from:", Integer.valueOf(j) });
    }
    catch (JSONException paramString)
    {
      label71:
      Object localObject;
      paramString.printStackTrace();
      return null;
    }
    paramString = this.jdField_a_of_type_Ancc.a();
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
          localObject = anck.a(a());
          if (localObject != null)
          {
            ((ancd)localObject).a(paramString);
            return null;
            label183:
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
      if ((this.jdField_a_of_type_Ancc == null) || (this.jdField_a_of_type_Ancc.a() == null))
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleOnApolloClick mSpriteContent is nil");
        return null;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label122;
      }
      if (this.jdField_a_of_type_Ancc.a().getActivity() == null)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleOnApolloClick activity is nil");
        return null;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "Exception:", paramString);
      return null;
    }
    ApolloUtil.a(this.jdField_a_of_type_Ancc.a().getActivity(), (String)localObject);
    return null;
    label122:
    paramString = paramString.optString("gameId");
    if (!TextUtils.isEmpty(paramString)) {
      i = Integer.parseInt(paramString);
    }
    if (i > 0)
    {
      ApolloGameUtil.a(this.jdField_a_of_type_Ancc.a(), i, 333002, "message", 1);
      return null;
    }
    QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleOnApolloClick gameStr is nil");
    return null;
    label177:
    i = paramString.optInt("apolloStatus");
    int k = paramString.optInt("clickPart");
    paramString = paramString.optString("apolloId");
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "handleOnApolloClick", ",from:", Integer.valueOf(j), ",apolloStatus:", Integer.valueOf(i), ",clickPart:", Integer.valueOf(k), "apolloId:", paramString });
    }
    Object localObject = this.jdField_a_of_type_Ancc.a();
    if (localObject != null) {
      ((ancn)localObject).a(i, k, paramString);
    }
    return null;
  }
  
  public amqr a()
  {
    amqr localamqr;
    label248:
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = a();
        if (localQQAppInterface == null) {
          return null;
        }
        localamqr = new amqr();
        localamqr.jdField_b_of_type_Boolean = true;
        JSONObject localJSONObject = new JSONObject();
        if ((1 == localQQAppInterface.getALLGeneralSettingRing()) && (((this.jdField_a_of_type_Ancc.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Ancc.jdField_a_of_type_Int != 3000)) || (((1 == localQQAppInterface.getTroopGeneralSettingRing()) || (this.jdField_a_of_type_Ancc.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Ancc.jdField_a_of_type_Int == -2)) && (!localQQAppInterface.isRingerVibrate()) && (!localQQAppInterface.isRingEqualsZero()) && (localQQAppInterface.isCallIdle()) && (!MediaPlayerManager.a(localQQAppInterface).a()) && ((localQQAppInterface.getCheckPttListener() == null) || (!localQQAppInterface.getCheckPttListener().isRecordingOrPlaying())) && (!localQQAppInterface.isVideoChatting()))))
        {
          if (localQQAppInterface.getCheckPtvListener() == null) {
            break label248;
          }
          if (!localQQAppInterface.getCheckPtvListener().isPTVRecording())
          {
            break label248;
            localJSONObject.put("isAllowed", i);
            localamqr.jdField_a_of_type_JavaLangString = localJSONObject.toString();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "isAllowPlayAudio:", Integer.valueOf(i) });
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
        QLog.e("cmshow_scripted_SpriteActionScript", 1, localThrowable, new Object[0]);
        return null;
      }
    }
    return localamqr;
  }
  
  public amqr a(long paramLong, String paramString1, String paramString2)
  {
    ampv localampv = a();
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {}
    while ((localampv == null) || (localampv.getLuaState() != paramLong)) {
      return null;
    }
    if ((paramString1.startsWith("apollo_")) && (!paramString1.startsWith("cs.")) && (!paramString1.endsWith(".local")) && (!amqp.a(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, "ssoCmdRule, [aio],cmd:" + paramString1);
      }
      ((VasExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(paramString1, paramString2.toString(), paramLong, 4);
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      if ("cs.script_action_status_notify.local".equals(paramString1))
      {
        paramString1 = n(paramString2);
      }
      else if ("cs.script_change_panel_status.local".equals(paramString1))
      {
        paramString1 = m(paramString2);
      }
      else if ("cs.script_get_dress_data.local".equals(paramString1))
      {
        paramString1 = k(paramString2);
      }
      else if ("cs.script_sprite_status_change.local".equals(paramString1))
      {
        paramString1 = l(paramString2);
      }
      else if ("cs.script_get_show_action.local".equals(paramString1))
      {
        paramString1 = a(paramString2);
      }
      else if ("cs.script_is_allow_play_audio.local".equals(paramString1))
      {
        paramString1 = a();
      }
      else if ("cs.script_show_barrage.local".equals(paramString1))
      {
        paramString1 = b(paramString2);
      }
      else if ("cs.script_send_action_msg.local".equals(paramString1))
      {
        paramString1 = c(paramString2);
      }
      else if ("cs.script_show_toast.local".equals(paramString1))
      {
        paramString1 = j(paramString2);
      }
      else if ("cs.script_get_config.local".equals(paramString1))
      {
        paramString1 = o(paramString2);
      }
      else if ("cs.script_play_action.local".equals(paramString1))
      {
        paramString1 = p(paramString2);
      }
      else if ("cs.script_action_apollo_click.local".equals(paramString1))
      {
        paramString1 = q(paramString2);
      }
      else if ("cs.script_update_boundinglist.local".equals(paramString1))
      {
        paramString1 = a(paramString2, localampv.getRenderImpl().a());
      }
      else if ("cs.get_cm3D_state.local".equals(paramString1))
      {
        paramString1 = b();
      }
      else if ("cs.trace_begin.local".equals(paramString1))
      {
        paramString1 = e(paramString2);
      }
      else if ("cs.trace_end.local".equals(paramString1))
      {
        paramString1 = f(paramString2);
      }
      else if ("cs.trace_span_begin.local".equals(paramString1))
      {
        paramString1 = g(paramString2);
      }
      else if ("cs.trace_span_end.local".equals(paramString1))
      {
        paramString1 = h(paramString2);
      }
      else if ("cs.trace_log.local".equals(paramString1))
      {
        paramString1 = i(paramString2);
      }
      else
      {
        if ("cs.script_sprite_model_change_notify.local".equals(paramString1))
        {
          if ((ApolloGameUtil.a(localQQAppInterface) == 2) && (this.jdField_a_of_type_Ancc != null) && (this.jdField_a_of_type_Ancc.e == 0))
          {
            paramString1 = ((ankc)localQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).d(3000059);
            if (paramString1 != null)
            {
              paramString2 = new SpriteTaskParam();
              paramString2.f = paramString1.actionId;
              paramString2.jdField_c_of_type_Int = 0;
              paramString2.g = 3;
              paramString2.e = paramString1.personNum;
              paramString2.jdField_a_of_type_Long = -10000L;
              paramString2.jdField_a_of_type_Boolean = true;
              paramString2.jdField_b_of_type_Boolean = false;
              paramString2.jdField_c_of_type_JavaLangString = paramString1.bubbleText;
              if (this.jdField_a_of_type_Ancc.a() != null)
              {
                paramString2.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Ancc.a().getCurrentAccountUin());
                ((anch)this.jdField_a_of_type_Ancc.a().getManager(QQManagerFactory.SPRITE_SCRIPT_MANAGER)).a().a(paramString2);
              }
            }
            paramString1 = null;
          }
        }
        else if ("cs.xy_error_info.local".equals(paramString1))
        {
          paramString1 = d(paramString2);
          continue;
        }
        paramString1 = null;
      }
    }
  }
  
  public amqr a(String paramString)
  {
    amqr localamqr;
    JSONObject localJSONObject1;
    try
    {
      if (this.jdField_a_of_type_Ancc.e != 0) {
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
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[handleGetShowAction] type:", Integer.valueOf(j) });
      }
      ancd localancd = anck.a(a());
      if (localancd != null)
      {
        int i = 0;
        if (i < localJSONArray1.length())
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject = localJSONArray1.optString(i);
          localJSONObject2.put("uin", localObject);
          if (j == 1) {
            localJSONObject2.put("petPath", localancd.a(new JSONArray(paramString.optString("actionList"))));
          }
          for (;;)
          {
            localJSONArray2.put(localJSONObject2);
            i += 1;
            break;
            localObject = localancd.a((String)localObject);
            localJSONObject2.put("path", ((Pair)localObject).first);
            localJSONObject2.put("actionType", ((Pair)localObject).second);
          }
        }
      }
      localJSONObject1.put("path", localJSONArray2);
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localamqr.jdField_a_of_type_JavaLangString = localJSONObject1.toString();
    return localamqr;
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Ancc.e != 0) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyPanelStatusChanged], status:", Integer.valueOf(paramInt) });
        }
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("status", paramInt);
        ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ancc.a()).callbackFromRequest(this.jdField_a_of_type_Ancc.a().getLuaState(), 0, "sc.script_panel_status_change.local", ((JSONObject)localObject).toString());
        localObject = "";
        if (1 == paramInt)
        {
          localObject = "panel_close_clk";
          VipUtils.a(this.jdField_a_of_type_Ancc.a(), "cmshow", "Apollo", (String)localObject, ApolloUtil.b(this.jdField_a_of_type_Ancc.jdField_a_of_type_Int), ApolloUtil.h(this.jdField_a_of_type_Ancc.jdField_b_of_type_Int), new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifyPanelStatusChanged],", localThrowable);
        return;
      }
      if (2 == paramInt) {
        String str = "panel_open_clk";
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyDrawRectChanged], width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ancc.a()).callbackFromRequest(this.jdField_a_of_type_Ancc.a().getLuaState(), 0, "sc.script_draw_area_change.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifySpriteClicked], clickPart:", Integer.valueOf(paramInt), ",url:", paramString1 });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("clickPart", paramInt);
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("url", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("apolloId", paramString2);
      }
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ancc.a()).callbackFromRequest(this.jdField_a_of_type_Ancc.a().getLuaState(), 0, "sc.script_on_sprite_single_clicked.local", localJSONObject.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteClicked],", paramString1);
    }
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    JSONObject localJSONObject;
    try
    {
      QLog.i("cmshow_scripted_SpriteActionScript", 1, "[notifyStatusOrDressChanged], type:" + paramInt);
      localJSONObject = new JSONObject();
      localJSONObject.put("type", paramInt);
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str)) {
          localJSONArray.put(str);
        }
      }
      localJSONObject.put("uinList", localJSONArray);
    }
    catch (Throwable paramArrayList)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", paramArrayList);
      return;
    }
    ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ancc.a()).callbackFromRequest(this.jdField_a_of_type_Ancc.a().getLuaState(), 0, "sc.script_user_dressOrStatus_changed.local", localJSONObject.toString());
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyScreenSizeChange] screenWidth:", Long.valueOf(paramLong1), ",screenHeight:", Long.valueOf(paramLong2), ",width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2) });
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if ((paramLong1 > 0L) && (paramLong2 > 0L))
      {
        localJSONObject.put("screenWidth", paramLong1);
        localJSONObject.put("screenHeight", paramLong2);
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        localJSONObject.put("width", paramInt1);
        localJSONObject.put("height", paramInt2);
      }
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ancc.a()).callbackFromRequest(this.jdField_a_of_type_Ancc.a().getLuaState(), 0, "sc.script_notify_screen_size_change.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifyScreenSizeChange] ", localThrowable);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Ancc == null) || (this.jdField_a_of_type_Ancc.a() == null) || (!this.jdField_a_of_type_Ancc.c()) || (!this.jdField_a_of_type_Boolean))
    {
      QLog.w("cmshow_scripted_SpriteActionScript", 1, "[notifyDressReady], surfaceView is destroyed. return");
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        int j = paramArrayOfInt.length;
        paramInt2 = 0;
        if (paramInt2 < j)
        {
          ((StringBuilder)localObject).append(Integer.valueOf(paramArrayOfInt[paramInt2])).append(",");
          paramInt2 += 1;
          continue;
        }
        ((StringBuilder)localObject).append("]");
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyDressReady], uin:", paramString, "dress:", localObject });
        }
        localObject = new JSONObject();
        JSONArray localJSONArray1 = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uin", paramString);
        JSONArray localJSONArray2 = new JSONArray();
        j = paramArrayOfInt.length;
        paramInt2 = i;
        if (paramInt2 < j)
        {
          localJSONArray2.put(anhm.a(1, Integer.valueOf(paramArrayOfInt[paramInt2]).intValue()));
          paramInt2 += 1;
          continue;
        }
        anhm.a(paramString, paramQQAppInterface, localJSONObject, null);
        localJSONObject.put("dress", localJSONArray2);
        localJSONObject.put("role", anhm.a(0, paramInt1));
        paramQQAppInterface = this.jdField_a_of_type_Ancc.a();
        if (paramQQAppInterface != null)
        {
          if (!this.jdField_a_of_type_Ancc.c)
          {
            paramArrayOfInt = paramQQAppInterface.a(paramString, this.jdField_a_of_type_Ancc, true);
            paramQQAppInterface = paramArrayOfInt;
            if (paramArrayOfInt == null) {
              paramQQAppInterface = new JSONObject();
            }
            localJSONObject.put("pet", paramQQAppInterface);
            localJSONObject.put("nameplate", ancd.a(this.jdField_a_of_type_Ancc.a(), paramString, paramInt1, true));
          }
          paramQQAppInterface = this.jdField_a_of_type_Ancc.jdField_b_of_type_JavaLangString;
          if ((TextUtils.isEmpty(paramQQAppInterface)) || (!paramQQAppInterface.equals(paramString))) {
            break label488;
          }
          paramQQAppInterface = anvx.a(2131713700);
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            localJSONObject.put("nickname", anck.a(bhcu.encodeToString(paramQQAppInterface.getBytes("utf-8"), 0)));
          }
        }
        localJSONArray1.put(localJSONObject);
        ((JSONObject)localObject).put("dressInfo", localJSONArray1);
        ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ancc.a()).callbackFromRequest(this.jdField_a_of_type_Ancc.a().getLuaState(), 0, "sc.script_notify_dress_ready.local", ((JSONObject)localObject).toString());
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", paramQQAppInterface);
        return;
      }
      label488:
      paramQQAppInterface = anck.a(this.jdField_a_of_type_Ancc.a(), this.jdField_a_of_type_Ancc.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_Ancc.jdField_a_of_type_JavaLangString, true);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyAddBubble],text:", paramString2 });
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("text", new String(anck.a(bhcu.encodeToString(paramString2.getBytes("utf-8"), 0))));
      if (!TextUtils.isEmpty(paramString1))
      {
        localJSONObject.put("uin", paramString1);
        paramString1 = ancd.a(paramString2, 0, amme.a(a(), paramString1));
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.e("cmshow_scripted_SpriteActionScript", 1, "base role 0 is not exit, now check and download");
          anhm.a(a(), 11);
        }
        localJSONObject.put("bubble", paramString1);
        ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ancc.a()).callbackFromRequest(this.jdField_a_of_type_Ancc.a().getLuaState(), 0, "sc.script_add_bubble.local", localJSONObject.toString());
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifyAddBubble] ", paramString1);
      return;
    }
    String str = ancd.a(paramString2, 0, 1);
    paramString2 = ancd.a(paramString2, 0, 2);
    if (amme.a(a()) == 1) {}
    for (paramString1 = str;; paramString1 = paramString2)
    {
      localJSONObject.put("bubble2D", str);
      localJSONObject.put("bubble3D", paramString2);
      localJSONObject.put("bubble", paramString1);
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyAddBubble],text:", paramString2 });
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = paramString1;
    try
    {
      if (TextUtils.isEmpty(paramString1))
      {
        str = paramString1;
        if (a() != null) {
          str = a().getCurrentAccountUin();
        }
      }
      paramString1 = new JSONObject();
      paramString1.put("model", anhm.a(str, a()));
      paramString1.put("text", paramString2);
      if (!TextUtils.isEmpty(str)) {
        paramString1.put("uin", str);
      }
      paramString1.put("bubble", ancd.a(paramString2, 0, paramInt, amme.a(a(), str)));
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ancc.a()).callbackFromRequest(this.jdField_a_of_type_Ancc.a().getLuaState(), 0, "sc.script_add_bubble.local", paramString1.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifyAddBubble] ", paramString1);
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
        QLog.w("cmshow_scripted_SpriteActionScript", 1, "3D dir NOT exist.");
        return;
      }
      if (!((File)localObject1).exists())
      {
        QLog.w("cmshow_scripted_SpriteActionScript", 1, "3DConfig NOT exist.");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramJSONObject, new Object[0]);
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
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localampv.removeAllApolloBarrages(true);
    return null;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Ancc != null) && (this.jdField_a_of_type_Ancc.a() != null)) {
      a(this.jdField_a_of_type_Ancc.a().getRenderWidth(), this.jdField_a_of_type_Ancc.a().getInitHeight(), this.jdField_a_of_type_Ancc.a().getRenderHeight(), this.jdField_a_of_type_Ancc.jdField_a_of_type_Int, this.jdField_a_of_type_Ancc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ancc.e, this.jdField_a_of_type_Ancc.c);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifySpriteVisibility], status:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isShow", paramInt);
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ancc.a()).callbackFromRequest(this.jdField_a_of_type_Ancc.a().getLuaState(), 0, "sc.script_set_sprite_visibility.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
  
  public amqr c(String paramString)
  {
    QQAppInterface localQQAppInterface;
    try
    {
      if (this.jdField_a_of_type_Ancc.e != 0) {
        return null;
      }
      paramString = anck.a(paramString, this.jdField_a_of_type_Ancc);
      localQQAppInterface = a();
      if ((paramString == null) || (localQQAppInterface == null)) {
        break label129;
      }
      anbs localanbs = this.jdField_a_of_type_Anch.a();
      if ((localanbs != null) && (!localanbs.a(paramString)))
      {
        if (!QLog.isColorLevel()) {
          break label129;
        }
        QLog.d("cmshow_scripted_SpriteActionScript", 2, "Message can't be sent out without any slave.");
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localQQAppInterface.getMessageFacade().addAndSendMessage(paramString, null);
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "send an action msg, actionId:", Integer.valueOf(paramString.mApolloMessage.id) });
    }
    label129:
    return null;
  }
  
  public void c(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyUsrOperation], status:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("status", paramInt);
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_Ancc.a()).callbackFromRequest(this.jdField_a_of_type_Ancc.a().getLuaState(), 0, "sc.script_notify_user_operation.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbt
 * JD-Core Version:    0.7.0.1
 */