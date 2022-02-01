package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import vnz;
import vri;
import vva;
import zxl;

public abstract class QCircleBaseVideoView
  extends BaseVideoView
  implements zxl<QCircleReportBean>
{
  private static final int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_video_level_type", 10);
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private List<FeedCloudMeta.StVideoUrl> jdField_a_of_type_JavaUtilList;
  
  public QCircleBaseVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleBaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleBaseVideoView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(FeedCloudMeta.StVideo paramStVideo, int paramInt)
  {
    a(this, paramStVideo.fileId.get(), paramStVideo.playUrl.get(), paramInt);
    this.jdField_a_of_type_JavaUtilList = paramStVideo.vecVideoUrl.get();
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  protected abstract String a();
  
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
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FeedCloudMeta.StVideoUrl localStVideoUrl = (FeedCloudMeta.StVideoUrl)localIterator.next();
        if ((localStVideoUrl != null) && (localStVideoUrl.levelType.get() == jdField_a_of_type_Int) && (a() != null))
        {
          QLog.i("QCircleBaseVideoView", 1, String.format("triggerPlayLowResVideoUrl:url: %s, startoffset:%d, levelType:%d", new Object[] { localStVideoUrl.playUrl.get(), Integer.valueOf((int)a().getCurrentPositionMs()), Integer.valueOf(localStVideoUrl.levelType.get()) }));
          setVideoPath(null, localStVideoUrl.playUrl.get(), (int)a().getCurrentPositionMs());
          a(this.jdField_a_of_type_Long, "video_play_downgrade_url", a(), Collections.singletonList(vri.a("video_url", localStVideoUrl.playUrl.get())));
        }
      }
    }
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  public void setVideoPath(FeedCloudMeta.StVideo paramStVideo, int paramInt)
  {
    vnz.a().a(getContext().hashCode(), paramStVideo, new vva(this, paramInt, paramStVideo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBaseVideoView
 * JD-Core Version:    0.7.0.1
 */