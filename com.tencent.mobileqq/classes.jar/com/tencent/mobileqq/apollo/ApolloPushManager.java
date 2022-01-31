package com.tencent.mobileqq.apollo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3;
import yqz;
import yra;
import yrb;

public class ApolloPushManager
  implements Manager
{
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public ApolloPushManager.OnActionPushListener a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
  private WeakReference b;
  
  public ApolloPushManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloPushManager$OnActionPushListener = new yqz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(int paramInt, apollo_push_msgInfo.STPushMsgElem paramSTPushMsgElem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPushManager", 2, "[onRecvActionPush], aioType:" + paramInt);
    }
    if (paramSTPushMsgElem == null) {
      return;
    }
    try
    {
      int i = paramSTPushMsgElem.showPlace.get();
      int j = paramSTPushMsgElem.type.get();
      if ((1 != j) || (1 != i))
      {
        QLog.i("ApolloPushManager", 1, "[onRecvActionPush], It doesn't meet show conditions, type:" + j + ",showPlace:" + i);
        return;
      }
    }
    catch (Exception paramSTPushMsgElem)
    {
      paramSTPushMsgElem.printStackTrace();
      QLog.e("ApolloPushManager", 1, "errInfo->" + paramSTPushMsgElem.getMessage());
      return;
    }
    Object localObject = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)paramSTPushMsgElem.pm1.get();
    paramSTPushMsgElem = new ApolloActionPush();
    paramSTPushMsgElem.mId = NetConnInfoCenter.getServerTimeMillis();
    paramSTPushMsgElem.mActionId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).actionId.get();
    paramSTPushMsgElem.mActionType = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).actionType.get();
    paramSTPushMsgElem.mAioType = ApolloUtil.c(((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).aioType.get());
    paramSTPushMsgElem.mContent = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).diyWords.get();
    paramSTPushMsgElem.mRcvUin = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).rcvUin.get();
    paramSTPushMsgElem.mSendUin = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sendUin.get();
    if (!ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.w("ApolloPushManager", 1, "NOT apollo user, return.");
      return;
    }
    paramSTPushMsgElem.mWordShowType = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).wordType.get();
    String str;
    if (paramInt == 0)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((!TextUtils.isEmpty(str)) && (str.equals(Long.toString(((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sessionId.get())))) {
        if ((str.equals(Long.toString(paramSTPushMsgElem.mRcvUin))) || (0L == paramSTPushMsgElem.mRcvUin)) {
          paramSTPushMsgElem.mSessionId = paramSTPushMsgElem.mSendUin;
        }
      }
    }
    for (;;)
    {
      paramSTPushMsgElem.print();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(paramSTPushMsgElem);
      ThreadManager.post(new yra(this, paramInt, paramSTPushMsgElem), 5, null, true);
      if (paramInt == 0) {
        break;
      }
      localObject = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      localObject = String.valueOf(paramSTPushMsgElem.mSendUin);
      paramSTPushMsgElem = String.valueOf(paramSTPushMsgElem.mRcvUin);
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((!TextUtils.isEmpty(str)) && (!str.equals(localObject))) {
        ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "apllo_redPack_action");
      }
      if ((TextUtils.isEmpty(str)) || (str.equals(paramSTPushMsgElem))) {
        break;
      }
      ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSTPushMsgElem, "apllo_redPack_action");
      return;
      paramSTPushMsgElem.mSessionId = paramSTPushMsgElem.mRcvUin;
      continue;
      paramSTPushMsgElem.mSessionId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sessionId.get();
      continue;
      paramSTPushMsgElem.mSessionId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sessionId.get();
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void a(ApolloPushManager.OnActionPushListener paramOnActionPushListener)
  {
    if (paramOnActionPushListener == null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference = null;
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramOnActionPushListener);
  }
  
  public void a(ApolloPushManager.OnPushObserver paramOnPushObserver)
  {
    if (paramOnPushObserver == null)
    {
      this.b = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPushManager", 2, "[setOnPushObserver]");
    }
    this.b = new WeakReference(paramOnPushObserver);
  }
  
  public void a(ApolloActionPush paramApolloActionPush)
  {
    boolean bool = false;
    if (paramApolloActionPush == null)
    {
      QLog.e("ApolloPushManager", 1, "[tiggerAction] pushData is null,return.");
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = paramApolloActionPush.mActionId;
    localSpriteTaskParam.jdField_c_of_type_Int = 0;
    localSpriteTaskParam.h = paramApolloActionPush.mAioType;
    localSpriteTaskParam.g = 4;
    localSpriteTaskParam.jdField_a_of_type_Long = -10000L;
    localSpriteTaskParam.i = 0;
    localSpriteTaskParam.jdField_a_of_type_Float = 0.0F;
    localSpriteTaskParam.e = paramApolloActionPush.mActionType;
    localSpriteTaskParam.jdField_c_of_type_JavaLangString = paramApolloActionPush.mContent;
    Object localObject1;
    Object localObject2;
    if (paramApolloActionPush.mWordShowType == 1)
    {
      localSpriteTaskParam.jdField_b_of_type_Boolean = true;
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = String.valueOf(paramApolloActionPush.mSendUin);
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = String.valueOf(paramApolloActionPush.mRcvUin);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramApolloActionPush.mSendUin))) {
          bool = true;
        }
        localSpriteTaskParam.jdField_a_of_type_Boolean = bool;
        localObject1 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
        localObject2 = ((ApolloDaoManager)localObject1).a(localSpriteTaskParam.f);
        if (localObject2 == null) {
          break label253;
        }
        if (TextUtils.isEmpty(localSpriteTaskParam.jdField_c_of_type_JavaLangString)) {
          localSpriteTaskParam.jdField_c_of_type_JavaLangString = ApolloActionHelper.a(((ApolloActionData)localObject2).bubbleText);
        }
      }
    }
    for (;;)
    {
      localObject1 = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject1 != null) {
        ((SpriteScriptManager)localObject1).a().a(localSpriteTaskParam);
      }
      ThreadManager.post(new yrb(this, paramApolloActionPush, localSpriteTaskParam), 5, null, true);
      return;
      localSpriteTaskParam.jdField_b_of_type_Boolean = false;
      break;
      label253:
      localObject2 = Collections.synchronizedList(new ArrayList());
      ApolloActionData localApolloActionData = new ApolloActionData();
      localApolloActionData.actionId = localSpriteTaskParam.f;
      ((List)localObject2).add(localApolloActionData);
      ((ApolloDaoManager)localObject1).a((List)localObject2);
    }
  }
  
  public void a(apollo_push_msgInfo.STPushMsgElem paramSTPushMsgElem)
  {
    if ((paramSTPushMsgElem == null) || (!paramSTPushMsgElem.pm3.has()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ApolloPushManager", 1, "[onReceiveAioPush] msg null or pms none");
      return;
    }
    Object localObject2 = paramSTPushMsgElem.pm3.get();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      paramSTPushMsgElem = new ArrayList(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      int i = 1;
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)((Iterator)localObject2).next();
        Object localObject3;
        ApolloGameData localApolloGameData;
        if (((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).dotId.get() != 1003)
        {
          localObject3 = new ApolloGameRedDot();
          ((ApolloGameRedDot)localObject3).mDotId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).dotId.get();
          ((ApolloGameRedDot)localObject3).mStartTime = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).begTs.get();
          ((ApolloGameRedDot)localObject3).mEndTime = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).endTs.get();
          ((ApolloGameRedDot)localObject3).mTipsWording = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).wording.get();
          ((ApolloGameRedDot)localObject3).mGameId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).busId.get();
          ((ApolloGameRedDot)localObject3).mUrl = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).url.get();
          ((ApolloGameRedDot)localObject3).mActId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).actId.get();
          ((ApolloGameRedDot)localObject3).mPriority = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).priority.get();
          ((ApolloGameRedDot)localObject3).mSpRegion = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).spRegion.get();
          localObject4 = (HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(254);
          localApolloGameData = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(((ApolloGameRedDot)localObject3).mGameId);
          if (localApolloGameData != null)
          {
            if ((localObject4 != null) && (!TextUtils.isEmpty(localApolloGameData.hotChatCode))) {
              ((HotChatCenterManager)localObject4).b(localApolloGameData.hotChatCode, "[新活动]" + localApolloGameData.name + "：" + ((ApolloGameRedDot)localObject3).mTipsWording);
            }
          }
          else
          {
            label362:
            ((EntityManager)localObject1).b((Entity)localObject3);
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "get_notice", ((ApolloGameRedDot)localObject3).mDotId, 1, new String[] { String.valueOf(((ApolloGameRedDot)localObject3).mGameId), "", ((ApolloGameRedDot)localObject3).mActId });
            ApolloGameUtil.a((EntityManager)localObject1);
          }
        }
        for (;;)
        {
          break;
          QLog.e("ApolloPushManager", 1, new Object[] { "[parseGameRedDot] ", localApolloGameData.hotChatCode });
          break label362;
          localObject3 = new AioPushData();
          ((AioPushData)localObject3).begTs = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).begTs.get();
          ((AioPushData)localObject3).busId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).busId.get();
          ((AioPushData)localObject3).busType = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).busType.get();
          ((AioPushData)localObject3).dotId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).dotId.get();
          ((AioPushData)localObject3).endTs = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).endTs.get();
          ((AioPushData)localObject3).priority = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).priority.get();
          ((AioPushData)localObject3).them = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).theme.get();
          ((AioPushData)localObject3).wording = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).wording.get();
          ((AioPushData)localObject3).url = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).url.get();
          ((AioPushData)localObject3).actId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).actId.get();
          ((AioPushData)localObject3).spRegion = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).spRegion.get();
          ((AioPushData)localObject3).folderIconUrl = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)localObject4).folderIconUrl.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPushManager", 2, "[onReceiveAioPush] receive " + localObject3);
          }
          int j = i;
          if (this.b != null)
          {
            j = i;
            if (this.b.get() != null)
            {
              j = i;
              if (((AioPushData)localObject3).isShow)
              {
                j = 2;
                ((ApolloPushManager.OnPushObserver)this.b.get()).a(1, localObject3);
              }
            }
          }
          i = j;
        }
      }
      localObject1 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
      if (localObject1 != null) {
        ((ApolloDaoManager)localObject1).a(paramSTPushMsgElem, i);
      }
      for (;;)
      {
        ((HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(254)).a(NetConnInfoCenter.getServerTimeMillis());
        return;
        QLog.e("ApolloPushManager", 1, "[onReceiveAioPush] dao manager is null ");
      }
    }
    QLog.e("ApolloPushManager", 1, "[onReceiveAioPush] pb list is null or empty");
  }
  
  public void b(apollo_push_msgInfo.STPushMsgElem paramSTPushMsgElem)
  {
    if ((paramSTPushMsgElem == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    label70:
    apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2 localSTPushMsgElem0x2;
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            int i = paramSTPushMsgElem.showPlace.get();
            if ((2 == paramSTPushMsgElem.type.get()) && (3 == i)) {
              break label70;
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ApolloPushManager", 2, "onReceiveDrawerHirePush incompatible type");
              return;
            }
          }
          catch (Exception paramSTPushMsgElem) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("ApolloPushManager", 2, "onReceiveDrawerHirePush error:", paramSTPushMsgElem);
      return;
      localSTPushMsgElem0x2 = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2)paramSTPushMsgElem.pm2.get();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putLong("hire_for", localSTPushMsgElem0x2.toUin.get()).putInt("hire_action", localSTPushMsgElem0x2.actionId.get()).putLong("hire_end", localSTPushMsgElem0x2.endTs.get()).putString("hire_word", localSTPushMsgElem0x2.diyWords.get()).putInt("hire_priority", paramSTPushMsgElem.priority.get()).putBoolean("hire_bubble_click", false).commit();
    } while (!QLog.isColorLevel());
    QLog.i("ApolloPushManager", 2, "receive drawerHirePush:" + localSTPushMsgElem0x2.actionId.get() + "," + localSTPushMsgElem0x2.endTs.get() + "," + localSTPushMsgElem0x2.diyWords.get() + "," + paramSTPushMsgElem.priority.get());
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPushManager", 2, "[onDestroy]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPushManager
 * JD-Core Version:    0.7.0.1
 */