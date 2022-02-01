package com.tencent.mobileqq.ark.core;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import java.lang.ref.WeakReference;

public class ArkPredownloader$Task
{
  BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  WeakReference<IPreDownloadController> jdField_a_of_type_JavaLangRefWeakReference;
  String b;
  
  public void a(Runnable paramRunnable)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null)
    {
      paramRunnable.run();
      return;
    }
    localObject = (IPreDownloadController)((WeakReference)localObject).get();
    if (localObject == null)
    {
      paramRunnable.run();
      return;
    }
    paramRunnable = new RunnableTask(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.b, paramRunnable, 10000L);
    ((IPreDownloadController)localObject).requestPreDownload(10022, "prd", this.b, 0, this.jdField_a_of_type_JavaLangString, "", 1, 0, false, paramRunnable);
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (IPreDownloadController)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((IPreDownloadController)localObject).preDownloadSuccess(paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkPredownloader.Task
 * JD-Core Version:    0.7.0.1
 */