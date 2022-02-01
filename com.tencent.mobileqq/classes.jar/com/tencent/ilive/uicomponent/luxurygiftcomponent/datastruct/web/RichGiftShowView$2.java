package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.web;

import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.IGiftAnimation;

class RichGiftShowView$2
  implements Runnable
{
  RichGiftShowView$2(RichGiftShowView paramRichGiftShowView) {}
  
  public void run()
  {
    RichGiftShowView.access$002(this.this$0, false);
    if (RichGiftShowView.access$100(this.this$0) != null) {
      RichGiftShowView.access$100(this.this$0).onEnd();
    }
    if (RichGiftShowView.access$200(this.this$0) != null) {
      RichGiftShowView.access$200(this.this$0).animationEnd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.web.RichGiftShowView.2
 * JD-Core Version:    0.7.0.1
 */