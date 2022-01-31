package com.tencent.av.app;

import ajyc;
import ampm;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import ayrv;
import ayry;
import bbdj;
import bbev;
import com.tencent.av.VideoController;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.videoeffect.VideoEffectTest;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
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
import lcm;
import lcq;
import lcs;
import lct;
import ler;
import les;
import let;
import leu;
import lew;
import lex;
import ley;
import lez;
import lle;
import llq;
import lpc;
import mus;
import muz;

public class DeviceCapabilityExamination
{
  public static lex a;
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
  
  public static String a(int paramInt, lcs paramlcs)
  {
    String str = "enc_[w" + paramlcs.jdField_a_of_type_Int + "h" + paramlcs.jdField_b_of_type_Int + "fYUV420]_";
    paramlcs = c(paramlcs.jdField_a_of_type_JavaLangString) + str + paramlcs.jdField_c_of_type_Int + "_" + paramlcs.d + "_" + paramlcs.jdField_a_of_type_Int + "x" + paramlcs.jdField_b_of_type_Int;
    if ((paramInt == 1) || (paramInt == 2)) {
      return paramlcs + ".264";
    }
    return paramlcs + ".265";
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
      localArrayList.add(new Integer[] { Integer.valueOf(29), Integer.valueOf(600), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    }
    return localArrayList;
  }
  
  public static TreeMap<Integer, Integer[]> a()
  {
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put(Integer.valueOf(1), new Integer[] { Integer.valueOf(1), Integer.valueOf(30), Integer.valueOf(192), Integer.valueOf(144), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(10), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(2), new Integer[] { Integer.valueOf(2), Integer.valueOf(45), Integer.valueOf(192), Integer.valueOf(144), Integer.valueOf(4), Integer.valueOf(3), Integer.valueOf(10), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(3), new Integer[] { Integer.valueOf(3), Integer.valueOf(60), Integer.valueOf(192), Integer.valueOf(144), Integer.valueOf(6), Integer.valueOf(3), Integer.valueOf(10), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(4), new Integer[] { Integer.valueOf(4), Integer.valueOf(80), Integer.valueOf(192), Integer.valueOf(144), Integer.valueOf(6), Integer.valueOf(3), Integer.valueOf(10), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(5), new Integer[] { Integer.valueOf(5), Integer.valueOf(100), Integer.valueOf(192), Integer.valueOf(144), Integer.valueOf(8), Integer.valueOf(3), Integer.valueOf(10), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(6), new Integer[] { Integer.valueOf(6), Integer.valueOf(115), Integer.valueOf(192), Integer.valueOf(144), Integer.valueOf(10), Integer.valueOf(2), Integer.valueOf(10), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(7), new Integer[] { Integer.valueOf(7), Integer.valueOf(130), Integer.valueOf(192), Integer.valueOf(144), Integer.valueOf(10), Integer.valueOf(2), Integer.valueOf(10), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(8), new Integer[] { Integer.valueOf(8), Integer.valueOf(130), Integer.valueOf(320), Integer.valueOf(240), Integer.valueOf(8), Integer.valueOf(3), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(9), new Integer[] { Integer.valueOf(9), Integer.valueOf(150), Integer.valueOf(320), Integer.valueOf(240), Integer.valueOf(8), Integer.valueOf(2), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(10), new Integer[] { Integer.valueOf(10), Integer.valueOf(170), Integer.valueOf(320), Integer.valueOf(240), Integer.valueOf(10), Integer.valueOf(2), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(11), new Integer[] { Integer.valueOf(11), Integer.valueOf(190), Integer.valueOf(320), Integer.valueOf(240), Integer.valueOf(10), Integer.valueOf(2), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(12), new Integer[] { Integer.valueOf(12), Integer.valueOf(210), Integer.valueOf(320), Integer.valueOf(240), Integer.valueOf(10), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(13), new Integer[] { Integer.valueOf(13), Integer.valueOf(230), Integer.valueOf(320), Integer.valueOf(240), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(14), new Integer[] { Integer.valueOf(14), Integer.valueOf(250), Integer.valueOf(320), Integer.valueOf(240), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(15), new Integer[] { Integer.valueOf(15), Integer.valueOf(275), Integer.valueOf(320), Integer.valueOf(240), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(16), new Integer[] { Integer.valueOf(16), Integer.valueOf(300), Integer.valueOf(320), Integer.valueOf(240), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(17), new Integer[] { Integer.valueOf(17), Integer.valueOf(325), Integer.valueOf(320), Integer.valueOf(240), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(18), new Integer[] { Integer.valueOf(18), Integer.valueOf(300), Integer.valueOf(480), Integer.valueOf(360), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(19), new Integer[] { Integer.valueOf(19), Integer.valueOf(325), Integer.valueOf(480), Integer.valueOf(360), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(20), new Integer[] { Integer.valueOf(20), Integer.valueOf(350), Integer.valueOf(480), Integer.valueOf(360), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(21), new Integer[] { Integer.valueOf(21), Integer.valueOf(375), Integer.valueOf(480), Integer.valueOf(360), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(22), new Integer[] { Integer.valueOf(22), Integer.valueOf(400), Integer.valueOf(480), Integer.valueOf(360), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(23), new Integer[] { Integer.valueOf(23), Integer.valueOf(425), Integer.valueOf(480), Integer.valueOf(360), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(24), new Integer[] { Integer.valueOf(24), Integer.valueOf(450), Integer.valueOf(480), Integer.valueOf(360), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(25), new Integer[] { Integer.valueOf(25), Integer.valueOf(425), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(26), new Integer[] { Integer.valueOf(26), Integer.valueOf(450), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(27), new Integer[] { Integer.valueOf(27), Integer.valueOf(500), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(28), new Integer[] { Integer.valueOf(28), Integer.valueOf(550), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(29), new Integer[] { Integer.valueOf(29), Integer.valueOf(600), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(30), new Integer[] { Integer.valueOf(30), Integer.valueOf(650), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(31), new Integer[] { Integer.valueOf(31), Integer.valueOf(700), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(32), new Integer[] { Integer.valueOf(32), Integer.valueOf(750), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(33), new Integer[] { Integer.valueOf(33), Integer.valueOf(800), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(34), new Integer[] { Integer.valueOf(34), Integer.valueOf(850), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(35), new Integer[] { Integer.valueOf(35), Integer.valueOf(900), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(36), new Integer[] { Integer.valueOf(36), Integer.valueOf(1000), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(37), new Integer[] { Integer.valueOf(37), Integer.valueOf(800), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(38), new Integer[] { Integer.valueOf(38), Integer.valueOf(850), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(39), new Integer[] { Integer.valueOf(39), Integer.valueOf(900), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(40), new Integer[] { Integer.valueOf(40), Integer.valueOf(1000), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(41), new Integer[] { Integer.valueOf(41), Integer.valueOf(1100), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(42), new Integer[] { Integer.valueOf(42), Integer.valueOf(1200), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(43), new Integer[] { Integer.valueOf(43), Integer.valueOf(1300), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    return localTreeMap;
  }
  
  public static lez a(int paramInt1, int paramInt2, long paramLong1, String paramString1, String paramString2, int paramInt3, long paramLong2)
  {
    lez locallez = new lez();
    locallez.jdField_a_of_type_Long = Long.parseLong(VideoController.a().jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    locallez.jdField_b_of_type_Int = paramInt1;
    locallez.g = paramString2;
    locallez.h = paramString1;
    locallez.jdField_c_of_type_Int = paramInt2;
    locallez.d = ((int)paramLong2);
    locallez.e = ((int)paramLong1);
    return locallez;
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
    int i = ampm.a().a(431, "");
    localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof VideoAppInterface))
    {
      Object localObject2 = (VideoAppInterface)localObject1;
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("uin", ((VideoAppInterface)localObject2).getCurrentAccountUin());
      ((HashMap)localObject1).put("ver", i + "");
      ((HashMap)localObject1).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      localObject2 = lcq.a(paramInt);
      if (localObject2 != null)
      {
        i = lpc.a((lct)localObject2);
        ((HashMap)localObject1).put("test" + paramInt, "1");
        ((HashMap)localObject1).put("test" + paramInt + "_ver", ((lct)localObject2).e + "");
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
    mus.a(paramVideoAppInterface);
    mus.a("DeviceCapabilityExamination", paramVideoAppInterface);
    ThreadManager.excute(new DeviceCapabilityExamination.1(paramInt, paramVideoAppInterface), 16, null, true);
  }
  
  static void a(int paramInt, String paramString)
  {
    if (AudioHelper.d())
    {
      QLog.w("DeviceCapabilityExamination", 1, "delSampleFile, 测试版本不删除样本, codec[" + paramInt + "], md5[" + paramString + "]");
      return;
    }
    b(paramInt, paramString);
  }
  
  public static void a(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt, lcs paramlcs, les paramles)
  {
    long l = System.currentTimeMillis();
    VideoController localVideoController = paramVideoAppInterface.a();
    let locallet = new let();
    locallet.jdField_a_of_type_Int = paramInt;
    locallet.jdField_a_of_type_JavaLangString = paramlcs.jdField_a_of_type_JavaLangString;
    locallet.jdField_b_of_type_JavaLangString = a(paramlcs.jdField_a_of_type_JavaLangString);
    locallet.d = a(paramInt, paramlcs);
    locallet.jdField_c_of_type_Int = paramlcs.jdField_c_of_type_Int;
    locallet.jdField_b_of_type_Int = paramlcs.d;
    locallet.jdField_c_of_type_JavaLangString = paramlcs.jdField_c_of_type_JavaLangString;
    ler.a(paramLong, localVideoController, locallet, new leu(l, paramInt, locallet, paramlcs, paramVideoAppInterface, paramLong, paramles));
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
  
  public static void a(lct paramlct, String paramString1, String paramString2)
  {
    if (!bbev.h(null))
    {
      QLog.w("DeviceCapabilityExamination", 1, "startDownloadTestResource, no wifi");
      return;
    }
    try
    {
      if (jdField_a_of_type_Lex == null) {
        jdField_a_of_type_Lex = new lex();
      }
      if (jdField_a_of_type_Lex.a(paramString1, paramString2))
      {
        QLog.w("DeviceCapabilityExamination", 1, "startDownloadTestResource, 下载中 , md5[" + paramString1 + "]");
        return;
      }
    }
    finally {}
    if (AudioHelper.e()) {
      QLog.w("DeviceCapabilityExamination", 1, "startDownloadTestResource, md5[" + paramString1 + "]");
    }
    paramlct = new ayrv();
    paramlct.jdField_a_of_type_Aysa = new ley();
    paramlct.jdField_a_of_type_JavaLangString = paramString2;
    paramlct.jdField_a_of_type_Int = 0;
    paramlct.jdField_c_of_type_JavaLangString = (c(paramString1) + "sample.zip");
    paramlct.e = paramString1;
    paramlct.a(paramString1);
    lcm.a().a(paramlct);
  }
  
  public static void a(lez paramlez, int paramInt1, int paramInt2)
  {
    ClientLogReport.instance().callbackSendLog(paramlez.jdField_a_of_type_Long, 5274, paramlez.a().getBytes());
    AudioHelper.c(ajyc.a(2131703164) + paramInt1 + "], resultCode:" + paramInt2);
    a(paramInt1, paramInt2);
    a(paramInt1, paramlez.h);
  }
  
  static boolean a(int paramInt)
  {
    lct locallct = lcq.a(paramInt);
    if ((locallct == null) || (System.currentTimeMillis() > locallct.jdField_a_of_type_Long)) {}
    SharedPreferences localSharedPreferences;
    long l1;
    do
    {
      do
      {
        return false;
        b(locallct.jdField_b_of_type_Int, locallct.e);
        localSharedPreferences = a();
        l1 = localSharedPreferences.getLong(a(paramInt, "doneTime"), 0L);
        if (l1 != 0L) {
          break;
        }
      } while (!a(locallct, true));
      a(locallct.jdField_b_of_type_Int);
      return true;
    } while (!AudioHelper.e());
    int i = localSharedPreferences.getInt(a(paramInt, "result"), -99);
    long l2 = localSharedPreferences.getLong(a(paramInt, "finishTime"), 0L);
    QLog.w("DeviceCapabilityExamination", 1, "runTest, done, codec[" + paramInt + "], result[" + i + "], doneFlagTime[" + l1 + "], finishFlagTime[" + l2 + "]");
    return false;
  }
  
  public static boolean a(lct paramlct, boolean paramBoolean)
  {
    if (paramlct == null) {}
    lcs locallcs;
    do
    {
      do
      {
        return false;
      } while (lpc.a(paramlct) == 0);
      locallcs = b(paramlct);
      if (locallcs == null)
      {
        QLog.w("DeviceCapabilityExamination", 1, "checkCondition, 无样本, codec[" + paramlct.jdField_b_of_type_Int + "]");
        return false;
      }
      String str = a(locallcs.jdField_a_of_type_JavaLangString);
      if (new File(str).exists()) {
        break;
      }
      QLog.w("DeviceCapabilityExamination", 1, "checkCondition, 样本未下载, codec[" + paramlct.jdField_b_of_type_Int + "], path[" + str + "], downloadRes[" + paramBoolean + "]");
    } while (!paramBoolean);
    a(paramlct, locallcs.jdField_a_of_type_JavaLangString, locallcs.jdField_b_of_type_JavaLangString);
    return false;
    return true;
  }
  
  static Integer[] a(TreeMap<Integer, Integer[]> paramTreeMap, String paramString, int paramInt1, int paramInt2)
  {
    paramTreeMap = a(paramTreeMap, paramString, paramInt1, paramInt2);
    return (Integer[])paramTreeMap.get((int)(System.currentTimeMillis() % paramTreeMap.size()));
  }
  
  private static lcs b(lct paramlct)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (paramlct.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if (paramlct.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break label30;
      }
      localObject2 = localObject3;
    }
    label30:
    do
    {
      return localObject2;
      localObject3 = a();
      localObject2 = ((SharedPreferences)localObject3).getString(a(paramlct.jdField_b_of_type_Int, "md5"), null);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = (lcs)paramlct.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      }
      if (localObject1 == null) {
        break;
      }
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty(((lcs)localObject1).jdField_b_of_type_JavaLangString));
    int i = paramlct.jdField_a_of_type_JavaUtilHashMap.size();
    i = (int)(System.currentTimeMillis() % i);
    localObject1 = (String)paramlct.jdField_a_of_type_JavaUtilHashMap.keySet().toArray()[i];
    localObject2 = (lcs)paramlct.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
    localObject3 = ((SharedPreferences)localObject3).edit();
    ((SharedPreferences.Editor)localObject3).putString(a(paramlct.jdField_b_of_type_Int, "md5"), (String)localObject1);
    ((SharedPreferences.Editor)localObject3).commit();
    return localObject2;
  }
  
  private void b()
  {
    if (AudioHelper.e()) {
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed");
    }
    Object localObject = llq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (AudioHelper.e()) {
        QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed test config: \n" + (String)localObject);
      }
      localObject = new lle((String)localObject);
      if (new muz().a((lle)localObject) == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSharedPreferences("qav_sp_video_effect", 0);
        if (((SharedPreferences)localObject).getBoolean("qav_key_test_executed", false)) {
          break label161;
        }
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("qav_key_test_executed", true);
        ((SharedPreferences.Editor)localObject).commit();
        new VideoEffectTest(new lew(this)).a();
      }
    }
    label161:
    while (!AudioHelper.e())
    {
      do
      {
        return;
      } while (!AudioHelper.e());
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
      bbdj.a(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination
 * JD-Core Version:    0.7.0.1
 */