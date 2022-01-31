package com.tencent.mobileqq.activity.aio.zhitu;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import wjp;

public class ZhituPanelView$ZhituViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public ProgressBar a;
  public RelativeLayout a;
  public BubbleImageView a;
  public WeakReference a;
  
  public ZhituPanelView$ZhituViewHolder(ZhituPanelView paramZhituPanelView, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramView.findViewById(2131375626));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(5.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.b = false;
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131375627));
    paramView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    paramView = (ZhituPicData)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramView == null) || (paramView.jdField_a_of_type_JavaLangString == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData == null)) {
      return;
    }
    ThreadManager.post(new wjp(this, paramView), 8, null, false);
    ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a.ar();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.ZhituViewHolder
 * JD-Core Version:    0.7.0.1
 */