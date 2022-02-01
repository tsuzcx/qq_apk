package com.tencent.biz.pubaccount.weishi_new.drama.history;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;

public class WSDramaHistoryAdapter
  extends BaseAdapter<WSDramaHistoryData, WSDramaHistoryHolder>
{
  private WSDramaPageFragment a;
  private boolean b = true;
  
  public WSDramaHistoryAdapter(Context paramContext, WSDramaPageFragment paramWSDramaPageFragment)
  {
    super(paramContext);
    this.a = paramWSDramaPageFragment;
  }
  
  public WSDramaHistoryHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new WSDramaHistoryHolder(paramViewGroup, this.a);
  }
  
  public void a(WSDramaHistoryHolder paramWSDramaHistoryHolder, int paramInt)
  {
    paramWSDramaHistoryHolder.a((WSDramaHistoryData)getDataList().get(paramInt));
  }
  
  public void a(BaseViewHolder<WSDramaHistoryData> paramBaseViewHolder)
  {
    super.onViewAttachedToWindow(paramBaseViewHolder);
    if (this.b) {
      return;
    }
    AbsWSDramaHolder localAbsWSDramaHolder = this.a.e();
    WSDramaBeaconReport.b(WSDramaUtils.b(localAbsWSDramaHolder), WSDramaUtils.a(localAbsWSDramaHolder), WSDramaUtils.c(localAbsWSDramaHolder), WSDramaUtils.d(localAbsWSDramaHolder), (WSDramaHistoryData)getDataList().get(paramBaseViewHolder.getAdapterPosition()), this.a.b(), paramBaseViewHolder.getAdapterPosition());
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */