package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleMessageNoticeInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.widgets.QCircleMessageNoticeView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QCircleMessageNoticeBubbleBlock
  extends QCircleBaseSingleViewBlock
{
  private QCircleMessageNoticeView a;
  private QCircleMessageNoticeInfo c;
  
  public QCircleMessageNoticeBubbleBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.a = new QCircleMessageNoticeView(getContext());
    this.a.setReportBean(d());
    return this.a;
  }
  
  protected String a()
  {
    return "QCircleMessage_QCircleMessageNoticeBubbleBlock";
  }
  
  public boolean b()
  {
    QCircleMessageNoticeView localQCircleMessageNoticeView = this.a;
    if (localQCircleMessageNoticeView != null) {
      return localQCircleMessageNoticeView.a;
    }
    return false;
  }
  
  public void c()
  {
    QCircleMessageNoticeView localQCircleMessageNoticeView = this.a;
    if (localQCircleMessageNoticeView != null) {
      localQCircleMessageNoticeView.a();
    }
  }
  
  protected int getFixedViewTypeOffset()
  {
    return 200000;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.d("QCircleMessage_QCircleMessageNoticeBubbleBlock", 1, "onBindViewHolder");
    if ((this.mDataList != null) && (this.mDataList.size() > 0))
    {
      this.c = ((QCircleMessageNoticeInfo)this.mDataList.get(paramInt));
      if (this.a != null)
      {
        QLog.d("QCircleMessage_QCircleMessageNoticeBubbleBlock", 1, "mMessageNoticeView not null");
        this.a.setData(this.c);
        return;
      }
      QLog.d("QCircleMessage_QCircleMessageNoticeBubbleBlock", 1, "mMessageNoticeView is null");
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleMessageNoticeBubbleBlock
 * JD-Core Version:    0.7.0.1
 */