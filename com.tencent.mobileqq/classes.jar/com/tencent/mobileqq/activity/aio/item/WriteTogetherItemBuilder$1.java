package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WriteTogetherItemBuilder$1
  implements View.OnClickListener
{
  WriteTogetherItemBuilder$1(WriteTogetherItemBuilder paramWriteTogetherItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = AIOUtils.a(paramView);
    if (!(localObject instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.w("WriteTogetherItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (MessageForText)localObject;
      if (!this.a.a())
      {
        if ((paramView instanceof ETTextView)) {
          ((ETTextView)paramView).startAnimation(true, false);
        }
        if (!WriteTogetherItemBuilder.a(this.a))
        {
          WriteTogetherItemBuilder.b(this.a, true);
          ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherItemBuilder.1.1(this, (MessageForText)localObject), 500L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.WriteTogetherItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */