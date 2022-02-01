package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.AbsTroopOnlinePushHandlerProcessor;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.handler.TroopMemberListHandler;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;

public class TroopOnlinePushProcessor
  extends AbsTroopOnlinePushHandlerProcessor
{
  private void a(QQAppInterface paramQQAppInterface, long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    if (paramSubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has())
    {
      paramSubCmd0x1UpdateAppUnreadNum = (submsgtype0x26.AppTipNotify)paramSubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.get();
      if ((paramSubCmd0x1UpdateAppUnreadNum.uint32_action.has()) && (paramSubCmd0x1UpdateAppUnreadNum.uint32_action.get() == 1))
      {
        long l1;
        try
        {
          l1 = Long.parseLong(paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString);
        }
        catch (NumberFormatException paramSubCmd0x1UpdateAppUnreadNum)
        {
          paramSubCmd0x1UpdateAppUnreadNum.printStackTrace();
          l1 = 0L;
        }
        long l2;
        if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0)) {
          l2 = paramArrayOfLong[0];
        } else {
          l2 = 0L;
        }
        if ((l1 > 0L) && (l2 > 0L))
        {
          paramArrayOfLong = paramQQAppInterface.getAVNotifyCenter();
          if (paramArrayOfLong != null)
          {
            paramArrayOfLong.a(8, l1, 2, paramInt1, paramInt2, paramInt3, 20, 1);
            paramArrayOfLong.b(l1, true);
            paramArrayOfLong.a(21, 1, l1, 0L);
          }
          VideoMsgTools.a(paramQQAppInterface, 1, 13, false, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, Long.toString(l2), TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), String.valueOf(l2)), null, TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), String.valueOf(l2)), 2, new Object[0]);
        }
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, TroopEnterEffectData paramTroopEnterEffectData)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      ContactUtils.a((QQAppInterface)paramAppInterface, paramTroopEnterEffectData.jdField_a_of_type_JavaLangString, paramTroopEnterEffectData.b, 1, 0);
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramAppInterface = (QQAppInterface)paramAppInterface;
      if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 101509131L)
      {
        if (paramTroopUnreadMsgInfo.b > 0)
        {
          paramAppInterface = (ITroopBatchAddFriendService)paramAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "");
          if (paramAppInterface != null) {
            paramAppInterface.getTroopBatchAddFriendMgr().d(paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString);
          }
        }
      }
      else if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 101796525L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopOnlinePushProcessor", 2, "handleTroopNewsOnlinePush() for watching together.");
        }
        ((TogetherControlManager)paramAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, paramTroopUnreadMsgInfo.b, paramTroopUnreadMsgInfo.jdField_a_of_type_Int, paramTroopUnreadMsgInfo);
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, TroopUnreadMsgInfo paramTroopUnreadMsgInfo, submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum, long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramAppInterface = (QQAppInterface)paramAppInterface;
      if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 21L)
      {
        GVideoGrayConfig.a().a(paramAppInterface, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, new TroopOnlinePushProcessor.WeakGVideoGrayConfigListener(paramAppInterface, paramTroopUnreadMsgInfo, paramArrayOfLong));
        return;
      }
      if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 23L)
      {
        a(paramAppInterface, paramArrayOfLong, paramInt1, paramInt2, paramInt3, paramSubCmd0x1UpdateAppUnreadNum, paramTroopUnreadMsgInfo);
        ((IGroupVideoManager)paramAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).a(paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString);
        paramAppInterface.getGAudioHandler().a(1, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, paramTroopUnreadMsgInfo.b, paramArrayOfLong, 14, paramInt1, paramInt2, paramInt3);
        return;
      }
      if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 1104651886L)
      {
        paramAppInterface.getGAudioHandler().a(1, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, paramTroopUnreadMsgInfo.b, paramArrayOfLong, 10, paramInt1, paramInt2, paramInt3);
        return;
      }
      if ((paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 1102858908L) && ((paramTroopUnreadMsgInfo.b == -1) || (paramTroopUnreadMsgInfo.b > 0))) {
        ChatActivityUtils.a(paramAppInterface, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(-1));
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString)
  {
    Object localObject = (HotChatManager)paramAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if (localObject != null)
    {
      localObject = ((HotChatManager)localObject).a(paramString);
      if ((localObject != null) && (((HotChatInfo)localObject).isBuLuoHotChat()))
      {
        ((HotChatInfo)localObject).setHasRedPoint();
        ((ITroopRedDotHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(TroopRedDotObserver.b, true, new Object[] { paramString });
      }
    }
  }
  
  protected void a(@NonNull AppInterface paramAppInterface, @NonNull String paramString1, @NonNull String paramString2, TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo != null) && (!paramTroopInfo.hasSetTroopHead()))
    {
      ArrayList localArrayList = ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopMemberForTroopHead(paramString1);
      if ((localArrayList != null) && (localArrayList.contains(paramString2)))
      {
        localArrayList.remove(paramString2);
        paramTroopInfo.mHeaderUinsNew = GroupIconHelper.a(GroupIconHelper.a(localArrayList, paramTroopInfo), false);
        try
        {
          ((ITroopMemberListHandler)paramAppInterface.getBusinessHandler(TroopMemberListHandler.class.getName())).a(Long.parseLong(paramString1));
          return;
        }
        catch (Exception paramAppInterface)
        {
          paramString2 = new StringBuilder();
          paramString2.append("send 0x899 for Head failed! troopUin = ");
          paramString2.append(paramString1);
          QLog.e("TroopOnlinePushProcessor", 2, paramString2.toString(), paramAppInterface);
        }
      }
    }
  }
  
  protected void a(@NonNull AppInterface paramAppInterface, @NonNull String paramString1, @NonNull String paramString2, @NonNull TroopInfo paramTroopInfo, @NonNull ArrayList<String> paramArrayList)
  {
    if ((paramArrayList.size() <= 4) && (!paramArrayList.contains(paramString2)))
    {
      paramArrayList.add(paramString2);
      paramTroopInfo.updateHeadMemberList(GroupIconHelper.a(GroupIconHelper.a(paramArrayList, paramTroopInfo), false));
      paramAppInterface = ((ITroopAvatarService)paramAppInterface.getRuntimeService(ITroopAvatarService.class, "")).getGroupIconHelper();
      if (paramAppInterface != null) {
        paramAppInterface.c(paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopOnlinePushProcessor
 * JD-Core Version:    0.7.0.1
 */