import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bdud
  extends BusinessHandler
{
  public bdud(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool3;
    boolean bool4;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("AlphabeticFontHandler", 2, "handleGetAlphabeticFontStatusToFriendResp success=" + bool1);
      }
      bool3 = bool1;
      if (!bool1) {
        break label623;
      }
      bool4 = bool1;
      bool2 = bool1;
    }
    for (;;)
    {
      boolean bool5;
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool4 = bool1;
        bool2 = bool1;
        if (paramFromServiceMsg.uint32_result.get() == 0)
        {
          bool1 = true;
          bool4 = bool1;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            bool4 = bool1;
            bool2 = bool1;
            QLog.d("AlphabeticFontHandler", 2, "handleGetAlphabeticFontStatusToFriendResp result=" + bool1);
          }
          bool3 = bool1;
          if (!bool1) {
            break label623;
          }
          bool4 = bool1;
          bool2 = bool1;
          bool3 = bool1;
          if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
            break label623;
          }
          bool4 = bool1;
          bool2 = bool1;
          bool3 = bool1;
          if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
            break label623;
          }
          bool4 = bool1;
          bool2 = bool1;
          paramObject = new oidb_0x5eb.RspBody();
          bool4 = bool1;
          bool2 = bool1;
          paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool4 = bool1;
          bool2 = bool1;
          if (paramObject.rpt_msg_uin_data.size() <= 0) {
            continue;
          }
          bool4 = bool1;
          bool2 = bool1;
          int i = ((oidb_0x5eb.UdcUinData)paramObject.rpt_msg_uin_data.get(0)).uint32_alphabetic_font_flag.get();
          if (i == 0) {
            continue;
          }
          bool1 = true;
          bool4 = true;
          bool2 = true;
          bool3 = true;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool3 = false;
        bool1 = bool4;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          QLog.d("AlphabeticFontHandler", 2, "handleGetAlphabeticFontStatusToFriendResp ex", paramFromServiceMsg);
        }
        bool5 = bool3;
        bool4 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("AlphabeticFontHandler", 2, "handleGetAlphabeticFontStatusToFriendResp result=" + bool1);
          bool2 = bool1;
          bool1 = bool3;
          continue;
        }
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("AlphabeticFontHandler", 2, "handleGetAlphabeticFontStatusToFriendResp result=" + bool2);
        }
      }
      try
      {
        bhhr.a(BaseApplicationImpl.context, getCurrentAccountUin(), true, "key_alphabetic_font_switch_status_", Boolean.valueOf(bool1));
        bool2 = bool3;
        bool5 = bool1;
        bool4 = bool2;
        if (!QLog.isColorLevel()) {
          break label612;
        }
        QLog.d("AlphabeticFontHandler", 2, "handleGetAlphabeticFontStatusToFriendResp result=" + bool2);
      }
      catch (Exception paramFromServiceMsg)
      {
        bool3 = bool1;
        bool1 = bool4;
        continue;
        bool1 = bool5;
        bool2 = bool4;
        continue;
      }
      if (!b())
      {
        if (bool1) {
          bdla.b(this.app, "dc00898", "", "", "0X800B3D4", "0X800B3D4", 0, 0, "", "", "", "");
        }
        paramFromServiceMsg = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
        bhhr.a(BaseApplicationImpl.context, getCurrentAccountUin(), true, "teens_mode_last_report_alphabetic_time", paramFromServiceMsg.format(new Date()));
      }
      notifyUI(1, bool2, Boolean.valueOf(bool1));
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool2 = false;
      bool1 = false;
      continue;
      label612:
      label623:
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_1
    //   4: istore 12
    //   6: iconst_1
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 11
    //   12: aload_2
    //   13: invokevirtual 19	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +398 -> 414
    //   19: aload_3
    //   20: ifnull +394 -> 414
    //   23: iconst_1
    //   24: istore 5
    //   26: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +29 -> 58
    //   32: ldc 26
    //   34: iconst_2
    //   35: new 28	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   42: ldc 182
    //   44: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload 5
    //   49: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: iload 5
    //   60: istore 8
    //   62: iload 5
    //   64: ifeq +602 -> 666
    //   67: iload 5
    //   69: istore 6
    //   71: iload 5
    //   73: istore 7
    //   75: new 50	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   78: dup
    //   79: invokespecial 51	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   82: aload_3
    //   83: checkcast 53	[B
    //   86: checkcast 53	[B
    //   89: invokevirtual 57	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   92: checkcast 50	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: astore_2
    //   96: iload 5
    //   98: istore 6
    //   100: iload 5
    //   102: istore 7
    //   104: aload_2
    //   105: getfield 61	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   108: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   111: istore 4
    //   113: iload 4
    //   115: ifne +305 -> 420
    //   118: iconst_1
    //   119: istore 5
    //   121: iload 5
    //   123: istore 6
    //   125: iload 5
    //   127: istore 7
    //   129: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +47 -> 179
    //   135: iload 5
    //   137: istore 6
    //   139: iload 5
    //   141: istore 7
    //   143: ldc 26
    //   145: iconst_2
    //   146: new 28	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   153: ldc 184
    //   155: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: iload 5
    //   160: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   163: ldc 186
    //   165: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload 4
    //   170: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: iload 5
    //   181: istore 8
    //   183: iload 5
    //   185: ifeq +481 -> 666
    //   188: iload 5
    //   190: istore 6
    //   192: iload 5
    //   194: istore 7
    //   196: iload 5
    //   198: istore 8
    //   200: aload_2
    //   201: getfield 73	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   204: invokevirtual 78	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   207: ifeq +459 -> 666
    //   210: iload 5
    //   212: istore 6
    //   214: iload 5
    //   216: istore 7
    //   218: iload 5
    //   220: istore 8
    //   222: aload_2
    //   223: getfield 73	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   226: invokevirtual 81	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   229: ifnull +437 -> 666
    //   232: iload 5
    //   234: istore 6
    //   236: iload 5
    //   238: istore 7
    //   240: aload_2
    //   241: getfield 73	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   244: invokevirtual 81	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   247: invokevirtual 90	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   250: invokestatic 195	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   253: invokevirtual 198	java/nio/ByteBuffer:getInt	()I
    //   256: invokestatic 203	bhbx:a	(I)J
    //   259: lstore 13
    //   261: iload 5
    //   263: istore 6
    //   265: iload 5
    //   267: istore 7
    //   269: aload_0
    //   270: getfield 137	bdud:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   273: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   276: lload 13
    //   278: invokestatic 211	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   281: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   284: ifeq +142 -> 426
    //   287: iload 5
    //   289: istore 6
    //   291: iload 5
    //   293: istore 7
    //   295: aload_1
    //   296: getfield 221	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   299: ldc 223
    //   301: invokevirtual 229	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   304: istore 5
    //   306: iload 12
    //   308: istore 6
    //   310: getstatic 114	com/tencent/common/app/BaseApplicationImpl:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   313: aload_0
    //   314: invokevirtual 117	bdud:getCurrentAccountUin	()Ljava/lang/String;
    //   317: iconst_1
    //   318: ldc 119
    //   320: iload 5
    //   322: invokestatic 125	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   325: invokestatic 130	bhhr:a	(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Object;)V
    //   328: iload 5
    //   330: istore 7
    //   332: iload 9
    //   334: istore 5
    //   336: iload 5
    //   338: istore 6
    //   340: iload 7
    //   342: istore 8
    //   344: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +54 -> 401
    //   350: ldc 26
    //   352: iconst_2
    //   353: new 28	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   360: ldc 184
    //   362: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload 5
    //   367: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   370: ldc 231
    //   372: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_1
    //   376: getfield 221	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   379: ldc 223
    //   381: invokevirtual 229	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   384: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   387: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: iload 7
    //   395: istore 8
    //   397: iload 5
    //   399: istore 6
    //   401: aload_0
    //   402: iconst_2
    //   403: iload 6
    //   405: iload 8
    //   407: invokestatic 125	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   410: invokevirtual 174	bdud:notifyUI	(IZLjava/lang/Object;)V
    //   413: return
    //   414: iconst_0
    //   415: istore 5
    //   417: goto -391 -> 26
    //   420: iconst_0
    //   421: istore 5
    //   423: goto -302 -> 121
    //   426: iload 5
    //   428: istore 6
    //   430: iload 5
    //   432: istore 7
    //   434: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +52 -> 489
    //   440: iload 5
    //   442: istore 6
    //   444: iload 5
    //   446: istore 7
    //   448: ldc 26
    //   450: iconst_2
    //   451: new 28	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   458: ldc 233
    //   460: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload_0
    //   464: getfield 137	bdud:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   467: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   470: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: ldc 235
    //   475: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: lload 13
    //   480: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   483: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: iconst_0
    //   490: istore 5
    //   492: iload 11
    //   494: istore 7
    //   496: goto -160 -> 336
    //   499: astore_2
    //   500: iconst_0
    //   501: istore 5
    //   503: iload 6
    //   505: istore 7
    //   507: iload 7
    //   509: istore 6
    //   511: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq +16 -> 530
    //   517: iload 7
    //   519: istore 6
    //   521: ldc 26
    //   523: iconst_1
    //   524: ldc 240
    //   526: aload_2
    //   527: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   530: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   533: ifeq +123 -> 656
    //   536: ldc 26
    //   538: iconst_2
    //   539: new 28	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   546: ldc 184
    //   548: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: iconst_0
    //   552: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   555: ldc 231
    //   557: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload_1
    //   561: getfield 221	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   564: ldc 223
    //   566: invokevirtual 229	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   569: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   572: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: iconst_0
    //   579: istore 6
    //   581: iload 5
    //   583: istore 8
    //   585: goto -184 -> 401
    //   588: astore_2
    //   589: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   592: ifeq +46 -> 638
    //   595: ldc 26
    //   597: iconst_2
    //   598: new 28	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   605: ldc 184
    //   607: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: iload 7
    //   612: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   615: ldc 231
    //   617: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload_1
    //   621: getfield 221	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   624: ldc 223
    //   626: invokevirtual 229	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   629: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   632: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: aload_2
    //   639: athrow
    //   640: astore_2
    //   641: iload 6
    //   643: istore 7
    //   645: goto -56 -> 589
    //   648: astore_2
    //   649: iload 10
    //   651: istore 7
    //   653: goto -146 -> 507
    //   656: iconst_0
    //   657: istore 6
    //   659: iload 5
    //   661: istore 8
    //   663: goto -262 -> 401
    //   666: iload 8
    //   668: istore 5
    //   670: iload 11
    //   672: istore 7
    //   674: goto -338 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	677	0	this	bdud
    //   0	677	1	paramToServiceMsg	ToServiceMsg
    //   0	677	2	paramFromServiceMsg	FromServiceMsg
    //   0	677	3	paramObject	Object
    //   111	58	4	i	int
    //   24	645	5	bool1	boolean
    //   69	589	6	bool2	boolean
    //   73	600	7	bool3	boolean
    //   60	607	8	bool4	boolean
    //   7	326	9	bool5	boolean
    //   1	649	10	bool6	boolean
    //   10	661	11	bool7	boolean
    //   4	303	12	bool8	boolean
    //   259	220	13	l	long
    // Exception table:
    //   from	to	target	type
    //   75	96	499	java/lang/Exception
    //   104	113	499	java/lang/Exception
    //   129	135	499	java/lang/Exception
    //   143	179	499	java/lang/Exception
    //   200	210	499	java/lang/Exception
    //   222	232	499	java/lang/Exception
    //   240	261	499	java/lang/Exception
    //   269	287	499	java/lang/Exception
    //   295	306	499	java/lang/Exception
    //   434	440	499	java/lang/Exception
    //   448	489	499	java/lang/Exception
    //   75	96	588	finally
    //   104	113	588	finally
    //   129	135	588	finally
    //   143	179	588	finally
    //   200	210	588	finally
    //   222	232	588	finally
    //   240	261	588	finally
    //   269	287	588	finally
    //   295	306	588	finally
    //   434	440	588	finally
    //   448	489	588	finally
    //   310	328	640	finally
    //   511	517	640	finally
    //   521	530	640	finally
    //   310	328	648	java/lang/Exception
  }
  
  private boolean b()
  {
    Object localObject1 = (String)bhhr.b(BaseApplicationImpl.context, getCurrentAccountUin(), "teens_mode_last_report_alphabetic_time", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse((String)localObject1);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTime((Date)localObject2);
        localObject2 = Calendar.getInstance();
        ((Calendar)localObject2).setTime(new Date());
        if ((((Calendar)localObject1).get(0) == ((Calendar)localObject2).get(0)) && (((Calendar)localObject1).get(1) == ((Calendar)localObject2).get(1)))
        {
          int i = ((Calendar)localObject1).get(6);
          int j = ((Calendar)localObject2).get(6);
          if (i == j) {
            return true;
          }
        }
        return false;
      }
      catch (ParseException localParseException)
      {
        localParseException.printStackTrace();
      }
    }
    return false;
  }
  
  public void a(boolean paramBoolean)
  {
    short s = 2;
    if (QLog.isColorLevel()) {
      QLog.d("AlphabeticFontHandler", 2, "setVisibilityForAlphabeticFontStatus OPEN=" + paramBoolean);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(9);
      Object localObject = ByteBuffer.allocate(13);
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      if (paramBoolean) {
        s = 1;
      }
      ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)-23053).putShort((short)2).putShort(s);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x4ff_42483");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putBoolean("uint32_input_status_flag", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromAlphabeticFontHandler", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AlphabeticFontHandler", 1, "setMedalSwitch ex", localException);
    }
  }
  
  public boolean a()
  {
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    try
    {
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      localReqBody.rpt_uint64_uins.add(Long.valueOf(l));
      localReqBody.uint32_alphabetic_font_flag.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42483", 1515, 22, localReqBody.toByteArray()));
      return ((Boolean)bhhr.b(BaseApplicationImpl.context, getCurrentAccountUin(), "key_alphabetic_font_switch_status_", Boolean.valueOf(false))).booleanValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return bduf.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (!TextUtils.equals("OidbSvc.0x5eb_42483", paramFromServiceMsg.getServiceCmd())) {
        break label27;
      }
      a(paramFromServiceMsg, paramObject);
    }
    label27:
    while (!TextUtils.equals("OidbSvc.0x4ff_42483", paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdud
 * JD-Core Version:    0.7.0.1
 */