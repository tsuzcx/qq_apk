package com.tencent.mobileqq.apollo.view;

import ajbx;
import ajbz;
import ajdg;
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
  private ajdg jdField_a_of_type_Ajdg;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ApolloLinearLayoutNoPreview jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview;
  private List<ajbx> jdField_a_of_type_JavaUtilList;
  
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
      ajbz localajbz = (ajbz)localViewGroup.getTag();
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localViewGroup.setVisibility(0);
        localajbz.jdField_a_of_type_Ajbx = ((ajbx)this.jdField_a_of_type_JavaUtilList.get(i));
        ApolloActionData localApolloActionData = localajbz.jdField_a_of_type_Ajbx.a;
        localajbz.jdField_a_of_type_Ajbx.c = 0;
        localajbz.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
        localajbz.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localajbz.jdField_a_of_type_Ajbx.a(getContext(), getContext().getResources().getDisplayMetrics().density));
        localajbz.e.setBackgroundDrawable(null);
        localajbz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        localajbz.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localajbz.e.setVisibility(8);
        if (localajbz.jdField_a_of_type_AndroidViewView != null)
        {
          localViewGroup.removeView(localajbz.jdField_a_of_type_AndroidViewView);
          localajbz.jdField_a_of_type_AndroidViewView = null;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localViewGroup.setVisibility(4);
        localajbz.jdField_a_of_type_Ajbx = null;
        localajbz.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
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
        if (((ajbx)localIterator.next()).a.actionId == paramApolloActionData.actionId) {
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
    if (this.jdField_a_of_type_Ajdg == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302318: 
      this.jdField_a_of_type_Ajdg.a(this);
      return;
    }
    this.jdField_a_of_type_Ajdg.b(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    findViewById(2131302318).setOnClickListener(this);
    findViewById(2131310940).setOnClickListener(this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131296393);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview = new ApolloLinearLayoutNoPreview(getContext(), null, 0, 4, 1);
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview, -1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview.getChildAt(0));
  }
  
  public void setActions(List<ajbx> paramList)
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
  
  public void setClickCallback(ajdg paramajdg)
  {
    this.jdField_a_of_type_Ajdg = paramajdg;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview.setSessionInfo(paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanelGuideView
 * JD-Core Version:    0.7.0.1
 */