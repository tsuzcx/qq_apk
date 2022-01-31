package com.tencent.mobileqq.adapter;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
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
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.adapter.contacts.BuddyItemBuilder;
import com.tencent.mobileqq.adapter.contacts.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem.BuddyListCallback;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem.ViewTag;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import ydn;
import ydp;
import ydq;
import ydr;
import yds;
import ydt;
import ydu;

public class BuddyListAdapter
  extends SwipFacePreloadExpandableAdapter
  implements View.OnClickListener, View.OnLongClickListener, BuddyListItem.BuddyListCallback, SwipPinnedHeaderExpandableListView.SwipListListener
{
  private static final ydu jdField_a_of_type_Ydu = new ydu(null);
  public int a;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private SimpleTextView jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
  public final BaseActivity a;
  private final FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  private final StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private yds jdField_a_of_type_Yds = new yds(this);
  private ydt jdField_a_of_type_Ydt = new ydt(this);
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new ydr(this);
  private SimpleTextView jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView;
  private final boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int d = -1;
  
  public BuddyListAdapter(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SwipPinnedHeaderExpandableListView paramSwipPinnedHeaderExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramBaseActivity, paramQQAppInterface, paramSwipPinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(10));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(166));
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
    if (AppSetting.jdField_b_of_type_Boolean)
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
        break label362;
      }
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText(paramInt1 + "");
      if (AppSetting.jdField_b_of_type_Boolean) {
        ((StringBuilder)localObject1).append("共" + paramInt1 + "个常用群聊");
      }
      if (paramInt2 != 0) {
        break label534;
      }
      if (!this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramGroupTag.jdField_a_of_type_Int)) {
        break label469;
      }
      paramInt1 = 2;
    }
    for (;;)
    {
      label237:
      localObject2 = paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox;
      boolean bool;
      if (paramInt1 == 2)
      {
        bool = true;
        label251:
        ((CheckBox)localObject2).setChecked(bool);
        if (AppSetting.jdField_b_of_type_Boolean)
        {
          if (!paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label480;
          }
          ((StringBuilder)localObject1).append(" 已展开");
        }
      }
      for (;;)
      {
        paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setContentDescription(((StringBuilder)localObject1).toString());
        AccessibilityUtil.a(paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox, false);
        if ((paramGroups.group_id != 1002) || (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c() != this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c())) {
          break label501;
        }
        if (!paramBoolean) {
          break label492;
        }
        this.jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
        return;
        ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
        localObject1 = localObject2;
        break;
        label362:
        SimpleTextView localSimpleTextView = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
        if (this.jdField_b_of_type_Boolean) {}
        for (localObject2 = "%d / %d";; localObject2 = "%d/%d")
        {
          localSimpleTextView.setText(String.format((String)localObject2, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) }));
          if (!AppSetting.jdField_b_of_type_Boolean) {
            break;
          }
          ((StringBuilder)localObject1).append("在线" + i + "人，共" + paramInt1 + "人");
          break;
        }
        label469:
        paramInt1 = 1;
        break label237;
        bool = false;
        break label251;
        label480:
        ((StringBuilder)localObject1).append(" 已折叠");
      }
      label492:
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
      return;
      label501:
      if (this.jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView == paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView) {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView != paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = null;
      return;
      label534:
      paramInt1 = paramInt2;
    }
  }
  
  private void a(ArrayList paramArrayList, SparseArray paramSparseArray, SparseIntArray paramSparseIntArray)
  {
    Groups localGroups = new Groups();
    localGroups.group_id = 1004;
    localGroups.group_name = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436844);
    localGroups.group_friend_count = 1;
    localGroups.seqid = 0;
    paramArrayList.add(localGroups);
    ArrayList localArrayList1 = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
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
            break label517;
          }
          localObject2 = "null";
          label139:
          QLog.d("BuddyListAdapter", 2, (String)localObject2);
        }
        if (localObject1 != null) {
          break label667;
        }
        localObject1 = new ArrayList();
      }
    }
    label517:
    label664:
    label667:
    for (;;)
    {
      paramArrayList.remove(localGroups);
      localObject2 = localObject1;
      localObject2 = ((List)localObject2).iterator();
      int i = 0;
      label193:
      label254:
      ArrayList localArrayList2;
      int k;
      int j;
      label290:
      Object localObject4;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Groups)((Iterator)localObject2).next();
        paramArrayList.add(localObject3);
        localObject1 = localFriendsManager.a(String.valueOf(((Groups)localObject3).group_id));
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          localArrayList2 = new ArrayList(((List)localObject1).size());
          Iterator localIterator = ((List)localObject1).iterator();
          k = 0;
          j = i;
          i = k;
          while (localIterator.hasNext())
          {
            localObject4 = (Entity)localIterator.next();
            Object localObject5 = (Friends)localObject4;
            int m = ContactUtils.a(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType);
            localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((Friends)localObject5).uin);
            k = j;
            if (localObject5 != null)
            {
              k = j;
              if (((SpecialCareInfo)localObject5).globalSwitch != 0)
              {
                localArrayList1.add(BuddyItemBuilder.a(4, (Entity)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
                k = j;
                if (m != 0)
                {
                  k = j;
                  if (m != 6) {
                    k = j + 1;
                  }
                }
              }
            }
            j = k;
            if (((Friends)localObject4).gathtertype != 1)
            {
              if ((m == 0) || (m == 6)) {
                break label664;
              }
              i += 1;
            }
          }
        }
      }
      for (;;)
      {
        localObject4 = BuddyItemBuilder.a(0, (Entity)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((BuddyListItem)localObject4).a(this);
        localArrayList2.add(localObject4);
        j = k;
        break label290;
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BuddyListAdapter", 2, "FriendManager is null");
        localObject1 = localObject2;
        break;
        localObject2 = "empty";
        break label139;
        localObject1 = new ArrayList((Collection)localObject1);
        break label254;
        a(localArrayList2);
        paramSparseIntArray.put(((Groups)localObject3).group_id, i);
        paramSparseArray.put(((Groups)localObject3).group_id, localArrayList2);
        if (QLog.isColorLevel()) {
          QLog.d("BuddyListAdapter", 2, "groupId: " + ((Groups)localObject3).group_id + " num: " + ((List)localObject1).size());
        }
        i = j;
        break label193;
        a(localArrayList1);
        paramSparseIntArray.put(1004, i);
        paramSparseArray.put(1004, localArrayList1);
        localGroups.group_friend_count = localArrayList1.size();
        return;
      }
    }
  }
  
  private void a(List paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_Ydu);
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
        if ((TextUtils.isEmpty(((BuddyListFriends.BuddyChildTag)localObject).jdField_b_of_type_ComTencentWidgetSingleLineTextView.a().toString())) && ((((BuddyListFriends.BuddyChildTag)localObject).a instanceof Friends))) {
          a((Friends)((BuddyListFriends.BuddyChildTag)localObject).a, (BuddyListFriends.BuddyChildTag)localObject);
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
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
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
  
  private void g()
  {
    ThreadManager.post(new ydp(this), 5, null, true);
  }
  
  private void h()
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
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(i))
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
  
  public int a()
  {
    return 2130968808;
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
          break label268;
        }
        bool = true;
        localObject = localExtensionInfo.getRichStatus(bool);
      }
      if ((localObject == null) || (localObject == RichStatus.getEmptyStatus()) || (((RichStatus)localObject).isEmpty())) {
        break label274;
      }
      j = 1;
      if ((j == 0) || (TextUtils.isEmpty(((RichStatus)localObject).actionText))) {
        break label280;
      }
      k = 1;
      label117:
      if ((i == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (j != 0))) {
        break label299;
      }
      paramFriends = new String(localExtensionInfo.feedContent);
      paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView;
      if (localExtensionInfo.feedType != 1) {
        break label286;
      }
      i = 2130845332;
      label189:
      ((ImageView)localObject).setBackgroundResource(i);
      localObject = paramBuddyChildTag.c;
      if (!localExtensionInfo.feedHasPhoto) {
        break label293;
      }
    }
    label268:
    label274:
    label280:
    label286:
    label293:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      localObject = null;
      if (localExtensionInfo == null)
      {
        paramBuddyChildTag.c.setVisibility(8);
        paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
      paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramFriends);
      return paramFriends;
      i = 0;
      break;
      bool = false;
      break label65;
      j = 0;
      break label98;
      k = 0;
      break label117;
      i = 2130845330;
      break label189;
    }
    label299:
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
      paramBuddyChildTag.c.setVisibility(8);
      paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
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
  
  public void a(View paramView)
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
  
  public void a(View paramView, int paramInt)
  {
    Groups localGroups = (Groups)getGroup(paramInt);
    BuddyListAdapter.GroupTag localGroupTag;
    if (!(paramView.getTag() instanceof BuddyListAdapter.GroupTag))
    {
      localGroupTag = new BuddyListAdapter.GroupTag();
      localGroupTag.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131363817));
      localGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131363819));
      localGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      localGroupTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131363821));
      localGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131363820));
      localGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setDefaultTextColor(1711276032);
      localGroupTag.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131363818));
      paramView.setTag(localGroupTag);
    }
    for (;;)
    {
      a(localGroupTag, localGroups, paramInt, true, 0);
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break;
      }
      paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131493363));
      localGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundResource(2130838655);
      return;
      localGroupTag = (BuddyListAdapter.GroupTag)paramView.getTag();
    }
    paramView.setBackgroundResource(2130845737);
    localGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundResource(2130838654);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    super.a(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      d();
      DropFrameMonitor.a().a("list_g_contacts", false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
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
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.b(paramBoolean);
      return;
    }
  }
  
  public boolean a(View paramView)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if ((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag))
    {
      paramView = (BuddyListFriends.BuddyChildTag)paramView.getTag();
      if ((paramView.a instanceof Friends))
      {
        paramView = (Friends)paramView.a;
        if ((paramView.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (Utils.b(paramView.uin))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    h();
    g();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c() {}
  
  public void f()
  {
    h();
    g();
    super.f();
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
    TraceUtils.a("getChildView");
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
        paramView.setOnLongClickListener(this.jdField_a_of_type_Ydt);
      }
      TraceUtils.a();
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
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {}
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
    Object localObject;
    if (getGroupType(paramInt) == 1)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130968805, paramViewGroup, false);
        paramViewGroup = (SingleLineTextView)paramView.findViewById(2131363815);
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
    Groups localGroups = (Groups)getGroup(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130968808, paramViewGroup, false);
      paramViewGroup = new BuddyListAdapter.GroupTag();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131363819));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131363817));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131363820));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131363818));
      paramViewGroup.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131363821));
      paramView.setTag(paramViewGroup);
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break label325;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131494261);
      paramView.setBackgroundResource(2130838665);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundResource(2130838655);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor((ColorStateList)localObject);
      paramView.setOnClickListener(this.jdField_a_of_type_Yds);
      paramView.setOnLongClickListener(this.jdField_a_of_type_Ydt);
      if (paramBoolean) {
        i = 2;
      }
      a(paramViewGroup, localGroups, paramInt, false, i);
      return paramView;
      paramViewGroup = (BuddyListAdapter.GroupTag)paramView.getTag();
      break;
      label325:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131494260);
      paramView.setBackgroundResource(2130838579);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundResource(2130838654);
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "notifyDataSetChanged");
    }
    ThreadManager.postImmediately(new ydn(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    paramView = (BuddyListAdapter.GroupTag)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramView.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(paramView.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(paramView.jdField_a_of_type_Int);
    ((QzoneContactsFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(90)).a();
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject1 = paramView.getTag();
      if (localObject1 != null)
      {
        if ((localObject1 instanceof BuddyListAdapter.GroupTag))
        {
          localObject1 = new QQCustomMenu();
          ((QQCustomMenu)localObject1).a(0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131435519));
          BubbleContextMenu.a(paramView, (QQCustomMenu)localObject1, this.jdField_b_of_type_AndroidViewView$OnClickListener, null);
        }
        do
        {
          do
          {
            return true;
          } while (!(localObject1 instanceof BuddyListItem.ViewTag));
          localObject2 = ((BuddyListItem.ViewTag)localObject1).a;
        } while ((localObject2 == null) || (!(localObject2 instanceof Friends)));
        paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
        localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        Object localObject2 = (Friends)localObject2;
        localObject1 = ((FriendsManager)localObject1).a(((Friends)localObject2).uin);
        boolean bool1 = bool2;
        if (localObject1 != null)
        {
          if (((SpecialCareInfo)localObject1).globalSwitch == 0) {
            bool1 = bool2;
          }
        }
        else {
          label166:
          if (!bool1) {
            break label218;
          }
        }
        label218:
        for (int i = 2131433297;; i = 2131433296)
        {
          for (;;)
          {
            paramView.b(i);
            paramView.c(2131432998);
            paramView.a(new ydq(this, bool1, (Friends)localObject2, paramView));
            try
            {
              paramView.show();
            }
            catch (Exception paramView) {}
          }
          break;
          bool1 = true;
          break label166;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */