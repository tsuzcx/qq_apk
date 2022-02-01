import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.apollo.ApolloGameArkHandler.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class amly
{
  public static final LRULinkedHashMap<String, String> a;
  private WeakReference<QQAppInterface> a;
  
  static
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(50);
  }
  
  public amly(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  private String a(MessageForApollo paramMessageForApollo)
  {
    if ((a() == null) || (paramMessageForApollo == null)) {
      return "com.tencent.cmshow";
    }
    if (paramMessageForApollo.istroop == 1036) {
      return "com.tencent.cmgame.social";
    }
    if (paramMessageForApollo.isHasOwnArk())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQ_CmGame_CmGameTemp", 2, new Object[] { "[getArkAppName], msg.gameId:", Integer.valueOf(paramMessageForApollo.gameId), " hasOwnArk." });
      }
      return "com.tencent.cmshow." + paramMessageForApollo.gameId;
    }
    return "com.tencent.cmshow";
  }
  
  private JSONArray a(List<Long> paramList, int paramInt, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    for (;;)
    {
      JSONArray localJSONArray;
      int i;
      String str;
      JSONObject localJSONObject;
      try
      {
        localJSONArray = new JSONArray();
        int j = paramList.size();
        i = 0;
        if (i >= j) {
          break label213;
        }
        str = String.valueOf(paramList.get(i));
        if (TextUtils.isEmpty(str))
        {
          QLog.w("QQ_CmGame_CmGameTemp", 1, "[getPlayerInfo], uin is null.");
        }
        else
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("uin", str);
          localObject = a();
          if (localObject == null) {
            break;
          }
          if (str.equals(((QQAppInterface)localObject).getCurrentAccountUin()))
          {
            localObject = ((QQAppInterface)localObject).getCurrentNickname();
            localJSONObject.put("nickname", localObject);
            localObject = a(str);
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break label200;
            }
            localJSONObject.put("avatarUrl", localObject);
            localJSONArray.put(localJSONObject);
          }
        }
      }
      catch (Throwable paramList)
      {
        QLog.e("QQ_CmGame_CmGameTemp", 1, paramList, new Object[0]);
        return null;
      }
      Object localObject = anck.a((QQAppInterface)localObject, paramInt, str, paramString, true);
      continue;
      label200:
      localJSONObject.put("avatarUrl", "");
      continue;
      label213:
      return localJSONArray;
      i += 1;
    }
  }
  
  private void a(String paramString)
  {
    ThreadManager.post(new ApolloGameArkHandler.1(this, paramString), 5, null, true);
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public MessageForArkApp a(MessageForApollo paramMessageForApollo, MessageForArkApp paramMessageForArkApp)
  {
    MessageForArkApp localMessageForArkApp = paramMessageForArkApp;
    if (paramMessageForArkApp == null)
    {
      QLog.i("QQ_CmGame_CmGameTemp", 1, "create an arkMsg obj.");
      localMessageForArkApp = new MessageForArkApp();
      localMessageForArkApp.ark_app_message = new ArkAppMessage();
    }
    paramMessageForArkApp = a();
    ArkAppMessage localArkAppMessage = localMessageForArkApp.ark_app_message;
    if ((paramMessageForApollo == null) || (localArkAppMessage == null) || (paramMessageForArkApp == null)) {
      return localMessageForArkApp;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQ_CmGame_CmGameTemp", 2, new Object[] { "gameStatus:", Integer.valueOf(paramMessageForApollo.gameStatus), ",gameId:", Integer.valueOf(paramMessageForApollo.gameId), ",arkInfo:", paramMessageForApollo.gameArkInfo, ",roomId:", Long.valueOf(paramMessageForApollo.roomId), ",msgId:", Long.valueOf(paramMessageForApollo.uniseq), ",seq:", Long.valueOf(paramMessageForApollo.msgseq), ",msgType:", Integer.valueOf(paramMessageForApollo.msgType) });
    }
    int i;
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    Object localObject1;
    label400:
    Object localObject2;
    for (;;)
    {
      try
      {
        i = paramMessageForApollo.gameStatus;
        localArkAppMessage.reset();
        localArkAppMessage.appName = a(paramMessageForApollo);
        localArkAppMessage.appMinVersion = "1.0.0.0";
        localArkAppMessage.appDesc = anvx.a(2131699853);
        localJSONObject1 = new JSONObject();
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("gameId", paramMessageForApollo.gameId);
        localJSONObject2.put("msgId", String.valueOf(paramMessageForApollo.uniseq));
        if (paramMessageForApollo.istroop == 1036)
        {
          localJSONObject2.put("senderUin", paramMessageForApollo.senderuin);
          if (paramMessageForApollo.isSend())
          {
            localJSONObject2.put("receiverUin", paramMessageForApollo.frienduin);
            localJSONObject2.put("createTime", paramMessageForApollo.time);
            localJSONObject2.put("roomId", String.valueOf(paramMessageForApollo.roomId));
            localJSONObject2.put("gameName", paramMessageForApollo.gameName);
          }
        }
        else
        {
          if (TextUtils.isEmpty(paramMessageForApollo.gameExtendJson)) {
            break label1273;
          }
          localObject1 = new JSONObject(paramMessageForApollo.gameExtendJson);
          localJSONObject2.put("extendInfo", ((JSONObject)localObject1).optString("extendInfo"));
          if (paramMessageForApollo.msgType != 4) {
            break label577;
          }
          localArkAppMessage.appView = "game_share";
          localJSONObject2.put("gameStatus", 100);
          i = 100;
          if (paramMessageForApollo.istroop != 1036) {
            break label1282;
          }
          localObject1 = ((amme)paramMessageForArkApp.getManager(QQManagerFactory.APOLLO_MANAGER)).a();
          localObject2 = new JSONArray();
        }
        switch (i)
        {
        case 0: 
          label496:
          paramMessageForArkApp = new JSONArray();
          localObject1 = paramMessageForApollo.winnerList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label884;
          }
          paramMessageForArkApp.put(String.valueOf((Long)((Iterator)localObject1).next()));
          continue;
          localJSONObject2.put("receiverUin", paramMessageForApollo.selfuin);
        }
      }
      catch (Throwable paramMessageForApollo)
      {
        QLog.e("QQ_CmGame_CmGameTemp", 1, paramMessageForApollo, new Object[0]);
        return localMessageForArkApp;
      }
      continue;
      label577:
      if (paramMessageForApollo.istroop == 1036) {}
      for (localArkAppMessage.appView = "SocialGame";; localArkAppMessage.appView = "game_aio")
      {
        localJSONObject2.put("gameStatus", paramMessageForApollo.gameStatus);
        localJSONObject2.put("extendJson", paramMessageForApollo.gameArkInfo);
        localJSONObject2.put("commInfo", paramMessageForApollo.commInfo);
        break;
      }
      paramMessageForArkApp = new JSONObject();
      paramMessageForArkApp.put("uin", paramMessageForApollo.senderuin);
      paramMessageForArkApp.put("nickname", ((amuf)localObject1).a.get(paramMessageForApollo.senderuin));
      paramMessageForArkApp.put("avatarUrl", ((amuf)localObject1).b.get(paramMessageForApollo.senderuin));
      ((JSONArray)localObject2).put(paramMessageForArkApp);
      localJSONObject2.put("players", localObject2);
    }
    paramMessageForArkApp = new JSONObject();
    paramMessageForArkApp.put("uin", paramMessageForApollo.senderuin);
    paramMessageForArkApp.put("nickname", ((amuf)localObject1).a.get(paramMessageForApollo.senderuin));
    paramMessageForArkApp.put("avatarUrl", ((amuf)localObject1).b.get(paramMessageForApollo.senderuin));
    ((JSONArray)localObject2).put(paramMessageForArkApp);
    if (paramMessageForApollo.isSend()) {}
    for (paramMessageForArkApp = paramMessageForApollo.frienduin;; paramMessageForArkApp = paramMessageForApollo.selfuin)
    {
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("uin", paramMessageForArkApp);
      localJSONObject3.put("nickname", ((amuf)localObject1).a.get(paramMessageForArkApp));
      localJSONObject3.put("avatarUrl", ((amuf)localObject1).b.get(paramMessageForArkApp));
      ((JSONArray)localObject2).put(localJSONObject3);
      localJSONObject2.put("players", localObject2);
      break;
    }
    label884:
    localJSONObject2.put("winList", paramMessageForArkApp);
    long l2 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    long l1 = l2;
    if (l2 < paramMessageForApollo.time) {
      l1 = paramMessageForApollo.time;
    }
    localJSONObject2.put("currentTime", l1);
    for (;;)
    {
      localJSONObject1.put("gameArk", localJSONObject2);
      localArkAppMessage.metaList = localJSONObject1.toString();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQ_CmGame_CmGameTemp", 2, localArkAppMessage.metaList);
      return localMessageForArkApp;
      localJSONObject2.put("roomCapacity", paramMessageForApollo.roomVol);
      paramMessageForApollo = a(paramMessageForApollo.playerList, paramMessageForApollo.istroop, paramMessageForApollo.frienduin);
      if ((paramMessageForApollo != null) && (paramMessageForApollo.length() > 0))
      {
        localJSONObject2.put("players", paramMessageForApollo);
        continue;
        paramMessageForArkApp = new JSONArray();
        localObject1 = paramMessageForApollo.winnerList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramMessageForArkApp.put(String.valueOf((Long)((Iterator)localObject1).next()));
        }
        localJSONObject2.put("winList", paramMessageForArkApp);
        localJSONObject2.put("overType", paramMessageForApollo.overType);
        paramMessageForArkApp = a(paramMessageForApollo.playerList, paramMessageForApollo.istroop, paramMessageForApollo.frienduin);
        if ((paramMessageForArkApp != null) && (paramMessageForArkApp.length() > 0)) {
          localJSONObject2.put("players", paramMessageForArkApp);
        }
        localJSONObject2.put("wording", paramMessageForApollo.winRecord);
        continue;
        localObject2 = ((ankc)paramMessageForArkApp.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).a(paramMessageForApollo.gameId);
        paramMessageForArkApp = anvx.a(2131699854);
        if (!TextUtils.isEmpty(paramMessageForApollo.gameName)) {
          paramMessageForArkApp = paramMessageForApollo.gameName;
        }
        if (localObject2 != null) {
          paramMessageForArkApp = ((ApolloGameData)localObject2).name;
        }
        if (localObject1 != null)
        {
          localJSONObject2.put("summary", ((JSONObject)localObject1).optString("summary"));
          localJSONObject2.put("picUrl", ((JSONObject)localObject1).optString("picUrl"));
        }
        localJSONObject2.put("title", paramMessageForArkApp);
        localJSONObject2.put("gameMode", paramMessageForApollo.mGameMode);
        continue;
        label1273:
        localObject1 = null;
        break label400;
        break label496;
        label1282:
        switch (i)
        {
        }
      }
    }
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 19	amly:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   5: ifnull +12 -> 17
    //   8: aload_1
    //   9: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +9 -> 23
    //   17: aconst_null
    //   18: astore_3
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_3
    //   22: areturn
    //   23: getstatic 19	amly:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   26: aload_1
    //   27: invokevirtual 434	com/tencent/util/LRULinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 106	java/lang/String
    //   33: astore 4
    //   35: aload 4
    //   37: astore_3
    //   38: aload 4
    //   40: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifeq -24 -> 19
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 436	amly:a	(Ljava/lang/String;)V
    //   51: aconst_null
    //   52: astore_3
    //   53: goto -34 -> 19
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	amly
    //   0	61	1	paramString	String
    //   12	2	2	bool	boolean
    //   18	35	3	localObject	Object
    //   33	6	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	13	56	finally
    //   23	35	56	finally
    //   38	51	56	finally
  }
  
  public void a(MessageForApollo paramMessageForApollo)
  {
    MessageForArkApp localMessageForArkApp = a(paramMessageForApollo, paramMessageForApollo.mApolloGameArkMsg);
    if ((localMessageForArkApp == null) || (localMessageForArkApp.ark_app_message == null)) {
      return;
    }
    if (paramMessageForApollo.istroop == 1036)
    {
      a(paramMessageForApollo, "UpdateSocialGame", localMessageForArkApp.ark_app_message.metaList);
      return;
    }
    a(paramMessageForApollo, "UpdateGameAioView", localMessageForArkApp.ark_app_message.metaList);
  }
  
  public void a(MessageForApollo paramMessageForApollo, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramMessageForApollo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQ_CmGame_CmGameTemp", 2, new Object[] { "eventName:", paramString1, ",data:", paramString2 });
    }
    paramMessageForApollo = a(paramMessageForApollo);
    try
    {
      ArkAppCenter.a(paramMessageForApollo, paramString1, paramString2, "json");
      return;
    }
    catch (Throwable paramMessageForApollo)
    {
      QLog.e("QQ_CmGame_CmGameTemp", 1, paramMessageForApollo, new Object[0]);
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 19	amly:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   5: ifnull +19 -> 24
    //   8: aload_1
    //   9: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +12 -> 24
    //   15: aload_2
    //   16: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: istore_3
    //   20: iload_3
    //   21: ifeq +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: getstatic 19	amly:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   30: aload_1
    //   31: aload_2
    //   32: invokevirtual 465	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: goto -12 -> 24
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	amly
    //   0	44	1	paramString1	String
    //   0	44	2	paramString2	String
    //   19	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	39	finally
    //   27	36	39	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amly
 * JD-Core Version:    0.7.0.1
 */