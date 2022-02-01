package com.tencent.mobileqq.apollo.view;

import amlu;
import amlw;
import amnc;
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
  private amnc jdField_a_of_type_Amnc;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundRectLinearLayout jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout;
  private ApolloLinearLayoutNoPreview jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview;
  private List<amlu> jdField_a_of_type_JavaUtilList;
  
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
    amlw localamlw;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("试试有趣的3D形象");
      this.jdField_a_of_type_AndroidWidgetButton.setText("使用3D形象");
      i = 0;
      if (i >= this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount()) {
        return;
      }
      localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      localamlw = (amlw)localViewGroup.getTag();
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label236;
      }
      localViewGroup.setVisibility(0);
      localamlw.jdField_a_of_type_Amlu = ((amlu)this.jdField_a_of_type_JavaUtilList.get(i));
      ApolloActionData localApolloActionData = localamlw.jdField_a_of_type_Amlu.a;
      localamlw.jdField_a_of_type_Amlu.c = 0;
      localamlw.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
      localamlw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localamlw.jdField_a_of_type_Amlu.a(getContext(), getContext().getResources().getDisplayMetrics().density));
      localamlw.e.setBackgroundDrawable(null);
      localamlw.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localamlw.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localamlw.e.setVisibility(8);
      if (localamlw.jdField_a_of_type_AndroidViewView != null)
      {
        localViewGroup.removeView(localamlw.jdField_a_of_type_AndroidViewView);
        localamlw.jdField_a_of_type_AndroidViewView = null;
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
      localamlw.jdField_a_of_type_Amlu = null;
      localamlw.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
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
        if (((amlu)localIterator.next()).a.actionId == paramApolloActionData.actionId) {
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
    if (this.jdField_a_of_type_Amnc == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131368508: 
        this.jdField_a_of_type_Amnc.a(this);
        break;
      case 2131378054: 
        this.jdField_a_of_type_Amnc.b(this);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    findViewById(2131368508).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378054));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131361985);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367828));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview = new ApolloLinearLayoutNoPreview(getContext(), null, 0, 4, 1);
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview, -1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview.getChildAt(0));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378941));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout = ((RoundRectLinearLayout)findViewById(2131363657));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setRoundRect(AIOUtils.dp2px(6.0F, getResources()), -10205955, false);
  }
  
  public void setActions(List<amlu> paramList)
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
  
  public void setClickCallback(amnc paramamnc)
  {
    this.jdField_a_of_type_Amnc = paramamnc;
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