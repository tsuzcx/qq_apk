package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.TroopBlockDialogHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import java.util.ArrayList;

public class TroopChatPieInnerObserver
  extends TroopObserver
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  TroopChatPieInnerObserver(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramTroopInfo.troopuin)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramTroopInfo.getTroopDisplayName();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (AppSetting.d)
      {
        paramTroopInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.getText().toString();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.setContentDescription(paramTroopInfo);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setTitle(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.getText());
      }
    }
  }
  
  public void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      a(((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString));
    }
  }
  
  public void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(paramBoolean, paramObject);
  }
  
  public void onGetTroopMemberCardInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      break label15;
    }
    label15:
    label44:
    label206:
    label207:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020))
      {
        int i = 0;
        if (i < paramArrayList.size())
        {
          TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
          if ((localTroopMemberCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localTroopMemberCardInfo.memberuin)))
          {
            paramArrayList = localTroopMemberCardInfo.name;
            if ((paramArrayList != null) && (!"".equals(paramArrayList))) {
              break label206;
            }
            paramArrayList = localTroopMemberCardInfo.nick;
          }
        }
        for (;;)
        {
          if ((paramArrayList == null) || ("".equals(paramArrayList))) {
            break label207;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramArrayList;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          if (!AppSetting.d) {
            break;
          }
          paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.getText().toString();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.setContentDescription(paramArrayList);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setTitle(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.getText());
          return;
          i += 1;
          break label44;
          break label15;
        }
      }
    }
  }
  
  public void onUpdateRecentList()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.bo();
  }
  
  public void onUpdateTroopList(boolean paramBoolean)
  {
    TroopBlockDialogHelper localTroopBlockDialogHelper = (TroopBlockDialogHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(76);
    if (localTroopBlockDialogHelper != null) {
      localTroopBlockDialogHelper.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPieInnerObserver
 * JD-Core Version:    0.7.0.1
 */