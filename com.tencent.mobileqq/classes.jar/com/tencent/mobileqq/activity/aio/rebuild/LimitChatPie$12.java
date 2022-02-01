package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class LimitChatPie$12
  extends ExtendFriendObserver
{
  LimitChatPie$12(LimitChatPie paramLimitChatPie) {}
  
  public void onGetExtendFriendOnlineState(boolean paramBoolean, List<Long> paramList1, int paramInt, List<Long> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    LimitChatPie.a(this.a, (ArrayList)paramList1);
  }
  
  public void onGetStrangerInfo(boolean paramBoolean, StrangerInfo paramStrangerInfo, int paramInt)
  {
    if ((paramBoolean) && (paramStrangerInfo != null))
    {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStrangerInfo, this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.a.g, this.a.G);
      LimitChatPie.a(this.a, paramStrangerInfo.mNickName);
      this.a.e.setText(paramStrangerInfo.mNickName);
      if ((!TextUtils.isEmpty(paramStrangerInfo.mNickName)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramStrangerInfo.mNickName;
      }
    }
  }
  
  public void onGetUnLimitFriendInfo(boolean paramBoolean, int paramInt1, int paramInt2, MatchInfo paramMatchInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, String.format("onGetUnLimitFriendInfo() success=%s uinType=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) }));
    }
    if ((paramBoolean) && (paramMatchInfo != null)) {
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.12.1(this, paramInt2, paramMatchInfo));
    }
  }
  
  public void onPreLoadDataForArkMiniProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      LimitChatUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, paramObject);
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.12.2(this));
      return;
    }
    QLog.w(this.a.b, 1, "onPreLoadDataForArkMiniProfileCard network error, data is null");
  }
  
  public void onPreLoadDataForIcebreakerTopic(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      ExpandFriendChatUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramObject);
      return;
    }
    QLog.w(this.a.b, 1, "onPreLoadDataForIcebreakerTopic network error, data is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.12
 * JD-Core Version:    0.7.0.1
 */