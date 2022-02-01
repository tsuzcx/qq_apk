package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.module.ArkAPIPermission;
import com.tencent.mobileqq.ark.module.ArkModuleMethod;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.open.appcommon.js.LastDownloadAction;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.base.APNUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClassConstructor
public class ArkAppYYBDownloadModule
  extends ArkAppQQModuleBase
{
  private ArkAppYYBDownloadModule.DownloadStateListener jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppYYBDownloadModule$DownloadStateListener;
  private LastDownloadAction jdField_a_of_type_ComTencentOpenAppcommonJsLastDownloadAction = null;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  
  public ArkAppYYBDownloadModule(ark.Application paramApplication, int paramInt)
  {
    super(paramApplication, paramInt);
    QLog.i("ArkApp.downloadyyb.module", 1, "init");
    DownloadManagerV2.a();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new ArkAppYYBDownloadModule.3(this);
  }
  
  private void a(int paramInt, JSONArray paramJSONArray, long paramLong)
  {
    for (;;)
    {
      try
      {
        int m = paramJSONArray.length();
        Object localObject1 = new ArrayList();
        int j = 0;
        int k = 0;
        int i = 0;
        Object localObject2;
        Object localObject3;
        if (i < m)
        {
          localObject2 = paramJSONArray.getJSONObject(i);
          localObject3 = new DownloadInfo();
          ((DownloadInfo)localObject3).jdField_d_of_type_JavaLangString = ((JSONObject)localObject2).optString("url");
          ((DownloadInfo)localObject3).jdField_e_of_type_JavaLangString = ((JSONObject)localObject2).optString("packageName");
          ((DownloadInfo)localObject3).jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("versionCode");
          ((DownloadInfo)localObject3).jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).optString("appId");
          ((DownloadInfo)localObject3).a();
          ((List)localObject1).add(localObject3);
          i += 1;
          continue;
        }
        paramJSONArray = new StringBuilder();
        paramJSONArray.append("queryPackageStateYYB action is ");
        paramJSONArray.append(paramInt);
        QLog.d("ArkApp.downloadyyb.module", 1, paramJSONArray.toString());
        if (paramInt != 0)
        {
          if (paramInt != 1) {
            return;
          }
          if (((List)localObject1).size() > 0)
          {
            paramJSONArray = BaseActivity.sTopActivity;
            localObject2 = new JSONArray();
            paramInt = k;
            if (paramInt < ((List)localObject1).size())
            {
              localObject3 = (DownloadInfo)((List)localObject1).get(paramInt);
              boolean bool = PackageUtil.a(paramJSONArray, ((DownloadInfo)localObject3).jdField_e_of_type_JavaLangString);
              localObject3 = a((DownloadInfo)localObject3);
              ((JSONObject)localObject3).put("isInstall", bool);
              ((JSONArray)localObject2).put(localObject3);
              paramInt += 1;
              continue;
            }
            paramJSONArray = ((JSONArray)localObject2).toString();
            ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.b, new ArkAppYYBDownloadModule.6(this, paramLong, paramJSONArray));
          }
        }
        else
        {
          try
          {
            paramJSONArray = new JSONArray();
            i = ((List)localObject1).size();
            paramInt = j;
            if (paramInt < i)
            {
              localObject2 = (DownloadInfo)((List)localObject1).get(paramInt);
              localObject2 = DownloadManagerV2.a().b(((DownloadInfo)localObject2).jdField_d_of_type_JavaLangString);
              if (localObject2 == null) {
                break label441;
              }
              paramJSONArray.put(a((DownloadInfo)localObject2));
              break label441;
            }
            paramJSONArray = paramJSONArray.toString();
            ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.b, new ArkAppYYBDownloadModule.5(this, paramLong, paramJSONArray));
            return;
          }
          catch (Exception paramJSONArray)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("queryPackageStateYYB : ");
            ((StringBuilder)localObject1).append(paramJSONArray);
            QLog.e("ArkApp.downloadyyb.module", 1, ((StringBuilder)localObject1).toString());
            return;
          }
        }
        return;
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("ArkApp.downloadyyb.module", 1, "[innerQuery] e=", paramJSONArray);
      }
      label441:
      paramInt += 1;
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
      StringBuilder localStringBuilder;
      QLog.e("ArkApp.downloadyyb.module", 1, "[doDownloadAction] Exception", paramDownloadInfo);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[doActionByDowloadInfo] object ");
      localStringBuilder.append(paramDownloadInfo.toString());
      localStringBuilder.append("action =");
      localStringBuilder.append(paramInt);
      QLog.i("ArkApp.downloadyyb.module", 1, localStringBuilder.toString());
    }
    do
    {
      DownloadManagerV2.a().b(paramDownloadInfo);
      return;
      do
      {
        DownloadManagerV2.a().a(paramDownloadInfo.jdField_d_of_type_JavaLangString, true);
        return;
        do
        {
          if (!paramDownloadInfo.jdField_c_of_type_Boolean)
          {
            QLog.i("ArkApp.downloadyyb.module", 1, "[doActionByDowloadInfo] not apk");
            return;
          }
          StaticAnalyz.a("305", paramDownloadInfo.jdField_h_of_type_JavaLangString, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.o);
          DownloadManagerV2.a().a(paramDownloadInfo);
          return;
          do
          {
            DownloadManagerV2.a().a(paramDownloadInfo.jdField_d_of_type_JavaLangString);
            return;
            do
            {
              DownloadManagerV2.a().b(paramDownloadInfo);
              return;
            } while (paramInt == 2);
          } while (paramInt == 3);
        } while (paramInt == 5);
      } while (paramInt == 10);
    } while (paramInt == 12);
  }
  
  private void a(DownloadInfo paramDownloadInfo, boolean paramBoolean, int paramInt)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    int j = 1;
    if (localBaseActivity == null)
    {
      QLog.w("ArkApp.downloadyyb.module", 1, "ark.dctrl [handleDownload] top activity is null");
      return;
    }
    boolean bool1 = APNUtil.d(localBaseActivity);
    boolean bool2 = APNUtil.c(localBaseActivity);
    int i = j;
    if (paramDownloadInfo != null) {
      if (paramDownloadInfo.a() == 1) {
        i = j;
      } else {
        i = 0;
      }
    }
    if ((paramBoolean) && (bool1) && (!bool2) && (i != 0) && (paramInt == 2))
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
    //   0: new 80	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 272	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 16
    //   10: getstatic 141	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   13: aload 16
    //   15: invokestatic 278	com/tencent/open/appcommon/js/DownloadInterface:parseSourceType	(Landroid/app/Activity;Lorg/json/JSONObject;)Ljava/lang/String;
    //   18: astore 21
    //   20: ldc_w 280
    //   23: aload 21
    //   25: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +23 -> 51
    //   31: ldc_w 287
    //   34: ldc_w 289
    //   37: ldc_w 291
    //   40: aload 16
    //   42: getstatic 296	com/tencent/open/downloadnew/DownloadConstants:K	Ljava/lang/String;
    //   45: invokevirtual 84	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokestatic 242	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   51: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +39 -> 93
    //   57: new 116	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   64: astore_1
    //   65: aload_1
    //   66: ldc_w 298
    //   69: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_1
    //   74: aload 16
    //   76: invokevirtual 299	org/json/JSONObject:toString	()Ljava/lang/String;
    //   79: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: ldc 19
    //   85: iconst_1
    //   86: aload_1
    //   87: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 27	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aload 16
    //   95: getstatic 302	com/tencent/open/downloadnew/DownloadConstants:j	Ljava/lang/String;
    //   98: invokevirtual 84	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 23
    //   103: aload 23
    //   105: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifeq +19 -> 127
    //   111: ldc 19
    //   113: iconst_1
    //   114: ldc_w 310
    //   117: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_2
    //   121: iconst_m1
    //   122: invokevirtual 316	com/tencent/ark/ark$VariantWrapper:SetInt	(I)Z
    //   125: pop
    //   126: return
    //   127: aload 16
    //   129: getstatic 319	com/tencent/open/downloadnew/DownloadConstants:f	Ljava/lang/String;
    //   132: invokevirtual 84	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 24
    //   137: aload 16
    //   139: getstatic 322	com/tencent/open/downloadnew/DownloadConstants:k	Ljava/lang/String;
    //   142: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   145: istore 4
    //   147: aload 16
    //   149: getstatic 324	com/tencent/open/downloadnew/DownloadConstants:i	Ljava/lang/String;
    //   152: invokevirtual 84	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 25
    //   157: aload 16
    //   159: getstatic 327	com/tencent/open/downloadnew/DownloadConstants:l	Ljava/lang/String;
    //   162: invokevirtual 84	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: astore 14
    //   167: aload 16
    //   169: getstatic 330	com/tencent/open/downloadnew/DownloadConstants:F	Ljava/lang/String;
    //   172: invokevirtual 84	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   175: astore 15
    //   177: aload 16
    //   179: ldc_w 332
    //   182: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   185: istore 5
    //   187: aload 16
    //   189: getstatic 296	com/tencent/open/downloadnew/DownloadConstants:K	Ljava/lang/String;
    //   192: invokevirtual 84	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 19
    //   197: aload 16
    //   199: getstatic 335	com/tencent/open/downloadnew/DownloadConstants:z	Ljava/lang/String;
    //   202: iconst_1
    //   203: invokevirtual 338	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   206: istore 6
    //   208: aload 16
    //   210: ldc_w 340
    //   213: iconst_0
    //   214: invokevirtual 338	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   217: istore 8
    //   219: aload 16
    //   221: ldc_w 342
    //   224: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   227: invokestatic 344	com/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule:a	(I)Z
    //   230: istore 9
    //   232: aload 16
    //   234: getstatic 347	com/tencent/open/downloadnew/DownloadConstants:y	Ljava/lang/String;
    //   237: invokevirtual 350	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   240: istore 10
    //   242: aload 16
    //   244: getstatic 353	com/tencent/open/downloadnew/DownloadConstants:E	Ljava/lang/String;
    //   247: iconst_0
    //   248: invokevirtual 356	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   251: istore_3
    //   252: aload 16
    //   254: getstatic 359	com/tencent/open/downloadnew/DownloadConstants:L	Ljava/lang/String;
    //   257: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   260: invokestatic 344	com/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule:a	(I)Z
    //   263: istore 11
    //   265: aload 16
    //   267: ldc 103
    //   269: invokevirtual 84	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   272: astore 13
    //   274: aload 16
    //   276: ldc_w 361
    //   279: ldc_w 363
    //   282: invokevirtual 366	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   285: astore 17
    //   287: aload 16
    //   289: getstatic 369	com/tencent/open/downloadnew/DownloadConstants:M	Ljava/lang/String;
    //   292: ldc_w 363
    //   295: invokevirtual 366	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   298: astore 18
    //   300: getstatic 141	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   303: invokestatic 373	com/tencent/open/appcommon/js/DownloadInterface:parseCurrentPageId	(Landroid/app/Activity;)Ljava/lang/String;
    //   306: ifnonnull +10 -> 316
    //   309: ldc_w 363
    //   312: astore_1
    //   313: goto +10 -> 323
    //   316: getstatic 141	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   319: invokestatic 373	com/tencent/open/appcommon/js/DownloadInterface:parseCurrentPageId	(Landroid/app/Activity;)Ljava/lang/String;
    //   322: astore_1
    //   323: aload 16
    //   325: getstatic 376	com/tencent/open/downloadnew/DownloadConstants:s	Ljava/lang/String;
    //   328: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   331: invokestatic 344	com/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule:a	(I)Z
    //   334: istore 7
    //   336: aload 16
    //   338: ldc_w 378
    //   341: invokevirtual 84	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   344: astore 20
    //   346: new 116	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   353: astore 12
    //   355: aload 12
    //   357: aload 16
    //   359: ldc_w 380
    //   362: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   365: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 12
    //   371: ldc_w 363
    //   374: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 12
    //   380: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: astore 22
    //   385: new 116	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   392: astore 12
    //   394: aload 12
    //   396: aload 16
    //   398: ldc_w 382
    //   401: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   404: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 12
    //   410: ldc_w 363
    //   413: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload 12
    //   419: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: astore 26
    //   424: new 116	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   431: astore 12
    //   433: aload 12
    //   435: aload 16
    //   437: ldc_w 384
    //   440: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   443: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 12
    //   449: ldc_w 363
    //   452: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload 12
    //   458: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: astore 27
    //   463: new 116	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   470: astore 12
    //   472: aload 12
    //   474: aload 16
    //   476: ldc_w 386
    //   479: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   482: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 12
    //   488: ldc_w 363
    //   491: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 12
    //   497: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: astore 28
    //   502: aload_0
    //   503: getfield 17	com/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule:jdField_a_of_type_ComTencentOpenAppcommonJsLastDownloadAction	Lcom/tencent/open/appcommon/js/LastDownloadAction;
    //   506: ifnonnull +23 -> 529
    //   509: aload_0
    //   510: new 388	com/tencent/open/appcommon/js/LastDownloadAction
    //   513: dup
    //   514: aload 13
    //   516: aload 25
    //   518: iload 4
    //   520: invokespecial 391	com/tencent/open/appcommon/js/LastDownloadAction:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   523: putfield 17	com/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule:jdField_a_of_type_ComTencentOpenAppcommonJsLastDownloadAction	Lcom/tencent/open/appcommon/js/LastDownloadAction;
    //   526: goto +36 -> 562
    //   529: aload_0
    //   530: getfield 17	com/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule:jdField_a_of_type_ComTencentOpenAppcommonJsLastDownloadAction	Lcom/tencent/open/appcommon/js/LastDownloadAction;
    //   533: aload 13
    //   535: aload 25
    //   537: iload 4
    //   539: invokevirtual 394	com/tencent/open/appcommon/js/LastDownloadAction:a	(Ljava/lang/String;Ljava/lang/String;I)Z
    //   542: ifeq +20 -> 562
    //   545: ldc 19
    //   547: iconst_1
    //   548: ldc_w 396
    //   551: invokestatic 27	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: aload_2
    //   555: bipush 253
    //   557: invokevirtual 316	com/tencent/ark/ark$VariantWrapper:SetInt	(I)Z
    //   560: pop
    //   561: return
    //   562: invokestatic 32	com/tencent/open/appstore/dl/DownloadManagerV2:a	()Lcom/tencent/open/appstore/dl/DownloadManagerV2;
    //   565: aload 23
    //   567: invokevirtual 184	com/tencent/open/appstore/dl/DownloadManagerV2:b	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   570: astore 12
    //   572: aload 12
    //   574: ifnonnull +437 -> 1011
    //   577: new 75	com/tencent/open/downloadnew/DownloadInfo
    //   580: dup
    //   581: aload 13
    //   583: aload 23
    //   585: invokevirtual 399	java/lang/String:trim	()Ljava/lang/String;
    //   588: aload 24
    //   590: aload 14
    //   592: aload 25
    //   594: aconst_null
    //   595: aload 21
    //   597: iload 6
    //   599: invokespecial 402	com/tencent/open/downloadnew/DownloadInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Ljava/lang/String;Z)V
    //   602: astore 12
    //   604: goto +3 -> 607
    //   607: aload 12
    //   609: iload 4
    //   611: putfield 405	com/tencent/open/downloadnew/DownloadInfo:g	I
    //   614: iload 6
    //   616: ifeq +20 -> 636
    //   619: aload 12
    //   621: iload 9
    //   623: putfield 407	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   626: aload 12
    //   628: iload 10
    //   630: putfield 409	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   633: goto +21 -> 654
    //   636: aload 12
    //   638: iconst_0
    //   639: putfield 407	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   642: aload 12
    //   644: iconst_1
    //   645: putfield 409	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_Boolean	Z
    //   648: aload 12
    //   650: iconst_2
    //   651: putfield 411	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Int	I
    //   654: aload 12
    //   656: iload_3
    //   657: putfield 413	com/tencent/open/downloadnew/DownloadInfo:jdField_h_of_type_Int	I
    //   660: aload 12
    //   662: aload 15
    //   664: putfield 416	com/tencent/open/downloadnew/DownloadInfo:n	Ljava/lang/String;
    //   667: aload 12
    //   669: iload 5
    //   671: putfield 418	com/tencent/open/downloadnew/DownloadInfo:i	I
    //   674: aload 12
    //   676: aload 19
    //   678: putfield 237	com/tencent/open/downloadnew/DownloadInfo:o	Ljava/lang/String;
    //   681: aload 12
    //   683: iload 11
    //   685: putfield 420	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Boolean	Z
    //   688: aload 12
    //   690: iconst_0
    //   691: putfield 422	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Int	I
    //   694: aload 12
    //   696: aload 16
    //   698: getstatic 423	com/tencent/open/downloadnew/DownloadConstants:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   701: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   704: putfield 101	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_Int	I
    //   707: aload 12
    //   709: aload 16
    //   711: getstatic 425	com/tencent/open/downloadnew/DownloadConstants:I	Ljava/lang/String;
    //   714: invokevirtual 429	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   717: putfield 432	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Long	J
    //   720: aload 12
    //   722: aload 20
    //   724: putfield 435	com/tencent/open/downloadnew/DownloadInfo:q	Ljava/lang/String;
    //   727: aload 12
    //   729: aload 22
    //   731: putfield 438	com/tencent/open/downloadnew/DownloadInfo:r	Ljava/lang/String;
    //   734: aload 12
    //   736: aload 17
    //   738: putfield 439	com/tencent/open/downloadnew/DownloadInfo:k	Ljava/lang/String;
    //   741: aload 12
    //   743: aload 18
    //   745: putfield 440	com/tencent/open/downloadnew/DownloadInfo:s	Ljava/lang/String;
    //   748: aload 12
    //   750: aload 26
    //   752: putfield 443	com/tencent/open/downloadnew/DownloadInfo:t	Ljava/lang/String;
    //   755: aload 12
    //   757: aload 27
    //   759: putfield 446	com/tencent/open/downloadnew/DownloadInfo:u	Ljava/lang/String;
    //   762: aload 12
    //   764: aload 28
    //   766: putfield 449	com/tencent/open/downloadnew/DownloadInfo:v	Ljava/lang/String;
    //   769: aload 12
    //   771: iload 8
    //   773: putfield 451	com/tencent/open/downloadnew/DownloadInfo:jdField_e_of_type_Boolean	Z
    //   776: aload 12
    //   778: ldc_w 453
    //   781: aload_1
    //   782: invokevirtual 456	com/tencent/open/downloadnew/DownloadInfo:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   785: pop
    //   786: aload 12
    //   788: invokevirtual 108	com/tencent/open/downloadnew/DownloadInfo:a	()V
    //   791: ldc_w 458
    //   794: invokestatic 172	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   797: checkcast 458	com/tencent/mobileqq/ark/api/IArkConfig
    //   800: ldc_w 460
    //   803: invokeinterface 464 2 0
    //   808: checkcast 460	com/tencent/mobileqq/ark/config/bean/ArkPlatformConfigBean
    //   811: astore_1
    //   812: aload_1
    //   813: ifnull +201 -> 1014
    //   816: aload_1
    //   817: invokevirtual 467	com/tencent/mobileqq/ark/config/bean/ArkPlatformConfigBean:a	()Lcom/tencent/mobileqq/ark/config/config/ArkPlatformConfig;
    //   820: ifnull +194 -> 1014
    //   823: aload_1
    //   824: invokevirtual 467	com/tencent/mobileqq/ark/config/bean/ArkPlatformConfigBean:a	()Lcom/tencent/mobileqq/ark/config/config/ArkPlatformConfig;
    //   827: astore_1
    //   828: aload_1
    //   829: getfield 471	com/tencent/mobileqq/ark/config/config/ArkPlatformConfig:c	Ljava/util/ArrayList;
    //   832: ifnull +182 -> 1014
    //   835: aload_1
    //   836: getfield 471	com/tencent/mobileqq/ark/config/config/ArkPlatformConfig:c	Ljava/util/ArrayList;
    //   839: aload_0
    //   840: getfield 59	com/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule:b	Ljava/lang/String;
    //   843: invokevirtual 474	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   846: ifeq +168 -> 1014
    //   849: iconst_0
    //   850: istore 6
    //   852: goto +3 -> 855
    //   855: ldc 19
    //   857: iconst_1
    //   858: bipush 10
    //   860: anewarray 476	java/lang/Object
    //   863: dup
    //   864: iconst_0
    //   865: ldc_w 478
    //   868: aastore
    //   869: dup
    //   870: iconst_1
    //   871: aload_0
    //   872: getfield 59	com/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule:b	Ljava/lang/String;
    //   875: aastore
    //   876: dup
    //   877: iconst_2
    //   878: ldc_w 480
    //   881: aastore
    //   882: dup
    //   883: iconst_3
    //   884: iload 6
    //   886: invokestatic 486	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   889: aastore
    //   890: dup
    //   891: iconst_4
    //   892: ldc_w 488
    //   895: aastore
    //   896: dup
    //   897: iconst_5
    //   898: aload 13
    //   900: aastore
    //   901: dup
    //   902: bipush 6
    //   904: ldc_w 490
    //   907: aastore
    //   908: dup
    //   909: bipush 7
    //   911: aload 14
    //   913: aastore
    //   914: dup
    //   915: bipush 8
    //   917: ldc_w 492
    //   920: aastore
    //   921: dup
    //   922: bipush 9
    //   924: aload 15
    //   926: aastore
    //   927: invokestatic 495	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   930: iload 6
    //   932: ifeq +40 -> 972
    //   935: invokestatic 500	com/tencent/mobileqq/ark/download/ArkDownloadController:a	()Lcom/tencent/mobileqq/ark/download/ArkDownloadController;
    //   938: aload_0
    //   939: getfield 59	com/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule:b	Ljava/lang/String;
    //   942: aload 13
    //   944: aload 14
    //   946: aload 15
    //   948: new 502	com/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule$4
    //   951: dup
    //   952: aload_0
    //   953: aload 13
    //   955: aload 14
    //   957: aload 12
    //   959: iload 7
    //   961: iload 4
    //   963: invokespecial 505	com/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule$4:<init>	(Lcom/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/open/downloadnew/DownloadInfo;ZI)V
    //   966: invokevirtual 508	com/tencent/mobileqq/ark/download/ArkDownloadController:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    //   969: goto +13 -> 982
    //   972: aload_0
    //   973: aload 12
    //   975: iload 7
    //   977: iload 4
    //   979: invokespecial 207	com/tencent/mobileqq/ark/api/module/ArkAppYYBDownloadModule:a	(Lcom/tencent/open/downloadnew/DownloadInfo;ZI)V
    //   982: aload_2
    //   983: iconst_1
    //   984: invokevirtual 316	com/tencent/ark/ark$VariantWrapper:SetInt	(I)Z
    //   987: pop
    //   988: return
    //   989: astore_1
    //   990: ldc 19
    //   992: iconst_1
    //   993: ldc 249
    //   995: aload_1
    //   996: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   999: aload_2
    //   1000: iconst_m1
    //   1001: invokevirtual 316	com/tencent/ark/ark$VariantWrapper:SetInt	(I)Z
    //   1004: pop
    //   1005: return
    //   1006: astore 16
    //   1008: goto -288 -> 720
    //   1011: goto -404 -> 607
    //   1014: iconst_1
    //   1015: istore 6
    //   1017: goto -162 -> 855
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1020	0	this	ArkAppYYBDownloadModule
    //   0	1020	1	paramString	String
    //   0	1020	2	paramVariantWrapper	ark.VariantWrapper
    //   251	406	3	i	int
    //   145	833	4	j	int
    //   185	485	5	k	int
    //   206	810	6	bool1	boolean
    //   334	642	7	bool2	boolean
    //   217	555	8	bool3	boolean
    //   230	392	9	bool4	boolean
    //   240	389	10	bool5	boolean
    //   263	421	11	bool6	boolean
    //   353	621	12	localObject	Object
    //   272	682	13	str1	String
    //   165	791	14	str2	String
    //   175	772	15	str3	String
    //   8	702	16	localJSONObject	JSONObject
    //   1006	1	16	localNumberFormatException	java.lang.NumberFormatException
    //   285	452	17	str4	String
    //   298	446	18	str5	String
    //   195	482	19	str6	String
    //   344	379	20	str7	String
    //   18	578	21	str8	String
    //   383	347	22	str9	String
    //   101	483	23	str10	String
    //   135	454	24	str11	String
    //   155	438	25	str12	String
    //   422	329	26	str13	String
    //   461	297	27	str14	String
    //   500	265	28	str15	String
    // Exception table:
    //   from	to	target	type
    //   0	51	989	java/lang/Exception
    //   51	93	989	java/lang/Exception
    //   93	126	989	java/lang/Exception
    //   127	309	989	java/lang/Exception
    //   316	323	989	java/lang/Exception
    //   323	526	989	java/lang/Exception
    //   529	561	989	java/lang/Exception
    //   562	572	989	java/lang/Exception
    //   577	604	989	java/lang/Exception
    //   607	614	989	java/lang/Exception
    //   619	633	989	java/lang/Exception
    //   636	654	989	java/lang/Exception
    //   654	694	989	java/lang/Exception
    //   694	720	989	java/lang/Exception
    //   720	812	989	java/lang/Exception
    //   816	849	989	java/lang/Exception
    //   855	930	989	java/lang/Exception
    //   935	969	989	java/lang/Exception
    //   972	982	989	java/lang/Exception
    //   982	988	989	java/lang/Exception
    //   694	720	1006	java/lang/NumberFormatException
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt != 0;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppYYBDownloadModule.2(this, paramString));
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
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a(((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue());
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppYYBDownloadModule$DownloadStateListener = null;
    DownloadManagerV2.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = null;
  }
  
  public String GetTypeName()
  {
    return "QQYYBDownload";
  }
  
  public boolean HasMethod(String paramString)
  {
    if (paramString.equals("getQueryDownloadAction")) {
      return true;
    }
    if (paramString.equals("doDownloadAction")) {
      return true;
    }
    return paramString.equals("RegisterDownloadCallBackListener");
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!ArkAPIPermission.a(this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.YYB_DOWNLOAD"))
    {
      QLog.i("ArkApp.downloadyyb.module", 1, "ArkAppYYBDownloadModule.invokeFunc permission denied");
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {
        b(paramString.getString(2131690155));
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp.downloadyyb.module", 1, String.format("ArkAppYYBDownloadModule.invokeFunc.%s", new Object[] { paramString }));
    }
    long l;
    if (paramString.equals("getQueryDownloadAction"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        l = a(paramArrayOfVariantWrapper[1].Copy());
        if (QLog.isColorLevel())
        {
          paramArrayOfVariantWrapper = new StringBuilder();
          paramArrayOfVariantWrapper.append("<getQueryDownloadAction> paramJson=");
          paramArrayOfVariantWrapper.append(paramString);
          QLog.i("ArkApp.downloadyyb.module", 1, paramArrayOfVariantWrapper.toString());
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
          paramArrayOfVariantWrapper = new StringBuilder();
          paramArrayOfVariantWrapper.append("[queryDownloadAction] e=");
          paramArrayOfVariantWrapper.append(paramString.getMessage());
          QLog.e("ArkApp.downloadyyb.module", 1, paramArrayOfVariantWrapper.toString());
        }
      }
      return true;
    }
    if (paramString.equals("doDownloadAction"))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppYYBDownloadModule$DownloadStateListener == null)
      {
        QLog.e("ArkApp.downloadyyb.module", 1, "should DownloadInit first ");
        paramVariantWrapper.SetInt(-2);
        return true;
      }
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        if (QLog.isColorLevel())
        {
          paramArrayOfVariantWrapper = new StringBuilder();
          paramArrayOfVariantWrapper.append("ArkAppYYBDownloadModule = ");
          paramArrayOfVariantWrapper.append(paramString);
          QLog.i("ArkApp.downloadyyb.module", 1, paramArrayOfVariantWrapper.toString());
        }
        a(paramString, paramVariantWrapper);
        return true;
      }
      paramVariantWrapper.SetInt(-1);
      return true;
    }
    if (paramString.equals("RegisterDownloadCallBackListener"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
      {
        l = a(paramArrayOfVariantWrapper[0].Copy());
        DownloadManagerV2.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
        this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppYYBDownloadModule$DownloadStateListener = new ArkAppYYBDownloadModule.1(this);
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    return false;
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
        boolean bool = TextUtils.isEmpty(paramDownloadInfo.l);
        if (bool)
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
  
  public boolean a()
  {
    return true;
  }
  
  protected ArkModuleMethod[] a()
  {
    return null;
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule
 * JD-Core Version:    0.7.0.1
 */