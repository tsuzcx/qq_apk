package com.tencent.biz.qqcircle.widgets;

import aabg;
import android.animation.AnimatorSet;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import bhsr;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.util.Collections;
import java.util.List;
import vqh;
import vtt;
import vxr;
import vyd;

public abstract class QCircleBaseVideoView
  extends BaseVideoView
  implements aabg<QCircleReportBean>
{
  private static final long c;
  private static final boolean d;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private QCircleProgressLoadingView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView;
  private FeedCloudMeta.StVideo jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo;
  
  static
  {
    boolean bool = true;
    if (QzoneConfig.getInstance().getConfig("qqcircle", "secondary_video_enable_rate_bit_pre_select", 1) > 0) {}
    for (;;)
    {
      d = bool;
      c = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_video_trigger_downgrade_speed", 500);
      return;
      bool = false;
    }
  }
  
  public QCircleBaseVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView = new QCircleProgressLoadingView(paramContext);
  }
  
  public QCircleBaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView = new QCircleProgressLoadingView(paramContext);
  }
  
  public QCircleBaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView = new QCircleProgressLoadingView(paramContext);
  }
  
  public static String a(FeedCloudMeta.StVideo paramStVideo)
  {
    if (!d)
    {
      QLog.i("BaseVideoView", 1, "selectUrlByDownloadSpeed not enable");
      return paramStVideo.playUrl.get();
    }
    if (a(paramStVideo.playUrl.get(), paramStVideo.fileId.get()))
    {
      QLog.i("BaseVideoView", 1, "stop selectUrlByDownloadSpeed because of hit cache");
      return paramStVideo.playUrl.get();
    }
    long l = QCircleBaseFragment.a.getCurrentPrediction();
    QLog.i("BaseVideoView", 1, String.format("selectUrlByDownloadSpeed start, lastDownloadSpeed:%d, predictDownloadSpeed:%d", new Object[] { Long.valueOf(b), Long.valueOf(l) }));
    if (l < c)
    {
      FeedCloudMeta.StVideoUrl localStVideoUrl = vqh.a(paramStVideo.vecVideoUrl.get());
      if ((localStVideoUrl != null) && (!bhsr.a(localStVideoUrl.playUrl.get())))
      {
        QLog.i("BaseVideoView", 1, "selectUrlByDownloadSpeed hit, url:" + localStVideoUrl.playUrl.get());
        return localStVideoUrl.playUrl.get();
      }
    }
    QLog.i("BaseVideoView", 1, "selectUrlByDownloadSpeed use original video url");
    return paramStVideo.playUrl.get();
  }
  
  private void a(FeedCloudMeta.StVideo paramStVideo, int paramInt)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo = paramStVideo;
    String str = a(paramStVideo);
    super.setVideoPath(paramStVideo.fileId.get(), str, paramInt);
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  protected abstract String a();
  
  public void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    QLog.i("BaseVideoView", 1, "triggerDowngradeVideoUrl start");
    Object localObject;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo != null)
    {
      localObject = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StVideo.vecVideoUrl.get();
      localObject = vqh.a((List)localObject);
      if ((localObject != null) && (!bhsr.a(((FeedCloudMeta.StVideoUrl)localObject).playUrl.get()))) {
        break label62;
      }
      QLog.i("BaseVideoView", 1, "triggerPlayLowResVideoUrl: url is null");
    }
    label62:
    do
    {
      return;
      localObject = null;
      break;
      if (paramSuperPlayerVideoInfo.getPlayUrl().equals(((FeedCloudMeta.StVideoUrl)localObject).playUrl.get()))
      {
        QLog.i("BaseVideoView", 1, String.format("triggerDowngradeVideoUrl:return url is targetLevelType: %s, levelType:%d", new Object[] { ((FeedCloudMeta.StVideoUrl)localObject).playUrl.get(), Integer.valueOf(((FeedCloudMeta.StVideoUrl)localObject).levelType.get()) }));
        return;
      }
    } while (a() == null);
    QLog.i("BaseVideoView", 1, String.format("triggerDowngradeVideoUrl:url: %s, startoffset:%d, levelType:%d", new Object[] { ((FeedCloudMeta.StVideoUrl)localObject).playUrl.get(), Integer.valueOf((int)a().getCurrentPositionMs()), Integer.valueOf(((FeedCloudMeta.StVideoUrl)localObject).levelType.get()) }));
    setVideoPath(null, ((FeedCloudMeta.StVideoUrl)localObject).playUrl.get(), (int)a().getCurrentPositionMs());
    a(this.jdField_a_of_type_Long, "video_play_downgrade_url", a(), Collections.singletonList(vtt.a("video_url", ((FeedCloudMeta.StVideoUrl)localObject).playUrl.get())));
  }
  
  protected int b()
  {
    return QCircleReportBean.getPageId(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  protected int d()
  {
    return QCircleReportBean.getParentPageId(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView != null)
    {
      View localView = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView.a();
      if (localView != null) {
        localView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView.a() != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView.a().start();
      }
    }
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView != null)
    {
      View localView = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView.a();
      if (localView != null) {
        localView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView.a() != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView.a().removeAllListeners();
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView.a().cancel();
      }
    }
    if (a() != null) {
      a().setOnSeekBarChangeListener(this);
    }
    if (this.jdField_a_of_type_Vxr != null) {
      this.jdField_a_of_type_Vxr.a();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView.a() != null))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView.a().cancel();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView.a().removeAllListeners();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView = null;
    }
  }
  
  public void setLoadingView(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleProgressLoadingView.setLoadingView(paramView);
    }
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  public void setVideoPath(FeedCloudMeta.StVideo paramStVideo, int paramInt)
  {
    vqh.a().a(getContext().hashCode(), paramStVideo, new vyd(this, paramInt, paramStVideo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBaseVideoView
 * JD-Core Version:    0.7.0.1
 */