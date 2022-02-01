package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.helpers.QCircleVideoExchangeHelper;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.richframework.video.QCircleVideoUtils;
import com.tencent.biz.qqcircle.richframework.widget.BaseVideoView;
import com.tencent.biz.qqcircle.utils.FileUtils;
import com.tencent.biz.qqcircle.utils.StringUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class QCircleBaseVideoView
  extends BaseVideoView
  implements ReportBean<QCircleReportBean>
{
  public static final String f;
  protected WeakReference<Bitmap> g;
  private QCircleReportBean h;
  private QCircleProgressLoadingView i;
  private FeedCloudMeta.StVideo j;
  private boolean k = true;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileUtils.a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qcircle_pic_temp_cache");
    localStringBuilder.append(File.separator);
    f = localStringBuilder.toString();
  }
  
  public QCircleBaseVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.i = new QCircleProgressLoadingView(paramContext);
  }
  
  public QCircleBaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.i = new QCircleProgressLoadingView(paramContext);
  }
  
  public QCircleBaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.i = new QCircleProgressLoadingView(paramContext);
  }
  
  private void a(SeekBar paramSeekBar, boolean paramBoolean)
  {
    if (paramSeekBar == null) {
      return;
    }
    paramSeekBar.setEnabled(paramBoolean);
  }
  
  private void a(FeedCloudMeta.StVideo paramStVideo, int paramInt)
  {
    this.j = paramStVideo;
    String str = QCircleVideoUtils.a(paramStVideo);
    super.setVideoPath(paramStVideo.fileId.get(), str, paramInt);
  }
  
  private void a(FeedCloudMeta.StVideoUrl paramStVideoUrl)
  {
    getMainHandler().post(new QCircleBaseVideoView.2(this, paramStVideoUrl));
  }
  
  protected void b(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    QLog.i("BaseVideoView", 1, "triggerDowngradeVideoUrl start");
    Object localObject = this.j;
    if (localObject != null) {
      localObject = ((FeedCloudMeta.StVideo)localObject).vecVideoUrl.get();
    } else {
      localObject = null;
    }
    localObject = QCircleVideoExchangeHelper.a((List)localObject);
    if ((localObject != null) && (!StringUtil.a(((FeedCloudMeta.StVideoUrl)localObject).playUrl.get())))
    {
      if (paramSuperPlayerVideoInfo.getPlayUrl().equals(((FeedCloudMeta.StVideoUrl)localObject).playUrl.get()))
      {
        QLog.i("BaseVideoView", 1, String.format("triggerDowngradeVideoUrl:return url is targetLevelType: %s, levelType:%d", new Object[] { ((FeedCloudMeta.StVideoUrl)localObject).playUrl.get(), Integer.valueOf(((FeedCloudMeta.StVideoUrl)localObject).levelType.get()) }));
        return;
      }
      a((FeedCloudMeta.StVideoUrl)localObject);
      return;
    }
    QLog.i("BaseVideoView", 1, "triggerPlayLowResVideoUrl: url is null");
  }
  
  protected abstract String getLogTag();
  
  protected int getPageId()
  {
    return QCircleReportBean.getPageId(getLogTag(), this.h);
  }
  
  protected int getParentPageId()
  {
    return QCircleReportBean.getParentPageId(getLogTag(), this.h);
  }
  
  public QCircleReportBean getReportBean()
  {
    return QCircleReportBean.getReportBean(getLogTag(), this.h);
  }
  
  protected void l()
  {
    super.l();
    QCircleProgressLoadingView localQCircleProgressLoadingView = this.i;
    if (localQCircleProgressLoadingView != null) {
      localQCircleProgressLoadingView.b();
    }
    if (getProgressBar() != null)
    {
      getProgressBar().setVisibility(0);
      getProgressBar().setOnSeekBarChangeListener(this);
      a(getProgressBar(), this.k);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QCircleProgressLoadingView localQCircleProgressLoadingView = this.i;
    if (localQCircleProgressLoadingView != null) {
      localQCircleProgressLoadingView.b();
    }
  }
  
  protected void q()
  {
    super.q();
    if (getProgressBar() != null) {
      getProgressBar().setVisibility(8);
    }
    QCircleProgressLoadingView localQCircleProgressLoadingView = this.i;
    if (localQCircleProgressLoadingView != null) {
      localQCircleProgressLoadingView.a();
    }
  }
  
  public void release()
  {
    super.release();
    this.g = null;
  }
  
  public void setLoadingView(View paramView)
  {
    if (paramView != null) {
      this.i.setLoadingView(paramView);
    }
  }
  
  public void setLoadingView(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      this.i.setLoadingView(paramView);
      this.i.setScreenOrientation(paramInt);
    }
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.h = QCircleReportBean.setReportBean(getLogTag(), paramQCircleReportBean);
  }
  
  public void setSupportSeek(boolean paramBoolean)
  {
    a(getProgressBar(), paramBoolean);
    this.k = paramBoolean;
  }
  
  public void setVideoPath(FeedCloudMeta.StVideo paramStVideo, int paramInt)
  {
    QCircleVideoExchangeHelper.a().a(getContext().hashCode(), paramStVideo, new QCircleBaseVideoView.1(this, paramInt, paramStVideo));
  }
  
  public Bitmap y()
  {
    if (getSuperPlayer() != null)
    {
      if (getSuperPlayer().getVideoView() == null) {
        return null;
      }
      if ((getSuperPlayer().getVideoView().getRenderView() instanceof TextureView))
      {
        Bitmap localBitmap = ((TextureView)getSuperPlayer().getVideoView().getRenderView()).getBitmap();
        if ((localBitmap != null) && (localBitmap.getWidth() > 0)) {
          this.g = new WeakReference(localBitmap);
        }
        return localBitmap;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBaseVideoView
 * JD-Core Version:    0.7.0.1
 */