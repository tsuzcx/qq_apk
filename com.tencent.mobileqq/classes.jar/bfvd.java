import android.content.Context;

public class bfvd
{
  private static volatile bfvd jdField_a_of_type_Bfvd;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private bfvh jdField_a_of_type_Bfvh;
  private bfvk jdField_a_of_type_Bfvk;
  private boolean jdField_a_of_type_Boolean;
  
  public static bfvd a()
  {
    if (jdField_a_of_type_Bfvd == null) {}
    try
    {
      if (jdField_a_of_type_Bfvd == null) {
        jdField_a_of_type_Bfvd = new bfvd();
      }
      return jdField_a_of_type_Bfvd;
    }
    finally {}
  }
  
  public bfvl a()
  {
    bfvl localbfvl = null;
    if (this.jdField_a_of_type_Bfvk != null) {
      localbfvl = this.jdField_a_of_type_Bfvk.a();
    }
    return localbfvl;
  }
  
  public void a()
  {
    try
    {
      bfvy.a().a();
      if (this.jdField_a_of_type_Bfvk != null)
      {
        this.jdField_a_of_type_Bfvk.a();
        this.jdField_a_of_type_Bfvk = null;
      }
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Bfvh = null;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(Context paramContext, long paramLong, bfvh parambfvh)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 48
    //   4: ldc 50
    //   6: iconst_3
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_1
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: lload_2
    //   17: invokestatic 56	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: dup
    //   22: iconst_2
    //   23: aload 4
    //   25: aastore
    //   26: invokestatic 62	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokestatic 68	bfvp:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 43	bfvd:jdField_a_of_type_Boolean	Z
    //   36: ifeq +13 -> 49
    //   39: ldc 48
    //   41: ldc 70
    //   43: invokestatic 73	bfvp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 79	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   54: putfield 37	bfvd:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   57: aload_0
    //   58: lload_2
    //   59: putfield 39	bfvd:jdField_a_of_type_Long	J
    //   62: aload_0
    //   63: aload 4
    //   65: putfield 41	bfvd:jdField_a_of_type_Bfvh	Lbfvh;
    //   68: aload_0
    //   69: getfield 23	bfvd:jdField_a_of_type_Bfvk	Lbfvk;
    //   72: ifnonnull +26 -> 98
    //   75: aload_0
    //   76: new 25	bfvk
    //   79: dup
    //   80: aload_0
    //   81: getfield 37	bfvd:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   84: aload_0
    //   85: getfield 39	bfvd:jdField_a_of_type_Long	J
    //   88: aload_0
    //   89: getfield 41	bfvd:jdField_a_of_type_Bfvh	Lbfvh;
    //   92: invokespecial 81	bfvk:<init>	(Landroid/content/Context;JLbfvh;)V
    //   95: putfield 23	bfvd:jdField_a_of_type_Bfvk	Lbfvk;
    //   98: aload_0
    //   99: iconst_1
    //   100: putfield 43	bfvd:jdField_a_of_type_Boolean	Z
    //   103: goto -57 -> 46
    //   106: astore_1
    //   107: ldc 48
    //   109: ldc 83
    //   111: aload_1
    //   112: invokestatic 86	bfvp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 23	bfvd:jdField_a_of_type_Bfvk	Lbfvk;
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 43	bfvd:jdField_a_of_type_Boolean	Z
    //   125: goto -79 -> 46
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	bfvd
    //   0	133	1	paramContext	Context
    //   0	133	2	paramLong	long
    //   0	133	4	parambfvh	bfvh
    // Exception table:
    //   from	to	target	type
    //   49	98	106	java/lang/Throwable
    //   98	103	106	java/lang/Throwable
    //   2	46	128	finally
    //   49	98	128	finally
    //   98	103	128	finally
    //   107	125	128	finally
  }
  
  public void a(bfvx parambfvx)
  {
    bfvy.a().a(parambfvx, true);
  }
  
  public void b(bfvx parambfvx)
  {
    bfvy.a().a(parambfvx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfvd
 * JD-Core Version:    0.7.0.1
 */