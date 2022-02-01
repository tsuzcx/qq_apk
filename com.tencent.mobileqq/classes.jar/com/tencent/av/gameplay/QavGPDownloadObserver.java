package com.tencent.av.gameplay;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QavGPDownloadObserver
{
  int jdField_a_of_type_Int = 0;
  QAVGamePlaySoConfigInfo jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = null;
  ArrayList<QavGPDownloadManager.IGPDownloadStatusListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  QavGPDownloadObserver()
  {
    a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = QAVGamePlaySoConfigInfo.a();
    this.jdField_a_of_type_Int = QavGamePlayUtil.a(this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo);
    QLog.d("QavGPDownloadManager", 1, String.format("QavGPDownloadObserver, mStatusGameplay[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
  
  boolean a()
  {
    this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = QAVGamePlaySoConfigInfo.a();
    this.jdField_a_of_type_Int = QavGamePlayUtil.a(this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo);
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("checkResReady, mStatusGameplay[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    return 11 != this.jdField_a_of_type_Int;
  }
  
  boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("registReceiver[%s]", new Object[] { paramBaseApplicationImpl.getQQProcessName() }));
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.qavgameplaysomgr.notify");
    return paramBaseApplicationImpl.registerReceiver(new QavGPDownloadObserver.1(this), localIntentFilter) != null;
  }
  
  boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  boolean c()
  {
    this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = QAVGamePlaySoConfigInfo.a();
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = QavGamePlayUtil.a(this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo);
    if (this.jdField_a_of_type_Int == 11)
    {
      this.jdField_a_of_type_Int = 12;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      Intent localIntent = new Intent();
      localIntent.setAction("from_qavgpsomgr_download");
      localIntent.setClass(localBaseApplicationImpl.getApplicationContext(), JumpActivity.class);
      localIntent.addFlags(268435456);
      localBaseApplicationImpl.getBaseContext().startActivity(localIntent);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavGPDownloadManager", 2, String.format("nodifyDownloadRes, lastStatus[%s], mStatusGameplay[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gameplay.QavGPDownloadObserver
 * JD-Core Version:    0.7.0.1
 */