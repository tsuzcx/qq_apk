package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.List;

public class OpeningCardGroup
  extends MultilScreenlLayout
  implements Handler.Callback
{
  private IApolloOpenBoxListener b;
  private AnimationSet c;
  private float d;
  private int e;
  private int f;
  private WeakReferenceHandler g;
  
  public OpeningCardGroup(Context paramContext, IApolloOpenBoxListener paramIApolloOpenBoxListener)
  {
    super(paramContext);
    this.b = paramIApolloOpenBoxListener;
    this.g = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = super.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = super.getChildAt(i);
      float f1 = this.d;
      AnimationSet localAnimationSet = new AnimationSet(false);
      Object localObject = new ScaleAnimation(1.0F, f1, 1.0F, f1, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setFillAfter(true);
      localObject = new TranslateAnimation(0.0F, paramInt2 * i + paramInt1 - (localView.getLeft() + localView.getWidth() / 2), 0.0F, paramInt3 - this.e);
      ((TranslateAnimation)localObject).setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      localView.clearAnimation();
      localView.startAnimation(localAnimationSet);
      i += 1;
    }
    this.g.removeMessages(15);
    this.g.sendEmptyMessageDelayed(15, 400L);
  }
  
  public void a(int paramInt1, int paramInt2, ApolloBoxData paramApolloBoxData)
  {
    if (paramApolloBoxData != null)
    {
      if (paramApolloBoxData.n == null) {
        return;
      }
      int j = Math.min(super.getChildCount(), paramApolloBoxData.n.size());
      int i = 0;
      while (i < j)
      {
        View localView = super.getChildAt(i);
        localView.clearAnimation();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.width = paramInt1;
        localLayoutParams.height = paramInt2;
        if ((localView instanceof ApolloCardLayout)) {
          ((ApolloCardLayout)localView).a(1, (ApolloBoxData.ApolloBoxDataItem)paramApolloBoxData.n.get(i), paramInt1, paramInt2);
        }
        i += 1;
      }
      super.clearAnimation();
      super.setLayoutStyle(1);
    }
  }
  
  public void a(List<ApolloBoxData.ApolloBoxDataItem> paramList, List<ApolloCardLayout> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.removeAllViews();
    super.clearAnimation();
    super.setLayoutStyle(0);
    super.setCurrentFrame(0);
    float f1 = paramInt3;
    paramInt4 = (int)(0.706F * f1);
    int i = paramInt4 * 760 / 530;
    this.d = 1.0F;
    this.f = paramInt1;
    this.e = paramInt2;
    int j = Math.min(paramList1.size(), paramList.size());
    if (j == 1)
    {
      this.d = 1.818182F;
      paramInt4 = (int)(paramInt4 * 0.55F);
      i = (int)(i * 0.55F);
      paramList1 = (ApolloCardLayout)paramList1.get(0);
      paramList1.a(2, (ApolloBoxData.ApolloBoxDataItem)paramList.get(0), paramInt4, i);
      paramList = new FrameLayout.LayoutParams(paramInt4, i);
      paramList.leftMargin = (paramInt3 - paramInt1 - paramInt4 / 2);
      paramList.topMargin = (paramInt2 - i / 2);
      paramList1.clearAnimation();
      super.addView(paramList1, paramList);
      return;
    }
    if (j == 2)
    {
      this.d = 1.818182F;
      paramInt4 = (int)(paramInt4 * 0.55F);
      i = (int)(i * 0.55F);
      j = (int)(f1 * 0.016F);
      localApolloCardLayout = (ApolloCardLayout)paramList1.get(0);
      localApolloCardLayout.a(2, (ApolloBoxData.ApolloBoxDataItem)paramList.get(0), paramInt4, i);
      localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
      paramInt1 = paramInt3 - paramInt1 - j / 2 - paramInt4;
      paramInt2 -= i / 2;
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.topMargin = paramInt2;
      localApolloCardLayout.clearAnimation();
      super.addView(localApolloCardLayout, localLayoutParams);
      paramList1 = (ApolloCardLayout)paramList1.get(1);
      paramList1.a(2, (ApolloBoxData.ApolloBoxDataItem)paramList.get(1), paramInt4, i);
      paramList = new FrameLayout.LayoutParams(paramInt4, i);
      paramList.leftMargin = (paramInt1 + j + paramInt4);
      paramList.topMargin = paramInt2;
      paramList1.clearAnimation();
      super.addView(paramList1, paramList);
      return;
    }
    if (j == 3)
    {
      this.d = 2.631579F;
      paramInt4 = (int)(paramInt4 * 0.38F);
      i = (int)(i * 0.38F);
      localApolloCardLayout = (ApolloCardLayout)paramList1.get(0);
      localApolloCardLayout.a(3, (ApolloBoxData.ApolloBoxDataItem)paramList.get(0), paramInt4, i);
      localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
      paramInt1 = paramInt3 - paramInt1 - 0 - paramInt4 * 3 / 2;
      paramInt2 -= i / 2;
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.topMargin = paramInt2;
      localApolloCardLayout.clearAnimation();
      super.addView(localApolloCardLayout, localLayoutParams);
      localApolloCardLayout = (ApolloCardLayout)paramList1.get(1);
      localApolloCardLayout.a(3, (ApolloBoxData.ApolloBoxDataItem)paramList.get(1), paramInt4, i);
      localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
      paramInt1 = paramInt1 + 0 + paramInt4;
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.topMargin = paramInt2;
      localApolloCardLayout.clearAnimation();
      super.addView(localApolloCardLayout, localLayoutParams);
      paramList1 = (ApolloCardLayout)paramList1.get(2);
      paramList1.a(3, (ApolloBoxData.ApolloBoxDataItem)paramList.get(2), paramInt4, i);
      paramList = new FrameLayout.LayoutParams(paramInt4, i);
      paramList.leftMargin = (paramInt1 + 0 + paramInt4);
      paramList.topMargin = paramInt2;
      paramList1.clearAnimation();
      super.addView(paramList1, paramList);
      return;
    }
    this.d = 3.571429F;
    paramInt4 = (int)(paramInt4 * 0.28F);
    i = (int)(i * 0.28F);
    j = (int)(f1 * 0.008F);
    ApolloCardLayout localApolloCardLayout = (ApolloCardLayout)paramList1.get(0);
    localApolloCardLayout.a(4, (ApolloBoxData.ApolloBoxDataItem)paramList.get(0), paramInt4, i);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
    paramInt3 = paramInt3 - paramInt1 - j * 3 / 2 - paramInt4 * 2;
    paramInt1 = paramInt2 - i / 2;
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt1;
    localApolloCardLayout.clearAnimation();
    super.addView(localApolloCardLayout, localLayoutParams);
    localApolloCardLayout = (ApolloCardLayout)paramList1.get(1);
    localApolloCardLayout.a(4, (ApolloBoxData.ApolloBoxDataItem)paramList.get(1), paramInt4, i);
    localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
    paramInt2 = paramInt3 + j + paramInt4;
    localLayoutParams.leftMargin = paramInt2;
    localLayoutParams.topMargin = paramInt1;
    localApolloCardLayout.clearAnimation();
    super.addView(localApolloCardLayout, localLayoutParams);
    localApolloCardLayout = (ApolloCardLayout)paramList1.get(2);
    localApolloCardLayout.a(4, (ApolloBoxData.ApolloBoxDataItem)paramList.get(2), paramInt4, i);
    localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
    paramInt2 = paramInt2 + j + paramInt4;
    localLayoutParams.leftMargin = paramInt2;
    localLayoutParams.topMargin = paramInt1;
    localApolloCardLayout.clearAnimation();
    super.addView(localApolloCardLayout, localLayoutParams);
    paramList1 = (ApolloCardLayout)paramList1.get(3);
    paramList1.a(4, (ApolloBoxData.ApolloBoxDataItem)paramList.get(3), paramInt4, i);
    paramList = new FrameLayout.LayoutParams(paramInt4, i);
    paramList.leftMargin = (paramInt2 + j + paramInt4);
    paramList.topMargin = paramInt1;
    paramList1.clearAnimation();
    super.addView(paramList1, paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g.removeCallbacksAndMessages(null);
    if (paramBoolean)
    {
      this.b = null;
      this.a = null;
    }
  }
  
  public void b()
  {
    if (this.c == null)
    {
      this.c = new AnimationSet(true);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 0.25F, 0.0F, 0.25F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(150L);
      this.c.addAnimation(localScaleAnimation);
      localScaleAnimation = new ScaleAnimation(1.0F, 4.0F, 1.0F, 4.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(150L);
      localScaleAnimation.setStartOffset(450L);
      this.c.addAnimation(localScaleAnimation);
    }
    this.c.reset();
    super.startAnimation(this.c);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    int i = paramMessage.what;
    if (i != 15)
    {
      if (i != 16) {
        return false;
      }
      super.setVisibility(8);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloCardWindow", 2, "MSG_CODE_ANIMATION_END");
    }
    paramMessage = this.b;
    if (paramMessage != null) {
      paramMessage.a(10, 0, 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.OpeningCardGroup
 * JD-Core Version:    0.7.0.1
 */