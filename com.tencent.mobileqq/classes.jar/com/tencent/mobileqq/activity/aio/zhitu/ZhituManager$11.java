package com.tencent.mobileqq.activity.aio.zhitu;

import com.tencent.mobileqq.doutu.DoutuEmotionHorizonListView.HorizonListViewTouchListener;
import mqq.os.MqqHandler;

class ZhituManager$11
  implements DoutuEmotionHorizonListView.HorizonListViewTouchListener
{
  ZhituManager$11(ZhituManager paramZhituManager, MqqHandler paramMqqHandler) {}
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_MqqOsMqqHandler == null);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
      return;
    } while (this.jdField_a_of_type_MqqOsMqqHandler == null);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(84, 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.11
 * JD-Core Version:    0.7.0.1
 */