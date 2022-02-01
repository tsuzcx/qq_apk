package com.tencent.biz.qqcircle.immersive.part;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QFSLayerPageBottomPart
  extends QFSBasePart
  implements View.OnClickListener
{
  private LinearLayout a;
  private FeedBlockData b;
  
  private void d()
  {
    if (this.b == null)
    {
      QLog.e("QFSLayerPageBottomPart", 1, "[openCommentInput] mFeedData == null");
      return;
    }
    QCircleCommentInfo localQCircleCommentInfo = new QCircleCommentInfo();
    FeedBlockData localFeedBlockData = this.b;
    localQCircleCommentInfo.a = localFeedBlockData;
    localQCircleCommentInfo.b = localFeedBlockData.b();
    localQCircleCommentInfo.k = l();
    c("comment_input_window_show", localQCircleCommentInfo);
  }
  
  public String a()
  {
    return "QFSLayerPageBottomPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((LinearLayout)paramView.findViewById(2131433341));
    this.a.setOnClickListener(this);
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if ("layer_notify_part_update_feed".equals(paramString))
    {
      if (!(paramObject instanceof FeedBlockData)) {
        return;
      }
      this.b = ((FeedBlockData)paramObject);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131433341) {
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerPageBottomPart
 * JD-Core Version:    0.7.0.1
 */