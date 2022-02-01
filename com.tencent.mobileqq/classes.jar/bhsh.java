import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.SocialWeeklyWebViewPlugin.1;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bhsh
  extends WebViewPlugin
{
  private String a;
  
  public bhsh()
  {
    this.mPluginNameSpace = "SocialWeekly";
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_1
    //   4: iconst_0
    //   5: invokestatic 28	bgku:decode	(Ljava/lang/String;I)[B
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload 7
    //   13: astore_2
    //   14: aload_1
    //   15: ifnull +142 -> 157
    //   18: ldc 30
    //   20: invokestatic 36	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   23: invokevirtual 42	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +165 -> 191
    //   29: new 44	java/io/File
    //   32: dup
    //   33: getstatic 49	anhk:ba	Ljava/lang/String;
    //   36: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: new 44	java/io/File
    //   43: dup
    //   44: aload_2
    //   45: ldc 12
    //   47: invokespecial 55	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 59	java/io/File:exists	()Z
    //   55: ifne +8 -> 63
    //   58: aload_2
    //   59: invokevirtual 62	java/io/File:mkdirs	()Z
    //   62: pop
    //   63: new 44	java/io/File
    //   66: dup
    //   67: aload_2
    //   68: aload_1
    //   69: invokestatic 68	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   72: invokespecial 55	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   75: astore 5
    //   77: aload 5
    //   79: invokevirtual 59	java/io/File:exists	()Z
    //   82: ifeq +9 -> 91
    //   85: aload 5
    //   87: invokevirtual 71	java/io/File:delete	()Z
    //   90: pop
    //   91: new 73	java/io/FileOutputStream
    //   94: dup
    //   95: aload 5
    //   97: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   100: astore_2
    //   101: new 78	java/io/BufferedOutputStream
    //   104: dup
    //   105: aload_2
    //   106: invokespecial 81	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   109: astore 6
    //   111: aload 6
    //   113: astore 4
    //   115: aload_2
    //   116: astore_3
    //   117: aload 6
    //   119: aload_1
    //   120: invokevirtual 85	java/io/BufferedOutputStream:write	([B)V
    //   123: aload 6
    //   125: astore 4
    //   127: aload_2
    //   128: astore_3
    //   129: aload 5
    //   131: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   134: astore_1
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   143: aload_1
    //   144: astore_2
    //   145: aload 6
    //   147: ifnull +10 -> 157
    //   150: aload 6
    //   152: invokevirtual 92	java/io/BufferedOutputStream:close	()V
    //   155: aload_1
    //   156: astore_2
    //   157: aload_2
    //   158: areturn
    //   159: astore_2
    //   160: ldc 94
    //   162: iconst_1
    //   163: new 96	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   170: ldc 99
    //   172: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_1
    //   176: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: aload_2
    //   183: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   186: aconst_null
    //   187: astore_1
    //   188: goto -177 -> 11
    //   191: invokestatic 118	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   194: invokevirtual 122	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   197: astore_2
    //   198: goto -158 -> 40
    //   201: astore 5
    //   203: aconst_null
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_2
    //   207: aload_1
    //   208: astore 4
    //   210: aload_2
    //   211: astore_3
    //   212: ldc 94
    //   214: iconst_1
    //   215: ldc 124
    //   217: aload 5
    //   219: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload_2
    //   223: ifnull +7 -> 230
    //   226: aload_2
    //   227: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   230: aload 7
    //   232: astore_2
    //   233: aload_1
    //   234: ifnull -77 -> 157
    //   237: aload_1
    //   238: invokevirtual 92	java/io/BufferedOutputStream:close	()V
    //   241: aconst_null
    //   242: areturn
    //   243: astore_1
    //   244: aconst_null
    //   245: areturn
    //   246: astore_1
    //   247: aconst_null
    //   248: astore 4
    //   250: aconst_null
    //   251: astore_2
    //   252: aload_2
    //   253: ifnull +7 -> 260
    //   256: aload_2
    //   257: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   260: aload 4
    //   262: ifnull +8 -> 270
    //   265: aload 4
    //   267: invokevirtual 92	java/io/BufferedOutputStream:close	()V
    //   270: aload_1
    //   271: athrow
    //   272: astore_2
    //   273: goto -3 -> 270
    //   276: astore_1
    //   277: aconst_null
    //   278: astore 4
    //   280: goto -28 -> 252
    //   283: astore_1
    //   284: aload_3
    //   285: astore_2
    //   286: goto -34 -> 252
    //   289: astore 5
    //   291: aconst_null
    //   292: astore_1
    //   293: goto -86 -> 207
    //   296: astore 5
    //   298: aload 6
    //   300: astore_1
    //   301: goto -94 -> 207
    //   304: astore_2
    //   305: aload_1
    //   306: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	bhsh
    //   0	307	1	paramString	String
    //   8	150	2	localObject1	Object
    //   159	24	2	localException1	Exception
    //   197	60	2	localObject2	Object
    //   272	1	2	localException2	Exception
    //   285	1	2	localObject3	Object
    //   304	1	2	localException3	Exception
    //   116	169	3	localObject4	Object
    //   113	166	4	localObject5	Object
    //   75	55	5	localFile	java.io.File
    //   201	17	5	localException4	Exception
    //   289	1	5	localException5	Exception
    //   296	1	5	localException6	Exception
    //   109	190	6	localBufferedOutputStream	java.io.BufferedOutputStream
    //   1	230	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   3	9	159	java/lang/Exception
    //   18	40	201	java/lang/Exception
    //   40	63	201	java/lang/Exception
    //   63	91	201	java/lang/Exception
    //   91	101	201	java/lang/Exception
    //   191	198	201	java/lang/Exception
    //   226	230	243	java/lang/Exception
    //   237	241	243	java/lang/Exception
    //   18	40	246	finally
    //   40	63	246	finally
    //   63	91	246	finally
    //   91	101	246	finally
    //   191	198	246	finally
    //   256	260	272	java/lang/Exception
    //   265	270	272	java/lang/Exception
    //   101	111	276	finally
    //   117	123	283	finally
    //   129	135	283	finally
    //   212	222	283	finally
    //   101	111	289	java/lang/Exception
    //   117	123	296	java/lang/Exception
    //   129	135	296	java/lang/Exception
    //   139	143	304	java/lang/Exception
    //   150	155	304	java/lang/Exception
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SocialWeeklyWebViewPlugin", 2, String.format("handleJsRequest pkgName=%s method=%s url=%s", new Object[] { paramString2, paramString3, paramString1 }));
    }
    if (("SocialWeekly".equals(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1)) && ("sharePicMessage".equals(paramString3))) {
      try
      {
        paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramJsBridgeListener != null)
        {
          paramJsBridgeListener = paramJsBridgeListener.getString("imageData");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            int i = paramJsBridgeListener.indexOf(',');
            if (i > 0) {
              postPluginAsyncTask(new SocialWeeklyWebViewPlugin.1(this, paramJsBridgeListener.substring(i)));
            }
          }
        }
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.d("SocialWeeklyWebViewPlugin", 1, "handleJsRequest json parse fail!", paramJsBridgeListener);
        return true;
      }
    }
    return false;
  }
  
  public void onPostPluginAsyncTask()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SocialWeeklyWebViewPlugin", 2, "onPostPluginAsyncTask mSharePicLocalPath=" + this.a);
    }
    if (!TextUtils.isEmpty(this.a))
    {
      Activity localActivity = this.mRuntime.a();
      if (localActivity != null)
      {
        Intent localIntent = new Intent();
        localIntent.setClass(localActivity, ForwardRecentActivity.class);
        localIntent.putExtra("forward_type", 1);
        localIntent.putExtra("forward_filepath", this.a);
        localIntent.putExtra("isFromShare", true);
        localActivity.startActivity(localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsh
 * JD-Core Version:    0.7.0.1
 */