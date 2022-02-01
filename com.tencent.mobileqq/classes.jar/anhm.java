import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class anhm
{
  static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  int jdField_a_of_type_Int = -1;
  private anhg jdField_a_of_type_Anhg;
  int jdField_b_of_type_Int = -1;
  Map<String, Integer> jdField_b_of_type_JavaUtilMap = new HashMap();
  Map<String, String> c = new ConcurrentHashMap(2);
  private Map<String, Long> d = new HashMap();
  
  public anhm(anhg paramanhg)
  {
    this.jdField_a_of_type_Anhg = paramanhg;
  }
  
  private static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = ((amsx)ApolloUtil.a().getManager(153)).a(paramInt);
    if ((paramInt != -1) && (!ApolloUtil.a(paramInt, 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloPet", 2, "download random pet action:" + paramInt);
      }
      Object localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = paramInt;
      String str = ApolloUtil.a((ApolloActionData)localObject, 5);
      localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
      aniv.a(ApolloUtil.a(), (String)localObject, str);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramInt != -1) {
        localStringBuilder.append(paramInt).append("/action/action");
      }
    }
  }
  
  static String a(int paramInt, String paramString)
  {
    return null;
  }
  
  public static String a(SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext, CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    int j = 0;
    if ((paramSpriteTaskParam == null) || (paramIPCSpriteContext == null) || (paramPlayActionConfig == null)) {
      return null;
    }
    label341:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        String str;
        int i;
        if (paramIPCSpriteContext.jdField_b_of_type_Int == 0)
        {
          str = ApolloActionData.getModelString(paramSpriteTaskParam.f);
          localJSONObject.put("loop", paramPlayActionConfig.jdField_a_of_type_Boolean);
          localJSONObject.put("needRestore", paramPlayActionConfig.jdField_b_of_type_Boolean);
          localJSONObject.put("model", str);
          localJSONObject.put("actionId", paramSpriteTaskParam.f);
          localJSONObject.put("taskId", paramSpriteTaskParam.jdField_a_of_type_Int);
          localJSONObject.put("actionType", paramSpriteTaskParam.jdField_c_of_type_Int);
          localJSONObject.put("from", paramSpriteTaskParam.g);
          if (!angi.a(ApolloUtil.a())) {
            break label341;
          }
          i = 1;
          localJSONObject.put("isHide", i);
          i = j;
          if (paramSpriteTaskParam.jdField_a_of_type_Boolean) {
            i = 1;
          }
          localJSONObject.put("isSender", i);
          if (paramSpriteTaskParam.jdField_c_of_type_Int == 1)
          {
            paramPlayActionConfig = b(paramSpriteTaskParam, paramIPCSpriteContext);
            paramIPCSpriteContext = a(paramSpriteTaskParam, paramIPCSpriteContext);
            localJSONObject.put("sprites", paramPlayActionConfig);
            localJSONObject.put("actions", paramIPCSpriteContext);
            paramIPCSpriteContext = a(paramSpriteTaskParam);
            if (paramIPCSpriteContext != null) {
              localJSONObject.put("audio", paramIPCSpriteContext);
            }
            if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_d_of_type_JavaLangString)) {
              localJSONObject.put("extraMsg", new JSONObject(paramSpriteTaskParam.jdField_d_of_type_JavaLangString));
            }
            return localJSONObject.toString();
          }
        }
        else
        {
          if (paramSpriteTaskParam.f > 0)
          {
            str = ApolloActionData.getModelString(paramSpriteTaskParam.f);
            continue;
          }
          if (paramSpriteTaskParam.k == 14)
          {
            str = "3D";
            continue;
          }
          str = anlk.a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, ApolloUtil.a());
          continue;
        }
        paramIPCSpriteContext = a(paramSpriteTaskParam, paramIPCSpriteContext, paramPlayActionConfig);
        if (paramIPCSpriteContext != null)
        {
          localJSONObject.put("sprites", paramIPCSpriteContext);
          continue;
          i = 0;
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("CmShow_SpriteRscBuilder", 1, "[getActionJsParam],", paramSpriteTaskParam);
        return null;
      }
    }
  }
  
  public static String a(IPCSpriteContext paramIPCSpriteContext)
  {
    if (paramIPCSpriteContext == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      if (!TextUtils.isEmpty(paramIPCSpriteContext.jdField_b_of_type_JavaLangString)) {
        localJSONArray.put(b(paramIPCSpriteContext.jdField_b_of_type_JavaLangString, paramIPCSpriteContext, true));
      }
      if (!TextUtils.isEmpty(paramIPCSpriteContext.jdField_a_of_type_JavaLangString)) {
        localJSONArray.put(b(paramIPCSpriteContext.jdField_a_of_type_JavaLangString, paramIPCSpriteContext, false));
      }
      localJSONObject.put("sprites", localJSONArray);
      paramIPCSpriteContext = localJSONObject.toString();
      return paramIPCSpriteContext;
    }
    catch (Throwable paramIPCSpriteContext)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, "[getSpriteJsParam],", paramIPCSpriteContext);
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    boolean bool1 = ((amsx)paramQQAppInterface.getManager(153)).b(paramString);
    boolean bool2 = paramString.equals(paramQQAppInterface.getCurrentAccountUin());
    int i = angi.a(paramInt, bool2, bool1, 1, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "getNicknamePath uin:", ApolloUtil.d(paramString), ", isMe:", Boolean.valueOf(bool2), ",isYellowVip:", Boolean.valueOf(bool1), ",isRight:", Boolean.valueOf(paramBoolean), ",bubbleId:", Integer.valueOf(i) });
    }
    return anlk.a(paramInt, i, amsx.a(paramQQAppInterface, paramString));
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = ApolloUtil.b(208.0F, paramString, paramInt2);
    if ((!ApolloUtil.e(paramInt1, i)) && (!ApolloUtil.e(0, i))) {
      return "";
    }
    return anlk.a(paramInt1, i, paramInt2);
  }
  
  static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("def/role/0/Bubble/");
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        if (i < j)
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          int k = localJSONObject.optInt("roleId", -1);
          if ((k == -1) || (k != paramInt)) {
            continue;
          }
          if (!paramBoolean) {
            continue;
          }
          paramString = "namePlateIdRight";
          localStringBuilder.append(localJSONObject.optInt(paramString, 0));
        }
        localStringBuilder.append("/dress");
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloPet", 1, "getPetNamePlate error:", paramString);
        continue;
      }
      return localStringBuilder.toString();
      paramString = "namePlateIdLeft";
      continue;
      i += 1;
    }
  }
  
  private static String a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    boolean bool1;
    try
    {
      Object localObject2 = new JSONObject(paramString).optJSONObject("action");
      Object localObject1;
      if (paramBoolean)
      {
        localObject1 = ((JSONObject)localObject2).optString("actionId");
        if (((JSONObject)localObject2).optInt("actionPlatform") <= 0) {
          break label246;
        }
        bool1 = true;
        break label243;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (!paramBoolean) {
            bool2 = true;
          }
          if (ApolloUtil.a(paramInt, bool2, Integer.parseInt((String)localObject1), bool1))
          {
            localObject2 = File.separator + (String)localObject1;
            localObject1 = localObject2;
            if (bool1) {
              localObject1 = (String)localObject2 + File.separator + "android";
            }
            return (String)localObject1 + File.separator + "action";
          }
        }
      }
      else
      {
        localObject1 = ((JSONObject)localObject2).optString("actionPeerId");
        int i = ((JSONObject)localObject2).optInt("actionPeerPlatform");
        if (i > 0) {}
        for (bool1 = true;; bool1 = false) {
          break;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, "[random] the json is not right," + paramString);
    }
    for (;;)
    {
      label243:
      break;
      label246:
      bool1 = false;
    }
  }
  
  private static JSONArray a(SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext)
  {
    if ((paramSpriteTaskParam == null) || (paramIPCSpriteContext == null)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      int k;
      int m;
      try
      {
        localJSONArray = new JSONArray();
        paramSpriteTaskParam = paramSpriteTaskParam.jdField_a_of_type_JavaUtilArrayList;
        localannx = (annx)ApolloUtil.a().getManager(155);
        i = 0;
        k = 0;
        j = -1;
        if (k < paramSpriteTaskParam.size())
        {
          m = ((Integer)paramSpriteTaskParam.get(k)).intValue();
          if (-1 != j)
          {
            localObject = localannx.a(j);
            if ((localObject != null) && (((ApolloActionData)localObject).isHasPostAction()) && (j != m))
            {
              localObject = a(j, 2, paramIPCSpriteContext);
              if (localObject != null) {
                localJSONArray.put(localObject);
              }
            }
          }
          Object localObject = localannx.a(m);
          if (localObject != null)
          {
            if ((m != j) && (((ApolloActionData)localObject).isHasPreAction()))
            {
              localObject = a(m, 0, paramIPCSpriteContext);
              if (localObject != null) {
                localJSONArray.put(localObject);
              }
            }
            localObject = a(m, 1, paramIPCSpriteContext);
            if (localObject == null) {
              break label420;
            }
            localJSONArray.put(localObject);
            break label420;
          }
          j = -1;
          i = 1;
          QLog.i("CmShow_SpriteRscBuilder", 1, "[insertPrePost], action NOT exist locally, id:" + m);
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        JSONArray localJSONArray;
        annx localannx;
        int i;
        QLog.e("CmShow_SpriteRscBuilder", 1, "[getWhiteFaceActions],", paramSpriteTaskParam);
        return null;
        if (-1 != j)
        {
          paramSpriteTaskParam = localannx.a(j);
          if ((paramSpriteTaskParam != null) && (paramSpriteTaskParam.isHasPostAction()))
          {
            paramSpriteTaskParam = a(j, 2, paramIPCSpriteContext);
            if (paramSpriteTaskParam != null) {
              localJSONArray.put(paramSpriteTaskParam);
            }
          }
        }
        if (i != 0) {
          apcx.a(ApolloUtil.a(), 1);
        }
        return localJSONArray;
      }
      finally
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "[getWhiteFaceActions], cost:", Long.valueOf(l2 - l1) });
        }
      }
      label420:
      int j = m;
      k += 1;
    }
  }
  
  private static JSONArray a(SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext, CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    if ((paramSpriteTaskParam == null) || (paramIPCSpriteContext == null)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, paramIPCSpriteContext, paramSpriteTaskParam, true, false, paramPlayActionConfig);
        if ((paramIPCSpriteContext.jdField_a_of_type_Int == 0) || (paramSpriteTaskParam.e == 1))
        {
          paramSpriteTaskParam = a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, paramIPCSpriteContext, paramSpriteTaskParam, false, false, paramPlayActionConfig);
          if (localJSONObject != null) {
            localJSONArray.put(localJSONObject);
          }
          if (paramSpriteTaskParam != null) {
            localJSONArray.put(paramSpriteTaskParam);
          }
          return localJSONArray;
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("CmShow_SpriteRscBuilder", 1, "[getBasicActionJs],", paramSpriteTaskParam);
        return null;
      }
      finally
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "[getBasicActionJs], cost:", Long.valueOf(l2 - l1) });
        }
      }
      paramSpriteTaskParam = null;
    }
  }
  
  private static JSONObject a(int paramInt1, int paramInt2, IPCSpriteContext paramIPCSpriteContext)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      Object localObject = new SpriteTaskParam();
      ((SpriteTaskParam)localObject).f = paramInt1;
      ((SpriteTaskParam)localObject).jdField_d_of_type_Int = paramInt2;
      ((SpriteTaskParam)localObject).h = paramIPCSpriteContext.jdField_a_of_type_Int;
      ((SpriteTaskParam)localObject).jdField_c_of_type_Int = 1;
      if (!a((SpriteTaskParam)localObject)) {
        return null;
      }
      localObject = ((annx)ApolloUtil.a().getManager(155)).a(paramInt1);
      if (localObject == null) {
        return null;
      }
      localJSONObject.put("actionId", paramInt1);
      localJSONObject.put("action", anlk.a(paramInt1, paramInt2, true, paramIPCSpriteContext.a())[0]);
      if (((ApolloActionData)localObject).personNum == 1) {
        localJSONObject.put("actionPeer", anlk.a(paramInt1, paramInt2, false, paramIPCSpriteContext.a())[0]);
      }
      if (paramIPCSpriteContext.jdField_a_of_type_Int == 0)
      {
        localJSONObject.put("actionDis", ((ApolloActionData)localObject).actionMoveDis * (float)bhlo.j() / 7.0F / 368.0F);
        localJSONObject.put("actionPeerDis", ((ApolloActionData)localObject).peerMoveDis * (float)bhlo.j() / 7.0F / 368.0F);
      }
      else
      {
        localJSONObject.put("posType", ((ApolloActionData)localObject).playArea);
      }
    }
    catch (Throwable paramIPCSpriteContext)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, "[getWhiteFaceSingleAction],", paramIPCSpriteContext);
      return null;
    }
    return localJSONObject;
  }
  
  public static JSONObject a(SpriteTaskParam paramSpriteTaskParam)
  {
    label349:
    for (;;)
    {
      try
      {
        Object localObject2;
        Object localObject1;
        if ((paramSpriteTaskParam.k == 12) && (paramSpriteTaskParam.f > 0))
        {
          localObject2 = ApolloUtil.g(paramSpriteTaskParam.f);
          if (!new File((String)localObject2).exists())
          {
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("CmShow_SpriteRscBuilder", 1, new Object[] { "[getAudioParam] audio not found for " + (String)localObject2, ",action:", Integer.valueOf(paramSpriteTaskParam.f) });
              localObject1 = localObject2;
            }
            int i = ((String)localObject1).indexOf(".apollo");
            if (-1 != i)
            {
              localObject1 = ((String)localObject1).substring(i + ".apollo/action/".length());
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("path", localObject1);
              ((JSONObject)localObject2).put("delayMill", paramSpriteTaskParam.jdField_a_of_type_Float * 1000.0F);
              return localObject2;
            }
          }
          else
          {
            localObject1 = ((String)localObject2).substring(annv.jdField_d_of_type_JavaLangString.length());
            continue;
          }
        }
        else
        {
          localObject2 = (amsx)ApolloUtil.a().getManager(153);
          ApolloActionData localApolloActionData = ((annx)ApolloUtil.a().getManager(155)).a(paramSpriteTaskParam.f);
          if ((localApolloActionData != null) && (localApolloActionData.hasSound))
          {
            localObject1 = annv.jdField_d_of_type_JavaLangString + paramSpriteTaskParam.f + "/" + "music.amr";
            if (new File((String)localObject1).exists()) {
              break label349;
            }
            ((amsx)localObject2).a(localApolloActionData, 4, null);
            continue;
          }
          if (paramSpriteTaskParam.i > 0)
          {
            localObject2 = aniv.b(paramSpriteTaskParam.i);
            localObject1 = localObject2;
            if (new File((String)localObject2).exists()) {
              continue;
            }
            aniv.a(ApolloUtil.a(), null, paramSpriteTaskParam.i, false);
            localObject1 = localObject2;
            continue;
          }
          return null;
        }
      }
      catch (Exception paramSpriteTaskParam)
      {
        QLog.e("CmShow_SpriteRscBuilder", 1, paramSpriteTaskParam, new Object[0]);
        return null;
      }
    }
  }
  
  private static JSONObject a(String paramString, IPCSpriteContext paramIPCSpriteContext, SpriteTaskParam paramSpriteTaskParam, boolean paramBoolean1, boolean paramBoolean2, CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      int m;
      int i;
      int j;
      int n;
      try
      {
        localJSONObject = b(paramString, paramIPCSpriteContext, false);
        if (!a(paramSpriteTaskParam)) {
          return localJSONObject;
        }
        m = amsx.a(ApolloUtil.a(), paramString);
        i = ((Integer)anlk.a(paramString, m, ApolloUtil.a(), true)[0]).intValue();
        paramString = anlk.a(paramString, ApolloUtil.a(), true);
        if ((paramString == null) || (paramString.length != 2)) {
          break label603;
        }
        j = ((Integer)paramString[0]).intValue();
        if (paramSpriteTaskParam == null) {
          break;
        }
        if (!paramBoolean1) {
          break label607;
        }
        k = 1;
        localJSONObject.put("isMaster", k);
        if ((paramBoolean1) && (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)))
        {
          localJSONObject.put("text", angi.a(bhkv.encodeToString(paramSpriteTaskParam.jdField_c_of_type_JavaLangString.getBytes("utf-8"), 0)));
          if (paramSpriteTaskParam.jdField_b_of_type_Boolean) {
            continue;
          }
          localJSONObject.put("bubbleType", 0);
          if ((m == 1) && (paramSpriteTaskParam.f > annv.jdField_a_of_type_Int) && (amsx.a(ApolloUtil.a())))
          {
            k = 2;
            localJSONObject.put("bubble", a(paramSpriteTaskParam.jdField_c_of_type_JavaLangString, j, k));
          }
        }
        else
        {
          n = paramSpriteTaskParam.k;
          i1 = paramSpriteTaskParam.f;
          if (i < 0) {
            break label305;
          }
          k = i;
          paramString = anlk.a(n, i1, k, paramBoolean1, m, paramPlayActionConfig);
          if (paramString == null) {
            break label605;
          }
          if (paramString.length >= 2) {
            break label312;
          }
          break label605;
        }
        if ((m != 2) || (paramSpriteTaskParam.f >= annv.jdField_a_of_type_Int)) {
          break label596;
        }
        k = 1;
        continue;
        localJSONObject.put("bubbleType", 1);
        continue;
        k = j;
      }
      catch (Throwable paramString)
      {
        QLog.e("CmShow_SpriteRscBuilder", 1, paramString, new Object[0]);
        return null;
      }
      label305:
      continue;
      label312:
      if ((paramSpriteTaskParam.e == 0) && (paramIPCSpriteContext.jdField_a_of_type_Int == 0) && (!paramBoolean1) && (!paramBoolean2)) {
        break;
      }
      paramIPCSpriteContext = paramString[0];
      paramString = paramIPCSpriteContext;
      if (8 == paramSpriteTaskParam.jdField_c_of_type_Int)
      {
        paramString = paramIPCSpriteContext;
        if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_d_of_type_JavaLangString))
        {
          String str = a(paramBoolean1, paramSpriteTaskParam.jdField_d_of_type_JavaLangString, paramSpriteTaskParam.f);
          paramString = paramIPCSpriteContext;
          if (!TextUtils.isEmpty(str)) {
            paramString = paramIPCSpriteContext + str;
          }
        }
      }
      localJSONObject.put("action", paramString);
      if (paramPlayActionConfig == null) {
        break;
      }
      int i1 = paramPlayActionConfig.jdField_c_of_type_Int;
      paramPlayActionConfig.jdField_c_of_type_Int = 1;
      int i2 = paramSpriteTaskParam.f;
      if (i >= 0)
      {
        k = i;
        localJSONObject.put("preAction", anlk.a(n, i2, k, paramBoolean1, m, paramPlayActionConfig)[0]);
        paramPlayActionConfig.jdField_c_of_type_Int = 2;
        i2 = paramSpriteTaskParam.f;
        if (i < 0) {
          break label582;
        }
        k = i;
        label498:
        localJSONObject.put("mainAction", anlk.a(n, i2, k, paramBoolean1, m, paramPlayActionConfig)[0]);
        paramPlayActionConfig.jdField_c_of_type_Int = 3;
        k = paramSpriteTaskParam.f;
        if (i < 0) {
          break label589;
        }
      }
      for (;;)
      {
        localJSONObject.put("postAction", anlk.a(n, k, i, paramBoolean1, m, paramPlayActionConfig)[0]);
        paramPlayActionConfig.jdField_c_of_type_Int = i1;
        break label613;
        k = j;
        break;
        label582:
        k = j;
        break label498;
        label589:
        i = j;
      }
      label596:
      int k = m;
      continue;
      label603:
      return null;
      label605:
      return null;
      label607:
      k = 0;
    }
    label613:
    return localJSONObject;
  }
  
  /* Error */
  public static JSONObject a(String paramString, IPCSpriteContext paramIPCSpriteContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 113	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 114	org/json/JSONObject:<init>	()V
    //   7: astore 13
    //   9: iconst_1
    //   10: istore 10
    //   12: iconst_1
    //   13: istore 11
    //   15: iconst_1
    //   16: istore 5
    //   18: iconst_m1
    //   19: istore 4
    //   21: new 374	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 569	java/util/ArrayList:<init>	()V
    //   28: astore 14
    //   30: invokestatic 52	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: sipush 153
    //   36: invokevirtual 58	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   39: checkcast 60	amsx
    //   42: astore 12
    //   44: iload 4
    //   46: istore 8
    //   48: iload 10
    //   50: istore 6
    //   52: iload 4
    //   54: istore 9
    //   56: iload 11
    //   58: istore 7
    //   60: aload 12
    //   62: aload_0
    //   63: invokevirtual 572	amsx:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   66: astore 15
    //   68: aload 15
    //   70: ifnonnull +5 -> 75
    //   73: aconst_null
    //   74: areturn
    //   75: iload 4
    //   77: istore 8
    //   79: iload 10
    //   81: istore 6
    //   83: iload 4
    //   85: istore 9
    //   87: iload 11
    //   89: istore 7
    //   91: aload 15
    //   93: invokevirtual 578	com/tencent/mobileqq/data/ApolloBaseInfo:getApolloPetDress	()Lamxm;
    //   96: astore 16
    //   98: aload 16
    //   100: ifnull +967 -> 1067
    //   103: iload 4
    //   105: istore 8
    //   107: iload 10
    //   109: istore 6
    //   111: iload 4
    //   113: istore 9
    //   115: iload 11
    //   117: istore 7
    //   119: aload 15
    //   121: getfield 581	com/tencent/mobileqq/data/ApolloBaseInfo:hasPet	Z
    //   124: ifeq +943 -> 1067
    //   127: iload 4
    //   129: istore 8
    //   131: iload 10
    //   133: istore 6
    //   135: iload 4
    //   137: istore 9
    //   139: iload 11
    //   141: istore 7
    //   143: aload 16
    //   145: getfield 586	amxm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   148: ifnull +919 -> 1067
    //   151: iload 4
    //   153: istore 8
    //   155: iload 10
    //   157: istore 6
    //   159: iload 4
    //   161: istore 9
    //   163: iload 11
    //   165: istore 7
    //   167: aload 16
    //   169: getfield 586	amxm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   172: invokevirtual 588	java/util/HashMap:isEmpty	()Z
    //   175: ifne +892 -> 1067
    //   178: iload 4
    //   180: istore 8
    //   182: iload 10
    //   184: istore 6
    //   186: iload 4
    //   188: istore 9
    //   190: iload 11
    //   192: istore 7
    //   194: aload 13
    //   196: ldc_w 590
    //   199: iconst_0
    //   200: aload 16
    //   202: getfield 591	amxm:jdField_a_of_type_Int	I
    //   205: invokestatic 594	anlk:a	(II)Ljava/lang/String;
    //   208: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   211: pop
    //   212: iload 4
    //   214: istore_3
    //   215: iload 4
    //   217: istore 8
    //   219: iload 10
    //   221: istore 6
    //   223: iload 4
    //   225: istore 9
    //   227: iload 11
    //   229: istore 7
    //   231: iconst_1
    //   232: aload 16
    //   234: getfield 591	amxm:jdField_a_of_type_Int	I
    //   237: invokestatic 596	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(II)Z
    //   240: ifne +26 -> 266
    //   243: iconst_0
    //   244: istore 6
    //   246: iconst_0
    //   247: istore 7
    //   249: iconst_0
    //   250: istore 5
    //   252: iload 4
    //   254: istore 8
    //   256: iload 4
    //   258: istore 9
    //   260: aload 16
    //   262: getfield 591	amxm:jdField_a_of_type_Int	I
    //   265: istore_3
    //   266: iload_3
    //   267: istore 8
    //   269: iload 5
    //   271: istore 6
    //   273: iload_3
    //   274: istore 9
    //   276: iload 5
    //   278: istore 7
    //   280: aload 16
    //   282: getfield 586	amxm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   285: invokevirtual 597	java/util/HashMap:size	()I
    //   288: newarray int
    //   290: astore 17
    //   292: iload_3
    //   293: istore 8
    //   295: iload 5
    //   297: istore 6
    //   299: iload_3
    //   300: istore 9
    //   302: iload 5
    //   304: istore 7
    //   306: aload 16
    //   308: getfield 586	amxm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   311: invokevirtual 601	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   314: invokeinterface 607 1 0
    //   319: astore 18
    //   321: iconst_0
    //   322: istore 4
    //   324: iload_3
    //   325: istore 8
    //   327: iload 5
    //   329: istore 6
    //   331: iload_3
    //   332: istore 9
    //   334: iload 5
    //   336: istore 7
    //   338: aload 18
    //   340: invokeinterface 612 1 0
    //   345: ifeq +52 -> 397
    //   348: iload_3
    //   349: istore 8
    //   351: iload 5
    //   353: istore 6
    //   355: iload_3
    //   356: istore 9
    //   358: iload 5
    //   360: istore 7
    //   362: aload 17
    //   364: iload 4
    //   366: aload 18
    //   368: invokeinterface 616 1 0
    //   373: checkcast 618	java/util/Map$Entry
    //   376: invokeinterface 621 1 0
    //   381: checkcast 277	java/lang/Integer
    //   384: invokevirtual 384	java/lang/Integer:intValue	()I
    //   387: iastore
    //   388: iload 4
    //   390: iconst_1
    //   391: iadd
    //   392: istore 4
    //   394: goto -70 -> 324
    //   397: iload_3
    //   398: istore 8
    //   400: iload 5
    //   402: istore 6
    //   404: iload_3
    //   405: istore 9
    //   407: iload 5
    //   409: istore 7
    //   411: new 226	org/json/JSONArray
    //   414: dup
    //   415: invokespecial 227	org/json/JSONArray:<init>	()V
    //   418: astore 18
    //   420: iload_3
    //   421: istore 8
    //   423: iload 5
    //   425: istore 6
    //   427: iload_3
    //   428: istore 9
    //   430: iload 5
    //   432: istore 7
    //   434: aload 17
    //   436: arraylength
    //   437: istore 10
    //   439: iload 5
    //   441: istore 4
    //   443: iconst_0
    //   444: istore 7
    //   446: iload 7
    //   448: iload 10
    //   450: if_icmpge +72 -> 522
    //   453: aload 17
    //   455: iload 7
    //   457: iaload
    //   458: istore 8
    //   460: iload 4
    //   462: istore 5
    //   464: iload 4
    //   466: istore 6
    //   468: aload 18
    //   470: iconst_1
    //   471: iload 8
    //   473: invokestatic 594	anlk:a	(II)Ljava/lang/String;
    //   476: invokevirtual 235	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   479: pop
    //   480: iload 4
    //   482: istore 5
    //   484: iload 4
    //   486: istore 6
    //   488: iconst_2
    //   489: iload 8
    //   491: invokestatic 596	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(II)Z
    //   494: ifne +914 -> 1408
    //   497: iconst_0
    //   498: istore 6
    //   500: iconst_0
    //   501: istore 4
    //   503: iconst_0
    //   504: istore 5
    //   506: aload 14
    //   508: iload 8
    //   510: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   513: invokeinterface 626 2 0
    //   518: pop
    //   519: goto +889 -> 1408
    //   522: iload 4
    //   524: istore 5
    //   526: iload 4
    //   528: istore 6
    //   530: aload 13
    //   532: ldc_w 628
    //   535: aload 18
    //   537: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   540: pop
    //   541: iload 4
    //   543: istore 5
    //   545: iload 4
    //   547: istore 6
    //   549: aload 13
    //   551: ldc_w 313
    //   554: aload 16
    //   556: getfield 591	amxm:jdField_a_of_type_Int	I
    //   559: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   562: pop
    //   563: iload 4
    //   565: istore 5
    //   567: iload 4
    //   569: istore 6
    //   571: aload 16
    //   573: getfield 591	amxm:jdField_a_of_type_Int	I
    //   576: ldc_w 630
    //   579: invokestatic 632	anhm:a	(ILjava/lang/String;)Ljava/lang/String;
    //   582: astore 17
    //   584: iload 4
    //   586: istore 5
    //   588: iload 4
    //   590: istore 6
    //   592: aload 16
    //   594: getfield 591	amxm:jdField_a_of_type_Int	I
    //   597: ldc_w 634
    //   600: invokestatic 632	anhm:a	(ILjava/lang/String;)Ljava/lang/String;
    //   603: astore 18
    //   605: iload 4
    //   607: istore 5
    //   609: iload 4
    //   611: istore 6
    //   613: aload 17
    //   615: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   618: ifne +57 -> 675
    //   621: iload 4
    //   623: istore 5
    //   625: iload 4
    //   627: istore 6
    //   629: aload 18
    //   631: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   634: ifne +41 -> 675
    //   637: iload 4
    //   639: istore 5
    //   641: iload 4
    //   643: istore 6
    //   645: aload 13
    //   647: ldc_w 636
    //   650: aload 18
    //   652: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   655: pop
    //   656: iload 4
    //   658: istore 5
    //   660: iload 4
    //   662: istore 6
    //   664: aload 13
    //   666: ldc_w 638
    //   669: aload 17
    //   671: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   674: pop
    //   675: iload 4
    //   677: istore 5
    //   679: iload 4
    //   681: istore 6
    //   683: aload 16
    //   685: getfield 591	amxm:jdField_a_of_type_Int	I
    //   688: invokestatic 640	anhm:a	(I)Ljava/lang/String;
    //   691: astore 17
    //   693: iload 4
    //   695: istore 5
    //   697: iload 4
    //   699: istore 6
    //   701: aload 17
    //   703: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   706: ifne +22 -> 728
    //   709: iload 4
    //   711: istore 5
    //   713: iload 4
    //   715: istore 6
    //   717: aload 13
    //   719: ldc_w 642
    //   722: aload 17
    //   724: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   727: pop
    //   728: iload 4
    //   730: istore 5
    //   732: iload 4
    //   734: istore 6
    //   736: aload 15
    //   738: getfield 645	com/tencent/mobileqq/data/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   741: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   744: ifne +53 -> 797
    //   747: iload 4
    //   749: istore 5
    //   751: iload 4
    //   753: istore 6
    //   755: aload_1
    //   756: getfield 117	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_b_of_type_Int	I
    //   759: ifne +38 -> 797
    //   762: iload 4
    //   764: istore 5
    //   766: iload 4
    //   768: istore 6
    //   770: aload 13
    //   772: ldc_w 647
    //   775: aload 15
    //   777: getfield 645	com/tencent/mobileqq/data/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   780: ldc_w 535
    //   783: invokevirtual 539	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   786: iconst_0
    //   787: invokestatic 545	bhkv:encodeToString	([BI)Ljava/lang/String;
    //   790: invokestatic 547	angi:a	(Ljava/lang/String;)Ljava/lang/String;
    //   793: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   796: pop
    //   797: iload 4
    //   799: istore 5
    //   801: iload 4
    //   803: istore 6
    //   805: aload 13
    //   807: ldc_w 649
    //   810: aload 12
    //   812: getfield 651	amsx:j	Ljava/lang/String;
    //   815: aload 16
    //   817: getfield 591	amxm:jdField_a_of_type_Int	I
    //   820: iload_2
    //   821: invokestatic 653	anhm:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   824: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   827: pop
    //   828: iload 4
    //   830: istore 5
    //   832: iload 4
    //   834: istore 6
    //   836: aload 13
    //   838: ldc_w 655
    //   841: aload_1
    //   842: getfield 656	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_a_of_type_Float	F
    //   845: f2d
    //   846: invokevirtual 458	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   849: pop
    //   850: iload 4
    //   852: istore 5
    //   854: iload 4
    //   856: istore 6
    //   858: aload_1
    //   859: getfield 658	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_b_of_type_Float	F
    //   862: ldc_w 659
    //   865: fcmpl
    //   866: ifeq +25 -> 891
    //   869: iload 4
    //   871: istore 5
    //   873: iload 4
    //   875: istore 6
    //   877: aload 13
    //   879: ldc_w 661
    //   882: aload_1
    //   883: getfield 658	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_b_of_type_Float	F
    //   886: f2d
    //   887: invokevirtual 458	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   890: pop
    //   891: iload 4
    //   893: istore 5
    //   895: iload 4
    //   897: istore 6
    //   899: aload_1
    //   900: getfield 663	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:c	F
    //   903: ldc_w 659
    //   906: fcmpl
    //   907: ifeq +25 -> 932
    //   910: iload 4
    //   912: istore 5
    //   914: iload 4
    //   916: istore 6
    //   918: aload 13
    //   920: ldc_w 665
    //   923: aload_1
    //   924: getfield 663	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:c	F
    //   927: f2d
    //   928: invokevirtual 458	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   931: pop
    //   932: iload 4
    //   934: ifeq +107 -> 1041
    //   937: iload 4
    //   939: ifne +466 -> 1405
    //   942: aload_1
    //   943: ifnull +462 -> 1405
    //   946: invokestatic 52	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   949: ifnull +456 -> 1405
    //   952: ldc 74
    //   954: iconst_1
    //   955: new 46	java/lang/StringBuilder
    //   958: dup
    //   959: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   962: ldc_w 667
    //   965: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: aload_0
    //   969: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   978: aload 12
    //   980: ifnull +425 -> 1405
    //   983: aload 14
    //   985: invokeinterface 668 1 0
    //   990: newarray int
    //   992: astore_1
    //   993: aload 14
    //   995: invokeinterface 669 1 0
    //   1000: astore 14
    //   1002: iconst_0
    //   1003: istore 4
    //   1005: aload 14
    //   1007: invokeinterface 612 1 0
    //   1012: ifeq +35 -> 1047
    //   1015: aload_1
    //   1016: iload 4
    //   1018: aload 14
    //   1020: invokeinterface 616 1 0
    //   1025: checkcast 277	java/lang/Integer
    //   1028: invokevirtual 384	java/lang/Integer:intValue	()I
    //   1031: iastore
    //   1032: iload 4
    //   1034: iconst_1
    //   1035: iadd
    //   1036: istore 4
    //   1038: goto -33 -> 1005
    //   1041: aconst_null
    //   1042: astore 13
    //   1044: goto -107 -> 937
    //   1047: invokestatic 52	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1050: aload_0
    //   1051: aload 12
    //   1053: invokevirtual 672	amsx:a	()Lanje;
    //   1056: iload_3
    //   1057: aload_1
    //   1058: iconst_m1
    //   1059: iconst_m1
    //   1060: iconst_1
    //   1061: invokestatic 675	aniv:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lanje;I[IIIZ)V
    //   1064: aload 13
    //   1066: areturn
    //   1067: aconst_null
    //   1068: areturn
    //   1069: astore 13
    //   1071: aconst_null
    //   1072: astore 12
    //   1074: iconst_1
    //   1075: istore 5
    //   1077: iload 4
    //   1079: istore_3
    //   1080: iload 5
    //   1082: istore 4
    //   1084: ldc 217
    //   1086: iconst_1
    //   1087: aload 13
    //   1089: iconst_0
    //   1090: anewarray 4	java/lang/Object
    //   1093: invokestatic 521	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1096: iload 4
    //   1098: ifne +119 -> 1217
    //   1101: aload_1
    //   1102: ifnull +115 -> 1217
    //   1105: invokestatic 52	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1108: ifnull +109 -> 1217
    //   1111: ldc 74
    //   1113: iconst_1
    //   1114: new 46	java/lang/StringBuilder
    //   1117: dup
    //   1118: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   1121: ldc_w 667
    //   1124: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: aload_0
    //   1128: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1134: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1137: aload 12
    //   1139: ifnull +78 -> 1217
    //   1142: aload 14
    //   1144: invokeinterface 668 1 0
    //   1149: newarray int
    //   1151: astore_1
    //   1152: aload 14
    //   1154: invokeinterface 669 1 0
    //   1159: astore 13
    //   1161: iconst_0
    //   1162: istore 4
    //   1164: aload 13
    //   1166: invokeinterface 612 1 0
    //   1171: ifeq +29 -> 1200
    //   1174: aload_1
    //   1175: iload 4
    //   1177: aload 13
    //   1179: invokeinterface 616 1 0
    //   1184: checkcast 277	java/lang/Integer
    //   1187: invokevirtual 384	java/lang/Integer:intValue	()I
    //   1190: iastore
    //   1191: iload 4
    //   1193: iconst_1
    //   1194: iadd
    //   1195: istore 4
    //   1197: goto -33 -> 1164
    //   1200: invokestatic 52	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1203: aload_0
    //   1204: aload 12
    //   1206: invokevirtual 672	amsx:a	()Lanje;
    //   1209: iload_3
    //   1210: aload_1
    //   1211: iconst_m1
    //   1212: iconst_m1
    //   1213: iconst_1
    //   1214: invokestatic 675	aniv:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lanje;I[IIIZ)V
    //   1217: aconst_null
    //   1218: areturn
    //   1219: astore 13
    //   1221: aconst_null
    //   1222: astore 12
    //   1224: iconst_1
    //   1225: istore 5
    //   1227: iload 4
    //   1229: istore_3
    //   1230: iload 5
    //   1232: istore 4
    //   1234: iload 4
    //   1236: ifne +119 -> 1355
    //   1239: aload_1
    //   1240: ifnull +115 -> 1355
    //   1243: invokestatic 52	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1246: ifnull +109 -> 1355
    //   1249: ldc 74
    //   1251: iconst_1
    //   1252: new 46	java/lang/StringBuilder
    //   1255: dup
    //   1256: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   1259: ldc_w 667
    //   1262: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: aload_0
    //   1266: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1272: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1275: aload 12
    //   1277: ifnull +78 -> 1355
    //   1280: aload 14
    //   1282: invokeinterface 668 1 0
    //   1287: newarray int
    //   1289: astore_1
    //   1290: aload 14
    //   1292: invokeinterface 669 1 0
    //   1297: astore 14
    //   1299: iconst_0
    //   1300: istore 4
    //   1302: aload 14
    //   1304: invokeinterface 612 1 0
    //   1309: ifeq +29 -> 1338
    //   1312: aload_1
    //   1313: iload 4
    //   1315: aload 14
    //   1317: invokeinterface 616 1 0
    //   1322: checkcast 277	java/lang/Integer
    //   1325: invokevirtual 384	java/lang/Integer:intValue	()I
    //   1328: iastore
    //   1329: iload 4
    //   1331: iconst_1
    //   1332: iadd
    //   1333: istore 4
    //   1335: goto -33 -> 1302
    //   1338: invokestatic 52	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1341: aload_0
    //   1342: aload 12
    //   1344: invokevirtual 672	amsx:a	()Lanje;
    //   1347: iload_3
    //   1348: aload_1
    //   1349: iconst_m1
    //   1350: iconst_m1
    //   1351: iconst_1
    //   1352: invokestatic 675	aniv:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lanje;I[IIIZ)V
    //   1355: aload 13
    //   1357: athrow
    //   1358: astore 13
    //   1360: iload 6
    //   1362: istore 4
    //   1364: iload 8
    //   1366: istore_3
    //   1367: goto -133 -> 1234
    //   1370: astore 13
    //   1372: iload 5
    //   1374: istore 4
    //   1376: goto -142 -> 1234
    //   1379: astore 13
    //   1381: goto -147 -> 1234
    //   1384: astore 13
    //   1386: iload 7
    //   1388: istore 4
    //   1390: iload 9
    //   1392: istore_3
    //   1393: goto -309 -> 1084
    //   1396: astore 13
    //   1398: iload 6
    //   1400: istore 4
    //   1402: goto -318 -> 1084
    //   1405: aload 13
    //   1407: areturn
    //   1408: iload 7
    //   1410: iconst_1
    //   1411: iadd
    //   1412: istore 7
    //   1414: goto -968 -> 446
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1417	0	paramString	String
    //   0	1417	1	paramIPCSpriteContext	IPCSpriteContext
    //   0	1417	2	paramBoolean	boolean
    //   214	1179	3	i	int
    //   19	1382	4	j	int
    //   16	1357	5	k	int
    //   50	1349	6	m	int
    //   58	1355	7	n	int
    //   46	1319	8	i1	int
    //   54	1337	9	i2	int
    //   10	441	10	i3	int
    //   13	215	11	i4	int
    //   42	1301	12	localamsx	amsx
    //   7	1058	13	localJSONObject	JSONObject
    //   1069	19	13	localThrowable1	Throwable
    //   1159	19	13	localIterator	java.util.Iterator
    //   1219	137	13	localObject1	Object
    //   1358	1	13	localObject2	Object
    //   1370	1	13	localObject3	Object
    //   1379	1	13	localObject4	Object
    //   1384	1	13	localThrowable2	Throwable
    //   1396	10	13	localThrowable3	Throwable
    //   28	1288	14	localObject5	Object
    //   66	710	15	localApolloBaseInfo	ApolloBaseInfo
    //   96	720	16	localamxm	amxm
    //   290	433	17	localObject6	Object
    //   319	332	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   30	44	1069	java/lang/Throwable
    //   30	44	1219	finally
    //   60	68	1358	finally
    //   91	98	1358	finally
    //   119	127	1358	finally
    //   143	151	1358	finally
    //   167	178	1358	finally
    //   194	212	1358	finally
    //   231	243	1358	finally
    //   260	266	1358	finally
    //   280	292	1358	finally
    //   306	321	1358	finally
    //   338	348	1358	finally
    //   362	388	1358	finally
    //   411	420	1358	finally
    //   434	439	1358	finally
    //   468	480	1370	finally
    //   488	497	1370	finally
    //   506	519	1370	finally
    //   530	541	1370	finally
    //   549	563	1370	finally
    //   571	584	1370	finally
    //   592	605	1370	finally
    //   613	621	1370	finally
    //   629	637	1370	finally
    //   645	656	1370	finally
    //   664	675	1370	finally
    //   683	693	1370	finally
    //   701	709	1370	finally
    //   717	728	1370	finally
    //   736	747	1370	finally
    //   755	762	1370	finally
    //   770	797	1370	finally
    //   805	828	1370	finally
    //   836	850	1370	finally
    //   858	869	1370	finally
    //   877	891	1370	finally
    //   899	910	1370	finally
    //   918	932	1370	finally
    //   1084	1096	1379	finally
    //   60	68	1384	java/lang/Throwable
    //   91	98	1384	java/lang/Throwable
    //   119	127	1384	java/lang/Throwable
    //   143	151	1384	java/lang/Throwable
    //   167	178	1384	java/lang/Throwable
    //   194	212	1384	java/lang/Throwable
    //   231	243	1384	java/lang/Throwable
    //   260	266	1384	java/lang/Throwable
    //   280	292	1384	java/lang/Throwable
    //   306	321	1384	java/lang/Throwable
    //   338	348	1384	java/lang/Throwable
    //   362	388	1384	java/lang/Throwable
    //   411	420	1384	java/lang/Throwable
    //   434	439	1384	java/lang/Throwable
    //   468	480	1396	java/lang/Throwable
    //   488	497	1396	java/lang/Throwable
    //   506	519	1396	java/lang/Throwable
    //   530	541	1396	java/lang/Throwable
    //   549	563	1396	java/lang/Throwable
    //   571	584	1396	java/lang/Throwable
    //   592	605	1396	java/lang/Throwable
    //   613	621	1396	java/lang/Throwable
    //   629	637	1396	java/lang/Throwable
    //   645	656	1396	java/lang/Throwable
    //   664	675	1396	java/lang/Throwable
    //   683	693	1396	java/lang/Throwable
    //   701	709	1396	java/lang/Throwable
    //   717	728	1396	java/lang/Throwable
    //   736	747	1396	java/lang/Throwable
    //   755	762	1396	java/lang/Throwable
    //   770	797	1396	java/lang/Throwable
    //   805	828	1396	java/lang/Throwable
    //   836	850	1396	java/lang/Throwable
    //   858	869	1396	java/lang/Throwable
    //   877	891	1396	java/lang/Throwable
    //   899	910	1396	java/lang/Throwable
    //   918	932	1396	java/lang/Throwable
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = amsx.a();
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CmShow_SpriteRscBuilder", 2, "[clearAction] clear action success ");
          }
          ((SharedPreferences.Editor)localObject).remove(paramString).apply();
        }
      }
    }
  }
  
  public static boolean a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return false;
    }
    if (paramSpriteTaskParam.k == 1) {
      return b(paramSpriteTaskParam);
    }
    if (paramSpriteTaskParam.k == 6)
    {
      if (!ApolloUtil.c(5, paramSpriteTaskParam.f))
      {
        aniv.a(ApolloUtil.a(), ApolloUtil.c(paramSpriteTaskParam.f) + "/d.zip", ApolloUtil.d(paramSpriteTaskParam.f));
        return false;
      }
    }
    else if (paramSpriteTaskParam.k == 12)
    {
      if (!ApolloUtil.a(paramSpriteTaskParam.f, 0))
      {
        Object localObject = new ApolloActionData();
        ((ApolloActionData)localObject).actionId = paramSpriteTaskParam.f;
        paramSpriteTaskParam = ApolloUtil.a((ApolloActionData)localObject, 5);
        localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
        aniv.a(ApolloUtil.a(), (String)localObject, paramSpriteTaskParam);
        return false;
      }
    }
    else if ((paramSpriteTaskParam.k == 11) || (paramSpriteTaskParam.k == 7))
    {
      paramSpriteTaskParam = anlk.a(paramSpriteTaskParam.k, paramSpriteTaskParam.f, 0, true);
      if ((paramSpriteTaskParam.length > 0) && (!TextUtils.isEmpty(paramSpriteTaskParam[0])) && (!new File(ApolloRender.getRscStaticPath(paramSpriteTaskParam[0], "json")).exists()))
      {
        aniv.a(ApolloUtil.a(), ApolloUtil.a().getCurrentAccountUin(), null, 0, null, -1, -1, true);
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private static JSONArray b(SpriteTaskParam paramSpriteTaskParam, IPCSpriteContext paramIPCSpriteContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: aconst_null
    //   9: astore_0
    //   10: aload_0
    //   11: areturn
    //   12: invokestatic 367	java/lang/System:currentTimeMillis	()J
    //   15: lstore_2
    //   16: new 226	org/json/JSONArray
    //   19: dup
    //   20: invokespecial 227	org/json/JSONArray:<init>	()V
    //   23: astore 6
    //   25: aload_1
    //   26: getfield 416	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_a_of_type_Int	I
    //   29: ifne +132 -> 161
    //   32: aload_1
    //   33: getfield 229	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   36: aload_1
    //   37: iconst_1
    //   38: invokestatic 232	anhm:b	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   41: astore_0
    //   42: aload_1
    //   43: getfield 236	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   46: aload_1
    //   47: iconst_0
    //   48: invokestatic 232	anhm:b	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   51: astore 7
    //   53: aload_1
    //   54: getfield 229	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   57: aload_1
    //   58: iconst_1
    //   59: invokestatic 720	anhm:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   62: astore 8
    //   64: aload_1
    //   65: getfield 236	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   68: aload_1
    //   69: iconst_0
    //   70: invokestatic 720	anhm:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   73: astore_1
    //   74: aload 8
    //   76: ifnull +13 -> 89
    //   79: aload_0
    //   80: ldc_w 722
    //   83: aload 8
    //   85: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   88: pop
    //   89: aload_1
    //   90: ifnull +13 -> 103
    //   93: aload 7
    //   95: ldc_w 722
    //   98: aload_1
    //   99: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   102: pop
    //   103: aload 6
    //   105: aload_0
    //   106: invokevirtual 235	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   109: pop
    //   110: aload 6
    //   112: aload 7
    //   114: invokevirtual 235	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   117: pop
    //   118: invokestatic 367	java/lang/System:currentTimeMillis	()J
    //   121: lstore 4
    //   123: aload 6
    //   125: astore_0
    //   126: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -119 -> 10
    //   132: ldc 217
    //   134: iconst_2
    //   135: iconst_2
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: ldc_w 724
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: lload 4
    //   149: lload_2
    //   150: lsub
    //   151: invokestatic 407	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   154: aastore
    //   155: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   158: aload 6
    //   160: areturn
    //   161: aload_0
    //   162: getfield 207	com/tencent/mobileqq/apollo/script/SpriteTaskParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   165: aload_1
    //   166: iconst_1
    //   167: invokestatic 232	anhm:b	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   170: astore_0
    //   171: aload_1
    //   172: getfield 229	com/tencent/mobileqq/apollo/sdk/IPCSpriteContext:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   175: aload_1
    //   176: iconst_1
    //   177: invokestatic 720	anhm:a	(Ljava/lang/String;Lcom/tencent/mobileqq/apollo/sdk/IPCSpriteContext;Z)Lorg/json/JSONObject;
    //   180: astore_1
    //   181: aload_1
    //   182: ifnull +12 -> 194
    //   185: aload_0
    //   186: ldc_w 722
    //   189: aload_1
    //   190: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload 6
    //   196: aload_0
    //   197: invokevirtual 235	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   200: pop
    //   201: goto -83 -> 118
    //   204: astore_0
    //   205: ldc 217
    //   207: iconst_1
    //   208: ldc_w 726
    //   211: aload_0
    //   212: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   215: invokestatic 367	java/lang/System:currentTimeMillis	()J
    //   218: lstore 4
    //   220: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +29 -> 252
    //   226: ldc 217
    //   228: iconst_2
    //   229: iconst_2
    //   230: anewarray 4	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: ldc_w 724
    //   238: aastore
    //   239: dup
    //   240: iconst_1
    //   241: lload 4
    //   243: lload_2
    //   244: lsub
    //   245: invokestatic 407	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   248: aastore
    //   249: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   252: aconst_null
    //   253: areturn
    //   254: astore_0
    //   255: invokestatic 367	java/lang/System:currentTimeMillis	()J
    //   258: lstore 4
    //   260: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +29 -> 292
    //   266: ldc 217
    //   268: iconst_2
    //   269: iconst_2
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: ldc_w 724
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: lload 4
    //   283: lload_2
    //   284: lsub
    //   285: invokestatic 407	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   288: aastore
    //   289: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   292: aload_0
    //   293: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramSpriteTaskParam	SpriteTaskParam
    //   0	294	1	paramIPCSpriteContext	IPCSpriteContext
    //   15	269	2	l1	long
    //   121	161	4	l2	long
    //   23	172	6	localJSONArray	JSONArray
    //   51	62	7	localJSONObject1	JSONObject
    //   62	22	8	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   16	74	204	java/lang/Throwable
    //   79	89	204	java/lang/Throwable
    //   93	103	204	java/lang/Throwable
    //   103	118	204	java/lang/Throwable
    //   161	181	204	java/lang/Throwable
    //   185	194	204	java/lang/Throwable
    //   194	201	204	java/lang/Throwable
    //   16	74	254	finally
    //   79	89	254	finally
    //   93	103	254	finally
    //   103	118	254	finally
    //   161	181	254	finally
    //   185	194	254	finally
    //   194	201	254	finally
    //   205	215	254	finally
  }
  
  private static JSONObject b(String paramString, IPCSpriteContext paramIPCSpriteContext, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramString);
      anlk.a(paramString, ApolloUtil.a(), localJSONObject, null);
      Object localObject = anlk.a(paramString, ApolloUtil.a(), true);
      if ((localObject == null) || (localObject.length != 2))
      {
        angi.a(301, new Object[] { "roleInfos is null" });
        return null;
      }
      int j = ((Integer)localObject[0]).intValue();
      localObject = (int[])localObject[1];
      if ((localObject == null) || (localObject.length == 0))
      {
        angi.a(301, new Object[] { "dressInfo is null" });
        return null;
      }
      JSONArray localJSONArray = new JSONArray();
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        localJSONArray.put(anlk.a(1, Integer.valueOf(localObject[i]).intValue()));
        i += 1;
      }
      localJSONObject.put("dress", localJSONArray);
      localJSONObject.put("role", anlk.a(0, j));
      if (((paramIPCSpriteContext.jdField_a_of_type_Int == 1) || (paramIPCSpriteContext.jdField_a_of_type_Int == 3000)) && (!"-1".equals(paramString)) && (!"-2".equals(paramString)))
      {
        localJSONObject.put("nameplate", a(ApolloUtil.a(), paramString, j, paramBoolean));
        localObject = paramIPCSpriteContext.jdField_b_of_type_JavaLangString;
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(paramString))) {
          break label419;
        }
      }
      label419:
      for (localObject = anzj.a(2131713124);; localObject = angi.a(ApolloUtil.a(), paramIPCSpriteContext.jdField_a_of_type_Int, paramString, paramIPCSpriteContext.jdField_a_of_type_JavaLangString, true))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localJSONObject.put("nickname", angi.a(bhkv.encodeToString(((String)localObject).getBytes("utf-8"), 0)));
        }
        localJSONObject.put("scale", paramIPCSpriteContext.jdField_a_of_type_Float);
        if (paramIPCSpriteContext.jdField_b_of_type_Float != -2.147484E+009F) {
          localJSONObject.put("xPos", paramIPCSpriteContext.jdField_b_of_type_Float);
        }
        if (paramIPCSpriteContext.c != -2.147484E+009F) {
          localJSONObject.put("yPos", paramIPCSpriteContext.c);
        }
        if ((TextUtils.isEmpty(paramIPCSpriteContext.jdField_b_of_type_JavaLangString)) || (!paramIPCSpriteContext.jdField_b_of_type_JavaLangString.equals(paramString))) {
          break;
        }
        localJSONObject.put("rotate", paramIPCSpriteContext.jdField_d_of_type_Int);
        break label470;
      }
      localJSONObject.put("rotate", paramIPCSpriteContext.e);
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, paramString, new Object[0]);
      return null;
    }
    label470:
    return localJSONObject;
  }
  
  public static boolean b(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return false;
    }
    if (ApolloUtil.a() == null)
    {
      QLog.e("CmShow_SpriteRscBuilder", 1, "CmShow downloadIfAIOActionNotExist taskParam:" + paramSpriteTaskParam);
      return false;
    }
    long l1 = System.currentTimeMillis();
    amsx localamsx = (amsx)ApolloUtil.a().getManager(153);
    ApolloActionData localApolloActionData = ((annx)ApolloUtil.a().getManager(155)).a(paramSpriteTaskParam.f);
    if (localApolloActionData == null)
    {
      QLog.i("CmShow_SpriteRscBuilder", 1, "warning: data is null. call checkApolloPanelJsonVer, id:" + paramSpriteTaskParam.f);
      apcx.a(ApolloUtil.a(), 1);
      return false;
    }
    boolean bool1;
    label158:
    label168:
    Object localObject;
    if (paramSpriteTaskParam.jdField_c_of_type_Int == 1) {
      if (paramSpriteTaskParam.h != 0)
      {
        bool1 = true;
        int j = paramSpriteTaskParam.f;
        int k = paramSpriteTaskParam.jdField_d_of_type_Int;
        if (!bool1) {
          break label339;
        }
        i = 0;
        bool1 = ApolloUtil.a(j, k, i, bool1);
        localObject = ((angf)ApolloUtil.a().getManager(249)).a();
        if (!bool1)
        {
          if (localObject != null) {
            ((SpriteUIHandler)localObject).a(0, 0, paramSpriteTaskParam.jdField_a_of_type_Long);
          }
          bool1 = localamsx.a(localApolloActionData, 4, null);
          if (localObject != null) {
            if (!bool1) {
              break label720;
            }
          }
        }
      }
    }
    label670:
    label676:
    label720:
    for (int i = 0;; i = 6)
    {
      label339:
      label376:
      boolean bool3;
      for (;;)
      {
        ((SpriteUIHandler)localObject).a(i, 1, paramSpriteTaskParam.jdField_a_of_type_Long);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "[downloadIfActionNotExist end, actionId:", Integer.valueOf(paramSpriteTaskParam.f), ",costT:", Long.valueOf(l2 - l1), ",threadId:", Long.valueOf(Thread.currentThread().getId()), ",actionType:", Integer.valueOf(paramSpriteTaskParam.jdField_c_of_type_Int) });
        }
        return true;
        bool1 = false;
        break;
        i = localApolloActionData.personNum;
        break label158;
        if ((ApolloUtil.a(paramSpriteTaskParam.f, localApolloActionData.personNum)) || (ApolloUtil.b(paramSpriteTaskParam.f)))
        {
          bool1 = true;
          bool3 = bool1;
          if (8 == paramSpriteTaskParam.jdField_c_of_type_Int)
          {
            bool3 = bool1;
            if (paramSpriteTaskParam.jdField_d_of_type_JavaLangString != null)
            {
              bool3 = bool1;
              if (bool1) {
                bool3 = bool1;
              }
            }
          }
        }
        else
        {
          try
          {
            localObject = new JSONObject(paramSpriteTaskParam.jdField_d_of_type_JavaLangString).optJSONObject("action");
            bool3 = bool1;
            String str = ((JSONObject)localObject).optString("actionId");
            boolean bool2 = bool1;
            bool3 = bool1;
            if (!TextUtils.isEmpty(str))
            {
              bool3 = bool1;
              i = Integer.parseInt(str);
              bool3 = bool1;
              if (((JSONObject)localObject).optInt("actionPlatform") <= 0) {
                break label670;
              }
              bool4 = true;
              label489:
              bool2 = bool1;
              bool3 = bool1;
              if (!ApolloUtil.a(paramSpriteTaskParam.f, false, i, bool4)) {
                bool2 = false;
              }
            }
            bool1 = bool2;
            bool3 = bool2;
            if (1 == localApolloActionData.personNum)
            {
              bool1 = bool2;
              if (bool2)
              {
                bool3 = bool2;
                str = ((JSONObject)localObject).optString("actionPeerId");
                bool1 = bool2;
                bool3 = bool2;
                if (!TextUtils.isEmpty(str))
                {
                  bool3 = bool2;
                  i = Integer.parseInt(str);
                  bool3 = bool2;
                  if (((JSONObject)localObject).optInt("actionPeerPlatform") <= 0) {
                    break label676;
                  }
                }
              }
            }
            for (boolean bool4 = true;; bool4 = false)
            {
              bool1 = bool2;
              bool3 = bool2;
              if (!ApolloUtil.a(paramSpriteTaskParam.f, true, i, bool4)) {
                bool1 = false;
              }
              if (!bool1)
              {
                bool3 = bool1;
                QLog.e("CmShow_SpriteRscBuilder", 1, "[random] action nis not exist," + paramSpriteTaskParam.jdField_d_of_type_JavaLangString);
              }
              break;
              bool1 = false;
              break label376;
              bool4 = false;
              break label489;
            }
            bool1 = bool3;
          }
          catch (Exception localException)
          {
            QLog.e("CmShow_SpriteRscBuilder", 1, "[random] the json is not right," + paramSpriteTaskParam.jdField_d_of_type_JavaLangString);
          }
        }
      }
      break label168;
    }
  }
  
  public Pair<String, Integer> a(String paramString)
  {
    int i = 2;
    Object localObject = new Pair("def/basic/action/4/action/action", Integer.valueOf(0));
    if (TextUtils.isEmpty(paramString)) {
      return localObject;
    }
    StringBuilder localStringBuilder;
    if ((amsx.a(ApolloUtil.a(), paramString) != 2) && (a(ApolloUtil.a(), paramString)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Int).append("/action/action");
      SharedPreferences localSharedPreferences = ApolloUtil.a().getApp().getSharedPreferences("apollo_sp", 0);
      if (!localSharedPreferences.getBoolean("stand_type_" + this.jdField_a_of_type_Int, false)) {}
      switch (this.jdField_a_of_type_Int)
      {
      case 4: 
      default: 
        localObject = null;
        anfr localanfr = angi.a(ApolloUtil.a());
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localanfr != null)) {
          localanfr.a(paramString, (String)localObject);
        }
        localSharedPreferences.edit().putBoolean("stand_type_" + this.jdField_a_of_type_Int, true).commit();
        if (this.jdField_a_of_type_Anhg.jdField_a_of_type_Int == 3000)
        {
          label244:
          VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
          if (this.jdField_a_of_type_Int != 4) {
            break label357;
          }
        }
        break;
      }
    }
    label357:
    for (i = 7;; i = 0)
    {
      return new Pair(localStringBuilder.toString(), Integer.valueOf(i));
      localObject = anzj.a(2131713125);
      break;
      localObject = anzj.a(2131713132);
      break;
      localObject = anzj.a(2131713126);
      break;
      localObject = anzj.a(2131713128);
      break;
      i = this.jdField_a_of_type_Anhg.jdField_a_of_type_Int;
      break label244;
      return localObject;
    }
  }
  
  public JSONArray a(JSONArray paramJSONArray)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((this.jdField_a_of_type_Anhg == null) || (ApolloUtil.a() == null) || (paramJSONArray == null)) {
      return localJSONArray;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramJSONArray.length();
    int i = 0;
    for (;;)
    {
      int k;
      if (i < j) {
        try
        {
          k = ((Integer)paramJSONArray.get(i)).intValue();
          if (k == 0) {
            break label196;
          }
          if (ApolloUtil.a(k, 0)) {
            break label166;
          }
          QLog.e("ApolloPet", 1, "getPetActions download:" + k);
          Object localObject = new ApolloActionData();
          ((ApolloActionData)localObject).actionId = k;
          String str = ApolloUtil.a((ApolloActionData)localObject, 5);
          localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
          aniv.a(ApolloUtil.a(), (String)localObject, str);
        }
        catch (Exception paramJSONArray)
        {
          QLog.e("ApolloPet", 1, "getPetActions error:", paramJSONArray);
        }
      } else {
        return localJSONArray;
      }
      label166:
      localStringBuilder.setLength(0);
      localStringBuilder.append(k).append("/action/action");
      localJSONArray.put(localStringBuilder.toString());
      label196:
      i += 1;
    }
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
  }
  
  boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return false;
    }
    int i;
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString))
    {
      i = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(paramString)).intValue();
      if (!jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        break label686;
      }
    }
    label686:
    for (int j = ((Integer)jdField_a_of_type_JavaUtilMap.get(paramString)).intValue();; j = 0)
    {
      Object localObject = amsx.a();
      VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)paramQQAppInterface.a(71);
      JSONArray localJSONArray;
      try
      {
        if (this.d.get(paramString) == null) {}
        for (long l = 0L; (!((SharedPreferences)localObject).contains(paramString)) && (NetConnInfoCenter.getServerTime() - l > 180L); l = ((Long)this.d.get(paramString)).longValue())
        {
          paramQQAppInterface = new JSONObject();
          paramQQAppInterface.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, paramQQAppInterface.toString()).commit();
          localVasExtensionHandler.a(new long[] { Long.parseLong(paramString) });
          this.d.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
          return false;
        }
        JSONObject localJSONObject = new JSONObject(((SharedPreferences)localObject).getString(paramString, "{}"));
        localJSONArray = localJSONObject.optJSONArray("action");
        l = localJSONObject.optLong("lastRequestTime");
        if ((j >= 5) || (NetConnInfoCenter.getServerTime() - l > 10800000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "hasSpecialStandAction getApolloStandAction openCount:", Integer.valueOf(j), ",lastRequestSpTime:", Long.valueOf(l) });
          }
          jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(0));
          localVasExtensionHandler.a(new long[] { Long.parseLong(paramString) });
          localJSONObject.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, localJSONObject.toString()).commit();
        }
        for (;;)
        {
          if (localJSONArray == null) {
            break label692;
          }
          if (localJSONArray.length() > 0) {
            break;
          }
          break label692;
          jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(j + 1));
        }
        j = i;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("CmShow_SpriteRscBuilder", 2, "hasSpecialStandAction error:", paramQQAppInterface);
        return false;
      }
      if (i >= localJSONArray.length()) {
        j = 0;
      }
      localObject = localJSONArray.getJSONObject(j);
      this.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("type");
      this.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("id");
      if ((this.jdField_a_of_type_Int == 4) && (!((amsx)paramQQAppInterface.getManager(153)).b(paramString).hasPet))
      {
        a(paramString);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteRscBuilder", 2, new Object[] { "[hasSpecialStandAction] uin:", paramString, ",index:", Integer.valueOf(j), ",id:", Integer.valueOf(this.jdField_b_of_type_Int), ",standType:", Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      if (!ApolloUtil.a(this.jdField_b_of_type_Int, 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CmShow_SpriteRscBuilder", 2, "hasSpecialStandAction isActionResDone is false.");
        }
        paramString = new ApolloActionData();
        paramString.actionId = this.jdField_b_of_type_Int;
        localObject = ApolloUtil.a(paramString, 5);
        aniv.a(paramQQAppInterface, ApolloUtil.a(paramString, 4), (String)localObject);
        return false;
      }
      this.jdField_b_of_type_JavaUtilMap.put(paramString, Integer.valueOf(j + 1));
      return true;
      i = 0;
      break;
    }
    label692:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhm
 * JD-Core Version:    0.7.0.1
 */