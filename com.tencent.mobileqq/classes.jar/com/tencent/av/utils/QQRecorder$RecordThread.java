package com.tencent.av.utils;

import android.media.AudioRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class QQRecorder$RecordThread
  extends Thread
{
  public volatile boolean a;
  
  private FileOutputStream a()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null) {
      this.this$0.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.a(this.this$0.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(this.this$0.jdField_a_of_type_JavaLangString);
    if (localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "RecordThread-->RUN-->File is Exists");
      }
      localFile.delete();
    }
    try
    {
      localFile.createNewFile();
      if (this.this$0.jdField_a_of_type_AndroidMediaAudioRecord != null)
      {
        this.this$0.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
        if (this.this$0.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null) {
          this.this$0.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.a();
        }
        return new FileOutputStream(localFile);
      }
      if (this.this$0.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null) {
        this.this$0.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.a(this.this$0.jdField_a_of_type_JavaLangString, 4);
      }
      return null;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("RecordThread-->Create New File Failed. Exception = ");
        localStringBuilder.append(localIOException.getMessage());
        QLog.e("QQRecorder", 2, localStringBuilder.toString());
      }
      if (this.this$0.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null) {
        this.this$0.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.a(this.this$0.jdField_a_of_type_JavaLangString, 2);
      }
    }
    return null;
  }
  
  private void a(FileOutputStream paramFileOutputStream)
  {
    byte[] arrayOfByte = new byte[QQRecorder.a(this.this$0)];
    long l2 = System.currentTimeMillis();
    long l1 = 0L;
    int k = 0;
    int i = 0;
    Object localObject1 = null;
    if (this.a)
    {
      int j = k;
      Object localObject2;
      if (System.currentTimeMillis() - l2 > 1000L)
      {
        j = k;
        if (k == 0)
        {
          if ((l1 == 0L) || (i == 0))
          {
            if (this.this$0.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null)
            {
              localObject2 = this.this$0.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener;
              if (l1 == 0L) {
                j = 0;
              } else {
                j = 1;
              }
              ((QQRecorder.OnQQRecorderListener)localObject2).a(j);
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("record abnormal: data size = ");
              ((StringBuilder)localObject2).append(l1);
              ((StringBuilder)localObject2).append(", max volume = ");
              ((StringBuilder)localObject2).append(i);
              QLog.d("QQRecorder", 2, ((StringBuilder)localObject2).toString());
            }
          }
          j = 1;
        }
      }
      if (localObject1 != null)
      {
        k = localObject1.length;
        System.arraycopy(localObject1, 0, arrayOfByte, 0, k);
      }
      else
      {
        k = 0;
      }
      int m = this.this$0.jdField_a_of_type_AndroidMediaAudioRecord.read(arrayOfByte, k, QQRecorder.a(this.this$0) - k);
      if (QQRecorder.a(this.this$0) - k != m)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" Recording --> Request Size = ");
        ((StringBuilder)localObject2).append(QQRecorder.a(this.this$0) - k);
        ((StringBuilder)localObject2).append(" ,Really Size = ");
        ((StringBuilder)localObject2).append(m);
        QLog.d("QQRecorder", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.this$0.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null) {
        this.this$0.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.b();
      }
      if (m <= 0) {
        Thread.sleep(10L);
      }
      for (;;)
      {
        k = j;
        break;
        l1 += m;
        k = m + k;
        m = k % 160;
        if (m != 0)
        {
          localObject1 = new byte[m];
          k -= m;
          System.arraycopy(arrayOfByte, k, localObject1, 0, m);
        }
        else
        {
          localObject1 = null;
        }
        i = Math.max(i, (int)AudioHelper.a(this.this$0.jdField_a_of_type_AndroidContentContext, arrayOfByte, k, 1.0F));
        paramFileOutputStream.write(arrayOfByte, 0, k);
      }
    }
    paramFileOutputStream.flush();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: new 75	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   13: astore_1
    //   14: aload_1
    //   15: ldc 168
    //   17: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_1
    //   22: aload_0
    //   23: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 42
    //   29: iconst_2
    //   30: aload_1
    //   31: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: invokespecial 173	com/tencent/av/utils/QQRecorder$RecordThread:a	()Ljava/io/FileOutputStream;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnonnull +90 -> 133
    //   46: aload_0
    //   47: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   50: getfield 57	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   53: ifnull +13 -> 66
    //   56: aload_0
    //   57: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   60: getfield 57	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   63: invokevirtual 176	android/media/AudioRecord:release	()V
    //   66: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +34 -> 103
    //   72: new 75	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   79: astore_2
    //   80: aload_2
    //   81: ldc 178
    //   83: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_2
    //   88: aload_0
    //   89: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 42
    //   95: iconst_2
    //   96: aload_2
    //   97: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_0
    //   104: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   107: astore_2
    //   108: aload_2
    //   109: aconst_null
    //   110: putfield 181	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$RecordThread	Lcom/tencent/av/utils/QQRecorder$RecordThread;
    //   113: aload_2
    //   114: aconst_null
    //   115: putfield 21	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   118: aload_1
    //   119: ifnull +13 -> 132
    //   122: aload_1
    //   123: invokevirtual 184	java/io/FileOutputStream:close	()V
    //   126: return
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   132: return
    //   133: aload_1
    //   134: astore_2
    //   135: aload_0
    //   136: aload_1
    //   137: invokespecial 189	com/tencent/av/utils/QQRecorder$RecordThread:a	(Ljava/io/FileOutputStream;)V
    //   140: aload_1
    //   141: astore_2
    //   142: aload_0
    //   143: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   146: getfield 18	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener	Lcom/tencent/av/utils/QQRecorder$OnQQRecorderListener;
    //   149: ifnull +17 -> 166
    //   152: aload_1
    //   153: astore_2
    //   154: aload_0
    //   155: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   158: getfield 18	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener	Lcom/tencent/av/utils/QQRecorder$OnQQRecorderListener;
    //   161: invokeinterface 192 1 0
    //   166: aload_1
    //   167: astore_2
    //   168: aload_0
    //   169: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   172: getfield 195	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   175: ifnull +29 -> 204
    //   178: aload_1
    //   179: astore_2
    //   180: aload_0
    //   181: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   184: getfield 198	com/tencent/av/utils/QQRecorder:jdField_a_of_type_Int	I
    //   187: iconst_m1
    //   188: if_icmpeq +16 -> 204
    //   191: aload_1
    //   192: astore_2
    //   193: aload_0
    //   194: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   197: getfield 195	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   200: iconst_0
    //   201: invokevirtual 203	android/media/AudioManager:setMode	(I)V
    //   204: aload_0
    //   205: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   208: getfield 57	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   211: ifnull +13 -> 224
    //   214: aload_0
    //   215: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   218: getfield 57	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   221: invokevirtual 176	android/media/AudioRecord:release	()V
    //   224: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +34 -> 261
    //   230: new 75	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   237: astore_2
    //   238: aload_2
    //   239: ldc 178
    //   241: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_2
    //   246: aload_0
    //   247: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: ldc 42
    //   253: iconst_2
    //   254: aload_2
    //   255: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_0
    //   262: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   265: astore_2
    //   266: aload_2
    //   267: aconst_null
    //   268: putfield 181	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$RecordThread	Lcom/tencent/av/utils/QQRecorder$RecordThread;
    //   271: aload_2
    //   272: aconst_null
    //   273: putfield 21	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   276: aload_1
    //   277: ifnull +199 -> 476
    //   280: aload_1
    //   281: invokevirtual 184	java/io/FileOutputStream:close	()V
    //   284: return
    //   285: astore_3
    //   286: goto +12 -> 298
    //   289: astore_1
    //   290: aconst_null
    //   291: astore_2
    //   292: goto +186 -> 478
    //   295: astore_3
    //   296: aconst_null
    //   297: astore_1
    //   298: aload_1
    //   299: astore_2
    //   300: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq +50 -> 353
    //   306: aload_1
    //   307: astore_2
    //   308: new 75	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   315: astore 4
    //   317: aload_1
    //   318: astore_2
    //   319: aload 4
    //   321: ldc 205
    //   323: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload_1
    //   328: astore_2
    //   329: aload 4
    //   331: aload_3
    //   332: invokestatic 211	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   335: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload_1
    //   340: astore_2
    //   341: ldc 42
    //   343: iconst_2
    //   344: aload 4
    //   346: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: aload_3
    //   350: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   353: aload_1
    //   354: astore_2
    //   355: aload_0
    //   356: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   359: getfield 18	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener	Lcom/tencent/av/utils/QQRecorder$OnQQRecorderListener;
    //   362: ifnull +28 -> 390
    //   365: aload_1
    //   366: astore_2
    //   367: aload_0
    //   368: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   371: getfield 18	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener	Lcom/tencent/av/utils/QQRecorder$OnQQRecorderListener;
    //   374: aload_0
    //   375: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   378: getfield 21	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   381: aload_3
    //   382: invokevirtual 215	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   385: invokeinterface 218 3 0
    //   390: aload_0
    //   391: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   394: getfield 57	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   397: ifnull +13 -> 410
    //   400: aload_0
    //   401: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   404: getfield 57	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   407: invokevirtual 176	android/media/AudioRecord:release	()V
    //   410: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   413: ifeq +34 -> 447
    //   416: new 75	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   423: astore_2
    //   424: aload_2
    //   425: ldc 178
    //   427: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_2
    //   432: aload_0
    //   433: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: ldc 42
    //   439: iconst_2
    //   440: aload_2
    //   441: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload_0
    //   448: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   451: astore_2
    //   452: aload_2
    //   453: aconst_null
    //   454: putfield 181	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$RecordThread	Lcom/tencent/av/utils/QQRecorder$RecordThread;
    //   457: aload_2
    //   458: aconst_null
    //   459: putfield 21	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   462: aload_1
    //   463: ifnull +13 -> 476
    //   466: aload_1
    //   467: invokevirtual 184	java/io/FileOutputStream:close	()V
    //   470: return
    //   471: astore_1
    //   472: aload_1
    //   473: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   476: return
    //   477: astore_1
    //   478: aload_0
    //   479: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   482: getfield 57	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   485: ifnull +13 -> 498
    //   488: aload_0
    //   489: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   492: getfield 57	com/tencent/av/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   495: invokevirtual 176	android/media/AudioRecord:release	()V
    //   498: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +34 -> 535
    //   504: new 75	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   511: astore_3
    //   512: aload_3
    //   513: ldc 178
    //   515: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_3
    //   520: aload_0
    //   521: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: ldc 42
    //   527: iconst_2
    //   528: aload_3
    //   529: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: aload_0
    //   536: getfield 13	com/tencent/av/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/av/utils/QQRecorder;
    //   539: astore_3
    //   540: aload_3
    //   541: aconst_null
    //   542: putfield 181	com/tencent/av/utils/QQRecorder:jdField_a_of_type_ComTencentAvUtilsQQRecorder$RecordThread	Lcom/tencent/av/utils/QQRecorder$RecordThread;
    //   545: aload_3
    //   546: aconst_null
    //   547: putfield 21	com/tencent/av/utils/QQRecorder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   550: aload_2
    //   551: ifnull +15 -> 566
    //   554: aload_2
    //   555: invokevirtual 184	java/io/FileOutputStream:close	()V
    //   558: goto +8 -> 566
    //   561: astore_2
    //   562: aload_2
    //   563: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   566: aload_1
    //   567: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	this	RecordThread
    //   13	110	1	localObject1	Object
    //   127	154	1	localIOException1	IOException
    //   289	1	1	localObject2	Object
    //   297	170	1	localObject3	Object
    //   471	2	1	localIOException2	IOException
    //   477	90	1	localObject4	Object
    //   79	476	2	localObject5	Object
    //   561	2	2	localIOException3	IOException
    //   285	1	3	localThrowable1	java.lang.Throwable
    //   295	87	3	localThrowable2	java.lang.Throwable
    //   511	35	3	localObject6	Object
    //   315	30	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   122	126	127	java/io/IOException
    //   135	140	285	java/lang/Throwable
    //   142	152	285	java/lang/Throwable
    //   154	166	285	java/lang/Throwable
    //   168	178	285	java/lang/Throwable
    //   180	191	285	java/lang/Throwable
    //   193	204	285	java/lang/Throwable
    //   37	42	289	finally
    //   37	42	295	java/lang/Throwable
    //   280	284	471	java/io/IOException
    //   466	470	471	java/io/IOException
    //   135	140	477	finally
    //   142	152	477	finally
    //   154	166	477	finally
    //   168	178	477	finally
    //   180	191	477	finally
    //   193	204	477	finally
    //   300	306	477	finally
    //   308	317	477	finally
    //   319	327	477	finally
    //   329	339	477	finally
    //   341	353	477	finally
    //   355	365	477	finally
    //   367	390	477	finally
    //   554	558	561	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QQRecorder.RecordThread
 * JD-Core Version:    0.7.0.1
 */