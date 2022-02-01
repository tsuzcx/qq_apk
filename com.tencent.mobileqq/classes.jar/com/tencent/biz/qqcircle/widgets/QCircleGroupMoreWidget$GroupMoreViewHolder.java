package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StImage;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;
import qqcircle.QQCircleDitto.StPymkItemInfoBizData;

class QCircleGroupMoreWidget$GroupMoreViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int b;
  private int c;
  private FeedBlockData d;
  private QQCircleDitto.StItemInfo e;
  private ImageView f;
  private QCircleAvatarView g;
  private TextView h;
  private QCircleAsyncTextView i;
  private RoundCorneredRelativeLayout j;
  private ImageView k;
  
  public QCircleGroupMoreWidget$GroupMoreViewHolder(QCircleGroupMoreWidget paramQCircleGroupMoreWidget, View paramView)
  {
    super(paramView);
    this.j = ((RoundCorneredRelativeLayout)paramView.findViewById(2131441690));
    if (this.j != null)
    {
      int m = ViewUtils.a(10.0F);
      paramQCircleGroupMoreWidget = this.j;
      float f1 = m;
      paramQCircleGroupMoreWidget.setRadius(f1, f1, f1, f1);
    }
    this.f = ((ImageView)paramView.findViewById(2131441691));
    this.g = ((QCircleAvatarView)paramView.findViewById(2131441688));
    this.h = ((TextView)paramView.findViewById(2131441694));
    this.i = ((QCircleAsyncTextView)paramView.findViewById(2131441689));
    this.k = ((ImageView)paramView.findViewById(2131441692));
  }
  
  private void a(View paramView)
  {
    if (this.e == null) {
      return;
    }
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUin(this.e.id.get());
    localQCircleInitBean.setFromReportBean(this.a.getReportBean().clone());
    QCircleLauncher.b(paramView.getContext(), localQCircleInitBean);
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder().setActionType(122).setSubActionType(2).setPageId(this.a.getReportBean().getPageId()).setToUin(this.e.id.get()).setFeedId(QCircleGroupMoreWidget.a(this.a, this.e.busiInfo.get(), "feedid")).setExt2(QCircleGroupMoreWidget.a(this.a)));
    QLog.d("QCircleGroupMoreWidget", 1, "click to mainPage");
  }
  
  private void a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    if ("true".equals(QCircleGroupMoreWidget.a(this.a, paramStItemInfo.busiInfo.get(), "is_video")))
    {
      this.k.setVisibility(0);
      return;
    }
    this.k.setVisibility(8);
  }
  
  private void b(View paramView)
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    localObject = QCircleGroupMoreWidget.a(this.a, ((QQCircleDitto.StItemInfo)localObject).urlInfo.get(), "detailpageUrl");
    QCircleLauncher.a(paramView.getContext(), (String)localObject);
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder().setActionType(122).setSubActionType(5).setPageId(this.a.getReportBean().getPageId()).setToUin(this.e.id.get()).setFeedId(QCircleGroupMoreWidget.a(this.a, this.e.busiInfo.get(), "feedid")).setExt2(QCircleGroupMoreWidget.a(this.a)));
    paramView = new StringBuilder();
    paramView.append("click to detail:");
    paramView.append((String)localObject);
    QLog.d("QCircleGroupMoreWidget", 1, paramView.toString());
  }
  
  private void b(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    this.j.setOnClickListener(this);
    this.h.setText(paramStItemInfo.name.get());
    this.h.setOnClickListener(this);
    QQCircleDitto.StPymkItemInfoBizData localStPymkItemInfoBizData = new QQCircleDitto.StPymkItemInfoBizData();
    try
    {
      localStPymkItemInfoBizData.mergeFrom(paramStItemInfo.bizData.get().toByteArray());
    }
    catch (InvalidProtocolBufferMicroException paramStItemInfo)
    {
      QLog.e("QCircleGroupMoreWidget", 1, "[bindPersonInfo] error: ", paramStItemInfo);
    }
    this.g.setUser(localStPymkItemInfoBizData.recomUser);
    this.g.setOnClickListener(this);
  }
  
  private void c(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    if (paramStItemInfo.images.get().size() > 0)
    {
      paramStItemInfo = new Option().setUrl(((FeedCloudMeta.StImage)paramStItemInfo.images.get(0)).picUrl.get()).setTargetView(this.f);
      QCircleFeedPicLoader.g().loadImage(paramStItemInfo, null);
      this.f.setOnClickListener(this);
    }
  }
  
  private void d(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    if (paramStItemInfo.des.get().size() > 0)
    {
      String str = (String)paramStItemInfo.des.get(0);
      paramStItemInfo = str;
      if (TextUtils.isEmpty(str)) {
        paramStItemInfo = this.a.getContext().getResources().getString(2131895751);
      }
      this.i.setText(paramStItemInfo);
      this.i.setOnClickListener(this);
    }
  }
  
  public QQCircleDitto.StItemInfo a()
  {
    return this.e;
  }
  
  public void a(FeedBlockData paramFeedBlockData, int paramInt1, QQCircleDitto.StItemInfo paramStItemInfo, int paramInt2)
  {
    this.d = paramFeedBlockData;
    this.b = paramInt1;
    this.e = paramStItemInfo;
    this.c = paramInt2;
    if (paramStItemInfo == null) {
      return;
    }
    d(paramStItemInfo);
    c(paramStItemInfo);
    b(paramStItemInfo);
    a(paramStItemInfo);
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if ((m != 2131441691) && (m != 2131441689))
    {
      if ((m == 2131441688) || (m == 2131441694)) {
        a(paramView);
      }
    }
    else {
      b(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleGroupMoreWidget.GroupMoreViewHolder
 * JD-Core Version:    0.7.0.1
 */