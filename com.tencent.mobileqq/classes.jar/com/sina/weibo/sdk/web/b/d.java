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
    WeiboMultiMessage localWeiboMultiMessage = this.aK;
    if (localWeiboMultiMessage != null) {
      localWeiboMultiMessage.writeToBundle(paramBundle);
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
    //   81: ifnull +197 -> 278
    //   84: aload_0
    //   85: getfield 31	com/sina/weibo/sdk/web/b/d:aK	Lcom/sina/weibo/sdk/api/WeiboMultiMessage;
    //   88: getfield 126	com/sina/weibo/sdk/api/WeiboMultiMessage:imageObject	Lcom/sina/weibo/sdk/api/ImageObject;
    //   91: astore 5
    //   93: aload 5
    //   95: getfield 131	com/sina/weibo/sdk/api/ImageObject:imagePath	Ljava/lang/String;
    //   98: astore_1
    //   99: aload_1
    //   100: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +152 -> 255
    //   106: new 139	java/io/File
    //   109: dup
    //   110: aload_1
    //   111: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore_2
    //   115: aload_2
    //   116: invokevirtual 146	java/io/File:exists	()Z
    //   119: ifeq +136 -> 255
    //   122: aload_2
    //   123: invokevirtual 149	java/io/File:canRead	()Z
    //   126: ifeq +129 -> 255
    //   129: aload_2
    //   130: invokevirtual 153	java/io/File:length	()J
    //   133: lconst_0
    //   134: lcmp
    //   135: ifle +120 -> 255
    //   138: aload_2
    //   139: invokevirtual 153	java/io/File:length	()J
    //   142: l2i
    //   143: newarray byte
    //   145: astore 6
    //   147: aconst_null
    //   148: astore_3
    //   149: aconst_null
    //   150: astore_1
    //   151: new 155	java/io/FileInputStream
    //   154: dup
    //   155: aload_2
    //   156: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   159: astore_2
    //   160: aload_2
    //   161: aload 6
    //   163: invokevirtual 162	java/io/FileInputStream:read	([B)I
    //   166: pop
    //   167: aload_0
    //   168: aload 6
    //   170: invokestatic 167	com/sina/weibo/sdk/c/e:b	([B)[B
    //   173: putfield 66	com/sina/weibo/sdk/web/b/d:aL	[B
    //   176: aload_2
    //   177: invokevirtual 170	java/io/FileInputStream:close	()V
    //   180: goto +98 -> 278
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   188: goto +90 -> 278
    //   191: astore_3
    //   192: aload_2
    //   193: astore_1
    //   194: aload_3
    //   195: astore_2
    //   196: goto +41 -> 237
    //   199: astore_3
    //   200: goto +12 -> 212
    //   203: astore_2
    //   204: goto +33 -> 237
    //   207: astore_1
    //   208: aload_3
    //   209: astore_2
    //   210: aload_1
    //   211: astore_3
    //   212: aload_2
    //   213: astore_1
    //   214: aload_3
    //   215: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   218: aload_2
    //   219: ifnull +36 -> 255
    //   222: aload_2
    //   223: invokevirtual 170	java/io/FileInputStream:close	()V
    //   226: goto +29 -> 255
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   234: goto +21 -> 255
    //   237: aload_1
    //   238: ifnull +15 -> 253
    //   241: aload_1
    //   242: invokevirtual 170	java/io/FileInputStream:close	()V
    //   245: goto +8 -> 253
    //   248: astore_1
    //   249: aload_1
    //   250: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   253: aload_2
    //   254: athrow
    //   255: aload 5
    //   257: getfield 177	com/sina/weibo/sdk/api/ImageObject:imageData	[B
    //   260: astore_1
    //   261: aload_1
    //   262: ifnull +16 -> 278
    //   265: aload_1
    //   266: arraylength
    //   267: ifle +11 -> 278
    //   270: aload_0
    //   271: aload_1
    //   272: invokestatic 167	com/sina/weibo/sdk/c/e:b	([B)[B
    //   275: putfield 66	com/sina/weibo/sdk/web/b/d:aL	[B
    //   278: aload_0
    //   279: aload 4
    //   281: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: putfield 181	com/sina/weibo/sdk/web/b/d:text	Ljava/lang/String;
    //   287: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	d
    //   0	288	1	paramBundle	Bundle
    //   114	82	2	localObject1	Object
    //   203	1	2	localObject2	Object
    //   209	45	2	localObject3	Object
    //   148	1	3	localObject4	Object
    //   191	4	3	localObject5	Object
    //   199	10	3	localException	java.lang.Exception
    //   211	4	3	localBundle	Bundle
    //   46	234	4	localStringBuilder	StringBuilder
    //   91	165	5	localImageObject	com.sina.weibo.sdk.api.ImageObject
    //   145	24	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   176	180	183	java/io/IOException
    //   160	176	191	finally
    //   160	176	199	java/lang/Exception
    //   151	160	203	finally
    //   214	218	203	finally
    //   151	160	207	java/lang/Exception
    //   222	226	229	java/io/IOException
    //   241	245	248	java/io/IOException
  }
  
  public final String getUrl()
  {
    Uri.Builder localBuilder = Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
    localBuilder.appendQueryParameter("title", this.text);
    localBuilder.appendQueryParameter("version", "0041005000");
    String str = this.aI.a().getAppKey();
    if (!TextUtils.isEmpty(str)) {
      localBuilder.appendQueryParameter("source", str);
    }
    if (!TextUtils.isEmpty(this.ak)) {
      localBuilder.appendQueryParameter("access_token", this.ak);
    }
    Object localObject = com.sina.weibo.sdk.c.e.f(this.af, str);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localBuilder.appendQueryParameter("aid", (String)localObject);
    }
    if (!TextUtils.isEmpty(this.packageName)) {
      localBuilder.appendQueryParameter("packagename", this.packageName);
    }
    if (!TextUtils.isEmpty(this.aM)) {
      localBuilder.appendQueryParameter("picinfo", this.aM);
    }
    localBuilder.appendQueryParameter("luicode", "10000360");
    localObject = new StringBuilder("OP_");
    ((StringBuilder)localObject).append(str);
    localBuilder.appendQueryParameter("lfid", ((StringBuilder)localObject).toString());
    return localBuilder.build().toString();
  }
  
  public final boolean w()
  {
    byte[] arrayOfByte = this.aL;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      return true;
    }
    return super.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.web.b.d
 * JD-Core Version:    0.7.0.1
 */