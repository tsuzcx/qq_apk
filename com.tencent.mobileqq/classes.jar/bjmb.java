import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.business.cgireport.ReportManager.1;
import java.util.ArrayList;
import java.util.Random;

public class bjmb
{
  protected static bjmb a;
  public static final String a;
  public int a;
  protected long a;
  public bjlz a;
  public volatile ArrayList<bjmc> a;
  protected Random a;
  public boolean a;
  protected volatile ArrayList<bjmc> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = bjmb.class.getName();
  }
  
  public bjmb()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Bjlz = new bjlz();
    this.jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public static bjmb a()
  {
    try
    {
      if (jdField_a_of_type_Bjmb == null) {
        jdField_a_of_type_Bjmb = new bjmb();
      }
      bjmb localbjmb = jdField_a_of_type_Bjmb;
      return localbjmb;
    }
    finally {}
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == 0)
    {
      i = bjlt.a(bizw.a().a(), null).a("Common_CGIReportFrequencySuccess");
      bjko.c("OpenConfig_agent", "config 4:Common_CGIReportFrequencySuccess     config_value:" + i);
      paramInt = i;
      if (i == 0) {
        paramInt = 10;
      }
      bjko.c("OpenConfig_agent", "config 4:Common_CGIReportFrequencySuccess     result_value:" + paramInt);
      return paramInt;
    }
    int i = bjlt.a(bizw.a().a(), null).a("Common_CGIReportFrequencyFailed");
    bjko.c("OpenConfig_agent", "config 4:Common_CGIReportFrequencyFailed     config_value:" + i);
    paramInt = i;
    if (i == 0) {
      paramInt = 100;
    }
    bjko.c("OpenConfig_agent", "config 4:Common_CGIReportFrequencyFailed     result_value:" + paramInt);
    return paramInt;
  }
  
  /* Error */
  protected Bundle a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 111
    //   4: ldc 113
    //   6: invokestatic 115	bjko:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 47	bjmb:jdField_a_of_type_Bjlz	Lbjlz;
    //   14: aload_1
    //   15: invokevirtual 118	bjlz:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   18: putfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   21: aload_0
    //   22: getfield 47	bjmb:jdField_a_of_type_Bjlz	Lbjlz;
    //   25: aload_1
    //   26: invokevirtual 121	bjlz:b	(Ljava/lang/String;)Z
    //   29: pop
    //   30: aload_0
    //   31: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   34: invokevirtual 125	java/util/ArrayList:size	()I
    //   37: ifgt +16 -> 53
    //   40: ldc 111
    //   42: ldc 127
    //   44: invokestatic 115	bjko:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 47	bjmb:jdField_a_of_type_Bjlz	Lbjlz;
    //   58: aload_1
    //   59: invokevirtual 129	bjlz:b	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   62: putfield 42	bjmb:b	Ljava/util/ArrayList;
    //   65: aload_0
    //   66: getfield 47	bjmb:jdField_a_of_type_Bjlz	Lbjlz;
    //   69: aload_1
    //   70: invokevirtual 131	bjlz:a	(Ljava/lang/String;)Z
    //   73: pop
    //   74: new 133	android/os/Bundle
    //   77: dup
    //   78: invokespecial 134	android/os/Bundle:<init>	()V
    //   81: astore 5
    //   83: aload 5
    //   85: ldc 136
    //   87: aload_1
    //   88: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload 5
    //   93: ldc 141
    //   95: getstatic 144	bjly:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   98: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 5
    //   103: ldc 146
    //   105: getstatic 151	android/os/Build:DEVICE	Ljava/lang/String;
    //   108: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload 5
    //   113: ldc 153
    //   115: getstatic 155	bjly:b	Ljava/lang/String;
    //   118: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload 5
    //   123: ldc 157
    //   125: ldc 159
    //   127: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: iconst_0
    //   131: istore_3
    //   132: iload_3
    //   133: aload_0
    //   134: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   137: invokevirtual 125	java/util/ArrayList:size	()I
    //   140: if_icmpge +417 -> 557
    //   143: aload 5
    //   145: new 79	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   152: iload_3
    //   153: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: ldc 161
    //   158: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: aload_0
    //   165: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   168: iload_3
    //   169: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   172: checkcast 167	bjmc
    //   175: getfield 168	bjmc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   178: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload 5
    //   183: new 79	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   190: iload_3
    //   191: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc 170
    //   196: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: aload_0
    //   203: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   206: iload_3
    //   207: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   210: checkcast 167	bjmc
    //   213: getfield 171	bjmc:b	Ljava/lang/String;
    //   216: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload 5
    //   221: new 79	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   228: iload_3
    //   229: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc 173
    //   234: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: aload_0
    //   241: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   244: iload_3
    //   245: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   248: checkcast 167	bjmc
    //   251: getfield 175	bjmc:c	Ljava/lang/String;
    //   254: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload 5
    //   259: new 79	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   266: iload_3
    //   267: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: ldc 177
    //   272: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: aload_0
    //   279: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   282: iload_3
    //   283: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   286: checkcast 167	bjmc
    //   289: getfield 180	bjmc:d	Ljava/lang/String;
    //   292: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload 5
    //   297: new 79	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   304: iload_3
    //   305: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc 182
    //   310: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: aload_0
    //   317: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   320: iload_3
    //   321: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   324: checkcast 167	bjmc
    //   327: getfield 185	bjmc:e	Ljava/lang/String;
    //   330: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload 5
    //   335: new 79	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   342: iload_3
    //   343: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: ldc 187
    //   348: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: aload_0
    //   355: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   358: iload_3
    //   359: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   362: checkcast 167	bjmc
    //   365: getfield 190	bjmc:f	Ljava/lang/String;
    //   368: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload 5
    //   373: new 79	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   380: iload_3
    //   381: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: ldc 192
    //   386: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: aload_0
    //   393: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   396: iload_3
    //   397: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   400: checkcast 167	bjmc
    //   403: getfield 195	bjmc:g	Ljava/lang/String;
    //   406: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: aload 5
    //   411: new 79	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   418: iload_3
    //   419: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: ldc 197
    //   424: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: aload_0
    //   431: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   434: iload_3
    //   435: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   438: checkcast 167	bjmc
    //   441: getfield 200	bjmc:j	Ljava/lang/String;
    //   444: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload 5
    //   449: new 79	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   456: iload_3
    //   457: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   460: ldc 202
    //   462: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: aload_0
    //   469: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   472: iload_3
    //   473: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   476: checkcast 167	bjmc
    //   479: getfield 205	bjmc:h	Ljava/lang/String;
    //   482: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: new 79	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   492: iload_2
    //   493: invokestatic 210	bjls:a	(Z)Ljava/lang/String;
    //   496: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: ldc 212
    //   501: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload_0
    //   505: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   508: iload_3
    //   509: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   512: checkcast 167	bjmc
    //   515: getfield 215	bjmc:i	Ljava/lang/String;
    //   518: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: astore_1
    //   525: aload 5
    //   527: new 79	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   534: iload_3
    //   535: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc 217
    //   540: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: aload_1
    //   547: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: iload_3
    //   551: iconst_1
    //   552: iadd
    //   553: istore_3
    //   554: goto -422 -> 132
    //   557: aload_0
    //   558: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   561: invokevirtual 125	java/util/ArrayList:size	()I
    //   564: istore_3
    //   565: iload_3
    //   566: aload_0
    //   567: getfield 42	bjmb:b	Ljava/util/ArrayList;
    //   570: invokevirtual 125	java/util/ArrayList:size	()I
    //   573: aload_0
    //   574: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   577: invokevirtual 125	java/util/ArrayList:size	()I
    //   580: iadd
    //   581: if_icmpge +453 -> 1034
    //   584: iload_3
    //   585: aload_0
    //   586: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   589: invokevirtual 125	java/util/ArrayList:size	()I
    //   592: isub
    //   593: istore 4
    //   595: aload 5
    //   597: new 79	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   604: iload_3
    //   605: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   608: ldc 161
    //   610: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: aload_0
    //   617: getfield 42	bjmb:b	Ljava/util/ArrayList;
    //   620: iload 4
    //   622: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   625: checkcast 167	bjmc
    //   628: getfield 168	bjmc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   631: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: aload 5
    //   636: new 79	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   643: iload_3
    //   644: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   647: ldc 170
    //   649: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: aload_0
    //   656: getfield 42	bjmb:b	Ljava/util/ArrayList;
    //   659: iload 4
    //   661: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   664: checkcast 167	bjmc
    //   667: getfield 171	bjmc:b	Ljava/lang/String;
    //   670: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: aload 5
    //   675: new 79	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   682: iload_3
    //   683: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   686: ldc 173
    //   688: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: aload_0
    //   695: getfield 42	bjmb:b	Ljava/util/ArrayList;
    //   698: iload 4
    //   700: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   703: checkcast 167	bjmc
    //   706: getfield 175	bjmc:c	Ljava/lang/String;
    //   709: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   712: aload 5
    //   714: new 79	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   721: iload_3
    //   722: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   725: ldc 177
    //   727: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: aload_0
    //   734: getfield 42	bjmb:b	Ljava/util/ArrayList;
    //   737: iload 4
    //   739: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   742: checkcast 167	bjmc
    //   745: getfield 180	bjmc:d	Ljava/lang/String;
    //   748: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload 5
    //   753: new 79	java/lang/StringBuilder
    //   756: dup
    //   757: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   760: iload_3
    //   761: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: ldc 182
    //   766: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: aload_0
    //   773: getfield 42	bjmb:b	Ljava/util/ArrayList;
    //   776: iload 4
    //   778: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   781: checkcast 167	bjmc
    //   784: getfield 185	bjmc:e	Ljava/lang/String;
    //   787: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   790: aload 5
    //   792: new 79	java/lang/StringBuilder
    //   795: dup
    //   796: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   799: iload_3
    //   800: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   803: ldc 187
    //   805: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: aload_0
    //   812: getfield 42	bjmb:b	Ljava/util/ArrayList;
    //   815: iload 4
    //   817: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   820: checkcast 167	bjmc
    //   823: getfield 190	bjmc:f	Ljava/lang/String;
    //   826: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   829: aload 5
    //   831: new 79	java/lang/StringBuilder
    //   834: dup
    //   835: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   838: iload_3
    //   839: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   842: ldc 192
    //   844: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: aload_0
    //   851: getfield 42	bjmb:b	Ljava/util/ArrayList;
    //   854: iload 4
    //   856: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   859: checkcast 167	bjmc
    //   862: getfield 195	bjmc:g	Ljava/lang/String;
    //   865: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   868: aload 5
    //   870: new 79	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   877: iload_3
    //   878: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   881: ldc 197
    //   883: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: aload_0
    //   890: getfield 42	bjmb:b	Ljava/util/ArrayList;
    //   893: iload 4
    //   895: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   898: checkcast 167	bjmc
    //   901: getfield 200	bjmc:j	Ljava/lang/String;
    //   904: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   907: aload 5
    //   909: new 79	java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   916: iload_3
    //   917: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: ldc 202
    //   922: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   928: aload_0
    //   929: getfield 42	bjmb:b	Ljava/util/ArrayList;
    //   932: iload 4
    //   934: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   937: checkcast 167	bjmc
    //   940: getfield 205	bjmc:h	Ljava/lang/String;
    //   943: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   946: new 79	java/lang/StringBuilder
    //   949: dup
    //   950: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   953: iload_2
    //   954: invokestatic 210	bjls:a	(Z)Ljava/lang/String;
    //   957: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: ldc 212
    //   962: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: aload_0
    //   966: getfield 40	bjmb:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   969: iload 4
    //   971: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   974: checkcast 167	bjmc
    //   977: getfield 215	bjmc:i	Ljava/lang/String;
    //   980: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   986: astore_1
    //   987: aload 5
    //   989: new 79	java/lang/StringBuilder
    //   992: dup
    //   993: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   996: iload_3
    //   997: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1000: ldc 217
    //   1002: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: aload_1
    //   1009: invokevirtual 139	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1012: iload_3
    //   1013: iconst_1
    //   1014: iadd
    //   1015: istore_3
    //   1016: goto -451 -> 565
    //   1019: astore_1
    //   1020: getstatic 25	bjmb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1023: ldc 219
    //   1025: aload_1
    //   1026: invokestatic 222	bjko:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1029: aconst_null
    //   1030: astore_1
    //   1031: goto -982 -> 49
    //   1034: ldc 111
    //   1036: ldc 224
    //   1038: invokestatic 115	bjko:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1041: aload 5
    //   1043: astore_1
    //   1044: goto -995 -> 49
    //   1047: astore_1
    //   1048: aload_0
    //   1049: monitorexit
    //   1050: aload_1
    //   1051: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1052	0	this	bjmb
    //   0	1052	1	paramString	String
    //   0	1052	2	paramBoolean	boolean
    //   131	885	3	i	int
    //   593	377	4	j	int
    //   81	961	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   83	130	1019	java/lang/Exception
    //   132	550	1019	java/lang/Exception
    //   557	565	1019	java/lang/Exception
    //   565	1012	1019	java/lang/Exception
    //   2	47	1047	finally
    //   53	83	1047	finally
    //   83	130	1047	finally
    //   132	550	1047	finally
    //   557	565	1047	finally
    //   565	1012	1047	finally
    //   1020	1029	1047	finally
    //   1034	1041	1047	finally
  }
  
  protected String a()
  {
    return AppNetConnInfo.getCurrentAPN();
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3)
  {
    a(paramString1, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramString2, paramString3, false);
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      b(paramString1, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramString2, paramString3);
      if (!this.jdField_a_of_type_Boolean) {
        break label35;
      }
    }
    label35:
    while ((!a()) && (!a(paramString2))) {
      return;
    }
    a(paramString2, paramBoolean);
  }
  
  protected void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    ThreadManager.executeOnNetWorkThread(new ReportManager.1(this, paramString1, paramBundle));
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    bjko.b("cgi_report_debug", "ReportManager doUpload start");
    paramString = a(paramString, paramBoolean);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    a("https://wspeed.qq.com/w.cgi", "POST", paramString);
  }
  
  protected boolean a()
  {
    long l2 = bjlt.a(bizw.a().a(), null).a("Common_CGIReportTimeinterval");
    bjko.c("OpenConfig_agent", "config 5:Common_CGIReportTimeinterval     config_value:" + l2);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1200L;
    }
    bjko.c("OpenConfig_agent", "config 5:Common_CGIReportTimeinterval     result_value:" + l1);
    l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_a_of_type_Long == 0L) || (l1 + this.jdField_a_of_type_Long <= l2))
    {
      this.jdField_a_of_type_Long = l2;
      bjko.b("cgi_report_debug", "ReportManager availableForTime = ture");
      return true;
    }
    bjko.b("cgi_report_debug", "ReportManager availableForTime = false");
    return false;
  }
  
  protected boolean a(int paramInt)
  {
    paramInt = a(paramInt);
    if (this.jdField_a_of_type_JavaUtilRandom.nextInt(100) < paramInt)
    {
      bjko.b("cgi_report_debug", "ReportManager availableForFrequency = ture");
      return true;
    }
    bjko.b("cgi_report_debug", "ReportManager availableForFrequency = false");
    return false;
  }
  
  protected boolean a(String paramString)
  {
    int j = bjlt.a(bizw.a().a(), null).a("Common_CGIReportMaxcount");
    bjko.c("OpenConfig_agent", "config 6:Common_CGIReportMaxcount     config_value:" + j);
    int i = j;
    if (j == 0) {
      i = 20;
    }
    bjko.c("OpenConfig_agent", "config 6:Common_CGIReportMaxcount     result_value:" + i);
    if (this.jdField_a_of_type_Bjlz.a(paramString) >= i)
    {
      bjko.b("cgi_report_debug", "ReportManager availableForCount = ture");
      return true;
    }
    bjko.b("cgi_report_debug", "ReportManager availableForCount = false");
    return false;
  }
  
  protected void b(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3)
  {
    paramLong1 = SystemClock.elapsedRealtime() - paramLong1;
    bjko.b("cgi_report_debug", "ReportManager updateDB url=" + paramString1 + ",resultCode=" + paramInt + ",timeCost=" + paramLong1 + ",reqSize=" + paramLong2 + ",rspSize=" + paramLong3);
    int i = 100 / a(paramInt);
    if (i <= 0) {
      i = 1;
    }
    for (;;)
    {
      String str = a();
      this.jdField_a_of_type_Bjlz.a(str, i + "", paramString1, paramInt + "", paramLong1 + "", paramLong2 + "", paramLong3 + "", paramLong4 + "", paramString3, paramString2);
      return;
      if (i > 100) {
        i = 100;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjmb
 * JD-Core Version:    0.7.0.1
 */