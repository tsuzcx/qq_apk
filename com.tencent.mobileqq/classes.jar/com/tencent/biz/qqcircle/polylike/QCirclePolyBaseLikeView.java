package com.tencent.biz.qqcircle.polylike;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.AnimationView;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleFeedBase.StPolyLike;
import vpc;
import vpd;
import vpo;
import vqa;

public abstract class QCirclePolyBaseLikeView
  extends QCircleBaseWidgetView
{
  public int a;
  public View a;
  protected FrameLayout a;
  protected ImageView a;
  protected TextView a;
  public URLImageView a;
  public AnimationView a;
  public FeedCloudMeta.StFeed a;
  public QQCircleFeedBase.StPolyLike a;
  public vpo a;
  public vqa a;
  protected TextView b;
  
  public QCirclePolyBaseLikeView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new vpc(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setOnClickListener(new vpd(this));
    }
  }
  
  public FeedCloudMeta.StFeed a()
  {
    return this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  }
  
  public QQCircleFeedBase.StPolyLike a()
  {
    return this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike;
  }
  
  public void a() {}
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (paramView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)paramView.findViewById(2131373886));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131373887));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131373883));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373862));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373884));
      this.b = ((TextView)paramView.findViewById(2131373870));
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof QQCircleFeedBase.StPolyLike))
    {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike = ((QQCircleFeedBase.StPolyLike)paramObject);
      this.jdField_a_of_type_Int = paramInt;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentImageURLImageView.getContext().getResources().getDrawable(2130850664);
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_ComTencentImageURLImageView.getContext().getResources().getDrawable(2130850664);
      String str = this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyPreviewSource.get();
      paramObject = str;
      if (TextUtils.isEmpty(str)) {
        paramObject = this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyIconUrl.get();
      }
      paramObject = URLDrawable.getDrawable(paramObject, localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setVisibility(8);
      c();
    }
  }
  
  int b()
  {
    return this.d >> 8 << 8;
  }
  
  public int c()
  {
    return this.d & 0xFF;
  }
  
  public void setCurrentFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
  }
  
  public void setHookListener(vpo paramvpo)
  {
    this.jdField_a_of_type_Vpo = paramvpo;
  }
  
  public void setRequestManager(vqa paramvqa)
  {
    this.jdField_a_of_type_Vqa = paramvqa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyBaseLikeView
 * JD-Core Version:    0.7.0.1
 */