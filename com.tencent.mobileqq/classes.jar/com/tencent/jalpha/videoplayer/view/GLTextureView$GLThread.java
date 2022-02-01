package com.tencent.jalpha.videoplayer.view;

import com.tencent.jalpha.common.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class GLTextureView$GLThread
  extends Thread
{
  private GLTextureView.EglHelper mEglHelper;
  private ArrayList<Runnable> mEventQueue = new ArrayList();
  private boolean mExited;
  private boolean mFinishedCreatingEglSurface;
  private WeakReference<GLTextureView> mGLTextureViewWeakRef;
  private boolean mHasSurface;
  private boolean mHaveEglContext;
  private boolean mHaveEglSurface;
  private int mHeight = 0;
  private boolean mLogPrinted = false;
  private boolean mPaused;
  private boolean mRenderComplete;
  private int mRenderMode = 1;
  private boolean mRequestPaused;
  private boolean mRequestRender = true;
  private boolean mShouldExit;
  private boolean mShouldReleaseEglContext;
  private boolean mSizeChanged = true;
  private boolean mSurfaceIsBad;
  private boolean mWaitingForSurface;
  private int mWidth = 0;
  
  GLTextureView$GLThread(WeakReference<GLTextureView> paramWeakReference)
  {
    this.mGLTextureViewWeakRef = paramWeakReference;
  }
  
  /* Error */
  private void guardedRun()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 68	com/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper
    //   4: dup
    //   5: aload_0
    //   6: getfield 56	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 70	com/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 72	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mEglHelper	Lcom/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 74	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHaveEglContext	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 76	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHaveEglSurface	Z
    //   25: iconst_1
    //   26: istore 19
    //   28: iconst_0
    //   29: istore 10
    //   31: aconst_null
    //   32: astore 23
    //   34: iconst_0
    //   35: istore_1
    //   36: iconst_0
    //   37: istore_3
    //   38: iconst_0
    //   39: istore 5
    //   41: iconst_0
    //   42: istore 6
    //   44: iconst_0
    //   45: istore 7
    //   47: iconst_0
    //   48: istore 8
    //   50: iconst_0
    //   51: istore 9
    //   53: aconst_null
    //   54: astore 22
    //   56: iconst_0
    //   57: istore_2
    //   58: iconst_0
    //   59: istore 4
    //   61: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   64: astore 24
    //   66: aload 24
    //   68: monitorenter
    //   69: iload 10
    //   71: istore 11
    //   73: iload 7
    //   75: istore 10
    //   77: iload 4
    //   79: istore 14
    //   81: aload_0
    //   82: getfield 84	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mShouldExit	Z
    //   85: istore 20
    //   87: iload 20
    //   89: ifeq +28 -> 117
    //   92: iconst_0
    //   93: istore_2
    //   94: aload 24
    //   96: monitorexit
    //   97: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   100: astore 22
    //   102: aload 22
    //   104: monitorenter
    //   105: aload_0
    //   106: invokespecial 87	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:stopEglSurfaceLocked	()V
    //   109: aload_0
    //   110: invokespecial 90	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:stopEglContextLocked	()V
    //   113: aload 22
    //   115: monitorexit
    //   116: return
    //   117: aload_0
    //   118: getfield 52	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mEventQueue	Ljava/util/ArrayList;
    //   121: invokevirtual 94	java/util/ArrayList:isEmpty	()Z
    //   124: ifne +93 -> 217
    //   127: aload_0
    //   128: getfield 52	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mEventQueue	Ljava/util/ArrayList;
    //   131: iconst_0
    //   132: invokevirtual 98	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   135: checkcast 100	java/lang/Runnable
    //   138: astore 22
    //   140: iload 10
    //   142: istore 7
    //   144: iload 6
    //   146: istore 12
    //   148: iload_1
    //   149: istore 4
    //   151: iload 11
    //   153: istore 10
    //   155: iload 7
    //   157: istore 6
    //   159: iload 12
    //   161: istore 7
    //   163: iload_2
    //   164: istore_1
    //   165: iload 14
    //   167: istore_2
    //   168: aload 24
    //   170: monitorexit
    //   171: aload 22
    //   173: ifnull +649 -> 822
    //   176: aload 22
    //   178: invokeinterface 103 1 0
    //   183: iload 6
    //   185: istore 11
    //   187: aconst_null
    //   188: astore 22
    //   190: iload_1
    //   191: istore 12
    //   193: iload_2
    //   194: istore 6
    //   196: iload 4
    //   198: istore_1
    //   199: iload 12
    //   201: istore_2
    //   202: iload 6
    //   204: istore 4
    //   206: iload 7
    //   208: istore 6
    //   210: iload 11
    //   212: istore 7
    //   214: goto -153 -> 61
    //   217: aload_0
    //   218: getfield 105	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mPaused	Z
    //   221: aload_0
    //   222: getfield 107	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mRequestPaused	Z
    //   225: if_icmpeq +1067 -> 1292
    //   228: aload_0
    //   229: getfield 107	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mRequestPaused	Z
    //   232: istore 20
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 107	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mRequestPaused	Z
    //   239: putfield 105	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mPaused	Z
    //   242: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   245: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   248: iload_3
    //   249: istore 4
    //   251: aload_0
    //   252: getfield 114	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mShouldReleaseEglContext	Z
    //   255: ifeq +19 -> 274
    //   258: aload_0
    //   259: invokespecial 87	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:stopEglSurfaceLocked	()V
    //   262: aload_0
    //   263: invokespecial 90	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:stopEglContextLocked	()V
    //   266: aload_0
    //   267: iconst_0
    //   268: putfield 114	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mShouldReleaseEglContext	Z
    //   271: iconst_1
    //   272: istore 4
    //   274: iload 10
    //   276: istore 7
    //   278: iload 10
    //   280: ifeq +14 -> 294
    //   283: aload_0
    //   284: invokespecial 87	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:stopEglSurfaceLocked	()V
    //   287: aload_0
    //   288: invokespecial 90	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:stopEglContextLocked	()V
    //   291: iconst_0
    //   292: istore 7
    //   294: iload 20
    //   296: ifeq +14 -> 310
    //   299: aload_0
    //   300: getfield 76	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHaveEglSurface	Z
    //   303: ifeq +7 -> 310
    //   306: aload_0
    //   307: invokespecial 87	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:stopEglSurfaceLocked	()V
    //   310: iload 20
    //   312: ifeq +48 -> 360
    //   315: aload_0
    //   316: getfield 74	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHaveEglContext	Z
    //   319: ifeq +41 -> 360
    //   322: aload_0
    //   323: getfield 56	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
    //   326: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   329: checkcast 78	com/tencent/jalpha/videoplayer/view/GLTextureView
    //   332: astore 25
    //   334: aload 25
    //   336: ifnonnull +339 -> 675
    //   339: iconst_0
    //   340: istore 21
    //   342: iload 21
    //   344: ifeq +12 -> 356
    //   347: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   350: invokevirtual 125	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager:shouldReleaseEGLContextWhenPausing	()Z
    //   353: ifeq +7 -> 360
    //   356: aload_0
    //   357: invokespecial 90	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:stopEglContextLocked	()V
    //   360: iload 20
    //   362: ifeq +19 -> 381
    //   365: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   368: invokevirtual 128	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager:shouldTerminateEGLWhenPausing	()Z
    //   371: ifeq +10 -> 381
    //   374: aload_0
    //   375: getfield 72	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mEglHelper	Lcom/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper;
    //   378: invokevirtual 131	com/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper:finish	()V
    //   381: aload_0
    //   382: getfield 133	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHasSurface	Z
    //   385: ifne +64 -> 449
    //   388: aload_0
    //   389: getfield 135	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mWaitingForSurface	Z
    //   392: ifne +57 -> 449
    //   395: ldc 137
    //   397: new 139	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   404: ldc 142
    //   406: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload_0
    //   410: invokevirtual 150	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:getId	()J
    //   413: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   416: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 163	com/tencent/jalpha/common/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: aload_0
    //   423: getfield 76	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHaveEglSurface	Z
    //   426: ifeq +7 -> 433
    //   429: aload_0
    //   430: invokespecial 87	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:stopEglSurfaceLocked	()V
    //   433: aload_0
    //   434: iconst_1
    //   435: putfield 135	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mWaitingForSurface	Z
    //   438: aload_0
    //   439: iconst_0
    //   440: putfield 165	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mSurfaceIsBad	Z
    //   443: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   446: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   449: aload_0
    //   450: getfield 133	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHasSurface	Z
    //   453: ifeq +21 -> 474
    //   456: aload_0
    //   457: getfield 135	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mWaitingForSurface	Z
    //   460: ifeq +14 -> 474
    //   463: aload_0
    //   464: iconst_0
    //   465: putfield 135	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mWaitingForSurface	Z
    //   468: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   471: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   474: iload 14
    //   476: istore 12
    //   478: iload 5
    //   480: istore 13
    //   482: iload 14
    //   484: ifeq +20 -> 504
    //   487: iconst_0
    //   488: istore 13
    //   490: iconst_0
    //   491: istore 12
    //   493: aload_0
    //   494: iconst_1
    //   495: putfield 167	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mRenderComplete	Z
    //   498: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   501: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   504: iload 4
    //   506: istore_3
    //   507: iload 6
    //   509: istore 15
    //   511: iload 8
    //   513: istore 16
    //   515: iload 9
    //   517: istore 17
    //   519: iload 11
    //   521: istore 18
    //   523: aload_0
    //   524: invokespecial 170	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:readyToDraw	()Z
    //   527: ifeq +258 -> 785
    //   530: iload 4
    //   532: istore_3
    //   533: iload 11
    //   535: istore 10
    //   537: aload_0
    //   538: getfield 74	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHaveEglContext	Z
    //   541: ifne +14 -> 555
    //   544: iload 4
    //   546: ifeq +139 -> 685
    //   549: iconst_0
    //   550: istore_3
    //   551: iload 11
    //   553: istore 10
    //   555: aload_0
    //   556: getfield 74	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHaveEglContext	Z
    //   559: ifeq +722 -> 1281
    //   562: aload_0
    //   563: getfield 76	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHaveEglSurface	Z
    //   566: ifne +715 -> 1281
    //   569: aload_0
    //   570: iconst_1
    //   571: putfield 76	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHaveEglSurface	Z
    //   574: iconst_1
    //   575: istore 9
    //   577: iconst_1
    //   578: istore 5
    //   580: iconst_1
    //   581: istore 4
    //   583: aload_0
    //   584: getfield 76	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHaveEglSurface	Z
    //   587: ifeq +714 -> 1301
    //   590: aload_0
    //   591: getfield 54	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mSizeChanged	Z
    //   594: ifeq +670 -> 1264
    //   597: iconst_1
    //   598: istore_2
    //   599: aload_0
    //   600: getfield 41	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mWidth	I
    //   603: istore 6
    //   605: aload_0
    //   606: getfield 43	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHeight	I
    //   609: istore_1
    //   610: iconst_1
    //   611: istore 8
    //   613: iconst_1
    //   614: istore 5
    //   616: aload_0
    //   617: iconst_0
    //   618: putfield 54	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mSizeChanged	Z
    //   621: aload_0
    //   622: iconst_0
    //   623: putfield 47	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mRequestRender	Z
    //   626: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   629: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   632: iload 4
    //   634: istore 11
    //   636: iload 12
    //   638: istore 4
    //   640: iload 6
    //   642: istore 12
    //   644: iload 7
    //   646: istore 6
    //   648: iload_2
    //   649: istore 7
    //   651: iload 5
    //   653: istore 9
    //   655: iload 4
    //   657: istore_2
    //   658: iload_1
    //   659: istore 4
    //   661: iload 12
    //   663: istore_1
    //   664: iload 8
    //   666: istore 5
    //   668: iload 11
    //   670: istore 8
    //   672: goto -504 -> 168
    //   675: aload 25
    //   677: invokestatic 174	com/tencent/jalpha/videoplayer/view/GLTextureView:access$900	(Lcom/tencent/jalpha/videoplayer/view/GLTextureView;)Z
    //   680: istore 21
    //   682: goto -340 -> 342
    //   685: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   688: aload_0
    //   689: invokevirtual 178	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager:tryAcquireEglContextLocked	(Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThread;)Z
    //   692: istore 20
    //   694: iload 4
    //   696: istore_3
    //   697: iload 11
    //   699: istore 10
    //   701: iload 20
    //   703: ifeq -148 -> 555
    //   706: aload_0
    //   707: getfield 72	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mEglHelper	Lcom/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper;
    //   710: invokevirtual 181	com/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper:start	()V
    //   713: aload_0
    //   714: iconst_1
    //   715: putfield 74	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mHaveEglContext	Z
    //   718: iconst_1
    //   719: istore 10
    //   721: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   724: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   727: iload 4
    //   729: istore_3
    //   730: goto -175 -> 555
    //   733: astore 22
    //   735: iconst_1
    //   736: istore_1
    //   737: iload_1
    //   738: istore_2
    //   739: aload 24
    //   741: monitorexit
    //   742: aload 22
    //   744: athrow
    //   745: astore 22
    //   747: iload_1
    //   748: ifeq +22 -> 770
    //   751: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   754: astore 23
    //   756: aload 23
    //   758: monitorenter
    //   759: aload_0
    //   760: invokespecial 87	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:stopEglSurfaceLocked	()V
    //   763: aload_0
    //   764: invokespecial 90	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:stopEglContextLocked	()V
    //   767: aload 23
    //   769: monitorexit
    //   770: aload 22
    //   772: athrow
    //   773: astore 22
    //   775: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   778: aload_0
    //   779: invokevirtual 185	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager:releaseEglContextLocked	(Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThread;)V
    //   782: aload 22
    //   784: athrow
    //   785: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   788: invokevirtual 188	java/lang/Object:wait	()V
    //   791: iload 12
    //   793: istore 14
    //   795: iload 13
    //   797: istore 5
    //   799: iload 15
    //   801: istore 6
    //   803: iload 7
    //   805: istore 10
    //   807: iload 16
    //   809: istore 8
    //   811: iload 17
    //   813: istore 9
    //   815: iload 18
    //   817: istore 11
    //   819: goto -738 -> 81
    //   822: iload 9
    //   824: ifeq +437 -> 1261
    //   827: aload_0
    //   828: getfield 72	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mEglHelper	Lcom/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper;
    //   831: invokevirtual 191	com/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper:createSurface	()Z
    //   834: ifne +69 -> 903
    //   837: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   840: astore 24
    //   842: aload 24
    //   844: monitorenter
    //   845: aload_0
    //   846: iconst_1
    //   847: putfield 193	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mFinishedCreatingEglSurface	Z
    //   850: aload_0
    //   851: iconst_1
    //   852: putfield 165	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mSurfaceIsBad	Z
    //   855: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   858: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   861: aload 24
    //   863: monitorexit
    //   864: iload 6
    //   866: istore 11
    //   868: iload_1
    //   869: istore 12
    //   871: iload_2
    //   872: istore 6
    //   874: iload 4
    //   876: istore_1
    //   877: iload 12
    //   879: istore_2
    //   880: iload 6
    //   882: istore 4
    //   884: iload 7
    //   886: istore 6
    //   888: iload 11
    //   890: istore 7
    //   892: goto -831 -> 61
    //   895: astore 22
    //   897: aload 24
    //   899: monitorexit
    //   900: aload 22
    //   902: athrow
    //   903: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   906: astore 24
    //   908: aload 24
    //   910: monitorenter
    //   911: aload_0
    //   912: iconst_1
    //   913: putfield 193	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mFinishedCreatingEglSurface	Z
    //   916: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   919: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   922: aload 24
    //   924: monitorexit
    //   925: iconst_0
    //   926: istore 9
    //   928: iload 8
    //   930: ifeq +328 -> 1258
    //   933: aload_0
    //   934: getfield 72	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mEglHelper	Lcom/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper;
    //   937: invokevirtual 197	com/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper:createGL	()Ljavax/microedition/khronos/opengles/GL;
    //   940: checkcast 199	javax/microedition/khronos/opengles/GL10
    //   943: astore 23
    //   945: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   948: aload 23
    //   950: invokevirtual 203	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager:checkGLDriver	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   953: iconst_0
    //   954: istore 8
    //   956: iload 10
    //   958: istore 11
    //   960: iload 10
    //   962: ifeq +50 -> 1012
    //   965: aload_0
    //   966: getfield 56	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
    //   969: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   972: checkcast 78	com/tencent/jalpha/videoplayer/view/GLTextureView
    //   975: astore 24
    //   977: aload 24
    //   979: ifnull +349 -> 1328
    //   982: aload 24
    //   984: invokestatic 207	com/tencent/jalpha/videoplayer/view/GLTextureView:access$1000	(Lcom/tencent/jalpha/videoplayer/view/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   987: ifnull +341 -> 1328
    //   990: aload 24
    //   992: invokestatic 207	com/tencent/jalpha/videoplayer/view/GLTextureView:access$1000	(Lcom/tencent/jalpha/videoplayer/view/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   995: aload 23
    //   997: aload_0
    //   998: getfield 72	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mEglHelper	Lcom/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper;
    //   1001: getfield 211	com/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1004: invokeinterface 217 3 0
    //   1009: goto +319 -> 1328
    //   1012: iload 7
    //   1014: istore 10
    //   1016: iload 7
    //   1018: ifeq +46 -> 1064
    //   1021: aload_0
    //   1022: getfield 56	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1025: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1028: checkcast 78	com/tencent/jalpha/videoplayer/view/GLTextureView
    //   1031: astore 24
    //   1033: aload 24
    //   1035: ifnull +299 -> 1334
    //   1038: aload 24
    //   1040: invokestatic 207	com/tencent/jalpha/videoplayer/view/GLTextureView:access$1000	(Lcom/tencent/jalpha/videoplayer/view/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   1043: ifnull +291 -> 1334
    //   1046: aload 24
    //   1048: invokestatic 207	com/tencent/jalpha/videoplayer/view/GLTextureView:access$1000	(Lcom/tencent/jalpha/videoplayer/view/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   1051: aload 23
    //   1053: iload_1
    //   1054: iload 4
    //   1056: invokeinterface 221 4 0
    //   1061: goto +273 -> 1334
    //   1064: aload_0
    //   1065: getfield 56	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1068: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1071: checkcast 78	com/tencent/jalpha/videoplayer/view/GLTextureView
    //   1074: astore 24
    //   1076: aload 24
    //   1078: ifnull +23 -> 1101
    //   1081: aload 24
    //   1083: invokestatic 207	com/tencent/jalpha/videoplayer/view/GLTextureView:access$1000	(Lcom/tencent/jalpha/videoplayer/view/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   1086: ifnull +15 -> 1101
    //   1089: aload 24
    //   1091: invokestatic 207	com/tencent/jalpha/videoplayer/view/GLTextureView:access$1000	(Lcom/tencent/jalpha/videoplayer/view/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   1094: aload 23
    //   1096: invokeinterface 224 2 0
    //   1101: aload_0
    //   1102: getfield 72	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mEglHelper	Lcom/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper;
    //   1105: invokevirtual 228	com/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper:swap	()I
    //   1108: istore 12
    //   1110: iload 6
    //   1112: istore 7
    //   1114: iload 12
    //   1116: lookupswitch	default:+224->1340, 12288:+63->1179, 12302:+105->1221
    //   1145: <illegal opcode>
    //   1146: ldc 232
    //   1148: iload 12
    //   1150: invokestatic 236	com/tencent/jalpha/videoplayer/view/GLTextureView$EglHelper:logEglErrorAsWarning	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1153: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   1156: astore 24
    //   1158: aload 24
    //   1160: monitorenter
    //   1161: aload_0
    //   1162: iconst_1
    //   1163: putfield 165	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:mSurfaceIsBad	Z
    //   1166: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   1169: invokevirtual 112	java/lang/Object:notifyAll	()V
    //   1172: aload 24
    //   1174: monitorexit
    //   1175: iload 6
    //   1177: istore 7
    //   1179: iload 5
    //   1181: ifeq +117 -> 1298
    //   1184: iconst_1
    //   1185: istore_2
    //   1186: iload_1
    //   1187: istore 12
    //   1189: iload_2
    //   1190: istore 6
    //   1192: iload 4
    //   1194: istore_1
    //   1195: iload 12
    //   1197: istore_2
    //   1198: iload 6
    //   1200: istore 4
    //   1202: iload 10
    //   1204: istore 6
    //   1206: iload 11
    //   1208: istore 10
    //   1210: goto -1149 -> 61
    //   1213: astore 22
    //   1215: aload 24
    //   1217: monitorexit
    //   1218: aload 22
    //   1220: athrow
    //   1221: iconst_1
    //   1222: istore 7
    //   1224: goto -45 -> 1179
    //   1227: astore 22
    //   1229: aload 24
    //   1231: monitorexit
    //   1232: aload 22
    //   1234: athrow
    //   1235: astore 22
    //   1237: aload 23
    //   1239: monitorexit
    //   1240: aload 22
    //   1242: athrow
    //   1243: astore 23
    //   1245: aload 22
    //   1247: monitorexit
    //   1248: aload 23
    //   1250: athrow
    //   1251: astore 22
    //   1253: iload_2
    //   1254: istore_1
    //   1255: goto -518 -> 737
    //   1258: goto -302 -> 956
    //   1261: goto -333 -> 928
    //   1264: iload 13
    //   1266: istore 8
    //   1268: iload_2
    //   1269: istore 6
    //   1271: iload 5
    //   1273: istore_2
    //   1274: iload 9
    //   1276: istore 5
    //   1278: goto -657 -> 621
    //   1281: iload 6
    //   1283: istore 5
    //   1285: iload 8
    //   1287: istore 4
    //   1289: goto -706 -> 583
    //   1292: iconst_0
    //   1293: istore 20
    //   1295: goto -1047 -> 248
    //   1298: goto -112 -> 1186
    //   1301: iload 5
    //   1303: istore 15
    //   1305: iload 4
    //   1307: istore 16
    //   1309: iload 9
    //   1311: istore 17
    //   1313: iload 10
    //   1315: istore 18
    //   1317: goto -532 -> 785
    //   1320: astore 22
    //   1322: iload 19
    //   1324: istore_1
    //   1325: goto -578 -> 747
    //   1328: iconst_0
    //   1329: istore 11
    //   1331: goto -319 -> 1012
    //   1334: iconst_0
    //   1335: istore 10
    //   1337: goto -273 -> 1064
    //   1340: goto -196 -> 1144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1343	0	this	GLThread
    //   35	1290	1	i	int
    //   57	1217	2	j	int
    //   37	693	3	k	int
    //   59	1247	4	m	int
    //   39	1263	5	n	int
    //   42	1240	6	i1	int
    //   45	1178	7	i2	int
    //   48	1238	8	i3	int
    //   51	1259	9	i4	int
    //   29	1307	10	i5	int
    //   71	1259	11	i6	int
    //   146	1050	12	i7	int
    //   480	785	13	i8	int
    //   79	715	14	i9	int
    //   509	795	15	i10	int
    //   513	795	16	i11	int
    //   517	795	17	i12	int
    //   521	795	18	i13	int
    //   26	1297	19	i14	int
    //   85	1209	20	bool1	boolean
    //   340	341	21	bool2	boolean
    //   54	135	22	localObject1	Object
    //   733	10	22	localObject2	Object
    //   745	26	22	localObject3	Object
    //   773	10	22	localRuntimeException	java.lang.RuntimeException
    //   895	6	22	localObject4	Object
    //   1213	6	22	localObject5	Object
    //   1227	6	22	localObject6	Object
    //   1235	11	22	localObject7	Object
    //   1251	1	22	localObject8	Object
    //   1320	1	22	localObject9	Object
    //   32	1206	23	localObject10	Object
    //   1243	6	23	localObject11	Object
    //   332	344	25	localGLTextureView	GLTextureView
    // Exception table:
    //   from	to	target	type
    //   81	87	733	finally
    //   117	140	733	finally
    //   168	171	733	finally
    //   217	248	733	finally
    //   251	271	733	finally
    //   283	291	733	finally
    //   299	310	733	finally
    //   315	334	733	finally
    //   347	356	733	finally
    //   356	360	733	finally
    //   365	381	733	finally
    //   381	433	733	finally
    //   433	449	733	finally
    //   449	474	733	finally
    //   493	504	733	finally
    //   523	530	733	finally
    //   537	544	733	finally
    //   555	574	733	finally
    //   583	597	733	finally
    //   599	610	733	finally
    //   616	621	733	finally
    //   621	632	733	finally
    //   675	682	733	finally
    //   685	694	733	finally
    //   706	713	733	finally
    //   713	718	733	finally
    //   721	727	733	finally
    //   775	785	733	finally
    //   785	791	733	finally
    //   742	745	745	finally
    //   706	713	773	java/lang/RuntimeException
    //   845	864	895	finally
    //   897	900	895	finally
    //   911	925	1213	finally
    //   1215	1218	1213	finally
    //   1161	1175	1227	finally
    //   1229	1232	1227	finally
    //   759	770	1235	finally
    //   1237	1240	1235	finally
    //   105	116	1243	finally
    //   1245	1248	1243	finally
    //   94	97	1251	finally
    //   739	742	1251	finally
    //   61	69	1320	finally
    //   176	183	1320	finally
    //   827	845	1320	finally
    //   900	903	1320	finally
    //   903	911	1320	finally
    //   933	953	1320	finally
    //   965	977	1320	finally
    //   982	1009	1320	finally
    //   1021	1033	1320	finally
    //   1038	1061	1320	finally
    //   1064	1076	1320	finally
    //   1081	1101	1320	finally
    //   1101	1110	1320	finally
    //   1144	1161	1320	finally
    //   1218	1221	1320	finally
    //   1232	1235	1320	finally
  }
  
  private boolean readyToDraw()
  {
    return (!this.mPaused) && (this.mHasSurface) && (!this.mSurfaceIsBad) && (this.mWidth > 0) && (this.mHeight > 0) && ((this.mRequestRender) || (this.mRenderMode == 1));
  }
  
  private void stopEglContextLocked()
  {
    if (this.mHaveEglContext)
    {
      this.mEglHelper.finish();
      this.mHaveEglContext = false;
      GLTextureView.access$800().releaseEglContextLocked(this);
    }
  }
  
  private void stopEglSurfaceLocked()
  {
    if (this.mHaveEglSurface)
    {
      this.mHaveEglSurface = false;
      this.mEglHelper.destroySurface();
    }
  }
  
  public boolean ableToDraw()
  {
    return (this.mHaveEglContext) && (this.mHaveEglSurface) && (readyToDraw());
  }
  
  public int getRenderMode()
  {
    synchronized ()
    {
      int i = this.mRenderMode;
      return i;
    }
  }
  
  public void onPause()
  {
    synchronized ()
    {
      this.mRequestPaused = true;
      GLTextureView.access$800().notifyAll();
      for (;;)
      {
        if (!this.mExited)
        {
          boolean bool = this.mPaused;
          if (!bool) {
            try
            {
              GLTextureView.access$800().wait();
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
  
  public void onResume()
  {
    synchronized ()
    {
      this.mRequestPaused = false;
      this.mRequestRender = true;
      this.mRenderComplete = false;
      GLTextureView.access$800().notifyAll();
      for (;;)
      {
        if ((!this.mExited) && (this.mPaused))
        {
          boolean bool = this.mRenderComplete;
          if (!bool) {
            try
            {
              GLTextureView.access$800().wait();
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
  
  public void onWindowResize(int paramInt1, int paramInt2)
  {
    synchronized ()
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.mSizeChanged = true;
      this.mRequestRender = true;
      this.mRenderComplete = false;
      GLTextureView.access$800().notifyAll();
      for (;;)
      {
        if ((!this.mExited) && (!this.mPaused) && (!this.mRenderComplete))
        {
          boolean bool = ableToDraw();
          if (bool) {
            try
            {
              GLTextureView.access$800().wait();
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
  
  public void queueEvent(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException("r must not be null");
    }
    synchronized (GLTextureView.access$800())
    {
      this.mEventQueue.add(paramRunnable);
      GLTextureView.access$800().notifyAll();
      return;
    }
  }
  
  public void requestExitAndWait()
  {
    synchronized ()
    {
      this.mShouldExit = true;
      GLTextureView.access$800().notifyAll();
      for (;;)
      {
        boolean bool = this.mExited;
        if (!bool) {
          try
          {
            GLTextureView.access$800().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
  
  public void requestReleaseEglContextLocked()
  {
    this.mShouldReleaseEglContext = true;
    GLTextureView.access$800().notifyAll();
  }
  
  public void requestRender()
  {
    synchronized ()
    {
      this.mRequestRender = true;
      GLTextureView.access$800().notifyAll();
      return;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 139	java/lang/StringBuilder
    //   4: dup
    //   5: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   8: ldc_w 274
    //   11: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: invokevirtual 150	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:getId	()J
    //   18: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   21: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 277	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:setName	(Ljava/lang/String;)V
    //   27: aload_0
    //   28: invokespecial 279	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThread:guardedRun	()V
    //   31: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   34: aload_0
    //   35: invokevirtual 282	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager:threadExiting	(Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThread;)V
    //   38: return
    //   39: astore_1
    //   40: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   43: aload_0
    //   44: invokevirtual 282	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager:threadExiting	(Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThread;)V
    //   47: return
    //   48: astore_1
    //   49: invokestatic 82	com/tencent/jalpha/videoplayer/view/GLTextureView:access$800	()Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager;
    //   52: aload_0
    //   53: invokevirtual 282	com/tencent/jalpha/videoplayer/view/GLTextureView$GLThreadManager:threadExiting	(Lcom/tencent/jalpha/videoplayer/view/GLTextureView$GLThread;)V
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	GLThread
    //   39	1	1	localInterruptedException	InterruptedException
    //   48	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	31	39	java/lang/InterruptedException
    //   27	31	48	finally
  }
  
  public void setRenderMode(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      synchronized (GLTextureView.access$800())
      {
        this.mRenderMode = paramInt;
        GLTextureView.access$800().notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("renderMode");
  }
  
  public void surfaceCreated()
  {
    synchronized ()
    {
      this.mHasSurface = true;
      this.mFinishedCreatingEglSurface = false;
      GLTextureView.access$800().notifyAll();
      for (;;)
      {
        if ((this.mWaitingForSurface) && (!this.mFinishedCreatingEglSurface))
        {
          boolean bool = this.mExited;
          if (!bool) {
            try
            {
              GLTextureView.access$800().wait();
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
  
  public void surfaceDestroyed()
  {
    synchronized ()
    {
      this.mHasSurface = false;
      GLTextureView.access$800().notifyAll();
      for (;;)
      {
        if ((!this.mWaitingForSurface) && (!this.mExited))
        {
          if (!this.mLogPrinted)
          {
            this.mLogPrinted = true;
            Logger.d("GLTextureView", "mWaitingForSurface " + this.mWaitingForSurface + " mExited " + this.mExited);
          }
          try
          {
            GLTextureView.access$800().wait();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.GLTextureView.GLThread
 * JD-Core Version:    0.7.0.1
 */