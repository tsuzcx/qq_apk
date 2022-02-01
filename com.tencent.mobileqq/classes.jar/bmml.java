import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.webviewplugin.QzoneMoodPlugin.1;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class bmml
  extends bmmk
{
  private static CopyOnWriteArrayList<bmmm> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
  private boolean jdField_a_of_type_Boolean;
  
  /* Error */
  private bmmm a()
  {
    // Byte code:
    //   0: new 35	bmmm
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 38	bmmm:<init>	(Lbmml;)V
    //   8: astore 8
    //   10: aload 8
    //   12: aload_0
    //   13: getfield 41	bmml:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   16: getfield 47	com/tencent/mobileqq/webview/swift/WebViewPlugin:mRuntime	Lbhod;
    //   19: invokevirtual 52	bhod:a	()Lcom/tencent/common/app/AppInterface;
    //   22: invokevirtual 58	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   25: putfield 61	bmmm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   28: invokestatic 67	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   31: invokevirtual 73	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   34: new 75	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   41: ldc 78
    //   43: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload 8
    //   48: getfield 61	bmmm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 91	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   60: iconst_3
    //   61: anewarray 93	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: ldc 95
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: ldc 97
    //   73: aastore
    //   74: dup
    //   75: iconst_2
    //   76: ldc 99
    //   78: aastore
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: invokevirtual 105	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore 5
    //   87: aload 5
    //   89: ifnull +112 -> 201
    //   92: aload 5
    //   94: astore 4
    //   96: aload 5
    //   98: invokeinterface 111 1 0
    //   103: ifeq +98 -> 201
    //   106: aload 5
    //   108: astore 4
    //   110: aload 5
    //   112: ldc 95
    //   114: invokeinterface 115 2 0
    //   119: istore_1
    //   120: aload 5
    //   122: astore 4
    //   124: aload 5
    //   126: ldc 97
    //   128: invokeinterface 115 2 0
    //   133: istore_2
    //   134: aload 5
    //   136: astore 4
    //   138: aload 5
    //   140: ldc 99
    //   142: invokeinterface 115 2 0
    //   147: istore_3
    //   148: aload 5
    //   150: astore 4
    //   152: aload 5
    //   154: iload_1
    //   155: invokeinterface 119 2 0
    //   160: astore 6
    //   162: aload 5
    //   164: astore 4
    //   166: aload 6
    //   168: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   171: ifeq +45 -> 216
    //   174: aload 5
    //   176: astore 4
    //   178: aload 5
    //   180: invokeinterface 128 1 0
    //   185: ifne -37 -> 148
    //   188: aload 5
    //   190: astore 4
    //   192: getstatic 28	bmml:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   195: aload 8
    //   197: invokevirtual 132	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   200: pop
    //   201: aload 5
    //   203: ifnull +10 -> 213
    //   206: aload 5
    //   208: invokeinterface 135 1 0
    //   213: aload 8
    //   215: areturn
    //   216: aload 5
    //   218: astore 4
    //   220: new 93	java/lang/String
    //   223: dup
    //   224: aload 6
    //   226: invokevirtual 139	java/lang/String:getBytes	()[B
    //   229: ldc 141
    //   231: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   234: iconst_0
    //   235: invokestatic 150	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;Z)Ljava/lang/String;
    //   238: astore 9
    //   240: aload 5
    //   242: astore 4
    //   244: aload 5
    //   246: iload_2
    //   247: invokeinterface 119 2 0
    //   252: astore 6
    //   254: aload 5
    //   256: astore 4
    //   258: aload 6
    //   260: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   263: ifne +104 -> 367
    //   266: aload 5
    //   268: astore 4
    //   270: new 93	java/lang/String
    //   273: dup
    //   274: aload 6
    //   276: invokevirtual 139	java/lang/String:getBytes	()[B
    //   279: ldc 141
    //   281: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   284: iconst_0
    //   285: invokestatic 150	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;Z)Ljava/lang/String;
    //   288: astore 6
    //   290: aload 5
    //   292: astore 4
    //   294: aload 8
    //   296: getfield 153	bmmm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   299: aload 9
    //   301: aload 6
    //   303: invokevirtual 159	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   306: pop
    //   307: goto -133 -> 174
    //   310: astore 6
    //   312: aload 5
    //   314: astore 4
    //   316: ldc 161
    //   318: new 75	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   325: ldc 163
    //   327: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 6
    //   332: invokestatic 169	cooperation/qzone/util/QZLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   335: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 173	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload 5
    //   346: astore 4
    //   348: aload 6
    //   350: invokevirtual 176	java/lang/Throwable:printStackTrace	()V
    //   353: aload 5
    //   355: ifnull +10 -> 365
    //   358: aload 5
    //   360: invokeinterface 135 1 0
    //   365: aconst_null
    //   366: areturn
    //   367: aload 5
    //   369: astore 4
    //   371: aload 5
    //   373: iload_3
    //   374: invokeinterface 119 2 0
    //   379: astore 6
    //   381: aload 5
    //   383: astore 4
    //   385: aload 6
    //   387: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   390: ifne -216 -> 174
    //   393: aload 5
    //   395: astore 4
    //   397: new 93	java/lang/String
    //   400: dup
    //   401: aload 6
    //   403: invokevirtual 139	java/lang/String:getBytes	()[B
    //   406: ldc 141
    //   408: invokespecial 144	java/lang/String:<init>	([BLjava/lang/String;)V
    //   411: iconst_0
    //   412: invokestatic 150	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;Z)Ljava/lang/String;
    //   415: astore 7
    //   417: aload 7
    //   419: astore 6
    //   421: aload 5
    //   423: astore 4
    //   425: aload 7
    //   427: invokevirtual 180	java/lang/String:length	()I
    //   430: iconst_1
    //   431: if_icmple +47 -> 478
    //   434: aload 7
    //   436: astore 6
    //   438: aload 5
    //   440: astore 4
    //   442: aload 7
    //   444: aload 7
    //   446: invokevirtual 180	java/lang/String:length	()I
    //   449: iconst_1
    //   450: isub
    //   451: invokevirtual 184	java/lang/String:charAt	(I)C
    //   454: bipush 10
    //   456: if_icmpne +22 -> 478
    //   459: aload 5
    //   461: astore 4
    //   463: aload 7
    //   465: iconst_0
    //   466: aload 7
    //   468: invokevirtual 180	java/lang/String:length	()I
    //   471: iconst_1
    //   472: isub
    //   473: invokevirtual 188	java/lang/String:substring	(II)Ljava/lang/String;
    //   476: astore 6
    //   478: aload 5
    //   480: astore 4
    //   482: aload 8
    //   484: getfield 153	bmmm:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   487: aload 9
    //   489: aload 6
    //   491: invokevirtual 159	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   494: pop
    //   495: goto -321 -> 174
    //   498: astore 6
    //   500: aload 4
    //   502: astore 5
    //   504: aload 6
    //   506: astore 4
    //   508: aload 5
    //   510: ifnull +10 -> 520
    //   513: aload 5
    //   515: invokeinterface 135 1 0
    //   520: aload 4
    //   522: athrow
    //   523: astore 4
    //   525: aconst_null
    //   526: astore 5
    //   528: goto -20 -> 508
    //   531: astore 6
    //   533: aconst_null
    //   534: astore 5
    //   536: goto -224 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	bmml
    //   119	36	1	i	int
    //   133	114	2	j	int
    //   147	227	3	k	int
    //   94	427	4	localObject1	Object
    //   523	1	4	localObject2	Object
    //   85	450	5	localObject3	Object
    //   160	142	6	str1	String
    //   310	39	6	localThrowable1	Throwable
    //   379	111	6	localObject4	Object
    //   498	7	6	localObject5	Object
    //   531	1	6	localThrowable2	Throwable
    //   415	52	7	str2	String
    //   8	475	8	localbmmm	bmmm
    //   238	250	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   96	106	310	java/lang/Throwable
    //   110	120	310	java/lang/Throwable
    //   124	134	310	java/lang/Throwable
    //   138	148	310	java/lang/Throwable
    //   152	162	310	java/lang/Throwable
    //   166	174	310	java/lang/Throwable
    //   178	188	310	java/lang/Throwable
    //   192	201	310	java/lang/Throwable
    //   220	240	310	java/lang/Throwable
    //   244	254	310	java/lang/Throwable
    //   258	266	310	java/lang/Throwable
    //   270	290	310	java/lang/Throwable
    //   294	307	310	java/lang/Throwable
    //   371	381	310	java/lang/Throwable
    //   385	393	310	java/lang/Throwable
    //   397	417	310	java/lang/Throwable
    //   425	434	310	java/lang/Throwable
    //   442	459	310	java/lang/Throwable
    //   463	478	310	java/lang/Throwable
    //   482	495	310	java/lang/Throwable
    //   96	106	498	finally
    //   110	120	498	finally
    //   124	134	498	finally
    //   138	148	498	finally
    //   152	162	498	finally
    //   166	174	498	finally
    //   178	188	498	finally
    //   192	201	498	finally
    //   220	240	498	finally
    //   244	254	498	finally
    //   258	266	498	finally
    //   270	290	498	finally
    //   294	307	498	finally
    //   316	344	498	finally
    //   348	353	498	finally
    //   371	381	498	finally
    //   385	393	498	finally
    //   397	417	498	finally
    //   425	434	498	finally
    //   442	459	498	finally
    //   463	478	498	finally
    //   482	495	498	finally
    //   28	87	523	finally
    //   28	87	531	java/lang/Throwable
  }
  
  private static String a(String paramString, ArrayList<ResultRecord> paramArrayList)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    try
    {
      paramString = Pattern.compile("@\\{uin:(\\d+),nick:(.+?)\\}").matcher(paramString);
      while (paramString.find())
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("QzoneMoodPlugin", 4, "match:" + paramString.group() + " uin=" + paramString.group(1) + " nick=" + paramString.group(2));
        }
        paramArrayList = new ResultRecord();
        paramArrayList.jdField_a_of_type_JavaLangString = paramString.group(1);
        paramArrayList.b = paramString.group(2);
        ((ArrayList)localObject).add(paramArrayList);
      }
      paramString = paramString.replaceAll("");
    }
    catch (Exception paramString)
    {
      QLog.e("QzoneMoodPlugin", 1, "parse at string error:", paramString);
      return null;
    }
    return paramString;
  }
  
  private boolean a(String paramString)
  {
    try
    {
      localObject4 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject4).getString("text");
      localObject3 = null;
      if (!TextUtils.isEmpty(paramString)) {
        break label559;
      }
      localObject1 = ((JSONObject)localObject4).optString("base64UBBText");
      bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (bool) {
        break label559;
      }
    }
    catch (Exception paramString)
    {
      Object localObject4;
      boolean bool;
      Object localObject2;
      label181:
      QLog.e("QzoneMoodPlugin", 1, paramString.getMessage());
      return false;
    }
    for (;;)
    {
      try
      {
        localObject2 = new String(Base64.decode((String)localObject1, 2));
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject1 = new ArrayList();
      }
      catch (Throwable localThrowable2)
      {
        localObject1 = localObject3;
        break label181;
      }
      try
      {
        localObject2 = a((String)localObject2, (ArrayList)localObject1);
        bool = TextUtils.isEmpty((CharSequence)localObject2);
        if (bool) {
          continue;
        }
        paramString = (String)localObject2;
      }
      catch (Throwable localThrowable1)
      {
        break label181;
        break;
      }
    }
    localObject2 = localObject1;
    localObject1 = paramString;
    paramString = (String)localObject2;
    for (;;)
    {
      localObject2 = ((JSONObject)localObject4).getJSONArray("photoList");
      ArrayList localArrayList = new ArrayList();
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i < ((JSONArray)localObject2).length())
          {
            localArrayList.add(((JSONArray)localObject2).getJSONObject(i).getString("url"));
            i += 1;
            continue;
            QLog.e("QzoneMoodPlugin", 1, "writeMood: parse base64UBBText error:", (Throwable)localObject2);
            localObject2 = paramString;
            paramString = (String)localObject1;
            localObject1 = localObject2;
            break;
          }
        }
      }
      localObject3 = null;
      String str1 = ((JSONObject)localObject4).optString("tagId");
      String str2 = ((JSONObject)localObject4).optString("tagTitle");
      String str3 = ((JSONObject)localObject4).optString("tagUrl");
      String str4 = ((JSONObject)localObject4).optString("tagProtocol");
      String str5 = ((JSONObject)localObject4).optString("desc");
      int i = ((JSONObject)localObject4).optInt("isfromfeedcombine");
      String str6 = ((JSONObject)localObject4).optString("descTruncateNum");
      localObject2 = localObject3;
      if (!TextUtils.isEmpty(str1))
      {
        localObject2 = localObject3;
        if (!TextUtils.isEmpty(str2))
        {
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(str3))
          {
            localObject2 = localObject3;
            if (!TextUtils.isEmpty(str4))
            {
              localObject3 = new PublishEventTag();
              ((PublishEventTag)localObject3).c = str1;
              ((PublishEventTag)localObject3).jdField_a_of_type_JavaLangString = str2;
              ((PublishEventTag)localObject3).b = str3;
              ((PublishEventTag)localObject3).d = str4;
              localObject2 = localObject3;
              if (i == 1)
              {
                localObject2 = localObject3;
                if (!TextUtils.isEmpty(str5))
                {
                  localObject2 = localObject3;
                  if (!TextUtils.isEmpty(str6))
                  {
                    ((PublishEventTag)localObject3).b = "https://qzonestyle.gtimg.cn/aoi/sola/20170323194618_Xgy5reWQh0.png";
                    ((PublishEventTag)localObject3).e = str5;
                    ((PublishEventTag)localObject3).f = str6;
                    localObject2 = localObject3;
                  }
                }
              }
            }
          }
        }
      }
      localObject4 = ((JSONObject)localObject4).optString("singlePic");
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (localObject3 != null))
      {
        localObject4 = bmnl.a((Context)localObject3, (String)localObject4);
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          localArrayList.add(localObject4);
        }
      }
      if (localObject3 != null)
      {
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getCurrentAccountUin();
        ThreadManager.getSubThreadHandler().post(new QzoneMoodPlugin.1(this, paramString, (String)localObject4, i, (Activity)localObject3, (String)localObject1, localArrayList, (PublishEventTag)localObject2));
        return true;
      }
      return false;
      localObject1 = null;
      break;
      label559:
      localObject1 = paramString;
      paramString = null;
    }
  }
  
  private void b()
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    if (localActivity != null)
    {
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "refreshFeed");
      localIntent.putExtras(localBundle);
      blsb.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), blsi.a(), localIntent);
      localActivity.setResult(-1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
    }
  }
  
  private void c()
  {
    bmfd.a().a().t();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      bmfd.a().a();
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("signInSuccess".equals(paramString3))
    {
      try
      {
        paramString3 = new JSONObject(paramVarArgs[0]);
        if (paramString3.optBoolean("shareToWX"))
        {
          paramJsBridgeListener = paramString3.optString("image");
          paramString1 = paramString3.optString("text");
          paramString2 = paramString3.optString("fontId");
          paramString3 = paramString3.optString("fontUrl");
          bmfd.a().a().a(paramString1, paramJsBridgeListener, paramString2, paramString3);
          this.jdField_a_of_type_Boolean = true;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() == null) {
          break label186;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
        return true;
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("QzoneMoodPlugin", 1, paramJsBridgeListener.getMessage());
        return false;
      }
    }
    else
    {
      if ("editMoodSuccess".equals(paramString3))
      {
        b();
        return true;
      }
      if (bmld.i.equals(paramString3)) {
        return a(paramVarArgs[0]);
      }
      if ("deleteUnpublishedShuoShuo".equals(paramString3))
      {
        c();
        return true;
      }
    }
    label186:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmml
 * JD-Core Version:    0.7.0.1
 */