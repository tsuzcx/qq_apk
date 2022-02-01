package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBaseVideoView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;

public class QFSVideoView
  extends QCircleBaseVideoView
{
  private SeekBar h;
  private int i;
  private int j = 2;
  
  public QFSVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QFSVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void z() {}
  
  public void a(long paramLong1, long paramLong2)
  {
    Object localObject = (FeedCloudMeta.StFeed)getData();
    if (localObject != null)
    {
      QCircleLpReportDc05507.DataBuilder localDataBuilder = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject)).setActionType(2).setSubActionType(5).setToUin(((FeedCloudMeta.StFeed)localObject).poster.id.get()).setPosition(this.i).setPlayScene(this.j).setVideoPlayTime(paramLong1).setVideoSoloTime(paramLong2).setIsAutoPlay(true).setErrorCode("");
      if (QCircleContentImmersiveEvent.isImmersive()) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      QCircleLpReportDc05507.report(localDataBuilder.setExt4((String)localObject).setPageId(getPageId()).setfpageid(getParentPageId()));
    }
  }
  
  public void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    Object localObject2 = (FeedCloudMeta.StFeed)getData();
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
      localObject2 = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject2)).setActionType(2).setSubActionType(7).setToUin(((FeedCloudMeta.StFeed)localObject2).poster.id.get()).setPosition(this.i).setPlayScene(this.j).setVideoPlayTime(paramLong1).setVideoSoloTime(paramLong2).setIsAutoPlay(true).setErrorCode((String)localObject1);
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
    Object localObject = (FeedCloudMeta.StFeed)getData();
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
    return "QFSVideoView";
  }
  
  public String getPlayUrl()
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
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
    return this.h;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int k = paramMessage.what;
    return false;
  }
  
  protected void j()
  {
    Object localObject = (FeedCloudMeta.StFeed)getData();
    if (localObject != null)
    {
      QCircleLpReportDc05507.DataBuilder localDataBuilder = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject)).setActionType(2).setSubActionType(4).setToUin(((FeedCloudMeta.StFeed)localObject).poster.id.get()).setPosition(this.i).setPlayScene(this.j).setVideoPlayTime(0L).setVideoSoloTime(0L).setIsAutoPlay(true).setErrorCode("");
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
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    super.onStartTrackingTouch(paramSeekBar);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    super.onStopTrackingTouch(paramSeekBar);
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void setPlayScene(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setProgressBar(SeekBar paramSeekBar)
  {
    this.h = paramSeekBar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSVideoView
 * JD-Core Version:    0.7.0.1
 */