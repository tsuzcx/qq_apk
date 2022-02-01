package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.SpecWordEmotionThinkHelper;
import com.tencent.mobileqq.app.BaseActivity;
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
    Object localObject2 = ((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment();
    Object localObject1 = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    if ((localObject2 != null) && (((ChatFragment)localObject2).a() != null))
    {
      localObject2 = (TroopChatPie)((ChatFragment)localObject2).a();
      ((SpecWordEmotionThinkHelper)((TroopChatPie)localObject2).a(41)).a(1);
      ((TroopManager.ConfigableWordingSetter)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((TroopChatPie)localObject2).a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, paramView.a);
    }
    localObject1 = new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_welcome");
    localObject2 = paramView.a.frienduin;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.a.frienduin));
    ((ReportTask)localObject1).a(new String[] { localObject2, "", localStringBuilder.toString() }).a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击欢迎");
    }
    TroopPobingItemBuilder.jdField_a_of_type_Int = 1;
  }
  
  public void b(View paramView)
  {
    paramView = (TroopPobingItemBuilder.TroopPobingViewHolder)AIOUtils.a(paramView);
    TroopPobingItemBuilder.jdField_a_of_type_JavaLangString = paramView.a.senderuin;
    TroopManager.ConfigableWordingSetter localConfigableWordingSetter = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    Object localObject = ((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if ((localObject != null) && (((ChatFragment)localObject).a() != null))
    {
      localObject = (TroopChatPie)((ChatFragment)localObject).a();
      localConfigableWordingSetter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((TroopChatPie)localObject).a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, paramView.a);
    }
    new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_play").a(new String[] { paramView.a.frienduin }).a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击撩一下");
    }
    TroopPobingItemBuilder.jdField_a_of_type_Int = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */