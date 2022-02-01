package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class GLThread
  extends Thread
{
  public boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private boolean p;
  private boolean q;
  private ArrayList<Runnable> r = new ArrayList();
  private boolean s = true;
  private Runnable t = null;
  private EglHelper u;
  private WeakReference<GLRenderView> v;
  private final GLThreadManager w;
  private boolean x = false;
  private boolean y;
  private boolean z = true;
  
  GLThread(GLThreadManager paramGLThreadManager, WeakReference<GLRenderView> paramWeakReference)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GLThread ");
    localStringBuilder.append(getId());
    setName(localStringBuilder.toString());
    this.l = 0;
    this.m = 0;
    this.o = true;
    this.n = 1;
    this.v = new WeakReference(paramWeakReference.get());
    this.w = paramGLThreadManager;
  }
  
  private void j()
  {
    if (this.i)
    {
      this.i = false;
      this.u.e();
    }
  }
  
  private void k()
  {
    if (this.h)
    {
      this.u.f();
      this.h = false;
      this.w.c(this);
    }
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 115	com/tencent/mobileqq/apollo/view/opengl/EglHelper
    //   4: dup
    //   5: aload_0
    //   6: getfield 100	com/tencent/mobileqq/apollo/view/opengl/GLThread:v	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 133	com/tencent/mobileqq/apollo/view/opengl/EglHelper:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 113	com/tencent/mobileqq/apollo/view/opengl/GLThread:u	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 119	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 111	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 135	com/tencent/mobileqq/apollo/view/opengl/GLThread:p	Z
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
    //   71: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   74: astore 24
    //   76: aload 24
    //   78: monitorenter
    //   79: iload 8
    //   81: istore 4
    //   83: iload 10
    //   85: istore 9
    //   87: aload_0
    //   88: getfield 137	com/tencent/mobileqq/apollo/view/opengl/GLThread:b	Z
    //   91: ifeq +35 -> 126
    //   94: aload 24
    //   96: monitorexit
    //   97: aload_0
    //   98: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   101: astore 21
    //   103: aload 21
    //   105: monitorenter
    //   106: aload_0
    //   107: invokespecial 139	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	()V
    //   110: aload_0
    //   111: invokespecial 141	com/tencent/mobileqq/apollo/view/opengl/GLThread:k	()V
    //   114: aload 21
    //   116: monitorexit
    //   117: return
    //   118: astore 22
    //   120: aload 21
    //   122: monitorexit
    //   123: aload 22
    //   125: athrow
    //   126: aload_0
    //   127: getfield 49	com/tencent/mobileqq/apollo/view/opengl/GLThread:r	Ljava/util/ArrayList;
    //   130: invokevirtual 145	java/util/ArrayList:isEmpty	()Z
    //   133: ifne +27 -> 160
    //   136: aload_0
    //   137: getfield 49	com/tencent/mobileqq/apollo/view/opengl/GLThread:r	Ljava/util/ArrayList;
    //   140: iconst_0
    //   141: invokevirtual 149	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   144: checkcast 151	java/lang/Runnable
    //   147: astore 23
    //   149: iload 4
    //   151: istore 8
    //   153: iload 9
    //   155: istore 4
    //   157: goto +948 -> 1105
    //   160: aload_0
    //   161: getfield 153	com/tencent/mobileqq/apollo/view/opengl/GLThread:d	Z
    //   164: aload_0
    //   165: getfield 155	com/tencent/mobileqq/apollo/view/opengl/GLThread:c	Z
    //   168: if_icmpeq +1572 -> 1740
    //   171: aload_0
    //   172: getfield 155	com/tencent/mobileqq/apollo/view/opengl/GLThread:c	Z
    //   175: istore 19
    //   177: aload_0
    //   178: aload_0
    //   179: getfield 155	com/tencent/mobileqq/apollo/view/opengl/GLThread:c	Z
    //   182: putfield 153	com/tencent/mobileqq/apollo/view/opengl/GLThread:d	Z
    //   185: aload_0
    //   186: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   189: invokevirtual 160	java/lang/Object:notifyAll	()V
    //   192: new 59	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   199: astore 25
    //   201: aload 25
    //   203: ldc 162
    //   205: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 25
    //   211: aload_0
    //   212: getfield 153	com/tencent/mobileqq/apollo/view/opengl/GLThread:d	Z
    //   215: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 25
    //   221: ldc 167
    //   223: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 25
    //   229: aload_0
    //   230: invokevirtual 70	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   233: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: ldc 169
    //   239: iconst_1
    //   240: aload 25
    //   242: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: goto +3 -> 251
    //   251: aload_0
    //   252: getfield 176	com/tencent/mobileqq/apollo/view/opengl/GLThread:k	Z
    //   255: ifeq +1491 -> 1746
    //   258: new 59	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   265: astore 25
    //   267: aload 25
    //   269: ldc 178
    //   271: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 25
    //   277: aload_0
    //   278: invokevirtual 70	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   281: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: ldc 169
    //   287: iconst_1
    //   288: aload 25
    //   290: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: aload_0
    //   297: invokespecial 139	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	()V
    //   300: aload_0
    //   301: invokespecial 141	com/tencent/mobileqq/apollo/view/opengl/GLThread:k	()V
    //   304: aload_0
    //   305: iconst_0
    //   306: putfield 176	com/tencent/mobileqq/apollo/view/opengl/GLThread:k	Z
    //   309: iconst_1
    //   310: istore 4
    //   312: goto +3 -> 315
    //   315: iload 5
    //   317: istore 8
    //   319: iload 5
    //   321: ifeq +14 -> 335
    //   324: aload_0
    //   325: invokespecial 139	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	()V
    //   328: aload_0
    //   329: invokespecial 141	com/tencent/mobileqq/apollo/view/opengl/GLThread:k	()V
    //   332: iconst_0
    //   333: istore 8
    //   335: iload 19
    //   337: ifeq +1412 -> 1749
    //   340: aload_0
    //   341: getfield 111	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   344: ifeq +1405 -> 1749
    //   347: new 59	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   354: astore 25
    //   356: aload 25
    //   358: ldc 180
    //   360: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 25
    //   366: aload_0
    //   367: invokevirtual 70	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   370: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: ldc 169
    //   376: iconst_1
    //   377: aload 25
    //   379: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: aload_0
    //   386: invokespecial 139	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	()V
    //   389: goto +3 -> 392
    //   392: iload 19
    //   394: ifeq +99 -> 493
    //   397: aload_0
    //   398: getfield 119	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   401: ifeq +92 -> 493
    //   404: aload_0
    //   405: getfield 100	com/tencent/mobileqq/apollo/view/opengl/GLThread:v	Ljava/lang/ref/WeakReference;
    //   408: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   411: checkcast 182	com/tencent/mobileqq/apollo/view/opengl/GLRenderView
    //   414: astore 25
    //   416: aload 25
    //   418: ifnonnull +9 -> 427
    //   421: iconst_0
    //   422: istore 20
    //   424: goto +12 -> 436
    //   427: aload 25
    //   429: invokeinterface 185 1 0
    //   434: istore 20
    //   436: iload 20
    //   438: ifeq +13 -> 451
    //   441: aload_0
    //   442: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   445: invokevirtual 187	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	()Z
    //   448: ifeq +45 -> 493
    //   451: aload_0
    //   452: invokespecial 141	com/tencent/mobileqq/apollo/view/opengl/GLThread:k	()V
    //   455: new 59	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   462: astore 25
    //   464: aload 25
    //   466: ldc 189
    //   468: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 25
    //   474: aload_0
    //   475: invokevirtual 70	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   478: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: ldc 169
    //   484: iconst_1
    //   485: aload 25
    //   487: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: iload 19
    //   495: ifeq +58 -> 553
    //   498: aload_0
    //   499: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   502: invokevirtual 191	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:b	()Z
    //   505: ifeq +48 -> 553
    //   508: aload_0
    //   509: getfield 113	com/tencent/mobileqq/apollo/view/opengl/GLThread:u	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   512: invokevirtual 121	com/tencent/mobileqq/apollo/view/opengl/EglHelper:f	()V
    //   515: new 59	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   522: astore 25
    //   524: aload 25
    //   526: ldc 193
    //   528: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 25
    //   534: aload_0
    //   535: invokevirtual 70	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   538: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: ldc 169
    //   544: iconst_1
    //   545: aload 25
    //   547: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   553: aload_0
    //   554: getfield 109	com/tencent/mobileqq/apollo/view/opengl/GLThread:e	Z
    //   557: ifne +82 -> 639
    //   560: aload_0
    //   561: getfield 195	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   564: ifne +75 -> 639
    //   567: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +41 -> 611
    //   573: new 59	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   580: astore 25
    //   582: aload 25
    //   584: ldc 200
    //   586: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 25
    //   592: aload_0
    //   593: invokevirtual 70	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   596: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: ldc 169
    //   602: iconst_2
    //   603: aload 25
    //   605: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: aload_0
    //   612: getfield 111	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   615: ifeq +7 -> 622
    //   618: aload_0
    //   619: invokespecial 139	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	()V
    //   622: aload_0
    //   623: iconst_1
    //   624: putfield 195	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   627: aload_0
    //   628: iconst_0
    //   629: putfield 204	com/tencent/mobileqq/apollo/view/opengl/GLThread:f	Z
    //   632: aload_0
    //   633: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   636: invokevirtual 160	java/lang/Object:notifyAll	()V
    //   639: aload_0
    //   640: getfield 109	com/tencent/mobileqq/apollo/view/opengl/GLThread:e	Z
    //   643: ifeq +60 -> 703
    //   646: aload_0
    //   647: getfield 195	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   650: ifeq +53 -> 703
    //   653: new 59	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   660: astore 25
    //   662: aload 25
    //   664: ldc 206
    //   666: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload 25
    //   672: aload_0
    //   673: invokevirtual 70	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   676: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: ldc 169
    //   682: iconst_1
    //   683: aload 25
    //   685: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: aload_0
    //   692: iconst_0
    //   693: putfield 195	com/tencent/mobileqq/apollo/view/opengl/GLThread:g	Z
    //   696: aload_0
    //   697: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   700: invokevirtual 160	java/lang/Object:notifyAll	()V
    //   703: iload 9
    //   705: istore 13
    //   707: iload 9
    //   709: ifeq +61 -> 770
    //   712: new 59	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   719: astore 25
    //   721: aload 25
    //   723: ldc 208
    //   725: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload 25
    //   731: aload_0
    //   732: invokevirtual 70	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   735: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: ldc 169
    //   741: iconst_1
    //   742: aload 25
    //   744: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   750: aload_0
    //   751: iconst_0
    //   752: putfield 135	com/tencent/mobileqq/apollo/view/opengl/GLThread:p	Z
    //   755: aload_0
    //   756: iconst_1
    //   757: putfield 210	com/tencent/mobileqq/apollo/view/opengl/GLThread:q	Z
    //   760: aload_0
    //   761: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   764: invokevirtual 160	java/lang/Object:notifyAll	()V
    //   767: iconst_0
    //   768: istore 13
    //   770: aload_0
    //   771: getfield 53	com/tencent/mobileqq/apollo/view/opengl/GLThread:t	Ljava/lang/Runnable;
    //   774: ifnull +978 -> 1752
    //   777: aload_0
    //   778: getfield 53	com/tencent/mobileqq/apollo/view/opengl/GLThread:t	Ljava/lang/Runnable;
    //   781: astore 21
    //   783: aload_0
    //   784: aconst_null
    //   785: putfield 53	com/tencent/mobileqq/apollo/view/opengl/GLThread:t	Ljava/lang/Runnable;
    //   788: goto +3 -> 791
    //   791: aload_0
    //   792: invokespecial 212	com/tencent/mobileqq/apollo/view/opengl/GLThread:m	()Z
    //   795: ifeq +836 -> 1631
    //   798: iload 4
    //   800: istore 5
    //   802: iload_3
    //   803: istore 9
    //   805: aload_0
    //   806: getfield 119	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   809: ifne +126 -> 935
    //   812: iload 4
    //   814: ifeq +12 -> 826
    //   817: iconst_0
    //   818: istore 5
    //   820: iload_3
    //   821: istore 9
    //   823: goto +112 -> 935
    //   826: aload_0
    //   827: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   830: aload_0
    //   831: invokevirtual 215	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:b	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)Z
    //   834: istore 19
    //   836: iload 4
    //   838: istore 5
    //   840: iload_3
    //   841: istore 9
    //   843: iload 19
    //   845: ifeq +90 -> 935
    //   848: aload_0
    //   849: getfield 113	com/tencent/mobileqq/apollo/view/opengl/GLThread:u	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   852: invokevirtual 217	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	()V
    //   855: aload_0
    //   856: iconst_1
    //   857: putfield 119	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   860: aload_0
    //   861: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   864: invokevirtual 160	java/lang/Object:notifyAll	()V
    //   867: iconst_1
    //   868: istore 9
    //   870: iload 4
    //   872: istore 5
    //   874: goto +61 -> 935
    //   877: astore 21
    //   879: aload_0
    //   880: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   883: aload_0
    //   884: invokevirtual 126	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:c	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)V
    //   887: aload 21
    //   889: athrow
    //   890: astore 21
    //   892: ldc 169
    //   894: iconst_1
    //   895: aload 21
    //   897: invokevirtual 220	com/tencent/mobileqq/apollo/view/opengl/EglHelper$EGLException:getMessage	()Ljava/lang/String;
    //   900: invokestatic 222	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   903: aload 24
    //   905: monitorexit
    //   906: aload_0
    //   907: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   910: astore 21
    //   912: aload 21
    //   914: monitorenter
    //   915: aload_0
    //   916: invokespecial 139	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	()V
    //   919: aload_0
    //   920: invokespecial 141	com/tencent/mobileqq/apollo/view/opengl/GLThread:k	()V
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
    //   945: getfield 119	com/tencent/mobileqq/apollo/view/opengl/GLThread:h	Z
    //   948: ifeq +32 -> 980
    //   951: iload_2
    //   952: istore 4
    //   954: iload_1
    //   955: istore 10
    //   957: iload 6
    //   959: istore_3
    //   960: aload_0
    //   961: getfield 111	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   964: ifne +16 -> 980
    //   967: aload_0
    //   968: iconst_1
    //   969: putfield 111	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
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
    //   1000: getfield 111	com/tencent/mobileqq/apollo/view/opengl/GLThread:i	Z
    //   1003: ifeq +807 -> 1810
    //   1006: aload_0
    //   1007: getfield 51	com/tencent/mobileqq/apollo/view/opengl/GLThread:s	Z
    //   1010: ifeq +745 -> 1755
    //   1013: aload_0
    //   1014: getfield 83	com/tencent/mobileqq/apollo/view/opengl/GLThread:l	I
    //   1017: istore 12
    //   1019: aload_0
    //   1020: getfield 85	com/tencent/mobileqq/apollo/view/opengl/GLThread:m	I
    //   1023: istore 11
    //   1025: aload_0
    //   1026: iconst_1
    //   1027: putfield 135	com/tencent/mobileqq/apollo/view/opengl/GLThread:p	Z
    //   1030: new 59	java/lang/StringBuilder
    //   1033: dup
    //   1034: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1037: astore 25
    //   1039: aload 25
    //   1041: ldc 224
    //   1043: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload 25
    //   1049: aload_0
    //   1050: invokevirtual 70	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   1053: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1056: pop
    //   1057: ldc 169
    //   1059: iconst_1
    //   1060: aload 25
    //   1062: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1065: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1068: aload_0
    //   1069: iconst_0
    //   1070: putfield 51	com/tencent/mobileqq/apollo/view/opengl/GLThread:s	Z
    //   1073: iconst_1
    //   1074: istore_2
    //   1075: iconst_1
    //   1076: istore_3
    //   1077: goto +3 -> 1080
    //   1080: aload_0
    //   1081: iconst_0
    //   1082: putfield 87	com/tencent/mobileqq/apollo/view/opengl/GLThread:o	Z
    //   1085: aload_0
    //   1086: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1089: invokevirtual 160	java/lang/Object:notifyAll	()V
    //   1092: aload_0
    //   1093: getfield 135	com/tencent/mobileqq/apollo/view/opengl/GLThread:p	Z
    //   1096: ifeq +665 -> 1761
    //   1099: iconst_1
    //   1100: istore 7
    //   1102: goto +659 -> 1761
    //   1105: aload 24
    //   1107: monitorexit
    //   1108: aload 23
    //   1110: ifnull +13 -> 1123
    //   1113: aload 23
    //   1115: invokeinterface 227 1 0
    //   1120: goto -1057 -> 63
    //   1123: iload_2
    //   1124: istore 9
    //   1126: iload_2
    //   1127: ifeq +102 -> 1229
    //   1130: ldc 169
    //   1132: iconst_1
    //   1133: ldc 229
    //   1135: invokestatic 231	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1138: aload_0
    //   1139: getfield 113	com/tencent/mobileqq/apollo/view/opengl/GLThread:u	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   1142: invokevirtual 232	com/tencent/mobileqq/apollo/view/opengl/EglHelper:b	()Z
    //   1145: ifeq +41 -> 1186
    //   1148: aload_0
    //   1149: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1152: astore 24
    //   1154: aload 24
    //   1156: monitorenter
    //   1157: aload_0
    //   1158: iconst_1
    //   1159: putfield 234	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	Z
    //   1162: aload_0
    //   1163: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1166: invokevirtual 160	java/lang/Object:notifyAll	()V
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
    //   1187: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1190: astore 24
    //   1192: aload 24
    //   1194: monitorenter
    //   1195: aload_0
    //   1196: iconst_1
    //   1197: putfield 234	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	Z
    //   1200: aload_0
    //   1201: iconst_1
    //   1202: putfield 204	com/tencent/mobileqq/apollo/view/opengl/GLThread:f	Z
    //   1205: aload_0
    //   1206: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1209: invokevirtual 160	java/lang/Object:notifyAll	()V
    //   1212: aload 24
    //   1214: monitorexit
    //   1215: iload_2
    //   1216: istore 9
    //   1218: goto +403 -> 1621
    //   1221: astore 21
    //   1223: aload 24
    //   1225: monitorexit
    //   1226: aload 21
    //   1228: athrow
    //   1229: iload_1
    //   1230: ifeq +557 -> 1787
    //   1233: aload_0
    //   1234: getfield 113	com/tencent/mobileqq/apollo/view/opengl/GLThread:u	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   1237: invokevirtual 237	com/tencent/mobileqq/apollo/view/opengl/EglHelper:c	()Ljavax/microedition/khronos/opengles/GL;
    //   1240: checkcast 239	javax/microedition/khronos/opengles/GL10
    //   1243: astore 22
    //   1245: aload_0
    //   1246: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1249: aload 22
    //   1251: invokevirtual 242	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   1254: iconst_0
    //   1255: istore_1
    //   1256: goto +3 -> 1259
    //   1259: iload_3
    //   1260: istore_2
    //   1261: iload_3
    //   1262: ifeq +52 -> 1314
    //   1265: ldc 169
    //   1267: iconst_1
    //   1268: ldc 244
    //   1270: invokestatic 231	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1273: aload_0
    //   1274: getfield 100	com/tencent/mobileqq/apollo/view/opengl/GLThread:v	Ljava/lang/ref/WeakReference;
    //   1277: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1280: checkcast 182	com/tencent/mobileqq/apollo/view/opengl/GLRenderView
    //   1283: astore 24
    //   1285: aload 24
    //   1287: ifnull +503 -> 1790
    //   1290: aload 24
    //   1292: invokeinterface 248 1 0
    //   1297: aload 22
    //   1299: aload_0
    //   1300: getfield 113	com/tencent/mobileqq/apollo/view/opengl/GLThread:u	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   1303: getfield 251	com/tencent/mobileqq/apollo/view/opengl/EglHelper:d	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1306: invokeinterface 256 3 0
    //   1311: goto +479 -> 1790
    //   1314: iload 6
    //   1316: ifeq +488 -> 1804
    //   1319: new 59	java/lang/StringBuilder
    //   1322: dup
    //   1323: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1326: astore 24
    //   1328: aload 24
    //   1330: ldc_w 258
    //   1333: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: pop
    //   1337: aload 24
    //   1339: iload 12
    //   1341: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1344: pop
    //   1345: aload 24
    //   1347: ldc_w 263
    //   1350: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: pop
    //   1354: aload 24
    //   1356: iload 11
    //   1358: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1361: pop
    //   1362: aload 24
    //   1364: ldc_w 265
    //   1367: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: pop
    //   1371: ldc 169
    //   1373: iconst_1
    //   1374: aload 24
    //   1376: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1379: invokestatic 231	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1382: aload_0
    //   1383: getfield 100	com/tencent/mobileqq/apollo/view/opengl/GLThread:v	Ljava/lang/ref/WeakReference;
    //   1386: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1389: checkcast 182	com/tencent/mobileqq/apollo/view/opengl/GLRenderView
    //   1392: astore 24
    //   1394: aload 24
    //   1396: ifnull +402 -> 1798
    //   1399: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1402: ifeq +393 -> 1795
    //   1405: ldc 169
    //   1407: iconst_2
    //   1408: ldc_w 267
    //   1411: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1414: goto +3 -> 1417
    //   1417: aload 24
    //   1419: invokeinterface 248 1 0
    //   1424: aload 22
    //   1426: iload 12
    //   1428: iload 11
    //   1430: invokeinterface 271 4 0
    //   1435: goto +363 -> 1798
    //   1438: aload_0
    //   1439: getfield 100	com/tencent/mobileqq/apollo/view/opengl/GLThread:v	Ljava/lang/ref/WeakReference;
    //   1442: invokevirtual 95	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1445: checkcast 182	com/tencent/mobileqq/apollo/view/opengl/GLRenderView
    //   1448: astore 24
    //   1450: aload 24
    //   1452: ifnull +355 -> 1807
    //   1455: aload 22
    //   1457: ifnull +350 -> 1807
    //   1460: aload 24
    //   1462: invokeinterface 248 1 0
    //   1467: aload 22
    //   1469: invokeinterface 274 2 0
    //   1474: aload 21
    //   1476: ifnull +331 -> 1807
    //   1479: aload 21
    //   1481: invokeinterface 227 1 0
    //   1486: aconst_null
    //   1487: astore 21
    //   1489: goto +3 -> 1492
    //   1492: aload_0
    //   1493: getfield 113	com/tencent/mobileqq/apollo/view/opengl/GLThread:u	Lcom/tencent/mobileqq/apollo/view/opengl/EglHelper;
    //   1496: invokevirtual 277	com/tencent/mobileqq/apollo/view/opengl/EglHelper:d	()I
    //   1499: istore_3
    //   1500: iload_3
    //   1501: sipush 12288
    //   1504: if_icmpeq +99 -> 1603
    //   1507: iload_3
    //   1508: sipush 12302
    //   1511: if_icmpeq +47 -> 1558
    //   1514: ldc 169
    //   1516: ldc_w 279
    //   1519: iload_3
    //   1520: invokestatic 282	com/tencent/mobileqq/apollo/view/opengl/EglHelper:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1523: aload_0
    //   1524: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1527: astore 24
    //   1529: aload 24
    //   1531: monitorenter
    //   1532: aload_0
    //   1533: iconst_1
    //   1534: putfield 204	com/tencent/mobileqq/apollo/view/opengl/GLThread:f	Z
    //   1537: aload_0
    //   1538: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1541: invokevirtual 160	java/lang/Object:notifyAll	()V
    //   1544: aload 24
    //   1546: monitorexit
    //   1547: goto +56 -> 1603
    //   1550: astore 21
    //   1552: aload 24
    //   1554: monitorexit
    //   1555: aload 21
    //   1557: athrow
    //   1558: new 59	java/lang/StringBuilder
    //   1561: dup
    //   1562: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1565: astore 24
    //   1567: aload 24
    //   1569: ldc_w 284
    //   1572: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: pop
    //   1576: aload 24
    //   1578: aload_0
    //   1579: invokevirtual 70	com/tencent/mobileqq/apollo/view/opengl/GLThread:getId	()J
    //   1582: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1585: pop
    //   1586: ldc 169
    //   1588: iconst_1
    //   1589: aload 24
    //   1591: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1594: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1597: iconst_1
    //   1598: istore 5
    //   1600: goto +3 -> 1603
    //   1603: iload 7
    //   1605: ifeq +14 -> 1619
    //   1608: iconst_1
    //   1609: istore 4
    //   1611: iconst_0
    //   1612: istore 7
    //   1614: iload_2
    //   1615: istore_3
    //   1616: goto +5 -> 1621
    //   1619: iload_2
    //   1620: istore_3
    //   1621: iload 4
    //   1623: istore 10
    //   1625: iload 9
    //   1627: istore_2
    //   1628: goto -1558 -> 70
    //   1631: iload 4
    //   1633: istore 17
    //   1635: iload_3
    //   1636: istore 16
    //   1638: iload_2
    //   1639: istore 15
    //   1641: iload_1
    //   1642: istore 14
    //   1644: iload 6
    //   1646: istore 18
    //   1648: aload 21
    //   1650: ifnull +160 -> 1810
    //   1653: ldc 169
    //   1655: iconst_1
    //   1656: ldc_w 286
    //   1659: invokestatic 231	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1662: aload 21
    //   1664: invokeinterface 227 1 0
    //   1669: aconst_null
    //   1670: astore 21
    //   1672: goto +3 -> 1675
    //   1675: aload_0
    //   1676: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1679: invokevirtual 289	java/lang/Object:wait	()V
    //   1682: iload 8
    //   1684: istore 5
    //   1686: iload 13
    //   1688: istore 9
    //   1690: goto -1603 -> 87
    //   1693: astore 21
    //   1695: aload 24
    //   1697: monitorexit
    //   1698: aload 21
    //   1700: athrow
    //   1701: astore 22
    //   1703: aload_0
    //   1704: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   1707: astore 21
    //   1709: aload 21
    //   1711: monitorenter
    //   1712: aload_0
    //   1713: invokespecial 139	com/tencent/mobileqq/apollo/view/opengl/GLThread:j	()V
    //   1716: aload_0
    //   1717: invokespecial 141	com/tencent/mobileqq/apollo/view/opengl/GLThread:k	()V
    //   1720: aload 21
    //   1722: monitorexit
    //   1723: aload 22
    //   1725: athrow
    //   1726: astore 22
    //   1728: aload 21
    //   1730: monitorexit
    //   1731: goto +6 -> 1737
    //   1734: aload 22
    //   1736: athrow
    //   1737: goto -3 -> 1734
    //   1740: iconst_0
    //   1741: istore 19
    //   1743: goto -1492 -> 251
    //   1746: goto -1431 -> 315
    //   1749: goto -1357 -> 392
    //   1752: goto -961 -> 791
    //   1755: iload 4
    //   1757: istore_2
    //   1758: goto -678 -> 1080
    //   1761: iload 5
    //   1763: istore_1
    //   1764: iload 8
    //   1766: istore 5
    //   1768: iload 13
    //   1770: istore 4
    //   1772: iload_1
    //   1773: istore 8
    //   1775: iload_3
    //   1776: istore 6
    //   1778: iload 9
    //   1780: istore_3
    //   1781: iload 10
    //   1783: istore_1
    //   1784: goto -679 -> 1105
    //   1787: goto -528 -> 1259
    //   1790: iconst_0
    //   1791: istore_2
    //   1792: goto -478 -> 1314
    //   1795: goto -378 -> 1417
    //   1798: iconst_0
    //   1799: istore 6
    //   1801: goto -363 -> 1438
    //   1804: goto -366 -> 1438
    //   1807: goto -315 -> 1492
    //   1810: iload 18
    //   1812: istore 6
    //   1814: iload 17
    //   1816: istore 4
    //   1818: iload 16
    //   1820: istore_3
    //   1821: iload 15
    //   1823: istore_2
    //   1824: iload 14
    //   1826: istore_1
    //   1827: goto -152 -> 1675
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1830	0	this	GLThread
    //   62	1765	1	i1	int
    //   60	1764	2	i2	int
    //   58	1763	3	i3	int
    //   34	1783	4	i4	int
    //   31	1736	5	i5	int
    //   43	1770	6	i6	int
    //   49	1564	7	i7	int
    //   37	1737	8	i8	int
    //   85	1694	9	i9	int
    //   68	1714	10	i10	int
    //   55	1374	11	i11	int
    //   52	1375	12	i12	int
    //   705	1064	13	i13	int
    //   994	831	14	i14	int
    //   990	832	15	i15	int
    //   986	833	16	i16	int
    //   982	833	17	i17	int
    //   997	814	18	i18	int
    //   175	1567	19	bool1	boolean
    //   422	15	20	bool2	boolean
    //   40	742	21	localObject1	Object
    //   877	11	21	localRuntimeException	java.lang.RuntimeException
    //   890	6	21	localEGLException	EglHelper.EGLException
    //   910	20	21	localGLThreadManager1	GLThreadManager
    //   1178	6	21	localObject2	Object
    //   1221	259	21	localObject3	Object
    //   1487	1	21	localObject4	Object
    //   1550	113	21	localObject5	Object
    //   1670	1	21	localObject6	Object
    //   1693	6	21	localObject7	Object
    //   1707	22	21	localGLThreadManager2	GLThreadManager
    //   46	1	22	localObject8	Object
    //   118	6	22	localObject9	Object
    //   927	6	22	localObject10	Object
    //   1243	225	22	localGL10	javax.microedition.khronos.opengles.GL10
    //   1701	23	22	localObject11	Object
    //   1726	9	22	localObject12	Object
    //   64	1050	23	localRunnable	Runnable
    //   74	1622	24	localObject13	Object
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
    //   1532	1547	1550	finally
    //   1552	1555	1550	finally
    //   87	97	1693	finally
    //   126	149	1693	finally
    //   160	192	1693	finally
    //   192	248	1693	finally
    //   251	309	1693	finally
    //   324	332	1693	finally
    //   340	389	1693	finally
    //   397	416	1693	finally
    //   427	436	1693	finally
    //   441	451	1693	finally
    //   451	493	1693	finally
    //   498	553	1693	finally
    //   553	611	1693	finally
    //   611	622	1693	finally
    //   622	639	1693	finally
    //   639	703	1693	finally
    //   712	767	1693	finally
    //   770	788	1693	finally
    //   791	798	1693	finally
    //   805	812	1693	finally
    //   826	836	1693	finally
    //   848	855	1693	finally
    //   855	867	1693	finally
    //   879	890	1693	finally
    //   892	906	1693	finally
    //   944	951	1693	finally
    //   960	972	1693	finally
    //   999	1073	1693	finally
    //   1080	1099	1693	finally
    //   1105	1108	1693	finally
    //   1653	1669	1693	finally
    //   1675	1682	1693	finally
    //   1695	1698	1693	finally
    //   70	79	1701	finally
    //   1113	1120	1701	finally
    //   1130	1157	1701	finally
    //   1183	1186	1701	finally
    //   1186	1195	1701	finally
    //   1226	1229	1701	finally
    //   1233	1254	1701	finally
    //   1265	1285	1701	finally
    //   1290	1311	1701	finally
    //   1319	1394	1701	finally
    //   1399	1414	1701	finally
    //   1417	1435	1701	finally
    //   1438	1450	1701	finally
    //   1460	1474	1701	finally
    //   1479	1486	1701	finally
    //   1492	1500	1701	finally
    //   1514	1532	1701	finally
    //   1555	1558	1701	finally
    //   1558	1597	1701	finally
    //   1698	1701	1701	finally
    //   1712	1723	1726	finally
    //   1728	1731	1726	finally
  }
  
  private boolean m()
  {
    boolean bool2 = this.d;
    boolean bool1 = true;
    if ((!bool2) && (this.e) && (!this.f) && (this.l > 0) && (this.m > 0))
    {
      if (this.o) {
        return bool1;
      }
      if (this.n == 1) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      synchronized (this.w)
      {
        this.n = paramInt;
        this.w.notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("renderMode");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.w)
    {
      this.l = paramInt1;
      this.m = paramInt2;
      this.s = true;
      this.o = true;
      this.q = false;
      if (Thread.currentThread() == this) {
        return;
      }
      this.w.notifyAll();
      if (this.z) {
        while ((!this.a) && (!this.d) && (!this.q) && (a()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("TextureView onWindowResize waiting for render complete from tid=");
          localStringBuilder.append(getId());
          QLog.i("[ApolloGL][GLThread]Main thread", 1, localStringBuilder.toString());
          try
          {
            this.w.wait();
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
    synchronized (this.w)
    {
      if (Thread.currentThread() == this) {
        return;
      }
      this.p = true;
      this.o = true;
      this.q = false;
      this.t = paramRunnable;
      this.w.notifyAll();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.h) && (this.i) && (m());
  }
  
  public int b()
  {
    synchronized (this.w)
    {
      int i1 = this.n;
      return i1;
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    synchronized (this.w)
    {
      this.t = paramRunnable;
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void c()
  {
    synchronized (this.w)
    {
      this.o = true;
      this.w.notifyAll();
      return;
    }
  }
  
  public void c(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      synchronized (this.w)
      {
        this.r.remove(paramRunnable);
        this.r.add(paramRunnable);
        if (this.r.size() > 100) {
          QLog.e("[ApolloGL][GLThread]", 1, new Object[] { "GLThread runable queueList size is > 100, last r:", paramRunnable });
        }
        this.w.notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("r must not be null");
  }
  
  public void d()
  {
    synchronized (this.w)
    {
      this.e = true;
      this.j = false;
      this.w.notifyAll();
      if (this.z) {
        while ((this.g) && (!this.j))
        {
          boolean bool = this.a;
          if (bool) {
            break;
          }
          try
          {
            this.w.wait();
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
  
  public void e()
  {
    if (this.y)
    {
      this.e = false;
      new Thread(new GLThread.1(this)).start();
      return;
    }
    synchronized (this.w)
    {
      this.e = false;
      this.w.notifyAll();
      if (this.z) {
        while ((!this.g) && (!this.a))
        {
          if ((!this.x) && (QLog.isColorLevel()))
          {
            this.x = true;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("mWaitingForSurface ");
            localStringBuilder.append(this.g);
            localStringBuilder.append(" mExited ");
            localStringBuilder.append(this.a);
            QLog.d("[ApolloGL][GLThread]", 2, localStringBuilder.toString());
          }
          try
          {
            this.w.wait();
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
  
  public void f()
  {
    synchronized (this.w)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause tid=");
      localStringBuilder.append(getId());
      QLog.i("[ApolloGL][GLThread]", 1, localStringBuilder.toString());
      this.c = true;
      this.w.notifyAll();
      while ((!this.a) && (!this.d))
      {
        QLog.i("[ApolloGL][GLThread]Main thread", 1, "onPause waiting for mPaused.");
        try
        {
          this.w.wait();
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
  
  public void g()
  {
    synchronized (this.w)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume tid=");
      localStringBuilder.append(getId());
      QLog.i("[ApolloGL][GLThread]", 1, localStringBuilder.toString());
      this.c = false;
      this.o = true;
      this.q = false;
      this.w.notifyAll();
      while ((!this.a) && (this.d) && (!this.q))
      {
        QLog.i("[ApolloGL][GLThread]Main thread", 1, "onResume waiting for !mPaused.");
        try
        {
          this.w.wait();
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
  
  public void h()
  {
    synchronized (this.w)
    {
      this.b = true;
      this.w.notifyAll();
      if (this.z) {
        for (;;)
        {
          boolean bool = this.a;
          if (bool) {
            break;
          }
          try
          {
            this.w.wait();
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
  
  public void i()
  {
    this.k = true;
    this.w.notifyAll();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 356	com/tencent/mobileqq/apollo/view/opengl/GLThread:l	()V
    //   4: aload_0
    //   5: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   8: aload_0
    //   9: invokevirtual 358	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)V
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: getfield 102	com/tencent/mobileqq/apollo/view/opengl/GLThread:w	Lcom/tencent/mobileqq/apollo/view/opengl/GLThreadManager;
    //   18: aload_0
    //   19: invokevirtual 358	com/tencent/mobileqq/apollo/view/opengl/GLThreadManager:a	(Lcom/tencent/mobileqq/apollo/view/opengl/GLThread;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLThread
 * JD-Core Version:    0.7.0.1
 */