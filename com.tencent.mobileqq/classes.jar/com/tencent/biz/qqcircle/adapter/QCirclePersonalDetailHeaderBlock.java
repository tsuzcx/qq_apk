package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonInfoWidget;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonInfoWidget.HeaderClickListener;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QCirclePersonalDetailHeaderBlock
  extends QCircleBaseSingleViewBlock
{
  private QCirclePersonInfoWidget a;
  private QCirclePersonInfoWidget.HeaderClickListener c;
  
  public QCirclePersonalDetailHeaderBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.a = new QCirclePersonInfoWidget(getContext());
    this.a.setReportBean(d());
    return this.a;
  }
  
  protected String a()
  {
    return "QCirclePersonalDetailHeaderBlock";
  }
  
  public void b()
  {
    QCirclePersonInfoWidget localQCirclePersonInfoWidget = this.a;
    if (localQCirclePersonInfoWidget != null) {
      localQCirclePersonInfoWidget.release();
    }
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = new StringBuilder();
    paramViewHolder.append("personDetail has dataList");
    boolean bool;
    if (this.mDataList != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramViewHolder.append(String.valueOf(bool));
    QLog.d("QCirclePersonalDetailHeaderBlock", 1, paramViewHolder.toString());
    if ((this.mDataList != null) && (this.mDataList.size() > 0))
    {
      if (this.a != null)
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append("personDetail mHeadPersonalDetailInfoView setData i");
        paramViewHolder.append(paramInt);
        QLog.d("QCirclePersonalDetailHeaderBlock", 1, paramViewHolder.toString());
        this.a.setInteractor(this.mInteractor);
        this.a.setData(this.mDataList.get(paramInt));
        this.a.setHeaderClickListener(this.c);
        return;
      }
      QLog.e("QCirclePersonalDetailHeaderBlock", 1, "personDetail mHeadPersonalDetailInfoView isnull");
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCirclePersonalDetailHeaderBlock
 * JD-Core Version:    0.7.0.1
 */