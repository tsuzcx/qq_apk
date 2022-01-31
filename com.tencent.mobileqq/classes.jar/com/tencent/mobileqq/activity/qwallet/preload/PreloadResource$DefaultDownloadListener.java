package com.tencent.mobileqq.activity.qwallet.preload;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class PreloadResource$DefaultDownloadListener
  extends PreloadResource.DownloadListenerWrapper
{
  public PreloadResource$DefaultDownloadListener(PreloadResource paramPreloadResource, DownloadListener paramDownloadListener)
  {
    super(paramDownloadListener);
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    int i = ResDownRecordUtil.a(paramString, 0);
    if (i == 0)
    {
      if (paramBoolean) {
        ResDownRecordUtil.a(paramString, 1);
      }
      return 1;
    }
    if (i == 1) {
      return 7;
    }
    if (paramBoolean) {
      ResDownRecordUtil.a(paramString, 1);
    }
    return i;
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    int j = 1;
    Object localObject1;
    PreloadModule localPreloadModule;
    File localFile;
    String str;
    label222:
    boolean bool;
    label265:
    int k;
    if ((paramDownloadTask != null) && (paramDownloadTask.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString)))
    {
      localObject1 = paramDownloadTask.a();
      localPreloadModule = (PreloadModule)((Bundle)localObject1).getSerializable("module");
      Object localObject2 = (PreloadResource)((Bundle)localObject1).getSerializable("resource");
      localFile = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString);
      if (localFile != null) {
        break label429;
      }
      localObject1 = "";
      if ((paramDownloadTask.jdField_a_of_type_Int != 0) || (localObject2 == null)) {
        break label480;
      }
      str = MD5Coding.encodeFile2HexStr((String)localObject1);
      if ((localFile == null) || (!localFile.exists()) || (TextUtils.isEmpty(str))) {
        break label480;
      }
      if ((TextUtils.isEmpty(((PreloadResource)localObject2).md5)) || (str.equalsIgnoreCase(((PreloadResource)localObject2).md5))) {
        break label439;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "preload onDoneFile md5 not match|" + ((PreloadResource)localObject2).mResId + "|" + str + "|" + ((PreloadResource)localObject2).md5);
      }
      QWalletTools.a((String)localObject1);
      ResDownRecordUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString, 5);
      paramDownloadTask.jdField_a_of_type_Int = -1;
      i = 1;
      if (paramDownloadTask.jdField_a_of_type_Int == -118) {
        i = 1;
      }
      if ((i != 0) && (localPreloadModule != null)) {
        localPreloadModule.removeResource((PreloadResource)localObject2);
      }
      localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (paramDownloadTask.jdField_a_of_type_Int != 0) {
        break label485;
      }
      bool = true;
      k = a((String)localObject2, bool);
      paramDownloadTask.a().putInt("scene", k);
      if ((k == 7) && (paramDownloadTask.jdField_a_of_type_Int == 0)) {
        if ((localFile == null) || (localFile.exists())) {
          break label491;
        }
      }
    }
    label429:
    label439:
    label480:
    label485:
    label491:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        ResUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "preload onDoneFile|" + paramDownloadTask.jdField_a_of_type_Int + "|" + paramDownloadTask.jdField_a_of_type_JavaLangString + "|" + (String)localObject1 + "|" + k);
      }
      super.onDoneFile(paramDownloadTask);
      if (this.a.isNeedReport(paramDownloadTask.jdField_a_of_type_JavaLangString)) {
        this.a.reportDownload(paramDownloadTask.jdField_a_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int, localPreloadModule);
      }
      return;
      localObject1 = localFile.getAbsolutePath();
      break;
      ResUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString, str, NetConnInfoCenter.getServerTimeMillis());
      if (PreloadResource.access$000(this.a, (String)localObject1, paramDownloadTask.jdField_a_of_type_JavaLangString)) {
        this.a.unzip((String)localObject1, paramDownloadTask.jdField_a_of_type_JavaLangString);
      }
      i = 0;
      break label222;
      bool = false;
      break label265;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadResource.DefaultDownloadListener
 * JD-Core Version:    0.7.0.1
 */