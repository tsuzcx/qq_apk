package com.tencent.biz.pubaccount.weishi_new.drama.history;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class WSDramaHistoryHolder
  extends BaseViewHolder<WSDramaHistoryData>
{
  private RoundCornerImageView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private WSDramaPageFragment f;
  private WSDramaHistoryData g;
  
  public WSDramaHistoryHolder(ViewGroup paramViewGroup, WSDramaPageFragment paramWSDramaPageFragment)
  {
    super(paramViewGroup, 2131626043);
    this.f = paramWSDramaPageFragment;
    a();
  }
  
  private void a()
  {
    this.a = ((RoundCornerImageView)this.itemView.findViewById(2131444887));
    this.b = ((TextView)this.itemView.findViewById(2131448417));
    this.c = ((TextView)this.itemView.findViewById(2131448410));
    this.d = ((TextView)this.itemView.findViewById(2131448415));
    this.e = ((TextView)this.itemView.findViewById(2131448416));
    this.a.setCorner(WeishiUIUtil.u, 0);
    this.itemView.setOnClickListener(new WSDramaHistoryHolder.1(this));
  }
  
  private void a(stDramaInfo paramstDramaInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramstDramaInfo.isPublishCompleted)
    {
      localStringBuilder.append("全");
      localStringBuilder.append(paramstDramaInfo.curPublishedFeedNum);
      localStringBuilder.append("集");
    }
    else
    {
      localStringBuilder.append("更新到");
      localStringBuilder.append(paramstDramaInfo.curPublishedFeedNum);
      localStringBuilder.append("集");
    }
    this.c.setText(localStringBuilder);
  }
  
  private void b()
  {
    AbsWSDramaHolder localAbsWSDramaHolder = this.f.e();
    WSDramaBeaconReport.a(WSDramaUtils.b(localAbsWSDramaHolder), WSDramaUtils.a(localAbsWSDramaHolder), WSDramaUtils.c(localAbsWSDramaHolder), WSDramaUtils.d(localAbsWSDramaHolder), this.g, this.f.b(), getAdapterPosition());
  }
  
  private void c()
  {
    ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
    localLayoutParams.width = d();
    localLayoutParams.height = ((int)(d() * 1.333333F));
    this.a.setLayoutParams(localLayoutParams);
  }
  
  private int d()
  {
    return (WeishiUIUtil.c() - WeishiUIUtil.i * 2 - WeishiUIUtil.d * 2) / 3;
  }
  
  public void a(int paramInt, stDramaInfo paramstDramaInfo)
  {
    int i = paramstDramaInfo.curWatchedFeedNum;
    if (paramInt <= paramstDramaInfo.curWatchedFeedNum) {
      paramInt = i;
    }
    paramstDramaInfo = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("观看到第");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("集");
    paramstDramaInfo.setText(localStringBuilder);
  }
  
  public void a(WSDramaHistoryData paramWSDramaHistoryData)
  {
    super.bindData(paramWSDramaHistoryData);
    if (paramWSDramaHistoryData == null) {
      return;
    }
    this.g = paramWSDramaHistoryData;
    Object localObject = paramWSDramaHistoryData.a;
    if (localObject != null)
    {
      if (((stDrama)localObject).dramaInfo == null) {
        return;
      }
      localObject = ((stDrama)localObject).dramaInfo;
      WSPicLoader.a().a(this.a, ((stDramaInfo)localObject).coverImg, WSFeedUtils.f(2131166336));
      this.d.setText(((stDramaInfo)localObject).name);
      if ((getAdapterPosition() == 0) && (paramWSDramaHistoryData.a())) {
        this.b.setVisibility(0);
      } else {
        this.b.setVisibility(8);
      }
      a((stDramaInfo)localObject);
      a(((stDramaInfo)localObject).curWatchedFeedNum, (stDramaInfo)localObject);
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryHolder
 * JD-Core Version:    0.7.0.1
 */