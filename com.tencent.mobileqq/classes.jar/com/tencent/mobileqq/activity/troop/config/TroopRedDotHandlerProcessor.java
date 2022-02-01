package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.config.AbsTroopRedDotHandlerProcessor;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troop.troopsurvey.api.ITroopSurveyHandler;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.qphone.base.util.QLog;

public class TroopRedDotHandlerProcessor
  extends AbsTroopRedDotHandlerProcessor
{
  private void b(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    if (paramTroopUnreadMsgInfo.b == -1)
    {
      Object localObject = (HotChatManager)paramAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if (localObject != null)
      {
        String str = String.valueOf(paramLong);
        localObject = ((HotChatManager)localObject).a(str);
        if ((localObject != null) && (((HotChatInfo)localObject).isBuLuoHotChat()))
        {
          ((HotChatInfo)localObject).setHasRedPoint();
          ((ITroopRedDotHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(TroopRedDotObserver.b, true, new Object[] { str });
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("handle_oidb_0x8c9_2_response, msgInfo.nUnreadMsgNum:");
      paramAppInterface.append(paramTroopUnreadMsgInfo.jdField_a_of_type_Int);
      QLog.d("TroopRedDotHandlerProcessorQ.hotchat.aio_post_red_point", 2, paramAppInterface.toString());
    }
  }
  
  private void c(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(paramAppInterface.getCurrentAccountUin(), "troop_photo_new", String.valueOf(paramLong), paramTroopUnreadMsgInfo.b);
    ((IRedPointUtilsApi)QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(paramAppInterface, String.valueOf(paramLong), "troop", 2, paramTroopUnreadMsgInfo.b);
    ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(paramAppInterface.getCurrentAccountUin(), "troop_photo_message", String.valueOf(paramLong), paramTroopUnreadMsgInfo.jdField_a_of_type_Int);
  }
  
  private void d(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(paramAppInterface.getCurrentAccountUin(), "troop_file_new", String.valueOf(paramLong), paramTroopUnreadMsgInfo.b);
  }
  
  private void e(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(paramAppInterface.getCurrentAccountUin(), "troop_notification_new", String.valueOf(paramLong), paramTroopUnreadMsgInfo.b);
  }
  
  private void f(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(paramAppInterface.getCurrentAccountUin(), "group_activity_new_message", String.valueOf(paramLong), paramTroopUnreadMsgInfo.b);
  }
  
  private void g(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    if ((paramTroopUnreadMsgInfo.b != -1) && (paramTroopUnreadMsgInfo.b <= 0))
    {
      if (paramTroopUnreadMsgInfo.b == 0) {
        ChatActivityUtils.a((QQAppInterface)paramAppInterface, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(0));
      }
    }
    else {
      ChatActivityUtils.a((QQAppInterface)paramAppInterface, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(-1));
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("handle_oidb_0x8c9_2_response, troopUin=");
      paramAppInterface.append(paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString);
      paramAppInterface.append(", nNewNum=");
      paramAppInterface.append(paramTroopUnreadMsgInfo.b);
      QLog.i(".troop.notify_feeds.data", 2, paramAppInterface.toString());
    }
  }
  
  private void h(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handle_oidb_0x8c9_2_response, troopUin=");
      localStringBuilder.append(paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", nNewNum=");
      localStringBuilder.append(paramTroopUnreadMsgInfo.b);
      QLog.i("hw_troop", 2, localStringBuilder.toString());
    }
    ((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).setAIOHomeworkBtnRedPoint((QQAppInterface)paramAppInterface, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, paramTroopUnreadMsgInfo.b);
    ((ITroopRedDotHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(TroopRedDotObserver.jdField_a_of_type_Int, true, new Object[] { String.valueOf(paramLong), String.valueOf(1104445552), Boolean.valueOf(false) });
  }
  
  private void i(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    paramAppInterface = ((ITroopBatchAddFriendService)paramAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
    if ((paramTroopUnreadMsgInfo.b > 0) && (paramAppInterface != null)) {
      paramAppInterface.d(paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void j(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    if (paramTroopUnreadMsgInfo.b == -1)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupPadTemplateNewsInfoTips(paramAppInterface.getCurrentAccountUin(), "group_pad_template_tips", paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, true);
      return;
    }
    ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupPadTemplateNewsInfoTips(paramAppInterface.getCurrentAccountUin(), "group_pad_template_tips", paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, false);
  }
  
  private void k(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    if (paramTroopUnreadMsgInfo.b == -1)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupTIMFileNewsInfo(paramAppInterface.getCurrentAccountUin(), "group_file_reddot_tim", paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, true);
      return;
    }
    ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupTIMFileNewsInfo(paramAppInterface.getCurrentAccountUin(), "group_file_reddot_tim", paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, false);
  }
  
  private void l(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    if (paramTroopUnreadMsgInfo == null) {
      return;
    }
    if (paramTroopUnreadMsgInfo.b > 0)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setTroopHasNewApp((QQAppInterface)paramAppInterface, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, true);
      ((ITroopRedDotHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(TroopRedDotObserver.d, true, new Object[] { paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString });
      return;
    }
    ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setTroopHasNewApp((QQAppInterface)paramAppInterface, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, false);
  }
  
  private void m(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hw_troop", 2, "onLinePush receive 0x210_0x26_cmd0x1 troop mini app entrance.");
    }
    boolean bool;
    if (paramTroopUnreadMsgInfo.b != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setAIOTroopMiniAppEntranceRedPoint(paramAppInterface, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, bool);
    ((ITroopRedDotHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(TroopRedDotObserver.c, true, new Object[] { paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(bool) });
  }
  
  private void n(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hw_troop", 2, "onLinePush receive 0x210_0x26_cmd0x1 remindAddTroopAppGrayTips.");
    }
    paramAppInterface = (TroopShortcutBarManager)paramAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
    paramAppInterface.a(paramLong, paramTroopUnreadMsgInfo.b);
    paramAppInterface.a(String.valueOf(paramLong));
  }
  
  private void o(@NonNull AppInterface paramAppInterface, long paramLong, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hw_troop", 2, "onLinePush receive 0x210_0x26_cmd0x1 troopAppTroopMgr.");
    }
    ((IRedPointUtilsApi)QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(paramAppInterface, String.valueOf(paramLong), "troop", 5, paramTroopUnreadMsgInfo.b);
  }
  
  public void a(@NonNull AppInterface paramAppInterface, long paramLong, @NonNull TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 1105933138L)
    {
      b(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 2L)
    {
      c(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 1L)
    {
      d(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 1101236949L)
    {
      e(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 1101484419L)
    {
      f(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 1102858908L)
    {
      g(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 1104445552L)
    {
      h(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 101509131L)
    {
      i(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 1106588005L)
    {
      j(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 1106664488L)
    {
      k(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 101618516L)
    {
      m(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 101872323L)
    {
      l(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 101896870L)
    {
      n(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long == 101913298L)
    {
      o(paramAppInterface, paramLong, paramTroopUnreadMsgInfo);
      return;
    }
    if ((((ITroopSurveyHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SURVEY_HANDLER)).a(paramTroopUnreadMsgInfo, null, 1)) && (QLog.isColorLevel())) {
      QLog.d(".troop.survey", 2, "handle_oidb_0x8c9_2_response() msginfo handled by Oidb0xb36");
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      ChatActivityUtils.a((QQAppInterface)paramAppInterface, paramString, Integer.valueOf(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopRedDotHandlerProcessor
 * JD-Core Version:    0.7.0.1
 */