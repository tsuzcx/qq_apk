package com.tencent.mobileqq.activity.aio.item;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.SpecWordEmotionThinkHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ConfigableWordingSetter;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;

class TroopPobingItemBuilder$1
  implements TroopPobingItemBuilder.Callback
{
  TroopPobingItemBuilder$1(TroopPobingItemBuilder paramTroopPobingItemBuilder) {}
  
  public void a(View paramView)
  {
    paramView = (TroopPobingItemBuilder.TroopPobingViewHolder)AIOUtils.a(paramView);
    TroopPobingItemBuilder.jdField_a_of_type_JavaLangString = paramView.a.senderuin;
    Object localObject = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment();
    TroopManager.ConfigableWordingSetter localConfigableWordingSetter = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    if ((localObject != null) && (((ChatFragment)localObject).a() != null))
    {
      localObject = (TroopChatPie)((ChatFragment)localObject).a();
      ((SpecWordEmotionThinkHelper)((TroopChatPie)localObject).a(41)).a(1);
      localConfigableWordingSetter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((TroopChatPie)localObject).a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, paramView.a);
    }
    new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_welcome").a(new String[] { paramView.a.frienduin, "", "" + TroopUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.a.frienduin) }).a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击欢迎");
    }
    TroopPobingItemBuilder.c = 1;
  }
  
  public void b(View paramView)
  {
    paramView = (TroopPobingItemBuilder.TroopPobingViewHolder)AIOUtils.a(paramView);
    TroopPobingItemBuilder.jdField_a_of_type_JavaLangString = paramView.a.senderuin;
    TroopManager.ConfigableWordingSetter localConfigableWordingSetter = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    Object localObject = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if ((localObject != null) && (((ChatFragment)localObject).a() != null))
    {
      localObject = (TroopChatPie)((ChatFragment)localObject).a();
      localConfigableWordingSetter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((TroopChatPie)localObject).a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, paramView.a);
    }
    new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_play").a(new String[] { paramView.a.frienduin }).a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击撩一下");
    }
    TroopPobingItemBuilder.c = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */