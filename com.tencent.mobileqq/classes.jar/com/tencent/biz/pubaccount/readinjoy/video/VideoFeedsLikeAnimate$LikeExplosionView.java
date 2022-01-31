package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import qdv;
import qdw;
import qdx;
import qdy;

public class VideoFeedsLikeAnimate$LikeExplosionView
  extends View
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long = 500L;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private List<qdy> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Random jdField_a_of_type_JavaUtilRandom;
  
  public VideoFeedsLikeAnimate$LikeExplosionView(VideoFeedsLikeAnimate paramVideoFeedsLikeAnimate, Context paramContext, Random paramRandom)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
  }
  
  private void b()
  {
    VideoFeedsLikeAnimate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLikeAnimate).removeView(this);
  }
  
  public void a()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.12F, 1.0F), Keyframe.ofFloat(0.8F, 1.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "explosionFraction", new float[] { 0.0F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
    localAnimatorSet.setStartDelay(250L);
    localAnimatorSet.addListener(new qdv(this));
    localAnimatorSet.setDuration(this.jdField_a_of_type_Long);
    localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((qdy)localIterator.next()).a(paramCanvas);
      }
    }
  }
  
  public void setExplosionEachDirection(int paramInt)
  {
    if (paramInt <= 0) {}
    do
    {
      for (;;)
      {
        return;
        int i = 0;
        while (i < 4)
        {
          int k = i * 90;
          int j = 0;
          for (;;)
          {
            if (j < paramInt) {}
            try
            {
              int m = (int)(this.jdField_a_of_type_JavaUtilRandom.nextFloat() * ((i + 1) * 90 - k) + k);
              if (QLog.isColorLevel()) {
                QLog.d("VideoFeedsLikeAnimate", 2, "setIconExplosionEachDirection, angele: " + m);
              }
              this.jdField_a_of_type_JavaUtilList.add(new qdw(this, m));
              j += 1;
            }
            catch (Exception localException) {}
          }
          i += 1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsLikeAnimate", 2, "setIconExplosionEachDirection: " + localException.getMessage());
  }
  
  public void setExplosionFraction(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qdy)localIterator.next()).a(paramFloat);
    }
    invalidate();
  }
  
  public void setExplosionSize(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      this.jdField_a_of_type_JavaUtilList.add(new qdw(this));
      i += 1;
    }
  }
  
  public void setIconExplosion(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfDrawable == null) || (paramArrayOfDrawable.length == 0) || (paramInt1 <= 0)) {}
    do
    {
      return;
      int[] arrayOfInt = new int[3];
      int[] tmp21_19 = arrayOfInt;
      tmp21_19[0] = -15;
      int[] tmp26_21 = tmp21_19;
      tmp26_21[1] = 0;
      int[] tmp30_26 = tmp26_21;
      tmp30_26[2] = 15;
      tmp30_26;
      int i = 0;
      while (i < paramInt1) {
        try
        {
          int j = this.jdField_a_of_type_JavaUtilRandom.nextInt(paramArrayOfDrawable.length);
          int k = this.jdField_a_of_type_JavaUtilRandom.nextInt(arrayOfInt.length);
          this.jdField_a_of_type_JavaUtilList.add(new qdx(this, paramArrayOfDrawable[j], paramInt2, arrayOfInt[k]));
          i += 1;
        }
        catch (Exception paramArrayOfDrawable) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsLikeAnimate", 2, "setIconExplosion: " + paramArrayOfDrawable.getMessage());
  }
  
  public void setIconExplosionEachDirection(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfDrawable == null) || (paramArrayOfDrawable.length == 0) || (paramInt1 <= 0)) {
      return;
    }
    for (;;)
    {
      int[] arrayOfInt;
      int i;
      int j;
      int k;
      try
      {
        arrayOfInt = new int[3];
        int[] tmp21_19 = arrayOfInt;
        tmp21_19[0] = -15;
        int[] tmp26_21 = tmp21_19;
        tmp26_21[1] = 0;
        int[] tmp30_26 = tmp26_21;
        tmp30_26[2] = 15;
        tmp30_26;
        i = 0;
      }
      catch (Exception paramArrayOfDrawable) {}
      if (j < paramInt1)
      {
        int m = this.jdField_a_of_type_JavaUtilRandom.nextInt(paramArrayOfDrawable.length);
        int n = this.jdField_a_of_type_JavaUtilRandom.nextInt(arrayOfInt.length);
        int i1 = (int)(this.jdField_a_of_type_JavaUtilRandom.nextFloat() * ((i + 1) * 90 - k) + k);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsLikeAnimate", 2, "angele: " + i1);
        }
        this.jdField_a_of_type_JavaUtilList.add(new qdx(this, paramArrayOfDrawable[m], paramInt2, arrayOfInt[n], i1));
        j += 1;
      }
      else
      {
        i += 1;
        break label213;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("VideoFeedsLikeAnimate", 2, "setIconExplosionEachDirection: " + paramArrayOfDrawable.getMessage());
        return;
        label213:
        if (i >= 4) {
          break;
        }
        k = i * 90;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate.LikeExplosionView
 * JD-Core Version:    0.7.0.1
 */