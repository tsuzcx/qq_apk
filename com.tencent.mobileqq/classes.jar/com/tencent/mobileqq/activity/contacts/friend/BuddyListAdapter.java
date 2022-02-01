package com.tencent.mobileqq.activity.contacts.friend;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.contacts.base.BuddyItemBuilder;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.BuddyListCallback;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.adapter.SwipFacePreloadExpandableAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.troop.adapter.contact.GroupTag;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.QQStoryCoverImageViewHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class BuddyListAdapter
  extends SwipFacePreloadExpandableAdapter
  implements View.OnClickListener, View.OnLongClickListener, BuddyListItem.BuddyListCallback, SwipPinnedHeaderExpandableListView.SwipListListener
{
  private static final BuddyListAdapter.MyComparator jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$MyComparator = new BuddyListAdapter.MyComparator(null);
  public int a;
  private SparseArray<List<BuddyListItem>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BuddyListAdapter.ItemClickListener jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$ItemClickListener;
  private BuddyListAdapter.ItemLongClickListener jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$ItemLongClickListener;
  private SimpleTextView jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
  final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IPhoneContactService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
  private final StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private SimpleTextView jdField_b_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
  private final boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  public BuddyListAdapter(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SwipPinnedHeaderExpandableListView paramSwipPinnedHeaderExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramBaseActivity, paramQQAppInterface, paramSwipPinnedHeaderExpandableListView);
    boolean bool2 = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = null;
    this.jdField_c_of_type_Boolean = true;
    this.d = -1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new BuddyListAdapter.3(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$ItemClickListener = new BuddyListAdapter.ItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$ItemLongClickListener = new BuddyListAdapter.ItemLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, ""));
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_c_of_type_Int = ((int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 12.0F));
    notifyDataSetChanged();
    boolean bool1 = bool2;
    if (Build.MODEL.equals("Lenovo A366t"))
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT == 10) {
        bool1 = true;
      }
    }
    this.jdField_b_of_type_Boolean = bool1;
  }
  
  private void a(GroupTag paramGroupTag, Groups paramGroups, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramGroupTag == null) {
      return;
    }
    boolean bool2 = paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
    boolean bool1 = true;
    if (!bool2) {
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    Object localObject2 = paramGroupTag.jdField_a_of_type_JavaLangStringBuilder;
    Object localObject1 = localObject2;
    if (AppSetting.d)
    {
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder(24);
      }
      else
      {
        ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
        localObject1 = localObject2;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramGroups.group_name);
      ((StringBuilder)localObject2).append(" 分组");
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
    }
    paramGroupTag.jdField_a_of_type_Int = paramInt1;
    paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramGroups.group_name);
    paramGroupTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
    paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    int i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramGroups.group_id);
    paramInt1 = getChildrenCount(paramInt1);
    Object localObject3;
    if (paramGroups.group_id == 1005)
    {
      localObject2 = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append("");
      ((SimpleTextView)localObject2).setText(((StringBuilder)localObject3).toString());
      if (AppSetting.d)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("共");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("个常用群聊");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      localObject3 = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
      if (this.jdField_b_of_type_Boolean) {
        localObject2 = "%d / %d";
      } else {
        localObject2 = "%d/%d";
      }
      ((SimpleTextView)localObject3).setText(String.format((String)localObject2, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) }));
      if (AppSetting.d)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("在线");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("人，共");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("人");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      }
    }
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramGroupTag.jdField_a_of_type_Int)) {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      }
    }
    localObject2 = paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox;
    if (paramInt1 != 2) {
      bool1 = false;
    }
    ((CheckBox)localObject2).setChecked(bool1);
    if (AppSetting.d)
    {
      if (paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        ((StringBuilder)localObject1).append(" 已展开");
      } else {
        ((StringBuilder)localObject1).append(" 已折叠");
      }
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setContentDescription(((StringBuilder)localObject1).toString());
      AccessibilityUtil.a(paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox, false);
    }
    if ((paramGroups.group_id == 1002) && (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState() == this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState()))
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView == paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView) {
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView == paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = null;
    }
  }
  
  private void a(ArrayList<Object> paramArrayList, SparseArray<List<BuddyListItem>> paramSparseArray, SparseIntArray paramSparseIntArray)
  {
    Object localObject4 = paramArrayList;
    Groups localGroups1 = new Groups();
    localGroups1.group_id = 1004;
    localGroups1.group_name = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131716891);
    localGroups1.group_friend_count = 1;
    localGroups1.seqid = 0;
    ((ArrayList)localObject4).add(localGroups1);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject3 != null)
    {
      localObject1 = ((FriendsManager)localObject3).b();
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("BuddyListAdapter", 2, "FriendManager is null");
      }
      localObject1 = null;
    }
    Object localObject5;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((List)localObject1).size() != 0) {}
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("group list is ");
        if (localObject1 == null) {
          localObject2 = "null";
        } else {
          localObject2 = "empty";
        }
        ((StringBuilder)localObject5).append((String)localObject2);
        QLog.d("BuddyListAdapter", 2, ((StringBuilder)localObject5).toString());
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      ((ArrayList)localObject4).remove(localGroups1);
    }
    Object localObject1 = ((List)localObject2).iterator();
    int i = 0;
    Object localObject2 = localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      Groups localGroups2 = (Groups)((Iterator)localObject1).next();
      paramArrayList.add(localGroups2);
      localObject3 = ((FriendsManager)localObject2).a(String.valueOf(localGroups2.group_id));
      if (localObject3 == null) {
        localObject4 = new ArrayList();
      } else {
        localObject4 = new ArrayList((Collection)localObject3);
      }
      ArrayList localArrayList2 = new ArrayList(((List)localObject4).size());
      localObject3 = ((List)localObject4).iterator();
      int k = 0;
      localObject5 = null;
      int j = i;
      i = k;
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject6 = (Entity)((Iterator)localObject3).next();
        Friends localFriends = (Friends)localObject6;
        int m = OnlineStatusUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
        Object localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localFriends.uin);
        if ((localObject7 != null) && (((SpecialCareInfo)localObject7).globalSwitch != 0))
        {
          localArrayList1.add(BuddyItemBuilder.a(4, (Entity)localObject6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
          k = j;
          if (m != 0)
          {
            k = j;
            if (m != 6) {
              k = j + 1;
            }
          }
        }
        else
        {
          k = j;
        }
        if (localFriends.gathtertype == 1)
        {
          j = k;
        }
        else
        {
          j = i;
          if (m != 0)
          {
            j = i;
            if (m != 6) {
              j = i + 1;
            }
          }
          localObject6 = BuddyItemBuilder.a(0, (Entity)localObject6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          ((BuddyListItem)localObject6).a(this);
          try
          {
            localObject7 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            boolean bool = localFriends.uin.equals(localObject7);
            if (bool) {
              localObject5 = localObject6;
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            localArrayList2.add(localObject6);
          }
          i = j;
          j = k;
        }
      }
      a(localArrayList2);
      if (localObject5 != null) {
        localArrayList2.add(0, localObject5);
      }
      paramSparseIntArray.put(localGroups2.group_id, i);
      paramSparseArray.put(localGroups2.group_id, localArrayList2);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("groupId: ");
        ((StringBuilder)localObject3).append(localGroups2.group_id);
        ((StringBuilder)localObject3).append(" num: ");
        ((StringBuilder)localObject3).append(((List)localObject4).size());
        QLog.d("BuddyListAdapter", 2, ((StringBuilder)localObject3).toString());
      }
      i = j;
    }
    a(localArrayList1);
    paramSparseIntArray.put(1004, i);
    paramSparseArray.put(1004, localArrayList1);
    localGroups1.group_friend_count = localArrayList1.size();
  }
  
  private void a(List<BuddyListItem> paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$MyComparator);
      return;
    }
    catch (Exception paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BuddyListAdapter", 2, "", paramList);
      }
    }
  }
  
  private void d()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof BuddyListFriends.BuddyChildTag)))
      {
        localObject = (BuddyListFriends.BuddyChildTag)localObject;
        if ((TextUtils.isEmpty(((BuddyListFriends.BuddyChildTag)localObject).jdField_b_of_type_ComTencentWidgetSingleLineTextView.getText().toString())) && ((((BuddyListFriends.BuddyChildTag)localObject).jdField_a_of_type_JavaLangObject instanceof Friends))) {
          a((Friends)((BuddyListFriends.BuddyChildTag)localObject).jdField_a_of_type_JavaLangObject, (BuddyListFriends.BuddyChildTag)localObject);
        }
      }
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    int k = 0;
    localObject2 = ((BaseApplication)localObject1).getSharedPreferences((String)localObject2, 0).getString("700_sp_key_last_expanded", "700_sp_key_last_expanded");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("readExpand=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("BuddyListAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new HashSet();
    int i;
    int j;
    int m;
    if (((String)localObject2).equalsIgnoreCase("700_sp_key_last_expanded"))
    {
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (getGroupType(i) == 0)
        {
          localObject2 = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (((Groups)localObject2).group_friend_count > 0)
          {
            ((Set)localObject1).add(Integer.valueOf(((Groups)localObject2).group_id));
            break;
          }
        }
        i += 1;
      }
      j = k;
      if (((Set)localObject1).size() == 0)
      {
        this.jdField_c_of_type_Boolean = true;
        j = k;
      }
    }
    else
    {
      j = k;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = ((String)localObject2).split("_");
        m = localObject2.length;
        i = 0;
      }
    }
    for (;;)
    {
      j = k;
      String str;
      if (i < m) {
        str = localObject2[i];
      }
      try
      {
        ((Set)localObject1).add(Integer.valueOf(Integer.parseInt(str)));
        label252:
        i += 1;
        continue;
        while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if ((getGroupType(j) == 0) && (((Set)localObject1).contains(Integer.valueOf(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(j)).group_id)))) {
            this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(j);
          }
          j += 1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label252;
      }
    }
  }
  
  private void f()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = getGroupCount();
    if (j <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BuddyListAdapter", 2, "no data. don't save group");
      }
      return;
    }
    int i = 0;
    Object localObject;
    while (i < j)
    {
      if (getGroupType(i) == 0)
      {
        localObject = (Groups)getGroup(i);
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i))
        {
          localStringBuffer.append(((Groups)localObject).group_id);
          localStringBuffer.append("_");
        }
      }
      i += 1;
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveExpanded=");
      ((StringBuilder)localObject).append(localStringBuffer.toString());
      QLog.d("BuddyListAdapter", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putString("700_sp_key_last_expanded", localStringBuffer.toString()).commit();
  }
  
  String a(Friends paramFriends, BuddyListFriends.BuddyChildTag paramBuddyChildTag)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
      if (localObject == null) {
        return null;
      }
      ExtensionInfo localExtensionInfo = ((FriendsManager)localObject).a(paramFriends.uin);
      int m = 0;
      int i;
      if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent))) {
        i = 1;
      } else {
        i = 0;
      }
      if (localExtensionInfo != null)
      {
        boolean bool;
        if (this.jdField_b_of_type_Int != 0) {
          bool = true;
        } else {
          bool = false;
        }
        localObject = ExtensionRichStatus.a(localExtensionInfo, bool);
      }
      else
      {
        localObject = null;
      }
      int j;
      if ((localObject != null) && (localObject != RichStatus.getEmptyStatus()) && (!((RichStatus)localObject).isEmpty())) {
        j = 1;
      } else {
        j = 0;
      }
      int k;
      if ((j != 0) && (!TextUtils.isEmpty(((RichStatus)localObject).actionText))) {
        k = 1;
      } else {
        k = 0;
      }
      if ((i != 0) && ((localExtensionInfo.feedTime > localExtensionInfo.richTime) || (j == 0)))
      {
        paramFriends = new String(localExtensionInfo.feedContent);
        paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        if (localExtensionInfo.feedType == 2)
        {
          paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
            QQStoryCoverImageViewHelper.a(paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView, localExtensionInfo.feedPhotoUrl, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130850613));
          } else {
            paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850613));
          }
          paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
        else
        {
          paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject = paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView;
          if (localExtensionInfo.feedType == 1) {
            i = 2130849885;
          } else {
            i = 2130849883;
          }
          ((ImageView)localObject).setBackgroundResource(i);
          localObject = paramBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView;
          if (localExtensionInfo.feedHasPhoto) {
            i = m;
          } else {
            i = 8;
          }
          ((URLImageView)localObject).setVisibility(i);
          paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
        localObject = null;
      }
      else
      {
        if (k != 0)
        {
          ((RichStatus)localObject).enableSummaryCached = paramFriends.isFriend();
          paramFriends = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(((RichStatus)localObject).actionId, 200);
          paramFriends = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), paramFriends);
          i = this.jdField_c_of_type_Int;
          paramFriends.setBounds(0, 0, Math.round(paramFriends.getIntrinsicWidth() * 1.0F / paramFriends.getIntrinsicHeight() * i), i);
          paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramFriends, null);
        }
        else if (j == 0)
        {
          localObject = RichStatus.getEmptyStatus();
          paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        }
        paramFriends = ((RichStatus)localObject).getActionAndData();
        String str = ((RichStatus)localObject).getPlainText();
        paramBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        localObject = paramFriends;
        paramFriends = str;
      }
      if (localExtensionInfo == null)
      {
        paramBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
      paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramFriends);
      return paramFriends;
    }
    return null;
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    f();
    OldMutualMarkLogicHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    super.b();
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    f();
    OldMutualMarkLogicHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    Groups localGroups = (Groups)getGroup(paramInt);
    if (!(paramView.getTag() instanceof GroupTag))
    {
      localObject = new GroupTag();
      ((GroupTag)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369353));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367855));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      ((GroupTag)localObject).jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131379843));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365107));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      ((GroupTag)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369450));
      paramView.setTag(localObject);
      paramView = (View)localObject;
    }
    else
    {
      paramView = (GroupTag)paramView.getTag();
    }
    a(paramView, localGroups, paramInt, true, 0);
    paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTypeface(Typeface.SANS_SERIF);
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false))
    {
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131167142);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor((ColorStateList)localObject);
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    if (getGroupType(paramInt1) == 0)
    {
      Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
      return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(localGroups.group_id)).get(paramInt2);
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    long l;
    if ((localObject instanceof Friends))
    {
      localObject = (Friends)localObject;
      try
      {
        l = Long.parseLong(((Friends)localObject).uin);
        return l;
      }
      catch (Throwable localThrowable1)
      {
        if (!QLog.isColorLevel()) {
          break label119;
        }
      }
      QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable1));
      return 0L;
    }
    else
    {
      if ((localThrowable1 instanceof PublicAccountInfo)) {
        return ((PublicAccountInfo)localThrowable1).uin;
      }
      if ((localThrowable1 instanceof PhoneContact))
      {
        PhoneContact localPhoneContact = (PhoneContact)localThrowable1;
        try
        {
          l = Long.parseLong(localPhoneContact.mobileNo);
          return l;
        }
        catch (Throwable localThrowable2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable2));
          }
        }
      }
    }
    label119:
    return 0L;
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    if (getGroupType(paramInt1) == 0)
    {
      if (((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1002) {
        return 1;
      }
      return 0;
    }
    return 99;
  }
  
  public int getChildTypeCount()
  {
    return 6;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.traceBegin("getChildView");
    BuddyListItem localBuddyListItem = (BuddyListItem)getChild(paramInt1, paramInt2);
    if (localBuddyListItem == null) {
      paramView = null;
    } else {
      paramView = localBuddyListItem.a(paramInt1, paramInt2, paramView, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    if (paramView != null)
    {
      a((BuddyListItem.ViewTag)paramView.getTag(), null);
      paramViewGroup = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      if (paramViewGroup != null) {
        paramView.setOnClickListener(paramViewGroup);
      }
      paramView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$ItemLongClickListener);
    }
    TraceUtils.traceEnd();
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (getGroupType(paramInt) == 1) {
      return 0;
    }
    paramInt = ((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).group_id;
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    if (getGroupType(paramInt) == 0) {
      return ((Groups)getGroup(paramInt)).group_id;
    }
    return 1000L;
  }
  
  public int getGroupType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof String)) {
        return 1;
      }
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGroupType illegal, groupPosition =");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
    QLog.e("BuddyListAdapter", 1, localStringBuilder.toString());
    return 1;
  }
  
  public int getGroupTypeCount()
  {
    return 2;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (getGroupType(paramInt) == 1)
    {
      if (paramView == null)
      {
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558915, paramViewGroup, false);
        paramView = (SingleLineTextView)paramViewGroup.findViewById(2131379627);
        paramView.setDefaultTextColor(-8355712);
        paramViewGroup.setTag(paramView);
      }
      else
      {
        localObject = (SingleLineTextView)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
      localObject = (String)getGroup(paramInt);
      paramView.setText("");
      return paramViewGroup;
    }
    Object localObject = (Groups)getGroup(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558918, paramViewGroup, false);
      paramViewGroup = new GroupTag();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367855));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369353));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365107));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369450));
      paramViewGroup.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131379843));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (GroupTag)paramView.getTag();
    }
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false))
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    else
    {
      ColorStateList localColorStateList = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131167142);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(localColorStateList);
    }
    paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$ItemClickListener);
    paramView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$ItemLongClickListener);
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    a(paramViewGroup, (Groups)localObject, paramInt, false, i);
    return paramView;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131558918;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    FrameHelperActivity.b(paramBoolean ^ true);
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public boolean needHideBackgroundGroup()
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "notifyDataSetChanged");
    }
    ThreadManager.postImmediately(new BuddyListAdapter.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    GroupTag localGroupTag = (GroupTag)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(localGroupTag.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(localGroupTag.jdField_a_of_type_Int);
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(localGroupTag.jdField_a_of_type_Int);
      ((QzoneContactsFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_CONTACTS_FEED_MANAGER)).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool1 = this.jdField_a_of_type_Boolean;
    boolean bool3 = true;
    boolean bool2 = false;
    if (bool1)
    {
      Object localObject1 = paramView.getTag();
      if (localObject1 != null)
      {
        if ((localObject1 instanceof GroupTag))
        {
          localObject1 = new QQCustomMenu();
          ((QQCustomMenu)localObject1).a(0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693091));
          BubbleContextMenu.a(paramView, (QQCustomMenu)localObject1, this.jdField_b_of_type_AndroidViewView$OnClickListener, null);
          return true;
        }
        bool1 = bool3;
        if (!(localObject1 instanceof BuddyListItem.ViewTag)) {
          break label257;
        }
        Object localObject2 = ((BuddyListItem.ViewTag)localObject1).jdField_a_of_type_JavaLangObject;
        bool1 = bool3;
        if (localObject2 == null) {
          break label257;
        }
        bool1 = bool3;
        if (!(localObject2 instanceof Friends)) {
          break label257;
        }
        paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
        localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        localObject2 = (Friends)localObject2;
        localObject1 = ((FriendsManager)localObject1).a(((Friends)localObject2).uin);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(((Friends)localObject2).uin)) {
          return false;
        }
        bool1 = bool2;
        if (localObject1 != null) {
          if (((SpecialCareInfo)localObject1).globalSwitch == 0) {
            bool1 = bool2;
          } else {
            bool1 = true;
          }
        }
        int i;
        if (bool1) {
          i = 2131691089;
        } else {
          i = 2131691090;
        }
        paramView.addButton(i);
        paramView.addCancelButton(2131690728);
        paramView.setOnButtonClickListener(new BuddyListAdapter.2(this, bool1, (Friends)localObject2, paramView));
      }
    }
    try
    {
      paramView.show();
      return true;
    }
    catch (Exception paramView) {}
    bool1 = false;
    label257:
    return bool1;
    return true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      d();
      DropFrameMonitor.a().a("list_g_contacts", false);
    }
    else
    {
      DropFrameMonitor.a().a("list_g_contacts");
    }
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
  
  public boolean supportSwip(View paramView)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if ((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag))
    {
      paramView = (BuddyListFriends.BuddyChildTag)paramView.getTag();
      if ((paramView.jdField_a_of_type_JavaLangObject instanceof Friends))
      {
        paramView = (Friends)paramView.jdField_a_of_type_JavaLangObject;
        if ((paramView.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (Utils.b(paramView.uin))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void updateCurShowRightView(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i = j;
      if ((paramView instanceof Integer)) {
        i = ((Integer)paramView).intValue();
      }
    }
    this.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */