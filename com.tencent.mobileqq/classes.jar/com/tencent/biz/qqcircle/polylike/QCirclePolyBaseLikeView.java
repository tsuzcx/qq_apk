package com.tencent.biz.qqcircle.polylike;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.AnimationView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleFeedBase.StPolyLike;

public abstract class QCirclePolyBaseLikeView
  extends QCircleBaseWidgetView
{
  public AnimationView a;
  public URLImageView b;
  public View c;
  public FeedCloudMeta.StFeed d;
  protected QQCircleFeedBase.StPolyLike e;
  protected FrameLayout f;
  protected ImageView g;
  protected TextView h;
  protected TextView i;
  protected QCirclePolyRequestManager j;
  protected QCirclePolyLikeFrameLayout.OnClickHookListener k;
  
  public QCirclePolyBaseLikeView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void b()
  {
    URLImageView localURLImageView = this.b;
    if (localURLImageView != null)
    {
      localURLImageView.setOnClickListener(new QCirclePolyBaseLikeView.1(this));
      this.a.setOnClickListener(new QCirclePolyBaseLikeView.2(this));
    }
  }
  
  protected void a() {}
  
  public void bindData(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof QQCircleFeedBase.StPolyLike))
    {
      this.e = ((QQCircleFeedBase.StPolyLike)paramObject);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = this.b.getContext().getResources().getDrawable(2130853309);
      localURLDrawableOptions.mFailedDrawable = this.b.getContext().getResources().getDrawable(2130853309);
      String str = this.e.polyPreviewSource.get();
      paramObject = str;
      if (TextUtils.isEmpty(str)) {
        paramObject = this.e.polyIconUrl.get();
      }
      paramObject = URLDrawable.getDrawable(paramObject, localURLDrawableOptions);
      this.b.setImageDrawable(paramObject);
      this.b.setVisibility(0);
      this.a.setVisibility(8);
      b();
    }
  }
  
  public FeedCloudMeta.StFeed getFeed()
  {
    return this.d;
  }
  
  int getParentType()
  {
    return this.mViewType >> 8 << 8;
  }
  
  public QQCircleFeedBase.StPolyLike getPolyLike()
  {
    return this.e;
  }
  
  public int getViewType()
  {
    return this.mViewType & 0xFF;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.c = paramView;
    if (paramView != null)
    {
      this.a = ((AnimationView)paramView.findViewById(2131441792));
      this.b = ((URLImageView)paramView.findViewById(2131441793));
      this.f = ((FrameLayout)paramView.findViewById(2131441789));
      this.g = ((ImageView)paramView.findViewById(2131441765));
      this.h = ((TextView)paramView.findViewById(2131441790));
      this.i = ((TextView)paramView.findViewById(2131441776));
    }
  }
  
  public void setCurrentFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    this.d = paramStFeed;
  }
  
  public void setHookListener(QCirclePolyLikeFrameLayout.OnClickHookListener paramOnClickHookListener)
  {
    this.k = paramOnClickHookListener;
  }
  
  public void setRequestManager(QCirclePolyRequestManager paramQCirclePolyRequestManager)
  {
    this.j = paramQCirclePolyRequestManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyBaseLikeView
 * JD-Core Version:    0.7.0.1
 */