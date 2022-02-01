package com.tencent.av.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.AVNetEngine;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig.Sample;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig.TestInfo;
import com.tencent.av.VideoController;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.av.config.api.IVideoEffectConfigParser;
import com.tencent.av.mediacodec.config.CodecConfigUtil;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.upload.FileUpload;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.videoeffect.VideoEffectTest;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DeviceCapabilityExamination
{
  static DeviceCapabilityExamination.DownloadInfo jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination$DownloadInfo;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  
  public DeviceCapabilityExamination(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    paramVideoAppInterface = new DeviceCapabilityExamination.MyTestRunnable(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(paramVideoAppInterface, 5000L);
  }
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("DeviceCapabilityExamination", 4);
  }
  
  public static DeviceCapabilityExamination.ReportData a(int paramInt1, int paramInt2, long paramLong1, String paramString1, String paramString2, int paramInt3, long paramLong2)
  {
    DeviceCapabilityExamination.ReportData localReportData = new DeviceCapabilityExamination.ReportData();
    localReportData.jdField_a_of_type_Long = Long.parseLong(VideoController.a().jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    localReportData.jdField_b_of_type_Int = paramInt1;
    localReportData.g = paramString2;
    localReportData.h = paramString1;
    localReportData.jdField_c_of_type_Int = paramInt2;
    localReportData.d = ((int)paramLong2);
    localReportData.e = ((int)paramLong1);
    return localReportData;
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getParent());
    localStringBuilder.append("/qav/sample/");
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt, AVTestforEncDecConfig.Sample paramSample)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enc_[w");
    ((StringBuilder)localObject).append(paramSample.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("h");
    ((StringBuilder)localObject).append(paramSample.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append("fYUV420]_");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(paramSample.jdField_a_of_type_JavaLangString));
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramSample.jdField_c_of_type_Int);
    localStringBuilder.append("_");
    localStringBuilder.append(paramSample.d);
    localStringBuilder.append("_");
    localStringBuilder.append(paramSample.jdField_a_of_type_Int);
    localStringBuilder.append("x");
    localStringBuilder.append(paramSample.jdField_b_of_type_Int);
    paramSample = localStringBuilder.toString();
    if ((paramInt != 1) && (paramInt != 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramSample);
      ((StringBuilder)localObject).append(".265");
      return ((StringBuilder)localObject).toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramSample);
    ((StringBuilder)localObject).append(".264");
    return ((StringBuilder)localObject).toString();
  }
  
  public static String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DT_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(paramString));
    localStringBuilder.append("sample");
    return localStringBuilder.toString();
  }
  
  public static ArrayList<Integer[]> a(TreeMap<Integer, Integer[]> paramTreeMap, String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = paramTreeMap.keySet().iterator();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
    {
      Integer[] arrayOfInteger = (Integer[])paramTreeMap.get(Integer.valueOf(((Integer)localIterator.next()).intValue()));
      if ((arrayOfInteger[2].intValue() == paramInt1) && (arrayOfInteger[3].intValue() == paramInt2))
      {
        localArrayList.add(arrayOfInteger);
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getBitRateTable, md5[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("], w[");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append("], h[");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append("], bitrate[");
          localStringBuilder.append(arrayOfInteger[1]);
          localStringBuilder.append("], fps[");
          localStringBuilder.append(arrayOfInteger[4]);
          localStringBuilder.append("]");
          QLog.w("DeviceCapabilityExamination", 1, localStringBuilder.toString());
        }
      }
    }
    if (localArrayList.size() == 0)
    {
      paramTreeMap = new StringBuilder();
      paramTreeMap.append("getBitRateTable, 没找到对应的码表, md5[");
      paramTreeMap.append(paramString);
      paramTreeMap.append("], w[");
      paramTreeMap.append(paramInt1);
      paramTreeMap.append("], h[");
      paramTreeMap.append(paramInt2);
      paramTreeMap.append("]");
      QLog.w("DeviceCapabilityExamination", 1, paramTreeMap.toString());
      localArrayList.add(new Integer[] { Integer.valueOf(32), Integer.valueOf(2000), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    }
    return localArrayList;
  }
  
  public static TreeMap<Integer, Integer[]> a()
  {
    TreeMap localTreeMap = new TreeMap();
    Integer localInteger1 = Integer.valueOf(1);
    Integer localInteger5 = Integer.valueOf(640);
    Integer localInteger6 = Integer.valueOf(480);
    Integer localInteger2 = Integer.valueOf(5);
    Integer localInteger3 = Integer.valueOf(15);
    localTreeMap.put(localInteger1, new Integer[] { localInteger1, Integer.valueOf(425), localInteger5, localInteger6, Integer.valueOf(12), localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(Integer.valueOf(2), new Integer[] { Integer.valueOf(2), Integer.valueOf(450), localInteger5, localInteger6, Integer.valueOf(12), localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(Integer.valueOf(3), new Integer[] { Integer.valueOf(3), Integer.valueOf(500), localInteger5, localInteger6, Integer.valueOf(12), localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(Integer.valueOf(4), new Integer[] { Integer.valueOf(4), Integer.valueOf(550), localInteger5, localInteger6, Integer.valueOf(12), localInteger1, localInteger3, localInteger2 });
    Integer localInteger4 = Integer.valueOf(20);
    localTreeMap.put(localInteger2, new Integer[] { localInteger2, Integer.valueOf(600), localInteger5, localInteger6, localInteger3, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(6), new Integer[] { Integer.valueOf(6), Integer.valueOf(650), localInteger5, localInteger6, localInteger3, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(7), new Integer[] { Integer.valueOf(7), Integer.valueOf(700), localInteger5, localInteger6, localInteger3, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(8), new Integer[] { Integer.valueOf(8), Integer.valueOf(750), localInteger5, localInteger6, localInteger3, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(9), new Integer[] { Integer.valueOf(9), Integer.valueOf(800), localInteger5, localInteger6, localInteger3, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(10), new Integer[] { Integer.valueOf(10), Integer.valueOf(850), localInteger5, localInteger6, localInteger3, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(11), new Integer[] { Integer.valueOf(11), Integer.valueOf(900), localInteger5, localInteger6, localInteger3, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(12), new Integer[] { Integer.valueOf(12), Integer.valueOf(1000), localInteger5, localInteger6, localInteger3, localInteger1, localInteger4, localInteger2 });
    localInteger5 = Integer.valueOf(1280);
    localTreeMap.put(Integer.valueOf(13), new Integer[] { Integer.valueOf(13), Integer.valueOf(800), localInteger5, Integer.valueOf(720), localInteger3, localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(Integer.valueOf(14), new Integer[] { Integer.valueOf(14), Integer.valueOf(850), localInteger5, Integer.valueOf(720), localInteger3, localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(localInteger3, new Integer[] { localInteger3, Integer.valueOf(900), localInteger5, Integer.valueOf(720), localInteger3, localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(Integer.valueOf(16), new Integer[] { Integer.valueOf(16), Integer.valueOf(1000), localInteger5, Integer.valueOf(720), localInteger3, localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(Integer.valueOf(17), new Integer[] { Integer.valueOf(17), Integer.valueOf(1100), localInteger5, Integer.valueOf(720), localInteger3, localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(Integer.valueOf(18), new Integer[] { Integer.valueOf(18), Integer.valueOf(1200), localInteger5, Integer.valueOf(720), localInteger3, localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(Integer.valueOf(19), new Integer[] { Integer.valueOf(19), Integer.valueOf(1300), localInteger5, Integer.valueOf(720), localInteger3, localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(localInteger4, new Integer[] { localInteger4, Integer.valueOf(1400), localInteger5, Integer.valueOf(720), localInteger4, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(21), new Integer[] { Integer.valueOf(21), Integer.valueOf(1500), localInteger5, Integer.valueOf(720), localInteger4, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(22), new Integer[] { Integer.valueOf(22), Integer.valueOf(1600), localInteger5, Integer.valueOf(720), localInteger4, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(23), new Integer[] { Integer.valueOf(23), Integer.valueOf(1700), localInteger5, Integer.valueOf(720), localInteger4, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(24), new Integer[] { Integer.valueOf(24), Integer.valueOf(1800), localInteger5, Integer.valueOf(720), localInteger4, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(25), new Integer[] { Integer.valueOf(25), Integer.valueOf(2000), Integer.valueOf(1920), Integer.valueOf(1080), localInteger3, localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(Integer.valueOf(26), new Integer[] { Integer.valueOf(26), Integer.valueOf(2100), Integer.valueOf(1920), Integer.valueOf(1080), localInteger3, localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(Integer.valueOf(27), new Integer[] { Integer.valueOf(27), Integer.valueOf(2200), Integer.valueOf(1920), Integer.valueOf(1080), localInteger3, localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(Integer.valueOf(28), new Integer[] { Integer.valueOf(28), Integer.valueOf(2300), Integer.valueOf(1920), Integer.valueOf(1080), localInteger3, localInteger1, localInteger3, localInteger2 });
    localTreeMap.put(Integer.valueOf(29), new Integer[] { Integer.valueOf(29), Integer.valueOf(2400), Integer.valueOf(1920), Integer.valueOf(1080), localInteger4, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(30), new Integer[] { Integer.valueOf(30), Integer.valueOf(2600), Integer.valueOf(1920), Integer.valueOf(1080), localInteger4, localInteger1, localInteger4, localInteger2 });
    localTreeMap.put(Integer.valueOf(31), new Integer[] { Integer.valueOf(31), Integer.valueOf(2800), Integer.valueOf(1920), Integer.valueOf(1080), localInteger4, localInteger1, localInteger4, localInteger2 });
    return localTreeMap;
  }
  
  private void a()
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    b();
  }
  
  private static void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setTestDone, codec[");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("], doneFlagTime[");
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append("]");
    QLog.w("DeviceCapabilityExamination", 1, ((StringBuilder)localObject1).toString());
    localObject1 = a().edit();
    ((SharedPreferences.Editor)localObject1).putLong(a(paramInt, "doneTime"), l);
    ((SharedPreferences.Editor)localObject1).commit();
    int i = QConfigManager.a().a(431, "");
    localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof VideoAppInterface))
    {
      Object localObject2 = (VideoAppInterface)localObject1;
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("uin", ((VideoAppInterface)localObject2).getCurrentAccountUin());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("");
      ((HashMap)localObject1).put("ver", ((StringBuilder)localObject2).toString());
      ((HashMap)localObject1).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      localObject2 = AVTestforEncDecConfig.a(paramInt);
      if (localObject2 != null)
      {
        i = CodecConfigUtil.a((AVTestforEncDecConfig.TestInfo)localObject2);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("test");
        ((StringBuilder)localObject3).append(paramInt);
        ((HashMap)localObject1).put(((StringBuilder)localObject3).toString(), "1");
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("test");
        ((StringBuilder)localObject3).append(paramInt);
        ((StringBuilder)localObject3).append("_ver");
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((AVTestforEncDecConfig.TestInfo)localObject2).e);
        localStringBuilder.append("");
        ((HashMap)localObject1).put(localObject3, localStringBuilder.toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("test");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("_flag");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("");
        ((HashMap)localObject1).put(localObject2, ((StringBuilder)localObject3).toString());
      }
      UserAction.onUserAction("qav_codec_done", true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
  
  static void a(int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putInt(a(paramInt1, "result"), paramInt2);
    localEditor.putLong(a(paramInt1, "finishTime"), System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static void a(int paramInt, VideoAppInterface paramVideoAppInterface)
  {
    FileUpload.a(paramVideoAppInterface);
    FileUpload.a("DeviceCapabilityExamination", paramVideoAppInterface);
    ThreadManager.excute(new DeviceCapabilityExamination.1(paramInt, paramVideoAppInterface), 16, null, true);
  }
  
  static void a(int paramInt, String paramString)
  {
    if (AudioHelper.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delSampleFile, 测试版本不删除样本, codec[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], md5[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w("DeviceCapabilityExamination", 1, localStringBuilder.toString());
      return;
    }
    b(paramInt, paramString);
  }
  
  public static void a(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt, AVTestforEncDecConfig.Sample paramSample, DeviceCapability.CodecPlayerCallback paramCodecPlayerCallback)
  {
    long l = System.currentTimeMillis();
    VideoController localVideoController = paramVideoAppInterface.a();
    DeviceCapability.CodecPlayerCallback.CodecTestInfo localCodecTestInfo = new DeviceCapability.CodecPlayerCallback.CodecTestInfo();
    localCodecTestInfo.jdField_a_of_type_Int = paramInt;
    localCodecTestInfo.jdField_a_of_type_JavaLangString = paramSample.jdField_a_of_type_JavaLangString;
    localCodecTestInfo.jdField_b_of_type_JavaLangString = a(paramSample.jdField_a_of_type_JavaLangString);
    localCodecTestInfo.d = a(paramInt, paramSample);
    localCodecTestInfo.jdField_c_of_type_Int = paramSample.jdField_c_of_type_Int;
    localCodecTestInfo.jdField_b_of_type_Int = paramSample.d;
    localCodecTestInfo.jdField_c_of_type_JavaLangString = paramSample.jdField_c_of_type_JavaLangString;
    DeviceCapability.a(paramLong, localVideoController, localCodecTestInfo, new DeviceCapabilityExamination.2(l, paramInt, localCodecTestInfo, paramSample, paramVideoAppInterface, paramLong, paramCodecPlayerCallback));
  }
  
  public static void a(AVTestforEncDecConfig.TestInfo paramTestInfo, String paramString1, String paramString2)
  {
    if (!NetworkUtil.isWifiConnected(null))
    {
      QLog.w("DeviceCapabilityExamination", 1, "startDownloadTestResource, no wifi");
      return;
    }
    try
    {
      if (jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination$DownloadInfo == null) {
        jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination$DownloadInfo = new DeviceCapabilityExamination.DownloadInfo();
      }
      if (jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination$DownloadInfo.a(paramString1, paramString2))
      {
        paramTestInfo = new StringBuilder();
        paramTestInfo.append("startDownloadTestResource, 下载中 , md5[");
        paramTestInfo.append(paramString1);
        paramTestInfo.append("]");
        QLog.w("DeviceCapabilityExamination", 1, paramTestInfo.toString());
        return;
      }
      if (AudioHelper.b())
      {
        paramTestInfo = new StringBuilder();
        paramTestInfo.append("startDownloadTestResource, md5[");
        paramTestInfo.append(paramString1);
        paramTestInfo.append("]");
        QLog.w("DeviceCapabilityExamination", 1, paramTestInfo.toString());
      }
      paramTestInfo = new HttpNetReq();
      paramTestInfo.mCallback = new DeviceCapabilityExamination.MyHttpListener();
      paramTestInfo.mReqUrl = paramString2;
      paramTestInfo.mHttpMethod = 0;
      paramString2 = new StringBuilder();
      paramString2.append(c(paramString1));
      paramString2.append("sample.zip");
      paramTestInfo.mOutPath = paramString2.toString();
      paramTestInfo.mMsgId = paramString1;
      paramTestInfo.setUserData(paramString1);
      AVNetEngine.a().sendReq(paramTestInfo);
      return;
    }
    finally {}
  }
  
  public static void a(DeviceCapabilityExamination.ReportData paramReportData, int paramInt1, int paramInt2)
  {
    ClientLogReport.instance().sendLog(paramReportData.jdField_a_of_type_Long, "5274", paramReportData.a().getBytes(), false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131703329));
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], resultCode:");
    localStringBuilder.append(paramInt2);
    AudioHelper.c(localStringBuilder.toString());
    a(paramInt1, paramInt2);
    a(paramInt1, paramReportData.h);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("DeviceCapabilityExamination", 1, "testHWCodecIfNeed, begin");
    }
    if (a(1))
    {
      b(1, paramVideoAppInterface);
      return;
    }
    if (a(4))
    {
      b(4, paramVideoAppInterface);
      return;
    }
    if (a(2))
    {
      a(2, paramVideoAppInterface);
      return;
    }
    if (a(8))
    {
      a(8, paramVideoAppInterface);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("DeviceCapabilityExamination", 1, "testHWCodecIfNeed, no");
    }
  }
  
  static boolean a(int paramInt)
  {
    Object localObject = AVTestforEncDecConfig.a(paramInt);
    if (localObject != null)
    {
      if (System.currentTimeMillis() > ((AVTestforEncDecConfig.TestInfo)localObject).jdField_a_of_type_Long) {
        return false;
      }
      b(((AVTestforEncDecConfig.TestInfo)localObject).jdField_b_of_type_Int, ((AVTestforEncDecConfig.TestInfo)localObject).e);
      SharedPreferences localSharedPreferences = a();
      long l1 = localSharedPreferences.getLong(a(paramInt, "doneTime"), 0L);
      if (l1 == 0L)
      {
        if (a((AVTestforEncDecConfig.TestInfo)localObject, true))
        {
          if (((paramInt == 8) || (paramInt == 2)) && (TextUtils.isEmpty(AVSoUtils.f())))
          {
            QLog.w("DeviceCapabilityExamination", 1, "runTest, cannot find libTcHevcDec2.so for hardware encode detect!!");
            return false;
          }
          a(((AVTestforEncDecConfig.TestInfo)localObject).jdField_b_of_type_Int);
          return true;
        }
      }
      else if (AudioHelper.b())
      {
        int i = localSharedPreferences.getInt(a(paramInt, "result"), -99);
        long l2 = localSharedPreferences.getLong(a(paramInt, "finishTime"), 0L);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("runTest, done, codec[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], result[");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("], doneFlagTime[");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append("], finishFlagTime[");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append("]");
        QLog.w("DeviceCapabilityExamination", 1, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  public static boolean a(AVTestforEncDecConfig.TestInfo paramTestInfo, boolean paramBoolean)
  {
    if (paramTestInfo == null) {
      return false;
    }
    if (CodecConfigUtil.a(paramTestInfo) == 0) {
      return false;
    }
    Object localObject = b(paramTestInfo);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkCondition, 无样本, codec[");
      ((StringBuilder)localObject).append(paramTestInfo.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append("]");
      QLog.w("DeviceCapabilityExamination", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    String str = a(((AVTestforEncDecConfig.Sample)localObject).jdField_a_of_type_JavaLangString);
    if (!new File(str).exists())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkCondition, 样本未下载, codec[");
      localStringBuilder.append(paramTestInfo.jdField_b_of_type_Int);
      localStringBuilder.append("], path[");
      localStringBuilder.append(str);
      localStringBuilder.append("], downloadRes[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w("DeviceCapabilityExamination", 1, localStringBuilder.toString());
      if (paramBoolean) {
        a(paramTestInfo, ((AVTestforEncDecConfig.Sample)localObject).jdField_a_of_type_JavaLangString, ((AVTestforEncDecConfig.Sample)localObject).jdField_b_of_type_JavaLangString);
      }
      return false;
    }
    return true;
  }
  
  static Integer[] a(TreeMap<Integer, Integer[]> paramTreeMap, String paramString, int paramInt1, int paramInt2)
  {
    paramTreeMap = a(paramTreeMap, paramString, paramInt1, paramInt2);
    return (Integer[])paramTreeMap.get((int)(System.currentTimeMillis() % paramTreeMap.size()));
  }
  
  private static AVTestforEncDecConfig.Sample b(AVTestforEncDecConfig.TestInfo paramTestInfo)
  {
    Object localObject3 = paramTestInfo.jdField_a_of_type_JavaUtilHashMap;
    Object localObject1 = null;
    Object localObject2 = null;
    if (localObject3 != null)
    {
      if (paramTestInfo.jdField_a_of_type_JavaUtilHashMap.size() == 0) {
        return null;
      }
      localObject3 = a();
      localObject1 = ((SharedPreferences)localObject3).getString(a(paramTestInfo.jdField_b_of_type_Int, "md5"), null);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = (AVTestforEncDecConfig.Sample)paramTestInfo.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
      }
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(((AVTestforEncDecConfig.Sample)localObject2).jdField_b_of_type_JavaLangString)) {}
      }
      else
      {
        int i = paramTestInfo.jdField_a_of_type_JavaUtilHashMap.size();
        i = (int)(System.currentTimeMillis() % i);
        localObject2 = (String)paramTestInfo.jdField_a_of_type_JavaUtilHashMap.keySet().toArray()[i];
        localObject1 = (AVTestforEncDecConfig.Sample)paramTestInfo.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
        localObject3 = ((SharedPreferences)localObject3).edit();
        ((SharedPreferences.Editor)localObject3).putString(a(paramTestInfo.jdField_b_of_type_Int, "md5"), (String)localObject2);
        ((SharedPreferences.Editor)localObject3).commit();
      }
    }
    return localObject1;
  }
  
  private void b()
  {
    if (AudioHelper.b()) {
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed");
    }
    Object localObject1 = ConfigSystemImpl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (AudioHelper.b())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("testVideoEffectIfNeed test config: \n");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("DeviceCapabilityExamination", 1, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = (IConfigParser)QRoute.api(IConfigParser.class);
      ((IConfigParser)localObject2).setData((String)localObject1);
      if (((IVideoEffectConfigParser)QRoute.api(IVideoEffectConfigParser.class)).getVideoEffectTestFlag((IConfigParser)localObject2) == 1)
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSharedPreferences("qav_sp_video_effect", 0);
        if (!((SharedPreferences)localObject1).getBoolean("qav_key_test_executed", false))
        {
          localObject1 = ((SharedPreferences)localObject1).edit();
          ((SharedPreferences.Editor)localObject1).putBoolean("qav_key_test_executed", true);
          ((SharedPreferences.Editor)localObject1).commit();
          new VideoEffectTest(new DeviceCapabilityExamination.4(this)).a();
          return;
        }
        if (AudioHelper.b()) {
          QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed test executed.");
        }
      }
    }
    else if (AudioHelper.b())
    {
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed do not need test.");
    }
  }
  
  private static void b(int paramInt1, int paramInt2)
  {
    Object localObject = a();
    int i = ((SharedPreferences)localObject).getInt(a(paramInt1, "test_ver"), 0);
    if (i == paramInt2) {
      return;
    }
    long l1 = ((SharedPreferences)localObject).getLong(a(paramInt1, "doneTime"), 0L);
    long l2 = ((SharedPreferences)localObject).getLong(a(paramInt1, "finishTime"), 0L);
    String str = ((SharedPreferences)localObject).getString(a(paramInt1, "md5"), null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).remove(a(paramInt1, "md5"));
    ((SharedPreferences.Editor)localObject).remove(a(paramInt1, "doneTime"));
    ((SharedPreferences.Editor)localObject).remove(a(paramInt1, "finishTime"));
    ((SharedPreferences.Editor)localObject).remove(a(paramInt1, "result"));
    ((SharedPreferences.Editor)localObject).putInt(a(paramInt1, "test_ver"), paramInt2);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkSPVer, codec[");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("], ver[");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("->");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("], doneFlagTime[");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("], finishFlagTime[");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append("], md5[");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("]");
    QLog.w("DeviceCapabilityExamination", 1, ((StringBuilder)localObject).toString());
  }
  
  public static void b(int paramInt, VideoAppInterface paramVideoAppInterface)
  {
    ThreadManager.excute(new DeviceCapabilityExamination.3(paramInt, paramVideoAppInterface), 16, null, true);
  }
  
  public static void b(int paramInt, String paramString)
  {
    try
    {
      Object localObject = c(paramString);
      File localFile = new File((String)localObject);
      boolean bool = localFile.exists();
      FileUtils.deleteDirectory((String)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delSampleFile, codec[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], md5[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], exists[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(localFile.exists());
      ((StringBuilder)localObject).append("]");
      QLog.w("DeviceCapabilityExamination", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString) {}
  }
  
  private static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination
 * JD-Core Version:    0.7.0.1
 */