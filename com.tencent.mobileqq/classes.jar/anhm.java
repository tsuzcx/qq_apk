import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.json.JSONObject;

public class anhm
{
  public static int a;
  public static boolean a;
  private static final String[] a;
  public static int b;
  
  static
  {
    jdField_a_of_type_Int = 1;
    b = 2;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "/def/role/0/sayhi/1/action/action.json", "/def/role/0/friendcard/1/action/action.json", "/def/role/0/3D/sayhi/1/action.bin", "/def/role/0/3D/3DConfig.json" };
  }
  
  public static int a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRandomActionId], roleId:" + paramInt);
    }
    paramString = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/", paramInt + "/" + paramString + "/");
    if (!paramString.exists()) {}
    for (;;)
    {
      return -1;
      Object localObject = paramString.list();
      if ((localObject == null) || (localObject.length == 0))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloActionHelper", 2, "no any action file.");
        return -1;
      }
      int i = awrh.a(localObject.length);
      if ((i >= localObject.length) || (i < 0)) {
        continue;
      }
      localObject = localObject[i];
      try
      {
        int j = Integer.parseInt((String)localObject);
        if (paramInt >= anka.b) {
          if (!ApolloUtil.c(paramString.getAbsolutePath() + "/" + (String)localObject + "/action/" + "action.bin")) {
            continue;
          }
        }
        for (;;)
        {
          return j;
          if ((!ApolloUtil.c(paramString.getAbsolutePath() + "/" + (String)localObject + "/" + "action/action.json")) || (!ApolloUtil.c(paramString.getAbsolutePath() + "/" + (String)localObject + "/" + "action/action.png")) || (!ApolloUtil.c(paramString.getAbsolutePath() + "/" + (String)localObject + "/" + "action/action.atlas"))) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "value:" + i + ",actionId:" + (String)localObject);
          }
        }
        return -1;
      }
      catch (NumberFormatException paramString) {}
    }
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getApolloFuncSwitch], uin:" + paramString);
    }
    paramString = ((amme)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "apolloBaseInfo is null. ret closed status");
      }
      return 2;
    }
    return paramString.apolloStatus;
  }
  
  public static String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getTickerPauseString]");
    }
    return "BK.Director.tickerPause();";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getApolloRsc],  rscType", Integer.valueOf(paramInt1), ",id:" + paramInt2 });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "rsc:" + localStringBuilder);
      }
      return localStringBuilder.toString();
      if (paramInt2 < 21) {
        localStringBuilder.append("def/basic/dress/");
      }
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/dress");
      continue;
      if (paramInt2 == 0) {
        localStringBuilder.append("def/basic/skeleton/");
      }
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/role");
    }
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramInt1 == 0) || (!ApolloUtil.f(paramInt1, paramInt2)))
    {
      localStringBuilder.append("def/role/");
      localStringBuilder.append(0);
    }
    for (;;)
    {
      localStringBuilder.append("/");
      localStringBuilder.append("Bubble");
      localStringBuilder.append("/");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/dress");
      return localStringBuilder.toString();
      localStringBuilder.append("role/");
      localStringBuilder.append(paramInt1);
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new StringTokenizer(paramString, "@$");
    int i = awrh.a(paramString.countTokens());
    while (paramString.hasMoreTokens())
    {
      i -= 1;
      if (i < 0) {
        return paramString.nextToken();
      }
      paramString.nextToken();
    }
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = paramString;
    } while (paramString.contains("def"));
    Object localObject = new StringBuilder();
    switch (paramInt)
    {
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("//").append(paramString);
      return ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).append("ActionRes:");
      continue;
      ((StringBuilder)localObject).append("Dress:");
      continue;
      ((StringBuilder)localObject).append("Role:");
    }
  }
  
  public static String a(String paramString, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getRoleLuaString] apolloId=", paramString, ", roleId=", Integer.valueOf(paramInt) });
    }
    String str = a(0, paramInt);
    float f = 0.0F;
    if ("friend".equals(paramString)) {
      f = 180.0F;
    }
    paramString = String.format("var %s = loadAnimation('%s', '%s', '%s', %f, %f, %f, %f, %f, '%s','%s');if(%s){%s.openAABBCallback()}", new Object[] { paramString, paramString, str, str, Float.valueOf(1.0F), Float.valueOf(paramFloat1), Float.valueOf(f), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), "null", "null", paramString, paramString });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getRoleLuaString] scriptStr=", paramString });
    }
    return paramString;
  }
  
  public static String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getBubbleLuaString], apolloId:" + paramString1 + ",bubbleId" + paramInt1 + ",roleId:" + paramInt2);
    }
    String str = b(paramInt2, paramInt1);
    paramString1 = String.format("setAccessoryWithInfo(%s, '%s', '%s', '%s');", new Object[] { paramString1, str, str, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, paramString1);
    }
    return paramString1;
  }
  
  public static String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getModelByUin], uin:" + paramString);
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "errInfo->null param.");
      }
      return null;
    }
    if (amme.a(paramQQAppInterface, paramString) == 2) {
      return "3D";
    }
    return "2D";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRemoveBubbleLuaString], apolloId:" + paramString1 + ",bubbleName" + paramString2);
    }
    paramString1 = String.format("if(%s) {%s.removeAccessory('%s')};", new Object[] { paramString1, paramString1, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, paramString1);
    }
    return paramString1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SpriteTaskParam paramSpriteTaskParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[doActionReport], isHasUsrText:" + paramBoolean1 + ",isBarrage:" + paramBoolean2);
    }
    if ((paramSpriteTaskParam == null) || (paramQQAppInterface == null)) {}
    Object localObject;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "taskParam:" + paramSpriteTaskParam.toString());
      }
      localObject = ((ankc)paramQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).a(paramSpriteTaskParam.f);
    } while (localObject == null);
    int i = 0;
    int j = paramSpriteTaskParam.j;
    String str5 = Integer.toString(paramSpriteTaskParam.f);
    if (paramBoolean1) {
      if (!paramBoolean2) {}
    }
    for (String str3 = "2";; str3 = "0")
    {
      label141:
      if (paramSpriteTaskParam.h == 0) {}
      label769:
      for (String str2 = "action_play";; str2 = "")
      {
        label153:
        label171:
        String str4;
        if (paramSpriteTaskParam.g == 2) {
          if (paramSpriteTaskParam.a)
          {
            i = 2;
            if ((((ApolloActionData)localObject).hasSound) || (paramSpriteTaskParam.i > 0)) {
              break label514;
            }
            str4 = "0";
            label191:
            if ((8 != paramSpriteTaskParam.c) || (TextUtils.isEmpty(paramSpriteTaskParam.d))) {
              break label686;
            }
          }
        }
        for (;;)
        {
          label514:
          String str1;
          try
          {
            localObject = new JSONObject(paramSpriteTaskParam.d).optString("subActionId", "0");
            VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "actionnewuser_play", paramSpriteTaskParam.b, i, j, new String[] { str5, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
            VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", str2, i, j, new String[] { str5, str3, str4, localObject });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloActionHelper", 2, "actionName:" + str2 + ",entry:" + i + ",result:" + j + ",r2:" + str5 + ",r3:" + str3 + ",r4:" + str4 + ",r5:" + (String)localObject);
            return;
            str3 = "1";
            break label141;
            if (paramSpriteTaskParam.h == 1)
            {
              str2 = "g_action_play";
              break label153;
            }
            if (paramSpriteTaskParam.h != 3000) {
              break label769;
            }
            str2 = "d_action_play";
            break label153;
            i = 3;
            break label171;
            if (paramSpriteTaskParam.g == 0)
            {
              i = 0;
              break label171;
            }
            if (paramSpriteTaskParam.g == 1)
            {
              i = 1;
              break label171;
            }
            if (paramSpriteTaskParam.g != 4) {
              break label171;
            }
            i = 4;
            break label171;
            if ((1 == paramQQAppInterface.getALLGeneralSettingRing()) && (((paramSpriteTaskParam.h != 1) && (paramSpriteTaskParam.h != 3000)) || (((1 == paramQQAppInterface.getTroopGeneralSettingRing()) || (paramSpriteTaskParam.h == 0)) && (!paramQQAppInterface.isRingerVibrate()) && (!paramQQAppInterface.isRingEqualsZero()) && (paramQQAppInterface.isCallIdle()) && (!MediaPlayerManager.a(paramQQAppInterface).a()) && ((paramQQAppInterface.getCheckPttListener() == null) || (!paramQQAppInterface.getCheckPttListener().isRecordingOrPlaying())) && (!paramQQAppInterface.isVideoChatting()) && ((paramQQAppInterface.getCheckPtvListener() == null) || (!paramQQAppInterface.getCheckPtvListener().isPTVRecording())))))
            {
              str4 = "1";
              break label191;
            }
            str4 = "2";
          }
          catch (Exception localException)
          {
            QLog.e("ApolloActionHelper", 1, "[random] the json is not right," + paramSpriteTaskParam.d);
            str1 = "-1";
            continue;
          }
          label686:
          if (a(str1.vibrate) == null) {
            str1 = "0";
          } else if ((1 == paramQQAppInterface.getALLGeneralSettingVibrate()) && (((paramSpriteTaskParam.h != 1) && (paramSpriteTaskParam.h != 3000)) || (((1 == paramQQAppInterface.getTroopGeneralSettingVibrate()) || (paramSpriteTaskParam.h == 0)) && (!paramQQAppInterface.isRingEqualsZero())))) {
            str1 = "1";
          } else {
            str1 = "2";
          }
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      localObject = new File(anka.jdField_a_of_type_JavaLangString + (String)localObject);
      if (!((File)localObject).exists())
      {
        QLog.d("ApolloActionHelper", 1, new Object[] { "[checkBasicActionExit] rsc file not exist:", ((File)localObject).toString() });
        anex.a(paramQQAppInterface, paramQQAppInterface.getCurrentUin(), null, 0, null, -1, -1, true);
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return a(paramQQAppInterface);
  }
  
  public static boolean a(String paramString, int paramInt, int[] paramArrayOfInt, QQAppInterface paramQQAppInterface)
  {
    return a(paramString, paramInt, paramArrayOfInt, paramQQAppInterface, null);
  }
  
  public static boolean a(String paramString, int paramInt, int[] paramArrayOfInt, QQAppInterface paramQQAppInterface, anfg paramanfg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[isRscValid], roleId:" + paramInt + ",dressId:" + paramArrayOfInt);
    }
    if (paramArrayOfInt == null) {
      return false;
    }
    int[] arrayOfInt = null;
    ArrayList localArrayList = new ArrayList();
    boolean bool = true;
    if (!ApolloUtil.d(paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "need download role id:" + paramInt);
      }
      bool = false;
    }
    for (;;)
    {
      int i = 0;
      if (i < paramArrayOfInt.length)
      {
        if (ApolloUtil.c(paramArrayOfInt[i])) {
          break label328;
        }
        localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, "need download dress id:" + paramArrayOfInt[i]);
        }
        bool = false;
      }
      label325:
      label328:
      for (;;)
      {
        i += 1;
        break;
        if (!bool)
        {
          paramArrayOfInt = arrayOfInt;
          if (localArrayList.size() > 0)
          {
            arrayOfInt = new int[localArrayList.size()];
            i = 0;
            for (;;)
            {
              paramArrayOfInt = arrayOfInt;
              if (i >= localArrayList.size()) {
                break;
              }
              arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
              i += 1;
            }
          }
          if (paramQQAppInterface != null)
          {
            if (paramanfg != null) {
              break label325;
            }
            paramanfg = ((amme)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a();
          }
        }
        for (;;)
        {
          anex.a(paramQQAppInterface, paramString, paramanfg, paramInt, paramArrayOfInt, -1, -1, false);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "ret:" + bool);
          }
          return bool;
        }
      }
      paramInt = -1;
    }
  }
  
  public static boolean a(String paramString1, QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[attach3DInfoToJson], uin:" + paramString1);
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "errInfo->null param.");
      }
      return false;
    }
    ApolloBaseInfo localApolloBaseInfo = ((amme)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).b(paramString1);
    if (localApolloBaseInfo != null)
    {
      String str = paramString2;
      try
      {
        if (TextUtils.isEmpty(paramString2)) {
          str = a(paramString1, paramQQAppInterface);
        }
        paramJSONObject.put("model", str);
        paramString1 = new JSONObject();
        paramString2 = localApolloBaseInfo.getFaceModel(true, paramQQAppInterface);
        if (paramString2 != null) {
          paramString1.put("faceModel", paramString2);
        }
        paramString2 = localApolloBaseInfo.getDress3D(true, paramQQAppInterface);
        int i = localApolloBaseInfo.getRole3D(true, paramQQAppInterface);
        if ((paramString2 != null) && (i > 0))
        {
          paramString1.put("dress", paramString2);
          paramString1.put("role", String.valueOf(i));
        }
        paramJSONObject.put("3DObject", paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_ApolloActionHelper", 2, "attach3DInfoToJson: obj3D:" + paramString1.toString());
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QLog.e("ApolloActionHelper", 1, "attach3DInfoToJson e=" + paramString1.toString());
        }
      }
      return true;
    }
    return false;
  }
  
  public static long[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long[] arrayOfLong;
    for (;;)
    {
      return null;
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length != 0))
      {
        arrayOfLong = new long[paramString.length];
        i = 0;
        try
        {
          while (i < paramString.length)
          {
            arrayOfLong[i] = Integer.parseInt(paramString[i].trim());
            i += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (NumberFormatException paramString) {}
      }
    }
    QLog.d("ApolloActionHelper", 2, "errInfo->NumberFormatException, e:" + paramString.getMessage());
    return null;
    int i = paramString.length - 2;
    while (i >= 2)
    {
      arrayOfLong[i] = (arrayOfLong[i] - arrayOfLong[(i - 1)] - arrayOfLong[(i - 2)]);
      i -= 2;
    }
    return arrayOfLong;
  }
  
  public static Object[] a(String paramString, int paramInt, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramInt != 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, new Object[] { "get3DRoleIdByUin errInfo->null param, userStatus:", Integer.valueOf(paramInt) });
      }
      return new Object[] { Integer.valueOf(-1), null };
    }
    Object localObject = ((amme)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).b(paramString);
    if (localObject != null)
    {
      localObject = ((ApolloBaseInfo)localObject).getApolloDress3D();
      if (localObject != null)
      {
        paramInt = ((ApolloDress)localObject).jdField_a_of_type_Int;
        localObject = ((ApolloDress)localObject).a();
        if ((paramInt > anka.b) && (localObject != null) && (localObject.length > 0) && ((!paramBoolean) || (a(paramString, paramInt, (int[])localObject, paramQQAppInterface))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, new Object[] { "get3DRoleDressIdByUin valid role and dress RSC, needVerify:", Boolean.valueOf(paramBoolean) });
          }
          paramString = (String)localObject;
        }
      }
    }
    for (;;)
    {
      return new Object[] { Integer.valueOf(paramInt), paramString };
      paramString = null;
      paramInt = 0;
    }
  }
  
  public static Object[] a(String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRoldIdByUin], uin:" + paramString);
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "errInfo->null param.");
      }
      return null;
    }
    Object localObject2 = anex.a(0);
    Object localObject1;
    int i;
    if (("-1".equals(paramString)) || ("-2".equals(paramString)))
    {
      localObject1 = paramString;
      if (!"-1".equals(localObject1)) {
        break label252;
      }
      i = 1;
      label102:
      localObject3 = anex.a(i);
      if ((paramBoolean) && (!a((String)localObject1, i, (int[])localObject3, paramQQAppInterface))) {
        break label257;
      }
      localObject1 = localObject3;
    }
    for (;;)
    {
      localObject2 = ((amme)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).b(paramString);
      if (localObject2 == null) {
        break label719;
      }
      j = ((ApolloBaseInfo)localObject2).apolloStatus;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "uin: " + ((ApolloBaseInfo)localObject2).uin + ", funcSwitch:" + j);
      }
      if (amme.a((ApolloBaseInfo)localObject2)) {
        break label305;
      }
      return new Object[] { Integer.valueOf(i), localObject1 };
      if (ancd.b(paramQQAppInterface, paramString))
      {
        localObject1 = "-2";
        break;
      }
      localObject1 = "-1";
      break;
      label252:
      i = 2;
      break label102;
      label257:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, new Object[] { "role and dress is not ready,uin:", paramString, ",roleId:", Integer.valueOf(0) });
      }
      localObject1 = localObject2;
      i = 0;
    }
    label305:
    if ((paramBoolean) && (((ApolloBaseInfo)localObject2).apolloLocalTS != ((ApolloBaseInfo)localObject2).apolloServerTS))
    {
      QLog.i("ApolloActionHelper", 1, "dress changed, uin:" + ApolloUtil.d(paramString));
      amme.a(paramQQAppInterface, paramString, "getRoleDressIdByUin");
    }
    Object localObject3 = ((ApolloBaseInfo)localObject2).getApolloDress(false);
    if ((localObject3 != null) && (localObject3.length > 0))
    {
      int k = localObject3.length;
      j = 0;
      if (j >= k) {
        break label802;
      }
      Object localObject4 = localObject3[j];
      localObject2 = localObject4.a();
      if (a(paramString, localObject4.jdField_a_of_type_Int, (int[])localObject2, paramQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, "valid role and dress RSC.");
        }
        i = localObject4.jdField_a_of_type_Int;
        localObject1 = localObject2;
      }
    }
    label536:
    label541:
    label802:
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        localObject2 = anex.a(localObject3[0].jdField_a_of_type_Int);
        if (a(paramString, localObject3[0].jdField_a_of_type_Int, (int[])localObject2, paramQQAppInterface))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "valid basic dress.");
          }
          j = localObject3[0].jdField_a_of_type_Int;
          paramString = (String)localObject2;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloActionHelper", 2, "current dress NOT downloaded, check basic dress");
            i = j;
            paramString = (String)localObject2;
          }
          j = i;
          paramQQAppInterface = paramString;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("******roleId:[");
          paramString.append(j);
          paramString.append("],");
          paramString.append("dress:[");
          i = 0;
          for (;;)
          {
            if (i < paramQQAppInterface.length)
            {
              if (i != 0) {
                paramString.append(",");
              }
              paramString.append(paramQQAppInterface[i]);
              i += 1;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("ApolloActionHelper", 2, "try to get history dress ....");
              }
              j += 1;
              break;
              anck.a(110, new Object[] { "basicDresses is not vaild" });
              paramString = (String)localObject1;
              break label536;
              paramQQAppInterface = (QQAppInterface)localObject1;
              j = i;
              if (!QLog.isColorLevel()) {
                break label541;
              }
              QLog.d("ApolloActionHelper", 2, "uin: " + paramString + " dress is null");
              paramQQAppInterface = (QQAppInterface)localObject1;
              j = i;
              break label541;
              label719:
              paramQQAppInterface = (QQAppInterface)localObject1;
              j = i;
              if (!QLog.isColorLevel()) {
                break label541;
              }
              QLog.d("ApolloActionHelper", 2, "warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:" + localObject2);
              paramQQAppInterface = (QQAppInterface)localObject1;
              j = i;
              break label541;
            }
          }
          paramString.append("]****");
          QLog.d("ApolloActionHelper", 2, paramString.toString());
        }
      }
      return new Object[] { Integer.valueOf(j), paramQQAppInterface };
    }
  }
  
  public static String[] a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action/");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/action_background/action");
    String str1 = "background__" + Integer.toString(paramInt);
    String str2 = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "action rsc path:" + localStringBuilder.toString() + ",actionName:" + str1);
    }
    return new String[] { str2, str1 };
  }
  
  public static String[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return a(paramInt1, paramInt2, paramInt3, paramBoolean, 1);
  }
  
  public static String[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getActionRscPath], bid:" + paramInt1 + ",activeId:" + paramInt2 + ",roleId:" + paramInt3 + ",isActionMaker:" + paramBoolean, ",userStatus:", Integer.valueOf(paramInt4) });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt4 == 2)
    {
      paramInt4 = 1;
      switch (paramInt1)
      {
      case 3: 
      case 8: 
      case 9: 
      default: 
        paramInt3 = 1;
        paramInt4 = paramInt2;
        label177:
        if (paramInt3 != 0) {
          localStringBuilder.append("/");
        }
        localStringBuilder.append(paramInt4);
        if ((paramBoolean) || (paramInt2 < 21)) {
          if (localStringBuilder.indexOf("def/role/0/3D/") > -1) {
            localStringBuilder.append("/action");
          }
        }
        break;
      }
    }
    for (;;)
    {
      String str1 = localStringBuilder.toString();
      String str2 = Integer.toString(paramInt1) + "_" + Integer.toString(paramInt4);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "action rsc path:" + localStringBuilder.toString() + ",actionId:" + paramInt4);
      }
      return new String[] { str1, str2 };
      paramInt4 = 0;
      break;
      paramInt3 = 0;
      paramInt4 = paramInt2;
      break label177;
      localStringBuilder.append("action");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/");
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/basic/action");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0) {
        localStringBuilder.append("def/role/0/3D/").append("sayhi");
      }
      for (;;)
      {
        paramInt3 = 1;
        paramInt4 = 1;
        break;
        localStringBuilder.append("def/basic/").append("sayhi");
      }
      localStringBuilder.append("def/role/0/3D/").append("sayhi");
      paramInt3 = 1;
      paramInt4 = 1;
      break label177;
      int i = a(paramInt3, "sayhi");
      if (-1 != i)
      {
        localStringBuilder.append("role/");
        localStringBuilder.append(paramInt3).append("/").append("sayhi");
        paramInt4 = i;
        paramInt3 = 1;
        break label177;
      }
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/").append("sayhi");
        paramInt3 = 1;
        paramInt4 = 1;
        break label177;
      }
      localStringBuilder.append("def/basic/").append("sayhi");
      paramInt3 = 1;
      paramInt4 = 1;
      break label177;
      localStringBuilder.append("drawer_action/");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/").append("friendcard");
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/role/").append(0).append("/").append("friendcard");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/").append("drawer");
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/role/").append(0).append("/").append("drawer");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      i = a(paramInt3, "interact");
      if (-1 != i)
      {
        localStringBuilder.append("role/");
        localStringBuilder.append(paramInt3).append("/").append("interact");
        paramInt4 = i;
        paramInt3 = 1;
        break label177;
      }
      if (paramInt4 != 0) {
        localStringBuilder.append("def/role/0/3D/").append("sayhi");
      }
      for (;;)
      {
        paramInt3 = 1;
        paramInt4 = 1;
        break;
        localStringBuilder.append("def/basic/").append("sayhi");
      }
      if (15 == paramInt1) {
        localStringBuilder.append("/panelAction");
      }
      localStringBuilder.append("/action/action");
      continue;
      if (15 == paramInt1) {
        localStringBuilder.append("/panelAction");
      }
      localStringBuilder.append("/action_peer/action");
    }
  }
  
  public static String[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getActionRscPath], bid:" + paramInt1 + ",activeId:" + paramInt2 + ",roleId:" + paramInt3 + ",isActionMaker:" + paramBoolean, ",userStatus:", Integer.valueOf(paramInt4) });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt4 == 2)
    {
      paramInt4 = 1;
      switch (paramInt1)
      {
      case 3: 
      case 8: 
      case 9: 
      default: 
        paramInt3 = 1;
        paramInt4 = paramInt2;
        label177:
        if (paramInt3 != 0) {
          localStringBuilder.append("/");
        }
        localStringBuilder.append(paramInt4);
        if ((paramBoolean) || (paramInt2 < 21)) {
          if (localStringBuilder.indexOf("def/role/0/3D/") > -1) {
            localStringBuilder.append("/action");
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramPlayActionConfig = localStringBuilder.toString();
      String str = Integer.toString(paramInt1) + "_" + Integer.toString(paramInt4);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "action rsc path:" + localStringBuilder.toString() + ",actionId:" + paramInt4);
      }
      return new String[] { paramPlayActionConfig, str };
      paramInt4 = 0;
      break;
      paramInt3 = 0;
      paramInt4 = paramInt2;
      break label177;
      localStringBuilder.append("action");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/");
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/basic/action");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0) {
        localStringBuilder.append("def/role/0/3D/").append("sayhi");
      }
      for (;;)
      {
        paramInt3 = 1;
        paramInt4 = 1;
        break;
        localStringBuilder.append("def/basic/").append("sayhi");
      }
      localStringBuilder.append("def/role/0/3D/").append("sayhi");
      paramInt3 = 1;
      paramInt4 = 1;
      break label177;
      int i = a(paramInt3, "sayhi");
      if (-1 != i)
      {
        localStringBuilder.append("role/");
        localStringBuilder.append(paramInt3).append("/").append("sayhi");
        paramInt4 = i;
        paramInt3 = 1;
        break label177;
      }
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/").append("sayhi");
        paramInt3 = 1;
        paramInt4 = 1;
        break label177;
      }
      localStringBuilder.append("def/basic/").append("sayhi");
      paramInt3 = 1;
      paramInt4 = 1;
      break label177;
      localStringBuilder.append("drawer_action/");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/").append("friendcard");
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/role/").append(0).append("/").append("friendcard");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append("def/role/0/3D/").append("drawer");
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/role/").append(0).append("/").append("drawer");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      i = a(paramInt3, "interact");
      if (-1 != i)
      {
        localStringBuilder.append("role/");
        localStringBuilder.append(paramInt3).append("/").append("interact");
        paramInt4 = i;
        paramInt3 = 1;
        break label177;
      }
      if (paramInt4 != 0) {
        localStringBuilder.append("def/role/0/3D/").append("sayhi");
      }
      for (;;)
      {
        paramInt3 = 1;
        paramInt4 = 1;
        break;
        localStringBuilder.append("def/basic/").append("sayhi");
      }
      if ((paramPlayActionConfig == null) || (paramPlayActionConfig.c == 0))
      {
        localStringBuilder.append("/action/action");
      }
      else if (paramPlayActionConfig.c == 1)
      {
        localStringBuilder.append("/action/pre/action/action");
      }
      else if (paramPlayActionConfig.c == 2)
      {
        localStringBuilder.append("/action/main/action/action");
      }
      else if (paramPlayActionConfig.c == 3)
      {
        localStringBuilder.append("/action/post/action/action");
      }
      else
      {
        localStringBuilder.append("/action/action");
        continue;
        if ((paramPlayActionConfig == null) || (paramPlayActionConfig.c == 0)) {
          localStringBuilder.append("/action_peer/action");
        } else if (paramPlayActionConfig.c == 1) {
          localStringBuilder.append("/action/pre/action_peer/action");
        } else if (paramPlayActionConfig.c == 2) {
          localStringBuilder.append("/action/main/action_peer/action");
        } else if (paramPlayActionConfig.c == 3) {
          localStringBuilder.append("/action/post/action_peer/action");
        } else {
          localStringBuilder.append("/action_peer/action");
        }
      }
    }
  }
  
  public static String[] a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append("/action");
    if (paramBoolean2) {
      localStringBuilder.append("/group");
    }
    switch (paramInt2)
    {
    default: 
      if (paramBoolean1) {
        localStringBuilder.append("/action/action");
      }
      break;
    }
    for (;;)
    {
      String str1 = localStringBuilder.toString();
      String str2 = "whiteface_" + Integer.toString(paramInt2) + "_" + Integer.toString(paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "[whiteface] path:" + localStringBuilder.toString() + ",actionId:" + paramInt1);
      }
      return new String[] { str1, str2 };
      localStringBuilder.append("/pre");
      break;
      localStringBuilder.append("/main");
      break;
      localStringBuilder.append("/post");
      break;
      localStringBuilder.append("/action_peer/action");
    }
  }
  
  public static String[] a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getActionLuaString] apolloId=", paramString1, ", actionId=", Integer.valueOf(paramInt1), ", taskId=", Integer.valueOf(paramInt2), ", animName=", paramString3, ", actionRscName=", paramString2 });
    }
    String[] arrayOfString = new String[2];
    String str = paramString3;
    if (paramString2.contains("_peer")) {
      str = paramString3 + "_peer";
    }
    paramString3 = paramString2;
    if (paramString2.startsWith("action")) {
      paramString3 = paramString2.substring("action/".length());
    }
    arrayOfString[0] = String.format("setAccessoryAnimation(%s, '%s', '%s', '%s');", new Object[] { paramString1, paramString3, paramString3, str });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, arrayOfString[0]);
    }
    arrayOfString[1] = String.format("if(%s){%s.setAnimation(%d, '%s', false);}", new Object[] { paramString1, paramString1, Integer.valueOf(paramInt2), str });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, arrayOfString[1]);
    }
    return arrayOfString;
  }
  
  public static String[] a(String paramString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getDressLuaString] apolloId=", paramString });
    }
    if (paramArrayOfInt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "[getDressLuaString] no dressId, abort");
      }
      return null;
    }
    String[] arrayOfString = new String[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      String str = a(1, paramArrayOfInt[i]);
      arrayOfString[i] = String.format("setAccessory(%s, '%s', '%s');", new Object[] { paramString, str, str });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, new Object[] { "[getDressLuaString] scriptStr", Integer.valueOf(i), "=", arrayOfString[i] });
      }
      i += 1;
    }
    return arrayOfString;
  }
  
  public static String b()
  {
    return "if(\"undefined\" != typeof addFrame){addFrame();}else{if(renderTicker.paused){if(BK.Director.root){BK.Render.clear(0,0,0,0);BK.Render.treeRender( BK.Director.root,0);BK.Render.commit();}}}";
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, 1);
  }
  
  public static String b(int paramInt1, int paramInt2, int paramInt3)
  {
    return "if(\"undefined\" != typeof comGlobalParam) { comGlobalParam.width=" + paramInt1 + ";comGlobalParam.vWidth=" + paramInt1 + ";comGlobalParam.vHeight=" + paramInt2 + ";if(comGlobalParam.height==0){comGlobalParam.height=" + paramInt3 + ";}}";
  }
  
  public static String b(String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramString = ((amme)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).b(paramString);
    if (paramString != null)
    {
      paramString = paramString.getApolloDress3D();
      if (paramString != null) {
        return paramString.jdField_a_of_type_JavaLangString;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhm
 * JD-Core Version:    0.7.0.1
 */