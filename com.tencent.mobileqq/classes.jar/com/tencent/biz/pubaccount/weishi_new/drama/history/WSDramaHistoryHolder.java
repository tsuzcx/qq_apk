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
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSDramaPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment;
  private WSDramaHistoryData jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryData;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public WSDramaHistoryHolder(ViewGroup paramViewGroup, WSDramaPageFragment paramWSDramaPageFragment)
  {
    super(paramViewGroup, 2131560000);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment = paramWSDramaPageFragment;
    a();
  }
  
  private int a()
  {
    return (WeishiUIUtil.c() - WeishiUIUtil.h * 2 - WeishiUIUtil.d * 2) / 3;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)this.itemView.findViewById(2131376627));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.itemView.findViewById(2131379645));
    this.b = ((TextView)this.itemView.findViewById(2131379638));
    this.c = ((TextView)this.itemView.findViewById(2131379643));
    this.d = ((TextView)this.itemView.findViewById(2131379644));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(WeishiUIUtil.s, 0);
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
    this.b.setText(localStringBuilder);
  }
  
  private void b()
  {
    AbsWSDramaHolder localAbsWSDramaHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment.a();
    WSDramaBeaconReport.a(WSDramaUtils.b(localAbsWSDramaHolder), WSDramaUtils.a(localAbsWSDramaHolder), WSDramaUtils.c(localAbsWSDramaHolder), WSDramaUtils.a(localAbsWSDramaHolder), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryData, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment.a(), getAdapterPosition());
  }
  
  private void c()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.getLayoutParams();
    localLayoutParams.width = a();
    localLayoutParams.height = ((int)(a() * 1.333333F));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt, stDramaInfo paramstDramaInfo)
  {
    int i = paramstDramaInfo.curWatchedFeedNum;
    if (paramInt <= paramstDramaInfo.curWatchedFeedNum) {
      paramInt = i;
    }
    paramstDramaInfo = this.d;
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
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryData = paramWSDramaHistoryData;
    Object localObject = paramWSDramaHistoryData.a;
    if (localObject != null)
    {
      if (((stDrama)localObject).dramaInfo == null) {
        return;
      }
      localObject = ((stDrama)localObject).dramaInfo;
      WSPicLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, ((stDramaInfo)localObject).coverImg, WSFeedUtils.a(2131165740));
      this.c.setText(((stDramaInfo)localObject).name);
      if ((getAdapterPosition() == 0) && (paramWSDramaHistoryData.a())) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      a((stDramaInfo)localObject);
      a(((stDramaInfo)localObject).curWatchedFeedNum, (stDramaInfo)localObject);
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryHolder
 * JD-Core Version:    0.7.0.1
 */