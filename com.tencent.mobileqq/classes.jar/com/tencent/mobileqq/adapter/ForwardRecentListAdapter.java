package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
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
import com.tencent.mobileqq.model.PhoneContactManager;
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
    RecentUser localRecentUser;
    String str;
    int i;
    Object localObject2;
    if (j < paramList.size())
    {
      localRecentUser = (RecentUser)paramList.get(j);
      ForwardRecentListAdapter.DisplayData localDisplayData = new ForwardRecentListAdapter.DisplayData();
      str = localRecentUser.uin;
      i = localRecentUser.getType();
      switch (localRecentUser.getType())
      {
      default: 
        i = 1;
        localObject1 = null;
      case 6002: 
        for (;;)
        {
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = str;
          }
          localDisplayData.jdField_a_of_type_JavaLangString = ((String)localObject2);
          localDisplayData.jdField_a_of_type_Int = i;
          localDisplayData.b = str;
          localDisplayData.jdField_a_of_type_ComTencentMobileqqDataRecentUser = localRecentUser;
          localArrayList.add(localDisplayData);
          j += 1;
          break;
          localObject1 = localRecentUser.displayName;
          i = 104;
        }
      case 1008: 
        label308:
        localObject1 = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(str);
        if (localObject1 == null) {
          break;
        }
      }
    }
    for (Object localObject1 = ((PublicAccountInfo)localObject1).name;; localObject1 = null)
    {
      i = 1;
      break;
      localObject1 = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
      localObject2 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).c(str);
      if (localObject2 != null) {
        localObject1 = ((PhoneContact)localObject2).name;
      }
      for (;;)
      {
        i = 11;
        break;
        if (localObject1 != null) {
          localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        } else {
          localObject1 = str;
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e(str);
      if ((localObject1 != null) && (((Friends)localObject1).uin != null) && (((Friends)localObject1).uin.length() > 0)) {}
      for (localObject1 = ContactUtils.a((Friends)localObject1);; localObject1 = null)
      {
        if ((i == 1000) || (i == 1020))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localRecentUser.troopUin);
          localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, (String)localObject1, localRecentUser.troopUin, true, null);
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (!"".equals(localObject1)) {}
          }
          else
          {
            localObject2 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).equals(QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {}
          }
          else
          {
            localObject1 = localRecentUser.displayName;
          }
          i = 1;
          break;
          if (i == 1004) {
            localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.troopUin, str);
          }
        }
        if ((0 == 0) || ("".equals(null))) {}
        for (localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, true);; localObject1 = null)
        {
          i = 1;
          break;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(str);
          int k = 4;
          if (localObject1 != null) {}
          for (localObject2 = ((TroopInfo)localObject1).getTroopDisplayName();; localObject2 = localRecentUser.displayName)
          {
            if (localObject2 != null)
            {
              i = k;
              localObject1 = localObject2;
              if (!((String)localObject2).trim().equals("")) {
                break;
              }
            }
            localObject1 = str;
            i = k;
            break;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(str);
          if ((localObject1 == null) || (((DiscussionInfo)localObject1).isHidden())) {
            break label308;
          }
          if (TextUtils.isEmpty(((DiscussionInfo)localObject1).discussionName)) {}
          for (localObject1 = localRecentUser.displayName;; localObject1 = ((DiscussionInfo)localObject1).discussionName)
          {
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691838);
            }
            localObject1 = localObject2;
            i = 101;
            break;
          }
          return localArrayList;
        }
      }
    }
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
    Object localObject1;
    ForwardRecentListAdapter.DisplayData localDisplayData;
    BitmapDrawable localBitmapDrawable;
    boolean bool3;
    Object localObject2;
    if (paramView == null)
    {
      localForwardRecentItemView = new ForwardRecentItemView(this.jdField_a_of_type_AndroidContentContext);
      localObject1 = new FacePreloadBaseAdapter.ViewHolder();
      localForwardRecentItemView.setTag(localObject1);
      localDisplayData = (ForwardRecentListAdapter.DisplayData)getItem(paramInt);
      ((FacePreloadBaseAdapter.ViewHolder)localObject1).jdField_a_of_type_JavaLangString = localDisplayData.b;
      ((FacePreloadBaseAdapter.ViewHolder)localObject1).jdField_c_of_type_Int = localDisplayData.jdField_a_of_type_Int;
      ((FacePreloadBaseAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = localForwardRecentItemView.jdField_a_of_type_AndroidWidgetImageView;
      localBitmapDrawable = new BitmapDrawable(a(localDisplayData.jdField_a_of_type_Int, localDisplayData.b));
      bool3 = this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter$IForwardRecentListAdapterCallback.a(localDisplayData.b, localDisplayData.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType());
      localObject2 = localForwardRecentItemView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ResultRecord();
      }
      ((ResultRecord)localObject1).init(localDisplayData.b, localDisplayData.jdField_a_of_type_JavaLangString, localDisplayData.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType(), localDisplayData.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, "");
      if (localDisplayData.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType() != 3000) {
        break label323;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(localDisplayData.b);
      if ((localObject2 == null) || (((DiscussionInfo)localObject2).hasRenamed())) {
        break label299;
      }
      localForwardRecentItemView.a(localDisplayData.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(localDisplayData.b)), localBitmapDrawable, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, bool3);
    }
    for (;;)
    {
      localForwardRecentItemView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localForwardRecentItemView;
      localForwardRecentItemView = (ForwardRecentItemView)paramView;
      localObject1 = (FacePreloadBaseAdapter.ViewHolder)localForwardRecentItemView.getTag();
      break;
      label299:
      localForwardRecentItemView.a(localDisplayData.jdField_a_of_type_JavaLangString, null, localBitmapDrawable, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, bool3);
      continue;
      label323:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localDisplayData.b);
      if ((localObject2 != null) && (!((TroopInfo)localObject2).hasSetTroopName()) && (((TroopInfo)localObject2).wMemberNumClient > 0))
      {
        localForwardRecentItemView.a(localDisplayData.jdField_a_of_type_JavaLangString, String.valueOf(((TroopInfo)localObject2).wMemberNumClient), localBitmapDrawable, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, bool3);
      }
      else
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (localObject2 == null)
        {
          bool1 = bool2;
          if (RobotUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDisplayData.b)) {
            bool1 = true;
          }
        }
        localForwardRecentItemView.a(localDisplayData.jdField_a_of_type_JavaLangString, null, localBitmapDrawable, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, bool3, bool1);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentListAdapter
 * JD-Core Version:    0.7.0.1
 */