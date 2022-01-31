package com.tencent.biz.qqcircle.fragments.content;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.widgets.multiTouchImage.QCircleMultiTouchImageView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.io.File;
import tql;
import txo;
import txp;
import uaj;

public class QCircleContentImage
  extends BaseWidgetView<FeedCloudMeta.StFeed>
  implements URLDrawableDownListener
{
  private int jdField_a_of_type_Int;
  private QCircleMultiTouchImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView;
  private boolean jdField_a_of_type_Boolean;
  
  public QCircleContentImage(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView, FeedCloudMeta.StImage paramStImage)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = tql.b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView);
    localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130850072);
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
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.setOnDoubleTabListener(new txo(this, paramStFeed));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.setOnScaleChangeListener(new txp(this, paramStFeed));
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.setImageDrawable(null);
    }
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
      Object localObject1 = (FeedCloudMeta.StImage)((FeedCloudMeta.StImage)paramStFeed.images.get(this.c)).get();
      String str1 = ((FeedCloudMeta.StImage)localObject1).picUrl.get();
      if (str1 != null) {}
      try
      {
        String str2 = uaj.b(str1);
        Object localObject2 = uaj.a(str2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new File((String)localObject2);
          if (((File)localObject2).exists()) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.setImageURI(Uri.fromFile((File)localObject2));
          }
          QLog.d("QCircleContentImage", 1, "bindData with local image path,url:" + str1 + ",trimUrl:" + str2);
          b(paramStFeed);
          return;
        }
        QLog.d("QCircleContentImage", 1, "bindData can't find local image path,url:" + str1);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("QCircleContentImage", 1, "bindData set local image path error!exception:" + localException);
        }
      }
      QLog.d("QCircleContentImage", 1, "bindData with network image url:" + str1);
      localObject1 = a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView, (FeedCloudMeta.StImage)localObject1);
      tql.a(str1, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView, (URLDrawable.URLDrawableOptions)localObject1, false, this);
      b(paramStFeed);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsMultiTouchImageQCircleMultiTouchImageView.a(paramFloat1, paramFloat2);
    }
    return true;
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
  
  public void setVerticalPos(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentImage
 * JD-Core Version:    0.7.0.1
 */