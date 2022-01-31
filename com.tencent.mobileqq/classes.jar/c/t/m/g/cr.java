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

public class cr
  extends cq
{
  private static final String m = "fc4." + cx.b(cr.class.getName()).substring(0, 8);
  public cv c = null;
  public boolean d = false;
  public long e = 102400L;
  public long f = 1800000L;
  public int g = 1;
  public int h = 25600;
  public long i = 104857600L;
  public long j = 10485760L;
  public long k = 259200000L;
  public long l = 2592000000L;
  private Context n = null;
  private final File o;
  private boolean p;
  private Handler q;
  private long r = 0L;
  private volatile List<cw> s;
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
            cr.a(cr.this);
            return;
          }
        }
        catch (Throwable paramAnonymousContext) {}
      }
    }
  };
  
  private cr(Context paramContext, File paramFile)
  {
    this.n = paramContext;
    this.o = paramFile;
    this.d = false;
    this.p = false;
  }
  
  public cr(Context paramContext, String paramString)
  {
    this(paramContext, new File(paramString + "/f_c"));
  }
  
  public static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return Math.max(paramLong2, Math.min(paramLong1, paramLong3));
  }
  
  private void a(int paramInt)
  {
    if (this.q != null) {
      this.q.obtainMessage(paramInt).sendToTarget();
    }
  }
  
  private void a(long paramLong)
  {
    if (this.q != null)
    {
      if (paramLong == 0L) {
        a(7);
      }
    }
    else {
      return;
    }
    Message localMessage = this.q.obtainMessage(7);
    this.q.sendMessageDelayed(localMessage, paramLong);
  }
  
  private boolean d()
  {
    return (this.p) && (this.q != null);
  }
  
  public final void a(Location paramLocation, List<ScanResult> paramList, List<cw> paramList1)
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
        if (!d()) {
          continue;
        }
        if (paramList == null)
        {
          if (co.b(paramList1)) {
            continue;
          }
          a(2);
          continue;
        }
        if (co.b(paramList)) {
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
    if ((this.o != null) && ((this.o.exists()) || (this.o.mkdirs()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.p = bool;
      cp.a("DC_Pro", "startup! prepared:" + this.p);
      if (this.p)
      {
        this.q = new a(paramLooper);
        this.r = (System.currentTimeMillis() - 10000L);
        a(300000L);
      }
      try
      {
        paramLooper = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.n.registerReceiver(this.v, paramLooper);
        return;
      }
      catch (Throwable paramLooper)
      {
        cp.a("DC_Pro", "listenNetworkState: failed", paramLooper);
      }
    }
  }
  
  public final void b()
  {
    try
    {
      this.n.unregisterReceiver(this.v);
      label11:
      if (d())
      {
        a(4);
        a(6);
        a(5);
        this.r = 0L;
        a(0L);
        final Handler localHandler = this.q;
        this.q.postDelayed(new Runnable()
        {
          public final void run()
          {
            try
            {
              if (localHandler != null) {
                localHandler.removeCallbacksAndMessages(null);
              }
              return;
            }
            catch (Throwable localThrowable) {}
          }
        }, 200L);
        this.q = null;
      }
      cp.a("DC_Pro", "shutdown!");
      return;
    }
    catch (Throwable localThrowable)
    {
      break label11;
    }
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
      if (cr.b(cr.this)) {}
      for (long l = 51200L; cr.c(cr.this) > l; l = 512000L) {
        return l;
      }
      return cr.c(cr.this);
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
            byte[] arrayOfByte = co.a(paramFile);
            if (!co.a(arrayOfByte))
            {
              arrayOfByte = cx.a(arrayOfByte);
              if (!co.a(arrayOfByte))
              {
                FileOutputStream localFileOutputStream = new FileOutputStream(localFile, true);
                localFileOutputStream.write(arrayOfByte);
                localFileOutputStream.close();
                paramFile.delete();
              }
            }
            cp.a("DC_Pro", "rename:" + paramFile.getName() + " to " + localFile.getName());
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          cp.a("DC_Pro", "rename:" + paramFile.getName() + " error.", localThrowable);
          return;
        }
        paramFile.renameTo(localThrowable);
      }
    }
    
    private void a(long paramLong1, long paramLong2)
    {
      File[] arrayOfFile;
      if (cr.e(cr.this) == null)
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
        arrayOfFile = cr.e(cr.this).listFiles();
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
              if (!cr.c().equals(localFile.getName()))
              {
                if ((l3 - localFile.lastModified() <= paramLong1) && (localFile.length() != 0L)) {
                  break label206;
                }
                cp.a("DC_Pro", "delete expired file:" + localFile.getName());
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
              a(co.a((String)localObject2), localFile);
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
      cp.a("DC_Pro", "too big folder size:" + l2 + ", delete " + localObject1.getName() + ",size:" + localObject1.length());
      localObject1.delete();
    }
    
    /* Error */
    private void a(Message paramMessage)
    {
      // Byte code:
      //   0: aload_1
      //   1: getfield 196	android/os/Message:what	I
      //   4: tableswitch	default:+44 -> 48, 1:+45->49, 2:+45->49, 3:+340->344, 4:+393->397, 5:+414->418, 6:+550->554, 7:+732->736
      //   49: aload_0
      //   50: getfield 38	c/t/m/g/cr$a:b	[Ljava/lang/Object;
      //   53: astore 5
      //   55: aload 5
      //   57: monitorenter
      //   58: aload_1
      //   59: getfield 196	android/os/Message:what	I
      //   62: istore_2
      //   63: aload_0
      //   64: invokespecial 198	c/t/m/g/cr$a:d	()V
      //   67: ldc 200
      //   69: astore 4
      //   71: iload_2
      //   72: iconst_2
      //   73: if_icmpne +55 -> 128
      //   76: aload_0
      //   77: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   80: invokestatic 204	c/t/m/g/cr:l	(Lc/t/m/g/cr;)Lc/t/m/g/cv;
      //   83: aload_0
      //   84: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   87: invokestatic 208	c/t/m/g/cr:m	(Lc/t/m/g/cr;)Landroid/location/Location;
      //   90: aconst_null
      //   91: aload_0
      //   92: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   95: invokestatic 212	c/t/m/g/cr:n	(Lc/t/m/g/cr;)Ljava/util/List;
      //   98: invokestatic 217	c/t/m/g/ct:a	(Lc/t/m/g/cv;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
      //   101: astore_1
      //   102: aload_0
      //   103: getfield 219	c/t/m/g/cr$a:d	Ljava/io/BufferedOutputStream;
      //   106: ifnull +12 -> 118
      //   109: aload_1
      //   110: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   113: istore_3
      //   114: iload_3
      //   115: ifeq +71 -> 186
      //   118: aload 5
      //   120: monitorexit
      //   121: return
      //   122: astore_1
      //   123: aload 5
      //   125: monitorexit
      //   126: aload_1
      //   127: athrow
      //   128: aload 4
      //   130: astore_1
      //   131: iload_2
      //   132: iconst_1
      //   133: if_icmpne -31 -> 102
      //   136: aload_0
      //   137: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   140: invokestatic 228	c/t/m/g/cr:o	(Lc/t/m/g/cr;)Ljava/util/List;
      //   143: astore 6
      //   145: aload 4
      //   147: astore_1
      //   148: aload 6
      //   150: invokestatic 231	c/t/m/g/co:b	(Ljava/util/List;)Z
      //   153: ifne -51 -> 102
      //   156: aload_0
      //   157: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   160: invokestatic 204	c/t/m/g/cr:l	(Lc/t/m/g/cr;)Lc/t/m/g/cv;
      //   163: aload_0
      //   164: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   167: invokestatic 208	c/t/m/g/cr:m	(Lc/t/m/g/cr;)Landroid/location/Location;
      //   170: aload 6
      //   172: aload_0
      //   173: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   176: invokestatic 212	c/t/m/g/cr:n	(Lc/t/m/g/cr;)Ljava/util/List;
      //   179: invokestatic 217	c/t/m/g/ct:a	(Lc/t/m/g/cv;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
      //   182: astore_1
      //   183: goto -81 -> 102
      //   186: aload_0
      //   187: getfield 233	c/t/m/g/cr$a:e	Ljava/lang/StringBuffer;
      //   190: ifnonnull +21 -> 211
      //   193: aload_0
      //   194: new 235	java/lang/StringBuffer
      //   197: dup
      //   198: aload_0
      //   199: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   202: invokestatic 239	c/t/m/g/cr:p	(Lc/t/m/g/cr;)I
      //   205: invokespecial 242	java/lang/StringBuffer:<init>	(I)V
      //   208: putfield 233	c/t/m/g/cr$a:e	Ljava/lang/StringBuffer;
      //   211: aload_0
      //   212: getfield 233	c/t/m/g/cr$a:e	Ljava/lang/StringBuffer;
      //   215: aload_1
      //   216: invokevirtual 245	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   219: ldc 247
      //   221: invokevirtual 245	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   224: pop
      //   225: aload_0
      //   226: getfield 233	c/t/m/g/cr$a:e	Ljava/lang/StringBuffer;
      //   229: invokevirtual 250	java/lang/StringBuffer:length	()I
      //   232: aload_0
      //   233: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   236: invokestatic 239	c/t/m/g/cr:p	(Lc/t/m/g/cr;)I
      //   239: if_icmpgt +22 -> 261
      //   242: aload_0
      //   243: getfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   246: ifnull +41 -> 287
      //   249: aload_0
      //   250: getfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   253: invokevirtual 165	java/io/File:length	()J
      //   256: lconst_0
      //   257: lcmp
      //   258: ifne +29 -> 287
      //   261: aload_0
      //   262: invokespecial 254	c/t/m/g/cr$a:b	()V
      //   265: aload_0
      //   266: getfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   269: invokevirtual 165	java/io/File:length	()J
      //   272: aload_0
      //   273: invokespecial 256	c/t/m/g/cr$a:a	()J
      //   276: lcmp
      //   277: ifle +10 -> 287
      //   280: aload_0
      //   281: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   284: invokestatic 260	c/t/m/g/cr:q	(Lc/t/m/g/cr;)V
      //   287: ldc 118
      //   289: new 66	java/lang/StringBuilder
      //   292: dup
      //   293: ldc_w 262
      //   296: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   299: aload_1
      //   300: iconst_0
      //   301: bipush 60
      //   303: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
      //   306: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   309: ldc_w 268
      //   312: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   315: aload_1
      //   316: invokevirtual 269	java/lang/String:length	()I
      //   319: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   322: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   325: invokestatic 131	c/t/m/g/cp:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   328: goto -210 -> 118
      //   331: astore_1
      //   332: ldc 118
      //   334: ldc_w 274
      //   337: aload_1
      //   338: invokestatic 136	c/t/m/g/cp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   341: goto -223 -> 118
      //   344: ldc 118
      //   346: ldc_w 276
      //   349: invokestatic 131	c/t/m/g/cp:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   352: aload_0
      //   353: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   356: invokestatic 278	c/t/m/g/cr:d	(Lc/t/m/g/cr;)Z
      //   359: ifeq -311 -> 48
      //   362: aload_0
      //   363: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   366: invokestatic 144	c/t/m/g/cr:e	(Lc/t/m/g/cr;)Ljava/io/File;
      //   369: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   372: astore_1
      //   373: aload_0
      //   374: aload_1
      //   375: invokespecial 280	c/t/m/g/cr$a:a	(Ljava/lang/String;)Z
      //   378: ifne -330 -> 48
      //   381: aload_0
      //   382: aload_1
      //   383: ldc_w 282
      //   386: ldc_w 284
      //   389: invokevirtual 288	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   392: invokespecial 280	c/t/m/g/cr$a:a	(Ljava/lang/String;)Z
      //   395: pop
      //   396: return
      //   397: aload_0
      //   398: getfield 38	c/t/m/g/cr$a:b	[Ljava/lang/Object;
      //   401: astore_1
      //   402: aload_1
      //   403: monitorenter
      //   404: aload_0
      //   405: invokespecial 290	c/t/m/g/cr$a:c	()V
      //   408: aload_1
      //   409: monitorexit
      //   410: return
      //   411: astore 4
      //   413: aload_1
      //   414: monitorexit
      //   415: aload 4
      //   417: athrow
      //   418: aload_0
      //   419: getfield 38	c/t/m/g/cr$a:b	[Ljava/lang/Object;
      //   422: astore_1
      //   423: aload_1
      //   424: monitorenter
      //   425: aload_0
      //   426: invokespecial 254	c/t/m/g/cr$a:b	()V
      //   429: aload_0
      //   430: getfield 233	c/t/m/g/cr$a:e	Ljava/lang/StringBuffer;
      //   433: ifnull +11 -> 444
      //   436: aload_0
      //   437: getfield 233	c/t/m/g/cr$a:e	Ljava/lang/StringBuffer;
      //   440: iconst_0
      //   441: invokevirtual 293	java/lang/StringBuffer:setLength	(I)V
      //   444: aload_0
      //   445: aconst_null
      //   446: putfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   449: aload_0
      //   450: getfield 219	c/t/m/g/cr$a:d	Ljava/io/BufferedOutputStream;
      //   453: invokestatic 296	c/t/m/g/co:a	(Ljava/io/Closeable;)V
      //   456: aload_0
      //   457: aload_0
      //   458: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   461: invokestatic 298	c/t/m/g/cr:f	(Lc/t/m/g/cr;)J
      //   464: aload_0
      //   465: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   468: invokestatic 301	c/t/m/g/cr:g	(Lc/t/m/g/cr;)J
      //   471: invokespecial 303	c/t/m/g/cr$a:a	(JJ)V
      //   474: aload_1
      //   475: monitorexit
      //   476: return
      //   477: astore 4
      //   479: aload_1
      //   480: monitorexit
      //   481: aload 4
      //   483: athrow
      //   484: astore 4
      //   486: aload_0
      //   487: aconst_null
      //   488: putfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   491: aload_0
      //   492: getfield 219	c/t/m/g/cr$a:d	Ljava/io/BufferedOutputStream;
      //   495: invokestatic 296	c/t/m/g/co:a	(Ljava/io/Closeable;)V
      //   498: aload_0
      //   499: aload_0
      //   500: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   503: invokestatic 298	c/t/m/g/cr:f	(Lc/t/m/g/cr;)J
      //   506: aload_0
      //   507: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   510: invokestatic 301	c/t/m/g/cr:g	(Lc/t/m/g/cr;)J
      //   513: invokespecial 303	c/t/m/g/cr$a:a	(JJ)V
      //   516: goto -42 -> 474
      //   519: astore 4
      //   521: aload_0
      //   522: aconst_null
      //   523: putfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   526: aload_0
      //   527: getfield 219	c/t/m/g/cr$a:d	Ljava/io/BufferedOutputStream;
      //   530: invokestatic 296	c/t/m/g/co:a	(Ljava/io/Closeable;)V
      //   533: aload_0
      //   534: aload_0
      //   535: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   538: invokestatic 298	c/t/m/g/cr:f	(Lc/t/m/g/cr;)J
      //   541: aload_0
      //   542: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   545: invokestatic 301	c/t/m/g/cr:g	(Lc/t/m/g/cr;)J
      //   548: invokespecial 303	c/t/m/g/cr$a:a	(JJ)V
      //   551: aload 4
      //   553: athrow
      //   554: aload_0
      //   555: getfield 38	c/t/m/g/cr$a:b	[Ljava/lang/Object;
      //   558: astore_1
      //   559: aload_1
      //   560: monitorenter
      //   561: aload_0
      //   562: invokespecial 198	c/t/m/g/cr$a:d	()V
      //   565: aload_0
      //   566: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   569: invokestatic 144	c/t/m/g/cr:e	(Lc/t/m/g/cr;)Ljava/io/File;
      //   572: ifnull +20 -> 592
      //   575: aload_0
      //   576: getfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   579: ifnull +13 -> 592
      //   582: aload_0
      //   583: getfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   586: invokevirtual 151	java/io/File:exists	()Z
      //   589: ifne +13 -> 602
      //   592: aload_1
      //   593: monitorexit
      //   594: return
      //   595: astore 4
      //   597: aload_1
      //   598: monitorexit
      //   599: aload 4
      //   601: athrow
      //   602: aload_0
      //   603: invokespecial 254	c/t/m/g/cr$a:b	()V
      //   606: aload_0
      //   607: getfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   610: invokevirtual 165	java/io/File:length	()J
      //   613: aload_0
      //   614: invokespecial 256	c/t/m/g/cr$a:a	()J
      //   617: lcmp
      //   618: ifgt +22 -> 640
      //   621: invokestatic 64	java/lang/System:currentTimeMillis	()J
      //   624: aload_0
      //   625: invokespecial 305	c/t/m/g/cr$a:f	()J
      //   628: lsub
      //   629: aload_0
      //   630: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   633: invokestatic 308	c/t/m/g/cr:h	(Lc/t/m/g/cr;)J
      //   636: lcmp
      //   637: ifle +63 -> 700
      //   640: aload_0
      //   641: invokespecial 290	c/t/m/g/cr$a:c	()V
      //   644: aload_0
      //   645: getfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   648: ifnull +17 -> 665
      //   651: aload_0
      //   652: getfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   655: invokevirtual 165	java/io/File:length	()J
      //   658: ldc2_w 309
      //   661: lcmp
      //   662: ifge +41 -> 703
      //   665: aload_0
      //   666: aload_0
      //   667: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   670: invokestatic 298	c/t/m/g/cr:f	(Lc/t/m/g/cr;)J
      //   673: aload_0
      //   674: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   677: invokestatic 301	c/t/m/g/cr:g	(Lc/t/m/g/cr;)J
      //   680: invokespecial 303	c/t/m/g/cr$a:a	(JJ)V
      //   683: aload_0
      //   684: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   687: getfield 313	c/t/m/g/cr:d	Z
      //   690: ifeq +10 -> 700
      //   693: aload_0
      //   694: bipush 7
      //   696: invokevirtual 317	c/t/m/g/cr$a:sendEmptyMessage	(I)Z
      //   699: pop
      //   700: aload_1
      //   701: monitorexit
      //   702: return
      //   703: aload_0
      //   704: getfield 219	c/t/m/g/cr$a:d	Ljava/io/BufferedOutputStream;
      //   707: invokestatic 296	c/t/m/g/co:a	(Ljava/io/Closeable;)V
      //   710: aload_0
      //   711: aconst_null
      //   712: putfield 219	c/t/m/g/cr$a:d	Ljava/io/BufferedOutputStream;
      //   715: iconst_4
      //   716: aload_0
      //   717: getfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   720: invokestatic 183	c/t/m/g/cr$a:a	(ILjava/io/File;)V
      //   723: aload_0
      //   724: aconst_null
      //   725: putfield 252	c/t/m/g/cr$a:c	Ljava/io/File;
      //   728: aload_0
      //   729: lconst_0
      //   730: invokespecial 320	c/t/m/g/cr$a:b	(J)V
      //   733: goto -68 -> 665
      //   736: aload_0
      //   737: bipush 7
      //   739: invokevirtual 323	c/t/m/g/cr$a:removeMessages	(I)V
      //   742: aload_0
      //   743: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   746: invokestatic 326	c/t/m/g/cr:i	(Lc/t/m/g/cr;)V
      //   749: aload_0
      //   750: bipush 7
      //   752: aload_0
      //   753: getfield 22	c/t/m/g/cr$a:f	Lc/t/m/g/cr;
      //   756: invokestatic 329	c/t/m/g/cr:j	(Lc/t/m/g/cr;)J
      //   759: invokevirtual 333	c/t/m/g/cr$a:sendEmptyMessageDelayed	(IJ)Z
      //   762: pop
      //   763: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	764	0	this	a
      //   0	764	1	paramMessage	Message
      //   62	72	2	i	int
      //   113	2	3	bool	boolean
      //   69	77	4	str	String
      //   411	5	4	localObject1	Object
      //   477	5	4	localObject2	Object
      //   484	1	4	localThrowable	Throwable
      //   519	33	4	localObject3	Object
      //   595	5	4	localObject4	Object
      //   53	71	5	arrayOfObject	Object[]
      //   143	28	6	localList	List
      // Exception table:
      //   from	to	target	type
      //   58	67	122	finally
      //   76	102	122	finally
      //   102	114	122	finally
      //   118	121	122	finally
      //   123	126	122	finally
      //   136	145	122	finally
      //   148	183	122	finally
      //   186	211	122	finally
      //   211	261	122	finally
      //   261	287	122	finally
      //   287	328	122	finally
      //   332	341	122	finally
      //   58	67	331	java/lang/Throwable
      //   76	102	331	java/lang/Throwable
      //   102	114	331	java/lang/Throwable
      //   136	145	331	java/lang/Throwable
      //   148	183	331	java/lang/Throwable
      //   186	211	331	java/lang/Throwable
      //   211	261	331	java/lang/Throwable
      //   261	287	331	java/lang/Throwable
      //   287	328	331	java/lang/Throwable
      //   404	410	411	finally
      //   413	415	411	finally
      //   444	474	477	finally
      //   474	476	477	finally
      //   479	481	477	finally
      //   486	516	477	finally
      //   521	554	477	finally
      //   425	444	484	java/lang/Throwable
      //   425	444	519	finally
      //   561	592	595	finally
      //   592	594	595	finally
      //   597	599	595	finally
      //   602	640	595	finally
      //   640	665	595	finally
      //   665	700	595	finally
      //   700	702	595	finally
      //   703	733	595	finally
    }
    
    private boolean a(long paramLong)
    {
      try
      {
        Object localObject = PreferenceManager.getDefaultSharedPreferences(cr.r(cr.this));
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
        String str = ((SharedPreferences)localObject).getString("log_up_fc_date", "");
        long l = ((SharedPreferences)localObject).getLong("log_up_fc_size", 0L);
        localObject = this.a.format(new Date());
        if (((String)localObject).equals(str))
        {
          if (l > cr.s(cr.this)) {
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
          break label81;
        }
        arrayOfFile = null;
        label34:
        if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
          break label91;
        }
        if ((arrayOfFile != null) && (paramString.endsWith("d_c"))) {
          ((File)localObject).delete();
        }
      }
      label81:
      label91:
      int m;
      label153:
      label248:
      do
      {
        return false;
        localObject = new File(paramString);
        break;
        arrayOfFile = ((File)localObject).listFiles();
        break label34;
        long l = System.currentTimeMillis();
        m = cr.k(cr.this);
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
              if ((!paramString.endsWith("d_c")) || ((localFile.length() != 0L) && (l - localFile.lastModified() <= cr.f(cr.this)))) {
                break label248;
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
                break label153;
                if ((!((String)localObject).startsWith("fc2")) && (!((String)localObject).startsWith("fc3"))) {
                  break label536;
                }
                i = 1;
                if (((!((String)localObject).startsWith("fc4.")) || (!((String)localObject).endsWith(".enc"))) && (i == 0)) {
                  break label541;
                }
                j = 1;
                i = j;
                if (j == 0)
                {
                  cp.a("DC_Pro", paramString + ",has no fc4.***.enc files!!!");
                  if ((!((String)localObject).startsWith("dc")) || (System.currentTimeMillis() - localFile.lastModified() <= 172800000L)) {
                    break label546;
                  }
                  i = 1;
                }
                j = m;
              } while (i == 0);
              j = m;
            } while (!a(localFile.length()));
            cp.a("DC_Pro", "upload:" + localFile.getName() + ",len=" + localFile.length());
            i = co.a((String)localObject);
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
            localObject = new cs(localFile.getAbsolutePath(), (String)localObject);
            if (!((cs)localObject).c)
            {
              ((cs)localObject).c = true;
              new Thread(new cs.1((cs)localObject), "th_upload_fc").start();
            }
            j = m - 1;
            break;
            i = 0;
            break label272;
            j = 0;
            break label298;
            i = 0;
            break label358;
            if (i != 1) {
              localObject = "";
            }
          }
        }
      } while (m == cr.k(cr.this));
      label272:
      label298:
      label358:
      return true;
    }
    
    private void b()
    {
      if ((this.e == null) || (this.e.length() == 0) || (this.d == null)) {
        return;
      }
      byte[] arrayOfByte = cx.a(this.e.toString());
      StringBuilder localStringBuilder = new StringBuilder("write buf to file:buf:").append(this.e.length()).append(",enc:");
      if (arrayOfByte == null) {}
      for (int i = 0;; i = arrayOfByte.length)
      {
        cp.a("DC_Pro", i);
        this.e.setLength(0);
        if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
          break;
        }
        cp.a("DC_Pro", "enc result is null or len = 0");
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
        cp.a("DC_Pro", "write file failed.", localThrowable);
        this.c = null;
        co.a(this.d);
      }
    }
    
    private void b(long paramLong)
    {
      try
      {
        PreferenceManager.getDefaultSharedPreferences(cr.r(cr.this)).edit().putLong("log_fc_create", paramLong).apply();
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
        co.a(this.d);
      }
    }
    
    private void d()
    {
      if ((this.c == null) || (!this.c.exists()) || (this.d == null) || (!cr.c().equals(this.c.getName()))) {
        this.c = e();
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
        cp.a("DC_Pro", "open file error", localThrowable);
      }
    }
    
    private File e()
    {
      File localFile = cr.e(cr.this);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return new File(localFile, cr.c());
    }
    
    private long f()
    {
      try
      {
        long l = PreferenceManager.getDefaultSharedPreferences(cr.r(cr.this)).getLong("log_fc_create", 0L);
        return l;
      }
      catch (Throwable localThrowable) {}
      return 0L;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      try
      {
        a(paramMessage);
        return;
      }
      catch (Throwable paramMessage)
      {
        cp.a("DC_Pro", "handler msg error!", paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.cr
 * JD-Core Version:    0.7.0.1
 */