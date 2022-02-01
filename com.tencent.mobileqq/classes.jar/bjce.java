import android.content.Context;

public class bjce
{
  private static volatile bjce jdField_a_of_type_Bjce;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private bjci jdField_a_of_type_Bjci;
  private bjcl jdField_a_of_type_Bjcl;
  private boolean jdField_a_of_type_Boolean;
  
  public static bjce a()
  {
    if (jdField_a_of_type_Bjce == null) {}
    try
    {
      if (jdField_a_of_type_Bjce == null) {
        jdField_a_of_type_Bjce = new bjce();
      }
      return jdField_a_of_type_Bjce;
    }
    finally {}
  }
  
  public bjcm a()
  {
    bjcm localbjcm = null;
    if (this.jdField_a_of_type_Bjcl != null) {
      localbjcm = this.jdField_a_of_type_Bjcl.a();
    }
    return localbjcm;
  }
  
  public void a()
  {
    try
    {
      bjcz.a().a();
      if (this.jdField_a_of_type_Bjcl != null)
      {
        this.jdField_a_of_type_Bjcl.a();
        this.jdField_a_of_type_Bjcl = null;
      }
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Bjci = null;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(Context paramContext, long paramLong, bjci parambjci)
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
    //   29: invokestatic 68	bjcq:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 43	bjce:jdField_a_of_type_Boolean	Z
    //   36: ifeq +13 -> 49
    //   39: ldc 48
    //   41: ldc 70
    //   43: invokestatic 73	bjcq:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 79	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   54: putfield 37	bjce:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   57: aload_0
    //   58: lload_2
    //   59: putfield 39	bjce:jdField_a_of_type_Long	J
    //   62: aload_0
    //   63: aload 4
    //   65: putfield 41	bjce:jdField_a_of_type_Bjci	Lbjci;
    //   68: aload_0
    //   69: getfield 23	bjce:jdField_a_of_type_Bjcl	Lbjcl;
    //   72: ifnonnull +43 -> 115
    //   75: new 81	bjco
    //   78: dup
    //   79: aload_0
    //   80: getfield 37	bjce:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   83: aload_0
    //   84: getfield 39	bjce:jdField_a_of_type_Long	J
    //   87: aload_0
    //   88: getfield 41	bjce:jdField_a_of_type_Bjci	Lbjci;
    //   91: invokespecial 83	bjco:<init>	(Landroid/content/Context;JLbjci;)V
    //   94: astore_1
    //   95: aload_0
    //   96: new 25	bjcl
    //   99: dup
    //   100: aload_0
    //   101: getfield 37	bjce:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   104: aload_0
    //   105: getfield 41	bjce:jdField_a_of_type_Bjci	Lbjci;
    //   108: aload_1
    //   109: invokespecial 86	bjcl:<init>	(Landroid/content/Context;Lbjci;Lbjco;)V
    //   112: putfield 23	bjce:jdField_a_of_type_Bjcl	Lbjcl;
    //   115: aload_0
    //   116: iconst_1
    //   117: putfield 43	bjce:jdField_a_of_type_Boolean	Z
    //   120: goto -74 -> 46
    //   123: astore_1
    //   124: ldc 48
    //   126: ldc 88
    //   128: aload_1
    //   129: invokestatic 91	bjcq:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload_0
    //   133: aconst_null
    //   134: putfield 23	bjce:jdField_a_of_type_Bjcl	Lbjcl;
    //   137: aload_0
    //   138: iconst_0
    //   139: putfield 43	bjce:jdField_a_of_type_Boolean	Z
    //   142: goto -96 -> 46
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	bjce
    //   0	150	1	paramContext	Context
    //   0	150	2	paramLong	long
    //   0	150	4	parambjci	bjci
    // Exception table:
    //   from	to	target	type
    //   49	115	123	java/lang/Throwable
    //   115	120	123	java/lang/Throwable
    //   2	46	145	finally
    //   49	115	145	finally
    //   115	120	145	finally
    //   124	142	145	finally
  }
  
  public void a(bjcl parambjcl)
  {
    this.jdField_a_of_type_Bjcl = parambjcl;
  }
  
  public void a(bjcy parambjcy)
  {
    bjcz.a().a(parambjcy, true);
  }
  
  public void b(bjcy parambjcy)
  {
    bjcz.a().a(parambjcy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjce
 * JD-Core Version:    0.7.0.1
 */