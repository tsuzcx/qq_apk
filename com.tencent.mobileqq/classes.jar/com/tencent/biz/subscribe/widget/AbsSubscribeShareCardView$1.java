package com.tencent.biz.subscribe.widget;

class AbsSubscribeShareCardView$1
  implements Runnable
{
  AbsSubscribeShareCardView$1(AbsSubscribeShareCardView paramAbsSubscribeShareCardView, AbsSubscribeShareCardView.ShareDataBindListener paramShareDataBindListener) {}
  
  public void run()
  {
    AbsSubscribeShareCardView.ShareDataBindListener localShareDataBindListener = this.a;
    if (localShareDataBindListener != null) {
      localShareDataBindListener.onLoadSuccessed(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.1
 * JD-Core Version:    0.7.0.1
 */