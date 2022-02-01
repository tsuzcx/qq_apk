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
import com.tencent.mobileqq.extendfriend.limitchat.LimitChatMatchInfoHelper;
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = ((IceBreakingMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("checkNeedShowImmediately, sessionType: %s, sessionUin: %s, type: %s", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(i) }));
    }
    if (i != -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null) && (paramInt2 == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null) {
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.a();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onAddIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (!IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str)) {}
    while ((TextUtils.isEmpty(str)) || (!str.equals(paramString)) || (((!paramBoolean) || (!IceBreakingUtil.c(i))) && ((paramBoolean) || (!IceBreakingUtil.b(i))) && (!IceBreakingUtil.d(i)) && (!IceBreakingUtil.e(i)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().post(new IceBreakHelper.3(this));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    if (!IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onIceBreakResp suc=%b selfUin=%b frdUin=%b", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 }));
      }
    } while ((!paramBoolean) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (!paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format("updateIceBreakPokeShow bOnCreate=%b uin=%s, toShow=%s", new Object[] { Boolean.valueOf(paramBoolean1), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramBoolean2) }));
    }
    if (paramBoolean2)
    {
      IceBreakingMng localIceBreakingMng = (IceBreakingMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (IceBreakingUtil.b(i))
      {
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null) && (localFriendsManager.b(str)) && (!localIceBreakingMng.a(str)))
        {
          if (localIceBreakingMng.a(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) != 1) {
            break label180;
          }
          i = 6;
          localIceBreakingMng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 3, i, str);
        }
      }
      label180:
      label219:
      label254:
      do
      {
        do
        {
          do
          {
            return;
            i = 1;
            break;
            if (!IceBreakingUtil.c(i)) {
              break label219;
            }
          } while (localIceBreakingMng.b(str));
          localIceBreakingMng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 3, 2, str);
          return;
          if (!IceBreakingUtil.d(i)) {
            break label254;
          }
        } while (localIceBreakingMng.c(str));
        LimitChatMatchInfoHelper.a(str, new IceBreakHelper.2(this, localIceBreakingMng, str));
        return;
      } while ((!IceBreakingUtil.e(i)) || (localIceBreakingMng.d(str)));
      localIceBreakingMng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 3, 5, str);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingIIceBreakHotPicCallback.a(true, null, 0);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((!IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onGoingToShowPanel old=%d new=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g() != 0) || (paramInt2 == 0));
    this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.a(true);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onRemoveIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (!IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str)) {}
    while ((TextUtils.isEmpty(paramString)) || (!str.equals(paramString)) || (((!paramBoolean) || (!IceBreakingUtil.c(i))) && ((paramBoolean) || (!IceBreakingUtil.b(i))) && (!IceBreakingUtil.d(i)) && (!IceBreakingUtil.e(i)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().post(new IceBreakHelper.4(this));
  }
  
  public String getTag()
  {
    return "IceBreakHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 14, 8 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131369141) && (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onClick inputCustomClickLisenter");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.a(true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.i("IceBreak.HotPic", 1, "onMoveToState create.");
        } while (!IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow = new AIOIceBreakShow(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().setOnGoingToShowPanelListener(this);
        localIceBreakingMng = (IceBreakingMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
        localIceBreakingMng.a(this);
        localIceBreakingMng.a(this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingIIceBreakHotPicCallback);
        return;
        QLog.i("IceBreak.HotPic", 1, "onMoveToState destroy.");
      } while (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow == null);
      IceBreakingMng localIceBreakingMng = (IceBreakingMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
      localIceBreakingMng.b(this);
      localIceBreakingMng.f();
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.b();
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow = null;
      return;
      QLog.i("IceBreak.HotPic", 1, "onMoveToState show first.");
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    if (a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString))
    {
      a(true, true);
      return;
    }
    IceBreakingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.IceBreakHelper
 * JD-Core Version:    0.7.0.1
 */