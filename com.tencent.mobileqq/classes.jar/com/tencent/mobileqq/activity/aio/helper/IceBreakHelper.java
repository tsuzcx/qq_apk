package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatMatchInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow;
import com.tencent.mobileqq.relationx.icebreaking.IIceBreakHotPicCallback;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.relationx.icebreaking.OnIceBreakChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.OnGoingToShowPanelListener;
import mqq.os.MqqHandler;

public class IceBreakHelper
  implements View.OnClickListener, ILifeCycleHelper, OnIceBreakChangeListener, XPanelContainer.OnGoingToShowPanelListener
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  AIOIceBreakShow jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow;
  private IIceBreakHotPicCallback jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingIIceBreakHotPicCallback = new IceBreakHelper.1(this);
  private String jdField_a_of_type_JavaLangString;
  
  IceBreakHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    int i = ((IceBreakingMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("checkNeedShowImmediately, sessionType: %s, sessionUin: %s, type: %s", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(i) }));
    }
    if (i != -1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AIOIceBreakShow localAIOIceBreakShow = this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow;
    if ((localAIOIceBreakShow != null) && (paramInt2 == 0)) {
      localAIOIceBreakShow.a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow;
    if (paramAbsListView != null) {
      paramAbsListView.a();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onAddIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (!IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str)) {
      return;
    }
    if (!TextUtils.isEmpty(str))
    {
      if (!str.equals(paramString)) {
        return;
      }
      if (((paramBoolean) && (IceBreakingUtil.c(i))) || ((!paramBoolean) && (IceBreakingUtil.b(i))) || (IceBreakingUtil.d(i)) || (IceBreakingUtil.e(i))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().post(new IceBreakHelper.3(this));
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    if (!IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onIceBreakResp suc=%b selfUin=%b frdUin=%b", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 }));
    }
    if ((paramBoolean) && (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = QLog.isColorLevel();
    int i = 1;
    if (bool) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format("updateIceBreakPokeShow bOnCreate=%b uin=%s, toShow=%s", new Object[] { Boolean.valueOf(paramBoolean1), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramBoolean2) }));
    }
    if (paramBoolean2)
    {
      IceBreakingMng localIceBreakingMng = (IceBreakingMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (IceBreakingUtil.b(j))
      {
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null) && (localFriendsManager.b(str)) && (!localIceBreakingMng.a(str)))
        {
          if (localIceBreakingMng.a(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) == 1) {
            i = 6;
          }
          localIceBreakingMng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 3, i, str);
        }
      }
      else if (IceBreakingUtil.c(j))
      {
        if (!localIceBreakingMng.b(str)) {
          localIceBreakingMng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 3, 2, str);
        }
      }
      else if (IceBreakingUtil.d(j))
      {
        if (!localIceBreakingMng.c(str)) {
          ((ILimitChatMatchInfoHelper)QRoute.api(ILimitChatMatchInfoHelper.class)).getMatchInfoRequest(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, new IceBreakHelper.2(this, localIceBreakingMng, str));
        }
      }
      else if ((IceBreakingUtil.e(j)) && (!localIceBreakingMng.d(str)))
      {
        localIceBreakingMng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 3, 5, str);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingIIceBreakHotPicCallback.a(true, null, 0);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onGoingToShowPanel old=%d new=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c() == 0) && (paramInt2 != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.a(true);
      }
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onRemoveIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (!IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str)) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (!str.equals(paramString)) {
        return;
      }
      if (((paramBoolean) && (IceBreakingUtil.c(i))) || ((!paramBoolean) && (IceBreakingUtil.b(i))) || (IceBreakingUtil.d(i)) || (IceBreakingUtil.e(i))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().post(new IceBreakHelper.4(this));
      }
    }
  }
  
  public String getTag()
  {
    return "IceBreakHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15, 9 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131368874) && (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onClick inputCustomClickLisenter");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.a(true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject;
    if (paramInt != 4)
    {
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        QLog.i("IceBreak.HotPic", 1, "onMoveToState destroy.");
        if (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null)
        {
          localObject = (IceBreakingMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
          ((IceBreakingMng)localObject).b(this);
          ((IceBreakingMng)localObject).f();
          this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.b();
          this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow = null;
        }
      }
      else
      {
        QLog.i("IceBreak.HotPic", 1, "onMoveToState show first.");
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          if (a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString))
          {
            a(true, true);
            return;
          }
          IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Int);
        }
      }
    }
    else
    {
      QLog.i("IceBreak.HotPic", 1, "onMoveToState create.");
      if (IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow = new AIOIceBreakShow((BaseChatPie)localObject, this.jdField_a_of_type_AndroidContentContext, ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().setOnGoingToShowPanelListener(this);
        localObject = (IceBreakingMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
        ((IceBreakingMng)localObject).a(this);
        ((IceBreakingMng)localObject).a(this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingIIceBreakHotPicCallback);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.IceBreakHelper
 * JD-Core Version:    0.7.0.1
 */