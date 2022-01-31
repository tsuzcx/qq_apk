package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class co
  extends cn
{
  private static final String c = "fc4." + ct.b(co.class.getName()).substring(0, 8);
  private Context d = null;
  private final File e;
  private boolean f;
  private cj g = null;
  private Handler h;
  private boolean i = false;
  private long j = 102400L;
  private long k = 1800000L;
  private int l = 1;
  private int m = 25600;
  private long n = 104857600L;
  private long o = 10485760L;
  private long p = 259200000L;
  private long q = 2592000000L;
  private long r = 0L;
  private volatile List<ck> s;
  private volatile List<ScanResult> t;
  private volatile Location u;
  private BroadcastReceiver v = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent == null) || (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramAnonymousIntent.getAction()))) {}
      for (;;)
      {
        return;
        try
        {
          if (!paramAnonymousIntent.getBooleanExtra("noConnectivity", false))
          {
            co.a(co.this);
            return;
          }
        }
        catch (Throwable paramAnonymousContext) {}
      }
    }
  };
  
  private co(Context paramContext, File paramFile)
  {
    this.d = paramContext;
    this.e = paramFile;
    this.i = false;
    this.f = false;
  }
  
  public co(Context paramContext, String paramString)
  {
    this(paramContext, new File(paramString + "/f_c"));
  }
  
  private static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return Math.max(paramLong2, Math.min(paramLong1, paramLong3));
  }
  
  private void a(int paramInt)
  {
    if (this.h != null) {
      this.h.obtainMessage(paramInt).sendToTarget();
    }
  }
  
  private void a(long paramLong)
  {
    if (this.h != null)
    {
      if (paramLong == 0L) {
        a(7);
      }
    }
    else {
      return;
    }
    Message localMessage = this.h.obtainMessage(7);
    this.h.sendMessageDelayed(localMessage, paramLong);
  }
  
  private boolean e()
  {
    return (this.f) && (this.h != null);
  }
  
  public final void a(Location paramLocation, List<ScanResult> paramList, List<ck> paramList1)
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramLocation != null)
        {
          long l2 = paramLocation.getTime();
          if (l1 - l2 <= 10000L) {}
        }
        else
        {
          return;
        }
        this.u = paramLocation;
        this.t = paramList;
        this.s = paramList1;
        if (!e()) {
          continue;
        }
        if (paramList == null)
        {
          if (f.a.a(paramList1)) {
            continue;
          }
          a(2);
          continue;
        }
        if (f.a.a(paramList)) {
          continue;
        }
      }
      finally {}
      a(1);
    }
  }
  
  public final void a(Looper paramLooper)
  {
    this.s = null;
    this.t = null;
    this.u = null;
    this.r = 0L;
    if ((this.e != null) && ((this.e.exists()) || (this.e.mkdirs()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      cl.a("DC_Pro", "startup! prepared:" + this.f);
      if (this.f)
      {
        this.h = new a(paramLooper);
        this.r = (System.currentTimeMillis() - 10000L);
        a(300000L);
      }
      try
      {
        paramLooper = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.d.registerReceiver(this.v, paramLooper);
        return;
      }
      catch (Throwable paramLooper)
      {
        cl.a("DC_Pro", "listenNetworkState: failed", paramLooper);
      }
    }
  }
  
  public final void a(cj paramcj)
  {
    this.g = paramcj;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ("D_UP_NET".equals(paramString1)) {
      if ("m".equals(paramString2.toLowerCase())) {
        this.i = true;
      }
    }
    do
    {
      do
      {
        return;
      } while (!"w".equals(paramString2.toLowerCase()));
      this.i = false;
      return;
      if ("D_UP_INTERVAL".equals(paramString1))
      {
        this.k = Math.max(900000L, Long.parseLong(paramString2));
        return;
      }
      if ("D_MAX_1F_SIZE".equals(paramString1))
      {
        this.j = a(Long.parseLong(paramString2), 20480L, 512000L);
        return;
      }
      if ("D_NUM_UP".equals(paramString1))
      {
        this.l = ((int)a(Long.parseLong(paramString2), 1L, 5L));
        return;
      }
      if ("D_MAX_BUF_WF".equals(paramString1))
      {
        this.m = ((int)a(Long.parseLong(paramString2), 5120L, 51200L));
        return;
      }
      if ("D_MAX_FOLDER_SIZE".equals(paramString1))
      {
        this.n = a(Long.parseLong(paramString2), 10240L, 209715200L);
        return;
      }
      if ("D_MAX_SIZE_UP_1DAY".equals(paramString1))
      {
        this.o = Math.max(Long.parseLong(paramString2), 0L);
        return;
      }
      if ("D_MAX_DAY_RENAME".equals(paramString1))
      {
        this.p = (a(Long.parseLong(paramString2), 1L, 5L) * 24L * 60L * 60L * 1000L);
        return;
      }
    } while (!"D_MAX_DAY_DELETE".equals(paramString1));
    this.q = (a(Long.parseLong(paramString2), 1L, 30L) * 24L * 60L * 60L * 1000L);
  }
  
  public final void b()
  {
    try
    {
      this.d.unregisterReceiver(this.v);
      label11:
      if (e())
      {
        a(4);
        a(6);
        a(5);
        this.r = 0L;
        a(0L);
        Handler localHandler = this.h;
        this.h.postDelayed(new Runnable()
        {
          public final void run()
          {
            try
            {
              if (co.this != null) {
                co.this.removeCallbacksAndMessages(null);
              }
              return;
            }
            catch (Throwable localThrowable) {}
          }
        }, 200L);
        this.h = null;
      }
      cl.a("DC_Pro", "shutdown!");
      return;
    }
    catch (Throwable localThrowable)
    {
      break label11;
    }
  }
  
  public final boolean c()
  {
    return this.i;
  }
  
  final class a
    extends Handler
  {
    private SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd");
    private Object[] b = new Object[0];
    private File c;
    private BufferedOutputStream d;
    private StringBuffer e;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    private long a()
    {
      if (co.b(co.this)) {}
      for (long l = 51200L; co.c(co.this) > l; l = 512000L) {
        return l;
      }
      return co.c(co.this);
    }
    
    private static void a(int paramInt, File paramFile)
    {
      for (;;)
      {
        try
        {
          if (!paramFile.isFile()) {
            return;
          }
          long l = System.currentTimeMillis();
          File localFile = new File(paramFile.getAbsolutePath() + "." + l + ".enc");
          if (paramInt == 4)
          {
            byte[] arrayOfByte = f.a.a(paramFile);
            if (!f.a.a(arrayOfByte))
            {
              arrayOfByte = ct.a(arrayOfByte);
              if (!f.a.a(arrayOfByte))
              {
                FileOutputStream localFileOutputStream = new FileOutputStream(localFile, true);
                localFileOutputStream.write(arrayOfByte);
                localFileOutputStream.close();
                paramFile.delete();
              }
            }
            cl.a("DC_Pro", "rename:" + paramFile.getName() + " to " + localFile.getName());
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          cl.a("DC_Pro", "rename:" + paramFile.getName() + " error.", localThrowable);
          return;
        }
        paramFile.renameTo(localThrowable);
      }
    }
    
    private void a(long paramLong1, long paramLong2)
    {
      File[] arrayOfFile;
      if (co.e(co.this) == null)
      {
        arrayOfFile = null;
        if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
          break label40;
        }
      }
      label40:
      long l2;
      Object localObject1;
      label206:
      do
      {
        return;
        arrayOfFile = co.e(co.this).listFiles();
        break;
        long l3 = System.currentTimeMillis();
        l2 = 0L;
        int j = arrayOfFile.length;
        int i = 0;
        localObject1 = null;
        if (i < j)
        {
          File localFile = arrayOfFile[i];
          Object localObject2 = localObject1;
          long l1 = l2;
          if (localFile.exists())
          {
            localObject2 = localObject1;
            l1 = l2;
            if (localFile.isFile())
            {
              localObject2 = localObject1;
              l1 = l2;
              if (!co.d().equals(localFile.getName()))
              {
                if ((l3 - localFile.lastModified() <= paramLong1) && (localFile.length() != 0L)) {
                  break label206;
                }
                cl.a("DC_Pro", "delete expired file:" + localFile.getName());
                localFile.delete();
                l1 = l2;
                localObject2 = localObject1;
              }
            }
          }
          for (;;)
          {
            i += 1;
            localObject1 = localObject2;
            l2 = l1;
            break;
            localObject2 = localFile.getName();
            if ((l3 - localFile.lastModified() > 172800000L) && (!((String)localObject2).endsWith(".enc")) && (((String)localObject2).startsWith("fc4.")))
            {
              a(f.a.f((String)localObject2), localFile);
              localObject2 = localObject1;
              l1 = l2;
            }
            else
            {
              l2 += localFile.length();
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                l1 = l2;
                if (localObject1.lastModified() <= localFile.lastModified()) {}
              }
              else
              {
                localObject2 = localFile;
                l1 = l2;
              }
            }
          }
        }
      } while ((l2 < paramLong2) || (localObject1 == null));
      cl.a("DC_Pro", "too big folder size:" + l2 + ", delete " + localObject1.getName() + ",size:" + localObject1.length());
      localObject1.delete();
    }
    
    private boolean a(long paramLong)
    {
      try
      {
        Object localObject = PreferenceManager.getDefaultSharedPreferences(co.r(co.this));
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
        String str = ((SharedPreferences)localObject).getString("log_up_fc_date", "");
        long l = ((SharedPreferences)localObject).getLong("log_up_fc_size", 0L);
        localObject = this.a.format(new Date());
        if (((String)localObject).equals(str))
        {
          if (l > co.s(co.this)) {
            return false;
          }
          localEditor.putLong("log_up_fc_size", paramLong + l);
        }
        for (;;)
        {
          localEditor.apply();
          break;
          localEditor.putString("log_up_fc_date", (String)localObject);
          localEditor.putLong("log_up_fc_size", paramLong);
        }
        return true;
      }
      catch (Throwable localThrowable) {}
    }
    
    private boolean a(String paramString)
    {
      Object localObject;
      File[] arrayOfFile;
      if (TextUtils.isEmpty(paramString))
      {
        localObject = null;
        if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isDirectory())) {
          break label80;
        }
        arrayOfFile = null;
        label34:
        if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
          break label90;
        }
        if ((arrayOfFile != null) && (paramString.endsWith("d_c"))) {
          ((File)localObject).delete();
        }
      }
      label80:
      label90:
      int m;
      label152:
      label246:
      do
      {
        return false;
        localObject = new File(paramString);
        break;
        arrayOfFile = ((File)localObject).listFiles();
        break label34;
        long l = System.currentTimeMillis();
        m = co.k(co.this);
        int k = 0;
        if ((k < arrayOfFile.length) && (m > 0))
        {
          File localFile = arrayOfFile[k];
          int j;
          if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile()))
          {
            localObject = "";
            if (!((String)localObject).startsWith("dc"))
            {
              j = m;
              if (!((String)localObject).startsWith("fc")) {}
            }
            else
            {
              if ((!paramString.endsWith("d_c")) || ((localFile.length() != 0L) && (l - localFile.lastModified() <= co.f(co.this)))) {
                break label246;
              }
              localFile.delete();
              j = m;
            }
          }
          int i;
          do
          {
            do
            {
              do
              {
                k += 1;
                m = j;
                break;
                localObject = localFile.getName();
                break label152;
                if ((!((String)localObject).startsWith("fc2")) && (!((String)localObject).startsWith("fc3"))) {
                  break label534;
                }
                i = 1;
                if (((!((String)localObject).startsWith("fc4.")) || (!((String)localObject).endsWith(".enc"))) && (i == 0)) {
                  break label539;
                }
                j = 1;
                i = j;
                if (j == 0)
                {
                  cl.a("DC_Pro", paramString + ",has no fc4.***.enc files!!!");
                  if ((!((String)localObject).startsWith("dc")) || (System.currentTimeMillis() - localFile.lastModified() <= 172800000L)) {
                    break label544;
                  }
                  i = 1;
                }
                j = m;
              } while (i == 0);
              j = m;
            } while (!a(localFile.length()));
            cl.a("DC_Pro", "upload:" + localFile.getName() + ",len=" + localFile.length());
            i = f.a.f((String)localObject);
            j = m;
          } while (i <= 0);
          localObject = "http://analytics.map.qq.com/?sf";
          if (i > 1) {
            localObject = "http://analytics.map.qq.com/?sf" + i;
          }
          for (;;)
          {
            j = m;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            localObject = new cp(localFile.getAbsolutePath(), (String)localObject);
            if (!((cp)localObject).c)
            {
              ((cp)localObject).c = true;
              new Thread(new cp.1((cp)localObject), "th_upload_fc").start();
            }
            j = m - 1;
            break;
            i = 0;
            break label270;
            j = 0;
            break label296;
            i = 0;
            break label356;
            if (i != 1) {
              localObject = "";
            }
          }
        }
      } while (m == co.k(co.this));
      label270:
      label296:
      label356:
      return true;
    }
    
    private void b()
    {
      if ((this.e == null) || (this.e.length() == 0) || (this.d == null)) {
        return;
      }
      byte[] arrayOfByte = ct.a(this.e.toString());
      StringBuilder localStringBuilder = new StringBuilder("write buf to file:buf:").append(this.e.length()).append(",enc:");
      if (arrayOfByte == null) {}
      for (int i = 0;; i = arrayOfByte.length)
      {
        cl.a("DC_Pro", i);
        this.e.setLength(0);
        if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
          break;
        }
        cl.a("DC_Pro", "enc result is null or len = 0");
        return;
      }
      try
      {
        this.d.write(arrayOfByte);
        this.d.write(36);
        return;
      }
      catch (Throwable localThrowable)
      {
        cl.a("DC_Pro", "write file failed.", localThrowable);
        this.c = null;
        f.a.a(this.d);
      }
    }
    
    private void b(long paramLong)
    {
      try
      {
        PreferenceManager.getDefaultSharedPreferences(co.r(co.this)).edit().putLong("log_fc_create", paramLong).apply();
        return;
      }
      catch (Throwable localThrowable) {}
    }
    
    private void c()
    {
      try
      {
        if (this.d != null) {
          this.d.flush();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        this.c = null;
        f.a.a(this.d);
      }
    }
    
    private void d()
    {
      if ((this.c == null) || (!this.c.exists()) || (this.d == null) || (!co.d().equals(this.c.getName())))
      {
        File localFile = co.e(co.this);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        this.c = new File(localFile, co.d());
      }
      try
      {
        boolean bool = this.c.exists();
        this.d = new BufferedOutputStream(new FileOutputStream(this.c, true), 1024);
        if (!bool) {
          b(System.currentTimeMillis());
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        cl.a("DC_Pro", "open file error", localThrowable);
      }
    }
    
    private long e()
    {
      try
      {
        long l = PreferenceManager.getDefaultSharedPreferences(co.r(co.this)).getLong("log_fc_create", 0L);
        return l;
      }
      catch (Throwable localThrowable) {}
      return 0L;
    }
    
    /* Error */
    public final void handleMessage(Message paramMessage)
    {
      // Byte code:
      //   0: aload_1
      //   1: getfield 365	android/os/Message:what	I
      //   4: tableswitch	default:+770 -> 774, 1:+44->48, 2:+44->48, 3:+351->355, 4:+403->407, 5:+424->428, 6:+560->564, 7:+742->746
      //   49: getfield 38	c/t/m/g/co$a:b	[Ljava/lang/Object;
      //   52: astore 5
      //   54: aload 5
      //   56: monitorenter
      //   57: aload_1
      //   58: getfield 365	android/os/Message:what	I
      //   61: istore_2
      //   62: aload_0
      //   63: invokespecial 367	c/t/m/g/co$a:d	()V
      //   66: ldc 210
      //   68: astore 4
      //   70: iload_2
      //   71: iconst_2
      //   72: if_icmpne +66 -> 138
      //   75: aload_0
      //   76: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   79: invokestatic 371	c/t/m/g/co:l	(Lc/t/m/g/co;)Lc/t/m/g/cj;
      //   82: aload_0
      //   83: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   86: invokestatic 375	c/t/m/g/co:m	(Lc/t/m/g/co;)Landroid/location/Location;
      //   89: aconst_null
      //   90: aload_0
      //   91: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   94: invokestatic 379	c/t/m/g/co:n	(Lc/t/m/g/co;)Ljava/util/List;
      //   97: invokestatic 384	c/t/m/g/cq:a	(Lc/t/m/g/cj;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
      //   100: astore_1
      //   101: aload_0
      //   102: getfield 312	c/t/m/g/co$a:d	Ljava/io/BufferedOutputStream;
      //   105: ifnull +12 -> 117
      //   108: aload_1
      //   109: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   112: istore_3
      //   113: iload_3
      //   114: ifeq +82 -> 196
      //   117: aload 5
      //   119: monitorexit
      //   120: return
      //   121: astore_1
      //   122: aload 5
      //   124: monitorexit
      //   125: aload_1
      //   126: athrow
      //   127: astore_1
      //   128: ldc 118
      //   130: ldc_w 386
      //   133: aload_1
      //   134: invokestatic 136	c/t/m/g/cl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   137: return
      //   138: aload 4
      //   140: astore_1
      //   141: iload_2
      //   142: iconst_1
      //   143: if_icmpne -42 -> 101
      //   146: aload_0
      //   147: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   150: invokestatic 389	c/t/m/g/co:o	(Lc/t/m/g/co;)Ljava/util/List;
      //   153: astore 6
      //   155: aload 4
      //   157: astore_1
      //   158: aload 6
      //   160: invokestatic 392	c/t/m/g/f$a:a	(Ljava/util/List;)Z
      //   163: ifne -62 -> 101
      //   166: aload_0
      //   167: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   170: invokestatic 371	c/t/m/g/co:l	(Lc/t/m/g/co;)Lc/t/m/g/cj;
      //   173: aload_0
      //   174: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   177: invokestatic 375	c/t/m/g/co:m	(Lc/t/m/g/co;)Landroid/location/Location;
      //   180: aload 6
      //   182: aload_0
      //   183: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   186: invokestatic 379	c/t/m/g/co:n	(Lc/t/m/g/co;)Ljava/util/List;
      //   189: invokestatic 384	c/t/m/g/cq:a	(Lc/t/m/g/cj;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
      //   192: astore_1
      //   193: goto -92 -> 101
      //   196: aload_0
      //   197: getfield 305	c/t/m/g/co$a:e	Ljava/lang/StringBuffer;
      //   200: ifnonnull +21 -> 221
      //   203: aload_0
      //   204: new 307	java/lang/StringBuffer
      //   207: dup
      //   208: aload_0
      //   209: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   212: invokestatic 395	c/t/m/g/co:p	(Lc/t/m/g/co;)I
      //   215: invokespecial 397	java/lang/StringBuffer:<init>	(I)V
      //   218: putfield 305	c/t/m/g/co$a:e	Ljava/lang/StringBuffer;
      //   221: aload_0
      //   222: getfield 305	c/t/m/g/co$a:e	Ljava/lang/StringBuffer;
      //   225: aload_1
      //   226: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   229: ldc_w 402
      //   232: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   235: pop
      //   236: aload_0
      //   237: getfield 305	c/t/m/g/co$a:e	Ljava/lang/StringBuffer;
      //   240: invokevirtual 310	java/lang/StringBuffer:length	()I
      //   243: aload_0
      //   244: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   247: invokestatic 395	c/t/m/g/co:p	(Lc/t/m/g/co;)I
      //   250: if_icmpgt +22 -> 272
      //   253: aload_0
      //   254: getfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   257: ifnull +41 -> 298
      //   260: aload_0
      //   261: getfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   264: invokevirtual 165	java/io/File:length	()J
      //   267: lconst_0
      //   268: lcmp
      //   269: ifne +29 -> 298
      //   272: aload_0
      //   273: invokespecial 404	c/t/m/g/co$a:b	()V
      //   276: aload_0
      //   277: getfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   280: invokevirtual 165	java/io/File:length	()J
      //   283: aload_0
      //   284: invokespecial 406	c/t/m/g/co$a:a	()J
      //   287: lcmp
      //   288: ifle +10 -> 298
      //   291: aload_0
      //   292: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   295: invokestatic 410	c/t/m/g/co:q	(Lc/t/m/g/co;)V
      //   298: ldc 118
      //   300: new 66	java/lang/StringBuilder
      //   303: dup
      //   304: ldc_w 412
      //   307: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   310: aload_1
      //   311: iconst_0
      //   312: bipush 60
      //   314: invokevirtual 416	java/lang/String:substring	(II)Ljava/lang/String;
      //   317: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   320: ldc_w 418
      //   323: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   326: aload_1
      //   327: invokevirtual 419	java/lang/String:length	()I
      //   330: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   333: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   336: invokestatic 131	c/t/m/g/cl:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   339: goto -222 -> 117
      //   342: astore_1
      //   343: ldc 118
      //   345: ldc_w 421
      //   348: aload_1
      //   349: invokestatic 136	c/t/m/g/cl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   352: goto -235 -> 117
      //   355: ldc 118
      //   357: ldc_w 423
      //   360: invokestatic 131	c/t/m/g/cl:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   363: aload_0
      //   364: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   367: invokestatic 425	c/t/m/g/co:d	(Lc/t/m/g/co;)Z
      //   370: ifeq +404 -> 774
      //   373: aload_0
      //   374: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   377: invokestatic 144	c/t/m/g/co:e	(Lc/t/m/g/co;)Ljava/io/File;
      //   380: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   383: astore_1
      //   384: aload_0
      //   385: aload_1
      //   386: invokespecial 427	c/t/m/g/co$a:a	(Ljava/lang/String;)Z
      //   389: ifne +385 -> 774
      //   392: aload_0
      //   393: aload_1
      //   394: ldc_w 429
      //   397: ldc 254
      //   399: invokevirtual 432	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   402: invokespecial 427	c/t/m/g/co$a:a	(Ljava/lang/String;)Z
      //   405: pop
      //   406: return
      //   407: aload_0
      //   408: getfield 38	c/t/m/g/co$a:b	[Ljava/lang/Object;
      //   411: astore_1
      //   412: aload_1
      //   413: monitorenter
      //   414: aload_0
      //   415: invokespecial 434	c/t/m/g/co$a:c	()V
      //   418: aload_1
      //   419: monitorexit
      //   420: return
      //   421: astore 4
      //   423: aload_1
      //   424: monitorexit
      //   425: aload 4
      //   427: athrow
      //   428: aload_0
      //   429: getfield 38	c/t/m/g/co$a:b	[Ljava/lang/Object;
      //   432: astore_1
      //   433: aload_1
      //   434: monitorenter
      //   435: aload_0
      //   436: invokespecial 404	c/t/m/g/co$a:b	()V
      //   439: aload_0
      //   440: getfield 305	c/t/m/g/co$a:e	Ljava/lang/StringBuffer;
      //   443: ifnull +11 -> 454
      //   446: aload_0
      //   447: getfield 305	c/t/m/g/co$a:e	Ljava/lang/StringBuffer;
      //   450: iconst_0
      //   451: invokevirtual 324	java/lang/StringBuffer:setLength	(I)V
      //   454: aload_0
      //   455: aconst_null
      //   456: putfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   459: aload_0
      //   460: getfield 312	c/t/m/g/co$a:d	Ljava/io/BufferedOutputStream;
      //   463: invokestatic 338	c/t/m/g/f$a:a	(Ljava/io/Closeable;)V
      //   466: aload_0
      //   467: aload_0
      //   468: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   471: invokestatic 264	c/t/m/g/co:f	(Lc/t/m/g/co;)J
      //   474: aload_0
      //   475: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   478: invokestatic 437	c/t/m/g/co:g	(Lc/t/m/g/co;)J
      //   481: invokespecial 439	c/t/m/g/co$a:a	(JJ)V
      //   484: aload_1
      //   485: monitorexit
      //   486: return
      //   487: astore 4
      //   489: aload_1
      //   490: monitorexit
      //   491: aload 4
      //   493: athrow
      //   494: astore 4
      //   496: aload_0
      //   497: aconst_null
      //   498: putfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   501: aload_0
      //   502: getfield 312	c/t/m/g/co$a:d	Ljava/io/BufferedOutputStream;
      //   505: invokestatic 338	c/t/m/g/f$a:a	(Ljava/io/Closeable;)V
      //   508: aload_0
      //   509: aload_0
      //   510: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   513: invokestatic 264	c/t/m/g/co:f	(Lc/t/m/g/co;)J
      //   516: aload_0
      //   517: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   520: invokestatic 437	c/t/m/g/co:g	(Lc/t/m/g/co;)J
      //   523: invokespecial 439	c/t/m/g/co$a:a	(JJ)V
      //   526: goto -42 -> 484
      //   529: astore 4
      //   531: aload_0
      //   532: aconst_null
      //   533: putfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   536: aload_0
      //   537: getfield 312	c/t/m/g/co$a:d	Ljava/io/BufferedOutputStream;
      //   540: invokestatic 338	c/t/m/g/f$a:a	(Ljava/io/Closeable;)V
      //   543: aload_0
      //   544: aload_0
      //   545: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   548: invokestatic 264	c/t/m/g/co:f	(Lc/t/m/g/co;)J
      //   551: aload_0
      //   552: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   555: invokestatic 437	c/t/m/g/co:g	(Lc/t/m/g/co;)J
      //   558: invokespecial 439	c/t/m/g/co$a:a	(JJ)V
      //   561: aload 4
      //   563: athrow
      //   564: aload_0
      //   565: getfield 38	c/t/m/g/co$a:b	[Ljava/lang/Object;
      //   568: astore_1
      //   569: aload_1
      //   570: monitorenter
      //   571: aload_0
      //   572: invokespecial 367	c/t/m/g/co$a:d	()V
      //   575: aload_0
      //   576: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   579: invokestatic 144	c/t/m/g/co:e	(Lc/t/m/g/co;)Ljava/io/File;
      //   582: ifnull +20 -> 602
      //   585: aload_0
      //   586: getfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   589: ifnull +13 -> 602
      //   592: aload_0
      //   593: getfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   596: invokevirtual 151	java/io/File:exists	()Z
      //   599: ifne +13 -> 612
      //   602: aload_1
      //   603: monitorexit
      //   604: return
      //   605: astore 4
      //   607: aload_1
      //   608: monitorexit
      //   609: aload 4
      //   611: athrow
      //   612: aload_0
      //   613: invokespecial 404	c/t/m/g/co$a:b	()V
      //   616: aload_0
      //   617: getfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   620: invokevirtual 165	java/io/File:length	()J
      //   623: aload_0
      //   624: invokespecial 406	c/t/m/g/co$a:a	()J
      //   627: lcmp
      //   628: ifgt +22 -> 650
      //   631: invokestatic 64	java/lang/System:currentTimeMillis	()J
      //   634: aload_0
      //   635: invokespecial 441	c/t/m/g/co$a:e	()J
      //   638: lsub
      //   639: aload_0
      //   640: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   643: invokestatic 444	c/t/m/g/co:h	(Lc/t/m/g/co;)J
      //   646: lcmp
      //   647: ifle +63 -> 710
      //   650: aload_0
      //   651: invokespecial 434	c/t/m/g/co$a:c	()V
      //   654: aload_0
      //   655: getfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   658: ifnull +17 -> 675
      //   661: aload_0
      //   662: getfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   665: invokevirtual 165	java/io/File:length	()J
      //   668: ldc2_w 445
      //   671: lcmp
      //   672: ifge +41 -> 713
      //   675: aload_0
      //   676: aload_0
      //   677: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   680: invokestatic 264	c/t/m/g/co:f	(Lc/t/m/g/co;)J
      //   683: aload_0
      //   684: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   687: invokestatic 437	c/t/m/g/co:g	(Lc/t/m/g/co;)J
      //   690: invokespecial 439	c/t/m/g/co$a:a	(JJ)V
      //   693: aload_0
      //   694: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   697: invokevirtual 448	c/t/m/g/co:c	()Z
      //   700: ifeq +10 -> 710
      //   703: aload_0
      //   704: bipush 7
      //   706: invokevirtual 452	c/t/m/g/co$a:sendEmptyMessage	(I)Z
      //   709: pop
      //   710: aload_1
      //   711: monitorexit
      //   712: return
      //   713: aload_0
      //   714: getfield 312	c/t/m/g/co$a:d	Ljava/io/BufferedOutputStream;
      //   717: invokestatic 338	c/t/m/g/f$a:a	(Ljava/io/Closeable;)V
      //   720: aload_0
      //   721: aconst_null
      //   722: putfield 312	c/t/m/g/co$a:d	Ljava/io/BufferedOutputStream;
      //   725: iconst_4
      //   726: aload_0
      //   727: getfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   730: invokestatic 183	c/t/m/g/co$a:a	(ILjava/io/File;)V
      //   733: aload_0
      //   734: aconst_null
      //   735: putfield 335	c/t/m/g/co$a:c	Ljava/io/File;
      //   738: aload_0
      //   739: lconst_0
      //   740: invokespecial 355	c/t/m/g/co$a:b	(J)V
      //   743: goto -68 -> 675
      //   746: aload_0
      //   747: bipush 7
      //   749: invokevirtual 455	c/t/m/g/co$a:removeMessages	(I)V
      //   752: aload_0
      //   753: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   756: invokestatic 458	c/t/m/g/co:i	(Lc/t/m/g/co;)V
      //   759: aload_0
      //   760: bipush 7
      //   762: aload_0
      //   763: getfield 22	c/t/m/g/co$a:f	Lc/t/m/g/co;
      //   766: invokestatic 461	c/t/m/g/co:j	(Lc/t/m/g/co;)J
      //   769: invokevirtual 465	c/t/m/g/co$a:sendEmptyMessageDelayed	(IJ)Z
      //   772: pop
      //   773: return
      //   774: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	775	0	this	a
      //   0	775	1	paramMessage	Message
      //   61	83	2	i	int
      //   112	2	3	bool	boolean
      //   68	88	4	str	String
      //   421	5	4	localObject1	Object
      //   487	5	4	localObject2	Object
      //   494	1	4	localThrowable	Throwable
      //   529	33	4	localObject3	Object
      //   605	5	4	localObject4	Object
      //   52	71	5	arrayOfObject	Object[]
      //   153	28	6	localList	List
      // Exception table:
      //   from	to	target	type
      //   57	66	121	finally
      //   75	101	121	finally
      //   101	113	121	finally
      //   117	120	121	finally
      //   146	155	121	finally
      //   158	193	121	finally
      //   196	221	121	finally
      //   221	272	121	finally
      //   272	298	121	finally
      //   298	339	121	finally
      //   343	352	121	finally
      //   0	48	127	java/lang/Throwable
      //   48	57	127	java/lang/Throwable
      //   122	127	127	java/lang/Throwable
      //   355	406	127	java/lang/Throwable
      //   407	414	127	java/lang/Throwable
      //   423	428	127	java/lang/Throwable
      //   428	435	127	java/lang/Throwable
      //   489	494	127	java/lang/Throwable
      //   564	571	127	java/lang/Throwable
      //   607	612	127	java/lang/Throwable
      //   746	773	127	java/lang/Throwable
      //   57	66	342	java/lang/Throwable
      //   75	101	342	java/lang/Throwable
      //   101	113	342	java/lang/Throwable
      //   146	155	342	java/lang/Throwable
      //   158	193	342	java/lang/Throwable
      //   196	221	342	java/lang/Throwable
      //   221	272	342	java/lang/Throwable
      //   272	298	342	java/lang/Throwable
      //   298	339	342	java/lang/Throwable
      //   414	420	421	finally
      //   454	484	487	finally
      //   484	486	487	finally
      //   496	526	487	finally
      //   531	564	487	finally
      //   435	454	494	java/lang/Throwable
      //   435	454	529	finally
      //   571	602	605	finally
      //   602	604	605	finally
      //   612	650	605	finally
      //   650	675	605	finally
      //   675	710	605	finally
      //   710	712	605	finally
      //   713	743	605	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.co
 * JD-Core Version:    0.7.0.1
 */