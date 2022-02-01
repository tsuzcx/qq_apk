package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

public class PreviewCaptureManager
  implements CapturePreparedListener, CaptureTask.OnTaskListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new PreviewCaptureManager.1(this);
  private ICaptureProxy jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy;
  private Queue<CaptureTask> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManagerExecutor.getExecutorService(64);
  private boolean jdField_a_of_type_Boolean = false;
  private Queue<CaptureTask> b = new ArrayDeque();
  
  public PreviewCaptureManager(ICaptureProxy paramICaptureProxy)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy = paramICaptureProxy;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.a(this);
  }
  
  private boolean a()
  {
    return this.b.size() < 3;
  }
  
  private void b()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilQueue.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("PreviewCaptureManager", 2, "fetchTaskToExe return for capturePrepared is false or waittingTaskQueue is Empty");
      }
    }
    for (;;)
    {
      return;
      while (a())
      {
        CaptureTask localCaptureTask = (CaptureTask)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localCaptureTask != null) {
          e(localCaptureTask);
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
  }
  
  private void d(CaptureTask paramCaptureTask)
  {
    paramCaptureTask.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy);
    paramCaptureTask.a(this);
  }
  
  private void e(CaptureTask paramCaptureTask)
  {
    this.b.add(paramCaptureTask);
    d(paramCaptureTask);
    paramCaptureTask.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilQueue);
    localArrayList.addAll(this.b);
    this.jdField_a_of_type_JavaUtilQueue.clear();
    this.b.clear();
    int i = 0;
    while (i < localArrayList.size())
    {
      CaptureTask localCaptureTask = (CaptureTask)localArrayList.get(i);
      if (localCaptureTask != null) {
        localCaptureTask.cancel(true);
      }
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void a(CaptureTask paramCaptureTask) {}
  
  public void b(CaptureTask paramCaptureTask)
  {
    this.b.remove(paramCaptureTask);
    c();
  }
  
  public void c(CaptureTask paramCaptureTask)
  {
    if ((this.jdField_a_of_type_JavaUtilQueue.contains(paramCaptureTask)) || (this.b.contains(paramCaptureTask))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreviewCaptureManager", 2, "addCaptureTask task:" + paramCaptureTask);
    }
    this.jdField_a_of_type_JavaUtilQueue.add(paramCaptureTask);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.PreviewCaptureManager
 * JD-Core Version:    0.7.0.1
 */