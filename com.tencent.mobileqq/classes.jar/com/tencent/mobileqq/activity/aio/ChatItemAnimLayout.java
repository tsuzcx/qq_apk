package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import upk;

public class ChatItemAnimLayout
  extends RelativeLayout
{
  int D;
  int E = 255;
  public long a;
  private Handler a;
  public ChatItemAnimLayout.OnItemAnimEndListener a;
  public ChatMessage b;
  public float e = 1.0F;
  public float f = 1.0F;
  float g = 0.0F;
  float h = 0.0F;
  
  public ChatItemAnimLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidOsHandler = new upk(this);
  }
  
  public ChatItemAnimLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidOsHandler = new upk(this);
  }
  
  public ChatItemAnimLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidOsHandler = new upk(this);
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    if (this.b == null) {}
    do
    {
      return false;
      if (paramChatMessage == null) {
        return true;
      }
    } while ((this.b != paramChatMessage) && ((paramChatMessage.msgseq == 0L) || (this.b.msgseq != paramChatMessage.msgseq)) && ((paramChatMessage.msgUid == 0L) || (this.b.msgUid != paramChatMessage.msgUid)) && ((paramChatMessage.uniseq == 0L) || (this.b.uniseq != paramChatMessage.uniseq)));
    return true;
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if ((this.b != null) && (this.b != paramChatMessage))
    {
      this.h = 0.0F;
      this.E = 255;
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      this.b = paramChatMessage;
    }
  }
  
  public void a(ChatMessage paramChatMessage, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, ChatItemAnimLayout.OnItemAnimEndListener paramOnItemAnimEndListener)
  {
    if (a(paramChatMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemAnimLayout", 2, "startAnim isTheSameMsg");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemAnimLayout", 2, "startAnim");
    }
    this.b = paramChatMessage;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatItemAnimLayout$OnItemAnimEndListener = paramOnItemAnimEndListener;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.g = paramFloat1;
    this.h = paramFloat2;
    this.D = ((int)(paramFloat3 * 255.0F));
    this.E = ((int)(paramFloat4 * 255.0F));
    this.e = 0.0F;
    this.f = 0.0F;
    paramChatMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramChatMessage, 0L);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    float f1 = this.h;
    float f2 = this.g;
    float f3 = this.e;
    float f4 = this.g;
    setAlpha(((this.E - this.D) * this.f + this.D) / 255.0F);
    paramCanvas.translate((f1 - f2) * f3 + f4, 0.0F);
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatItemAnimLayout
 * JD-Core Version:    0.7.0.1
 */