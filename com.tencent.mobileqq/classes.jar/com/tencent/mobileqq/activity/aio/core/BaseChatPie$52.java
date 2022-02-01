package com.tencent.mobileqq.activity.aio.core;

import bdla;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView.HorizonListViewTouchListener;
import com.tencent.widget.XEditTextEx;
import mqq.os.MqqHandler;

class BaseChatPie$52
  implements EmotionKeywordHorizonListView.HorizonListViewTouchListener
{
  BaseChatPie$52(BaseChatPie paramBaseChatPie) {}
  
  public void touchEventActionChanged(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.this$0.uiHandler.removeMessages(67);
      bdla.b(this.this$0.app, "CliOper", "", "", "ep_mall", "slide", 0, 0, "", "", "", this.this$0.input.getText().toString());
      return;
    }
    this.this$0.uiHandler.sendEmptyMessageDelayed(67, 6000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.52
 * JD-Core Version:    0.7.0.1
 */