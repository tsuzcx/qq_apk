package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgSayHiHelper$2
  implements View.OnClickListener
{
  GameMsgSayHiHelper$2(GameMsgSayHiHelper paramGameMsgSayHiHelper) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131447213: 
      this.a.j();
      break;
    case 2131436909: 
      this.a.bL_();
      break;
    case 2131436869: 
      this.a.bK_();
      break;
    case 2131435409: 
      this.a.i();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgSayHiHelper.2
 * JD-Core Version:    0.7.0.1
 */