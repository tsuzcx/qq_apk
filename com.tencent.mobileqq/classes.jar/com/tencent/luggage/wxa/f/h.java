package com.tencent.luggage.wxa.f;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.opengl.EGLContext;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.Set;

public class h
  extends FrameLayout
  implements p.a
{
  i a;
  private final h.b c;
  private boolean d;
  private Context e;
  private int f = -1;
  private int g = -1;
  private boolean h;
  private volatile byte[] i = null;
  private volatile boolean j = false;
  private boolean k = true;
  private boolean l = true;
  private o m;
  private p n;
  private final k o;
  
  public h(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super(paramContext, null, 0);
    if (isInEditMode())
    {
      this.c = null;
      this.o = null;
      return;
    }
    this.d = true;
    this.e = paramContext;
    this.m = new m(paramContext, this, paramSurfaceTexture, paramInt1, paramInt2);
    this.c = new h.b(this);
    this.a = a(paramContext, this.m, this.c);
    this.o = new h.2(this, paramContext);
  }
  
  public h(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
    {
      this.c = null;
      this.o = null;
      return;
    }
    this.d = true;
    this.e = paramContext;
    this.m = a(paramContext);
    this.c = new h.b(this);
    this.a = a(paramContext, this.m, this.c);
    this.o = new h.1(this, paramContext);
  }
  
  public h(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, 0, paramBoolean);
  }
  
  public h(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  private i a(Context paramContext, o paramo, h.b paramb)
  {
    if (e.a().c())
    {
      f.b("WMPF.CameraView", "createCameraViewImpl, sdk version = %d, create Camera1 (for previous experience)", Integer.valueOf(Build.VERSION.SDK_INT));
      return new b(paramb, paramo, paramContext);
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      f.b("WMPF.CameraView", "createCameraViewImpl, sdk version = %d, create Camera1", Integer.valueOf(Build.VERSION.SDK_INT));
      return new b(paramb, paramo, paramContext);
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      f.b("WMPF.CameraView", "createCameraViewImpl, sdk version = %d, create Camera2", Integer.valueOf(Build.VERSION.SDK_INT));
      return new c(paramb, paramo, paramContext);
    }
    f.b("WMPF.CameraView", "createCameraViewImpl, sdk version = %d, create Camera2Api23", Integer.valueOf(Build.VERSION.SDK_INT));
    return new d(paramb, paramo, paramContext);
  }
  
  @NonNull
  private o a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 14) {
      return new s(paramContext, this);
    }
    return new t(paramContext, this);
  }
  
  /* Error */
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 86	com/tencent/luggage/wxa/f/h:a	Lcom/tencent/luggage/wxa/f/i;
    //   4: astore 9
    //   6: aload 9
    //   8: ifnull +508 -> 516
    //   11: aload 9
    //   13: invokevirtual 166	com/tencent/luggage/wxa/f/i:y	()Z
    //   16: ifeq +500 -> 516
    //   19: new 168	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   26: astore 9
    //   28: aload 9
    //   30: ldc 172
    //   32: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 9
    //   38: iload_1
    //   39: invokevirtual 179	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: ldc 113
    //   45: aload 9
    //   47: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 186	com/tencent/luggage/wxa/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: getfield 188	com/tencent/luggage/wxa/f/h:h	Z
    //   57: ifeq +16 -> 73
    //   60: ldc 113
    //   62: ldc 190
    //   64: invokestatic 186	com/tencent/luggage/wxa/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 188	com/tencent/luggage/wxa/f/h:h	Z
    //   72: return
    //   73: aload_0
    //   74: getfield 86	com/tencent/luggage/wxa/f/h:a	Lcom/tencent/luggage/wxa/f/i;
    //   77: invokevirtual 193	com/tencent/luggage/wxa/f/i:B	()Z
    //   80: ifeq +422 -> 502
    //   83: aload_0
    //   84: iconst_1
    //   85: putfield 188	com/tencent/luggage/wxa/f/h:h	Z
    //   88: aload_0
    //   89: getfield 86	com/tencent/luggage/wxa/f/h:a	Lcom/tencent/luggage/wxa/f/i;
    //   92: invokevirtual 197	com/tencent/luggage/wxa/f/i:z	()F
    //   95: fstore 5
    //   97: aload_0
    //   98: getfield 86	com/tencent/luggage/wxa/f/h:a	Lcom/tencent/luggage/wxa/f/i;
    //   101: invokevirtual 199	com/tencent/luggage/wxa/f/i:m	()F
    //   104: fload 5
    //   106: fmul
    //   107: fstore 4
    //   109: iload_2
    //   110: ifne +44 -> 154
    //   113: aload_0
    //   114: getfield 48	com/tencent/luggage/wxa/f/h:f	I
    //   117: ifgt +28 -> 145
    //   120: aload_0
    //   121: fload 5
    //   123: ldc 200
    //   125: fdiv
    //   126: invokestatic 206	java/lang/Math:round	(F)I
    //   129: putfield 48	com/tencent/luggage/wxa/f/h:f	I
    //   132: aload_0
    //   133: getfield 48	com/tencent/luggage/wxa/f/h:f	I
    //   136: iconst_5
    //   137: if_icmple +8 -> 145
    //   140: aload_0
    //   141: iconst_5
    //   142: putfield 48	com/tencent/luggage/wxa/f/h:f	I
    //   145: aload_0
    //   146: getfield 48	com/tencent/luggage/wxa/f/h:f	I
    //   149: istore 7
    //   151: goto +59 -> 210
    //   154: aload_0
    //   155: getfield 50	com/tencent/luggage/wxa/f/h:g	I
    //   158: ifgt +46 -> 204
    //   161: new 168	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   168: astore 9
    //   170: aload 9
    //   172: ldc 208
    //   174: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 9
    //   180: aload_0
    //   181: getfield 50	com/tencent/luggage/wxa/f/h:g	I
    //   184: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: ldc 113
    //   190: aload 9
    //   192: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 213	com/tencent/luggage/wxa/f/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_0
    //   199: iconst_0
    //   200: putfield 188	com/tencent/luggage/wxa/f/h:h	Z
    //   203: return
    //   204: aload_0
    //   205: getfield 50	com/tencent/luggage/wxa/f/h:g	I
    //   208: istore 7
    //   210: new 168	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   217: astore 9
    //   219: aload 9
    //   221: ldc 215
    //   223: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 9
    //   229: fload 4
    //   231: invokevirtual 218	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 9
    //   237: ldc 220
    //   239: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 9
    //   245: fload 5
    //   247: invokevirtual 218	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 9
    //   253: ldc 222
    //   255: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 9
    //   261: aload_0
    //   262: getfield 48	com/tencent/luggage/wxa/f/h:f	I
    //   265: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 9
    //   271: ldc 224
    //   273: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 9
    //   279: aload_0
    //   280: getfield 50	com/tencent/luggage/wxa/f/h:g	I
    //   283: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 9
    //   289: ldc 226
    //   291: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 9
    //   297: iload_3
    //   298: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: ldc 113
    //   304: aload 9
    //   306: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 186	com/tencent/luggage/wxa/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: iload 7
    //   314: istore 8
    //   316: iload_3
    //   317: iconst_1
    //   318: if_icmplt +9 -> 327
    //   321: iload 7
    //   323: iload_3
    //   324: imul
    //   325: istore 8
    //   327: iload_1
    //   328: ifeq +44 -> 372
    //   331: fload 4
    //   333: fload 5
    //   335: fcmpl
    //   336: iflt +9 -> 345
    //   339: aload_0
    //   340: iconst_0
    //   341: putfield 188	com/tencent/luggage/wxa/f/h:h	Z
    //   344: return
    //   345: iload 8
    //   347: i2f
    //   348: fload 4
    //   350: fadd
    //   351: fstore 6
    //   353: fload 6
    //   355: fstore 4
    //   357: fload 6
    //   359: fload 5
    //   361: fcmpl
    //   362: iflt +45 -> 407
    //   365: fload 5
    //   367: fstore 4
    //   369: goto +38 -> 407
    //   372: fload 4
    //   374: fconst_0
    //   375: fcmpl
    //   376: ifne +9 -> 385
    //   379: aload_0
    //   380: iconst_0
    //   381: putfield 188	com/tencent/luggage/wxa/f/h:h	Z
    //   384: return
    //   385: fload 4
    //   387: iload 8
    //   389: i2f
    //   390: fsub
    //   391: fstore 6
    //   393: fload 6
    //   395: fstore 4
    //   397: fload 6
    //   399: fconst_0
    //   400: fcmpg
    //   401: ifgt +6 -> 407
    //   404: fconst_0
    //   405: fstore 4
    //   407: new 168	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   414: astore 9
    //   416: aload 9
    //   418: ldc 228
    //   420: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 9
    //   426: fload 4
    //   428: invokevirtual 218	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: ldc 113
    //   434: aload 9
    //   436: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 186	com/tencent/luggage/wxa/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload_0
    //   443: getfield 86	com/tencent/luggage/wxa/f/h:a	Lcom/tencent/luggage/wxa/f/i;
    //   446: fload 4
    //   448: fload 5
    //   450: fdiv
    //   451: invokevirtual 231	com/tencent/luggage/wxa/f/i:b	(F)V
    //   454: goto +48 -> 502
    //   457: astore 9
    //   459: goto +49 -> 508
    //   462: astore 9
    //   464: new 168	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   471: astore 10
    //   473: aload 10
    //   475: ldc 233
    //   477: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 10
    //   483: aload 9
    //   485: invokevirtual 236	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   488: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: ldc 113
    //   494: aload 10
    //   496: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 213	com/tencent/luggage/wxa/f/f:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: aload_0
    //   503: iconst_0
    //   504: putfield 188	com/tencent/luggage/wxa/f/h:h	Z
    //   507: return
    //   508: aload_0
    //   509: iconst_0
    //   510: putfield 188	com/tencent/luggage/wxa/f/h:h	Z
    //   513: aload 9
    //   515: athrow
    //   516: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	this	h
    //   0	517	1	paramBoolean1	boolean
    //   0	517	2	paramBoolean2	boolean
    //   0	517	3	paramInt	int
    //   107	340	4	f1	float
    //   95	354	5	f2	float
    //   351	47	6	f3	float
    //   149	176	7	i1	int
    //   314	74	8	i2	int
    //   4	431	9	localObject1	Object
    //   457	1	9	localObject2	Object
    //   462	52	9	localException	java.lang.Exception
    //   471	24	10	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	67	457	finally
    //   73	109	457	finally
    //   113	145	457	finally
    //   145	151	457	finally
    //   154	198	457	finally
    //   204	210	457	finally
    //   210	312	457	finally
    //   407	454	457	finally
    //   464	502	457	finally
    //   19	67	462	java/lang/Exception
    //   73	109	462	java/lang/Exception
    //   113	145	462	java/lang/Exception
    //   145	151	462	java/lang/Exception
    //   154	198	462	java/lang/Exception
    //   204	210	462	java/lang/Exception
    //   210	312	462	java/lang/Exception
    //   407	454	462	java/lang/Exception
  }
  
  private boolean j()
  {
    boolean bool = this.a.a();
    if (bool)
    {
      f.b("WMPF.CameraView", "start camera success");
    }
    else
    {
      f.b("WMPF.CameraView", "start camera fail, try Camera1");
      Parcelable localParcelable = onSaveInstanceState();
      o localo = this.m;
      if ((localo == null) || (localo.g() == null)) {
        this.m = a(getContext());
      }
      this.a = new b(this.c, this.m, getContext());
      onRestoreInstanceState(localParcelable);
      bool = this.a.a();
      if (bool)
      {
        f.b("WMPF.CameraView", "start camera with Camera1 success, set to use Camera1 in the future");
        e.a().b();
      }
      else
      {
        f.b("WMPF.CameraView", "start camera with Camera1 fail");
      }
    }
    l();
    return bool;
  }
  
  private boolean k()
  {
    ((l)this.m).a(new h.3(this));
    return true;
  }
  
  private void l()
  {
    if (this.n == null)
    {
      this.n = new p();
      this.n.a(this);
    }
    i locali = this.a;
    if (locali != null) {
      locali.L().setOnTouchListener(this.n);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    i locali = this.a;
    if ((locali != null) && (locali.y()) && (this.l)) {
      this.a.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    p localp = this.n;
    if (localp != null) {
      localp.onTouch(this, paramMotionEvent);
    }
  }
  
  public void a(@NonNull h.a parama)
  {
    this.c.a(parama);
  }
  
  public boolean a()
  {
    f.b("WMPF.CameraView", "start camera begin");
    if ((this.m instanceof l)) {
      return k();
    }
    return j();
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, CamcorderProfile paramCamcorderProfile, boolean paramBoolean2)
  {
    return this.a.a(paramString, paramInt1, paramInt2, paramBoolean1, paramCamcorderProfile, paramBoolean2);
  }
  
  public void b()
  {
    Object localObject = this.m;
    if ((localObject instanceof l))
    {
      localObject = (l)localObject;
      ((l)localObject).a();
      ((l)localObject).d();
    }
    this.a.b();
    this.i = null;
  }
  
  public boolean c()
  {
    return this.a.d();
  }
  
  public void d()
  {
    this.a.p();
  }
  
  public void e()
  {
    this.a.r();
  }
  
  public void f() {}
  
  public void g()
  {
    i locali = this.a;
    if ((locali != null) && (locali.y()) && (this.k)) {
      a(true, false, 1);
    }
  }
  
  public boolean getAdjustViewBounds()
  {
    return this.d;
  }
  
  @Nullable
  public a getAspectRatio()
  {
    return this.a.i();
  }
  
  public boolean getAutoFocus()
  {
    return this.a.j();
  }
  
  public int getCameraId()
  {
    return this.a.f();
  }
  
  public int getCameraOrientation()
  {
    return this.a.u();
  }
  
  public byte[] getCurrentFrameData()
  {
    if (this.i != null)
    {
      this.j = true;
      byte[] arrayOfByte = new byte[this.i.length];
      System.arraycopy(this.i, 0, arrayOfByte, 0, this.i.length);
      this.j = false;
      return arrayOfByte;
    }
    return null;
  }
  
  public float getDisplayRatio()
  {
    return this.a.t();
  }
  
  public EGLContext getEglContext()
  {
    o localo = this.m;
    if ((localo instanceof l)) {
      return ((l)localo).c();
    }
    return null;
  }
  
  public int getFacing()
  {
    return this.a.e();
  }
  
  public int getFlash()
  {
    return this.a.k();
  }
  
  public float getFocusDepth()
  {
    return this.a.l();
  }
  
  public q getPictureSize()
  {
    return this.a.h();
  }
  
  public q getPreviewSize()
  {
    return this.a.v();
  }
  
  public int getPreviewSizeLimit()
  {
    return this.a.s();
  }
  
  public boolean getScanning()
  {
    return this.a.o();
  }
  
  public float[] getSupportZoomRatios()
  {
    i locali = this.a;
    if (locali == null) {
      return new float[0];
    }
    return locali.A();
  }
  
  public Set<a> getSupportedAspectRatios()
  {
    return this.a.g();
  }
  
  public Point getVideoSize()
  {
    return this.a.D();
  }
  
  public View getView()
  {
    i locali = this.a;
    if (locali != null) {
      return locali.L();
    }
    return null;
  }
  
  public int getWhiteBalance()
  {
    return this.a.n();
  }
  
  public float getZoom()
  {
    return this.a.m();
  }
  
  public void h()
  {
    i locali = this.a;
    if ((locali != null) && (locali.y()) && (this.k)) {
      a(false, false, 1);
    }
  }
  
  public void i()
  {
    this.a.C();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      this.o.a(ViewCompat.getDisplay(this));
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (!isInEditMode()) {
      this.o.a();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (isInEditMode())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    if (this.d)
    {
      if (!c())
      {
        this.c.d();
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      int i3 = View.MeasureSpec.getMode(paramInt1);
      int i4 = View.MeasureSpec.getMode(paramInt2);
      int i2;
      int i1;
      if ((i3 == 1073741824) && (i4 != 1073741824))
      {
        localObject = getAspectRatio();
        if ((!b) && (localObject == null)) {
          throw new AssertionError();
        }
        i2 = (int)(View.MeasureSpec.getSize(paramInt1) * ((a)localObject).c());
        i1 = i2;
        if (i4 == -2147483648) {
          i1 = Math.min(i2, View.MeasureSpec.getSize(paramInt2));
        }
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i1, 1073741824));
      }
      else if ((i3 != 1073741824) && (i4 == 1073741824))
      {
        localObject = getAspectRatio();
        if ((!b) && (localObject == null)) {
          throw new AssertionError();
        }
        i2 = (int)(View.MeasureSpec.getSize(paramInt2) * ((a)localObject).c());
        i1 = i2;
        if (i3 == -2147483648) {
          i1 = Math.min(i2, View.MeasureSpec.getSize(paramInt1));
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), paramInt2);
      }
      else
      {
        super.onMeasure(paramInt1, paramInt2);
      }
    }
    else
    {
      super.onMeasure(paramInt1, paramInt2);
    }
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    a locala = getAspectRatio();
    Object localObject = locala;
    if (this.o.b() % 180 == 0) {
      localObject = locala.d();
    }
    if ((!b) && (localObject == null)) {
      throw new AssertionError();
    }
    if (paramInt2 < ((a)localObject).b() * paramInt1 / ((a)localObject).a())
    {
      this.a.L().measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1 * ((a)localObject).b() / ((a)localObject).a(), 1073741824));
      return;
    }
    this.a.L().measure(View.MeasureSpec.makeMeasureSpec(((a)localObject).a() * paramInt2 / ((a)localObject).b(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof h.c))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (h.c)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setFacing(paramParcelable.a);
    setAspectRatio(paramParcelable.b);
    setAutoFocus(paramParcelable.c);
    setFlash(paramParcelable.d);
    setFocusDepth(paramParcelable.e);
    setZoom(paramParcelable.f);
    setWhiteBalance(paramParcelable.g);
    setScanning(paramParcelable.h);
    setPictureSize(paramParcelable.i);
    setPreviewSizeLimit(paramParcelable.j);
    setDisplayRatio(paramParcelable.k);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    h.c localc = new h.c(super.onSaveInstanceState());
    localc.a = getFacing();
    localc.b = getAspectRatio();
    localc.c = getAutoFocus();
    localc.d = getFlash();
    localc.e = getFocusDepth();
    localc.f = getZoom();
    localc.g = getWhiteBalance();
    localc.h = getScanning();
    localc.i = getPictureSize();
    localc.j = getPreviewSizeLimit();
    localc.k = getDisplayRatio();
    return localc;
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (this.d != paramBoolean)
    {
      this.d = paramBoolean;
      requestLayout();
    }
  }
  
  public void setAspectRatio(@NonNull a parama)
  {
    if (this.a.a(parama)) {
      requestLayout();
    }
  }
  
  public void setAutoFocus(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void setClipVideoSize(boolean paramBoolean)
  {
    this.a.c(paramBoolean);
  }
  
  public void setDisplayRatio(float paramFloat)
  {
    int i1 = com.tencent.luggage.wxa.g.b.b(this.e);
    f.a("WMPF.CameraView", "setDisplayRatio: %s, screenRotation: %s", Float.valueOf(paramFloat), Integer.valueOf(i1));
    float f1;
    if (i1 != 90)
    {
      f1 = paramFloat;
      if (i1 != 270) {}
    }
    else
    {
      f1 = 1.0F / paramFloat;
    }
    this.a.c(f1);
  }
  
  public void setEnableDragZoom(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setEnableTouchFocus(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setFacing(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void setFlash(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  public void setFocusDepth(float paramFloat)
  {
    this.a.a(paramFloat);
  }
  
  public void setForceZoomTargetRatio(float paramFloat)
  {
    i locali = this.a;
    if (locali == null) {
      return;
    }
    locali.a(Float.valueOf(paramFloat));
  }
  
  public void setPictureSize(@NonNull q paramq)
  {
    this.a.a(paramq);
  }
  
  public void setPreviewSizeLimit(int paramInt)
  {
    this.a.e(paramInt);
  }
  
  public void setPreviewTexture(SurfaceTexture paramSurfaceTexture)
  {
    this.a.a(paramSurfaceTexture);
  }
  
  public void setScanning(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
  
  public void setUsingCamera2Api(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    boolean bool = c();
    Parcelable localParcelable = onSaveInstanceState();
    if (paramBoolean)
    {
      if (bool) {
        b();
      }
      if (Build.VERSION.SDK_INT < 23) {
        this.a = new c(this.c, this.a.g, this.e);
      } else {
        this.a = new d(this.c, this.a.g, this.e);
      }
    }
    else
    {
      if ((this.a instanceof b)) {
        return;
      }
      if (bool) {
        b();
      }
      this.a = new b(this.c, this.a.g, this.e);
    }
    onRestoreInstanceState(localParcelable);
    if (bool) {
      a();
    }
  }
  
  public void setWhiteBalance(int paramInt)
  {
    this.a.c(paramInt);
  }
  
  public void setZoom(float paramFloat)
  {
    this.a.b(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.h
 * JD-Core Version:    0.7.0.1
 */