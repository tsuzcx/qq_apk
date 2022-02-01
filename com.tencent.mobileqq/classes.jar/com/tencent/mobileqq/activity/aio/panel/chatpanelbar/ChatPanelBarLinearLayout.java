package com.tencent.mobileqq.activity.aio.panel.chatpanelbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

public abstract class ChatPanelBarLinearLayout
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public ChatPanelBarLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarLinearLayout
 * JD-Core Version:    0.7.0.1
 */