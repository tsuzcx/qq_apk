import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class babd
{
  private static ArrayList<babe> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private static boolean jdField_a_of_type_Boolean = true;
  private static ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_b_of_type_Boolean;
  private static boolean c;
  private static boolean d;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  }
  
  public static void a()
  {
    try
    {
      babc localbabc = babb.a();
      if (localbabc.jdField_a_of_type_Boolean) {
        jdField_a_of_type_Boolean = babc.a(localbabc);
      }
      ArrayList localArrayList = babf.a().jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        jdField_b_of_type_JavaUtilArrayList.clear();
        jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
      }
      jdField_b_of_type_Boolean = ((Boolean)bdne.a("study_mode_key_user_switch", Boolean.valueOf(false))).booleanValue();
      c = ((Boolean)bdne.a("study_mode_key_student_mask", Boolean.valueOf(false))).booleanValue();
      d = babl.a.a();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 2, String.format("init ,sStudyModeConfigSwitch = %b,sStudyModeSwitch = %b,sStudentMask = %b,sBlackIds = %s,configHas = %b,sShowStudyModeSwitchDialog = %b", new Object[] { Boolean.valueOf(jdField_a_of_type_Boolean), Boolean.valueOf(jdField_b_of_type_Boolean), Boolean.valueOf(c), jdField_b_of_type_JavaUtilArrayList.toString(), Boolean.valueOf(localbabc.jdField_a_of_type_Boolean), Boolean.valueOf(d) }));
      }
      return;
    }
    finally {}
  }
  
  public static void a(babe parambabe)
  {
    try
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(parambabe)) {
        jdField_a_of_type_JavaUtilArrayList.add(parambabe);
      }
      return;
    }
    finally
    {
      parambabe = finally;
      throw parambabe;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((babe)localIterator.next()).a(paramBoolean);
      }
    }
    finally {}
  }
  
  /* Error */
  public static void a(boolean paramBoolean, com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +25 -> 31
    //   9: ldc 109
    //   11: iconst_2
    //   12: ldc 152
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_0
    //   21: invokestatic 72	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 121	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: getstatic 24	babd:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: invokevirtual 155	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   37: istore_2
    //   38: iload_2
    //   39: ifne +7 -> 46
    //   42: ldc 2
    //   44: monitorexit
    //   45: return
    //   46: getstatic 83	babd:jdField_b_of_type_Boolean	Z
    //   49: iload_0
    //   50: if_icmpeq -8 -> 42
    //   53: ldc 66
    //   55: iload_0
    //   56: invokestatic 72	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: invokestatic 158	bdne:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   62: iload_0
    //   63: putstatic 83	babd:jdField_b_of_type_Boolean	Z
    //   66: getstatic 17	babd:jdField_a_of_type_Boolean	Z
    //   69: ifeq +7 -> 76
    //   72: iload_0
    //   73: invokestatic 159	babd:a	(Z)V
    //   76: aload_1
    //   77: ifnull -35 -> 42
    //   80: aload_1
    //   81: bipush 87
    //   83: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   86: checkcast 166	ambm
    //   89: iconst_1
    //   90: iconst_0
    //   91: invokevirtual 169	ambm:a	(ZZ)V
    //   94: goto -52 -> 42
    //   97: astore_1
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramBoolean	boolean
    //   0	103	1	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   37	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	31	97	finally
    //   31	38	97	finally
    //   46	76	97	finally
    //   80	94	97	finally
  }
  
  public static boolean a()
  {
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a();
    }
    if (jdField_a_of_type_Boolean) {
      return jdField_b_of_type_Boolean;
    }
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return false;
    }
    if (a()) {}
    for (;;)
    {
      try
      {
        if (jdField_b_of_type_JavaUtilArrayList.size() > 0)
        {
          bool = jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt));
          if (QLog.isColorLevel()) {
            QLog.d("StudyModeManager", 2, String.format("init ,studyModeSwitch = %b,notifyID = %d,blackResult = %b,sBlackIds = %s", new Object[] { Boolean.valueOf(jdField_a_of_type_Boolean), Integer.valueOf(paramInt), Boolean.valueOf(bool), jdField_b_of_type_JavaUtilArrayList.toString() }));
          }
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StudyModeManager", 2, localThrowable, new Object[0]);
        }
      }
      boolean bool = false;
    }
  }
  
  public static void b(babe parambabe)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilArrayList.contains(parambabe)) {
        jdField_a_of_type_JavaUtilArrayList.remove(parambabe);
      }
      return;
    }
    finally
    {
      parambabe = finally;
      throw parambabe;
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyModeManager", 2, String.format("setstudent mask = %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    bdne.a("study_mode_key_student_mask", Boolean.valueOf(paramBoolean));
  }
  
  public static boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static void c(boolean paramBoolean)
  {
    try
    {
      jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean c()
  {
    d = babl.a.a();
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babd
 * JD-Core Version:    0.7.0.1
 */