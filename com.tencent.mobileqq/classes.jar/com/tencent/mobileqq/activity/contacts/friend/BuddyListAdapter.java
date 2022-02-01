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
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
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
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.QQStoryCoverImageViewHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
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
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = null;
  private BuddyListAdapter.ItemClickListener jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$ItemClickListener = new BuddyListAdapter.ItemClickListener(this);
  private BuddyListAdapter.ItemLongClickListener jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$ItemLongClickListener = new BuddyListAdapter.ItemLongClickListener(this);
  private SimpleTextView jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
  final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  private final StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new BuddyListAdapter.3(this);
  private SimpleTextView jdField_b_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
  private final boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int d = -1;
  
  public BuddyListAdapter(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SwipPinnedHeaderExpandableListView paramSwipPinnedHeaderExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramBaseActivity, paramQQAppInterface, paramSwipPinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(QQManagerFactory.OLYMPIC_MANAGER));
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_c_of_type_Int = ((int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 12.0F));
    notifyDataSetChanged();
    if ((Build.MODEL.equals("Lenovo A366t")) && (Build.VERSION.SDK_INT == 10)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(BuddyListAdapter.GroupTag paramGroupTag, Groups paramGroups, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramGroupTag == null) {
      return;
    }
    if (!paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    Object localObject2 = paramGroupTag.jdField_a_of_type_JavaLangStringBuilder;
    Object localObject1 = localObject2;
    int i;
    if (AppSetting.d)
    {
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder(24);
        ((StringBuilder)localObject1).append(paramGroups.group_name + " 分组");
      }
    }
    else
    {
      paramGroupTag.jdField_a_of_type_Int = paramInt1;
      paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramGroups.group_name);
      paramGroupTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
      paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramGroups.group_id);
      paramInt1 = getChildrenCount(paramInt1);
      if (paramGroups.group_id != 1005) {
        break label366;
      }
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText(paramInt1 + "");
      if (AppSetting.d) {
        ((StringBuilder)localObject1).append("共" + paramInt1 + "个常用群聊");
      }
      if (paramInt2 != 0) {
        break label538;
      }
      if (!this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramGroupTag.jdField_a_of_type_Int)) {
        break label473;
      }
      paramInt1 = 2;
    }
    for (;;)
    {
      label240:
      localObject2 = paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox;
      boolean bool;
      if (paramInt1 == 2)
      {
        bool = true;
        label254:
        ((CheckBox)localObject2).setChecked(bool);
        if (AppSetting.d)
        {
          if (!paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label484;
          }
          ((StringBuilder)localObject1).append(" 已展开");
        }
      }
      for (;;)
      {
        paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setContentDescription(((StringBuilder)localObject1).toString());
        AccessibilityUtil.a(paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox, false);
        if ((paramGroups.group_id != 1002) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.d() != this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.d())) {
          break label505;
        }
        if (!paramBoolean) {
          break label496;
        }
        this.jdField_b_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
        return;
        ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
        localObject1 = localObject2;
        break;
        label366:
        SimpleTextView localSimpleTextView = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
        if (this.jdField_b_of_type_Boolean) {}
        for (localObject2 = "%d / %d";; localObject2 = "%d/%d")
        {
          localSimpleTextView.setText(String.format((String)localObject2, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) }));
          if (!AppSetting.d) {
            break;
          }
          ((StringBuilder)localObject1).append("在线" + i + "人，共" + paramInt1 + "人");
          break;
        }
        label473:
        paramInt1 = 1;
        break label240;
        bool = false;
        break label254;
        label484:
        ((StringBuilder)localObject1).append(" 已折叠");
      }
      label496:
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
      return;
      label505:
      if (this.jdField_b_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView == paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView) {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView != paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = null;
      return;
      label538:
      paramInt1 = paramInt2;
    }
  }
  
  private void a(ArrayList<Object> paramArrayList, SparseArray<List<BuddyListItem>> paramSparseArray, SparseIntArray paramSparseIntArray)
  {
    Groups localGroups1 = new Groups();
    localGroups1.group_id = 1004;
    localGroups1.group_name = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131717232);
    localGroups1.group_friend_count = 1;
    localGroups1.seqid = 0;
    paramArrayList.add(localGroups1);
    ArrayList localArrayList1 = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = null;
    Object localObject1;
    Object localObject3;
    if (localFriendsManager != null)
    {
      localObject1 = localFriendsManager.b();
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((List)localObject1).size() != 0) {}
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("group list is ");
          if (localObject1 != null) {
            break label439;
          }
          localObject2 = "null";
          label140:
          QLog.d("BuddyListAdapter", 2, (String)localObject2);
        }
        if (localObject1 != null) {
          break label698;
        }
        localObject1 = new ArrayList();
      }
    }
    label286:
    label439:
    label695:
    label698:
    for (;;)
    {
      paramArrayList.remove(localGroups1);
      localObject2 = localObject1;
      Iterator localIterator1 = ((List)localObject2).iterator();
      int i = 0;
      Groups localGroups2;
      label255:
      ArrayList localArrayList2;
      int j;
      Friends localFriends;
      int k;
      Object localObject4;
      if (localIterator1.hasNext())
      {
        localGroups2 = (Groups)localIterator1.next();
        paramArrayList.add(localGroups2);
        localObject1 = localFriendsManager.a(String.valueOf(localGroups2.group_id));
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          localArrayList2 = new ArrayList(((List)localObject1).size());
          Iterator localIterator2 = ((List)localObject1).iterator();
          localObject2 = null;
          j = 0;
          if (!localIterator2.hasNext()) {
            break label556;
          }
          localObject3 = (Entity)localIterator2.next();
          localFriends = (Friends)localObject3;
          k = ContactUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localFriends.uin);
          if ((localObject4 == null) || (((SpecialCareInfo)localObject4).globalSwitch == 0)) {
            break label695;
          }
          localArrayList1.add(BuddyItemBuilder.a(4, (Entity)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
          if ((k == 0) || (k == 6)) {
            break label695;
          }
          i += 1;
        }
      }
      for (;;)
      {
        if (((Friends)localObject3).gathtertype == 1)
        {
          break label286;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("BuddyListAdapter", 2, "FriendManager is null");
          localObject1 = localObject2;
          break;
          localObject2 = "empty";
          break label140;
          localObject1 = new ArrayList((Collection)localObject1);
          break label255;
        }
        if ((k != 0) && (k != 6)) {
          j += 1;
        }
        for (;;)
        {
          for (;;)
          {
            localObject3 = BuddyItemBuilder.a(0, (Entity)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
            ((BuddyListItem)localObject3).a(this);
            try
            {
              localObject4 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
              boolean bool = localFriends.uin.equals(localObject4);
              if (bool) {
                localObject2 = localObject3;
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              localArrayList2.add(localObject3);
            }
          }
          break label286;
          a(localArrayList2);
          if (localObject2 != null) {
            localArrayList2.add(0, localObject2);
          }
          paramSparseIntArray.put(localGroups2.group_id, j);
          paramSparseArray.put(localGroups2.group_id, localArrayList2);
          if (QLog.isColorLevel()) {
            QLog.d("BuddyListAdapter", 2, "groupId: " + localGroups2.group_id + " num: " + ((List)localObject1).size());
          }
          break;
          a(localArrayList1);
          paramSparseIntArray.put(1004, i);
          paramSparseArray.put(1004, localArrayList1);
          localGroups1.group_friend_count = localArrayList1.size();
          return;
        }
      }
    }
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
      while (!QLog.isColorLevel()) {}
      QLog.d("BuddyListAdapter", 2, "", paramList);
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
    int k = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getString("700_sp_key_last_expanded", "700_sp_key_last_expanded");
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "readExpand=" + (String)localObject);
    }
    HashSet localHashSet = new HashSet();
    int i;
    if (((String)localObject).equalsIgnoreCase("700_sp_key_last_expanded"))
    {
      i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (getGroupType(i) == 0)
        {
          localObject = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (((Groups)localObject).group_friend_count > 0) {
            localHashSet.add(Integer.valueOf(((Groups)localObject).group_id));
          }
        }
      }
      else
      {
        i = k;
        if (localHashSet.size() == 0)
        {
          this.jdField_c_of_type_Boolean = true;
          i = k;
        }
      }
    }
    int m;
    int j;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((getGroupType(i) == 0) && (localHashSet.contains(Integer.valueOf(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i)).group_id)))) {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
        }
        i += 1;
        continue;
        i += 1;
        break;
        i = k;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("_");
          m = localObject.length;
          j = 0;
        }
      }
    }
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      String str = localObject[j];
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str)));
        label290:
        j += 1;
        continue;
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label290;
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
    while (i < j)
    {
      if (getGroupType(i) == 0)
      {
        Groups localGroups = (Groups)getGroup(i);
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i))
        {
          localStringBuffer.append(localGroups.group_id);
          localStringBuffer.append("_");
        }
      }
      i += 1;
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "saveExpanded=" + localStringBuffer.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putString("700_sp_key_last_expanded", localStringBuffer.toString()).commit();
  }
  
  String a(Friends paramFriends, BuddyListFriends.BuddyChildTag paramBuddyChildTag)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null)) {
      return null;
    }
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramFriends.uin);
    Object localObject = null;
    boolean bool;
    label65:
    int j;
    label98:
    int k;
    if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent)))
    {
      i = 1;
      if (localExtensionInfo != null)
      {
        if (this.jdField_b_of_type_Int == 0) {
          break label285;
        }
        bool = true;
        localObject = ExtensionRichStatus.a(localExtensionInfo, bool);
      }
      if ((localObject == null) || (localObject == RichStatus.getEmptyStatus()) || (((RichStatus)localObject).isEmpty())) {
        break label291;
      }
      j = 1;
      if ((j == 0) || (TextUtils.isEmpty(((RichStatus)localObject).actionText))) {
        break label297;
      }
      k = 1;
      label117:
      if ((i == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (j != 0))) {
        break label413;
      }
      paramFriends = new String(localExtensionInfo.feedContent);
      paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      if (localExtensionInfo.feedType != 2) {
        break label322;
      }
      paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
        break label303;
      }
      QQStoryCoverImageViewHelper.a(paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView, localExtensionInfo.feedPhotoUrl, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130850687));
    }
    for (;;)
    {
      paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      localObject = null;
      if (localExtensionInfo == null)
      {
        paramBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
      paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramFriends);
      return paramFriends;
      i = 0;
      break;
      label285:
      bool = false;
      break label65;
      label291:
      j = 0;
      break label98;
      label297:
      k = 0;
      break label117;
      label303:
      paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850687));
    }
    label322:
    paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    localObject = paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView;
    if (localExtensionInfo.feedType == 1)
    {
      i = 2130849987;
      label349:
      ((ImageView)localObject).setBackgroundResource(i);
      localObject = paramBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView;
      if (!localExtensionInfo.feedHasPhoto) {
        break label407;
      }
    }
    label407:
    for (int i = 0;; i = 8)
    {
      ((URLImageView)localObject).setVisibility(i);
      paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      localObject = null;
      break;
      i = 2130849985;
      break label349;
    }
    label413:
    if (k != 0)
    {
      ((RichStatus)localObject).enableSummaryCached = paramFriends.isFriend();
      paramFriends = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(((RichStatus)localObject).actionId, 200);
      paramFriends = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), paramFriends);
      i = this.jdField_c_of_type_Int;
      paramFriends.setBounds(0, 0, Math.round(paramFriends.getIntrinsicWidth() * 1.0F / paramFriends.getIntrinsicHeight() * i), i);
      paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramFriends, null);
    }
    for (;;)
    {
      String str = ((RichStatus)localObject).getActionAndData();
      paramFriends = ((RichStatus)localObject).getPlainText();
      paramBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      localObject = str;
      break;
      if (j == 0)
      {
        localObject = RichStatus.getEmptyStatus();
        paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      }
    }
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
    if (!(paramView.getTag() instanceof BuddyListAdapter.GroupTag))
    {
      localObject = new BuddyListAdapter.GroupTag();
      ((BuddyListAdapter.GroupTag)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369653));
      ((BuddyListAdapter.GroupTag)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131368102));
      ((BuddyListAdapter.GroupTag)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      ((BuddyListAdapter.GroupTag)localObject).jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131380558));
      ((BuddyListAdapter.GroupTag)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365230));
      ((BuddyListAdapter.GroupTag)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      ((BuddyListAdapter.GroupTag)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369760));
      paramView.setTag(localObject);
    }
    for (paramView = (View)localObject;; paramView = (BuddyListAdapter.GroupTag)paramView.getTag())
    {
      a(paramView, localGroups, paramInt, true, 0);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTypeface(Typeface.SANS_SERIF);
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131167117);
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
    long l2 = 0L;
    if ((localObject instanceof Friends)) {
      localObject = (Friends)localObject;
    }
    do
    {
      long l1;
      do
      {
        try
        {
          l1 = Long.parseLong(((Friends)localObject).uin);
          return l1;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable1));
            }
            l1 = 0L;
          }
        }
        if ((localThrowable1 instanceof PublicAccountInfo)) {
          return ((PublicAccountInfo)localThrowable1).uin;
        }
        l1 = l2;
      } while (!(localThrowable1 instanceof PhoneContact));
      PhoneContact localPhoneContact = (PhoneContact)localThrowable1;
      try
      {
        l1 = Long.parseLong(localPhoneContact.mobileNo);
        return l1;
      }
      catch (Throwable localThrowable2)
      {
        l1 = l2;
      }
    } while (!QLog.isColorLevel());
    QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable2));
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
    if (localBuddyListItem == null) {}
    for (paramView = null;; paramView = localBuddyListItem.a(paramInt1, paramInt2, paramView, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener))
    {
      if (paramView != null)
      {
        a((BuddyListItem.ViewTag)paramView.getTag(), null);
        if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        paramView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$ItemLongClickListener);
      }
      TraceUtils.traceEnd();
      return paramView;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (getGroupType(paramInt) == 1) {
      return 0;
    }
    paramInt = ((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).group_id;
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localList == null) {}
    for (paramInt = 0;; paramInt = localList.size()) {
      return paramInt;
    }
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
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      QLog.e("BuddyListAdapter", 1, "getGroupType illegal, groupPosition =" + paramInt + ", size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    while ((this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof String)) {
      return 1;
    }
    return 0;
  }
  
  public int getGroupTypeCount()
  {
    return 2;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    int i = 1;
    if (getGroupType(paramInt) == 1)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131559021, paramViewGroup, false);
        paramViewGroup = (SingleLineTextView)paramView.findViewById(2131380316);
        paramViewGroup.setDefaultTextColor(-8355712);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject = (String)getGroup(paramInt);
        paramViewGroup.setText("");
        return paramView;
        paramViewGroup = (SingleLineTextView)paramView.getTag();
      }
    }
    Object localObject = (Groups)getGroup(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131559024, paramViewGroup, false);
      paramViewGroup = new BuddyListAdapter.GroupTag();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131368102));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369653));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365230));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369760));
      paramViewGroup.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131380558));
      paramView.setTag(paramViewGroup);
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break label294;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$ItemClickListener);
      paramView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$ItemLongClickListener);
      if (paramBoolean) {
        i = 2;
      }
      a(paramViewGroup, (Groups)localObject, paramInt, false, i);
      return paramView;
      paramViewGroup = (BuddyListAdapter.GroupTag)paramView.getTag();
      break;
      label294:
      ColorStateList localColorStateList = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131167117);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(localColorStateList);
    }
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131559024;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.c(paramBoolean);
      return;
    }
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
    BuddyListAdapter.GroupTag localGroupTag = (BuddyListAdapter.GroupTag)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(localGroupTag.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(localGroupTag.jdField_a_of_type_Int);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(localGroupTag.jdField_a_of_type_Int);
      ((QzoneContactsFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_CONTACTS_FEED_MANAGER)).a();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = paramView.getTag();
      if (localObject1 != null) {
        if ((localObject1 instanceof BuddyListAdapter.GroupTag))
        {
          localObject1 = new QQCustomMenu();
          ((QQCustomMenu)localObject1).a(0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693131));
          BubbleContextMenu.a(paramView, (QQCustomMenu)localObject1, this.jdField_b_of_type_AndroidViewView$OnClickListener, null);
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      return bool1;
      if (!(localObject1 instanceof BuddyListItem.ViewTag)) {
        break;
      }
      Object localObject2 = ((BuddyListItem.ViewTag)localObject1).jdField_a_of_type_JavaLangObject;
      if ((localObject2 == null) || (!(localObject2 instanceof Friends))) {
        break;
      }
      paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject2 = (Friends)localObject2;
      localObject1 = ((FriendsManager)localObject1).a(((Friends)localObject2).uin);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(((Friends)localObject2).uin))
      {
        bool1 = bool2;
        if (localObject1 != null)
        {
          if (((SpecialCareInfo)localObject1).globalSwitch == 0) {
            bool1 = bool2;
          }
        }
        else {
          label189:
          if (!bool1) {
            break label241;
          }
        }
        label241:
        for (int i = 2131691169;; i = 2131691170)
        {
          for (;;)
          {
            paramView.addButton(i);
            paramView.addCancelButton(2131690800);
            paramView.setOnButtonClickListener(new BuddyListAdapter.2(this, bool1, (Friends)localObject2, paramView));
            try
            {
              paramView.show();
            }
            catch (Exception paramView) {}
          }
          break;
          bool1 = true;
          break label189;
        }
        bool1 = false;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
      }
      if (paramInt != 0) {
        ApngImage.pauseByTag(3);
      }
      if (paramInt == 0) {
        ApngImage.playByTag(3);
      }
      return;
      DropFrameMonitor.a().a("list_g_contacts");
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
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */