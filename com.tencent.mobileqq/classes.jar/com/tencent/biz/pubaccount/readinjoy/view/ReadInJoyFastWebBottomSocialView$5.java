package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.widget.BubblePopupWindow;

class ReadInJoyFastWebBottomSocialView$5
  implements Runnable
{
  ReadInJoyFastWebBottomSocialView$5(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void run()
  {
    Context localContext = ReadInJoyFastWebBottomSocialView.a(this.this$0).a().getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
      ReadInJoyFastWebBottomSocialView.a(this.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialView.5
 * JD-Core Version:    0.7.0.1
 */