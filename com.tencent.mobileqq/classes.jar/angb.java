import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class angb
{
  static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  int jdField_a_of_type_Int = -1;
  private anga jdField_a_of_type_Anga;
  int jdField_b_of_type_Int = -1;
  Map<String, Integer> jdField_b_of_type_JavaUtilMap = new HashMap();
  Map<String, String> c = new ConcurrentHashMap(2);
  private Map<String, Long> d = new HashMap();
  
  public angb(anga paramanga)
  {
    this.jdField_a_of_type_Anga = paramanga;
  }
  
  public static Pair<String, Integer> a(String paramString, int paramInt)
  {
    Pair localPair = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = localPair;
    }
    int i;
    String str;
    do
    {
      do
      {
        return paramString;
        i = ApolloUtil.a(248.0F, paramString, paramInt);
        if (ApolloUtil.e(0, i)) {
          break;
        }
        paramString = localPair;
      } while (!QLog.isColorLevel());
      QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "getQzoneBubbleRsc, bubble res not exist bubbleId=", Integer.valueOf(i) });
      return null;
      str = anlk.a(0, i, paramInt);
      localPair = new Pair(str, Integer.valueOf(i));
      paramString = localPair;
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "getQzoneBubbleRsc, bubbleId=", Integer.valueOf(i), ", bubbleRsc=", str });
    return localPair;
  }
  
  private angd a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 0;
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return null;
    }
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {}
    Object localObject1;
    Object localObject2;
    for (int i = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(paramString)).intValue();; i = 0)
    {
      localObject1 = (amsx)paramQQAppInterface.getManager(153);
      localObject2 = ((amsx)localObject1).a(paramQQAppInterface, paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = new JSONArray((String)localObject2);
        if (((JSONArray)localObject3).length() <= 0) {
          return null;
        }
        if (i >= ((JSONArray)localObject3).length())
        {
          i = j;
          localObject2 = new angd();
          localObject3 = ((JSONArray)localObject3).getJSONObject(i);
          ((angd)localObject2).jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("type");
          ((angd)localObject2).jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("id");
          localObject3 = ((amsx)localObject1).b(paramString);
          if (localObject3 == null) {
            return null;
          }
          if ((((angd)localObject2).jdField_b_of_type_Int == 4) && (!((ApolloBaseInfo)localObject3).hasPet))
          {
            ((ApolloBaseInfo)localObject3).appearAction = null;
            ((amsx)localObject1).a((ApolloBaseInfo)localObject3);
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[hasAppearAction] index:", Integer.valueOf(i), ",id:", Integer.valueOf(((angd)localObject2).jdField_a_of_type_Int), ",standType:", Integer.valueOf(((angd)localObject2).jdField_b_of_type_Int) });
          }
          if (((angd)localObject2).jdField_a_of_type_Int <= 0)
          {
            QLog.e("cmshow_scripted_SpriteRscBuilder", 1, new Object[] { "appearAction not correct,actionId:", Integer.valueOf(((angd)localObject2).jdField_a_of_type_Int) });
            return null;
          }
          if (!ApolloUtil.a(((angd)localObject2).jdField_a_of_type_Int, 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("cmshow_scripted_SpriteRscBuilder", 2, "hasAppearAction isActionResDone is false.");
            }
            paramString = new ApolloActionData();
            paramString.actionId = ((angd)localObject2).jdField_a_of_type_Int;
            localObject1 = ApolloUtil.a(paramString, 5);
            aniv.a(paramQQAppInterface, ApolloUtil.a(paramString, 4), (String)localObject1);
            return null;
          }
          this.jdField_b_of_type_JavaUtilMap.put(paramString, Integer.valueOf(i + 1));
          return localObject2;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 2, "hasAppearAction error:", paramQQAppInterface);
        return null;
      }
    }
  }
  
  private SpriteTaskParam a(angd paramangd)
  {
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    if (paramangd == null)
    {
      localSpriteTaskParam.f = 4;
      localSpriteTaskParam.k = 2;
      localSpriteTaskParam.g = 5;
      localSpriteTaskParam.jdField_a_of_type_Long = 1000000L;
    }
    do
    {
      return localSpriteTaskParam;
      localSpriteTaskParam.jdField_a_of_type_Int = 1;
      localSpriteTaskParam.f = paramangd.jdField_a_of_type_Int;
      localSpriteTaskParam.k = 12;
      localSpriteTaskParam.g = 5;
      localSpriteTaskParam.jdField_a_of_type_Long = 1000000L;
    } while (paramangd.jdField_b_of_type_Int != 4);
    localSpriteTaskParam.jdField_c_of_type_Int = 7;
    return localSpriteTaskParam;
  }
  
  private String a(int paramInt)
  {
    if ((this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Anga.a() == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = ((amsx)this.jdField_a_of_type_Anga.a().getManager(153)).a(paramInt);
    if ((paramInt != -1) && (!ApolloUtil.a(paramInt, 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloPet", 2, "download random pet action:" + paramInt);
      }
      Object localObject = new ApolloActionData();
      ((ApolloActionData)localObject).actionId = paramInt;
      String str = ApolloUtil.a((ApolloActionData)localObject, 5);
      localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
      aniv.a(this.jdField_a_of_type_Anga.a(), (String)localObject, str);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramInt != -1) {
        localStringBuilder.append(paramInt).append("/action/action");
      }
    }
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
      QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "getNicknamePath uin:", ApolloUtil.d(paramString), ", isMe:", Boolean.valueOf(bool2), ",isYellowVip:", Boolean.valueOf(bool1), ",isRight:", Boolean.valueOf(paramBoolean), ",bubbleId:", Integer.valueOf(i) });
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
  
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ((!ApolloUtil.e(paramInt1, paramInt2)) && (!ApolloUtil.e(0, paramInt2))) {
      return "";
    }
    return anlk.a(paramInt1, paramInt2, paramInt3);
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
  
  private String a(boolean paramBoolean, String paramString, int paramInt)
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
          break label249;
        }
        bool1 = true;
        break label246;
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
      QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[random] the json is not right," + paramString);
    }
    for (;;)
    {
      label246:
      break;
      label249:
      bool1 = false;
    }
  }
  
  private JSONArray a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Anga == null)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject2 = a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anga, paramSpriteTaskParam, true, false);
        if ((this.jdField_a_of_type_Anga.jdField_a_of_type_Int == 0) || (paramSpriteTaskParam.e == 1))
        {
          localJSONObject1 = a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anga, paramSpriteTaskParam, false, false);
          if (localJSONObject2 != null)
          {
            localJSONArray.put(localJSONObject2);
            JSONObject localJSONObject3 = a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anga, true);
            if (localJSONObject3 != null) {
              localJSONObject2.put("pet", localJSONObject3);
            }
          }
          if (localJSONObject1 != null)
          {
            localJSONArray.put(localJSONObject1);
            paramSpriteTaskParam = a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anga, false);
            if (paramSpriteTaskParam != null) {
              localJSONObject1.put("pet", paramSpriteTaskParam);
            }
          }
          return localJSONArray;
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getBasicActionJs],", paramSpriteTaskParam);
        return null;
      }
      finally
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[getBasicActionJs], cost:", Long.valueOf(l2 - l1) });
        }
      }
      JSONObject localJSONObject1 = null;
    }
  }
  
  public static JSONArray a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramQQAppInterface == null)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteRscBuilder", 2, "[getActionJson]");
    }
    for (;;)
    {
      JSONArray localJSONArray1;
      int j;
      boolean bool2;
      try
      {
        localJSONArray1 = new JSONArray();
        paramJSONObject = paramJSONObject.optString("actionList");
        JSONArray localJSONArray2 = new JSONArray(paramJSONObject);
        if ((localJSONArray2 == null) || (localJSONArray2.length() == 0)) {
          break label504;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,", paramJSONObject });
        }
        annx localannx = (annx)paramQQAppInterface.getManager(155);
        int i = 0;
        j = 0;
        if (j < localJSONArray2.length())
        {
          paramJSONObject = localJSONArray2.getJSONObject(j);
          if (paramJSONObject == null) {
            break label507;
          }
          int k = paramJSONObject.optInt("actionId");
          int m = paramJSONObject.optInt("perNum");
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,actId:", Integer.valueOf(k), ",perNum:", Integer.valueOf(m) });
          }
          if (-1 == m)
          {
            paramJSONObject = localannx.a(k);
            if (paramJSONObject != null) {
              break label501;
            }
            QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "ReqAction,[getActionsPath], warning: data is null. call checkApolloPanelJsonVer, id:" + k);
            if (i == 0)
            {
              apcx.a(paramQQAppInterface, 1);
              i = 1;
              break label507;
            }
          }
          else
          {
            paramJSONObject = new ApolloActionData();
            paramJSONObject.actionId = k;
            paramJSONObject.personNum = m;
            bool2 = ApolloUtil.a(k, paramJSONObject.personNum);
            Object localObject = (amsx)paramQQAppInterface.getManager(153);
            if (bool2) {
              break label495;
            }
            bool1 = ((amsx)localObject).a(paramJSONObject, 4, null);
            if (!QLog.isColorLevel()) {
              break label514;
            }
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,isActionDone:", Boolean.valueOf(bool2), ",ret:", Boolean.valueOf(bool1) });
            break label514;
            localObject = new JSONObject();
            String[] arrayOfString = anlk.a(1, k, 0, true);
            ((JSONObject)localObject).put("actionId", k);
            ((JSONObject)localObject).put("actionPath", anlk.a(arrayOfString[0], 3));
            if (paramJSONObject.personNum == 1) {
              ((JSONObject)localObject).put("peerPath", anlk.a(anlk.a(1, k, 0, false)[0], 3));
            }
            localJSONArray1.put(localObject);
            if (QLog.isColorLevel()) {
              QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "ReqAction,put into array, id:", Integer.valueOf(k) });
            }
          }
          break label507;
        }
        else
        {
          return localJSONArray1;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramQQAppInterface, new Object[0]);
        return null;
      }
      label495:
      boolean bool1 = false;
      continue;
      label501:
      continue;
      label504:
      return localJSONArray1;
      label507:
      j += 1;
      continue;
      label514:
      if (!bool2) {
        if (!bool1) {}
      }
    }
  }
  
  private JSONObject a(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new SpriteTaskParam();
      ((SpriteTaskParam)localObject).f = paramInt1;
      ((SpriteTaskParam)localObject).jdField_d_of_type_Int = paramInt2;
      ((SpriteTaskParam)localObject).h = this.jdField_a_of_type_Anga.jdField_a_of_type_Int;
      ((SpriteTaskParam)localObject).jdField_c_of_type_Int = 1;
      if (!a((SpriteTaskParam)localObject)) {
        return null;
      }
      localObject = ((annx)this.jdField_a_of_type_Anga.a().getManager(155)).a(paramInt1);
      if (localObject == null) {
        return null;
      }
      localJSONObject.put("actionId", paramInt1);
      localJSONObject.put("action", anlk.a(paramInt1, paramInt2, true, this.jdField_a_of_type_Anga.a())[0]);
      if (((ApolloActionData)localObject).personNum == 1) {
        localJSONObject.put("actionPeer", anlk.a(paramInt1, paramInt2, false, this.jdField_a_of_type_Anga.a())[0]);
      }
      if (this.jdField_a_of_type_Anga.jdField_a_of_type_Int == 0)
      {
        localJSONObject.put("actionDis", ((ApolloActionData)localObject).actionMoveDis * (float)bhlo.j() / 7.0F / 368.0F);
        localJSONObject.put("actionPeerDis", ((ApolloActionData)localObject).peerMoveDis * (float)bhlo.j() / 7.0F / 368.0F);
      }
      else
      {
        localJSONObject.put("posType", ((ApolloActionData)localObject).playArea);
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getWhiteFaceSingleAction],", localThrowable);
      return null;
    }
    return localThrowable;
  }
  
  private JSONObject a(String paramString, anga paramanga, SpriteTaskParam paramSpriteTaskParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    JSONObject localJSONObject = null;
    Object localObject = localJSONObject;
    for (;;)
    {
      int j;
      try
      {
        if (paramanga.g())
        {
          localObject = localJSONObject;
          if (paramSpriteTaskParam.f > 0) {
            localObject = ApolloActionData.getModelString(paramSpriteTaskParam.f);
          }
        }
        localJSONObject = a(paramString, paramanga, angi.a(paramString, paramSpriteTaskParam, paramanga, paramBoolean1), (String)localObject);
        if (!a(paramSpriteTaskParam)) {
          return localJSONObject;
        }
        j = amsx.a(paramanga.a(), paramString);
        int k = ((Integer)anlk.a(paramString, j, paramanga.a(), true)[0]).intValue();
        localObject = paramString;
        if (amsx.b(paramanga.a(), paramString, false) == 0)
        {
          localObject = paramString;
          if (paramanga.g())
          {
            if (!b(paramanga.a(), paramString)) {
              break label528;
            }
            paramString = "-2";
            break label520;
          }
        }
        paramString = anlk.a((String)localObject, paramanga.a(), true);
        if ((paramString == null) || (paramString.length != 2)) {
          break label526;
        }
        int m = ((Integer)paramString[0]).intValue();
        if (paramSpriteTaskParam == null) {
          break;
        }
        if (!paramBoolean1) {
          break label537;
        }
        i = 1;
        localJSONObject.put("isMaster", i);
        if ((paramBoolean1) && (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)))
        {
          localJSONObject.put("text", angi.a(bhkv.encodeToString(paramSpriteTaskParam.jdField_c_of_type_JavaLangString.getBytes("utf-8"), 0)));
          if (paramSpriteTaskParam.jdField_b_of_type_Boolean) {
            continue;
          }
          localJSONObject.put("bubbleType", 0);
          if ((j == 1) && (paramSpriteTaskParam.f > annv.jdField_a_of_type_Int) && (amsx.a(paramanga.a())))
          {
            i = 2;
            localJSONObject.put("bubble", a(paramSpriteTaskParam.jdField_c_of_type_JavaLangString, m, i));
          }
        }
        else
        {
          int n = paramSpriteTaskParam.k;
          int i1 = paramSpriteTaskParam.f;
          i = m;
          if (k >= 0) {
            i = k;
          }
          paramString = anlk.a(n, i1, i, paramBoolean1, j);
          if (paramString == null) {
            break label535;
          }
          if (paramString.length >= 2) {
            break label403;
          }
          break label535;
        }
        if ((j != 2) || (paramSpriteTaskParam.f >= annv.jdField_a_of_type_Int)) {
          break label513;
        }
        i = 1;
        continue;
        localJSONObject.put("bubbleType", 1);
        continue;
        if (paramSpriteTaskParam.e != 0) {
          break label430;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramString, new Object[0]);
        return null;
      }
      label403:
      if ((paramanga.jdField_a_of_type_Int == 0) && (!paramBoolean1) && (!paramBoolean2)) {
        break;
      }
      label430:
      paramanga = paramString[0];
      paramString = paramanga;
      if (8 == paramSpriteTaskParam.jdField_c_of_type_Int)
      {
        paramString = paramanga;
        if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_d_of_type_JavaLangString))
        {
          paramSpriteTaskParam = a(paramBoolean1, paramSpriteTaskParam.jdField_d_of_type_JavaLangString, paramSpriteTaskParam.f);
          paramString = paramanga;
          if (!TextUtils.isEmpty(paramSpriteTaskParam)) {
            paramString = paramanga + paramSpriteTaskParam;
          }
        }
      }
      localJSONObject.put("action", paramString);
      break;
      label513:
      int i = j;
      continue;
      for (;;)
      {
        label520:
        localObject = paramString;
        break;
        label526:
        return null;
        label528:
        paramString = "-1";
      }
      label535:
      return null;
      label537:
      i = 0;
    }
    return localJSONObject;
  }
  
  private JSONObject a(String paramString1, anga paramanga, boolean paramBoolean, String paramString2)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("uin", paramString1);
        anlk.a(paramString1, paramanga.a(), localJSONObject, paramString2);
        if ((amsx.b(paramanga.a(), paramString1, false) == 0) && (paramanga.g()))
        {
          if (!b(paramanga.a(), paramString1)) {
            break label474;
          }
          paramString2 = "-2";
          paramString2 = anlk.a(paramString2, paramanga.a(), true);
          if ((paramString2 == null) || (paramString2.length != 2))
          {
            angi.a(301, new Object[] { "roleInfos is null" });
            return null;
          }
          int j = ((Integer)paramString2[0]).intValue();
          paramString2 = (int[])paramString2[1];
          if ((paramString2 == null) || (paramString2.length == 0))
          {
            angi.a(301, new Object[] { "dressInfo is null" });
            return null;
          }
          JSONArray localJSONArray = new JSONArray();
          int k = paramString2.length;
          int i = 0;
          if (i < k)
          {
            localJSONArray.put(anlk.a(1, Integer.valueOf(paramString2[i]).intValue()));
            i += 1;
            continue;
          }
          localJSONObject.put("dress", localJSONArray);
          localJSONObject.put("role", anlk.a(0, j));
          if (((paramanga.jdField_a_of_type_Int == 1) || (paramanga.jdField_a_of_type_Int == 3000)) && (!"-1".equals(paramString1)) && (!"-2".equals(paramString1)))
          {
            localJSONObject.put("nameplate", a(paramanga.a(), paramString1, j, paramBoolean));
            paramString2 = paramanga.jdField_b_of_type_JavaLangString;
            if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(paramString1))) {
              continue;
            }
            paramString1 = anzj.a(2131713124);
            if (!TextUtils.isEmpty(paramString1)) {
              localJSONObject.put("nickname", angi.a(bhkv.encodeToString(paramString1.getBytes("utf-8"), 0)));
            }
          }
          if (this.jdField_a_of_type_Anga.jdField_a_of_type_Amxq == null) {
            break;
          }
          localJSONObject.put("scale", this.jdField_a_of_type_Anga.jdField_a_of_type_Amxq.jdField_a_of_type_Float);
          localJSONObject.put("xPos", this.jdField_a_of_type_Anga.jdField_a_of_type_Amxq.b);
          localJSONObject.put("yPos", this.jdField_a_of_type_Anga.jdField_a_of_type_Amxq.c);
          break;
          paramString1 = angi.a(paramanga.a(), paramanga.jdField_a_of_type_Int, paramString1, paramanga.jdField_a_of_type_JavaLangString, true);
          continue;
        }
        paramString2 = paramString1;
      }
      catch (Throwable paramString1)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramString1, new Object[0]);
        return null;
      }
      continue;
      label474:
      paramString2 = "-1";
    }
    return localJSONObject;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, anol paramanol)
  {
    if (paramArrayOfInt == null) {
      return;
    }
    int i;
    if (paramInt == 0)
    {
      QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "role id is 0, uin:" + ApolloUtil.d(paramString));
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        anog.a(-1L, paramQQAppInterface, paramString, "", 0, "", paramanol);
        return;
        i = 0;
        for (;;)
        {
          if (i >= paramArrayOfInt.length) {
            break label156;
          }
          if (!ApolloUtil.c(paramArrayOfInt[i]))
          {
            QLog.w("cmshow_scripted_SpriteRscBuilder", 2, "dress rsc NOT exist, id:" + paramArrayOfInt[i]);
            i = 1;
            break;
          }
          i += 1;
        }
      }
      if (paramanol == null) {
        break;
      }
      paramanol.a(-1L, paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 10);
      return;
      label156:
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, anjh paramanjh)
  {
    int i;
    if (!ApolloUtil.d(paramString))
    {
      i = 1;
      if (i == 0) {
        break label25;
      }
      aniv.a(paramQQAppInterface, paramString, paramanjh);
    }
    label25:
    while (paramanjh == null)
    {
      return;
      i = 0;
      break;
    }
    paramanjh.a(true, 0);
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
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, "[clearAction] clear action success ");
          }
          ((SharedPreferences.Editor)localObject).remove(paramString).apply();
        }
      }
    }
  }
  
  private JSONArray b(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Anga == null)) {
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
        localannx = (annx)this.jdField_a_of_type_Anga.a().getManager(155);
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
              localObject = a(j, 2);
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
              localObject = a(m, 0);
              if (localObject != null) {
                localJSONArray.put(localObject);
              }
            }
            localObject = a(m, 1);
            if (localObject == null) {
              break label431;
            }
            localJSONArray.put(localObject);
            break label431;
          }
          j = -1;
          i = 1;
          QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "[insertPrePost], action NOT exist locally, id:" + m);
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        JSONArray localJSONArray;
        annx localannx;
        int i;
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getWhiteFaceActions],", paramSpriteTaskParam);
        return null;
        if (-1 != j)
        {
          paramSpriteTaskParam = localannx.a(j);
          if ((paramSpriteTaskParam != null) && (paramSpriteTaskParam.isHasPostAction()))
          {
            paramSpriteTaskParam = a(j, 2);
            if (paramSpriteTaskParam != null) {
              localJSONArray.put(paramSpriteTaskParam);
            }
          }
        }
        if (i != 0) {
          apcx.a(this.jdField_a_of_type_Anga.a(), 1);
        }
        return localJSONArray;
      }
      finally
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[getWhiteFaceActions], cost:", Long.valueOf(l2 - l1) });
        }
      }
      label431:
      int j = m;
      k += 1;
    }
  }
  
  private JSONObject b(String paramString, anga paramanga, boolean paramBoolean)
  {
    return a(paramString, paramanga, paramBoolean, null);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, anol paramanol)
  {
    int k = 0;
    if (paramArrayOfInt == null) {}
    do
    {
      return;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < paramArrayOfInt.length)
        {
          if (!ApolloUtil.c(paramArrayOfInt[i]))
          {
            QLog.w("cmshow_scripted_SpriteRscBuilder", 2, "checkThreeDressRsc rsc NOT exist, id:" + paramArrayOfInt[i]);
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break;
          }
          c(paramQQAppInterface, paramString, paramInt, paramArrayOfInt, paramanol);
          return;
        }
        i += 1;
      }
    } while (paramanol == null);
    paramanol.a(-1L, paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 10);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((anyw)paramQQAppInterface.getManager(51)).b(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.gender == 2;
    }
    return false;
  }
  
  /* Error */
  private JSONArray c(SpriteTaskParam paramSpriteTaskParam)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   8: ifnonnull +7 -> 15
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: invokestatic 366	java/lang/System:currentTimeMillis	()J
    //   18: lstore_2
    //   19: new 125	org/json/JSONArray
    //   22: dup
    //   23: invokespecial 367	org/json/JSONArray:<init>	()V
    //   26: astore 6
    //   28: aload_0
    //   29: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   32: getfield 373	anga:jdField_a_of_type_Int	I
    //   35: ifne +163 -> 198
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   43: getfield 591	anga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   46: aload_0
    //   47: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   50: iconst_1
    //   51: invokespecial 715	angb:b	(Ljava/lang/String;Langa;Z)Lorg/json/JSONObject;
    //   54: astore_1
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   60: getfield 616	anga:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload_0
    //   64: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   67: iconst_0
    //   68: invokespecial 715	angb:b	(Ljava/lang/String;Langa;Z)Lorg/json/JSONObject;
    //   71: astore 7
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   78: getfield 591	anga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   81: aload_0
    //   82: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   85: iconst_1
    //   86: invokevirtual 383	angb:a	(Ljava/lang/String;Langa;Z)Lorg/json/JSONObject;
    //   89: astore 8
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   96: getfield 616	anga:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   99: aload_0
    //   100: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   103: iconst_0
    //   104: invokevirtual 383	angb:a	(Ljava/lang/String;Langa;Z)Lorg/json/JSONObject;
    //   107: astore 9
    //   109: aload 8
    //   111: ifnull +13 -> 124
    //   114: aload_1
    //   115: ldc_w 385
    //   118: aload 8
    //   120: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   123: pop
    //   124: aload 9
    //   126: ifnull +14 -> 140
    //   129: aload 7
    //   131: ldc_w 385
    //   134: aload 9
    //   136: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload 6
    //   142: aload_1
    //   143: invokevirtual 380	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   146: pop
    //   147: aload 6
    //   149: aload 7
    //   151: invokevirtual 380	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   154: pop
    //   155: invokestatic 366	java/lang/System:currentTimeMillis	()J
    //   158: lstore 4
    //   160: aload 6
    //   162: astore_1
    //   163: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq -153 -> 13
    //   169: ldc 68
    //   171: iconst_2
    //   172: iconst_2
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: ldc_w 717
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: lload 4
    //   186: lload_2
    //   187: lsub
    //   188: invokestatic 395	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   191: aastore
    //   192: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   195: aload 6
    //   197: areturn
    //   198: aload_0
    //   199: aload_1
    //   200: getfield 369	com/tencent/mobileqq/apollo/script/SpriteTaskParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   203: aload_0
    //   204: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   207: iconst_1
    //   208: invokespecial 715	angb:b	(Ljava/lang/String;Langa;Z)Lorg/json/JSONObject;
    //   211: astore_1
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   217: getfield 591	anga:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   220: aload_0
    //   221: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   224: iconst_1
    //   225: invokevirtual 383	angb:a	(Ljava/lang/String;Langa;Z)Lorg/json/JSONObject;
    //   228: astore 7
    //   230: aload 7
    //   232: ifnull +13 -> 245
    //   235: aload_1
    //   236: ldc_w 385
    //   239: aload 7
    //   241: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   244: pop
    //   245: aload 6
    //   247: aload_1
    //   248: invokevirtual 380	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   251: pop
    //   252: goto -97 -> 155
    //   255: astore_1
    //   256: ldc 68
    //   258: iconst_1
    //   259: ldc_w 719
    //   262: aload_1
    //   263: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: invokestatic 366	java/lang/System:currentTimeMillis	()J
    //   269: lstore 4
    //   271: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +29 -> 303
    //   277: ldc 68
    //   279: iconst_2
    //   280: iconst_2
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: ldc_w 717
    //   289: aastore
    //   290: dup
    //   291: iconst_1
    //   292: lload 4
    //   294: lload_2
    //   295: lsub
    //   296: invokestatic 395	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   299: aastore
    //   300: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   303: aconst_null
    //   304: areturn
    //   305: astore_1
    //   306: invokestatic 366	java/lang/System:currentTimeMillis	()J
    //   309: lstore 4
    //   311: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq +29 -> 343
    //   317: ldc 68
    //   319: iconst_2
    //   320: iconst_2
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: ldc_w 717
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: lload 4
    //   334: lload_2
    //   335: lsub
    //   336: invokestatic 395	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   339: aastore
    //   340: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   343: aload_1
    //   344: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	angb
    //   0	345	1	paramSpriteTaskParam	SpriteTaskParam
    //   18	317	2	l1	long
    //   158	175	4	l2	long
    //   26	220	6	localJSONArray	JSONArray
    //   71	169	7	localJSONObject1	JSONObject
    //   89	30	8	localJSONObject2	JSONObject
    //   107	28	9	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   19	109	255	java/lang/Throwable
    //   114	124	255	java/lang/Throwable
    //   129	140	255	java/lang/Throwable
    //   140	155	255	java/lang/Throwable
    //   198	230	255	java/lang/Throwable
    //   235	245	255	java/lang/Throwable
    //   245	252	255	java/lang/Throwable
    //   19	109	305	finally
    //   114	124	305	finally
    //   129	140	305	finally
    //   140	155	305	finally
    //   198	230	305	finally
    //   235	245	305	finally
    //   245	252	305	finally
    //   256	266	305	finally
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt, int[] paramArrayOfInt, anol paramanol)
  {
    if ((anlk.a(paramString, paramInt, paramArrayOfInt, paramQQAppInterface, new angc(paramanol, paramQQAppInterface, paramInt, paramArrayOfInt))) && (paramanol != null)) {
      paramanol.a(-1L, paramQQAppInterface, paramString, "", "", paramInt, paramArrayOfInt, 22);
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
    if ((amsx.a(this.jdField_a_of_type_Anga.a(), paramString) != 2) && (a(this.jdField_a_of_type_Anga.a(), paramString)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Int).append("/action/action");
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_Anga.a().getApp().getSharedPreferences("apollo_sp", 0);
      if (!localSharedPreferences.getBoolean("stand_type_" + this.jdField_a_of_type_Int, false)) {}
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        localObject = null;
        anfr localanfr = angi.a(this.jdField_a_of_type_Anga.a());
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localanfr != null)) {
          localanfr.a(paramString, (String)localObject);
        }
        localSharedPreferences.edit().putBoolean("stand_type_" + this.jdField_a_of_type_Int, true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "getSpriteShowPath stand:", Integer.valueOf(this.jdField_a_of_type_Int), ", uin:", ApolloUtil.d(paramString) });
        }
        if (this.jdField_a_of_type_Anga.jdField_a_of_type_Int == 3000)
        {
          label297:
          VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, this.jdField_a_of_type_Int, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
          if (this.jdField_a_of_type_Int != 4) {
            break label400;
          }
        }
        break;
      }
    }
    label400:
    for (i = 7;; i = 0)
    {
      return new Pair(localStringBuilder.toString(), Integer.valueOf(i));
      localObject = anzj.a(2131713128);
      break;
      localObject = anzj.a(2131713132);
      break;
      localObject = anzj.a(2131713126);
      break;
      i = this.jdField_a_of_type_Anga.jdField_a_of_type_Int;
      break label297;
      return localObject;
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Anga == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2;
      JSONObject localJSONObject3;
      if (this.jdField_a_of_type_Anga.jdField_a_of_type_Int == 0)
      {
        localJSONObject2 = b(this.jdField_a_of_type_Anga.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anga, true);
        localJSONObject3 = b(this.jdField_a_of_type_Anga.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anga, false);
        JSONObject localJSONObject4;
        if (amsx.a(this.jdField_a_of_type_Anga.a(), this.jdField_a_of_type_Anga.jdField_b_of_type_JavaLangString) != 2)
        {
          localJSONObject4 = a(this.jdField_a_of_type_Anga.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anga, true);
          if (localJSONObject4 != null) {
            localJSONObject2.put("pet", localJSONObject4);
          }
        }
        if (amsx.a(this.jdField_a_of_type_Anga.a(), this.jdField_a_of_type_Anga.jdField_a_of_type_JavaLangString) != 2)
        {
          localJSONObject4 = a(this.jdField_a_of_type_Anga.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anga, false);
          if (localJSONObject4 != null) {
            localJSONObject3.put("pet", localJSONObject4);
          }
        }
        localJSONArray.put(localJSONObject2);
        localJSONArray.put(localJSONObject3);
      }
      for (;;)
      {
        localJSONObject1.put("sprites", localJSONArray);
        return localJSONObject1.toString();
        localJSONObject2 = b(this.jdField_a_of_type_Anga.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anga, true);
        if (amsx.a(this.jdField_a_of_type_Anga.a(), this.jdField_a_of_type_Anga.jdField_b_of_type_JavaLangString) != 2)
        {
          localJSONObject3 = a(this.jdField_a_of_type_Anga.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Anga, true);
          if (localJSONObject3 != null) {
            localJSONObject2.put("pet", localJSONObject3);
          }
        }
        localJSONArray.put(localJSONObject2);
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getSpriteJsParam],", localThrowable);
    }
  }
  
  String a(int paramInt, String paramString)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Anga.a() == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject = paramInt + "_" + paramString;
    if (this.c.containsKey(localObject)) {
      return (String)this.c.get(localObject);
    }
    localObject = (amsx)this.jdField_a_of_type_Anga.a().getManager(153);
    if (TextUtils.isEmpty(((amsx)localObject).j)) {
      return null;
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(((amsx)localObject).j);
        int j = localJSONArray.length();
        if (i < j)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          int k = localJSONObject.optInt("roleId", -1);
          if ((k == -1) || (k != paramInt)) {
            continue;
          }
          paramInt = localJSONObject.getInt(paramString);
          if (ApolloUtil.a(paramInt, 0)) {
            return paramInt + "/action/action";
          }
          QLog.e("ApolloPet", 1, "getPetBasicActions download action:" + paramInt);
          paramString = new ApolloActionData();
          paramString.actionId = paramInt;
          ((amsx)localObject).a(paramString, 4);
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloPet", 1, "getPetBasicActions error:", paramString);
        continue;
      }
      return null;
      i += 1;
    }
  }
  
  public String a(SpriteTaskParam paramSpriteTaskParam)
  {
    int j = 0;
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Anga == null)) {
      return null;
    }
    label349:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        int i;
        if (this.jdField_a_of_type_Anga.e == 0)
        {
          localObject = ApolloActionData.getModelString(paramSpriteTaskParam.f);
          localJSONObject.put("model", localObject);
          localJSONObject.put("actionId", paramSpriteTaskParam.f);
          localJSONObject.put("taskId", paramSpriteTaskParam.jdField_a_of_type_Int);
          localJSONObject.put("actionType", paramSpriteTaskParam.jdField_c_of_type_Int);
          localJSONObject.put("from", paramSpriteTaskParam.g);
          if (!angi.a(this.jdField_a_of_type_Anga.a())) {
            break label349;
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
            localObject = c(paramSpriteTaskParam);
            JSONArray localJSONArray = b(paramSpriteTaskParam);
            localJSONObject.put("sprites", localObject);
            localJSONObject.put("actions", localJSONArray);
            localObject = a(paramSpriteTaskParam);
            if (localObject != null) {
              localJSONObject.put("audio", localObject);
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
            localObject = ApolloActionData.getModelString(paramSpriteTaskParam.f);
            continue;
          }
          if (paramSpriteTaskParam.k == 14)
          {
            localObject = "3D";
            continue;
          }
          localObject = anlk.a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anga.a());
          continue;
        }
        Object localObject = a(paramSpriteTaskParam);
        if (localObject != null)
        {
          localJSONObject.put("sprites", localObject);
          continue;
          i = 0;
        }
      }
      catch (Throwable paramSpriteTaskParam)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[getActionJsParam],", paramSpriteTaskParam);
        return null;
      }
    }
  }
  
  public JSONArray a(JSONArray paramJSONArray)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Anga.a() == null) || (paramJSONArray == null)) {
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
            break label205;
          }
          if (ApolloUtil.a(k, 0)) {
            break label174;
          }
          QLog.e("ApolloPet", 1, "getPetActions download:" + k);
          Object localObject = new ApolloActionData();
          ((ApolloActionData)localObject).actionId = k;
          String str = ApolloUtil.a((ApolloActionData)localObject, 5);
          localObject = ApolloUtil.a((ApolloActionData)localObject, 4);
          aniv.a(this.jdField_a_of_type_Anga.a(), (String)localObject, str);
        }
        catch (Exception paramJSONArray)
        {
          QLog.e("ApolloPet", 1, "getPetActions error:", paramJSONArray);
        }
      } else {
        return localJSONArray;
      }
      label174:
      localStringBuilder.setLength(0);
      localStringBuilder.append(k).append("/action/action");
      localJSONArray.put(localStringBuilder.toString());
      label205:
      i += 1;
    }
  }
  
  public JSONObject a(SpriteTaskParam paramSpriteTaskParam)
  {
    label377:
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
              QLog.d("cmshow_scripted_SpriteRscBuilder", 1, new Object[] { "[getAudioParam] audio not found for " + (String)localObject2, ",action:", Integer.valueOf(paramSpriteTaskParam.f) });
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
          localObject2 = (amsx)this.jdField_a_of_type_Anga.a().getManager(153);
          ApolloActionData localApolloActionData = ((annx)this.jdField_a_of_type_Anga.a().getManager(155)).a(paramSpriteTaskParam.f);
          if ((localApolloActionData != null) && (localApolloActionData.hasSound))
          {
            localObject1 = annv.jdField_d_of_type_JavaLangString + paramSpriteTaskParam.f + "/" + "music.amr";
            if (new File((String)localObject1).exists()) {
              break label377;
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
            aniv.a(this.jdField_a_of_type_Anga.a(), null, paramSpriteTaskParam.i, false);
            localObject1 = localObject2;
            continue;
          }
          return null;
        }
      }
      catch (Exception paramSpriteTaskParam)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 1, paramSpriteTaskParam, new Object[0]);
        return null;
      }
    }
  }
  
  /* Error */
  public JSONObject a(String paramString, anga paramanga, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 142	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 435	org/json/JSONObject:<init>	()V
    //   7: astore 14
    //   9: iconst_1
    //   10: istore 11
    //   12: iconst_1
    //   13: istore 12
    //   15: iconst_1
    //   16: istore 6
    //   18: iconst_m1
    //   19: istore 5
    //   21: new 678	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 894	java/util/ArrayList:<init>	()V
    //   28: astore 15
    //   30: aload_2
    //   31: invokevirtual 234	anga:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   34: sipush 153
    //   37: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   40: checkcast 120	amsx
    //   43: astore 13
    //   45: iload 5
    //   47: istore 9
    //   49: iload 11
    //   51: istore 7
    //   53: iload 5
    //   55: istore 10
    //   57: iload 12
    //   59: istore 8
    //   61: aload 13
    //   63: aload_1
    //   64: invokevirtual 153	amsx:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   67: astore 16
    //   69: aload 16
    //   71: ifnonnull +5 -> 76
    //   74: aconst_null
    //   75: areturn
    //   76: iload 5
    //   78: istore 9
    //   80: iload 11
    //   82: istore 7
    //   84: iload 5
    //   86: istore 10
    //   88: iload 12
    //   90: istore 8
    //   92: aload 16
    //   94: invokevirtual 898	com/tencent/mobileqq/data/ApolloBaseInfo:getApolloPetDress	()Lamxm;
    //   97: astore 17
    //   99: aload 17
    //   101: ifnull +988 -> 1089
    //   104: iload 5
    //   106: istore 9
    //   108: iload 11
    //   110: istore 7
    //   112: iload 5
    //   114: istore 10
    //   116: iload 12
    //   118: istore 8
    //   120: aload 16
    //   122: getfield 159	com/tencent/mobileqq/data/ApolloBaseInfo:hasPet	Z
    //   125: ifeq +964 -> 1089
    //   128: iload 5
    //   130: istore 9
    //   132: iload 11
    //   134: istore 7
    //   136: iload 5
    //   138: istore 10
    //   140: iload 12
    //   142: istore 8
    //   144: aload 17
    //   146: getfield 903	amxm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   149: ifnull +940 -> 1089
    //   152: iload 5
    //   154: istore 9
    //   156: iload 11
    //   158: istore 7
    //   160: iload 5
    //   162: istore 10
    //   164: iload 12
    //   166: istore 8
    //   168: aload 17
    //   170: getfield 903	amxm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   173: invokevirtual 905	java/util/HashMap:isEmpty	()Z
    //   176: ifne +913 -> 1089
    //   179: iload 5
    //   181: istore 9
    //   183: iload 11
    //   185: istore 7
    //   187: iload 5
    //   189: istore 10
    //   191: iload 12
    //   193: istore 8
    //   195: aload 14
    //   197: ldc_w 586
    //   200: iconst_0
    //   201: aload 17
    //   203: getfield 906	amxm:jdField_a_of_type_Int	I
    //   206: invokestatic 582	anlk:a	(II)Ljava/lang/String;
    //   209: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   212: pop
    //   213: iload 5
    //   215: istore 4
    //   217: iload 5
    //   219: istore 9
    //   221: iload 11
    //   223: istore 7
    //   225: iload 5
    //   227: istore 10
    //   229: iload 12
    //   231: istore 8
    //   233: iconst_1
    //   234: aload 17
    //   236: getfield 906	amxm:jdField_a_of_type_Int	I
    //   239: invokestatic 908	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(II)Z
    //   242: ifne +27 -> 269
    //   245: iconst_0
    //   246: istore 7
    //   248: iconst_0
    //   249: istore 8
    //   251: iconst_0
    //   252: istore 6
    //   254: iload 5
    //   256: istore 9
    //   258: iload 5
    //   260: istore 10
    //   262: aload 17
    //   264: getfield 906	amxm:jdField_a_of_type_Int	I
    //   267: istore 4
    //   269: iload 4
    //   271: istore 9
    //   273: iload 6
    //   275: istore 7
    //   277: iload 4
    //   279: istore 10
    //   281: iload 6
    //   283: istore 8
    //   285: aload 17
    //   287: getfield 903	amxm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   290: invokevirtual 909	java/util/HashMap:size	()I
    //   293: newarray int
    //   295: astore 18
    //   297: iload 4
    //   299: istore 9
    //   301: iload 6
    //   303: istore 7
    //   305: iload 4
    //   307: istore 10
    //   309: iload 6
    //   311: istore 8
    //   313: aload 17
    //   315: getfield 903	amxm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   318: invokevirtual 913	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   321: invokeinterface 919 1 0
    //   326: astore 19
    //   328: iconst_0
    //   329: istore 5
    //   331: iload 4
    //   333: istore 9
    //   335: iload 6
    //   337: istore 7
    //   339: iload 4
    //   341: istore 10
    //   343: iload 6
    //   345: istore 8
    //   347: aload 19
    //   349: invokeinterface 924 1 0
    //   354: ifeq +54 -> 408
    //   357: iload 4
    //   359: istore 9
    //   361: iload 6
    //   363: istore 7
    //   365: iload 4
    //   367: istore 10
    //   369: iload 6
    //   371: istore 8
    //   373: aload 18
    //   375: iload 5
    //   377: aload 19
    //   379: invokeinterface 928 1 0
    //   384: checkcast 930	java/util/Map$Entry
    //   387: invokeinterface 933 1 0
    //   392: checkcast 72	java/lang/Integer
    //   395: invokevirtual 112	java/lang/Integer:intValue	()I
    //   398: iastore
    //   399: iload 5
    //   401: iconst_1
    //   402: iadd
    //   403: istore 5
    //   405: goto -74 -> 331
    //   408: iload 4
    //   410: istore 9
    //   412: iload 6
    //   414: istore 7
    //   416: iload 4
    //   418: istore 10
    //   420: iload 6
    //   422: istore 8
    //   424: new 125	org/json/JSONArray
    //   427: dup
    //   428: invokespecial 367	org/json/JSONArray:<init>	()V
    //   431: astore 19
    //   433: iload 4
    //   435: istore 9
    //   437: iload 6
    //   439: istore 7
    //   441: iload 4
    //   443: istore 10
    //   445: iload 6
    //   447: istore 8
    //   449: aload 18
    //   451: arraylength
    //   452: istore 11
    //   454: iload 6
    //   456: istore 5
    //   458: iconst_0
    //   459: istore 8
    //   461: iload 8
    //   463: iload 11
    //   465: if_icmpge +72 -> 537
    //   468: aload 18
    //   470: iload 8
    //   472: iaload
    //   473: istore 9
    //   475: iload 5
    //   477: istore 6
    //   479: iload 5
    //   481: istore 7
    //   483: aload 19
    //   485: iconst_1
    //   486: iload 9
    //   488: invokestatic 582	anlk:a	(II)Ljava/lang/String;
    //   491: invokevirtual 380	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   494: pop
    //   495: iload 5
    //   497: istore 6
    //   499: iload 5
    //   501: istore 7
    //   503: iconst_2
    //   504: iload 9
    //   506: invokestatic 908	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(II)Z
    //   509: ifne +937 -> 1446
    //   512: iconst_0
    //   513: istore 7
    //   515: iconst_0
    //   516: istore 5
    //   518: iconst_0
    //   519: istore 6
    //   521: aload 15
    //   523: iload 9
    //   525: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   528: invokeinterface 938 2 0
    //   533: pop
    //   534: goto +912 -> 1446
    //   537: iload 5
    //   539: istore 6
    //   541: iload 5
    //   543: istore 7
    //   545: aload 14
    //   547: ldc_w 584
    //   550: aload 19
    //   552: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   555: pop
    //   556: iload 5
    //   558: istore 6
    //   560: iload 5
    //   562: istore 7
    //   564: aload 14
    //   566: ldc_w 308
    //   569: aload 17
    //   571: getfield 906	amxm:jdField_a_of_type_Int	I
    //   574: invokevirtual 441	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   577: pop
    //   578: iload 5
    //   580: istore 6
    //   582: iload 5
    //   584: istore 7
    //   586: aload_0
    //   587: aload 17
    //   589: getfield 906	amxm:jdField_a_of_type_Int	I
    //   592: ldc_w 940
    //   595: invokevirtual 942	angb:a	(ILjava/lang/String;)Ljava/lang/String;
    //   598: astore 18
    //   600: iload 5
    //   602: istore 6
    //   604: iload 5
    //   606: istore 7
    //   608: aload_0
    //   609: aload 17
    //   611: getfield 906	amxm:jdField_a_of_type_Int	I
    //   614: ldc_w 944
    //   617: invokevirtual 942	angb:a	(ILjava/lang/String;)Ljava/lang/String;
    //   620: astore 19
    //   622: iload 5
    //   624: istore 6
    //   626: iload 5
    //   628: istore 7
    //   630: aload 18
    //   632: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   635: ifne +57 -> 692
    //   638: iload 5
    //   640: istore 6
    //   642: iload 5
    //   644: istore 7
    //   646: aload 19
    //   648: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   651: ifne +41 -> 692
    //   654: iload 5
    //   656: istore 6
    //   658: iload 5
    //   660: istore 7
    //   662: aload 14
    //   664: ldc_w 946
    //   667: aload 19
    //   669: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   672: pop
    //   673: iload 5
    //   675: istore 6
    //   677: iload 5
    //   679: istore 7
    //   681: aload 14
    //   683: ldc_w 948
    //   686: aload 18
    //   688: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   691: pop
    //   692: iload 5
    //   694: istore 6
    //   696: iload 5
    //   698: istore 7
    //   700: aload_0
    //   701: aload 17
    //   703: getfield 906	amxm:jdField_a_of_type_Int	I
    //   706: invokespecial 949	angb:a	(I)Ljava/lang/String;
    //   709: astore 18
    //   711: iload 5
    //   713: istore 6
    //   715: iload 5
    //   717: istore 7
    //   719: aload 18
    //   721: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   724: ifne +22 -> 746
    //   727: iload 5
    //   729: istore 6
    //   731: iload 5
    //   733: istore 7
    //   735: aload 14
    //   737: ldc_w 951
    //   740: aload 18
    //   742: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   745: pop
    //   746: iload 5
    //   748: istore 6
    //   750: iload 5
    //   752: istore 7
    //   754: aload 16
    //   756: getfield 954	com/tencent/mobileqq/data/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   759: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   762: ifne +53 -> 815
    //   765: iload 5
    //   767: istore 6
    //   769: iload 5
    //   771: istore 7
    //   773: aload_2
    //   774: getfield 805	anga:e	I
    //   777: ifne +38 -> 815
    //   780: iload 5
    //   782: istore 6
    //   784: iload 5
    //   786: istore 7
    //   788: aload 14
    //   790: ldc_w 598
    //   793: aload 16
    //   795: getfield 954	com/tencent/mobileqq/data/ApolloBaseInfo:petNick	Ljava/lang/String;
    //   798: ldc_w 530
    //   801: invokevirtual 534	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   804: iconst_0
    //   805: invokestatic 540	bhkv:encodeToString	([BI)Ljava/lang/String;
    //   808: invokestatic 542	angi:a	(Ljava/lang/String;)Ljava/lang/String;
    //   811: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   814: pop
    //   815: iload 5
    //   817: istore 6
    //   819: iload 5
    //   821: istore 7
    //   823: aload 14
    //   825: ldc_w 588
    //   828: aload 13
    //   830: getfield 796	amsx:j	Ljava/lang/String;
    //   833: aload 17
    //   835: getfield 906	amxm:jdField_a_of_type_Int	I
    //   838: iload_3
    //   839: invokestatic 956	angb:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   842: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   845: pop
    //   846: iload 5
    //   848: istore 6
    //   850: iload 5
    //   852: istore 7
    //   854: aload_0
    //   855: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   858: getfield 601	anga:jdField_a_of_type_Amxq	Lamxq;
    //   861: ifnull +87 -> 948
    //   864: iload 5
    //   866: istore 6
    //   868: iload 5
    //   870: istore 7
    //   872: aload 14
    //   874: ldc_w 603
    //   877: aload_0
    //   878: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   881: getfield 601	anga:jdField_a_of_type_Amxq	Lamxq;
    //   884: getfield 607	amxq:jdField_a_of_type_Float	F
    //   887: f2d
    //   888: invokevirtual 485	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   891: pop
    //   892: iload 5
    //   894: istore 6
    //   896: iload 5
    //   898: istore 7
    //   900: aload 14
    //   902: ldc_w 609
    //   905: aload_0
    //   906: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   909: getfield 601	anga:jdField_a_of_type_Amxq	Lamxq;
    //   912: getfield 611	amxq:b	F
    //   915: f2d
    //   916: invokevirtual 485	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   919: pop
    //   920: iload 5
    //   922: istore 6
    //   924: iload 5
    //   926: istore 7
    //   928: aload 14
    //   930: ldc_w 613
    //   933: aload_0
    //   934: getfield 43	angb:jdField_a_of_type_Anga	Langa;
    //   937: getfield 601	anga:jdField_a_of_type_Amxq	Lamxq;
    //   940: getfield 615	amxq:c	F
    //   943: f2d
    //   944: invokevirtual 485	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   947: pop
    //   948: iload 5
    //   950: ifeq +110 -> 1060
    //   953: iload 5
    //   955: ifne +488 -> 1443
    //   958: aload_2
    //   959: ifnull +484 -> 1443
    //   962: aload_2
    //   963: invokevirtual 234	anga:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   966: ifnull +477 -> 1443
    //   969: ldc 242
    //   971: iconst_1
    //   972: new 236	java/lang/StringBuilder
    //   975: dup
    //   976: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   979: ldc_w 958
    //   982: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: aload_1
    //   986: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   992: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   995: aload 13
    //   997: ifnull +446 -> 1443
    //   1000: aload 15
    //   1002: invokeinterface 959 1 0
    //   1007: newarray int
    //   1009: astore 16
    //   1011: aload 15
    //   1013: invokeinterface 960 1 0
    //   1018: astore 15
    //   1020: iconst_0
    //   1021: istore 5
    //   1023: aload 15
    //   1025: invokeinterface 924 1 0
    //   1030: ifeq +36 -> 1066
    //   1033: aload 16
    //   1035: iload 5
    //   1037: aload 15
    //   1039: invokeinterface 928 1 0
    //   1044: checkcast 72	java/lang/Integer
    //   1047: invokevirtual 112	java/lang/Integer:intValue	()I
    //   1050: iastore
    //   1051: iload 5
    //   1053: iconst_1
    //   1054: iadd
    //   1055: istore 5
    //   1057: goto -34 -> 1023
    //   1060: aconst_null
    //   1061: astore 14
    //   1063: goto -110 -> 953
    //   1066: aload_2
    //   1067: invokevirtual 234	anga:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1070: aload_1
    //   1071: aload 13
    //   1073: invokevirtual 963	amsx:a	()Lanje;
    //   1076: iload 4
    //   1078: aload 16
    //   1080: iconst_m1
    //   1081: iconst_m1
    //   1082: iconst_1
    //   1083: invokestatic 966	aniv:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lanje;I[IIIZ)V
    //   1086: aload 14
    //   1088: areturn
    //   1089: aconst_null
    //   1090: areturn
    //   1091: astore 14
    //   1093: aconst_null
    //   1094: astore 13
    //   1096: iconst_1
    //   1097: istore 6
    //   1099: iload 5
    //   1101: istore 4
    //   1103: iload 6
    //   1105: istore 5
    //   1107: ldc 68
    //   1109: iconst_1
    //   1110: aload 14
    //   1112: iconst_0
    //   1113: anewarray 4	java/lang/Object
    //   1116: invokestatic 453	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1119: iload 5
    //   1121: ifne +125 -> 1246
    //   1124: aload_2
    //   1125: ifnull +121 -> 1246
    //   1128: aload_2
    //   1129: invokevirtual 234	anga:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1132: ifnull +114 -> 1246
    //   1135: ldc 242
    //   1137: iconst_1
    //   1138: new 236	java/lang/StringBuilder
    //   1141: dup
    //   1142: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   1145: ldc_w 958
    //   1148: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: aload_1
    //   1152: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1158: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1161: aload 13
    //   1163: ifnull +83 -> 1246
    //   1166: aload 15
    //   1168: invokeinterface 959 1 0
    //   1173: newarray int
    //   1175: astore 14
    //   1177: aload 15
    //   1179: invokeinterface 960 1 0
    //   1184: astore 15
    //   1186: iconst_0
    //   1187: istore 5
    //   1189: aload 15
    //   1191: invokeinterface 924 1 0
    //   1196: ifeq +30 -> 1226
    //   1199: aload 14
    //   1201: iload 5
    //   1203: aload 15
    //   1205: invokeinterface 928 1 0
    //   1210: checkcast 72	java/lang/Integer
    //   1213: invokevirtual 112	java/lang/Integer:intValue	()I
    //   1216: iastore
    //   1217: iload 5
    //   1219: iconst_1
    //   1220: iadd
    //   1221: istore 5
    //   1223: goto -34 -> 1189
    //   1226: aload_2
    //   1227: invokevirtual 234	anga:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1230: aload_1
    //   1231: aload 13
    //   1233: invokevirtual 963	amsx:a	()Lanje;
    //   1236: iload 4
    //   1238: aload 14
    //   1240: iconst_m1
    //   1241: iconst_m1
    //   1242: iconst_1
    //   1243: invokestatic 966	aniv:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lanje;I[IIIZ)V
    //   1246: aconst_null
    //   1247: areturn
    //   1248: astore 14
    //   1250: aconst_null
    //   1251: astore 13
    //   1253: iconst_1
    //   1254: istore 6
    //   1256: iload 5
    //   1258: istore 4
    //   1260: iload 6
    //   1262: istore 5
    //   1264: iload 5
    //   1266: ifne +125 -> 1391
    //   1269: aload_2
    //   1270: ifnull +121 -> 1391
    //   1273: aload_2
    //   1274: invokevirtual 234	anga:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1277: ifnull +114 -> 1391
    //   1280: ldc 242
    //   1282: iconst_1
    //   1283: new 236	java/lang/StringBuilder
    //   1286: dup
    //   1287: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   1290: ldc_w 958
    //   1293: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: aload_1
    //   1297: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1303: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1306: aload 13
    //   1308: ifnull +83 -> 1391
    //   1311: aload 15
    //   1313: invokeinterface 959 1 0
    //   1318: newarray int
    //   1320: astore 16
    //   1322: aload 15
    //   1324: invokeinterface 960 1 0
    //   1329: astore 15
    //   1331: iconst_0
    //   1332: istore 5
    //   1334: aload 15
    //   1336: invokeinterface 924 1 0
    //   1341: ifeq +30 -> 1371
    //   1344: aload 16
    //   1346: iload 5
    //   1348: aload 15
    //   1350: invokeinterface 928 1 0
    //   1355: checkcast 72	java/lang/Integer
    //   1358: invokevirtual 112	java/lang/Integer:intValue	()I
    //   1361: iastore
    //   1362: iload 5
    //   1364: iconst_1
    //   1365: iadd
    //   1366: istore 5
    //   1368: goto -34 -> 1334
    //   1371: aload_2
    //   1372: invokevirtual 234	anga:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1375: aload_1
    //   1376: aload 13
    //   1378: invokevirtual 963	amsx:a	()Lanje;
    //   1381: iload 4
    //   1383: aload 16
    //   1385: iconst_m1
    //   1386: iconst_m1
    //   1387: iconst_1
    //   1388: invokestatic 966	aniv:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lanje;I[IIIZ)V
    //   1391: aload 14
    //   1393: athrow
    //   1394: astore 14
    //   1396: iload 7
    //   1398: istore 5
    //   1400: iload 9
    //   1402: istore 4
    //   1404: goto -140 -> 1264
    //   1407: astore 14
    //   1409: iload 6
    //   1411: istore 5
    //   1413: goto -149 -> 1264
    //   1416: astore 14
    //   1418: goto -154 -> 1264
    //   1421: astore 14
    //   1423: iload 8
    //   1425: istore 5
    //   1427: iload 10
    //   1429: istore 4
    //   1431: goto -324 -> 1107
    //   1434: astore 14
    //   1436: iload 7
    //   1438: istore 5
    //   1440: goto -333 -> 1107
    //   1443: aload 14
    //   1445: areturn
    //   1446: iload 8
    //   1448: iconst_1
    //   1449: iadd
    //   1450: istore 8
    //   1452: goto -991 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1455	0	this	angb
    //   0	1455	1	paramString	String
    //   0	1455	2	paramanga	anga
    //   0	1455	3	paramBoolean	boolean
    //   215	1215	4	i	int
    //   19	1420	5	j	int
    //   16	1394	6	k	int
    //   51	1386	7	m	int
    //   59	1392	8	n	int
    //   47	1354	9	i1	int
    //   55	1373	10	i2	int
    //   10	456	11	i3	int
    //   13	217	12	i4	int
    //   43	1334	13	localamsx	amsx
    //   7	1080	14	localJSONObject	JSONObject
    //   1091	20	14	localThrowable1	Throwable
    //   1175	64	14	arrayOfInt	int[]
    //   1248	144	14	localObject1	Object
    //   1394	1	14	localObject2	Object
    //   1407	1	14	localObject3	Object
    //   1416	1	14	localObject4	Object
    //   1421	1	14	localThrowable2	Throwable
    //   1434	10	14	localThrowable3	Throwable
    //   28	1321	15	localObject5	Object
    //   67	1317	16	localObject6	Object
    //   97	737	17	localamxm	amxm
    //   295	446	18	localObject7	Object
    //   326	342	19	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   30	45	1091	java/lang/Throwable
    //   30	45	1248	finally
    //   61	69	1394	finally
    //   92	99	1394	finally
    //   120	128	1394	finally
    //   144	152	1394	finally
    //   168	179	1394	finally
    //   195	213	1394	finally
    //   233	245	1394	finally
    //   262	269	1394	finally
    //   285	297	1394	finally
    //   313	328	1394	finally
    //   347	357	1394	finally
    //   373	399	1394	finally
    //   424	433	1394	finally
    //   449	454	1394	finally
    //   483	495	1407	finally
    //   503	512	1407	finally
    //   521	534	1407	finally
    //   545	556	1407	finally
    //   564	578	1407	finally
    //   586	600	1407	finally
    //   608	622	1407	finally
    //   630	638	1407	finally
    //   646	654	1407	finally
    //   662	673	1407	finally
    //   681	692	1407	finally
    //   700	711	1407	finally
    //   719	727	1407	finally
    //   735	746	1407	finally
    //   754	765	1407	finally
    //   773	780	1407	finally
    //   788	815	1407	finally
    //   823	846	1407	finally
    //   854	864	1407	finally
    //   872	892	1407	finally
    //   900	920	1407	finally
    //   928	948	1407	finally
    //   1107	1119	1416	finally
    //   61	69	1421	java/lang/Throwable
    //   92	99	1421	java/lang/Throwable
    //   120	128	1421	java/lang/Throwable
    //   144	152	1421	java/lang/Throwable
    //   168	179	1421	java/lang/Throwable
    //   195	213	1421	java/lang/Throwable
    //   233	245	1421	java/lang/Throwable
    //   262	269	1421	java/lang/Throwable
    //   285	297	1421	java/lang/Throwable
    //   313	328	1421	java/lang/Throwable
    //   347	357	1421	java/lang/Throwable
    //   373	399	1421	java/lang/Throwable
    //   424	433	1421	java/lang/Throwable
    //   449	454	1421	java/lang/Throwable
    //   483	495	1434	java/lang/Throwable
    //   503	512	1434	java/lang/Throwable
    //   521	534	1434	java/lang/Throwable
    //   545	556	1434	java/lang/Throwable
    //   564	578	1434	java/lang/Throwable
    //   586	600	1434	java/lang/Throwable
    //   608	622	1434	java/lang/Throwable
    //   630	638	1434	java/lang/Throwable
    //   646	654	1434	java/lang/Throwable
    //   662	673	1434	java/lang/Throwable
    //   681	692	1434	java/lang/Throwable
    //   700	711	1434	java/lang/Throwable
    //   719	727	1434	java/lang/Throwable
    //   735	746	1434	java/lang/Throwable
    //   754	765	1434	java/lang/Throwable
    //   773	780	1434	java/lang/Throwable
    //   788	815	1434	java/lang/Throwable
    //   823	846	1434	java/lang/Throwable
    //   854	864	1434	java/lang/Throwable
    //   872	892	1434	java/lang/Throwable
    //   900	920	1434	java/lang/Throwable
    //   928	948	1434	java/lang/Throwable
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
  }
  
  public void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Object localObject3;
    Object localObject1;
    do
    {
      return;
      localObject3 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      i = 1;
      localObject1 = null;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramList = a(this.jdField_a_of_type_Anga.a(), str);
        if (str.equals(this.jdField_a_of_type_Anga.jdField_b_of_type_JavaLangString)) {}
        for (localObject1 = a(paramList);; localObject1 = localObject2)
        {
          ((SpriteTaskParam)localObject1).jdField_a_of_type_Int = i;
          ((SpriteTaskParam)localObject1).jdField_a_of_type_Boolean = true;
          ((SpriteTaskParam)localObject1).jdField_a_of_type_JavaLangString = str;
          ((List)localObject3).add(localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "playAppearAction task action:", Integer.valueOf(((SpriteTaskParam)localObject1).f), ",uin:", str.substring(0, 4) });
          }
          i += 1;
          localObject1 = paramList;
          break;
          localObject2 = a(paramList);
          paramList = (List<String>)localObject1;
        }
      }
      angi.a(this.jdField_a_of_type_Anga, (List)localObject3);
    } while (localObject1 == null);
    Object localObject2 = this.jdField_a_of_type_Anga.a().getApp().getSharedPreferences("apollo_sp", 0);
    if (!((SharedPreferences)localObject2).getBoolean("stand_type_" + ((angd)localObject1).jdField_b_of_type_Int, false)) {}
    switch (((angd)localObject1).jdField_b_of_type_Int)
    {
    default: 
      paramList = null;
      localObject3 = angi.a(this.jdField_a_of_type_Anga.a());
      if ((!TextUtils.isEmpty(paramList)) && (localObject3 != null)) {
        ((anfr)localObject3).a(this.jdField_a_of_type_Anga.jdField_b_of_type_JavaLangString, paramList);
      }
      ((SharedPreferences)localObject2).edit().putBoolean("stand_type_" + ((angd)localObject1).jdField_b_of_type_Int, true).commit();
      if (this.jdField_a_of_type_Anga.jdField_a_of_type_Int != 3000) {
        break;
      }
    }
    for (int i = 2;; i = this.jdField_a_of_type_Anga.jdField_a_of_type_Int)
    {
      VipUtils.a(null, "cmshow", "Apollo", "appearanceaction", i, ((angd)localObject1).jdField_b_of_type_Int, new String[] { String.valueOf(((angd)localObject1).jdField_a_of_type_Int) });
      return;
      paramList = anzj.a(2131713127);
      break;
      paramList = anzj.a(2131713123);
      break;
      paramList = anzj.a(2131713130);
      break;
    }
  }
  
  public boolean a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Anga.a() == null)) {
      return false;
    }
    if (paramSpriteTaskParam.k == 1) {
      return b(paramSpriteTaskParam);
    }
    if (paramSpriteTaskParam.k == 6)
    {
      if (!ApolloUtil.c(5, paramSpriteTaskParam.f))
      {
        aniv.a(this.jdField_a_of_type_Anga.a(), ApolloUtil.c(paramSpriteTaskParam.f) + "/d.zip", ApolloUtil.d(paramSpriteTaskParam.f));
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
        aniv.a(this.jdField_a_of_type_Anga.a(), (String)localObject, paramSpriteTaskParam);
        return false;
      }
    }
    else if ((paramSpriteTaskParam.k == 11) || (paramSpriteTaskParam.k == 7))
    {
      paramSpriteTaskParam = anlk.a(paramSpriteTaskParam.k, paramSpriteTaskParam.f, 0, true);
      if ((paramSpriteTaskParam.length > 0) && (!TextUtils.isEmpty(paramSpriteTaskParam[0])) && (!new File(ApolloRender.getRscStaticPath(paramSpriteTaskParam[0], "json")).exists()))
      {
        aniv.a(this.jdField_a_of_type_Anga.a(), this.jdField_a_of_type_Anga.a().getCurrentAccountUin(), null, 0, null, -1, -1, true);
        return false;
      }
    }
    return true;
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
        break label682;
      }
    }
    label682:
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
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "hasSpecialStandAction getApolloStandAction openCount:", Integer.valueOf(j), ",lastRequestSpTime:", Long.valueOf(l) });
          }
          jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(0));
          localVasExtensionHandler.a(new long[] { Long.parseLong(paramString) });
          localJSONObject.put("lastRequestTime", NetConnInfoCenter.getServerTimeMillis());
          ((SharedPreferences)localObject).edit().putString(paramString, localJSONObject.toString()).commit();
        }
        for (;;)
        {
          if (localJSONArray == null) {
            break label688;
          }
          if (localJSONArray.length() > 0) {
            break;
          }
          break label688;
          jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(j + 1));
        }
        j = i;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("cmshow_scripted_SpriteRscBuilder", 2, "hasSpecialStandAction error:", paramQQAppInterface);
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
        QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[hasSpecialStandAction] uin:", paramString, ",index:", Integer.valueOf(j), ",id:", Integer.valueOf(this.jdField_b_of_type_Int), ",standType:", Integer.valueOf(this.jdField_a_of_type_Int) });
      }
      if (!ApolloUtil.a(this.jdField_b_of_type_Int, 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("cmshow_scripted_SpriteRscBuilder", 2, "hasSpecialStandAction isActionResDone is false.");
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
    label688:
    return false;
  }
  
  public boolean b(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Anga.a() == null)) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    amsx localamsx = (amsx)this.jdField_a_of_type_Anga.a().getManager(153);
    ApolloActionData localApolloActionData = ((annx)this.jdField_a_of_type_Anga.a().getManager(155)).a(paramSpriteTaskParam.f);
    if (localApolloActionData == null)
    {
      QLog.i("cmshow_scripted_SpriteRscBuilder", 1, "warning: data is null. call checkApolloPanelJsonVer, id:" + paramSpriteTaskParam.f);
      apcx.a(this.jdField_a_of_type_Anga.a(), 1);
      return false;
    }
    int j;
    int k;
    int i;
    if (paramSpriteTaskParam.jdField_c_of_type_Int == 1) {
      if (paramSpriteTaskParam.h != 0)
      {
        bool1 = true;
        j = paramSpriteTaskParam.f;
        k = paramSpriteTaskParam.jdField_d_of_type_Int;
        if (!bool1) {
          break label340;
        }
        i = 0;
      }
    }
    label154:
    label340:
    boolean bool3;
    label644:
    label650:
    label694:
    label700:
    for (boolean bool1 = ApolloUtil.a(j, k, i, bool1);; bool1 = bool3)
    {
      Object localObject = ((angf)this.jdField_a_of_type_Anga.a().getManager(249)).a();
      if (!bool1)
      {
        if (localObject != null) {
          ((SpriteUIHandler)localObject).a(0, 0, paramSpriteTaskParam.jdField_a_of_type_Long);
        }
        bool1 = localamsx.a(localApolloActionData, 4, null);
        if (localObject != null) {
          if (!bool1) {
            break label694;
          }
        }
      }
      for (i = 0;; i = 6) {
        for (;;)
        {
          ((SpriteUIHandler)localObject).a(i, 1, paramSpriteTaskParam.jdField_a_of_type_Long);
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteRscBuilder", 2, new Object[] { "[downloadIfActionNotExist end, actionId:", Integer.valueOf(paramSpriteTaskParam.f), ",costT:", Long.valueOf(l2 - l1), ",threadId:", Long.valueOf(Thread.currentThread().getId()), ",actionType:", Integer.valueOf(paramSpriteTaskParam.jdField_c_of_type_Int) });
          }
          return true;
          bool1 = false;
          break;
          i = localApolloActionData.personNum;
          break label154;
          bool3 = ApolloUtil.a(paramSpriteTaskParam.f, localApolloActionData.personNum);
          if ((8 != paramSpriteTaskParam.jdField_c_of_type_Int) || (paramSpriteTaskParam.jdField_d_of_type_JavaLangString == null) || (!bool3)) {
            break label700;
          }
          boolean bool2 = bool3;
          try
          {
            localObject = new JSONObject(paramSpriteTaskParam.jdField_d_of_type_JavaLangString).optJSONObject("action");
            bool2 = bool3;
            String str = ((JSONObject)localObject).optString("actionId");
            bool1 = bool3;
            bool2 = bool3;
            if (!TextUtils.isEmpty(str))
            {
              bool2 = bool3;
              i = Integer.parseInt(str);
              bool2 = bool3;
              if (((JSONObject)localObject).optInt("actionPlatform") <= 0) {
                break label644;
              }
              bool4 = true;
              label465:
              bool1 = bool3;
              bool2 = bool3;
              if (!ApolloUtil.a(paramSpriteTaskParam.f, false, i, bool4)) {
                bool1 = false;
              }
            }
            bool3 = bool1;
            bool2 = bool1;
            if (1 == localApolloActionData.personNum)
            {
              bool3 = bool1;
              if (bool1)
              {
                bool2 = bool1;
                str = ((JSONObject)localObject).optString("actionPeerId");
                bool3 = bool1;
                bool2 = bool1;
                if (!TextUtils.isEmpty(str))
                {
                  bool2 = bool1;
                  i = Integer.parseInt(str);
                  bool2 = bool1;
                  if (((JSONObject)localObject).optInt("actionPeerPlatform") <= 0) {
                    break label650;
                  }
                }
              }
            }
            for (boolean bool4 = true;; bool4 = false)
            {
              bool3 = bool1;
              bool2 = bool1;
              if (!ApolloUtil.a(paramSpriteTaskParam.f, true, i, bool4)) {
                bool3 = false;
              }
              if (!bool3)
              {
                bool2 = bool3;
                QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[random] action nis not exist," + paramSpriteTaskParam.jdField_d_of_type_JavaLangString);
              }
              bool1 = bool3;
              break;
              bool4 = false;
              break label465;
            }
          }
          catch (Exception localException)
          {
            QLog.e("cmshow_scripted_SpriteRscBuilder", 1, "[random] the json is not right," + paramSpriteTaskParam.jdField_d_of_type_JavaLangString);
            bool1 = bool2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angb
 * JD-Core Version:    0.7.0.1
 */