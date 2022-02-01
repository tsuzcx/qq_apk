package com.tencent.mobileqq.activity.aio.item.graytipsitem;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.Holder;
import com.tencent.mobileqq.data.MessageRecord;

public class ShieldMsg
  implements HandleMsgType
{
  public void a(GrayTipsItemBuilder paramGrayTipsItemBuilder, MessageRecord paramMessageRecord, GrayTipsItemBuilder.Holder paramHolder, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, String paramString, LinearLayout paramLinearLayout, Context paramContext)
  {
    paramGrayTipsItemBuilder.c(paramOnLongClickAndTouchListener, paramHolder, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.graytipsitem.ShieldMsg
 * JD-Core Version:    0.7.0.1
 */