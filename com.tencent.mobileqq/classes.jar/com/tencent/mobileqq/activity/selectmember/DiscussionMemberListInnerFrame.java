package com.tencent.mobileqq.activity.selectmember;

import android.app.Dialog;
import android.content.Context;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xvk;
import xvl;
import xvm;
import xvn;

public class DiscussionMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new xvl(this);
  public CheckBox a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  DiscussionManager jdField_a_of_type_ComTencentMobileqqAppDiscussionManager;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  private String jdField_a_of_type_JavaLangString = "";
  public List a;
  private xvm jdField_a_of_type_Xvm;
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
      int j = this.jdField_a_of_type_Xvm.getCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label105;
        }
        paramString = (DiscussionMemberInfo)this.jdField_a_of_type_Xvm.getItem(i);
        if ((paramString != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(paramString.memberUin)))
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131374854));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131363807));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131492923);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131374850));
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374852);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131374853));
    localLinearLayout.setOnClickListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.b);
    if (localObject != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
        if ((localDiscussionMemberInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.s) || (!str.equalsIgnoreCase(localDiscussionMemberInfo.memberUin))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h.contains(localDiscussionMemberInfo.memberUin)))
        {
          localDiscussionMemberInfo.displayedNamePinyinFirst = ChnToSpell.a(ContactUtils.a(localDiscussionMemberInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 2);
          this.jdField_a_of_type_JavaUtilList.add(localDiscussionMemberInfo);
        }
      }
    }
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 4096, this.b, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130971502);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    g();
    this.jdField_a_of_type_Xvm = new xvm(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Xvm);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Xvm.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.clearFocus();
    this.b = paramBundle.getString("group_uin");
    this.c = paramBundle.getString("group_name");
    boolean bool = paramBundle.getBoolean("param_enable_all_select", false);
    paramBundle = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    int i;
    if (bool)
    {
      i = 0;
      paramBundle.setVisibility(i);
      if ((TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.b)) && (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager != null))
      {
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(this.b);
        if (paramBundle != null) {
          this.c = paramBundle.discussionName;
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.m) {
        break label240;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, "", this.c);
      label137:
      if ((TextUtils.isEmpty(this.b)) || (this.b.equals(this.jdField_a_of_type_JavaLangString))) {
        break label258;
      }
      h();
      this.jdField_a_of_type_Xvm.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      this.jdField_a_of_type_JavaLangString = this.b;
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.t))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        onCheckedChanged(this.jdField_a_of_type_AndroidWidgetCheckBox, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
      }
      return;
      i = 8;
      break;
      label240:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, "多人聊天", this.c);
      break label137;
      label258:
      this.jdField_a_of_type_Xvm.notifyDataSetChanged();
    }
  }
  
  public void b(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Xvm.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Xvm != null) {
      this.jdField_a_of_type_Xvm.c();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Xvm.notifyDataSetChanged();
    a(null, false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (2131374853 == paramCompoundButton.getId())
    {
      if (!paramBoolean) {
        break label160;
      }
      paramCompoundButton = new ArrayList();
      int j = this.jdField_a_of_type_Xvm.getCount();
      int i = 0;
      while (i < j)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)this.jdField_a_of_type_Xvm.getItem(i);
        if (localDiscussionMemberInfo != null)
        {
          SelectMemberActivity localSelectMemberActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
          paramCompoundButton.add(SelectMemberActivity.a(localDiscussionMemberInfo.memberUin, ContactUtils.a(localDiscussionMemberInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 2, this.b));
        }
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f == 31) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, "dc00898", "", "", "0X8007CFB", "0X8007CFB", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(paramCompoundButton, false, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Xvm.notifyDataSetChanged();
      return;
      label160:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c();
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject;
    if (2131374852 != paramView.getId())
    {
      localObject = (xvn)paramView.getTag();
      if ((localObject != null) && (((xvn)localObject).jdField_a_of_type_AndroidWidgetCheckBox != null) && (((xvn)localObject).b != null) && (((xvn)localObject).jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(((xvn)localObject).jdField_a_of_type_JavaLangString, ((xvn)localObject).b.getText().toString(), 2, this.b);
        ((xvn)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        a(((xvn)localObject).jdField_a_of_type_JavaLangString, bool);
        if (AppSetting.b)
        {
          if (!((xvn)localObject).jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label145;
          }
          paramView.setContentDescription(((xvn)localObject).b.getText().toString() + "已选中,双击取消");
        }
      }
    }
    label145:
    do
    {
      return;
      paramView.setContentDescription(((xvn)localObject).b.getText().toString() + "未选中,双击选中");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f == 32) && (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i < this.jdField_a_of_type_Xvm.b()))
      {
        paramView = new xvk(this);
        localObject = MessageFormat.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435951), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i) });
        paramView = DialogUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 232, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getString(2131434764), (String)localObject, 2131432998, 2131437768, paramView, paramView);
        try
        {
          paramView.show();
          return;
        }
        catch (Throwable paramView)
        {
          return;
        }
      }
      paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break;
      }
      paramView.setChecked(bool);
      onCheckedChanged(this.jdField_a_of_type_AndroidWidgetCheckBox, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
    } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f != 32);
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (paramView = "friendsfinder.all.confirm";; paramView = "friendsfinder.all.cancel")
    {
      QWalletTools.a(0, paramView);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.DiscussionMemberListInnerFrame
 * JD-Core Version:    0.7.0.1
 */