package com.tencent.biz.troop;

import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

class VideoCombineHelper$DownLoadTask$1
  extends DownloadListener
{
  VideoCombineHelper$DownLoadTask$1(VideoCombineHelper.DownLoadTask paramDownLoadTask, VideoCombineHelper.CombineParams paramCombineParams, ArrayList paramArrayList, long paramLong) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.a == 0)
    {
      paramDownloadTask = this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (paramDownloadTask.hasNext()) {
        if (!((File)paramDownloadTask.next()).exists())
        {
          this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask);
          return;
        }
      }
      try
      {
        paramDownloadTask = this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.b.iterator();
        int i = 1;
        while (paramDownloadTask.hasNext())
        {
          String str = (String)paramDownloadTask.next();
          File localFile = new File(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.a() + File.separator + "v_" + i + ".mp4");
          this.jdField_a_of_type_JavaUtilArrayList.add(localFile.getAbsolutePath());
          if (localFile.exists())
          {
            i += 1;
          }
          else
          {
            if (!localFile.exists()) {
              localFile.createNewFile();
            }
            FileUtils.a(new File(str), localFile);
            i += 1;
          }
        }
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.b();
      }
      catch (IOException paramDownloadTask)
      {
        QLog.e(".troop.VideoCombineHelper", 1, paramDownloadTask, new Object[0]);
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask);
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.b = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask);
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task = new VideoCombineHelper.CombineTask(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.c, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.b, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.d, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.c);
        paramDownloadTask = (AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web");
        if (!VideoEnvironment.checkAndLoadAVCodec()) {}
      }
      for (;;)
      {
        QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        return;
        if (this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.a) {
          this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task);
        } else {
          this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task);
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.d = ("donwload failed!code = " + paramDownloadTask.a + "errmsg = " + paramDownloadTask.b);
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.DownLoadTask.1
 * JD-Core Version:    0.7.0.1
 */