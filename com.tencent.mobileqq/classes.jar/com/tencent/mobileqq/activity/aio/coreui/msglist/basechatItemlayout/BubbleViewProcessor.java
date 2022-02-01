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
  private BaseChatItemLayout a;
  private Context b;
  private View c;
  private BaseChatItemLayoutViewBasicAbility d;
  
  public BubbleViewProcessor(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    this.a = paramBaseChatItemLayout;
    this.b = paramContext;
  }
  
  public BaseChatItemLayoutViewBasicAbility a()
  {
    if (this.d == null)
    {
      View localView = this.c;
      if (localView != null) {
        this.d = new BaseChatItemLayoutViewBasicAbilityImpl(localView);
      }
    }
    return this.d;
  }
  
  public BaseChatItemLayoutViewBasicAbility a(int paramInt)
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Object localObject = this.c;
    if (localObject != paramView)
    {
      this.a.removeView((View)localObject);
      boolean bool = paramView instanceof HorizontalListView;
      if (!bool) {
        this.a.addView(paramView);
      } else {
        this.a.addView(paramView, 0);
      }
      this.c = paramView;
      this.c.setId(2131430578);
      if (!bool)
      {
        localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
        int i = paramView.getContext().getResources().getDimensionPixelSize(2131296615);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
        ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
        if (this.a.getHeadIconPosition() == 1)
        {
          ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131430587);
          ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131430587);
          ((RelativeLayout.LayoutParams)localObject).addRule(0, 0);
        }
      }
    }
    paramView = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    localObject = this.a.a(NickNameChatItemLayoutProcessor.h);
    if ((localObject != null) && (((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull()) && (((BaseChatItemLayoutViewBasicAbility)localObject).getViewVisibility() == 0))
    {
      paramView.addRule(3, 2131430596);
      paramView.topMargin = 0;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append(" setBubbleView mTopId = R.id.chat_item_nick_name_layout, bubbleView = ");
        paramView.append(this.c.isPressed());
        QLog.d("BubbleView", 2, paramView.toString());
      }
    }
    else
    {
      paramView.addRule(3, this.a.getTopId());
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append(" setBubbleView mTopId  = ");
        paramView.append(this.a.getTopId());
        paramView.append(", bubbleView = ");
        paramView.append(this.c.isPressed());
        QLog.d("BubbleView", 2, paramView.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (paramBoolean)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131430587);
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131430587);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BubbleViewProcessor
 * JD-Core Version:    0.7.0.1
 */