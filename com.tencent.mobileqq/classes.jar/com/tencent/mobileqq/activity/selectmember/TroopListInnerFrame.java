package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

public class TroopListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private TroopListAdapter jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public TroopListInnerFrame(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TroopListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TroopListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131558938);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0) != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0).getBottom() == this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.getItem(paramInt);
    } while (!(localObject1 instanceof TroopListAdapter.TroopListItem));
    Object localObject2 = (TroopListAdapter.TroopListItem)localObject1;
    Object localObject1 = null;
    switch (((TroopListAdapter.TroopListItem)localObject2).jdField_a_of_type_Int)
    {
    default: 
      label132:
      if (paramInt + 1 < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.getCount())
      {
        localObject2 = (TroopListAdapter.TroopListItem)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.getItem(paramInt + 1);
        if (((localObject2 == null) || (((TroopListAdapter.TroopListItem)localObject2).jdField_a_of_type_Int != 6)) && (((TroopListAdapter.TroopListItem)localObject2).jdField_a_of_type_Int != 4) && (((TroopListAdapter.TroopListItem)localObject2).jdField_a_of_type_Int != 2) && (((TroopListAdapter.TroopListItem)localObject2).jdField_a_of_type_Int != 8)) {
          break label441;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          if (paramInt >= this.jdField_a_of_type_Int) {
            break label433;
          }
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - this.jdField_a_of_type_Int);
          label244:
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        }
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429838, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.d) });
      break label132;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429832, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.c) });
      break label132;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429830, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.jdField_a_of_type_Int) });
      break label132;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429831, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.b) });
      break label132;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429833, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.e) });
      break label132;
      label433:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      break label244;
      label441:
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilArrayList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a();
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
  }
  
  public ContactSearchFragment a()
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130969725);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131366744));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366492));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelector(2131492924);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter = new TroopListAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, 4, false, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter);
    g();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(this);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter != null) {
      a(paramInt1);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435991), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435982));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.X_();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (TroopListAdapter.TroopViewHolder)paramView.getTag();
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null))
    {
      localObject = paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      localBundle = new Bundle();
      localBundle.putString("group_uin", ((TroopInfo)localObject).troopuin);
      localBundle.putString("group_name", ((TroopInfo)localObject).getTroopName());
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, localBundle);
      switch (paramView.jdField_a_of_type_Int)
      {
      case 2: 
      case 4: 
      case 6: 
      case 8: 
      default: 
        i = 0;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, ((TroopInfo)localObject).troopuin + "", String.valueOf(i), "", "");
      }
    }
    while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null)) {
      for (;;)
      {
        Bundle localBundle;
        return;
        int i = 0;
        continue;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 4;
      }
    }
    paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("group_uin", paramView.uin);
    ((Bundle)localObject).putString("group_name", paramView.discussionName);
    if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a instanceof PhoneContactSelectActivity))
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3, (Bundle)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListInnerFrame
 * JD-Core Version:    0.7.0.1
 */