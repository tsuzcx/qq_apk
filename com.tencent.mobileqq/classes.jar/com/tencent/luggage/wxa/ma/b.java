package com.tencent.luggage.wxa.ma;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.wxa.mb.a;
import com.tencent.luggage.wxa.qt.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.g;

public class b
  extends RelativeLayout
  implements e, e.c
{
  private static f d;
  protected int a = 0;
  private Context b;
  private e c;
  private e.c e;
  private e.b f;
  private e.h g = e.h.c;
  private boolean h = false;
  private float i = -1.0F;
  private int j;
  private boolean k;
  private boolean l;
  private String m;
  private a n;
  private boolean o = true;
  
  public b(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    this.n = a.a();
  }
  
  private boolean a(d paramd)
  {
    if (af.c(paramd.a)) {
      return false;
    }
    if (paramd.a.indexOf("file://") == 0)
    {
      paramd.a = paramd.a.substring(7);
      return true;
    }
    return false;
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	com/tencent/luggage/wxa/ma/b:m	Ljava/lang/String;
    //   4: invokestatic 82	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   7: ifne +166 -> 173
    //   10: aload_0
    //   11: getfield 98	com/tencent/luggage/wxa/ma/b:m	Ljava/lang/String;
    //   14: ldc 100
    //   16: invokevirtual 103	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   19: ifeq +154 -> 173
    //   22: new 105	java/net/URL
    //   25: dup
    //   26: aload_0
    //   27: getfield 98	com/tencent/luggage/wxa/ma/b:m	Ljava/lang/String;
    //   30: invokespecial 108	java/net/URL:<init>	(Ljava/lang/String;)V
    //   33: invokevirtual 112	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   36: checkcast 114	java/net/HttpURLConnection
    //   39: astore_2
    //   40: aload_2
    //   41: astore_3
    //   42: aload_2
    //   43: invokevirtual 117	java/net/HttpURLConnection:connect	()V
    //   46: aload_2
    //   47: astore_3
    //   48: aload_2
    //   49: invokevirtual 121	java/net/HttpURLConnection:getResponseCode	()I
    //   52: istore_1
    //   53: aload_2
    //   54: astore_3
    //   55: ldc 123
    //   57: ldc 125
    //   59: iconst_1
    //   60: anewarray 127	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: iload_1
    //   66: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aastore
    //   70: invokestatic 138	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: iload_1
    //   74: sipush 400
    //   77: if_icmplt +31 -> 108
    //   80: aload_2
    //   81: astore_3
    //   82: aload_0
    //   83: getfield 140	com/tencent/luggage/wxa/ma/b:e	Lcom/tencent/luggage/wxa/ma/e$c;
    //   86: ifnull +22 -> 108
    //   89: aload_2
    //   90: astore_3
    //   91: aload_0
    //   92: getfield 140	com/tencent/luggage/wxa/ma/b:e	Lcom/tencent/luggage/wxa/ma/e$c;
    //   95: ldc 142
    //   97: ldc 142
    //   99: ldc 144
    //   101: iconst_m1
    //   102: iload_1
    //   103: invokeinterface 147 6 0
    //   108: aload_2
    //   109: ifnull +64 -> 173
    //   112: goto +45 -> 157
    //   115: astore 4
    //   117: goto +13 -> 130
    //   120: astore_2
    //   121: aconst_null
    //   122: astore_3
    //   123: goto +40 -> 163
    //   126: astore 4
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: astore_3
    //   132: ldc 123
    //   134: aload 4
    //   136: ldc 149
    //   138: iconst_1
    //   139: anewarray 127	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload 4
    //   146: invokevirtual 153	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   149: aastore
    //   150: invokestatic 156	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_2
    //   154: ifnull +19 -> 173
    //   157: aload_2
    //   158: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   161: return
    //   162: astore_2
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 159	java/net/HttpURLConnection:disconnect	()V
    //   171: aload_2
    //   172: athrow
    //   173: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	b
    //   52	51	1	i1	int
    //   39	70	2	localHttpURLConnection	java.net.HttpURLConnection
    //   120	1	2	localObject1	Object
    //   129	29	2	localObject2	Object
    //   162	10	2	localObject3	Object
    //   41	127	3	localObject4	Object
    //   115	1	4	localException1	java.lang.Exception
    //   126	19	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   42	46	115	java/lang/Exception
    //   48	53	115	java/lang/Exception
    //   55	73	115	java/lang/Exception
    //   82	89	115	java/lang/Exception
    //   91	108	115	java/lang/Exception
    //   22	40	120	finally
    //   22	40	126	java/lang/Exception
    //   42	46	162	finally
    //   48	53	162	finally
    //   55	73	162	finally
    //   82	89	162	finally
    //   91	108	162	finally
    //   132	153	162	finally
  }
  
  public static void setVideoViewFactory(f paramf)
  {
    d = paramf;
  }
  
  public void a()
  {
    o.d("MicroMsg.Video.AppBrandVideoWrapper", "%s preload video url %s", new Object[] { Integer.valueOf(hashCode()), this.m });
    if (!af.c(this.m)) {
      this.c.a();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    o.d("MicroMsg.Video.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    e.c localc = this.e;
    if (localc != null) {
      localc.a(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.Video.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    e.c localc = this.e;
    if (localc != null) {
      localc.a(paramString1, paramString2, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    o.c("MicroMsg.Video.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    e.c localc = this.e;
    if (localc != null) {
      localc.a(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.j = paramInt;
    this.k = paramBoolean;
    d locald = new d();
    locald.a = paramString;
    this.l = a(locald);
    this.m = locald.a;
    paramString = this.c;
    if (paramString == null)
    {
      this.c = d.a(this.b);
      this.c.setVideoSource(this.a);
      this.c.setIMMVideoViewCallback(this);
      paramInt = 1;
    }
    else
    {
      paramString.e();
      paramInt = 0;
    }
    setScaleType(this.g);
    a(this.i);
    setMute(this.h);
    if (paramInt != 0)
    {
      setVideoFooterView(this.f);
      paramString = new RelativeLayout.LayoutParams(-1, -1);
      addView(this.c.getView(), paramString);
    }
    this.c.a(this.k, this.m, this.j);
    com.tencent.luggage.wxa.rz.f.a.c(new b.1(this));
  }
  
  public boolean a(double paramDouble)
  {
    e locale = this.c;
    if (locale != null) {
      return locale.a(paramDouble);
    }
    return false;
  }
  
  public boolean a(double paramDouble, boolean paramBoolean)
  {
    e locale = this.c;
    if (locale != null) {
      return locale.a(paramDouble, paramBoolean);
    }
    return false;
  }
  
  public boolean a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return false;
    }
    this.i = paramFloat;
    e locale = this.c;
    if (locale != null) {
      return locale.a(this.i);
    }
    return false;
  }
  
  public void b(String paramString1, String paramString2)
  {
    o.d("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    e.c localc = this.e;
    if (localc != null) {
      localc.b(paramString1, paramString2);
    }
  }
  
  public boolean b()
  {
    e locale = this.c;
    if (locale != null) {
      return locale.b();
    }
    return false;
  }
  
  public void c(String paramString1, String paramString2)
  {
    o.d("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    if (this.o) {
      this.n.c();
    }
    e.c localc = this.e;
    if (localc != null) {
      localc.c(paramString1, paramString2);
    }
  }
  
  public boolean c()
  {
    e locale = this.c;
    if (locale != null) {
      return locale.c();
    }
    return false;
  }
  
  public void d()
  {
    e locale = this.c;
    if (locale != null)
    {
      locale.d();
      setKeepScreenOn(true);
      if (this.o) {
        this.n.a(null);
      }
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    o.d("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    if (this.o) {
      this.n.a(null);
    }
    e.c localc = this.e;
    if (localc != null) {
      localc.d(paramString1, paramString2);
    }
  }
  
  public void e()
  {
    e locale = this.c;
    if (locale != null)
    {
      locale.e();
      if (this.o) {
        this.n.c();
      }
      setKeepScreenOn(false);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    e.c localc = this.e;
    if (localc != null) {
      localc.e(paramString1, paramString2);
    }
  }
  
  public void f(String paramString1, String paramString2)
  {
    e.c localc = this.e;
    if (localc != null) {
      localc.f(paramString1, paramString2);
    }
  }
  
  public boolean f()
  {
    if (this.c != null)
    {
      setKeepScreenOn(false);
      if (this.o) {
        this.n.c();
      }
      return this.c.f();
    }
    return false;
  }
  
  public void g()
  {
    e locale = this.c;
    if (locale != null) {
      locale.g();
    }
  }
  
  public int getCacheTimeSec()
  {
    e locale = this.c;
    if (locale != null) {
      return locale.getCacheTimeSec();
    }
    return 0;
  }
  
  public int getCurrPosMs()
  {
    e locale = this.c;
    if (locale != null) {
      return locale.getCurrPosMs();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    e locale = this.c;
    if (locale != null) {
      return locale.getCurrPosSec();
    }
    return 0;
  }
  
  public int getPlayerType()
  {
    e locale = this.c;
    if (locale != null) {
      return locale.getPlayerType();
    }
    return 0;
  }
  
  public TextureView getTexture()
  {
    e locale = this.c;
    if ((locale != null) && ((locale.getView() instanceof com.tencent.luggage.wxa.mm.b))) {
      return ((com.tencent.luggage.wxa.mm.b)this.c.getView()).getVideoTexture();
    }
    return null;
  }
  
  public int getVideoDurationSec()
  {
    e locale = this.c;
    if (locale != null) {
      return locale.getVideoDurationSec();
    }
    return this.j;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void h()
  {
    e locale = this.c;
    if (locale != null) {
      locale.h();
    }
    if (this.o) {
      this.n.c();
    }
    setKeepScreenOn(false);
  }
  
  public void i()
  {
    e locale = this.c;
    if (locale != null) {
      locale.i();
    }
    if (this.o) {
      this.n.c();
    }
    setKeepScreenOn(false);
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    e locale = this.c;
    if (locale != null) {
      locale.setCover(paramBitmap);
    }
  }
  
  public void setFocusAudio(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setFullDirection(int paramInt)
  {
    e locale = this.c;
    if (locale != null) {
      locale.setFullDirection(paramInt);
    }
  }
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.e = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    e locale = this.c;
    if (locale != null) {
      locale.setIsShowBasicControls(paramBoolean);
    }
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    o.e("MicroMsg.Video.AppBrandVideoWrapper", "set keep screen on:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    super.setKeepScreenOn(paramBoolean);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.h = paramBoolean;
    e locale = this.c;
    if (locale != null) {
      locale.setMute(this.h);
    }
  }
  
  public void setScaleType(e.h paramh)
  {
    this.g = paramh;
    paramh = this.c;
    if (paramh != null) {
      paramh.setScaleType(this.g);
    }
  }
  
  public void setVideoFooterView(e.b paramb)
  {
    this.f = paramb;
    paramb = this.c;
    if (paramb != null) {
      paramb.setVideoFooterView(this.f);
    }
  }
  
  public void setVideoSource(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.b
 * JD-Core Version:    0.7.0.1
 */