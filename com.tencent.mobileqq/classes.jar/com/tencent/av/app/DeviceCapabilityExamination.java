package com.tencent.av.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import anzj;
import aran;
import beum;
import beuo;
import bhmi;
import bhnv;
import com.tencent.av.VideoController;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.videoeffect.VideoEffectTest;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import lbk;
import lbp;
import lbr;
import lbs;
import ldq;
import ldr;
import lds;
import ldt;
import ldv;
import ldw;
import ldx;
import ldy;
import lkk;
import lkw;
import lol;
import mvp;
import mvw;

public class DeviceCapabilityExamination
{
  public static ldw a;
  public VideoAppInterface a;
  
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
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null) {
      return "";
    }
    return localFile.getParent() + "/qav/sample/";
  }
  
  public static String a(int paramInt, String paramString)
  {
    return "DT_" + paramInt + "_" + paramString;
  }
  
  public static String a(int paramInt, lbr paramlbr)
  {
    String str = "enc_[w" + paramlbr.jdField_a_of_type_Int + "h" + paramlbr.jdField_b_of_type_Int + "fYUV420]_";
    paramlbr = c(paramlbr.jdField_a_of_type_JavaLangString) + str + paramlbr.jdField_c_of_type_Int + "_" + paramlbr.d + "_" + paramlbr.jdField_a_of_type_Int + "x" + paramlbr.jdField_b_of_type_Int;
    if ((paramInt == 1) || (paramInt == 2)) {
      return paramlbr + ".264";
    }
    return paramlbr + ".265";
  }
  
  public static String a(String paramString)
  {
    return c(paramString) + "sample";
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
        if (QLog.isDevelopLevel()) {
          QLog.w("DeviceCapabilityExamination", 1, "getBitRateTable, md5[" + paramString + "], w[" + paramInt1 + "], h[" + paramInt2 + "], bitrate[" + arrayOfInteger[1] + "], fps[" + arrayOfInteger[4] + "]");
        }
      }
    }
    if (localArrayList.size() == 0)
    {
      QLog.w("DeviceCapabilityExamination", 1, "getBitRateTable, 没找到对应的码表, md5[" + paramString + "], w[" + paramInt1 + "], h[" + paramInt2 + "]");
      localArrayList.add(new Integer[] { Integer.valueOf(32), Integer.valueOf(2000), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    }
    return localArrayList;
  }
  
  public static TreeMap<Integer, Integer[]> a()
  {
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put(Integer.valueOf(1), new Integer[] { Integer.valueOf(1), Integer.valueOf(425), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(2), new Integer[] { Integer.valueOf(2), Integer.valueOf(450), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(3), new Integer[] { Integer.valueOf(3), Integer.valueOf(500), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(4), new Integer[] { Integer.valueOf(4), Integer.valueOf(550), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(5), new Integer[] { Integer.valueOf(5), Integer.valueOf(600), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(6), new Integer[] { Integer.valueOf(6), Integer.valueOf(650), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(7), new Integer[] { Integer.valueOf(7), Integer.valueOf(700), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(8), new Integer[] { Integer.valueOf(8), Integer.valueOf(750), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(9), new Integer[] { Integer.valueOf(9), Integer.valueOf(800), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(10), new Integer[] { Integer.valueOf(10), Integer.valueOf(850), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(11), new Integer[] { Integer.valueOf(11), Integer.valueOf(900), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(12), new Integer[] { Integer.valueOf(12), Integer.valueOf(1000), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(13), new Integer[] { Integer.valueOf(13), Integer.valueOf(800), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(14), new Integer[] { Integer.valueOf(14), Integer.valueOf(850), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(15), new Integer[] { Integer.valueOf(15), Integer.valueOf(900), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(16), new Integer[] { Integer.valueOf(16), Integer.valueOf(1000), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(17), new Integer[] { Integer.valueOf(17), Integer.valueOf(1100), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(18), new Integer[] { Integer.valueOf(18), Integer.valueOf(1200), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(19), new Integer[] { Integer.valueOf(19), Integer.valueOf(1300), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(20), new Integer[] { Integer.valueOf(20), Integer.valueOf(1400), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(21), new Integer[] { Integer.valueOf(21), Integer.valueOf(1500), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(22), new Integer[] { Integer.valueOf(22), Integer.valueOf(1600), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(23), new Integer[] { Integer.valueOf(23), Integer.valueOf(1700), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(24), new Integer[] { Integer.valueOf(24), Integer.valueOf(1800), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(25), new Integer[] { Integer.valueOf(25), Integer.valueOf(2000), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(26), new Integer[] { Integer.valueOf(26), Integer.valueOf(2100), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(27), new Integer[] { Integer.valueOf(27), Integer.valueOf(2200), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(28), new Integer[] { Integer.valueOf(28), Integer.valueOf(2300), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(29), new Integer[] { Integer.valueOf(29), Integer.valueOf(2400), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(30), new Integer[] { Integer.valueOf(30), Integer.valueOf(2600), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(31), new Integer[] { Integer.valueOf(31), Integer.valueOf(2800), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    return localTreeMap;
  }
  
  public static ldy a(int paramInt1, int paramInt2, long paramLong1, String paramString1, String paramString2, int paramInt3, long paramLong2)
  {
    ldy localldy = new ldy();
    localldy.jdField_a_of_type_Long = Long.parseLong(VideoController.a().jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    localldy.jdField_b_of_type_Int = paramInt1;
    localldy.g = paramString2;
    localldy.h = paramString1;
    localldy.jdField_c_of_type_Int = paramInt2;
    localldy.d = ((int)paramLong2);
    localldy.e = ((int)paramLong1);
    return localldy;
  }
  
  private void a()
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    b();
  }
  
  private static void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    QLog.w("DeviceCapabilityExamination", 1, "setTestDone, codec[" + paramInt + "], doneFlagTime[" + l + "]");
    Object localObject1 = a().edit();
    ((SharedPreferences.Editor)localObject1).putLong(a(paramInt, "doneTime"), l);
    ((SharedPreferences.Editor)localObject1).commit();
    int i = aran.a().a(431, "");
    localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof VideoAppInterface))
    {
      Object localObject2 = (VideoAppInterface)localObject1;
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("uin", ((VideoAppInterface)localObject2).getCurrentAccountUin());
      ((HashMap)localObject1).put("ver", i + "");
      ((HashMap)localObject1).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      localObject2 = lbp.a(paramInt);
      if (localObject2 != null)
      {
        i = lol.a((lbs)localObject2);
        ((HashMap)localObject1).put("test" + paramInt, "1");
        ((HashMap)localObject1).put("test" + paramInt + "_ver", ((lbs)localObject2).e + "");
        ((HashMap)localObject1).put("test" + paramInt + "_flag", i + "");
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
    mvp.a(paramVideoAppInterface);
    mvp.a("DeviceCapabilityExamination", paramVideoAppInterface);
    ThreadManager.excute(new DeviceCapabilityExamination.1(paramInt, paramVideoAppInterface), 16, null, true);
  }
  
  static void a(int paramInt, String paramString)
  {
    if (AudioHelper.e())
    {
      QLog.w("DeviceCapabilityExamination", 1, "delSampleFile, 测试版本不删除样本, codec[" + paramInt + "], md5[" + paramString + "]");
      return;
    }
    b(paramInt, paramString);
  }
  
  public static void a(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt, lbr paramlbr, ldr paramldr)
  {
    long l = System.currentTimeMillis();
    VideoController localVideoController = paramVideoAppInterface.a();
    lds locallds = new lds();
    locallds.jdField_a_of_type_Int = paramInt;
    locallds.jdField_a_of_type_JavaLangString = paramlbr.jdField_a_of_type_JavaLangString;
    locallds.jdField_b_of_type_JavaLangString = a(paramlbr.jdField_a_of_type_JavaLangString);
    locallds.d = a(paramInt, paramlbr);
    locallds.jdField_c_of_type_Int = paramlbr.jdField_c_of_type_Int;
    locallds.jdField_b_of_type_Int = paramlbr.d;
    locallds.jdField_c_of_type_JavaLangString = paramlbr.jdField_c_of_type_JavaLangString;
    ldq.a(paramLong, localVideoController, locallds, new ldt(l, paramInt, locallds, paramlbr, paramVideoAppInterface, paramLong, paramldr));
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("DeviceCapabilityExamination", 1, "testHWCodecIfNeed, begin");
    }
    if (a(1)) {
      b(1, paramVideoAppInterface);
    }
    do
    {
      return;
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
    } while (!QLog.isDevelopLevel());
    QLog.w("DeviceCapabilityExamination", 1, "testHWCodecIfNeed, no");
  }
  
  public static void a(lbs paramlbs, String paramString1, String paramString2)
  {
    if (!bhnv.h(null))
    {
      QLog.w("DeviceCapabilityExamination", 1, "startDownloadTestResource, no wifi");
      return;
    }
    try
    {
      if (jdField_a_of_type_Ldw == null) {
        jdField_a_of_type_Ldw = new ldw();
      }
      if (jdField_a_of_type_Ldw.a(paramString1, paramString2))
      {
        QLog.w("DeviceCapabilityExamination", 1, "startDownloadTestResource, 下载中 , md5[" + paramString1 + "]");
        return;
      }
    }
    finally {}
    if (AudioHelper.f()) {
      QLog.w("DeviceCapabilityExamination", 1, "startDownloadTestResource, md5[" + paramString1 + "]");
    }
    paramlbs = new beum();
    paramlbs.jdField_a_of_type_Beuq = new ldx();
    paramlbs.jdField_a_of_type_JavaLangString = paramString2;
    paramlbs.jdField_a_of_type_Int = 0;
    paramlbs.jdField_c_of_type_JavaLangString = (c(paramString1) + "sample.zip");
    paramlbs.e = paramString1;
    paramlbs.a(paramString1);
    lbk.a().a(paramlbs);
  }
  
  public static void a(ldy paramldy, int paramInt1, int paramInt2)
  {
    ClientLogReport.instance().callbackSendLog(paramldy.jdField_a_of_type_Long, 5274, paramldy.a().getBytes());
    AudioHelper.c(anzj.a(2131702063) + paramInt1 + "], resultCode:" + paramInt2);
    a(paramInt1, paramInt2);
    a(paramInt1, paramldy.h);
  }
  
  static boolean a(int paramInt)
  {
    lbs locallbs = lbp.a(paramInt);
    if ((locallbs == null) || (System.currentTimeMillis() > locallbs.jdField_a_of_type_Long)) {}
    SharedPreferences localSharedPreferences;
    long l1;
    do
    {
      do
      {
        return false;
        b(locallbs.jdField_b_of_type_Int, locallbs.e);
        localSharedPreferences = a();
        l1 = localSharedPreferences.getLong(a(paramInt, "doneTime"), 0L);
        if (l1 != 0L) {
          break;
        }
      } while (!a(locallbs, true));
      if (((paramInt == 8) || (paramInt == 2)) && (TextUtils.isEmpty(AVSoUtils.d())))
      {
        QLog.w("DeviceCapabilityExamination", 1, "runTest, cannot find libTcHevcDec2.so for hardware encode detect!!");
        return false;
      }
      a(locallbs.jdField_b_of_type_Int);
      return true;
    } while (!AudioHelper.f());
    int i = localSharedPreferences.getInt(a(paramInt, "result"), -99);
    long l2 = localSharedPreferences.getLong(a(paramInt, "finishTime"), 0L);
    QLog.w("DeviceCapabilityExamination", 1, "runTest, done, codec[" + paramInt + "], result[" + i + "], doneFlagTime[" + l1 + "], finishFlagTime[" + l2 + "]");
    return false;
  }
  
  public static boolean a(lbs paramlbs, boolean paramBoolean)
  {
    if (paramlbs == null) {}
    lbr locallbr;
    do
    {
      do
      {
        return false;
      } while (lol.a(paramlbs) == 0);
      locallbr = b(paramlbs);
      if (locallbr == null)
      {
        QLog.w("DeviceCapabilityExamination", 1, "checkCondition, 无样本, codec[" + paramlbs.jdField_b_of_type_Int + "]");
        return false;
      }
      String str = a(locallbr.jdField_a_of_type_JavaLangString);
      if (new File(str).exists()) {
        break;
      }
      QLog.w("DeviceCapabilityExamination", 1, "checkCondition, 样本未下载, codec[" + paramlbs.jdField_b_of_type_Int + "], path[" + str + "], downloadRes[" + paramBoolean + "]");
    } while (!paramBoolean);
    a(paramlbs, locallbr.jdField_a_of_type_JavaLangString, locallbr.jdField_b_of_type_JavaLangString);
    return false;
    return true;
  }
  
  static Integer[] a(TreeMap<Integer, Integer[]> paramTreeMap, String paramString, int paramInt1, int paramInt2)
  {
    paramTreeMap = a(paramTreeMap, paramString, paramInt1, paramInt2);
    return (Integer[])paramTreeMap.get((int)(System.currentTimeMillis() % paramTreeMap.size()));
  }
  
  private static lbr b(lbs paramlbs)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (paramlbs.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if (paramlbs.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break label30;
      }
      localObject2 = localObject3;
    }
    label30:
    do
    {
      return localObject2;
      localObject3 = a();
      localObject2 = ((SharedPreferences)localObject3).getString(a(paramlbs.jdField_b_of_type_Int, "md5"), null);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = (lbr)paramlbs.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      }
      if (localObject1 == null) {
        break;
      }
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty(((lbr)localObject1).jdField_b_of_type_JavaLangString));
    int i = paramlbs.jdField_a_of_type_JavaUtilHashMap.size();
    i = (int)(System.currentTimeMillis() % i);
    localObject1 = (String)paramlbs.jdField_a_of_type_JavaUtilHashMap.keySet().toArray()[i];
    localObject2 = (lbr)paramlbs.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
    localObject3 = ((SharedPreferences)localObject3).edit();
    ((SharedPreferences.Editor)localObject3).putString(a(paramlbs.jdField_b_of_type_Int, "md5"), (String)localObject1);
    ((SharedPreferences.Editor)localObject3).commit();
    return localObject2;
  }
  
  private void b()
  {
    if (AudioHelper.f()) {
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed");
    }
    Object localObject = lkw.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (AudioHelper.f()) {
        QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed test config: \n" + (String)localObject);
      }
      localObject = new lkk((String)localObject);
      if (new mvw().a((lkk)localObject) == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSharedPreferences("qav_sp_video_effect", 0);
        if (((SharedPreferences)localObject).getBoolean("qav_key_test_executed", false)) {
          break label161;
        }
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("qav_key_test_executed", true);
        ((SharedPreferences.Editor)localObject).commit();
        new VideoEffectTest(new ldv(this)).a();
      }
    }
    label161:
    while (!AudioHelper.f())
    {
      do
      {
        return;
      } while (!AudioHelper.f());
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed test executed.");
      return;
    }
    QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed do not need test.");
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
    QLog.w("DeviceCapabilityExamination", 1, "checkSPVer, codec[" + paramInt1 + "], ver[" + i + "->" + paramInt2 + "], doneFlagTime[" + l1 + "], finishFlagTime[" + l2 + "], md5[" + str + "]");
  }
  
  public static void b(int paramInt, VideoAppInterface paramVideoAppInterface)
  {
    ThreadManager.excute(new DeviceCapabilityExamination.3(paramInt, paramVideoAppInterface), 16, null, true);
  }
  
  public static void b(int paramInt, String paramString)
  {
    try
    {
      String str = c(paramString);
      File localFile = new File(str);
      boolean bool = localFile.exists();
      bhmi.a(str);
      QLog.w("DeviceCapabilityExamination", 1, "delSampleFile, codec[" + paramInt + "], md5[" + paramString + "], exists[" + bool + "->" + localFile.exists() + "]");
      return;
    }
    catch (Exception paramString) {}
  }
  
  private static String c(String paramString)
  {
    return a() + paramString + "/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination
 * JD-Core Version:    0.7.0.1
 */