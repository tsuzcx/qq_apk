package com.tencent.mobileqq.activity.aio.pluspanel.loader;

import android.util.SparseArray;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.BMQQPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.CommonC2CPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.OneWayFriendPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.RobotPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.SelfPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.BusinessCRMEXTPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.CircleGroupStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.ContactStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.DateStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.GroupOrDiscussionStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.MovieTicketStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.NearByStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.temp.TribeStrangerPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.AnonymousPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.CommonTroopPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.HotChatPlusPanelAppLoader;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.QiDianPrivatePlusPanelAppLoader;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.filemanager.fileassistant.aio.NewDataLinePlusPanelAppLoader;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.qphone.base.util.QLog;

public class PlusPanelLoaderFactory
  implements PlusPanelAppLoader.Factory
{
  private final SparseArray<Class<? extends PlusPanelAppLoader>> a = new SparseArray();
  
  public PlusPanelLoaderFactory()
  {
    a();
  }
  
  private void a()
  {
    this.a.put(1000, GroupOrDiscussionStrangerPlusPanelAppLoader.class);
    this.a.put(1004, GroupOrDiscussionStrangerPlusPanelAppLoader.class);
    this.a.put(1008, PublicAccountPlusPanelAppLoader.class);
    this.a.put(1024, PublicAccountPlusPanelAppLoader.class);
    this.a.put(1020, CommonPlusPanelAppLoader.class);
    this.a.put(1005, CommonPlusPanelAppLoader.class);
    this.a.put(1003, CommonPlusPanelAppLoader.class);
    this.a.put(1022, CommonPlusPanelAppLoader.class);
    this.a.put(1009, CommonPlusPanelAppLoader.class);
    this.a.put(1023, CommonPlusPanelAppLoader.class);
    this.a.put(3000, DiscussPlusPanelAppLoader.class);
    this.a.put(10004, MovieTicketStrangerPlusPanelAppLoader.class);
    this.a.put(1006, ContactStrangerPlusPanelAppLoader.class);
    this.a.put(1025, BusinessCRMEXTPlusPanelAppLoader.class);
    this.a.put(1001, NearByStrangerPlusPanelAppLoader.class);
    this.a.put(10002, TribeStrangerPlusPanelAppLoader.class);
    this.a.put(1010, DateStrangerPlusPanelAppLoader.class);
    this.a.put(1021, CircleGroupStrangerPlusPanelAppLoader.class);
    this.a.put(6000, DataLinePCPlusPanelAppLoader.class);
    this.a.put(9501, DevicePlusPanelAppLoader.class);
  }
  
  PlusPanelAppLoader a(BaseChatPie paramBaseChatPie)
  {
    Object localObject = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramBaseChatPie = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    HotChatManager localHotChatManager = (HotChatManager)((QQAppInterface)localObject).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    localObject = (TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramBaseChatPie.jdField_a_of_type_JavaLangString))) {
      return new HotChatPlusPanelAppLoader();
    }
    if (AnonymousChatHelper.a().a(paramBaseChatPie.jdField_a_of_type_JavaLangString)) {
      return new AnonymousPlusPanelAppLoader();
    }
    if (((TroopManager)localObject).n(paramBaseChatPie.jdField_a_of_type_JavaLangString)) {
      return new QiDianPrivatePlusPanelAppLoader();
    }
    return new CommonTroopPlusPanelAppLoader();
  }
  
  public PlusPanelAppLoader a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    if (i == 1) {
      return a(paramBaseChatPie);
    }
    if ((i == 0) || (ChatActivityUtils.a(localQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return b(paramBaseChatPie, paramBoolean);
    }
    try
    {
      paramBaseChatPie = (Class)this.a.get(i);
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie = (PlusPanelAppLoader)paramBaseChatPie.newInstance();
        return paramBaseChatPie;
      }
    }
    catch (Throwable paramBaseChatPie)
    {
      QLog.d("PlusPanelLoaderFactory", 1, paramBaseChatPie, new Object[0]);
    }
    return new DefaultPlusPanelAppLoader();
  }
  
  PlusPanelAppLoader b(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramBaseChatPie = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (RobotUtils.b(localQQAppInterface, paramBaseChatPie.jdField_a_of_type_JavaLangString)) {
      return new RobotPlusPanelAppLoader();
    }
    if (BmqqSegmentUtil.b(paramBaseChatPie.jdField_a_of_type_JavaLangString)) {
      return new BMQQPlusPanelAppLoader();
    }
    if (paramBoolean) {
      return new OneWayFriendPlusPanelAppLoader();
    }
    if (localQQAppInterface.getCurrentUin().equals(paramBaseChatPie.jdField_a_of_type_JavaLangString)) {
      return new SelfPlusPanelAppLoader();
    }
    if (QFileAssistantUtils.a(paramBaseChatPie.jdField_a_of_type_JavaLangString)) {
      return new NewDataLinePlusPanelAppLoader();
    }
    return new CommonC2CPlusPanelAppLoader();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelLoaderFactory
 * JD-Core Version:    0.7.0.1
 */