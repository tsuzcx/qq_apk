package com.tencent.mobileqq.activity.contacts.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.adapter.BuddyListAdapter.GroupTag;
import com.tencent.mobileqq.adapter.SwipFacePreloadExpandableAdapter;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItemWithMask;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem.ViewTag;
import com.tencent.mobileqq.adapter.contacts.BuddyListTroop.TroopDisChildTag;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import wma;
import wmb;
import wmc;
import wmd;
import wmf;
import wmg;
import wmi;
import wmj;
import wmk;

public class ContactsTroopAdapter
  extends SwipFacePreloadExpandableAdapter
  implements View.OnClickListener, View.OnLongClickListener, ExpandableListView.OnGroupClickListener, SwipPinnedHeaderExpandableListView.SwipListListener
{
  public int a;
  public Context a;
  protected DiscussionManager a;
  public QQAppInterface a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new wmk(this);
  protected SwipTextViewMenuBuilder a;
  public HashSet a;
  public List a;
  private boolean jdField_a_of_type_Boolean = true;
  public int[] a;
  private int b;
  public List b;
  protected int[] b;
  private int c;
  public List c;
  protected int[] c;
  public List d = new ArrayList();
  public List e = new ArrayList();
  public List f = new ArrayList();
  public List g = new ArrayList();
  
  public ContactsTroopAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(4);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(5);
    this.jdField_a_of_type_Int = -2;
    this.jdField_a_of_type_ArrayOfInt = new int[6];
    this.jdField_b_of_type_ArrayOfInt = new int[6];
    this.jdField_c_of_type_ArrayOfInt = new int[6];
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = ((int)(paramContext.getResources().getDisplayMetrics().density * 56.0F));
    this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131559316);
    this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder = new wma(this, 1, 1, new int[] { paramContext.getResources().getDimensionPixelSize(2131558645) }, -1, new int[] { 2131370009, 2131370009 }, new int[] { 2131435388, 2131435389 }, new int[] { 2130838683, 2130838683 });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(52));
  }
  
  private int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return 0;
    }
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return 0;
    case 0: 
      return 0;
    case 4: 
      return 1;
    case 6: 
      return 2;
    case 2: 
      return 3;
    case 10: 
      return 4;
    }
    return 5;
  }
  
  private int a(List paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      TroopListAdapter2.TroopListItemWithMask localTroopListItemWithMask = (TroopListAdapter2.TroopListItemWithMask)paramList.next();
      if ((localTroopListItemWithMask.a == null) || (!(localTroopListItemWithMask.a instanceof TroopInfo)) || (((TroopInfo)localTroopListItemWithMask.a).lastMsgTime <= 0L)) {
        break label69;
      }
      i += 1;
    }
    label69:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private Entity a(int paramInt1, int paramInt2)
  {
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return null;
    case 0: 
      return (Entity)this.jdField_b_of_type_JavaUtilList.get(paramInt2);
    case 4: 
      return ((TroopListAdapter2.TroopListItemWithMask)this.jdField_c_of_type_JavaUtilList.get(paramInt2)).a;
    case 6: 
      return ((TroopListAdapter2.TroopListItemWithMask)this.d.get(paramInt2)).a;
    case 2: 
      return ((TroopListAdapter2.TroopListItemWithMask)this.e.get(paramInt2)).a;
    case 8: 
      return ((TroopListAdapter2.TroopListItemWithMask)this.f.get(paramInt2)).a;
    }
    return ((TroopListAdapter2.TroopListItemWithMask)this.g.get(paramInt2)).a;
  }
  
  private void a(int paramInt)
  {
    int j = 0;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
    int i;
    label107:
    int k;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
      if (j <= 10)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
        if (j > 10) {
          break label286;
        }
        k = j;
      }
      break;
    }
    for (;;)
    {
      this.jdField_b_of_type_ArrayOfInt[paramInt] = k;
      this.jdField_c_of_type_ArrayOfInt[paramInt] = (j - k);
      return;
      j = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      i = 0;
      break;
      j = this.jdField_c_of_type_JavaUtilList.size();
      i = a(this.jdField_c_of_type_JavaUtilList);
      break;
      j = this.d.size();
      i = a(this.d);
      break;
      j = this.e.size();
      i = a(this.e);
      break;
      j = this.f.size();
      i = a(this.f);
      break;
      j = this.g.size();
      i = a(this.g);
      break;
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 0) {
        break label107;
      }
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
      break label107;
      label286:
      k = i;
      if (i < 10) {
        k = 10;
      }
    }
  }
  
  private void a(BuddyListAdapter.GroupTag paramGroupTag)
  {
    int k = 0;
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      i = 0;
      if (!this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(i)) {
        break label100;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(i);
      this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(i));
      i = k;
    }
    for (;;)
    {
      if (i >= this.jdField_a_of_type_ArrayOfInt.length) {
        return;
      }
      if (this.jdField_a_of_type_ArrayOfInt[i] == 2) {
        this.jdField_a_of_type_ArrayOfInt[i] = 1;
      }
      i += 1;
      continue;
      i = paramGroupTag.jdField_a_of_type_Int;
      break;
      label100:
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(j))
        {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(j);
          this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(j));
        }
        j += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
      i = k;
    }
  }
  
  private void a(BuddyListAdapter.GroupTag paramGroupTag, int paramInt, boolean paramBoolean)
  {
    int i;
    String str1;
    int j;
    int k;
    label117:
    String str2;
    label131:
    label187:
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (paramGroupTag != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
      switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
      {
      case 1: 
      case 3: 
      case 5: 
      case 7: 
      case 9: 
      default: 
        i = 0;
        str1 = "";
        j = 0;
        if (j <= 10)
        {
          k = j;
          if (j > 10) {
            break label588;
          }
          this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
          this.jdField_b_of_type_ArrayOfInt[paramInt] = k;
          this.jdField_c_of_type_ArrayOfInt[paramInt] = (j - k);
          if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 1) {
            break label607;
          }
          str2 = k + "/" + j;
          localStringBuilder1 = paramGroupTag.jdField_a_of_type_JavaLangStringBuilder;
          localStringBuilder2 = localStringBuilder1;
          if (AppSetting.b)
          {
            if (localStringBuilder1 != null) {
              break label632;
            }
            localStringBuilder1 = new StringBuilder(24);
            label219:
            localStringBuilder1.append(str1 + " 分组");
            localStringBuilder2 = localStringBuilder1;
          }
          paramGroupTag.jdField_a_of_type_Int = paramInt;
          paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str1);
          paramGroupTag.b.setVisibility(8);
          paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText(str2);
          if (AppSetting.b) {
            localStringBuilder2.append("共" + j + "个" + str1);
          }
          paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
          if (AppSetting.b)
          {
            if (!paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label647;
            }
            localStringBuilder2.append(" 已展开");
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setContentDescription(localStringBuilder2.toString());
      AccessibilityUtil.a(paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox, false);
      return;
      j = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      str1 = "置顶群聊";
      i = 0;
      break;
      str1 = "我创建的群聊";
      j = this.jdField_c_of_type_JavaUtilList.size();
      i = a(this.jdField_c_of_type_JavaUtilList);
      break;
      str1 = "我管理的群聊";
      j = this.d.size();
      i = a(this.d);
      break;
      str1 = "我加入的群聊";
      j = this.e.size();
      i = a(this.e);
      break;
      str1 = "未命名的群聊";
      j = this.f.size();
      i = a(this.f);
      break;
      str1 = "我的隐私群";
      j = this.g.size();
      i = a(this.g);
      break;
      k = i;
      if (i >= 10) {
        break label117;
      }
      k = 10;
      break label117;
      label588:
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 0) {
        break label131;
      }
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
      break label131;
      label607:
      str2 = "" + j;
      break label187;
      label632:
      localStringBuilder1.delete(0, localStringBuilder1.length());
      break label219;
      label647:
      localStringBuilder2.append(" 已折叠");
    }
  }
  
  private void a(BuddyListTroop.TroopDisChildTag paramTroopDisChildTag, DiscussionInfo paramDiscussionInfo)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
    localIntent.putExtra("uin", paramDiscussionInfo.uin);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramDiscussionInfo.discussionName);
    localIntent.putExtra("open_chatfragment_withanim", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    int i;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramTroopDisChildTag.jdField_b_of_type_Int)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
    }
    for (;;)
    {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramDiscussionInfo.uin, String.valueOf(i) }).a();
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 > 0) && (paramInt1 < this.jdField_b_of_type_ArrayOfInt.length) && (paramInt2 > this.jdField_b_of_type_ArrayOfInt[paramInt1]);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "only one group");
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(0);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getString("700_sp_key_last_troop_expanded", "700_sp_key_last_troop_expanded");
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "readExpand=" + (String)localObject);
    }
    HashSet localHashSet = new HashSet();
    label170:
    int i;
    label172:
    int j;
    if (((String)localObject).equalsIgnoreCase("700_sp_key_last_troop_expanded")) {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
        i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size()) {
          if (localHashSet.contains(this.jdField_a_of_type_JavaUtilList.get(i)))
          {
            this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
            if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
              break label429;
            }
            j = 0;
          }
        }
      }
    }
    for (;;)
    {
      if ((i > 0) && (i < this.jdField_a_of_type_ArrayOfInt.length)) {
        a(i);
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
      if ((i < this.jdField_a_of_type_ArrayOfInt.length) && (this.jdField_a_of_type_ArrayOfInt[i] == 1) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(j)))
      {
        j = a(i);
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(j) }).a();
      }
      i += 1;
      break label172;
      break;
      this.jdField_a_of_type_Boolean = true;
      break label170;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label170;
      }
      localObject = ((String)localObject).split("_");
      j = localObject.length;
      i = 0;
      label396:
      if (i >= j) {
        break label170;
      }
      String str = localObject[i];
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str)));
        label422:
        i += 1;
        break label396;
        label429:
        j = i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label422;
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      localStringBuffer = new StringBuffer();
      localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        localStringBuffer.append((Integer)localIterator.next());
        localStringBuffer.append("_");
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "saveExpanded=" + localStringBuffer.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putString("700_sp_key_last_troop_expanded", localStringBuffer.toString()).commit();
    }
    while (!QLog.isColorLevel())
    {
      StringBuffer localStringBuffer;
      Iterator localIterator;
      return;
    }
    QLog.d("ContactsTroopAdapter", 2, "less than 1 group : don't saveExpanded");
  }
  
  private void i()
  {
    ThreadManager.post(new wmg(this, (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()), 8, null, true);
  }
  
  public int a()
  {
    return 2130968808;
  }
  
  public void a()
  {
    h();
  }
  
  public void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem, Object paramObject)
  {
    int i = 1;
    if ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0)) {}
    label97:
    for (;;)
    {
      return;
      if (paramArrayOfSwipRightMenuItem.length < 0) {
        if ((paramObject instanceof TroopInfo))
        {
          paramObject = (TroopInfo)paramObject;
          if (this.jdField_b_of_type_JavaUtilList.contains(paramObject))
          {
            paramInt = 1;
            paramArrayOfSwipRightMenuItem[0].jdField_b_of_type_Int = paramInt;
            paramArrayOfSwipRightMenuItem[0].jdField_a_of_type_Int = 0;
            paramInt = i;
          }
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfSwipRightMenuItem.length) {
          break label97;
        }
        paramArrayOfSwipRightMenuItem[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfSwipRightMenuItem[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
        continue;
        paramInt = 0;
        break;
        paramInt = 0;
      }
    }
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
    if (paramView == null) {}
    while (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      return;
    }
    BuddyListAdapter.GroupTag localGroupTag;
    if (!(paramView.getTag() instanceof BuddyListAdapter.GroupTag))
    {
      localGroupTag = new BuddyListAdapter.GroupTag();
      localGroupTag.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131363840));
      localGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131363842));
      localGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      localGroupTag.b = ((SingleLineTextView)paramView.findViewById(2131363844));
      localGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131363843));
      localGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setDefaultTextColor(1711276032);
      localGroupTag.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131363841));
      paramView.setTag(localGroupTag);
    }
    for (;;)
    {
      a(localGroupTag, paramInt, this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramInt));
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break;
      }
      paramView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493366));
      localGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundResource(2130838659);
      return;
      localGroupTag = (BuddyListAdapter.GroupTag)paramView.getTag();
    }
    paramView.setBackgroundResource(2130845865);
    localGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundResource(2130838658);
  }
  
  public void a(View paramView, int paramInt, BuddyListItem.ViewTag paramViewTag, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder != null) {}
    for (int i = this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, paramObject, paramViewTag, paramOnClickListener);; i = 0)
    {
      if (this.jdField_a_of_type_Int != -1)
      {
        if (paramInt != this.jdField_a_of_type_Int) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
  }
  
  public void a(TroopInfo paramTroopInfo, RecentUserProxy paramRecentUserProxy)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = paramRecentUserProxy.a(paramTroopInfo.troopuin, 1).lastmsgtime;
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
    return true;
  }
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof BuddyListAdapter.GroupTag)) {
      a((BuddyListAdapter.GroupTag)paramExpandableListView);
    }
    return true;
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new wmf(this));
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    notifyDataSetChanged();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
      return;
    }
    int i = 0;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(i);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt2 == getChildrenCount(paramInt1) - 1) && (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1))
    {
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130971669, null);
      paramView = (TextView)((View)localObject1).findViewById(2131375306);
      paramViewGroup = "展示最近不活跃的群(" + this.jdField_c_of_type_ArrayOfInt[paramInt1] + ")";
      paramView.setText(paramViewGroup);
      ((View)localObject1).setOnClickListener(new wmb(this, paramInt1));
      ((View)localObject1).setOnTouchListener(new wmc(this, paramView));
      ((View)localObject1).setContentDescription(paramViewGroup + "按钮");
      if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        ((View)localObject1).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493366));
      }
    }
    Object localObject2;
    label521:
    label546:
    label607:
    label880:
    label890:
    do
    {
      do
      {
        return localObject1;
        ((View)localObject1).setBackgroundResource(2130838587);
        return localObject1;
        if ((paramView == null) || (!(paramView.getTag() instanceof BuddyListTroop.TroopDisChildTag)))
        {
          localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130971670, null);
          ((View)localObject1).setBackgroundResource(2130838587);
          ((View)localObject1).setMinimumHeight(this.jdField_b_of_type_Int);
          paramViewGroup = new BuddyListTroop.TroopDisChildTag();
          paramView = this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, (View)localObject1, paramViewGroup, -1);
          paramViewGroup.f = ((View)localObject1);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363896));
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363901));
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362719));
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365597));
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375307));
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375309));
          paramViewGroup.d = ((ImageView)paramView.findViewById(2131366587));
          localObject1 = paramView.getResources().getColorStateList(2131494219);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
          paramView.setTag(paramViewGroup);
          paramViewGroup.jdField_b_of_type_Int = paramInt1;
          localObject2 = a(paramInt1, paramInt2);
          if ((localObject2 == null) || (!(localObject2 instanceof TroopInfo))) {
            break label1071;
          }
          localObject2 = (TroopInfo)localObject2;
          paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
          paramViewGroup.jdField_a_of_type_JavaLangObject = localObject2;
          paramViewGroup.jdField_a_of_type_Int = 4;
          paramViewGroup.jdField_a_of_type_Boolean = a(paramInt1, paramInt2);
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject2).troopuin);
          if (i != 3) {
            break label839;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846076);
          TextView localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
          if (TextUtils.isEmpty(((TroopInfo)localObject2).getTroopName())) {
            break label880;
          }
          localObject1 = ((TroopInfo)localObject2).getTroopName();
          localTextView.setText((CharSequence)localObject1);
          if ((((TroopInfo)localObject2).hasSetTroopName()) || (((TroopInfo)localObject2).wMemberNumClient <= 0)) {
            break label890;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject2).wMemberNumClient) }));
          if (QLog.isColorLevel()) {
            QLog.d("ContactsTroopAdapter", 2, "TroopInfo hasSetTroopName:" + ((TroopInfo)localObject2).hasSetTroopName() + " | memberNum:" + ((TroopInfo)localObject2).wMemberNumClient);
          }
          if (((TroopInfo)localObject2).lastMsgTime != 0L) {
            break label903;
          }
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x800) == 0L) {
            break label1004;
          }
          if (((TroopInfo)localObject2).dwAuthGroupType != 2L) {
            break label958;
          }
          paramViewGroup.d.setVisibility(0);
          paramViewGroup.d.setBackgroundResource(2130841430);
          if (((TroopInfo)localObject2).troopCreditLevel != 2L) {
            break label1017;
          }
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846081);
        }
        for (;;)
        {
          if (AppSetting.b) {
            paramViewGroup.f.setContentDescription(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText());
          }
          a(paramViewGroup, null);
          paramView.setOnClickListener(this);
          paramView.setOnLongClickListener(this);
          a(paramView, paramInt1 << 16 | paramInt2, paramViewGroup, this, localObject2);
          return paramView;
          paramViewGroup = (BuddyListTroop.TroopDisChildTag)paramView.getTag();
          break;
          if (i == 1)
          {
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
            break label521;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838661);
          break label521;
          localObject1 = ((TroopInfo)localObject2).troopuin;
          break label546;
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label607;
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText("最近活跃：" + TimeManager.a().a(((TroopInfo)localObject2).troopuin, ((TroopInfo)localObject2).lastMsgTime));
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          break label678;
          if (((TroopInfo)localObject2).dwAuthGroupType == 1L)
          {
            paramViewGroup.d.setVisibility(0);
            paramViewGroup.d.setBackgroundResource(2130841430);
            break label724;
          }
          paramViewGroup.d.setVisibility(8);
          break label724;
          paramViewGroup.d.setVisibility(8);
          break label724;
          if (((TroopInfo)localObject2).troopCreditLevel == 1L)
          {
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846079);
          }
          else
          {
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
          }
        }
        localObject1 = paramView;
      } while (localObject2 == null);
      localObject1 = paramView;
    } while (!(localObject2 instanceof DiscussionInfo));
    label678:
    label724:
    label1004:
    label1017:
    Object localObject1 = (DiscussionInfo)localObject2;
    label839:
    paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject1).uin;
    label903:
    label958:
    paramViewGroup.jdField_a_of_type_JavaLangObject = localObject1;
    label1071:
    paramViewGroup.jdField_a_of_type_Int = 101;
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    paramViewGroup.d.setVisibility(8);
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionInfo)localObject1).discussionName);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject1).uin);
    if ((!((DiscussionInfo)localObject1).hasRenamed()) && (i > 0))
    {
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "DiscussionInfo hasRenamed:" + ((DiscussionInfo)localObject1).hasRenamed() + " | memberNum:" + i);
      }
      if (((DiscussionInfo)localObject1).lastMsgTime != 0L) {
        break label1369;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      if (AppSetting.b) {
        paramViewGroup.f.setContentDescription(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      a(paramViewGroup, null);
      paramView.setOnClickListener(this);
      paramView.setOnLongClickListener(this);
      a(paramView, paramInt1 << 16 | paramInt2, paramViewGroup, this, localObject1);
      return paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label1369:
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText("最近活跃：" + DatingUtil.a(((DiscussionInfo)localObject1).lastMsgTime, false));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      j = 0;
      return j;
    }
    int i;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
    }
    for (;;)
    {
      j = i;
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 1) {
        break;
      }
      j = i;
      if (this.jdField_b_of_type_ArrayOfInt[paramInt] >= i) {
        break;
      }
      return this.jdField_b_of_type_ArrayOfInt[paramInt] + 1;
      i = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      continue;
      i = this.jdField_c_of_type_JavaUtilList.size();
      continue;
      i = this.d.size();
      continue;
      i = this.e.size();
      continue;
      i = this.f.size();
      continue;
      i = this.g.size();
    }
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968808, paramViewGroup, false);
      paramViewGroup = new BuddyListAdapter.GroupTag();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131363842));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131363840));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131363843));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131363841));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131363844));
      paramView.setTag(paramViewGroup);
    }
    while (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
      paramViewGroup = (BuddyListAdapter.GroupTag)paramView.getTag();
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_c_of_type_Int));
    ColorStateList localColorStateList;
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false))
    {
      localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494268);
      paramView.setBackgroundResource(2130838669);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundResource(2130838659);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor(localColorStateList);
      a(paramViewGroup, paramInt, paramBoolean);
      paramView.setOnClickListener(this);
      return paramView;
      localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494267);
      paramView.setBackgroundResource(2130838583);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundResource(2130838658);
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b == null)
    {
      ThreadManager.postImmediately(new wmd(this), null, false);
      return;
    }
    i();
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    int i;
    if ((paramView instanceof BuddyListAdapter.GroupTag))
    {
      a((BuddyListAdapter.GroupTag)paramView);
      paramView = (BuddyListAdapter.GroupTag)paramView;
      a(paramView.jdField_a_of_type_Int);
      if ((paramView.jdField_a_of_type_Int >= 0) && (paramView.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfInt.length))
      {
        if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
          break label158;
        }
        i = 0;
        if ((this.jdField_a_of_type_ArrayOfInt[paramView.jdField_a_of_type_Int] == 1) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(i)))
        {
          i = a(paramView.jdField_a_of_type_Int);
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(i) }).a();
        }
      }
    }
    label158:
    do
    {
      return;
      i = paramView.jdField_a_of_type_Int;
      break;
      if ((paramView instanceof BuddyListTroop.TroopDisChildTag))
      {
        localObject = (BuddyListTroop.TroopDisChildTag)paramView;
        if ((((BuddyListTroop.TroopDisChildTag)localObject).jdField_a_of_type_JavaLangObject instanceof DiscussionInfo))
        {
          a((BuddyListTroop.TroopDisChildTag)localObject, (DiscussionInfo)((BuddyListTroop.TroopDisChildTag)localObject).jdField_a_of_type_JavaLangObject);
          return;
        }
        paramView = (TroopInfo)((BuddyListTroop.TroopDisChildTag)localObject).jdField_a_of_type_JavaLangObject;
        int j;
        switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(((BuddyListTroop.TroopDisChildTag)localObject).jdField_b_of_type_Int)).intValue())
        {
        case 1: 
        case 3: 
        case 5: 
        case 7: 
        case 9: 
        default: 
          i = 0;
          switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramView.troopuin))
          {
          default: 
            j = 0;
          }
          break;
        }
        for (;;)
        {
          if (((BuddyListTroop.TroopDisChildTag)localObject).jdField_a_of_type_Boolean) {
            new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactiveGrp").a(new String[] { paramView.troopuin, String.valueOf(i) }).a();
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramView.troopuin + "", String.valueOf(i), j + "", "");
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramView.troopuin, String.valueOf(i) }).a();
          if (i == 5) {
            new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_unnamedGrp").a(new String[] { paramView.troopuin }).a();
          }
          ThreadPriorityManager.a(true);
          localObject = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
          ((Intent)localObject).putExtra("uin", paramView.troopuin);
          if (paramView.troopcode != null) {
            ((Intent)localObject).putExtra("troop_uin", paramView.troopcode);
          }
          ((Intent)localObject).putExtra("uintype", 1);
          ((Intent)localObject).putExtra("uinname", paramView.getTroopName());
          ((Intent)localObject).putExtra("open_chatfragment_withanim", true);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
          return;
          i = 0;
          break;
          i = 1;
          break;
          i = 2;
          break;
          i = 3;
          break;
          i = 4;
          break;
          i = 5;
          break;
          j = 0;
          continue;
          j = 2;
          continue;
          j = 3;
          continue;
          j = 1;
        }
      }
    } while (!(paramView instanceof TroopInfo));
    Object localObject = (TroopInfo)paramView;
    boolean bool = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(((TroopInfo)localObject).troopuin);
    paramView = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
    label796:
    label818:
    ReportTask localReportTask;
    label890:
    String str;
    if (bool)
    {
      i = 1;
      if (!paramView.a(((TroopInfo)localObject).troopcode, i)) {
        break label942;
      }
      if (!bool) {
        break label944;
      }
      paramView = "Clk_uncommgrp";
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_contactlist", paramView, 0, 0, ((TroopInfo)localObject).troopuin, "", "", "");
      localReportTask = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_set").c("Grp_contactlist");
      if (!bool) {
        break label951;
      }
      paramView = "Clk_unstick";
      localReportTask = localReportTask.d(paramView);
      str = ((TroopInfo)localObject).troopuin;
      if (!((TroopInfo)localObject).hasSetTroopHead()) {
        break label958;
      }
    }
    label942:
    label944:
    label951:
    label958:
    for (paramView = "1";; paramView = "0")
    {
      localReportTask.a(new String[] { str, paramView }).a();
      return;
      i = 0;
      break label796;
      break;
      paramView = "Clk_setcommgrp";
      break label818;
      paramView = "Clk_stick";
      break label890;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = 2131435389;
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof BuddyListItem.ViewTag)))
    {
      paramView = ((BuddyListItem.ViewTag)paramView).jdField_a_of_type_JavaLangObject;
      if (paramView != null)
      {
        ActionSheet localActionSheet;
        Object localObject;
        boolean bool;
        if ((paramView instanceof TroopInfo))
        {
          localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
          localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          paramView = (TroopInfo)paramView;
          bool = ((TroopManager)localObject).b(paramView.troopuin);
          if (bool) {
            i = 2131435389;
          }
        }
        for (;;)
        {
          localActionSheet.b(i);
          localActionSheet.c(2131433015);
          localActionSheet.a(new wmi(this, bool, paramView, localActionSheet));
          try
          {
            localActionSheet.show();
            label123:
            do
            {
              return true;
              i = 2131435388;
              break;
            } while (!(paramView instanceof DiscussionInfo));
            localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
            localObject = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
            paramView = (DiscussionInfo)paramView;
            bool = ((DiscussionHandler)localObject).a(paramView);
            if (bool) {}
            for (;;)
            {
              for (;;)
              {
                localActionSheet.b(i);
                localActionSheet.c(2131433015);
                localActionSheet.a(new wmj(this, (DiscussionHandler)localObject, paramView, bool, localActionSheet));
                try
                {
                  localActionSheet.show();
                }
                catch (Exception paramView) {}
              }
              break;
              i = 2131435388;
            }
          }
          catch (Exception paramView)
          {
            break label123;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter
 * JD-Core Version:    0.7.0.1
 */