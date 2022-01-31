package com.tencent.biz.troop;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandUnit;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import ova;
import ovb;
import ovd;
import ovf;
import ovg;
import ovh;
import ovi;

public class VideoCombineHelper
{
  protected static final String a;
  public long a;
  public FFmpeg a;
  public TroopMemberApiClient a;
  BaseActivity a;
  public Object a;
  public HashMap a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aI + "/Tencent/QQ_business/videocombine";
  }
  
  public VideoCombineHelper(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg = FFmpeg.a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
  }
  
  public DownloaderInterface a()
  {
    return new DownloaderFactory(null).a(1);
  }
  
  public String a(VideoCombineHelper.CombineParams paramCombineParams, VideoCombineHelper.Callback paramCallback)
  {
    ??? = UUID.nameUUIDFromBytes(paramCombineParams.c.getBytes());
    String str1 = "combineVideo_" + ((UUID)???).toString();
    String str2 = "prepareVideo_" + ((UUID)???).toString();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str2))
      {
        ((VideoCombineHelper.CombineParams)this.jdField_a_of_type_JavaUtilHashMap.get(str2)).b = true;
        Looper.prepare();
        new Handler().postDelayed(new ova(this, paramCombineParams, paramCallback), 300L);
        return str1;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramCombineParams);
      ThreadManager.post(new ovb(this, paramCallback, System.currentTimeMillis(), str1), 8, null, false);
      return str1;
    }
  }
  
  public void a(VideoCombineHelper.CombineParams paramCombineParams, VideoCombineHelper.Callback paramCallback)
  {
    ??? = UUID.nameUUIDFromBytes(paramCombineParams.c.getBytes());
    String str = "prepareVideo_" + ((UUID)???).toString();
    paramCombineParams.a = true;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(str, paramCombineParams);
      ThreadManager.post(new ovd(this, paramCallback, System.currentTimeMillis(), str), 8, null, false);
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
    Object localObject3 = ((File)localObject1).getAbsolutePath() + File.separator + "vn.m4a";
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
    ((FFmpegCommandUnit)localObject2).jdField_a_of_type_ArrayOfJavaLangString = ((String[])((ArrayList)localObject4).toArray(new String[0]));
    ((FFmpegCommandUnit)localObject2).jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new ovf(this, paramCallback, paramString1);
    localArrayList1.add(localObject2);
    ((ArrayList)localObject4).clear();
    localObject4 = new FFmpegCommandUnit();
    localObject2 = ((File)localObject1).getAbsolutePath() + File.separator + "an.ts";
    Object localObject5 = new ArrayList();
    ((ArrayList)localObject5).add("-y");
    ((ArrayList)localObject5).add("-i");
    ((ArrayList)localObject5).add(paramString1);
    ((ArrayList)localObject5).add("-vcodec");
    ((ArrayList)localObject5).add("copy");
    ((ArrayList)localObject5).add("-an");
    ((ArrayList)localObject5).add(localObject2);
    ((FFmpegCommandUnit)localObject4).jdField_a_of_type_ArrayOfJavaLangString = ((String[])((ArrayList)localObject5).toArray(new String[0]));
    ((FFmpegCommandUnit)localObject4).jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new ovg(this, paramCallback, paramString1);
    localArrayList1.add(localObject4);
    localObject5 = new FFmpegCommandUnit();
    localObject4 = ((File)localObject1).getAbsolutePath() + File.separator + "mixed.m4a";
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add("-y");
    localArrayList2.add("-i");
    localArrayList2.add(localObject3);
    localArrayList2.add("-i");
    localArrayList2.add(paramString2);
    localArrayList2.add("-filter_complex");
    localArrayList2.add("amix=inputs=2:duration=first:dropout_transition=2");
    localArrayList2.add(localObject4);
    ((FFmpegCommandUnit)localObject5).jdField_a_of_type_ArrayOfJavaLangString = ((String[])localArrayList2.toArray(new String[0]));
    ((FFmpegCommandUnit)localObject5).jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new ovh(this, paramCallback, paramString1);
    localArrayList1.add(localObject5);
    paramString2 = new FFmpegCommandUnit();
    localObject1 = ((File)localObject1).getAbsolutePath() + File.separator + "combine.mp4";
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
    paramString2.jdField_a_of_type_ArrayOfJavaLangString = ((String[])((ArrayList)localObject3).toArray(new String[0]));
    paramString2.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new ovi(this, paramCallback, (String)localObject1, paramString1);
    localArrayList1.add(paramString2);
    ((ArrayList)localObject3).clear();
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a()) {
      try
      {
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.b(localArrayList1);
        return;
      }
      catch (FFmpegCommandAlreadyRunningException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a(localArrayList1);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper
 * JD-Core Version:    0.7.0.1
 */