package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerSaveUtils;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class QIMInformationPasterManager$InformationPasterResDownloader
{
  private QIMInformationPasterManager jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterQIMInformationPasterManager;
  private ConcurrentHashMap<String, ArrayList<WeakReference<QIMInformationPasterManager.IInformationPasterResDownloaderCallback>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public QIMInformationPasterManager$InformationPasterResDownloader(QIMInformationPasterManager paramQIMInformationPasterManager)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterQIMInformationPasterManager = paramQIMInformationPasterManager;
  }
  
  public void a(@NonNull InformationFacePackage.Item paramItem, QIMInformationPasterManager.IInformationPasterResDownloaderCallback paramIInformationPasterResDownloaderCallback)
  {
    String str = paramItem.e;
    if ((str != null) && (!TextUtils.isEmpty(str)))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("startDownloadDynamicText res url: ");
        ((StringBuilder)???).append(str);
        QLog.i("QIMInformationPasterManager", 2, ((StringBuilder)???).toString());
      }
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        int j = 0;
        if (localArrayList != null)
        {
          paramItem = localArrayList.iterator();
          do
          {
            i = j;
            if (!paramItem.hasNext()) {
              break;
            }
          } while (((WeakReference)paramItem.next()).get() != paramIInformationPasterResDownloaderCallback);
          int i = 1;
          if (i == 0) {
            localArrayList.add(new WeakReference(paramIInformationPasterResDownloaderCallback));
          }
          if (QLog.isColorLevel())
          {
            paramItem = new StringBuilder();
            paramItem.append("already put url ");
            paramItem.append(str);
            QLog.i("QIMInformationPasterManager", 2, paramItem.toString());
          }
          return;
        }
        localArrayList = new ArrayList();
        localArrayList.add(new WeakReference(paramIInformationPasterResDownloaderCallback));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localArrayList);
        paramIInformationPasterResDownloaderCallback = new HttpNetReq();
        paramIInformationPasterResDownloaderCallback.mCallback = new QIMInformationPasterManager.InformationPasterResDownloader.1(this);
        paramIInformationPasterResDownloaderCallback.mReqUrl = str;
        paramIInformationPasterResDownloaderCallback.mHttpMethod = 0;
        paramIInformationPasterResDownloaderCallback.mOutPath = InfoStickerSaveUtils.a(paramItem);
        paramIInformationPasterResDownloaderCallback.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        paramIInformationPasterResDownloaderCallback.setUserData(paramItem);
        AVNetEngine.a().sendReq(paramIInformationPasterResDownloaderCallback);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMInformationPasterManager", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.InformationPasterResDownloader
 * JD-Core Version:    0.7.0.1
 */