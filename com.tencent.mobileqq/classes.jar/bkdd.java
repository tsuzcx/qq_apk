import android.content.Context;

public class bkdd
{
  private static volatile bkdd jdField_a_of_type_Bkdd;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private bkdh jdField_a_of_type_Bkdh;
  private bkdk jdField_a_of_type_Bkdk;
  private boolean jdField_a_of_type_Boolean;
  
  public static bkdd a()
  {
    if (jdField_a_of_type_Bkdd == null) {}
    try
    {
      if (jdField_a_of_type_Bkdd == null) {
        jdField_a_of_type_Bkdd = new bkdd();
      }
      return jdField_a_of_type_Bkdd;
    }
    finally {}
  }
  
  public bkdl a()
  {
    bkdl localbkdl = null;
    if (this.jdField_a_of_type_Bkdk != null) {
      localbkdl = this.jdField_a_of_type_Bkdk.a();
    }
    return localbkdl;
  }
  
  public void a()
  {
    try
    {
      bkdy.a().a();
      if (this.jdField_a_of_type_Bkdk != null)
      {
        this.jdField_a_of_type_Bkdk.a();
        this.jdField_a_of_type_Bkdk = null;
      }
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Bkdh = null;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(Context paramContext, long paramLong, bkdh parambkdh)
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
    //   29: invokestatic 68	bkdp:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 43	bkdd:jdField_a_of_type_Boolean	Z
    //   36: ifeq +13 -> 49
    //   39: ldc 48
    //   41: ldc 70
    //   43: invokestatic 73	bkdp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 79	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   54: putfield 37	bkdd:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   57: aload_0
    //   58: lload_2
    //   59: putfield 39	bkdd:jdField_a_of_type_Long	J
    //   62: aload_0
    //   63: aload 4
    //   65: putfield 41	bkdd:jdField_a_of_type_Bkdh	Lbkdh;
    //   68: aload_0
    //   69: getfield 23	bkdd:jdField_a_of_type_Bkdk	Lbkdk;
    //   72: ifnonnull +43 -> 115
    //   75: new 81	bkdn
    //   78: dup
    //   79: aload_0
    //   80: getfield 37	bkdd:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   83: aload_0
    //   84: getfield 39	bkdd:jdField_a_of_type_Long	J
    //   87: aload_0
    //   88: getfield 41	bkdd:jdField_a_of_type_Bkdh	Lbkdh;
    //   91: invokespecial 83	bkdn:<init>	(Landroid/content/Context;JLbkdh;)V
    //   94: astore_1
    //   95: aload_0
    //   96: new 25	bkdk
    //   99: dup
    //   100: aload_0
    //   101: getfield 37	bkdd:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   104: aload_0
    //   105: getfield 41	bkdd:jdField_a_of_type_Bkdh	Lbkdh;
    //   108: aload_1
    //   109: invokespecial 86	bkdk:<init>	(Landroid/content/Context;Lbkdh;Lbkdn;)V
    //   112: putfield 23	bkdd:jdField_a_of_type_Bkdk	Lbkdk;
    //   115: aload_0
    //   116: iconst_1
    //   117: putfield 43	bkdd:jdField_a_of_type_Boolean	Z
    //   120: goto -74 -> 46
    //   123: astore_1
    //   124: ldc 48
    //   126: ldc 88
    //   128: aload_1
    //   129: invokestatic 91	bkdp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload_0
    //   133: aconst_null
    //   134: putfield 23	bkdd:jdField_a_of_type_Bkdk	Lbkdk;
    //   137: aload_0
    //   138: iconst_0
    //   139: putfield 43	bkdd:jdField_a_of_type_Boolean	Z
    //   142: goto -96 -> 46
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	bkdd
    //   0	150	1	paramContext	Context
    //   0	150	2	paramLong	long
    //   0	150	4	parambkdh	bkdh
    // Exception table:
    //   from	to	target	type
    //   49	115	123	java/lang/Throwable
    //   115	120	123	java/lang/Throwable
    //   2	46	145	finally
    //   49	115	145	finally
    //   115	120	145	finally
    //   124	142	145	finally
  }
  
  public void a(bkdk parambkdk)
  {
    this.jdField_a_of_type_Bkdk = parambkdk;
  }
  
  public void a(bkdx parambkdx)
  {
    bkdy.a().a(parambkdx, true);
  }
  
  public void b(bkdx parambkdx)
  {
    bkdy.a().a(parambkdx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdd
 * JD-Core Version:    0.7.0.1
 */