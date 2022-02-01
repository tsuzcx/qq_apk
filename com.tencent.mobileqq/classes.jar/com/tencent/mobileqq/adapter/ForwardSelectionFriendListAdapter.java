package com.tencent.mobileqq.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.util.ImageWorker;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class ForwardSelectionFriendListAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener
{
  public static int a = 1003;
  protected float a;
  protected Context a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ForwardSelectionFriendListAdapter.1(this);
  private ForwardSelectionFriendListAdapter.IForwardFriendListAdapterCallback jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter$IForwardFriendListAdapterCallback;
  protected FriendsManager a;
  protected QQAppInterface a;
  protected ImageWorker a;
  protected HashMap<Integer, ArrayList<Entity>> a;
  protected List<Entity> a;
  private boolean jdField_a_of_type_Boolean;
  protected HashMap<Integer, String> b = new HashMap();
  
  public ForwardSelectionFriendListAdapter(Context paramContext, ExpandableListView paramExpandableListView, QQAppInterface paramQQAppInterface, List<Entity> paramList, ForwardSelectionFriendListAdapter.IForwardFriendListAdapterCallback paramIForwardFriendListAdapterCallback, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter$IForwardFriendListAdapterCallback = paramIForwardFriendListAdapterCallback;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker = new ImageWorker(paramContext);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker;
    float f = this.jdField_a_of_type_Float;
    paramContext.a((int)(f * 100.0F), (int)(f * 100.0F));
    a(paramList, false);
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  private ArrayList<Entity> a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(true));
  }
  
  private ArrayList<Entity> a(List<RecentUser> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.getType() == 0) && (!Utils.c(localRecentUser.uin)))
        {
          FriendsManager localFriendsManager = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
          if ((localFriendsManager != null) && (localFriendsManager.b(localRecentUser.uin))) {
            localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e(localRecentUser.uin));
          }
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a()
  {
    Object localObject1 = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    int i = ((IPhoneContactService)localObject1).getSelfBindState();
    if ((((IPhoneContactService)localObject1).isBindContactOk()) || (i == 8))
    {
      Object localObject2 = ((IPhoneContactService)localObject1).getBindNonfriendList();
      if (localObject2 != null)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll((Collection)localObject2);
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1002;
          ((Groups)localObject2).group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131694786);
          ((Groups)localObject2).group_friend_count = 1;
          ((Groups)localObject2).seqid = 0;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((Groups)localObject2).group_id), localObject1);
        }
      }
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public List<Entity> a(int paramInt)
  {
    paramInt = ((Groups)getGroup(paramInt)).group_id;
    return (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(List<Entity> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    Groups localGroups;
    ArrayList localArrayList;
    Object localObject1;
    if (paramList.hasNext())
    {
      localGroups = (Groups)paramList.next();
      int j = localGroups.group_id;
      int k = a();
      int i = 0;
      if ((j == k) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(a()))))
      {
        localArrayList = a();
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(a()), localArrayList);
        if (localArrayList != null) {
          i = localArrayList.size();
        }
        localGroups.group_friend_count = i;
      }
      else
      {
        localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(String.valueOf(localGroups.group_id));
        localArrayList = new ArrayList();
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
        {
          localArrayList.addAll((Collection)localObject1);
          localObject1 = localArrayList.iterator();
          label183:
          if (!((Iterator)localObject1).hasNext()) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = (Friends)((Iterator)localObject1).next();
        if (Utils.b(((Friends)localObject2).uin))
        {
          ((Iterator)localObject1).remove();
          break label183;
        }
        if ((!TextUtils.equals(((Friends)localObject2).uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof ForwardFriendListActivity))) {
          break label183;
        }
        localObject2 = ((ForwardFriendListActivity)this.jdField_a_of_type_AndroidContentContext).getIntent();
        if (localObject2 == null) {
          break label368;
        }
        bool = ((Intent)localObject2).getBooleanExtra("choose_friend_isForConfess", false);
        if (!bool) {
          break label183;
        }
        ((Iterator)localObject1).remove();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      break label183;
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localGroups.group_id), localArrayList);
      this.b.put(Integer.valueOf(localGroups.group_id), localGroups.group_name);
      break;
      if (paramBoolean) {
        super.notifyDataSetChanged();
      }
      return;
      label368:
      boolean bool = false;
    }
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    Object localObject2 = (ForwardSelectionFriendListAdapter.GroupViewTag)paramView.getTag();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ForwardSelectionFriendListAdapter.GroupViewTag();
      ((ForwardSelectionFriendListAdapter.GroupViewTag)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367855));
      ((ForwardSelectionFriendListAdapter.GroupViewTag)localObject1).b = ((TextView)paramView.findViewById(2131365107));
      paramView.findViewById(2131369353).setVisibility(0);
      paramView.setTag(localObject1);
    }
    localObject2 = (Groups)getGroup(paramInt);
    ((ForwardSelectionFriendListAdapter.GroupViewTag)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((Groups)localObject2).group_name);
    ((ForwardSelectionFriendListAdapter.GroupViewTag)localObject1).b.setText(String.valueOf(((Groups)localObject2).group_friend_count));
    ((CheckBox)paramView.findViewById(2131369353)).setChecked(this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return a(paramInt1).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    ForwardSelectionFriendListAdapter.ViewTag localViewTag;
    if (paramView == null)
    {
      paramViewGroup = new ForwardRecentItemView(this.jdField_a_of_type_AndroidContentContext);
      localViewTag = new ForwardSelectionFriendListAdapter.ViewTag();
      paramViewGroup.setTag(localViewTag);
    }
    else
    {
      paramViewGroup = (ForwardRecentItemView)paramView;
      localViewTag = (ForwardSelectionFriendListAdapter.ViewTag)paramViewGroup.getTag();
    }
    Object localObject2 = getChild(paramInt1, paramInt2);
    String str;
    if ((localObject2 instanceof PhoneContact))
    {
      paramView = (PhoneContact)localObject2;
      str = paramView.name;
      localObject1 = paramView.mobileCode;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramView = paramView.mobileNo;
      }
      else
      {
        paramInt1 = ((String)localObject1).indexOf("|");
        paramView = (View)localObject1;
        if (paramInt1 > -1) {
          paramView = ((String)localObject1).substring(0, paramInt1);
        }
      }
      localViewTag.jdField_c_of_type_Int = 11;
      paramInt1 = 1006;
    }
    else
    {
      paramView = (Friends)localObject2;
      str = ContactUtils.a(paramView);
      paramView = paramView.uin;
      localViewTag.jdField_c_of_type_Int = 1;
      paramInt1 = 0;
    }
    localViewTag.jdField_c_of_type_AndroidWidgetImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
    localViewTag.jdField_a_of_type_JavaLangString = paramView;
    localViewTag.jdField_a_of_type_JavaLangObject = localObject2;
    paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter$IForwardFriendListAdapterCallback.a(paramView, paramInt1);
    boolean bool = RobotUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    localObject2 = paramViewGroup.jdField_a_of_type_ComTencentMobileqqSelectmemberResultRecord;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ResultRecord();
    }
    ((ResultRecord)localObject1).init(paramView, str, paramInt1, "", "");
    paramViewGroup.a(str, "", null, (ResultRecord)localObject1, this.jdField_a_of_type_Boolean, paramBoolean, bool);
    a(localViewTag, null);
    paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.d) {
      paramViewGroup.setContentDescription(str);
    }
    return paramViewGroup;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (a(paramInt) == null) {
      return 0;
    }
    return a(paramInt).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558917, paramViewGroup, false);
      paramView = new ForwardSelectionFriendListAdapter.GroupViewTag();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367855));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131365107));
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this);
    }
    else
    {
      localObject = (ForwardSelectionFriendListAdapter.GroupViewTag)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (Groups)getGroup(paramInt);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Groups)localObject).group_name);
    paramView.b.setText(String.valueOf(getChildrenCount(paramInt)));
    paramView.jdField_a_of_type_Int = paramInt;
    if (AppSetting.d) {
      paramViewGroup.setContentDescription(((Groups)localObject).group_name);
    }
    return paramViewGroup;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131558917;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_JavaUtilList == null;
  }
  
  public void onClick(View paramView)
  {
    ForwardSelectionFriendListAdapter.GroupViewTag localGroupViewTag = (ForwardSelectionFriendListAdapter.GroupViewTag)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(localGroupViewTag.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(localGroupViewTag.jdField_a_of_type_Int);
    } else {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(localGroupViewTag.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter
 * JD-Core Version:    0.7.0.1
 */