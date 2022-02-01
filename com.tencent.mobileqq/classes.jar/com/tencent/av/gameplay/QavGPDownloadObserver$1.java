package com.tencent.av.gameplay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class QavGPDownloadObserver$1
  extends BroadcastReceiver
{
  QavGPDownloadObserver$1(QavGPDownloadObserver paramQavGPDownloadObserver) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    for (;;)
    {
      return;
      if (!"tencent.video.qavgameplaysomgr.notify".equals(paramIntent.getAction())) {
        continue;
      }
      int i = paramIntent.getIntExtra("Event_Progress", 0);
      if ((i == 100) || (i < 0))
      {
        this.a.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo = QAVGamePlaySoConfigInfo.a();
        int j = this.a.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_Int = QavGamePlayUtil.a(this.a.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo);
        boolean bool;
        if ((i == 100) && (this.a.jdField_a_of_type_Int != 11))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("QavGPDownloadManager", 2, String.format("receive notify, lastStatus[%s], progress[%s], mStatusGameplay[%s], data[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo }));
          }
          paramIntent = new ArrayList();
        }
        synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
        {
          paramIntent.addAll(this.a.jdField_a_of_type_JavaUtilArrayList);
          ??? = paramIntent.iterator();
          while (???.hasNext()) {
            ((QavGPDownloadManager.IGPDownloadStatusListener)???.next()).a(bool, this.a.b(), this.a.jdField_a_of_type_Int);
          }
          bool = false;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGPDownloadManager", 4, String.format("receive notify, progress[%s]", new Object[] { Integer.valueOf(i) }));
      }
      paramIntent = new ArrayList();
      synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
      {
        paramIntent.addAll(this.a.jdField_a_of_type_JavaUtilArrayList);
        ??? = paramIntent.iterator();
        if (!???.hasNext()) {
          continue;
        }
        ((QavGPDownloadManager.IGPDownloadStatusListener)???.next()).a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gameplay.QavGPDownloadObserver.1
 * JD-Core Version:    0.7.0.1
 */