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
    localAEPreDownloadResMetaData.n = "https://sqdd.myapp.com/myapp/qqteam/QIM/zhinenglvjingdonghua/AutoAISceneAni.zip";
    localAEPreDownloadResMetaData.p = "AutoAISceneAni";
    localAEPreDownloadResMetaData.o = "6f6632b8106fe070a560abcec6051f0d";
    localAEPreDownloadResMetaData.k = "AutoAISceneAni";
    localAEPreDownloadResMetaData.a = AEPath.AISCENE.FILES.c;
    localAEPreDownloadResMetaData.b = AEPath.AISCENE.FILES.b;
    return localAEPreDownloadResMetaData;
  }
  
  public static void a(AEPreDownloadResMetaData paramAEPreDownloadResMetaData)
  {
    try
    {
      File localFile = new File(paramAEPreDownloadResMetaData.c());
      if (!localFile.exists()) {
        return;
      }
      ZipUtils.unZipFile(localFile, paramAEPreDownloadResMetaData.b());
      return;
    }
    catch (Exception paramAEPreDownloadResMetaData) {}
  }
  
  public static AEPreDownloadResMetaData b()
  {
    AEPreDownloadResMetaData localAEPreDownloadResMetaData = new AEPreDownloadResMetaData();
    localAEPreDownloadResMetaData.n = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/aiScreenAndroid/AISceneLoading.zip";
    localAEPreDownloadResMetaData.o = "da407ead2fb260d6b2570450f2e1bebd";
    localAEPreDownloadResMetaData.p = "AISceneLoading";
    localAEPreDownloadResMetaData.k = "AISceneLoading";
    localAEPreDownloadResMetaData.a = AEPath.AISCENE.FILES.c;
    localAEPreDownloadResMetaData.b = AEPath.AISCENE.FILES.b;
    return localAEPreDownloadResMetaData;
  }
  
  public static AEPreDownloadResMetaData c()
  {
    AEPreDownloadResMetaData localAEPreDownloadResMetaData = new AEPreDownloadResMetaData();
    localAEPreDownloadResMetaData.n = "https://qd.myapp.com/myapp/qqteam/shenqidegongneng/AISceneGuide19082601Android.zip";
    localAEPreDownloadResMetaData.o = "dcb9d44eb8872db03a17fe57ce231a76";
    localAEPreDownloadResMetaData.p = "AISceneGuide";
    localAEPreDownloadResMetaData.k = "AISceneGuide";
    localAEPreDownloadResMetaData.a = AEPath.AISCENE.FILES.c;
    localAEPreDownloadResMetaData.b = AEPath.AISCENE.FILES.b;
    return localAEPreDownloadResMetaData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.TTAutoAISceneAni
 * JD-Core Version:    0.7.0.1
 */