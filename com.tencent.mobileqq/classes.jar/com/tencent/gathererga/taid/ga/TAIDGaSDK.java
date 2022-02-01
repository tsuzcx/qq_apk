package com.tencent.gathererga.taid.ga;

import android.content.Context;
import android.os.Process;
import com.tencent.gathererga.core.GathererCoreContext;
import com.tencent.gathererga.core.ProviderMethodPriority;
import com.tencent.gathererga.core.ProviderResult;
import com.tencent.gathererga.core.TuringProvider;
import com.tencent.gathererga.core.internal.provider.ProviderMethodPriorityImpl;
import com.tencent.gathererga.core.internal.provider.ProviderMethodPriorityImpl.Builder;
import com.tencent.gathererga.core.internal.util.GLog;
import com.tencent.gathererga.core.internal.util.GathererExecutor;
import com.tencent.turingfd.sdk.ams.ga.ITuringDeviceInfoProvider;
import com.tencent.turingfd.sdk.ams.ga.TuringDIDConfig;
import com.tencent.turingfd.sdk.ams.ga.TuringDIDConfig.Builder;
import com.tencent.turingfd.sdk.ams.ga.TuringDIDService;

public class TAIDGaSDK
{
  private static final ProviderMethodPriority a = ProviderMethodPriorityImpl.g().b().b(false).a(false).g();
  private static ITuringDeviceInfoProvider b = new TAIDGaSDK.2();
  
  /* Error */
  private static int a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: new 46	java/io/RandomAccessFile
    //   11: dup
    //   12: aload_0
    //   13: ldc 48
    //   15: invokespecial 51	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: astore_0
    //   19: aload_0
    //   20: ldc2_w 52
    //   23: invokevirtual 57	java/io/RandomAccessFile:seek	(J)V
    //   26: aload_0
    //   27: invokevirtual 61	java/io/RandomAccessFile:read	()I
    //   30: istore_1
    //   31: aload_0
    //   32: invokevirtual 64	java/io/RandomAccessFile:close	()V
    //   35: iload_1
    //   36: ireturn
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   42: iload_1
    //   43: ireturn
    //   44: astore_3
    //   45: aload_0
    //   46: astore_2
    //   47: aload_3
    //   48: astore_0
    //   49: goto +64 -> 113
    //   52: astore_3
    //   53: goto +15 -> 68
    //   56: astore_3
    //   57: goto +32 -> 89
    //   60: astore_0
    //   61: goto +52 -> 113
    //   64: astore_3
    //   65: aload 4
    //   67: astore_0
    //   68: aload_0
    //   69: astore_2
    //   70: aload_3
    //   71: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   74: aload_0
    //   75: ifnull +36 -> 111
    //   78: aload_0
    //   79: invokevirtual 64	java/io/RandomAccessFile:close	()V
    //   82: goto +29 -> 111
    //   85: astore_3
    //   86: aload 5
    //   88: astore_0
    //   89: aload_0
    //   90: astore_2
    //   91: aload_3
    //   92: invokevirtual 68	java/io/FileNotFoundException:printStackTrace	()V
    //   95: aload_0
    //   96: ifnull +15 -> 111
    //   99: aload_0
    //   100: invokevirtual 64	java/io/RandomAccessFile:close	()V
    //   103: goto +8 -> 111
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   111: iconst_0
    //   112: ireturn
    //   113: aload_2
    //   114: ifnull +15 -> 129
    //   117: aload_2
    //   118: invokevirtual 64	java/io/RandomAccessFile:close	()V
    //   121: goto +8 -> 129
    //   124: astore_2
    //   125: aload_2
    //   126: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   129: aload_0
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString	String
    //   30	13	1	i	int
    //   7	111	2	str	String
    //   124	2	2	localIOException1	java.io.IOException
    //   44	4	3	localObject1	Object
    //   52	1	3	localIOException2	java.io.IOException
    //   56	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   64	7	3	localIOException3	java.io.IOException
    //   85	7	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	65	4	localObject2	Object
    //   4	83	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   31	35	37	java/io/IOException
    //   19	31	44	finally
    //   19	31	52	java/io/IOException
    //   19	31	56	java/io/FileNotFoundException
    //   8	19	60	finally
    //   70	74	60	finally
    //   91	95	60	finally
    //   8	19	64	java/io/IOException
    //   8	19	85	java/io/FileNotFoundException
    //   78	82	106	java/io/IOException
    //   99	103	106	java/io/IOException
    //   117	121	124	java/io/IOException
  }
  
  public static String a()
  {
    int i = Process.myTid();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/proc/");
    localStringBuilder.append(i);
    localStringBuilder.append("/exe");
    i = a(localStringBuilder.toString());
    if (i != 3)
    {
      if (i != 40)
      {
        if (i != 62)
        {
          if (i != 183) {
            return "unknown";
          }
          return "arm64-v8a";
        }
        return "x86_64";
      }
      return "armeabi";
    }
    return "x86";
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    String str = a();
    GathererCoreContext.a(TuringProvider.class, TuringProviderImpl.class);
    if ((!"x86".equals(str)) && (!"x86_64".equals(str)))
    {
      paramContext = TuringDIDConfig.newBuilder(paramContext).appid(paramString).channel(paramInt).turingDeviceInfoProvider(b).build();
      if (!paramBoolean)
      {
        TuringDIDService.init(paramContext);
        return;
      }
      GathererExecutor.a().a(new TAIDGaSDK.1(paramContext));
      return;
    }
    GLog.d("unsupport cpu abi");
  }
  
  private static String b(ProviderResult paramProviderResult)
  {
    if (paramProviderResult.c()) {
      return (String)paramProviderResult.b();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.taid.ga.TAIDGaSDK
 * JD-Core Version:    0.7.0.1
 */