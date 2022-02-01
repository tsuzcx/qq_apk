package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.miniaio.IChatShieldClick;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class ChatItemAnimLayout
  extends RelativeLayout
  implements IChatShieldClick
{
  private Handler a = new ChatItemAnimLayout.1(this);
  public ChatItemAnimLayout.OnItemAnimEndListener aA;
  protected boolean aB;
  protected boolean aC;
  float as = 1.0F;
  float at = 1.0F;
  float au = 0.0F;
  float av = 0.0F;
  int aw;
  int ax = 255;
  long ay = -1L;
  ChatMessage az;
  
  public ChatItemAnimLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ChatItemAnimLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChatItemAnimLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean b(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = this.az;
    boolean bool2 = false;
    if (localChatMessage == null) {
      return false;
    }
    if (paramChatMessage == null) {
      return true;
    }
    boolean bool1;
    if ((localChatMessage != paramChatMessage) && ((paramChatMessage.msgseq == 0L) || (this.az.msgseq != paramChatMessage.msgseq)) && ((paramChatMessage.msgUid == 0L) || (this.az.msgUid != paramChatMessage.msgUid)))
    {
      bool1 = bool2;
      if (paramChatMessage.uniseq != 0L)
      {
        bool1 = bool2;
        if (this.az.uniseq != paramChatMessage.uniseq) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    Object localObject = this.az;
    if ((localObject != null) && (localObject != paramChatMessage))
    {
      this.av = 0.0F;
      this.ax = 255;
      localObject = this.a.obtainMessage(2);
      this.a.sendMessage((Message)localObject);
      this.az = paramChatMessage;
    }
  }
  
  public void a(ChatMessage paramChatMessage, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, ChatItemAnimLayout.OnItemAnimEndListener paramOnItemAnimEndListener)
  {
    if (b(paramChatMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemAnimLayout", 2, "startAnim isTheSameMsg");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemAnimLayout", 2, "startAnim");
    }
    this.az = paramChatMessage;
    this.aA = paramOnItemAnimEndListener;
    this.ay = System.currentTimeMillis();
    this.au = paramFloat1;
    this.av = paramFloat2;
    this.aw = ((int)(paramFloat3 * 255.0F));
    this.ax = ((int)(paramFloat4 * 255.0F));
    this.as = 0.0F;
    this.at = 0.0F;
    paramChatMessage = this.a.obtainMessage(0);
    this.a.sendMessageDelayed(paramChatMessage, 0L);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    float f1 = this.av;
    float f2 = this.au;
    float f3 = this.as;
    int i = this.ax;
    int j = this.aw;
    setAlpha(((i - j) * this.at + j) / 255.0F);
    paramCanvas.translate((f1 - f2) * f3 + f2, 0.0F);
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  public void setFrom(boolean paramBoolean)
  {
    this.aC = paramBoolean;
  }
  
  public void setIsShieldTouchForItem(boolean paramBoolean)
  {
    this.aB = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatItemAnimLayout
 * JD-Core Version:    0.7.0.1
 */