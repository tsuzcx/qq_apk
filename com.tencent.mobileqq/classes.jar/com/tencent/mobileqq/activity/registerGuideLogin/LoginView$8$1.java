package com.tencent.mobileqq.activity.registerGuideLogin;

import ajjm;

public class LoginView$8$1
  implements Runnable
{
  public LoginView$8$1(ajjm paramajjm) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 25	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: ldc 27
    //   5: invokestatic 32	aowf:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   8: ifle +194 -> 202
    //   11: new 34	android/content/Intent
    //   14: dup
    //   15: ldc 36
    //   17: invokespecial 39	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginView$8$1:a	Lajjm;
    //   26: getfield 44	ajjm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: invokestatic 50	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   32: invokevirtual 54	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   35: pop
    //   36: aload_0
    //   37: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginView$8$1:a	Lajjm;
    //   40: getfield 57	ajjm:jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginView;
    //   43: getfield 62	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   46: aload_2
    //   47: invokevirtual 68	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   50: iconst_1
    //   51: istore_1
    //   52: aload_0
    //   53: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginView$8$1:a	Lajjm;
    //   56: getfield 57	ajjm:jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginView;
    //   59: getfield 71	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   62: ldc 73
    //   64: ldc 75
    //   66: ldc 75
    //   68: ldc 77
    //   70: ldc 77
    //   72: iconst_0
    //   73: iconst_0
    //   74: ldc 75
    //   76: ldc 75
    //   78: ldc 75
    //   80: ldc 75
    //   82: invokestatic 82	azmj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   85: iload_1
    //   86: ifne +103 -> 189
    //   89: aload_0
    //   90: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginView$8$1:a	Lajjm;
    //   93: getfield 57	ajjm:jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginView;
    //   96: getfield 71	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   99: ldc 73
    //   101: ldc 75
    //   103: ldc 75
    //   105: ldc 84
    //   107: ldc 84
    //   109: iconst_0
    //   110: iconst_0
    //   111: ldc 75
    //   113: ldc 75
    //   115: ldc 75
    //   117: ldc 75
    //   119: invokestatic 82	azmj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   122: new 34	android/content/Intent
    //   125: dup
    //   126: aload_0
    //   127: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginView$8$1:a	Lajjm;
    //   130: getfield 57	ajjm:jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginView;
    //   133: getfield 62	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   136: ldc 86
    //   138: invokespecial 89	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   141: astore_2
    //   142: aload_2
    //   143: ldc 91
    //   145: aload_0
    //   146: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginView$8$1:a	Lajjm;
    //   149: getfield 94	ajjm:b	Ljava/lang/String;
    //   152: invokevirtual 98	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: new 100	amll
    //   159: dup
    //   160: aload_0
    //   161: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginView$8$1:a	Lajjm;
    //   164: getfield 103	ajjm:c	Ljava/lang/String;
    //   167: aconst_null
    //   168: invokespecial 106	amll:<init>	(Ljava/lang/String;Lamlm;)V
    //   171: invokestatic 111	bfju:a	(Lbfjs;)Z
    //   174: pop
    //   175: aload_0
    //   176: getfield 12	com/tencent/mobileqq/activity/registerGuideLogin/LoginView$8$1:a	Lajjm;
    //   179: getfield 57	ajjm:jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView	Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginView;
    //   182: getfield 62	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   185: aload_2
    //   186: invokevirtual 68	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   189: return
    //   190: astore_2
    //   191: iconst_0
    //   192: istore_1
    //   193: goto -108 -> 85
    //   196: astore_2
    //   197: iconst_1
    //   198: istore_1
    //   199: goto -6 -> 193
    //   202: iconst_0
    //   203: istore_1
    //   204: goto -119 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	1
    //   51	153	1	i	int
    //   20	166	2	localIntent	android.content.Intent
    //   190	1	2	localException1	java.lang.Exception
    //   196	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   36	50	190	java/lang/Exception
    //   52	85	196	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.8.1
 * JD-Core Version:    0.7.0.1
 */