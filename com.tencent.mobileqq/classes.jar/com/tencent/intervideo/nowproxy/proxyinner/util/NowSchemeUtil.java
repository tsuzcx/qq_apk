package com.tencent.intervideo.nowproxy.proxyinner.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.intervideo.nowproxy.Global;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.NowRoomEntry;
import com.tencent.intervideo.nowproxy.baseability.log.DefaultLog;
import com.tencent.intervideo.nowproxy.common.ThreadManager;
import com.tencent.intervideo.nowproxy.common.log.XLog;
import java.net.URLDecoder;

public class NowSchemeUtil
{
  private static String TAG = "NowSchemeUtil";
  
  public static String addBusiParam(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString1.contains("?"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("&busiparam=");
        ((StringBuilder)localObject).append(paramString2);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("?busiparam=");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static boolean doAction(Context paramContext, String paramString, Intent paramIntent)
  {
    paramIntent.putExtra("doAction", paramString);
    if ((TextUtils.isEmpty(paramString)) && (!Global.sAppid.equals("2")))
    {
      Toast.makeText(paramContext, "缺少关键参数action", 0).show();
      return false;
    }
    try
    {
      paramContext = paramIntent.getStringExtra("decoded_scheme");
      paramContext = paramContext.substring(paramContext.indexOf("viewid"), paramContext.length());
    }
    catch (Exception paramContext)
    {
      label63:
      StringBuilder localStringBuilder;
      break label63;
    }
    paramContext = "";
    if (!TextUtils.isEmpty(paramContext))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://c.gdt.qq.com/gdt_mclick.fcg?");
      localStringBuilder.append(paramContext);
      paramContext = localStringBuilder.toString();
      ThreadManager.getFileThreadHandler().post(new NowSchemeUtil.1(paramContext));
    }
    if (paramString.equalsIgnoreCase("openroom")) {
      return doOpenRoomAction(paramIntent);
    }
    if (paramString.equalsIgnoreCase("preload"))
    {
      NowLive.preload(null);
      return true;
    }
    NowLive.getNowRoomEntry().enterPluginManager(6, paramIntent.getExtras());
    return true;
  }
  
  public static boolean doActionByScheme(Context paramContext, String paramString, Bundle paramBundle, long paramLong)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doActionByScheme scheme = ");
    localStringBuilder.append(paramString);
    XLog.i(str, localStringBuilder.toString());
    paramString = parseSchemeUrl(paramString);
    if (paramString == null) {
      return false;
    }
    str = paramString.getStringExtra("action");
    if (paramBundle != null) {
      paramString.putExtras(paramBundle);
    }
    paramString.putExtra("actionSeq", paramLong);
    paramString.removeExtra("action");
    return doAction(paramContext, str, paramString);
  }
  
  /* Error */
  private static boolean doOpenRoomAction(Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 102
    //   2: astore 9
    //   4: lconst_0
    //   5: lstore 4
    //   7: aconst_null
    //   8: astore 13
    //   10: iconst_2
    //   11: istore_2
    //   12: aload_0
    //   13: ldc 184
    //   15: invokevirtual 86	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 190	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   21: lstore 6
    //   23: lload 6
    //   25: lstore 4
    //   27: aload_0
    //   28: ldc 192
    //   30: invokevirtual 86	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 14
    //   35: aload 9
    //   37: astore 8
    //   39: iload_2
    //   40: istore_3
    //   41: aload_0
    //   42: ldc 194
    //   44: invokevirtual 86	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 15
    //   49: aload 9
    //   51: astore 8
    //   53: iload_2
    //   54: istore_3
    //   55: aload_0
    //   56: ldc 196
    //   58: invokevirtual 86	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore 10
    //   63: aload 10
    //   65: astore 8
    //   67: iload_2
    //   68: istore_3
    //   69: aload_0
    //   70: ldc 198
    //   72: invokevirtual 86	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   75: astore 9
    //   77: iload_2
    //   78: istore_1
    //   79: aload 9
    //   81: ifnull +22 -> 103
    //   84: iload_2
    //   85: istore_1
    //   86: aload 9
    //   88: invokevirtual 96	java/lang/String:length	()I
    //   91: ifle +12 -> 103
    //   94: aload 9
    //   96: invokestatic 204	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   99: invokevirtual 207	java/lang/Integer:intValue	()I
    //   102: istore_1
    //   103: aload 10
    //   105: astore 9
    //   107: lload 6
    //   109: lstore 4
    //   111: aload 13
    //   113: astore 11
    //   115: iload_1
    //   116: istore_2
    //   117: aload 14
    //   119: astore 12
    //   121: aload 10
    //   123: astore 8
    //   125: iload_1
    //   126: istore_3
    //   127: aload 15
    //   129: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   132: ifne +75 -> 207
    //   135: aload 10
    //   137: astore 8
    //   139: iload_1
    //   140: istore_3
    //   141: new 209	java/util/ArrayList
    //   144: dup
    //   145: invokespecial 210	java/util/ArrayList:<init>	()V
    //   148: astore 9
    //   150: aload 10
    //   152: astore 8
    //   154: iload_1
    //   155: istore_3
    //   156: aload 9
    //   158: aload 15
    //   160: invokevirtual 213	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   163: pop
    //   164: aload 10
    //   166: astore 8
    //   168: iload_1
    //   169: istore_3
    //   170: new 215	com/tencent/intervideo/nowproxy/ListNameData
    //   173: dup
    //   174: aload 9
    //   176: iconst_0
    //   177: invokespecial 218	com/tencent/intervideo/nowproxy/ListNameData:<init>	(Ljava/util/ArrayList;I)V
    //   180: astore 11
    //   182: aload 10
    //   184: astore 9
    //   186: lload 6
    //   188: lstore 4
    //   190: iload_1
    //   191: istore_2
    //   192: aload 14
    //   194: astore 12
    //   196: goto +11 -> 207
    //   199: ldc 102
    //   201: astore 12
    //   203: aload 13
    //   205: astore 11
    //   207: aload 11
    //   209: lload 4
    //   211: aload 12
    //   213: aload 9
    //   215: iload_2
    //   216: aload_0
    //   217: invokevirtual 146	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   220: invokestatic 222	com/tencent/intervideo/nowproxy/NowLive:openRoom	(Lcom/tencent/intervideo/nowproxy/ListNameData;JLjava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Z
    //   223: ireturn
    //   224: astore 8
    //   226: goto -27 -> 199
    //   229: astore 9
    //   231: aload 8
    //   233: astore 9
    //   235: lload 6
    //   237: lstore 4
    //   239: aload 13
    //   241: astore 11
    //   243: iload_3
    //   244: istore_2
    //   245: aload 14
    //   247: astore 12
    //   249: goto -42 -> 207
    //   252: astore 8
    //   254: iload_2
    //   255: istore_1
    //   256: goto -153 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramIntent	Intent
    //   78	178	1	i	int
    //   11	244	2	j	int
    //   40	204	3	k	int
    //   5	233	4	l1	long
    //   21	215	6	l2	long
    //   37	130	8	localObject1	Object
    //   224	8	8	localException1	Exception
    //   252	1	8	localException2	Exception
    //   2	212	9	localObject2	Object
    //   229	1	9	localException3	Exception
    //   233	1	9	localObject3	Object
    //   61	122	10	str1	String
    //   113	129	11	localObject4	Object
    //   119	129	12	str2	String
    //   8	232	13	localObject5	Object
    //   33	213	14	str3	String
    //   47	112	15	str4	String
    // Exception table:
    //   from	to	target	type
    //   12	23	224	java/lang/Exception
    //   27	35	224	java/lang/Exception
    //   41	49	229	java/lang/Exception
    //   55	63	229	java/lang/Exception
    //   69	77	229	java/lang/Exception
    //   127	135	229	java/lang/Exception
    //   141	150	229	java/lang/Exception
    //   156	164	229	java/lang/Exception
    //   170	182	229	java/lang/Exception
    //   86	103	252	java/lang/Exception
  }
  
  public static Intent parseSchemeUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = URLDecoder.decode(paramString, "UTF-8");
      Intent localIntent = new Intent();
      localIntent.putExtra("original_scheme", paramString);
      localIntent.putExtra("decoded_scheme", (String)localObject);
      paramString = ((String)localObject).split("&");
      if (paramString != null)
      {
        if (paramString.length == 0) {
          return null;
        }
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramString[i].split("=");
          if (localObject.length == 2) {
            localIntent.putExtra(localObject[0], localObject[1]);
          }
          i += 1;
        }
        return localIntent;
      }
      return null;
    }
    catch (Exception paramString)
    {
      DefaultLog.e(TAG, "parseScheme decode exception");
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.util.NowSchemeUtil
 * JD-Core Version:    0.7.0.1
 */