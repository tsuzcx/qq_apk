package com.tencent.biz.pubaccount.ecshopassit.aio;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public abstract interface IEcshopChatPie
{
  public abstract void a(Context paramContext);
  
  public abstract void a(MessageRecord paramMessageRecord);
  
  public abstract void a(List<ChatMessage> paramList, IEcshopChatPie.IRefreshCallback paramIRefreshCallback);
  
  public abstract boolean a(Context paramContext, RelativeLayout paramRelativeLayout);
  
  public abstract boolean a(RelativeLayout paramRelativeLayout);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.aio.IEcshopChatPie
 * JD-Core Version:    0.7.0.1
 */