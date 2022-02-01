import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class bcoo
{
  private static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString;
  private static ArrayList<bcoq> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private static boolean jdField_a_of_type_Boolean = true;
  private static int jdField_b_of_type_Int;
  private static String jdField_b_of_type_JavaLangString;
  private static ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_b_of_type_Boolean;
  private static boolean c;
  private static boolean d;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  }
  
  public static int a()
  {
    try
    {
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        a();
      }
      int i = jdField_a_of_type_Int;
      return i;
    }
    finally {}
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void a()
  {
    try
    {
      bcon localbcon = bcom.a();
      if (localbcon.jdField_a_of_type_Boolean) {
        jdField_a_of_type_Boolean = bcon.a(localbcon);
      }
      ArrayList localArrayList = bcor.a().jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        jdField_b_of_type_JavaUtilArrayList.clear();
        jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
      }
      jdField_b_of_type_Boolean = ((Boolean)bfyz.a("study_mode_key_user_switch", Boolean.valueOf(false))).booleanValue();
      c = ((Boolean)bfyz.a("study_mode_key_student_mask", Boolean.valueOf(false))).booleanValue();
      jdField_a_of_type_Int = ((Integer)bfyz.a("kid_mode_key_need_verify_phone", Integer.valueOf(-1))).intValue();
      d = bcox.a.a();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 2, String.format("init ,sStudyModeConfigSwitch = %b,sStudyModeSwitch = %b,sStudentMask = %b,sBlackIds = %s,configHas = %b,sShowStudyModeSwitchDialog = %b", new Object[] { Boolean.valueOf(jdField_a_of_type_Boolean), Boolean.valueOf(jdField_b_of_type_Boolean), Boolean.valueOf(c), "sBlackIds.toString()", Boolean.valueOf(localbcon.jdField_a_of_type_Boolean), Boolean.valueOf(d) }));
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +25 -> 31
    //   9: ldc 133
    //   11: iconst_1
    //   12: iconst_2
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: ldc 149
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: iload_0
    //   24: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   31: getstatic 30	bcoo:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: invokevirtual 43	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   37: istore_1
    //   38: iload_1
    //   39: ifne +7 -> 46
    //   42: ldc 2
    //   44: monitorexit
    //   45: return
    //   46: getstatic 21	bcoo:jdField_a_of_type_Int	I
    //   49: iload_0
    //   50: if_icmpeq -8 -> 42
    //   53: ldc 103
    //   55: iload_0
    //   56: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: invokestatic 155	bfyz:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   62: iload_0
    //   63: putstatic 21	bcoo:jdField_a_of_type_Int	I
    //   66: goto -24 -> 42
    //   69: astore_2
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramInt	int
    //   37	2	1	bool	boolean
    //   69	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	31	69	finally
    //   31	38	69	finally
    //   46	66	69	finally
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 1, new Object[] { "setIsBindPhone: ", Integer.valueOf(paramInt) });
      }
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        a();
      }
      jdField_b_of_type_Int = paramInt;
      jdField_a_of_type_JavaLangString = paramString1;
      jdField_b_of_type_JavaLangString = paramString2;
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (paramBoolean) {
          break label116;
        }
      }
      break;
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      bfyz.a((String)localObject, Boolean.valueOf(bool));
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 2, "updateAdvanceSettingSwitch, mask: " + paramInt + ", isSupport: " + paramBoolean);
      }
      return;
      localObject = "search_friend_flag";
      break;
      localObject = "search_by_stranger_flag";
      break;
      localObject = "invite_to_troop_by_stranger_flag";
      break;
    }
  }
  
  public static void a(bcoq parambcoq)
  {
    try
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(parambcoq)) {
        jdField_a_of_type_JavaUtilArrayList.add(parambcoq);
      }
      return;
    }
    finally
    {
      parambcoq = finally;
      throw parambcoq;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bcoq)localIterator.next()).a(paramBoolean);
      }
    }
    finally {}
  }
  
  /* Error */
  public static void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +25 -> 31
    //   9: ldc 133
    //   11: iconst_2
    //   12: ldc 221
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_0
    //   21: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 143	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: getstatic 30	bcoo:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: invokevirtual 43	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   37: istore_2
    //   38: iload_2
    //   39: ifne +7 -> 46
    //   42: ldc 2
    //   44: monitorexit
    //   45: return
    //   46: getstatic 97	bcoo:jdField_b_of_type_Boolean	Z
    //   49: iload_0
    //   50: if_icmpeq -8 -> 42
    //   53: ldc 81
    //   55: iload_0
    //   56: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: invokestatic 155	bfyz:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   62: iload_0
    //   63: putstatic 97	bcoo:jdField_b_of_type_Boolean	Z
    //   66: getstatic 19	bcoo:jdField_a_of_type_Boolean	Z
    //   69: ifeq +7 -> 76
    //   72: iload_0
    //   73: invokestatic 222	bcoo:a	(Z)V
    //   76: aload_1
    //   77: ifnull -35 -> 42
    //   80: aload_1
    //   81: bipush 87
    //   83: invokevirtual 228	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   86: checkcast 230	amzu
    //   89: iconst_1
    //   90: iconst_0
    //   91: iconst_0
    //   92: invokevirtual 233	amzu:a	(ZZI)V
    //   95: goto -53 -> 42
    //   98: astore_1
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramBoolean	boolean
    //   0	104	1	paramQQAppInterface	QQAppInterface
    //   37	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	31	98	finally
    //   31	38	98	finally
    //   46	76	98	finally
    //   80	95	98	finally
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      ((bbyj)paramQQAppInterface.getBusinessHandler(154)).a(false, 0, false, true);
      QLog.e("StudyModeManager", 1, "[KidMode]checkAbnormalFlag both true");
      return true;
    }
    return false;
  }
  
  public static int b()
  {
    return jdField_b_of_type_Int;
  }
  
  public static String b()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public static void b()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
    if (QLog.isDevelopLevel()) {
      QLog.d("StudyModeManager", 4, new Object[] { "needReportAdvanceSettingStatus : ", Boolean.valueOf(e()) });
    }
    if (e())
    {
      if (!b(16)) {
        break label198;
      }
      i = 1;
      bfyz.a("kid_mode_advance_setting", localSimpleDateFormat.format(new Date()));
      bcef.b(null, "dc00898", "", "", "0X800B3D5", "0X800B3D5", 0, i, "", "", "", "");
      if (!b(32)) {
        break label203;
      }
      i = 1;
      label121:
      bcef.b(null, "dc00898", "", "", "0X800B3D6", "0X800B3D6", 0, i, "", "", "", "");
      if (!b(8)) {
        break label208;
      }
    }
    label198:
    label203:
    label208:
    for (int i = 1;; i = 0)
    {
      bcef.b(null, "dc00898", "", "", "0X800B3D7", "0X800B3D7", 0, i, "", "", "", "");
      return;
      i = 0;
      break;
      i = 0;
      break label121;
    }
  }
  
  public static void b(bcoq parambcoq)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilArrayList.contains(parambcoq)) {
        jdField_a_of_type_JavaUtilArrayList.remove(parambcoq);
      }
      return;
    }
    finally
    {
      parambcoq = finally;
      throw parambcoq;
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyModeManager", 2, String.format("setstudent mask = %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    bfyz.a("study_mode_key_student_mask", Boolean.valueOf(paramBoolean));
  }
  
  public static boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean b(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      boolean bool = ((Boolean)bfyz.a((String)localObject, Boolean.valueOf(true))).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 2, "getAdvanceSettingSwitch, mask: " + paramInt + ", isChecked: " + bool);
      }
      return bool;
      localObject = "search_friend_flag";
      continue;
      localObject = "search_by_stranger_flag";
      continue;
      localObject = "invite_to_troop_by_stranger_flag";
    }
    return false;
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
    d = bcox.a.a();
    return d;
  }
  
  public static boolean d()
  {
    boolean bool1;
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyModeManager", 2, "isBanSearchFriend: it isn't in kid mode");
      }
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = b(8);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("StudyModeManager", 2, "isBanSearchFriend: " + bool2);
    return bool2;
  }
  
  public static boolean e()
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(new Date());
    Object localObject = (String)bfyz.a("kid_mode_advance_setting", "");
    if (QLog.isDevelopLevel()) {
      QLog.d("StudyModeManager", 4, new Object[] { "calendar in sp : ", localObject });
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse((String)localObject);
        Calendar localCalendar2 = Calendar.getInstance();
        localCalendar2.setTime((Date)localObject);
        if ((localCalendar2.get(0) == localCalendar1.get(0)) && (localCalendar2.get(1) == localCalendar1.get(1)))
        {
          int i = localCalendar2.get(6);
          int j = localCalendar1.get(6);
          if (i == j) {
            return false;
          }
        }
      }
      catch (ParseException localParseException)
      {
        QLog.e("StudyModeManager", 1, new Object[] { "simpleDateFormat parse error : ", localParseException.toString() });
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcoo
 * JD-Core Version:    0.7.0.1
 */