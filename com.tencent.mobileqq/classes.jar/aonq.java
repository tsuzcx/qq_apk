import android.content.DialogInterface.OnDismissListener;

public class aonq
{
  private static DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new aonr();
  private static aons jdField_a_of_type_Aons;
  
  public static void a()
  {
    if ((jdField_a_of_type_Aons != null) && (jdField_a_of_type_Aons.isShowing())) {
      jdField_a_of_type_Aons.dismiss();
    }
  }
  
  /* Error */
  public static boolean a(com.tencent.mobileqq.app.BaseActivity paramBaseActivity, java.util.ArrayList<com.tencent.mobileqq.data.QIMNotifyAddFriend> paramArrayList)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: getstatic 20	aonq:jdField_a_of_type_Aons	Laons;
    //   9: ifnull +25 -> 34
    //   12: getstatic 20	aonq:jdField_a_of_type_Aons	Laons;
    //   15: invokevirtual 26	aons:isShowing	()Z
    //   18: ifeq +16 -> 34
    //   21: getstatic 20	aonq:jdField_a_of_type_Aons	Laons;
    //   24: aload_1
    //   25: invokevirtual 33	aons:a	(Ljava/util/List;)Z
    //   28: istore_3
    //   29: ldc 2
    //   31: monitorexit
    //   32: iload_3
    //   33: ireturn
    //   34: iconst_0
    //   35: istore_3
    //   36: iload_3
    //   37: istore_2
    //   38: aload_1
    //   39: ifnull +41 -> 80
    //   42: iload_3
    //   43: istore_2
    //   44: aload_1
    //   45: invokevirtual 39	java/util/ArrayList:size	()I
    //   48: ifle +32 -> 80
    //   51: new 22	aons
    //   54: dup
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 42	aons:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Ljava/util/ArrayList;)V
    //   60: putstatic 20	aonq:jdField_a_of_type_Aons	Laons;
    //   63: getstatic 20	aonq:jdField_a_of_type_Aons	Laons;
    //   66: getstatic 16	aonq:jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener	Landroid/content/DialogInterface$OnDismissListener;
    //   69: invokevirtual 46	aons:setOnDismissListener	(Landroid/content/DialogInterface$OnDismissListener;)V
    //   72: getstatic 20	aonq:jdField_a_of_type_Aons	Laons;
    //   75: invokevirtual 49	aons:show	()V
    //   78: iconst_1
    //   79: istore_2
    //   80: iload 4
    //   82: istore_3
    //   83: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq -57 -> 29
    //   89: ldc 56
    //   91: iconst_2
    //   92: new 58	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   99: ldc 61
    //   101: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload_2
    //   105: invokevirtual 68	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   108: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 76	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: iload 4
    //   116: istore_3
    //   117: goto -88 -> 29
    //   120: astore_0
    //   121: ldc 2
    //   123: monitorexit
    //   124: aload_0
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramBaseActivity	com.tencent.mobileqq.app.BaseActivity
    //   0	126	1	paramArrayList	java.util.ArrayList<com.tencent.mobileqq.data.QIMNotifyAddFriend>
    //   37	68	2	bool1	boolean
    //   28	89	3	bool2	boolean
    //   1	114	4	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   6	29	120	finally
    //   44	78	120	finally
    //   83	114	120	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aonq
 * JD-Core Version:    0.7.0.1
 */