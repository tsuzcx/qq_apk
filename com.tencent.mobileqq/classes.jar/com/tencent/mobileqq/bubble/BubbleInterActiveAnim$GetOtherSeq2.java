package com.tencent.mobileqq.bubble;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

class BubbleInterActiveAnim$GetOtherSeq2
{
  private boolean a;
  private MessageRecord b;
  private SessionInfo c;
  private String d;
  private BubbleConfig e;
  private long f;
  private long g;
  private ChatMessage h;
  private String i;
  private BubbleConfig j;
  
  public BubbleInterActiveAnim$GetOtherSeq2(MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, String paramString1, BubbleConfig paramBubbleConfig1, long paramLong1, long paramLong2, ChatMessage paramChatMessage, String paramString2, BubbleConfig paramBubbleConfig2)
  {
    this.b = paramMessageRecord;
    this.c = paramSessionInfo;
    this.d = paramString1;
    this.e = paramBubbleConfig1;
    this.f = paramLong1;
    this.g = paramLong2;
    this.h = paramChatMessage;
    this.i = paramString2;
    this.j = paramBubbleConfig2;
  }
  
  boolean a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.f;
  }
  
  public long c()
  {
    return this.g;
  }
  
  public GetOtherSeq2 d()
  {
    boolean bool = BubbleInterActiveAnim.a(this.c, this.e, this.j);
    if ((!TextUtils.isEmpty(this.i)) && (!this.d.equals(this.i)) && (bool))
    {
      if (this.f == -1L) {
        this.f = this.h.uniseq;
      }
      this.g = BubbleInterActiveAnim.a(this.b, this.c, this.f, this.g, this.h, this.i);
    }
    if ((this.f != -1L) && (this.g != -1L))
    {
      this.a = true;
      return this;
    }
    this.a = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.GetOtherSeq2
 * JD-Core Version:    0.7.0.1
 */