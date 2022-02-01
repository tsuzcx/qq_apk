package com.tencent.biz.troop;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import mqq.app.AppRuntime;

class VideoCombineHelper$DownLoadTask
  extends VideoCombineHelper.Task
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, File> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public VideoCombineHelper$DownLoadTask(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.TaskListener paramTaskListener, String paramString)
  {
    super(paramVideoCombineHelper, paramTaskListener, paramString);
    paramVideoCombineHelper = a();
    if (paramVideoCombineHelper != null)
    {
      int i = 0;
      while (i < paramVideoCombineHelper.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramTaskListener = (String)paramVideoCombineHelper.jdField_a_of_type_JavaUtilArrayList.get(i);
        paramString = a(paramTaskListener, ".mp4");
        paramVideoCombineHelper.jdField_b_of_type_JavaUtilArrayList.add(paramString);
        if ((!new File(paramString).exists()) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramTaskListener)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramTaskListener);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramTaskListener, new File(paramString));
        }
        i += 1;
      }
      if (!TextUtils.isEmpty(paramVideoCombineHelper.jdField_b_of_type_JavaLangString))
      {
        paramTaskListener = new File(a(paramVideoCombineHelper.jdField_b_of_type_JavaLangString, ".m4a"));
        if (!paramTaskListener.exists())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramVideoCombineHelper.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramVideoCombineHelper.jdField_b_of_type_JavaLangString, new File(paramTaskListener.getAbsolutePath()));
        }
        paramVideoCombineHelper.d = paramTaskListener.getAbsolutePath();
      }
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    paramString1 = UUID.nameUUIDFromBytes(paramString1.getBytes());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("v_");
    localStringBuilder.append(paramString1.toString());
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    paramString2 = new File(paramString1);
    if (!paramString2.getParentFile().exists()) {
      paramString2.mkdirs();
    }
    return paramString1;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    Object localObject3 = new Bundle();
    Object localObject1 = a();
    if (((VideoCombineHelper.CombineParams)localObject1).jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this);
      return;
    }
    Object localObject2 = new ArrayList();
    Object localObject4;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject4 = new DownloadTask(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilHashMap, this.c);
      ((DownloadTask)localObject4).b = 3;
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a().startDownload((DownloadTask)localObject4, new VideoCombineHelper.DownLoadTask.1(this, (VideoCombineHelper.CombineParams)localObject1, (ArrayList)localObject2, l), (Bundle)localObject3);
    }
    for (;;)
    {
      int i;
      try
      {
        localObject3 = ((VideoCombineHelper.CombineParams)localObject1).jdField_b_of_type_JavaUtilArrayList.iterator();
        i = 1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          Object localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(a());
          ((StringBuilder)localObject5).append(File.separator);
          ((StringBuilder)localObject5).append("v_");
          ((StringBuilder)localObject5).append(i);
          ((StringBuilder)localObject5).append(".mp4");
          localObject5 = new File(((StringBuilder)localObject5).toString());
          ((ArrayList)localObject2).add(((File)localObject5).getAbsolutePath());
          if (((File)localObject5).exists()) {
            break label501;
          }
          if (!((File)localObject5).exists()) {
            ((File)localObject5).createNewFile();
          }
          FileUtils.a(new File((String)localObject4), (File)localObject5);
        }
      }
      catch (IOException localIOException)
      {
        QLog.e(".troop.VideoCombineHelper", 1, localIOException, new Object[0]);
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this);
        ((VideoCombineHelper.CombineParams)localObject1).jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this);
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task = new VideoCombineHelper.CombineTask(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener, this.c, ((VideoCombineHelper.CombineParams)localObject1).jdField_b_of_type_JavaUtilArrayList, ((VideoCombineHelper.CombineParams)localObject1).d, ((VideoCombineHelper.CombineParams)localObject1).c);
        localObject2 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web");
        if (VideoEnvironment.checkAndLoadAVCodec())
        {
          b();
        }
        else if (((VideoCombineHelper.CombineParams)localObject1).jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task);
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task.d = "lib not ready";
          this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("downLoadTime = ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
        QLog.d(".troop.trace_video_combine", 2, ((StringBuilder)localObject1).toString());
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start Download key = ");
        ((StringBuilder)localObject1).append(this.c);
        QLog.d(".troop.VideoCombineHelper", 2, ((StringBuilder)localObject1).toString());
      }
      return;
      label501:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.DownLoadTask
 * JD-Core Version:    0.7.0.1
 */