package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

public final class jr
  implements gh
{
  private static List<jw> Q = new CopyOnWriteArrayList();
  private static List<String> R = new CopyOnWriteArrayList();
  public static ConcurrentHashMap<String, Bitmap> e = new ConcurrentHashMap();
  public static ReentrantReadWriteLock f = new ReentrantReadWriteLock();
  public static final int[] h = { 1, 2, 5 };
  private ViewGroup A;
  private float[] B = { -1.0F, -1.0F, -1.0F, -1.0F };
  private int[] C = { -1, -1, -1, -1 };
  private int[] D = { -1, -1, -1, -1 };
  private int[] E = new int[gh.a.values().length];
  private int[] F = new int[gh.a.values().length];
  private float[] G = { 0.02F, 0.02F, 0.012F, 0.012F };
  private float[] H = { 0.022F, 0.022F, 0.0125F, 0.0125F };
  private float[] I = { 0.0185F, 0.0185F, 0.0104F, 0.0104F };
  private int J = 0;
  private int K = 0;
  private int L = 0;
  private int M = 0;
  private int N = 0;
  private int O = 0;
  private boolean P = false;
  private String S = null;
  private AtomicInteger T = new AtomicInteger(0);
  private int U = 11;
  private float V = 1.0F;
  private LinearLayout W;
  private final int X;
  private final int Y;
  private final int Z = 18;
  public Context a;
  private Animation aa;
  private int ab = -1;
  private int ac = -1;
  private boolean ad = true;
  public ImageView b;
  public boolean c = true;
  public TextView d;
  public int g = 0;
  public String i = "50m";
  public int j = 109;
  public int k;
  public double l;
  public jr.a m;
  public boolean n = true;
  public LinearLayout o;
  public float p = 1.4E-45F;
  public int q = 40;
  public List<gs> r = new ArrayList();
  public int s = -1;
  public int t = -1;
  private final int u = 500;
  private final int v = 1000;
  private Bitmap w;
  private Bitmap x;
  private gh.b y = gh.b.c;
  private gh.b z = gh.b.a;
  
  public jr(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.X = paramInt1;
    this.Y = paramInt2;
    this.V = paramContext.getResources().getDisplayMetrics().density;
    double d1 = this.V * 40.0F;
    Double.isNaN(d1);
    this.q = ((int)(d1 + 0.5D));
    this.b = new ImageView(paramContext);
    this.m = new jr.a(this, this.a);
    this.d = new pc(this.a);
    this.d.setText(this.i);
    this.d.setContentDescription("地图");
    this.d.setTextSize(12.0F);
    this.d.setTextColor(-16777216);
    this.d.setGravity(1);
    if (this.V <= 0.0F) {
      this.V = 1.0F;
    }
    this.W = new LinearLayout(this.a);
    this.W.setOrientation(1);
    this.W.setGravity(16);
    this.W.setOnClickListener(new jr.1(this));
    this.o = new LinearLayout(this.a);
    this.o.setOrientation(1);
    this.o.setGravity(16);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 3;
    this.o.addView(this.d, paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 3;
    this.o.addView(this.m, paramContext);
    this.o.setVisibility(8);
    this.aa = new AlphaAnimation(1.0F, 0.0F);
    this.aa.setDuration(1000L);
    this.aa.setStartOffset(500L);
    this.aa.setAnimationListener(new jr.2(this));
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 3;
    this.W.addView(this.b, paramContext);
    a(jx.g());
  }
  
  private void a(Bitmap paramBitmap)
  {
    try
    {
      this.w = paramBitmap;
      if (this.w != null)
      {
        this.L = this.w.getWidth();
        this.M = this.w.getHeight();
      }
      e();
      f();
      return;
    }
    catch (Exception paramBitmap) {}
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Q.clear();
    try
    {
      paramString = new JSONArray(paramString);
      int i1 = 0;
      while (i1 < paramString.length())
      {
        Object localObject2 = paramString.getJSONObject(i1);
        Object localObject1 = ((JSONObject)localObject2).getJSONArray("level");
        int i3 = ((JSONArray)localObject1).getInt(0);
        int i4 = ((JSONArray)localObject1).getInt(1);
        localObject1 = new ArrayList();
        localObject2 = ((JSONObject)localObject2).getJSONArray("districts");
        int i2 = 0;
        while (i2 < ((JSONArray)localObject2).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i2);
          int i5 = localJSONObject.getInt("rule");
          int i6 = localJSONObject.getInt("priority");
          String str = localJSONObject.getString("frontier");
          ((List)localObject1).add(new ju(i5, i6, localJSONObject.getString("logo_name"), localJSONObject.getString("logo"), localJSONObject.optString("logo_night"), str));
          i2 += 1;
        }
        Q.add(new jw(i3, i4, (List)localObject1));
        i1 += 1;
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  /* Error */
  private boolean a(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 454	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   6: invokevirtual 459	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   9: aload_2
    //   10: ifnonnull +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial 461	com/tencent/map/sdk/a/jr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_1
    //   21: aconst_null
    //   22: astore 4
    //   24: new 463	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 464	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 468	java/io/File:exists	()Z
    //   37: istore_3
    //   38: iload_3
    //   39: ifeq +18 -> 57
    //   42: aconst_null
    //   43: invokestatic 473	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   46: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   49: invokevirtual 454	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   52: invokevirtual 476	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   55: iconst_0
    //   56: ireturn
    //   57: new 478	java/io/FileOutputStream
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 481	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   65: astore_1
    //   66: aload_2
    //   67: getstatic 487	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   70: bipush 100
    //   72: aload_1
    //   73: invokevirtual 491	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   76: istore_3
    //   77: aload_1
    //   78: invokestatic 473	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   81: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   84: invokevirtual 454	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   87: invokevirtual 476	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   90: iload_3
    //   91: ireturn
    //   92: astore_2
    //   93: goto +7 -> 100
    //   96: astore_2
    //   97: aload 4
    //   99: astore_1
    //   100: aload_1
    //   101: invokestatic 473	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   104: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   107: invokevirtual 454	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   110: invokevirtual 476	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   113: aload_2
    //   114: athrow
    //   115: aconst_null
    //   116: astore_1
    //   117: aload_1
    //   118: invokestatic 473	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   121: goto -75 -> 46
    //   124: astore_1
    //   125: goto -10 -> 115
    //   128: astore_2
    //   129: goto -12 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	jr
    //   0	132	1	paramString	String
    //   0	132	2	paramBitmap	Bitmap
    //   37	54	3	bool	boolean
    //   22	76	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	77	92	finally
    //   24	38	96	finally
    //   57	66	96	finally
    //   24	38	124	java/lang/Throwable
    //   57	66	124	java/lang/Throwable
    //   66	77	128	java/lang/Throwable
  }
  
  private String b(String paramString)
  {
    String str = c();
    on.a(str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  /* Error */
  private Bitmap c(String paramString)
  {
    // Byte code:
    //   0: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 514	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 517	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: new 463	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 461	com/tencent/map/sdk/a/jr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokespecial 464	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 468	java/io/File:exists	()Z
    //   31: istore_2
    //   32: iload_2
    //   33: ifne +20 -> 53
    //   36: aconst_null
    //   37: invokestatic 473	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   40: aload_3
    //   41: astore_1
    //   42: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   45: invokevirtual 514	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   48: invokevirtual 518	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   51: aload_1
    //   52: areturn
    //   53: new 520	java/io/FileInputStream
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 521	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore_1
    //   62: aload_1
    //   63: invokestatic 527	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   66: astore_3
    //   67: aload_1
    //   68: invokestatic 473	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   71: aload_3
    //   72: astore_1
    //   73: goto -31 -> 42
    //   76: astore_3
    //   77: goto +7 -> 84
    //   80: astore_3
    //   81: aload 4
    //   83: astore_1
    //   84: aload_1
    //   85: invokestatic 473	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   88: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   91: invokevirtual 514	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   94: invokevirtual 518	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   97: aload_3
    //   98: athrow
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: invokestatic 473	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   105: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   108: invokevirtual 514	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   111: invokevirtual 518	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_1
    //   117: goto -18 -> 99
    //   120: astore_3
    //   121: goto -20 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	jr
    //   0	124	1	paramString	String
    //   31	2	2	bool	boolean
    //   13	59	3	localBitmap	Bitmap
    //   76	1	3	localObject1	Object
    //   80	18	3	localObject2	Object
    //   120	1	3	localThrowable	Throwable
    //   10	72	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   62	67	76	finally
    //   14	32	80	finally
    //   53	62	80	finally
    //   14	32	116	java/lang/Throwable
    //   53	62	116	java/lang/Throwable
    //   62	67	120	java/lang/Throwable
  }
  
  public final void a()
  {
    if (this.T.decrementAndGet() == 0)
    {
      if (Build.VERSION.SDK_INT < 11)
      {
        Iterator localIterator = e.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            localBitmap.recycle();
          }
        }
      }
      e.clear();
    }
    on.a(this.x);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.J = paramInt1;
    this.K = paramInt2;
    e();
    f();
  }
  
  public final void a(fv paramfv, int paramInt)
  {
    int i2 = (int)paramfv.c;
    int i1 = i2;
    if (i2 > 18) {
      i1 = 18;
    }
    Object localObject2 = Q.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (jw)((Iterator)localObject2).next();
      if ((i1 >= ((jw)localObject1).a) && (i1 <= ((jw)localObject1).b)) {
        break label76;
      }
    }
    Object localObject1 = null;
    label76:
    if (localObject1 == null) {
      return;
    }
    localObject2 = ((jw)localObject1).c.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (ju)((Iterator)localObject2).next();
      i1 = ((ju)localObject1).a;
      Object localObject3;
      if (i1 != 0)
      {
        if (i1 != 1) {
          break label252;
        }
        if (!"default".equals(((ju)localObject1).b))
        {
          if (paramfv == null) {
            break label252;
          }
          jv.a();
          localObject3 = jv.d(((ju)localObject1).b);
          fw[] arrayOffw = paramfv.b;
          if ((arrayOffw != null) && (localObject3 != null))
          {
            bool = jv.a(arrayOffw, (fw[])localObject3);
            break label255;
          }
        }
      }
      else
      {
        if (!"default".equals(((ju)localObject1).b)) {
          break label220;
        }
      }
      boolean bool = true;
      break label255;
      label220:
      if (paramfv != null)
      {
        localObject3 = paramfv.a;
        jv.a();
        bool = jv.a((fw)localObject3, jv.d(((ju)localObject1).b));
      }
      else
      {
        label252:
        bool = false;
      }
      label255:
      if (bool)
      {
        if (((paramInt == 13) || (paramInt == 10)) && (((ju)localObject1).e != null) && (((ju)localObject1).e.length() > 0))
        {
          paramfv = new String[2];
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((ju)localObject1).c);
          ((StringBuilder)localObject2).append("_night");
          paramfv[0] = ((StringBuilder)localObject2).toString();
          paramfv[1] = ((ju)localObject1).e;
          break label370;
        }
        paramfv = new String[2];
        paramfv[0] = ((ju)localObject1).c;
        paramfv[1] = ((ju)localObject1).d;
        break label370;
      }
    }
    paramfv = null;
    label370:
    if (paramfv == null) {
      return;
    }
    localObject1 = paramfv[0];
    paramfv = paramfv[1];
    if ((nl.a((String)localObject1, this.S) ^ true))
    {
      localObject2 = (Bitmap)e.get(localObject1);
      if (localObject2 != null)
      {
        if (!((Bitmap)localObject2).isRecycled())
        {
          a((Bitmap)localObject2);
          this.S = ((String)localObject1);
          return;
        }
        e.remove(localObject1);
      }
      localObject2 = c((String)localObject1);
      if (localObject2 != null)
      {
        this.S = ((String)localObject1);
        e.put(this.S, localObject2);
        a((Bitmap)localObject2);
        return;
      }
      this.S = null;
      if (!R.contains(localObject1))
      {
        R.add(localObject1);
        new jr.3(this, paramfv, (String)localObject1).start();
      }
    }
  }
  
  public final void a(gh.a parama, int paramInt)
  {
    this.C[parama.e] = paramInt;
  }
  
  public final void a(gh.b paramb)
  {
    if (this.y != paramb) {
      b();
    }
    this.y = paramb;
  }
  
  public final boolean a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return false;
    }
    int i1;
    int i2;
    if (this.P)
    {
      this.P = false;
      on.a(this.x);
      i1 = this.N;
      i2 = this.O;
      int[] arrayOfInt = new int[2];
      float f2 = 1.0F;
      float f1 = this.p;
      if (f1 == 1.4E-45F)
      {
        int i3 = this.g;
        if (i3 != -3)
        {
          if (i3 != -2)
          {
            if (i3 != -1)
            {
              f1 = f2;
              if (i3 != 0) {
                if (i3 != 1) {
                  f1 = f2;
                } else {
                  f1 = 1.2F;
                }
              }
            }
            else
            {
              f1 = 0.8333333F;
            }
          }
          else {
            f1 = 0.8F;
          }
        }
        else {
          f1 = 0.7F;
        }
      }
      arrayOfInt[0] = ((int)(i1 * f1));
      arrayOfInt[1] = ((int)(i2 * f1));
      this.x = fy.a(this.w, this.a, arrayOfInt[0], arrayOfInt[1]);
      try
      {
        this.b.setImageBitmap(this.x);
      }
      catch (Throwable localThrowable)
      {
        Log.e("tencentmap", Log.getStackTraceString(localThrowable));
      }
    }
    this.A = paramViewGroup;
    Object localObject1 = new FrameLayout.LayoutParams(-2, -2);
    if (this.x != null) {
      switch (jr.5.a[this.y.ordinal()])
      {
      default: 
        localObject2 = new StringBuilder("Unknown position:");
        ((StringBuilder)localObject2).append(this.y);
        or.b(((StringBuilder)localObject2).toString());
        break;
      case 6: 
        ((FrameLayout.LayoutParams)localObject1).gravity = 53;
        ((FrameLayout.LayoutParams)localObject1).topMargin = this.E[gh.a.d.e];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = this.E[gh.a.b.e];
        this.ac = ((FrameLayout.LayoutParams)localObject1).topMargin;
        this.ab = (this.J - ((FrameLayout.LayoutParams)localObject1).rightMargin - this.x.getWidth());
        break;
      case 5: 
        ((FrameLayout.LayoutParams)localObject1).gravity = 49;
        ((FrameLayout.LayoutParams)localObject1).topMargin = this.E[gh.a.d.e];
        this.ac = ((FrameLayout.LayoutParams)localObject1).topMargin;
        this.ab = ((this.J - this.x.getWidth()) / 2);
        break;
      case 4: 
        ((FrameLayout.LayoutParams)localObject1).gravity = 51;
        ((FrameLayout.LayoutParams)localObject1).topMargin = this.E[gh.a.d.e];
        ((FrameLayout.LayoutParams)localObject1).leftMargin = this.E[gh.a.a.e];
        this.ac = ((FrameLayout.LayoutParams)localObject1).topMargin;
        this.ab = ((FrameLayout.LayoutParams)localObject1).leftMargin;
        break;
      case 3: 
        ((FrameLayout.LayoutParams)localObject1).gravity = 85;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = this.E[gh.a.c.e];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = this.E[gh.a.b.e];
        this.ac = (this.K - ((FrameLayout.LayoutParams)localObject1).bottomMargin - this.x.getHeight());
        this.ab = (this.J - ((FrameLayout.LayoutParams)localObject1).rightMargin - this.x.getWidth());
        break;
      case 2: 
        ((FrameLayout.LayoutParams)localObject1).gravity = 81;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = this.E[gh.a.c.e];
        this.ac = (this.K - ((FrameLayout.LayoutParams)localObject1).bottomMargin - this.x.getHeight());
        this.ab = ((this.J - this.x.getWidth()) / 2);
        break;
      case 1: 
        ((FrameLayout.LayoutParams)localObject1).gravity = 83;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = this.E[gh.a.c.e];
        ((FrameLayout.LayoutParams)localObject1).leftMargin = this.E[gh.a.a.e];
        this.ac = (this.K - ((FrameLayout.LayoutParams)localObject1).bottomMargin - this.x.getHeight());
        this.ab = ((FrameLayout.LayoutParams)localObject1).leftMargin;
      }
    }
    if (paramViewGroup.indexOfChild(this.W) < 0) {
      paramViewGroup.addView(this.W, (ViewGroup.LayoutParams)localObject1);
    } else {
      paramViewGroup.updateViewLayout(this.W, (ViewGroup.LayoutParams)localObject1);
    }
    localObject1 = new FrameLayout.LayoutParams(-2, -2);
    Object localObject2 = this.o;
    if (localObject2 != null)
    {
      i1 = ((LinearLayout)localObject2).getMeasuredWidth();
      i2 = this.o.getMeasuredHeight();
      switch (jr.5.a[this.z.ordinal()])
      {
      default: 
        localObject2 = new StringBuilder("Unknown positionScale:");
        ((StringBuilder)localObject2).append(this.z);
        or.b(((StringBuilder)localObject2).toString());
        break;
      case 6: 
        ((FrameLayout.LayoutParams)localObject1).gravity = 53;
        ((FrameLayout.LayoutParams)localObject1).topMargin = this.F[gh.a.d.e];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = this.F[gh.a.b.e];
        this.t = ((FrameLayout.LayoutParams)localObject1).topMargin;
        this.s = (this.J - ((FrameLayout.LayoutParams)localObject1).rightMargin - i1);
        break;
      case 5: 
        ((FrameLayout.LayoutParams)localObject1).gravity = 49;
        ((FrameLayout.LayoutParams)localObject1).topMargin = this.F[gh.a.d.e];
        this.t = ((FrameLayout.LayoutParams)localObject1).topMargin;
        this.s = ((this.J - i1) / 2);
        break;
      case 4: 
        ((FrameLayout.LayoutParams)localObject1).gravity = 51;
        ((FrameLayout.LayoutParams)localObject1).topMargin = this.F[gh.a.d.e];
        ((FrameLayout.LayoutParams)localObject1).leftMargin = this.F[gh.a.a.e];
        this.t = ((FrameLayout.LayoutParams)localObject1).topMargin;
        this.s = ((FrameLayout.LayoutParams)localObject1).leftMargin;
        break;
      case 3: 
        ((FrameLayout.LayoutParams)localObject1).gravity = 85;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = this.F[gh.a.c.e];
        ((FrameLayout.LayoutParams)localObject1).rightMargin = this.F[gh.a.b.e];
        this.t = (this.K - ((FrameLayout.LayoutParams)localObject1).bottomMargin - i2);
        this.s = (this.J - ((FrameLayout.LayoutParams)localObject1).rightMargin - i1);
        break;
      case 2: 
        ((FrameLayout.LayoutParams)localObject1).gravity = 81;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = this.F[gh.a.c.e];
        this.t = (this.K - ((FrameLayout.LayoutParams)localObject1).bottomMargin - i2);
        this.s = ((this.J - i1) / 2);
        break;
      case 1: 
        ((FrameLayout.LayoutParams)localObject1).gravity = 83;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = this.F[gh.a.c.e];
        ((FrameLayout.LayoutParams)localObject1).leftMargin = this.F[gh.a.a.e];
        this.t = (this.K - ((FrameLayout.LayoutParams)localObject1).bottomMargin - i2);
        this.s = ((FrameLayout.LayoutParams)localObject1).leftMargin;
      }
    }
    if (paramViewGroup.indexOfChild(this.o) < 0) {
      paramViewGroup.addView(this.o, (ViewGroup.LayoutParams)localObject1);
    } else {
      paramViewGroup.updateViewLayout(this.o, (ViewGroup.LayoutParams)localObject1);
    }
    localObject1 = this.d;
    if ((localObject1 != null) && (this.m != null))
    {
      localObject1 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      this.m.measure(0, 0);
      this.d.measure(0, 0);
      ((LinearLayout.LayoutParams)localObject1).leftMargin = ((int)((this.j + this.V * 6.0F - this.d.getWidth()) / 2.0F));
      this.o.updateViewLayout(this.d, (ViewGroup.LayoutParams)localObject1);
      localObject1 = this.o;
      localObject2 = this.m;
      ((LinearLayout)localObject1).updateViewLayout((View)localObject2, ((jr.a)localObject2).getLayoutParams());
    }
    localObject1 = this.b;
    if (this.c) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    ((ImageView)localObject1).setVisibility(i1);
    if (this.r != null)
    {
      this.W.requestLayout();
      this.o.requestLayout();
      localObject1 = this.r.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (gs)((Iterator)localObject1).next();
        ((gs)localObject2).a(this.W, new Rect(this.ab, this.ac, 0, 0), this.c);
        ((gs)localObject2).b(this.o, new Rect(this.s, this.t, 0, 0), this.n);
      }
    }
    paramViewGroup.requestLayout();
    return true;
  }
  
  public final void b()
  {
    a(this.A);
  }
  
  public final void b(gh.a parama, int paramInt)
  {
    if (this.ad) {
      this.ad = false;
    }
    this.D[parama.e] = paramInt;
    f();
  }
  
  public final void b(gh.b paramb)
  {
    if (this.z != paramb) {
      b();
    }
    this.z = paramb;
  }
  
  public final String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getFilesDir().getAbsolutePath());
    localStringBuilder.append("/tencentMapSdk/logos");
    return localStringBuilder.toString();
  }
  
  public final Rect d()
  {
    Rect localRect = new Rect();
    LinearLayout localLinearLayout = this.W;
    if (localLinearLayout != null)
    {
      localRect.left = localLinearLayout.getLeft();
      localRect.bottom = this.W.getBottom();
      localRect.right = this.W.getRight();
      localRect.top = this.W.getTop();
    }
    return localRect;
  }
  
  public final void e()
  {
    int i1 = this.J;
    if (i1 != 0)
    {
      if (this.K == 0) {
        return;
      }
      float f1 = this.L;
      float f2 = this.V;
      this.N = ((int)(f1 * f2 / 3.0F));
      this.O = ((int)(this.M * f2 / 3.0F));
      Object localObject1 = this.G;
      if (i1 >= 1080) {
        localObject1 = this.I;
      } else if (i1 >= 720) {
        localObject1 = this.H;
      }
      i1 = gh.a.a.e;
      f1 = localObject1[i1];
      Object localObject2 = this.B;
      if (localObject2[i1] >= 0.0F) {
        f1 = localObject2[i1];
      }
      this.E[i1] = ((int)(this.J * f1));
      if (this.ad) {
        this.D[gh.a.c.e] = this.O;
      }
      localObject2 = this.C;
      if ((localObject2[i1] >= 0) && (localObject2[i1] < this.J - this.N)) {
        this.E[i1] = localObject2[i1];
      }
      i1 = gh.a.b.e;
      f1 = localObject1[i1];
      localObject2 = this.B;
      if (localObject2[i1] >= 0.0F) {
        f1 = localObject2[i1];
      }
      localObject2 = this.E;
      int i2 = this.J;
      localObject2[i1] = ((int)(i2 * f1));
      int[] arrayOfInt = this.C;
      if ((arrayOfInt[i1] >= 0) && (arrayOfInt[i1] < i2 - this.N)) {
        localObject2[i1] = arrayOfInt[i1];
      }
      i1 = gh.a.c.e;
      f1 = localObject1[i1];
      localObject2 = this.B;
      if (localObject2[i1] >= 0.0F) {
        f1 = localObject2[i1];
      }
      localObject2 = this.E;
      i2 = this.K;
      localObject2[i1] = ((int)(i2 * f1));
      arrayOfInt = this.C;
      if ((arrayOfInt[i1] >= 0) && (arrayOfInt[i1] < i2 - this.O)) {
        localObject2[i1] = arrayOfInt[i1];
      }
      i1 = gh.a.d.e;
      f1 = localObject1[i1];
      localObject1 = this.B;
      if (localObject1[i1] >= 0.0F) {
        f1 = localObject1[i1];
      }
      localObject1 = this.E;
      i2 = this.K;
      localObject1[i1] = ((int)(i2 * f1));
      localObject2 = this.C;
      if ((localObject2[i1] >= 0) && (localObject2[i1] < i2 - this.O)) {
        localObject1[i1] = localObject2[i1];
      }
      this.P = true;
      b();
    }
  }
  
  public final void f()
  {
    if (this.J != 0)
    {
      if (this.K == 0) {
        return;
      }
      int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.o.measure(i1, i2);
      i1 = this.o.getMeasuredHeight();
      i2 = this.o.getMeasuredWidth();
      Object localObject1 = this.G;
      int i3 = this.J;
      if (i3 >= 1080) {
        localObject1 = this.I;
      } else if (i3 >= 720) {
        localObject1 = this.H;
      }
      i3 = gh.a.a.e;
      float f1 = localObject1[i3];
      Object localObject2 = this.B;
      if (localObject2[i3] >= 0.0F) {
        f1 = localObject2[i3];
      }
      localObject2 = this.F;
      int i4 = this.J;
      localObject2[i3] = ((int)(i4 * f1));
      int[] arrayOfInt = this.D;
      if ((arrayOfInt[i3] >= 0) && (arrayOfInt[i3] < i4 - i2)) {
        localObject2[i3] = arrayOfInt[i3];
      }
      i3 = gh.a.b.e;
      f1 = localObject1[i3];
      localObject2 = this.B;
      if (localObject2[i3] >= 0.0F) {
        f1 = localObject2[i3];
      }
      localObject2 = this.F;
      i4 = this.J;
      localObject2[i3] = ((int)(i4 * f1));
      arrayOfInt = this.D;
      if ((arrayOfInt[i3] >= 0) && (arrayOfInt[i3] < i4 - i2)) {
        localObject2[i3] = arrayOfInt[i3];
      }
      i2 = gh.a.c.e;
      f1 = localObject1[i2];
      localObject2 = this.B;
      if (localObject2[i2] >= 0.0F) {
        f1 = localObject2[i2];
      }
      localObject2 = this.F;
      i3 = this.K;
      localObject2[i2] = ((int)(i3 * f1));
      arrayOfInt = this.D;
      if ((arrayOfInt[i2] >= 0) && (arrayOfInt[i2] < i3 - i1)) {
        localObject2[i2] = arrayOfInt[i2];
      }
      i2 = gh.a.d.e;
      f1 = localObject1[i2];
      localObject1 = this.B;
      if (localObject1[i2] >= 0.0F) {
        f1 = localObject1[i2];
      }
      localObject1 = this.F;
      i3 = this.K;
      localObject1[i2] = ((int)(i3 * f1));
      localObject2 = this.D;
      if ((localObject2[i2] >= 0) && (localObject2[i2] < i3 - i1)) {
        localObject1[i2] = localObject2[i2];
      }
      b();
    }
  }
  
  public final void g()
  {
    if (this.o.getVisibility() != 0) {
      return;
    }
    this.o.clearAnimation();
    this.aa.reset();
    this.o.startAnimation(this.aa);
  }
  
  public final boolean h()
  {
    if (nl.a(this.S)) {
      return true;
    }
    if (!this.S.contains("tencent")) {
      return this.S.contains("taiwan");
    }
    return true;
  }
  
  public final void i()
  {
    Object localObject = this.r;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((gs)((Iterator)localObject).next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jr
 * JD-Core Version:    0.7.0.1
 */