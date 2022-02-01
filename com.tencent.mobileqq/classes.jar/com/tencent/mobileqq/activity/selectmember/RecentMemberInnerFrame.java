package com.tencent.mobileqq.activity.selectmember;

import amec;
import amed;
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
import anyw;
import anzj;
import apaw;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentMemberInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  private amec jdField_a_of_type_Amec;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private anyw jdField_a_of_type_Anyw;
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
      Object localObject2 = ((apaw)localObject1).getRecentList(true);
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
                Friends localFriends = this.jdField_a_of_type_Anyw.b(localRecentUser.uin);
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
    setContentView(2131562911);
    this.jdField_a_of_type_Anyw = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131381542));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131167247);
    paramBundle = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131562854, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBundle.findViewById(2131366151));
    ((Button)paramBundle.findViewById(2131363745)).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBundle);
    g();
    this.jdField_a_of_type_Amec = new amec(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Amec);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131717856), anzj.a(2131712079));
    if (this.jdField_a_of_type_Amec != null) {
      this.jdField_a_of_type_Amec.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Amec != null) {
      this.jdField_a_of_type_Amec.c();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Amec.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    amed localamed = (amed)paramView.getTag();
    if ((localamed != null) && (localamed.jdField_a_of_type_JavaLangString != null) && (localamed.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localamed.jdField_a_of_type_AndroidWidgetTextView != null) && (localamed.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localamed.jdField_a_of_type_JavaLangString, localamed.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), 0, "-1");
      localamed.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (AppSetting.c)
      {
        if (!localamed.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label140;
        }
        paramView.setContentDescription(localamed.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + anzj.a(2131712077));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label140:
      paramView.setContentDescription(localamed.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + anzj.a(2131712080));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.RecentMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */