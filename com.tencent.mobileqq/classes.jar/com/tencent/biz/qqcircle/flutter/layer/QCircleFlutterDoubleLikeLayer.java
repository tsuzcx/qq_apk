package com.tencent.biz.qqcircle.flutter.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView.IAnimationEndHandler;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;

public class QCircleFlutterDoubleLikeLayer
  extends FrameLayout
{
  private QCircleDoublePraiseView a;
  private int b = ImmersiveUtils.b();
  private float c = 1.777778F;
  private float d = 0.75F;
  private QCircleExtraTypeInfo e = null;
  private QCircleReportBean f = null;
  private int g = 0;
  
  public QCircleFlutterDoubleLikeLayer(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QCircleFlutterDoubleLikeLayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QCircleFlutterDoubleLikeLayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.type.get() != 3) {
      return;
    }
    int i = paramStFeed.video.width.get();
    int k = paramStFeed.video.height.get();
    int j = this.b;
    if ((i != 0) && (k != 0))
    {
      float f1 = i / k;
      float f2 = this.c;
      if (f1 >= f2)
      {
        i = (int)(j / f2);
      }
      else
      {
        if ((f1 > this.d) && (f1 <= f2))
        {
          f2 = j;
        }
        else
        {
          f2 = j;
          f1 = this.d;
        }
        i = (int)(f2 / f1);
      }
    }
    else
    {
      i = j;
    }
    this.a.getLayoutParams().width = j;
    this.a.getLayoutParams().height = i;
    ((FrameLayout.LayoutParams)this.a.getLayoutParams()).gravity = 16;
    paramStFeed = this.a;
    paramStFeed.setLayoutParams(paramStFeed.getLayoutParams());
  }
  
  public void a()
  {
    this.a = new QCircleDoublePraiseView(getContext(), null, this);
    addView(this.a);
  }
  
  public void a(QCircleExtraTypeInfo paramQCircleExtraTypeInfo, QCircleReportBean paramQCircleReportBean, int paramInt)
  {
    if (paramQCircleExtraTypeInfo == null)
    {
      QLog.d("QCircleFlutterDoubleLikeLayer", 2, "[bindData] type info not is null.");
      return;
    }
    if (paramQCircleExtraTypeInfo.mFeed == null)
    {
      QLog.d("QCircleFlutterDoubleLikeLayer", 2, "[bindData] feed not is null.");
      return;
    }
    this.e = paramQCircleExtraTypeInfo;
    this.f = paramQCircleReportBean;
    this.g = paramInt;
    QCircleDoublePraiseView localQCircleDoublePraiseView = this.a;
    if (localQCircleDoublePraiseView == null)
    {
      QLog.d("QCircleFlutterDoubleLikeLayer", 2, "[bindData] double praise view not is null.");
      return;
    }
    localQCircleDoublePraiseView.setFeed(paramQCircleExtraTypeInfo.mFeed);
    this.a.setPageType(paramQCircleExtraTypeInfo.pageType);
    this.a.setReportBean(paramQCircleReportBean);
    a(paramQCircleExtraTypeInfo.mFeed);
  }
  
  public void b()
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      QLog.d("QCircleFlutterDoubleLikeLayer", 2, "[startAnimation] extra type info not is null.");
      return;
    }
    localObject = ((QCircleExtraTypeInfo)localObject).mFeed;
    if (localObject == null)
    {
      QLog.d("QCircleFlutterDoubleLikeLayer", 2, "[startAnimation] feed not is null.");
      return;
    }
    QCircleReportBean localQCircleReportBean = this.f;
    int i;
    if (localQCircleReportBean == null) {
      i = 0;
    } else {
      i = localQCircleReportBean.getPageId();
    }
    SimpleEventBus.getInstance().dispatchEvent(new QCircleDoublePraiseAnimationEvent(((FeedCloudMeta.StFeed)localObject).id.get(), i, this.g));
  }
  
  public void setAnimationEndHandler(QCircleDoublePraiseView.IAnimationEndHandler paramIAnimationEndHandler)
  {
    this.a.setAnimationEndHandler(paramIAnimationEndHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.layer.QCircleFlutterDoubleLikeLayer
 * JD-Core Version:    0.7.0.1
 */