package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;

public final class PlayerMessage
{
  private boolean deleteAfterDelivery;
  private Handler handler;
  private boolean isDelivered;
  private boolean isProcessed;
  private boolean isSent;
  private Object payload;
  private long positionMs;
  private final PlayerMessage.Sender sender;
  private final PlayerMessage.Target target;
  private final Timeline timeline;
  private int type;
  private int windowIndex;
  
  public PlayerMessage(PlayerMessage.Sender paramSender, PlayerMessage.Target paramTarget, Timeline paramTimeline, int paramInt, Handler paramHandler)
  {
    this.sender = paramSender;
    this.target = paramTarget;
    this.timeline = paramTimeline;
    this.handler = paramHandler;
    this.windowIndex = paramInt;
    this.positionMs = -9223372036854775807L;
    this.deleteAfterDelivery = true;
  }
  
  public boolean blockUntilDelivered()
  {
    for (;;)
    {
      try
      {
        Assertions.checkState(this.isSent);
        if (this.handler.getLooper().getThread() != Thread.currentThread())
        {
          bool = true;
          Assertions.checkState(bool);
          if (this.isProcessed) {
            break;
          }
          wait();
          continue;
        }
        bool = false;
      }
      finally {}
    }
    boolean bool = this.isDelivered;
    return bool;
  }
  
  public boolean getDeleteAfterDelivery()
  {
    return this.deleteAfterDelivery;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public Object getPayload()
  {
    return this.payload;
  }
  
  public long getPositionMs()
  {
    return this.positionMs;
  }
  
  public PlayerMessage.Target getTarget()
  {
    return this.target;
  }
  
  public Timeline getTimeline()
  {
    return this.timeline;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int getWindowIndex()
  {
    return this.windowIndex;
  }
  
  public void markAsProcessed(boolean paramBoolean)
  {
    try
    {
      this.isDelivered |= paramBoolean;
      this.isProcessed = true;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public PlayerMessage send()
  {
    if (!this.isSent) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      if (this.positionMs == -9223372036854775807L) {
        Assertions.checkArgument(this.deleteAfterDelivery);
      }
      this.isSent = true;
      this.sender.sendMessage(this);
      return this;
    }
  }
  
  public PlayerMessage setDeleteAfterDelivery(boolean paramBoolean)
  {
    if (!this.isSent) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.deleteAfterDelivery = paramBoolean;
      return this;
    }
  }
  
  public PlayerMessage setHandler(Handler paramHandler)
  {
    if (!this.isSent) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.handler = paramHandler;
      return this;
    }
  }
  
  public PlayerMessage setPayload(@Nullable Object paramObject)
  {
    if (!this.isSent) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.payload = paramObject;
      return this;
    }
  }
  
  public PlayerMessage setPosition(int paramInt, long paramLong)
  {
    boolean bool2 = true;
    if (!this.isSent)
    {
      bool1 = true;
      Assertions.checkState(bool1);
      if (paramLong == -9223372036854775807L) {
        break label80;
      }
    }
    label80:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assertions.checkArgument(bool1);
      if ((paramInt >= 0) && ((this.timeline.isEmpty()) || (paramInt < this.timeline.getWindowCount()))) {
        break label86;
      }
      throw new IllegalSeekPositionException(this.timeline, paramInt, paramLong);
      bool1 = false;
      break;
    }
    label86:
    this.windowIndex = paramInt;
    this.positionMs = paramLong;
    return this;
  }
  
  public PlayerMessage setPosition(long paramLong)
  {
    if (!this.isSent) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.positionMs = paramLong;
      return this;
    }
  }
  
  public PlayerMessage setType(int paramInt)
  {
    if (!this.isSent) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.type = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.PlayerMessage
 * JD-Core Version:    0.7.0.1
 */