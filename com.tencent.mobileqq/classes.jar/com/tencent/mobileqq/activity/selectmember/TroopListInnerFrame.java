package com.tencent.mobileqq.activity.selectmember;

import amfz;
import amgd;
import amge;
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
import bdll;
import blih;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;

public class TroopListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, blih
{
  int jdField_a_of_type_Int;
  private amfz jdField_a_of_type_Amfz;
  Context jdField_a_of_type_AndroidContentContext;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  ArrayList<Entity> jdField_a_of_type_JavaUtilArrayList;
  
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
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131299058);
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
      localObject1 = this.jdField_a_of_type_Amfz.getItem(paramInt);
    } while (!(localObject1 instanceof amgd));
    Object localObject2 = (amgd)localObject1;
    Object localObject1 = null;
    switch (((amgd)localObject2).jdField_a_of_type_Int)
    {
    default: 
      label132:
      if (paramInt + 1 < this.jdField_a_of_type_Amfz.getCount())
      {
        localObject2 = (amgd)this.jdField_a_of_type_Amfz.getItem(paramInt + 1);
        if (((localObject2 == null) || (((amgd)localObject2).jdField_a_of_type_Int != 6)) && (((amgd)localObject2).jdField_a_of_type_Int != 4) && (((amgd)localObject2).jdField_a_of_type_Int != 2) && (((amgd)localObject2).jdField_a_of_type_Int != 8)) {
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
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695540, new Object[] { String.valueOf(this.jdField_a_of_type_Amfz.d) });
      break label132;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695560, new Object[] { String.valueOf(this.jdField_a_of_type_Amfz.c) });
      break label132;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695473, new Object[] { String.valueOf(this.jdField_a_of_type_Amfz.jdField_a_of_type_Int) });
      break label132;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695512, new Object[] { String.valueOf(this.jdField_a_of_type_Amfz.b) });
      break label132;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695654, new Object[] { String.valueOf(this.jdField_a_of_type_Amfz.e) });
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
    this.jdField_a_of_type_JavaUtilArrayList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b();
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
    setContentView(2131560424);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131381542));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379524));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelector(2131167247);
    this.jdField_a_of_type_Amfz = new amfz(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, 4, false, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Amfz);
    g();
    this.jdField_a_of_type_Amfz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(this);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, "", "");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Amfz != null) {
      this.jdField_a_of_type_Amfz.c();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Amfz.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (amge)paramView.getTag();
    Object localObject2;
    int i;
    if ((localObject1 != null) && (((amge)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null))
    {
      localObject2 = ((amge)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      Bundle localBundle = new Bundle();
      localBundle.putString("group_uin", ((TroopInfo)localObject2).troopuin);
      localBundle.putString("group_name", ((TroopInfo)localObject2).getTroopName());
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, localBundle);
      switch (((amge)localObject1).jdField_a_of_type_Int)
      {
      case 2: 
      case 4: 
      case 6: 
      case 8: 
      default: 
        i = 0;
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, ((TroopInfo)localObject2).troopuin + "", String.valueOf(i), "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
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
      if ((localObject1 != null) && (((amge)localObject1).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null))
      {
        localObject1 = ((amge)localObject1).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("group_uin", ((DiscussionInfo)localObject1).uin);
        ((Bundle)localObject2).putString("group_name", ((DiscussionInfo)localObject1).discussionName);
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, (Bundle)localObject2);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Amfz != null) {
      a(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListInnerFrame
 * JD-Core Version:    0.7.0.1
 */