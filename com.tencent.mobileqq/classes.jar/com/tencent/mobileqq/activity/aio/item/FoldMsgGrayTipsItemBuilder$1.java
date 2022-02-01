package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FoldMsgGrayTipsItemBuilder$1
  implements View.OnClickListener
{
  FoldMsgGrayTipsItemBuilder$1(FoldMsgGrayTipsItemBuilder paramFoldMsgGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = AIOUtils.a(paramView);
    if ((localObject1 instanceof MessageForFoldMsgGrayTips))
    {
      Object localObject2 = (MessageForFoldMsgGrayTips)localObject1;
      ((MessageForFoldMsgGrayTips)localObject2).isOpen = true;
      localObject1 = (FoldMsgGrayTipsItemBuilder.Holder)AIOUtils.b(paramView);
      ((FoldMsgGrayTipsItemBuilder.Holder)localObject1).d.setText(((MessageForFoldMsgGrayTips)localObject2).getShowMsgContent(this.a.a, this.a.c));
      localObject2 = ((FoldMsgGrayTipsItemBuilder.Holder)localObject1).d.getLayoutParams();
      if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        if (((ViewGroup.MarginLayoutParams)localObject2).rightMargin != AIOUtils.b(10.0F, this.a.c.getResources())) {
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = AIOUtils.b(10.0F, this.a.c.getResources());
        }
      }
      ((FoldMsgGrayTipsItemBuilder.Holder)localObject1).f.setVisibility(8);
      ((FoldMsgGrayTipsItemBuilder.Holder)localObject1).g.requestLayout();
      ReportController.b(this.a.a, "CliOper", "", "", "0X80064BD", "0X80064BD", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FoldMsgGrayTipsItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */