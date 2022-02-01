package com.tencent.mobileqq.apollo.view.opengl;

import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class GLThread
  extends Thread
{
  private int jdField_a_of_type_Int;
  private EglHelper jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper;
  private final GLThreadManager jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private WeakReference<GLRenderView> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<Runnable> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o = true;
  private boolean p = false;
  private boolean q;
  private boolean r = true;
  
  GLThread(GLThreadManager paramGLThreadManager, WeakReference<GLRenderView> paramWeakReference)
  {
    setName("GLThread " + getId());
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.l = true;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWeakReference.get());
    this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager = paramGLThreadManager;
  }
  
  private boolean b()
  {
    return (!this.d) && (this.e) && (!this.f) && (this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0) && ((this.l) || (this.jdField_c_of_type_Int == 1));
  }
  
  private void h()
  {
    if (this.i)
    {
      this.i = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper.b();
    }
  }
  
  private void i()
  {
    if (this.h)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper.c();
      this.h = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.b(this);
    }
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 112	com/tencent/mobileqq/apollo/view/opengl/EglHelper
    //   4: dup
    //   5: aload_0
    //   6: getfield 92	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 130	com/tencent/mobileqq/apollo/view/opengl/EglHelper:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 116	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 108	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 132	com/tencent/mobileqq/apollo/view/opengl/GLThread:m	Z
    //   30: iconst_0
    //   31: istore 10
    //   33: aconst_null
    //   34: astore 23
    //   36: iconst_0
    //   37: istore_2
    //   38: iconst_0
    //   39: istore 5
    //   41: aconst_null
    //   42: astore 22
    //   44: iconst_0
    //   45: istore_3
    //   46: iconst_0
    //   47: istore_1
    //   48: aconst_null
    //   49: astore 21
    //   51: iconst_0
    //   52: istore 4
    //   54: iconst_0
    //   55: istore 6
    //   57: iconst_0
    //   58: istore 7
    //   60: iconst_0
    //   61: istore 8
    //   63: iconst_0
    //   64: istore 9
    //   66: aload_0
    //   67: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   70: astore 25
    //   72: aload 25
    //   74: monitorenter
    //   75: iload 10
    //   77: istore 11
    //   79: iload 9
    //   81: istore 12
    //   83: iload 8
    //   85: istore 9
    //   87: iload 7
    //   89: istore 10
    //   91: iload 6
    //   93: istore 8
    //   95: iload 5
    //   97: istore 13
    //   99: aload_0
    //   100: getfield 134	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_b_of_type_Boolean	Z
    //   103: ifeq +35 -> 138
    //   106: aload 25
    //   108: monitorexit
    //   109: aload_0
    //   110: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   113: astore 21
    //   115: aload 21
    //   117: monitorenter
    //   118: aload_0
    //   119: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   122: aload_0
    //   123: invokespecial 138	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	()V
    //   126: aload 21
    //   128: monitorexit
    //   129: return
    //   130: astore 22
    //   132: aload 21
    //   134: monitorexit
    //   135: aload 22
    //   137: athrow
    //   138: aload_0
    //   139: getfield 41	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   142: invokevirtual 141	java/util/ArrayList:isEmpty	()Z
    //   145: ifne +125 -> 270
    //   148: aload_0
    //   149: getfield 41	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   152: iconst_0
    //   153: invokevirtual 145	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   156: checkcast 147	java/lang/Runnable
    //   159: astore 24
    //   161: iload_1
    //   162: istore 5
    //   164: iload_3
    //   165: istore_1
    //   166: aload 22
    //   168: astore 21
    //   170: iload 13
    //   172: istore 7
    //   174: iload_2
    //   175: istore_3
    //   176: iload 10
    //   178: istore 6
    //   180: iload 4
    //   182: istore_2
    //   183: aload 24
    //   185: astore 22
    //   187: iload 11
    //   189: istore 10
    //   191: iload 5
    //   193: istore 4
    //   195: iload 12
    //   197: istore 5
    //   199: aload 25
    //   201: monitorexit
    //   202: aload 22
    //   204: ifnull +1035 -> 1239
    //   207: aload 22
    //   209: invokeinterface 150 1 0
    //   214: iload_1
    //   215: istore 13
    //   217: iload 4
    //   219: istore_1
    //   220: aconst_null
    //   221: astore 24
    //   223: iload_2
    //   224: istore 4
    //   226: iload 6
    //   228: istore 11
    //   230: iload 5
    //   232: istore 12
    //   234: aload 21
    //   236: astore 22
    //   238: aload 24
    //   240: astore 21
    //   242: iload_3
    //   243: istore_2
    //   244: iload 13
    //   246: istore_3
    //   247: iload 7
    //   249: istore 5
    //   251: iload 8
    //   253: istore 6
    //   255: iload 11
    //   257: istore 7
    //   259: iload 9
    //   261: istore 8
    //   263: iload 12
    //   265: istore 9
    //   267: goto -201 -> 66
    //   270: aload_0
    //   271: getfield 104	com/tencent/mobileqq/apollo/view/opengl/GLThread:d	Z
    //   274: aload_0
    //   275: getfield 152	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_c_of_type_Boolean	Z
    //   278: if_icmpeq +1541 -> 1819
    //   281: aload_0
    //   282: getfield 152	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_c_of_type_Boolean	Z
    //   285: istore 19
    //   287: aload_0
    //   288: aload_0
    //   289: getfield 152	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_c_of_type_Boolean	Z
    //   292: putfield 104	com/tencent/mobileqq/apollo/view/opengl/GLThread:d	Z
    //   295: aload_0
    //   296: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   299: invokevirtual 157	java/lang/Object:notifyAll	()V
    //   302: iload 4
    //   304: istore 5
    //   306: aload_0
    //   307: getfield 159	com/tencent/mobileqq/apollo/view/opengl/GLThread:k	Z
    //   310: ifeq +19 -> 329
    //   313: aload_0
    //   314: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   317: aload_0
    //   318: invokespecial 138	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	()V
    //   321: aload_0
    //   322: iconst_0
    //   323: putfield 159	com/tencent/mobileqq/apollo/view/opengl/GLThread:k	Z
    //   326: iconst_1
    //   327: istore 5
    //   329: iload 10
    //   331: istore 7
    //   333: iload 10
    //   335: ifeq +14 -> 349
    //   338: aload_0
    //   339: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   342: aload_0
    //   343: invokespecial 138	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	()V
    //   346: iconst_0
    //   347: istore 7
    //   349: iload 19
    //   351: ifeq +14 -> 365
    //   354: aload_0
    //   355: getfield 108	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   358: ifeq +7 -> 365
    //   361: aload_0
    //   362: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   365: iload 19
    //   367: ifeq +49 -> 416
    //   370: aload_0
    //   371: getfield 116	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   374: ifeq +42 -> 416
    //   377: aload_0
    //   378: getfield 92	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   381: invokevirtual 87	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   384: checkcast 161	com/tencent/mobileqq/apollo/view/opengl/GLRenderView
    //   387: astore 24
    //   389: aload 24
    //   391: ifnonnull +424 -> 815
    //   394: iconst_0
    //   395: istore 20
    //   397: iload 20
    //   399: ifeq +13 -> 412
    //   402: aload_0
    //   403: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   406: invokevirtual 163	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	()Z
    //   409: ifeq +7 -> 416
    //   412: aload_0
    //   413: invokespecial 138	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	()V
    //   416: iload 19
    //   418: ifeq +20 -> 438
    //   421: aload_0
    //   422: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   425: invokevirtual 165	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:b	()Z
    //   428: ifeq +10 -> 438
    //   431: aload_0
    //   432: getfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   435: invokevirtual 118	com/tencent/mobileqq/apollo/view/opengl/EglHelper:c	()V
    //   438: aload_0
    //   439: getfield 101	com/tencent/mobileqq/apollo/view/opengl/GLThread:e	Z
    //   442: ifne +72 -> 514
    //   445: aload_0
    //   446: getfield 167	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   449: ifne +65 -> 514
    //   452: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq +31 -> 486
    //   458: ldc 174
    //   460: iconst_2
    //   461: new 51	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   468: ldc 176
    //   470: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_0
    //   474: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   477: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   480: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: aload_0
    //   487: getfield 108	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   490: ifeq +7 -> 497
    //   493: aload_0
    //   494: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   497: aload_0
    //   498: iconst_1
    //   499: putfield 167	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   502: aload_0
    //   503: iconst_0
    //   504: putfield 106	com/tencent/mobileqq/apollo/view/opengl/GLThread:f	Z
    //   507: aload_0
    //   508: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   511: invokevirtual 157	java/lang/Object:notifyAll	()V
    //   514: aload_0
    //   515: getfield 101	com/tencent/mobileqq/apollo/view/opengl/GLThread:e	Z
    //   518: ifeq +22 -> 540
    //   521: aload_0
    //   522: getfield 167	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   525: ifeq +15 -> 540
    //   528: aload_0
    //   529: iconst_0
    //   530: putfield 167	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   533: aload_0
    //   534: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   537: invokevirtual 157	java/lang/Object:notifyAll	()V
    //   540: iload 13
    //   542: istore 6
    //   544: iload 13
    //   546: ifeq +23 -> 569
    //   549: aload_0
    //   550: iconst_0
    //   551: putfield 132	com/tencent/mobileqq/apollo/view/opengl/GLThread:m	Z
    //   554: iconst_0
    //   555: istore 6
    //   557: aload_0
    //   558: iconst_1
    //   559: putfield 181	com/tencent/mobileqq/apollo/view/opengl/GLThread:n	Z
    //   562: aload_0
    //   563: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   566: invokevirtual 157	java/lang/Object:notifyAll	()V
    //   569: aload_0
    //   570: getfield 45	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   573: ifnull +1243 -> 1816
    //   576: aload_0
    //   577: getfield 45	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   580: astore 22
    //   582: aload_0
    //   583: aconst_null
    //   584: putfield 45	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   587: aload_0
    //   588: invokespecial 182	com/tencent/mobileqq/apollo/view/opengl/GLThread:b	()Z
    //   591: ifeq +379 -> 970
    //   594: iload 5
    //   596: istore 4
    //   598: iload 11
    //   600: istore 10
    //   602: aload_0
    //   603: getfield 116	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   606: ifne +15 -> 621
    //   609: iload 5
    //   611: ifeq +216 -> 827
    //   614: iconst_0
    //   615: istore 4
    //   617: iload 11
    //   619: istore 10
    //   621: iload 8
    //   623: istore 13
    //   625: iload 9
    //   627: istore 5
    //   629: iload 12
    //   631: istore 11
    //   633: aload_0
    //   634: getfield 116	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   637: ifeq +36 -> 673
    //   640: iload 8
    //   642: istore 13
    //   644: iload 9
    //   646: istore 5
    //   648: iload 12
    //   650: istore 11
    //   652: aload_0
    //   653: getfield 108	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   656: ifne +17 -> 673
    //   659: aload_0
    //   660: iconst_1
    //   661: putfield 108	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   664: iconst_1
    //   665: istore 11
    //   667: iconst_1
    //   668: istore 5
    //   670: iconst_1
    //   671: istore 13
    //   673: aload 22
    //   675: astore 24
    //   677: iload 4
    //   679: istore 14
    //   681: iload 13
    //   683: istore 18
    //   685: iload 5
    //   687: istore 15
    //   689: iload 11
    //   691: istore 16
    //   693: iload 10
    //   695: istore 17
    //   697: aload_0
    //   698: getfield 108	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   701: ifeq +336 -> 1037
    //   704: aload_0
    //   705: getfield 43	com/tencent/mobileqq/apollo/view/opengl/GLThread:o	Z
    //   708: ifeq +1105 -> 1813
    //   711: iconst_1
    //   712: istore 13
    //   714: aload_0
    //   715: getfield 75	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_Int	I
    //   718: istore_3
    //   719: aload_0
    //   720: getfield 77	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_b_of_type_Int	I
    //   723: istore_2
    //   724: aload_0
    //   725: iconst_1
    //   726: putfield 132	com/tencent/mobileqq/apollo/view/opengl/GLThread:m	Z
    //   729: iconst_1
    //   730: istore 11
    //   732: aload_0
    //   733: iconst_0
    //   734: putfield 43	com/tencent/mobileqq/apollo/view/opengl/GLThread:o	Z
    //   737: aload_0
    //   738: iconst_0
    //   739: putfield 79	com/tencent/mobileqq/apollo/view/opengl/GLThread:l	Z
    //   742: aload_0
    //   743: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   746: invokevirtual 157	java/lang/Object:notifyAll	()V
    //   749: aload_0
    //   750: getfield 132	com/tencent/mobileqq/apollo/view/opengl/GLThread:m	Z
    //   753: ifeq +1003 -> 1756
    //   756: iload_3
    //   757: istore_1
    //   758: iconst_1
    //   759: istore 14
    //   761: iload 11
    //   763: istore_3
    //   764: iload 5
    //   766: istore 9
    //   768: iload 7
    //   770: istore 11
    //   772: iload 13
    //   774: istore 8
    //   776: iload 4
    //   778: istore 12
    //   780: aload 21
    //   782: astore 24
    //   784: iload_3
    //   785: istore 5
    //   787: iload 6
    //   789: istore 7
    //   791: iload 14
    //   793: istore 4
    //   795: aload 22
    //   797: astore 21
    //   799: aload 24
    //   801: astore 22
    //   803: iload_2
    //   804: istore_3
    //   805: iload 12
    //   807: istore_2
    //   808: iload 11
    //   810: istore 6
    //   812: goto -613 -> 199
    //   815: aload 24
    //   817: invokeinterface 185 1 0
    //   822: istore 20
    //   824: goto -427 -> 397
    //   827: aload_0
    //   828: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   831: aload_0
    //   832: invokevirtual 188	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)Z
    //   835: istore 19
    //   837: iload 5
    //   839: istore 4
    //   841: iload 11
    //   843: istore 10
    //   845: iload 19
    //   847: ifeq -226 -> 621
    //   850: aload_0
    //   851: getfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   854: invokevirtual 190	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	()V
    //   857: aload_0
    //   858: iconst_1
    //   859: putfield 116	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   862: iconst_1
    //   863: istore 10
    //   865: aload_0
    //   866: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   869: invokevirtual 157	java/lang/Object:notifyAll	()V
    //   872: iload 5
    //   874: istore 4
    //   876: goto -255 -> 621
    //   879: astore 21
    //   881: aload 25
    //   883: monitorexit
    //   884: aload 21
    //   886: athrow
    //   887: astore 22
    //   889: aload_0
    //   890: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   893: astore 21
    //   895: aload 21
    //   897: monitorenter
    //   898: aload_0
    //   899: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   902: aload_0
    //   903: invokespecial 138	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	()V
    //   906: aload 21
    //   908: monitorexit
    //   909: aload 22
    //   911: athrow
    //   912: astore 21
    //   914: ldc 174
    //   916: iconst_1
    //   917: aload 21
    //   919: invokevirtual 193	com/tencent/mobileqq/apollo/view/opengl/EglHelper$EGLException:getMessage	()Ljava/lang/String;
    //   922: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   925: aload 25
    //   927: monitorexit
    //   928: aload_0
    //   929: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   932: astore 21
    //   934: aload 21
    //   936: monitorenter
    //   937: aload_0
    //   938: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   941: aload_0
    //   942: invokespecial 138	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	()V
    //   945: aload 21
    //   947: monitorexit
    //   948: return
    //   949: astore 22
    //   951: aload 21
    //   953: monitorexit
    //   954: aload 22
    //   956: athrow
    //   957: astore 21
    //   959: aload_0
    //   960: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   963: aload_0
    //   964: invokevirtual 123	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:b	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)V
    //   967: aload 21
    //   969: athrow
    //   970: aload 22
    //   972: astore 24
    //   974: iload 5
    //   976: istore 14
    //   978: iload 8
    //   980: istore 18
    //   982: iload 9
    //   984: istore 15
    //   986: iload 12
    //   988: istore 16
    //   990: iload 11
    //   992: istore 17
    //   994: aload 22
    //   996: ifnull +41 -> 1037
    //   999: ldc 174
    //   1001: ldc 197
    //   1003: invokestatic 203	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   1006: pop
    //   1007: aload 22
    //   1009: invokeinterface 150 1 0
    //   1014: aconst_null
    //   1015: astore 24
    //   1017: iload 11
    //   1019: istore 17
    //   1021: iload 12
    //   1023: istore 16
    //   1025: iload 9
    //   1027: istore 15
    //   1029: iload 8
    //   1031: istore 18
    //   1033: iload 5
    //   1035: istore 14
    //   1037: ldc 174
    //   1039: new 51	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1046: ldc 205
    //   1048: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: aload_0
    //   1052: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   1055: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1058: ldc 207
    //   1060: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: aload_0
    //   1064: getfield 116	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   1067: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1070: ldc 212
    //   1072: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: aload_0
    //   1076: getfield 108	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   1079: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1082: ldc 214
    //   1084: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: aload_0
    //   1088: getfield 216	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	Z
    //   1091: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1094: ldc 218
    //   1096: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: aload_0
    //   1100: getfield 104	com/tencent/mobileqq/apollo/view/opengl/GLThread:d	Z
    //   1103: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1106: ldc 220
    //   1108: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: aload_0
    //   1112: getfield 101	com/tencent/mobileqq/apollo/view/opengl/GLThread:e	Z
    //   1115: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1118: ldc 222
    //   1120: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: aload_0
    //   1124: getfield 106	com/tencent/mobileqq/apollo/view/opengl/GLThread:f	Z
    //   1127: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1130: ldc 224
    //   1132: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: aload_0
    //   1136: getfield 167	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   1139: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1142: ldc 226
    //   1144: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: aload_0
    //   1148: getfield 75	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_Int	I
    //   1151: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1154: ldc 231
    //   1156: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: aload_0
    //   1160: getfield 77	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_b_of_type_Int	I
    //   1163: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1166: ldc 233
    //   1168: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: aload_0
    //   1172: getfield 79	com/tencent/mobileqq/apollo/view/opengl/GLThread:l	Z
    //   1175: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1178: ldc 235
    //   1180: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: aload_0
    //   1184: getfield 81	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_c_of_type_Int	I
    //   1187: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1190: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1193: invokestatic 237	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   1196: pop
    //   1197: aload_0
    //   1198: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1201: invokevirtual 240	java/lang/Object:wait	()V
    //   1204: aload 24
    //   1206: astore 22
    //   1208: iload 14
    //   1210: istore 4
    //   1212: iload 6
    //   1214: istore 13
    //   1216: iload 18
    //   1218: istore 8
    //   1220: iload 7
    //   1222: istore 10
    //   1224: iload 15
    //   1226: istore 9
    //   1228: iload 16
    //   1230: istore 12
    //   1232: iload 17
    //   1234: istore 11
    //   1236: goto -1137 -> 99
    //   1239: iload 5
    //   1241: ifeq +512 -> 1753
    //   1244: aload_0
    //   1245: getfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   1248: invokevirtual 241	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	()Z
    //   1251: ifeq +383 -> 1634
    //   1254: aload_0
    //   1255: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1258: astore 24
    //   1260: aload 24
    //   1262: monitorenter
    //   1263: aload_0
    //   1264: iconst_1
    //   1265: putfield 216	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	Z
    //   1268: aload_0
    //   1269: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1272: invokevirtual 157	java/lang/Object:notifyAll	()V
    //   1275: aload 24
    //   1277: monitorexit
    //   1278: iconst_0
    //   1279: istore 5
    //   1281: iload 9
    //   1283: ifeq +467 -> 1750
    //   1286: aload_0
    //   1287: getfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   1290: invokevirtual 244	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	()Ljavax/microedition/khronos/opengles/GL;
    //   1293: checkcast 246	javax/microedition/khronos/opengles/GL10
    //   1296: astore 23
    //   1298: aload_0
    //   1299: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1302: aload 23
    //   1304: invokevirtual 249	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   1307: iconst_0
    //   1308: istore 9
    //   1310: iload 10
    //   1312: istore 11
    //   1314: iload 10
    //   1316: ifeq +44 -> 1360
    //   1319: aload_0
    //   1320: getfield 92	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   1323: invokevirtual 87	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1326: checkcast 161	com/tencent/mobileqq/apollo/view/opengl/GLRenderView
    //   1329: astore 24
    //   1331: aload 24
    //   1333: ifnull +499 -> 1832
    //   1336: aload 24
    //   1338: invokeinterface 253 1 0
    //   1343: aload 23
    //   1345: aload_0
    //   1346: getfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   1349: getfield 256	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1352: invokeinterface 262 3 0
    //   1357: goto +475 -> 1832
    //   1360: iload 8
    //   1362: istore 10
    //   1364: iload 8
    //   1366: ifeq +54 -> 1420
    //   1369: aload_0
    //   1370: getfield 92	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   1373: invokevirtual 87	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1376: checkcast 161	com/tencent/mobileqq/apollo/view/opengl/GLRenderView
    //   1379: astore 24
    //   1381: aload 24
    //   1383: ifnull +455 -> 1838
    //   1386: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1389: ifeq +12 -> 1401
    //   1392: ldc 174
    //   1394: iconst_2
    //   1395: ldc_w 264
    //   1398: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1401: aload 24
    //   1403: invokeinterface 253 1 0
    //   1408: aload 23
    //   1410: iload_1
    //   1411: iload_3
    //   1412: invokeinterface 268 4 0
    //   1417: goto +421 -> 1838
    //   1420: aload_0
    //   1421: getfield 92	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   1424: invokevirtual 87	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1427: checkcast 161	com/tencent/mobileqq/apollo/view/opengl/GLRenderView
    //   1430: astore 25
    //   1432: aload 21
    //   1434: astore 24
    //   1436: aload 25
    //   1438: ifnull +45 -> 1483
    //   1441: aload 21
    //   1443: astore 24
    //   1445: aload 23
    //   1447: ifnull +36 -> 1483
    //   1450: aload 25
    //   1452: invokeinterface 253 1 0
    //   1457: aload 23
    //   1459: invokeinterface 271 2 0
    //   1464: aload 21
    //   1466: astore 24
    //   1468: aload 21
    //   1470: ifnull +13 -> 1483
    //   1473: aload 21
    //   1475: invokeinterface 150 1 0
    //   1480: aconst_null
    //   1481: astore 24
    //   1483: aload_0
    //   1484: getfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   1487: invokevirtual 274	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	()I
    //   1490: istore 12
    //   1492: iload 6
    //   1494: istore 8
    //   1496: iload 12
    //   1498: lookupswitch	default:+346->1844, 12288:+64->1562, 12302:+230->1728
    //   1525: freturn
    //   1526: ldc_w 276
    //   1529: iload 12
    //   1531: invokestatic 279	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1534: aload_0
    //   1535: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1538: astore 21
    //   1540: aload 21
    //   1542: monitorenter
    //   1543: aload_0
    //   1544: iconst_1
    //   1545: putfield 106	com/tencent/mobileqq/apollo/view/opengl/GLThread:f	Z
    //   1548: aload_0
    //   1549: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1552: invokevirtual 157	java/lang/Object:notifyAll	()V
    //   1555: aload 21
    //   1557: monitorexit
    //   1558: iload 6
    //   1560: istore 8
    //   1562: iload 4
    //   1564: ifeq +261 -> 1825
    //   1567: iconst_1
    //   1568: istore 6
    //   1570: iconst_0
    //   1571: istore 4
    //   1573: aload 22
    //   1575: astore 21
    //   1577: iload_2
    //   1578: istore 12
    //   1580: iload 8
    //   1582: istore 7
    //   1584: iload 9
    //   1586: istore 8
    //   1588: iload 5
    //   1590: istore 9
    //   1592: iload_3
    //   1593: istore_2
    //   1594: iload 6
    //   1596: istore 5
    //   1598: iload 4
    //   1600: istore 6
    //   1602: aload 24
    //   1604: astore 22
    //   1606: iload_1
    //   1607: istore_3
    //   1608: iload 12
    //   1610: istore 4
    //   1612: iload 6
    //   1614: istore_1
    //   1615: iload 10
    //   1617: istore 6
    //   1619: iload 11
    //   1621: istore 10
    //   1623: goto -1557 -> 66
    //   1626: astore 21
    //   1628: aload 24
    //   1630: monitorexit
    //   1631: aload 21
    //   1633: athrow
    //   1634: aload_0
    //   1635: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1638: astore 24
    //   1640: aload 24
    //   1642: monitorenter
    //   1643: aload_0
    //   1644: iconst_1
    //   1645: putfield 216	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	Z
    //   1648: aload_0
    //   1649: iconst_1
    //   1650: putfield 106	com/tencent/mobileqq/apollo/view/opengl/GLThread:f	Z
    //   1653: aload_0
    //   1654: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1657: invokevirtual 157	java/lang/Object:notifyAll	()V
    //   1660: aload 24
    //   1662: monitorexit
    //   1663: iload_1
    //   1664: istore 13
    //   1666: iload 4
    //   1668: istore_1
    //   1669: aload 22
    //   1671: astore 24
    //   1673: iload_2
    //   1674: istore 4
    //   1676: iload 6
    //   1678: istore 11
    //   1680: iload 5
    //   1682: istore 12
    //   1684: aload 21
    //   1686: astore 22
    //   1688: aload 24
    //   1690: astore 21
    //   1692: iload_3
    //   1693: istore_2
    //   1694: iload 13
    //   1696: istore_3
    //   1697: iload 7
    //   1699: istore 5
    //   1701: iload 8
    //   1703: istore 6
    //   1705: iload 11
    //   1707: istore 7
    //   1709: iload 9
    //   1711: istore 8
    //   1713: iload 12
    //   1715: istore 9
    //   1717: goto -1651 -> 66
    //   1720: astore 21
    //   1722: aload 24
    //   1724: monitorexit
    //   1725: aload 21
    //   1727: athrow
    //   1728: iconst_1
    //   1729: istore 8
    //   1731: goto -169 -> 1562
    //   1734: astore 22
    //   1736: aload 21
    //   1738: monitorexit
    //   1739: aload 22
    //   1741: athrow
    //   1742: astore 22
    //   1744: aload 21
    //   1746: monitorexit
    //   1747: aload 22
    //   1749: athrow
    //   1750: goto -440 -> 1310
    //   1753: goto -472 -> 1281
    //   1756: iload 11
    //   1758: istore 14
    //   1760: iload 5
    //   1762: istore 9
    //   1764: iload 7
    //   1766: istore 11
    //   1768: iload 13
    //   1770: istore 8
    //   1772: iload 4
    //   1774: istore 12
    //   1776: aload 21
    //   1778: astore 24
    //   1780: iload_1
    //   1781: istore 4
    //   1783: iload_3
    //   1784: istore_1
    //   1785: iload 14
    //   1787: istore 5
    //   1789: iload 6
    //   1791: istore 7
    //   1793: aload 22
    //   1795: astore 21
    //   1797: aload 24
    //   1799: astore 22
    //   1801: iload_2
    //   1802: istore_3
    //   1803: iload 12
    //   1805: istore_2
    //   1806: iload 11
    //   1808: istore 6
    //   1810: goto -1611 -> 199
    //   1813: goto -1076 -> 737
    //   1816: goto -1229 -> 587
    //   1819: iconst_0
    //   1820: istore 19
    //   1822: goto -1520 -> 302
    //   1825: iload 7
    //   1827: istore 6
    //   1829: goto -256 -> 1573
    //   1832: iconst_0
    //   1833: istore 11
    //   1835: goto -475 -> 1360
    //   1838: iconst_0
    //   1839: istore 10
    //   1841: goto -421 -> 1420
    //   1844: goto -320 -> 1524
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1847	0	this	GLThread
    //   47	1738	1	i1	int
    //   37	1769	2	i2	int
    //   45	1758	3	i3	int
    //   52	1730	4	i4	int
    //   39	1749	5	i5	int
    //   55	1773	6	i6	int
    //   58	1768	7	i7	int
    //   61	1710	8	i8	int
    //   64	1699	9	i9	int
    //   31	1809	10	i10	int
    //   77	1757	11	i11	int
    //   81	1723	12	i12	int
    //   97	1672	13	i13	int
    //   679	1107	14	i14	int
    //   687	538	15	i15	int
    //   691	538	16	i16	int
    //   695	538	17	i17	int
    //   683	534	18	i18	int
    //   285	1536	19	bool1	boolean
    //   395	428	20	bool2	boolean
    //   49	749	21	localObject1	Object
    //   879	6	21	localObject2	Object
    //   893	14	21	localGLThreadManager1	GLThreadManager
    //   912	6	21	localEGLException	EglHelper.EGLException
    //   957	517	21	localRuntimeException	java.lang.RuntimeException
    //   1626	59	21	localObject4	Object
    //   1690	1	21	localObject5	Object
    //   1720	57	21	localObject6	Object
    //   1795	1	21	localObject7	Object
    //   42	1	22	localObject8	Object
    //   130	37	22	localObject9	Object
    //   185	617	22	localObject10	Object
    //   887	23	22	localObject11	Object
    //   949	59	22	localObject12	Object
    //   1206	481	22	localObject13	Object
    //   1734	6	22	localObject14	Object
    //   1742	52	22	localObject15	Object
    //   1799	1	22	localObject16	Object
    //   34	1424	23	localGL10	javax.microedition.khronos.opengles.GL10
    //   70	1381	25	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   118	129	130	finally
    //   132	135	130	finally
    //   99	109	879	finally
    //   138	161	879	finally
    //   199	202	879	finally
    //   270	302	879	finally
    //   306	326	879	finally
    //   338	346	879	finally
    //   354	365	879	finally
    //   370	389	879	finally
    //   402	412	879	finally
    //   412	416	879	finally
    //   421	438	879	finally
    //   438	486	879	finally
    //   486	497	879	finally
    //   497	514	879	finally
    //   514	540	879	finally
    //   549	554	879	finally
    //   557	569	879	finally
    //   569	587	879	finally
    //   587	594	879	finally
    //   602	609	879	finally
    //   633	640	879	finally
    //   652	664	879	finally
    //   697	711	879	finally
    //   714	729	879	finally
    //   732	737	879	finally
    //   737	756	879	finally
    //   815	824	879	finally
    //   827	837	879	finally
    //   850	857	879	finally
    //   857	862	879	finally
    //   865	872	879	finally
    //   881	884	879	finally
    //   914	928	879	finally
    //   959	970	879	finally
    //   999	1014	879	finally
    //   1037	1204	879	finally
    //   66	75	887	finally
    //   207	214	887	finally
    //   884	887	887	finally
    //   1244	1263	887	finally
    //   1286	1307	887	finally
    //   1319	1331	887	finally
    //   1336	1357	887	finally
    //   1369	1381	887	finally
    //   1386	1401	887	finally
    //   1401	1417	887	finally
    //   1420	1432	887	finally
    //   1450	1464	887	finally
    //   1473	1480	887	finally
    //   1483	1492	887	finally
    //   1524	1543	887	finally
    //   1631	1634	887	finally
    //   1634	1643	887	finally
    //   1725	1728	887	finally
    //   1739	1742	887	finally
    //   850	857	912	com/tencent/mobileqq/apollo/view/opengl/EglHelper$EGLException
    //   937	948	949	finally
    //   951	954	949	finally
    //   850	857	957	java/lang/RuntimeException
    //   1263	1278	1626	finally
    //   1628	1631	1626	finally
    //   1643	1663	1720	finally
    //   1722	1725	1720	finally
    //   1543	1558	1734	finally
    //   1736	1739	1734	finally
    //   898	909	1742	finally
    //   1744	1747	1742	finally
  }
  
  public int a()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      int i1 = this.jdField_c_of_type_Int;
      return i1;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      this.l = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1)) {
      throw new IllegalArgumentException("renderMode");
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.o = true;
      this.l = true;
      this.n = false;
      if (Thread.currentThread() == this) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      for (;;)
      {
        if ((this.r) && (!this.jdField_a_of_type_Boolean) && (!this.d) && (!this.n))
        {
          boolean bool = a();
          if (bool) {
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      if (Thread.currentThread() == this) {
        return;
      }
      this.m = true;
      this.l = true;
      this.n = false;
      this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.h) && (this.i) && (b());
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      Log.i("GLThread", "surfaceCreated tid=" + getId());
      this.e = true;
      this.j = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      for (;;)
      {
        if ((this.r) && (this.g) && (!this.j))
        {
          boolean bool = this.jdField_a_of_type_Boolean;
          if (!bool) {
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void c()
  {
    if (this.q)
    {
      this.e = false;
      new Thread(new GLThread.1(this)).start();
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      Log.i("GLThread", "surfaceDestroyed tid=" + getId());
      this.e = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      for (;;)
      {
        if ((this.r) && (!this.g) && (!this.jdField_a_of_type_Boolean))
        {
          if ((!this.p) && (QLog.isColorLevel()))
          {
            this.p = true;
            QLog.d("GLThread", 2, "mWaitingForSurface " + this.g + " mExited " + this.jdField_a_of_type_Boolean);
          }
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
  
  public void c(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException("r must not be null");
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramRunnable);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramRunnable);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 100) {
        QLog.e("GLThread", 1, new Object[] { "GLThread runable queueList size is > 100, last r:", paramRunnable });
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      return;
    }
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          boolean bool = this.d;
          if (!bool) {
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      this.jdField_c_of_type_Boolean = false;
      this.l = true;
      this.n = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      for (;;)
      {
        if ((!this.jdField_a_of_type_Boolean) && (this.d))
        {
          boolean bool = this.n;
          if (!bool) {
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void f()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      if (this.r) {
        for (;;)
        {
          boolean bool = this.jdField_a_of_type_Boolean;
          if (!bool) {
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void g()
  {
    this.k = true;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 174
    //   2: new 51	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 338
    //   12: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   19: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 237	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: aload_0
    //   30: invokespecial 340	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	()V
    //   33: aload_0
    //   34: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   37: aload_0
    //   38: invokevirtual 342	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)V
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   47: aload_0
    //   48: invokevirtual 342	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)V
    //   51: return
    //   52: astore_1
    //   53: aload_0
    //   54: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   57: aload_0
    //   58: invokevirtual 342	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)V
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	GLThread
    //   42	1	1	localInterruptedException	InterruptedException
    //   52	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	33	42	java/lang/InterruptedException
    //   29	33	52	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLThread
 * JD-Core Version:    0.7.0.1
 */