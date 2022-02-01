import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.emoticon.EmojiManager.4;
import com.tencent.mobileqq.emoticon.EmojiManager.5;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class areb
  implements Manager
{
  public static int a;
  public static long a;
  public static area a;
  private static final String jdField_a_of_type_JavaLangString = areb.class.getSimpleName();
  public static boolean a;
  public static int b;
  private static String jdField_b_of_type_JavaLangString = "json_";
  public static boolean b;
  public static int c;
  public static int d;
  private static int g;
  private static int h = 1;
  avkv jdField_a_of_type_Avkv = null;
  public bgod a;
  public JobQueue a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  LRULinkedHashMap<String, ArrayList<String>> jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(20);
  public HashMap<String, String> a;
  Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  public ConcurrentHashMap<String, arfl> a;
  bgod jdField_b_of_type_Bgod = new ared(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  public bgod c;
  public boolean c;
  public boolean d;
  public int e;
  public boolean e;
  int f = 0;
  
  static
  {
    jdField_b_of_type_Int = 60000;
    jdField_c_of_type_Int = 1;
    d = jdField_c_of_type_Int + 1;
  }
  
  public areb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Int = 3000000;
    this.jdField_a_of_type_ComTencentImageJobQueue = new JobQueue(3);
    this.jdField_a_of_type_Bgod = new arec(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_c_of_type_Bgod = new aree(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Avkv = ((avkv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(83));
    jdField_a_of_type_Area = area.a();
  }
  
  private Bundle a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, EmoticonPackage paramEmoticonPackage)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    if (paramInt2 == -1)
    {
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      switch (paramInt1)
      {
      default: 
        k = paramInt6;
        j = paramInt4;
        i = paramInt2;
      case 2: 
        paramInt1 = i;
        m = j;
        n = k;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getPackageStatus| query result in DB or not DB, epId:" + paramString + ",result=" + i + " status=" + j + " progress=" + k);
          paramInt4 = k;
          paramInt2 = j;
          paramInt1 = i;
        }
        break;
      }
    }
    for (;;)
    {
      paramInt6 = paramInt2;
      paramInt2 = paramInt1;
      if (paramInt1 == -1)
      {
        paramInt2 = 0;
        paramInt6 = 0;
        paramInt4 = 0;
      }
      paramEmoticonPackage = new Bundle();
      paramEmoticonPackage.putString("id", paramString);
      paramEmoticonPackage.putInt("result", paramInt2);
      paramEmoticonPackage.putInt("status", paramInt6);
      paramEmoticonPackage.putInt("pluginStatus", paramInt5);
      paramEmoticonPackage.putLong("pluginSize", paramLong);
      paramEmoticonPackage.putInt("progress", paramInt4);
      paramEmoticonPackage.putInt("dEmojiId", paramInt7);
      paramEmoticonPackage.putInt("flag", paramInt3);
      paramEmoticonPackage.putStringArrayList("srcList", paramArrayList1);
      paramEmoticonPackage.putStringArrayList("urlParamsList", paramArrayList2);
      return paramEmoticonPackage;
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage == null) {
        break;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage.status != 2) {
        break;
      }
      if (a(paramString)) {
        if (EmoticonUtils.isEmoticonPkgUpdateBitSet(paramEmoticonPackage.updateFlag))
        {
          paramInt2 = 4;
          paramInt1 = 0;
        }
      }
      for (;;)
      {
        i = 0;
        j = paramInt2;
        k = paramInt1;
        break;
        paramInt1 = 100;
        paramInt2 = 3;
        continue;
        paramInt2 = 0;
        paramInt1 = 0;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage == null) {
        break;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage.status != 2) {
        break;
      }
      if (b(paramString)) {
        if (EmoticonUtils.isEmoticonPkgUpdateBitSet(paramEmoticonPackage.updateFlag))
        {
          paramInt2 = 4;
          paramInt1 = 0;
        }
      }
      for (;;)
      {
        i = 0;
        j = paramInt2;
        k = paramInt1;
        break;
        paramInt1 = 100;
        paramInt2 = 3;
        continue;
        paramInt2 = 0;
        paramInt1 = 0;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage == null) {
        break;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage.status != 2) {
        break;
      }
      if (a(paramString, Boolean.valueOf(true)))
      {
        paramInt2 = 100;
        paramInt1 = 3;
      }
      for (;;)
      {
        i = 0;
        j = paramInt1;
        k = paramInt2;
        break;
        paramInt1 = 0;
        paramInt2 = 0;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage == null) {
        break;
      }
      i = paramInt2;
      j = paramInt4;
      k = paramInt6;
      if (paramEmoticonPackage.status != 2) {
        break;
      }
      if (b(paramString, true, true))
      {
        paramInt2 = 100;
        paramInt1 = 3;
      }
      for (;;)
      {
        i = 0;
        j = paramInt1;
        k = paramInt2;
        break;
        paramInt1 = 0;
        paramInt2 = 0;
      }
      paramInt1 = paramInt2;
      m = paramInt4;
      n = paramInt6;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getPackageStatus| query result in running... result=" + paramInt2 + " status=" + paramInt4 + " progress=" + paramInt6);
        n = paramInt6;
        m = paramInt4;
        paramInt1 = paramInt2;
      }
      paramInt4 = n;
      paramInt2 = m;
    }
  }
  
  public static arfl a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      paramAppRuntime = (areb)paramAppRuntime.getManager(43);
      if (paramAppRuntime != null) {
        return (arfl)paramAppRuntime.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    }
    return null;
  }
  
  /* Error */
  private Emoticon a(Emoticon paramEmoticon)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 250	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 61	areb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: bipush 14
    //   11: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14: checkcast 252	avsq
    //   17: astore 4
    //   19: aload 4
    //   21: aload_3
    //   22: invokevirtual 255	avsq:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   25: astore 5
    //   27: aload 4
    //   29: aload_3
    //   30: aload_1
    //   31: getfield 258	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   34: invokevirtual 261	avsq:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/Emoticon;
    //   37: astore_2
    //   38: aload 5
    //   40: ifnull +7 -> 47
    //   43: aload_2
    //   44: ifnonnull +124 -> 168
    //   47: new 4	java/lang/Object
    //   50: dup
    //   51: invokespecial 59	java/lang/Object:<init>	()V
    //   54: astore_2
    //   55: new 263	areg
    //   58: dup
    //   59: aload_0
    //   60: aload_3
    //   61: aload_2
    //   62: invokespecial 266	areg:<init>	(Lareb;Ljava/lang/String;Ljava/lang/Object;)V
    //   65: astore 5
    //   67: invokestatic 126	area:a	()Larea;
    //   70: aload 5
    //   72: invokevirtual 269	area:a	(Larep;)V
    //   75: aload_0
    //   76: aload_3
    //   77: getstatic 48	areb:jdField_c_of_type_Int	I
    //   80: invokevirtual 271	areb:a	(Ljava/lang/String;I)V
    //   83: aload_2
    //   84: monitorenter
    //   85: aload_2
    //   86: ldc2_w 272
    //   89: invokevirtual 277	java/lang/Object:wait	(J)V
    //   92: aload_2
    //   93: monitorexit
    //   94: invokestatic 126	area:a	()Larea;
    //   97: aload 5
    //   99: invokevirtual 279	area:b	(Larep;)V
    //   102: aload 4
    //   104: aload_3
    //   105: invokevirtual 255	avsq:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   108: astore 5
    //   110: aload 4
    //   112: aload_3
    //   113: aload_1
    //   114: getfield 258	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   117: invokevirtual 261	avsq:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/Emoticon;
    //   120: astore_2
    //   121: aload 5
    //   123: ifnull +9 -> 132
    //   126: aload_2
    //   127: astore_1
    //   128: aload_2
    //   129: ifnonnull +41 -> 170
    //   132: getstatic 41	areb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   135: iconst_1
    //   136: new 137	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 281
    //   146: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_3
    //   150: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: areturn
    //   163: astore_1
    //   164: aload_2
    //   165: monitorexit
    //   166: aload_1
    //   167: athrow
    //   168: aload_2
    //   169: astore_1
    //   170: aload_1
    //   171: getfield 286	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   174: ifeq +21 -> 195
    //   177: aload_1
    //   178: getfield 286	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   181: iconst_2
    //   182: if_icmpeq +13 -> 195
    //   185: aload_1
    //   186: astore_2
    //   187: aload_1
    //   188: getfield 286	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   191: iconst_4
    //   192: if_icmpne -31 -> 161
    //   195: aload_1
    //   196: astore_2
    //   197: aload_1
    //   198: invokevirtual 289	com/tencent/mobileqq/data/Emoticon:hasEncryptKey	()Z
    //   201: ifne -40 -> 161
    //   204: new 291	java/util/ArrayList
    //   207: dup
    //   208: iconst_1
    //   209: invokespecial 292	java/util/ArrayList:<init>	(I)V
    //   212: astore_2
    //   213: aload_2
    //   214: aload_1
    //   215: invokevirtual 296	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   218: pop
    //   219: new 298	arfb
    //   222: dup
    //   223: invokespecial 299	arfb:<init>	()V
    //   226: astore 4
    //   228: aload_0
    //   229: aload_3
    //   230: aload_2
    //   231: aload 4
    //   233: invokevirtual 302	areb:a	(Ljava/lang/String;Ljava/util/ArrayList;Larfb;)V
    //   236: aload_1
    //   237: astore_2
    //   238: aload 4
    //   240: getfield 304	arfb:jdField_a_of_type_Boolean	Z
    //   243: ifne -82 -> 161
    //   246: getstatic 41	areb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   249: iconst_1
    //   250: new 137	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   257: ldc_w 306
    //   260: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_3
    //   264: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc_w 308
    //   270: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_1
    //   274: getfield 258	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   277: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aconst_null
    //   287: areturn
    //   288: astore 6
    //   290: goto -198 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	areb
    //   0	293	1	paramEmoticon	Emoticon
    //   37	201	2	localObject1	Object
    //   4	260	3	str	String
    //   17	222	4	localObject2	Object
    //   25	97	5	localObject3	Object
    //   288	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   85	92	163	finally
    //   92	94	163	finally
    //   164	166	163	finally
    //   85	92	288	java/lang/InterruptedException
  }
  
  private void a(EmoticonPackage arg1, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, Emoticon paramEmoticon, String[] paramArrayOfString)
  {
    boolean bool;
    if (???.rscType == 1)
    {
      if (!avlc.a(EmoticonUtils.pngFramePath.replace("[epId]", paramEmoticon.epId))) {
        break label154;
      }
      bool = true;
    }
    for (;;)
    {
      if (!bool)
      {
        paramList.add(paramArrayOfString[0]);
        paramMap.put(paramArrayOfString[0], new File(paramArrayOfString[1]));
        if (???.rscType != 1) {
          break label101;
        }
        paramBundle.putInt(paramArrayOfString[0], 16);
      }
      label101:
      while (???.jobType == 1)
      {
        return;
        bool = FileUtils.fileExists(paramArrayOfString[1]);
        break;
      }
      paramBundle.putInt(paramArrayOfString[0], 7);
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramArrayOfString[0], paramEmoticon.encryptKey);
        return;
      }
      label154:
      bool = false;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoResID", paramString2);
    localHashMap.put("emoPackageID", paramString1);
    localHashMap.put("result", paramInt + "");
    paramString1 = StatisticCollector.getInstance(BaseApplication.getContext());
    paramString2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1.collectPerformance(paramString2, "NewAudioEmoticonVoiceDownload", bool, 0L, 0L, localHashMap, null);
      return;
    }
  }
  
  private void a(List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt, Emoticon paramEmoticon)
  {
    if ((paramInt & 0x1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo AIO preview static.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
      }
      String[] arrayOfString = b(paramEmoticon);
      if (!FileUtils.fileExists(arrayOfString[1]))
      {
        paramList.add(arrayOfString[0]);
        paramMap.put(arrayOfString[0], new File(arrayOfString[1]));
        paramList = arrayOfString[0];
        if (paramEmoticon.jobType != 1) {
          break label147;
        }
      }
    }
    label147:
    for (paramInt = 15;; paramInt = 8)
    {
      paramBundle.putInt(paramList, paramInt);
      return;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 2);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramInt2 == 1)) {}
    while (((paramInt1 == 3) && (paramInt2 == 3)) || ((paramInt1 == 4) && (paramInt2 == 5)) || ((paramInt1 == 5) && (paramInt2 == 4)) || ((paramInt1 == 1) && (paramInt2 == 0))) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    paramFile = FileUtils.readFileContent(paramFile);
    int j;
    int i;
    if (paramFile != null)
    {
      paramFile = paramFile.split("&");
      j = paramFile.length;
      i = 0;
      if (i < j)
      {
        String str = paramFile[i];
        if (new File(paramString3 + paramString2 + File.separator + str).exists()) {}
      }
    }
    label234:
    do
    {
      do
      {
        return false;
        i += 1;
        break;
        paramString2 = new File(paramString3 + "audio" + File.separator + "audio.ini");
      } while (!paramString2.exists());
      paramString2 = FileUtils.readFileContent(paramString2);
      if (paramString2 != null)
      {
        paramString2 = paramString2.split("&");
        j = paramString2.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label234;
          }
          paramFile = paramString2[i];
          if (!new File(paramString3 + "audio" + File.separator + paramFile).exists()) {
            break;
          }
          i += 1;
        }
      }
    } while (!a(paramString1, h));
    return e(paramString1);
  }
  
  public static String[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = EmoticonUtils.smallEmoticonThumbUrl.replace("[epId]", paramString1).replace("[eId]", paramString2);
      paramString1 = EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
    for (paramString2 = str;; paramString2 = str)
    {
      return new String[] { paramString2, paramString1 };
      str = EmoticonUtils.emoticonPreviewUrl.replace("[eIdSub]", paramString2.substring(0, 2)).replace("[eId]", paramString2);
      paramString1 = EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
  }
  
  private void b(List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt, Emoticon paramEmoticon)
  {
    if ((paramEmoticon.isSound) && ((paramInt & 0x8) == 8))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo sound.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
      }
      String[] arrayOfString = a(paramEmoticon);
      if (!FileUtils.fileExists(arrayOfString[1]))
      {
        paramList.add(arrayOfString[0]);
        paramMap.put(arrayOfString[0], new File(arrayOfString[1]));
        paramBundle.putInt(arrayOfString[0], 9);
        if (paramEmoticon.isNewSoundEmoticon()) {
          paramBundle.putString(arrayOfString[0] + "emoticonId", paramEmoticon.eId);
        }
      }
    }
  }
  
  private boolean c(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramInt & 0x2) == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo imgPreview.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis() + ",jobType:" + paramEmoticon.jobType);
      }
      Object localObject = c(paramEmoticon);
      bool1 = bool2;
      if (!FileUtils.fileExists(localObject[1]))
      {
        localObject = new bgoe(localObject[0], new File(localObject[1]));
        ((bgoe)localObject).n = true;
        ((bgoe)localObject).jdField_e_of_type_Int = jdField_b_of_type_Int;
        paramInt = bgog.a((bgoe)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramInt == 0) {
          break label294;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "task preview down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
        bggr.a("emotionType", "emotionActionAIO", "3", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.getNetworkType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
        bool1 = true;
      }
    }
    label294:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ret:" + paramInt);
    return false;
  }
  
  private boolean d(Emoticon paramEmoticon)
  {
    if (bftf.a())
    {
      if (bftf.b() < 1048576L)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "sdcard check, sdcard full .return.");
        bggr.a("emotionType", "emotionActionAIO", "1", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
        return true;
      }
    }
    else
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "sdcard check, has sdcard FALSE .return.");
      bggr.a("emotionType", "emotionActionAIO", "2", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
      return true;
    }
    return false;
  }
  
  private boolean d(Emoticon paramEmoticon, int paramInt)
  {
    File localFile = null;
    boolean bool2 = false;
    boolean bool1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramInt & 0x4) != 4)
    {
      bool1 = bool2;
      if ((paramInt & 0x20) != 32) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo gif.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
      }
      if (paramEmoticon.jobType == 1) {
        break label1079;
      }
      if ((paramInt & 0x20) != 32) {
        break label1074;
      }
      paramInt = 2;
      localObject1 = a(paramEmoticon, paramInt);
      localObject2 = new arfb();
      if ((paramEmoticon.jobType == 3) || (!TextUtils.isEmpty(paramEmoticon.encryptKey))) {
        break label280;
      }
      localObject3 = new ArrayList();
      ((ArrayList)localObject3).add(paramEmoticon);
      a(paramEmoticon.epId, (ArrayList)localObject3, (arfb)localObject2);
      if (!TextUtils.isEmpty(paramEmoticon.encryptKey)) {
        break label280;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "Emoticon don't have encryptKey,epId=" + paramEmoticon.epId + ", eid=" + paramEmoticon.eId + " type=" + 4);
      bggr.a("emotionType", "emotionActionAIO", "4", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
      bool1 = true;
    }
    return bool1;
    for (;;)
    {
      label280:
      if (localObject1 == null) {
        return true;
      }
      boolean bool3 = FileUtils.fileExists(localObject1[1]);
      if (!bool3)
      {
        localFile = new File(localObject1[1]);
        localObject1 = new bgoe(localObject1[0], localFile);
        ((bgoe)localObject1).n = true;
        ((bgoe)localObject1).jdField_e_of_type_Int = jdField_b_of_type_Int;
        paramInt = bgog.a((bgoe)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramInt != 0)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "task gif down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ":ret = " + paramInt);
          bggr.a("emotionType", "emotionActionAIO", "5", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.getNetworkType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
          return true;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (bool3) {
          break;
        }
        bool1 = bool2;
        if (paramEmoticon.jobType == 1) {
          break;
        }
        for (;;)
        {
          try
          {
            localObject2 = FileUtils.fileToBytes(localFile);
            localObject3 = localFile.getAbsolutePath();
            localFile.delete();
            if (localObject2 == null)
            {
              QLog.e(jdField_a_of_type_JavaLangString, 1, "task gif 2 fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
              bggr.a("emotionType", "emotionActionAIO", "6", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
              return true;
            }
            if (paramEmoticon.jobType != 3)
            {
              paramInt = aqyy.a((byte[])localObject2, paramEmoticon.encryptKey, (String)localObject3);
              if (paramInt != 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "onProgress download encrypt exception, url=" + ((bgoe)localObject1).c);
                }
                if ((bftf.a()) && (bftf.b() > 1048576L)) {
                  FileUtils.pushData2File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "err" + File.separator + String.valueOf(paramEmoticon.epId) + "_" + paramEmoticon.encryptKey + "_" + localFile.getName()), (byte[])localObject2, false);
                }
                QLog.e(jdField_a_of_type_JavaLangString, 1, "task gif save fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";emosmCode = " + paramInt);
                bggr.a("emotionType", "emotionActionAIO", "7", paramEmoticon.epId, paramEmoticon.eId, "", paramInt + "", "", "", "");
                return true;
              }
            }
            else
            {
              if (paramEmoticon.jobType != 3) {
                break label1063;
              }
              paramInt = aqyy.a((byte[])localObject2, (String)localObject3);
              continue;
            }
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onProgress| Emotiocon encode resource done.result=" + paramInt + " time:" + System.currentTimeMillis() + " url=" + ((bgoe)localObject1).c);
            return false;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onProgress Emotiocon encode resource fail .EXCEPTION:" + localThrowable.toString() + " time:" + System.currentTimeMillis() + " url=" + ((bgoe)localObject1).c);
            }
            bggr.a("emotionType", "emotionActionAIO", "8", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
            return true;
          }
          label1063:
          paramInt = 0;
        }
        localObject1 = null;
      }
      label1074:
      paramInt = 0;
      break;
      label1079:
      localObject1 = null;
    }
  }
  
  private boolean e(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramInt & 0x1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo AIO preview static.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
      }
      Object localObject = b(paramEmoticon);
      bool1 = bool2;
      if (!FileUtils.fileExists(localObject[1]))
      {
        localObject = new bgoe(localObject[0], new File(localObject[1]));
        ((bgoe)localObject).n = true;
        ((bgoe)localObject).jdField_e_of_type_Int = jdField_b_of_type_Int;
        paramInt = bgog.a((bgoe)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        bool1 = bool2;
        if (paramInt != 0)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "task aio static down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";ret = " + paramInt);
          bggr.a("emotionType", "emotionActionAIO", "9", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.getNetworkType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean f(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramEmoticon.isSound)
    {
      bool1 = bool2;
      if ((paramInt & 0x8) == 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo sound.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        Object localObject = a(paramEmoticon);
        bool1 = bool2;
        if (!FileUtils.fileExists(localObject[1]))
        {
          localObject = new bgoe(localObject[0], new File(localObject[1]));
          ((bgoe)localObject).n = true;
          ((bgoe)localObject).jdField_e_of_type_Int = jdField_b_of_type_Int;
          paramInt = bgog.a((bgoe)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (paramInt == 0) {
            break label327;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 1, "task sound down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";ret = " + paramInt);
          bggr.a("emotionType", "emotionActionAIO", "10", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.getNetworkType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
          if (paramEmoticon.isNewSoundEmoticon()) {
            a(paramEmoticon.epId, paramEmoticon.eId, ((bgoe)localObject).jdField_a_of_type_Int);
          }
          bool1 = false;
        }
      }
    }
    label327:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!paramEmoticon.isNewSoundEmoticon());
    a(paramEmoticon.epId, paramEmoticon.eId, 0);
    return true;
  }
  
  private boolean g(String paramString)
  {
    ??? = null;
    try
    {
      synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
      {
        if (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.containsKey(paramString)) {
          ??? = (ArrayList)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
        }
        ??? = ???;
        if (??? != null) {
          break label222;
        }
        ??? = new File(EmoticonUtils.H5MagicFileListPath.replace("[epId]", paramString));
        boolean bool = ((File)???).exists();
        if (!bool) {
          return false;
        }
      }
      ??? = new JSONObject(FileUtils.readFileToString((File)???));
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, error=" + MsfSdkUtils.getStackTraceString(paramString));
      }
      return false;
    }
    ??? = new ArrayList();
    ??? = ((JSONObject)???).getJSONArray("fileList");
    int j = ((JSONArray)???).length();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = ((JSONArray)???).getString(i);
        if (!TextUtils.isEmpty(str)) {
          ((ArrayList)???).add(str);
        }
      }
      else
      {
        synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
        {
          this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString, ???);
          label222:
          if (??? != null)
          {
            paramString = ((ArrayList)???).iterator();
            while (paramString.hasNext())
            {
              ??? = new File((String)paramString.next());
              if ((??? != null) && (!((File)???).exists()))
              {
                if (QLog.isColorLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, file miss: " + ???);
                }
                return false;
              }
            }
          }
        }
        return true;
      }
      i += 1;
    }
  }
  
  public float a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return -1.0F;
    }
    paramString = (arfl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {
      return paramString.a();
    }
    return -1.0F;
  }
  
  public int a(Emoticon paramEmoticon)
  {
    paramEmoticon = a(paramEmoticon);
    if (paramEmoticon == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "collectEmoji fail to download Emoticon");
      return -1;
    }
    return agif.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticon, null);
  }
  
  int a(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      Emoticon localEmoticon = (Emoticon)paramArrayList.get(i);
      Object localObject;
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = c(localEmoticon);
        if (!FileUtils.fileExists(localObject[1]))
        {
          paramList.add(localObject[0]);
          paramMap.put(localObject[0], new File(localObject[1]));
          localObject = localObject[0];
          if (localEmoticon.jobType != 1) {
            break label385;
          }
        }
      }
      label385:
      for (int j = 15;; j = 6)
      {
        paramBundle.putInt((String)localObject, j);
        if (((paramInt & 0x4) != 4) && ((paramInt & 0x20) != 32)) {
          break label410;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = null;
        if (paramEmoticonPackage.jobType != 1)
        {
          if (!localEmoticon.hasEncryptKey()) {
            break;
          }
          j = paramEmoticonPackage.rscType;
          if ((paramInt & 0x20) == 32) {
            j = 2;
          }
          localObject = a(localEmoticon, j);
        }
        if (localObject != null) {
          break label396;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fail Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId);
        }
        return 11030;
      }
      return 11009;
      label396:
      a(paramEmoticonPackage, paramList, paramMap, paramBundle, localEmoticon, (String[])localObject);
      label410:
      a(paramList, paramMap, paramBundle, paramInt, localEmoticon);
      b(paramList, paramMap, paramBundle, paramInt, localEmoticon);
      i += 1;
    }
    return 0;
  }
  
  int a(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (Emoticon)paramArrayList.get(i);
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + ((Emoticon)localObject).epId + " eid=" + ((Emoticon)localObject).eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        String[] arrayOfString = c((Emoticon)localObject);
        if ((!FileUtils.fileExists(arrayOfString[1])) || (paramBoolean))
        {
          paramList.add(arrayOfString[0]);
          paramMap.put(arrayOfString[0], new File(arrayOfString[1]));
          paramBundle.putInt(arrayOfString[0], 6);
        }
      }
      if (((paramInt & 0x4) == 4) || ((paramInt & 0x20) == 32))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + ((Emoticon)localObject).epId + " eid=" + ((Emoticon)localObject).eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = a((Emoticon)localObject, paramEmoticonPackage.rscType);
        if ((!FileUtils.fileExists(localObject[1])) || (paramBoolean)) {
          paramList.add(localObject[0]);
        }
        paramMap.put(localObject[0], new File(localObject[1]));
        paramBundle.putInt(localObject[0], 7);
      }
      i += 1;
    }
    return 0;
  }
  
  int a(File paramFile, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    arfb localarfb = new arfb();
    byte[] arrayOfByte = null;
    if (paramFile != null) {}
    label521:
    for (;;)
    {
      try
      {
        if (paramFile.exists())
        {
          arrayOfByte = FileUtils.fileToBytes(paramFile);
          if (paramEmoticonPackage.jobType == 4)
          {
            paramFile = areq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_c_of_type_Int, arrayOfByte, localArrayList);
            if (paramEmoticonPackage.isAPNG != 2) {
              break label521;
            }
            paramInt |= 0x20;
            if (paramFile == null) {
              continue;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 1, "addEmotionsTask| parse json error");
            bggr.a("emotionType", "emotionActionDownload", "4", paramEmoticonPackage.epId, "", "", paramFile, "", "", "");
            return 11008;
          }
        }
        else
        {
          arrayOfByte = null;
          continue;
        }
      }
      catch (OutOfMemoryError paramFile)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "OutOfMemoryError e = " + paramFile.getMessage());
        arrayOfByte = null;
        continue;
        paramFile = areq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_c_of_type_Int, arrayOfByte, localArrayList, localarfb);
        continue;
        if ((!TextUtils.isEmpty(paramEmoticonPackage.minQQVersion)) && (!bges.a(paramEmoticonPackage.minQQVersion, "8.4.8")))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "unavailable in current version, min version=" + paramEmoticonPackage.minQQVersion);
          return 11011;
        }
        paramBundle.putBoolean("isUpdate", paramBoolean);
        paramBundle.putSerializable("emoticonList", localArrayList);
        if ((!localarfb.jdField_a_of_type_Boolean) && (paramEmoticonPackage.jobType != 4))
        {
          int i = 0;
          localarfb.jdField_a_of_type_JavaLangString = null;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i);
          }
          a(paramEmoticonPackage.epId, localArrayList, localarfb);
          int j = i + 1;
          if (!localarfb.jdField_a_of_type_Boolean)
          {
            i = j;
            if (j < 3) {
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + j + " encryptKeysSuccess=" + localarfb.jdField_a_of_type_Boolean);
          }
          if (!localarfb.jdField_a_of_type_Boolean)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "addEmoticonsTask| fetchEncryptKeys fail epId=" + paramEmoticonPackage.epId + " encryptGetKeySeq=" + localarfb.jdField_a_of_type_JavaLangString + " encryptKeysResultCode" + localarfb.jdField_a_of_type_Int);
            return 11009;
          }
        }
        if (paramEmoticonPackage.jobType == 4) {
          return a(paramEmoticonPackage, localArrayList, paramList, paramMap, paramBundle, paramInt, paramBoolean);
        }
        return a(paramEmoticonPackage, localArrayList, paramList, paramMap, paramBundle, paramInt);
      }
    }
  }
  
  public Bundle a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ArrayList)a().a(paramInt);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (localEmoticonPackage.jobType == 0) {
          localArrayList.add(a(localEmoticonPackage.epId, 1, paramInt));
        } else if (localEmoticonPackage.jobType == 3) {
          localArrayList.add(a(localEmoticonPackage.epId, 3, paramInt));
        } else if (localEmoticonPackage.jobType == 5) {
          localArrayList.add(a(localEmoticonPackage.epId, 4, paramInt));
        } else if (localEmoticonPackage.jobType == 4) {
          localArrayList.add(a(localEmoticonPackage.epId, 5, paramInt));
        }
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelableArrayList("pkgStatusList", localArrayList);
    return localObject;
  }
  
  public Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    String str = String.valueOf(paramBundle.getInt("id"));
    int i = paramBundle.getInt("businessType");
    int j = paramBundle.getInt("sceneType");
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str) != null)
    {
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      localBundle.putInt("sceneType", j);
      return localBundle;
    }
    paramBundle = a().c(str, -1);
    if ((paramBundle != null) && (paramBundle.status != 0))
    {
      switch (paramBundle.status)
      {
      default: 
        i = 1;
      }
      for (;;)
      {
        if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_detail", 0, 0, paramBundle.epId, "" + paramBundle.localVersion, "" + paramBundle.latestVersion, "");
        }
        localBundle.putInt("result", i);
        localBundle.putString("messge", "");
        localBundle.putInt("sceneType", j);
        return localBundle;
        a(paramBundle, true, j);
        i = 0;
        continue;
        i = 4;
      }
    }
    Object localObject = a().a(str, -1);
    paramBundle = (Bundle)localObject;
    if (localObject != null)
    {
      paramBundle = (Bundle)localObject;
      if (!a(i, ((EmoticonPackage)localObject).jobType))
      {
        a().a((EmoticonPackage)localObject);
        paramBundle = null;
      }
    }
    localObject = paramBundle;
    if (paramBundle == null)
    {
      localObject = new EmoticonPackage();
      ((EmoticonPackage)localObject).epId = str;
      ((EmoticonPackage)localObject).wordingId = -1L;
      if (i != 2) {
        break label416;
      }
      ((EmoticonPackage)localObject).jobType = 1;
    }
    for (;;)
    {
      ((EmoticonPackage)localObject).isMagicFaceDownloading = false;
      if (i == 4) {
        ((EmoticonPackage)localObject).jobType = 5;
      }
      a((EmoticonPackage)localObject, true, j);
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      localBundle.putInt("sceneType", j);
      return localBundle;
      label416:
      if (i == 3) {
        ((EmoticonPackage)localObject).jobType = 3;
      } else if (i == 4) {
        ((EmoticonPackage)localObject).jobType = 5;
      } else if (i == 5) {
        ((EmoticonPackage)localObject).jobType = 4;
      } else {
        ((EmoticonPackage)localObject).jobType = 0;
      }
    }
  }
  
  public Bundle a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    paramString = (arfl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = paramString.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localBundle != null)
      {
        paramString = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
        if (paramString != null) {
          jdField_a_of_type_Area.a(paramString, 11007, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    }
    paramString = new Bundle();
    paramString.putInt("result", 0);
    paramString.putString("messge", "");
    paramString.putInt("sceneType", paramInt);
    return paramString;
  }
  
  Bundle a(String paramString, int paramInt1, int paramInt2)
  {
    int m = -1;
    int i = 0;
    int n = 0;
    int i1 = 0;
    EmoticonPackage localEmoticonPackage = a().c(paramString, paramInt2);
    paramInt2 = i;
    if (localEmoticonPackage != null) {
      if (!localEmoticonPackage.valid) {
        break label133;
      }
    }
    label133:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if (paramInt1 == 2) {
        paramInt2 = 1;
      }
      arfl localarfl = (arfl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      int k = m;
      int j = n;
      i = i1;
      if (localarfl != null)
      {
        k = m;
        j = n;
        i = i1;
        if (!localarfl.a())
        {
          k = 0;
          i = (int)localarfl.a();
          j = 2;
        }
      }
      return a(paramString, paramInt1, k, paramInt2, j, 0, 0L, i, -1, null, null, localEmoticonPackage);
    }
  }
  
  public avsq a()
  {
    return (avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
  }
  
  public bgoj a()
  {
    return ((bgog)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
  }
  
  public void a(Bundle paramBundle, Object paramObject, boolean paramBoolean, int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    boolean bool1 = paramBundle.getBoolean("newPkgAdd", false);
    boolean bool2 = paramBundle.getBoolean("isUpdate", false);
    boolean bool3 = paramBundle.getBoolean("wifiAutoDownload", true);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramBundle.getSerializable("emoticonPackage");
    if (localEmoticonPackage == null) {
      return;
    }
    int i;
    if ((localEmoticonPackage.jobType == 3) || (localEmoticonPackage.jobType == 5))
    {
      i = 1;
      label69:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onDone:epId=" + localEmoticonPackage.epId + " task:" + paramObject + " localVersion=" + localEmoticonPackage.localVersion + ",latestVersion=" + localEmoticonPackage.latestVersion + ",updateFlag=" + localEmoticonPackage.updateFlag);
      }
      if (!paramBoolean) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          paramInt2 = aqyy.a(paramInt1);
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handleEmoticonPackageDownloaded : download error ,reportCode = " + paramInt1);
          jdField_a_of_type_Area.a(localEmoticonPackage, paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          bggr.a("emotionType", "emotionActionDownload", "11", localEmoticonPackage.epId, "", "", paramInt1 + "", "", "", "");
          a(localEmoticonPackage, paramInt2, 0L, paramString);
          if (!bool1) {
            break;
          }
          if (localEmoticonPackage.type != 1) {
            break label322;
          }
          paramInt1 = 5;
          avsq.c(String.valueOf(paramInt2), paramInt1);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handleEmoticonPackageDownloaded failed", paramBundle);
          return;
        }
        i = 0;
        break label69;
        label322:
        paramInt1 = 4;
      }
    }
    if ((bool2) && (i == 0))
    {
      paramBundle = (ArrayList)paramBundle.getSerializable("emoticonList");
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        a().a(localEmoticonPackage.epId, paramBundle);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "update package:" + localEmoticonPackage.epId + ",newEmoticons:" + paramBundle.size());
        }
      }
    }
    for (;;)
    {
      localEmoticonPackage.updateFlag &= 0xFFFFFFFE;
      localEmoticonPackage.status = 2;
      localEmoticonPackage.valid = true;
      paramBundle = a();
      paramBundle.a(localEmoticonPackage);
      if (localEmoticonPackage.jobType != 5) {
        break label603;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      Object localObject = paramObject.query(EmoticonPackage.class, true, "childEpId=?", new String[] { localEmoticonPackage.epId }, null, null, null, null);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        b(((EmoticonPackage)((Iterator)localObject).next()).epId, true, true);
      }
      if (localEmoticonPackage.latestVersion > localEmoticonPackage.localVersion) {
        localEmoticonPackage.localVersion = localEmoticonPackage.latestVersion;
      }
      localEmoticonPackage.hasReadUpdatePage = false;
    }
    paramObject.close();
    label603:
    if (bool1) {}
    try
    {
      paramBundle.h(localEmoticonPackage.epId, paramInt2);
      jdField_a_of_type_Area.a(localEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!bool3) {
        localEmoticonPackage.extraFlags |= 0x2;
      }
      jdField_a_of_type_Area.d(localEmoticonPackage);
      a(localEmoticonPackage, 0, paramLong, paramString);
      return;
    }
    finally {}
  }
  
  /* Error */
  void a(bgoe parambgoe)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokevirtual 998	bgoe:a	()Landroid/os/Bundle;
    //   9: ldc_w 890
    //   12: invokevirtual 894	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   15: checkcast 200	com/tencent/mobileqq/data/EmoticonPackage
    //   18: astore 6
    //   20: aload_1
    //   21: getfield 999	bgoe:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   24: aload_1
    //   25: getfield 587	bgoe:c	Ljava/lang/String;
    //   28: invokeinterface 1000 2 0
    //   33: checkcast 335	java/io/File
    //   36: astore 7
    //   38: aload_0
    //   39: getfield 66	areb:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   42: aload_1
    //   43: getfield 587	bgoe:c	Ljava/lang/String;
    //   46: invokeinterface 1001 2 0
    //   51: ifeq +603 -> 654
    //   54: aload_0
    //   55: getfield 66	areb:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   58: astore 4
    //   60: aload 4
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 66	areb:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   67: aload_1
    //   68: getfield 587	bgoe:c	Ljava/lang/String;
    //   71: invokeinterface 1000 2 0
    //   76: checkcast 323	java/lang/String
    //   79: astore_3
    //   80: aload_0
    //   81: getfield 66	areb:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   84: aload_1
    //   85: getfield 587	bgoe:c	Ljava/lang/String;
    //   88: invokeinterface 1004 2 0
    //   93: pop
    //   94: aload 4
    //   96: monitorexit
    //   97: aload 7
    //   99: ifnull +546 -> 645
    //   102: aload 7
    //   104: invokestatic 568	com/tencent/mobileqq/utils/FileUtils:fileToBytes	(Ljava/io/File;)[B
    //   107: astore 5
    //   109: aload 7
    //   111: invokevirtual 571	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   114: astore 4
    //   116: aload 7
    //   118: invokevirtual 574	java/io/File:delete	()Z
    //   121: pop
    //   122: goto +537 -> 659
    //   125: aload_1
    //   126: iconst_1
    //   127: putfield 1005	bgoe:jdField_a_of_type_Boolean	Z
    //   130: getstatic 41	areb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   133: iconst_1
    //   134: ldc_w 1007
    //   137: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: getstatic 128	areb:jdField_a_of_type_Area	Larea;
    //   143: aload 6
    //   145: sipush 11013
    //   148: aload_0
    //   149: getfield 61	areb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   152: invokevirtual 897	area:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   155: ldc_w 498
    //   158: ldc_w 760
    //   161: ldc_w 578
    //   164: aload 6
    //   166: getfield 761	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   169: ldc_w 361
    //   172: ldc_w 361
    //   175: ldc_w 361
    //   178: ldc_w 361
    //   181: ldc_w 361
    //   184: ldc_w 361
    //   187: invokestatic 516	bggr:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   190: return
    //   191: astore_3
    //   192: aload_3
    //   193: invokevirtual 628	java/lang/Throwable:printStackTrace	()V
    //   196: getstatic 41	areb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   199: iconst_2
    //   200: new 137	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 1009
    //   210: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_3
    //   214: invokevirtual 631	java/lang/Throwable:toString	()Ljava/lang/String;
    //   217: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 465
    //   223: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokestatic 471	java/lang/System:currentTimeMillis	()J
    //   229: invokevirtual 474	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   232: ldc_w 625
    //   235: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_1
    //   239: getfield 587	bgoe:c	Ljava/lang/String;
    //   242: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_1
    //   252: iconst_1
    //   253: putfield 1005	bgoe:jdField_a_of_type_Boolean	Z
    //   256: getstatic 128	areb:jdField_a_of_type_Area	Larea;
    //   259: aload 6
    //   261: sipush 11020
    //   264: aload_0
    //   265: getfield 61	areb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   268: invokevirtual 897	area:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   271: ldc_w 498
    //   274: ldc_w 760
    //   277: ldc_w 641
    //   280: aload 6
    //   282: getfield 761	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   285: ldc_w 361
    //   288: ldc_w 361
    //   291: ldc_w 361
    //   294: ldc_w 361
    //   297: ldc_w 361
    //   300: ldc_w 361
    //   303: invokestatic 516	bggr:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   306: return
    //   307: astore_3
    //   308: aload 4
    //   310: monitorexit
    //   311: aload_3
    //   312: athrow
    //   313: aload 6
    //   315: getfield 350	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   318: iconst_4
    //   319: if_icmpeq +73 -> 392
    //   322: aload_3
    //   323: ifnonnull +69 -> 392
    //   326: aload_1
    //   327: iconst_1
    //   328: putfield 1005	bgoe:jdField_a_of_type_Boolean	Z
    //   331: getstatic 41	areb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   334: iconst_1
    //   335: ldc_w 1011
    //   338: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: getstatic 128	areb:jdField_a_of_type_Area	Larea;
    //   344: aload 6
    //   346: sipush 11009
    //   349: aload_0
    //   350: getfield 61	areb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   353: invokevirtual 897	area:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   356: ldc_w 498
    //   359: ldc_w 760
    //   362: ldc_w 618
    //   365: aload 6
    //   367: getfield 761	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   370: ldc_w 361
    //   373: ldc_w 361
    //   376: ldc_w 361
    //   379: ldc_w 361
    //   382: ldc_w 361
    //   385: ldc_w 361
    //   388: invokestatic 516	bggr:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   391: return
    //   392: aload 6
    //   394: getfield 350	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   397: iconst_4
    //   398: if_icmpne +235 -> 633
    //   401: aload 5
    //   403: aload 4
    //   405: invokestatic 621	aqyy:a	([BLjava/lang/String;)I
    //   408: istore_2
    //   409: iload_2
    //   410: ifeq +164 -> 574
    //   413: getstatic 41	areb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   416: iconst_2
    //   417: new 137	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 1013
    //   427: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_1
    //   431: getfield 587	bgoe:c	Ljava/lang/String;
    //   434: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: ldc_w 498
    //   446: ldc_w 760
    //   449: ldc_w 633
    //   452: aload 6
    //   454: getfield 761	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   457: ldc_w 361
    //   460: ldc_w 361
    //   463: new 137	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   470: iload_2
    //   471: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: ldc_w 361
    //   477: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: ldc_w 361
    //   486: ldc_w 361
    //   489: ldc_w 361
    //   492: invokestatic 516	bggr:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   495: invokestatic 523	bftf:a	()Z
    //   498: ifeq +76 -> 574
    //   501: invokestatic 525	bftf:b	()J
    //   504: ldc2_w 526
    //   507: lcmp
    //   508: ifle +66 -> 574
    //   511: new 137	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   518: getstatic 592	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   521: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc_w 594
    //   527: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: getstatic 418	java/io/File:separator	Ljava/lang/String;
    //   533: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload 6
    //   538: getfield 761	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   541: invokestatic 597	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   544: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: ldc_w 599
    //   550: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 7
    //   555: invokevirtual 602	java/io/File:getName	()Ljava/lang/String;
    //   558: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 608	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   567: aload 5
    //   569: iconst_0
    //   570: invokestatic 612	com/tencent/mobileqq/utils/FileUtils:pushData2File	(Ljava/lang/String;[BZ)Z
    //   573: pop
    //   574: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq -573 -> 4
    //   580: getstatic 41	areb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   583: iconst_2
    //   584: new 137	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 1015
    //   594: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: iload_2
    //   598: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: ldc_w 465
    //   604: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokestatic 471	java/lang/System:currentTimeMillis	()J
    //   610: invokevirtual 474	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   613: ldc_w 625
    //   616: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload_1
    //   620: getfield 587	bgoe:c	Ljava/lang/String;
    //   623: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: return
    //   633: aload 5
    //   635: aload_3
    //   636: aload 4
    //   638: invokestatic 583	aqyy:a	([BLjava/lang/String;Ljava/lang/String;)I
    //   641: istore_2
    //   642: goto -233 -> 409
    //   645: aconst_null
    //   646: astore 4
    //   648: aconst_null
    //   649: astore 5
    //   651: goto +8 -> 659
    //   654: aconst_null
    //   655: astore_3
    //   656: goto -559 -> 97
    //   659: aload 5
    //   661: ifnull -536 -> 125
    //   664: aload 4
    //   666: ifnonnull -353 -> 313
    //   669: goto -544 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	672	0	this	areb
    //   0	672	1	parambgoe	bgoe
    //   408	234	2	i	int
    //   79	1	3	str1	String
    //   191	23	3	localThrowable	Throwable
    //   307	329	3	str2	String
    //   655	1	3	localObject1	Object
    //   107	553	5	arrayOfByte	byte[]
    //   18	519	6	localEmoticonPackage	EmoticonPackage
    //   36	518	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   38	63	191	java/lang/Throwable
    //   102	122	191	java/lang/Throwable
    //   125	190	191	java/lang/Throwable
    //   311	313	191	java/lang/Throwable
    //   313	322	191	java/lang/Throwable
    //   326	391	191	java/lang/Throwable
    //   392	409	191	java/lang/Throwable
    //   413	574	191	java/lang/Throwable
    //   574	632	191	java/lang/Throwable
    //   633	642	191	java/lang/Throwable
    //   63	97	307	finally
    //   308	311	307	finally
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    paramEmoticonPackage = new bgoe(localArrayList, localHashMap, "vipEmoticonKey_cover_" + paramEmoticonPackage.epId);
    paramEmoticonPackage.jdField_e_of_type_Long = this.jdField_e_of_type_Int;
    paramEmoticonPackage.n = true;
    a().a(paramEmoticonPackage, this.jdField_b_of_type_Bgod, localBundle);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, long paramLong, String paramString)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "download emoji report actionResult=" + paramInt + ",epId=" + paramEmoticonPackage.epId + ",downloadTime=" + paramLong);
    }
    int i = 0;
    if (paramInt != 0) {
      i = 1;
    }
    paramInt = NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "EMOJI_DOWN", "actEmoPackage", 0, i, paramEmoticonPackage.epId + "", paramInt + "", paramString, String.valueOf(paramLong));
      return;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, bgod parambgod, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "package download epId:" + paramEmoticonPackage.epId);
    }
    if ((paramEmoticonPackage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "ep or mApp = null");
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "netUnSupport epId=" + paramEmoticonPackage.epId);
      jdField_a_of_type_Area.a(paramEmoticonPackage, 11003, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bggr.a("emotionType", "emotionActionDownload", "2", paramEmoticonPackage.epId, "", "", "", "", "", "");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putInt("businessType", paramInt);
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    localBundle.putBoolean("newPkgAdd", paramBoolean1);
    localBundle.putBoolean("wifiAutoDownload", paramBoolean2);
    Object localObject1;
    label251:
    Object localObject2;
    label270:
    label372:
    File localFile;
    if ((paramEmoticonPackage.jobType == 3) && (paramEmoticonPackage.isMagicFaceDownloading))
    {
      localObject1 = "vipEmoticonKey_auto_" + paramEmoticonPackage.epId;
      if (paramEmoticonPackage.jobType == 3)
      {
        e(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        localObject2 = new bgoe(localArrayList, localHashMap, (String)localObject1);
        if (!((String)localObject1).contains("auto")) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEmoticonPackage.epId, new arfl(paramEmoticonPackage.epId, (bgoe)localObject2));
        }
        ((bgoe)localObject2).n = true;
        if (localArrayList.size() != 0) {
          break label998;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| urlList is empty");
        }
        ((bgoe)localObject2).a(localBundle);
        ((bgoe)localObject2).a(3);
        parambgod.onDone((bgoe)localObject2);
        if (paramEmoticonPackage.jobType != 5) {
          break label1029;
        }
        b(paramEmoticonPackage, paramBoolean1);
      }
    }
    else
    {
      if (paramEmoticonPackage.jobType == 5)
      {
        ((bgga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.a(paramEmoticonPackage, paramBoolean1, paramBoolean2);
        return;
      }
      localObject2 = "vipEmoticonKey_" + paramEmoticonPackage.epId;
      localObject1 = aqyy.a(paramEmoticonPackage.epId);
      if (paramEmoticonPackage.jobType == 4) {
        localObject1 = EmoticonUtils.smallEmoticonJsonUrl.replace("[epId]", paramEmoticonPackage.epId);
      }
      localFile = new File(EmoticonUtils.emoticonJsonFilePath.replace("[epId]", paramEmoticonPackage.epId));
      localObject1 = new bgoe((String)localObject1, localFile);
      arfl localarfl = new arfl(paramEmoticonPackage.epId, (bgoe)localObject1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(jdField_b_of_type_JavaLangString + paramEmoticonPackage.epId, localarfl);
      ((bgoe)localObject1).g = jdField_b_of_type_Boolean;
      ((bgoe)localObject1).j = true;
      ((bgoe)localObject1).n = true;
      paramInt = bgog.a((bgoe)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(jdField_b_of_type_JavaLangString + paramEmoticonPackage.epId);
      jdField_a_of_type_Area.a(paramEmoticonPackage, paramInt);
      if (paramInt != 0)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "json download faile : resultCode = " + paramInt);
        paramInt = aqyy.a(paramInt);
        jdField_a_of_type_Area.a(paramEmoticonPackage, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        bggr.a("emotionType", "emotionActionDownload", "3", paramEmoticonPackage.epId, "", NetworkUtil.getNetworkType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
        return;
      }
      paramBoolean2 = EmoticonUtils.emoticonPkgNeedUpdate(paramEmoticonPackage);
      if (((paramEmoticonPackage.jobType == 0) || (paramEmoticonPackage.jobType == 4)) && (!paramBoolean2)) {
        a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      }
      b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      if (paramEmoticonPackage.isAPNG == 2)
      {
        paramInt = 42;
        label822:
        if (paramEmoticonPackage.jobType != 5) {
          break label959;
        }
        paramInt = 6;
      }
    }
    label1029:
    label1038:
    for (;;)
    {
      paramInt = a(localFile, paramEmoticonPackage, paramBoolean2, localArrayList, localHashMap, localBundle, paramInt);
      if (paramInt != 0)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleEmotionPackage|addEmotionsTask fail : resultCode = " + paramInt);
        jdField_a_of_type_Area.a(paramEmoticonPackage, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        bggr.a("emotionType", "emotionActionDownload", "5", paramEmoticonPackage.epId, "", "", paramInt + "", "", "", "");
        return;
        paramInt = 14;
        break label822;
        label959:
        if (paramEmoticonPackage.jobType != 3) {
          break label1038;
        }
        paramInt |= 0x1;
        continue;
        if (paramEmoticonPackage.jobType != 5) {
          break label270;
        }
        f(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        break label270;
        label998:
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| startDownload");
        }
        a().a((bgoe)localObject2, parambgod, localBundle);
        break label372;
        break;
      }
      localObject1 = localObject2;
      break label251;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    a(paramEmoticonPackage, paramBoolean, true, 0);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean, int paramInt)
  {
    a(paramEmoticonPackage, paramBoolean, true, paramInt);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramEmoticonPackage == null) || (paramEmoticonPackage.epId == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    Object localObject;
    label136:
    do
    {
      return;
      if (paramInt == 0) {
        paramEmoticonPackage.aio = true;
      }
      arfl localarfl;
      for (;;)
      {
        localObject = (arfl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramEmoticonPackage.epId);
        localarfl = (arfl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(jdField_b_of_type_JavaLangString + paramEmoticonPackage.epId);
        if (localObject == null) {
          break label136;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "pullEmoticonPackage task exist epId = " + paramEmoticonPackage.epId);
        return;
        if (paramInt == 1) {
          paramEmoticonPackage.kandian = true;
        }
      }
      if (localarfl == null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "pullEmoticonPackage jsonTask exist epId = " + paramEmoticonPackage.epId);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "try to pullEmoticonPackage ep:" + paramEmoticonPackage.epId);
    }
    if (!aqyy.a(paramEmoticonPackage.epId))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "ep.epId=" + paramEmoticonPackage.epId + " isNumeral false.");
      bggr.a("emotionType", "emotionActionDownload", "1", paramEmoticonPackage.epId, "", "", "", "", "", "");
      return;
    }
    if (!paramEmoticonPackage.isMagicFaceDownloading) {
      if ((paramEmoticonPackage.status != 2) || (!EmoticonUtils.isEmoticonPkgUpdateBitSet(paramEmoticonPackage.updateFlag))) {
        break label416;
      }
    }
    for (;;)
    {
      paramEmoticonPackage.valid = true;
      a().a(paramEmoticonPackage);
      localObject = new File(AppConstants.SDCARD_EMOTICON_SAVE);
      if (!((File)localObject).exists())
      {
        boolean bool = ((File)localObject).mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "mkdirs success:" + bool);
        }
      }
      ThreadManager.excute(new EmojiManager.5(this, paramEmoticonPackage, paramBoolean1, paramBoolean2, paramInt), 128, null, true);
      return;
      label416:
      paramEmoticonPackage.status = 0;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = (arfl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    } while (paramString == null);
    paramString.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, null, false, 0);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, null, false, paramInt2);
  }
  
  public void a(String paramString, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    a(paramString, paramInt, paramBundle, paramBoolean, 0);
  }
  
  public void a(String paramString, int paramInt1, Bundle paramBundle, boolean paramBoolean, int paramInt2)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageJobQueue.execute(new EmojiManager.4(this, paramBoolean, paramString, paramInt2, paramInt1, paramBundle), 128, true);
  }
  
  public void a(String paramString1, String arg2)
  {
    Object localObject = FileUtils.getChildFiles(???);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
      {
        this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString1, localObject);
        ??? = new JSONArray();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str)) {
            ???.put(str);
          }
        }
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        String str;
        localObject = new JSONObject();
        ((JSONObject)localObject).put("fileList", ???);
        FileUtils.writeFile(EmoticonUtils.H5MagicFileListPath.replace("[epId]", paramString1), ((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "", paramString1);
        return;
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile h5 magic, childFiles is null");
  }
  
  public void a(String paramString, ArrayList<Emoticon> paramArrayList)
  {
    int i = aqyy.a(paramString);
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (i == -1)) {
      return;
    }
    int j = this.f;
    this.f = (j + 1);
    paramString = Integer.toString(j);
    ((amrg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(12)).a(i, paramArrayList, paramString);
  }
  
  public void a(String paramString, ArrayList<Emoticon> paramArrayList, arfb paramarfb)
  {
    int i = aqyy.a(paramString);
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (paramarfb == null) || (i == -1)) {
      return;
    }
    paramString = new Object();
    amrg localamrg = (amrg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(12);
    localamrg.a(new aref(this, localamrg, paramarfb, paramString));
    int j = this.f;
    this.f = (j + 1);
    String str = Integer.toString(j);
    paramarfb.jdField_a_of_type_JavaLangString = str;
    paramarfb.jdField_a_of_type_Int = 11022;
    localamrg.a(i, paramArrayList, str);
    try
    {
      try
      {
        paramString.wait(35000L);
        return;
      }
      finally {}
      return;
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    paramString = a().a(paramString);
    if (paramString != null)
    {
      if (!paramBoolean) {
        break label39;
      }
      if (paramString.status != 2)
      {
        paramString.status = 2;
        a().a(paramString);
      }
    }
    label39:
    while (paramString.status == 0) {
      return;
    }
    paramString.status = 0;
    a().a(paramString);
  }
  
  void a(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    String str1 = paramEmoticonPackage.epId;
    int j;
    int i;
    if (paramEmoticonPackage.jobType == 2)
    {
      str1 = paramEmoticonPackage.kinId;
      j = 13;
      i = 14;
    }
    for (;;)
    {
      String str2 = aqyy.b(j, str1);
      String str3 = aqyy.a(3, paramEmoticonPackage.epId);
      if (!FileUtils.fileExists(str3))
      {
        paramList.add(str2);
        paramMap.put(str2, new File(str3));
        paramBundle.putInt(str2, 3);
      }
      str1 = aqyy.b(i, str1);
      paramEmoticonPackage = aqyy.a(4, paramEmoticonPackage.epId);
      if (!FileUtils.fileExists(paramEmoticonPackage))
      {
        paramList.add(str1);
        paramMap.put(str1, new File(paramEmoticonPackage));
        paramBundle.putInt(str1, 4);
      }
      return;
      if (paramEmoticonPackage.jobType == 4)
      {
        str1 = paramEmoticonPackage.epId;
        j = 17;
        i = 18;
      }
      else
      {
        j = 3;
        i = 4;
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("h5magic_sp_name", 4).getBoolean("h5magic_sp_isplay_key", false);
    boolean bool4 = b();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "canPlayH5Magic isPlay = " + bool3 + ";isDPCSupport = " + bool4);
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (bool4) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(Emoticon paramEmoticon)
  {
    PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localPicEmoticonInfo.type = 6;
    localPicEmoticonInfo.isAPNG = paramEmoticon.isAPNG;
    paramEmoticon = a(paramEmoticon);
    if (paramEmoticon == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "sendEmojiToAio fail to download Emoticon");
      return false;
    }
    localPicEmoticonInfo.emoticon = paramEmoticon;
    agif.a = localPicEmoticonInfo;
    return true;
  }
  
  public boolean a(Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon == null) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon|taskvalue:" + paramInt + "，epid:" + paramEmoticon.epId + "，eid=" + paramEmoticon.eId);
      }
    } while ((d(paramEmoticon)) || (c(paramEmoticon, paramInt)) || (d(paramEmoticon, paramInt)) || (e(paramEmoticon, paramInt)));
    return f(paramEmoticon, paramInt);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = d(paramString);
    a(paramString, bool);
    return bool;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    String str3 = EmoticonUtils.emoticonPackageFolderPath.replace("[epId]", paramString);
    String str1;
    int i;
    if (paramInt == h)
    {
      String str2 = avlx.a();
      str1 = str3 + str2 + File.separator + "video.ini";
      File localFile = new File(str1);
      paramString = localFile;
      if (!localFile.exists())
      {
        str2 = "big";
        str1 = str3 + "big" + File.separator + "video.ini";
        localFile = new File(str1);
        paramString = localFile;
        if (!localFile.exists()) {
          return false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str1);
      }
      paramString = FileUtils.readFileContent(paramString).split("&");
      i = paramString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        str1 = paramString[paramInt];
        if (!new File(str3 + str2 + File.separator + str1).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    if (paramInt == g)
    {
      paramString = new File(str3 + "audio" + File.separator + "audio.ini");
      if (!paramString.exists()) {
        return false;
      }
      paramString = FileUtils.readFileContent(paramString).split("&");
      i = paramString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        str1 = paramString[paramInt];
        if (!new File(str3 + "audio" + File.separator + str1).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    return true;
  }
  
  public boolean a(String paramString, Boolean paramBoolean)
  {
    boolean bool = b(paramString, paramBoolean);
    a(paramString, bool);
    return bool;
  }
  
  boolean a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = (ArrayList)a().a(paramString);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          localObject = (Emoticon)((Iterator)localObject).next();
          if (localObject == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((((Emoticon)localObject).jobType == 4) && ((((Emoticon)localObject).encryptKey == null) || (((Emoticon)localObject).encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, encrypt isn't exist.epId=" + paramString + " eId=" + ((Emoticon)localObject).eId);
            }
            return false;
          }
          if (!new File(EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject).eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, emo img preview do not be exist! epId=" + paramString + " eId=" + ((Emoticon)localObject).eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    Object localObject = new File(EmoticonUtils.H5MagicRootPath.replace("[epId]", paramString));
    if ((localObject != null) && (!((File)localObject).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, no root path: " + localObject);
      }
      return false;
    }
    return g(paramString);
  }
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a().a(paramString) != null) {}
    for (int i = 1;; i = 0) {
      return (i != 0) && (b(paramString, paramBoolean1, paramBoolean2));
    }
  }
  
  String[] a(Emoticon paramEmoticon)
  {
    return new String[] { EmoticonUtils.emoticonSoundUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId), EmoticonUtils.emoticonSoundPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId) };
  }
  
  String[] a(Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon.jobType == 3)
    {
      str1 = EmoticonUtils.smallGifUrl.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      if (paramInt != 2) {}
    }
    boolean bool;
    for (String str1 = EmoticonUtils.smallApngUrl.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);; str1 = EmoticonUtils.emoticonPNGZIPUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId))
    {
      str2 = EmoticonUtils.emoticonEncryptPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      if (paramInt == 2) {
        str2 = EmoticonUtils.emoticonAPNGPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
      paramEmoticon = str2;
      if (1 == paramInt)
      {
        paramEmoticon = str2;
        if (!TextUtils.isEmpty(str2)) {
          paramEmoticon = str2 + ".zip";
        }
      }
      return new String[] { str1, paramEmoticon };
      bool = c(paramEmoticon);
      if (1 != paramInt) {
        break;
      }
    }
    if (paramInt == 2)
    {
      str2 = EmoticonUtils.emoticonEncryptExtensionApngUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
      if (bool)
      {
        str1 = String.valueOf(paramEmoticon.extensionWidth);
        label265:
        str2 = str2.replace("[width]", str1);
        if (!bool) {
          break label313;
        }
      }
      label313:
      for (str1 = String.valueOf(paramEmoticon.extensionHeight);; str1 = "200")
      {
        str1 = str2.replace("[height]", str1);
        break;
        str1 = "200";
        break label265;
      }
    }
    String str2 = EmoticonUtils.emoticonEncryptExtensionUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
    if (bool)
    {
      str1 = String.valueOf(paramEmoticon.extensionWidth);
      label364:
      str2 = str2.replace("[width]", str1);
      if (!bool) {
        break label412;
      }
    }
    label412:
    for (str1 = String.valueOf(paramEmoticon.extensionHeight);; str1 = "200")
    {
      str1 = str2.replace("[height]", str1);
      break;
      str1 = "200";
      break label364;
    }
  }
  
  public Bundle b(Bundle paramBundle)
  {
    int i = 1;
    int j;
    int k;
    if (paramBundle == null)
    {
      j = -1;
      paramBundle = "";
      i = 0;
      k = 0;
    }
    Object localObject;
    for (;;)
    {
      localObject = new Bundle();
      if (i == 0) {
        break;
      }
      paramBundle = a(paramBundle, j, k);
      ((Bundle)localObject).putInt("result", paramBundle.getInt("result"));
      ((Bundle)localObject).putString("messge", "");
      ((Bundle)localObject).putInt("id", -1);
      ((Bundle)localObject).putInt("status", paramBundle.getInt("status"));
      ((Bundle)localObject).putInt("pluginStatus", paramBundle.getInt("pluginStatus"));
      ((Bundle)localObject).putLong("pluginSize", paramBundle.getLong("pluginSize"));
      ((Bundle)localObject).putInt("progress", paramBundle.getInt("progress"));
      ((Bundle)localObject).putInt("dynamicEmojiId", paramBundle.getInt("dEmojiId"));
      ((Bundle)localObject).putStringArrayList("dynamicEmojiList", paramBundle.getStringArrayList("srcList"));
      ((Bundle)localObject).putStringArrayList("urlParamsList", paramBundle.getStringArrayList("urlParamsList"));
      return localObject;
      localObject = paramBundle.getString("id");
      int m = paramBundle.getInt("businessType");
      int n = paramBundle.getInt("sceneType");
      if (((String)localObject).length() == 0)
      {
        i = 0;
        k = n;
        j = m;
        paramBundle = (Bundle)localObject;
      }
      else
      {
        k = n;
        j = m;
        paramBundle = (Bundle)localObject;
        if (aqyy.a((String)localObject) == -1)
        {
          i = 0;
          k = n;
          j = m;
          paramBundle = (Bundle)localObject;
        }
      }
    }
    ((Bundle)localObject).putInt("result", 0);
    ((Bundle)localObject).putString("messge", "");
    ((Bundle)localObject).putInt("id", -1);
    ((Bundle)localObject).putInt("status", 0);
    ((Bundle)localObject).putInt("pluginStatus", 0);
    ((Bundle)localObject).putLong("pluginSize", 0L);
    ((Bundle)localObject).putInt("progress", 0);
    ((Bundle)localObject).putInt("dynamicEmojiId", -1);
    ((Bundle)localObject).putStringArrayList("dynamicEmojiList", null);
    ((Bundle)localObject).putStringArrayList("urlParamsList", null);
    return localObject;
  }
  
  void b(bgoe parambgoe)
  {
    if (parambgoe == null) {
      return;
    }
    Object localObject = parambgoe.a();
    int i = ((Bundle)localObject).getInt(parambgoe.c);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    localObject = (File)parambgoe.jdField_a_of_type_JavaUtilMap.get(parambgoe.c);
    switch (i)
    {
    default: 
      return;
    case 2: 
      jdField_a_of_type_Area.a(localEmoticonPackage, 2, 0, 0);
      return;
    case 21: 
      try
      {
        FileUtils.uncompressZip(((File)localObject).getAbsolutePath(), EmoticonUtils.emoticonPackageFolderPath.replace("[epId]", localEmoticonPackage.epId), false);
        ((File)localObject).delete();
        return;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          parambgoe.jdField_a_of_type_Boolean = true;
          localIOException1.printStackTrace();
        }
      }
    }
    try
    {
      FileUtils.uncompressZip(((File)localObject).getAbsolutePath(), EmoticonUtils.pngFramePath.replace("[epId]", localIOException1.epId), false);
      this.jdField_a_of_type_Avkv.b(localIOException1.epId);
      ((File)localObject).delete();
      return;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        parambgoe.jdField_a_of_type_Boolean = true;
        localIOException2.printStackTrace();
      }
    }
  }
  
  void b(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramEmoticonPackage.childEpId)) || ("0".equals(paramEmoticonPackage.childEpId)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| handle h5magic chiled emotion and childEpId = " + paramEmoticonPackage.childEpId);
    }
    if (paramBoolean)
    {
      localObject = (amrg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(12);
      if (localObject != null) {
        ((amrg)localObject).a(paramEmoticonPackage.childEpId, 0);
      }
    }
    EmoticonPackage localEmoticonPackage = a().c(paramEmoticonPackage.childEpId, 0);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| old childEp = " + localEmoticonPackage);
    }
    Object localObject = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| childEpId = " + paramEmoticonPackage.childEpId);
      }
      localObject = new EmoticonPackage();
      ((EmoticonPackage)localObject).epId = paramEmoticonPackage.childEpId;
      ((EmoticonPackage)localObject).wordingId = -1L;
      ((EmoticonPackage)localObject).jobType = 5;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| auto download childEp = " + localObject);
    }
    a((EmoticonPackage)localObject, paramBoolean);
  }
  
  void b(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (paramEmoticonPackage.jobType == 4) {}
    for (int i = 19;; i = 2)
    {
      if (paramEmoticonPackage.jobType == 2) {}
      for (String str = paramEmoticonPackage.kinId;; str = paramEmoticonPackage.epId)
      {
        str = aqyy.b(i, str);
        paramEmoticonPackage = aqyy.a(2, paramEmoticonPackage.epId);
        if (!FileUtils.fileExists(paramEmoticonPackage))
        {
          paramList.add(str);
          paramMap.put(str, new File(paramEmoticonPackage));
          paramBundle.putInt(str, 2);
        }
        return;
      }
    }
  }
  
  public boolean b()
  {
    return DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.h5magic_support.name());
  }
  
  /* Error */
  public boolean b(Emoticon paramEmoticon)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	areb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: sipush 149
    //   7: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10: checkcast 1448	arba
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 1451	arba:a	()Ljava/util/List;
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 61	areb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: bipush 14
    //   28: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   31: checkcast 252	avsq
    //   34: aload_1
    //   35: getfield 250	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   38: invokevirtual 255	avsq:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   41: ifnonnull +14 -> 55
    //   44: aload_0
    //   45: aload_1
    //   46: getfield 250	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   49: getstatic 48	areb:jdField_c_of_type_Int	I
    //   52: invokevirtual 271	areb:a	(Ljava/lang/String;I)V
    //   55: aload 4
    //   57: astore_3
    //   58: aload_0
    //   59: getfield 1453	areb:jdField_c_of_type_Boolean	Z
    //   62: ifne +121 -> 183
    //   65: aload 4
    //   67: ifnull +16 -> 83
    //   70: aload 4
    //   72: astore_3
    //   73: aload 4
    //   75: invokeinterface 1455 1 0
    //   80: ifeq +103 -> 183
    //   83: aload_0
    //   84: iconst_1
    //   85: putfield 1453	areb:jdField_c_of_type_Boolean	Z
    //   88: invokestatic 1456	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   91: invokestatic 1066	com/tencent/mobileqq/utils/NetworkUtil:isNetSupport	(Landroid/content/Context;)Z
    //   94: ifne +5 -> 99
    //   97: iconst_0
    //   98: ireturn
    //   99: aload_0
    //   100: getfield 61	areb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   103: bipush 103
    //   105: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   108: checkcast 1458	arbb
    //   111: astore 6
    //   113: aload 4
    //   115: astore_3
    //   116: aload 6
    //   118: invokevirtual 1459	arbb:a	()Z
    //   121: ifeq +62 -> 183
    //   124: new 4	java/lang/Object
    //   127: dup
    //   128: invokespecial 59	java/lang/Object:<init>	()V
    //   131: astore_3
    //   132: new 1461	areh
    //   135: dup
    //   136: aload_0
    //   137: aload_3
    //   138: invokespecial 1464	areh:<init>	(Lareb;Ljava/lang/Object;)V
    //   141: astore 4
    //   143: aload_0
    //   144: getfield 61	areb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   147: aload 4
    //   149: invokevirtual 1468	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   152: aload 6
    //   154: invokevirtual 1470	arbb:c	()V
    //   157: aload_3
    //   158: monitorenter
    //   159: aload_3
    //   160: ldc2_w 272
    //   163: invokevirtual 277	java/lang/Object:wait	(J)V
    //   166: aload_3
    //   167: monitorexit
    //   168: aload_0
    //   169: getfield 61	areb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   172: aload 4
    //   174: invokevirtual 1473	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   177: aload 5
    //   179: invokevirtual 1451	arba:a	()Ljava/util/List;
    //   182: astore_3
    //   183: aload_3
    //   184: ifnull -87 -> 97
    //   187: iconst_0
    //   188: istore_2
    //   189: iload_2
    //   190: aload_3
    //   191: invokeinterface 975 1 0
    //   196: if_icmpge -99 -> 97
    //   199: aload_3
    //   200: iload_2
    //   201: invokeinterface 1474 2 0
    //   206: checkcast 1476	com/tencent/mobileqq/data/CustomEmotionData
    //   209: astore 4
    //   211: aload 4
    //   213: getfield 1479	com/tencent/mobileqq/data/CustomEmotionData:isMarkFace	Z
    //   216: ifeq +54 -> 270
    //   219: aload 4
    //   221: getfield 1482	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   224: aload_1
    //   225: getfield 250	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   228: invokevirtual 1420	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +39 -> 270
    //   234: aload 4
    //   236: getfield 1483	com/tencent/mobileqq/data/CustomEmotionData:eId	Ljava/lang/String;
    //   239: aload_1
    //   240: getfield 258	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   243: invokevirtual 1420	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   246: ifeq +24 -> 270
    //   249: ldc_w 1485
    //   252: aload 4
    //   254: getfield 1488	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   257: invokevirtual 1420	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   260: ifne -163 -> 97
    //   263: iconst_1
    //   264: ireturn
    //   265: astore_1
    //   266: aload_3
    //   267: monitorexit
    //   268: aload_1
    //   269: athrow
    //   270: iload_2
    //   271: iconst_1
    //   272: iadd
    //   273: istore_2
    //   274: goto -85 -> 189
    //   277: astore 6
    //   279: goto -113 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	areb
    //   0	282	1	paramEmoticon	Emoticon
    //   188	86	2	i	int
    //   57	210	3	localObject1	Object
    //   20	233	4	localObject2	Object
    //   13	165	5	localarba	arba
    //   111	42	6	localarbb	arbb
    //   277	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   159	166	265	finally
    //   166	168	265	finally
    //   266	268	265	finally
    //   159	166	277	java/lang/InterruptedException
  }
  
  public boolean b(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool1;
    if (paramEmoticon == null)
    {
      bool1 = true;
      return bool1;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramInt & 0x1) == 1)
    {
      if (paramEmoticon.jobType != 1) {
        localObject1 = EmoticonUtils.emoticonAIOPreviewPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
      bool1 = FileUtil.isFileExists((String)localObject1);
    }
    for (;;)
    {
      if ((bool1) && ((paramInt & 0x4) == 4)) {
        if (paramEmoticon.jobType != 1) {
          localObject1 = EmoticonUtils.emoticonEncryptPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
        }
      }
      for (boolean bool2 = FileUtil.isFileExists((String)localObject1);; bool2 = bool1)
      {
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if ((paramInt & 0x2) == 2) {
            bool1 = FileUtil.isFileExists(EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
          }
        }
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (paramEmoticon.isSound)
          {
            bool2 = bool1;
            if ((paramInt & 0x8) == 8) {
              bool2 = FileUtil.isFileExists(EmoticonUtils.emoticonSoundPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
            }
          }
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        bool1 = bool2;
        if ((paramInt & 0x20) != 32) {
          break;
        }
        return FileUtil.isFileExists(EmoticonUtils.emoticonAPNGPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
      }
      bool1 = true;
      localObject1 = localObject2;
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool = c(paramString);
    a(paramString, bool);
    return bool;
  }
  
  boolean b(String paramString, Boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    if (paramBoolean.booleanValue())
    {
      paramBoolean = (ArrayList)a().a(paramString);
      if (paramBoolean != null)
      {
        paramBoolean = paramBoolean.iterator();
        if (paramBoolean.hasNext())
        {
          paramBoolean = (Emoticon)paramBoolean.next();
          if (paramBoolean == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((paramBoolean.jobType == 2) && ((paramBoolean.encryptKey == null) || (paramBoolean.encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
          if (!new File(EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramString).replace("[eId]", paramBoolean.eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    String str2 = avlx.a();
    String str3 = EmoticonUtils.emoticonPackageFolderPath.replace("[epId]", paramString);
    String str1 = str3 + str2 + File.separator + "video.ini";
    File localFile = new File(str1);
    paramBoolean = localFile;
    if (!localFile.exists())
    {
      str2 = "big";
      str1 = str3 + "big" + File.separator + "video.ini";
      localFile = new File(str1);
      paramBoolean = localFile;
      if (!localFile.exists()) {
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str1);
    }
    return a(paramString, str2, str3, paramBoolean);
  }
  
  public boolean b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, epId = " + paramString + ", needKey = " + paramBoolean1 + ", needCheckChild = " + paramBoolean2);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool2 = a(paramString, paramBoolean1);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, result = " + bool2);
    }
    EmoticonPackage localEmoticonPackage = a().a(paramString);
    if (localEmoticonPackage != null) {
      if ((paramBoolean2) && (!TextUtils.isEmpty(localEmoticonPackage.childEpId)))
      {
        paramBoolean1 = a(localEmoticonPackage.childEpId, paramBoolean1);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, childEpId = " + localEmoticonPackage.childEpId + ", childResult = " + paramBoolean1);
        }
        a(localEmoticonPackage.childEpId, paramBoolean1);
        if ((bool2) && (paramBoolean1))
        {
          paramBoolean1 = bool1;
          label217:
          a(paramString, paramBoolean1);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, epId=" + paramString + ", result=" + paramBoolean1);
      }
      return paramBoolean1;
      paramBoolean1 = false;
      break label217;
      paramBoolean1 = true;
      break;
      paramBoolean1 = bool2;
    }
  }
  
  String[] b(Emoticon paramEmoticon)
  {
    Object localObject = null;
    String str;
    if (paramEmoticon.jobType != 1)
    {
      boolean bool = c(paramEmoticon);
      str = EmoticonUtils.emoticonAIOPreviewExtensionUrl.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
      if (bool)
      {
        localObject = String.valueOf(paramEmoticon.extensionWidth);
        str = str.replace("[width]", (CharSequence)localObject);
        if (!bool) {
          break label135;
        }
        localObject = String.valueOf(paramEmoticon.extensionHeight);
        label81:
        localObject = str.replace("[height]", (CharSequence)localObject);
        paramEmoticon = EmoticonUtils.emoticonAIOPreviewPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramEmoticon };
      localObject = "200";
      break;
      label135:
      localObject = "200";
      break label81;
      str = null;
      paramEmoticon = (Emoticon)localObject;
      localObject = str;
    }
  }
  
  void c(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!a(paramEmoticonPackage.epId, h))
    {
      String str = aqyy.a(paramEmoticonPackage.epId, 1);
      paramEmoticonPackage = EmoticonUtils.magicFaceZipPath.replace("[epId]", paramEmoticonPackage.epId);
      if (!FileUtils.fileExists(paramEmoticonPackage))
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 21);
      }
    }
  }
  
  public boolean c()
  {
    if (jdField_a_of_type_Int == 4) {
      if (System.currentTimeMillis() - jdField_a_of_type_Long > 15000L)
      {
        jdField_a_of_type_Int = 0;
        jdField_a_of_type_Boolean = false;
      }
    }
    do
    {
      return true;
      return false;
      jdField_a_of_type_Int += 1;
    } while ((jdField_a_of_type_Int != 4) || (jdField_a_of_type_Boolean));
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  public boolean c(Emoticon paramEmoticon)
  {
    return (paramEmoticon != null) && (paramEmoticon.extensionWidth != 0) && (paramEmoticon.extensionHeight != 0);
  }
  
  public boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = aqyy.a(2, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_thumb isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = aqyy.a(3, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_color isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = aqyy.a(4, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_gray isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = (ArrayList)a().a(paramString);
    if (localObject != null)
    {
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)localIterator.next();
        if (localEmoticon == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
          }
          return false;
        }
        if (!new File(EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId)).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
        localObject = a().a(paramString, -1);
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {}
        for (localObject = EmoticonUtils.emoticonAPNGPath.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId); !new File((String)localObject).exists(); localObject = EmoticonUtils.emoticonEncryptPath.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emoticons do not be exist.epId=" + paramString);
    }
    return true;
  }
  
  String[] c(Emoticon paramEmoticon)
  {
    String str1 = paramEmoticon.epId;
    String str2 = paramEmoticon.eId;
    if (paramEmoticon.jobType == 3) {}
    for (boolean bool = true;; bool = false) {
      return a(str1, str2, bool);
    }
  }
  
  void d(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!a(paramEmoticonPackage.epId, g))
    {
      String str = aqyy.a(paramEmoticonPackage.epId, 0);
      paramEmoticonPackage = EmoticonUtils.magicFaceZipPath.replace("[epId]", paramEmoticonPackage.epId);
      if (!FileUtils.fileExists(paramEmoticonPackage))
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 21);
      }
    }
  }
  
  public boolean d(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          localObject = aqyy.a(2, paramString);
          if (new File((String)localObject).exists()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "cover_pkg_thumb isn't exist." + (String)localObject);
        return false;
        localObject = aqyy.a(3, paramString);
        if (new File((String)localObject).exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "cover_pkg_color isn't exist." + (String)localObject);
      return false;
      localObject = aqyy.a(4, paramString);
      if (new File((String)localObject).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "cover_pkg_gray isn't exist." + (String)localObject);
    return false;
    Object localObject = (ArrayList)a().a(paramString, true);
    EmoticonPackage localEmoticonPackage;
    if (localObject != null)
    {
      localEmoticonPackage = a().a(paramString, -1);
      if (localEmoticonPackage == null) {
        break label615;
      }
    }
    label578:
    label615:
    for (int i = localEmoticonPackage.rscType;; i = 0)
    {
      Iterator localIterator = ((ArrayList)localObject).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          if (localEmoticon == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
            return false;
          }
          if ((localEmoticon.jobType == 0) && ((localEmoticon.encryptKey == null) || (localEmoticon.encryptKey.length() == 0)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          if (!new File(EmoticonUtils.emoticonPreviewPath.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId)).exists())
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          if (1 == i) {
            return avlc.a(EmoticonUtils.pngFramePath.replace("[epId]", paramString));
          }
          if ((localEmoticonPackage != null) && (localEmoticonPackage.isAPNG == 2)) {}
          for (localObject = EmoticonUtils.emoticonAPNGPath.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId);; localObject = EmoticonUtils.emoticonEncryptPath.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId))
          {
            if (new File((String)localObject).exists()) {
              break label578;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
          }
        }
      }
      return true;
    }
  }
  
  void e(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage|add magic task ");
    }
    c(paramList, paramMap, paramEmoticonPackage, paramBundle);
    d(paramList, paramMap, paramEmoticonPackage, paramBundle);
  }
  
  protected boolean e(String paramString)
  {
    Object localObject = a().a(paramString);
    if (localObject != null) {}
    for (int i = ((EmoticonPackage)localObject).rscType;; i = 0)
    {
      if (1 == i) {
        return avlc.a(EmoticonUtils.pngFramePath.replace("[epId]", paramString));
      }
      localObject = (ArrayList)a().a(paramString);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0) && (!new File(EmoticonUtils.emoticonEncryptPath.replace("[epId]", paramString).replace("[eId]", ((Emoticon)((ArrayList)localObject).get(0)).eId)).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + ((Emoticon)((ArrayList)localObject).get(0)).eId);
        }
        return false;
      }
      return true;
    }
  }
  
  void f(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage|add h5magic task ");
    }
    if (!b(paramEmoticonPackage.epId, true, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| add h5 zip url");
      }
      String str = aqyy.b(paramEmoticonPackage.epId);
      paramEmoticonPackage = aqyy.c(paramEmoticonPackage.epId);
      if (paramEmoticonPackage != null)
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 20);
      }
    }
  }
  
  public boolean f(String paramString)
  {
    return new File(EmoticonUtils.emoticonPackageFolderPath.replace("[epId]", paramString) + "audio" + File.separator + "audio.ini").exists();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    jdField_a_of_type_Area.a();
    if (a() != null) {
      a().a();
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     areb
 * JD-Core Version:    0.7.0.1
 */