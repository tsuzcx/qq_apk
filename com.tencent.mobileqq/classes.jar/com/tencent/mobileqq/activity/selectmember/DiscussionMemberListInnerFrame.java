package com.tencent.mobileqq.activity.selectmember;

import alil;
import amdh;
import amdi;
import amdj;
import amdk;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anws;
import anzj;
import bdll;
import bhlg;
import bhlq;
import biyw;
import bjaj;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiscussionMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, biyw, bjaj
{
  private amdj jdField_a_of_type_Amdj;
  private Handler jdField_a_of_type_AndroidOsHandler = new amdi(this);
  public CheckBox a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  anws jdField_a_of_type_Anws;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  private String jdField_a_of_type_JavaLangString = "";
  public List<DiscussionMemberInfo> a;
  boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public DiscussionMemberListInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public DiscussionMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public DiscussionMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      if ((paramString == null) || (paramBoolean) || (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
        break label46;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      return;
      label46:
      int j = this.jdField_a_of_type_Amdj.getCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label105;
        }
        paramString = (DiscussionMemberInfo)this.jdField_a_of_type_Amdj.getItem(i);
        if ((paramString != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(paramString.memberUin)))
        {
          paramBoolean = false;
          break;
        }
        i += 1;
      }
      label105:
      paramBoolean = true;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364374));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368624));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167247);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376845));
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370240);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364284));
    localLinearLayout.setOnClickListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = ((anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(this.b);
    if (localObject != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
        if ((localDiscussionMemberInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.p) || (!str.equalsIgnoreCase(localDiscussionMemberInfo.memberUin))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_JavaUtilArrayList.contains(localDiscussionMemberInfo.memberUin)))
        {
          localDiscussionMemberInfo.displayedNamePinyinFirst = ChnToSpell.a(bhlg.a(localDiscussionMemberInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 2);
          this.jdField_a_of_type_JavaUtilList.add(localDiscussionMemberInfo);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 4096, this.b, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131562891);
    this.jdField_a_of_type_Anws = ((anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53));
    g();
    this.jdField_a_of_type_Amdj = new amdj(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Amdj);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Amdj.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Amdj.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.b();
    this.b = paramBundle.getString("group_uin");
    this.c = paramBundle.getString("group_name");
    boolean bool = paramBundle.getBoolean("param_enable_all_select", false);
    paramBundle = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    int i;
    if (bool)
    {
      i = 0;
      paramBundle.setVisibility(i);
      if ((TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.b)) && (this.jdField_a_of_type_Anws != null))
      {
        paramBundle = this.jdField_a_of_type_Anws.a(this.b);
        if (paramBundle != null) {
          this.c = paramBundle.discussionName;
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i) {
        break label240;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, "", this.c);
      label137:
      if ((TextUtils.isEmpty(this.b)) || (this.b.equals(this.jdField_a_of_type_JavaLangString))) {
        break label261;
      }
      h();
      this.jdField_a_of_type_Amdj.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      this.jdField_a_of_type_JavaLangString = this.b;
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.q))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        onCheckedChanged(this.jdField_a_of_type_AndroidWidgetCheckBox, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
      }
      return;
      i = 8;
      break;
      label240:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, anzj.a(2131702262), this.c);
      break label137;
      label261:
      this.jdField_a_of_type_Amdj.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Amdj != null) {
      this.jdField_a_of_type_Amdj.c();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Amdj.notifyDataSetChanged();
    a(null, false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (2131364284 == paramCompoundButton.getId())
    {
      if (!paramBoolean) {
        break label171;
      }
      ArrayList localArrayList = new ArrayList();
      int j = this.jdField_a_of_type_Amdj.getCount();
      int i = 0;
      while (i < j)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)this.jdField_a_of_type_Amdj.getItem(i);
        if (localDiscussionMemberInfo != null)
        {
          SelectMemberActivity localSelectMemberActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
          localArrayList.add(SelectMemberActivity.a(localDiscussionMemberInfo.memberUin, bhlg.a(localDiscussionMemberInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 2, this.b));
        }
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 31) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, "dc00898", "", "", "0X8007CFB", "0X8007CFB", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localArrayList, false, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Amdj.notifyDataSetChanged();
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label171:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d();
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject1;
    if (2131370240 != paramView.getId())
    {
      localObject1 = (amdk)paramView.getTag();
      if ((localObject1 != null) && (((amdk)localObject1).jdField_a_of_type_AndroidWidgetCheckBox != null) && (((amdk)localObject1).b != null) && (((amdk)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(((amdk)localObject1).jdField_a_of_type_JavaLangString, ((amdk)localObject1).b.getText().toString(), 2, this.b);
        ((amdk)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        a(((amdk)localObject1).jdField_a_of_type_JavaLangString, bool);
        if (AppSetting.c)
        {
          if (!((amdk)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label155;
          }
          paramView.setContentDescription(((amdk)localObject1).b.getText().toString() + anzj.a(2131702235));
        }
      }
    }
    label155:
    label336:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        paramView.setContentDescription(((amdk)localObject1).b.getText().toString() + anzj.a(2131702251));
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 32) || (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g >= this.jdField_a_of_type_Amdj.b())) {
          break;
        }
        localObject1 = new amdh(this);
        String str = MessageFormat.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131717855), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g) });
        localObject1 = bhlq.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 232, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getString(2131718699), str, 2131690580, 2131698114, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject1);
        try
        {
          ((Dialog)localObject1).show();
        }
        catch (Throwable localThrowable) {}
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break;
      }
      ((CheckBox)localObject2).setChecked(bool);
      onCheckedChanged(this.jdField_a_of_type_AndroidWidgetCheckBox, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
    } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 32);
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (Object localObject2 = "friendsfinder.all.confirm";; localObject2 = "friendsfinder.all.cancel")
    {
      alil.a(0, (String)localObject2);
      break;
      bool = false;
      break label336;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.DiscussionMemberListInnerFrame
 * JD-Core Version:    0.7.0.1
 */