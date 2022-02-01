package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.CountDownLatch;

public final class j$a<TResult>
  implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult>
{
  public final CountDownLatch a = new CountDownLatch(1);
  
  public final void onCanceled()
  {
    this.a.countDown();
  }
  
  public final void onFailure(Exception paramException)
  {
    this.a.countDown();
  }
  
  public final void onSuccess(TResult paramTResult)
  {
    this.a.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.j.a
 * JD-Core Version:    0.7.0.1
 */