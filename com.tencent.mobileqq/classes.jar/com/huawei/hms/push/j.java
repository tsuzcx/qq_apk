package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.List;

public class j
{
  public static final String[] a = { "url", "app", "cosa", "rp" };
  public Context b;
  public k c;
  
  public j(Context paramContext, k paramk)
  {
    this.b = paramContext;
    this.c = paramk;
  }
  
  public static boolean b(String paramString)
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final String a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = paramString.indexOf('?');
        if (j == -1) {
          return paramString;
        }
        int k = j + 1;
        localObject2 = paramString.substring(k).split("&");
        Object localObject1 = new ArrayList();
        int m = localObject2.length;
        i = 0;
        if (i < m)
        {
          Object localObject3 = localObject2[i];
          boolean bool = localObject3.startsWith("h_w_hiapp_referrer");
          if ((!bool) && (!localObject3.startsWith("h_w_gp_referrer"))) {
            ((List)localObject1).add(localObject3);
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          m = ((List)localObject1).size();
          i = 0;
          if (i < m)
          {
            ((StringBuilder)localObject2).append((String)((List)localObject1).get(i));
            if (i >= ((List)localObject1).size() - 1) {
              break label312;
            }
            ((StringBuilder)localObject2).append("&");
            break label312;
          }
          if (((List)localObject1).size() == 0)
          {
            localObject1 = paramString.substring(0, j);
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString.substring(0, k));
            ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("after delete referrer, the new IntentUri is:");
          ((StringBuilder)localObject2).append((String)localObject1);
          HMSLog.d("PushSelfShowLog", ((StringBuilder)localObject2).toString());
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("delete referrer exception.");
        ((StringBuilder)localObject2).append(localException.toString());
        HMSLog.e("PushSelfShowLog", ((StringBuilder)localObject2).toString());
        return paramString;
      }
      i += 1;
      continue;
      label312:
      i += 1;
    }
  }
  
  public final void a()
  {
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("enter launchApp, appPackageName =");
      localStringBuilder1.append(this.c.d());
      localStringBuilder1.append(",and msg.intentUri is ");
      localStringBuilder1.append(this.c.n());
      HMSLog.i("PushSelfShowLog", localStringBuilder1.toString());
      if (q.c(this.b, this.c.d()))
      {
        b();
        return;
      }
      d();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("launchApp error:");
      localStringBuilder2.append(localException.toString());
      HMSLog.e("PushSelfShowLog", localStringBuilder2.toString());
    }
  }
  
  public final void b()
  {
    HMSLog.i("PushSelfShowLog", "run into launchCosaApp");
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("enter launchExistApp cosa, appPackageName =");
      ((StringBuilder)localObject1).append(this.c.d());
      ((StringBuilder)localObject1).append(",and msg.intentUri is ");
      ((StringBuilder)localObject1).append(this.c.n());
      HMSLog.i("PushSelfShowLog", ((StringBuilder)localObject1).toString());
      localObject3 = q.b(this.b, this.c.d());
      localObject1 = this.c.n();
      int i = 0;
      Object localObject4;
      Object localObject2;
      if (localObject1 != null)
      {
        try
        {
          localObject4 = Intent.parseUri(this.c.n(), 0);
          ((Intent)localObject4).setSelector(null);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Intent.parseUri(msg.intentUri, 0), action:");
          ((StringBuilder)localObject1).append(((Intent)localObject4).getAction());
          HMSLog.i("PushSelfShowLog", ((StringBuilder)localObject1).toString());
          boolean bool = q.a(this.b, this.c.d(), (Intent)localObject4).booleanValue();
          localObject1 = localObject3;
          i = bool;
          if (!bool) {
            break label295;
          }
          localObject1 = localObject4;
          i = bool;
        }
        catch (Exception localException1)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("intentUri error.");
          ((StringBuilder)localObject4).append(localException1.toString());
          HMSLog.w("PushSelfShowLog", ((StringBuilder)localObject4).toString());
          localObject2 = localObject3;
        }
      }
      else
      {
        localObject2 = localObject3;
        if (this.c.a() != null)
        {
          localObject4 = new Intent(this.c.a());
          localObject2 = localObject3;
          if (q.a(this.b, this.c.d(), (Intent)localObject4).booleanValue()) {
            localObject2 = localObject4;
          }
        }
        localObject2.setPackage(this.c.d());
      }
      label295:
      if (localObject2 == null)
      {
        HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
        return;
      }
      if (i != 0) {
        localObject2.addFlags(268435456);
      } else {
        localObject2.setFlags(805437440);
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("start ");
      ((StringBuilder)localObject3).append(localObject2.toURI());
      HMSLog.i("PushSelfShowLog", ((StringBuilder)localObject3).toString());
      this.b.startActivity(localObject2);
      return;
    }
    catch (Exception localException2)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("launch Cosa App exception.");
      ((StringBuilder)localObject3).append(localException2.toString());
      HMSLog.e("PushSelfShowLog", ((StringBuilder)localObject3).toString());
    }
  }
  
  public void c()
  {
    HMSLog.d("PushSelfShowLog", "enter launchNotify()");
    if (this.b != null)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        if ("app".equals(((k)localObject).i()))
        {
          a();
          return;
        }
        if ("cosa".equals(this.c.i()))
        {
          b();
          return;
        }
        if ("rp".equals(this.c.i()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.c.i());
          ((StringBuilder)localObject).append(" not support rich message.");
          HMSLog.w("PushSelfShowLog", ((StringBuilder)localObject).toString());
          return;
        }
        if ("url".equals(this.c.i()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.c.i());
          ((StringBuilder)localObject).append(" not support URL.");
          HMSLog.w("PushSelfShowLog", ((StringBuilder)localObject).toString());
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.c.i());
        ((StringBuilder)localObject).append(" is not exist in hShowType");
        HMSLog.d("PushSelfShowLog", ((StringBuilder)localObject).toString());
        return;
      }
    }
    HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
  }
  
  public final void d()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      boolean bool = TextUtils.isEmpty(this.c.n());
      if (!bool)
      {
        ((StringBuilder)localObject1).append("&referrer=");
        ((StringBuilder)localObject1).append(Uri.encode(a(this.c.n())));
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("market://details?id=");
      ((StringBuilder)localObject2).append(this.c.d());
      ((StringBuilder)localObject2).append(localObject1);
      String str = ((StringBuilder)localObject2).toString();
      localObject1 = new Intent("android.intent.action.VIEW");
      ((Intent)localObject1).setData(Uri.parse(str));
      ((Intent)localObject1).setPackage("com.huawei.appmarket");
      localObject2 = new Intent("android.intent.action.VIEW");
      ((Intent)localObject2).setData(Uri.parse(str));
      ((Intent)localObject2).setPackage("com.android.vending");
      if (q.a(this.b, "com.android.vending", (Intent)localObject2).booleanValue())
      {
        ((Intent)localObject2).setFlags(402653184);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("open google play store's app detail, IntentUrl is:");
        ((StringBuilder)localObject1).append(((Intent)localObject2).toURI());
        HMSLog.i("PushSelfShowLog", ((StringBuilder)localObject1).toString());
        this.b.startActivity((Intent)localObject2);
        return;
      }
      if (q.a(this.b, "com.huawei.appmarket", (Intent)localObject1).booleanValue())
      {
        ((Intent)localObject1).setFlags(402653184);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("open HiApp's app detail, IntentUrl is:");
        ((StringBuilder)localObject2).append(((Intent)localObject1).toURI());
        HMSLog.i("PushSelfShowLog", ((StringBuilder)localObject2).toString());
        this.b.startActivity((Intent)localObject1);
        return;
      }
      HMSLog.i("PushSelfShowLog", "open app detail by browser.");
      e();
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("open market app detail failed,exception:");
      ((StringBuilder)localObject2).append(localException);
      HMSLog.e("PushSelfShowLog", ((StringBuilder)localObject2).toString());
    }
  }
  
  /* Error */
  public final void e()
  {
    // Byte code:
    //   0: ldc_w 262
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 33	com/huawei/hms/push/j:c	Lcom/huawei/hms/push/k;
    //   8: invokevirtual 119	com/huawei/hms/push/k:n	()Ljava/lang/String;
    //   11: invokestatic 265	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokestatic 241	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   17: astore_2
    //   18: aload_2
    //   19: ldc 60
    //   21: invokevirtual 268	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_1
    //   25: goto +15 -> 40
    //   28: ldc 96
    //   30: ldc_w 270
    //   33: invokestatic 122	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: ldc_w 262
    //   39: astore_1
    //   40: aload_2
    //   41: ldc 65
    //   43: invokevirtual 268	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore_2
    //   47: goto +65 -> 112
    //   50: ldc 96
    //   52: ldc_w 270
    //   55: invokestatic 122	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_3
    //   59: astore_2
    //   60: goto +52 -> 112
    //   63: astore_2
    //   64: goto +8 -> 72
    //   67: astore_2
    //   68: ldc_w 262
    //   71: astore_1
    //   72: new 72	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   79: astore 4
    //   81: aload 4
    //   83: ldc_w 272
    //   86: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 4
    //   92: aload_2
    //   93: invokevirtual 105	java/lang/Exception:toString	()Ljava/lang/String;
    //   96: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: ldc 96
    //   102: aload 4
    //   104: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 169	com/huawei/hms/support/log/HMSLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_3
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_3
    //   114: invokestatic 277	com/huawei/hms/utils/Util:isEMUI	()Z
    //   117: ifeq +83 -> 200
    //   120: invokestatic 280	com/huawei/hms/utils/Util:isChinaROM	()Z
    //   123: ifne +6 -> 129
    //   126: goto +74 -> 200
    //   129: new 72	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   136: astore_2
    //   137: aload_2
    //   138: ldc_w 282
    //   141: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_2
    //   146: aload_1
    //   147: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: ldc 96
    //   153: aload_2
    //   154: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 122	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_1
    //   161: invokestatic 265	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   164: astore_1
    //   165: aload_1
    //   166: invokestatic 287	android/webkit/URLUtil:isValidUrl	(Ljava/lang/String;)Z
    //   169: ifeq +6 -> 175
    //   172: goto +117 -> 289
    //   175: aload_0
    //   176: getfield 31	com/huawei/hms/push/j:b	Landroid/content/Context;
    //   179: astore_2
    //   180: aload_3
    //   181: astore_1
    //   182: aload_2
    //   183: ifnull +106 -> 289
    //   186: aload_2
    //   187: invokestatic 293	com/huawei/hms/utils/ResourceLoaderUtil:setmContext	(Landroid/content/Context;)V
    //   190: ldc_w 295
    //   193: invokestatic 298	com/huawei/hms/utils/ResourceLoaderUtil:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore_1
    //   197: goto +92 -> 289
    //   200: new 72	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   207: astore_1
    //   208: aload_1
    //   209: ldc_w 300
    //   212: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_1
    //   217: aload_2
    //   218: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: ldc 96
    //   224: aload_1
    //   225: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 122	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_2
    //   232: invokestatic 265	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   235: astore_1
    //   236: aload_1
    //   237: invokestatic 287	android/webkit/URLUtil:isValidUrl	(Ljava/lang/String;)Z
    //   240: ifeq +6 -> 246
    //   243: goto +46 -> 289
    //   246: aload_0
    //   247: getfield 31	com/huawei/hms/push/j:b	Landroid/content/Context;
    //   250: invokestatic 293	com/huawei/hms/utils/ResourceLoaderUtil:setmContext	(Landroid/content/Context;)V
    //   253: new 72	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   260: astore_1
    //   261: aload_1
    //   262: ldc_w 302
    //   265: invokestatic 298	com/huawei/hms/utils/ResourceLoaderUtil:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   268: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_1
    //   273: aload_0
    //   274: getfield 33	com/huawei/hms/push/j:c	Lcom/huawei/hms/push/k;
    //   277: invokevirtual 114	com/huawei/hms/push/k:d	()Ljava/lang/String;
    //   280: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_1
    //   285: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: astore_1
    //   289: new 72	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   296: astore_2
    //   297: aload_2
    //   298: ldc_w 304
    //   301: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_2
    //   306: aload_1
    //   307: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: ldc 96
    //   313: aload_2
    //   314: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 122	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload_0
    //   321: getfield 31	com/huawei/hms/push/j:b	Landroid/content/Context;
    //   324: aload_1
    //   325: invokestatic 307	com/huawei/hms/push/q:e	(Landroid/content/Context;Ljava/lang/String;)V
    //   328: return
    //   329: astore_1
    //   330: goto -302 -> 28
    //   333: astore_2
    //   334: goto -284 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	j
    //   24	301	1	localObject1	Object
    //   329	1	1	localException1	Exception
    //   17	43	2	localObject2	Object
    //   63	1	2	localException2	Exception
    //   67	26	2	localException3	Exception
    //   111	203	2	localObject3	Object
    //   333	1	2	localException4	Exception
    //   3	178	3	str	String
    //   79	24	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   50	58	63	java/lang/Exception
    //   4	18	67	java/lang/Exception
    //   28	36	67	java/lang/Exception
    //   18	25	329	java/lang/Exception
    //   40	47	333	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.j
 * JD-Core Version:    0.7.0.1
 */