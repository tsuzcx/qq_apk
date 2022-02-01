package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.api.script.ISpriteUIHandler;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.callback.ISpriteStatusChanged;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpriteBridge
  implements ISpriteBridge
{
  private ISpriteTaskHandler jdField_a_of_type_ComTencentMobileqqApolloApiScriptISpriteTaskHandler;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private SpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  private SpriteScriptCreator jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator;
  private String jdField_a_of_type_JavaLangString;
  private CopyOnWriteArrayList<WeakReference<ISpriteStatusChanged>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public SpriteBridge(SpriteContext paramSpriteContext, ISpriteTaskHandler paramISpriteTaskHandler, SpriteRscBuilder paramSpriteRscBuilder, SpriteScriptCreator paramSpriteScriptCreator)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptISpriteTaskHandler = paramISpriteTaskHandler;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder = paramSpriteRscBuilder;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator = paramSpriteScriptCreator;
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
  
  private boolean a(int paramInt)
  {
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.b == null))
    {
      bool2 = false;
      return bool2;
    }
    Object localObject1 = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.b.get();
    if (localObject1 != null)
    {
      Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("apollo_action_random", 0);
      localObject1 = String.valueOf(paramInt);
      if (((SharedPreferences)localObject2).getInt((String)localObject1, -1) > 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, paramInt);
        ((SharedPreferences.Editor)localObject2).commit();
        return bool1;
      }
    }
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a(paramInt1, paramInt2) != null;
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().post(new SpriteBridge.3(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a();
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
    if ((paramMessageForApollo == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptISpriteTaskHandler == null)) {
      break label48;
    }
    label48:
    while (!SpriteUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramMessageForApollo.istroop, paramMessageForApollo.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = ApolloUtilImpl.getPlayActionId(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, paramMessageForApollo);
    localSpriteTaskParam.jdField_c_of_type_Int = ApolloUtilImpl.getPlayActionType(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, paramMessageForApollo);
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
    localSpriteTaskParam.l = paramMessageForApollo.mSendSrc;
    if (CmShowAioMatcher.a(localSpriteTaskParam.h, 1)) {
      if (paramMessageForApollo.isSend())
      {
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramMessageForApollo.selfuin;
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramMessageForApollo.frienduin;
      }
    }
    for (;;)
    {
      b(localSpriteTaskParam);
      if (paramInt != 2) {
        break;
      }
      SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), localSpriteTaskParam);
      return;
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramMessageForApollo.frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramMessageForApollo.selfuin;
      continue;
      if (CmShowAioMatcher.a(localSpriteTaskParam.h, 2))
      {
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = Long.toString(paramMessageForApollo.mApolloMessage.peer_uin);
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramMessageForApollo.senderuin;
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
      if ((!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.i()) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d()))
      {
        localObject1 = ((ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(ISpriteScriptManager.class, "all")).getUIHandler();
        if (localObject1 != null) {
          ((ISpriteUIHandler)localObject1).a(false, "none_apollo_play_action");
        }
      }
      Object localObject1 = new JSONObject();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("id", paramMessageForApollo.mApolloMessage.id);
      if (paramMessageForApollo.mApolloMessage.name != null) {
        ((JSONObject)localObject2).put("name", SpriteUtil.a(Base64Util.encodeToString(paramMessageForApollo.mApolloMessage.name, 0)));
      }
      if (paramMessageForApollo.mApolloMessage.text != null) {
        ((JSONObject)localObject2).put("atText", SpriteUtil.a(Base64Util.encodeToString(paramMessageForApollo.mApolloMessage.text, 0)));
      }
      ((JSONObject)localObject2).put("peerUin", paramMessageForApollo.mApolloMessage.peer_uin);
      if (!TextUtils.isEmpty(paramMessageForApollo.mApolloMessage.extStr)) {
        ((JSONObject)localObject2).put("extraStr", new JSONObject(paramMessageForApollo.mApolloMessage.extStr));
      }
      ApolloMessage localApolloMessage = paramMessageForApollo.mApolloMessage;
      localApolloMessage.flag |= 0x200;
      ((JSONObject)localObject2).put("model", ApolloActionData.getModelString(paramMessageForApollo.mApolloMessage.id));
      ((JSONObject)localObject2).put("flag", paramMessageForApollo.mApolloMessage.flag);
      ((JSONObject)localObject2).put("senderTS", paramMessageForApollo.mApolloMessage.sender_ts);
      ((JSONObject)localObject2).put("peerTS", paramMessageForApollo.mApolloMessage.peer_ts);
      ((JSONObject)localObject2).put("senderStatus", paramMessageForApollo.mApolloMessage.sender_status);
      ((JSONObject)localObject2).put("peerStatus", paramMessageForApollo.mApolloMessage.peer_status);
      ((JSONObject)localObject2).put("curUsedIdType", paramMessageForApollo.curUsedIdType);
      if (8 == paramMessageForApollo.actionType)
      {
        ((JSONObject)localObject2).put("actionRootPath", "" + paramMessageForApollo.mApolloMessage.id);
        ((JSONObject)localObject2).put("isSend", a(paramMessageForApollo.mApolloMessage.id));
      }
      ((JSONObject)localObject1).put("type", paramMessageForApollo.actionType);
      ((JSONObject)localObject1).put("basicMsg", localObject2);
      paramMessageForApollo = (SpriteActionScript)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a(0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendMsg").append("('").append(((JSONObject)localObject1).toString()).append("');");
      if (paramMessageForApollo != null)
      {
        paramMessageForApollo.b(((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (Throwable paramMessageForApollo)
    {
      QLog.e("cmshow_scripted_SpriteBridge", 1, paramMessageForApollo, new Object[0]);
    }
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c())) {}
    Object localObject1;
    do
    {
      return;
      if ((paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList != null) && (paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.g()))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 2, "[playAction], BackgroundSurface is not ready and add now");
        c();
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
      localObject1 = (SpriteScriptManagerImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(ISpriteScriptManager.class, "all");
      localObject3 = ((SpriteScriptManagerImpl)localObject1).getSpriteCreator();
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
    ((SpriteAioScript)localObject3).b(localStringBuilder.toString());
    ((SpriteAioScript)localObject3).a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    ((SpriteAioScript)localObject3).a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      ApolloActionHelperImpl.doActionReport((QQAppInterface)localObject2, paramSpriteTaskParam, bool, paramSpriteTaskParam.jdField_b_of_type_Boolean);
      localObject1 = ((SpriteScriptManagerImpl)localObject1).getSpriteBackgroundManager();
      if ((localObject1 == null) || (SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()))) {
        break;
      }
      if ((paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList == null) || (paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label375;
      }
      ((SpriteBackgroundManager)localObject1).a(paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList);
      return;
      bool = false;
    }
    label375:
    ((SpriteBackgroundManager)localObject1).a();
  }
  
  public void a(SpriteContext paramSpriteContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[initSprite]");
    }
    int i = SpriteUtil.b(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder == null) || (paramSpriteContext == null) || (!paramSpriteContext.c())) {
      TraceReportUtil.a(i, 300, 160, new Object[] { "glview is not ready" });
    }
    String str;
    SpriteActionScript localSpriteActionScript;
    do
    {
      do
      {
        return;
      } while (!a(0, -1));
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a();
        QLog.d("CmShowStatUtil", 1, "get spriteJs");
      }
      while (TextUtils.isEmpty(str))
      {
        TraceReportUtil.a(i, 300, 301, new Object[] { "spriteJs is empty" });
        return;
        str = this.jdField_a_of_type_JavaLangString;
        QLog.d("CmShowStatUtil", 1, "spriteJs from cache");
        this.jdField_a_of_type_JavaLangString = null;
      }
      localSpriteActionScript = (SpriteActionScript)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a(0);
    } while (localSpriteActionScript == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initSprite('").append(str).append("');");
    TraceReportUtil.a(i, 350);
    QLog.d("cmshow_scripted_SpriteBridge", 1, "TraceReport CmShowStatUtil commitJS:(initSprite )");
    if (!paramSpriteContext.c) {
      localSpriteActionScript.b(localStringBuilder.toString());
    }
    ThreadManager.executeOnSubThread(new SpriteBridge.2(this, localSpriteActionScript, paramSpriteContext));
  }
  
  public void a(ISpriteStatusChanged paramISpriteStatusChanged)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramISpriteStatusChanged));
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramChatMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptISpriteTaskHandler == null)) {}
    while (!SpriteUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramChatMessage.istroop, paramChatMessage.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = paramInt;
    ApolloActionData localApolloActionData = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramInt);
    if (localApolloActionData != null)
    {
      localSpriteTaskParam.jdField_c_of_type_Int = localApolloActionData.actionType;
      localSpriteTaskParam.e = localApolloActionData.personNum;
    }
    localSpriteTaskParam.h = paramChatMessage.istroop;
    if (paramChatMessage.isSend())
    {
      localSpriteTaskParam.g = 0;
      localSpriteTaskParam.jdField_a_of_type_Boolean = paramChatMessage.isSend();
      localSpriteTaskParam.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (!CmShowAioMatcher.a(localSpriteTaskParam.h, 1)) {
        break label192;
      }
      if (!paramChatMessage.isSend()) {
        break label173;
      }
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.selfuin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.frienduin;
    }
    for (;;)
    {
      b(localSpriteTaskParam);
      return;
      localSpriteTaskParam.g = 1;
      break;
      label173:
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.selfuin;
      continue;
      label192:
      if (CmShowAioMatcher.a(localSpriteTaskParam.h, 2)) {
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[buildSpriteTask]");
    }
    if ((paramChatMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptISpriteTaskHandler == null) || (paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
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
      if (!CmShowAioMatcher.a(localSpriteTaskParam.h, 1)) {
        break label229;
      }
      if (!paramChatMessage.isSend()) {
        break label208;
      }
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.selfuin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.frienduin;
    }
    for (;;)
    {
      b(localSpriteTaskParam);
      return;
      localSpriteTaskParam.g = 1;
      break;
      label208:
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.selfuin;
      continue;
      label229:
      if (CmShowAioMatcher.a(localSpriteTaskParam.h, 2)) {
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
      }
    }
  }
  
  public void a(List<SpriteTaskParam> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c())) {}
    do
    {
      return;
      localObject = ((SpriteScriptManagerImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteCreator();
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
    ((SpriteAioScript)localObject).b(paramList.toString());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new SpriteBridge.1(this, paramSpriteTaskParam), 192, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBridge
 * JD-Core Version:    0.7.0.1
 */