package com.tencent.biz.qqcircle.adapter;

import java.util.ArrayList;
import uzl;

public class QCircleCommentPanelBlock$3
  implements Runnable
{
  public QCircleCommentPanelBlock$3(uzl paramuzl, int paramInt) {}
  
  public void run()
  {
    uzl.b(this.this$0);
    this.this$0.notifyItemRemoved(this.a);
    this.this$0.notifyItemRangeChanged(this.a, uzl.b(this.this$0).size() - this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock.3
 * JD-Core Version:    0.7.0.1
 */