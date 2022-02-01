package com.tencent.biz.pubaccount.readinjoy.automator;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Automator
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  @Nullable
  private ILog jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorILog;
  @Nullable
  private IThreadExecutor jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorIThreadExecutor;
  @Nullable
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList<BaseStep> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedList<BaseStep> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  private void c()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      localObject = (BaseStep)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((BaseStep)localObject).a())
      {
        local4 = new Automator.4(this, (BaseStep)localObject);
        if (((BaseStep)localObject).c()) {
          local4.run();
        }
      }
    }
    while (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      Automator.4 local4;
      return;
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorIThreadExecutor;
      if (localObject != null)
      {
        ((IThreadExecutor)localObject).a(local4);
        return;
      }
      new Thread(local4).start();
      return;
      b(new Automator.5(this, (BaseStep)localObject));
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  @Nullable
  public final ILog a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorILog;
  }
  
  @Nullable
  public final IThreadExecutor a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorIThreadExecutor;
  }
  
  public final void a()
  {
    b(new Automator.3(this));
  }
  
  public final void a(@NotNull BaseStep paramBaseStep)
  {
    b(new Automator.6(this, paramBaseStep));
  }
  
  public final void a(@Nullable ILog paramILog)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorILog = paramILog;
  }
  
  public final void a(@Nullable IThreadExecutor paramIThreadExecutor)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAutomatorIThreadExecutor = paramIThreadExecutor;
  }
  
  public final void a(@Nullable Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public final void a(@NotNull BaseStep[] paramArrayOfBaseStep, boolean paramBoolean)
  {
    b(new Automator.1(this, paramArrayOfBaseStep, paramBoolean));
  }
  
  public final void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((BaseStep)localIterator.next()).a();
    }
  }
  
  public void b(@NotNull Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramRunnable.run();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.automator.Automator
 * JD-Core Version:    0.7.0.1
 */