package com.tencent.mapsdk.rastercore.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.mapsdk.rastercore.b.b;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.d.h;
import java.io.File;
import java.lang.ref.WeakReference;
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

public final class a
{
  private static List<b> a = new CopyOnWriteArrayList();
  private static ConcurrentHashMap<String, Bitmap> b = new ConcurrentHashMap();
  private static ReentrantReadWriteLock g = new ReentrantReadWriteLock();
  private String c = null;
  private Context d;
  private WeakReference<f> e;
  private AtomicInteger f = new AtomicInteger(0);
  
  public a(f paramf)
  {
    if (this.f.getAndIncrement() == 0) {
      a(h.j());
    }
    this.d = f.a();
    this.e = new WeakReference(paramf);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      a.clear();
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject2 = paramString.getJSONObject(i);
          Object localObject1 = ((JSONObject)localObject2).getJSONArray("level");
          int k = ((JSONArray)localObject1).getInt(0);
          int m = ((JSONArray)localObject1).getInt(1);
          localObject1 = new ArrayList();
          localObject2 = ((JSONObject)localObject2).getJSONArray("districts");
          int j = 0;
          while (j < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
            int n = localJSONObject.getInt("rule");
            int i1 = localJSONObject.getInt("priority");
            String str = localJSONObject.getString("frontier");
            ((List)localObject1).add(new com.tencent.mapsdk.rastercore.b.a(n, i1, localJSONObject.getString("logo_name"), localJSONObject.getString("logo"), str));
            j += 1;
          }
          a.add(new b(k, m, (List)localObject1));
          i += 1;
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
    //   3: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   6: invokevirtual 158	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   9: invokevirtual 163	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   12: aload_2
    //   13: ifnonnull +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 165	com/tencent/mapsdk/rastercore/d/a/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_1
    //   24: new 167	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 172	java/io/File:exists	()Z
    //   37: istore_3
    //   38: iload_3
    //   39: ifeq +18 -> 57
    //   42: aconst_null
    //   43: invokestatic 177	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   46: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   49: invokevirtual 158	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   52: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   55: iconst_0
    //   56: ireturn
    //   57: new 182	java/io/FileOutputStream
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 185	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   65: astore_1
    //   66: aload_2
    //   67: getstatic 191	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   70: bipush 100
    //   72: aload_1
    //   73: invokevirtual 197	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   76: istore_3
    //   77: aload_1
    //   78: invokestatic 177	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   81: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   84: invokevirtual 158	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   87: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   90: iload_3
    //   91: ireturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: invokestatic 177	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   99: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   102: invokevirtual 158	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   105: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_1
    //   111: aload 4
    //   113: astore_2
    //   114: aload_2
    //   115: invokestatic 177	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   118: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   121: invokevirtual 158	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   124: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
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
    //   0	143	0	this	a
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
    String str = d();
    com.tencent.mapsdk.rastercore.c.b(str);
    return str + "/" + paramString;
  }
  
  /* Error */
  private Bitmap c(String paramString)
  {
    // Byte code:
    //   0: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 219	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 222	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: new 167	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 165	com/tencent/mapsdk/rastercore/d/a/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 172	java/io/File:exists	()Z
    //   26: istore_2
    //   27: iload_2
    //   28: ifne +18 -> 46
    //   31: aconst_null
    //   32: invokestatic 177	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   35: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   38: invokevirtual 219	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   41: invokevirtual 223	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   44: aconst_null
    //   45: areturn
    //   46: new 225	java/io/FileInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 226	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore_1
    //   55: aload_1
    //   56: invokestatic 232	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   59: astore_3
    //   60: aload_1
    //   61: invokestatic 177	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   64: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   67: invokevirtual 219	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   70: invokevirtual 223	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   73: aload_3
    //   74: areturn
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: invokestatic 177	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   82: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   85: invokevirtual 219	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   88: invokevirtual 223	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore 4
    //   97: aload_1
    //   98: astore_3
    //   99: aload 4
    //   101: invokestatic 177	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   104: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   107: invokevirtual 219	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   110: invokevirtual 223	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
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
    //   0	126	0	this	a
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
  
  private String d()
  {
    return this.d.getFilesDir() + "/logos";
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 158	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   6: invokevirtual 163	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   9: getstatic 39	com/tencent/mapsdk/rastercore/d/a/a:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: invokevirtual 245	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   15: new 167	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 199	com/tencent/mapsdk/rastercore/d/a/a:d	()Ljava/lang/String;
    //   23: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 172	java/io/File:exists	()Z
    //   31: ifeq +56 -> 87
    //   34: new 167	java/io/File
    //   37: dup
    //   38: new 204	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: getfield 76	com/tencent/mapsdk/rastercore/d/a/a:d	Landroid/content/Context;
    //   49: invokevirtual 239	android/content/Context:getFilesDir	()Ljava/io/File;
    //   52: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: ldc 247
    //   57: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore_2
    //   67: aload_1
    //   68: aload_2
    //   69: invokevirtual 251	java/io/File:renameTo	(Ljava/io/File;)Z
    //   72: ifeq +25 -> 97
    //   75: new 8	com/tencent/mapsdk/rastercore/d/a/a$2
    //   78: dup
    //   79: aload_0
    //   80: aload_2
    //   81: invokespecial 254	com/tencent/mapsdk/rastercore/d/a/a$2:<init>	(Lcom/tencent/mapsdk/rastercore/d/a/a;Ljava/io/File;)V
    //   84: invokevirtual 257	com/tencent/mapsdk/rastercore/d/a/a$2:start	()V
    //   87: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   90: invokevirtual 158	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   93: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   96: return
    //   97: aload_1
    //   98: invokevirtual 260	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   101: invokestatic 262	com/tencent/mapsdk/rastercore/c:a	(Ljava/lang/String;)Z
    //   104: pop
    //   105: goto -18 -> 87
    //   108: astore_1
    //   109: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   112: invokevirtual 158	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   115: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   118: return
    //   119: astore_1
    //   120: getstatic 44	com/tencent/mapsdk/rastercore/d/a/a:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   123: invokevirtual 158	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   126: invokevirtual 180	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	a
    //   26	72	1	localFile1	File
    //   108	1	1	localThrowable	Throwable
    //   119	11	1	localObject	Object
    //   66	15	2	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   15	87	108	java/lang/Throwable
    //   97	105	108	java/lang/Throwable
    //   15	87	119	finally
    //   97	105	119	finally
  }
  
  public final void a(final com.tencent.mapsdk.rastercore.b.c paramc)
  {
    float f1 = paramc.c();
    Object localObject2 = a.iterator();
    Object localObject1;
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (b)((Iterator)localObject2).next();
    } while ((f1 < ((b)localObject1).a()) || (f1 > ((b)localObject1).b()));
    for (;;)
    {
      if (localObject1 == null) {}
      for (;;)
      {
        return;
        localObject1 = ((b)localObject1).a(paramc);
        if (localObject1 != null)
        {
          paramc = localObject1[0];
          localObject1 = localObject1[1];
          if (paramc != this.c) {}
          for (int i = 1; i != 0; i = 0)
          {
            localObject2 = (Bitmap)b.get(paramc);
            if (localObject2 == null) {
              break label172;
            }
            if (((Bitmap)localObject2).isRecycled()) {
              break label164;
            }
            if (this.e.get() == null) {
              break label172;
            }
            ((f)this.e.get()).a((Bitmap)localObject2);
            this.c = paramc;
            return;
          }
        }
      }
      label164:
      b.remove(paramc);
      label172:
      localObject2 = c(paramc);
      if ((localObject2 != null) && (this.e.get() != null))
      {
        this.c = paramc;
        b.put(this.c, localObject2);
        ((f)this.e.get()).a((Bitmap)localObject2);
        return;
      }
      this.c = null;
      new Thread()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: invokespecial 30	java/lang/Thread:run	()V
          //   4: aconst_null
          //   5: astore_2
          //   6: new 32	java/net/URL
          //   9: dup
          //   10: aload_0
          //   11: getfield 19	com/tencent/mapsdk/rastercore/d/a/a$1:a	Ljava/lang/String;
          //   14: invokespecial 35	java/net/URL:<init>	(Ljava/lang/String;)V
          //   17: invokevirtual 39	java/net/URL:openConnection	()Ljava/net/URLConnection;
          //   20: checkcast 41	java/net/HttpURLConnection
          //   23: astore_1
          //   24: aload_1
          //   25: sipush 3000
          //   28: invokevirtual 45	java/net/HttpURLConnection:setConnectTimeout	(I)V
          //   31: aload_1
          //   32: invokevirtual 49	java/net/HttpURLConnection:getResponseCode	()I
          //   35: sipush 200
          //   38: if_icmpne +70 -> 108
          //   41: aload_1
          //   42: invokevirtual 53	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
          //   45: invokestatic 59	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
          //   48: astore_2
          //   49: aload_2
          //   50: ifnull +15 -> 65
          //   53: invokestatic 62	com/tencent/mapsdk/rastercore/d/a/a:c	()Ljava/util/concurrent/ConcurrentHashMap;
          //   56: aload_0
          //   57: getfield 21	com/tencent/mapsdk/rastercore/d/a/a$1:b	Ljava/lang/String;
          //   60: aload_2
          //   61: invokevirtual 68	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   64: pop
          //   65: aload_0
          //   66: getfield 17	com/tencent/mapsdk/rastercore/d/a/a$1:c	Lcom/tencent/mapsdk/rastercore/d/a/a;
          //   69: invokestatic 71	com/tencent/mapsdk/rastercore/d/a/a:a	(Lcom/tencent/mapsdk/rastercore/d/a/a;)Ljava/lang/ref/WeakReference;
          //   72: invokevirtual 77	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
          //   75: ifnull +20 -> 95
          //   78: aload_0
          //   79: getfield 17	com/tencent/mapsdk/rastercore/d/a/a$1:c	Lcom/tencent/mapsdk/rastercore/d/a/a;
          //   82: invokestatic 71	com/tencent/mapsdk/rastercore/d/a/a:a	(Lcom/tencent/mapsdk/rastercore/d/a/a;)Ljava/lang/ref/WeakReference;
          //   85: invokevirtual 77	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
          //   88: checkcast 79	com/tencent/mapsdk/rastercore/d/f
          //   91: aload_2
          //   92: invokevirtual 82	com/tencent/mapsdk/rastercore/d/f:b	(Landroid/graphics/Bitmap;)V
          //   95: aload_0
          //   96: getfield 17	com/tencent/mapsdk/rastercore/d/a/a$1:c	Lcom/tencent/mapsdk/rastercore/d/a/a;
          //   99: aload_0
          //   100: getfield 21	com/tencent/mapsdk/rastercore/d/a/a$1:b	Ljava/lang/String;
          //   103: aload_2
          //   104: invokestatic 85	com/tencent/mapsdk/rastercore/d/a/a:a	(Lcom/tencent/mapsdk/rastercore/d/a/a;Ljava/lang/String;Landroid/graphics/Bitmap;)Z
          //   107: pop
          //   108: aload_1
          //   109: ifnull +7 -> 116
          //   112: aload_1
          //   113: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
          //   116: return
          //   117: astore_1
          //   118: aconst_null
          //   119: astore_1
          //   120: aload_1
          //   121: ifnull -5 -> 116
          //   124: aload_1
          //   125: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
          //   128: return
          //   129: astore_3
          //   130: aload_2
          //   131: astore_1
          //   132: aload_3
          //   133: astore_2
          //   134: aload_1
          //   135: ifnull +7 -> 142
          //   138: aload_1
          //   139: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
          //   142: aload_2
          //   143: athrow
          //   144: astore_2
          //   145: goto -11 -> 134
          //   148: astore_2
          //   149: goto -29 -> 120
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	152	0	this	1
          //   23	90	1	localHttpURLConnection	java.net.HttpURLConnection
          //   117	1	1	localThrowable1	Throwable
          //   119	20	1	localObject1	Object
          //   5	138	2	localObject2	Object
          //   144	1	2	localObject3	Object
          //   148	1	2	localThrowable2	Throwable
          //   129	4	3	localObject4	Object
          // Exception table:
          //   from	to	target	type
          //   6	24	117	java/lang/Throwable
          //   6	24	129	finally
          //   24	49	144	finally
          //   53	65	144	finally
          //   65	95	144	finally
          //   95	108	144	finally
          //   24	49	148	java/lang/Throwable
          //   53	65	148	java/lang/Throwable
          //   65	95	148	java/lang/Throwable
          //   95	108	148	java/lang/Throwable
        }
      }.start();
      return;
      localObject1 = null;
    }
  }
  
  public final void b()
  {
    if (this.f.decrementAndGet() == 0)
    {
      if (Build.VERSION.SDK_INT < 11)
      {
        Iterator localIterator = b.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            localBitmap.recycle();
          }
        }
      }
      b.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.d.a.a
 * JD-Core Version:    0.7.0.1
 */