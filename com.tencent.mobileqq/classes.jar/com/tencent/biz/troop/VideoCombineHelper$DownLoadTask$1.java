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
    if (paramDownloadTask.c == 0)
    {
      paramDownloadTask = this.d.b.values().iterator();
      while (paramDownloadTask.hasNext()) {
        if (!((File)paramDownloadTask.next()).exists())
        {
          this.d.f.a(this.d);
          return;
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramDownloadTask = this.a.h.iterator();
        i = 1;
        if (paramDownloadTask.hasNext())
        {
          localObject1 = (String)paramDownloadTask.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.d.d());
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append("v_");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(".mp4");
          localObject2 = new File(((StringBuilder)localObject2).toString());
          this.b.add(((File)localObject2).getAbsolutePath());
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
        this.d.f.a(this.d);
        this.a.h = this.b;
        this.d.f.b(this.d);
        paramDownloadTask = this.d;
        paramDownloadTask.h = new VideoCombineHelper.CombineTask(paramDownloadTask.c, this.d.f, this.d.g, this.a.h, this.a.i, this.a.f);
        paramDownloadTask = (AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web");
        if (VideoEnvironment.checkAndLoadAVCodec()) {
          this.d.b();
        } else if (this.a.a) {
          this.d.f.b(this.d.h);
        } else {
          this.d.f.a(this.d.h);
        }
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("downLoadTime = ");
        paramDownloadTask.append(System.currentTimeMillis() - this.c);
        QLog.d(".troop.trace_video_combine", 2, paramDownloadTask.toString());
        return;
      }
      Object localObject1 = this.d;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("donwload failed!code = ");
      ((StringBuilder)localObject2).append(paramDownloadTask.c);
      ((StringBuilder)localObject2).append("errmsg = ");
      ((StringBuilder)localObject2).append(paramDownloadTask.d);
      ((VideoCombineHelper.DownLoadTask)localObject1).i = ((StringBuilder)localObject2).toString();
      this.d.f.a(this.d);
      return;
      label514:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.DownLoadTask.1
 * JD-Core Version:    0.7.0.1
 */