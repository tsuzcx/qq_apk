package com.tencent.mobileqq.apollo.lightGame;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloGameArkHandler;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameMsgInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class CmGameSessionUtil
{
  public static long a;
  
  public static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { { 16842919 }, { 0 } }, new int[] { paramInt2, paramInt1 });
  }
  
  /* Error */
  public static android.graphics.drawable.Drawable a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: new 25	android/graphics/drawable/StateListDrawable
    //   3: dup
    //   4: invokespecial 26	android/graphics/drawable/StateListDrawable:<init>	()V
    //   7: astore 6
    //   9: new 28	com/tencent/mobileqq/drawable/RoundRectColorDrawable
    //   12: dup
    //   13: ldc 30
    //   15: invokestatic 36	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   18: iload_2
    //   19: iconst_2
    //   20: idiv
    //   21: i2f
    //   22: iload_1
    //   23: iload_2
    //   24: invokespecial 39	com/tencent/mobileqq/drawable/RoundRectColorDrawable:<init>	(IFII)V
    //   27: astore 5
    //   29: new 28	com/tencent/mobileqq/drawable/RoundRectColorDrawable
    //   32: dup
    //   33: ldc 30
    //   35: invokestatic 36	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   38: iload_2
    //   39: iconst_2
    //   40: idiv
    //   41: i2f
    //   42: iload_1
    //   43: iload_2
    //   44: invokespecial 39	com/tencent/mobileqq/drawable/RoundRectColorDrawable:<init>	(IFII)V
    //   47: astore_0
    //   48: new 28	com/tencent/mobileqq/drawable/RoundRectColorDrawable
    //   51: dup
    //   52: aload_3
    //   53: invokestatic 36	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   56: iload_2
    //   57: iconst_2
    //   58: idiv
    //   59: i2f
    //   60: iload_1
    //   61: iload_2
    //   62: invokespecial 39	com/tencent/mobileqq/drawable/RoundRectColorDrawable:<init>	(IFII)V
    //   65: astore 4
    //   67: new 28	com/tencent/mobileqq/drawable/RoundRectColorDrawable
    //   70: dup
    //   71: new 41	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   78: ldc 44
    //   80: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_3
    //   84: aload_3
    //   85: ldc 50
    //   87: invokevirtual 55	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   90: iconst_1
    //   91: iadd
    //   92: invokevirtual 59	java/lang/String:substring	(I)Ljava/lang/String;
    //   95: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 36	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   104: iload_2
    //   105: iconst_2
    //   106: idiv
    //   107: i2f
    //   108: iload_1
    //   109: iload_2
    //   110: invokespecial 39	com/tencent/mobileqq/drawable/RoundRectColorDrawable:<init>	(IFII)V
    //   113: astore_3
    //   114: aload_3
    //   115: sipush 204
    //   118: invokevirtual 69	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   121: aload_3
    //   122: astore_0
    //   123: aload 6
    //   125: iconst_1
    //   126: newarray int
    //   128: dup
    //   129: iconst_0
    //   130: ldc 17
    //   132: iastore
    //   133: aload_0
    //   134: invokevirtual 73	android/graphics/drawable/StateListDrawable:addState	([ILandroid/graphics/drawable/Drawable;)V
    //   137: aload 6
    //   139: iconst_1
    //   140: newarray int
    //   142: dup
    //   143: iconst_0
    //   144: ldc 74
    //   146: iastore
    //   147: aload 4
    //   149: invokevirtual 73	android/graphics/drawable/StateListDrawable:addState	([ILandroid/graphics/drawable/Drawable;)V
    //   152: aload 6
    //   154: areturn
    //   155: astore 4
    //   157: aload 5
    //   159: astore_3
    //   160: ldc 76
    //   162: iconst_2
    //   163: ldc 78
    //   165: aload 4
    //   167: invokestatic 84	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   170: aload_3
    //   171: astore 4
    //   173: goto -50 -> 123
    //   176: astore 5
    //   178: aload 4
    //   180: astore_3
    //   181: aload 5
    //   183: astore 4
    //   185: goto -25 -> 160
    //   188: astore 5
    //   190: aload_3
    //   191: astore_0
    //   192: aload 4
    //   194: astore_3
    //   195: aload 5
    //   197: astore 4
    //   199: goto -39 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramContext	Context
    //   0	202	1	paramInt1	int
    //   0	202	2	paramInt2	int
    //   0	202	3	paramString	String
    //   65	83	4	localRoundRectColorDrawable1	com.tencent.mobileqq.drawable.RoundRectColorDrawable
    //   155	11	4	localException1	Exception
    //   171	27	4	localObject	Object
    //   27	131	5	localRoundRectColorDrawable2	com.tencent.mobileqq.drawable.RoundRectColorDrawable
    //   176	6	5	localException2	Exception
    //   188	8	5	localException3	Exception
    //   7	146	6	localStateListDrawable	android.graphics.drawable.StateListDrawable
    // Exception table:
    //   from	to	target	type
    //   48	67	155	java/lang/Exception
    //   67	114	176	java/lang/Exception
    //   114	121	188	java/lang/Exception
  }
  
  public static MessageForApollo a(List<MessageForApollo> paramList, int paramInt, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      Object localObject = (MessageRecord)paramList.get(i);
      if (!(localObject instanceof MessageForApollo)) {}
      do
      {
        i -= 1;
        break;
        localObject = (MessageForApollo)localObject;
      } while ((((MessageForApollo)localObject).roomId != paramLong) || (((MessageForApollo)localObject).gameId != paramInt));
      return localObject;
    }
    return null;
  }
  
  public static List<MessageForApollo> a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject = paramQQAppInterface.getMessageFacade().b(paramString, paramInt);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (!QLog.isColorLevel()) {
        break label197;
      }
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, "in aio, cache size:" + ((List)localObject).size());
      paramQQAppInterface = (QQAppInterface)localObject;
    }
    for (;;)
    {
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
      {
        QLog.i("CmGameTemp_CmGameSessionUtil", 2, "msgRcd size is 0.");
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameSessionUtil", 2, "NOT in aio.");
        }
        paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(paramString, paramInt, new int[] { -2039 }, 20);
      }
      else
      {
        paramString = new ArrayList();
        paramInt = paramQQAppInterface.size() - 1;
        if (paramInt >= 0)
        {
          localObject = (MessageRecord)paramQQAppInterface.get(paramInt);
          if (!(localObject instanceof MessageForApollo)) {}
          for (;;)
          {
            paramInt -= 1;
            break;
            paramString.add((MessageForApollo)localObject);
          }
        }
        return paramString;
        label197:
        paramQQAppInterface = (QQAppInterface)localObject;
      }
    }
  }
  
  public static List<MessageForApollo> a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject = paramQQAppInterface.getMessageFacade().b(paramString, paramInt1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (!QLog.isColorLevel()) {
        break label236;
      }
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, "in aio, cache size:" + ((List)localObject).size());
      paramQQAppInterface = (QQAppInterface)localObject;
    }
    for (;;)
    {
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
      {
        QLog.i("CmGameTemp_CmGameSessionUtil", 2, "msgRcd size is 0.");
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameSessionUtil", 2, "NOT in aio.");
        }
        paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(paramString, paramInt1, new int[] { -2039 }, 20);
      }
      else
      {
        paramString = new ArrayList();
        paramInt1 = paramQQAppInterface.size() - 1;
        if (paramInt1 >= 0)
        {
          localObject = (MessageRecord)paramQQAppInterface.get(paramInt1);
          if (!(localObject instanceof MessageForApollo)) {}
          for (;;)
          {
            paramInt1 -= 1;
            break;
            localObject = (MessageForApollo)localObject;
            if ((((MessageForApollo)localObject).gameStatus == paramInt2) && (((MessageForApollo)localObject).roomId > 0L) && (((MessageForApollo)localObject).gameId > 0)) {
              paramString.add(localObject);
            }
          }
        }
        return paramString;
        label236:
        paramQQAppInterface = (QQAppInterface)localObject;
      }
    }
  }
  
  public static List<MessageForApollo> a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject1 = paramQQAppInterface.getMessageFacade().b(paramString, paramInt1);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      if (!QLog.isColorLevel()) {
        break label272;
      }
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, "in aio, cache size:" + ((List)localObject1).size());
      paramString = (String)localObject1;
    }
    for (;;)
    {
      if ((paramString == null) || (paramString.size() == 0))
      {
        QLog.i("CmGameTemp_CmGameSessionUtil", 2, "msgRcd size is 0.");
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameSessionUtil", 2, "NOT in aio.");
        }
        paramString = paramQQAppInterface.getMessageFacade().a(paramString, paramInt1, new int[] { -2039 }, 20);
      }
      else
      {
        localObject1 = new ArrayList();
        ApolloGameManager localApolloGameManager = (ApolloGameManager)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
        paramInt1 = paramString.size() - 1;
        if (paramInt1 >= 0)
        {
          Object localObject2 = (MessageRecord)paramString.get(paramInt1);
          if (!(localObject2 instanceof MessageForApollo)) {}
          for (;;)
          {
            paramInt1 -= 1;
            break;
            localObject2 = (MessageForApollo)localObject2;
            if ((((MessageForApollo)localObject2).gameId == paramInt2) && (((MessageForApollo)localObject2).roomId == paramLong))
            {
              ((List)localObject1).add(localObject2);
              ((MessageForApollo)localObject2).gameStatus = 3;
              if (a()) {
                localApolloGameManager.a().a((MessageForApollo)localObject2);
              }
              ApolloGameUtil.a(paramQQAppInterface, (MessageForApollo)localObject2);
            }
          }
        }
        return localObject1;
        label272:
        paramString = (String)localObject1;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ApolloGameData paramApolloGameData, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, "[checkGameApp]");
    }
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramApolloGameData == null) || (paramSessionInfo == null))
    {
      QLog.e("CmGameTemp_CmGameSessionUtil", 1, "[checkGameApp] invalid param");
      return;
    }
    if (!PackageUtil.a(paramContext, paramApolloGameData.gameAppPkgName))
    {
      paramQQAppInterface = String.format("https://m.gamecenter.qq.com/directout/detail/%s?_wv=2147484679&_wwv=4&ADTAG=limixiuteam&autodownload=1&pf=invite&appid=%s&notShowPub=1&asyncMode=3&appType=1&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0", new Object[] { paramApolloGameData.gameAppid, paramApolloGameData.gameAppid });
      paramSessionInfo = new Intent(paramContext, QQBrowserActivity.class);
      paramSessionInfo.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.openQQBrowserActivity(paramContext, paramQQAppInterface, -1L, paramSessionInfo, false, -1);
      return;
    }
    ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().a(paramApolloGameData.gameId, paramApolloGameData.gameAppid, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ApolloGameMsgInfo localApolloGameMsgInfo = new ApolloGameMsgInfo();
    Object localObject = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    ApolloGameData localApolloGameData = ((ApolloDaoManagerServiceImpl)localObject).findGameById(paramInt);
    String str = HardCodeUtil.a(2131702166);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((ApolloDaoManagerServiceImpl)localObject).findActionById(localApolloGameData.actionId);
      if (localObject == null) {
        break label166;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label166:
    for (;;)
    {
      int i = localApolloGameData.actionId;
      localApolloGameMsgInfo.gameName = localApolloGameData.name;
      for (;;)
      {
        localApolloGameMsgInfo.actionName = str;
        localApolloGameMsgInfo.actionId = i;
        localApolloGameMsgInfo.gameId = paramInt;
        localApolloGameMsgInfo.roomId = paramLong;
        localApolloGameMsgInfo.gameStatus = 1;
        localApolloGameMsgInfo.msgType = 3;
        a(paramQQAppInterface, paramString, localApolloGameMsgInfo);
        return;
        localApolloGameMsgInfo.gameName = HardCodeUtil.a(2131702168);
        i = 0;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ApolloGameMsgInfo paramApolloGameMsgInfo)
  {
    if ((paramApolloGameMsgInfo == null) || (paramQQAppInterface == null))
    {
      QLog.e("CmGameTemp_CmGameSessionUtil", 1, "[sendGameMsg], errInfo->param is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, new Object[] { "[sendGameMsg], gameId:", Integer.valueOf(paramApolloGameMsgInfo.gameId), ",roomId:", Long.valueOf(paramApolloGameMsgInfo.roomId), ",extendInfo:", paramApolloGameMsgInfo.gameExtendJson });
    }
    ApolloMessage localApolloMessage = new ApolloMessage();
    if (!TextUtils.isEmpty(paramApolloGameMsgInfo.actionName)) {
      localApolloMessage.name = paramApolloGameMsgInfo.actionName.getBytes();
    }
    if (0 == 0) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("gameId", paramApolloGameMsgInfo.gameId);
        ((JSONObject)localObject).put("gameMode", paramApolloGameMsgInfo.gameMode);
        ((JSONObject)localObject).put("roomid", paramApolloGameMsgInfo.roomId);
        if (paramApolloGameMsgInfo.gameId == 1)
        {
          ((JSONObject)localObject).put("msgTyep", 2);
          ((JSONObject)localObject).put("gameName", paramApolloGameMsgInfo.gameName);
          if (!TextUtils.isEmpty(paramApolloGameMsgInfo.gameExtendJson)) {
            ((JSONObject)localObject).put("gameExtendJson", paramApolloGameMsgInfo.gameExtendJson);
          }
          ((JSONObject)localObject).put("gameStatus", paramApolloGameMsgInfo.gameStatus);
          if (localObject != null) {
            localApolloMessage.extStr = ((JSONObject)localObject).toString();
          }
          localObject = ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(paramQQAppInterface.getCurrentAccountUin());
          localApolloMessage.sender_ts = Utils.a(((ApolloBaseInfo)localObject).apolloServerTS);
          localApolloMessage.sender_status = ((ApolloBaseInfo)localObject).apolloStatus;
          localObject = ((ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(paramApolloGameMsgInfo.gameId);
          if ((localObject == null) || (1 != ((ApolloGameData)localObject).hasOwnArk)) {
            break label514;
          }
          i = 297;
          localApolloMessage.flag = (i | 0x200);
          paramString = MessageRecordFactory.a(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin(), 1036, localApolloMessage);
          if (paramApolloGameMsgInfo.gameId == 1)
          {
            paramString.msgType = 2;
            paramString.gameId = paramApolloGameMsgInfo.gameId;
            paramString.mGameMode = paramApolloGameMsgInfo.gameMode;
            paramString.roomId = paramApolloGameMsgInfo.roomId;
            paramString.mApolloMessage.id = paramApolloGameMsgInfo.actionId;
            paramString.gameName = paramApolloGameMsgInfo.gameName;
            paramString.gameExtendJson = paramApolloGameMsgInfo.gameExtendJson;
            paramString.gameStatus = paramApolloGameMsgInfo.gameStatus;
            paramString.extendJson = ("{\"gameStatus\":" + paramApolloGameMsgInfo.gameStatus + "}");
            paramQQAppInterface.getMessageFacade().a(paramString, null);
            a = System.currentTimeMillis();
          }
        }
        else
        {
          ((JSONObject)localObject).put("msgTyep", paramApolloGameMsgInfo.msgType);
          continue;
        }
        paramString.msgType = paramApolloGameMsgInfo.msgType;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.d("CmGameTemp_CmGameSessionUtil", 2, paramQQAppInterface, new Object[0]);
        return;
      }
      continue;
      label514:
      int i = 41;
      continue;
      Object localObject = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().b(paramString1, paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, new Object[] { "[addFakeInviteMsgLocal], gameId:", Integer.valueOf(paramInt), ",roomId:", Long.valueOf(paramLong), ",robotUin:", paramString1 });
    }
    ApolloGameMsgInfo localApolloGameMsgInfo = new ApolloGameMsgInfo();
    Object localObject2 = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    ApolloGameData localApolloGameData = ((ApolloDaoManagerServiceImpl)localObject2).findGameById(paramInt);
    Object localObject1 = HardCodeUtil.a(2131702167);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject2 = ((ApolloDaoManagerServiceImpl)localObject2).findActionById(localApolloGameData.actionId);
      if (localObject2 == null) {
        break label714;
      }
      localObject1 = ((ApolloActionData)localObject2).actionName;
    }
    label701:
    label714:
    for (;;)
    {
      int i = localApolloGameData.actionId;
      localApolloGameMsgInfo.gameName = localApolloGameData.name;
      localApolloGameMsgInfo.actionName = ((String)localObject1);
      localApolloGameMsgInfo.actionId = i;
      localApolloGameMsgInfo.gameId = paramInt;
      localApolloGameMsgInfo.roomId = paramLong;
      localApolloGameMsgInfo.gameStatus = 0;
      localApolloGameMsgInfo.msgType = 3;
      localObject2 = new ApolloMessage();
      if (!TextUtils.isEmpty(localApolloGameMsgInfo.actionName)) {
        ((ApolloMessage)localObject2).name = localApolloGameMsgInfo.actionName.getBytes();
      }
      localObject1 = null;
      if (0 == 0) {}
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("gameId", localApolloGameMsgInfo.gameId);
          ((JSONObject)localObject1).put("gameMode", localApolloGameMsgInfo.gameMode);
          ((JSONObject)localObject1).put("roomid", localApolloGameMsgInfo.roomId);
          if (localApolloGameMsgInfo.gameId == 1)
          {
            ((JSONObject)localObject1).put("msgTyep", 2);
            ((JSONObject)localObject1).put("gameName", localApolloGameMsgInfo.gameName);
            if (!TextUtils.isEmpty(localApolloGameMsgInfo.gameExtendJson)) {
              ((JSONObject)localObject1).put("gameExtendJson", localApolloGameMsgInfo.gameExtendJson);
            }
            ((JSONObject)localObject1).put("gameStatus", localApolloGameMsgInfo.gameStatus);
            if (localObject1 != null) {
              ((ApolloMessage)localObject2).extStr = ((JSONObject)localObject1).toString();
            }
            localObject1 = ((ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(paramQQAppInterface.getCurrentAccountUin());
            ((ApolloMessage)localObject2).sender_ts = Utils.a(((ApolloBaseInfo)localObject1).apolloServerTS);
            ((ApolloMessage)localObject2).sender_status = ((ApolloBaseInfo)localObject1).apolloStatus;
            i = 41;
            paramInt = i;
            if (localApolloGameData != null)
            {
              paramInt = i;
              if (1 == localApolloGameData.hasOwnArk) {
                paramInt = 297;
              }
            }
            ((ApolloMessage)localObject2).flag = (paramInt | 0x200);
            localObject1 = MessageRecordFactory.a(paramQQAppInterface, paramString1, paramQQAppInterface.getCurrentAccountUin(), 1036, (ApolloMessage)localObject2);
            if (localApolloGameMsgInfo.gameId != 1) {
              break label701;
            }
            ((MessageForApollo)localObject1).msgType = 2;
            ((MessageForApollo)localObject1).gameId = localApolloGameMsgInfo.gameId;
            ((MessageForApollo)localObject1).mGameMode = localApolloGameMsgInfo.gameMode;
            ((MessageForApollo)localObject1).roomId = localApolloGameMsgInfo.roomId;
            ((MessageForApollo)localObject1).mApolloMessage.id = localApolloGameMsgInfo.actionId;
            ((MessageForApollo)localObject1).gameName = localApolloGameMsgInfo.gameName;
            ((MessageForApollo)localObject1).gameExtendJson = localApolloGameMsgInfo.gameExtendJson;
            ((MessageForApollo)localObject1).gameStatus = localApolloGameMsgInfo.gameStatus;
            ((MessageForApollo)localObject1).extendJson = ("{\"gameStatus\":" + localApolloGameMsgInfo.gameStatus + ",\"robotOpenId\":" + paramString2 + "}");
            ((MessageForApollo)localObject1).senderuin = paramString1;
            ((MessageForApollo)localObject1).issend = 0;
            paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
            a = System.currentTimeMillis();
            return;
            localApolloGameMsgInfo.gameName = HardCodeUtil.a(2131702169);
            i = 0;
            break;
          }
          ((JSONObject)localObject1).put("msgTyep", localApolloGameMsgInfo.msgType);
          continue;
          ((MessageForApollo)localObject1).msgType = localApolloGameMsgInfo.msgType;
        }
        catch (Throwable paramQQAppInterface)
        {
          QLog.d("CmGameTemp_CmGameSessionUtil", 2, paramQQAppInterface, new Object[0]);
          return;
        }
      }
    }
  }
  
  public static boolean a()
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      localObject = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if (!(localObject instanceof CmGameChatPie)) {}
      }
    }
    for (Object localObject = (CmGameChatPie)localObject;; localObject = null) {
      return (localObject != null) && (((CmGameChatPie)localObject).E());
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    QLog.d("CmGameTemp_CmGameSessionUtil", 1, "sendGameAppArkMessage");
    try
    {
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_Int = 1036;
      localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
      localSessionInfo.b = paramQQAppInterface.getCurrentAccountUin();
      paramString1 = new JSONObject(paramString2);
      paramString2 = paramString1.optString("app");
      String str1 = paramString1.optString("view");
      String str2 = paramString1.optString("desc");
      String str3 = paramString1.optString("prompt");
      String str4 = paramString1.optString("ver");
      Object localObject = paramString1.optJSONObject("meta");
      paramString1 = null;
      if (localObject != null) {
        paramString1 = ((JSONObject)localObject).toString();
      }
      if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str4)))
      {
        QLog.d("CmGameTemp_CmGameSessionUtil", 1, new Object[] { "[sendGameAppArkMessage] failed, invalid param, appName=", paramString2, ", appView=", str1, ", appMinVersion=", str4 });
        return false;
      }
      localObject = new ArkAppMessage();
      ((ArkAppMessage)localObject).appName = paramString2;
      ((ArkAppMessage)localObject).appView = str1;
      ((ArkAppMessage)localObject).appMinVersion = str4;
      ((ArkAppMessage)localObject).appDesc = str2;
      ((ArkAppMessage)localObject).promptText = str3;
      ((ArkAppMessage)localObject).metaList = paramString1;
      ChatActivityFacade.b(paramQQAppInterface, localSessionInfo, (ArkAppMessage)localObject);
      return true;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("CmGameTemp_CmGameSessionUtil", 1, "[sendGameAppArkMessage] exception=", paramQQAppInterface);
    }
    return false;
  }
  
  public static List<MessageForApollo> b(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Object localObject1 = paramQQAppInterface.getMessageFacade().b(paramString, paramInt1);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      if (!QLog.isColorLevel()) {
        break label311;
      }
      QLog.d("CmGameTemp_CmGameSessionUtil", 2, "in aio, cache size:" + ((List)localObject1).size());
      paramString = (String)localObject1;
    }
    for (;;)
    {
      if ((paramString == null) || (paramString.size() == 0))
      {
        QLog.i("CmGameTemp_CmGameSessionUtil", 2, "msgRcd size is 0.");
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameSessionUtil", 2, "NOT in aio.");
        }
        paramString = paramQQAppInterface.getMessageFacade().a(paramString, paramInt1, new int[] { -2039 }, 20);
      }
      else
      {
        localObject1 = new ArrayList();
        ApolloGameManager localApolloGameManager = (ApolloGameManager)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
        paramInt1 = paramString.size() - 1;
        if (paramInt1 >= 0)
        {
          Object localObject2 = (MessageRecord)paramString.get(paramInt1);
          if (!(localObject2 instanceof MessageForApollo)) {}
          for (;;)
          {
            paramInt1 -= 1;
            break;
            localObject2 = (MessageForApollo)localObject2;
            if ((((MessageForApollo)localObject2).gameId == paramInt2) && (((MessageForApollo)localObject2).roomId == paramLong))
            {
              ((List)localObject1).add(localObject2);
              ((MessageForApollo)localObject2).gameStatus = 1;
              if (a()) {
                localApolloGameManager.a().a((MessageForApollo)localObject2);
              }
              ApolloGameUtil.a(paramQQAppInterface, (MessageForApollo)localObject2);
            }
            else if (((MessageForApollo)localObject2).gameStatus == 0)
            {
              ((MessageForApollo)localObject2).gameStatus = 3;
              ApolloGameUtil.a(paramQQAppInterface, (MessageForApollo)localObject2);
              if (a()) {
                localApolloGameManager.a().a((MessageForApollo)localObject2);
              }
            }
          }
        }
        return localObject1;
        label311:
        paramString = (String)localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameSessionUtil
 * JD-Core Version:    0.7.0.1
 */