package com.tencent.mobileqq.apollo.view;

import agej;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anra;
import anrc;
import ansl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.store.openbox.RoundRectLinearLayout;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ApolloPanelGuideView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ansl jdField_a_of_type_Ansl;
  private RoundRectLinearLayout jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout;
  private ApolloLinearLayoutNoPreview jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview;
  private List<anra> jdField_a_of_type_JavaUtilList;
  
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
    int i;
    label27:
    ViewGroup localViewGroup;
    anrc localanrc;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("试试有趣的3D形象");
      this.jdField_a_of_type_AndroidWidgetButton.setText("使用3D形象");
      i = 0;
      if (i >= this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount()) {
        return;
      }
      localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      localanrc = (anrc)localViewGroup.getTag();
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label236;
      }
      localViewGroup.setVisibility(0);
      localanrc.jdField_a_of_type_Anra = ((anra)this.jdField_a_of_type_JavaUtilList.get(i));
      ApolloActionData localApolloActionData = localanrc.jdField_a_of_type_Anra.a;
      localanrc.jdField_a_of_type_Anra.c = 0;
      localanrc.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
      localanrc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localanrc.jdField_a_of_type_Anra.a(getContext(), getContext().getResources().getDisplayMetrics().density));
      localanrc.e.setBackgroundDrawable(null);
      localanrc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localanrc.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localanrc.e.setVisibility(8);
      if (localanrc.jdField_a_of_type_AndroidViewView != null)
      {
        localViewGroup.removeView(localanrc.jdField_a_of_type_AndroidViewView);
        localanrc.jdField_a_of_type_AndroidViewView = null;
      }
    }
    for (;;)
    {
      i += 1;
      break label27;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("和好友一起来玩厘米秀吧！");
      this.jdField_a_of_type_AndroidWidgetButton.setText("开启厘米秀");
      break;
      label236:
      localViewGroup.setVisibility(4);
      localanrc.jdField_a_of_type_Anra = null;
      localanrc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (((anra)localIterator.next()).a.actionId == paramApolloActionData.actionId) {
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
    if (this.jdField_a_of_type_Ansl == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131368483: 
        this.jdField_a_of_type_Ansl.a(this);
        break;
      case 2131378285: 
        this.jdField_a_of_type_Ansl.b(this);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    findViewById(2131368483).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378285));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131361986);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367796));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview = new ApolloLinearLayoutNoPreview(getContext(), null, 0, 4, 1);
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview, -1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview.getChildAt(0));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379171));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout = ((RoundRectLinearLayout)findViewById(2131363625));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setRoundRect(agej.a(6.0F, getResources()), -10205955, false);
  }
  
  public void setActions(List<anra> paramList)
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
  
  public void setClickCallback(ansl paramansl)
  {
    this.jdField_a_of_type_Ansl = paramansl;
  }
  
  public void setGuideType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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