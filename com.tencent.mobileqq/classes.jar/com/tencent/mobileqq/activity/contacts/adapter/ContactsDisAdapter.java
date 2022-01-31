package com.tencent.mobileqq.activity.contacts.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.adapter.BuddyListAdapter.GroupTag;
import com.tencent.mobileqq.adapter.SwipFacePreloadExpandableAdapter;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem.ViewTag;
import com.tencent.mobileqq.adapter.contacts.BuddyListTroop.TroopDisChildTag;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import wis;
import wit;
import wiu;

public class ContactsDisAdapter
  extends SwipFacePreloadExpandableAdapter
  implements View.OnClickListener, View.OnLongClickListener, SwipPinnedHeaderExpandableListView.SwipListListener
{
  public int a;
  public Context a;
  protected DiscussionManager a;
  public QQAppInterface a;
  protected SwipTextViewMenuBuilder a;
  protected HashSet a;
  protected List a;
  private boolean a;
  private int jdField_b_of_type_Int;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int;
  private List jdField_c_of_type_JavaUtilList = new ArrayList();
  
  public ContactsDisAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(2);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(4);
    this.jdField_a_of_type_Int = -2;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = ((int)(paramContext.getResources().getDisplayMetrics().density * 56.0F));
    this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131559314);
    this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder = new wis(this, 1, 1, new int[] { paramContext.getResources().getDimensionPixelSize(2131558645) }, -1, new int[] { 2131369932, 2131369932 }, new int[] { 2131429830, 2131429831 }, new int[] { 2130838679, 2130838679 });
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(52));
  }
  
  private DiscussionInfo a(int paramInt1, int paramInt2)
  {
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).intValue())
    {
    default: 
      return null;
    case 0: 
      return (DiscussionInfo)this.jdField_c_of_type_JavaUtilList.get(paramInt2);
    }
    return (DiscussionInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt2);
  }
  
  private void a(BuddyListAdapter.GroupTag paramGroupTag, int paramInt, boolean paramBoolean)
  {
    String str;
    int i;
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (paramGroupTag != null)
    {
      str = "";
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
      switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
      {
      default: 
        i = 0;
        localStringBuilder1 = paramGroupTag.jdField_a_of_type_JavaLangStringBuilder;
        localStringBuilder2 = localStringBuilder1;
        if (AppSetting.b)
        {
          if (localStringBuilder1 == null)
          {
            localStringBuilder1 = new StringBuilder(24);
            label99:
            localStringBuilder1.append(str + " 分组");
            localStringBuilder2 = localStringBuilder1;
          }
        }
        else
        {
          paramGroupTag.jdField_a_of_type_Int = paramInt;
          paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str);
          paramGroupTag.b.setVisibility(8);
          paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText(i + "");
          if (AppSetting.b) {
            localStringBuilder2.append("共" + i + "个" + str);
          }
          paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
          if (AppSetting.b)
          {
            if (!paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label356;
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
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131435929);
      i = this.jdField_c_of_type_JavaUtilList.size();
      break;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131435930);
      i = this.jdField_b_of_type_JavaUtilList.size();
      break;
      localStringBuilder1.delete(0, localStringBuilder1.length());
      break label99;
      label356:
      localStringBuilder2.append(" 已折叠");
    }
  }
  
  private void d()
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsDisAdapter", 2, "only one group");
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(0);
    }
    HashSet localHashSet;
    int i;
    do
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(0));
      return;
      for (;;)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getString("700_sp_key_last_dis_expanded", "700_sp_key_last_dis_expanded");
        if (QLog.isColorLevel()) {
          QLog.d("ContactsDisAdapter", 2, "readExpand=" + (String)localObject);
        }
        localHashSet = new HashSet();
        if (!((String)localObject).equalsIgnoreCase("700_sp_key_last_dis_expanded")) {
          break;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localHashSet.add(Integer.valueOf(0));
          i = k;
        }
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (localHashSet.contains(Integer.valueOf(i)))
          {
            this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(i));
            this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
          }
          i += 1;
          continue;
          this.jdField_a_of_type_Boolean = true;
          i = k;
        }
      }
      i = k;
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Object localObject = ((String)localObject).split("_");
    int m = localObject.length;
    int j = 0;
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
        label283:
        j += 1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label283;
      }
    }
  }
  
  private void e()
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
        QLog.d("ContactsDisAdapter", 2, "saveExpanded=" + localStringBuffer.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putString("700_sp_key_last_dis_expanded", localStringBuffer.toString()).commit();
    }
    while (!QLog.isColorLevel())
    {
      StringBuffer localStringBuffer;
      Iterator localIterator;
      return;
    }
    QLog.d("ContactsDisAdapter", 2, "less than 1 group : don't saveExpanded");
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
    Object localObject1 = new HashMap();
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131433286);
    Object localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131433289);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
      long l = 0L;
      String str1 = ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, localDiscussionInfo);
      String str2 = ChnToSpell.a(str1, 1);
      if ((str1.matches((String)localObject2)) || (str1.contains((CharSequence)localObject3))) {
        l = 65536L;
      }
      if ((str2 == null) || (str2.length() == 0)) {
        l |= 0xFFFF;
      }
      for (;;)
      {
        ((HashMap)localObject1).put(localDiscussionInfo.uin, Long.valueOf(l));
        break;
        if (StringUtil.b(str2.charAt(0))) {
          l |= str2.charAt(0);
        } else if (Character.isDigit(str2.charAt(0))) {
          l |= 0xFFFE;
        } else {
          l |= 0xFFFF;
        }
      }
    }
    Collections.sort(this.jdField_b_of_type_JavaUtilList, new wit(this, (HashMap)localObject1));
    this.jdField_c_of_type_JavaUtilList.clear();
    localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      if (((DiscussionInfo)localObject2).hasCollect) {
        this.jdField_c_of_type_JavaUtilList.add(localObject2);
      }
    }
    if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
    }
    if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
    }
    localObject1 = new HashSet(4);
    localObject2 = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      if (this.jdField_a_of_type_JavaUtilList.contains(localObject3)) {
        ((HashSet)localObject1).add(localObject3);
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("ContactsDisAdapter", 2, "load dis: " + this.jdField_c_of_type_JavaUtilList.size() + " " + this.jdField_b_of_type_JavaUtilList.size() + " " + this.jdField_a_of_type_JavaUtilHashSet.size());
    }
  }
  
  public int a()
  {
    return 2130968808;
  }
  
  public void a()
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
  
  public void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem, Object paramObject)
  {
    int i = 1;
    if ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0)) {}
    label97:
    for (;;)
    {
      return;
      if (paramArrayOfSwipRightMenuItem.length < 0) {
        if ((paramObject instanceof DiscussionInfo))
        {
          paramObject = (DiscussionInfo)paramObject;
          if (this.jdField_c_of_type_JavaUtilList.contains(paramObject))
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
      localGroupTag.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131363817));
      localGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131363819));
      localGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      localGroupTag.b = ((SingleLineTextView)paramView.findViewById(2131363821));
      localGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131363820));
      localGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setDefaultTextColor(1711276032);
      localGroupTag.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131363818));
      paramView.setTag(localGroupTag);
    }
    for (;;)
    {
      a(localGroupTag, paramInt, this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramInt));
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break;
      }
      paramView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493363));
      localGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundResource(2130838655);
      return;
      localGroupTag = (BuddyListAdapter.GroupTag)paramView.getTag();
    }
    paramView.setBackgroundResource(2130845737);
    localGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundResource(2130838654);
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
  
  public void b()
  {
    e();
  }
  
  public void c() {}
  
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
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof BuddyListTroop.TroopDisChildTag)))
    {
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968943, null);
      ((View)localObject).setBackgroundResource(2130838583);
      ((View)localObject).setMinimumHeight(this.jdField_b_of_type_Int);
      paramViewGroup = new BuddyListTroop.TroopDisChildTag();
      paramView = this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, (View)localObject, paramViewGroup, -1);
      paramViewGroup.f = ((View)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363873));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362701));
      ((RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).leftMargin = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.b = ((TextView)paramView.findViewById(2131363878));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.f.setBackgroundResource(2130838583);
      paramView.setOnClickListener(this);
      paramView.setOnLongClickListener(this);
      localObject = a(paramInt1, paramInt2);
      if (localObject != null)
      {
        paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject).uin;
        paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
        paramViewGroup.jdField_a_of_type_Int = 101;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionInfo)localObject).discussionName);
        paramViewGroup.b.setVisibility(0);
        paramViewGroup.b.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject).uin)) }));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494212));
        a(paramView, paramInt2, paramViewGroup, this, localObject);
        a(paramViewGroup, null);
      }
      if (AppSetting.b) {
        ViewCompat.setImportantForAccessibility(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, 2);
      }
      return paramView;
      paramViewGroup = (BuddyListTroop.TroopDisChildTag)paramView.getTag();
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    default: 
      return 0;
    case 0: 
      return this.jdField_c_of_type_JavaUtilList.size();
    }
    return this.jdField_b_of_type_JavaUtilList.size();
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
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131363819));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131363817));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131363820));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131363818));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131363821));
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
      localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494261);
      paramView.setBackgroundResource(2130838665);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundResource(2130838655);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor(localColorStateList);
      a(paramViewGroup, paramInt, paramBoolean);
      paramView.setOnClickListener(this);
      return paramView;
      localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494260);
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
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    boolean bool = false;
    g();
    super.notifyDataSetChanged();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      d();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetExpandableListView instanceof PinnedHeaderExpandableListView))
      {
        PinnedHeaderExpandableListView localPinnedHeaderExpandableListView = (PinnedHeaderExpandableListView)this.jdField_a_of_type_ComTencentWidgetExpandableListView;
        if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
          bool = true;
        }
        localPinnedHeaderExpandableListView.setHeaderViewShouldShow(bool);
      }
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(0);
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(0));
    }
    int i = 0;
    label104:
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(i))) {
        break label147;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
    }
    for (;;)
    {
      i += 1;
      break label104;
      break;
      label147:
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(i);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof BuddyListAdapter.GroupTag))
    {
      paramView = (BuddyListAdapter.GroupTag)paramView;
      if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramView.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(paramView.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramView.jdField_a_of_type_Int));
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(paramView.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramView.jdField_a_of_type_Int));
      return;
      if ((paramView instanceof BuddyListTroop.TroopDisChildTag))
      {
        paramView = (DiscussionInfo)((BuddyListTroop.TroopDisChildTag)paramView).jdField_a_of_type_JavaLangObject;
        ThreadPriorityManager.a(true);
        localObject = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
        ((Intent)localObject).putExtra("uin", paramView.uin);
        ((Intent)localObject).putExtra("uintype", 3000);
        ((Intent)localObject).putExtra("uinname", paramView.discussionName);
        ((Intent)localObject).putExtra("open_chatfragment_withanim", true);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramView.hasCollect) {}
        for (int i = 1;; i = 2)
        {
          ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8006666", "0X8006666", i, 0, "", "", "", "");
          return;
        }
      }
    } while (!(paramView instanceof DiscussionInfo));
    Object localObject = (DiscussionInfo)paramView;
    if (NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      paramView = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(paramView, 2131429828, 0).b(paramView.getTitleBarHeight());
      return;
    }
    if ((!((DiscussionInfo)localObject).hasCollect) && (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a() >= 80))
    {
      paramView = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(paramView, this.jdField_a_of_type_AndroidContentContext.getString(2131429829, new Object[] { String.valueOf(80) }), 0).b(paramView.getTitleBarHeight());
      return;
    }
    DiscussionHandler localDiscussionHandler = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
    if (((DiscussionInfo)localObject).hasCollect) {}
    for (paramView = "0X8006898";; paramView = "0X8006897")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
      if (!((DiscussionInfo)localObject).hasCollect) {
        break;
      }
      localDiscussionHandler.e(Long.valueOf(((DiscussionInfo)localObject).uin).longValue());
      return;
    }
    localDiscussionHandler.d(Long.valueOf(((DiscussionInfo)localObject).uin).longValue());
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof BuddyListItem.ViewTag)))
    {
      Object localObject = ((BuddyListItem.ViewTag)paramView).jdField_a_of_type_JavaLangObject;
      if (localObject != null)
      {
        DiscussionManager localDiscussionManager;
        boolean bool;
        int i;
        if ((localObject instanceof DiscussionInfo))
        {
          paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
          localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          localObject = (DiscussionInfo)localObject;
          bool = ((DiscussionInfo)localObject).hasCollect;
          if (!bool) {
            break label120;
          }
          i = 2131429831;
        }
        for (;;)
        {
          paramView.b(i);
          paramView.c(2131432998);
          paramView.a(new wiu(this, bool, localDiscussionManager, (DiscussionInfo)localObject, paramView));
          try
          {
            paramView.show();
            label118:
            return true;
            label120:
            i = 2131429830;
          }
          catch (Exception paramView)
          {
            break label118;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.adapter.ContactsDisAdapter
 * JD-Core Version:    0.7.0.1
 */