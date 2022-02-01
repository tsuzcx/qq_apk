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
      localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessageDelayed(84, 10000L);
      }
    }
    else
    {
      localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localMqqHandler != null) {
        localMqqHandler.removeMessages(84);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.11
 * JD-Core Version:    0.7.0.1
 */