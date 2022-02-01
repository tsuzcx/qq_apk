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
    ITransAnimStateListener localITransAnimStateListener = this.jdField_a_of_type_ComTencentBizSubscribeTransitionInterITransAnimStateListener;
    if (localITransAnimStateListener != null)
    {
      if (paramInt != -1)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              return;
            }
            localITransAnimStateListener.m();
            return;
          }
          localITransAnimStateListener.k();
          return;
        }
        localITransAnimStateListener.l();
        return;
      }
      localITransAnimStateListener.n();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransAnimState
 * JD-Core Version:    0.7.0.1
 */