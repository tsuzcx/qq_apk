package com.sina.weibo.sdk.web.b;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.WebData;

public final class d
  extends b
{
  public WeiboMultiMessage aK;
  private byte[] aL;
  String aM;
  public String ak;
  public String packageName;
  private String text;
  
  public d(Context paramContext)
  {
    this.af = paramContext;
  }
  
  public d(AuthInfo paramAuthInfo)
  {
    super(paramAuthInfo, 1, null, null);
  }
  
  protected final void a(Bundle paramBundle)
  {
    if (this.aK != null) {
      this.aK.writeToBundle(paramBundle);
    }
    paramBundle.putString("token", this.ak);
    paramBundle.putString("packageName", this.packageName);
  }
  
  public final void a(b.a parama)
  {
    AuthInfo localAuthInfo = this.aI.a();
    parama = new com.sina.weibo.sdk.b.e(this.af, new String(this.aL), localAuthInfo.getAppKey(), this.ak, new d.1(this, parama));
    com.sina.weibo.sdk.b.b.a.n().a(parama);
  }
  
  /* Error */
  protected final void b(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 33	com/sina/weibo/sdk/api/WeiboMultiMessage
    //   4: dup
    //   5: invokespecial 100	com/sina/weibo/sdk/api/WeiboMultiMessage:<init>	()V
    //   8: putfield 31	com/sina/weibo/sdk/web/b/d:aK	Lcom/sina/weibo/sdk/api/WeiboMultiMessage;
    //   11: aload_0
    //   12: getfield 31	com/sina/weibo/sdk/web/b/d:aK	Lcom/sina/weibo/sdk/api/WeiboMultiMessage;
    //   15: aload_1
    //   16: invokevirtual 103	com/sina/weibo/sdk/api/WeiboMultiMessage:readFromBundle	(Landroid/os/Bundle;)V
    //   19: aload_0
    //   20: aload_1
    //   21: ldc 39
    //   23: invokevirtual 107	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: putfield 41	com/sina/weibo/sdk/web/b/d:ak	Ljava/lang/String;
    //   29: aload_0
    //   30: aload_1
    //   31: ldc 48
    //   33: invokevirtual 107	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: putfield 50	com/sina/weibo/sdk/web/b/d:packageName	Ljava/lang/String;
    //   39: new 109	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   46: astore 4
    //   48: aload_0
    //   49: getfield 31	com/sina/weibo/sdk/web/b/d:aK	Lcom/sina/weibo/sdk/api/WeiboMultiMessage;
    //   52: getfield 114	com/sina/weibo/sdk/api/WeiboMultiMessage:textObject	Lcom/sina/weibo/sdk/api/TextObject;
    //   55: ifnull +19 -> 74
    //   58: aload 4
    //   60: aload_0
    //   61: getfield 31	com/sina/weibo/sdk/web/b/d:aK	Lcom/sina/weibo/sdk/api/WeiboMultiMessage;
    //   64: getfield 114	com/sina/weibo/sdk/api/WeiboMultiMessage:textObject	Lcom/sina/weibo/sdk/api/TextObject;
    //   67: getfield 118	com/sina/weibo/sdk/api/TextObject:text	Ljava/lang/String;
    //   70: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_0
    //   75: getfield 31	com/sina/weibo/sdk/web/b/d:aK	Lcom/sina/weibo/sdk/api/WeiboMultiMessage;
    //   78: getfield 126	com/sina/weibo/sdk/api/WeiboMultiMessage:imageObject	Lcom/sina/weibo/sdk/api/ImageObject;
    //   81: ifnull +96 -> 177
    //   84: aload_0
    //   85: getfield 31	com/sina/weibo/sdk/web/b/d:aK	Lcom/sina/weibo/sdk/api/WeiboMultiMessage;
    //   88: getfield 126	com/sina/weibo/sdk/api/WeiboMultiMessage:imageObject	Lcom/sina/weibo/sdk/api/ImageObject;
    //   91: astore 5
    //   93: aload 5
    //   95: getfield 131	com/sina/weibo/sdk/api/ImageObject:imagePath	Ljava/lang/String;
    //   98: astore_1
    //   99: aload_1
    //   100: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +109 -> 212
    //   106: new 139	java/io/File
    //   109: dup
    //   110: aload_1
    //   111: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 146	java/io/File:exists	()Z
    //   119: ifeq +93 -> 212
    //   122: aload_1
    //   123: invokevirtual 149	java/io/File:canRead	()Z
    //   126: ifeq +86 -> 212
    //   129: aload_1
    //   130: invokevirtual 153	java/io/File:length	()J
    //   133: lconst_0
    //   134: lcmp
    //   135: ifle +77 -> 212
    //   138: aload_1
    //   139: invokevirtual 153	java/io/File:length	()J
    //   142: l2i
    //   143: newarray byte
    //   145: astore_3
    //   146: new 155	java/io/FileInputStream
    //   149: dup
    //   150: aload_1
    //   151: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   154: astore_2
    //   155: aload_2
    //   156: astore_1
    //   157: aload_2
    //   158: aload_3
    //   159: invokevirtual 162	java/io/FileInputStream:read	([B)I
    //   162: pop
    //   163: aload_2
    //   164: astore_1
    //   165: aload_0
    //   166: aload_3
    //   167: invokestatic 167	com/sina/weibo/sdk/c/e:b	([B)[B
    //   170: putfield 66	com/sina/weibo/sdk/web/b/d:aL	[B
    //   173: aload_2
    //   174: invokevirtual 170	java/io/FileInputStream:close	()V
    //   177: aload_0
    //   178: aload 4
    //   180: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: putfield 174	com/sina/weibo/sdk/web/b/d:text	Ljava/lang/String;
    //   186: return
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   192: goto -15 -> 177
    //   195: astore_3
    //   196: aconst_null
    //   197: astore_2
    //   198: aload_2
    //   199: astore_1
    //   200: aload_3
    //   201: invokevirtual 178	java/lang/Exception:printStackTrace	()V
    //   204: aload_2
    //   205: ifnull +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 170	java/io/FileInputStream:close	()V
    //   212: aload 5
    //   214: getfield 181	com/sina/weibo/sdk/api/ImageObject:imageData	[B
    //   217: astore_1
    //   218: aload_1
    //   219: ifnull -42 -> 177
    //   222: aload_1
    //   223: arraylength
    //   224: ifle -47 -> 177
    //   227: aload_0
    //   228: aload_1
    //   229: invokestatic 167	com/sina/weibo/sdk/c/e:b	([B)[B
    //   232: putfield 66	com/sina/weibo/sdk/web/b/d:aL	[B
    //   235: goto -58 -> 177
    //   238: astore_1
    //   239: aload_1
    //   240: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   243: goto -31 -> 212
    //   246: astore_2
    //   247: aconst_null
    //   248: astore_1
    //   249: aload_1
    //   250: ifnull +7 -> 257
    //   253: aload_1
    //   254: invokevirtual 170	java/io/FileInputStream:close	()V
    //   257: aload_2
    //   258: athrow
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   264: goto -7 -> 257
    //   267: astore_2
    //   268: goto -19 -> 249
    //   271: astore_3
    //   272: goto -74 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	d
    //   0	275	1	paramBundle	Bundle
    //   154	55	2	localFileInputStream	java.io.FileInputStream
    //   246	12	2	localObject1	java.lang.Object
    //   267	1	2	localObject2	java.lang.Object
    //   145	22	3	arrayOfByte	byte[]
    //   195	6	3	localException1	java.lang.Exception
    //   271	1	3	localException2	java.lang.Exception
    //   46	133	4	localStringBuilder	java.lang.StringBuilder
    //   91	122	5	localImageObject	com.sina.weibo.sdk.api.ImageObject
    // Exception table:
    //   from	to	target	type
    //   173	177	187	java/io/IOException
    //   146	155	195	java/lang/Exception
    //   208	212	238	java/io/IOException
    //   146	155	246	finally
    //   253	257	259	java/io/IOException
    //   157	163	267	finally
    //   165	173	267	finally
    //   200	204	267	finally
    //   157	163	271	java/lang/Exception
    //   165	173	271	java/lang/Exception
  }
  
  public final String getUrl()
  {
    Uri.Builder localBuilder = Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
    localBuilder.appendQueryParameter("title", this.text);
    localBuilder.appendQueryParameter("version", "0041005000");
    String str1 = this.aI.a().getAppKey();
    if (!TextUtils.isEmpty(str1)) {
      localBuilder.appendQueryParameter("source", str1);
    }
    if (!TextUtils.isEmpty(this.ak)) {
      localBuilder.appendQueryParameter("access_token", this.ak);
    }
    String str2 = com.sina.weibo.sdk.c.e.f(this.af, str1);
    if (!TextUtils.isEmpty(str2)) {
      localBuilder.appendQueryParameter("aid", str2);
    }
    if (!TextUtils.isEmpty(this.packageName)) {
      localBuilder.appendQueryParameter("packagename", this.packageName);
    }
    if (!TextUtils.isEmpty(this.aM)) {
      localBuilder.appendQueryParameter("picinfo", this.aM);
    }
    localBuilder.appendQueryParameter("luicode", "10000360");
    localBuilder.appendQueryParameter("lfid", "OP_" + str1);
    return localBuilder.build().toString();
  }
  
  public final boolean w()
  {
    if ((this.aL != null) && (this.aL.length > 0)) {
      return true;
    }
    return super.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.web.b.d
 * JD-Core Version:    0.7.0.1
 */