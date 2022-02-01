package com.tencent.aelight.camera.aioeditor.capture.text;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class DynamicTextConfigManager$DynamicTextResDownloader
{
  private DynamicTextConfigManager jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager;
  private ConcurrentHashMap<String, ArrayList<WeakReference<DynamicTextConfigManager.IDynamicTextResDownloadCallback>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public DynamicTextConfigManager$DynamicTextResDownloader(DynamicTextConfigManager paramDynamicTextConfigManager)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager = paramDynamicTextConfigManager;
  }
  
  private void a(DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo)
  {
    if (paramDynamicTextFontInfo != null)
    {
      if (TextUtils.isEmpty(paramDynamicTextFontInfo.c)) {
        return;
      }
      File[] arrayOfFile = DynamicTextConfigManager.a.listFiles();
      if (arrayOfFile != null)
      {
        if (arrayOfFile.length == 0) {
          return;
        }
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = arrayOfFile[i];
          if (localFile != null)
          {
            String str1 = localFile.getName();
            if (TextUtils.isEmpty(str1)) {
              localFile.delete();
            }
            if (str1.contains("_"))
            {
              String str2 = str1.substring(0, str1.lastIndexOf("_"));
              if ((paramDynamicTextFontInfo.c.equalsIgnoreCase(str2)) && (!str1.equalsIgnoreCase(paramDynamicTextFontInfo.a()))) {
                localFile.delete();
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(@NonNull DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo paramDynamicTextFontInfo, DynamicTextConfigManager.IDynamicTextResDownloadCallback paramIDynamicTextResDownloadCallback)
  {
    if ((paramDynamicTextFontInfo != null) && (!TextUtils.isEmpty(paramDynamicTextFontInfo.a)))
    {
      Object localObject2 = paramDynamicTextFontInfo.a;
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("startDownloadDynamicText res url: ");
        ((StringBuilder)???).append((String)localObject2);
        QLog.i("DText", 2, ((StringBuilder)???).toString());
      }
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject2);
        int j = 0;
        if (bool)
        {
          paramDynamicTextFontInfo = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
          localObject2 = paramDynamicTextFontInfo.iterator();
          do
          {
            i = j;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
          } while (((WeakReference)((Iterator)localObject2).next()).get() != paramIDynamicTextResDownloadCallback);
          int i = 1;
          if (i == 0) {
            paramDynamicTextFontInfo.add(new WeakReference(paramIDynamicTextResDownloadCallback));
          }
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new WeakReference(paramIDynamicTextResDownloadCallback));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, localArrayList);
        paramIDynamicTextResDownloadCallback = new HttpNetReq();
        paramIDynamicTextResDownloadCallback.mCallback = new DynamicTextConfigManager.DynamicTextResDownloader.1(this);
        paramIDynamicTextResDownloadCallback.mReqUrl = ((String)localObject2);
        paramIDynamicTextResDownloadCallback.mHttpMethod = 0;
        paramIDynamicTextResDownloadCallback.mOutPath = DynamicTextConfigManager.a(paramDynamicTextFontInfo);
        paramIDynamicTextResDownloadCallback.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        paramIDynamicTextResDownloadCallback.setUserData(paramDynamicTextFontInfo);
        AVNetEngine.a().sendReq(paramIDynamicTextResDownloadCallback);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextResDownloader
 * JD-Core Version:    0.7.0.1
 */