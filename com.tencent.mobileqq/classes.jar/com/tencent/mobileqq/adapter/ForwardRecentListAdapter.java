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
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ForwardRecentListAdapter.2(this);
  private ForwardRecentListAdapter.IForwardRecentListAdapterCallback jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter$IForwardRecentListAdapterCallback;
  CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  private DiscussionManager jdField_a_of_type_ComTencentMobileqqAppDiscussionManager;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private List<ForwardRecentListAdapter.DisplayData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public ForwardRecentListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<RecentUser> paramList, ForwardRecentListAdapter.IForwardRecentListAdapterCallback paramIForwardRecentListAdapterCallback)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, false);
    a(paramQQAppInterface);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter$IForwardRecentListAdapterCallback = paramIForwardRecentListAdapterCallback;
    a(paramList);
  }
  
  private ArrayList<ForwardRecentListAdapter.DisplayData> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = 0;
    while (j < paramList.size())
    {
      RecentUser localRecentUser = (RecentUser)paramList.get(j);
      ForwardRecentListAdapter.DisplayData localDisplayData = new ForwardRecentListAdapter.DisplayData();
      String str = localRecentUser.uin;
      int k = localRecentUser.getType();
      Object localObject2 = null;
      Object localObject1 = null;
      int m = localRecentUser.getType();
      int i = 1;
      if (m != 0) {
        if (m != 1)
        {
          if ((m == 1000) || (m == 1001)) {
            break label552;
          }
          if (m != 1008) {
            if (m != 3000) {
              if (m != 6002)
              {
                if ((m == 10002) || (m == 10004)) {
                  break label552;
                }
                switch (m)
                {
                default: 
                  switch (m)
                  {
                  default: 
                    switch (m)
                    {
                    }
                    break;
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
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);
        break;
        localObject1 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        localObject2 = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(str);
        if (localObject2 != null) {
          localObject1 = ((PhoneContact)localObject2).name;
        } else if (localObject1 != null) {
          localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        } else {
          localObject1 = str;
        }
        i = 11;
        break;
        localObject1 = localRecentUser.displayName;
        i = 104;
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(str);
        if ((localObject1 == null) || (((DiscussionInfo)localObject1).isHidden())) {
          break label802;
        }
        if (TextUtils.isEmpty(((DiscussionInfo)localObject1).discussionName)) {
          localObject1 = localRecentUser.displayName;
        } else {
          localObject1 = ((DiscussionInfo)localObject1).discussionName;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691760);
        }
        i = 101;
        localObject1 = localObject2;
        break;
        localObject2 = (PublicAccountInfo)((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(str);
        if (localObject2 != null)
        {
          localObject1 = ((PublicAccountInfo)localObject2).name;
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(str);
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
            label552:
            Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e(str);
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
            if ((k != 1000) && (k != 1020))
            {
              if (k == 1004) {
                localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.troopUin, str);
              }
            }
            else
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localRecentUser.troopUin);
              localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, (String)localObject1, localRecentUser.troopUin, true, null);
            }
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (!"".equals(localObject1)) {}
            }
            else
            {
              localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localObject2;
              if (!((String)localObject2).equals(QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
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
      localDisplayData.jdField_a_of_type_JavaLangString = ((String)localObject2);
      localDisplayData.jdField_a_of_type_Int = i;
      localDisplayData.b = str;
      localDisplayData.jdField_a_of_type_ComTencentMobileqqDataRecentUser = localRecentUser;
      localArrayList.add(localDisplayData);
      label802:
      j += 1;
    }
    return localArrayList;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
  }
  
  public void a(List<RecentUser> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new ForwardRecentListAdapter.1(this, paramList));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      localForwardRecentItemView = new ForwardRecentItemView(this.jdField_a_of_type_AndroidContentContext);
      localObject1 = new FacePreloadHolder.ViewHolder();
      localForwardRecentItemView.setTag(localObject1);
    }
    else
    {
      localForwardRecentItemView = (ForwardRecentItemView)paramView;
      localObject1 = (FacePreloadHolder.ViewHolder)localForwardRecentItemView.getTag();
    }
    ForwardRecentListAdapter.DisplayData localDisplayData = (ForwardRecentListAdapter.DisplayData)getItem(paramInt);
    ((FacePreloadHolder.ViewHolder)localObject1).jdField_a_of_type_JavaLangString = localDisplayData.b;
    ((FacePreloadHolder.ViewHolder)localObject1).jdField_c_of_type_Int = localDisplayData.jdField_a_of_type_Int;
    ((FacePreloadHolder.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = localForwardRecentItemView.jdField_a_of_type_AndroidWidgetImageView;
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(a(localDisplayData.jdField_a_of_type_Int, localDisplayData.b));
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter$IForwardRecentListAdapterCallback.a(localDisplayData.b, localDisplayData.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType());
    Object localObject2 = localForwardRecentItemView.jdField_a_of_type_ComTencentMobileqqSelectmemberResultRecord;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ResultRecord();
    }
    ((ResultRecord)localObject1).init(localDisplayData.b, localDisplayData.jdField_a_of_type_JavaLangString, localDisplayData.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType(), localDisplayData.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, "");
    if (localDisplayData.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType() == 3000)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(localDisplayData.b);
      if ((localObject2 != null) && (!((DiscussionInfo)localObject2).hasRenamed())) {
        localForwardRecentItemView.a(localDisplayData.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(localDisplayData.b)), localBitmapDrawable, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, bool2);
      } else {
        localForwardRecentItemView.a(localDisplayData.jdField_a_of_type_JavaLangString, null, localBitmapDrawable, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, bool2);
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localDisplayData.b);
      if ((localObject2 != null) && (!((TroopInfo)localObject2).hasSetTroopName()) && (((TroopInfo)localObject2).wMemberNumClient > 0))
      {
        localForwardRecentItemView.a(localDisplayData.jdField_a_of_type_JavaLangString, String.valueOf(((TroopInfo)localObject2).wMemberNumClient), localBitmapDrawable, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, bool2);
      }
      else
      {
        boolean bool1;
        if ((localObject2 == null) && (RobotUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDisplayData.b))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localForwardRecentItemView.a(localDisplayData.jdField_a_of_type_JavaLangString, null, localBitmapDrawable, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, bool2, bool1);
      }
    }
    localForwardRecentItemView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentListAdapter
 * JD-Core Version:    0.7.0.1
 */