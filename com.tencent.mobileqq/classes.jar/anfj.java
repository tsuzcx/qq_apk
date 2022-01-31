import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager.4;
import com.tencent.mobileqq.emoticon.EmojiManager.5;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
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

public class anfj
  implements Manager
{
  public static int a;
  public static long a;
  public static anfi a;
  public static boolean a;
  public static int b;
  private static String jdField_b_of_type_JavaLangString = "json_";
  public static boolean b;
  public static int c;
  public static int d;
  private static int g;
  private static int h = 1;
  arga jdField_a_of_type_Arga = null;
  public batl a;
  public JobQueue a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  LRULinkedHashMap<String, ArrayList<String>> jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(20);
  public String a;
  public HashMap<String, String> a;
  Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  public ConcurrentHashMap<String, angr> a;
  batl jdField_b_of_type_Batl = new anfl(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  public batl c;
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
  
  public anfj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = anfj.class.getSimpleName();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Int = 3000000;
    this.jdField_a_of_type_ComTencentImageJobQueue = new JobQueue(3);
    this.jdField_a_of_type_Batl = new anfk(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_c_of_type_Batl = new anfm(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Arga = ((arga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(83));
    jdField_a_of_type_Anfi = anfi.a();
  }
  
  public static angr a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      paramAppRuntime = (anfj)paramAppRuntime.getManager(43);
      if (paramAppRuntime != null) {
        return (angr)paramAppRuntime.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    }
    return null;
  }
  
  /* Error */
  private Emoticon a(Emoticon paramEmoticon)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 146	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 53	anfj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: bipush 14
    //   11: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14: checkcast 148	arnz
    //   17: astore 4
    //   19: aload 4
    //   21: aload_3
    //   22: invokevirtual 151	arnz:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   25: astore 5
    //   27: aload 4
    //   29: aload_3
    //   30: aload_1
    //   31: getfield 154	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   34: invokevirtual 157	arnz:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/Emoticon;
    //   37: astore_2
    //   38: aload 5
    //   40: ifnull +7 -> 47
    //   43: aload_2
    //   44: ifnonnull +124 -> 168
    //   47: new 4	java/lang/Object
    //   50: dup
    //   51: invokespecial 51	java/lang/Object:<init>	()V
    //   54: astore_2
    //   55: new 159	anfo
    //   58: dup
    //   59: aload_0
    //   60: aload_3
    //   61: aload_2
    //   62: invokespecial 162	anfo:<init>	(Lanfj;Ljava/lang/String;Ljava/lang/Object;)V
    //   65: astore 5
    //   67: invokestatic 126	anfi:a	()Lanfi;
    //   70: aload 5
    //   72: invokevirtual 165	anfi:a	(Lanfx;)V
    //   75: aload_0
    //   76: aload_3
    //   77: getstatic 40	anfj:jdField_c_of_type_Int	I
    //   80: invokevirtual 168	anfj:a	(Ljava/lang/String;I)V
    //   83: aload_2
    //   84: monitorenter
    //   85: aload_2
    //   86: ldc2_w 169
    //   89: invokevirtual 174	java/lang/Object:wait	(J)V
    //   92: aload_2
    //   93: monitorexit
    //   94: invokestatic 126	anfi:a	()Lanfi;
    //   97: aload 5
    //   99: invokevirtual 176	anfi:b	(Lanfx;)V
    //   102: aload 4
    //   104: aload_3
    //   105: invokevirtual 151	arnz:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   108: astore 5
    //   110: aload 4
    //   112: aload_3
    //   113: aload_1
    //   114: getfield 154	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   117: invokevirtual 157	arnz:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/Emoticon;
    //   120: astore_2
    //   121: aload 5
    //   123: ifnull +9 -> 132
    //   126: aload_2
    //   127: astore_1
    //   128: aload_2
    //   129: ifnonnull +41 -> 170
    //   132: aload_0
    //   133: getfield 61	anfj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   136: iconst_1
    //   137: new 178	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   144: ldc 181
    //   146: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_3
    //   150: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   171: getfield 196	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   174: ifeq +21 -> 195
    //   177: aload_1
    //   178: getfield 196	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   181: iconst_2
    //   182: if_icmpeq +13 -> 195
    //   185: aload_1
    //   186: astore_2
    //   187: aload_1
    //   188: getfield 196	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   191: iconst_4
    //   192: if_icmpne -31 -> 161
    //   195: aload_1
    //   196: astore_2
    //   197: aload_1
    //   198: invokevirtual 200	com/tencent/mobileqq/data/Emoticon:hasEncryptKey	()Z
    //   201: ifne -40 -> 161
    //   204: new 202	java/util/ArrayList
    //   207: dup
    //   208: iconst_1
    //   209: invokespecial 203	java/util/ArrayList:<init>	(I)V
    //   212: astore_2
    //   213: aload_2
    //   214: aload_1
    //   215: invokevirtual 207	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   218: pop
    //   219: new 209	angh
    //   222: dup
    //   223: invokespecial 210	angh:<init>	()V
    //   226: astore 4
    //   228: aload_0
    //   229: aload_3
    //   230: aload_2
    //   231: aload 4
    //   233: invokevirtual 213	anfj:a	(Ljava/lang/String;Ljava/util/ArrayList;Langh;)V
    //   236: aload_1
    //   237: astore_2
    //   238: aload 4
    //   240: getfield 215	angh:jdField_a_of_type_Boolean	Z
    //   243: ifne -82 -> 161
    //   246: aload_0
    //   247: getfield 61	anfj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   250: iconst_1
    //   251: new 178	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   258: ldc 217
    //   260: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_3
    //   264: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 219
    //   269: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_1
    //   273: getfield 154	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   276: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: aconst_null
    //   286: areturn
    //   287: astore 6
    //   289: goto -197 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	anfj
    //   0	292	1	paramEmoticon	Emoticon
    //   37	201	2	localObject1	Object
    //   4	260	3	str	String
    //   17	222	4	localObject2	Object
    //   25	97	5	localObject3	Object
    //   287	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   85	92	163	finally
    //   92	94	163	finally
    //   164	166	163	finally
    //   85	92	287	java/lang/InterruptedException
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoResID", paramString2);
    localHashMap.put("emoPackageID", paramString1);
    localHashMap.put("result", paramInt + "");
    paramString1 = awrn.a(BaseApplication.getContext());
    paramString2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1.a(paramString2, "NewAudioEmoticonVoiceDownload", bool, 0L, 0L, localHashMap, null);
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
  
  public static String[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = anjd.d.replace("[epId]", paramString1).replace("[eId]", paramString2);
      paramString1 = anjd.p.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
    for (paramString2 = str;; paramString2 = str)
    {
      return new String[] { paramString2, paramString1 };
      str = anjd.g.replace("[eIdSub]", paramString2.substring(0, 2)).replace("[eId]", paramString2);
      paramString1 = anjd.p.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
  }
  
  public float a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return -1.0F;
    }
    paramString = (angr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "collectEmoji fail to download Emoticon");
      return -1;
    }
    return adje.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticon, null);
  }
  
  int a(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, List<String> paramList, Map<String, File> paramMap, Bundle paramBundle, int paramInt)
  {
    int i = 0;
    Emoticon localEmoticon;
    int j;
    if (i < paramArrayList.size())
    {
      localEmoticon = (Emoticon)paramArrayList.get(i);
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = c(localEmoticon);
        if (!bace.a(localObject[1]))
        {
          paramList.add(localObject[0]);
          paramMap.put(localObject[0], new File(localObject[1]));
          localObject = localObject[0];
          if (localEmoticon.jobType != 1) {
            break label385;
          }
          j = 15;
          label177:
          paramBundle.putInt((String)localObject, j);
        }
      }
      if (((paramInt & 0x4) == 4) || ((paramInt & 0x20) == 32))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        if (paramEmoticonPackage.jobType == 1) {
          break label913;
        }
        if (localEmoticon.hasEncryptKey())
        {
          j = paramEmoticonPackage.rscType;
          if ((paramInt & 0x20) == 32) {
            j = 2;
          }
        }
      }
    }
    label385:
    label904:
    label913:
    for (Object localObject = a(localEmoticon, j);; localObject = null)
    {
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fail Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId);
        }
        return 11030;
        j = 6;
        break label177;
        return 11009;
      }
      boolean bool = false;
      if (paramEmoticonPackage.rscType == 1)
      {
        if (argh.a(anjd.z.replace("[epId]", localEmoticon.epId))) {
          bool = true;
        }
        label430:
        if (!bool)
        {
          paramList.add(localObject[0]);
          paramMap.put(localObject[0], new File(localObject[1]));
          if (paramEmoticonPackage.rscType != 1) {
            break label845;
          }
          paramBundle.putInt(localObject[0], 16);
        }
        label488:
        if ((paramInt & 0x1) == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo AIO preview static.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt);
          }
          localObject = b(localEmoticon);
          if (!bace.a(localObject[1]))
          {
            paramList.add(localObject[0]);
            paramMap.put(localObject[0], new File(localObject[1]));
            localObject = localObject[0];
            if (localEmoticon.jobType != 1) {
              break label904;
            }
          }
        }
      }
      for (j = 15;; j = 8) {
        for (;;)
        {
          paramBundle.putInt((String)localObject, j);
          if ((localEmoticon.isSound) && ((paramInt & 0x8) == 8))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo sound.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt);
            }
            localObject = a(localEmoticon);
            if (!bace.a(localObject[1]))
            {
              paramList.add(localObject[0]);
              paramMap.put(localObject[0], new File(localObject[1]));
              paramBundle.putInt(localObject[0], 9);
              if (localEmoticon.isNewSoundEmoticon()) {
                paramBundle.putString(localObject[0] + "emoticonId", localEmoticon.eId);
              }
            }
          }
          i += 1;
          break;
          bool = bace.a(localObject[1]);
          break label430;
          label845:
          if (paramEmoticonPackage.jobType == 1) {
            break label488;
          }
          paramBundle.putInt(localObject[0], 7);
          synchronized (this.jdField_a_of_type_JavaUtilMap)
          {
            this.jdField_a_of_type_JavaUtilMap.put(localObject[0], localEmoticon.encryptKey);
          }
        }
      }
      return 0;
    }
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
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + ((Emoticon)localObject).epId + " eid=" + ((Emoticon)localObject).eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        String[] arrayOfString = c((Emoticon)localObject);
        if ((!bace.a(arrayOfString[1])) || (paramBoolean))
        {
          paramList.add(arrayOfString[0]);
          paramMap.put(arrayOfString[0], new File(arrayOfString[1]));
          paramBundle.putInt(arrayOfString[0], 6);
        }
      }
      if (((paramInt & 0x4) == 4) || ((paramInt & 0x20) == 32))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + ((Emoticon)localObject).epId + " eid=" + ((Emoticon)localObject).eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = a((Emoticon)localObject, paramEmoticonPackage.rscType);
        if ((!bace.a(localObject[1])) || (paramBoolean)) {
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
    angh localangh = new angh();
    byte[] arrayOfByte = null;
    if (paramFile != null) {}
    label522:
    for (;;)
    {
      try
      {
        if (paramFile.exists())
        {
          arrayOfByte = bace.a(paramFile);
          if (paramEmoticonPackage.jobType == 4)
          {
            paramFile = anfy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_c_of_type_Int, arrayOfByte, localArrayList);
            if (paramEmoticonPackage.isAPNG != 2) {
              break label522;
            }
            paramInt |= 0x20;
            if (paramFile == null) {
              continue;
            }
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "addEmotionsTask| parse json error");
            bapm.a("emotionType", "emotionActionDownload", "4", paramEmoticonPackage.epId, "", "", paramFile, "", "", "");
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
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "OutOfMemoryError e = " + paramFile.getMessage());
        arrayOfByte = null;
        continue;
        paramFile = anfy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, jdField_c_of_type_Int, arrayOfByte, localArrayList, localangh);
        continue;
        if ((!TextUtils.isEmpty(paramEmoticonPackage.minQQVersion)) && (!banq.a(paramEmoticonPackage.minQQVersion, "8.2.6")))
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "unavailable in current version, min version=" + paramEmoticonPackage.minQQVersion);
          return 11011;
        }
        paramBundle.putBoolean("isUpdate", paramBoolean);
        paramBundle.putSerializable("emoticonList", localArrayList);
        if ((!localangh.jdField_a_of_type_Boolean) && (paramEmoticonPackage.jobType != 4))
        {
          int i = 0;
          localangh.jdField_a_of_type_JavaLangString = null;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i);
          }
          a(paramEmoticonPackage.epId, localArrayList, localangh);
          int j = i + 1;
          if (!localangh.jdField_a_of_type_Boolean)
          {
            i = j;
            if (j < 3) {
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + j + " encryptKeysSuccess=" + localangh.jdField_a_of_type_Boolean);
          }
          if (!localangh.jdField_a_of_type_Boolean)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "addEmoticonsTask| fetchEncryptKeys fail epId=" + paramEmoticonPackage.epId + " encryptGetKeySeq=" + localangh.jdField_a_of_type_JavaLangString + " encryptKeysResultCode" + localangh.jdField_a_of_type_Int);
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
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_detail", 0, 0, paramBundle.epId, "" + paramBundle.localVersion, "" + paramBundle.latestVersion, "");
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
        break label409;
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
      label409:
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
    paramString = (angr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null)
    {
      Bundle localBundle = paramString.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localBundle != null)
      {
        paramString = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
        if (paramString != null) {
          jdField_a_of_type_Anfi.a(paramString, 11007, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    int i = 0;
    Object localObject = a().c(paramString, paramInt2);
    paramInt2 = i;
    if (localObject != null)
    {
      if (((EmoticonPackage)localObject).valid) {
        paramInt2 = 1;
      }
    }
    else {
      if (paramInt1 != 2) {
        break label769;
      }
    }
    label769:
    for (int i3 = 1;; i3 = paramInt2)
    {
      angr localangr = (angr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      int n;
      int k;
      int m;
      if ((localangr != null) && (!localangr.a()))
      {
        n = 0;
        k = (int)localangr.a();
        m = 2;
      }
      for (;;)
      {
        int j;
        label147:
        int i2;
        int i1;
        if (n == -1)
        {
          paramInt2 = k;
          i = m;
          j = n;
          switch (paramInt1)
          {
          default: 
            j = n;
            i = m;
            paramInt2 = k;
          case 2: 
            i2 = paramInt2;
            i1 = i;
            paramInt1 = j;
            if (QLog.isColorLevel())
            {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getPackageStatus| query result in DB or not DB, epId:" + paramString + ",result=" + j + " status=" + i + " progress=" + paramInt2);
              paramInt1 = j;
              i1 = i;
              i2 = paramInt2;
            }
            break;
          }
        }
        for (;;)
        {
          paramInt2 = paramInt1;
          if (paramInt1 == -1)
          {
            paramInt2 = 0;
            i1 = 0;
            i2 = 0;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("id", paramString);
          ((Bundle)localObject).putInt("result", paramInt2);
          ((Bundle)localObject).putInt("status", i1);
          ((Bundle)localObject).putInt("pluginStatus", 0);
          ((Bundle)localObject).putLong("pluginSize", 0L);
          ((Bundle)localObject).putInt("progress", i2);
          ((Bundle)localObject).putInt("dEmojiId", -1);
          ((Bundle)localObject).putInt("flag", i3);
          ((Bundle)localObject).putStringArrayList("srcList", null);
          ((Bundle)localObject).putStringArrayList("urlParamsList", null);
          return localObject;
          paramInt2 = 0;
          break;
          paramInt2 = k;
          i = m;
          j = n;
          if (localObject == null) {
            break label147;
          }
          paramInt2 = k;
          i = m;
          j = n;
          if (((EmoticonPackage)localObject).status != 2) {
            break label147;
          }
          if (a(paramString))
          {
            if (anjd.a(((EmoticonPackage)localObject).updateFlag))
            {
              j = 0;
              i = 4;
              paramInt2 = 0;
              break label147;
            }
            j = 0;
            paramInt2 = 100;
            i = 3;
            break label147;
          }
          j = 0;
          i = 0;
          paramInt2 = 0;
          break label147;
          paramInt2 = k;
          i = m;
          j = n;
          if (localObject == null) {
            break label147;
          }
          paramInt2 = k;
          i = m;
          j = n;
          if (((EmoticonPackage)localObject).status != 2) {
            break label147;
          }
          if (b(paramString))
          {
            if (anjd.a(((EmoticonPackage)localObject).updateFlag))
            {
              j = 0;
              i = 4;
              paramInt2 = 0;
              break label147;
            }
            j = 0;
            paramInt2 = 100;
            i = 3;
            break label147;
          }
          j = 0;
          i = 0;
          paramInt2 = 0;
          break label147;
          paramInt2 = k;
          i = m;
          j = n;
          if (localObject == null) {
            break label147;
          }
          paramInt2 = k;
          i = m;
          j = n;
          if (((EmoticonPackage)localObject).status != 2) {
            break label147;
          }
          if (a(paramString, Boolean.valueOf(true)))
          {
            j = 0;
            paramInt2 = 100;
            i = 3;
            break label147;
          }
          j = 0;
          i = 0;
          paramInt2 = 0;
          break label147;
          paramInt2 = k;
          i = m;
          j = n;
          if (localObject == null) {
            break label147;
          }
          paramInt2 = k;
          i = m;
          j = n;
          if (((EmoticonPackage)localObject).status != 2) {
            break label147;
          }
          if (b(paramString, true, true))
          {
            j = 0;
            paramInt2 = 100;
            i = 3;
            break label147;
          }
          j = 0;
          i = 0;
          paramInt2 = 0;
          break label147;
          i2 = k;
          i1 = m;
          paramInt1 = n;
          if (QLog.isColorLevel())
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getPackageStatus| query result in running... result=" + n + " status=" + m + " progress=" + k);
            i2 = k;
            i1 = m;
            paramInt1 = n;
          }
        }
        k = 0;
        m = 0;
        n = -1;
      }
    }
  }
  
  public arnz a()
  {
    return (arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
  }
  
  public batr a()
  {
    return ((bato)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
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
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onDone:epId=" + localEmoticonPackage.epId + " task:" + paramObject + " localVersion=" + localEmoticonPackage.localVersion + ",latestVersion=" + localEmoticonPackage.latestVersion + ",updateFlag=" + localEmoticonPackage.updateFlag);
      }
      if (!paramBoolean) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          paramInt2 = anam.a(paramInt1);
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "handleEmoticonPackageDownloaded : download error ,reportCode = " + paramInt1);
          jdField_a_of_type_Anfi.a(localEmoticonPackage, paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          bapm.a("emotionType", "emotionActionDownload", "11", localEmoticonPackage.epId, "", "", paramInt1 + "", "", "", "");
          a(localEmoticonPackage, paramInt2, 0L, paramString);
          if (!bool1) {
            break;
          }
          if (localEmoticonPackage.type != 1) {
            break label319;
          }
          paramInt1 = 5;
          arnz.c(String.valueOf(paramInt2), paramInt1);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "handleEmoticonPackageDownloaded failed", paramBundle);
          return;
        }
        i = 0;
        break label69;
        label319:
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
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update package:" + localEmoticonPackage.epId + ",newEmoticons:" + paramBundle.size());
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
        break label602;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      Object localObject = paramObject.a(EmoticonPackage.class, true, "childEpId=?", new String[] { localEmoticonPackage.epId }, null, null, null, null);
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
    paramObject.a();
    label602:
    if (bool1) {}
    try
    {
      paramBundle.h(localEmoticonPackage.epId, paramInt2);
      jdField_a_of_type_Anfi.a(localEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!bool3) {
        localEmoticonPackage.extraFlags |= 0x2;
      }
      jdField_a_of_type_Anfi.d(localEmoticonPackage);
      a(localEmoticonPackage, 0, paramLong, paramString);
      return;
    }
    finally {}
  }
  
  /* Error */
  void a(batm parambatm)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokevirtual 772	batm:a	()Landroid/os/Bundle;
    //   9: ldc_w 603
    //   12: invokevirtual 607	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   15: checkcast 371	com/tencent/mobileqq/data/EmoticonPackage
    //   18: astore 6
    //   20: aload_1
    //   21: getfield 773	batm:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   24: aload_1
    //   25: getfield 775	batm:c	Ljava/lang/String;
    //   28: invokeinterface 776 2 0
    //   33: checkcast 356	java/io/File
    //   36: astore 7
    //   38: aload_0
    //   39: getfield 66	anfj:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   42: aload_1
    //   43: getfield 775	batm:c	Ljava/lang/String;
    //   46: invokeinterface 779 2 0
    //   51: ifeq +581 -> 632
    //   54: aload_0
    //   55: getfield 66	anfj:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   58: astore 4
    //   60: aload 4
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 66	anfj:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   67: aload_1
    //   68: getfield 775	batm:c	Ljava/lang/String;
    //   71: invokeinterface 776 2 0
    //   76: checkcast 278	java/lang/String
    //   79: astore_3
    //   80: aload_0
    //   81: getfield 66	anfj:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   84: aload_1
    //   85: getfield 775	batm:c	Ljava/lang/String;
    //   88: invokeinterface 782 2 0
    //   93: pop
    //   94: aload 4
    //   96: monitorexit
    //   97: aload 7
    //   99: ifnull +524 -> 623
    //   102: aload 7
    //   104: invokestatic 423	bace:a	(Ljava/io/File;)[B
    //   107: astore 5
    //   109: aload 7
    //   111: invokevirtual 785	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   114: astore 4
    //   116: aload 7
    //   118: invokevirtual 788	java/io/File:delete	()Z
    //   121: pop
    //   122: goto +515 -> 637
    //   125: aload_1
    //   126: iconst_1
    //   127: putfield 789	batm:jdField_a_of_type_Boolean	Z
    //   130: aload_0
    //   131: getfield 61	anfj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: iconst_1
    //   135: ldc_w 791
    //   138: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: getstatic 128	anfj:jdField_a_of_type_Anfi	Lanfi;
    //   144: aload 6
    //   146: sipush 11013
    //   149: aload_0
    //   150: getfield 53	anfj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   153: invokevirtual 610	anfi:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   156: ldc_w 435
    //   159: ldc_w 437
    //   162: ldc_w 793
    //   165: aload 6
    //   167: getfield 440	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   170: ldc 238
    //   172: ldc 238
    //   174: ldc 238
    //   176: ldc 238
    //   178: ldc 238
    //   180: ldc 238
    //   182: invokestatic 445	bapm:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   185: return
    //   186: astore_3
    //   187: aload_3
    //   188: invokevirtual 796	java/lang/Throwable:printStackTrace	()V
    //   191: aload_0
    //   192: getfield 61	anfj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   195: iconst_2
    //   196: new 178	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 798
    //   206: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_3
    //   210: invokevirtual 799	java/lang/Throwable:toString	()Ljava/lang/String;
    //   213: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 332
    //   219: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokestatic 338	java/lang/System:currentTimeMillis	()J
    //   225: invokevirtual 341	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   228: ldc_w 801
    //   231: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_1
    //   235: getfield 775	batm:c	Ljava/lang/String;
    //   238: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_1
    //   248: iconst_1
    //   249: putfield 789	batm:jdField_a_of_type_Boolean	Z
    //   252: getstatic 128	anfj:jdField_a_of_type_Anfi	Lanfi;
    //   255: aload 6
    //   257: sipush 11020
    //   260: aload_0
    //   261: getfield 53	anfj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   264: invokevirtual 610	anfi:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   267: ldc_w 435
    //   270: ldc_w 437
    //   273: ldc_w 803
    //   276: aload 6
    //   278: getfield 440	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   281: ldc 238
    //   283: ldc 238
    //   285: ldc 238
    //   287: ldc 238
    //   289: ldc 238
    //   291: ldc 238
    //   293: invokestatic 445	bapm:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   296: return
    //   297: astore_3
    //   298: aload 4
    //   300: monitorexit
    //   301: aload_3
    //   302: athrow
    //   303: aload 6
    //   305: getfield 372	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   308: iconst_4
    //   309: if_icmpeq +68 -> 377
    //   312: aload_3
    //   313: ifnonnull +64 -> 377
    //   316: aload_1
    //   317: iconst_1
    //   318: putfield 789	batm:jdField_a_of_type_Boolean	Z
    //   321: aload_0
    //   322: getfield 61	anfj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   325: iconst_1
    //   326: ldc_w 805
    //   329: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: getstatic 128	anfj:jdField_a_of_type_Anfi	Lanfi;
    //   335: aload 6
    //   337: sipush 11009
    //   340: aload_0
    //   341: getfield 53	anfj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   344: invokevirtual 610	anfi:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   347: ldc_w 435
    //   350: ldc_w 437
    //   353: ldc_w 807
    //   356: aload 6
    //   358: getfield 440	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   361: ldc 238
    //   363: ldc 238
    //   365: ldc 238
    //   367: ldc 238
    //   369: ldc 238
    //   371: ldc 238
    //   373: invokestatic 445	bapm:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   376: return
    //   377: aload 6
    //   379: getfield 372	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   382: iconst_4
    //   383: if_icmpne +228 -> 611
    //   386: aload 5
    //   388: aload 4
    //   390: invokestatic 810	anam:a	([BLjava/lang/String;)I
    //   393: istore_2
    //   394: iload_2
    //   395: ifeq +156 -> 551
    //   398: aload_0
    //   399: getfield 61	anfj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   402: iconst_2
    //   403: new 178	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 812
    //   413: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_1
    //   417: getfield 775	batm:c	Ljava/lang/String;
    //   420: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: ldc_w 435
    //   432: ldc_w 437
    //   435: ldc_w 814
    //   438: aload 6
    //   440: getfield 440	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   443: ldc 238
    //   445: ldc 238
    //   447: new 178	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   454: iload_2
    //   455: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: ldc 238
    //   460: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: ldc 238
    //   468: ldc 238
    //   470: ldc 238
    //   472: invokestatic 445	bapm:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   475: invokestatic 818	azzz:b	()Z
    //   478: ifeq +73 -> 551
    //   481: invokestatic 820	azzz:b	()J
    //   484: ldc2_w 821
    //   487: lcmp
    //   488: ifle +63 -> 551
    //   491: new 178	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   498: getstatic 827	ajed:aU	Ljava/lang/String;
    //   501: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: ldc_w 829
    //   507: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: getstatic 832	java/io/File:separator	Ljava/lang/String;
    //   513: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload 6
    //   518: getfield 440	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   521: invokestatic 835	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   524: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 837
    //   530: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload 7
    //   535: invokevirtual 840	java/io/File:getName	()Ljava/lang/String;
    //   538: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: aload 5
    //   546: iconst_0
    //   547: invokestatic 843	bace:a	(Ljava/lang/String;[BZ)Z
    //   550: pop
    //   551: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq -550 -> 4
    //   557: aload_0
    //   558: getfield 61	anfj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   561: iconst_2
    //   562: new 178	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   569: ldc_w 845
    //   572: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: iload_2
    //   576: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   579: ldc_w 332
    //   582: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokestatic 338	java/lang/System:currentTimeMillis	()J
    //   588: invokevirtual 341	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   591: ldc_w 801
    //   594: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload_1
    //   598: getfield 775	batm:c	Ljava/lang/String;
    //   601: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: return
    //   611: aload 5
    //   613: aload_3
    //   614: aload 4
    //   616: invokestatic 848	anam:a	([BLjava/lang/String;Ljava/lang/String;)I
    //   619: istore_2
    //   620: goto -226 -> 394
    //   623: aconst_null
    //   624: astore 4
    //   626: aconst_null
    //   627: astore 5
    //   629: goto +8 -> 637
    //   632: aconst_null
    //   633: astore_3
    //   634: goto -537 -> 97
    //   637: aload 5
    //   639: ifnull -514 -> 125
    //   642: aload 4
    //   644: ifnonnull -341 -> 303
    //   647: goto -522 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	anfj
    //   0	650	1	parambatm	batm
    //   393	227	2	i	int
    //   79	1	3	str1	String
    //   186	24	3	localThrowable	Throwable
    //   297	317	3	str2	String
    //   633	1	3	localObject1	Object
    //   107	531	5	arrayOfByte	byte[]
    //   18	499	6	localEmoticonPackage	EmoticonPackage
    //   36	498	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   38	63	186	java/lang/Throwable
    //   102	122	186	java/lang/Throwable
    //   125	185	186	java/lang/Throwable
    //   301	303	186	java/lang/Throwable
    //   303	312	186	java/lang/Throwable
    //   316	376	186	java/lang/Throwable
    //   377	394	186	java/lang/Throwable
    //   398	551	186	java/lang/Throwable
    //   551	610	186	java/lang/Throwable
    //   611	620	186	java/lang/Throwable
    //   63	97	297	finally
    //   298	301	297	finally
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    paramEmoticonPackage = new batm(localArrayList, localHashMap, "vipEmoticonKey_cover_" + paramEmoticonPackage.epId);
    paramEmoticonPackage.jdField_e_of_type_Long = this.jdField_e_of_type_Int;
    paramEmoticonPackage.n = true;
    a().a(paramEmoticonPackage, this.jdField_b_of_type_Batl, localBundle);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, long paramLong, String paramString)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "download emoji report actionResult=" + paramInt + ",epId=" + paramEmoticonPackage.epId + ",downloadTime=" + paramLong);
    }
    int i = 0;
    if (paramInt != 0) {
      i = 1;
    }
    paramInt = badq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "EMOJI_DOWN", "actEmoPackage", 0, i, paramEmoticonPackage.epId + "", paramInt + "", paramString, String.valueOf(paramLong));
      return;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, batl parambatl, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "package download epId:" + paramEmoticonPackage.epId);
    }
    if ((paramEmoticonPackage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "ep or mApp = null");
      return;
    }
    if (!badq.d(BaseApplication.getContext()))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "netUnSupport epId=" + paramEmoticonPackage.epId);
      jdField_a_of_type_Anfi.a(paramEmoticonPackage, 11003, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bapm.a("emotionType", "emotionActionDownload", "2", paramEmoticonPackage.epId, "", "", "", "", "", "");
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
    label248:
    Object localObject2;
    label267:
    label370:
    File localFile;
    if ((paramEmoticonPackage.jobType == 3) && (paramEmoticonPackage.isMagicFaceDownloading))
    {
      localObject1 = "vipEmoticonKey_auto_" + paramEmoticonPackage.epId;
      if (paramEmoticonPackage.jobType == 3)
      {
        e(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        localObject2 = new batm(localArrayList, localHashMap, (String)localObject1);
        if (!((String)localObject1).contains("auto")) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEmoticonPackage.epId, new angr(paramEmoticonPackage.epId, (batm)localObject2));
        }
        ((batm)localObject2).n = true;
        if (localArrayList.size() != 0) {
          break label986;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| urlList is empty");
        }
        ((batm)localObject2).a(localBundle);
        ((batm)localObject2).a(3);
        parambatl.onDone((batm)localObject2);
        if (paramEmoticonPackage.jobType != 5) {
          break label1018;
        }
        b(paramEmoticonPackage, paramBoolean1);
      }
    }
    else
    {
      if (paramEmoticonPackage.jobType == 5)
      {
        ((baov)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.a(paramEmoticonPackage, paramBoolean1, paramBoolean2);
        return;
      }
      localObject2 = "vipEmoticonKey_" + paramEmoticonPackage.epId;
      localObject1 = anam.a(paramEmoticonPackage.epId);
      if (paramEmoticonPackage.jobType == 4) {
        localObject1 = anjd.c.replace("[epId]", paramEmoticonPackage.epId);
      }
      localFile = new File(anjd.r.replace("[epId]", paramEmoticonPackage.epId));
      localObject1 = new batm((String)localObject1, localFile);
      angr localangr = new angr(paramEmoticonPackage.epId, (batm)localObject1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(jdField_b_of_type_JavaLangString + paramEmoticonPackage.epId, localangr);
      ((batm)localObject1).g = jdField_b_of_type_Boolean;
      ((batm)localObject1).j = true;
      ((batm)localObject1).n = true;
      paramInt = bato.a((batm)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(jdField_b_of_type_JavaLangString + paramEmoticonPackage.epId);
      jdField_a_of_type_Anfi.a(paramEmoticonPackage, paramInt);
      if (paramInt != 0)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "json download faile : resultCode = " + paramInt);
        paramInt = anam.a(paramInt);
        jdField_a_of_type_Anfi.a(paramEmoticonPackage, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        bapm.a("emotionType", "emotionActionDownload", "3", paramEmoticonPackage.epId, "", badq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
        return;
      }
      paramBoolean2 = anjd.a(paramEmoticonPackage);
      if (((paramEmoticonPackage.jobType == 0) || (paramEmoticonPackage.jobType == 4)) && (!paramBoolean2)) {
        a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      }
      b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      if (paramEmoticonPackage.isAPNG == 2)
      {
        paramInt = 42;
        label815:
        if (paramEmoticonPackage.jobType != 5) {
          break label947;
        }
        paramInt = 6;
      }
    }
    label1027:
    for (;;)
    {
      paramInt = a(localFile, paramEmoticonPackage, paramBoolean2, localArrayList, localHashMap, localBundle, paramInt);
      if (paramInt != 0)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "handleEmotionPackage|addEmotionsTask fail : resultCode = " + paramInt);
        jdField_a_of_type_Anfi.a(paramEmoticonPackage, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        bapm.a("emotionType", "emotionActionDownload", "5", paramEmoticonPackage.epId, "", "", paramInt + "", "", "", "");
        return;
        paramInt = 14;
        break label815;
        label947:
        if (paramEmoticonPackage.jobType != 3) {
          break label1027;
        }
        paramInt |= 0x1;
        continue;
        if (paramEmoticonPackage.jobType != 5) {
          break label267;
        }
        f(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        break label267;
        label986:
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| startDownload");
        }
        a().a((batm)localObject2, parambatl, localBundle);
        break label370;
        label1018:
        break;
      }
      localObject1 = localObject2;
      break label248;
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
    label137:
    do
    {
      return;
      if (paramInt == 0) {
        paramEmoticonPackage.aio = true;
      }
      angr localangr;
      for (;;)
      {
        localObject = (angr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramEmoticonPackage.epId);
        localangr = (angr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(jdField_b_of_type_JavaLangString + paramEmoticonPackage.epId);
        if (localObject == null) {
          break label137;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "pullEmoticonPackage task exist epId = " + paramEmoticonPackage.epId);
        return;
        if (paramInt == 1) {
          paramEmoticonPackage.kandian = true;
        }
      }
      if (localangr == null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "pullEmoticonPackage jsonTask exist epId = " + paramEmoticonPackage.epId);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "try to pullEmoticonPackage ep:" + paramEmoticonPackage.epId);
    }
    if (!anam.a(paramEmoticonPackage.epId))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "ep.epId=" + paramEmoticonPackage.epId + " isNumeral false.");
      bapm.a("emotionType", "emotionActionDownload", "1", paramEmoticonPackage.epId, "", "", "", "", "", "");
      return;
    }
    if (!paramEmoticonPackage.isMagicFaceDownloading) {
      if ((paramEmoticonPackage.status != 2) || (!anjd.a(paramEmoticonPackage.updateFlag))) {
        break label415;
      }
    }
    for (;;)
    {
      paramEmoticonPackage.valid = true;
      a().a(paramEmoticonPackage);
      localObject = new File(ajed.bJ);
      if (!((File)localObject).exists())
      {
        boolean bool = ((File)localObject).mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "mkdirs success:" + bool);
        }
      }
      ThreadManager.excute(new EmojiManager.5(this, paramEmoticonPackage, paramBoolean1, paramBoolean2, paramInt), 128, null, true);
      return;
      label415:
      paramEmoticonPackage.status = 0;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = (angr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
    Object localObject = bace.a(???);
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
        bace.a(anjd.x.replace("[epId]", paramString1), ((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "", paramString1);
        return;
      }
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile h5 magic, childFiles is null");
  }
  
  public void a(String paramString, ArrayList<Emoticon> paramArrayList)
  {
    int i = anam.a(paramString);
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (i == -1)) {
      return;
    }
    int j = this.f;
    this.f = (j + 1);
    paramString = Integer.toString(j);
    ((ajhm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(i, paramArrayList, paramString);
  }
  
  public void a(String paramString, ArrayList<Emoticon> paramArrayList, angh paramangh)
  {
    int i = anam.a(paramString);
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (paramangh == null) || (i == -1)) {
      return;
    }
    paramString = new Object();
    ajhm localajhm = (ajhm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
    localajhm.a(new anfn(this, localajhm, paramangh, paramString));
    int j = this.f;
    this.f = (j + 1);
    String str = Integer.toString(j);
    paramangh.jdField_a_of_type_JavaLangString = str;
    paramangh.jdField_a_of_type_Int = 11022;
    localajhm.a(i, paramArrayList, str);
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
      String str2 = anam.b(j, str1);
      String str3 = anam.a(3, paramEmoticonPackage.epId);
      if (!bace.a(str3))
      {
        paramList.add(str2);
        paramMap.put(str2, new File(str3));
        paramBundle.putInt(str2, 3);
      }
      str1 = anam.b(i, str1);
      paramEmoticonPackage = anam.a(4, paramEmoticonPackage.epId);
      if (!bace.a(paramEmoticonPackage))
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "canPlayH5Magic isPlay = " + bool3 + ";isDPCSupport = " + bool4);
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
    anla localanla = new anla(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localanla.jdField_c_of_type_Int = 6;
    localanla.jdField_c_of_type_Boolean = paramEmoticon.isAPNG;
    paramEmoticon = a(paramEmoticon);
    if (paramEmoticon == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "sendEmojiToAio fail to download Emoticon");
      return false;
    }
    localanla.a = paramEmoticon;
    adje.a = localanla;
    return true;
  }
  
  public boolean a(Emoticon paramEmoticon, int paramInt)
  {
    File localFile = null;
    if (paramEmoticon == null) {}
    label2112:
    label2117:
    label2121:
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon|taskvalue:" + paramInt + "，epid:" + paramEmoticon.epId + "，eid=" + paramEmoticon.eId);
      }
      if (azzz.b())
      {
        if (azzz.b() < 1048576L)
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 1, "sdcard check, sdcard full .return.");
          bapm.a("emotionType", "emotionActionAIO", "1", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
          return false;
        }
      }
      else
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "sdcard check, has sdcard FALSE .return.");
        bapm.a("emotionType", "emotionActionAIO", "2", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
        return false;
      }
      Object localObject1;
      int i;
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo imgPreview.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis() + ",jobType:" + paramEmoticon.jobType);
        }
        localObject1 = c(paramEmoticon);
        if (!bace.a(localObject1[1]))
        {
          localObject1 = new batm(localObject1[0], new File(localObject1[1]));
          ((batm)localObject1).n = true;
          ((batm)localObject1).jdField_e_of_type_Int = jdField_b_of_type_Int;
          i = bato.a((batm)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (i != 0)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task preview down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
            bapm.a("emotionType", "emotionActionAIO", "3", paramEmoticon.epId, paramEmoticon.eId, badq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", i + "", "", "", "");
            return false;
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ret:" + i);
          }
        }
      }
      label592:
      Object localObject2;
      Object localObject3;
      if (((paramInt & 0x4) == 4) || ((paramInt & 0x20) == 32))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo gif.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        if (paramEmoticon.jobType == 1) {
          break label2117;
        }
        if ((paramInt & 0x20) != 32) {
          break label2112;
        }
        i = 2;
        localObject1 = a(paramEmoticon, i);
        localObject2 = new angh();
        if ((paramEmoticon.jobType != 3) && (TextUtils.isEmpty(paramEmoticon.encryptKey)))
        {
          localObject3 = new ArrayList();
          ((ArrayList)localObject3).add(paramEmoticon);
          a(paramEmoticon.epId, (ArrayList)localObject3, (angh)localObject2);
          if (TextUtils.isEmpty(paramEmoticon.encryptKey))
          {
            QLog.i(this.jdField_a_of_type_JavaLangString, 1, "Emoticon don't have encryptKey,epId=" + paramEmoticon.epId + ", eid=" + paramEmoticon.eId + " type=" + 4);
            bapm.a("emotionType", "emotionActionAIO", "4", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
            return false;
          }
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label2121;
        }
        boolean bool = bace.a(localObject1[1]);
        if (!bool)
        {
          localFile = new File(localObject1[1]);
          localObject1 = new batm(localObject1[0], localFile);
          ((batm)localObject1).n = true;
          ((batm)localObject1).jdField_e_of_type_Int = jdField_b_of_type_Int;
          i = bato.a((batm)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (i != 0)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task gif down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ":ret = " + i);
            bapm.a("emotionType", "emotionActionAIO", "5", paramEmoticon.epId, paramEmoticon.eId, badq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", i + "", "", "", "");
            return false;
          }
        }
        for (;;)
        {
          if ((!bool) && (paramEmoticon.jobType != 1))
          {
            try
            {
              localObject2 = bace.a(localFile);
              localObject3 = localFile.getAbsolutePath();
              localFile.delete();
              if (localObject2 == null)
              {
                QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task gif 2 fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
                bapm.a("emotionType", "emotionActionAIO", "6", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
                return false;
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress Emotiocon encode resource fail .EXCEPTION:" + localThrowable.toString() + " time:" + System.currentTimeMillis() + " url=" + ((batm)localObject1).c);
              }
              bapm.a("emotionType", "emotionActionAIO", "8", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
              return false;
            }
            if (paramEmoticon.jobType != 3) {
              i = anam.a((byte[])localObject2, paramEmoticon.encryptKey, (String)localObject3);
            }
          }
          for (;;)
          {
            if (i != 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress download encrypt exception, url=" + ((batm)localObject1).c);
              }
              if ((azzz.b()) && (azzz.b() > 1048576L)) {
                bace.a(ajed.aU + "err" + File.separator + String.valueOf(paramEmoticon.epId) + "_" + paramEmoticon.encryptKey + "_" + localThrowable.getName(), (byte[])localObject2, false);
              }
              QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task gif save fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";emosmCode = " + i);
              bapm.a("emotionType", "emotionActionAIO", "7", paramEmoticon.epId, paramEmoticon.eId, "", i + "", "", "", "");
              return false;
              if (paramEmoticon.jobType == 3) {
                i = anam.a((byte[])localObject2, (String)localObject3);
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress| Emotiocon encode resource done.result=" + i + " time:" + System.currentTimeMillis() + " url=" + ((batm)localObject1).c);
              }
              if ((paramInt & 0x1) == 1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo AIO preview static.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
                }
                localObject1 = b(paramEmoticon);
                if (!bace.a(localObject1[1]))
                {
                  localObject1 = new batm(localObject1[0], new File(localObject1[1]));
                  ((batm)localObject1).n = true;
                  ((batm)localObject1).jdField_e_of_type_Int = jdField_b_of_type_Int;
                  i = bato.a((batm)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  if (i != 0)
                  {
                    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task aio static down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";ret = " + i);
                    bapm.a("emotionType", "emotionActionAIO", "9", paramEmoticon.epId, paramEmoticon.eId, badq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", i + "", "", "", "");
                    return false;
                  }
                }
              }
              if ((paramEmoticon.isSound) && ((paramInt & 0x8) == 8))
              {
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo sound.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
                }
                localObject1 = a(paramEmoticon);
                if (!bace.a(localObject1[1]))
                {
                  localObject1 = new batm(localObject1[0], new File(localObject1[1]));
                  ((batm)localObject1).n = true;
                  ((batm)localObject1).jdField_e_of_type_Int = jdField_b_of_type_Int;
                  paramInt = bato.a((batm)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  if (paramInt != 0)
                  {
                    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task sound down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";ret = " + paramInt);
                    bapm.a("emotionType", "emotionActionAIO", "10", paramEmoticon.epId, paramEmoticon.eId, badq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
                    if (!paramEmoticon.isNewSoundEmoticon()) {
                      break;
                    }
                    a(paramEmoticon.epId, paramEmoticon.eId, ((batm)localObject1).jdField_a_of_type_Int);
                    return false;
                  }
                  if (paramEmoticon.isNewSoundEmoticon()) {
                    a(paramEmoticon.epId, paramEmoticon.eId, 0);
                  }
                }
              }
              return true;
            }
            i = 0;
          }
          localObject1 = null;
        }
        i = 0;
        break label592;
        localObject1 = null;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = d(paramString);
    a(paramString, bool);
    return bool;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    String str3 = anjd.n.replace("[epId]", paramString);
    String str1;
    int i;
    if (paramInt == h)
    {
      String str2 = arhc.a();
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
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str1);
      }
      paramString = bace.a(paramString).split("&");
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
      paramString = bace.a(paramString).split("&");
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
      ??? = (ArrayList)a().a(paramString);
      if (??? != null)
      {
        ??? = ((ArrayList)???).iterator();
        if (((Iterator)???).hasNext())
        {
          ??? = (Emoticon)((Iterator)???).next();
          if (??? == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((((Emoticon)???).jobType == 4) && ((((Emoticon)???).encryptKey == null) || (((Emoticon)???).encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, encrypt isn't exist.epId=" + paramString + " eId=" + ((Emoticon)???).eId);
            }
            return false;
          }
          if (!new File(anjd.p.replace("[epId]", paramString).replace("[eId]", ((Emoticon)???).eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, emo img preview do not be exist! epId=" + paramString + " eId=" + ((Emoticon)???).eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    ??? = new File(anjd.v.replace("[epId]", paramString));
    if ((??? != null) && (!((File)???).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, no root path: " + ???);
      }
      return false;
    }
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
          break label582;
        }
        ??? = new File(anjd.x.replace("[epId]", paramString));
        paramBoolean = ((File)???).exists();
        if (!paramBoolean) {
          return false;
        }
      }
      ??? = new JSONObject(bace.b((File)???));
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, error=" + MsfSdkUtils.getStackTraceString(paramString));
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
          label582:
          if (??? != null)
          {
            paramString = ((ArrayList)???).iterator();
            while (paramString.hasNext())
            {
              ??? = new File((String)paramString.next());
              if ((??? != null) && (!((File)???).exists()))
              {
                if (QLog.isColorLevel()) {
                  QLog.e(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, file miss: " + ???);
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
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a().a(paramString) != null) {}
    for (int i = 1;; i = 0) {
      return (i != 0) && (b(paramString, paramBoolean1, paramBoolean2));
    }
  }
  
  String[] a(Emoticon paramEmoticon)
  {
    return new String[] { anjd.e.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId), anjd.o.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId) };
  }
  
  String[] a(Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon.jobType == 3)
    {
      str1 = anjd.jdField_a_of_type_JavaLangString.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      if (paramInt != 2) {}
    }
    boolean bool;
    for (String str1 = anjd.jdField_b_of_type_JavaLangString.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);; str1 = anjd.f.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId))
    {
      str2 = anjd.s.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      if (paramInt == 2) {
        str2 = anjd.t.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
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
      str2 = anjd.i.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
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
    String str2 = anjd.h.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
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
        if (anam.a((String)localObject) == -1)
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
  
  void b(batm parambatm)
  {
    if (parambatm == null) {
      return;
    }
    Object localObject = parambatm.a();
    int i = ((Bundle)localObject).getInt(parambatm.c);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    localObject = (File)parambatm.jdField_a_of_type_JavaUtilMap.get(parambatm.c);
    switch (i)
    {
    default: 
      return;
    case 2: 
      jdField_a_of_type_Anfi.a(localEmoticonPackage, 2, 0, 0);
      return;
    case 21: 
      try
      {
        bace.a(((File)localObject).getAbsolutePath(), anjd.n.replace("[epId]", localEmoticonPackage.epId), false);
        ((File)localObject).delete();
        return;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          parambatm.jdField_a_of_type_Boolean = true;
          localIOException1.printStackTrace();
        }
      }
    }
    try
    {
      bace.a(((File)localObject).getAbsolutePath(), anjd.z.replace("[epId]", localIOException1.epId), false);
      this.jdField_a_of_type_Arga.b(localIOException1.epId);
      ((File)localObject).delete();
      return;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        parambatm.jdField_a_of_type_Boolean = true;
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| handle h5magic chiled emotion and childEpId = " + paramEmoticonPackage.childEpId);
    }
    if (paramBoolean)
    {
      localObject = (ajhm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
      if (localObject != null) {
        ((ajhm)localObject).a(paramEmoticonPackage.childEpId, 0);
      }
    }
    EmoticonPackage localEmoticonPackage = a().c(paramEmoticonPackage.childEpId, 0);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| old childEp = " + localEmoticonPackage);
    }
    Object localObject = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| childEpId = " + paramEmoticonPackage.childEpId);
      }
      localObject = new EmoticonPackage();
      ((EmoticonPackage)localObject).epId = paramEmoticonPackage.childEpId;
      ((EmoticonPackage)localObject).wordingId = -1L;
      ((EmoticonPackage)localObject).jobType = 5;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| auto download childEp = " + localObject);
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
        str = anam.b(i, str);
        paramEmoticonPackage = anam.a(2, paramEmoticonPackage.epId);
        if (!bace.a(paramEmoticonPackage))
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
    //   1: getfield 53	anfj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: sipush 149
    //   7: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10: checkcast 1378	ancg
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 1381	ancg:a	()Ljava/util/List;
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 53	anfj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: bipush 14
    //   28: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   31: checkcast 148	arnz
    //   34: aload_1
    //   35: getfield 146	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   38: invokevirtual 151	arnz:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   41: ifnonnull +14 -> 55
    //   44: aload_0
    //   45: aload_1
    //   46: getfield 146	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   49: getstatic 40	anfj:jdField_c_of_type_Int	I
    //   52: invokevirtual 168	anfj:a	(Ljava/lang/String;I)V
    //   55: aload 4
    //   57: astore_3
    //   58: aload_0
    //   59: getfield 1382	anfj:jdField_c_of_type_Boolean	Z
    //   62: ifne +121 -> 183
    //   65: aload 4
    //   67: ifnull +16 -> 83
    //   70: aload 4
    //   72: astore_3
    //   73: aload 4
    //   75: invokeinterface 1384 1 0
    //   80: ifeq +103 -> 183
    //   83: aload_0
    //   84: iconst_1
    //   85: putfield 1382	anfj:jdField_c_of_type_Boolean	Z
    //   88: invokestatic 1385	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   91: invokestatic 906	badq:d	(Landroid/content/Context;)Z
    //   94: ifne +5 -> 99
    //   97: iconst_0
    //   98: ireturn
    //   99: aload_0
    //   100: getfield 53	anfj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   103: bipush 103
    //   105: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   108: checkcast 1387	anch
    //   111: astore 6
    //   113: aload 4
    //   115: astore_3
    //   116: aload 6
    //   118: invokevirtual 1388	anch:a	()Z
    //   121: ifeq +62 -> 183
    //   124: new 4	java/lang/Object
    //   127: dup
    //   128: invokespecial 51	java/lang/Object:<init>	()V
    //   131: astore_3
    //   132: new 1390	anfp
    //   135: dup
    //   136: aload_0
    //   137: aload_3
    //   138: invokespecial 1393	anfp:<init>	(Lanfj;Ljava/lang/Object;)V
    //   141: astore 4
    //   143: aload_0
    //   144: getfield 53	anfj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   147: aload 4
    //   149: invokevirtual 1397	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lajfe;)V
    //   152: aload 6
    //   154: invokevirtual 1399	anch:c	()V
    //   157: aload_3
    //   158: monitorenter
    //   159: aload_3
    //   160: ldc2_w 169
    //   163: invokevirtual 174	java/lang/Object:wait	(J)V
    //   166: aload_3
    //   167: monitorexit
    //   168: aload_0
    //   169: getfield 53	anfj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   172: aload 4
    //   174: invokevirtual 1402	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lajfe;)V
    //   177: aload 5
    //   179: invokevirtual 1381	ancg:a	()Ljava/util/List;
    //   182: astore_3
    //   183: aload_3
    //   184: ifnull -87 -> 97
    //   187: iconst_0
    //   188: istore_2
    //   189: iload_2
    //   190: aload_3
    //   191: invokeinterface 746 1 0
    //   196: if_icmpge -99 -> 97
    //   199: aload_3
    //   200: iload_2
    //   201: invokeinterface 1403 2 0
    //   206: checkcast 1405	com/tencent/mobileqq/data/CustomEmotionData
    //   209: astore 4
    //   211: aload 4
    //   213: getfield 1408	com/tencent/mobileqq/data/CustomEmotionData:isMarkFace	Z
    //   216: ifeq +54 -> 270
    //   219: aload 4
    //   221: getfield 1411	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   224: aload_1
    //   225: getfield 146	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   228: invokevirtual 1350	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +39 -> 270
    //   234: aload 4
    //   236: getfield 1412	com/tencent/mobileqq/data/CustomEmotionData:eId	Ljava/lang/String;
    //   239: aload_1
    //   240: getfield 154	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   243: invokevirtual 1350	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   246: ifeq +24 -> 270
    //   249: ldc_w 1414
    //   252: aload 4
    //   254: getfield 1417	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   257: invokevirtual 1350	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   0	282	0	this	anfj
    //   0	282	1	paramEmoticon	Emoticon
    //   188	86	2	i	int
    //   57	210	3	localObject1	Object
    //   20	233	4	localObject2	Object
    //   13	165	5	localancg	ancg
    //   111	42	6	localanch	anch
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
        localObject1 = anjd.q.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
      bool1 = apdh.a((String)localObject1);
    }
    for (;;)
    {
      if ((bool1) && ((paramInt & 0x4) == 4)) {
        if (paramEmoticon.jobType != 1) {
          localObject1 = anjd.s.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
        }
      }
      for (boolean bool2 = apdh.a((String)localObject1);; bool2 = bool1)
      {
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if ((paramInt & 0x2) == 2) {
            bool1 = apdh.a(anjd.p.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
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
              bool2 = apdh.a(anjd.o.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
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
        return apdh.a(anjd.t.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
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
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((paramBoolean.jobType == 2) && ((paramBoolean.encryptKey == null) || (paramBoolean.encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
          if (!new File(anjd.p.replace("[epId]", paramString).replace("[eId]", paramBoolean.eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    String str1 = arhc.a();
    String str3 = anjd.n.replace("[epId]", paramString);
    String str2 = str3 + str1 + File.separator + "video.ini";
    File localFile = new File(str2);
    paramBoolean = localFile;
    if (!localFile.exists())
    {
      str1 = "big";
      str2 = str3 + "big" + File.separator + "video.ini";
      localFile = new File(str2);
      paramBoolean = localFile;
      if (!localFile.exists()) {
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str2);
    }
    paramBoolean = bace.a(paramBoolean);
    int j;
    if (paramBoolean != null)
    {
      paramBoolean = paramBoolean.split("&");
      j = paramBoolean.length;
      i = 0;
      while (i < j)
      {
        str2 = paramBoolean[i];
        if (!new File(str3 + str1 + File.separator + str2).exists()) {
          return false;
        }
        i += 1;
      }
    }
    paramBoolean = new File(str3 + "audio" + File.separator + "audio.ini");
    if (!paramBoolean.exists()) {
      return false;
    }
    paramBoolean = bace.a(paramBoolean);
    if (paramBoolean != null)
    {
      paramBoolean = paramBoolean.split("&");
      j = paramBoolean.length;
      i = 0;
      while (i < j)
      {
        str1 = paramBoolean[i];
        if (!new File(str3 + "audio" + File.separator + str1).exists()) {
          return false;
        }
        i += 1;
      }
    }
    if (!a(paramString, h)) {
      return false;
    }
    paramBoolean = a().a(paramString);
    if (paramBoolean != null) {}
    for (int i = paramBoolean.rscType;; i = 0)
    {
      if (1 == i) {
        return argh.a(anjd.z.replace("[epId]", paramString));
      }
      paramBoolean = (ArrayList)a().a(paramString);
      if ((paramBoolean != null) && (paramBoolean.size() > 0) && (!new File(anjd.s.replace("[epId]", paramString).replace("[eId]", ((Emoticon)paramBoolean.get(0)).eId)).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + ((Emoticon)paramBoolean.get(0)).eId);
        }
        return false;
      }
      return true;
    }
  }
  
  public boolean b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, epId = " + paramString + ", needKey = " + paramBoolean1 + ", needCheckChild = " + paramBoolean2);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool2 = a(paramString, paramBoolean1);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, result = " + bool2);
    }
    EmoticonPackage localEmoticonPackage = a().a(paramString);
    if (localEmoticonPackage != null) {
      if ((paramBoolean2) && (!TextUtils.isEmpty(localEmoticonPackage.childEpId)))
      {
        paramBoolean1 = a(localEmoticonPackage.childEpId, paramBoolean1);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, childEpId = " + localEmoticonPackage.childEpId + ", childResult = " + paramBoolean1);
        }
        a(localEmoticonPackage.childEpId, paramBoolean1);
        if ((bool2) && (paramBoolean1))
        {
          paramBoolean1 = bool1;
          label220:
          a(paramString, paramBoolean1);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, epId=" + paramString + ", result=" + paramBoolean1);
      }
      return paramBoolean1;
      paramBoolean1 = false;
      break label220;
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
      str = anjd.j.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
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
        paramEmoticon = anjd.q.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
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
      String str = anam.a(paramEmoticonPackage.epId, 1);
      paramEmoticonPackage = anjd.y.replace("[epId]", paramEmoticonPackage.epId);
      if (!bace.a(paramEmoticonPackage))
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
    Object localObject = anam.a(2, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_thumb isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = anam.a(3, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_color isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = anam.a(4, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_gray isn't exist." + (String)localObject);
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
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
          }
          return false;
        }
        if (!new File(anjd.p.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId)).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
        localObject = a().a(paramString, -1);
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {}
        for (localObject = anjd.t.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId); !new File((String)localObject).exists(); localObject = anjd.s.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emoticons do not be exist.epId=" + paramString);
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
      String str = anam.a(paramEmoticonPackage.epId, 0);
      paramEmoticonPackage = anjd.y.replace("[epId]", paramEmoticonPackage.epId);
      if (!bace.a(paramEmoticonPackage))
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
          localObject = anam.a(2, paramString);
          if (new File((String)localObject).exists()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_thumb isn't exist." + (String)localObject);
        return false;
        localObject = anam.a(3, paramString);
        if (new File((String)localObject).exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_color isn't exist." + (String)localObject);
      return false;
      localObject = anam.a(4, paramString);
      if (new File((String)localObject).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_gray isn't exist." + (String)localObject);
    return false;
    Object localObject = (ArrayList)a().a(paramString, true);
    EmoticonPackage localEmoticonPackage;
    if (localObject != null)
    {
      localEmoticonPackage = a().a(paramString, -1);
      if (localEmoticonPackage == null) {
        break label623;
      }
    }
    label585:
    label623:
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
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
            return false;
          }
          if ((localEmoticon.jobType == 0) && ((localEmoticon.encryptKey == null) || (localEmoticon.encryptKey.length() == 0)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          if (!new File(anjd.p.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId)).exists())
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          if (1 == i) {
            return argh.a(anjd.z.replace("[epId]", paramString));
          }
          if ((localEmoticonPackage != null) && (localEmoticonPackage.isAPNG == 2)) {}
          for (localObject = anjd.t.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId);; localObject = anjd.s.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId))
          {
            if (new File((String)localObject).exists()) {
              break label585;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
            return false;
          }
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
          }
        }
      }
      return true;
    }
  }
  
  void e(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage|add magic task ");
    }
    c(paramList, paramMap, paramEmoticonPackage, paramBundle);
    d(paramList, paramMap, paramEmoticonPackage, paramBundle);
  }
  
  public boolean e(String paramString)
  {
    return new File(anjd.n.replace("[epId]", paramString) + "audio" + File.separator + "audio.ini").exists();
  }
  
  void f(List<String> paramList, Map<String, File> paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage|add h5magic task ");
    }
    if (!b(paramEmoticonPackage.epId, true, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| add h5 zip url");
      }
      String str = anam.b(paramEmoticonPackage.epId);
      paramEmoticonPackage = anam.c(paramEmoticonPackage.epId);
      if (paramEmoticonPackage != null)
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 20);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    jdField_a_of_type_Anfi.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anfj
 * JD-Core Version:    0.7.0.1
 */