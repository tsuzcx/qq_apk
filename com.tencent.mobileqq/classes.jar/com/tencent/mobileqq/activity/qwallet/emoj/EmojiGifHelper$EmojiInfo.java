package com.tencent.mobileqq.activity.qwallet.emoj;

import com.tencent.mobileqq.activity.aio.SessionInfo;

public class EmojiGifHelper$EmojiInfo
{
  public String gifPath;
  public boolean isImmeSend;
  public final byte[] lock = new byte[0];
  public SessionInfo sessionInfo;
  public int tag;
  public EmojiGifHelper.CompositeTask task;
  
  public void onDestroy()
  {
    removeTask();
  }
  
  public void removeTask()
  {
    if (this.task != null)
    {
      this.task.cancel();
      this.task = null;
    }
    this.gifPath = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper.EmojiInfo
 * JD-Core Version:    0.7.0.1
 */