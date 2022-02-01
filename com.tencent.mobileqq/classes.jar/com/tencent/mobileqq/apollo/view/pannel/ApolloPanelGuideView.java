package com.tencent.mobileqq.apollo.view.pannel;

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
import annl;
import anoa;
import anpj;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
  private anpj jdField_a_of_type_Anpj;
  private RoundRectLinearLayout jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout;
  private ApolloLinearLayoutNoPreview jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayoutNoPreview;
  private List<annl> jdField_a_of_type_JavaUtilList;
  
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
    anoa localanoa;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("试试有趣的3D形象");
      this.jdField_a_of_type_AndroidWidgetButton.setText("使用3D形象");
      i = 0;
      if (i >= this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount()) {
        return;
      }
      localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      localanoa = (anoa)localViewGroup.getTag();
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label236;
      }
      localViewGroup.setVisibility(0);
      localanoa.jdField_a_of_type_Annl = ((annl)this.jdField_a_of_type_JavaUtilList.get(i));
      ApolloActionData localApolloActionData = localanoa.jdField_a_of_type_Annl.a;
      localanoa.jdField_a_of_type_Annl.c = 0;
      localanoa.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
      localanoa.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localanoa.jdField_a_of_type_Annl.a(getContext(), getContext().getResources().getDisplayMetrics().density));
      localanoa.e.setBackgroundDrawable(null);
      localanoa.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localanoa.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localanoa.e.setVisibility(8);
      if (localanoa.jdField_a_of_type_AndroidViewView != null)
      {
        localViewGroup.removeView(localanoa.jdField_a_of_type_AndroidViewView);
        localanoa.jdField_a_of_type_AndroidViewView = null;
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
      localanoa.jdField_a_of_type_Annl = null;
      localanoa.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
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
        if (((annl)localIterator.next()).a.actionId == paramApolloActionData.actionId) {
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
    if (this.jdField_a_of_type_Anpj == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131368666: 
        this.jdField_a_of_type_Anpj.a(this);
        break;
      case 2131378342: 
        this.jdField_a_of_type_Anpj.b(this);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    findViewById(2131368666).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378342));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131361987);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367964));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayoutNoPreview = new ApolloLinearLayoutNoPreview(getContext(), null, 0, 4, 1);
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayoutNoPreview, -1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayoutNoPreview.getChildAt(0));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379235));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout = ((RoundRectLinearLayout)findViewById(2131363726));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setRoundRect(AIOUtils.dp2px(6.0F, getResources()), -10205955, false);
  }
  
  public void setActions(List<annl> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    a();
  }
  
  public void setCallback(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayoutNoPreview.setCallback(paramBaseChatPie);
  }
  
  public void setClickCallback(anpj paramanpj)
  {
    this.jdField_a_of_type_Anpj = paramanpj;
  }
  
  public void setGuideType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayoutNoPreview.setSessionInfo(paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanelGuideView
 * JD-Core Version:    0.7.0.1
 */