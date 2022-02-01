package com.tencent.biz.qqcircle.fragments.feeddetail;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;

class QCircleFeedDetailBodyPart$1
  extends RecyclerView.OnScrollListener
{
  QCircleFeedDetailBodyPart$1(QCircleFeedDetailBodyPart paramQCircleFeedDetailBodyPart, String paramString1, String paramString2) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((this.c.be_().getLayoutManager() instanceof SafeLinearLayoutManager))
    {
      paramInt1 = ((SafeLinearLayoutManager)this.c.be_().getLayoutManager()).findFirstVisibleItemPosition();
      if ((QCircleFeedDetailBodyPart.a(this.c) != paramInt1) && (QCircleFeedDetailBodyPart.b(this.c) != null))
      {
        TextView localTextView = QCircleFeedDetailBodyPart.b(this.c);
        if (paramInt1 > 1) {
          paramRecyclerView = this.a;
        } else {
          paramRecyclerView = this.b;
        }
        localTextView.setText(paramRecyclerView);
      }
      QCircleFeedDetailBodyPart.a(this.c, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailBodyPart.1
 * JD-Core Version:    0.7.0.1
 */