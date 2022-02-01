package com.tencent.mobileqq.activity.aio.zhitu;

import mqq.os.MqqHandler;

class ZhituManager$11
  implements ZhituEmotionHorizonListView.HorizonListViewTouchListener
{
  ZhituManager$11(ZhituManager paramZhituManager, MqqHandler paramMqqHandler) {}
  
  public void a(int paramInt)
  {
    MqqHandler localMqqHandler;
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 3)) {
        return;
      }
      localMqqHandler = this.a;
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessageDelayed(84, 10000L);
      }
    }
    else
    {
      localMqqHandler = this.a;
      if (localMqqHandler != null) {
        localMqqHandler.removeMessages(84);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.11
 * JD-Core Version:    0.7.0.1
 */