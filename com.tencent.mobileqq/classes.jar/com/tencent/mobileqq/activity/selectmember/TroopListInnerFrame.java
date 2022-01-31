package com.tencent.mobileqq.activity.selectmember;

import aifs;
import aifw;
import aifx;
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
import auko;
import axqy;
import bfos;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;

public class TroopListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, bfos
{
  int jdField_a_of_type_Int;
  private aifs jdField_a_of_type_Aifs;
  Context jdField_a_of_type_AndroidContentContext;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  ArrayList<auko> jdField_a_of_type_JavaUtilArrayList;
  
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
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298912);
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
      localObject1 = this.jdField_a_of_type_Aifs.getItem(paramInt);
    } while (!(localObject1 instanceof aifw));
    Object localObject2 = (aifw)localObject1;
    Object localObject1 = null;
    switch (((aifw)localObject2).jdField_a_of_type_Int)
    {
    default: 
      label132:
      if (paramInt + 1 < this.jdField_a_of_type_Aifs.getCount())
      {
        localObject2 = (aifw)this.jdField_a_of_type_Aifs.getItem(paramInt + 1);
        if (((localObject2 == null) || (((aifw)localObject2).jdField_a_of_type_Int != 6)) && (((aifw)localObject2).jdField_a_of_type_Int != 4) && (((aifw)localObject2).jdField_a_of_type_Int != 2) && (((aifw)localObject2).jdField_a_of_type_Int != 8)) {
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
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696495, new Object[] { String.valueOf(this.jdField_a_of_type_Aifs.d) });
      break label132;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696515, new Object[] { String.valueOf(this.jdField_a_of_type_Aifs.c) });
      break label132;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696429, new Object[] { String.valueOf(this.jdField_a_of_type_Aifs.jdField_a_of_type_Int) });
      break label132;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696468, new Object[] { String.valueOf(this.jdField_a_of_type_Aifs.b) });
      break label132;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696609, new Object[] { String.valueOf(this.jdField_a_of_type_Aifs.e) });
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
    this.jdField_a_of_type_JavaUtilArrayList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
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
    setContentView(2131560148);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131379547));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377902));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelector(2131167087);
    this.jdField_a_of_type_Aifs = new aifs(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, 4, false, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Aifs);
    g();
    this.jdField_a_of_type_Aifs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(this);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, "", "");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aifs != null) {
      this.jdField_a_of_type_Aifs.c();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aifs.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (aifx)paramView.getTag();
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
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, ((TroopInfo)localObject).troopuin + "", String.valueOf(i), "", "");
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
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, (Bundle)localObject);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Aifs != null) {
      a(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListInnerFrame
 * JD-Core Version:    0.7.0.1
 */