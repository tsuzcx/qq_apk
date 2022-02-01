package com.tencent.mobileqq.activity.aio.item.graytipsitem;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.Holder;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class TextSafe
  implements HandleMsgType
{
  public void a(GrayTipsItemBuilder paramGrayTipsItemBuilder, MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, String paramString, LinearLayout paramLinearLayout, Context paramContext)
  {
    if ((paramMessageRecord instanceof MessageForSafeGrayTips)) {
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
      }
    }
    for (paramMessageRecord = (MessageForSafeGrayTips)paramMessageRecord;; paramMessageRecord = null)
    {
      paramGrayTipsItemBuilder.a(paramMessageRecord, paramHolder.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.graytipsitem.TextSafe
 * JD-Core Version:    0.7.0.1
 */