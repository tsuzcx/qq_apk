package com.tencent.biz.qqcircle.widgets;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;

class QCircleDraftRecyclerView$DraftAdapter$DraftViewHolder$1
  extends QCirclePicStateListener
{
  QCircleDraftRecyclerView$DraftAdapter$DraftViewHolder$1(QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder paramDraftViewHolder, ImageView paramImageView) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    if (paramInt == 6)
    {
      paramOption = new BitmapDrawable(paramOption.getResultBitMap());
      RFThreadManager.getUIHandler().post(new QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.1.1(this, paramOption));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.1
 * JD-Core Version:    0.7.0.1
 */