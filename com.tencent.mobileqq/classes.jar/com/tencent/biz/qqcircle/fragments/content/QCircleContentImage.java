package com.tencent.biz.qqcircle.fragments.content;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.multiTouchImage.QCircleMultiTouchImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import uys;
import var;
import vly;
import vlz;
import vma;
import vmb;
import vmc;
import vmd;
import vme;
import vrd;

public class QCircleContentImage
  extends QCircleBaseWidgetView<FeedCloudMeta.StFeed>
  implements URLDrawableDownListener
{
  private int jdField_a_of_type_Int;
  private QCircleMultiTouchImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView;
  private boolean jdField_a_of_type_Boolean;
  private int b = 2;
  
  public QCircleContentImage(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private Drawable a()
  {
    if ((this.c != 0) || (a() == null) || (!(a() instanceof var))) {
      return getResources().getDrawable(2130850680);
    }
    var localvar = (var)a();
    if (localvar.a() != null) {
      return localvar.a();
    }
    return getResources().getDrawable(2130850680);
  }
  
  private URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView, FeedCloudMeta.StImage paramStImage)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = uys.b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView);
    localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130850680);
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
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.setOnDoubleTabListener(new vlz(this, paramStFeed));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.setOnScaleChangeListener(new vma(this, paramStFeed));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.setOnViewTapListener(new vmb(this, paramStFeed));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.setOnScaleBeginListener(new vmc(this));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.setOnScaleEndListener(new vmd(this));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.setOnLongClickListener(new vme(this));
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView;
  }
  
  public String a()
  {
    return "QCircleContentImage";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView = new QCircleMultiTouchImageView(getContext());
    addView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  protected void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView != null)
    {
      Object localObject = (FeedCloudMeta.StImage)((FeedCloudMeta.StImage)paramStFeed.images.get(this.c)).get();
      String str = ((FeedCloudMeta.StImage)localObject).picUrl.get();
      if (str != null)
      {
        localObject = a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView, (FeedCloudMeta.StImage)localObject);
        localObject = new vrd().a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView).b(((URLDrawable.URLDrawableOptions)localObject).mRequestHeight).c(((URLDrawable.URLDrawableOptions)localObject).mRequestWidth).a(str).a(a()).a(true);
        QCircleFeedPicLoader.a().a((vrd)localObject, new vly(this, paramStFeed, str));
      }
      b(paramStFeed);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.a(paramFloat1, paramFloat2);
    }
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.setImageDrawable(null);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.b();
    }
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.a();
    }
  }
  
  public void setPlayScene(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setVerticalPos(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentImage
 * JD-Core Version:    0.7.0.1
 */