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
    }
    for (;;)
    {
      int i;
      try
      {
        paramDownloadTask = this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.b.iterator();
        i = 1;
        if (paramDownloadTask.hasNext())
        {
          localObject1 = (String)paramDownloadTask.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.a());
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append("v_");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(".mp4");
          localObject2 = new File(((StringBuilder)localObject2).toString());
          this.jdField_a_of_type_JavaUtilArrayList.add(((File)localObject2).getAbsolutePath());
          if (((File)localObject2).exists()) {
            break label514;
          }
          if (!((File)localObject2).exists()) {
            ((File)localObject2).createNewFile();
          }
          FileUtils.a(new File((String)localObject1), (File)localObject2);
        }
      }
      catch (IOException paramDownloadTask)
      {
        QLog.e(".troop.VideoCombineHelper", 1, paramDownloadTask, new Object[0]);
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask);
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.b = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask);
        paramDownloadTask = this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask;
        paramDownloadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task = new VideoCombineHelper.CombineTask(paramDownloadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.c, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.b, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.d, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.c);
        paramDownloadTask = (AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web");
        if (VideoEnvironment.checkAndLoadAVCodec()) {
          this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.b();
        } else if (this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.a) {
          this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task);
        } else {
          this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task);
        }
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("downLoadTime = ");
        paramDownloadTask.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        QLog.d(".troop.trace_video_combine", 2, paramDownloadTask.toString());
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("donwload failed!code = ");
      ((StringBuilder)localObject2).append(paramDownloadTask.a);
      ((StringBuilder)localObject2).append("errmsg = ");
      ((StringBuilder)localObject2).append(paramDownloadTask.b);
      ((VideoCombineHelper.DownLoadTask)localObject1).d = ((StringBuilder)localObject2).toString();
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$DownLoadTask);
      return;
      label514:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.DownLoadTask.1
 * JD-Core Version:    0.7.0.1
 */