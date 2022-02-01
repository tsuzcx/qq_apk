package com.tencent.mobileqq.activity.history.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ATroopMember;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.TmViewHolder;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
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
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TroopMemberAddFrdHelper.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  public AddFrdStateMng a;
  private TroopRobotManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager = ((TroopRobotManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener = paramAddFrdHelperListener;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ATroopMember != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ATroopMember);
      a(1, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ATroopMember.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ATroopMember = null;
      return;
      b();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt > this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = paramInt;
    }
    if ((this.jdField_a_of_type_Int < 2) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        b();
        return;
      }
    }
    catch (Throwable paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener.a();
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
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRobotManager.b(paramATroopMember.jdField_a_of_type_JavaLangString))
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
    if (paramTmViewHolder == null) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramTmViewHolder.f == null);
        localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        int i;
        if (paramATroopMember == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label197;
          }
          paramTmViewHolder.f.setVisibility(0);
          localButton = (Button)paramTmViewHolder.f.findViewById(2131362186);
          paramTmViewHolder = (TextView)paramTmViewHolder.f.findViewById(2131362188);
          if (paramATroopMember.o != 2) {
            break;
          }
          localButton.setVisibility(8);
          paramTmViewHolder.setVisibility(0);
          return;
          if ((paramATroopMember.o == 3) || (paramATroopMember.o == 2)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramATroopMember.o != 3) {
          break;
        }
        localButton.setTag(paramATroopMember);
        localButton.setOnClickListener(this);
        localButton.setText(HardCodeUtil.a(2131715503));
        localButton.setVisibility(0);
        paramTmViewHolder.setVisibility(8);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
    } while (localTroopInfo == null);
    paramTmViewHolder = localTroopInfo.troopuin;
    long l = localTroopInfo.dwGroupClassExt;
    return;
    localButton.setVisibility(8);
    paramTmViewHolder.setVisibility(8);
    return;
    label197:
    paramTmViewHolder.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$TroopMemberListConfig == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$TroopMemberListConfig.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$TroopMemberListConfig.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)localIterator1.next();
          if ((localATroopMember != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localATroopMember.jdField_a_of_type_JavaLangString))) {
            a(localATroopMember);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener.b();
        }
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        return;
      }
      catch (Throwable localThrowable3)
      {
        localThrowable3.printStackTrace();
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        try
        {
          Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator2.hasNext())
          {
            localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)localIterator2.next();
            if (localATroopMember == null) {
              continue;
            }
            a(localATroopMember);
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener == null) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper$AddFrdHelperListener.b();
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
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
      localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject).jdField_a_of_type_JavaLangString, str, 3004, 13, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject).m, null, null, null, null);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        long l = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper
 * JD-Core Version:    0.7.0.1
 */