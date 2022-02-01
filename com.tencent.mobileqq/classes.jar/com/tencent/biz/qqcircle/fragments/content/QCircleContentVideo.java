package com.tencent.biz.qqcircle.fragments.content;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.TimeUtils;
import com.tencent.biz.qqcircle.widgets.QCircleBaseVideoView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;

public class QCircleContentVideo
  extends QCircleBaseVideoView
{
  private boolean h;
  private int i;
  private volatile QCircleContentOperationView j;
  private int k = 2;
  private boolean l = true;
  
  public QCircleContentVideo(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void z() {}
  
  public void a(long paramLong1, long paramLong2)
  {
    Object localObject = ((FeedBlockData)getData()).b();
    if (localObject != null)
    {
      QCircleLpReportDc05507.DataBuilder localDataBuilder = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject)).setActionType(2).setSubActionType(5).setToUin(((FeedCloudMeta.StFeed)localObject).poster.id.get()).setPosition(this.i).setPlayScene(this.k).setVideoPlayTime(paramLong1).setVideoSoloTime(paramLong2).setIsAutoPlay(true).setErrorCode("");
      if (QCircleContentImmersiveEvent.isImmersive()) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      QCircleLpReportDc05507.report(localDataBuilder.setExt4((String)localObject).setPageId(getPageId()).setfpageid(getParentPageId()));
    }
  }
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    super.a(paramISuperPlayer);
    getMainHandler().post(new QCircleContentVideo.4(this, paramISuperPlayer));
    h();
  }
  
  public void b()
  {
    super.b();
    getMainHandler().post(new QCircleContentVideo.2(this));
  }
  
  public void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    Object localObject2 = ((FeedBlockData)getData()).b();
    if (localObject2 != null)
    {
      Object localObject1;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = "";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(paramInt1);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject2)).setActionType(2).setSubActionType(7).setToUin(((FeedCloudMeta.StFeed)localObject2).poster.id.get()).setPosition(this.i).setPlayScene(this.k).setVideoPlayTime(paramLong1).setVideoSoloTime(paramLong2).setIsAutoPlay(true).setErrorCode((String)localObject1);
      if (QCircleContentImmersiveEvent.isImmersive()) {
        localObject1 = "2";
      } else {
        localObject1 = "1";
      }
      QCircleLpReportDc05507.report(((QCircleLpReportDc05507.DataBuilder)localObject2).setExt4((String)localObject1).setPageId(getPageId()).setfpageid(getParentPageId()));
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    Object localObject = ((FeedBlockData)getData()).b();
    if (localObject != null)
    {
      QCircleLpReportDc05507.DataBuilder localDataBuilder = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject)).setActionType(2).setSubActionType(6).setToUin(((FeedCloudMeta.StFeed)localObject).poster.id.get()).setPosition(this.i).setPlayScene(2).setVideoPlayTime(paramLong1).setVideoSoloTime(paramLong2).setIsAutoPlay(true).setErrorCode("");
      if (QCircleContentImmersiveEvent.isImmersive()) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      QCircleLpReportDc05507.report(localDataBuilder.setExt4((String)localObject).setPageId(getPageId()).setfpageid(getParentPageId()));
    }
  }
  
  public void b(ISuperPlayer paramISuperPlayer)
  {
    this.h = true;
  }
  
  public void bi_()
  {
    if (getSuperPlayer() == null) {
      return;
    }
    if (getSuperPlayer().isPlaying())
    {
      b();
      return;
    }
    if (this.h)
    {
      i();
      return;
    }
    h();
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.i = paramInt;
  }
  
  public long getCurrentPosition()
  {
    if (getSuperPlayer() != null) {
      return getSuperPlayer().getCurrentPositionMs();
    }
    return 0L;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  protected String getLogTag()
  {
    return "QCircleContentVideo";
  }
  
  public String getPlayUrl()
  {
    FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)getData()).b();
    if ((localStFeed != null) && (localStFeed.type.get() == 3)) {
      return localStFeed.video.playUrl.get();
    }
    return null;
  }
  
  public int getPos()
  {
    return this.i;
  }
  
  public SeekBar getProgressBar()
  {
    if (this.j != null) {
      return this.j.p;
    }
    return null;
  }
  
  public void h()
  {
    super.h();
    getMainHandler().post(new QCircleContentVideo.3(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    return false;
  }
  
  public void i()
  {
    super.i();
    this.h = false;
  }
  
  protected void j()
  {
    Object localObject = ((FeedBlockData)getData()).b();
    if (localObject != null)
    {
      QCircleLpReportDc05507.DataBuilder localDataBuilder = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject)).setActionType(2).setSubActionType(4).setToUin(((FeedCloudMeta.StFeed)localObject).poster.id.get()).setPosition(this.i).setPlayScene(this.k).setVideoPlayTime(0L).setVideoSoloTime(0L).setIsAutoPlay(true).setErrorCode("");
      if (QCircleContentImmersiveEvent.isImmersive()) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      QCircleLpReportDc05507.report(localDataBuilder.setExt4((String)localObject).setPageId(getPageId()).setfpageid(getParentPageId()));
    }
  }
  
  protected boolean k()
  {
    return true;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    z();
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    super.onProgressChanged(paramSeekBar, paramInt, paramBoolean);
    if ((this.c) && (this.j != null) && (this.j.m != null))
    {
      RFWTypefaceUtil.a(this.j.m, false);
      paramSeekBar = this.j.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TimeUtils.a(paramInt));
      localStringBuilder.append(" | ");
      paramSeekBar.setText(localStringBuilder.toString());
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    super.onStartTrackingTouch(paramSeekBar);
    if (this.j != null)
    {
      if (this.j.o != null) {
        this.j.o.setVisibility(0);
      }
      if (this.j.f != null) {
        this.j.f.setVisibility(8);
      }
      if (this.j.u != null) {
        this.j.u.setVisibility(8);
      }
      paramSeekBar.getLayoutParams().height = ImmersiveUtils.a(4.0F);
      paramSeekBar.requestLayout();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    super.onStopTrackingTouch(paramSeekBar);
    paramSeekBar.getLayoutParams().height = ImmersiveUtils.a(1.0F);
    paramSeekBar.requestLayout();
    getMainHandler().postDelayed(new QCircleContentVideo.5(this), 500L);
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void setOperationView(QCircleContentOperationView paramQCircleContentOperationView)
  {
    this.j = paramQCircleContentOperationView;
  }
  
  public void setPlayScene(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setVideoPath(FeedCloudMeta.StVideo paramStVideo, int paramInt)
  {
    if (this.j != null) {
      setLoadingView(this.j.q);
    }
    this.h = false;
    setInitListener(new QCircleContentVideo.1(this));
    super.setVideoPath(paramStVideo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo
 * JD-Core Version:    0.7.0.1
 */