package com.tencent.biz.troop;

import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandUnit;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class VideoCombineHelper
{
  protected static final String a;
  long jdField_a_of_type_Long = 0L;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  FFmpeg jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg;
  Object jdField_a_of_type_JavaLangObject = new Object();
  HashMap<String, VideoCombineHelper.CombineParams> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Tencent/QQ_business/videocombine");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public VideoCombineHelper(QBaseActivity paramQBaseActivity)
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    this.jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg.setFFMpegCanExe();
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
  }
  
  public DownloaderInterface a()
  {
    return new DownloaderFactory(null).a(1);
  }
  
  public String a(VideoCombineHelper.CombineParams paramCombineParams, VideoCombineHelper.Callback paramCallback)
  {
    ??? = UUID.nameUUIDFromBytes(paramCombineParams.c.getBytes());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("combineVideo_");
    ((StringBuilder)localObject1).append(((UUID)???).toString());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("prepareVideo_");
    ((StringBuilder)localObject3).append(((UUID)???).toString());
    localObject3 = ((StringBuilder)localObject3).toString();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject3))
      {
        ((VideoCombineHelper.CombineParams)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3)).b = true;
        Looper.prepare();
        new Handler().postDelayed(new VideoCombineHelper.1(this, paramCombineParams, paramCallback), 300L);
        return localObject1;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, paramCombineParams);
      ThreadManager.post(new VideoCombineHelper.2(this, paramCallback, System.currentTimeMillis(), (String)localObject1), 8, null, false);
      return localObject1;
    }
  }
  
  public void a(VideoCombineHelper.CombineParams paramCombineParams, VideoCombineHelper.Callback paramCallback)
  {
    ??? = UUID.nameUUIDFromBytes(paramCombineParams.c.getBytes());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("prepareVideo_");
    ((StringBuilder)localObject2).append(((UUID)???).toString());
    localObject2 = ((StringBuilder)localObject2).toString();
    paramCombineParams.a = true;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, paramCombineParams);
      ThreadManager.post(new VideoCombineHelper.3(this, paramCallback, System.currentTimeMillis(), (String)localObject2), 8, null, false);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, VideoCombineHelper.Callback paramCallback)
  {
    Object localObject1 = new File(paramString1).getParentFile();
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    ArrayList localArrayList1 = new ArrayList();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject2 = new FFmpegCommandUnit();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((File)localObject1).getAbsolutePath());
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append("vn.m4a");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new ArrayList();
    ((ArrayList)localObject4).add("-y");
    ((ArrayList)localObject4).add("-i");
    ((ArrayList)localObject4).add(paramString1);
    ((ArrayList)localObject4).add("-strict");
    ((ArrayList)localObject4).add("-2");
    ((ArrayList)localObject4).add("-acodec");
    ((ArrayList)localObject4).add("aac");
    ((ArrayList)localObject4).add("-vn");
    ((ArrayList)localObject4).add(localObject3);
    ((FFmpegCommandUnit)localObject2).cmd = ((String[])((ArrayList)localObject4).toArray(new String[0]));
    ((FFmpegCommandUnit)localObject2).callback = new VideoCombineHelper.5(this, paramCallback, paramString1);
    localArrayList1.add(localObject2);
    ((ArrayList)localObject4).clear();
    localObject4 = new FFmpegCommandUnit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("an.ts");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject5 = new ArrayList();
    ((ArrayList)localObject5).add("-y");
    ((ArrayList)localObject5).add("-i");
    ((ArrayList)localObject5).add(paramString1);
    ((ArrayList)localObject5).add("-vcodec");
    ((ArrayList)localObject5).add("copy");
    ((ArrayList)localObject5).add("-an");
    ((ArrayList)localObject5).add(localObject2);
    ((FFmpegCommandUnit)localObject4).cmd = ((String[])((ArrayList)localObject5).toArray(new String[0]));
    ((FFmpegCommandUnit)localObject4).callback = new VideoCombineHelper.6(this, paramCallback, paramString1);
    localArrayList1.add(localObject4);
    localObject5 = new FFmpegCommandUnit();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(((File)localObject1).getAbsolutePath());
    ((StringBuilder)localObject4).append(File.separator);
    ((StringBuilder)localObject4).append("mixed.m4a");
    localObject4 = ((StringBuilder)localObject4).toString();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add("-y");
    localArrayList2.add("-i");
    localArrayList2.add(localObject3);
    localArrayList2.add("-i");
    localArrayList2.add(paramString2);
    localArrayList2.add("-filter_complex");
    localArrayList2.add("amix=inputs=2:duration=first:dropout_transition=2");
    localArrayList2.add(localObject4);
    ((FFmpegCommandUnit)localObject5).cmd = ((String[])localArrayList2.toArray(new String[0]));
    ((FFmpegCommandUnit)localObject5).callback = new VideoCombineHelper.7(this, paramCallback, paramString1);
    localArrayList1.add(localObject5);
    paramString2 = new FFmpegCommandUnit();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((File)localObject1).getAbsolutePath());
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append("combine.mp4");
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).add("-y");
    ((ArrayList)localObject3).add("-i");
    ((ArrayList)localObject3).add(localObject2);
    ((ArrayList)localObject3).add("-i");
    ((ArrayList)localObject3).add(localObject4);
    ((ArrayList)localObject3).add("-strict");
    ((ArrayList)localObject3).add("2");
    ((ArrayList)localObject3).add("-vcodec");
    ((ArrayList)localObject3).add("copy");
    ((ArrayList)localObject3).add("-acodec");
    ((ArrayList)localObject3).add("aac");
    ((ArrayList)localObject3).add(localObject1);
    paramString2.cmd = ((String[])((ArrayList)localObject3).toArray(new String[0]));
    paramString2.callback = new VideoCombineHelper.8(this, paramCallback, (String)localObject1, paramString1);
    localArrayList1.add(paramString2);
    ((ArrayList)localObject3).clear();
    if (this.jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg.isFFmpegCommandRunning()) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg.insertFFmpegQueue(localArrayList1);
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (FFmpegCommandAlreadyRunningException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg.cmdFFmpegQueue(localArrayList1);
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper
 * JD-Core Version:    0.7.0.1
 */