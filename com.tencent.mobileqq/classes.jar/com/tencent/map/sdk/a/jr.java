package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
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
    this.q = ((int)(40.0F * this.V + 0.5D));
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
    if (paramString == null) {}
    for (;;)
    {
      return;
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
  }
  
  /* Error */
  private boolean a(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   6: invokevirtual 448	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   9: invokevirtual 453	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   12: aload_2
    //   13: ifnonnull +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 455	com/tencent/map/sdk/a/jr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_1
    //   24: new 457	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 458	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 462	java/io/File:exists	()Z
    //   37: istore_3
    //   38: iload_3
    //   39: ifeq +18 -> 57
    //   42: aconst_null
    //   43: invokestatic 467	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   46: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   49: invokevirtual 448	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   52: invokevirtual 470	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   55: iconst_0
    //   56: ireturn
    //   57: new 472	java/io/FileOutputStream
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 475	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   65: astore_1
    //   66: aload_2
    //   67: getstatic 481	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   70: bipush 100
    //   72: aload_1
    //   73: invokevirtual 485	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   76: istore_3
    //   77: aload_1
    //   78: invokestatic 467	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   81: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   84: invokevirtual 448	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   87: invokevirtual 470	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   90: iload_3
    //   91: ireturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: invokestatic 467	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   99: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   102: invokevirtual 448	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   105: invokevirtual 470	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_1
    //   111: aload 4
    //   113: astore_2
    //   114: aload_2
    //   115: invokestatic 467	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   118: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   121: invokevirtual 448	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   124: invokevirtual 470	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   127: aload_1
    //   128: athrow
    //   129: astore 4
    //   131: aload_1
    //   132: astore_2
    //   133: aload 4
    //   135: astore_1
    //   136: goto -22 -> 114
    //   139: astore_2
    //   140: goto -45 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	jr
    //   0	143	1	paramString	String
    //   0	143	2	paramBitmap	Bitmap
    //   37	54	3	bool	boolean
    //   1	111	4	localObject1	Object
    //   129	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	38	92	java/lang/Throwable
    //   57	66	92	java/lang/Throwable
    //   24	38	110	finally
    //   57	66	110	finally
    //   66	77	129	finally
    //   66	77	139	java/lang/Throwable
  }
  
  private String b(String paramString)
  {
    String str = c();
    on.a(str);
    return str + "/" + paramString;
  }
  
  /* Error */
  private Bitmap c(String paramString)
  {
    // Byte code:
    //   0: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 508	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 511	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: new 457	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 455	com/tencent/map/sdk/a/jr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokespecial 458	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 462	java/io/File:exists	()Z
    //   26: istore_2
    //   27: iload_2
    //   28: ifne +18 -> 46
    //   31: aconst_null
    //   32: invokestatic 467	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   35: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   38: invokevirtual 508	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   41: invokevirtual 512	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   44: aconst_null
    //   45: areturn
    //   46: new 514	java/io/FileInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 515	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore_1
    //   55: aload_1
    //   56: invokestatic 521	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   59: astore_3
    //   60: aload_1
    //   61: invokestatic 467	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   64: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   67: invokevirtual 508	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   70: invokevirtual 512	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   73: aload_3
    //   74: areturn
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: invokestatic 467	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   82: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   85: invokevirtual 508	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   88: invokevirtual 512	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore 4
    //   97: aload_1
    //   98: astore_3
    //   99: aload 4
    //   101: invokestatic 467	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   104: getstatic 103	com/tencent/map/sdk/a/jr:f	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   107: invokevirtual 508	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   110: invokevirtual 512	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   113: aload_3
    //   114: athrow
    //   115: astore_3
    //   116: aload_1
    //   117: astore 4
    //   119: goto -20 -> 99
    //   122: astore_3
    //   123: goto -45 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	jr
    //   0	126	1	paramString	String
    //   26	2	2	bool	boolean
    //   59	55	3	localObject1	Object
    //   115	1	3	localObject2	Object
    //   122	1	3	localThrowable	Throwable
    //   95	23	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	27	75	java/lang/Throwable
    //   46	55	75	java/lang/Throwable
    //   9	27	93	finally
    //   46	55	93	finally
    //   55	60	115	finally
    //   55	60	122	java/lang/Throwable
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
    Object localObject1;
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (jw)((Iterator)localObject2).next();
    } while ((i1 < ((jw)localObject1).a) || (i1 > ((jw)localObject1).b));
    for (;;)
    {
      if (localObject1 == null) {}
      label136:
      label139:
      label215:
      do
      {
        boolean bool;
        do
        {
          return;
          localObject1 = ((jw)localObject1).c.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (ju)((Iterator)localObject1).next();
            switch (((ju)localObject2).a)
            {
            default: 
              bool = false;
            }
          } while (!bool);
          if (((paramInt != 13) && (paramInt != 10)) || (((ju)localObject2).e == null) || (((ju)localObject2).e.length() <= 0)) {
            break;
          }
          paramfv = new String[] { ((ju)localObject2).c + "_night", ((ju)localObject2).e };
        } while (paramfv == null);
        localObject1 = paramfv[0];
        paramfv = paramfv[1];
        if (!nl.a((String)localObject1, this.S)) {}
        for (paramInt = 1; paramInt != 0; paramInt = 0)
        {
          localObject2 = (Bitmap)e.get(localObject1);
          if (localObject2 == null) {
            break label452;
          }
          if (((Bitmap)localObject2).isRecycled()) {
            break label443;
          }
          a((Bitmap)localObject2);
          this.S = ((String)localObject1);
          return;
          if ("default".equals(((ju)localObject2).b))
          {
            bool = true;
            break label139;
          }
          if (paramfv == null) {
            break label136;
          }
          Object localObject3 = paramfv.a;
          jv.a();
          bool = jv.a((fw)localObject3, jv.d(((ju)localObject2).b));
          break label139;
          if ("default".equals(((ju)localObject2).b))
          {
            bool = true;
            break label139;
          }
          if (paramfv == null) {
            break label136;
          }
          jv.a();
          localObject3 = jv.d(((ju)localObject2).b);
          fw[] arrayOffw = paramfv.b;
          if ((arrayOffw == null) || (localObject3 == null))
          {
            bool = true;
            break label139;
          }
          bool = jv.a(arrayOffw, (fw[])localObject3);
          break label139;
          paramfv = new String[] { ((ju)localObject2).c, ((ju)localObject2).d };
          break label215;
          paramfv = null;
          break label215;
        }
        e.remove(localObject1);
        localObject2 = c((String)localObject1);
        if (localObject2 != null)
        {
          this.S = ((String)localObject1);
          e.put(this.S, localObject2);
          a((Bitmap)localObject2);
          return;
        }
        this.S = null;
      } while (R.contains(localObject1));
      label443:
      label452:
      R.add(localObject1);
      new jr.3(this, paramfv, (String)localObject1).start();
      return;
      localObject1 = null;
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
    Object localObject;
    float f2;
    float f1;
    if (this.P)
    {
      this.P = false;
      on.a(this.x);
      i1 = this.N;
      i2 = this.O;
      localObject = new int[2];
      f2 = 1.0F;
      if (this.p == 1.4E-45F) {
        break label614;
      }
      f1 = this.p;
    }
    for (;;)
    {
      localObject[0] = ((int)(i1 * f1));
      localObject[1] = ((int)(f1 * i2));
      this.x = fy.a(this.w, this.a, localObject[0], localObject[1]);
      try
      {
        this.b.setImageBitmap(this.x);
        this.A = paramViewGroup;
        localObject = new FrameLayout.LayoutParams(-2, -2);
        if (this.x != null) {}
        switch (jr.5.a[this.y.ordinal()])
        {
        default: 
          or.b("Unknown position:" + this.y);
          if (paramViewGroup.indexOfChild(this.W) < 0)
          {
            paramViewGroup.addView(this.W, (ViewGroup.LayoutParams)localObject);
            localObject = new FrameLayout.LayoutParams(-2, -2);
            if (this.o != null)
            {
              i1 = this.o.getMeasuredWidth();
              i2 = this.o.getMeasuredHeight();
            }
            switch (jr.5.a[this.z.ordinal()])
            {
            default: 
              or.b("Unknown positionScale:" + this.z);
              if (paramViewGroup.indexOfChild(this.o) < 0)
              {
                paramViewGroup.addView(this.o, (ViewGroup.LayoutParams)localObject);
                if ((this.d != null) && (this.m != null))
                {
                  localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
                  this.m.measure(0, 0);
                  this.d.measure(0, 0);
                  ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)((this.j + 6.0F * this.V - this.d.getWidth()) / 2.0F));
                  this.o.updateViewLayout(this.d, (ViewGroup.LayoutParams)localObject);
                  this.o.updateViewLayout(this.m, this.m.getLayoutParams());
                }
                localObject = this.b;
                if (!this.c) {
                  break label1519;
                }
                i1 = 0;
                ((ImageView)localObject).setVisibility(i1);
                if (this.r == null) {
                  break label1525;
                }
                this.W.requestLayout();
                this.o.requestLayout();
                localObject = this.r.iterator();
                for (;;)
                {
                  if (((Iterator)localObject).hasNext())
                  {
                    gs localgs = (gs)((Iterator)localObject).next();
                    localgs.a(this.W, new Rect(this.ab, this.ac, 0, 0), this.c);
                    localgs.b(this.o, new Rect(this.s, this.t, 0, 0), this.n);
                    continue;
                    label614:
                    f1 = f2;
                    switch (this.g)
                    {
                    case 0: 
                    default: 
                      f1 = f2;
                      break;
                    case -3: 
                      f1 = 0.7F;
                      break;
                    case 1: 
                      f1 = 1.2F;
                      break;
                    case -1: 
                      f1 = 0.8333333F;
                      break;
                    case -2: 
                      f1 = 0.8F;
                    }
                  }
                }
              }
              break;
            }
          }
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("tencentmap", Log.getStackTraceString(localThrowable));
          continue;
          localThrowable.gravity = 83;
          localThrowable.bottomMargin = this.E[gh.a.c.e];
          localThrowable.leftMargin = this.E[gh.a.a.e];
          this.ac = (this.K - localThrowable.bottomMargin - this.x.getHeight());
          this.ab = localThrowable.leftMargin;
          continue;
          localThrowable.gravity = 81;
          localThrowable.bottomMargin = this.E[gh.a.c.e];
          this.ac = (this.K - localThrowable.bottomMargin - this.x.getHeight());
          this.ab = ((this.J - this.x.getWidth()) / 2);
          continue;
          localThrowable.gravity = 85;
          localThrowable.bottomMargin = this.E[gh.a.c.e];
          localThrowable.rightMargin = this.E[gh.a.b.e];
          this.ac = (this.K - localThrowable.bottomMargin - this.x.getHeight());
          this.ab = (this.J - localThrowable.rightMargin - this.x.getWidth());
          continue;
          localThrowable.gravity = 51;
          localThrowable.topMargin = this.E[gh.a.d.e];
          localThrowable.leftMargin = this.E[gh.a.a.e];
          this.ac = localThrowable.topMargin;
          this.ab = localThrowable.leftMargin;
          continue;
          localThrowable.gravity = 49;
          localThrowable.topMargin = this.E[gh.a.d.e];
          this.ac = localThrowable.topMargin;
          this.ab = ((this.J - this.x.getWidth()) / 2);
          continue;
          localThrowable.gravity = 53;
          localThrowable.topMargin = this.E[gh.a.d.e];
          localThrowable.rightMargin = this.E[gh.a.b.e];
          this.ac = localThrowable.topMargin;
          this.ab = (this.J - localThrowable.rightMargin - this.x.getWidth());
          continue;
          paramViewGroup.updateViewLayout(this.W, localThrowable);
          continue;
          localThrowable.gravity = 83;
          localThrowable.bottomMargin = this.F[gh.a.c.e];
          localThrowable.leftMargin = this.F[gh.a.a.e];
          this.t = (this.K - localThrowable.bottomMargin - i2);
          this.s = localThrowable.leftMargin;
          continue;
          localThrowable.gravity = 81;
          localThrowable.bottomMargin = this.F[gh.a.c.e];
          this.t = (this.K - localThrowable.bottomMargin - i2);
          this.s = ((this.J - i1) / 2);
          continue;
          localThrowable.gravity = 85;
          localThrowable.bottomMargin = this.F[gh.a.c.e];
          localThrowable.rightMargin = this.F[gh.a.b.e];
          this.t = (this.K - localThrowable.bottomMargin - i2);
          this.s = (this.J - localThrowable.rightMargin - i1);
          continue;
          localThrowable.gravity = 51;
          localThrowable.topMargin = this.F[gh.a.d.e];
          localThrowable.leftMargin = this.F[gh.a.a.e];
          this.t = localThrowable.topMargin;
          this.s = localThrowable.leftMargin;
          continue;
          localThrowable.gravity = 49;
          localThrowable.topMargin = this.F[gh.a.d.e];
          this.t = localThrowable.topMargin;
          this.s = ((this.J - i1) / 2);
          continue;
          localThrowable.gravity = 53;
          localThrowable.topMargin = this.F[gh.a.d.e];
          localThrowable.rightMargin = this.F[gh.a.b.e];
          this.t = localThrowable.topMargin;
          this.s = (this.J - localThrowable.rightMargin - i1);
          continue;
          paramViewGroup.updateViewLayout(this.o, localThrowable);
          continue;
          label1519:
          i1 = 4;
        }
        label1525:
        paramViewGroup.requestLayout();
      }
    }
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
    return this.a.getFilesDir().getAbsolutePath() + "/tencentMapSdk/logos";
  }
  
  public final Rect d()
  {
    Rect localRect = new Rect();
    if (this.W != null)
    {
      localRect.left = this.W.getLeft();
      localRect.bottom = this.W.getBottom();
      localRect.right = this.W.getRight();
      localRect.top = this.W.getTop();
    }
    return localRect;
  }
  
  public final void e()
  {
    if ((this.J == 0) || (this.K == 0)) {
      return;
    }
    this.N = ((int)(this.L * this.V / 3.0F));
    this.O = ((int)(this.M * this.V / 3.0F));
    float[] arrayOfFloat = this.G;
    if (this.J >= 1080) {
      arrayOfFloat = this.I;
    }
    for (;;)
    {
      int i1 = gh.a.a.e;
      float f1 = arrayOfFloat[i1];
      if (this.B[i1] >= 0.0F) {
        f1 = this.B[i1];
      }
      this.E[i1] = ((int)(f1 * this.J));
      if (this.ad) {
        this.D[gh.a.c.e] = this.O;
      }
      if ((this.C[i1] >= 0) && (this.C[i1] < this.J - this.N)) {
        this.E[i1] = this.C[i1];
      }
      i1 = gh.a.b.e;
      f1 = arrayOfFloat[i1];
      if (this.B[i1] >= 0.0F) {
        f1 = this.B[i1];
      }
      this.E[i1] = ((int)(f1 * this.J));
      if ((this.C[i1] >= 0) && (this.C[i1] < this.J - this.N)) {
        this.E[i1] = this.C[i1];
      }
      i1 = gh.a.c.e;
      f1 = arrayOfFloat[i1];
      if (this.B[i1] >= 0.0F) {
        f1 = this.B[i1];
      }
      this.E[i1] = ((int)(f1 * this.K));
      if ((this.C[i1] >= 0) && (this.C[i1] < this.K - this.O)) {
        this.E[i1] = this.C[i1];
      }
      i1 = gh.a.d.e;
      f1 = arrayOfFloat[i1];
      if (this.B[i1] >= 0.0F) {
        f1 = this.B[i1];
      }
      this.E[i1] = ((int)(f1 * this.K));
      if ((this.C[i1] >= 0) && (this.C[i1] < this.K - this.O)) {
        this.E[i1] = this.C[i1];
      }
      this.P = true;
      b();
      return;
      if (this.J >= 720) {
        arrayOfFloat = this.H;
      }
    }
  }
  
  public final void f()
  {
    if ((this.J == 0) || (this.K == 0)) {
      return;
    }
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.o.measure(i1, i2);
    i1 = this.o.getMeasuredHeight();
    i2 = this.o.getMeasuredWidth();
    float[] arrayOfFloat = this.G;
    if (this.J >= 1080) {
      arrayOfFloat = this.I;
    }
    for (;;)
    {
      int i3 = gh.a.a.e;
      float f1 = arrayOfFloat[i3];
      if (this.B[i3] >= 0.0F) {
        f1 = this.B[i3];
      }
      this.F[i3] = ((int)(f1 * this.J));
      if ((this.D[i3] >= 0) && (this.D[i3] < this.J - i2)) {
        this.F[i3] = this.D[i3];
      }
      i3 = gh.a.b.e;
      f1 = arrayOfFloat[i3];
      if (this.B[i3] >= 0.0F) {
        f1 = this.B[i3];
      }
      this.F[i3] = ((int)(f1 * this.J));
      if ((this.D[i3] >= 0) && (this.D[i3] < this.J - i2)) {
        this.F[i3] = this.D[i3];
      }
      i2 = gh.a.c.e;
      f1 = arrayOfFloat[i2];
      if (this.B[i2] >= 0.0F) {
        f1 = this.B[i2];
      }
      this.F[i2] = ((int)(f1 * this.K));
      if ((this.D[i2] >= 0) && (this.D[i2] < this.K - i1)) {
        this.F[i2] = this.D[i2];
      }
      i2 = gh.a.d.e;
      f1 = arrayOfFloat[i2];
      if (this.B[i2] >= 0.0F) {
        f1 = this.B[i2];
      }
      this.F[i2] = ((int)(f1 * this.K));
      if ((this.D[i2] >= 0) && (this.D[i2] < this.K - i1)) {
        this.F[i2] = this.D[i2];
      }
      b();
      return;
      if (this.J >= 720) {
        arrayOfFloat = this.H;
      }
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
    if (nl.a(this.S)) {}
    while ((this.S.contains("tencent")) || (this.S.contains("taiwan"))) {
      return true;
    }
    return false;
  }
  
  public final void i()
  {
    if (this.r != null)
    {
      Iterator localIterator = this.r.iterator();
      while (localIterator.hasNext()) {
        ((gs)localIterator.next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jr
 * JD-Core Version:    0.7.0.1
 */