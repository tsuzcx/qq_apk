package com.tencent.mobileqq.activity.aio;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.IScribblePicDownloadProcessor;
import com.tencent.mobileqq.transfile.IScribblePicUploadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class FileTransferManager
  implements Manager
{
  private final TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new FileTransferManager.1(this, Looper.getMainLooper());
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList<FileTransferManager.CallbackPack> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public FileTransferManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BuddyTransfileProcessor.class, ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getC2CPttDownloadProcessorClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getC2CPttUpProcessorClass(), ((IPicTransFile)paramQQAppInterface.getRuntimeService(IPicTransFile.class)).getC2CUploadProClass(), ((IPicTransFile)paramQQAppInterface.getRuntimeService(IPicTransFile.class)).getGroupUploadProClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getGroupPttDownloadProcessorClass(), ((IPicTransFile)paramQQAppInterface.getRuntimeService(IPicTransFile.class)).getC2CPicDownloadProClass(), ((IPicTransFile)paramQQAppInterface.getRuntimeService(IPicTransFile.class)).getGroupDownloadProClass(), ForwardImageProcessor.class, ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getShortVideoUploadProcessorClass(), ShortVideoDownloadProcessor.class, ((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getShortVideoForwardProcessorClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getPAAudioDownloadProcessorClass(), ((IScribblePicDownloadProcessor)QRoute.api(IScribblePicDownloadProcessor.class)).getProcessorClazz(), ((IScribblePicUploadProcessor)QRoute.api(IScribblePicUploadProcessor.class)).getProcessorClazz(), ForwardSdkShareProcessor.class, ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getGroupPttUpProcessorClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getSlicePttUpProcessorClass() });
    a(paramQQAppInterface);
  }
  
  public static FileTransferManager a(QQAppInterface paramQQAppInterface)
  {
    return (FileTransferManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_FILE_TRANS);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() == paramQQAppInterface)) {
      return;
    }
    localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      a();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      ((ITransFileController)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      ((IProtoReqManager)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getRuntimeService(IProtoReqManager.class, "")).onDestroy();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  void a(Message paramMessage)
  {
    try
    {
      if (!QLog.isColorLevel()) {
        break label226;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleMessage");
      ((StringBuilder)localObject1).append(((FileMsg)paramMessage.obj).uniseq);
      ((StringBuilder)localObject1).append(" status ");
      ((StringBuilder)localObject1).append(paramMessage.what);
      ((StringBuilder)localObject1).append("retCode ");
      ((StringBuilder)localObject1).append(paramMessage.arg1);
      QLog.d("FileTransferManager", 2, ((StringBuilder)localObject1).toString());
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        int j;
        for (;;)
        {
          throw paramMessage;
        }
        label226:
        int i = 0;
        continue;
        i = j + 1;
      }
    }
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject2 = (FileTransferManager.CallbackPack)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      j = i;
      if (localObject2 != null)
      {
        localObject1 = ((FileTransferManager.CallbackPack)localObject2).a();
        localObject2 = ((FileTransferManager.CallbackPack)localObject2).a();
        if ((localObject1 != null) && (localObject2 != null))
        {
          ((Callback)localObject2).handleMessage((View)localObject1, (FileMsg)paramMessage.obj, paramMessage.what, paramMessage.arg1);
          j = i;
        }
        else
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
          j = i - 1;
        }
      }
    }
    else
    {
      OpenApiManager.getInstance().onFileTransStatusChanged((FileMsg)paramMessage.obj, paramMessage.what, paramMessage.arg1);
      return;
    }
  }
  
  public void a(View paramView, Callback paramCallback)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        FileTransferManager.CallbackPack localCallbackPack = (FileTransferManager.CallbackPack)localIterator.next();
        if (localCallbackPack.a() == paramView)
        {
          localCallbackPack.b = new WeakReference(paramCallback);
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(new FileTransferManager.CallbackPack(this, paramView, paramCallback));
      return;
    }
    finally {}
    for (;;)
    {
      throw paramView;
    }
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.FileTransferManager
 * JD-Core Version:    0.7.0.1
 */