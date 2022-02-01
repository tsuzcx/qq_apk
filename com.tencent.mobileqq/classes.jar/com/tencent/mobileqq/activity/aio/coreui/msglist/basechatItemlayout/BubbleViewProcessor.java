package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;

public class BubbleViewProcessor
  implements IBubbleViewProcessor
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private BaseChatItemLayout jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
  private BaseChatItemLayoutViewBasicAbility jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewBasicAbility;
  
  public BubbleViewProcessor(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public BaseChatItemLayoutViewBasicAbility a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewBasicAbility == null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewBasicAbility = new BaseChatItemLayoutViewBasicAbilityImpl(localView);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewBasicAbility;
  }
  
  public BaseChatItemLayoutViewBasicAbility a(int paramInt)
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != paramView)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.removeView((View)localObject);
      boolean bool = paramView instanceof HorizontalListView;
      if (!bool) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramView);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramView, 0);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_AndroidViewView.setId(2131364521);
      if (!bool)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        int i = paramView.getContext().getResources().getDimensionPixelSize(2131296383);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
        ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b() == 1)
        {
          ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131364530);
          ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131364530);
          ((RelativeLayout.LayoutParams)localObject).addRule(0, 0);
        }
      }
    }
    paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.h);
    if ((localObject != null) && (((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull()) && (((BaseChatItemLayoutViewBasicAbility)localObject).getViewVisibility() == 0))
    {
      paramView.addRule(3, 2131364539);
      paramView.topMargin = 0;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append(" setBubbleView mTopId = R.id.chat_item_nick_name_layout, bubbleView = ");
        paramView.append(this.jdField_a_of_type_AndroidViewView.isPressed());
        QLog.d("BubbleView", 2, paramView.toString());
      }
    }
    else
    {
      paramView.addRule(3, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a());
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append(" setBubbleView mTopId  = ");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a());
        paramView.append(", bubbleView = ");
        paramView.append(this.jdField_a_of_type_AndroidViewView.isPressed());
        QLog.d("BubbleView", 2, paramView.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (paramBoolean)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131364530);
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131364530);
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 0);
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramInt);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" setHearIconPosition mTopId = ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("BubbleView", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BubbleViewProcessor
 * JD-Core Version:    0.7.0.1
 */