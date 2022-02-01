package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import com.tencent.aelight.camera.ae.AEPath.AISCENE.FILES;
import com.tencent.aelight.camera.ae.data.AEPreDownloadResMetaData;
import com.tencent.biz.common.util.ZipUtils;
import java.io.File;

public class TTAutoAISceneAni
{
  private static final String a = "TTAutoAISceneAni";
  
  public static AEPreDownloadResMetaData a()
  {
    AEPreDownloadResMetaData localAEPreDownloadResMetaData = new AEPreDownloadResMetaData();
    localAEPreDownloadResMetaData.r = "https://sqdd.myapp.com/myapp/qqteam/QIM/zhinenglvjingdonghua/AutoAISceneAni.zip";
    localAEPreDownloadResMetaData.t = "AutoAISceneAni";
    localAEPreDownloadResMetaData.s = "6f6632b8106fe070a560abcec6051f0d";
    localAEPreDownloadResMetaData.m = "AutoAISceneAni";
    localAEPreDownloadResMetaData.a = AEPath.AISCENE.FILES.c;
    localAEPreDownloadResMetaData.b = AEPath.AISCENE.FILES.b;
    return localAEPreDownloadResMetaData;
  }
  
  public static void a(AEPreDownloadResMetaData paramAEPreDownloadResMetaData)
  {
    try
    {
      File localFile = new File(paramAEPreDownloadResMetaData.g());
      if (!localFile.exists()) {
        return;
      }
      ZipUtils.unZipFile(localFile, paramAEPreDownloadResMetaData.f());
      return;
    }
    catch (Exception paramAEPreDownloadResMetaData) {}
  }
  
  public static AEPreDownloadResMetaData b()
  {
    AEPreDownloadResMetaData localAEPreDownloadResMetaData = new AEPreDownloadResMetaData();
    localAEPreDownloadResMetaData.r = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/aiScreenAndroid/AISceneLoading.zip";
    localAEPreDownloadResMetaData.s = "da407ead2fb260d6b2570450f2e1bebd";
    localAEPreDownloadResMetaData.t = "AISceneLoading";
    localAEPreDownloadResMetaData.m = "AISceneLoading";
    localAEPreDownloadResMetaData.a = AEPath.AISCENE.FILES.c;
    localAEPreDownloadResMetaData.b = AEPath.AISCENE.FILES.b;
    return localAEPreDownloadResMetaData;
  }
  
  public static AEPreDownloadResMetaData c()
  {
    AEPreDownloadResMetaData localAEPreDownloadResMetaData = new AEPreDownloadResMetaData();
    localAEPreDownloadResMetaData.r = "https://qd.myapp.com/myapp/qqteam/shenqidegongneng/AISceneGuide19082601Android.zip";
    localAEPreDownloadResMetaData.s = "dcb9d44eb8872db03a17fe57ce231a76";
    localAEPreDownloadResMetaData.t = "AISceneGuide";
    localAEPreDownloadResMetaData.m = "AISceneGuide";
    localAEPreDownloadResMetaData.a = AEPath.AISCENE.FILES.c;
    localAEPreDownloadResMetaData.b = AEPath.AISCENE.FILES.b;
    return localAEPreDownloadResMetaData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.TTAutoAISceneAni
 * JD-Core Version:    0.7.0.1
 */