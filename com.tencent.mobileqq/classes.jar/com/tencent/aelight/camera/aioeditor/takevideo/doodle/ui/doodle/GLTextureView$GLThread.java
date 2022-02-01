package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class GLTextureView$GLThread
  extends Thread
{
  private int jdField_a_of_type_Int = 0;
  private GLTextureView.EglHelper jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$EglHelper;
  private WeakReference<GLTextureView> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<Runnable> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 1;
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
  private boolean m = true;
  private boolean n;
  private boolean o = true;
  
  GLTextureView$GLThread(WeakReference<GLTextureView> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private boolean b()
  {
    boolean bool2 = this.e;
    boolean bool1 = true;
    if ((!bool2) && (this.f) && (!this.g) && (this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0))
    {
      if (this.m) {
        return bool1;
      }
      if (this.jdField_c_of_type_Int == 1) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  private void f()
  {
    if (this.j)
    {
      this.j = false;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$EglHelper.b();
    }
  }
  
  private void g()
  {
    if (this.i)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$EglHelper.c();
      this.i = false;
      GLTextureView.a().b(this);
    }
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 69	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper
    //   4: dup
    //   5: aload_0
    //   6: getfield 50	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 89	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 67	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$EglHelper	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 73	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:i	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 65	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:j	Z
    //   25: iconst_0
    //   26: istore 5
    //   28: iconst_0
    //   29: istore 9
    //   31: iconst_0
    //   32: istore 8
    //   34: aconst_null
    //   35: astore 18
    //   37: iconst_0
    //   38: istore 7
    //   40: iconst_0
    //   41: istore 10
    //   43: iconst_0
    //   44: istore_3
    //   45: iconst_0
    //   46: istore 4
    //   48: iconst_0
    //   49: istore_2
    //   50: iconst_0
    //   51: istore_1
    //   52: iconst_0
    //   53: istore 6
    //   55: aconst_null
    //   56: astore 20
    //   58: iload_3
    //   59: istore 11
    //   61: iload 5
    //   63: istore_3
    //   64: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   67: astore 19
    //   69: aload 19
    //   71: monitorenter
    //   72: iload 6
    //   74: istore 12
    //   76: iload 11
    //   78: istore 5
    //   80: iload 8
    //   82: istore 6
    //   84: iload 9
    //   86: istore 8
    //   88: aload_0
    //   89: getfield 91	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_b_of_type_Boolean	Z
    //   92: ifeq +34 -> 126
    //   95: aload 19
    //   97: monitorexit
    //   98: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   101: astore 18
    //   103: aload 18
    //   105: monitorenter
    //   106: aload_0
    //   107: invokespecial 93	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	()V
    //   110: aload_0
    //   111: invokespecial 95	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	()V
    //   114: aload 18
    //   116: monitorexit
    //   117: return
    //   118: astore 19
    //   120: aload 18
    //   122: monitorexit
    //   123: aload 19
    //   125: athrow
    //   126: aload_0
    //   127: getfield 38	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   130: invokevirtual 98	java/util/ArrayList:isEmpty	()Z
    //   133: ifne +41 -> 174
    //   136: aload_0
    //   137: getfield 38	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   140: iconst_0
    //   141: invokevirtual 102	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   144: checkcast 104	java/lang/Runnable
    //   147: astore 20
    //   149: iload_3
    //   150: istore 11
    //   152: iload 8
    //   154: istore 9
    //   156: iload 6
    //   158: istore 8
    //   160: iload 5
    //   162: istore_3
    //   163: iload 12
    //   165: istore 6
    //   167: iload 11
    //   169: istore 5
    //   171: goto +510 -> 681
    //   174: aload_0
    //   175: getfield 59	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:e	Z
    //   178: aload_0
    //   179: getfield 106	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:d	Z
    //   182: if_icmpeq +1005 -> 1187
    //   185: aload_0
    //   186: getfield 106	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:d	Z
    //   189: istore 16
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 106	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:d	Z
    //   196: putfield 59	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:e	Z
    //   199: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   202: invokevirtual 111	java/lang/Object:notifyAll	()V
    //   205: goto +3 -> 208
    //   208: aload_0
    //   209: getfield 113	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:l	Z
    //   212: ifeq +19 -> 231
    //   215: aload_0
    //   216: invokespecial 93	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	()V
    //   219: aload_0
    //   220: invokespecial 95	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	()V
    //   223: aload_0
    //   224: iconst_0
    //   225: putfield 113	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:l	Z
    //   228: iconst_1
    //   229: istore 6
    //   231: iload_3
    //   232: istore 9
    //   234: iload_3
    //   235: ifeq +14 -> 249
    //   238: aload_0
    //   239: invokespecial 93	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	()V
    //   242: aload_0
    //   243: invokespecial 95	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	()V
    //   246: iconst_0
    //   247: istore 9
    //   249: iload 16
    //   251: ifeq +14 -> 265
    //   254: aload_0
    //   255: getfield 65	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:j	Z
    //   258: ifeq +7 -> 265
    //   261: aload_0
    //   262: invokespecial 93	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	()V
    //   265: iload 16
    //   267: ifeq +58 -> 325
    //   270: aload_0
    //   271: getfield 73	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:i	Z
    //   274: ifeq +51 -> 325
    //   277: aload_0
    //   278: getfield 50	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   281: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   284: checkcast 77	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView
    //   287: astore 21
    //   289: aload 21
    //   291: ifnonnull +9 -> 300
    //   294: iconst_0
    //   295: istore 17
    //   297: goto +10 -> 307
    //   300: aload 21
    //   302: invokestatic 122	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView;)Z
    //   305: istore 17
    //   307: iload 17
    //   309: ifeq +12 -> 321
    //   312: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   315: invokevirtual 124	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager:a	()Z
    //   318: ifeq +7 -> 325
    //   321: aload_0
    //   322: invokespecial 95	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	()V
    //   325: iload 16
    //   327: ifeq +19 -> 346
    //   330: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   333: invokevirtual 126	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager:b	()Z
    //   336: ifeq +10 -> 346
    //   339: aload_0
    //   340: getfield 67	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$EglHelper	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper;
    //   343: invokevirtual 75	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper:c	()V
    //   346: aload_0
    //   347: getfield 61	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	Z
    //   350: ifne +846 -> 1196
    //   353: aload_0
    //   354: getfield 128	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:h	Z
    //   357: ifne +839 -> 1196
    //   360: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +830 -> 1193
    //   366: new 135	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   373: astore 21
    //   375: aload 21
    //   377: ldc 138
    //   379: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 21
    //   385: aload_0
    //   386: invokevirtual 146	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:getId	()J
    //   389: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: ldc 151
    //   395: iconst_2
    //   396: aload 21
    //   398: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: goto +3 -> 407
    //   407: aload_0
    //   408: getfield 65	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:j	Z
    //   411: ifeq +7 -> 418
    //   414: aload_0
    //   415: invokespecial 93	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	()V
    //   418: aload_0
    //   419: iconst_1
    //   420: putfield 128	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:h	Z
    //   423: aload_0
    //   424: iconst_0
    //   425: putfield 63	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	Z
    //   428: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   431: invokevirtual 111	java/lang/Object:notifyAll	()V
    //   434: goto +3 -> 437
    //   437: iload 7
    //   439: istore 11
    //   441: iload 9
    //   443: istore 7
    //   445: aload_0
    //   446: getfield 61	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	Z
    //   449: ifeq +21 -> 470
    //   452: aload_0
    //   453: getfield 128	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:h	Z
    //   456: ifeq +14 -> 470
    //   459: aload_0
    //   460: iconst_0
    //   461: putfield 128	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:h	Z
    //   464: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   467: invokevirtual 111	java/lang/Object:notifyAll	()V
    //   470: iload 8
    //   472: istore 9
    //   474: iload 8
    //   476: ifeq +20 -> 496
    //   479: aload_0
    //   480: iconst_1
    //   481: putfield 160	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:n	Z
    //   484: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   487: invokevirtual 111	java/lang/Object:notifyAll	()V
    //   490: iconst_0
    //   491: istore 9
    //   493: iconst_0
    //   494: istore 12
    //   496: aload_0
    //   497: invokespecial 161	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:b	()Z
    //   500: ifeq +621 -> 1121
    //   503: iload 6
    //   505: istore 8
    //   507: iload 5
    //   509: istore_3
    //   510: aload_0
    //   511: getfield 73	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:i	Z
    //   514: ifne +77 -> 591
    //   517: iload 6
    //   519: ifeq +12 -> 531
    //   522: iconst_0
    //   523: istore 8
    //   525: iload 5
    //   527: istore_3
    //   528: goto +63 -> 591
    //   531: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   534: aload_0
    //   535: invokevirtual 164	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)Z
    //   538: istore 16
    //   540: iload 6
    //   542: istore 8
    //   544: iload 5
    //   546: istore_3
    //   547: iload 16
    //   549: ifeq +42 -> 591
    //   552: aload_0
    //   553: getfield 67	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$EglHelper	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper;
    //   556: invokevirtual 166	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper:a	()V
    //   559: aload_0
    //   560: iconst_1
    //   561: putfield 73	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:i	Z
    //   564: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   567: invokevirtual 111	java/lang/Object:notifyAll	()V
    //   570: iconst_1
    //   571: istore_3
    //   572: iload 6
    //   574: istore 8
    //   576: goto +15 -> 591
    //   579: astore 18
    //   581: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   584: aload_0
    //   585: invokevirtual 85	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager:b	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)V
    //   588: aload 18
    //   590: athrow
    //   591: aload_0
    //   592: getfield 73	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:i	Z
    //   595: ifeq +604 -> 1199
    //   598: aload_0
    //   599: getfield 65	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:j	Z
    //   602: ifne +597 -> 1199
    //   605: aload_0
    //   606: iconst_1
    //   607: putfield 65	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:j	Z
    //   610: iconst_1
    //   611: istore 4
    //   613: iconst_1
    //   614: istore_2
    //   615: iconst_1
    //   616: istore_1
    //   617: goto +3 -> 620
    //   620: aload_0
    //   621: getfield 65	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:j	Z
    //   624: ifeq +487 -> 1111
    //   627: aload_0
    //   628: getfield 40	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:o	Z
    //   631: ifeq +571 -> 1202
    //   634: aload_0
    //   635: getfield 42	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_Int	I
    //   638: istore 11
    //   640: aload_0
    //   641: getfield 44	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_b_of_type_Int	I
    //   644: istore 10
    //   646: aload_0
    //   647: iconst_0
    //   648: putfield 40	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:o	Z
    //   651: iconst_1
    //   652: istore 4
    //   654: iconst_1
    //   655: istore_1
    //   656: iconst_1
    //   657: istore 6
    //   659: goto +3 -> 662
    //   662: aload_0
    //   663: iconst_0
    //   664: putfield 46	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:m	Z
    //   667: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   670: invokevirtual 111	java/lang/Object:notifyAll	()V
    //   673: iload 7
    //   675: istore 5
    //   677: iload 11
    //   679: istore 7
    //   681: aload 19
    //   683: monitorexit
    //   684: aload 20
    //   686: ifnull +13 -> 699
    //   689: aload 20
    //   691: invokeinterface 169 1 0
    //   696: goto -641 -> 55
    //   699: iload 4
    //   701: istore 11
    //   703: iload 4
    //   705: ifeq +105 -> 810
    //   708: aload_0
    //   709: getfield 67	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$EglHelper	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper;
    //   712: invokevirtual 170	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper:a	()Z
    //   715: ifeq +39 -> 754
    //   718: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   721: astore 19
    //   723: aload 19
    //   725: monitorenter
    //   726: aload_0
    //   727: iconst_1
    //   728: putfield 172	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:k	Z
    //   731: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   734: invokevirtual 111	java/lang/Object:notifyAll	()V
    //   737: aload 19
    //   739: monitorexit
    //   740: iconst_0
    //   741: istore 11
    //   743: goto +67 -> 810
    //   746: astore 18
    //   748: aload 19
    //   750: monitorexit
    //   751: aload 18
    //   753: athrow
    //   754: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   757: astore 19
    //   759: aload 19
    //   761: monitorenter
    //   762: aload_0
    //   763: iconst_1
    //   764: putfield 172	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:k	Z
    //   767: aload_0
    //   768: iconst_1
    //   769: putfield 63	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	Z
    //   772: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   775: invokevirtual 111	java/lang/Object:notifyAll	()V
    //   778: aload 19
    //   780: monitorexit
    //   781: iload 5
    //   783: istore 14
    //   785: aload 18
    //   787: astore 19
    //   789: iload_3
    //   790: istore 5
    //   792: iload 4
    //   794: istore 12
    //   796: iload_2
    //   797: istore 13
    //   799: goto +410 -> 1209
    //   802: astore 18
    //   804: aload 19
    //   806: monitorexit
    //   807: aload 18
    //   809: athrow
    //   810: iload_2
    //   811: ifeq +419 -> 1230
    //   814: aload_0
    //   815: getfield 67	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$EglHelper	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper;
    //   818: invokevirtual 175	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper:a	()Ljavax/microedition/khronos/opengles/GL;
    //   821: checkcast 177	javax/microedition/khronos/opengles/GL10
    //   824: astore 18
    //   826: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   829: aload 18
    //   831: invokevirtual 180	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   834: iconst_0
    //   835: istore_2
    //   836: goto +3 -> 839
    //   839: iload_3
    //   840: istore 4
    //   842: iload_3
    //   843: ifeq +50 -> 893
    //   846: aload_0
    //   847: getfield 50	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   850: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   853: checkcast 77	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView
    //   856: astore 19
    //   858: aload 19
    //   860: ifnull +373 -> 1233
    //   863: aload 19
    //   865: invokestatic 183	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   868: ifnull +365 -> 1233
    //   871: aload 19
    //   873: invokestatic 183	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   876: aload 18
    //   878: aload_0
    //   879: getfield 67	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$EglHelper	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper;
    //   882: getfield 186	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper:a	Ljavax/microedition/khronos/egl/EGLConfig;
    //   885: invokeinterface 192 3 0
    //   890: goto +343 -> 1233
    //   893: iload_1
    //   894: istore_3
    //   895: iload_1
    //   896: ifeq +47 -> 943
    //   899: aload_0
    //   900: getfield 50	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   903: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   906: checkcast 77	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView
    //   909: astore 19
    //   911: aload 19
    //   913: ifnull +326 -> 1239
    //   916: aload 19
    //   918: invokestatic 183	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   921: ifnull +318 -> 1239
    //   924: aload 19
    //   926: invokestatic 183	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   929: aload 18
    //   931: iload 7
    //   933: iload 10
    //   935: invokeinterface 196 4 0
    //   940: goto +299 -> 1239
    //   943: aload_0
    //   944: getfield 50	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   947: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   950: checkcast 77	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView
    //   953: astore 19
    //   955: aload 19
    //   957: ifnull +28 -> 985
    //   960: aload 19
    //   962: invokestatic 183	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   965: ifnull +20 -> 985
    //   968: aload 18
    //   970: ifnull +15 -> 985
    //   973: aload 19
    //   975: invokestatic 183	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   978: aload 18
    //   980: invokeinterface 199 2 0
    //   985: aload_0
    //   986: getfield 67	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleGLTextureView$EglHelper	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper;
    //   989: invokevirtual 202	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper:a	()I
    //   992: istore_1
    //   993: iload_1
    //   994: sipush 12288
    //   997: if_icmpeq +57 -> 1054
    //   1000: iload_1
    //   1001: sipush 12302
    //   1004: if_icmpeq +44 -> 1048
    //   1007: ldc 204
    //   1009: ldc 206
    //   1011: iload_1
    //   1012: invokestatic 209	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$EglHelper:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1015: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   1018: astore 19
    //   1020: aload 19
    //   1022: monitorenter
    //   1023: aload_0
    //   1024: iconst_1
    //   1025: putfield 63	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	Z
    //   1028: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   1031: invokevirtual 111	java/lang/Object:notifyAll	()V
    //   1034: aload 19
    //   1036: monitorexit
    //   1037: goto +17 -> 1054
    //   1040: astore 18
    //   1042: aload 19
    //   1044: monitorexit
    //   1045: aload 18
    //   1047: athrow
    //   1048: iconst_1
    //   1049: istore 15
    //   1051: goto +7 -> 1058
    //   1054: iload 5
    //   1056: istore 15
    //   1058: iload 15
    //   1060: istore 14
    //   1062: aload 18
    //   1064: astore 19
    //   1066: iload 4
    //   1068: istore 5
    //   1070: iload 11
    //   1072: istore 12
    //   1074: iload_2
    //   1075: istore 13
    //   1077: iload_3
    //   1078: istore_1
    //   1079: iload 6
    //   1081: ifeq +128 -> 1209
    //   1084: iconst_1
    //   1085: istore 9
    //   1087: iload 15
    //   1089: istore 14
    //   1091: aload 18
    //   1093: astore 19
    //   1095: iload 4
    //   1097: istore 5
    //   1099: iload 11
    //   1101: istore 12
    //   1103: iload_2
    //   1104: istore 13
    //   1106: iload_3
    //   1107: istore_1
    //   1108: goto +101 -> 1209
    //   1111: iload 8
    //   1113: istore 6
    //   1115: iload_3
    //   1116: istore 5
    //   1118: goto +3 -> 1121
    //   1121: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   1124: invokevirtual 212	java/lang/Object:wait	()V
    //   1127: iload 7
    //   1129: istore_3
    //   1130: iload 11
    //   1132: istore 7
    //   1134: iload 9
    //   1136: istore 8
    //   1138: goto -1050 -> 88
    //   1141: astore 18
    //   1143: aload 19
    //   1145: monitorexit
    //   1146: aload 18
    //   1148: athrow
    //   1149: astore 19
    //   1151: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   1154: astore 18
    //   1156: aload 18
    //   1158: monitorenter
    //   1159: aload_0
    //   1160: invokespecial 93	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:f	()V
    //   1163: aload_0
    //   1164: invokespecial 95	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:g	()V
    //   1167: aload 18
    //   1169: monitorexit
    //   1170: aload 19
    //   1172: athrow
    //   1173: astore 19
    //   1175: aload 18
    //   1177: monitorexit
    //   1178: goto +6 -> 1184
    //   1181: aload 19
    //   1183: athrow
    //   1184: goto -3 -> 1181
    //   1187: iconst_0
    //   1188: istore 16
    //   1190: goto -982 -> 208
    //   1193: goto -786 -> 407
    //   1196: goto -759 -> 437
    //   1199: goto -579 -> 620
    //   1202: iload 12
    //   1204: istore 6
    //   1206: goto -544 -> 662
    //   1209: iload 14
    //   1211: istore_3
    //   1212: aload 19
    //   1214: astore 18
    //   1216: iload 5
    //   1218: istore 11
    //   1220: iload 12
    //   1222: istore 4
    //   1224: iload 13
    //   1226: istore_2
    //   1227: goto -1163 -> 64
    //   1230: goto -391 -> 839
    //   1233: iconst_0
    //   1234: istore 4
    //   1236: goto -343 -> 893
    //   1239: iconst_0
    //   1240: istore_3
    //   1241: goto -298 -> 943
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1244	0	this	GLThread
    //   51	1057	1	i1	int
    //   49	1178	2	i2	int
    //   44	1197	3	i3	int
    //   46	1189	4	i4	int
    //   26	1191	5	i5	int
    //   53	1152	6	i6	int
    //   38	1095	7	i7	int
    //   32	1105	8	i8	int
    //   29	1106	9	i9	int
    //   41	893	10	i10	int
    //   59	1160	11	i11	int
    //   74	1147	12	i12	int
    //   797	428	13	i13	int
    //   783	427	14	i14	int
    //   1049	39	15	i15	int
    //   189	1000	16	bool1	boolean
    //   295	13	17	bool2	boolean
    //   35	86	18	localGLThreadManager1	GLTextureView.GLThreadManager
    //   579	10	18	localRuntimeException	java.lang.RuntimeException
    //   746	40	18	localObject1	Object
    //   802	6	18	localObject2	Object
    //   824	155	18	localGL10	javax.microedition.khronos.opengles.GL10
    //   1040	52	18	localObject3	Object
    //   1141	6	18	localObject4	Object
    //   1154	61	18	localObject5	Object
    //   67	29	19	localGLThreadManager2	GLTextureView.GLThreadManager
    //   118	564	19	localObject6	Object
    //   721	423	19	localObject7	Object
    //   1149	22	19	localObject8	Object
    //   1173	40	19	localObject9	Object
    //   56	634	20	localRunnable	Runnable
    //   287	110	21	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   106	117	118	finally
    //   120	123	118	finally
    //   552	559	579	java/lang/RuntimeException
    //   726	740	746	finally
    //   748	751	746	finally
    //   762	781	802	finally
    //   804	807	802	finally
    //   1023	1037	1040	finally
    //   1042	1045	1040	finally
    //   88	98	1141	finally
    //   126	149	1141	finally
    //   174	205	1141	finally
    //   208	228	1141	finally
    //   238	246	1141	finally
    //   254	265	1141	finally
    //   270	289	1141	finally
    //   300	307	1141	finally
    //   312	321	1141	finally
    //   321	325	1141	finally
    //   330	346	1141	finally
    //   346	404	1141	finally
    //   407	418	1141	finally
    //   418	434	1141	finally
    //   445	470	1141	finally
    //   479	490	1141	finally
    //   496	503	1141	finally
    //   510	517	1141	finally
    //   531	540	1141	finally
    //   552	559	1141	finally
    //   559	570	1141	finally
    //   581	591	1141	finally
    //   591	610	1141	finally
    //   620	651	1141	finally
    //   662	673	1141	finally
    //   681	684	1141	finally
    //   1121	1127	1141	finally
    //   1143	1146	1141	finally
    //   64	72	1149	finally
    //   689	696	1149	finally
    //   708	726	1149	finally
    //   751	754	1149	finally
    //   754	762	1149	finally
    //   807	810	1149	finally
    //   814	834	1149	finally
    //   846	858	1149	finally
    //   863	890	1149	finally
    //   899	911	1149	finally
    //   916	940	1149	finally
    //   943	955	1149	finally
    //   960	968	1149	finally
    //   973	985	1149	finally
    //   985	993	1149	finally
    //   1007	1023	1149	finally
    //   1045	1048	1149	finally
    //   1146	1149	1149	finally
    //   1159	1170	1173	finally
    //   1175	1178	1173	finally
  }
  
  public int a()
  {
    synchronized ()
    {
      int i1 = this.jdField_c_of_type_Int;
      return i1;
    }
  }
  
  public void a()
  {
    synchronized ()
    {
      this.m = true;
      GLTextureView.a().notifyAll();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      synchronized (GLTextureView.a())
      {
        this.jdField_c_of_type_Int = paramInt;
        GLTextureView.a().notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("renderMode");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized ()
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.o = true;
      this.m = true;
      this.n = false;
      GLTextureView.a().notifyAll();
      while ((!this.jdField_c_of_type_Boolean) && (!this.e) && (!this.n))
      {
        boolean bool = a();
        if (!bool) {
          break;
        }
        try
        {
          GLTextureView.a().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label78:
          break label78;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      synchronized (GLTextureView.a())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramRunnable);
        GLTextureView.a().notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("r must not be null");
  }
  
  public boolean a()
  {
    return (this.i) && (this.j) && (b());
  }
  
  public void b()
  {
    synchronized ()
    {
      this.f = true;
      this.k = false;
      GLTextureView.a().notifyAll();
      while ((this.h) && (!this.k))
      {
        boolean bool = this.jdField_c_of_type_Boolean;
        if (bool) {
          break;
        }
        try
        {
          GLTextureView.a().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label54:
          break label54;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void c()
  {
    synchronized ()
    {
      this.f = false;
      GLTextureView.a().notifyAll();
      while ((!this.h) && (!this.jdField_c_of_type_Boolean))
      {
        if ((!this.jdField_a_of_type_Boolean) && (QLog.isColorLevel()))
        {
          this.jdField_a_of_type_Boolean = true;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mWaitingForSurface ");
          localStringBuilder.append(this.h);
          localStringBuilder.append(" mExited ");
          localStringBuilder.append(this.jdField_c_of_type_Boolean);
          QLog.d("GLTextureView", 2, localStringBuilder.toString());
        }
        try
        {
          GLTextureView.a().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label108:
          break label108;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void d()
  {
    synchronized ()
    {
      this.jdField_b_of_type_Boolean = true;
      GLTextureView.a().notifyAll();
      for (;;)
      {
        boolean bool = this.jdField_c_of_type_Boolean;
        if (bool) {
          break;
        }
        try
        {
          GLTextureView.a().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label35:
          break label35;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void e()
  {
    this.l = true;
    GLTextureView.a().notifyAll();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 135	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 247
    //   11: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 146	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:getId	()J
    //   20: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 250	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:setName	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: invokespecial 252	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread:h	()V
    //   36: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   39: aload_0
    //   40: invokevirtual 254	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)V
    //   43: return
    //   44: astore_1
    //   45: invokestatic 80	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView:a	()Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager;
    //   48: aload_0
    //   49: invokevirtual 254	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThreadManager:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)V
    //   52: aload_1
    //   53: athrow
    //   54: astore_1
    //   55: goto -19 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	GLThread
    //   7	19	1	localStringBuilder	StringBuilder
    //   44	9	1	localObject	Object
    //   54	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   32	36	44	finally
    //   32	36	54	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.GLThread
 * JD-Core Version:    0.7.0.1
 */