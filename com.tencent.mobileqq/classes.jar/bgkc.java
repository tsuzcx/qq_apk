import com.tencent.mobileqq.app.QQAppInterface;

public class bgkc
{
  public static bgkc a;
  public anrc a;
  public QQAppInterface a;
  
  public bgkc()
  {
    this.jdField_a_of_type_Anrc = new bgkd(this);
  }
  
  /* Error */
  public static bgkc a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 23	bgkc:jdField_a_of_type_Bgkc	Lbgkc;
    //   6: ifnonnull +16 -> 22
    //   9: aload_0
    //   10: invokestatic 27	bgkc:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   13: getstatic 23	bgkc:jdField_a_of_type_Bgkc	Lbgkc;
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: getstatic 23	bgkc:jdField_a_of_type_Bgkc	Lbgkc;
    //   25: getfield 29	bgkc:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   28: aload_0
    //   29: if_acmpeq -16 -> 13
    //   32: getstatic 23	bgkc:jdField_a_of_type_Bgkc	Lbgkc;
    //   35: getfield 29	bgkc:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: ifnull +25 -> 63
    //   41: getstatic 23	bgkc:jdField_a_of_type_Bgkc	Lbgkc;
    //   44: getfield 29	bgkc:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   47: getstatic 23	bgkc:jdField_a_of_type_Bgkc	Lbgkc;
    //   50: getfield 19	bgkc:jdField_a_of_type_Anrc	Lanrc;
    //   53: invokevirtual 35	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   56: getstatic 23	bgkc:jdField_a_of_type_Bgkc	Lbgkc;
    //   59: aconst_null
    //   60: putfield 29	bgkc:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: aconst_null
    //   64: putstatic 23	bgkc:jdField_a_of_type_Bgkc	Lbgkc;
    //   67: aload_0
    //   68: invokestatic 27	bgkc:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   71: goto -58 -> 13
    //   74: astore_0
    //   75: ldc 2
    //   77: monitorexit
    //   78: aload_0
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   3	13	74	finally
    //   13	17	74	finally
    //   22	63	74	finally
    //   63	71	74	finally
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Bgkc != null)
    {
      paramQQAppInterface.removeObserver(jdField_a_of_type_Bgkc.jdField_a_of_type_Anrc);
      jdField_a_of_type_Bgkc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_Bgkc = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Bgkc = new bgkc();
    jdField_a_of_type_Bgkc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(jdField_a_of_type_Bgkc.jdField_a_of_type_Anrc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkc
 * JD-Core Version:    0.7.0.1
 */