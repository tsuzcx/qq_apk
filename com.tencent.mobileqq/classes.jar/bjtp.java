import android.content.Context;

public class bjtp
{
  private static volatile bjtp jdField_a_of_type_Bjtp;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private bjtt jdField_a_of_type_Bjtt;
  private bjtx jdField_a_of_type_Bjtx;
  private boolean jdField_a_of_type_Boolean;
  
  public static bjtp a()
  {
    if (jdField_a_of_type_Bjtp == null) {}
    try
    {
      if (jdField_a_of_type_Bjtp == null) {
        jdField_a_of_type_Bjtp = new bjtp();
      }
      return jdField_a_of_type_Bjtp;
    }
    finally {}
  }
  
  public bjty a()
  {
    bjty localbjty = null;
    if (this.jdField_a_of_type_Bjtx != null) {
      localbjty = this.jdField_a_of_type_Bjtx.a();
    }
    return localbjty;
  }
  
  public void a()
  {
    try
    {
      bjul.a().a();
      if (this.jdField_a_of_type_Bjtx != null)
      {
        this.jdField_a_of_type_Bjtx.a();
        this.jdField_a_of_type_Bjtx = null;
      }
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Bjtt = null;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(Context paramContext, long paramLong, bjtt parambjtt)
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
    //   29: invokestatic 68	bjuc:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 43	bjtp:jdField_a_of_type_Boolean	Z
    //   36: ifeq +13 -> 49
    //   39: ldc 48
    //   41: ldc 70
    //   43: invokestatic 73	bjuc:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 79	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   54: putfield 37	bjtp:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   57: aload_0
    //   58: lload_2
    //   59: putfield 39	bjtp:jdField_a_of_type_Long	J
    //   62: aload_0
    //   63: aload 4
    //   65: putfield 41	bjtp:jdField_a_of_type_Bjtt	Lbjtt;
    //   68: aload_0
    //   69: getfield 23	bjtp:jdField_a_of_type_Bjtx	Lbjtx;
    //   72: ifnonnull +39 -> 111
    //   75: new 81	bjua
    //   78: dup
    //   79: aload_0
    //   80: getfield 37	bjtp:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   83: aload_0
    //   84: getfield 39	bjtp:jdField_a_of_type_Long	J
    //   87: aload_0
    //   88: getfield 41	bjtp:jdField_a_of_type_Bjtt	Lbjtt;
    //   91: invokespecial 83	bjua:<init>	(Landroid/content/Context;JLbjtt;)V
    //   94: astore_1
    //   95: aload_0
    //   96: new 25	bjtx
    //   99: dup
    //   100: aload_0
    //   101: getfield 37	bjtp:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   104: aload_1
    //   105: invokespecial 86	bjtx:<init>	(Landroid/content/Context;Lbjua;)V
    //   108: putfield 23	bjtp:jdField_a_of_type_Bjtx	Lbjtx;
    //   111: aload_0
    //   112: iconst_1
    //   113: putfield 43	bjtp:jdField_a_of_type_Boolean	Z
    //   116: goto -70 -> 46
    //   119: astore_1
    //   120: ldc 48
    //   122: ldc 88
    //   124: aload_1
    //   125: invokestatic 91	bjuc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 23	bjtp:jdField_a_of_type_Bjtx	Lbjtx;
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 43	bjtp:jdField_a_of_type_Boolean	Z
    //   138: goto -92 -> 46
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	bjtp
    //   0	146	1	paramContext	Context
    //   0	146	2	paramLong	long
    //   0	146	4	parambjtt	bjtt
    // Exception table:
    //   from	to	target	type
    //   49	111	119	java/lang/Throwable
    //   111	116	119	java/lang/Throwable
    //   2	46	141	finally
    //   49	111	141	finally
    //   111	116	141	finally
    //   120	138	141	finally
  }
  
  public void a(bjtx parambjtx)
  {
    this.jdField_a_of_type_Bjtx = parambjtx;
  }
  
  public void a(bjuk parambjuk)
  {
    bjul.a().a(parambjuk, true);
  }
  
  public void b(bjuk parambjuk)
  {
    bjul.a().a(parambjuk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjtp
 * JD-Core Version:    0.7.0.1
 */