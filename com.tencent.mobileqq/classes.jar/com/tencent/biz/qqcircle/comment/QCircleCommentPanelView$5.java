package com.tencent.biz.qqcircle.comment;

import android.widget.TextView;
import tra;
import tuz;

public class QCircleCommentPanelView$5
  implements Runnable
{
  public QCircleCommentPanelView$5(tuz paramtuz, int paramInt) {}
  
  public void run()
  {
    if (tuz.a(this.this$0) != null)
    {
      if (this.a > 0)
      {
        tuz.a(this.this$0).setText(tra.b(this.a));
        tuz.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    tuz.a(this.this$0).setText("");
    tuz.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.5
 * JD-Core Version:    0.7.0.1
 */