package com.tencent.biz.qqcircle.adapter;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import uzl;

public class QCircleCommentPanelBlock$2
  implements Runnable
{
  public void run()
  {
    uzl.b(this.this$0);
    this.this$0.notifyItemInserted(this.a);
    this.this$0.notifyItemRangeChanged(this.a, uzl.a(this.this$0).size() - this.a);
    uzl.a(this.this$0).scrollToPosition(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleCommentPanelBlock.2
 * JD-Core Version:    0.7.0.1
 */