package com.tencent.mobileqq.activity.aio;

import afpo;
import afpr;
import afps;
import afpt;
import afpx;
import afrm;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import bahv;
import bhck;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class CommonAudioPlayer
  extends AudioPlayerBase
  implements afpr
{
  private afpo jdField_a_of_type_Afpo;
  private afps jdField_a_of_type_Afps;
  private afrm jdField_a_of_type_Afrm;
  private String b;
  volatile boolean e = false;
  
  public CommonAudioPlayer(Context paramContext, afpx paramafpx)
  {
    super(paramContext, paramafpx);
  }
  
  private void a(afpt paramafpt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramafpt == null) {}
    Object localObject;
    do
    {
      return;
      localObject = "CommonAudioPlayer.notifyUIDeviceStatusChanged getDeviceStatusType = " + paramafpt.a();
      this.jdField_a_of_type_Afps.a((String)localObject);
      switch (paramafpt.a())
      {
      default: 
        return;
      }
    } while (this.jdField_a_of_type_Afrm == null);
    bool1 = this.jdField_a_of_type_Afps.a();
    boolean bool3 = this.jdField_a_of_type_Afps.d();
    if (bool3) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_Afrm.onNearToEar(bool3, bool1);
      return;
      if (this.jdField_a_of_type_Afrm == null) {
        break;
      }
      localObject = this.jdField_a_of_type_Afrm;
      bool2 = this.jdField_a_of_type_Afps.b();
      bool3 = this.jdField_a_of_type_Afps.c();
      boolean bool4 = this.jdField_a_of_type_Afps.a();
      if (paramafpt.a() == 2) {
        bool1 = true;
      }
      ((afrm)localObject).onHeadsetChanged(bool2, bool3, bool4, bool1);
      return;
    }
  }
  
  private void m()
  {
    String str = this.b;
    if (StringUtil.isEmpty(str)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(this.jdField_a_of_type_AndroidAppApplication.getPackageName());
    localIntent.setAction("mqq.audiosenormanager.audio.start");
    localIntent.putExtra("audiosenormanager.playkey", str);
    this.jdField_a_of_type_AndroidAppApplication.getApplicationContext().sendBroadcast(localIntent);
  }
  
  private void n()
  {
    String str = this.b;
    if (StringUtil.isEmpty(str)) {
      return;
    }
    this.b = null;
    Intent localIntent = new Intent();
    localIntent.setPackage(this.jdField_a_of_type_AndroidAppApplication.getPackageName());
    localIntent.setAction("mqq.audiosenormanager.audio.end");
    localIntent.putExtra("audiosenormanager.playkey", str);
    this.jdField_a_of_type_AndroidAppApplication.getApplicationContext().sendBroadcast(localIntent);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Afps.a();
  }
  
  protected bhck a()
  {
    return this.jdField_a_of_type_Afps.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Afpo.a();
    super.a();
    this.e = false;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Afps.a(paramInt, paramBoolean);
      afpt localafpt = this.jdField_a_of_type_Afps.a();
      if (localafpt != null)
      {
        boolean bool = a();
        if (QLog.isColorLevel()) {
          QLog.d("AudioPlayer_Common", 2, "before notifyUIDeviceStatusChanged status = " + localafpt.a + " | isPlaying = " + bool);
        }
        if (bool)
        {
          if (localafpt.a())
          {
            localafpt.a();
            c(this.jdField_a_of_type_Bahv.a() - MediaPlayerManager.a);
          }
          a(localafpt);
        }
      }
      switch (paramInt)
      {
      }
      break;
    }
    do
    {
      do
      {
        return;
        a(paramBoolean, false);
        break;
        a(paramBoolean, true);
        break;
      } while (paramBoolean);
      j();
      return;
    } while (!paramBoolean);
    j();
  }
  
  public void a(afrm paramafrm)
  {
    this.jdField_a_of_type_Afrm = paramafrm;
  }
  
  public void a(bahv parambahv, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Afpo.a();
    super.a(parambahv, paramInt1, paramInt2);
    this.e = false;
  }
  
  public boolean a()
  {
    return (super.a()) || (this.e);
  }
  
  /* Error */
  protected boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore 7
    //   5: iload_2
    //   6: istore 6
    //   8: iload_2
    //   9: ifge +6 -> 15
    //   12: iconst_0
    //   13: istore 6
    //   15: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   18: lstore 8
    //   20: aload_0
    //   21: aload_1
    //   22: putfield 199	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   25: aload_0
    //   26: invokestatic 205	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   29: pop
    //   30: aload_0
    //   31: getfield 47	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Afps	Lafps;
    //   34: invokevirtual 207	afps:b	()V
    //   37: aload_0
    //   38: getfield 129	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Afpo	Lafpo;
    //   41: aload_1
    //   42: iload 6
    //   44: invokevirtual 210	afpo:a	(Ljava/lang/String;I)I
    //   47: istore_2
    //   48: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +28 -> 79
    //   54: ldc 149
    //   56: iconst_2
    //   57: new 24	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   64: ldc 212
    //   66: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: iload_2
    //   70: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: iload_2
    //   80: ifne +10 -> 90
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 20	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:e	Z
    //   88: iconst_0
    //   89: ireturn
    //   90: iload_2
    //   91: iconst_2
    //   92: if_icmpne +10 -> 102
    //   95: aload_0
    //   96: iconst_0
    //   97: putfield 20	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:e	Z
    //   100: iconst_1
    //   101: ireturn
    //   102: aload_0
    //   103: getfield 215	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   106: invokestatic 220	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Landroid/media/AudioManager;)Z
    //   109: ifeq +68 -> 177
    //   112: aload_0
    //   113: getfield 129	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Afpo	Lafpo;
    //   116: aload_1
    //   117: iload 6
    //   119: invokevirtual 222	afpo:b	(Ljava/lang/String;I)I
    //   122: istore_2
    //   123: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +28 -> 154
    //   129: ldc 149
    //   131: iconst_2
    //   132: new 24	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   139: ldc 224
    //   141: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: iload_2
    //   145: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: iload_2
    //   155: ifne +10 -> 165
    //   158: aload_0
    //   159: iconst_0
    //   160: putfield 20	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:e	Z
    //   163: iconst_0
    //   164: ireturn
    //   165: iload_2
    //   166: iconst_2
    //   167: if_icmpne +10 -> 177
    //   170: aload_0
    //   171: iconst_0
    //   172: putfield 20	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:e	Z
    //   175: iconst_1
    //   176: ireturn
    //   177: aload_1
    //   178: invokestatic 229	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   181: ifne +90 -> 271
    //   184: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +28 -> 215
    //   190: ldc 149
    //   192: iconst_2
    //   193: new 24	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   200: ldc 231
    //   202: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_0
    //   216: invokevirtual 233	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:c	()V
    //   219: aload_0
    //   220: getfield 236	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Afpx	Lafpx;
    //   223: ifnull -135 -> 88
    //   226: aload_0
    //   227: getfield 236	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Afpx	Lafpx;
    //   230: aload_0
    //   231: iconst_m1
    //   232: invokeinterface 241 3 0
    //   237: iconst_0
    //   238: iconst_1
    //   239: iconst_1
    //   240: ldc 243
    //   242: invokestatic 246	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(IIILjava/lang/String;)V
    //   245: aload_0
    //   246: getfield 249	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Long	J
    //   249: lconst_0
    //   250: lcmp
    //   251: ifle -163 -> 88
    //   254: invokestatic 254	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   257: aload_0
    //   258: getfield 249	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Long	J
    //   261: lsub
    //   262: l2f
    //   263: ldc 255
    //   265: fdiv
    //   266: invokestatic 258	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(F)V
    //   269: iconst_0
    //   270: ireturn
    //   271: aload_0
    //   272: new 24	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   279: aload_1
    //   280: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: lload 8
    //   285: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   288: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: putfield 78	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:b	Ljava/lang/String;
    //   294: aload_0
    //   295: invokevirtual 264	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:g	()V
    //   298: new 266	java/io/FileInputStream
    //   301: dup
    //   302: aload_1
    //   303: invokespecial 268	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   306: astore 11
    //   308: aload 11
    //   310: astore 10
    //   312: aload 11
    //   314: invokestatic 273	bhhd:a	(Ljava/io/InputStream;)B
    //   317: istore 4
    //   319: aload 11
    //   321: astore 10
    //   323: iload 4
    //   325: istore_3
    //   326: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +47 -> 376
    //   332: aload 11
    //   334: astore 10
    //   336: iload 4
    //   338: istore_3
    //   339: ldc 149
    //   341: iconst_2
    //   342: new 24	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 275
    //   352: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_1
    //   356: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 277
    //   362: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload 4
    //   367: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: iload 4
    //   378: istore 5
    //   380: aload 11
    //   382: ifnull +12 -> 394
    //   385: aload 11
    //   387: invokevirtual 282	java/io/InputStream:close	()V
    //   390: iload 4
    //   392: istore 5
    //   394: iload 5
    //   396: iflt +272 -> 668
    //   399: aload_0
    //   400: new 284	com/tencent/mobileqq/ptt/player/SilkPlayer
    //   403: dup
    //   404: invokespecial 285	com/tencent/mobileqq/ptt/player/SilkPlayer:<init>	()V
    //   407: putfield 167	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Bahv	Lbahv;
    //   410: iconst_1
    //   411: istore_2
    //   412: iload_2
    //   413: invokestatic 289	bhfx:a	(I)V
    //   416: aload_0
    //   417: getfield 167	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Bahv	Lbahv;
    //   420: aload_1
    //   421: invokeinterface 290 2 0
    //   426: aload_0
    //   427: getfield 167	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Bahv	Lbahv;
    //   430: iload 6
    //   432: invokeinterface 292 2 0
    //   437: aload_0
    //   438: getfield 167	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Bahv	Lbahv;
    //   441: iconst_m1
    //   442: iload 5
    //   444: invokeinterface 295 3 0
    //   449: aload_0
    //   450: getfield 167	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Bahv	Lbahv;
    //   453: aload_0
    //   454: invokeinterface 298 2 0
    //   459: aload_0
    //   460: getfield 167	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Bahv	Lbahv;
    //   463: aload_0
    //   464: getfield 301	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Float	F
    //   467: invokeinterface 302 2 0
    //   472: aload_0
    //   473: getfield 167	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Bahv	Lbahv;
    //   476: invokeinterface 303 1 0
    //   481: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +34 -> 518
    //   487: ldc 149
    //   489: iconst_2
    //   490: new 24	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   497: ldc_w 305
    //   500: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   506: lload 8
    //   508: lsub
    //   509: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   512: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: aload_0
    //   519: invokespecial 307	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:m	()V
    //   522: iconst_1
    //   523: ireturn
    //   524: astore 12
    //   526: aconst_null
    //   527: astore 11
    //   529: aload 11
    //   531: astore 10
    //   533: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq +37 -> 573
    //   539: aload 11
    //   541: astore 10
    //   543: ldc 149
    //   545: iconst_2
    //   546: new 24	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   553: ldc_w 309
    //   556: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: aload 12
    //   561: invokevirtual 312	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   564: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: iload_3
    //   574: istore 5
    //   576: aload 11
    //   578: ifnull -184 -> 394
    //   581: aload 11
    //   583: invokevirtual 282	java/io/InputStream:close	()V
    //   586: iload_3
    //   587: istore 5
    //   589: goto -195 -> 394
    //   592: astore 10
    //   594: iload_3
    //   595: istore 5
    //   597: goto -203 -> 394
    //   600: astore_1
    //   601: aconst_null
    //   602: astore 10
    //   604: aload 10
    //   606: ifnull +8 -> 614
    //   609: aload 10
    //   611: invokevirtual 282	java/io/InputStream:close	()V
    //   614: aload_1
    //   615: athrow
    //   616: astore_1
    //   617: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   620: ifeq +13 -> 633
    //   623: ldc 149
    //   625: iconst_2
    //   626: ldc_w 314
    //   629: aload_1
    //   630: invokestatic 317	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   633: aload_0
    //   634: getfield 167	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Bahv	Lbahv;
    //   637: instanceof 284
    //   640: ifeq +77 -> 717
    //   643: iload 7
    //   645: istore_2
    //   646: iconst_0
    //   647: iload_2
    //   648: iconst_2
    //   649: aload_1
    //   650: invokevirtual 318	java/lang/Exception:toString	()Ljava/lang/String;
    //   653: invokestatic 246	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(IIILjava/lang/String;)V
    //   656: aload_0
    //   657: aload_0
    //   658: getfield 167	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Bahv	Lbahv;
    //   661: iconst_0
    //   662: iconst_0
    //   663: invokevirtual 319	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:a	(Lbahv;II)V
    //   666: iconst_0
    //   667: ireturn
    //   668: aload_0
    //   669: new 321	com/tencent/mobileqq/ptt/player/AmrPlayer
    //   672: dup
    //   673: invokespecial 322	com/tencent/mobileqq/ptt/player/AmrPlayer:<init>	()V
    //   676: putfield 167	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Bahv	Lbahv;
    //   679: ldc 149
    //   681: iconst_1
    //   682: new 24	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   689: ldc_w 324
    //   692: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: iload 5
    //   697: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   700: ldc_w 326
    //   703: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: iconst_2
    //   713: istore_2
    //   714: goto -302 -> 412
    //   717: iconst_0
    //   718: istore_2
    //   719: goto -73 -> 646
    //   722: astore 10
    //   724: iload 4
    //   726: istore 5
    //   728: goto -334 -> 394
    //   731: astore 10
    //   733: goto -119 -> 614
    //   736: astore_1
    //   737: goto -133 -> 604
    //   740: astore 12
    //   742: goto -213 -> 529
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	745	0	this	CommonAudioPlayer
    //   0	745	1	paramString	String
    //   0	745	2	paramInt	int
    //   1	594	3	b1	byte
    //   317	408	4	b2	byte
    //   378	349	5	b3	byte
    //   6	425	6	i	int
    //   3	641	7	j	int
    //   18	489	8	l	long
    //   310	232	10	localFileInputStream1	java.io.FileInputStream
    //   592	1	10	localException1	java.lang.Exception
    //   602	8	10	localObject	Object
    //   722	1	10	localException2	java.lang.Exception
    //   731	1	10	localException3	java.lang.Exception
    //   306	276	11	localFileInputStream2	java.io.FileInputStream
    //   524	36	12	localException4	java.lang.Exception
    //   740	1	12	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   298	308	524	java/lang/Exception
    //   581	586	592	java/lang/Exception
    //   298	308	600	finally
    //   294	298	616	java/lang/Exception
    //   399	410	616	java/lang/Exception
    //   412	481	616	java/lang/Exception
    //   614	616	616	java/lang/Exception
    //   668	712	616	java/lang/Exception
    //   385	390	722	java/lang/Exception
    //   609	614	731	java/lang/Exception
    //   312	319	736	finally
    //   326	332	736	finally
    //   339	376	736	finally
    //   533	539	736	finally
    //   543	573	736	finally
    //   312	319	740	java/lang/Exception
    //   326	332	740	java/lang/Exception
    //   339	376	740	java/lang/Exception
  }
  
  public void b()
  {
    this.jdField_a_of_type_Afps.a(this.jdField_a_of_type_AndroidMediaAudioManager);
  }
  
  public void c()
  {
    try
    {
      n();
      super.c();
      this.e = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void c(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.e = true;
    }
    super.c(paramInt);
  }
  
  public void f()
  {
    super.f();
    this.e = false;
  }
  
  public void h()
  {
    this.jdField_a_of_type_Afps.a(true);
  }
  
  public void i()
  {
    this.jdField_a_of_type_Afps.a(false);
  }
  
  public void k()
  {
    super.k();
    this.jdField_a_of_type_Afpo.a();
  }
  
  public void l()
  {
    this.jdField_a_of_type_Afps = new afps();
    this.jdField_a_of_type_Afpo = new afpo(this.jdField_a_of_type_AndroidAppApplication);
    this.jdField_a_of_type_Afpo.a(this);
    this.jdField_a_of_type_Afps.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CommonAudioPlayer
 * JD-Core Version:    0.7.0.1
 */