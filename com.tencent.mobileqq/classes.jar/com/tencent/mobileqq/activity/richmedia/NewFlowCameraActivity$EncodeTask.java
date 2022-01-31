package com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class NewFlowCameraActivity$EncodeTask
  extends AsyncTask
{
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  NewFlowCameraActivity.VideoProcessListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  public final int b;
  String b;
  public final int c;
  String c;
  
  public NewFlowCameraActivity$EncodeTask(Activity paramActivity, Handler paramHandler, NewFlowCameraActivity.VideoProcessListener paramVideoProcessListener, String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener = paramVideoProcessListener;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  protected Integer a(java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   3: astore_1
    //   4: invokestatic 57	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   7: ifeq +448 -> 455
    //   10: ldc 59
    //   12: iconst_0
    //   13: invokestatic 65	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
    //   16: new 67	xov
    //   19: dup
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 70	xov:<init>	(Lcom/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   25: invokevirtual 76	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   28: invokestatic 57	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   31: ifeq +202 -> 233
    //   34: lconst_0
    //   35: lstore 7
    //   37: aload_1
    //   38: getfield 79	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   41: astore 10
    //   43: aload 10
    //   45: monitorenter
    //   46: aload_1
    //   47: getfield 79	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   50: invokevirtual 84	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   53: istore 9
    //   55: lload 7
    //   57: lstore 5
    //   59: iload 9
    //   61: ifne +101 -> 162
    //   64: lload 7
    //   66: lstore_3
    //   67: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +14 -> 84
    //   73: lload 7
    //   75: lstore_3
    //   76: ldc 91
    //   78: iconst_2
    //   79: ldc 93
    //   81: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: lload 7
    //   86: lstore_3
    //   87: invokestatic 102	android/os/SystemClock:elapsedRealtime	()J
    //   90: lstore 5
    //   92: lload 7
    //   94: lstore_3
    //   95: aload_1
    //   96: getfield 79	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   99: ldc2_w 103
    //   102: invokevirtual 110	java/lang/Object:wait	(J)V
    //   105: lload 7
    //   107: lstore_3
    //   108: invokestatic 102	android/os/SystemClock:elapsedRealtime	()J
    //   111: lload 5
    //   113: lsub
    //   114: lstore 7
    //   116: lload 7
    //   118: lstore 5
    //   120: lload 7
    //   122: lstore_3
    //   123: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +36 -> 162
    //   129: lload 7
    //   131: lstore_3
    //   132: ldc 91
    //   134: iconst_2
    //   135: new 112	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   142: ldc 115
    //   144: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: lload 7
    //   149: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   152: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: lload 7
    //   160: lstore 5
    //   162: aload 10
    //   164: monitorexit
    //   165: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +11 -> 179
    //   171: ldc 91
    //   173: iconst_2
    //   174: ldc 128
    //   176: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: lload 5
    //   181: ldc2_w 129
    //   184: lcmp
    //   185: ifge +48 -> 233
    //   188: bipush 30
    //   190: lload 5
    //   192: l2i
    //   193: isub
    //   194: istore_2
    //   195: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +28 -> 226
    //   201: ldc 91
    //   203: iconst_2
    //   204: new 112	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   211: ldc 132
    //   213: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload_2
    //   217: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: iload_2
    //   227: i2l
    //   228: lstore_3
    //   229: lload_3
    //   230: invokestatic 140	java/lang/Thread:sleep	(J)V
    //   233: aload_0
    //   234: getfield 30	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   237: invokevirtual 143	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   240: ifnull +343 -> 583
    //   243: aload_1
    //   244: getfield 146	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_Double	D
    //   247: d2i
    //   248: putstatic 151	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:y	I
    //   251: aload_1
    //   252: getfield 152	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_c_of_type_Int	I
    //   255: istore_2
    //   256: iload_2
    //   257: ifgt +301 -> 558
    //   260: aload_1
    //   261: getfield 155	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext	Lcom/tencent/mobileqq/shortvideo/mediadevice/PreviewContext;
    //   264: invokevirtual 161	com/tencent/mobileqq/shortvideo/mediadevice/PreviewContext:getFrameIndex	()I
    //   267: putstatic 164	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:z	I
    //   270: iconst_0
    //   271: putstatic 167	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:x	I
    //   274: iconst_0
    //   275: putstatic 170	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:E	I
    //   278: new 172	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
    //   281: dup
    //   282: aconst_null
    //   283: aload_0
    //   284: getfield 32	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   287: aload_0
    //   288: getfield 36	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   291: aconst_null
    //   292: aconst_null
    //   293: invokespecial 175	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   296: astore_1
    //   297: aload_1
    //   298: iconst_1
    //   299: invokevirtual 178	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	(Z)V
    //   302: aload_1
    //   303: iconst_1
    //   304: invokevirtual 180	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:b	(Z)V
    //   307: aload_0
    //   308: getfield 40	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_Boolean	Z
    //   311: ifeq +254 -> 565
    //   314: aload_1
    //   315: iconst_1
    //   316: invokevirtual 182	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:d	(Z)V
    //   319: aload_1
    //   320: iconst_1
    //   321: invokevirtual 185	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:e	(Z)V
    //   324: aload_1
    //   325: aload_0
    //   326: getfield 38	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_Int	I
    //   329: invokevirtual 188	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	(I)V
    //   332: aload_1
    //   333: invokevirtual 191	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
    //   336: aload_0
    //   337: aload_1
    //   338: getfield 193	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   341: putfield 194	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   344: aload_0
    //   345: getfield 194	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   348: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   351: ifne +56 -> 407
    //   354: new 202	java/io/File
    //   357: dup
    //   358: aload_0
    //   359: getfield 194	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   362: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
    //   365: astore 10
    //   367: aload 10
    //   369: invokevirtual 208	java/io/File:exists	()Z
    //   372: ifeq +35 -> 407
    //   375: new 112	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   382: aload 10
    //   384: invokevirtual 211	java/io/File:getParent	()Ljava/lang/String;
    //   387: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: getstatic 214	java/io/File:separator	Ljava/lang/String;
    //   393: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: ldc 216
    //   398: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 220	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;)V
    //   407: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +31 -> 441
    //   413: ldc 91
    //   415: iconst_2
    //   416: new 112	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   423: ldc 222
    //   425: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_0
    //   429: getfield 194	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$EncodeTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   432: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: aload_1
    //   442: getfield 223	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:jdField_a_of_type_Int	I
    //   445: ifne +133 -> 578
    //   448: iconst_0
    //   449: istore_2
    //   450: iload_2
    //   451: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: areturn
    //   455: invokestatic 234	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/RecordManager;
    //   458: invokevirtual 237	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   461: invokevirtual 242	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   464: pop
    //   465: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq -440 -> 28
    //   471: ldc 91
    //   473: iconst_2
    //   474: ldc 244
    //   476: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: goto -451 -> 28
    //   482: astore 10
    //   484: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   487: ifeq +11 -> 498
    //   490: ldc 91
    //   492: iconst_2
    //   493: ldc 246
    //   495: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload 10
    //   500: invokevirtual 249	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   503: goto -475 -> 28
    //   506: astore 11
    //   508: lload_3
    //   509: lstore 5
    //   511: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq -352 -> 162
    //   517: ldc 91
    //   519: iconst_2
    //   520: new 112	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   527: ldc 251
    //   529: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload 11
    //   534: invokevirtual 254	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   537: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: lload_3
    //   547: lstore 5
    //   549: goto -387 -> 162
    //   552: astore_1
    //   553: aload 10
    //   555: monitorexit
    //   556: aload_1
    //   557: athrow
    //   558: iload_2
    //   559: putstatic 164	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:z	I
    //   562: goto -292 -> 270
    //   565: aload_1
    //   566: iconst_0
    //   567: invokevirtual 182	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:d	(Z)V
    //   570: aload_1
    //   571: iconst_1
    //   572: invokevirtual 256	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:c	(Z)V
    //   575: goto -243 -> 332
    //   578: iconst_1
    //   579: istore_2
    //   580: goto -130 -> 450
    //   583: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   586: ifeq +12 -> 598
    //   589: ldc 91
    //   591: iconst_2
    //   592: ldc_w 258
    //   595: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: iconst_1
    //   599: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   602: areturn
    //   603: astore 10
    //   605: goto -372 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	this	EncodeTask
    //   0	608	1	paramVarArgs	java.lang.Void[]
    //   194	386	2	i	int
    //   66	481	3	l1	long
    //   57	491	5	l2	long
    //   35	124	7	l3	long
    //   53	7	9	bool	boolean
    //   41	342	10	localObject	java.lang.Object
    //   482	72	10	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   603	1	10	localInterruptedException1	java.lang.InterruptedException
    //   506	27	11	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   455	479	482	java/lang/UnsatisfiedLinkError
    //   67	73	506	java/lang/InterruptedException
    //   76	84	506	java/lang/InterruptedException
    //   87	92	506	java/lang/InterruptedException
    //   95	105	506	java/lang/InterruptedException
    //   108	116	506	java/lang/InterruptedException
    //   123	129	506	java/lang/InterruptedException
    //   132	158	506	java/lang/InterruptedException
    //   46	55	552	finally
    //   67	73	552	finally
    //   76	84	552	finally
    //   87	92	552	finally
    //   95	105	552	finally
    //   108	116	552	finally
    //   123	129	552	finally
    //   132	158	552	finally
    //   162	165	552	finally
    //   511	546	552	finally
    //   553	556	552	finally
    //   229	233	603	java/lang/InterruptedException
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "generate video result= " + paramInteger);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    switch (paramInteger.intValue())
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener.a(false, null, null, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.EncodeTask
 * JD-Core Version:    0.7.0.1
 */