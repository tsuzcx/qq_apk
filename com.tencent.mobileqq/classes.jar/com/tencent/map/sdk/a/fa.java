package com.tencent.map.sdk.a;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class fa
  extends ee<Time>
{
  public static final ef a = new fa.1();
  private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");
  
  private void a(fg paramfg, Time paramTime)
  {
    if (paramTime == null) {
      paramTime = null;
    }
    try
    {
      paramTime = this.b.format(paramTime);
      paramfg.b(paramTime);
      return;
    }
    finally {}
  }
  
  /* Error */
  private Time b(fe paramfe)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 50	com/tencent/map/sdk/a/fe:f	()Lcom/tencent/map/sdk/a/ff;
    //   6: getstatic 56	com/tencent/map/sdk/a/ff:i	Lcom/tencent/map/sdk/a/ff;
    //   9: if_acmpne +11 -> 20
    //   12: aload_1
    //   13: invokevirtual 59	com/tencent/map/sdk/a/fe:k	()V
    //   16: aload_0
    //   17: monitorexit
    //   18: aconst_null
    //   19: areturn
    //   20: new 61	java/sql/Time
    //   23: dup
    //   24: aload_0
    //   25: getfield 29	com/tencent/map/sdk/a/fa:b	Ljava/text/DateFormat;
    //   28: aload_1
    //   29: invokevirtual 64	com/tencent/map/sdk/a/fe:i	()Ljava/lang/String;
    //   32: invokevirtual 68	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   35: invokevirtual 74	java/util/Date:getTime	()J
    //   38: invokespecial 77	java/sql/Time:<init>	(J)V
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: new 79	com/tencent/map/sdk/a/eb
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 82	com/tencent/map/sdk/a/eb:<init>	(Ljava/lang/Throwable;)V
    //   55: athrow
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	fa
    //   0	61	1	paramfe	fe
    // Exception table:
    //   from	to	target	type
    //   20	42	46	java/text/ParseException
    //   2	16	56	finally
    //   20	42	56	finally
    //   47	56	56	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.fa
 * JD-Core Version:    0.7.0.1
 */