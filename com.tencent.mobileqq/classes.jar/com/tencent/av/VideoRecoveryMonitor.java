package com.tencent.av;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class VideoRecoveryMonitor
{
  private long jdField_a_of_type_Long;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public VideoRecoveryMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    boolean bool;
    if (QavRecordDpc.a().m == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_Long = QavRecordDpc.a().n;
    QLog.d("VideoRecoveryMonitor", 1, String.format("VideoProcessExitMonitor mRecoveryEnable=%s mRecoveryInterval=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(this.jdField_a_of_type_Long) }));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    QLog.d("VideoRecoveryMonitor", 1, String.format("sendKeepProcessAlive keepAlive=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 19);
    localNewIntent.putExtra("keepAlive", paramBoolean);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet(localNewIntent);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramBoolean);
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private void d()
  {
    for (;;)
    {
      int j;
      try
      {
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          if (localObject1 != null)
          {
            try
            {
              localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
              SessionInfo localSessionInfo = ((VideoController)localObject1).a();
              str1 = localSessionInfo.c;
              str2 = localSessionInfo.jdField_d_of_type_JavaLangString;
              i = localSessionInfo.jdField_E_of_type_Int;
              j = localSessionInfo.jdField_d_of_type_Int;
              bool1 = localSessionInfo.C;
              bool2 = localSessionInfo.jdField_E_of_type_Boolean;
              bool3 = localSessionInfo.g;
              l = ((VideoController)localObject1).a(str1);
              if (!QLog.isColorLevel()) {
                break label316;
              }
              QLog.d("VideoRecoveryMonitor", 2, String.format("updateLastCallInfo peerUin=%s displayName=%s businessType=%s relationType=%s sessionType=%s isFriend=%s speakerOn=%s localMute=%s roomId=%s", new Object[] { str1, str2, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l) }));
            }
            catch (Throwable localThrowable)
            {
              String str1;
              String str2;
              int i;
              boolean bool1;
              boolean bool2;
              boolean bool3;
              long l;
              QLog.e("VideoRecoveryMonitor", 1, "updateLastCallInfo fail.", localThrowable);
            }
            if (i == 3) {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSharedPreferences("last_call_info_sp", 0).edit().putString("last_call_uin", str1).putString("last_call_display_name", str2).putInt("last_call_business_type", 0).putInt("last_call_relation_type", i).putBoolean("last_call_is_friend", bool1).putBoolean("last_call_speaker_on", bool2).putBoolean("last_call_local_mute", bool3).putLong("last_call_room_id", l).apply();
            }
            return;
          }
        }
        return;
      }
      finally {}
      label316:
      if (j != 1) {
        if (j != 2) {}
      }
    }
  }
  
  private void e()
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSharedPreferences("last_call_info_sp", 0).edit().putLong("last_recovery_time", System.currentTimeMillis()).apply();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryMonitor", 1, "updateLastRecoveryTime fail.", localThrowable);
    }
  }
  
  private void f()
  {
    try
    {
      QLog.d("VideoRecoveryMonitor", 1, "removeLastCallInfo");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getSharedPreferences("last_call_info_sp", 0).edit().remove("last_call_uin").remove("last_call_display_name").remove("last_call_business_type").remove("last_call_relation_type").remove("last_call_is_friend").remove("last_call_speaker_on").remove("last_call_local_mute").remove("last_call_room_id").apply();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryMonitor", 1, "removeLastCallInfo fail.", localThrowable);
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.d("VideoRecoveryMonitor", 1, String.format("channelReady mIsRecovering=%s", new Object[] { Boolean.valueOf(this.jdField_c_of_type_Boolean) }));
    if (this.jdField_c_of_type_Boolean)
    {
      VideoRecoveryReporter.a(true, System.currentTimeMillis() - this.jdField_b_of_type_Long);
      this.jdField_c_of_type_Boolean = false;
      this.d = true;
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      if (this.e)
      {
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a;
        if (localObject != null) {
          ((TraeHelper)localObject).d();
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if (localObject != null)
      {
        localObject = ((VideoAppInterface)localObject).a().a();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((SessionInfo)localObject).k, ((SessionInfo)localObject).c, ((SessionInfo)localObject).e);
      }
    }
    a(true);
    d();
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.d("VideoRecoveryMonitor", 1, String.format("videoClose reason=%s", new Object[] { Integer.valueOf(paramInt) }));
    this.jdField_c_of_type_Boolean = false;
    if (this.d)
    {
      this.d = false;
      VideoRecoveryReporter.a(paramInt, System.currentTimeMillis() - this.jdField_c_of_type_Long);
    }
    a(false);
    f();
  }
  
  /* Error */
  public void a(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/av/VideoRecoveryMonitor:jdField_a_of_type_Boolean	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 19	com/tencent/av/VideoRecoveryMonitor:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   12: invokevirtual 148	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: ldc 150
    //   17: iconst_0
    //   18: invokevirtual 156	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   21: astore 15
    //   23: invokestatic 212	java/lang/System:currentTimeMillis	()J
    //   26: aload 15
    //   28: ldc 206
    //   30: lconst_0
    //   31: invokeinterface 267 4 0
    //   36: lsub
    //   37: lstore 6
    //   39: invokestatic 212	java/lang/System:currentTimeMillis	()J
    //   42: lload_2
    //   43: lsub
    //   44: lstore_2
    //   45: aload 15
    //   47: ldc 164
    //   49: aconst_null
    //   50: invokeinterface 271 3 0
    //   55: astore 16
    //   57: aload 15
    //   59: ldc 172
    //   61: aconst_null
    //   62: invokeinterface 271 3 0
    //   67: astore 17
    //   69: aload 15
    //   71: ldc 174
    //   73: iconst_m1
    //   74: invokeinterface 275 3 0
    //   79: istore 4
    //   81: aload 15
    //   83: ldc 180
    //   85: iconst_m1
    //   86: invokeinterface 275 3 0
    //   91: istore 5
    //   93: aload 15
    //   95: ldc 182
    //   97: iconst_0
    //   98: invokeinterface 279 3 0
    //   103: istore 12
    //   105: aload 15
    //   107: ldc 188
    //   109: iconst_0
    //   110: invokeinterface 279 3 0
    //   115: istore 13
    //   117: aload 15
    //   119: ldc 190
    //   121: iconst_0
    //   122: invokeinterface 279 3 0
    //   127: istore 14
    //   129: aload 15
    //   131: ldc 192
    //   133: ldc2_w 280
    //   136: invokeinterface 267 4 0
    //   141: lstore 8
    //   143: invokestatic 285	com/tencent/av/utils/AudioHelper:b	()J
    //   146: lstore 10
    //   148: new 287	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   155: astore 15
    //   157: aload 15
    //   159: ldc_w 290
    //   162: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 15
    //   168: iload_1
    //   169: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 15
    //   175: ldc_w 299
    //   178: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 15
    //   184: lload 6
    //   186: invokevirtual 302	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 15
    //   192: ldc_w 304
    //   195: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 15
    //   201: lload_2
    //   202: invokevirtual 302	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 15
    //   208: ldc_w 306
    //   211: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 15
    //   217: aload 16
    //   219: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 15
    //   225: ldc_w 308
    //   228: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 15
    //   234: aload 17
    //   236: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 15
    //   242: ldc_w 310
    //   245: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 15
    //   251: iload 4
    //   253: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 15
    //   259: ldc_w 312
    //   262: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 15
    //   268: iload 5
    //   270: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 15
    //   276: ldc_w 314
    //   279: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 15
    //   285: iload 12
    //   287: invokevirtual 317	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 15
    //   293: ldc_w 319
    //   296: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 15
    //   302: iload 13
    //   304: invokevirtual 317	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 15
    //   310: ldc_w 321
    //   313: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 15
    //   319: iload 14
    //   321: invokevirtual 317	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 15
    //   327: ldc_w 323
    //   330: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 15
    //   336: lload 8
    //   338: invokevirtual 302	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload 15
    //   344: ldc_w 325
    //   347: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 15
    //   353: lload 10
    //   355: invokevirtual 302	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 15
    //   361: ldc_w 327
    //   364: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 15
    //   370: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: astore 15
    //   375: ldc 37
    //   377: astore 18
    //   379: aload 18
    //   381: iconst_1
    //   382: aload 15
    //   384: invokestatic 334	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: lload 6
    //   389: ldc2_w 335
    //   392: lcmp
    //   393: ifle +321 -> 714
    //   396: aload_0
    //   397: astore 15
    //   399: lload_2
    //   400: aload 15
    //   402: getfield 35	com/tencent/av/VideoRecoveryMonitor:jdField_a_of_type_Long	J
    //   405: lcmp
    //   406: ifgt +260 -> 666
    //   409: aload 16
    //   411: invokestatic 342	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   414: ifne +252 -> 666
    //   417: iload 4
    //   419: iconst_m1
    //   420: if_icmpeq +246 -> 666
    //   423: iload 5
    //   425: iconst_m1
    //   426: if_icmpeq +240 -> 666
    //   429: lload 8
    //   431: ldc2_w 280
    //   434: lcmp
    //   435: ifeq +231 -> 666
    //   438: iload 5
    //   440: aload 16
    //   442: iconst_0
    //   443: newarray int
    //   445: invokestatic 347	com/tencent/av/SessionMgr:a	(ILjava/lang/String;[I)Ljava/lang/String;
    //   448: astore 18
    //   450: invokestatic 350	com/tencent/av/SessionMgr:a	()Lcom/tencent/av/SessionMgr;
    //   453: aload 18
    //   455: iconst_0
    //   456: invokevirtual 353	com/tencent/av/SessionMgr:a	(Ljava/lang/String;Z)Lcom/tencent/av/app/SessionInfo;
    //   459: astore 18
    //   461: aload 18
    //   463: iconst_0
    //   464: putfield 249	com/tencent/av/app/SessionInfo:k	I
    //   467: aload 18
    //   469: aload 16
    //   471: putfield 115	com/tencent/av/app/SessionInfo:c	Ljava/lang/String;
    //   474: aload 18
    //   476: aload 17
    //   478: putfield 117	com/tencent/av/app/SessionInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   481: aload 18
    //   483: iload 5
    //   485: putfield 120	com/tencent/av/app/SessionInfo:jdField_E_of_type_Int	I
    //   488: aload 18
    //   490: iconst_1
    //   491: putfield 356	com/tencent/av/app/SessionInfo:Y	Z
    //   494: aload 18
    //   496: lload 8
    //   498: putfield 359	com/tencent/av/app/SessionInfo:h	J
    //   501: aload 18
    //   503: lload 10
    //   505: ldc_w 361
    //   508: iconst_1
    //   509: invokevirtual 364	com/tencent/av/app/SessionInfo:a	(JLjava/lang/String;I)V
    //   512: aload 18
    //   514: iconst_1
    //   515: putfield 367	com/tencent/av/app/SessionInfo:H	Z
    //   518: aload 18
    //   520: iload 12
    //   522: putfield 125	com/tencent/av/app/SessionInfo:C	Z
    //   525: aload 18
    //   527: iload 14
    //   529: putfield 130	com/tencent/av/app/SessionInfo:g	Z
    //   532: aload 15
    //   534: getfield 19	com/tencent/av/VideoRecoveryMonitor:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   537: invokevirtual 105	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   540: astore 17
    //   542: aload 17
    //   544: lload 10
    //   546: aload 16
    //   548: iload 4
    //   550: iload 5
    //   552: aconst_null
    //   553: aconst_null
    //   554: aconst_null
    //   555: iconst_0
    //   556: aconst_null
    //   557: aconst_null
    //   558: aconst_null
    //   559: aconst_null
    //   560: aconst_null
    //   561: iconst_0
    //   562: iconst_0
    //   563: aconst_null
    //   564: aconst_null
    //   565: invokevirtual 370	com/tencent/av/VideoController:a	(JLjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)I
    //   568: pop
    //   569: aload_0
    //   570: invokespecial 263	com/tencent/av/VideoRecoveryMonitor:f	()V
    //   573: aload_0
    //   574: invokespecial 372	com/tencent/av/VideoRecoveryMonitor:e	()V
    //   577: invokestatic 376	com/tencent/av/smallscreen/SmallScreenUtils:f	()Z
    //   580: ifeq +30 -> 610
    //   583: lload 10
    //   585: iconst_1
    //   586: aload 15
    //   588: getfield 19	com/tencent/av/VideoRecoveryMonitor:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   591: invokevirtual 148	com/tencent/av/app/VideoAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   594: iconst_0
    //   595: aload 15
    //   597: getfield 19	com/tencent/av/VideoRecoveryMonitor:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   600: invokevirtual 379	com/tencent/av/app/VideoAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   603: iconst_0
    //   604: invokestatic 382	com/tencent/av/smallscreen/SmallScreenUtils:a	(JILandroid/content/Context;ZLjava/lang/String;Z)V
    //   607: goto +14 -> 621
    //   610: lconst_0
    //   611: aload 15
    //   613: getfield 19	com/tencent/av/VideoRecoveryMonitor:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   616: iconst_2
    //   617: invokestatic 385	com/tencent/av/smallscreen/SmallScreenUtils:a	(JLcom/tencent/common/app/business/BaseVideoAppInterface;I)Z
    //   620: pop
    //   621: aload 17
    //   623: getfield 243	com/tencent/av/VideoController:a	Lcom/tencent/av/utils/TraeHelper;
    //   626: astore 16
    //   628: aload 16
    //   630: ifnull +12 -> 642
    //   633: aload 16
    //   635: ldc_w 387
    //   638: invokevirtual 390	com/tencent/av/utils/TraeHelper:a	(Ljava/lang/String;)I
    //   641: pop
    //   642: aload 15
    //   644: iconst_1
    //   645: putfield 227	com/tencent/av/VideoRecoveryMonitor:jdField_c_of_type_Boolean	Z
    //   648: aload 15
    //   650: invokestatic 212	java/lang/System:currentTimeMillis	()J
    //   653: putfield 229	com/tencent/av/VideoRecoveryMonitor:jdField_b_of_type_Long	J
    //   656: aload 15
    //   658: iload 13
    //   660: putfield 240	com/tencent/av/VideoRecoveryMonitor:e	Z
    //   663: goto +12 -> 675
    //   666: aload 18
    //   668: iconst_1
    //   669: ldc_w 392
    //   672: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   675: iload_1
    //   676: lload_2
    //   677: aload_0
    //   678: getfield 227	com/tencent/av/VideoRecoveryMonitor:jdField_c_of_type_Boolean	Z
    //   681: invokestatic 395	com/tencent/av/VideoRecoveryReporter:a	(IJZ)V
    //   684: return
    //   685: astore 15
    //   687: goto +10 -> 697
    //   690: astore 15
    //   692: goto +5 -> 697
    //   695: astore 15
    //   697: ldc 37
    //   699: iconst_1
    //   700: ldc_w 397
    //   703: aload 15
    //   705: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   708: return
    //   709: astore 15
    //   711: goto -14 -> 697
    //   714: goto -48 -> 666
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	VideoRecoveryMonitor
    //   0	717	1	paramInt	int
    //   0	717	2	paramLong	long
    //   79	470	4	i	int
    //   91	460	5	j	int
    //   37	351	6	l1	long
    //   141	356	8	l2	long
    //   146	438	10	l3	long
    //   103	418	12	bool1	boolean
    //   115	544	13	bool2	boolean
    //   127	401	14	bool3	boolean
    //   21	636	15	localObject1	Object
    //   685	1	15	localThrowable1	Throwable
    //   690	1	15	localThrowable2	Throwable
    //   695	9	15	localThrowable3	Throwable
    //   709	1	15	localThrowable4	Throwable
    //   55	579	16	localObject2	Object
    //   67	555	17	localObject3	Object
    //   377	290	18	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   379	387	685	java/lang/Throwable
    //   129	375	690	java/lang/Throwable
    //   8	129	695	java/lang/Throwable
    //   399	417	709	java/lang/Throwable
    //   438	607	709	java/lang/Throwable
    //   610	621	709	java/lang/Throwable
    //   621	628	709	java/lang/Throwable
    //   633	642	709	java/lang/Throwable
    //   642	663	709	java/lang/Throwable
    //   666	675	709	java/lang/Throwable
    //   675	684	709	java/lang/Throwable
  }
  
  public void b()
  {
    ThreadManagerV2.executeOnSubThread(new VideoRecoveryMonitor.1(this));
  }
  
  public void c()
  {
    ThreadManagerV2.executeOnSubThread(new VideoRecoveryMonitor.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoRecoveryMonitor
 * JD-Core Version:    0.7.0.1
 */