package com.tencent.biz.qqcircle.adapter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StItemInfo;

public class QCircleRecommendBaseAdapter$QCircleRecommendItemBaseViewHolder
  extends RecyclerView.ViewHolder
  implements ReportBean<QCircleReportBean>
{
  protected Object a;
  protected int b;
  protected FeedCloudMeta.StFeed c;
  protected int d;
  protected QCircleRecommendBaseAdapter e;
  protected int f;
  protected QCircleReportBean g;
  
  public QCircleRecommendBaseAdapter$QCircleRecommendItemBaseViewHolder(View paramView)
  {
    super(paramView);
  }
  
  public QCircleReportBean a()
  {
    return this.g;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(QCircleRecommendBaseAdapter paramQCircleRecommendBaseAdapter)
  {
    this.e = paramQCircleRecommendBaseAdapter;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.g = paramQCircleReportBean;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.c = paramStFeed;
  }
  
  public void a(String paramString, Drawable paramDrawable, URLImageView paramURLImageView)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramURLImageView != null))
    {
      paramString = new Option().setLoadingDrawable(paramDrawable).setFailDrawable(paramDrawable).setTargetView(paramURLImageView).setUrl(paramString);
      QCircleFeedPicLoader.g().loadImage(paramString, null);
    }
  }
  
  public QQCircleDitto.StItemInfo b()
  {
    return (QQCircleDitto.StItemInfo)this.a;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter.QCircleRecommendItemBaseViewHolder
 * JD-Core Version:    0.7.0.1
 */