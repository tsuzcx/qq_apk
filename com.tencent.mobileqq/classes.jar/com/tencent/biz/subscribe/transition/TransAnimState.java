package com.tencent.biz.subscribe.transition;

import com.tencent.biz.subscribe.transition.inter.ITransAnimStateListener;

public class TransAnimState
{
  private volatile int jdField_a_of_type_Int = 0;
  private ITransAnimStateListener jdField_a_of_type_ComTencentBizSubscribeTransitionInterITransAnimStateListener;
  
  public void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizSubscribeTransitionInterITransAnimStateListener != null) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.jdField_a_of_type_ComTencentBizSubscribeTransitionInterITransAnimStateListener.n();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizSubscribeTransitionInterITransAnimStateListener.l();
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentBizSubscribeTransitionInterITransAnimStateListener.k();
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeTransitionInterITransAnimStateListener.m();
  }
  
  public void a(ITransAnimStateListener paramITransAnimStateListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeTransitionInterITransAnimStateListener = paramITransAnimStateListener;
    a(this.jdField_a_of_type_Int);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransAnimState
 * JD-Core Version:    0.7.0.1
 */