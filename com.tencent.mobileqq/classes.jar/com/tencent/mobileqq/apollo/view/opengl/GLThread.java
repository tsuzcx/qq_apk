package com.tencent.mobileqq.apollo.view.opengl;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GLThread ");
    localStringBuilder.append(getId());
    setName(localStringBuilder.toString());
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.l = true;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWeakReference.get());
    this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager = paramGLThreadManager;
  }
  
  private boolean b()
  {
    boolean bool2 = this.d;
    boolean bool1 = true;
    if ((!bool2) && (this.e) && (!this.f) && (this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0))
    {
      if (this.l) {
        return bool1;
      }
      if (this.jdField_c_of_type_Int == 1) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
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
    //   31: istore 5
    //   33: iconst_0
    //   34: istore 4
    //   36: iconst_0
    //   37: istore 8
    //   39: aconst_null
    //   40: astore 21
    //   42: iconst_0
    //   43: istore 6
    //   45: aconst_null
    //   46: astore 22
    //   48: iconst_0
    //   49: istore 7
    //   51: iconst_0
    //   52: istore 12
    //   54: iconst_0
    //   55: istore 11
    //   57: iconst_0
    //   58: istore_3
    //   59: iconst_0
    //   60: istore_2
    //   61: iconst_0
    //   62: istore_1
    //   63: aconst_null
    //   64: astore 23
    //   66: iload 4
    //   68: istore 10
    //   70: aload_0
    //   71: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   74: astore 24
    //   76: aload 24
    //   78: monitorenter
    //   79: iload 8
    //   81: istore 4
    //   83: iload 10
    //   85: istore 9
    //   87: aload_0
    //   88: getfield 134	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_b_of_type_Boolean	Z
    //   91: ifeq +35 -> 126
    //   94: aload 24
    //   96: monitorexit
    //   97: aload_0
    //   98: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   101: astore 21
    //   103: aload 21
    //   105: monitorenter
    //   106: aload_0
    //   107: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   110: aload_0
    //   111: invokespecial 138	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	()V
    //   114: aload 21
    //   116: monitorexit
    //   117: return
    //   118: astore 22
    //   120: aload 21
    //   122: monitorexit
    //   123: aload 22
    //   125: athrow
    //   126: aload_0
    //   127: getfield 41	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   130: invokevirtual 141	java/util/ArrayList:isEmpty	()Z
    //   133: ifne +27 -> 160
    //   136: aload_0
    //   137: getfield 41	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   140: iconst_0
    //   141: invokevirtual 145	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   144: checkcast 147	java/lang/Runnable
    //   147: astore 23
    //   149: iload 4
    //   151: istore 8
    //   153: iload 9
    //   155: istore 4
    //   157: goto +948 -> 1105
    //   160: aload_0
    //   161: getfield 104	com/tencent/mobileqq/apollo/view/opengl/GLThread:d	Z
    //   164: aload_0
    //   165: getfield 149	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_c_of_type_Boolean	Z
    //   168: if_icmpeq +1570 -> 1738
    //   171: aload_0
    //   172: getfield 149	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_c_of_type_Boolean	Z
    //   175: istore 19
    //   177: aload_0
    //   178: aload_0
    //   179: getfield 149	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_c_of_type_Boolean	Z
    //   182: putfield 104	com/tencent/mobileqq/apollo/view/opengl/GLThread:d	Z
    //   185: aload_0
    //   186: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   189: invokevirtual 154	java/lang/Object:notifyAll	()V
    //   192: new 51	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   199: astore 25
    //   201: aload 25
    //   203: ldc 156
    //   205: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 25
    //   211: aload_0
    //   212: getfield 104	com/tencent/mobileqq/apollo/view/opengl/GLThread:d	Z
    //   215: invokevirtual 159	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 25
    //   221: ldc 161
    //   223: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 25
    //   229: aload_0
    //   230: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   233: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: ldc 163
    //   239: iconst_1
    //   240: aload 25
    //   242: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: goto +3 -> 251
    //   251: aload_0
    //   252: getfield 170	com/tencent/mobileqq/apollo/view/opengl/GLThread:k	Z
    //   255: ifeq +1489 -> 1744
    //   258: new 51	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   265: astore 25
    //   267: aload 25
    //   269: ldc 172
    //   271: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 25
    //   277: aload_0
    //   278: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   281: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: ldc 163
    //   287: iconst_1
    //   288: aload 25
    //   290: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: aload_0
    //   297: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   300: aload_0
    //   301: invokespecial 138	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	()V
    //   304: aload_0
    //   305: iconst_0
    //   306: putfield 170	com/tencent/mobileqq/apollo/view/opengl/GLThread:k	Z
    //   309: iconst_1
    //   310: istore 4
    //   312: goto +3 -> 315
    //   315: iload 5
    //   317: istore 8
    //   319: iload 5
    //   321: ifeq +14 -> 335
    //   324: aload_0
    //   325: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   328: aload_0
    //   329: invokespecial 138	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	()V
    //   332: iconst_0
    //   333: istore 8
    //   335: iload 19
    //   337: ifeq +1410 -> 1747
    //   340: aload_0
    //   341: getfield 108	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   344: ifeq +1403 -> 1747
    //   347: new 51	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   354: astore 25
    //   356: aload 25
    //   358: ldc 174
    //   360: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 25
    //   366: aload_0
    //   367: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   370: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: ldc 163
    //   376: iconst_1
    //   377: aload 25
    //   379: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: aload_0
    //   386: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   389: goto +3 -> 392
    //   392: iload 19
    //   394: ifeq +99 -> 493
    //   397: aload_0
    //   398: getfield 116	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   401: ifeq +92 -> 493
    //   404: aload_0
    //   405: getfield 92	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   408: invokevirtual 87	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   411: checkcast 176	com/tencent/mobileqq/apollo/view/opengl/GLRenderView
    //   414: astore 25
    //   416: aload 25
    //   418: ifnonnull +9 -> 427
    //   421: iconst_0
    //   422: istore 20
    //   424: goto +12 -> 436
    //   427: aload 25
    //   429: invokeinterface 179 1 0
    //   434: istore 20
    //   436: iload 20
    //   438: ifeq +13 -> 451
    //   441: aload_0
    //   442: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   445: invokevirtual 181	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	()Z
    //   448: ifeq +45 -> 493
    //   451: aload_0
    //   452: invokespecial 138	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	()V
    //   455: new 51	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   462: astore 25
    //   464: aload 25
    //   466: ldc 183
    //   468: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 25
    //   474: aload_0
    //   475: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   478: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: ldc 163
    //   484: iconst_1
    //   485: aload 25
    //   487: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: iload 19
    //   495: ifeq +58 -> 553
    //   498: aload_0
    //   499: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   502: invokevirtual 185	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:b	()Z
    //   505: ifeq +48 -> 553
    //   508: aload_0
    //   509: getfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   512: invokevirtual 118	com/tencent/mobileqq/apollo/view/opengl/EglHelper:c	()V
    //   515: new 51	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   522: astore 25
    //   524: aload 25
    //   526: ldc 187
    //   528: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 25
    //   534: aload_0
    //   535: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   538: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: ldc 163
    //   544: iconst_1
    //   545: aload 25
    //   547: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   553: aload_0
    //   554: getfield 101	com/tencent/mobileqq/apollo/view/opengl/GLThread:e	Z
    //   557: ifne +82 -> 639
    //   560: aload_0
    //   561: getfield 189	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   564: ifne +75 -> 639
    //   567: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +41 -> 611
    //   573: new 51	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   580: astore 25
    //   582: aload 25
    //   584: ldc 194
    //   586: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 25
    //   592: aload_0
    //   593: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   596: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: ldc 163
    //   602: iconst_2
    //   603: aload 25
    //   605: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: aload_0
    //   612: getfield 108	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   615: ifeq +7 -> 622
    //   618: aload_0
    //   619: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   622: aload_0
    //   623: iconst_1
    //   624: putfield 189	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   627: aload_0
    //   628: iconst_0
    //   629: putfield 106	com/tencent/mobileqq/apollo/view/opengl/GLThread:f	Z
    //   632: aload_0
    //   633: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   636: invokevirtual 154	java/lang/Object:notifyAll	()V
    //   639: aload_0
    //   640: getfield 101	com/tencent/mobileqq/apollo/view/opengl/GLThread:e	Z
    //   643: ifeq +60 -> 703
    //   646: aload_0
    //   647: getfield 189	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   650: ifeq +53 -> 703
    //   653: new 51	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   660: astore 25
    //   662: aload 25
    //   664: ldc 198
    //   666: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload 25
    //   672: aload_0
    //   673: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   676: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: ldc 163
    //   682: iconst_1
    //   683: aload 25
    //   685: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: aload_0
    //   692: iconst_0
    //   693: putfield 189	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   696: aload_0
    //   697: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   700: invokevirtual 154	java/lang/Object:notifyAll	()V
    //   703: iload 9
    //   705: istore 13
    //   707: iload 9
    //   709: ifeq +61 -> 770
    //   712: new 51	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   719: astore 25
    //   721: aload 25
    //   723: ldc 200
    //   725: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload 25
    //   731: aload_0
    //   732: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   735: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: ldc 163
    //   741: iconst_1
    //   742: aload 25
    //   744: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   750: aload_0
    //   751: iconst_0
    //   752: putfield 132	com/tencent/mobileqq/apollo/view/opengl/GLThread:m	Z
    //   755: aload_0
    //   756: iconst_1
    //   757: putfield 202	com/tencent/mobileqq/apollo/view/opengl/GLThread:n	Z
    //   760: aload_0
    //   761: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   764: invokevirtual 154	java/lang/Object:notifyAll	()V
    //   767: iconst_0
    //   768: istore 13
    //   770: aload_0
    //   771: getfield 45	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   774: ifnull +976 -> 1750
    //   777: aload_0
    //   778: getfield 45	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   781: astore 21
    //   783: aload_0
    //   784: aconst_null
    //   785: putfield 45	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   788: goto +3 -> 791
    //   791: aload_0
    //   792: invokespecial 203	com/tencent/mobileqq/apollo/view/opengl/GLThread:b	()Z
    //   795: ifeq +834 -> 1629
    //   798: iload 4
    //   800: istore 5
    //   802: iload_3
    //   803: istore 9
    //   805: aload_0
    //   806: getfield 116	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   809: ifne +126 -> 935
    //   812: iload 4
    //   814: ifeq +12 -> 826
    //   817: iconst_0
    //   818: istore 5
    //   820: iload_3
    //   821: istore 9
    //   823: goto +112 -> 935
    //   826: aload_0
    //   827: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   830: aload_0
    //   831: invokevirtual 206	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)Z
    //   834: istore 19
    //   836: iload 4
    //   838: istore 5
    //   840: iload_3
    //   841: istore 9
    //   843: iload 19
    //   845: ifeq +90 -> 935
    //   848: aload_0
    //   849: getfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   852: invokevirtual 208	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	()V
    //   855: aload_0
    //   856: iconst_1
    //   857: putfield 116	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   860: aload_0
    //   861: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   864: invokevirtual 154	java/lang/Object:notifyAll	()V
    //   867: iconst_1
    //   868: istore 9
    //   870: iload 4
    //   872: istore 5
    //   874: goto +61 -> 935
    //   877: astore 21
    //   879: aload_0
    //   880: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   883: aload_0
    //   884: invokevirtual 123	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:b	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)V
    //   887: aload 21
    //   889: athrow
    //   890: astore 21
    //   892: ldc 163
    //   894: iconst_1
    //   895: aload 21
    //   897: invokevirtual 211	com/tencent/mobileqq/apollo/view/opengl/EglHelper$EGLException:getMessage	()Ljava/lang/String;
    //   900: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   903: aload 24
    //   905: monitorexit
    //   906: aload_0
    //   907: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   910: astore 21
    //   912: aload 21
    //   914: monitorenter
    //   915: aload_0
    //   916: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   919: aload_0
    //   920: invokespecial 138	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	()V
    //   923: aload 21
    //   925: monitorexit
    //   926: return
    //   927: astore 22
    //   929: aload 21
    //   931: monitorexit
    //   932: aload 22
    //   934: athrow
    //   935: iload_2
    //   936: istore 4
    //   938: iload_1
    //   939: istore 10
    //   941: iload 6
    //   943: istore_3
    //   944: aload_0
    //   945: getfield 116	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   948: ifeq +32 -> 980
    //   951: iload_2
    //   952: istore 4
    //   954: iload_1
    //   955: istore 10
    //   957: iload 6
    //   959: istore_3
    //   960: aload_0
    //   961: getfield 108	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   964: ifne +16 -> 980
    //   967: aload_0
    //   968: iconst_1
    //   969: putfield 108	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   972: iconst_1
    //   973: istore 4
    //   975: iconst_1
    //   976: istore 10
    //   978: iconst_1
    //   979: istore_3
    //   980: iload 5
    //   982: istore 17
    //   984: iload 9
    //   986: istore 16
    //   988: iload 4
    //   990: istore 15
    //   992: iload 10
    //   994: istore 14
    //   996: iload_3
    //   997: istore 18
    //   999: aload_0
    //   1000: getfield 108	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   1003: ifeq +805 -> 1808
    //   1006: aload_0
    //   1007: getfield 43	com/tencent/mobileqq/apollo/view/opengl/GLThread:o	Z
    //   1010: ifeq +743 -> 1753
    //   1013: aload_0
    //   1014: getfield 75	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_Int	I
    //   1017: istore 12
    //   1019: aload_0
    //   1020: getfield 77	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_b_of_type_Int	I
    //   1023: istore 11
    //   1025: aload_0
    //   1026: iconst_1
    //   1027: putfield 132	com/tencent/mobileqq/apollo/view/opengl/GLThread:m	Z
    //   1030: new 51	java/lang/StringBuilder
    //   1033: dup
    //   1034: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1037: astore 25
    //   1039: aload 25
    //   1041: ldc 215
    //   1043: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload 25
    //   1049: aload_0
    //   1050: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   1053: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1056: pop
    //   1057: ldc 163
    //   1059: iconst_1
    //   1060: aload 25
    //   1062: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1065: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1068: aload_0
    //   1069: iconst_0
    //   1070: putfield 43	com/tencent/mobileqq/apollo/view/opengl/GLThread:o	Z
    //   1073: iconst_1
    //   1074: istore_2
    //   1075: iconst_1
    //   1076: istore_3
    //   1077: goto +3 -> 1080
    //   1080: aload_0
    //   1081: iconst_0
    //   1082: putfield 79	com/tencent/mobileqq/apollo/view/opengl/GLThread:l	Z
    //   1085: aload_0
    //   1086: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1089: invokevirtual 154	java/lang/Object:notifyAll	()V
    //   1092: aload_0
    //   1093: getfield 132	com/tencent/mobileqq/apollo/view/opengl/GLThread:m	Z
    //   1096: ifeq +663 -> 1759
    //   1099: iconst_1
    //   1100: istore 7
    //   1102: goto +657 -> 1759
    //   1105: aload 24
    //   1107: monitorexit
    //   1108: aload 23
    //   1110: ifnull +13 -> 1123
    //   1113: aload 23
    //   1115: invokeinterface 218 1 0
    //   1120: goto -1057 -> 63
    //   1123: iload_2
    //   1124: istore 9
    //   1126: iload_2
    //   1127: ifeq +102 -> 1229
    //   1130: ldc 163
    //   1132: iconst_1
    //   1133: ldc 220
    //   1135: invokestatic 223	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1138: aload_0
    //   1139: getfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   1142: invokevirtual 224	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	()Z
    //   1145: ifeq +41 -> 1186
    //   1148: aload_0
    //   1149: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1152: astore 24
    //   1154: aload 24
    //   1156: monitorenter
    //   1157: aload_0
    //   1158: iconst_1
    //   1159: putfield 226	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	Z
    //   1162: aload_0
    //   1163: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1166: invokevirtual 154	java/lang/Object:notifyAll	()V
    //   1169: aload 24
    //   1171: monitorexit
    //   1172: iconst_0
    //   1173: istore 9
    //   1175: goto +54 -> 1229
    //   1178: astore 21
    //   1180: aload 24
    //   1182: monitorexit
    //   1183: aload 21
    //   1185: athrow
    //   1186: aload_0
    //   1187: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1190: astore 24
    //   1192: aload 24
    //   1194: monitorenter
    //   1195: aload_0
    //   1196: iconst_1
    //   1197: putfield 226	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	Z
    //   1200: aload_0
    //   1201: iconst_1
    //   1202: putfield 106	com/tencent/mobileqq/apollo/view/opengl/GLThread:f	Z
    //   1205: aload_0
    //   1206: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1209: invokevirtual 154	java/lang/Object:notifyAll	()V
    //   1212: aload 24
    //   1214: monitorexit
    //   1215: iload_2
    //   1216: istore 9
    //   1218: goto +401 -> 1619
    //   1221: astore 21
    //   1223: aload 24
    //   1225: monitorexit
    //   1226: aload 21
    //   1228: athrow
    //   1229: iload_1
    //   1230: ifeq +555 -> 1785
    //   1233: aload_0
    //   1234: getfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   1237: invokevirtual 229	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	()Ljavax/microedition/khronos/opengles/GL;
    //   1240: checkcast 231	javax/microedition/khronos/opengles/GL10
    //   1243: astore 22
    //   1245: aload_0
    //   1246: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1249: aload 22
    //   1251: invokevirtual 234	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   1254: iconst_0
    //   1255: istore_1
    //   1256: goto +3 -> 1259
    //   1259: iload_3
    //   1260: istore_2
    //   1261: iload_3
    //   1262: ifeq +52 -> 1314
    //   1265: ldc 163
    //   1267: iconst_1
    //   1268: ldc 236
    //   1270: invokestatic 223	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1273: aload_0
    //   1274: getfield 92	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   1277: invokevirtual 87	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1280: checkcast 176	com/tencent/mobileqq/apollo/view/opengl/GLRenderView
    //   1283: astore 24
    //   1285: aload 24
    //   1287: ifnull +501 -> 1788
    //   1290: aload 24
    //   1292: invokeinterface 240 1 0
    //   1297: aload 22
    //   1299: aload_0
    //   1300: getfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   1303: getfield 243	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1306: invokeinterface 248 3 0
    //   1311: goto +477 -> 1788
    //   1314: iload 6
    //   1316: ifeq +486 -> 1802
    //   1319: new 51	java/lang/StringBuilder
    //   1322: dup
    //   1323: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1326: astore 24
    //   1328: aload 24
    //   1330: ldc 250
    //   1332: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: pop
    //   1336: aload 24
    //   1338: iload 12
    //   1340: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: aload 24
    //   1346: ldc 255
    //   1348: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: pop
    //   1352: aload 24
    //   1354: iload 11
    //   1356: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1359: pop
    //   1360: aload 24
    //   1362: ldc_w 257
    //   1365: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: pop
    //   1369: ldc 163
    //   1371: iconst_1
    //   1372: aload 24
    //   1374: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1377: invokestatic 223	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1380: aload_0
    //   1381: getfield 92	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   1384: invokevirtual 87	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1387: checkcast 176	com/tencent/mobileqq/apollo/view/opengl/GLRenderView
    //   1390: astore 24
    //   1392: aload 24
    //   1394: ifnull +402 -> 1796
    //   1397: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1400: ifeq +393 -> 1793
    //   1403: ldc 163
    //   1405: iconst_2
    //   1406: ldc_w 259
    //   1409: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1412: goto +3 -> 1415
    //   1415: aload 24
    //   1417: invokeinterface 240 1 0
    //   1422: aload 22
    //   1424: iload 12
    //   1426: iload 11
    //   1428: invokeinterface 263 4 0
    //   1433: goto +363 -> 1796
    //   1436: aload_0
    //   1437: getfield 92	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   1440: invokevirtual 87	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1443: checkcast 176	com/tencent/mobileqq/apollo/view/opengl/GLRenderView
    //   1446: astore 24
    //   1448: aload 24
    //   1450: ifnull +355 -> 1805
    //   1453: aload 22
    //   1455: ifnull +350 -> 1805
    //   1458: aload 24
    //   1460: invokeinterface 240 1 0
    //   1465: aload 22
    //   1467: invokeinterface 266 2 0
    //   1472: aload 21
    //   1474: ifnull +331 -> 1805
    //   1477: aload 21
    //   1479: invokeinterface 218 1 0
    //   1484: aconst_null
    //   1485: astore 21
    //   1487: goto +3 -> 1490
    //   1490: aload_0
    //   1491: getfield 110	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglEglHelper	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   1494: invokevirtual 269	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	()I
    //   1497: istore_3
    //   1498: iload_3
    //   1499: sipush 12288
    //   1502: if_icmpeq +99 -> 1601
    //   1505: iload_3
    //   1506: sipush 12302
    //   1509: if_icmpeq +47 -> 1556
    //   1512: ldc 163
    //   1514: ldc_w 271
    //   1517: iload_3
    //   1518: invokestatic 274	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1521: aload_0
    //   1522: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1525: astore 24
    //   1527: aload 24
    //   1529: monitorenter
    //   1530: aload_0
    //   1531: iconst_1
    //   1532: putfield 106	com/tencent/mobileqq/apollo/view/opengl/GLThread:f	Z
    //   1535: aload_0
    //   1536: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1539: invokevirtual 154	java/lang/Object:notifyAll	()V
    //   1542: aload 24
    //   1544: monitorexit
    //   1545: goto +56 -> 1601
    //   1548: astore 21
    //   1550: aload 24
    //   1552: monitorexit
    //   1553: aload 21
    //   1555: athrow
    //   1556: new 51	java/lang/StringBuilder
    //   1559: dup
    //   1560: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1563: astore 24
    //   1565: aload 24
    //   1567: ldc_w 276
    //   1570: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: pop
    //   1574: aload 24
    //   1576: aload_0
    //   1577: invokevirtual 62	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   1580: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1583: pop
    //   1584: ldc 163
    //   1586: iconst_1
    //   1587: aload 24
    //   1589: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1592: invokestatic 168	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1595: iconst_1
    //   1596: istore 5
    //   1598: goto +3 -> 1601
    //   1601: iload 7
    //   1603: ifeq +14 -> 1617
    //   1606: iconst_1
    //   1607: istore 4
    //   1609: iconst_0
    //   1610: istore 7
    //   1612: iload_2
    //   1613: istore_3
    //   1614: goto +5 -> 1619
    //   1617: iload_2
    //   1618: istore_3
    //   1619: iload 4
    //   1621: istore 10
    //   1623: iload 9
    //   1625: istore_2
    //   1626: goto -1556 -> 70
    //   1629: iload 4
    //   1631: istore 17
    //   1633: iload_3
    //   1634: istore 16
    //   1636: iload_2
    //   1637: istore 15
    //   1639: iload_1
    //   1640: istore 14
    //   1642: iload 6
    //   1644: istore 18
    //   1646: aload 21
    //   1648: ifnull +160 -> 1808
    //   1651: ldc 163
    //   1653: iconst_1
    //   1654: ldc_w 278
    //   1657: invokestatic 223	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1660: aload 21
    //   1662: invokeinterface 218 1 0
    //   1667: aconst_null
    //   1668: astore 21
    //   1670: goto +3 -> 1673
    //   1673: aload_0
    //   1674: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1677: invokevirtual 281	java/lang/Object:wait	()V
    //   1680: iload 8
    //   1682: istore 5
    //   1684: iload 13
    //   1686: istore 9
    //   1688: goto -1601 -> 87
    //   1691: astore 21
    //   1693: aload 24
    //   1695: monitorexit
    //   1696: aload 21
    //   1698: athrow
    //   1699: astore 22
    //   1701: aload_0
    //   1702: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1705: astore 21
    //   1707: aload 21
    //   1709: monitorenter
    //   1710: aload_0
    //   1711: invokespecial 136	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	()V
    //   1714: aload_0
    //   1715: invokespecial 138	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	()V
    //   1718: aload 21
    //   1720: monitorexit
    //   1721: aload 22
    //   1723: athrow
    //   1724: astore 22
    //   1726: aload 21
    //   1728: monitorexit
    //   1729: goto +6 -> 1735
    //   1732: aload 22
    //   1734: athrow
    //   1735: goto -3 -> 1732
    //   1738: iconst_0
    //   1739: istore 19
    //   1741: goto -1490 -> 251
    //   1744: goto -1429 -> 315
    //   1747: goto -1355 -> 392
    //   1750: goto -959 -> 791
    //   1753: iload 4
    //   1755: istore_2
    //   1756: goto -676 -> 1080
    //   1759: iload 5
    //   1761: istore_1
    //   1762: iload 8
    //   1764: istore 5
    //   1766: iload 13
    //   1768: istore 4
    //   1770: iload_1
    //   1771: istore 8
    //   1773: iload_3
    //   1774: istore 6
    //   1776: iload 9
    //   1778: istore_3
    //   1779: iload 10
    //   1781: istore_1
    //   1782: goto -677 -> 1105
    //   1785: goto -526 -> 1259
    //   1788: iconst_0
    //   1789: istore_2
    //   1790: goto -476 -> 1314
    //   1793: goto -378 -> 1415
    //   1796: iconst_0
    //   1797: istore 6
    //   1799: goto -363 -> 1436
    //   1802: goto -366 -> 1436
    //   1805: goto -315 -> 1490
    //   1808: iload 18
    //   1810: istore 6
    //   1812: iload 17
    //   1814: istore 4
    //   1816: iload 16
    //   1818: istore_3
    //   1819: iload 15
    //   1821: istore_2
    //   1822: iload 14
    //   1824: istore_1
    //   1825: goto -152 -> 1673
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1828	0	this	GLThread
    //   62	1763	1	i1	int
    //   60	1762	2	i2	int
    //   58	1761	3	i3	int
    //   34	1781	4	i4	int
    //   31	1734	5	i5	int
    //   43	1768	6	i6	int
    //   49	1562	7	i7	int
    //   37	1735	8	i8	int
    //   85	1692	9	i9	int
    //   68	1712	10	i10	int
    //   55	1372	11	i11	int
    //   52	1373	12	i12	int
    //   705	1062	13	i13	int
    //   994	829	14	i14	int
    //   990	830	15	i15	int
    //   986	831	16	i16	int
    //   982	831	17	i17	int
    //   997	812	18	i18	int
    //   175	1565	19	bool1	boolean
    //   422	15	20	bool2	boolean
    //   40	742	21	localObject1	Object
    //   877	11	21	localRuntimeException	java.lang.RuntimeException
    //   890	6	21	localEGLException	EglHelper.EGLException
    //   910	20	21	localGLThreadManager1	GLThreadManager
    //   1178	6	21	localObject2	Object
    //   1221	257	21	localObject3	Object
    //   1485	1	21	localObject4	Object
    //   1548	113	21	localObject5	Object
    //   1668	1	21	localObject6	Object
    //   1691	6	21	localObject7	Object
    //   1705	22	21	localGLThreadManager2	GLThreadManager
    //   46	1	22	localObject8	Object
    //   118	6	22	localObject9	Object
    //   927	6	22	localObject10	Object
    //   1243	223	22	localGL10	javax.microedition.khronos.opengles.GL10
    //   1699	23	22	localObject11	Object
    //   1724	9	22	localObject12	Object
    //   64	1050	23	localRunnable	Runnable
    //   74	1620	24	localObject13	Object
    //   199	862	25	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   106	117	118	finally
    //   120	123	118	finally
    //   848	855	877	java/lang/RuntimeException
    //   848	855	890	com/tencent/mobileqq/apollo/view/opengl/EglHelper$EGLException
    //   915	926	927	finally
    //   929	932	927	finally
    //   1157	1172	1178	finally
    //   1180	1183	1178	finally
    //   1195	1215	1221	finally
    //   1223	1226	1221	finally
    //   1530	1545	1548	finally
    //   1550	1553	1548	finally
    //   87	97	1691	finally
    //   126	149	1691	finally
    //   160	192	1691	finally
    //   192	248	1691	finally
    //   251	309	1691	finally
    //   324	332	1691	finally
    //   340	389	1691	finally
    //   397	416	1691	finally
    //   427	436	1691	finally
    //   441	451	1691	finally
    //   451	493	1691	finally
    //   498	553	1691	finally
    //   553	611	1691	finally
    //   611	622	1691	finally
    //   622	639	1691	finally
    //   639	703	1691	finally
    //   712	767	1691	finally
    //   770	788	1691	finally
    //   791	798	1691	finally
    //   805	812	1691	finally
    //   826	836	1691	finally
    //   848	855	1691	finally
    //   855	867	1691	finally
    //   879	890	1691	finally
    //   892	906	1691	finally
    //   944	951	1691	finally
    //   960	972	1691	finally
    //   999	1073	1691	finally
    //   1080	1099	1691	finally
    //   1105	1108	1691	finally
    //   1651	1667	1691	finally
    //   1673	1680	1691	finally
    //   1693	1696	1691	finally
    //   70	79	1699	finally
    //   1113	1120	1699	finally
    //   1130	1157	1699	finally
    //   1183	1186	1699	finally
    //   1186	1195	1699	finally
    //   1226	1229	1699	finally
    //   1233	1254	1699	finally
    //   1265	1285	1699	finally
    //   1290	1311	1699	finally
    //   1319	1392	1699	finally
    //   1397	1412	1699	finally
    //   1415	1433	1699	finally
    //   1436	1448	1699	finally
    //   1458	1472	1699	finally
    //   1477	1484	1699	finally
    //   1490	1498	1699	finally
    //   1512	1530	1699	finally
    //   1553	1556	1699	finally
    //   1556	1595	1699	finally
    //   1696	1699	1699	finally
    //   1710	1721	1724	finally
    //   1726	1729	1724	finally
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
    if ((paramInt >= 0) && (paramInt <= 1)) {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
      {
        this.jdField_c_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("renderMode");
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
      if (this.r) {
        while ((!this.jdField_a_of_type_Boolean) && (!this.d) && (!this.n) && (a()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("TextureView onWindowResize waiting for render complete from tid=");
          localStringBuilder.append(getId());
          QLog.i("[ApolloGL][GLThread]Main thread", 1, localStringBuilder.toString());
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label134:
            break label134;
          }
          Thread.currentThread().interrupt();
        }
      }
      return;
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
      this.e = true;
      this.j = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      if (this.r) {
        while ((this.g) && (!this.j))
        {
          boolean bool = this.jdField_a_of_type_Boolean;
          if (bool) {
            break;
          }
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label64:
            break label64;
          }
          Thread.currentThread().interrupt();
        }
      }
      return;
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
      this.e = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      if (this.r) {
        while ((!this.g) && (!this.jdField_a_of_type_Boolean))
        {
          if ((!this.p) && (QLog.isColorLevel()))
          {
            this.p = true;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("mWaitingForSurface ");
            localStringBuilder.append(this.g);
            localStringBuilder.append(" mExited ");
            localStringBuilder.append(this.jdField_a_of_type_Boolean);
            QLog.d("[ApolloGL][GLThread]", 2, localStringBuilder.toString());
          }
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label151:
            break label151;
          }
          Thread.currentThread().interrupt();
        }
      }
      return;
    }
  }
  
  public void c(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramRunnable);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramRunnable);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 100) {
          QLog.e("[ApolloGL][GLThread]", 1, new Object[] { "GLThread runable queueList size is > 100, last r:", paramRunnable });
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("r must not be null");
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause tid=");
      localStringBuilder.append(getId());
      QLog.i("[ApolloGL][GLThread]", 1, localStringBuilder.toString());
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      while ((!this.jdField_a_of_type_Boolean) && (!this.d))
      {
        QLog.i("[ApolloGL][GLThread]Main thread", 1, "onPause waiting for mPaused.");
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label88:
          break label88;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume tid=");
      localStringBuilder.append(getId());
      QLog.i("[ApolloGL][GLThread]", 1, localStringBuilder.toString());
      this.jdField_c_of_type_Boolean = false;
      this.l = true;
      this.n = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.notifyAll();
      while ((!this.jdField_a_of_type_Boolean) && (this.d) && (!this.n))
      {
        QLog.i("[ApolloGL][GLThread]Main thread", 1, "onResume waiting for !mPaused.");
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label105:
          break label105;
        }
        Thread.currentThread().interrupt();
      }
      return;
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
          if (bool) {
            break;
          }
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            label45:
            break label45;
          }
          Thread.currentThread().interrupt();
        }
      }
      return;
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
    //   0: aload_0
    //   1: invokespecial 348	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	()V
    //   4: aload_0
    //   5: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   8: aload_0
    //   9: invokevirtual 350	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)V
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: getfield 94	com/tencent/mobileqq/apollo/view/opengl/GLThread:jdField_a_of_type_ComTencentMobileqqApolloViewOpenglGLThreadManager	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   18: aload_0
    //   19: invokevirtual 350	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)V
    //   22: aload_1
    //   23: athrow
    //   24: astore_1
    //   25: goto -21 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	GLThread
    //   13	10	1	localObject	Object
    //   24	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   0	4	13	finally
    //   0	4	24	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLThread
 * JD-Core Version:    0.7.0.1
 */