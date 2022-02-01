package com.tencent.gathererga.core.internal.util;

import com.tencent.gathererga.core.IExecutor;

public class GathererExecutor
  implements IExecutor
{
  private static volatile GathererExecutor jdField_a_of_type_ComTencentGatherergaCoreInternalUtilGathererExecutor;
  private IExecutor jdField_a_of_type_ComTencentGatherergaCoreIExecutor = null;
  private IExecutor b = null;
  
  private IExecutor a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGatherergaCoreIExecutor;
    if (localObject != null) {
      return localObject;
    }
    IExecutor localIExecutor = this.b;
    localObject = localIExecutor;
    if (localIExecutor == null)
    {
      this.b = new GathererExecutor.DefaultExecutor();
      localObject = this.b;
    }
    return localObject;
  }
  
  public static GathererExecutor a()
  {
    if (jdField_a_of_type_ComTencentGatherergaCoreInternalUtilGathererExecutor == null) {
      try
      {
        if (jdField_a_of_type_ComTencentGatherergaCoreInternalUtilGathererExecutor == null) {
          jdField_a_of_type_ComTencentGatherergaCoreInternalUtilGathererExecutor = new GathererExecutor();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentGatherergaCoreInternalUtilGathererExecutor;
  }
  
  public void a(IExecutor paramIExecutor)
  {
    this.jdField_a_of_type_ComTencentGatherergaCoreIExecutor = paramIExecutor;
  }
  
  public void execute(Runnable paramRunnable)
  {
    a().execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.GathererExecutor
 * JD-Core Version:    0.7.0.1
 */