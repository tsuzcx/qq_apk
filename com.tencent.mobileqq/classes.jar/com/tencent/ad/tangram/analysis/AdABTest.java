package com.tencent.ad.tangram.analysis;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_abtest.ABTest;

@Keep
public class AdABTest
{
  private static final String TAG = "AdABTest";
  
  /* Error */
  private static boolean isABTestByUIN(String paramString, com.tencent.ad.tangram.protocol.gdt_abtest.ABTest.LimitByUIN paramLimitByUIN)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 24	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 7
    //   9: iload 6
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: invokestatic 30	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   20: invokevirtual 34	java/lang/Long:longValue	()J
    //   23: lstore 8
    //   25: lload 8
    //   27: ldc2_w 35
    //   30: lcmp
    //   31: ifne +5 -> 36
    //   34: iconst_0
    //   35: ireturn
    //   36: aload_1
    //   37: ifnonnull +5 -> 42
    //   40: iconst_0
    //   41: ireturn
    //   42: aload_1
    //   43: getfield 42	com/tencent/ad/tangram/protocol/gdt_abtest$ABTest$LimitByUIN:whiteList	[Ljava/lang/String;
    //   46: ifnull +30 -> 76
    //   49: aload_1
    //   50: getfield 42	com/tencent/ad/tangram/protocol/gdt_abtest$ABTest$LimitByUIN:whiteList	[Ljava/lang/String;
    //   53: invokestatic 48	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   56: astore 10
    //   58: aload 10
    //   60: ifnull +16 -> 76
    //   63: aload 10
    //   65: aload_0
    //   66: invokeinterface 54 2 0
    //   71: ifeq +5 -> 76
    //   74: iconst_1
    //   75: ireturn
    //   76: aload_1
    //   77: getfield 57	com/tencent/ad/tangram/protocol/gdt_abtest$ABTest$LimitByUIN:blackList	[Ljava/lang/String;
    //   80: ifnull +30 -> 110
    //   83: aload_1
    //   84: getfield 57	com/tencent/ad/tangram/protocol/gdt_abtest$ABTest$LimitByUIN:blackList	[Ljava/lang/String;
    //   87: invokestatic 48	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   90: astore 10
    //   92: aload 10
    //   94: ifnull +16 -> 110
    //   97: aload 10
    //   99: aload_0
    //   100: invokeinterface 54 2 0
    //   105: ifeq +5 -> 110
    //   108: iconst_0
    //   109: ireturn
    //   110: aload_1
    //   111: getfield 60	com/tencent/ad/tangram/protocol/gdt_abtest$ABTest$LimitByUIN:lower	Ljava/lang/String;
    //   114: invokestatic 24	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifeq +5 -> 122
    //   120: iconst_0
    //   121: ireturn
    //   122: aload_1
    //   123: getfield 63	com/tencent/ad/tangram/protocol/gdt_abtest$ABTest$LimitByUIN:upper	Ljava/lang/String;
    //   126: invokestatic 24	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   129: ifeq +5 -> 134
    //   132: iconst_0
    //   133: ireturn
    //   134: aload_1
    //   135: getfield 60	com/tencent/ad/tangram/protocol/gdt_abtest$ABTest$LimitByUIN:lower	Ljava/lang/String;
    //   138: invokestatic 68	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   141: invokevirtual 72	java/lang/Integer:intValue	()I
    //   144: istore_2
    //   145: aload_1
    //   146: getfield 63	com/tencent/ad/tangram/protocol/gdt_abtest$ABTest$LimitByUIN:upper	Ljava/lang/String;
    //   149: invokestatic 68	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   152: invokevirtual 72	java/lang/Integer:intValue	()I
    //   155: istore_3
    //   156: iload_2
    //   157: ldc 73
    //   159: if_icmpne +5 -> 164
    //   162: iconst_0
    //   163: ireturn
    //   164: iload_3
    //   165: ldc 73
    //   167: if_icmpne +5 -> 172
    //   170: iconst_0
    //   171: ireturn
    //   172: iload_2
    //   173: iload_3
    //   174: if_icmple +5 -> 179
    //   177: iconst_0
    //   178: ireturn
    //   179: aload_0
    //   180: invokevirtual 78	java/lang/String:length	()I
    //   183: aload_1
    //   184: getfield 63	com/tencent/ad/tangram/protocol/gdt_abtest$ABTest$LimitByUIN:upper	Ljava/lang/String;
    //   187: invokevirtual 78	java/lang/String:length	()I
    //   190: isub
    //   191: istore 4
    //   193: aload_0
    //   194: invokevirtual 78	java/lang/String:length	()I
    //   197: istore 5
    //   199: iload 4
    //   201: ifge +5 -> 206
    //   204: iconst_0
    //   205: ireturn
    //   206: iload 4
    //   208: iload 5
    //   210: if_icmplt +5 -> 215
    //   213: iconst_0
    //   214: ireturn
    //   215: aload_0
    //   216: iload 4
    //   218: iload 5
    //   220: invokevirtual 82	java/lang/String:substring	(II)Ljava/lang/String;
    //   223: astore_0
    //   224: aload_0
    //   225: invokestatic 24	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifeq +5 -> 233
    //   231: iconst_0
    //   232: ireturn
    //   233: aload_0
    //   234: invokestatic 30	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   237: invokevirtual 34	java/lang/Long:longValue	()J
    //   240: lstore 8
    //   242: lload 8
    //   244: ldc2_w 35
    //   247: lcmp
    //   248: ifne +5 -> 253
    //   251: iconst_0
    //   252: ireturn
    //   253: iload 7
    //   255: istore 6
    //   257: iload_2
    //   258: i2l
    //   259: lload 8
    //   261: lcmp
    //   262: ifgt +18 -> 280
    //   265: iload 7
    //   267: istore 6
    //   269: lload 8
    //   271: iload_3
    //   272: i2l
    //   273: lcmp
    //   274: ifgt +6 -> 280
    //   277: iconst_1
    //   278: istore 6
    //   280: iload 6
    //   282: ireturn
    //   283: astore_0
    //   284: ldc 9
    //   286: ldc 83
    //   288: aload_0
    //   289: invokestatic 89	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   292: iconst_0
    //   293: ireturn
    //   294: astore_0
    //   295: ldc 9
    //   297: ldc 83
    //   299: aload_0
    //   300: invokestatic 89	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   303: iconst_0
    //   304: ireturn
    //   305: astore_0
    //   306: ldc 9
    //   308: ldc 83
    //   310: aload_0
    //   311: invokestatic 89	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   314: iconst_0
    //   315: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramString	String
    //   0	316	1	paramLimitByUIN	com.tencent.ad.tangram.protocol.gdt_abtest.ABTest.LimitByUIN
    //   144	114	2	i	int
    //   155	117	3	j	int
    //   191	26	4	k	int
    //   197	22	5	m	int
    //   4	277	6	bool1	boolean
    //   7	259	7	bool2	boolean
    //   23	247	8	l	long
    //   56	42	10	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   233	242	283	java/lang/Throwable
    //   134	156	294	java/lang/Throwable
    //   16	25	305	java/lang/Throwable
  }
  
  public static boolean isABTestByUIN(String paramString, gdt_abtest.ABTest paramABTest)
  {
    if (paramABTest == null) {
      return false;
    }
    if (paramABTest.mode == 0) {
      return false;
    }
    if (paramABTest.mode == 1) {
      return true;
    }
    if (paramABTest.mode == 2) {
      return isABTestByUIN(paramString, paramABTest.limitByUIN);
    }
    AdLog.e("AdABTest", "isABTestByUIN error");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.AdABTest
 * JD-Core Version:    0.7.0.1
 */