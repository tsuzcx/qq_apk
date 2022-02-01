package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget;

import android.animation.ValueAnimator;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.AnimatorFactory.SimpleAnimatorListener;
import com.tencent.biz.qqstory.support.logging.SLog;

class ElasticImageView$1
  extends AnimatorFactory.SimpleAnimatorListener
{
  ElasticImageView$1(ElasticImageView paramElasticImageView) {}
  
  public void a(ValueAnimator paramValueAnimator)
  {
    this.a.e = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    ElasticImageView.a(paramValueAnimator, paramValueAnimator.e);
    paramValueAnimator = new StringBuilder();
    paramValueAnimator.append("updateAnimator:");
    paramValueAnimator.append(this.a.e);
    SLog.b("ElasticImageView", paramValueAnimator.toString());
    ElasticImageView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.ElasticImageView.1
 * JD-Core Version:    0.7.0.1
 */