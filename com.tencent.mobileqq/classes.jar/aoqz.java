import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.2;
import com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.5;
import com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.6;
import com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.7;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aoqz
  extends aopk
{
  private aorf jdField_a_of_type_Aorf;
  private bhxj jdField_a_of_type_Bhxj;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  
  aoqz(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
    QLog.i("ArkApp.downloadyyb.module", 1, "init");
    bhyo.a();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new aorb(this);
  }
  
  private void a(int paramInt, JSONArray paramJSONArray, long paramLong)
  {
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject1;
      Object localObject2;
      try
      {
        int j = paramJSONArray.length();
        localArrayList = new ArrayList();
        i = 0;
        if (i < j)
        {
          localObject1 = paramJSONArray.getJSONObject(i);
          localObject2 = new DownloadInfo();
          ((DownloadInfo)localObject2).jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("url");
          ((DownloadInfo)localObject2).jdField_e_of_type_JavaLangString = ((JSONObject)localObject1).optString("packageName");
          ((DownloadInfo)localObject2).jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("versionCode");
          ((DownloadInfo)localObject2).jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("appId");
          ((DownloadInfo)localObject2).a();
          localArrayList.add(localObject2);
          i += 1;
          continue;
        }
        QLog.d("ArkApp.downloadyyb.module", 1, "queryPackageStateYYB action is " + paramInt);
        switch (paramInt)
        {
        default: 
          return;
        }
      }
      catch (Exception paramJSONArray)
      {
        int i;
        QLog.e("ArkApp.downloadyyb.module", 1, "[innerQuery] e=", paramJSONArray);
        return;
      }
      try
      {
        paramJSONArray = new JSONArray();
        i = localArrayList.size();
        paramInt = 0;
        if (paramInt < i)
        {
          localObject1 = (DownloadInfo)localArrayList.get(paramInt);
          localObject1 = bhyo.a().b(((DownloadInfo)localObject1).jdField_d_of_type_JavaLangString);
          if (localObject1 == null) {
            break label419;
          }
          paramJSONArray.put(a((DownloadInfo)localObject1));
          break label419;
        }
        paramJSONArray = paramJSONArray.toString();
        ArkAppCenter.a().post(this.jdField_a_of_type_JavaLangString, new ArkAppYYBDownloadModule.5(this, paramLong, paramJSONArray));
        return;
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("ArkApp.downloadyyb.module", 1, "queryPackageStateYYB : " + paramJSONArray);
        return;
      }
      if (localArrayList.size() > 0)
      {
        paramJSONArray = BaseActivity.sTopActivity;
        localObject1 = new JSONArray();
        paramInt = 0;
        while (paramInt < localArrayList.size())
        {
          localObject2 = (DownloadInfo)localArrayList.get(paramInt);
          boolean bool = bfwv.a(paramJSONArray, ((DownloadInfo)localObject2).jdField_e_of_type_JavaLangString);
          localObject2 = a((DownloadInfo)localObject2);
          ((JSONObject)localObject2).put("isInstall", bool);
          ((JSONArray)localObject1).put(localObject2);
          paramInt += 1;
        }
        paramJSONArray = ((JSONArray)localObject1).toString();
        ArkAppCenter.a().post(this.jdField_a_of_type_JavaLangString, new ArkAppYYBDownloadModule.6(this, paramLong, paramJSONArray));
        return;
        label419:
        paramInt += 1;
      }
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if (paramDownloadInfo == null) {}
    try
    {
      QLog.i("ArkApp.downloadyyb.module", 1, "[doActionByDowloadInfo] is null ");
      return;
    }
    catch (Exception paramDownloadInfo)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, "[doDownloadAction] Exception", paramDownloadInfo);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("ArkApp.downloadyyb.module", 1, "[doActionByDowloadInfo] object " + paramDownloadInfo.toString() + "action =" + paramInt);
      break label153;
      bhyo.a().b(paramDownloadInfo);
      return;
      bhyo.a().b(paramDownloadInfo);
      return;
      bhyo.a().a(paramDownloadInfo.jdField_d_of_type_JavaLangString);
      return;
      bhyo.a().a(paramDownloadInfo.jdField_d_of_type_JavaLangString, true);
      return;
      if (!paramDownloadInfo.jdField_c_of_type_Boolean)
      {
        QLog.i("ArkApp.downloadyyb.module", 1, "[doActionByDowloadInfo] not apk");
        return;
      }
      bias.a("305", paramDownloadInfo.jdField_h_of_type_JavaLangString, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.o);
      bhyo.a().a(paramDownloadInfo);
      return;
    }
    label153:
    switch (paramInt)
    {
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, boolean paramBoolean, int paramInt)
  {
    int j = 1;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null)
    {
      QLog.w("ArkApp.downloadyyb.module", 1, "ark.dctrl [handleDownload] top activity is null");
      return;
    }
    boolean bool1 = bhzh.d(localBaseActivity);
    boolean bool2 = bhzh.c(localBaseActivity);
    int i = j;
    if (paramDownloadInfo != null) {
      if (paramDownloadInfo.a() != 1) {
        break label89;
      }
    }
    label89:
    for (i = j; (paramBoolean) && (bool1) && (!bool2) && (i != 0) && (paramInt == 2); i = 0)
    {
      a(BaseActivity.sTopActivity, paramDownloadInfo);
      return;
    }
    a(paramDownloadInfo, paramInt);
  }
  
  /* Error */
  private void a(String paramString, ark.VariantWrapper paramVariantWrapper)
  {
    // Byte code:
    //   0: new 68	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 263	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 19
    //   10: getstatic 177	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   13: aload 19
    //   15: invokestatic 269	com/tencent/open/appcommon/js/DownloadInterface:parseSourceType	(Landroid/app/Activity;Lorg/json/JSONObject;)Ljava/lang/String;
    //   18: astore 21
    //   20: ldc_w 271
    //   23: aload 21
    //   25: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +23 -> 51
    //   31: ldc_w 278
    //   34: ldc_w 280
    //   37: ldc_w 282
    //   40: aload 19
    //   42: getstatic 286	bibw:I	Ljava/lang/String;
    //   45: invokevirtual 72	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokestatic 237	bias:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   51: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +33 -> 87
    //   57: ldc 16
    //   59: iconst_1
    //   60: new 106	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 288
    //   70: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 19
    //   75: invokevirtual 289	org/json/JSONObject:toString	()Ljava/lang/String;
    //   78: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 24	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload 19
    //   89: getstatic 292	bibw:j	Ljava/lang/String;
    //   92: invokevirtual 72	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 22
    //   97: aload 22
    //   99: invokestatic 298	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifeq +19 -> 121
    //   105: ldc 16
    //   107: iconst_1
    //   108: ldc_w 300
    //   111: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_2
    //   115: iconst_m1
    //   116: invokevirtual 306	com/tencent/ark/ark$VariantWrapper:SetInt	(I)Z
    //   119: pop
    //   120: return
    //   121: aload 19
    //   123: getstatic 309	bibw:f	Ljava/lang/String;
    //   126: invokevirtual 72	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore 23
    //   131: aload 19
    //   133: getstatic 312	bibw:k	Ljava/lang/String;
    //   136: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   139: istore_3
    //   140: aload 19
    //   142: getstatic 314	bibw:i	Ljava/lang/String;
    //   145: invokevirtual 72	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 24
    //   150: aload 19
    //   152: getstatic 317	bibw:l	Ljava/lang/String;
    //   155: invokevirtual 72	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 14
    //   160: aload 19
    //   162: getstatic 320	bibw:D	Ljava/lang/String;
    //   165: invokevirtual 72	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 15
    //   170: aload 19
    //   172: ldc_w 322
    //   175: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   178: istore 4
    //   180: aload 19
    //   182: getstatic 286	bibw:I	Ljava/lang/String;
    //   185: invokevirtual 72	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   188: astore 20
    //   190: aload 19
    //   192: getstatic 325	bibw:y	Ljava/lang/String;
    //   195: iconst_1
    //   196: invokevirtual 328	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   199: istore 6
    //   201: aload 19
    //   203: ldc_w 330
    //   206: iconst_0
    //   207: invokevirtual 328	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   210: istore 7
    //   212: aload 19
    //   214: ldc_w 332
    //   217: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   220: invokestatic 334	aoqz:a	(I)Z
    //   223: istore 9
    //   225: aload 19
    //   227: getstatic 337	bibw:x	Ljava/lang/String;
    //   230: invokevirtual 340	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   233: istore 10
    //   235: aload 19
    //   237: getstatic 343	bibw:C	Ljava/lang/String;
    //   240: iconst_0
    //   241: invokevirtual 346	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   244: istore 5
    //   246: aload 19
    //   248: getstatic 349	bibw:J	Ljava/lang/String;
    //   251: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   254: invokestatic 334	aoqz:a	(I)Z
    //   257: istore 11
    //   259: aload 19
    //   261: ldc 93
    //   263: invokevirtual 72	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   266: astore 16
    //   268: aload 19
    //   270: ldc_w 351
    //   273: ldc_w 353
    //   276: invokevirtual 356	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   279: astore 17
    //   281: aload 19
    //   283: getstatic 359	bibw:K	Ljava/lang/String;
    //   286: ldc_w 353
    //   289: invokevirtual 356	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   292: astore 18
    //   294: getstatic 177	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   297: invokestatic 363	com/tencent/open/appcommon/js/DownloadInterface:parseCurrentPageId	(Landroid/app/Activity;)Ljava/lang/String;
    //   300: ifnonnull +569 -> 869
    //   303: ldc_w 353
    //   306: astore 12
    //   308: aload 19
    //   310: getstatic 366	bibw:r	Ljava/lang/String;
    //   313: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   316: invokestatic 334	aoqz:a	(I)Z
    //   319: istore 8
    //   321: aload 19
    //   323: ldc_w 368
    //   326: invokevirtual 72	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: astore 25
    //   331: new 106	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   338: aload 19
    //   340: ldc_w 370
    //   343: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   346: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: ldc_w 353
    //   352: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: astore 26
    //   360: new 106	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   367: aload 19
    //   369: ldc_w 372
    //   372: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   375: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: ldc_w 353
    //   381: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: astore 27
    //   389: new 106	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   396: aload 19
    //   398: ldc_w 374
    //   401: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   404: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: ldc_w 353
    //   410: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: astore 28
    //   418: new 106	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   425: aload 19
    //   427: ldc_w 376
    //   430: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   433: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   436: ldc_w 353
    //   439: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: astore 29
    //   447: aload_0
    //   448: getfield 378	aoqz:jdField_a_of_type_Bhxj	Lbhxj;
    //   451: ifnonnull +429 -> 880
    //   454: aload_0
    //   455: new 380	bhxj
    //   458: dup
    //   459: aload 16
    //   461: aload 24
    //   463: iload_3
    //   464: invokespecial 383	bhxj:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   467: putfield 378	aoqz:jdField_a_of_type_Bhxj	Lbhxj;
    //   470: invokestatic 29	bhyo:a	()Lbhyo;
    //   473: aload 22
    //   475: invokevirtual 133	bhyo:b	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   478: astore 13
    //   480: aload 13
    //   482: astore_1
    //   483: aload 13
    //   485: ifnonnull +29 -> 514
    //   488: new 63	com/tencent/open/downloadnew/DownloadInfo
    //   491: dup
    //   492: aload 16
    //   494: aload 22
    //   496: invokevirtual 386	java/lang/String:trim	()Ljava/lang/String;
    //   499: aload 23
    //   501: aload 14
    //   503: aload 24
    //   505: aconst_null
    //   506: aload 21
    //   508: iload 6
    //   510: invokespecial 389	com/tencent/open/downloadnew/DownloadInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;Z)V
    //   513: astore_1
    //   514: aload_1
    //   515: iload_3
    //   516: putfield 392	com/tencent/open/downloadnew/DownloadInfo:g	I
    //   519: iload 6
    //   521: ifeq +391 -> 912
    //   524: aload_1
    //   525: iload 9
    //   527: putfield 394	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   530: aload_1
    //   531: iload 10
    //   533: putfield 396	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   536: aload_1
    //   537: iload 5
    //   539: putfield 398	com/tencent/open/downloadnew/DownloadInfo:jdField_h_of_type_Int	I
    //   542: aload_1
    //   543: aload 15
    //   545: putfield 401	com/tencent/open/downloadnew/DownloadInfo:n	Ljava/lang/String;
    //   548: aload_1
    //   549: iload 4
    //   551: putfield 403	com/tencent/open/downloadnew/DownloadInfo:i	I
    //   554: aload_1
    //   555: aload 20
    //   557: putfield 232	com/tencent/open/downloadnew/DownloadInfo:o	Ljava/lang/String;
    //   560: aload_1
    //   561: iload 11
    //   563: putfield 405	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Boolean	Z
    //   566: aload_1
    //   567: iconst_0
    //   568: putfield 407	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Int	I
    //   571: aload_1
    //   572: aload 19
    //   574: getstatic 408	bibw:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   577: invokevirtual 87	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   580: putfield 91	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_Int	I
    //   583: aload_1
    //   584: aload 19
    //   586: getstatic 411	bibw:G	Ljava/lang/String;
    //   589: invokevirtual 415	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   592: putfield 417	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Long	J
    //   595: aload_1
    //   596: aload 25
    //   598: putfield 420	com/tencent/open/downloadnew/DownloadInfo:q	Ljava/lang/String;
    //   601: aload_1
    //   602: aload 26
    //   604: putfield 421	com/tencent/open/downloadnew/DownloadInfo:r	Ljava/lang/String;
    //   607: aload_1
    //   608: aload 17
    //   610: putfield 422	com/tencent/open/downloadnew/DownloadInfo:k	Ljava/lang/String;
    //   613: aload_1
    //   614: aload 18
    //   616: putfield 425	com/tencent/open/downloadnew/DownloadInfo:s	Ljava/lang/String;
    //   619: aload_1
    //   620: aload 27
    //   622: putfield 428	com/tencent/open/downloadnew/DownloadInfo:t	Ljava/lang/String;
    //   625: aload_1
    //   626: aload 28
    //   628: putfield 431	com/tencent/open/downloadnew/DownloadInfo:u	Ljava/lang/String;
    //   631: aload_1
    //   632: aload 29
    //   634: putfield 434	com/tencent/open/downloadnew/DownloadInfo:v	Ljava/lang/String;
    //   637: aload_1
    //   638: iload 7
    //   640: putfield 436	com/tencent/open/downloadnew/DownloadInfo:jdField_e_of_type_Boolean	Z
    //   643: aload_1
    //   644: ldc_w 438
    //   647: aload 12
    //   649: invokevirtual 441	com/tencent/open/downloadnew/DownloadInfo:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   652: pop
    //   653: aload_1
    //   654: invokevirtual 98	com/tencent/open/downloadnew/DownloadInfo:a	()V
    //   657: iconst_1
    //   658: istore 7
    //   660: sipush 380
    //   663: invokestatic 446	apvq:b	(I)Lapvk;
    //   666: invokevirtual 451	apvk:a	()Lapvp;
    //   669: astore 12
    //   671: iload 7
    //   673: istore 6
    //   675: aload 12
    //   677: ifnull +56 -> 733
    //   680: iload 7
    //   682: istore 6
    //   684: aload 12
    //   686: invokevirtual 456	apvp:a	()Lapwj;
    //   689: ifnull +44 -> 733
    //   692: aload 12
    //   694: invokevirtual 456	apvp:a	()Lapwj;
    //   697: astore 12
    //   699: iload 7
    //   701: istore 6
    //   703: aload 12
    //   705: getfield 460	apwj:c	Ljava/util/ArrayList;
    //   708: ifnull +25 -> 733
    //   711: iload 7
    //   713: istore 6
    //   715: aload 12
    //   717: getfield 460	apwj:c	Ljava/util/ArrayList;
    //   720: aload_0
    //   721: getfield 148	aoqz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   724: invokevirtual 463	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   727: ifeq +6 -> 733
    //   730: iconst_0
    //   731: istore 6
    //   733: ldc 16
    //   735: iconst_1
    //   736: bipush 10
    //   738: anewarray 465	java/lang/Object
    //   741: dup
    //   742: iconst_0
    //   743: ldc_w 467
    //   746: aastore
    //   747: dup
    //   748: iconst_1
    //   749: aload_0
    //   750: getfield 148	aoqz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   753: aastore
    //   754: dup
    //   755: iconst_2
    //   756: ldc_w 469
    //   759: aastore
    //   760: dup
    //   761: iconst_3
    //   762: iload 6
    //   764: invokestatic 475	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   767: aastore
    //   768: dup
    //   769: iconst_4
    //   770: ldc_w 477
    //   773: aastore
    //   774: dup
    //   775: iconst_5
    //   776: aload 16
    //   778: aastore
    //   779: dup
    //   780: bipush 6
    //   782: ldc_w 479
    //   785: aastore
    //   786: dup
    //   787: bipush 7
    //   789: aload 14
    //   791: aastore
    //   792: dup
    //   793: bipush 8
    //   795: ldc_w 481
    //   798: aastore
    //   799: dup
    //   800: bipush 9
    //   802: aload 15
    //   804: aastore
    //   805: invokestatic 484	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   808: iload 6
    //   810: ifeq +120 -> 930
    //   813: invokestatic 489	aoxr:a	()Laoxr;
    //   816: aload_0
    //   817: getfield 148	aoqz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   820: aload 16
    //   822: aload 14
    //   824: aload 15
    //   826: new 491	aorc
    //   829: dup
    //   830: aload_0
    //   831: aload 16
    //   833: aload 14
    //   835: aload_1
    //   836: iload 8
    //   838: iload_3
    //   839: invokespecial 494	aorc:<init>	(Laoqz;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/open/downloadnew/DownloadInfo;ZI)V
    //   842: invokevirtual 497	aoxr:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    //   845: aload_2
    //   846: iconst_1
    //   847: invokevirtual 306	com/tencent/ark/ark$VariantWrapper:SetInt	(I)Z
    //   850: pop
    //   851: return
    //   852: astore_1
    //   853: ldc 16
    //   855: iconst_1
    //   856: ldc 214
    //   858: aload_1
    //   859: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   862: aload_2
    //   863: iconst_m1
    //   864: invokevirtual 306	com/tencent/ark/ark$VariantWrapper:SetInt	(I)Z
    //   867: pop
    //   868: return
    //   869: getstatic 177	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   872: invokestatic 363	com/tencent/open/appcommon/js/DownloadInterface:parseCurrentPageId	(Landroid/app/Activity;)Ljava/lang/String;
    //   875: astore 12
    //   877: goto -569 -> 308
    //   880: aload_0
    //   881: getfield 378	aoqz:jdField_a_of_type_Bhxj	Lbhxj;
    //   884: aload 16
    //   886: aload 24
    //   888: iload_3
    //   889: invokevirtual 500	bhxj:a	(Ljava/lang/String;Ljava/lang/String;I)Z
    //   892: ifeq -422 -> 470
    //   895: ldc 16
    //   897: iconst_1
    //   898: ldc_w 502
    //   901: invokestatic 24	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: aload_2
    //   905: bipush 253
    //   907: invokevirtual 306	com/tencent/ark/ark$VariantWrapper:SetInt	(I)Z
    //   910: pop
    //   911: return
    //   912: aload_1
    //   913: iconst_0
    //   914: putfield 394	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   917: aload_1
    //   918: iconst_1
    //   919: putfield 396	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   922: aload_1
    //   923: iconst_2
    //   924: putfield 504	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Int	I
    //   927: goto -391 -> 536
    //   930: aload_0
    //   931: aload_1
    //   932: iload 8
    //   934: iload_3
    //   935: invokespecial 198	aoqz:a	(Lcom/tencent/open/downloadnew/DownloadInfo;ZI)V
    //   938: goto -93 -> 845
    //   941: astore 13
    //   943: goto -348 -> 595
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	946	0	this	aoqz
    //   0	946	1	paramString	String
    //   0	946	2	paramVariantWrapper	ark.VariantWrapper
    //   139	796	3	i	int
    //   178	372	4	j	int
    //   244	294	5	k	int
    //   199	610	6	bool1	boolean
    //   210	502	7	bool2	boolean
    //   319	614	8	bool3	boolean
    //   223	303	9	bool4	boolean
    //   233	299	10	bool5	boolean
    //   257	305	11	bool6	boolean
    //   306	570	12	localObject	Object
    //   478	6	13	localDownloadInfo	DownloadInfo
    //   941	1	13	localNumberFormatException	java.lang.NumberFormatException
    //   158	676	14	str1	String
    //   168	657	15	str2	String
    //   266	619	16	str3	String
    //   279	330	17	str4	String
    //   292	323	18	str5	String
    //   8	577	19	localJSONObject	JSONObject
    //   188	368	20	str6	String
    //   18	489	21	str7	String
    //   95	400	22	str8	String
    //   129	371	23	str9	String
    //   148	739	24	str10	String
    //   329	268	25	str11	String
    //   358	245	26	str12	String
    //   387	234	27	str13	String
    //   416	211	28	str14	String
    //   445	188	29	str15	String
    // Exception table:
    //   from	to	target	type
    //   0	51	852	java/lang/Exception
    //   51	87	852	java/lang/Exception
    //   87	120	852	java/lang/Exception
    //   121	303	852	java/lang/Exception
    //   308	470	852	java/lang/Exception
    //   470	480	852	java/lang/Exception
    //   488	514	852	java/lang/Exception
    //   514	519	852	java/lang/Exception
    //   524	536	852	java/lang/Exception
    //   536	571	852	java/lang/Exception
    //   571	595	852	java/lang/Exception
    //   595	657	852	java/lang/Exception
    //   660	671	852	java/lang/Exception
    //   684	699	852	java/lang/Exception
    //   703	711	852	java/lang/Exception
    //   715	730	852	java/lang/Exception
    //   733	808	852	java/lang/Exception
    //   813	845	852	java/lang/Exception
    //   845	851	852	java/lang/Exception
    //   869	877	852	java/lang/Exception
    //   880	911	852	java/lang/Exception
    //   912	927	852	java/lang/Exception
    //   930	938	852	java/lang/Exception
    //   571	595	941	java/lang/NumberFormatException
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt != 0;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      ArkAppCenter.a().postToMainThread(new ArkAppYYBDownloadModule.2(this, paramString));
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, " showToast error::", paramString);
    }
    return false;
  }
  
  public void Destruct()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a(((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue());
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_Aorf = null;
    bhyo.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = null;
  }
  
  public String GetTypeName()
  {
    return "QQYYBDownload";
  }
  
  public boolean HasMenthod(String paramString)
  {
    if (paramString.equals("getQueryDownloadAction")) {}
    while ((paramString.equals("doDownloadAction")) || (paramString.equals("RegisterDownloadCallBackListener"))) {
      return true;
    }
    return false;
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!aonw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.YYB_DOWNLOAD"))
    {
      QLog.i("ArkApp.downloadyyb.module", 1, "ArkAppYYBDownloadModule.invokeFunc permission denied");
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {
        b(paramString.getString(2131690144));
      }
    }
    long l;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp.downloadyyb.module", 1, String.format("ArkAppYYBDownloadModule.invokeFunc.%s", new Object[] { paramString }));
      }
      if (paramString.equals("getQueryDownloadAction"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          l = a(paramArrayOfVariantWrapper[1].Copy());
          if (QLog.isColorLevel()) {
            QLog.i("ArkApp.downloadyyb.module", 1, "<getQueryDownloadAction> paramJson=" + paramString);
          }
        }
        try
        {
          paramString = new JSONObject(paramString);
          paramArrayOfVariantWrapper = new JSONArray(paramString.optString("queryParams"));
          a(paramString.optInt("actioncode"), paramArrayOfVariantWrapper, l);
          return true;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            QLog.e("ArkApp.downloadyyb.module", 1, "[queryDownloadAction] e=" + paramString.getMessage());
          }
        }
      }
      if (paramString.equals("doDownloadAction"))
      {
        if (this.jdField_a_of_type_Aorf == null)
        {
          QLog.e("ArkApp.downloadyyb.module", 1, "should DownloadInit first ");
          paramVariantWrapper.SetInt(-2);
          return true;
        }
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsString()))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          if (QLog.isColorLevel()) {
            QLog.i("ArkApp.downloadyyb.module", 1, "ArkAppYYBDownloadModule = " + paramString);
          }
          a(paramString, paramVariantWrapper);
          return true;
        }
        paramVariantWrapper.SetInt(-1);
        return true;
      }
    } while (!paramString.equals("RegisterDownloadCallBackListener"));
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
    {
      l = a(paramArrayOfVariantWrapper[0].Copy());
      bhyo.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
      this.jdField_a_of_type_Aorf = new aora(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
      paramVariantWrapper.SetBool(true);
      return true;
    }
    paramVariantWrapper.SetBool(false);
    return true;
  }
  
  public JSONObject a(DownloadInfo paramDownloadInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramDownloadInfo != null) {
      try
      {
        localJSONObject.put("appid", paramDownloadInfo.jdField_c_of_type_JavaLangString);
        localJSONObject.put("state", paramDownloadInfo.a());
        localJSONObject.put("pro", paramDownloadInfo.f);
        localJSONObject.put("packagename", paramDownloadInfo.jdField_e_of_type_JavaLangString);
        if (TextUtils.isEmpty(paramDownloadInfo.l))
        {
          localJSONObject.put("final_file_exits", "false");
          return localJSONObject;
        }
        localJSONObject.put("final_file_exits", new File(paramDownloadInfo.l).exists());
        return localJSONObject;
      }
      catch (JSONException paramDownloadInfo)
      {
        QLog.e("ArkApp.downloadyyb.module", 1, "tranDownloadToJSONObject ", paramDownloadInfo);
      }
    }
    return localJSONObject;
  }
  
  protected JSONObject a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt1);
      localJSONObject.put("pro", paramInt2);
      localJSONObject.put("errorMsg", paramString3);
      localJSONObject.put("errorCode", paramInt3);
      localJSONObject.put("writecodestate", paramInt4);
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, "getCallBackJsonObject >>> ", paramString1);
    }
    return localJSONObject;
  }
  
  protected JSONObject a(String paramString1, int paramInt, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt);
      localJSONObject.put("pro", 0);
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      QLog.e("ArkApp.downloadyyb.module", 1, "getCallBackJsonObject >>> ", paramString1);
    }
    return localJSONObject;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo)
  {
    new Handler(Looper.getMainLooper()).post(new ArkAppYYBDownloadModule.7(this, paramDownloadInfo, paramActivity));
  }
  
  protected aopq[] a()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqz
 * JD-Core Version:    0.7.0.1
 */