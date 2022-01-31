package com.tencent.biz.qqcircle.comment;

import android.widget.TextView;
import tra;
import tuk;

public class QCircleCommentPanelView$5
  implements Runnable
{
  public QCircleCommentPanelView$5(tuk paramtuk, int paramInt) {}
  
  public void run()
  {
    if (tuk.a(this.this$0) != null)
    {
      if (this.a > 0)
      {
        tuk.a(this.this$0).setText(tra.b(this.a));
        tuk.a(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    tuk.a(this.this$0).setText("");
    tuk.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.5
 * JD-Core Version:    0.7.0.1
 */