public class blfp
{
  public static boolean a;
  private static volatile boolean b;
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 10	blfp:b	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 16	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   18: ldc 18
    //   20: invokestatic 24	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: new 26	blft
    //   26: dup
    //   27: invokespecial 29	blft:<init>	()V
    //   30: new 31	blga
    //   33: dup
    //   34: invokespecial 32	blga:<init>	()V
    //   37: new 34	blfw
    //   40: dup
    //   41: invokespecial 35	blfw:<init>	()V
    //   44: new 37	blfz
    //   47: dup
    //   48: invokespecial 38	blfz:<init>	()V
    //   51: invokevirtual 42	com/tencent/sveffects/SdkContext:init	(Ljava/lang/String;Landroid/app/Application;Lcom/tencent/sveffects/DpcSwitcher;Lcom/tencent/mobileqq/shortvideo/resource/Resources;Lcom/tencent/sveffects/Logger;Lcom/tencent/sveffects/Reporter;)V
    //   54: iconst_1
    //   55: putstatic 10	blfp:b	Z
    //   58: goto -47 -> 11
    //   61: astore_1
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   61	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	61	finally
    //   15	58	61	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfp
 * JD-Core Version:    0.7.0.1
 */