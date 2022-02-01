package com.tencent.mobileqq.activity.aio.anim;

import com.tencent.widget.ListView;

public abstract class AIOAnimationConatiner$AIOAnimator
{
  protected AIOAnimationConatiner a;
  protected ListView b;
  protected int c;
  
  public AIOAnimationConatiner$AIOAnimator(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    this.c = paramInt;
    this.a = paramAIOAnimationConatiner;
    this.b = paramListView;
  }
  
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected abstract boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  protected abstract boolean a(Object... paramVarArgs);
  
  protected void b() {}
  
  protected boolean b(int paramInt)
  {
    return false;
  }
  
  protected abstract void c();
  
  protected void c(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  protected void d()
  {
    AIOAnimationConatiner localAIOAnimationConatiner = this.a;
    if (localAIOAnimationConatiner != null) {
      AIOAnimationConatiner.a(localAIOAnimationConatiner);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.AIOAnimator
 * JD-Core Version:    0.7.0.1
 */