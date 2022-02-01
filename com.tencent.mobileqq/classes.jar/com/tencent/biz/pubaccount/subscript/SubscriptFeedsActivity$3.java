package com.tencent.biz.pubaccount.subscript;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class SubscriptFeedsActivity$3
  implements AbsListView.OnScrollListener
{
  SubscriptFeedsActivity$3(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      DropFrameMonitor.a().a("list_subscript");
    }
    for (;;)
    {
      return;
      DropFrameMonitor.a().a("list_subscript", false);
      paramInt = 0;
      while (paramInt <= paramAbsListView.getChildCount())
      {
        Object localObject = paramAbsListView.getChildAt(paramInt);
        if ((localObject != null) && ((((View)localObject).getTag() instanceof SubscriptFeedsAdapter.FeedItemCellHolder)))
        {
          localObject = (SubscriptFeedsAdapter.FeedItemCellHolder)((View)localObject).getTag();
          Drawable localDrawable = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject).b.getDrawable();
          if ((localDrawable != null) && ((localDrawable instanceof URLDrawable)) && (!((URLDrawable)localDrawable).isDownloadStarted()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SubscriptFeedsActivity", 2, "list child view start download pic!  uin : " + ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject).a);
            }
            ((URLDrawable)localDrawable).startDownload();
            ((URLDrawable)localDrawable).setAutoDownload(true);
          }
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.3
 * JD-Core Version:    0.7.0.1
 */