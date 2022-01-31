import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class aoxw
  extends aoxv
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private aoxt jdField_a_of_type_Aoxt;
  private String jdField_a_of_type_JavaLangString;
  private xaz jdField_a_of_type_Xaz = new aoxx(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  
  private aoxw(aowx paramaowx, MessageRecord paramMessageRecord, int paramInt)
  {
    super(paramaowx);
    this.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
    this.jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSha");
    this.c = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.d = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize");
    this.jdField_a_of_type_Long = Long.parseLong(this.d);
    this.e = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    this.f = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    this.g = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.h = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardDuration");
    this.i = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardBusType");
    this.j = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    this.k = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter begin filename " + this.c);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a(String paramString, int paramInt)
  {
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter stopped filename " + this.c);
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  void a(String paramString, int paramInt, aoxt paramaoxt)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +32 -> 33
    //   4: ldc 98
    //   6: iconst_1
    //   7: new 100	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   14: ldc 152
    //   16: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: getfield 56	aoxw:c	Ljava/lang/String;
    //   23: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 154	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: return
    //   33: ldc 98
    //   35: iconst_1
    //   36: new 100	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   43: ldc 156
    //   45: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: getfield 56	aoxw:c	Ljava/lang/String;
    //   52: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: ldc 158
    //   63: aload_0
    //   64: getfield 96	aoxw:k	Ljava/lang/String;
    //   67: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +58 -> 128
    //   73: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +36 -> 112
    //   79: ldc 98
    //   81: iconst_1
    //   82: new 100	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   89: ldc 170
    //   91: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: getfield 56	aoxw:c	Ljava/lang/String;
    //   98: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 172
    //   103: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: aload_3
    //   113: aload_0
    //   114: getfield 68	aoxw:jdField_a_of_type_Long	J
    //   117: iconst_0
    //   118: invokestatic 179	aowx:a	(JZ)Ljava/lang/String;
    //   121: iconst_0
    //   122: invokeinterface 184 3 0
    //   127: return
    //   128: aload_0
    //   129: aload_3
    //   130: putfield 135	aoxw:jdField_a_of_type_Aoxt	Laoxt;
    //   133: aload_0
    //   134: aload_1
    //   135: invokestatic 66	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   138: putfield 144	aoxw:jdField_b_of_type_Long	J
    //   141: aload_0
    //   142: new 186	android/os/Bundle
    //   145: dup
    //   146: invokespecial 187	android/os/Bundle:<init>	()V
    //   149: putfield 132	aoxw:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   152: aload_0
    //   153: getfield 132	aoxw:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   156: ldc 40
    //   158: aload_0
    //   159: getfield 144	aoxw:jdField_b_of_type_Long	J
    //   162: invokestatic 191	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   165: invokevirtual 195	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_0
    //   169: getfield 52	aoxw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   172: ifnull +26 -> 198
    //   175: aload_0
    //   176: getfield 52	aoxw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokevirtual 198	java/lang/String:isEmpty	()Z
    //   182: ifne +16 -> 198
    //   185: aload_0
    //   186: getfield 132	aoxw:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   189: ldc 50
    //   191: aload_0
    //   192: getfield 52	aoxw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   195: invokevirtual 195	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 132	aoxw:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   202: ldc 54
    //   204: aload_0
    //   205: getfield 56	aoxw:c	Ljava/lang/String;
    //   208: invokevirtual 195	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload_0
    //   212: getfield 132	aoxw:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   215: ldc 58
    //   217: aload_0
    //   218: getfield 60	aoxw:d	Ljava/lang/String;
    //   221: invokevirtual 195	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload_0
    //   225: getfield 72	aoxw:e	Ljava/lang/String;
    //   228: invokestatic 203	apug:b	(Ljava/lang/String;)Z
    //   231: ifeq +16 -> 247
    //   234: aload_0
    //   235: getfield 132	aoxw:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   238: ldc 70
    //   240: aload_0
    //   241: getfield 72	aoxw:e	Ljava/lang/String;
    //   244: invokevirtual 195	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload_0
    //   248: getfield 76	aoxw:f	Ljava/lang/String;
    //   251: invokevirtual 198	java/lang/String:isEmpty	()Z
    //   254: ifne +16 -> 270
    //   257: aload_0
    //   258: getfield 132	aoxw:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   261: ldc 74
    //   263: aload_0
    //   264: getfield 84	aoxw:h	Ljava/lang/String;
    //   267: invokevirtual 195	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_0
    //   271: getfield 80	aoxw:g	Ljava/lang/String;
    //   274: invokevirtual 198	java/lang/String:isEmpty	()Z
    //   277: ifne +16 -> 293
    //   280: aload_0
    //   281: getfield 132	aoxw:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   284: ldc 78
    //   286: aload_0
    //   287: getfield 84	aoxw:h	Ljava/lang/String;
    //   290: invokevirtual 195	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_0
    //   294: getfield 84	aoxw:h	Ljava/lang/String;
    //   297: invokevirtual 198	java/lang/String:isEmpty	()Z
    //   300: ifne +16 -> 316
    //   303: aload_0
    //   304: getfield 132	aoxw:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   307: ldc 82
    //   309: aload_0
    //   310: getfield 84	aoxw:h	Ljava/lang/String;
    //   313: invokevirtual 195	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: iload_2
    //   317: ifne +165 -> 482
    //   320: aload_0
    //   321: getfield 132	aoxw:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   324: ldc 205
    //   326: iconst_1
    //   327: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   330: invokevirtual 195	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload_0
    //   334: getfield 48	aoxw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   337: invokestatic 66	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   340: lstore 4
    //   342: aload_0
    //   343: getfield 92	aoxw:j	Ljava/lang/String;
    //   346: invokevirtual 198	java/lang/String:isEmpty	()Z
    //   349: ifeq +49 -> 398
    //   352: ldc 98
    //   354: iconst_1
    //   355: new 100	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   362: ldc 210
    //   364: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: getfield 56	aoxw:c	Ljava/lang/String;
    //   371: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 154	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: aload_0
    //   381: getfield 135	aoxw:jdField_a_of_type_Aoxt	Laoxt;
    //   384: aload_0
    //   385: getfield 68	aoxw:jdField_a_of_type_Long	J
    //   388: iconst_1
    //   389: invokestatic 179	aowx:a	(JZ)Ljava/lang/String;
    //   392: iconst_0
    //   393: invokeinterface 184 3 0
    //   398: aload_0
    //   399: getfield 88	aoxw:i	Ljava/lang/String;
    //   402: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   405: istore_2
    //   406: ldc 98
    //   408: iconst_1
    //   409: new 100	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   416: ldc 218
    //   418: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_0
    //   422: getfield 56	aoxw:c	Ljava/lang/String;
    //   425: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: ldc 220
    //   430: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_0
    //   434: getfield 92	aoxw:j	Ljava/lang/String;
    //   437: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: ldc 222
    //   442: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: aload_0
    //   452: getfield 28	aoxw:jdField_a_of_type_Aowx	Laowx;
    //   455: invokestatic 225	aowx:a	(Laowx;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   458: lload 4
    //   460: iload_2
    //   461: aload_0
    //   462: getfield 92	aoxw:j	Ljava/lang/String;
    //   465: aload_0
    //   466: getfield 144	aoxw:jdField_b_of_type_Long	J
    //   469: aload_0
    //   470: getfield 120	aoxw:jdField_a_of_type_Int	I
    //   473: aconst_null
    //   474: aload_0
    //   475: getfield 38	aoxw:jdField_a_of_type_Xaz	Lxaz;
    //   478: invokestatic 230	xam:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JILjava/lang/String;JILandroid/os/Bundle;Lxaz;)V
    //   481: return
    //   482: iload_2
    //   483: sipush 3000
    //   486: if_icmpne +19 -> 505
    //   489: aload_0
    //   490: getfield 132	aoxw:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   493: ldc 205
    //   495: iconst_2
    //   496: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   499: invokevirtual 195	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: goto -169 -> 333
    //   505: iload_2
    //   506: iconst_1
    //   507: if_icmpne -174 -> 333
    //   510: aload_0
    //   511: getfield 132	aoxw:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   514: ldc 205
    //   516: iconst_3
    //   517: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   520: invokevirtual 195	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: goto -190 -> 333
    //   526: astore_1
    //   527: ldc 98
    //   529: iconst_1
    //   530: new 100	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   537: ldc 232
    //   539: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_0
    //   543: getfield 48	aoxw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   546: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc 234
    //   551: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload_0
    //   555: getfield 56	aoxw:c	Ljava/lang/String;
    //   558: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 154	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: aload_0
    //   568: getfield 135	aoxw:jdField_a_of_type_Aoxt	Laoxt;
    //   571: aload_0
    //   572: getfield 68	aoxw:jdField_a_of_type_Long	J
    //   575: iconst_0
    //   576: invokestatic 179	aowx:a	(JZ)Ljava/lang/String;
    //   579: iconst_0
    //   580: invokeinterface 184 3 0
    //   585: return
    //   586: astore_1
    //   587: ldc 98
    //   589: iconst_1
    //   590: new 100	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   597: ldc 236
    //   599: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: iconst_0
    //   603: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: ldc 234
    //   608: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload_0
    //   612: getfield 56	aoxw:c	Ljava/lang/String;
    //   615: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 154	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   624: aload_0
    //   625: getfield 135	aoxw:jdField_a_of_type_Aoxt	Laoxt;
    //   628: aload_0
    //   629: getfield 68	aoxw:jdField_a_of_type_Long	J
    //   632: iconst_0
    //   633: invokestatic 179	aowx:a	(JZ)Ljava/lang/String;
    //   636: iconst_0
    //   637: invokeinterface 184 3 0
    //   642: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	643	0	this	aoxw
    //   0	643	1	paramString	String
    //   0	643	2	paramInt	int
    //   0	643	3	paramaoxt	aoxt
    //   340	119	4	l1	long
    // Exception table:
    //   from	to	target	type
    //   333	342	526	java/lang/NumberFormatException
    //   398	406	586	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxw
 * JD-Core Version:    0.7.0.1
 */