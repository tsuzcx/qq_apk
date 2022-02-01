package com.tencent.mobileqq.apollo.api.aio.impl;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager;
import com.tencent.mobileqq.apollo.lightGame.CmGamePlayAgainDialog;
import com.tencent.mobileqq.apollo.lightGame.CmGameSessionUtil;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler;
import com.tencent.mobileqq.apollo.lightGame.RobotDataUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CmGameChatPie$1
  implements View.OnClickListener
{
  CmGameChatPie$1(CmGameChatPie paramCmGameChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (IApolloManagerService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    CmGameTempSessionHandler localCmGameTempSessionHandler = ((IApolloManagerService)localObject).getGameTempMsgHandler();
    switch (paramView.getId())
    {
    default: 
    case 2131362802: 
    case 2131362801: 
    case 2131363917: 
    case 2131363916: 
    case 2131380515: 
    case 2131380179: 
    case 2131380560: 
    case 2131380261: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "1" });
        this.a.w(false);
        ((IApolloManagerService)localObject).getCmGameAudioManager().a(this.a.b(), 319);
        continue;
        this.a.v(false);
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "1" });
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplication.getContext(), 2131692257, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
        }
        else
        {
          localCmGameTempSessionHandler.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          VipUtils.a(null, "cmshow", "Apollo", "addPlaymate", 0, 0, new String[] { "" });
          continue;
          if (!NetworkUtil.d(BaseApplication.getContext()))
          {
            QQToast.a(BaseApplication.getContext(), 2131692257, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
          }
          else
          {
            localCmGameTempSessionHandler.g(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            VipUtils.a(null, "cmshow", "Apollo", "acceptBtn", 0, 0, new String[] { "" });
            continue;
            if (!NetworkUtil.d(BaseApplication.getContext()))
            {
              QQToast.a(BaseApplication.getContext(), 2131692257, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
            }
            else
            {
              CmGameChatPie.a(this.a, (int)(System.currentTimeMillis() / 1000L));
              localCmGameTempSessionHandler.a(CmGameChatPie.a(this.a).jdField_a_of_type_Int, CmGameChatPie.a(this.a));
              CmGameChatPie.a(this.a).a(1);
              VipUtils.a(null, "cmshow", "Apollo", "moreGame", 0, 0, new String[] { CmGameChatPie.a(this.a).jdField_a_of_type_Int + "" });
              continue;
              if (!NetworkUtil.d(BaseApplication.getContext()))
              {
                QQToast.a(BaseApplication.getContext(), 2131692257, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
              }
              else
              {
                if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
                {
                  if (!RobotDataUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                    break label651;
                  }
                  this.a.a(CmGameChatPie.a(this.a).jdField_a_of_type_Int, CmGameChatPie.a(this.a).jdField_a_of_type_Long, CmGameChatPie.a(this.a).a());
                }
                for (;;)
                {
                  CmGameChatPie.a(this.a).dismiss();
                  VipUtils.a(null, "cmshow", "Apollo", "acceptInvitation", 0, 0, new String[] { CmGameChatPie.a(this.a).jdField_a_of_type_Int + "" });
                  break;
                  label651:
                  localCmGameTempSessionHandler.a(true, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, CmGameChatPie.a(this.a).jdField_a_of_type_Int, CmGameChatPie.a(this.a).jdField_a_of_type_Long);
                }
                if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
                {
                  localCmGameTempSessionHandler.a(false, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, CmGameChatPie.a(this.a).jdField_a_of_type_Int, CmGameChatPie.a(this.a).jdField_a_of_type_Long);
                  CmGameSessionUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, CmGameChatPie.a(this.a).jdField_a_of_type_Int, CmGameChatPie.a(this.a).jdField_a_of_type_Long);
                }
                CmGameChatPie.a(this.a).dismiss();
                VipUtils.a(null, "cmshow", "Apollo", "refuseInvitation", 0, 0, new String[] { CmGameChatPie.a(this.a).jdField_a_of_type_Int + "" });
                continue;
                CmGameChatPie.a(this.a).dismiss();
                if (CmGameChatPie.b(this.a) >= 2) {
                  this.a.bi();
                }
              }
            }
          }
        }
      }
    }
    if (((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      localObject = new ProfileActivity.AllInOne(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
    }
    for (((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;; ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)
    {
      ((ProfileActivity.AllInOne)localObject).f = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      ((ProfileActivity.AllInOne)localObject).e = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      ((ProfileActivity.AllInOne)localObject).g = 2;
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 106;
      ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject);
      VipUtils.a(null, "cmshow", "Apollo", "clickArea", 0, 0, new String[] { "" });
      break;
      localObject = new ProfileActivity.AllInOne(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.1
 * JD-Core Version:    0.7.0.1
 */