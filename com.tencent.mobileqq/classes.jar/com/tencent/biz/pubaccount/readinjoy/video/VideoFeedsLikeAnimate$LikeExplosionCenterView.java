package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import rzv;

public class VideoFeedsLikeAnimate$LikeExplosionCenterView
  extends View
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  
  public VideoFeedsLikeAnimate$LikeExplosionCenterView(VideoFeedsLikeAnimate paramVideoFeedsLikeAnimate, Context paramContext)
  {
    super(paramContext);
  }
  
  private void b()
  {
    setAlpha(0.0F);
    if (VideoFeedsLikeAnimate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate) != null) {
      VideoFeedsLikeAnimate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate).removeView(this);
    }
  }
  
  public void a()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.75F, 1.0F) }) });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("scaleX", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.4F), Keyframe.ofFloat(0.75F, 1.0F), Keyframe.ofFloat(1.0F, 1.28F) }) });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("scaleY", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.4F), Keyframe.ofFloat(0.75F, 1.0F), Keyframe.ofFloat(1.0F, 1.28F) }) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(400L);
    localObjectAnimator1.addListener(new rzv(this));
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
    localAnimatorSet.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, VideoFeedsLikeAnimate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate) - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, VideoFeedsLikeAnimate.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate) - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void setDrawableId(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate.LikeExplosionCenterView
 * JD-Core Version:    0.7.0.1
 */