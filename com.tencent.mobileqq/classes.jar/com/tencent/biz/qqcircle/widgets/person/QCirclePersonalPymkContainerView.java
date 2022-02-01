package com.tencent.biz.qqcircle.widgets.person;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendAdapter.IWidgetHideIntercept;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StItemContainer;

public class QCirclePersonalPymkContainerView
  extends LinearLayout
{
  private QCirclePYMKRecommendView a = null;
  private int b = 0;
  private int c = 0;
  
  public QCirclePersonalPymkContainerView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public QCirclePersonalPymkContainerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private int a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    if (paramStItemContainer == null) {
      return 0;
    }
    int i = paramStItemContainer.styleType.get();
    if (i == 50001) {
      i = 354;
    } else if (i == 50002) {
      i = 386;
    } else {
      i = 330;
    }
    return ViewUtils.a(i);
  }
  
  private void a(float paramFloat)
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      QLog.d("PYMK-QCirclePersonalPymkContainerView", 1, "[handlerAnimationUpdate] pymk recommend content should not be null.");
      return;
    }
    ((QCirclePYMKRecommendView)localObject).setAlpha(1.0F * paramFloat);
    localObject = this.a.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(paramFloat * this.b));
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(boolean paramBoolean)
  {
    float f2 = 0.0F;
    float f1;
    if (paramBoolean) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    if (paramBoolean) {
      f2 = 1.0F;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f1, f2 });
    localValueAnimator.setDuration(320L);
    localValueAnimator.addUpdateListener(new QCirclePersonalPymkContainerView.1(this));
    localValueAnimator.addListener(new QCirclePersonalPymkContainerView.2(this, paramBoolean));
    localValueAnimator.start();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QCirclePYMKRecommendView localQCirclePYMKRecommendView = this.a;
    if (localQCirclePYMKRecommendView == null)
    {
      QLog.w("PYMK-QCirclePersonalPymkContainerView", 1, "[handlerAnimStateChange] pymk recommend view should not be null.");
      return;
    }
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      localQCirclePYMKRecommendView.setVisibility(8);
      return;
    }
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.setVisibility(0);
    }
  }
  
  private void b()
  {
    this.a = new QCirclePYMKRecommendView(getContext(), Integer.valueOf(1001));
    this.a.setPageId(this.c);
    addView(this.a);
  }
  
  public void a()
  {
    if (this.a == null)
    {
      QLog.w("PYMK-QCirclePersonalPymkContainerView", 1, "[hidePymkContent] view should not be null.");
      return;
    }
    a(false);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.w("PYMK-QCirclePersonalPymkContainerView", 1, "[loadPymkContent] feed should not be null.");
      return;
    }
    String str = paramStFeed.id.get();
    paramStFeed = new FeedBlockData(paramStFeed);
    this.a.bindData(paramStFeed, 0);
    this.b = a(this.a.getCurrentContainer());
    QLog.d("PYMK-QCirclePersonalPymkContainerView", 1, new Object[] { "[loadPymkContent] current container height: ", Integer.valueOf(this.b), " | feedId: ", str });
    a(true);
  }
  
  public void setPageId(int paramInt)
  {
    this.c = paramInt;
    QCirclePYMKRecommendView localQCirclePYMKRecommendView = this.a;
    if (localQCirclePYMKRecommendView != null) {
      localQCirclePYMKRecommendView.setPageId(paramInt);
    }
  }
  
  public void setWidgetHideIntercept(QCirclePYMKRecommendAdapter.IWidgetHideIntercept paramIWidgetHideIntercept)
  {
    QCirclePYMKRecommendView localQCirclePYMKRecommendView = this.a;
    if (localQCirclePYMKRecommendView == null)
    {
      QLog.d("PYMK-QCirclePersonalPymkContainerView", 1, "[setWidgetHideIntercept] recommend adapter should not be null.");
      return;
    }
    localQCirclePYMKRecommendView.setWidgetHideIntercept(paramIWidgetHideIntercept);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.person.QCirclePersonalPymkContainerView
 * JD-Core Version:    0.7.0.1
 */