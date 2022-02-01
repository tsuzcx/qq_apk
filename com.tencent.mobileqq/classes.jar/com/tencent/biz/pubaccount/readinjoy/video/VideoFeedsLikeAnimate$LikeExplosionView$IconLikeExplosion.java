package com.tencent.biz.pubaccount.readinjoy.video;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

class VideoFeedsLikeAnimate$LikeExplosionView$IconLikeExplosion
  extends VideoFeedsLikeAnimate.LikeExplosionView.LikeExplosion
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  private int d;
  
  public VideoFeedsLikeAnimate$LikeExplosionView$IconLikeExplosion(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    super(paramLikeExplosionView);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  public VideoFeedsLikeAnimate$LikeExplosionView$IconLikeExplosion(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramLikeExplosionView);
    double d1 = Math.toRadians(paramInt3);
    this.e = ((float)Math.cos(d1));
    this.f = ((float)Math.sin(d1));
    a();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  public void a(Canvas paramCanvas)
  {
    int i = (int)(this.jdField_c_of_type_Float - this.jdField_c_of_type_Int / 2);
    int j = (int)(this.jdField_d_of_type_Float - this.jdField_c_of_type_Int / 2);
    int k = this.jdField_c_of_type_Int;
    int m = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, j, k + i, m + j);
    VideoFeedsLikeAnimate.LikeExplosionView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView).reset();
    VideoFeedsLikeAnimate.LikeExplosionView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView).setRotate(this.jdField_d_of_type_Int, VideoFeedsLikeAnimate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView.a), VideoFeedsLikeAnimate.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView.a));
    paramCanvas.setMatrix(VideoFeedsLikeAnimate.LikeExplosionView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate.LikeExplosionView.IconLikeExplosion
 * JD-Core Version:    0.7.0.1
 */