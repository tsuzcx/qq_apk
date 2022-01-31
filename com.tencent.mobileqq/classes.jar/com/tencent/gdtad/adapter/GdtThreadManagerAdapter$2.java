package com.tencent.gdtad.adapter;

import aamn;
import com.tencent.mobileqq.app.ThreadManager;

public class GdtThreadManagerAdapter$2
  implements Runnable
{
  public GdtThreadManagerAdapter$2(aamn paramaamn, Runnable paramRunnable, int paramInt) {}
  
  public void run()
  {
    ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Int, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtThreadManagerAdapter.2
 * JD-Core Version:    0.7.0.1
 */