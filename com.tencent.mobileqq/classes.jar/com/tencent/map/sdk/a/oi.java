package com.tencent.map.sdk.a;

import java.util.LinkedHashMap;

public final class oi
{
  private static LinkedHashMap<String, oi.a> a = new LinkedHashMap();
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	com/tencent/map/sdk/a/oi:a	Ljava/util/LinkedHashMap;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +10 -> 18
    //   11: aconst_null
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: getstatic 16	com/tencent/map/sdk/a/oi:a	Ljava/util/LinkedHashMap;
    //   21: aload_0
    //   22: invokevirtual 22	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 24	com/tencent/map/sdk/a/oi$a
    //   28: astore_0
    //   29: aload_0
    //   30: ifnull +11 -> 41
    //   33: aload_0
    //   34: getfield 28	com/tencent/map/sdk/a/oi$a:b	Landroid/graphics/Bitmap;
    //   37: astore_0
    //   38: goto -25 -> 13
    //   41: aconst_null
    //   42: astore_0
    //   43: goto -30 -> 13
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramString	String
    //   6	2	1	localLinkedHashMap	LinkedHashMap
    // Exception table:
    //   from	to	target	type
    //   3	7	46	finally
    //   18	29	46	finally
    //   33	38	46	finally
  }
  
  public static void a()
  {
    try
    {
      if (a != null) {
        a.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static void a(String paramString, android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	com/tencent/map/sdk/a/oi:a	Ljava/util/LinkedHashMap;
    //   6: ifnonnull +13 -> 19
    //   9: new 11	java/util/LinkedHashMap
    //   12: dup
    //   13: invokespecial 14	java/util/LinkedHashMap:<init>	()V
    //   16: putstatic 16	com/tencent/map/sdk/a/oi:a	Ljava/util/LinkedHashMap;
    //   19: getstatic 16	com/tencent/map/sdk/a/oi:a	Ljava/util/LinkedHashMap;
    //   22: aload_0
    //   23: invokevirtual 36	java/util/LinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   26: ifeq +28 -> 54
    //   29: getstatic 16	com/tencent/map/sdk/a/oi:a	Ljava/util/LinkedHashMap;
    //   32: aload_0
    //   33: invokevirtual 22	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 24	com/tencent/map/sdk/a/oi$a
    //   39: astore_0
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 39	com/tencent/map/sdk/a/oi$a:a	I
    //   45: iconst_1
    //   46: iadd
    //   47: putfield 39	com/tencent/map/sdk/a/oi$a:a	I
    //   50: ldc 2
    //   52: monitorexit
    //   53: return
    //   54: new 24	com/tencent/map/sdk/a/oi$a
    //   57: dup
    //   58: invokespecial 40	com/tencent/map/sdk/a/oi$a:<init>	()V
    //   61: astore_2
    //   62: aload_2
    //   63: aload_1
    //   64: putfield 28	com/tencent/map/sdk/a/oi$a:b	Landroid/graphics/Bitmap;
    //   67: aload_2
    //   68: iconst_1
    //   69: putfield 39	com/tencent/map/sdk/a/oi$a:a	I
    //   72: getstatic 16	com/tencent/map/sdk/a/oi:a	Ljava/util/LinkedHashMap;
    //   75: aload_0
    //   76: aload_2
    //   77: invokevirtual 44	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: goto -31 -> 50
    //   84: astore_0
    //   85: ldc 2
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramString	String
    //   0	90	1	paramBitmap	android.graphics.Bitmap
    //   61	16	2	locala	oi.a
    // Exception table:
    //   from	to	target	type
    //   3	19	84	finally
    //   19	50	84	finally
    //   54	81	84	finally
  }
  
  /* Error */
  public static void b(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	com/tencent/map/sdk/a/oi:a	Ljava/util/LinkedHashMap;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 16	com/tencent/map/sdk/a/oi:a	Ljava/util/LinkedHashMap;
    //   18: aload_0
    //   19: invokevirtual 22	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 24	com/tencent/map/sdk/a/oi$a
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull -16 -> 11
    //   30: aload_1
    //   31: aload_1
    //   32: getfield 39	com/tencent/map/sdk/a/oi$a:a	I
    //   35: iconst_1
    //   36: isub
    //   37: putfield 39	com/tencent/map/sdk/a/oi$a:a	I
    //   40: aload_1
    //   41: getfield 39	com/tencent/map/sdk/a/oi$a:a	I
    //   44: ifgt -33 -> 11
    //   47: getstatic 16	com/tencent/map/sdk/a/oi:a	Ljava/util/LinkedHashMap;
    //   50: aload_0
    //   51: invokevirtual 48	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: getstatic 53	android/os/Build$VERSION:SDK_INT	I
    //   58: bipush 10
    //   60: if_icmpgt -49 -> 11
    //   63: aload_1
    //   64: getfield 28	com/tencent/map/sdk/a/oi$a:b	Landroid/graphics/Bitmap;
    //   67: astore_0
    //   68: aload_0
    //   69: ifnull -58 -> 11
    //   72: aload_0
    //   73: invokevirtual 59	android/graphics/Bitmap:isRecycled	()Z
    //   76: ifne -65 -> 11
    //   79: aload_0
    //   80: invokevirtual 62	android/graphics/Bitmap:recycle	()V
    //   83: goto -72 -> 11
    //   86: astore_0
    //   87: ldc 2
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramString	String
    //   6	58	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	86	finally
    //   15	26	86	finally
    //   30	68	86	finally
    //   72	83	86	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.oi
 * JD-Core Version:    0.7.0.1
 */