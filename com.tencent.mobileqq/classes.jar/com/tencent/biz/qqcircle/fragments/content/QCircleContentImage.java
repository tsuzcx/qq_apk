package com.tencent.biz.qqcircle.fragments.content;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import tql;

public class QCircleContentImage
  extends BaseWidgetView<FeedCloudMeta.StFeed>
{
  private URLImageView a;
  
  public QCircleContentImage(@NonNull Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(-16777216);
  }
  
  private URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView, FeedCloudMeta.StImage paramStImage)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = tql.b(this.a);
    localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130849999);
    if ((paramStImage == null) || (paramURLImageView == null)) {}
    int k;
    do
    {
      return localURLDrawableOptions;
      j = paramStImage.height.get();
      k = paramStImage.width.get();
    } while ((j <= 0) || (k <= 0));
    int i = ImmersiveUtils.a();
    float f = i / k;
    int j = (int)(j * f);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = j;
    return localURLDrawableOptions;
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.setImageDrawable(null);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.a = new URLImageView(getContext());
    addView(this.a, new FrameLayout.LayoutParams(-1, -1));
  }
  
  protected void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.a != null)
    {
      paramStFeed = (FeedCloudMeta.StImage)((FeedCloudMeta.StImage)paramStFeed.images.get(this.b)).get();
      tql.a(paramStFeed.picUrl.get(), this.a, a(this.a, paramStFeed), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentImage
 * JD-Core Version:    0.7.0.1
 */