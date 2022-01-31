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
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString1.contains("?")) {
        str = paramString1 + "&busiparam=" + paramString2;
      }
    }
    else {
      return str;
    }
    return paramString1 + "?busiparam=" + paramString2;
  }
  
  public static boolean doAction(Context paramContext, String paramString, Intent paramIntent)
  {
    paramIntent.putExtra("doAction", paramString);
    if ((TextUtils.isEmpty(paramString)) && (!Global.sAppid.equals("2")))
    {
      Toast.makeText(paramContext, "缺少关键参数action", 0).show();
      return false;
    }
    paramContext = "";
    try
    {
      String str = paramIntent.getStringExtra("decoded_scheme");
      str = str.substring(str.indexOf("viewid"), str.length());
      paramContext = str;
    }
    catch (Exception localException)
    {
      label65:
      break label65;
    }
    if (!TextUtils.isEmpty(paramContext))
    {
      paramContext = "http://c.gdt.qq.com/gdt_mclick.fcg?" + paramContext;
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
    XLog.i(TAG, "doActionByScheme scheme = " + paramString);
    paramString = parseSchemeUrl(paramString);
    if (paramString == null) {
      return false;
    }
    String str = paramString.getStringExtra("action");
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
    //   0: lconst_0
    //   1: lstore_3
    //   2: ldc 82
    //   4: astore 9
    //   6: ldc 82
    //   8: astore 10
    //   10: aconst_null
    //   11: astore 11
    //   13: iconst_2
    //   14: istore_2
    //   15: aload 9
    //   17: astore 8
    //   19: aload 10
    //   21: astore 7
    //   23: aload_0
    //   24: ldc 184
    //   26: invokevirtual 88	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 190	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   32: lstore 5
    //   34: lload 5
    //   36: lstore_3
    //   37: aload 9
    //   39: astore 8
    //   41: aload 10
    //   43: astore 7
    //   45: aload_0
    //   46: ldc 192
    //   48: invokevirtual 88	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 9
    //   53: lload 5
    //   55: lstore_3
    //   56: aload 9
    //   58: astore 8
    //   60: aload 10
    //   62: astore 7
    //   64: aload_0
    //   65: ldc 194
    //   67: invokevirtual 88	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 12
    //   72: lload 5
    //   74: lstore_3
    //   75: aload 9
    //   77: astore 8
    //   79: aload 10
    //   81: astore 7
    //   83: aload_0
    //   84: ldc 196
    //   86: invokevirtual 88	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 10
    //   91: lload 5
    //   93: lstore_3
    //   94: aload 9
    //   96: astore 8
    //   98: aload 10
    //   100: astore 7
    //   102: aload_0
    //   103: ldc 198
    //   105: invokevirtual 88	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore 13
    //   110: iload_2
    //   111: istore_1
    //   112: aload 13
    //   114: ifnull +22 -> 136
    //   117: iload_2
    //   118: istore_1
    //   119: aload 13
    //   121: invokevirtual 98	java/lang/String:length	()I
    //   124: ifle +12 -> 136
    //   127: aload 13
    //   129: invokestatic 204	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   132: invokevirtual 207	java/lang/Integer:intValue	()I
    //   135: istore_1
    //   136: aload 12
    //   138: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifne +89 -> 230
    //   144: new 209	java/util/ArrayList
    //   147: dup
    //   148: invokespecial 210	java/util/ArrayList:<init>	()V
    //   151: astore 7
    //   153: aload 7
    //   155: aload 12
    //   157: invokevirtual 213	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   160: pop
    //   161: new 215	com/tencent/intervideo/nowproxy/ListNameData
    //   164: dup
    //   165: aload 7
    //   167: iconst_0
    //   168: invokespecial 218	com/tencent/intervideo/nowproxy/ListNameData:<init>	(Ljava/util/ArrayList;I)V
    //   171: astore 7
    //   173: aload 9
    //   175: astore 8
    //   177: lload 5
    //   179: lstore_3
    //   180: aload 7
    //   182: astore 11
    //   184: aload 11
    //   186: lload_3
    //   187: aload 8
    //   189: aload 10
    //   191: iload_1
    //   192: aload_0
    //   193: invokevirtual 146	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   196: invokestatic 222	com/tencent/intervideo/nowproxy/NowLive:openRoom	(Lcom/tencent/intervideo/nowproxy/ListNameData;JLjava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Z
    //   199: ireturn
    //   200: astore 7
    //   202: iconst_2
    //   203: istore_1
    //   204: goto -68 -> 136
    //   207: astore 9
    //   209: iconst_2
    //   210: istore_1
    //   211: aload 7
    //   213: astore 10
    //   215: goto -31 -> 184
    //   218: astore 7
    //   220: lload 5
    //   222: lstore_3
    //   223: aload 9
    //   225: astore 8
    //   227: goto -43 -> 184
    //   230: aconst_null
    //   231: astore 7
    //   233: goto -60 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramIntent	Intent
    //   111	100	1	i	int
    //   14	104	2	j	int
    //   1	222	3	l1	long
    //   32	189	5	l2	long
    //   21	160	7	localObject1	Object
    //   200	12	7	localException1	Exception
    //   218	1	7	localException2	Exception
    //   231	1	7	localObject2	Object
    //   17	209	8	localObject3	Object
    //   4	170	9	str1	String
    //   207	17	9	localException3	Exception
    //   8	206	10	localObject4	Object
    //   11	174	11	localObject5	Object
    //   70	86	12	str2	String
    //   108	20	13	str3	String
    // Exception table:
    //   from	to	target	type
    //   119	136	200	java/lang/Exception
    //   23	34	207	java/lang/Exception
    //   45	53	207	java/lang/Exception
    //   64	72	207	java/lang/Exception
    //   83	91	207	java/lang/Exception
    //   102	110	207	java/lang/Exception
    //   136	173	218	java/lang/Exception
  }
  
  public static Intent parseSchemeUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        Object localObject = URLDecoder.decode(paramString, "UTF-8");
        Intent localIntent = new Intent();
        localIntent.putExtra("original_scheme", paramString);
        localIntent.putExtra("decoded_scheme", (String)localObject);
        paramString = ((String)localObject).split("&");
        if ((paramString == null) || (paramString.length == 0)) {
          continue;
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
      catch (Exception paramString)
      {
        DefaultLog.e(TAG, "parseScheme decode exception");
        paramString.printStackTrace();
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.util.NowSchemeUtil
 * JD-Core Version:    0.7.0.1
 */