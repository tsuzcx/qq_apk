package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextSwitcher;
import com.tencent.mobileqq.app.ThreadManager;
import lvv;
import lvw;
import lvx;

public class RedPacketRollTextView
  extends TextSwitcher
  implements Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private lvw jdField_a_of_type_Lvw;
  private lvx jdField_a_of_type_Lvx = new lvx(this);
  protected boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private int c;
  private int d = 50;
  
  public RedPacketRollTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext, true);
  }
  
  public RedPacketRollTextView(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.d = paramInt;
    a(paramContext, paramBoolean);
  }
  
  public RedPacketRollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext, true);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int != paramInt1) || (this.jdField_b_of_type_Int != paramInt2))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      paramInt1 = (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int + 10) % 10;
      if (paramInt1 <= 0) {
        break label70;
      }
    }
    label70:
    for (paramInt1 = 250 / paramInt1;; paramInt1 = 0)
    {
      if (this.c != paramInt1)
      {
        this.c = paramInt1;
        c();
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      c();
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      localTranslateAnimation.setDuration(this.c);
      localTranslateAnimation.setInterpolator(new LinearInterpolator());
      localTranslateAnimation.setFillAfter(true);
      setInAnimation(localTranslateAnimation);
      localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
      localTranslateAnimation.setDuration(this.c);
      localTranslateAnimation.setInterpolator(new LinearInterpolator());
      localTranslateAnimation.setFillAfter(false);
      setOutAnimation(localTranslateAnimation);
      localTranslateAnimation.setAnimationListener(this);
      return;
    }
    setInAnimation(null);
    setOutAnimation(null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramBoolean);
    setFactory(new lvv(this, paramBoolean));
  }
  
  public void b()
  {
    ThreadManager.postImmediately(new RedPacketRollTextView.ContentSupplyThread(this), null, true);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Log.e("RollTextView", "WL_DEBUG onAnimationEnd");
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    Log.e("RollTextView", "WL_DEBUG onAnimationRepeat");
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    Log.e("RollTextView", "WL_DEBUG onAnimationStart");
  }
  
  public void setListener(lvw paramlvw)
  {
    this.jdField_a_of_type_Lvw = paramlvw;
  }
  
  public void setScope(int paramInt1, int paramInt2)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      a(paramInt2, paramInt2);
      return;
    }
    a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketRollTextView
 * JD-Core Version:    0.7.0.1
 */