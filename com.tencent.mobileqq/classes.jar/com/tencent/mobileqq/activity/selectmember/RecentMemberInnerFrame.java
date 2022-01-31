package com.tencent.mobileqq.activity.selectmember;

import aidv;
import aidw;
import ajxl;
import ajya;
import aktf;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentMemberInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  private aidv jdField_a_of_type_Aidv;
  private ajxl jdField_a_of_type_Ajxl;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List<RecentUser> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public RecentMemberInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (localObject1 != null)
    {
      Object localObject2 = ((aktf)localObject1).a(true);
      if (localObject2 != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
          if (localRecentUser != null) {
            try
            {
              if ((localRecentUser.getType() == 0) && (Long.parseLong(localRecentUser.uin) >= 10000L) && (!localRecentUser.uin.equals(localObject1)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d.contains(localRecentUser.uin)))
              {
                Friends localFriends = this.jdField_a_of_type_Ajxl.b(localRecentUser.uin);
                if ((localFriends != null) && (localFriends.isFriend())) {
                  this.jdField_a_of_type_JavaUtilList.add(localRecentUser);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
      }
    }
  }
  
  public ContactSearchFragment a()
  {
    return ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getChildAt(1)).a();
  }
  
  public String a()
  {
    return "-1";
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131562417);
    this.jdField_a_of_type_Ajxl = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131379547));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131167087);
    paramBundle = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131562360, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBundle.findViewById(2131365763));
    ((Button)paramBundle.findViewById(2131363479)).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBundle);
    g();
    this.jdField_a_of_type_Aidv = new aidv(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aidv);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719232), ajya.a(2131713207));
    if (this.jdField_a_of_type_Aidv != null) {
      this.jdField_a_of_type_Aidv.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aidv != null) {
      this.jdField_a_of_type_Aidv.c();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aidv.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    aidw localaidw = (aidw)paramView.getTag();
    if ((localaidw != null) && (localaidw.jdField_a_of_type_JavaLangString != null) && (localaidw.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localaidw.jdField_a_of_type_AndroidWidgetTextView != null) && (localaidw.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localaidw.jdField_a_of_type_JavaLangString, localaidw.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), 0, "-1");
      localaidw.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (AppSetting.d)
      {
        if (!localaidw.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label133;
        }
        paramView.setContentDescription(localaidw.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + ajya.a(2131713205));
      }
    }
    return;
    label133:
    paramView.setContentDescription(localaidw.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + ajya.a(2131713208));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.RecentMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */