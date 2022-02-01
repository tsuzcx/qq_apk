package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._TVK_PlayerMsg;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.events.QCircleVideoDetailsFragmentExitEvent;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;

public class QCircleFeedCleanPlayView
  extends QCircleBaseVideoView
  implements SimpleEventReceiver
{
  private int h;
  private boolean i;
  private SeekBar j;
  
  public QCircleFeedCleanPlayView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
  }
  
  public QCircleFeedCleanPlayView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleFeedCleanPlayView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean A()
  {
    if (getSuperPlayer() != null) {
      return getSuperPlayer().isPausing();
    }
    return false;
  }
  
  protected void a(long paramLong1, long paramLong2) {}
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    super.a(paramISuperPlayer);
    paramISuperPlayer.setXYaxis(QCircleHostConstants._TVK_PlayerMsg.PLAYER_SCALE_ORIGINAL_FULLSCREEN());
  }
  
  public void b(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
    if (localStFeed != null)
    {
      Object localObject;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = "";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(paramInt1);
        localObject = ((StringBuilder)localObject).toString();
      }
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(localStFeed)).setActionType(2).setSubActionType(7).setToUin(localStFeed.poster.id.get()).setPosition(this.h).setPlayScene(1).setVideoPlayTime(paramLong1).setVideoSoloTime(paramLong2).setIsAutoPlay(this.i).setErrorCode((String)localObject).setPageId(getPageId()).setfpageid(getParentPageId()));
    }
  }
  
  protected void b(long paramLong1, long paramLong2) {}
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public void e()
  {
    getMainHandler().post(new QCircleFeedCleanPlayView.1(this));
  }
  
  public ArrayList<Class> getEventClass()
  {
    return new ArrayList();
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedCleanPlayView";
  }
  
  public SeekBar getProgressBar()
  {
    SeekBar localSeekBar = this.j;
    if (localSeekBar != null) {
      return localSeekBar;
    }
    return null;
  }
  
  protected void j()
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)getData();
    if (localStFeed != null) {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(localStFeed)).setActionType(2).setSubActionType(4).setToUin(localStFeed.poster.id.get()).setPosition(this.h).setPlayScene(1).setVideoPlayTime(0L).setVideoSoloTime(0L).setIsAutoPlay(true).setErrorCode("").setPageId(getPageId()).setfpageid(getParentPageId()));
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  protected void onInitView(Context paramContext, View paramView) {}
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleVideoDetailsFragmentExitEvent)) && ((getData() instanceof FeedCloudMeta.StFeed))) {
      a(QCirclePluginGlobalInfo.f(((FeedCloudMeta.StFeed)getData()).id.get()));
    }
  }
  
  public void setIsAutoPlay(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setPos(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setProgressBar(SeekBar paramSeekBar)
  {
    if (paramSeekBar != null) {
      this.j = paramSeekBar;
    }
  }
  
  public boolean z()
  {
    if (getSuperPlayer() != null) {
      return getSuperPlayer().isPlaying();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView
 * JD-Core Version:    0.7.0.1
 */