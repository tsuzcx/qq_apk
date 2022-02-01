package com.tencent.biz.pubaccount.subscript;

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
    if (paramInt != 0)
    {
      DropFrameMonitor.b().a("list_subscript");
      return;
    }
    Object localObject1 = DropFrameMonitor.b();
    paramInt = 0;
    ((DropFrameMonitor)localObject1).a("list_subscript", false);
    while (paramInt <= paramAbsListView.getChildCount())
    {
      localObject1 = paramAbsListView.getChildAt(paramInt);
      if ((localObject1 != null) && ((((View)localObject1).getTag() instanceof SubscriptFeedsAdapter.FeedItemCellHolder)))
      {
        localObject1 = (SubscriptFeedsAdapter.FeedItemCellHolder)((View)localObject1).getTag();
        Object localObject2 = ((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).h.getDrawable();
        if ((localObject2 != null) && ((localObject2 instanceof URLDrawable)))
        {
          localObject2 = (URLDrawable)localObject2;
          if (!((URLDrawable)localObject2).isDownloadStarted())
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("list child view start download pic!  uin : ");
              localStringBuilder.append(((SubscriptFeedsAdapter.FeedItemCellHolder)localObject1).a);
              QLog.d("SubscriptFeedsActivity", 2, localStringBuilder.toString());
            }
            ((URLDrawable)localObject2).startDownload();
            ((URLDrawable)localObject2).setAutoDownload(true);
          }
        }
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.3
 * JD-Core Version:    0.7.0.1
 */