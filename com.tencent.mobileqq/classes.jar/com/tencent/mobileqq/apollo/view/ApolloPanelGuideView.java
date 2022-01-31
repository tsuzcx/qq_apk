package com.tencent.mobileqq.apollo.view;

import allz;
import almb;
import alni;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ApolloActionData;
import java.util.Iterator;
import java.util.List;

public class ApolloPanelGuideView
  extends RelativeLayout
  implements View.OnClickListener
{
  private alni jdField_a_of_type_Alni;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ApolloLinearLayoutNoPreview jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview;
  private List<allz> jdField_a_of_type_JavaUtilList;
  
  public ApolloPanelGuideView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ApolloPanelGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ApolloPanelGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      almb localalmb = (almb)localViewGroup.getTag();
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localViewGroup.setVisibility(0);
        localalmb.jdField_a_of_type_Allz = ((allz)this.jdField_a_of_type_JavaUtilList.get(i));
        ApolloActionData localApolloActionData = localalmb.jdField_a_of_type_Allz.a;
        localalmb.jdField_a_of_type_Allz.c = 0;
        localalmb.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
        localalmb.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localalmb.jdField_a_of_type_Allz.a(getContext(), getContext().getResources().getDisplayMetrics().density));
        localalmb.e.setBackgroundDrawable(null);
        localalmb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        localalmb.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localalmb.e.setVisibility(8);
        if (localalmb.jdField_a_of_type_AndroidViewView != null)
        {
          localViewGroup.removeView(localalmb.jdField_a_of_type_AndroidViewView);
          localalmb.jdField_a_of_type_AndroidViewView = null;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localViewGroup.setVisibility(4);
        localalmb.jdField_a_of_type_Allz = null;
        localalmb.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      }
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (((allz)localIterator.next()).a.actionId == paramApolloActionData.actionId) {
          post(new ApolloPanelGuideView.1(this));
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.dispatchTouchEvent(paramMotionEvent)) {}
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Alni == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368085: 
      this.jdField_a_of_type_Alni.a(this);
      return;
    }
    this.jdField_a_of_type_Alni.b(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    findViewById(2131368085).setOnClickListener(this);
    findViewById(2131377317).setOnClickListener(this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131361930);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview = new ApolloLinearLayoutNoPreview(getContext(), null, 0, 4, 1);
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview, -1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview.getChildAt(0));
  }
  
  public void setActions(List<allz> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    a();
  }
  
  public void setCallback(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview.setCallback(paramBaseChatPie);
  }
  
  public void setClickCallback(alni paramalni)
  {
    this.jdField_a_of_type_Alni = paramalni;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview.setSessionInfo(paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanelGuideView
 * JD-Core Version:    0.7.0.1
 */