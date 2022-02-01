import android.content.Context;

public class biin
{
  private static volatile biin jdField_a_of_type_Biin;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private biir jdField_a_of_type_Biir;
  private biiv jdField_a_of_type_Biiv;
  private boolean jdField_a_of_type_Boolean;
  
  public static biin a()
  {
    if (jdField_a_of_type_Biin == null) {}
    try
    {
      if (jdField_a_of_type_Biin == null) {
        jdField_a_of_type_Biin = new biin();
      }
      return jdField_a_of_type_Biin;
    }
    finally {}
  }
  
  public biiw a()
  {
    biiw localbiiw = null;
    if (this.jdField_a_of_type_Biiv != null) {
      localbiiw = this.jdField_a_of_type_Biiv.a();
    }
    return localbiiw;
  }
  
  public void a()
  {
    try
    {
      bijj.a().a();
      if (this.jdField_a_of_type_Biiv != null)
      {
        this.jdField_a_of_type_Biiv.a();
        this.jdField_a_of_type_Biiv = null;
      }
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Biir = null;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(Context paramContext, long paramLong, biir parambiir)
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
    //   29: invokestatic 68	bija:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 43	biin:jdField_a_of_type_Boolean	Z
    //   36: ifeq +13 -> 49
    //   39: ldc 48
    //   41: ldc 70
    //   43: invokestatic 73	bija:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 79	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   54: putfield 37	biin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   57: aload_0
    //   58: lload_2
    //   59: putfield 39	biin:jdField_a_of_type_Long	J
    //   62: aload_0
    //   63: aload 4
    //   65: putfield 41	biin:jdField_a_of_type_Biir	Lbiir;
    //   68: aload_0
    //   69: getfield 23	biin:jdField_a_of_type_Biiv	Lbiiv;
    //   72: ifnonnull +39 -> 111
    //   75: new 81	biiy
    //   78: dup
    //   79: aload_0
    //   80: getfield 37	biin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   83: aload_0
    //   84: getfield 39	biin:jdField_a_of_type_Long	J
    //   87: aload_0
    //   88: getfield 41	biin:jdField_a_of_type_Biir	Lbiir;
    //   91: invokespecial 83	biiy:<init>	(Landroid/content/Context;JLbiir;)V
    //   94: astore_1
    //   95: aload_0
    //   96: new 25	biiv
    //   99: dup
    //   100: aload_0
    //   101: getfield 37	biin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   104: aload_1
    //   105: invokespecial 86	biiv:<init>	(Landroid/content/Context;Lbiiy;)V
    //   108: putfield 23	biin:jdField_a_of_type_Biiv	Lbiiv;
    //   111: aload_0
    //   112: iconst_1
    //   113: putfield 43	biin:jdField_a_of_type_Boolean	Z
    //   116: goto -70 -> 46
    //   119: astore_1
    //   120: ldc 48
    //   122: ldc 88
    //   124: aload_1
    //   125: invokestatic 91	bija:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 23	biin:jdField_a_of_type_Biiv	Lbiiv;
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 43	biin:jdField_a_of_type_Boolean	Z
    //   138: goto -92 -> 46
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	biin
    //   0	146	1	paramContext	Context
    //   0	146	2	paramLong	long
    //   0	146	4	parambiir	biir
    // Exception table:
    //   from	to	target	type
    //   49	111	119	java/lang/Throwable
    //   111	116	119	java/lang/Throwable
    //   2	46	141	finally
    //   49	111	141	finally
    //   111	116	141	finally
    //   120	138	141	finally
  }
  
  public void a(biiv parambiiv)
  {
    this.jdField_a_of_type_Biiv = parambiiv;
  }
  
  public void a(biji parambiji)
  {
    bijj.a().a(parambiji, true);
  }
  
  public void b(biji parambiji)
  {
    bijj.a().a(parambiji);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biin
 * JD-Core Version:    0.7.0.1
 */