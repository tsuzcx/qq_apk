package com.tencent.mobileqq.apollo.lightGame;

import alvk;
import alvl;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class QuickInputTipsBar
  extends LinearLayout
  implements View.OnClickListener
{
  private alvk a;
  
  public QuickInputTipsBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    super.setOrientation(0);
    super.setGravity(16);
  }
  
  public void a()
  {
    super.clearAnimation();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(600L);
    localAlphaAnimation.setFillAfter(true);
    super.startAnimation(localAlphaAnimation);
  }
  
  public void a(List<alvl> paramList)
  {
    super.clearAnimation();
    super.removeAllViews();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject1 = (alvl)paramList.get(i);
        if (localObject1 == null)
        {
          i += 1;
        }
        else
        {
          Object localObject2 = new LinearLayout(getContext());
          ((LinearLayout)localObject2).setBackgroundResource(2130838476);
          ((LinearLayout)localObject2).setGravity(17);
          localObject2 = new TextView(getContext());
          ((TextView)localObject2).setGravity(17);
          ((TextView)localObject2).setTextColor(-6908266);
          ((TextView)localObject2).setTextSize(14.0F);
          ((TextView)localObject2).setText(((alvl)localObject1).a);
          ((TextView)localObject2).setTag(localObject1);
          ((TextView)localObject2).setOnClickListener(this);
          ((TextView)localObject2).setBackgroundResource(2130838476);
          int j = AIOUtils.dp2px(10.0F, getContext().getResources());
          ((TextView)localObject2).setPadding(j, 0, j, 0);
          localObject1 = new LinearLayout.LayoutParams(-2, -2);
          if (i == 0) {}
          for (((LinearLayout.LayoutParams)localObject1).leftMargin = AIOUtils.dp2px(8.0F, getContext().getResources());; ((LinearLayout.LayoutParams)localObject1).leftMargin = AIOUtils.dp2px(5.0F, getContext().getResources()))
          {
            ((LinearLayout.LayoutParams)localObject1).rightMargin = AIOUtils.dp2px(5.0F, getContext().getResources());
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.dp2px(2.0F, getContext().getResources());
            super.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
            break;
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (((localObject instanceof alvl)) && (this.a != null)) {
      this.a.a((alvl)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setTipsClickListener(alvk paramalvk)
  {
    this.a = paramalvk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.QuickInputTipsBar
 * JD-Core Version:    0.7.0.1
 */