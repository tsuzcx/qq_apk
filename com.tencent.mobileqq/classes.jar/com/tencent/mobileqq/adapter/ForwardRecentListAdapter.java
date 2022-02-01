package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ForwardRecentListAdapter
  extends FacePreloadBaseAdapter
{
  QQAppInterface a;
  CardHandler b;
  private Context c;
  private FriendsManager d;
  private List<ForwardRecentListAdapter.DisplayData> e = new ArrayList();
  private TroopManager f;
  private DiscussionManager g;
  private boolean h;
  private ForwardRecentListAdapter.IForwardRecentListAdapterCallback j;
  private View.OnClickListener k = new ForwardRecentListAdapter.2(this);
  
  public ForwardRecentListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<RecentUser> paramList, ForwardRecentListAdapter.IForwardRecentListAdapterCallback paramIForwardRecentListAdapterCallback)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, false);
    a(paramQQAppInterface);
    this.c = paramContext;
    this.j = paramIForwardRecentListAdapterCallback;
    a(paramList);
  }
  
  private ArrayList<ForwardRecentListAdapter.DisplayData> b(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int m = 0;
    while (m < paramList.size())
    {
      RecentUser localRecentUser = (RecentUser)paramList.get(m);
      ForwardRecentListAdapter.DisplayData localDisplayData = new ForwardRecentListAdapter.DisplayData();
      String str = localRecentUser.uin;
      int n = localRecentUser.getType();
      Object localObject2 = null;
      Object localObject1 = null;
      int i1 = localRecentUser.getType();
      int i = 1;
      if (i1 != 0) {
        if (i1 != 1)
        {
          if ((i1 == 1000) || (i1 == 1001)) {
            break label548;
          }
          if (i1 != 1008) {
            if (i1 != 3000) {
              if (i1 != 6002)
              {
                if ((i1 == 10002) || (i1 == 10004) || (i1 == 10008) || (i1 == 10010) || (i1 == 10013)) {
                  break label548;
                }
                switch (i1)
                {
                default: 
                  switch (i1)
                  {
                  }
                  break;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        break;
        localObject1 = ContactUtils.a(this.a, str, true);
        break;
        localObject1 = ContactUtils.b(this.a, str);
        localObject2 = ((IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(str);
        if (localObject2 != null) {
          localObject1 = ((PhoneContact)localObject2).name;
        } else if (localObject1 != null) {
          localObject1 = ContactUtils.a(this.a, (String)localObject1, true);
        } else {
          localObject1 = str;
        }
        i = 11;
        break;
        localObject1 = localRecentUser.displayName;
        i = 104;
        break;
        localObject1 = this.g.d(str);
        if ((localObject1 == null) || (((DiscussionInfo)localObject1).isHidden())) {
          break label798;
        }
        if (TextUtils.isEmpty(((DiscussionInfo)localObject1).discussionName)) {
          localObject1 = localRecentUser.displayName;
        } else {
          localObject1 = ((DiscussionInfo)localObject1).discussionName;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.c.getResources().getString(2131888722);
        }
        i = 101;
        localObject1 = localObject2;
        break;
        localObject2 = (PublicAccountInfo)((IPublicAccountDataManager)this.a.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(str);
        if (localObject2 != null)
        {
          localObject1 = ((PublicAccountInfo)localObject2).name;
          break;
          localObject1 = this.f.f(str);
          i = 4;
          if (localObject1 != null) {
            localObject1 = ((TroopInfo)localObject1).getTroopDisplayName();
          } else {
            localObject1 = localRecentUser.displayName;
          }
          if ((localObject1 == null) || (((String)localObject1).trim().equals("")))
          {
            localObject1 = str;
            break;
            label548:
            Friends localFriends = this.d.m(str);
            localObject1 = localObject2;
            if (localFriends != null)
            {
              localObject1 = localObject2;
              if (localFriends.uin != null)
              {
                localObject1 = localObject2;
                if (localFriends.uin.length() > 0) {
                  localObject1 = ContactUtils.a(localFriends);
                }
              }
            }
            if ((n != 1000) && (n != 1020))
            {
              if (n == 1004) {
                localObject1 = ContactUtils.a(this.a, localRecentUser.troopUin, str);
              }
            }
            else
            {
              localObject1 = this.f.k(localRecentUser.troopUin);
              localObject1 = ContactUtils.a(this.a, str, (String)localObject1, localRecentUser.troopUin, true, null);
            }
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (!"".equals(localObject1)) {}
            }
            else
            {
              localObject2 = ContactUtils.a(this.a, str, true);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localObject2;
              if (!((String)localObject2).equals(QFileAssistantUtils.b(this.a))) {
                break;
              }
            }
            else
            {
              localObject1 = localRecentUser.displayName;
            }
          }
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = str;
      }
      localDisplayData.a = ((String)localObject2);
      localDisplayData.b = i;
      localDisplayData.c = str;
      localDisplayData.d = localRecentUser;
      localArrayList.add(localDisplayData);
      label798:
      m += 1;
    }
    return localArrayList;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = ((CardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.d = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.f = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.g = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
  }
  
  public void a(List<RecentUser> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new ForwardRecentListAdapter.1(this, paramList));
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public int getCount()
  {
    return this.e.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.e.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ForwardRecentItemView localForwardRecentItemView;
    if (paramView == null)
    {
      localForwardRecentItemView = new ForwardRecentItemView(this.c);
      localObject1 = new FacePreloadHolder.ViewHolder();
      localForwardRecentItemView.setTag(localObject1);
    }
    else
    {
      localForwardRecentItemView = (ForwardRecentItemView)paramView;
      localObject1 = (FacePreloadHolder.ViewHolder)localForwardRecentItemView.getTag();
    }
    ForwardRecentListAdapter.DisplayData localDisplayData = (ForwardRecentListAdapter.DisplayData)getItem(paramInt);
    ((FacePreloadHolder.ViewHolder)localObject1).y = localDisplayData.c;
    ((FacePreloadHolder.ViewHolder)localObject1).z = localDisplayData.b;
    ((FacePreloadHolder.ViewHolder)localObject1).A = localForwardRecentItemView.d;
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(a(localDisplayData.b, localDisplayData.c));
    boolean bool2 = this.j.a(localDisplayData.c, localDisplayData.d.getType());
    Object localObject2 = localForwardRecentItemView.k;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ResultRecord();
    }
    ((ResultRecord)localObject1).init(localDisplayData.c, localDisplayData.a, localDisplayData.d.getType(), localDisplayData.d.troopUin, "");
    if (localDisplayData.d.getType() == 3000)
    {
      localObject2 = this.g.d(localDisplayData.c);
      if ((localObject2 != null) && (!((DiscussionInfo)localObject2).hasRenamed())) {
        localForwardRecentItemView.a(localDisplayData.a, String.valueOf(this.g.c(localDisplayData.c)), localBitmapDrawable, (ResultRecord)localObject1, this.h, bool2);
      } else {
        localForwardRecentItemView.a(localDisplayData.a, null, localBitmapDrawable, (ResultRecord)localObject1, this.h, bool2);
      }
    }
    else
    {
      localObject2 = this.f.f(localDisplayData.c);
      if ((localObject2 != null) && (!((TroopInfo)localObject2).hasSetTroopName()) && (((TroopInfo)localObject2).wMemberNumClient > 0))
      {
        localForwardRecentItemView.a(localDisplayData.a, String.valueOf(((TroopInfo)localObject2).wMemberNumClient), localBitmapDrawable, (ResultRecord)localObject1, this.h, bool2);
      }
      else
      {
        boolean bool1;
        if ((localObject2 == null) && (RobotUtils.a(this.a, localDisplayData.c))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localForwardRecentItemView.a(localDisplayData.a, null, localBitmapDrawable, (ResultRecord)localObject1, this.h, bool2, bool1);
      }
    }
    localForwardRecentItemView.setOnClickListener(this.k);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localForwardRecentItemView;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardRecentListAdapter", 2, "notifyDataSetChanged() called");
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentListAdapter
 * JD-Core Version:    0.7.0.1
 */