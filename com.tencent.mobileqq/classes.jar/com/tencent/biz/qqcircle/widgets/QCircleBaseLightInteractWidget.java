package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;

public abstract class QCircleBaseLightInteractWidget
  extends QCircleBaseWidgetView
{
  protected FeedCloudMeta.StFeed a;
  protected FeedCloudMeta.StLightInteractInfo b;
  protected int c;
  protected QCircleExtraTypeInfo d;
  
  public QCircleBaseLightInteractWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QCircleExtraTypeInfo paramQCircleExtraTypeInfo, int paramInt)
  {
    this.a = paramStFeed;
    this.d = paramQCircleExtraTypeInfo;
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget
 * JD-Core Version:    0.7.0.1
 */