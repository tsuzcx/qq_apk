package com.tencent.biz.pubaccount.readinjoy.automator;

import org.jetbrains.annotations.NotNull;

public final class AsyncSteps
  extends BaseStep
  implements StepGroup
{
  private int jdField_a_of_type_Int;
  private final BaseStep[] jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyAutomatorBaseStep;
  
  public AsyncSteps(@NotNull Automator paramAutomator, @NotNull BaseStep[] paramArrayOfBaseStep)
  {
    super(paramAutomator, false, "AsyncSteps");
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyAutomatorBaseStep = paramArrayOfBaseStep;
    paramAutomator = this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyAutomatorBaseStep;
    int j = paramAutomator.length;
    while (i < j)
    {
      paramAutomator[i].a(this);
      i += 1;
    }
  }
  
  public void a()
  {
    super.a();
    BaseStep[] arrayOfBaseStep = this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyAutomatorBaseStep;
    int j = arrayOfBaseStep.length;
    int i = 0;
    while (i < j)
    {
      arrayOfBaseStep[i].a();
      i += 1;
    }
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_a_of_type_Int = 0;
    return true;
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Int += 1;
    a("AsyncSteps onEnd: mFinishCount = " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyAutomatorBaseStep.length) {
      d();
    }
  }
  
  public boolean b()
  {
    BaseStep[] arrayOfBaseStep = this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyAutomatorBaseStep;
    int j = arrayOfBaseStep.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfBaseStep[i];
      AsyncSteps.1 local1;
      if (((BaseStep)localObject).a())
      {
        local1 = new AsyncSteps.1(this, (BaseStep)localObject);
        if (((BaseStep)localObject).c()) {
          local1.run();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = a().a();
        if (localObject != null)
        {
          ((IThreadExecutor)localObject).a(local1);
        }
        else
        {
          new Thread(local1).start();
          continue;
          a().b(new AsyncSteps.2(this, (BaseStep)localObject));
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps
 * JD-Core Version:    0.7.0.1
 */