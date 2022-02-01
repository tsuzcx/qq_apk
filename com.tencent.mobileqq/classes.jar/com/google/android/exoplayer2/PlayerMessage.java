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
    try
    {
      Assertions.checkState(this.isSent);
      if (this.handler.getLooper().getThread() == Thread.currentThread()) {
        break label68;
      }
      bool = true;
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw localObject;
        }
        label68:
        boolean bool = false;
      }
    }
    Assertions.checkState(bool);
    while (!this.isProcessed) {
      wait();
    }
    bool = this.isDelivered;
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
      this.isDelivered = (paramBoolean | this.isDelivered);
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
    Assertions.checkState(this.isSent ^ true);
    if (this.positionMs == -9223372036854775807L) {
      Assertions.checkArgument(this.deleteAfterDelivery);
    }
    this.isSent = true;
    this.sender.sendMessage(this);
    return this;
  }
  
  public PlayerMessage setDeleteAfterDelivery(boolean paramBoolean)
  {
    Assertions.checkState(this.isSent ^ true);
    this.deleteAfterDelivery = paramBoolean;
    return this;
  }
  
  public PlayerMessage setHandler(Handler paramHandler)
  {
    Assertions.checkState(this.isSent ^ true);
    this.handler = paramHandler;
    return this;
  }
  
  public PlayerMessage setPayload(@Nullable Object paramObject)
  {
    Assertions.checkState(this.isSent ^ true);
    this.payload = paramObject;
    return this;
  }
  
  public PlayerMessage setPosition(int paramInt, long paramLong)
  {
    boolean bool2 = this.isSent;
    boolean bool1 = true;
    Assertions.checkState(bool2 ^ true);
    if (paramLong == -9223372036854775807L) {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    if ((paramInt >= 0) && ((this.timeline.isEmpty()) || (paramInt < this.timeline.getWindowCount())))
    {
      this.windowIndex = paramInt;
      this.positionMs = paramLong;
      return this;
    }
    throw new IllegalSeekPositionException(this.timeline, paramInt, paramLong);
  }
  
  public PlayerMessage setPosition(long paramLong)
  {
    Assertions.checkState(this.isSent ^ true);
    this.positionMs = paramLong;
    return this;
  }
  
  public PlayerMessage setType(int paramInt)
  {
    Assertions.checkState(this.isSent ^ true);
    this.type = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.PlayerMessage
 * JD-Core Version:    0.7.0.1
 */