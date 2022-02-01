package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.utils.QCircleProtoUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCircleDefaultMessagePresenter
  extends QCircleBaseMessagePresenter
{
  protected QCircleRoundImageView q;
  protected ImageView r;
  protected View s;
  protected View.OnClickListener t;
  protected View.OnClickListener u;
  protected View.OnClickListener v;
  private ViewStub w;
  
  public QCircleDefaultMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  private QCircleLayerBean a(boolean paramBoolean)
  {
    try
    {
      if (this.d.feed.get() != null)
      {
        QCircleLayerBean localQCircleLayerBean = new QCircleLayerBean();
        QCircleProtoUtil.a(this.d.feed, 3);
        localQCircleLayerBean.setFeed(this.d.feed);
        localObject = new QCircleExtraTypeInfo();
        ((QCircleExtraTypeInfo)localObject).sourceType = 1002;
        localQCircleLayerBean.setExtraTypeInfo((QCircleExtraTypeInfo)localObject);
        a(localQCircleLayerBean, paramBoolean);
        localQCircleLayerBean.setSingleFeed(true);
        return localQCircleLayerBean;
      }
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpDetailPageError:");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("QCircleDefaultMessagePresenter", 1, ((StringBuilder)localObject).toString());
      localException.printStackTrace();
    }
    return null;
  }
  
  private void b(FeedCloudMeta.StNotice paramStNotice)
  {
    if (!TextUtils.isEmpty(paramStNotice.feed.cover.picUrl.get()))
    {
      if (this.s == null)
      {
        localObject = this.w;
        if (localObject != null) {
          this.s = ((ViewStub)localObject).inflate();
        }
      }
      Object localObject = this.s;
      if (localObject != null)
      {
        this.q = ((QCircleRoundImageView)((View)localObject).findViewById(2131436373));
        this.r = ((ImageView)this.s.findViewById(2131436374));
        localObject = this.s;
        int i = 0;
        ((View)localObject).setVisibility(0);
        this.q.setRoundRect(ViewUtils.a(4.0F));
        if ((this.q.getTag(2131441759) instanceof String)) {
          localObject = (String)this.q.getTag(2131441759);
        } else {
          localObject = "";
        }
        String str = paramStNotice.feed.cover.picUrl.get();
        this.q.setTag(2131441759, str);
        if (!((String)localObject).equals(str))
        {
          localObject = new Option().setUrl(str).setTargetView(this.q).setFromPreLoad(false).setPredecode(true).setRequestWidth(this.q.getWidth()).setRequestHeight(this.q.getHeight());
          QCircleFeedPicLoader.g().loadImage((Option)localObject, new QCircleDefaultMessagePresenter.1(this));
        }
        localObject = this.r;
        if (!QCirclePluginUtil.e(paramStNotice.feed)) {
          i = 8;
        }
        ((ImageView)localObject).setVisibility(i);
        this.s.setOnClickListener(i());
        a(this.s, paramStNotice.operation.opUser.id.get(), paramStNotice.feed.id.get(), paramStNotice.feed.poster.id.get());
      }
    }
  }
  
  protected void a(View paramView)
  {
    Object localObject;
    if ((this.s != null) && (paramView.getId() == this.s.getId()))
    {
      localObject = new QCircleLpReportDc05504.DataBuilder().setActionType(17).setSubActionType(3).setThrActionType(0);
      if (this.d != null) {
        paramView = this.d.busiReport.get().toByteArray();
      } else {
        paramView = null;
      }
      QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setMsgReportInfo(paramView).setPageId(d().getPageId()));
      return;
    }
    if ((this.h != null) && (paramView.getId() == this.h.getId()))
    {
      paramView = new QCircleLpReportDc05504.DataBuilder().setToUin(this.d.operation.opUser.id.get()).setActionType(17).setSubActionType(18).setThrActionType(1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append("");
      QCircleLpReportDc05504.report(paramView.setExt5(((StringBuilder)localObject).toString()).setExt6(this.d.operation.opUser.id.get()).setMsgReportInfo(this.d.busiReport.get().toByteArray()).setPageId(d().getPageId()));
    }
  }
  
  protected void a(View paramView, String paramString1, String paramString2, String paramString3)
  {
    VideoReport.setElementId(paramView, "em_xsj_feed_thumbnail");
    Map localMap = new QCircleDTParamBuilder().buildElementParams();
    localMap.put("xsj_from_uin", paramString1);
    localMap.put("xsj_feed_id", paramString2);
    localMap.put("xsj_author_uin", paramString3);
    VideoReport.setElementParams(paramView, localMap);
  }
  
  protected void a(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    if ((this.l == 13) && (this.d != null) && (this.d.operation != null) && (this.d.operation.like != null))
    {
      QQCircleFeedBase.StLikeBusiData localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
      try
      {
        localStLikeBusiData.mergeFrom(this.d.operation.like.busiData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      paramQCircleInitBean.setPolyLike((QQCircleFeedBase.StPolyLike)localStLikeBusiData.curPolyLikeInfo.get());
      paramQCircleInitBean = new StringBuilder();
      paramQCircleInitBean.append("fullscreen url");
      paramQCircleInitBean.append(localStLikeBusiData.curPolyLikeInfo.fullScreenURLAND.get());
      QLog.d("QCircleDefaultMessagePresenter", 1, paramQCircleInitBean.toString());
    }
  }
  
  public void b(Context paramContext, View paramView)
  {
    this.w = ((ViewStub)paramView.findViewById(2131441909));
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    b(paramStNotice);
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.setOnClickListener(g());
    }
    if (this.g != null) {
      this.g.setOnClickListener(g());
    }
    if (this.h != null) {
      this.h.setOnClickListener(h());
    }
    if (this.m != null) {
      this.m.setOnClickListener(j());
    }
    if (this.n != null) {
      this.n.setOnClickListener(j());
    }
    if (this.p != null) {
      this.p.setOnClickListener(g());
    }
  }
  
  protected String f()
  {
    return "QCircleDefaultMessagePresenter";
  }
  
  protected View.OnClickListener g()
  {
    if (this.t == null) {
      this.t = new QCircleDefaultMessagePresenter.2(this);
    }
    return this.t;
  }
  
  protected View.OnClickListener h()
  {
    if ((this.o != null) && (this.o.getVisibility() == 0)) {
      return j();
    }
    return g();
  }
  
  protected View.OnClickListener i()
  {
    return g();
  }
  
  protected View.OnClickListener j()
  {
    if (this.v == null) {
      this.v = new QCircleDefaultMessagePresenter.3(this);
    }
    return this.v;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleDefaultMessagePresenter
 * JD-Core Version:    0.7.0.1
 */