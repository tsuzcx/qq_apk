package com.tencent.mobileqq.app.qqdaily;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import cooperation.qzone.contentbox.MsgCardView;

public class QQDailyMsgContainer
  extends LinearLayout
{
  public QQDailyMsgContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQDailyMsgContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQDailyMsgContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setMainCard(MsgCardView paramMsgCardView)
  {
    addView(paramMsgCardView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyMsgContainer
 * JD-Core Version:    0.7.0.1
 */