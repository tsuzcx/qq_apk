package com.tencent.mobileqq.activity.qwallet.emoj;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class EmojiRedPackPreviewFragment$2
  implements Runnable
{
  EmojiRedPackPreviewFragment$2(EmojiRedPackPreviewFragment paramEmojiRedPackPreviewFragment) {}
  
  public void run()
  {
    if (this.this$0.mPercent < 99)
    {
      EmojiRedPackPreviewFragment localEmojiRedPackPreviewFragment = this.this$0;
      localEmojiRedPackPreviewFragment.mPercent += 1;
      this.this$0.numberProbar.setProgress(this.this$0.mPercent / 100.0F);
      ThreadManager.getUIHandler().postDelayed(EmojiRedPackPreviewFragment.access$000(this.this$0), this.this$0.internalProgress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiRedPackPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */