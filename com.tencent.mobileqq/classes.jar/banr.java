import BOSSStrategyCenter.tAdvDesc;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

public class banr
{
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("qboss_splash_ad_pref_" + paramString, 0);
  }
  
  public static banw a(tAdvDesc paramtAdvDesc, SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramtAdvDesc == null)
    {
      paramtAdvDesc = null;
      return paramtAdvDesc;
    }
    Object localObject3 = null;
    String str1 = paramtAdvDesc.task_id + "";
    String str2 = paramtAdvDesc.res_traceinfo;
    paramtAdvDesc = paramtAdvDesc.res_data;
    if (TextUtils.isEmpty(paramtAdvDesc)) {
      return null;
    }
    paramSharedPreferences = localObject3;
    for (;;)
    {
      try
      {
        Object localObject4 = new JSONObject(paramtAdvDesc);
        paramSharedPreferences = localObject3;
        String str3 = ((JSONObject)localObject4).getString("showStartTime");
        paramSharedPreferences = localObject3;
        String str4 = ((JSONObject)localObject4).getString("showEndTime");
        paramSharedPreferences = localObject3;
        int j = ((JSONObject)localObject4).getInt("resourceType");
        int k;
        int m;
        Object localObject2;
        Object localObject1;
        int i2;
        int i3;
        boolean bool;
        switch (j)
        {
        case 0: 
          paramSharedPreferences = localObject3;
          k = banv.a(((JSONObject)localObject4).getString("showPriority"));
          paramSharedPreferences = localObject3;
          m = ((JSONObject)localObject4).getInt("linkType");
          paramSharedPreferences = localObject3;
          localObject2 = ((JSONObject)localObject4).getString("linkURL");
          if (m == 1)
          {
            localObject1 = localObject2;
            paramSharedPreferences = localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localObject2;
              paramSharedPreferences = localObject3;
              if (!((String)localObject2).startsWith("http"))
              {
                paramSharedPreferences = localObject3;
                localObject1 = "https://" + (String)localObject2;
              }
            }
            paramSharedPreferences = localObject3;
            localObject2 = new StringBuilder().append((String)localObject1);
            paramSharedPreferences = localObject3;
            if (!((String)localObject1).contains("?")) {
              break label671;
            }
            localObject1 = "&";
            paramSharedPreferences = localObject3;
            localObject1 = bmzn.a(paramString, str2, (String)localObject1);
            paramSharedPreferences = localObject3;
            int n = banv.a(((JSONObject)localObject4).getString("androidMinimumMemorySize"));
            paramSharedPreferences = localObject3;
            int i1 = banv.a(((JSONObject)localObject4).getString("androidMinimumOSVersion"));
            paramSharedPreferences = localObject3;
            i2 = banv.a(((JSONObject)localObject4).getString("thirdPartyReportPlatform"));
            paramSharedPreferences = localObject3;
            localObject2 = ((JSONObject)localObject4).getString("thirdPartyReportURLForExposure");
            paramSharedPreferences = localObject3;
            i3 = banv.a(((JSONObject)localObject4).getString("shouldShowAdMark"));
            if ((i1 != 0) || (n != 0)) {
              break label678;
            }
            i = 0;
            paramSharedPreferences = localObject3;
            bool = a(i, n, i1);
            paramSharedPreferences = localObject3;
            if (!TextUtils.isEmpty(str1))
            {
              paramSharedPreferences = localObject3;
              if (!TextUtils.isEmpty(str3))
              {
                paramSharedPreferences = localObject3;
                if (!TextUtils.isEmpty(str4))
                {
                  paramSharedPreferences = localObject3;
                  if (!TextUtils.isEmpty(paramtAdvDesc)) {
                    continue;
                  }
                }
              }
            }
            paramSharedPreferences = localObject3;
            QLog.i("QSplash@QbossSplashCacheManager", 1, "downloadUrl = " + paramtAdvDesc + ", mAdID = " + str1 + ", mBeginTime = " + str3 + ", mEndTime = " + str4);
            return null;
            paramSharedPreferences = localObject3;
            paramtAdvDesc = ((JSONObject)localObject4).getString("imageURL");
          }
          break;
        case 1: 
          paramSharedPreferences = localObject3;
          paramtAdvDesc = ((JSONObject)localObject4).getString("gifURL");
          break;
        case 2: 
          paramSharedPreferences = localObject3;
          paramtAdvDesc = ((JSONObject)localObject4).getString("videoURL");
          continue;
          paramSharedPreferences = localObject3;
          localObject4 = new banx();
          paramSharedPreferences = localObject3;
          ((banx)localObject4).h(paramString).b(str1).c(str3).d(str4).c(j).e(paramtAdvDesc).d(m).f((String)localObject1).b(bool).g((String)localObject2).b(k).e(i2).i(str2).j("").a(i3);
          paramSharedPreferences = localObject3;
          paramString = ((banx)localObject4).a();
          paramtAdvDesc = paramString;
          paramSharedPreferences = paramString;
          if (!QLog.isColorLevel()) {
            break;
          }
          paramSharedPreferences = paramString;
          QLog.i("QSplash@QbossSplashCacheManager", 2, paramString.toString());
          return paramString;
          localObject1 = localObject2;
          break;
        default: 
          paramtAdvDesc = "";
          continue;
          localObject1 = "?";
        }
      }
      catch (Exception paramtAdvDesc)
      {
        return paramSharedPreferences;
      }
      label671:
      continue;
      label678:
      int i = 1;
    }
  }
  
  public static ArrayList<banw> a(ArrayList<tAdvDesc> paramArrayList, QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramArrayList, paramQQAppInterface, paramString, "qboss", null);
  }
  
  /* Error */
  public static ArrayList<banw> a(ArrayList<tAdvDesc> paramArrayList, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, java.util.List<cooperation.vip.pb.TianShuAccess.AdItem> paramList)
  {
    // Byte code:
    //   0: new 206	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 207	java/util/ArrayList:<init>	()V
    //   7: astore 9
    //   9: aload_1
    //   10: invokevirtual 213	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: aload_2
    //   14: invokestatic 216	banv:a	(Ljava/lang/String;)J
    //   17: invokestatic 221	bdhj:a	(Landroid/content/Context;J)V
    //   20: ldc 223
    //   22: aload_3
    //   23: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +200 -> 226
    //   29: aload 4
    //   31: ifnull +195 -> 226
    //   34: invokestatic 232	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   37: aload_2
    //   38: invokestatic 236	bnua:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   41: astore 8
    //   43: aload 4
    //   45: invokeinterface 242 1 0
    //   50: istore 5
    //   52: aload 9
    //   54: invokevirtual 245	java/util/ArrayList:clear	()V
    //   57: aload 9
    //   59: monitorenter
    //   60: iconst_0
    //   61: istore 6
    //   63: iload 6
    //   65: iload 5
    //   67: if_icmpge +217 -> 284
    //   70: ldc 223
    //   72: aload_3
    //   73: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifeq +168 -> 244
    //   79: aload 4
    //   81: ifnull +163 -> 244
    //   84: aload 4
    //   86: iload 6
    //   88: invokeinterface 249 2 0
    //   93: checkcast 251	cooperation/vip/pb/TianShuAccess$AdItem
    //   96: aload_1
    //   97: aload_2
    //   98: invokestatic 256	bnty:a	(Lcooperation/vip/pb/TianShuAccess$AdItem;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Lbanw;
    //   101: astore 7
    //   103: aload 7
    //   105: ifnull +580 -> 685
    //   108: aload 7
    //   110: getfield 259	banw:l	Ljava/lang/String;
    //   113: invokestatic 261	bnua:a	(Ljava/lang/String;)Z
    //   116: ifeq +569 -> 685
    //   119: aload 4
    //   121: iload 6
    //   123: invokeinterface 249 2 0
    //   128: checkcast 251	cooperation/vip/pb/TianShuAccess$AdItem
    //   131: aload 7
    //   133: getfield 259	banw:l	Ljava/lang/String;
    //   136: invokestatic 266	almm:a	(Lcooperation/vip/pb/TianShuAccess$AdItem;Ljava/lang/String;)Lalmm;
    //   139: astore 10
    //   141: invokestatic 271	almo:a	()Lalmo;
    //   144: aload_1
    //   145: aload 10
    //   147: iconst_0
    //   148: invokevirtual 274	almo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lalmm;Z)V
    //   151: aload 10
    //   153: aload_2
    //   154: aload 8
    //   156: invokevirtual 277	almm:a	(Ljava/lang/String;Landroid/content/SharedPreferences;)V
    //   159: aload 7
    //   161: ifnull +56 -> 217
    //   164: aload 9
    //   166: aload 7
    //   168: invokevirtual 280	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   171: pop
    //   172: aload 7
    //   174: getfield 282	banw:jdField_b_of_type_Int	I
    //   177: iconst_3
    //   178: if_icmpeq +12 -> 190
    //   181: aload 7
    //   183: getfield 282	banw:jdField_b_of_type_Int	I
    //   186: iconst_2
    //   187: if_icmpne +16 -> 203
    //   190: invokestatic 288	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager:getInstance	()Lcom/tencent/mobileqq/mini/entry/MiniAppPrePullManager;
    //   193: aload 7
    //   195: getfield 290	banw:f	Ljava/lang/String;
    //   198: iconst_0
    //   199: aconst_null
    //   200: invokevirtual 294	com/tencent/mobileqq/mini/entry/MiniAppPrePullManager:prePullAppinfoByLink	(Ljava/lang/String;ZLcom/tencent/mobileqq/mini/entry/MiniAppPrePullManager$IPrePullListener;)V
    //   203: getstatic 297	banv:a	Ljava/util/HashMap;
    //   206: aload 7
    //   208: getfield 299	banw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   211: aload 7
    //   213: invokevirtual 305	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   216: pop
    //   217: iload 6
    //   219: iconst_1
    //   220: iadd
    //   221: istore 6
    //   223: goto -160 -> 63
    //   226: invokestatic 232	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   229: aload_2
    //   230: invokestatic 306	banr:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   233: astore 8
    //   235: aload_0
    //   236: invokevirtual 307	java/util/ArrayList:size	()I
    //   239: istore 5
    //   241: goto -189 -> 52
    //   244: aload_0
    //   245: iload 6
    //   247: invokevirtual 308	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   250: checkcast 34	BOSSStrategyCenter/tAdvDesc
    //   253: astore 7
    //   255: aload 7
    //   257: ifnull -40 -> 217
    //   260: aload 7
    //   262: getfield 311	BOSSStrategyCenter/tAdvDesc:pattern_id	I
    //   265: sipush 1014
    //   268: if_icmpne -51 -> 217
    //   271: aload 7
    //   273: aload 8
    //   275: aload_2
    //   276: invokestatic 313	banr:a	(LBOSSStrategyCenter/tAdvDesc;Landroid/content/SharedPreferences;Ljava/lang/String;)Lbanw;
    //   279: astore 7
    //   281: goto -122 -> 159
    //   284: aload 9
    //   286: monitorexit
    //   287: aload 9
    //   289: invokevirtual 307	java/util/ArrayList:size	()I
    //   292: ifle +167 -> 459
    //   295: aload 8
    //   297: invokeinterface 319 1 0
    //   302: astore 4
    //   304: ldc 223
    //   306: aload_3
    //   307: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   310: ifeq +158 -> 468
    //   313: invokestatic 232	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   316: aload_2
    //   317: invokestatic 322	bnua:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Set;
    //   320: astore_0
    //   321: new 324	java/util/HashSet
    //   324: dup
    //   325: invokespecial 325	java/util/HashSet:<init>	()V
    //   328: astore 7
    //   330: new 327	java/lang/StringBuffer
    //   333: dup
    //   334: invokespecial 328	java/lang/StringBuffer:<init>	()V
    //   337: astore 8
    //   339: aload 9
    //   341: invokevirtual 332	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   344: astore 10
    //   346: aload 10
    //   348: invokeinterface 337 1 0
    //   353: ifeq +137 -> 490
    //   356: aload 10
    //   358: invokeinterface 341 1 0
    //   363: checkcast 195	banw
    //   366: astore 11
    //   368: aload 11
    //   370: getfield 299	banw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   373: astore 12
    //   375: aload 7
    //   377: aload 12
    //   379: invokeinterface 344 2 0
    //   384: pop
    //   385: aload 8
    //   387: aload 12
    //   389: invokevirtual 347	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   392: ldc_w 349
    //   395: invokevirtual 347	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   398: aload 11
    //   400: getfield 351	banw:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   403: invokevirtual 347	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   406: ldc_w 349
    //   409: invokevirtual 347	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   412: aload 11
    //   414: getfield 353	banw:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   417: invokevirtual 347	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   420: ldc_w 349
    //   423: invokevirtual 347	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   426: pop
    //   427: aload_0
    //   428: aload 12
    //   430: invokeinterface 355 2 0
    //   435: ifeq +44 -> 479
    //   438: aload_0
    //   439: aload 12
    //   441: invokeinterface 358 2 0
    //   446: pop
    //   447: aload 4
    //   449: aload 11
    //   451: iconst_0
    //   452: invokestatic 361	banr:a	(Landroid/content/SharedPreferences$Editor;Lbanw;Z)V
    //   455: goto -109 -> 346
    //   458: astore_0
    //   459: aload 9
    //   461: areturn
    //   462: astore_0
    //   463: aload 9
    //   465: monitorexit
    //   466: aload_0
    //   467: athrow
    //   468: invokestatic 232	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   471: aload_2
    //   472: invokestatic 362	banv:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Set;
    //   475: astore_0
    //   476: goto -155 -> 321
    //   479: aload 4
    //   481: aload 11
    //   483: iconst_1
    //   484: invokestatic 361	banr:a	(Landroid/content/SharedPreferences$Editor;Lbanw;Z)V
    //   487: goto -141 -> 346
    //   490: invokestatic 232	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   493: invokestatic 368	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   496: invokeinterface 319 1 0
    //   501: astore_0
    //   502: ldc 223
    //   504: aload_3
    //   505: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   508: ifeq +118 -> 626
    //   511: aload 4
    //   513: ldc_w 370
    //   516: aload 7
    //   518: invokestatic 373	banv:a	(Ljava/util/Set;)Ljava/lang/String;
    //   521: invokeinterface 379 3 0
    //   526: pop
    //   527: aload_0
    //   528: new 8	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 12	java/lang/StringBuilder:<init>	()V
    //   535: ldc_w 381
    //   538: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload_2
    //   542: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokevirtual 22	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: aload 8
    //   550: iconst_0
    //   551: aload 8
    //   553: invokevirtual 384	java/lang/StringBuffer:length	()I
    //   556: iconst_1
    //   557: isub
    //   558: invokevirtual 388	java/lang/StringBuffer:substring	(II)Ljava/lang/String;
    //   561: invokeinterface 379 3 0
    //   566: pop
    //   567: aload 4
    //   569: invokeinterface 391 1 0
    //   574: aload_0
    //   575: invokeinterface 391 1 0
    //   580: ldc 122
    //   582: iconst_1
    //   583: new 8	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 12	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 393
    //   593: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload 7
    //   598: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   601: ldc_w 398
    //   604: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload_3
    //   608: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 22	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 136	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   617: aload_1
    //   618: aload 9
    //   620: invokestatic 403	bans:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/Collection;)V
    //   623: aload 9
    //   625: areturn
    //   626: aload 4
    //   628: ldc_w 405
    //   631: aload 7
    //   633: invokestatic 373	banv:a	(Ljava/util/Set;)Ljava/lang/String;
    //   636: invokeinterface 379 3 0
    //   641: pop
    //   642: aload_0
    //   643: new 8	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 12	java/lang/StringBuilder:<init>	()V
    //   650: ldc_w 407
    //   653: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload_2
    //   657: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 22	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: aload 8
    //   665: iconst_0
    //   666: aload 8
    //   668: invokevirtual 384	java/lang/StringBuffer:length	()I
    //   671: iconst_1
    //   672: isub
    //   673: invokevirtual 388	java/lang/StringBuffer:substring	(II)Ljava/lang/String;
    //   676: invokeinterface 379 3 0
    //   681: pop
    //   682: goto -115 -> 567
    //   685: goto -526 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	paramArrayList	ArrayList<tAdvDesc>
    //   0	688	1	paramQQAppInterface	QQAppInterface
    //   0	688	2	paramString1	String
    //   0	688	3	paramString2	String
    //   0	688	4	paramList	java.util.List<cooperation.vip.pb.TianShuAccess.AdItem>
    //   50	190	5	i	int
    //   61	185	6	j	int
    //   101	531	7	localObject1	Object
    //   41	626	8	localObject2	Object
    //   7	617	9	localArrayList	ArrayList
    //   139	218	10	localObject3	Object
    //   366	116	11	localbanw	banw
    //   373	67	12	str	String
    // Exception table:
    //   from	to	target	type
    //   9	29	458	java/lang/Exception
    //   34	52	458	java/lang/Exception
    //   52	60	458	java/lang/Exception
    //   226	241	458	java/lang/Exception
    //   287	321	458	java/lang/Exception
    //   321	346	458	java/lang/Exception
    //   346	455	458	java/lang/Exception
    //   466	468	458	java/lang/Exception
    //   468	476	458	java/lang/Exception
    //   479	487	458	java/lang/Exception
    //   490	567	458	java/lang/Exception
    //   567	623	458	java/lang/Exception
    //   626	682	458	java/lang/Exception
    //   70	79	462	finally
    //   84	103	462	finally
    //   108	159	462	finally
    //   164	190	462	finally
    //   190	203	462	finally
    //   203	217	462	finally
    //   244	255	462	finally
    //   260	281	462	finally
    //   284	287	462	finally
    //   463	466	462	finally
  }
  
  public static void a(SharedPreferences.Editor paramEditor, banw parambanw, boolean paramBoolean)
  {
    paramEditor.putString("qboss_splash_ad_begin_time_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.jdField_c_of_type_JavaLangString);
    paramEditor.putString("qboss_splash_ad_end_time_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.jdField_d_of_type_JavaLangString);
    paramEditor.putInt("qbosss_plash_ad_content_type_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.jdField_a_of_type_Int);
    paramEditor.putString("qbosss_splash_ad_download_url_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.jdField_e_of_type_JavaLangString);
    paramEditor.putInt("qbosss_splash_ad_jumptype_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.jdField_b_of_type_Int);
    paramEditor.putString("qbosss_splash_ad_jump_h5_url_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.f);
    paramEditor.putInt("qboss_splash_ad_showpriority_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.jdField_d_of_type_Int);
    paramEditor.putBoolean("qboss_exposure_is_low_device_limit_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.jdField_a_of_type_Boolean);
    paramEditor.putInt("qboss_splash_ad_exposure_platform_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.jdField_c_of_type_Int);
    paramEditor.putString("qboss_splash_info_report_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.j);
    paramEditor.putString("qboss_splash_resource_md5_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.k);
    paramEditor.putInt("qboss_splash_should_show_ad_mark_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.jdField_e_of_type_Int);
    paramEditor.putString("qboss_splash_union_banner_type_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.l);
    String str2 = parambanw.g;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!str2.startsWith("https")) {
        str1 = parambanw.g.replaceFirst("http", "https");
      }
    }
    paramEditor.putString("qboss_exposure_url_" + parambanw.jdField_b_of_type_JavaLangString, str1);
    paramBoolean = banw.a(parambanw.h, true);
    if ((!parambanw.jdField_a_of_type_Boolean) && (paramBoolean)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      parambanw.jdField_b_of_type_Boolean = paramBoolean;
      paramEditor.putBoolean("qboss_splash_ad_is_limited_" + parambanw.jdField_b_of_type_JavaLangString, parambanw.jdField_b_of_type_Boolean);
      return;
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (1 == paramInt1)
    {
      l = bhlo.d();
      if (paramInt3 != 0)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT <= paramInt3) {}
      }
      else
      {
        if ((l == 0L) || (paramInt2 == 0) || (l > paramInt2 * 1024 * 1024)) {
          break label142;
        }
        bool1 = bool2;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("openDisabledLowerDevice ");
        localStringBuilder.append(" sdk_int:" + paramInt3);
        localStringBuilder.append(" mem:" + paramInt2);
        QLog.d("QSplash@QbossSplashCacheManager", 2, localStringBuilder.toString());
      }
    }
    label142:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        long l;
        StringBuilder localStringBuilder;
        return bool1;
        bool1 = false;
      }
    }
    QLog.d("QSplash@QbossSplashCacheManager", 2, "isDisabledLowerDevice false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banr
 * JD-Core Version:    0.7.0.1
 */