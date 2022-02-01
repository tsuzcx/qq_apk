package com.tencent.mobileqq.activity.history.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ATroopMember;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.TmViewHolder;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopMemberAddFrdHelper
  implements View.OnClickListener
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  public ChatHistoryTroopMemberFragment.ATroopMember a;
  private TroopMemberAddFrdHelper.AddFrdHelperListener jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener;
  private TroopMemberAddFrdHelper.TroopMemberListConfig jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$TroopMemberListConfig = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TroopMemberAddFrdHelper.2(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  private FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new TroopMemberAddFrdHelper.1(this);
  public AddFrdStateMng a;
  private ITroopRobotService jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService;
  private String jdField_a_of_type_JavaLangString;
  public final ArrayList<String> a;
  private List<ChatHistoryTroopMemberFragment.ATroopMember> jdField_a_of_type_JavaUtilList;
  public boolean a;
  
  public TroopMemberAddFrdHelper(Context paramContext, TroopMemberAddFrdHelper.AddFrdHelperListener paramAddFrdHelperListener, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<ChatHistoryTroopMemberFragment.ATroopMember> paramList)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ATroopMember = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdStateMng = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService = ((ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all"));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener = paramAddFrdHelperListener;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a()
  {
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ATroopMember;
    if (localATroopMember != null)
    {
      a(localATroopMember);
      a(1, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ATroopMember.jdField_a_of_type_JavaLangString);
    }
    else
    {
      b();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ATroopMember = null;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt > this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = paramInt;
    }
    if ((this.jdField_a_of_type_Int < 2) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b();
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener;
    if (paramString != null) {
      paramString.a();
    }
  }
  
  public void a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    AddFrdStateMng localAddFrdStateMng = this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdStateMng;
    if (paramATroopMember == null) {
      return;
    }
    if (!a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo))
    {
      paramATroopMember.o = 0;
      return;
    }
    if (localAddFrdStateMng != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiITroopRobotService.isRobotUin(paramATroopMember.jdField_a_of_type_JavaLangString))
      {
        paramATroopMember.o = 0;
        return;
      }
      paramATroopMember.o = localAddFrdStateMng.a(paramATroopMember.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    paramATroopMember.o = 0;
  }
  
  public void a(ChatHistoryTroopMemberFragment.TmViewHolder paramTmViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (paramTmViewHolder == null) {
      return;
    }
    if (paramTmViewHolder.f != null)
    {
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if (paramATroopMember == null) {}
      while ((paramATroopMember.o != 3) && (paramATroopMember.o != 2))
      {
        i = 0;
        break;
      }
      int i = 1;
      if (i != 0)
      {
        paramTmViewHolder.f.setVisibility(0);
        Button localButton = (Button)paramTmViewHolder.f.findViewById(2131362212);
        paramTmViewHolder = (TextView)paramTmViewHolder.f.findViewById(2131362214);
        if (paramATroopMember.o == 2)
        {
          localButton.setVisibility(8);
          paramTmViewHolder.setVisibility(0);
          return;
        }
        if (paramATroopMember.o == 3)
        {
          localButton.setTag(paramATroopMember);
          localButton.setOnClickListener(this);
          localButton.setText(HardCodeUtil.a(2131715425));
          localButton.setVisibility(0);
          paramTmViewHolder.setVisibility(8);
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            if (localTroopInfo != null)
            {
              paramTmViewHolder = localTroopInfo.troopuin;
              long l = localTroopInfo.dwGroupClassExt;
            }
          }
        }
        else
        {
          localButton.setVisibility(8);
          paramTmViewHolder.setVisibility(8);
        }
      }
      else
      {
        paramTmViewHolder.f.setVisibility(8);
      }
    }
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      if (paramTroopInfo.isQidianPrivateTroop()) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$TroopMemberListConfig == null) {
        d();
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$TroopMemberListConfig.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt)))
      {
        bool1 = bool2;
        if (paramTroopInfo.wMemberNum <= this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$TroopMemberListConfig.jdField_a_of_type_Int) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_Int;
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember;
    Object localObject;
    if (i == 1) {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)localIterator.next();
          if ((localATroopMember != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localATroopMember.jdField_a_of_type_JavaLangString))) {
            a(localATroopMember);
          }
        }
        ((TroopMemberAddFrdHelper.AddFrdHelperListener)localObject).b();
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener;
        if (localObject == null) {
          break label160;
        }
      }
    } else if (i == 2) {
      try
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject).next();
          if (localATroopMember != null) {
            a(localATroopMember);
          }
        }
        TroopMemberAddFrdHelper.AddFrdHelperListener localAddFrdHelperListener;
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        localAddFrdHelperListener = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener;
        if (localAddFrdHelperListener != null) {
          localAddFrdHelperListener.b();
        }
      }
    }
    try
    {
      label160:
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    catch (Throwable localThrowable3)
    {
      localThrowable3.printStackTrace();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdStateMng = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$TroopMemberListConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$TroopMemberListConfig = new TroopMemberAddFrdHelper.TroopMemberListConfig(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((localObject instanceof ChatHistoryTroopMemberFragment.ATroopMember)))
    {
      localObject = (ChatHistoryTroopMemberFragment.ATroopMember)localObject;
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ATroopMember = ((ChatHistoryTroopMemberFragment.ATroopMember)localObject);
      String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
      localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_AndroidContentContext, 1, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject).jdField_a_of_type_JavaLangString, str, 3004, 13, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject).m, null, null, null, null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if (localObject != null) {
        long l = ((TroopInfo)localObject).dwGroupClassExt;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper
 * JD-Core Version:    0.7.0.1
 */