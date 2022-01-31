package com.tencent.mobileqq.apollo.script;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.callback.ISpriteBridgeInterface;
import com.tencent.mobileqq.apollo.script.callback.ISpriteStatusChanged;
import com.tencent.mobileqq.apollo.script.callback.ISpriteTaskInterface;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import ysa;
import ysb;

public class SpriteBridge
  implements ISpriteBridgeInterface
{
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private SpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  private ISpriteTaskInterface jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteTaskInterface;
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public SpriteBridge(SpriteContext paramSpriteContext, ISpriteTaskInterface paramISpriteTaskInterface, SpriteRscBuilder paramSpriteRscBuilder)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteTaskInterface = paramISpriteTaskInterface;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder = paramSpriteRscBuilder;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  private String a()
  {
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.jdField_a_of_type_Int = 0;
    localSpriteTaskParam.f = 4;
    localSpriteTaskParam.k = 2;
    localSpriteTaskParam.g = 5;
    localSpriteTaskParam.jdField_a_of_type_Long = 1000000L;
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a(localSpriteTaskParam);
  }
  
  private String a(SpriteTaskParam paramSpriteTaskParam)
  {
    Object localObject;
    if (paramSpriteTaskParam == null) {
      localObject = a();
    }
    String str;
    do
    {
      return localObject;
      if (!a(paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.f))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[playAction], fail to load script.");
        paramSpriteTaskParam.jdField_b_of_type_Int = 4;
        return a();
      }
      str = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a(paramSpriteTaskParam);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    paramSpriteTaskParam.jdField_b_of_type_Int = 4;
    return a();
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null)) {
      return false;
    }
    return ((SpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(248)).a().a(paramInt1, paramInt2) != null;
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new ysb(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        ISpriteStatusChanged localISpriteStatusChanged = (ISpriteStatusChanged)((WeakReference)localIterator.next()).get();
        if (localISpriteStatusChanged != null) {
          localISpriteStatusChanged.a(paramInt);
        }
      }
    }
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[buildSpriteTask], from:", Integer.valueOf(paramInt) });
    }
    if ((paramMessageForApollo == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteTaskInterface == null)) {
      break label48;
    }
    label48:
    while (!SpriteUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramMessageForApollo.istroop, paramMessageForApollo.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = paramMessageForApollo.mApolloMessage.id;
    localSpriteTaskParam.jdField_c_of_type_Int = paramMessageForApollo.actionType;
    localSpriteTaskParam.h = paramMessageForApollo.istroop;
    localSpriteTaskParam.g = paramInt;
    localSpriteTaskParam.jdField_a_of_type_Boolean = paramMessageForApollo.isSend();
    localSpriteTaskParam.jdField_a_of_type_Long = paramMessageForApollo.uniseq;
    localSpriteTaskParam.i = paramMessageForApollo.audioId;
    localSpriteTaskParam.jdField_a_of_type_Float = paramMessageForApollo.audioStartTime;
    if (paramMessageForApollo.isDoubleAction()) {
      i = 1;
    }
    localSpriteTaskParam.e = i;
    localSpriteTaskParam.jdField_c_of_type_JavaLangString = paramMessageForApollo.inputText;
    localSpriteTaskParam.jdField_b_of_type_Boolean = paramMessageForApollo.isBarrageMode();
    localSpriteTaskParam.jdField_d_of_type_JavaLangString = paramMessageForApollo.extendJson;
    if (localSpriteTaskParam.h == 0) {
      if (paramMessageForApollo.isSend())
      {
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramMessageForApollo.selfuin;
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramMessageForApollo.frienduin;
      }
    }
    for (;;)
    {
      a(localSpriteTaskParam);
      if (paramInt != 2) {
        break;
      }
      SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), localSpriteTaskParam);
      return;
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramMessageForApollo.frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramMessageForApollo.selfuin;
      continue;
      if ((localSpriteTaskParam.h == 1) || (localSpriteTaskParam.h == 3000))
      {
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = Long.toString(paramMessageForApollo.mApolloMessage.peer_uin);
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramMessageForApollo.senderuin;
      }
    }
  }
  
  public void a(SpriteContext paramSpriteContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[initSprite]");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder == null) || (paramSpriteContext == null) || (!paramSpriteContext.c())) {}
    String str;
    SpriteActionScript localSpriteActionScript;
    do
    {
      do
      {
        do
        {
          return;
        } while (!a(0, -1));
        str = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a();
      } while (TextUtils.isEmpty(str));
      localSpriteActionScript = SpriteUtil.a(paramSpriteContext.a());
    } while (localSpriteActionScript == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initSprite('").append(str).append("');");
    localSpriteActionScript.a(localStringBuilder.toString());
    localSpriteActionScript.a(paramSpriteContext.jdField_b_of_type_JavaLangString, false);
    localSpriteActionScript.a(paramSpriteContext.jdField_a_of_type_JavaLangString, false);
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.post(new ysa(this, paramSpriteTaskParam), 8, null, true);
  }
  
  public void a(ISpriteStatusChanged paramISpriteStatusChanged)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramISpriteStatusChanged));
  }
  
  public void a(ChatMessage paramChatMessage, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[buildSpriteTask]");
    }
    if ((paramChatMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteTaskInterface == null) || (paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    while (!SpriteUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramChatMessage.istroop, paramChatMessage.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = ((Integer)paramArrayList1.get(0)).intValue();
    localSpriteTaskParam.jdField_d_of_type_Int = 1;
    localSpriteTaskParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
    localSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList = paramArrayList2;
    localSpriteTaskParam.jdField_c_of_type_Int = 1;
    localSpriteTaskParam.h = paramChatMessage.istroop;
    if (paramChatMessage.isSend())
    {
      localSpriteTaskParam.g = 0;
      localSpriteTaskParam.jdField_a_of_type_Boolean = paramChatMessage.isSend();
      localSpriteTaskParam.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (localSpriteTaskParam.h != 0) {
        break label225;
      }
      if (!paramChatMessage.isSend()) {
        break label204;
      }
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.selfuin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.frienduin;
    }
    for (;;)
    {
      a(localSpriteTaskParam);
      return;
      localSpriteTaskParam.g = 1;
      break;
      label204:
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.selfuin;
      continue;
      label225:
      if ((localSpriteTaskParam.h == 1) || (localSpriteTaskParam.h == 3000)) {
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
      }
    }
  }
  
  public void a(MessageForApollo paramMessageForApollo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[sendMsg], msg:", paramMessageForApollo });
    }
    try
    {
      if (!a(paramMessageForApollo.actionType, paramMessageForApollo.mApolloMessage.id))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[sendMsg], fail to load script, actionType:" + paramMessageForApollo.actionType);
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("id", paramMessageForApollo.mApolloMessage.id);
      if (paramMessageForApollo.mApolloMessage.name != null) {
        ((JSONObject)localObject).put("name", SpriteUtil.a(Base64Util.encodeToString(paramMessageForApollo.mApolloMessage.name, 0)));
      }
      if (paramMessageForApollo.mApolloMessage.text != null) {
        ((JSONObject)localObject).put("atText", SpriteUtil.a(Base64Util.encodeToString(paramMessageForApollo.mApolloMessage.text, 0)));
      }
      ((JSONObject)localObject).put("peerUin", paramMessageForApollo.mApolloMessage.peer_uin);
      if (!TextUtils.isEmpty(paramMessageForApollo.mApolloMessage.extStr)) {
        ((JSONObject)localObject).put("extraStr", new JSONObject(paramMessageForApollo.mApolloMessage.extStr));
      }
      ApolloMessage localApolloMessage = paramMessageForApollo.mApolloMessage;
      localApolloMessage.flag |= 0x200;
      ((JSONObject)localObject).put("flag", paramMessageForApollo.mApolloMessage.flag);
      ((JSONObject)localObject).put("senderTS", paramMessageForApollo.mApolloMessage.sender_ts);
      ((JSONObject)localObject).put("peerTS", paramMessageForApollo.mApolloMessage.peer_ts);
      ((JSONObject)localObject).put("senderStatus", paramMessageForApollo.mApolloMessage.sender_status);
      ((JSONObject)localObject).put("peerStatus", paramMessageForApollo.mApolloMessage.peer_status);
      localJSONObject.put("type", paramMessageForApollo.actionType);
      localJSONObject.put("basicMsg", localObject);
      paramMessageForApollo = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendMsg").append("('").append(localJSONObject.toString()).append("');");
      if (paramMessageForApollo != null)
      {
        paramMessageForApollo.a(((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable paramMessageForApollo)
    {
      QLog.e("cmshow_scripted_SpriteBridge", 1, paramMessageForApollo, new Object[0]);
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c())) {}
    do
    {
      return;
      localObject = ((SpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(248)).a();
    } while (localObject == null);
    Object localObject = ((SpriteScriptCreator)localObject).a(0);
    if (localObject == null)
    {
      QLog.w("cmshow_scripted_SpriteBridge", 1, "actionScript == null.");
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)paramList.next();
      try
      {
        localJSONArray.put(new JSONObject(a(localSpriteTaskParam)));
        ((SpriteAioScript)localObject).a(localSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
      }
      catch (Exception localException)
      {
        QLog.e("cmshow_scripted_SpriteBridge", 1, "[playAction] e:", localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[playAction], ready to play");
    }
    paramList = new StringBuilder();
    paramList.append("playShowAction('").append(localJSONArray.toString()).append("');");
    ((SpriteAioScript)localObject).a(paramList.toString());
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c())) {}
    Object localObject1;
    do
    {
      return;
      if ((paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList != null) && (paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d()))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 2, "[playAction], BackgroundSurface is not ready and add now");
        b();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a(paramSpriteTaskParam);
      if (!a(paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.f))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[playAction], fail to load script.");
        paramSpriteTaskParam.jdField_b_of_type_Int = 4;
        return;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a(paramSpriteTaskParam);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramSpriteTaskParam.jdField_b_of_type_Int = 4;
        return;
      }
      localObject1 = (SpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(248);
      localObject3 = ((SpriteScriptManager)localObject1).a();
    } while (localObject3 == null);
    Object localObject3 = ((SpriteScriptCreator)localObject3).a(paramSpriteTaskParam.jdField_c_of_type_Int);
    if (localObject3 == null)
    {
      QLog.w("cmshow_scripted_SpriteBridge", 1, "actionScript == null.");
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.f) });
    }
    paramSpriteTaskParam.jdField_b_of_type_Int = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playAction('").append((String)localObject2).append("');");
    ((SpriteAioScript)localObject3).a(localStringBuilder.toString());
    ((SpriteAioScript)localObject3).a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    ((SpriteAioScript)localObject3).a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      ApolloActionHelper.a((QQAppInterface)localObject2, paramSpriteTaskParam, bool, paramSpriteTaskParam.jdField_b_of_type_Boolean);
      localObject1 = ((SpriteScriptManager)localObject1).a();
      if ((localObject1 == null) || (SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()))) {
        break;
      }
      if ((paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList == null) || (paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label372;
      }
      ((SpriteBackgroundManager)localObject1).a(paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList);
      return;
      bool = false;
    }
    label372:
    ((SpriteBackgroundManager)localObject1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBridge
 * JD-Core Version:    0.7.0.1
 */