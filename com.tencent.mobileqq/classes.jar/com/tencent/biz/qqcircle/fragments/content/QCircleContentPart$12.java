package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.biz.qqcircle.utils.QCircleThemeUtil;

class QCircleContentPart$12
  implements Runnable
{
  QCircleContentPart$12(QCircleContentPart paramQCircleContentPart, float paramFloat1, float paramFloat2) {}
  
  public void run()
  {
    if (this.this$0.c() == null) {
      return;
    }
    QCircleThemeUtil.a(this.this$0.c(), 0);
    if (QCircleContentPart.x(this.this$0))
    {
      QCircleContentPart.y(this.this$0);
      return;
    }
    QCircleContentPart.a(this.this$0, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.12
 * JD-Core Version:    0.7.0.1
 */