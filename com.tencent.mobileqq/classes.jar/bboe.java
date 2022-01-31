import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class bboe
{
  public static bbog a;
  public static bboi a;
  static bbwt a;
  public static String a;
  public static HashMap<String, Boolean> a;
  public static bboi[] a;
  public static bboi b;
  public static bboi c;
  public static bboi d;
  public static bboi e;
  public static bboi f;
  public static bboi g;
  public static bboi h;
  public static bboi i;
  
  static
  {
    jdField_a_of_type_Bboi = new bboi("recommendEmotion.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aioPanal/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aioPanal/xydata.json", "recommendEmotionVersion", "vipData_emoji_aio_recommend.json");
    b = new bboi("IndividuationUrls.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation_url/android.json", "individuationUrlJsonNewVersion", "vipData_individuation_url_json");
    c = new bboi("Individuation.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/xydata.json", "IndividuationVersion", "individ_json");
    d = new bboi("EmoticonWording.json", "", "https://i.gtimg.cn/club/item/parcel/client_wording.json", "EmoticonWordingVersion", "wording_json");
    e = new bboi("WebviewCrashReport.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/vip_crash_report/WebviewCrashReport.json", "WebviewCrashJSONVersion", "WebviewCrashReport.json");
    f = new bboi("Qutu_xydata.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/vipQutu_release_zip/xydata.json", "QutuXYDataJsonVersion", "xydata.json");
    g = new bboi("iRedPacket_v2.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipRedPacketDataV2/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipRedPacketDataV2/xydata.mobile.v1.json", "vipRedPacketData_json_v2", "vipRedPacketData_json_v2");
    h = new bboi("UrlIntercept.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_url_to_api", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_url_to_api/android.json", "UrlIntercept_json", "UrlIntercept_json");
    i = new bboi("font_info.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipList_font_data", "https://i.gtimg.cn/qqshow/admindata/comdata/vipList_font_data/version.json", "FontInfoList_json", "FontInfoList_json");
    jdField_a_of_type_ArrayOfBboi = new bboi[] { jdField_a_of_type_Bboi, c, d };
    jdField_a_of_type_JavaLangString = "https://i.gtimg.cn/xydata";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_Bbwt = new bbof();
  }
  
  public static int a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("clubContentVersion", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "--getJsonVersion ,key=" + paramString + ",version:" + paramContext.getInt(paramString, 0));
    }
    return paramContext.getInt(paramString, 0);
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, bboi parambboi, boolean paramBoolean)
  {
    Object localObject = paramQQAppInterface.getApplication().getApplicationContext();
    String str = parambboi.jdField_a_of_type_JavaLangString;
    localObject = new File(((Context)localObject).getFilesDir(), str);
    if (((File)localObject).exists()) {
      try
      {
        paramQQAppInterface = bbdx.a((File)localObject, -1);
        if (paramQQAppInterface == null) {}
      }
      catch (Throwable paramQQAppInterface)
      {
        for (;;)
        {
          try
          {
            paramQQAppInterface = new JSONObject(paramQQAppInterface);
            return paramQQAppInterface;
          }
          catch (Throwable paramQQAppInterface)
          {
            QLog.e("ClubContentJsonTask", 2, "getJsonFromLocalFile new Json err,json_name:" + str + ", msg:" + paramQQAppInterface.getMessage());
            ((File)localObject).delete();
          }
          paramQQAppInterface = paramQQAppInterface;
          QLog.e("ClubContentJsonTask", 2, "getJsonFromLocalFile err,json_name:" + str + ", msg:" + paramQQAppInterface.getMessage());
          paramQQAppInterface = null;
        }
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.w("ClubContentJsonTask", 2, "getJsonFromLocalFile not exist,json_name:" + str + " _ " + paramBoolean);
      }
      if (paramBoolean) {
        a(paramQQAppInterface, parambboi);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "setJsonVersion ,key=" + paramString + ",version:" + paramInt);
    }
    paramContext.getSharedPreferences("clubContentVersion", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(AppInterface paramAppInterface, bboi parambboi, String paramString, File paramFile, Bundle paramBundle)
  {
    if (paramFile == null) {}
    String str1;
    do
    {
      return;
      str1 = paramString;
    } while ((paramString == null) && (parambboi == null));
    label427:
    label435:
    label441:
    label444:
    for (;;)
    {
      try
      {
        for (;;)
        {
          str1 = parambboi.b;
          if (parambboi == null) {
            break label427;
          }
          parambboi = parambboi.jdField_a_of_type_JavaLangString;
          paramString = paramBundle.getString("method");
          if (paramString != null) {
            break label444;
          }
          paramString = "other";
          String str2 = paramBundle.getString("ifromet");
          if (str2 != null) {
            break label441;
          }
          str2 = "false";
          if (!paramBundle.containsKey("forceUpdate")) {
            break label435;
          }
          bool = paramBundle.getBoolean("forceUpdate");
          int j = paramBundle.getInt("version", 0);
          String str3 = parambboi + "_" + j;
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, "club_downloadFile,method:" + paramString + ",key:" + parambboi + ", server version:" + j + ",ifromet:" + str2);
          }
          if ((!bool) && (jdField_a_of_type_JavaUtilHashMap.containsKey(str3)) && (((Boolean)jdField_a_of_type_JavaUtilHashMap.get(str3)).booleanValue())) {
            break;
          }
          jdField_a_of_type_JavaUtilHashMap.put(str3, Boolean.valueOf(true));
          paramFile = new bbwu(str1, paramFile);
          paramFile.n = true;
          paramFile.jdField_a_of_type_JavaLangString = parambboi;
          ((bbww)paramAppInterface.getManager(47)).a(1).a(paramFile, jdField_a_of_type_Bbwt, paramBundle);
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, paramString + ",cdownloadFile url=" + str1);
          }
          try
          {
            paramString = new HashMap();
            paramString.put("param_key", parambboi);
            paramString.put("param_ifromet", str2);
            axrn.a(paramAppInterface.getApplication().getApplicationContext()).a(paramAppInterface.getAccount(), "VipClubContentJsonTaskLoad", true, 1L, 0L, paramString, "", false);
          }
          catch (Exception paramAppInterface) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ClubContentJsonTask", 2, "downloadFile, downloadFile error=" + paramAppInterface.toString());
        break;
      }
      finally {}
      parambboi = paramFile.getName();
      continue;
      boolean bool = false;
      continue;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApplication().getApplicationContext();
    int j = 0;
    while (j < jdField_a_of_type_ArrayOfBboi.length)
    {
      a(paramQQAppInterface, jdField_a_of_type_ArrayOfBboi[j]);
      j += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bboi parambboi)
  {
    int j = 10;
    int k = 0;
    if ((paramQQAppInterface == null) || (parambboi == null)) {}
    do
    {
      return;
      File localFile = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), parambboi.jdField_a_of_type_JavaLangString);
      if (!localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, not exist: " + parambboi.jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          try
          {
            localObject = String.valueOf(NetConnInfoCenter.getServerTime());
            if (((String)localObject).length() <= 10) {
              continue;
            }
            localObject = ((String)localObject).substring(0, j);
            j = k;
            if (Long.parseLong((String)localObject) < 2147483647L) {
              j = Integer.parseInt((String)localObject);
            }
          }
          catch (Exception localException)
          {
            Object localObject;
            QLog.e("ClubContentJsonTask", 1, "downloadIfNotExist, Integer.parseInt Err:" + localException.getMessage());
            j = k;
            continue;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putInt("version", j);
          ((Bundle)localObject).putString("version_key", parambboi.d);
          ((Bundle)localObject).putString("method", "downloadIfNotExist");
          ((Bundle)localObject).putString("ifromet", "null1");
          a(paramQQAppInterface, parambboi, anqz.a("VIP_emosm", parambboi.b), localFile, (Bundle)localObject);
          return;
          j = ((String)localObject).length();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, exists.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bboi parambboi, int paramInt, boolean paramBoolean)
  {
    File localFile = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), parambboi.jdField_a_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localBundle.putInt("version", paramInt);
    localBundle.putString("version_key", parambboi.d);
    localBundle.putString("method", "updateJson");
    localBundle.putString("ifromet", String.valueOf(paramBoolean));
    a(paramQQAppInterface, parambboi, null, localFile, localBundle);
  }
  
  /* Error */
  public static void b(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 454
    //   4: iconst_0
    //   5: aconst_null
    //   6: invokestatic 460	com/tencent/mobileqq/vas/VasQuickUpdateManager:getJSONFromLocal	(Lmqq/app/AppRuntime;Ljava/lang/String;ZLcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)Lorg/json/JSONObject;
    //   9: astore 6
    //   11: aload 6
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: getstatic 465	ho:jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   20: iconst_0
    //   21: invokevirtual 471	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   24: new 473	bbog
    //   27: dup
    //   28: invokespecial 474	bbog:<init>	()V
    //   31: putstatic 476	bboe:jdField_a_of_type_Bbog	Lbbog;
    //   34: aload 6
    //   36: ldc_w 478
    //   39: invokevirtual 481	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   42: istore_1
    //   43: iload_1
    //   44: ifeq +15 -> 59
    //   47: aload_0
    //   48: ldc_w 483
    //   51: iload_1
    //   52: invokestatic 486	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   55: invokestatic 491	bbsg:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;)Z
    //   58: pop
    //   59: aload 6
    //   61: ldc_w 493
    //   64: invokevirtual 496	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   67: ifeq +689 -> 756
    //   70: aload 6
    //   72: ldc_w 493
    //   75: invokevirtual 500	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +168 -> 250
    //   85: aload 4
    //   87: invokevirtual 503	org/json/JSONArray:length	()I
    //   90: ifle +160 -> 250
    //   93: iconst_0
    //   94: istore_1
    //   95: iload_1
    //   96: aload 4
    //   98: invokevirtual 503	org/json/JSONArray:length	()I
    //   101: if_icmpge +149 -> 250
    //   104: aload 4
    //   106: iload_1
    //   107: invokevirtual 506	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   110: checkcast 219	org/json/JSONObject
    //   113: astore 5
    //   115: aload 5
    //   117: ldc_w 508
    //   120: invokevirtual 496	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   123: ifeq +639 -> 762
    //   126: aload 5
    //   128: ldc_w 508
    //   131: invokevirtual 510	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   134: istore_2
    //   135: goto +686 -> 821
    //   138: aload 5
    //   140: ldc_w 512
    //   143: invokevirtual 496	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   146: ifeq +621 -> 767
    //   149: aload 5
    //   151: ldc_w 512
    //   154: invokevirtual 513	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 4
    //   159: aload 5
    //   161: ldc_w 515
    //   164: invokevirtual 496	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   167: ifeq +666 -> 833
    //   170: aload 5
    //   172: ldc_w 515
    //   175: invokevirtual 513	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore 5
    //   180: getstatic 476	bboe:jdField_a_of_type_Bbog	Lbbog;
    //   183: aload 4
    //   185: putfield 516	bbog:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   188: getstatic 476	bboe:jdField_a_of_type_Bbog	Lbbog;
    //   191: aload 5
    //   193: putfield 517	bbog:b	Ljava/lang/String;
    //   196: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +51 -> 250
    //   202: ldc 157
    //   204: iconst_2
    //   205: new 159	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 519
    //   215: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload_2
    //   219: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: ldc_w 521
    //   225: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 4
    //   230: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 523
    //   236: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 5
    //   241: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload 6
    //   252: ldc_w 525
    //   255: invokevirtual 529	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   258: astore 4
    //   260: aload 4
    //   262: ifnull +274 -> 536
    //   265: aload 4
    //   267: ldc_w 531
    //   270: invokevirtual 481	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   273: iconst_1
    //   274: if_icmpne +573 -> 847
    //   277: iconst_1
    //   278: istore_3
    //   279: iload_3
    //   280: putstatic 533	ho:jdField_e_of_type_Boolean	Z
    //   283: getstatic 533	ho:jdField_e_of_type_Boolean	Z
    //   286: ifeq +488 -> 774
    //   289: aload 4
    //   291: ldc_w 535
    //   294: invokevirtual 481	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   297: iconst_1
    //   298: if_icmpne +554 -> 852
    //   301: iconst_1
    //   302: istore_3
    //   303: iload_3
    //   304: putstatic 537	ho:jdField_f_of_type_Boolean	Z
    //   307: aload 4
    //   309: ldc_w 539
    //   312: invokevirtual 543	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   315: d2f
    //   316: putstatic 546	ho:a	F
    //   319: aload 4
    //   321: ldc_w 548
    //   324: invokevirtual 543	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   327: d2f
    //   328: putstatic 550	ho:jdField_b_of_type_Float	F
    //   331: aload 4
    //   333: ldc_w 552
    //   336: invokevirtual 543	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   339: d2f
    //   340: putstatic 554	ho:jdField_c_of_type_Float	F
    //   343: aload 4
    //   345: ldc_w 556
    //   348: invokevirtual 543	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   351: d2f
    //   352: putstatic 558	ho:d	F
    //   355: aload 4
    //   357: ldc_w 560
    //   360: invokevirtual 543	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   363: d2f
    //   364: putstatic 562	ho:jdField_e_of_type_Float	F
    //   367: aload 4
    //   369: ldc_w 564
    //   372: invokevirtual 543	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   375: d2f
    //   376: putstatic 566	ho:jdField_f_of_type_Float	F
    //   379: aload 4
    //   381: ldc_w 568
    //   384: invokevirtual 481	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   387: putstatic 571	ho:jdField_b_of_type_Int	I
    //   390: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +115 -> 508
    //   396: ldc 157
    //   398: iconst_2
    //   399: new 159	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 573
    //   409: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: getstatic 537	ho:jdField_f_of_type_Boolean	Z
    //   415: invokevirtual 243	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   418: ldc_w 575
    //   421: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: getstatic 546	ho:a	F
    //   427: invokevirtual 578	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   430: ldc_w 580
    //   433: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: getstatic 550	ho:jdField_b_of_type_Float	F
    //   439: invokevirtual 578	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   442: ldc_w 582
    //   445: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: getstatic 554	ho:jdField_c_of_type_Float	F
    //   451: invokevirtual 578	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   454: ldc_w 584
    //   457: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: getstatic 558	ho:d	F
    //   463: invokevirtual 578	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   466: ldc_w 586
    //   469: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: getstatic 562	ho:jdField_e_of_type_Float	F
    //   475: invokevirtual 578	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   478: ldc_w 588
    //   481: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: getstatic 566	ho:jdField_f_of_type_Float	F
    //   487: invokevirtual 578	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   490: ldc_w 590
    //   493: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: getstatic 571	ho:jdField_b_of_type_Int	I
    //   499: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: getstatic 465	ho:jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   511: iconst_1
    //   512: invokevirtual 471	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   515: getstatic 595	aebx:a	Lcom/tencent/util/LRULinkedHashMap;
    //   518: astore 4
    //   520: aload 4
    //   522: monitorenter
    //   523: getstatic 595	aebx:a	Lcom/tencent/util/LRULinkedHashMap;
    //   526: invokevirtual 600	com/tencent/util/LRULinkedHashMap:clear	()V
    //   529: aload 4
    //   531: monitorexit
    //   532: aload_0
    //   533: invokestatic 605	bblj:a	(Lcom/tencent/common/app/AppInterface;)V
    //   536: aload 6
    //   538: ldc_w 607
    //   541: invokevirtual 529	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   544: astore_0
    //   545: aload_0
    //   546: ifnull +252 -> 798
    //   549: aload_0
    //   550: ldc_w 609
    //   553: iconst_0
    //   554: invokevirtual 611	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   557: iconst_1
    //   558: if_icmpne +299 -> 857
    //   561: iconst_1
    //   562: istore_3
    //   563: iload_3
    //   564: putstatic 615	com/tencent/mobileqq/app/SignatureManager:a	Z
    //   567: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +32 -> 602
    //   573: ldc_w 617
    //   576: iconst_2
    //   577: new 159	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 619
    //   587: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: getstatic 615	com/tencent/mobileqq/app/SignatureManager:a	Z
    //   593: invokevirtual 243	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   596: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: aload 6
    //   604: ldc_w 621
    //   607: invokevirtual 529	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   610: astore_0
    //   611: aload_0
    //   612: ifnull +16 -> 628
    //   615: aload_0
    //   616: ldc_w 623
    //   619: sipush 300
    //   622: invokevirtual 611	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   625: putstatic 627	aqxj:jdField_a_of_type_Int	I
    //   628: aload 6
    //   630: ldc_w 629
    //   633: invokevirtual 529	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   636: astore_0
    //   637: aload_0
    //   638: ifnull +68 -> 706
    //   641: aload_0
    //   642: ldc_w 631
    //   645: invokevirtual 481	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   648: istore_1
    //   649: iload_1
    //   650: ifle +19 -> 669
    //   653: new 633	java/util/Random
    //   656: dup
    //   657: invokespecial 634	java/util/Random:<init>	()V
    //   660: iload_1
    //   661: invokevirtual 638	java/util/Random:nextInt	(I)I
    //   664: iconst_1
    //   665: iadd
    //   666: putstatic 641	hv:jdField_a_of_type_Int	I
    //   669: getstatic 644	hv:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   672: aload_0
    //   673: ldc_w 646
    //   676: invokevirtual 481	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   679: invokevirtual 651	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   682: getstatic 653	hv:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   685: astore 4
    //   687: aload_0
    //   688: ldc_w 655
    //   691: invokevirtual 481	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   694: iconst_1
    //   695: if_icmpne +116 -> 811
    //   698: iconst_1
    //   699: istore_3
    //   700: aload 4
    //   702: iload_3
    //   703: invokevirtual 471	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   706: aload 6
    //   708: ldc_w 657
    //   711: invokevirtual 529	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   714: astore_0
    //   715: aload_0
    //   716: ifnull -700 -> 16
    //   719: getstatic 660	bbos:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   722: astore 4
    //   724: aload_0
    //   725: ldc_w 531
    //   728: invokevirtual 481	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   731: iconst_1
    //   732: if_icmpne +84 -> 816
    //   735: iconst_1
    //   736: istore_3
    //   737: aload 4
    //   739: iload_3
    //   740: invokevirtual 471	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   743: return
    //   744: astore_0
    //   745: ldc 157
    //   747: iconst_1
    //   748: ldc_w 662
    //   751: aload_0
    //   752: invokestatic 665	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   755: return
    //   756: aconst_null
    //   757: astore 4
    //   759: goto -679 -> 80
    //   762: iconst_m1
    //   763: istore_2
    //   764: goto +57 -> 821
    //   767: ldc 44
    //   769: astore 4
    //   771: goto -612 -> 159
    //   774: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq -269 -> 508
    //   780: ldc 157
    //   782: iconst_2
    //   783: ldc_w 667
    //   786: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   789: goto -281 -> 508
    //   792: astore_0
    //   793: aload 4
    //   795: monitorexit
    //   796: aload_0
    //   797: athrow
    //   798: ldc_w 669
    //   801: iconst_1
    //   802: ldc_w 671
    //   805: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: goto -206 -> 602
    //   811: iconst_0
    //   812: istore_3
    //   813: goto -113 -> 700
    //   816: iconst_0
    //   817: istore_3
    //   818: goto -81 -> 737
    //   821: iload_2
    //   822: ifeq -684 -> 138
    //   825: iload_2
    //   826: iconst_2
    //   827: if_icmpne +13 -> 840
    //   830: goto -692 -> 138
    //   833: ldc 44
    //   835: astore 5
    //   837: goto -657 -> 180
    //   840: iload_1
    //   841: iconst_1
    //   842: iadd
    //   843: istore_1
    //   844: goto -749 -> 95
    //   847: iconst_0
    //   848: istore_3
    //   849: goto -570 -> 279
    //   852: iconst_0
    //   853: istore_3
    //   854: goto -551 -> 303
    //   857: iconst_0
    //   858: istore_3
    //   859: goto -296 -> 563
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	862	0	paramQQAppInterface	QQAppInterface
    //   42	802	1	j	int
    //   134	694	2	k	int
    //   278	581	3	bool	boolean
    //   113	723	5	localObject2	Object
    //   9	698	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   24	43	744	java/lang/Exception
    //   47	59	744	java/lang/Exception
    //   59	80	744	java/lang/Exception
    //   85	93	744	java/lang/Exception
    //   95	135	744	java/lang/Exception
    //   138	159	744	java/lang/Exception
    //   159	180	744	java/lang/Exception
    //   180	250	744	java/lang/Exception
    //   250	260	744	java/lang/Exception
    //   265	277	744	java/lang/Exception
    //   279	301	744	java/lang/Exception
    //   303	508	744	java/lang/Exception
    //   508	523	744	java/lang/Exception
    //   532	536	744	java/lang/Exception
    //   536	545	744	java/lang/Exception
    //   549	561	744	java/lang/Exception
    //   563	602	744	java/lang/Exception
    //   602	611	744	java/lang/Exception
    //   615	628	744	java/lang/Exception
    //   628	637	744	java/lang/Exception
    //   641	649	744	java/lang/Exception
    //   653	669	744	java/lang/Exception
    //   669	698	744	java/lang/Exception
    //   700	706	744	java/lang/Exception
    //   706	715	744	java/lang/Exception
    //   719	735	744	java/lang/Exception
    //   737	743	744	java/lang/Exception
    //   774	789	744	java/lang/Exception
    //   796	798	744	java/lang/Exception
    //   798	808	744	java/lang/Exception
    //   523	532	792	finally
    //   793	796	792	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bboe
 * JD-Core Version:    0.7.0.1
 */