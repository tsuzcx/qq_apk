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
  public final ArrayList<String> a;
  public boolean b = false;
  public int c = 0;
  public ChatHistoryTroopMemberFragment.ATroopMember d = null;
  public AddFrdStateMng e;
  private TroopMemberAddFrdHelper.TroopMemberListConfig f = null;
  private TroopMemberAddFrdHelper.AddFrdHelperListener g;
  private ITroopRobotService h;
  private TroopInfo i;
  private String j;
  private Context k;
  private QQAppInterface l;
  private List<ChatHistoryTroopMemberFragment.ATroopMember> m;
  private FriendObserver n = new TroopMemberAddFrdHelper.1(this);
  private FriendListObserver o = new TroopMemberAddFrdHelper.2(this);
  
  public TroopMemberAddFrdHelper(Context paramContext, TroopMemberAddFrdHelper.AddFrdHelperListener paramAddFrdHelperListener, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<ChatHistoryTroopMemberFragment.ATroopMember> paramList)
  {
    this.k = paramContext;
    this.a = new ArrayList(5);
    this.e = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).z();
    paramQQAppInterface.addObserver(this.o);
    paramQQAppInterface.addObserver(this.n);
    this.l = paramQQAppInterface;
    this.h = ((ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all"));
    this.g = paramAddFrdHelperListener;
    this.i = paramTroopInfo;
    this.j = paramQQAppInterface.getCurrentAccountUin();
    this.m = paramList;
  }
  
  public void a()
  {
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = this.d;
    if (localATroopMember != null)
    {
      a(localATroopMember);
      a(1, this.d.a);
    }
    else
    {
      b();
    }
    this.d = null;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt > this.c) {
      this.c = paramInt;
    }
    if ((this.c < 2) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        this.a.add(paramString);
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
    paramString = this.g;
    if (paramString != null) {
      paramString.a();
    }
  }
  
  public void a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    AddFrdStateMng localAddFrdStateMng = this.e;
    if (paramATroopMember == null) {
      return;
    }
    if (!a(this.i))
    {
      paramATroopMember.W = 0;
      return;
    }
    if (localAddFrdStateMng != null)
    {
      if (this.h.isRobotUin(paramATroopMember.a))
      {
        paramATroopMember.W = 0;
        return;
      }
      paramATroopMember.W = localAddFrdStateMng.a(paramATroopMember.a, this.l);
      return;
    }
    paramATroopMember.W = 0;
  }
  
  public void a(ChatHistoryTroopMemberFragment.TmViewHolder paramTmViewHolder, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (paramTmViewHolder == null) {
      return;
    }
    if (paramTmViewHolder.u != null)
    {
      TroopInfo localTroopInfo = this.i;
      if (paramATroopMember == null) {}
      while ((paramATroopMember.W != 3) && (paramATroopMember.W != 2))
      {
        i1 = 0;
        break;
      }
      int i1 = 1;
      if (i1 != 0)
      {
        paramTmViewHolder.u.setVisibility(0);
        Button localButton = (Button)paramTmViewHolder.u.findViewById(2131427793);
        paramTmViewHolder = (TextView)paramTmViewHolder.u.findViewById(2131427795);
        if (paramATroopMember.W == 2)
        {
          localButton.setVisibility(8);
          paramTmViewHolder.setVisibility(0);
          return;
        }
        if (paramATroopMember.W == 3)
        {
          localButton.setTag(paramATroopMember);
          localButton.setOnClickListener(this);
          localButton.setText(HardCodeUtil.a(2131912903));
          localButton.setVisibility(0);
          paramTmViewHolder.setVisibility(8);
          if (!this.b)
          {
            this.b = true;
            if (localTroopInfo != null)
            {
              paramTmViewHolder = localTroopInfo.troopuin;
              long l1 = localTroopInfo.dwGroupClassExt;
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
        paramTmViewHolder.u.setVisibility(8);
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
      if (this.f == null) {
        d();
      }
      bool1 = bool2;
      if (this.f.a.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt)))
      {
        bool1 = bool2;
        if (paramTroopInfo.wMemberNum <= this.f.b) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    int i1 = this.c;
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember;
    Object localObject;
    if (i1 == 1) {
      try
      {
        Iterator localIterator = this.m.iterator();
        while (localIterator.hasNext())
        {
          localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)localIterator.next();
          if ((localATroopMember != null) && (this.a.contains(localATroopMember.a))) {
            a(localATroopMember);
          }
        }
        ((TroopMemberAddFrdHelper.AddFrdHelperListener)localObject).b();
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        localObject = this.g;
        if (localObject == null) {
          break label160;
        }
      }
    } else if (i1 == 2) {
      try
      {
        localObject = this.m.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)((Iterator)localObject).next();
          if (localATroopMember != null) {
            a(localATroopMember);
          }
        }
        TroopMemberAddFrdHelper.AddFrdHelperListener localAddFrdHelperListener;
        this.c = 0;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        localAddFrdHelperListener = this.g;
        if (localAddFrdHelperListener != null) {
          localAddFrdHelperListener.b();
        }
      }
    }
    try
    {
      label160:
      this.a.clear();
      return;
    }
    catch (Throwable localThrowable3)
    {
      localThrowable3.printStackTrace();
    }
  }
  
  public void c()
  {
    this.l.removeObserver(this.o);
    this.l.removeObserver(this.n);
    this.e = null;
    this.l = null;
  }
  
  protected void d()
  {
    if (this.f == null) {
      this.f = new TroopMemberAddFrdHelper.TroopMemberListConfig(this.j);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((this.k != null) && ((localObject instanceof ChatHistoryTroopMemberFragment.ATroopMember)))
    {
      localObject = (ChatHistoryTroopMemberFragment.ATroopMember)localObject;
      this.d = ((ChatHistoryTroopMemberFragment.ATroopMember)localObject);
      String str = this.i.troopcode;
      localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.k, 1, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject).a, str, 3004, 13, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject).n, null, null, null, null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.k, (Intent)localObject);
      localObject = this.i;
      if (localObject != null) {
        long l1 = ((TroopInfo)localObject).dwGroupClassExt;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper
 * JD-Core Version:    0.7.0.1
 */