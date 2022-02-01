package com.tencent.ad.tangram.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.telephony.TelephonyManager;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;

@Keep
public final class AdNet
{
  public static final int IP_FAMILY_UNKNOWN = 0;
  public static final int IP_FAMILY_V4 = 1;
  public static final int IP_FAMILY_V6 = 2;
  private static final String TAG = "AdNet";
  private static String ipV4Address;
  private static long ipV4AddressTimeStamp = -2147483648L;
  
  public static int getIpFamily(Context paramContext)
  {
    int i = getIpFamilyImpl(paramContext);
    AdLog.i("AdNet", String.format("getIpFamily %d", new Object[] { Integer.valueOf(i) }));
    return i;
  }
  
  private static int getIpFamilyImpl(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getApplicationContext();
    if (paramContext == null) {
      return 0;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return 0;
      }
      if (Build.VERSION.SDK_INT < 23) {
        return 0;
      }
      paramContext = paramContext.getLinkProperties(paramContext.getActiveNetwork());
      if (paramContext == null) {
        return 0;
      }
      paramContext = paramContext.getLinkAddresses().iterator();
      int i = 0;
      while (paramContext.hasNext())
      {
        LinkAddress localLinkAddress = (LinkAddress)paramContext.next();
        if (localLinkAddress != null)
        {
          int j = getNetIpFamily(localLinkAddress.getAddress());
          i |= j;
        }
      }
      return i;
    }
    catch (Throwable paramContext)
    {
      AdLog.i("AdNet", "getIpFamily", paramContext);
    }
    return 0;
  }
  
  private static String getIpV4Address()
  {
    Object localObject = new AdHttp.Params();
    ((AdHttp.Params)localObject).setUrl("https://ipv4.gdt.qq.com/get_client_ip");
    ((AdHttp.Params)localObject).method = "GET";
    AdHttp.send((AdHttp.Params)localObject);
    AdLog.i("AdNet", String.format("getIpV4Address responseCode:%d", new Object[] { Integer.valueOf(((AdHttp.Params)localObject).responseCode) }));
    if ((!((AdHttp.Params)localObject).canSend()) || (((AdHttp.Params)localObject).responseCode != 200)) {
      return null;
    }
    try
    {
      localObject = new String(((AdHttp.Params)localObject).responseData, "UTF-8");
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdNet", "getIpV4Address", localThrowable);
    }
    return null;
  }
  
  public static String getIpV4AddressCache()
  {
    AdLog.i("AdNet", String.format("getIpV4AddressCache address:%s timeStamp:%d", new Object[] { ipV4Address, Long.valueOf(ipV4AddressTimeStamp) }));
    return ipV4Address;
  }
  
  private static int getNetIpFamily(InetAddress paramInetAddress)
  {
    if (paramInetAddress == null) {}
    do
    {
      do
      {
        return 0;
      } while ((paramInetAddress.isLoopbackAddress()) || (paramInetAddress.isLinkLocalAddress()) || (paramInetAddress.isAnyLocalAddress()));
      if ((paramInetAddress instanceof Inet6Address)) {
        return 2;
      }
    } while (!(paramInetAddress instanceof Inet4Address));
    return 1;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      AdLog.e("AdNet", "getNetworkType error");
      return -2147483648;
      paramContext = paramContext.getApplicationContext();
      if (paramContext != null) {
        try
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            int i = paramContext.getNetworkType();
            return i;
          }
        }
        catch (Throwable paramContext)
        {
          AdLog.e("AdNet", "getNetworkType", paramContext);
        }
      }
    }
  }
  
  /* Error */
  public static int getType(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: invokevirtual 81	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   10: astore 7
    //   12: aload 7
    //   14: ifnonnull +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: new 57	java/lang/Integer
    //   22: dup
    //   23: iconst_1
    //   24: invokespecial 220	java/lang/Integer:<init>	(I)V
    //   27: astore_2
    //   28: new 57	java/lang/Integer
    //   31: dup
    //   32: iconst_2
    //   33: invokespecial 220	java/lang/Integer:<init>	(I)V
    //   36: astore 4
    //   38: new 57	java/lang/Integer
    //   41: dup
    //   42: iconst_3
    //   43: invokespecial 220	java/lang/Integer:<init>	(I)V
    //   46: astore 5
    //   48: aload 4
    //   50: astore_0
    //   51: ldc 212
    //   53: ldc 222
    //   55: invokevirtual 228	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   58: ldc 212
    //   60: invokevirtual 234	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: astore_3
    //   64: aload 4
    //   66: astore_0
    //   67: aload_3
    //   68: astore_2
    //   69: ldc 212
    //   71: ldc 236
    //   73: invokevirtual 228	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   76: ldc 212
    //   78: invokevirtual 234	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: astore 4
    //   83: aload 4
    //   85: astore_0
    //   86: aload_3
    //   87: astore_2
    //   88: ldc 212
    //   90: ldc 238
    //   92: invokevirtual 228	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   95: ldc 212
    //   97: invokevirtual 234	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: astore 6
    //   102: aload 4
    //   104: astore_2
    //   105: aload 6
    //   107: astore_0
    //   108: aload 7
    //   110: ldc 83
    //   112: invokevirtual 87	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   115: checkcast 89	android/net/ConnectivityManager
    //   118: astore 4
    //   120: aload 4
    //   122: ifnonnull +24 -> 146
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_3
    //   128: ldc 16
    //   130: ldc 239
    //   132: aload_3
    //   133: invokestatic 138	com/tencent/ad/tangram/log/AdLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload_2
    //   137: astore_3
    //   138: aload_0
    //   139: astore_2
    //   140: aload 5
    //   142: astore_0
    //   143: goto -35 -> 108
    //   146: aload 4
    //   148: invokevirtual 243	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   151: astore 4
    //   153: aload 4
    //   155: ifnonnull +5 -> 160
    //   158: iconst_0
    //   159: ireturn
    //   160: aload 4
    //   162: invokevirtual 247	android/net/NetworkInfo:getType	()I
    //   165: tableswitch	default:+130 -> 295, 0:+43->208, 1:+132->297, 2:+43->208, 3:+43->208, 4:+43->208, 5:+43->208, 6:+132->297
    //   209: <illegal opcode>
    //   210: ldc 249
    //   212: iconst_1
    //   213: anewarray 224	java/lang/Class
    //   216: dup
    //   217: iconst_0
    //   218: getstatic 253	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   221: aastore
    //   222: invokevirtual 257	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   225: ldc 212
    //   227: iconst_1
    //   228: anewarray 4	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: aload 4
    //   235: invokevirtual 260	android/net/NetworkInfo:getSubtype	()I
    //   238: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   241: aastore
    //   242: invokevirtual 266	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   245: astore 4
    //   247: aload 4
    //   249: aload_3
    //   250: invokevirtual 270	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   253: ifeq +5 -> 258
    //   256: iconst_2
    //   257: ireturn
    //   258: aload 4
    //   260: aload_2
    //   261: invokevirtual 270	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   264: ifeq +5 -> 269
    //   267: iconst_3
    //   268: ireturn
    //   269: aload 4
    //   271: aload_0
    //   272: invokevirtual 270	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   275: istore_1
    //   276: iload_1
    //   277: ifeq +5 -> 282
    //   280: iconst_4
    //   281: ireturn
    //   282: iconst_0
    //   283: ireturn
    //   284: astore_0
    //   285: ldc 16
    //   287: ldc 239
    //   289: aload_0
    //   290: invokestatic 179	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   293: iconst_0
    //   294: ireturn
    //   295: iconst_0
    //   296: ireturn
    //   297: iconst_1
    //   298: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramContext	Context
    //   275	2	1	bool	boolean
    //   27	234	2	localObject1	Object
    //   63	24	3	localObject2	Object
    //   127	6	3	localThrowable	Throwable
    //   137	113	3	localObject3	Object
    //   36	234	4	localObject4	Object
    //   46	95	5	localInteger	Integer
    //   100	6	6	localObject5	Object
    //   10	99	7	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   51	64	127	java/lang/Throwable
    //   69	83	127	java/lang/Throwable
    //   88	102	127	java/lang/Throwable
    //   108	120	284	java/lang/Throwable
    //   146	153	284	java/lang/Throwable
    //   160	208	284	java/lang/Throwable
    //   208	256	284	java/lang/Throwable
    //   258	267	284	java/lang/Throwable
    //   269	276	284	java/lang/Throwable
  }
  
  public static int getTypeWith5G(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {
      return 0;
    }
    Object localObject2 = new Integer(1);
    Object localObject3 = new Integer(2);
    Object localObject6 = new Integer(3);
    Integer localInteger = new Integer(4);
    Object localObject1 = localObject6;
    paramContext = (Context)localObject3;
    for (;;)
    {
      try
      {
        localObject5 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_2_G").get(TelephonyManager.class);
        localObject1 = localObject6;
        paramContext = (Context)localObject3;
        localObject2 = localObject5;
        localObject3 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_3_G").get(TelephonyManager.class);
        localObject1 = localObject6;
        paramContext = (Context)localObject3;
        localObject2 = localObject5;
        localObject6 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_4_G").get(TelephonyManager.class);
        localObject1 = localObject6;
        paramContext = (Context)localObject3;
        localObject2 = localObject5;
        Object localObject7 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_5_G").get(TelephonyManager.class);
        localObject1 = localObject6;
        paramContext = localObject7;
        localObject2 = localObject3;
        localObject3 = localObject5;
      }
      catch (Throwable localThrowable)
      {
        Object localObject4 = localObject2;
        Object localObject5 = localInteger;
        localObject2 = paramContext;
        paramContext = (Context)localObject5;
        continue;
        return 0;
      }
      try
      {
        localObject5 = (ConnectivityManager)localContext.getSystemService("connectivity");
        if (localObject5 == null) {
          return 0;
        }
        localObject5 = ((ConnectivityManager)localObject5).getActiveNetworkInfo();
        if (localObject5 == null) {
          return 0;
        }
        switch (((NetworkInfo)localObject5).getType())
        {
        case 0: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
          localObject5 = TelephonyManager.class.getDeclaredMethod("getNetworkClass", new Class[] { Integer.TYPE }).invoke(TelephonyManager.class, new Object[] { Integer.valueOf(((NetworkInfo)localObject5).getSubtype()) });
          if (localObject5.equals(localObject3)) {
            return 2;
          }
          if (localObject5.equals(localObject2)) {
            return 3;
          }
          if (localObject5.equals(localObject1)) {
            return 4;
          }
          boolean bool = localObject5.equals(paramContext);
          if (bool) {
            return 7;
          }
          return 0;
        }
      }
      catch (Throwable paramContext)
      {
        AdLog.e("AdNet", "getType", paramContext);
        return 0;
      }
    }
    return 1;
  }
  
  public static boolean isNetValid(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    return getType(paramContext) == 1;
  }
  
  private static void updateIpV4Address(long paramLong)
  {
    AdLog.i("AdNet", String.format("updateIpV4Address delayMillis:%d", new Object[] { Long.valueOf(paramLong) }));
    AdThreadManager.INSTANCE.postDelayed(new AdNet.1(), 4, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdNet
 * JD-Core Version:    0.7.0.1
 */