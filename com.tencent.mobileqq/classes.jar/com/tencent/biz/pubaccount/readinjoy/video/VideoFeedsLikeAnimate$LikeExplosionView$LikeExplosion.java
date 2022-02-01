package com.tencent.biz.pubaccount.readinjoy.video;

import android.graphics.Canvas;
import java.util.Random;

class VideoFeedsLikeAnimate$LikeExplosionView$LikeExplosion
{
  public float a;
  public int a;
  public float b;
  public int b;
  public float c;
  public float d;
  public float e;
  public float f;
  public float g = 0.8F;
  public float h = 0.4F;
  
  public VideoFeedsLikeAnimate$LikeExplosionView$LikeExplosion(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView)
  {
    this.jdField_a_of_type_Int = 360;
    this.jdField_b_of_type_Int = 0;
    b();
  }
  
  private void b()
  {
    c();
    a();
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Int) {}
    for (int i = this.jdField_b_of_type_Int;; i = VideoFeedsLikeAnimate.LikeExplosionView.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView).nextInt() * (this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) + this.jdField_b_of_type_Int)
    {
      double d1 = Math.toRadians(i);
      this.e = ((float)(0.9F * Math.cos(d1)));
      this.f = ((float)(0.9F * Math.sin(d1)));
      return;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Float = (VideoFeedsLikeAnimate.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView.a) - VideoFeedsLikeAnimate.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView.a).getWidth() / 2);
    this.jdField_b_of_type_Float = (VideoFeedsLikeAnimate.b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView.a) - VideoFeedsLikeAnimate.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView.a).getHeight() / 2);
    this.c = this.jdField_a_of_type_Float;
    this.d = this.jdField_b_of_type_Float;
  }
  
  public void a(float paramFloat)
  {
    this.c = (this.jdField_a_of_type_Float + this.e * (float)VideoFeedsLikeAnimate.LikeExplosionView.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView) * paramFloat);
    this.d = (this.jdField_b_of_type_Float + this.f * (float)VideoFeedsLikeAnimate.LikeExplosionView.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate$LikeExplosionView) * paramFloat);
  }
  
  public void a(Canvas paramCanvas) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate.LikeExplosionView.LikeExplosion
 * JD-Core Version:    0.7.0.1
 */