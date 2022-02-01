import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.voicechange.QQVoiceChangerThread;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class bgrn
  implements Manager
{
  public static String a;
  public static HashMap<String, bgrr> a;
  public static String[] a;
  bgod jdField_a_of_type_Bgod = new bgro(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaLangString = AppConstants.SDCARD_PATH + "voiceChange/";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { null, null, null };
  }
  
  public bgrn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  /* Error */
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iload_0
    //   4: i2d
    //   5: dstore 5
    //   7: dload 5
    //   9: invokestatic 71	com/tencent/mobileqq/utils/QQRecorder:a	(D)I
    //   12: istore_0
    //   13: getstatic 24	bgrn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   16: aload_1
    //   17: invokevirtual 75	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 77	bgrr
    //   23: astore 7
    //   25: aload 7
    //   27: ifnull +88 -> 115
    //   30: aload 7
    //   32: getfield 80	bgrr:jdField_a_of_type_Bgrs	Lbgrs;
    //   35: ifnull +84 -> 119
    //   38: aload_1
    //   39: aload_2
    //   40: iload_3
    //   41: invokestatic 85	bgrt:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   44: aload 7
    //   46: getfield 80	bgrr:jdField_a_of_type_Bgrs	Lbgrs;
    //   49: aload_1
    //   50: iload 4
    //   52: iload_0
    //   53: invokeinterface 91 4 0
    //   58: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +46 -> 107
    //   64: ldc 99
    //   66: iconst_2
    //   67: new 26	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   74: ldc 101
    //   76: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 103
    //   85: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_0
    //   89: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc 108
    //   94: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload_3
    //   98: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: getstatic 24	bgrn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   110: aload_1
    //   111: invokevirtual 115	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: pop
    //   115: ldc 2
    //   117: monitorexit
    //   118: return
    //   119: aload 7
    //   121: iconst_1
    //   122: putfield 118	bgrr:jdField_a_of_type_Boolean	Z
    //   125: aload 7
    //   127: iload_0
    //   128: putfield 121	bgrr:jdField_a_of_type_Int	I
    //   131: goto -16 -> 115
    //   134: astore_1
    //   135: ldc 2
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramInt1	int
    //   0	140	1	paramString1	String
    //   0	140	2	paramString2	String
    //   0	140	3	paramInt2	int
    //   0	140	4	paramInt3	int
    //   5	3	5	d	double
    //   23	103	7	localbgrr	bgrr
    // Exception table:
    //   from	to	target	type
    //   7	25	134	finally
    //   30	107	134	finally
    //   107	115	134	finally
    //   119	131	134	finally
  }
  
  public static void a(Context paramContext, bgrk parambgrk, String paramString, bgrj parambgrj)
  {
    if ((bgrr)jdField_a_of_type_JavaUtilHashMap.get(parambgrk.jdField_a_of_type_JavaLangString) == null) {
      b(paramContext, parambgrk, paramString, parambgrj);
    }
    ((bgrr)jdField_a_of_type_JavaUtilHashMap.get(parambgrk.jdField_a_of_type_JavaLangString)).jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.c();
  }
  
  public static void a(Context paramContext, bgrk parambgrk, String paramString, bgrj parambgrj, bgrp parambgrp)
  {
    bgrr localbgrr = (bgrr)jdField_a_of_type_JavaUtilHashMap.get(parambgrk.jdField_a_of_type_JavaLangString);
    if (localbgrr != null) {
      localbgrr.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.jdField_a_of_type_Boolean = false;
    }
    localbgrr = new bgrr();
    localbgrr.jdField_a_of_type_Bgrk = parambgrk;
    localbgrr.jdField_a_of_type_Bgrp = parambgrp;
    localbgrr.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = new QQVoiceChangerThread(paramContext, parambgrk, parambgrp, paramString, parambgrj);
    jdField_a_of_type_JavaUtilHashMap.put(parambgrk.jdField_a_of_type_JavaLangString, localbgrr);
    localbgrr.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.start();
  }
  
  public static void a(bgrk parambgrk)
  {
    bgrr localbgrr = (bgrr)jdField_a_of_type_JavaUtilHashMap.get(parambgrk.jdField_a_of_type_JavaLangString);
    if (localbgrr != null)
    {
      localbgrr.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.d();
      jdField_a_of_type_JavaUtilHashMap.remove(parambgrk.jdField_a_of_type_JavaLangString);
    }
  }
  
  public static boolean a(String paramString, bgrs parambgrs)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "queryStateByPath called path=" + paramString);
        }
        bgrr localbgrr = (bgrr)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (localbgrr == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceChangeManager", 2, "no task path=" + paramString);
          }
          bool = false;
          return bool;
        }
        if (localbgrr.jdField_a_of_type_Boolean)
        {
          bgrt.a(paramString, localbgrr.jdField_a_of_type_Bgrk.jdField_a_of_type_JavaLangString, localbgrr.jdField_a_of_type_Bgrk.f);
          jdField_a_of_type_JavaUtilHashMap.remove(paramString);
          parambgrs.onCompressFinished(paramString, localbgrr.jdField_a_of_type_Bgrk.e, localbgrr.jdField_a_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceChangeManager", 2, "queryStateByPath onCompressFinished filePath=" + paramString + " time=" + localbgrr.jdField_a_of_type_Int + " voiceType=" + localbgrr.jdField_a_of_type_Bgrk.e);
          }
        }
        else
        {
          localbgrr.jdField_a_of_type_Bgrs = parambgrs;
        }
      }
      finally {}
      boolean bool = true;
    }
  }
  
  public static void b(Context paramContext, bgrk parambgrk, String paramString, bgrj parambgrj)
  {
    a(paramContext, parambgrk, paramString, parambgrj, bgrp.a());
  }
  
  public static void b(bgrk parambgrk)
  {
    bgrr localbgrr = (bgrr)jdField_a_of_type_JavaUtilHashMap.get(parambgrk.jdField_a_of_type_JavaLangString);
    if (localbgrr != null)
    {
      localbgrr.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.jdField_a_of_type_Boolean = false;
      jdField_a_of_type_JavaUtilHashMap.remove(parambgrk.jdField_a_of_type_JavaLangString);
    }
  }
  
  public boolean a(ArrayList<bgrl> paramArrayList, JSONObject paramJSONObject)
  {
    boolean bool = bgqr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), "VoiceChangeManager", false);
    if (!bool)
    {
      jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir().getAbsolutePath() + File.separator + "voiceChange" + File.separator;
      QLog.d("VoiceChangeManager", 2, "preCheckData start haveSDCard:" + bool + ", path=" + jdField_a_of_type_JavaLangString);
    }
    Object localObject1 = new File(jdField_a_of_type_JavaLangString);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {
      ((File)localObject1).mkdirs();
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceChangeManager", 2, "preCheckData start");
    }
    localObject1 = paramJSONObject;
    if (paramJSONObject == null) {
      localObject1 = VasQuickUpdateManager.getJSONFromLocal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "changeVoice_json", false, null);
    }
    int[] arrayOfInt = ListenChangeVoicePanel.a;
    if (localObject1 == null)
    {
      QLog.e("VoiceChangeManager", 1, "preCheckData null == xydata");
      return false;
    }
    long l1;
    int k;
    Object localObject3;
    label339:
    Object localObject2;
    try
    {
      l1 = ((JSONObject)localObject1).optLong("timestamp", 0L);
      long l2 = System.currentTimeMillis() / 1000L;
      JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("VoiceChangeModels");
      k = 0;
      if (k >= localJSONArray.length()) {
        break label1129;
      }
      localObject3 = localJSONArray.getJSONObject(k);
      if ((localObject3 == null) || (((JSONObject)localObject3).getJSONArray("baseInfo") == null) || (((JSONObject)localObject3).getJSONArray("baseInfo").getJSONObject(0) == null) || (((JSONObject)localObject3).getJSONArray("operationInfo") == null))
      {
        QLog.e("VoiceChangeManager", 1, "preCheckData JsonErr:i=" + k + ", timestamp:" + l1);
        break label1363;
      }
      localObject4 = ((JSONObject)localObject3).getJSONArray("operationInfo");
      paramJSONObject = null;
      i = 0;
      if (i < ((JSONArray)localObject4).length())
      {
        localObject2 = ((JSONObject)localObject3).getJSONArray("operationInfo").getJSONObject(i);
        if ((localObject2 == null) || (!((JSONObject)localObject2).has("platformId"))) {
          break label1381;
        }
        j = ((JSONObject)localObject2).getInt("platformId");
        label388:
        paramJSONObject = (JSONObject)localObject2;
        if (j == 0) {
          break label1374;
        }
        paramJSONObject = (JSONObject)localObject2;
        if (j == 2) {
          break label1374;
        }
        if (!QLog.isColorLevel()) {
          break label1372;
        }
        QLog.d("VoiceChangeManager", 2, "preCheckData continue platformId=" + j + ", i=" + k + ", timestamp:" + l1 + ", o=" + i);
        break label1372;
      }
      if (paramJSONObject != null) {
        break label1357;
      }
      localObject2 = new JSONObject();
      if (!QLog.isColorLevel()) {
        break label1387;
      }
      QLog.d("VoiceChangeManager", 2, "preCheckData continue null == itemJsonOpera, i=" + k + ", timestamp:" + l1);
    }
    catch (Exception paramArrayList)
    {
      label533:
      QLog.e("VoiceChangeManager", 1, "preCheckData jsonEx:" + paramArrayList.getMessage());
    }
    Object localObject4 = ((JSONObject)localObject3).getJSONArray("baseInfo").getJSONObject(0);
    int j = ((JSONObject)localObject4).getInt("voiceID");
    int i = 6;
    for (;;)
    {
      if (i < arrayOfInt.length)
      {
        if (arrayOfInt[i] == j)
        {
          label576:
          if (i < 0)
          {
            if (!QLog.isColorLevel()) {
              break label1363;
            }
            QLog.d("VoiceChangeManager", 2, "preCheckData not in VOICE_TYPES[] out:i=" + k + ", timestamp:" + l1);
            break label1363;
            this.jdField_a_of_type_Bgod.onDone(null);
            return true;
          }
        }
        else
        {
          label657:
          i += 1;
          continue;
        }
        if (paramArrayList == null) {
          break label1390;
        }
        paramJSONObject = (bgrl)paramArrayList.get(i);
        label687:
        if (paramJSONObject == null)
        {
          if (!QLog.isColorLevel()) {
            break label1363;
          }
          QLog.d("VoiceChangeManager", 2, "preCheckData null == voiceChangeData out:i=" + k + ", timestamp:" + l1);
          break label1363;
        }
        if (!((JSONObject)localObject2).has("isShow")) {
          break label1395;
        }
        j = ((JSONObject)localObject2).getInt("isShow");
        label759:
        i = j;
        if (j != 0)
        {
          i = j;
          if (((JSONObject)localObject2).has("QQVersion"))
          {
            i = j;
            if (bges.a(((JSONObject)localObject2).getString("QQVersion"), "8.4.8"))
            {
              j = 0;
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("VoiceChangeManager", 2, "preCheckData Version out:i=" + k + ", timestamp:" + l1);
                i = j;
              }
            }
          }
        }
        if (i == 0)
        {
          paramJSONObject.jdField_b_of_type_Int = i;
          break label1363;
        }
        if (!((JSONObject)localObject2).has("isEnable")) {
          break label1406;
        }
        if (((JSONObject)localObject2).getInt("isEnable") != 1) {
          break label1401;
        }
        i = 2;
        label891:
        localObject3 = ((JSONObject)localObject4).getString("icon");
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          QLog.e("VoiceChangeManager", 1, "preCheckData url Error null:");
          label918:
          paramJSONObject.jdField_b_of_type_Int = i;
          if (1 != i) {
            break label1050;
          }
          paramJSONObject.d = 1;
          paramJSONObject.c = 0;
          if (!TextUtils.isEmpty(((JSONObject)localObject4).getString("name"))) {
            break label1103;
          }
          localObject2 = paramJSONObject.jdField_a_of_type_JavaLangString;
          label958:
          paramJSONObject.jdField_a_of_type_JavaLangString = ((String)localObject2);
          if (!TextUtils.isEmpty(((JSONObject)localObject4).getString("description"))) {
            break label1116;
          }
        }
        label1050:
        label1070:
        label1095:
        label1103:
        label1116:
        for (localObject2 = paramJSONObject.jdField_b_of_type_JavaLangString;; localObject2 = ((JSONObject)localObject4).getString("description"))
        {
          paramJSONObject.jdField_b_of_type_JavaLangString = ((String)localObject2);
          paramJSONObject.jdField_a_of_type_Bgrm.jdField_a_of_type_JavaLangString = ((String)localObject3);
          break label1363;
          localObject3 = bgcw.jdField_b_of_type_JavaLangString + (String)localObject3;
          if (this.jdField_a_of_type_JavaUtilArrayList.contains(localObject3)) {
            break label1409;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
          break label1409;
          if (!((JSONObject)localObject2).has("feeType")) {
            break label1412;
          }
          i = ((JSONObject)localObject2).getInt("feeType");
          paramJSONObject.d = i;
          if (!((JSONObject)localObject2).has("tag")) {
            break label1417;
          }
          i = ((JSONObject)localObject2).getInt("tag");
          paramJSONObject.c = i;
          break;
          localObject2 = ((JSONObject)localObject4).getString("name");
          break label958;
        }
        label1129:
        if ((TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[0])) || (TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[1])) || (TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[2])))
        {
          paramArrayList = ((JSONObject)localObject1).getJSONArray("commmonData");
          if (paramArrayList == null) {
            break label1429;
          }
        }
      }
    }
    label1409:
    label1412:
    label1417:
    label1429:
    for (paramArrayList = paramArrayList.getJSONObject(0);; paramArrayList = null)
    {
      if (paramArrayList != null)
      {
        paramJSONObject = new String[3];
        paramJSONObject[0] = "vipIcon";
        paramJSONObject[1] = "svipIcon";
        paramJSONObject[2] = "activityIcon";
        i = 0;
      }
      for (;;)
      {
        if (i < paramJSONObject.length)
        {
          localObject1 = paramArrayList.getJSONObject(paramJSONObject[i]);
          if (localObject1 != null)
          {
            localObject1 = ((JSONObject)localObject1).getString("src");
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              QLog.e("VoiceChangeManager", 1, "preCheckData common url Error null:" + paramJSONObject[i]);
            }
            else
            {
              localObject1 = bgcw.jdField_b_of_type_JavaLangString + (String)localObject1;
              if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localObject1)) {
                this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
              }
              jdField_a_of_type_ArrayOfJavaLangString[i] = localObject1;
            }
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label657;
          }
          QLog.d("VoiceChangeManager", 2, "preCheckData run ok");
          break label657;
          i = -1;
          break label576;
          label1357:
          localObject2 = paramJSONObject;
          break label533;
          label1363:
          k += 1;
          break;
          label1372:
          paramJSONObject = null;
          label1374:
          i += 1;
          break label339;
          label1381:
          j = -1;
          break label388;
          label1387:
          break label533;
          label1390:
          paramJSONObject = null;
          break label687;
          label1395:
          j = 2;
          break label759;
          label1401:
          i = 1;
          break label891;
          label1406:
          break label891;
          break label918;
          i = 1;
          break label1070;
          i = 0;
          break label1095;
        }
        i += 1;
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrn
 * JD-Core Version:    0.7.0.1
 */