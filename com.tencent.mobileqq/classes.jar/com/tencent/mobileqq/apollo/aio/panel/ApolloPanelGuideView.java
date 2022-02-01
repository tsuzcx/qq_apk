package com.tencent.mobileqq.apollo.aio.panel;

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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.store.openbox.RoundRectLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
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
  private ApolloLinearLayoutNoPreview jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloLinearLayoutNoPreview;
  private ApolloPanelGuideView.ClickCallback jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView$ClickCallback;
  private RoundRectLinearLayout jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout;
  private List<ApolloInfo> jdField_a_of_type_JavaUtilList;
  
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
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("试试有趣的3D形象");
      this.jdField_a_of_type_AndroidWidgetButton.setText("使用3D形象");
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("和好友一起来玩厘米秀吧！");
      this.jdField_a_of_type_AndroidWidgetButton.setText("开启厘米秀");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)localViewGroup.getTag();
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localViewGroup.setVisibility(0);
        localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(i));
        ApolloActionData localApolloActionData = localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction;
        localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mBinderType = 0;
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.getPanelDrawable(getContext(), getContext().getResources().getDisplayMetrics().density));
        localViewHolder.e.setBackgroundDrawable(null);
        localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localViewHolder.e.setVisibility(8);
        if (localViewHolder.jdField_a_of_type_AndroidViewView != null)
        {
          localViewGroup.removeView(localViewHolder.jdField_a_of_type_AndroidViewView);
          localViewHolder.jdField_a_of_type_AndroidViewView = null;
        }
      }
      else
      {
        localViewGroup.setVisibility(4);
        localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo = null;
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((ApolloInfo)((Iterator)localObject).next()).mAction.actionId == paramApolloActionData.actionId) {
        post(new ApolloPanelGuideView.1(this));
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView$ClickCallback == null) {
      return;
    }
    int i = paramView.getId();
    if (i != 2131368624)
    {
      if (i != 2131378164) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView$ClickCallback.b(this);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView$ClickCallback.a(this);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    findViewById(2131368624).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378164));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131362005);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367925));
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloLinearLayoutNoPreview = new ApolloLinearLayoutNoPreview(getContext(), null, 0, 4, 1);
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloLinearLayoutNoPreview, -1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloLinearLayoutNoPreview.getChildAt(0));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379011));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout = ((RoundRectLinearLayout)findViewById(2131363750));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setRoundRect(AIOUtils.b(6.0F, getResources()), -10205955, false);
  }
  
  public void setActions(List<ApolloInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    a();
  }
  
  public void setCallback(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloLinearLayoutNoPreview.setCallback(paramBaseChatPie);
  }
  
  public void setClickCallback(ApolloPanelGuideView.ClickCallback paramClickCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelGuideView$ClickCallback = paramClickCallback;
  }
  
  public void setGuideType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloLinearLayoutNoPreview.setSessionInfo(paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelGuideView
 * JD-Core Version:    0.7.0.1
 */