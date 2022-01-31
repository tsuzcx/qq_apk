class aoyx
  extends aoun
{
  aoyx(aoyw paramaoyw) {}
  
  /* Error */
  protected void a(boolean paramBoolean, int paramInt1, java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, java.lang.String paramString4, java.lang.String paramString5, int paramInt2, java.lang.String paramString6, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 20	apei:a	Z
    //   5: ifeq +229 -> 234
    //   8: ldc 22
    //   10: astore 9
    //   12: ldc 24
    //   14: astore 13
    //   16: aconst_null
    //   17: astore 7
    //   19: aload 7
    //   21: astore 6
    //   23: aload_0
    //   24: getfield 10	aoyx:a	Laoyw;
    //   27: getfield 29	aoyw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: invokestatic 33	apei:f	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   33: ifeq +92 -> 125
    //   36: aload 7
    //   38: astore 6
    //   40: aload 10
    //   42: ifnull +83 -> 125
    //   45: aload 10
    //   47: ldc 35
    //   49: invokevirtual 41	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 14
    //   54: aload 10
    //   56: ldc 43
    //   58: iconst_0
    //   59: invokevirtual 47	android/os/Bundle:getShort	(Ljava/lang/String;S)S
    //   62: istore 12
    //   64: aload 7
    //   66: astore 6
    //   68: aload 14
    //   70: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   73: ifne +52 -> 125
    //   76: iload 12
    //   78: istore 11
    //   80: iload 12
    //   82: ifne +8 -> 90
    //   85: sipush 443
    //   88: istore 11
    //   90: new 37	android/os/Bundle
    //   93: dup
    //   94: invokespecial 54	android/os/Bundle:<init>	()V
    //   97: astore 6
    //   99: aload 6
    //   101: ldc 56
    //   103: iconst_1
    //   104: invokevirtual 60	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   107: aload 6
    //   109: ldc 62
    //   111: aload 14
    //   113: invokevirtual 66	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload 6
    //   118: ldc 68
    //   120: iload 11
    //   122: invokevirtual 72	android/os/Bundle:putShort	(Ljava/lang/String;S)V
    //   125: aload 6
    //   127: astore 14
    //   129: aload 10
    //   131: ifnull +57 -> 188
    //   134: aload 10
    //   136: ldc 74
    //   138: ldc 76
    //   140: invokevirtual 79	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 10
    //   145: aload 6
    //   147: astore 7
    //   149: aload 6
    //   151: ifnonnull +12 -> 163
    //   154: new 37	android/os/Bundle
    //   157: dup
    //   158: invokespecial 54	android/os/Bundle:<init>	()V
    //   161: astore 7
    //   163: aload 7
    //   165: astore 14
    //   167: aload 10
    //   169: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifne +16 -> 188
    //   175: aload 7
    //   177: ldc 81
    //   179: aload 10
    //   181: invokevirtual 66	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 7
    //   186: astore 14
    //   188: aload_0
    //   189: getfield 10	aoyx:a	Laoyw;
    //   192: getfield 84	aoyw:jdField_a_of_type_Aooq	Laooq;
    //   195: ifnull +36 -> 231
    //   198: aload_0
    //   199: getfield 10	aoyx:a	Laoyw;
    //   202: getfield 84	aoyw:jdField_a_of_type_Aooq	Laooq;
    //   205: iload_1
    //   206: aload 9
    //   208: aload 13
    //   210: iload_2
    //   211: i2l
    //   212: aload_3
    //   213: aload 5
    //   215: aload 4
    //   217: aload_0
    //   218: getfield 10	aoyx:a	Laoyw;
    //   221: getfield 88	aoyw:b	Ljava/lang/String;
    //   224: aload 14
    //   226: invokeinterface 93 11 0
    //   231: aload_0
    //   232: monitorexit
    //   233: return
    //   234: aload 6
    //   236: ifnull +35 -> 271
    //   239: aload 6
    //   241: invokevirtual 99	java/lang/String:length	()I
    //   244: ifle +27 -> 271
    //   247: aload 6
    //   249: ldc 101
    //   251: invokevirtual 105	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   254: ifne +17 -> 271
    //   257: iload 8
    //   259: invokestatic 109	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   262: astore 13
    //   264: aload 6
    //   266: astore 9
    //   268: goto -252 -> 16
    //   271: aload 7
    //   273: astore 6
    //   275: goto -18 -> 257
    //   278: astore_3
    //   279: aload_0
    //   280: monitorexit
    //   281: aload_3
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	aoyx
    //   0	283	1	paramBoolean	boolean
    //   0	283	2	paramInt1	int
    //   0	283	3	paramString1	java.lang.String
    //   0	283	4	paramString2	java.lang.String
    //   0	283	5	paramString3	java.lang.String
    //   0	283	6	paramString4	java.lang.String
    //   0	283	7	paramString5	java.lang.String
    //   0	283	8	paramInt2	int
    //   0	283	9	paramString6	java.lang.String
    //   0	283	10	paramBundle	android.os.Bundle
    //   78	43	11	s1	short
    //   62	19	12	s2	short
    //   14	249	13	str1	java.lang.String
    //   52	173	14	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	8	278	finally
    //   23	36	278	finally
    //   45	64	278	finally
    //   68	76	278	finally
    //   90	125	278	finally
    //   134	145	278	finally
    //   154	163	278	finally
    //   167	184	278	finally
    //   188	231	278	finally
    //   239	257	278	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoyx
 * JD-Core Version:    0.7.0.1
 */