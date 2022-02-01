package com.tencent.biz.qqcircle.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleTagItemInfo;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StMedalInfo;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StTagMedalInfo;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleBase.CircleRankingData;

class QCircleTagListAdapter$TagViewHolder
  extends RecyclerView.ViewHolder
{
  public TextView a;
  public ViewGroup b;
  public SquareImageView c;
  
  QCircleTagListAdapter$TagViewHolder(QCircleTagListAdapter paramQCircleTagListAdapter, @NonNull View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131436836));
    this.b = ((ViewGroup)paramView.findViewById(2131437482));
    this.c = ((SquareImageView)paramView.findViewById(2131436829));
  }
  
  private void a()
  {
    if (this.a == null) {
      return;
    }
    VideoReport.setElementId(this.b, "em_xsj_medal_tag");
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    localMap.put("xsj_medal_content", this.a.getText());
    VideoReport.setElementParams(this.b, localMap);
  }
  
  private void a(QCircleTagItemInfo paramQCircleTagItemInfo)
  {
    if (paramQCircleTagItemInfo == null) {
      paramQCircleTagItemInfo = null;
    } else {
      paramQCircleTagItemInfo = paramQCircleTagItemInfo.d();
    }
    if (paramQCircleTagItemInfo == null)
    {
      QLog.d("RANK-QCircleTagListAdapter", 1, "[updateNewRankingInfoType] item info should not be null.");
      return;
    }
    this.a.setText(paramQCircleTagItemInfo.describe.get());
    QCircleFeedPicLoader.g().loadImage(new Option().setUrl(paramQCircleTagItemInfo.iconUrl.get()).setTargetView(this.c), null);
    this.b.setOnClickListener(new QCircleTagListAdapter.TagViewHolder.1(this, paramQCircleTagItemInfo));
  }
  
  private void b(QCircleTagItemInfo paramQCircleTagItemInfo)
  {
    if (paramQCircleTagItemInfo.b() == null) {
      return;
    }
    this.a.setText(paramQCircleTagItemInfo.b().rankDesc.get());
    QCircleFeedPicLoader.g().loadImage(new Option().setUrl(paramQCircleTagItemInfo.b().rankIconUrl.get()).setTargetView(this.c), null);
    this.b.setOnClickListener(new QCircleTagListAdapter.TagViewHolder.2(this, paramQCircleTagItemInfo));
    QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setActionType(11);
    int i;
    if (paramQCircleTagItemInfo.b().rankingType.get() == 1) {
      i = 53;
    } else {
      i = 52;
    }
    QCircleLpReportDc05504.report(localDataBuilder.setSubActionType(i).setThrActionType(1));
  }
  
  private void c(QCircleTagItemInfo paramQCircleTagItemInfo)
  {
    if (paramQCircleTagItemInfo.c() == null) {
      return;
    }
    this.a.setText(paramQCircleTagItemInfo.c().tagName.get());
    if ((paramQCircleTagItemInfo.c().medal.has()) && (paramQCircleTagItemInfo.c().medal.rank.get() > 0L)) {
      QCircleFeedPicLoader.g().loadImage(new Option().setUrl(paramQCircleTagItemInfo.c().tagIconUrl.get()).setTargetView(this.c), null);
    } else {
      this.c.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845363));
    }
    this.b.setOnClickListener(new QCircleTagListAdapter.TagViewHolder.3(this, paramQCircleTagItemInfo));
    QCircleTagListAdapter.a(this.d, 4, paramQCircleTagItemInfo.c());
  }
  
  public void a(QCircleTagItemInfo paramQCircleTagItemInfo, int paramInt)
  {
    if (paramQCircleTagItemInfo == null) {
      return;
    }
    if (paramQCircleTagItemInfo.a() == 2) {
      b(paramQCircleTagItemInfo);
    } else if (paramQCircleTagItemInfo.a() == 3) {
      a(paramQCircleTagItemInfo);
    } else if (paramQCircleTagItemInfo.a() == 1) {
      c(paramQCircleTagItemInfo);
    } else {
      this.c.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845363));
    }
    paramQCircleTagItemInfo = (RecyclerView.LayoutParams)this.b.getLayoutParams();
    if (paramInt == 0) {
      paramQCircleTagItemInfo.setMargins(0, 0, 0, 0);
    } else if (paramInt == QCircleTagListAdapter.a(this.d).size() - 1) {
      paramQCircleTagItemInfo.setMargins(ViewUtils.a(8.0F), 0, ViewUtils.a(38.0F), 0);
    } else {
      paramQCircleTagItemInfo.setMargins(ViewUtils.a(8.0F), 0, 0, 0);
    }
    this.b.setLayoutParams(paramQCircleTagItemInfo);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleTagListAdapter.TagViewHolder
 * JD-Core Version:    0.7.0.1
 */