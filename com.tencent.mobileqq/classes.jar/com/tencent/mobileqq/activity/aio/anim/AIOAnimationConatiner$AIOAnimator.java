package com.tencent.mobileqq.activity.aio.anim;

import com.tencent.widget.ListView;

public abstract class AIOAnimationConatiner$AIOAnimator
{
  protected int a;
  protected AIOAnimationConatiner a;
  protected ListView a;
  
  public AIOAnimationConatiner$AIOAnimator(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
  
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected boolean a(int paramInt)
  {
    return false;
  }
  
  protected abstract boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  protected abstract boolean a(Object... paramVarArgs);
  
  protected void b() {}
  
  protected void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(paramInt);
  }
  
  protected abstract void c();
  
  protected void d()
  {
    AIOAnimationConatiner localAIOAnimationConatiner = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
    if (localAIOAnimationConatiner != null) {
      AIOAnimationConatiner.a(localAIOAnimationConatiner);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.AIOAnimator
 * JD-Core Version:    0.7.0.1
 */