package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock;
import com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView;
import com.tencent.biz.richframework.part.block.BlockMerger.ShareData;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

public class QCircleTagPageHeaderBlock
  extends QCircleBaseSingleViewBlock
{
  private QCircleTagPageHeaderView a;
  private BlockMerger.ShareData c;
  
  public QCircleTagPageHeaderBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.a = new QCircleTagPageHeaderView(paramViewGroup.getContext());
    this.a.setReportBean(d());
    return this.a;
  }
  
  protected String a()
  {
    return "QCircleTagPageHeaderBlock";
  }
  
  public void handleShareDataChange(String paramString, BlockMerger.ShareData paramShareData)
  {
    super.handleShareDataChange(paramString, paramShareData);
    if ("share_key_tag_page_header_data".equals(paramString))
    {
      this.c = paramShareData;
      paramString = this.a;
      if (paramString != null) {
        paramString.setData(this.c);
      }
    }
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = this.a;
    if (paramViewHolder != null) {
      paramViewHolder.setData(this.c);
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleTagPageHeaderBlock
 * JD-Core Version:    0.7.0.1
 */