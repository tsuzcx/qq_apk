package com.tencent.device.file;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo.RetryInfo;
import com.tencent.mobileqq.shortvideo.UiCallBack;
import com.tencent.mobileqq.shortvideo.api.IShortVideoOperator;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class DevShortVideoSendOperator
  implements UpCallBack, IShortVideoOperator
{
  public BaseQQAppInterface a;
  public ShortVideoReq b;
  protected UiCallBack c;
  public String d;
  public String e;
  public MessageRecord f;
  protected Handler g;
  public String h;
  public long i;
  public long j;
  public String k;
  public int l;
  public String m;
  public String n;
  public int o;
  public int p;
  public String q;
  
  public DevShortVideoSendOperator() {}
  
  public DevShortVideoSendOperator(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    if (this.g == null) {
      this.g = new DevShortVideoSendOperator.1(this, Looper.getMainLooper());
    }
  }
  
  private void c(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DevShortVideoSendOperator.2(this, paramShortVideoUploadInfo));
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: aload_0
    //   13: getfield 81	com/tencent/device/file/DevShortVideoSendOperator:h	Ljava/lang/String;
    //   16: invokestatic 87	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnonnull +19 -> 40
    //   24: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +1007 -> 1034
    //   30: ldc 95
    //   32: iconst_2
    //   33: ldc 97
    //   35: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: iconst_m1
    //   39: ireturn
    //   40: aload_2
    //   41: invokestatic 104	com/tencent/mobileqq/shortvideo/ShortVideoUtils:resizeThumb	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   44: astore 5
    //   46: aload 5
    //   48: ifnonnull +19 -> 67
    //   51: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +982 -> 1036
    //   57: ldc 95
    //   59: iconst_2
    //   60: ldc 106
    //   62: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: iconst_m1
    //   66: ireturn
    //   67: aload_0
    //   68: aload 5
    //   70: invokevirtual 111	android/graphics/Bitmap:getWidth	()I
    //   73: putfield 113	com/tencent/device/file/DevShortVideoSendOperator:o	I
    //   76: aload_0
    //   77: aload 5
    //   79: invokevirtual 116	android/graphics/Bitmap:getHeight	()I
    //   82: putfield 118	com/tencent/device/file/DevShortVideoSendOperator:p	I
    //   85: new 120	java/io/File
    //   88: dup
    //   89: aload_0
    //   90: getfield 81	com/tencent/device/file/DevShortVideoSendOperator:h	Ljava/lang/String;
    //   93: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: astore_2
    //   97: aload_0
    //   98: aload_2
    //   99: invokevirtual 127	java/io/File:length	()J
    //   102: putfield 129	com/tencent/device/file/DevShortVideoSendOperator:i	J
    //   105: new 131	java/io/FileInputStream
    //   108: dup
    //   109: aload_2
    //   110: invokespecial 134	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   113: astore_2
    //   114: aload_0
    //   115: aload_2
    //   116: aload_0
    //   117: getfield 129	com/tencent/device/file/DevShortVideoSendOperator:i	J
    //   120: invokestatic 140	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   123: invokestatic 146	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   126: putfield 148	com/tencent/device/file/DevShortVideoSendOperator:m	Ljava/lang/String;
    //   129: aload_0
    //   130: getfield 148	com/tencent/device/file/DevShortVideoSendOperator:m	Ljava/lang/String;
    //   133: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   136: ifeq +49 -> 185
    //   139: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +37 -> 179
    //   145: new 156	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   152: astore_3
    //   153: aload_3
    //   154: ldc 159
    //   156: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_3
    //   161: aload_0
    //   162: getfield 148	com/tencent/device/file/DevShortVideoSendOperator:m	Ljava/lang/String;
    //   165: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: ldc 95
    //   171: iconst_2
    //   172: aload_3
    //   173: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: aload_2
    //   180: invokevirtual 170	java/io/FileInputStream:close	()V
    //   183: iconst_m1
    //   184: ireturn
    //   185: aload_0
    //   186: getfield 148	com/tencent/device/file/DevShortVideoSendOperator:m	Ljava/lang/String;
    //   189: ldc 172
    //   191: invokestatic 177	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   194: astore 7
    //   196: new 156	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   203: astore_3
    //   204: aload_3
    //   205: invokestatic 179	com/tencent/mobileqq/shortvideo/SVUtils:b	()Ljava/lang/String;
    //   208: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_3
    //   213: ldc 181
    //   215: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_3
    //   220: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 186	com/tencent/mobileqq/utils/FileUtils:createFileIfNotExits	(Ljava/lang/String;)V
    //   226: new 120	java/io/File
    //   229: dup
    //   230: aload 7
    //   232: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
    //   235: astore 8
    //   237: new 120	java/io/File
    //   240: dup
    //   241: aload 8
    //   243: invokevirtual 189	java/io/File:getParent	()Ljava/lang/String;
    //   246: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
    //   249: astore_3
    //   250: aload_3
    //   251: invokevirtual 192	java/io/File:exists	()Z
    //   254: ifeq +10 -> 264
    //   257: aload_3
    //   258: invokevirtual 195	java/io/File:isDirectory	()Z
    //   261: ifne +8 -> 269
    //   264: aload_3
    //   265: invokevirtual 198	java/io/File:mkdirs	()Z
    //   268: pop
    //   269: aload 8
    //   271: invokevirtual 192	java/io/File:exists	()Z
    //   274: ifeq +11 -> 285
    //   277: aload 8
    //   279: invokevirtual 201	java/io/File:isFile	()Z
    //   282: ifne +9 -> 291
    //   285: aload 8
    //   287: invokevirtual 204	java/io/File:createNewFile	()Z
    //   290: pop
    //   291: new 206	java/io/FileOutputStream
    //   294: dup
    //   295: aload 8
    //   297: invokespecial 207	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   300: astore_3
    //   301: aload 5
    //   303: getstatic 213	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   306: bipush 50
    //   308: aload_3
    //   309: invokevirtual 217	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   312: pop
    //   313: aload_3
    //   314: invokevirtual 220	java/io/FileOutputStream:flush	()V
    //   317: new 131	java/io/FileInputStream
    //   320: dup
    //   321: aload 8
    //   323: invokespecial 134	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   326: astore 4
    //   328: aload_0
    //   329: aload 4
    //   331: aload 8
    //   333: invokevirtual 127	java/io/File:length	()J
    //   336: invokestatic 140	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   339: invokestatic 146	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   342: putfield 222	com/tencent/device/file/DevShortVideoSendOperator:q	Ljava/lang/String;
    //   345: aload_0
    //   346: getfield 222	com/tencent/device/file/DevShortVideoSendOperator:q	Ljava/lang/String;
    //   349: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifeq +62 -> 414
    //   355: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +41 -> 399
    //   361: new 156	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   368: astore 5
    //   370: aload 5
    //   372: ldc 224
    //   374: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 5
    //   380: aload_0
    //   381: getfield 222	com/tencent/device/file/DevShortVideoSendOperator:q	Ljava/lang/String;
    //   384: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: ldc 95
    //   390: iconst_2
    //   391: aload 5
    //   393: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: aload_2
    //   400: invokevirtual 170	java/io/FileInputStream:close	()V
    //   403: aload_3
    //   404: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   407: aload 4
    //   409: invokevirtual 170	java/io/FileInputStream:close	()V
    //   412: iconst_m1
    //   413: ireturn
    //   414: aload_0
    //   415: aload_0
    //   416: getfield 222	com/tencent/device/file/DevShortVideoSendOperator:q	Ljava/lang/String;
    //   419: ldc 172
    //   421: invokestatic 177	com/tencent/mobileqq/shortvideo/SVUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   424: putfield 227	com/tencent/device/file/DevShortVideoSendOperator:n	Ljava/lang/String;
    //   427: aload 7
    //   429: aload_0
    //   430: getfield 227	com/tencent/device/file/DevShortVideoSendOperator:n	Ljava/lang/String;
    //   433: invokestatic 231	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   436: istore_1
    //   437: iload_1
    //   438: ifne +18 -> 456
    //   441: aload_2
    //   442: invokevirtual 170	java/io/FileInputStream:close	()V
    //   445: aload_3
    //   446: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   449: aload 4
    //   451: invokevirtual 170	java/io/FileInputStream:close	()V
    //   454: iconst_m1
    //   455: ireturn
    //   456: aload_0
    //   457: getfield 233	com/tencent/device/file/DevShortVideoSendOperator:j	J
    //   460: lconst_0
    //   461: lcmp
    //   462: ifne +14 -> 476
    //   465: aload_0
    //   466: aload_0
    //   467: getfield 81	com/tencent/device/file/DevShortVideoSendOperator:h	Ljava/lang/String;
    //   470: invokestatic 237	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   473: putfield 233	com/tencent/device/file/DevShortVideoSendOperator:j	J
    //   476: aload_2
    //   477: invokevirtual 170	java/io/FileInputStream:close	()V
    //   480: aload_3
    //   481: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   484: aload 4
    //   486: invokevirtual 170	java/io/FileInputStream:close	()V
    //   489: iconst_0
    //   490: ireturn
    //   491: astore 5
    //   493: aload_2
    //   494: astore 6
    //   496: goto +418 -> 914
    //   499: astore 5
    //   501: goto +67 -> 568
    //   504: astore 5
    //   506: goto +87 -> 593
    //   509: astore 5
    //   511: goto +107 -> 618
    //   514: astore 5
    //   516: aconst_null
    //   517: astore 4
    //   519: aload_2
    //   520: astore 6
    //   522: goto +392 -> 914
    //   525: astore 5
    //   527: aconst_null
    //   528: astore 4
    //   530: goto +38 -> 568
    //   533: astore 5
    //   535: aconst_null
    //   536: astore 4
    //   538: goto +55 -> 593
    //   541: astore 5
    //   543: aconst_null
    //   544: astore 4
    //   546: goto +72 -> 618
    //   549: astore 5
    //   551: aconst_null
    //   552: astore 4
    //   554: aload 6
    //   556: astore_3
    //   557: goto +360 -> 917
    //   560: astore 5
    //   562: aconst_null
    //   563: astore 4
    //   565: aload 4
    //   567: astore_3
    //   568: aload 5
    //   570: astore 8
    //   572: aload_2
    //   573: astore 7
    //   575: aload 4
    //   577: astore 5
    //   579: aload_3
    //   580: astore 6
    //   582: goto +76 -> 658
    //   585: astore 5
    //   587: aconst_null
    //   588: astore 4
    //   590: aload 4
    //   592: astore_3
    //   593: aload 5
    //   595: astore 8
    //   597: aload_2
    //   598: astore 7
    //   600: aload 4
    //   602: astore 5
    //   604: aload_3
    //   605: astore 6
    //   607: goto +137 -> 744
    //   610: astore 5
    //   612: aconst_null
    //   613: astore 4
    //   615: aload 4
    //   617: astore_3
    //   618: aload 5
    //   620: astore 8
    //   622: aload_2
    //   623: astore 7
    //   625: aload 4
    //   627: astore 5
    //   629: aload_3
    //   630: astore 6
    //   632: goto +199 -> 831
    //   635: astore 5
    //   637: aconst_null
    //   638: astore 4
    //   640: aload 4
    //   642: astore_2
    //   643: aload 6
    //   645: astore_3
    //   646: goto +271 -> 917
    //   649: astore 8
    //   651: aconst_null
    //   652: astore 5
    //   654: aload 5
    //   656: astore 6
    //   658: aload 7
    //   660: astore 4
    //   662: aload 5
    //   664: astore_2
    //   665: aload 6
    //   667: astore_3
    //   668: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   671: ifeq +23 -> 694
    //   674: aload 7
    //   676: astore 4
    //   678: aload 5
    //   680: astore_2
    //   681: aload 6
    //   683: astore_3
    //   684: ldc 95
    //   686: iconst_2
    //   687: ldc 239
    //   689: aload 8
    //   691: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   694: aload 7
    //   696: ifnull +11 -> 707
    //   699: aload 7
    //   701: invokevirtual 170	java/io/FileInputStream:close	()V
    //   704: goto +3 -> 707
    //   707: aload 6
    //   709: ifnull +11 -> 720
    //   712: aload 6
    //   714: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   717: goto +3 -> 720
    //   720: aload 5
    //   722: ifnull +8 -> 730
    //   725: aload 5
    //   727: invokevirtual 170	java/io/FileInputStream:close	()V
    //   730: iconst_m1
    //   731: ireturn
    //   732: astore 8
    //   734: aconst_null
    //   735: astore 5
    //   737: aload 5
    //   739: astore 6
    //   741: aload_3
    //   742: astore 7
    //   744: aload 7
    //   746: astore 4
    //   748: aload 5
    //   750: astore_2
    //   751: aload 6
    //   753: astore_3
    //   754: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   757: ifeq +23 -> 780
    //   760: aload 7
    //   762: astore 4
    //   764: aload 5
    //   766: astore_2
    //   767: aload 6
    //   769: astore_3
    //   770: ldc 95
    //   772: iconst_2
    //   773: ldc 244
    //   775: aload 8
    //   777: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   780: aload 7
    //   782: ifnull +11 -> 793
    //   785: aload 7
    //   787: invokevirtual 170	java/io/FileInputStream:close	()V
    //   790: goto +3 -> 793
    //   793: aload 6
    //   795: ifnull +11 -> 806
    //   798: aload 6
    //   800: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   803: goto +3 -> 806
    //   806: aload 5
    //   808: ifnull +8 -> 816
    //   811: aload 5
    //   813: invokevirtual 170	java/io/FileInputStream:close	()V
    //   816: iconst_m1
    //   817: ireturn
    //   818: astore 8
    //   820: aconst_null
    //   821: astore 5
    //   823: aload 5
    //   825: astore 6
    //   827: aload 4
    //   829: astore 7
    //   831: aload 7
    //   833: astore 4
    //   835: aload 5
    //   837: astore_2
    //   838: aload 6
    //   840: astore_3
    //   841: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   844: ifeq +23 -> 867
    //   847: aload 7
    //   849: astore 4
    //   851: aload 5
    //   853: astore_2
    //   854: aload 6
    //   856: astore_3
    //   857: ldc 95
    //   859: iconst_2
    //   860: ldc 244
    //   862: aload 8
    //   864: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   867: aload 7
    //   869: ifnull +11 -> 880
    //   872: aload 7
    //   874: invokevirtual 170	java/io/FileInputStream:close	()V
    //   877: goto +3 -> 880
    //   880: aload 6
    //   882: ifnull +11 -> 893
    //   885: aload 6
    //   887: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   890: goto +3 -> 893
    //   893: aload 5
    //   895: ifnull +8 -> 903
    //   898: aload 5
    //   900: invokevirtual 170	java/io/FileInputStream:close	()V
    //   903: iconst_m1
    //   904: ireturn
    //   905: astore 5
    //   907: aload 4
    //   909: astore 6
    //   911: aload_2
    //   912: astore 4
    //   914: aload 6
    //   916: astore_2
    //   917: aload_2
    //   918: ifnull +10 -> 928
    //   921: aload_2
    //   922: invokevirtual 170	java/io/FileInputStream:close	()V
    //   925: goto +3 -> 928
    //   928: aload_3
    //   929: ifnull +10 -> 939
    //   932: aload_3
    //   933: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   936: goto +3 -> 939
    //   939: aload 4
    //   941: ifnull +8 -> 949
    //   944: aload 4
    //   946: invokevirtual 170	java/io/FileInputStream:close	()V
    //   949: aload 5
    //   951: athrow
    //   952: astore_2
    //   953: iconst_m1
    //   954: ireturn
    //   955: astore_2
    //   956: goto -553 -> 403
    //   959: astore_2
    //   960: goto -553 -> 407
    //   963: astore_2
    //   964: iconst_m1
    //   965: ireturn
    //   966: astore_2
    //   967: goto -522 -> 445
    //   970: astore_2
    //   971: goto -522 -> 449
    //   974: astore_2
    //   975: iconst_m1
    //   976: ireturn
    //   977: astore_2
    //   978: goto -498 -> 480
    //   981: astore_2
    //   982: goto -498 -> 484
    //   985: astore_2
    //   986: goto -497 -> 489
    //   989: astore_2
    //   990: goto -283 -> 707
    //   993: astore_2
    //   994: goto -274 -> 720
    //   997: astore_2
    //   998: iconst_m1
    //   999: ireturn
    //   1000: astore_2
    //   1001: goto -208 -> 793
    //   1004: astore_2
    //   1005: goto -199 -> 806
    //   1008: astore_2
    //   1009: iconst_m1
    //   1010: ireturn
    //   1011: astore_2
    //   1012: goto -132 -> 880
    //   1015: astore_2
    //   1016: goto -123 -> 893
    //   1019: astore_2
    //   1020: iconst_m1
    //   1021: ireturn
    //   1022: astore_2
    //   1023: goto -95 -> 928
    //   1026: astore_2
    //   1027: goto -88 -> 939
    //   1030: astore_2
    //   1031: goto -82 -> 949
    //   1034: iconst_m1
    //   1035: ireturn
    //   1036: iconst_m1
    //   1037: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1038	0	this	DevShortVideoSendOperator
    //   436	2	1	bool	boolean
    //   19	903	2	localObject1	Object
    //   952	1	2	localIOException1	java.io.IOException
    //   955	1	2	localIOException2	java.io.IOException
    //   959	1	2	localIOException3	java.io.IOException
    //   963	1	2	localIOException4	java.io.IOException
    //   966	1	2	localIOException5	java.io.IOException
    //   970	1	2	localIOException6	java.io.IOException
    //   974	1	2	localIOException7	java.io.IOException
    //   977	1	2	localIOException8	java.io.IOException
    //   981	1	2	localIOException9	java.io.IOException
    //   985	1	2	localIOException10	java.io.IOException
    //   989	1	2	localIOException11	java.io.IOException
    //   993	1	2	localIOException12	java.io.IOException
    //   997	1	2	localIOException13	java.io.IOException
    //   1000	1	2	localIOException14	java.io.IOException
    //   1004	1	2	localIOException15	java.io.IOException
    //   1008	1	2	localIOException16	java.io.IOException
    //   1011	1	2	localIOException17	java.io.IOException
    //   1015	1	2	localIOException18	java.io.IOException
    //   1019	1	2	localIOException19	java.io.IOException
    //   1022	1	2	localIOException20	java.io.IOException
    //   1026	1	2	localIOException21	java.io.IOException
    //   1030	1	2	localIOException22	java.io.IOException
    //   1	932	3	localObject2	Object
    //   3	942	4	localObject3	Object
    //   44	348	5	localObject4	Object
    //   491	1	5	localObject5	Object
    //   499	1	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   504	1	5	localException1	java.lang.Exception
    //   509	1	5	localIOException23	java.io.IOException
    //   514	1	5	localObject6	Object
    //   525	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   533	1	5	localException2	java.lang.Exception
    //   541	1	5	localIOException24	java.io.IOException
    //   549	1	5	localObject7	Object
    //   560	9	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   577	1	5	localObject8	Object
    //   585	9	5	localException3	java.lang.Exception
    //   602	1	5	localObject9	Object
    //   610	9	5	localIOException25	java.io.IOException
    //   627	1	5	localObject10	Object
    //   635	1	5	localObject11	Object
    //   652	247	5	localObject12	Object
    //   905	45	5	localObject13	Object
    //   6	909	6	localObject14	Object
    //   9	864	7	localObject15	Object
    //   235	386	8	localObject16	Object
    //   649	41	8	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   732	44	8	localException4	java.lang.Exception
    //   818	45	8	localIOException26	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   328	399	491	finally
    //   414	437	491	finally
    //   456	476	491	finally
    //   328	399	499	java/lang/OutOfMemoryError
    //   414	437	499	java/lang/OutOfMemoryError
    //   456	476	499	java/lang/OutOfMemoryError
    //   328	399	504	java/lang/Exception
    //   414	437	504	java/lang/Exception
    //   456	476	504	java/lang/Exception
    //   328	399	509	java/io/IOException
    //   414	437	509	java/io/IOException
    //   456	476	509	java/io/IOException
    //   301	328	514	finally
    //   301	328	525	java/lang/OutOfMemoryError
    //   301	328	533	java/lang/Exception
    //   301	328	541	java/io/IOException
    //   114	179	549	finally
    //   185	264	549	finally
    //   264	269	549	finally
    //   269	285	549	finally
    //   285	291	549	finally
    //   291	301	549	finally
    //   114	179	560	java/lang/OutOfMemoryError
    //   185	264	560	java/lang/OutOfMemoryError
    //   264	269	560	java/lang/OutOfMemoryError
    //   269	285	560	java/lang/OutOfMemoryError
    //   285	291	560	java/lang/OutOfMemoryError
    //   291	301	560	java/lang/OutOfMemoryError
    //   114	179	585	java/lang/Exception
    //   185	264	585	java/lang/Exception
    //   264	269	585	java/lang/Exception
    //   269	285	585	java/lang/Exception
    //   285	291	585	java/lang/Exception
    //   291	301	585	java/lang/Exception
    //   114	179	610	java/io/IOException
    //   185	264	610	java/io/IOException
    //   264	269	610	java/io/IOException
    //   269	285	610	java/io/IOException
    //   285	291	610	java/io/IOException
    //   291	301	610	java/io/IOException
    //   11	20	635	finally
    //   24	38	635	finally
    //   40	46	635	finally
    //   51	65	635	finally
    //   67	114	635	finally
    //   11	20	649	java/lang/OutOfMemoryError
    //   24	38	649	java/lang/OutOfMemoryError
    //   40	46	649	java/lang/OutOfMemoryError
    //   51	65	649	java/lang/OutOfMemoryError
    //   67	114	649	java/lang/OutOfMemoryError
    //   11	20	732	java/lang/Exception
    //   24	38	732	java/lang/Exception
    //   40	46	732	java/lang/Exception
    //   51	65	732	java/lang/Exception
    //   67	114	732	java/lang/Exception
    //   11	20	818	java/io/IOException
    //   24	38	818	java/io/IOException
    //   40	46	818	java/io/IOException
    //   51	65	818	java/io/IOException
    //   67	114	818	java/io/IOException
    //   668	674	905	finally
    //   684	694	905	finally
    //   754	760	905	finally
    //   770	780	905	finally
    //   841	847	905	finally
    //   857	867	905	finally
    //   179	183	952	java/io/IOException
    //   399	403	955	java/io/IOException
    //   403	407	959	java/io/IOException
    //   407	412	963	java/io/IOException
    //   441	445	966	java/io/IOException
    //   445	449	970	java/io/IOException
    //   449	454	974	java/io/IOException
    //   476	480	977	java/io/IOException
    //   480	484	981	java/io/IOException
    //   484	489	985	java/io/IOException
    //   699	704	989	java/io/IOException
    //   712	717	993	java/io/IOException
    //   725	730	997	java/io/IOException
    //   785	790	1000	java/io/IOException
    //   798	803	1004	java/io/IOException
    //   811	816	1008	java/io/IOException
    //   872	877	1011	java/io/IOException
    //   885	890	1015	java/io/IOException
    //   898	903	1019	java/io/IOException
    //   921	925	1022	java/io/IOException
    //   932	936	1026	java/io/IOException
    //   944	949	1030	java/io/IOException
  }
  
  public MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    return null;
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    long l1 = System.currentTimeMillis();
    MessageForDevShortVideo localMessageForDevShortVideo = (MessageForDevShortVideo)MessageRecordFactory.c((QQAppInterface)this.a, paramShortVideoUploadInfo.e, paramShortVideoUploadInfo.f, paramShortVideoUploadInfo.c);
    localMessageForDevShortVideo.videoFileName = paramShortVideoUploadInfo.l;
    if (paramShortVideoUploadInfo.a == null) {
      paramShortVideoUploadInfo.a = "";
    }
    localMessageForDevShortVideo.uuid = paramShortVideoUploadInfo.a;
    if (paramShortVideoUploadInfo.i == null) {
      paramShortVideoUploadInfo.i = "";
    }
    localMessageForDevShortVideo.md5 = paramShortVideoUploadInfo.i;
    localMessageForDevShortVideo.videoFileFormat = 2;
    localMessageForDevShortVideo.videoFileSize = paramShortVideoUploadInfo.q;
    localMessageForDevShortVideo.videoFileTime = paramShortVideoUploadInfo.r;
    localMessageForDevShortVideo.thumbWidth = paramShortVideoUploadInfo.o;
    localMessageForDevShortVideo.thumbHeight = paramShortVideoUploadInfo.p;
    localMessageForDevShortVideo.videoFileStatus = 1002;
    int i1 = 0;
    localMessageForDevShortVideo.videoFileProgress = 0;
    localMessageForDevShortVideo.fileType = 19;
    localMessageForDevShortVideo.thumbMD5 = paramShortVideoUploadInfo.k;
    localMessageForDevShortVideo.extraflag = 32772;
    if (paramShortVideoUploadInfo.v == null) {
      paramShortVideoUploadInfo.v = "";
    }
    localMessageForDevShortVideo.fileSource = paramShortVideoUploadInfo.v;
    localMessageForDevShortVideo.lastModified = 0L;
    if (paramShortVideoUploadInfo.T != null) {
      i1 = 1;
    }
    if (i1 != 0)
    {
      localMessageForDevShortVideo.msgseq = paramShortVideoUploadInfo.T.a;
      localMessageForDevShortVideo.shmsgseq = paramShortVideoUploadInfo.T.b;
      localMessageForDevShortVideo.msgUid = paramShortVideoUploadInfo.T.c;
    }
    localMessageForDevShortVideo.msg = localMessageForDevShortVideo.getSummary();
    localMessageForDevShortVideo.serial();
    paramShortVideoUploadInfo.g = localMessageForDevShortVideo.uniseq;
    paramShortVideoUploadInfo = this.e;
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l1);
    Logger.a(paramShortVideoUploadInfo, str, "packmsg", localStringBuilder.toString());
    paramShortVideoUploadInfo = this.e;
    str = this.d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mr: ");
    localStringBuilder.append(localMessageForDevShortVideo.toLogString());
    localStringBuilder.append("-");
    localStringBuilder.append(localMessageForDevShortVideo.toString());
    Logger.a(paramShortVideoUploadInfo, str, "packMsg", localStringBuilder.toString());
    return localMessageForDevShortVideo;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.e, this.d, "attachRichText2Msg", "");
    MessageRecord localMessageRecord = this.f;
    if ((localMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)localMessageRecord).richText = paramRichText;
    }
    return this.f;
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.a(this.e, this.d, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    if ((paramObject instanceof Intent))
    {
      localObject = (Intent)paramObject;
      this.k = ((Intent)localObject).getStringExtra("uin");
      this.l = ((Intent)localObject).getIntExtra("uintype", 1003);
      this.h = ((Intent)localObject).getStringExtra("file_send_path");
    }
    else if ((paramObject instanceof MessageForShortVideo))
    {
      localObject = (MessageForShortVideo)paramObject;
      this.k = ((MessageForShortVideo)localObject).frienduin;
      this.l = ((MessageForShortVideo)localObject).istroop;
      this.i = ((MessageForShortVideo)localObject).videoFileSize;
      this.j = (((MessageForShortVideo)localObject).videoFileTime * 1000);
      this.h = ((MessageForShortVideo)localObject).videoFileName;
      this.n = SVUtils.a(((MessageForShortVideo)localObject).thumbMD5, "jpg");
      this.m = ((MessageForShortVideo)localObject).md5;
      this.o = ((MessageForShortVideo)localObject).thumbWidth;
      this.p = ((MessageForShortVideo)localObject).thumbHeight;
      this.q = ((MessageForShortVideo)localObject).thumbMD5;
    }
    a();
    Object localObject = new ShortVideoUploadInfo();
    ((ShortVideoUploadInfo)localObject).e = this.k;
    ((ShortVideoUploadInfo)localObject).l = this.h;
    ((ShortVideoUploadInfo)localObject).n = this.n;
    ((ShortVideoUploadInfo)localObject).c = this.l;
    ((ShortVideoUploadInfo)localObject).f = "";
    ((ShortVideoUploadInfo)localObject).q = ((int)this.i);
    ((ShortVideoUploadInfo)localObject).r = ((int)this.j / 1000);
    ((ShortVideoUploadInfo)localObject).i = this.m;
    ((ShortVideoUploadInfo)localObject).o = this.o;
    ((ShortVideoUploadInfo)localObject).p = this.p;
    ((ShortVideoUploadInfo)localObject).t = paramShortVideoReq.a;
    ((ShortVideoUploadInfo)localObject).s = paramObject;
    ((ShortVideoUploadInfo)localObject).k = this.q;
    ((ShortVideoUploadInfo)localObject).v = "";
    Logger.a(this.e, this.d, "createShortVideoUploadInfo", "");
    return localObject;
  }
  
  protected void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.g.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, PicInfoInterface.ErrInfo paramErrInfo)
  {
    ShortVideoResult localShortVideoResult = new ShortVideoResult();
    localShortVideoResult.c = this.b;
    localShortVideoResult.b = paramErrInfo;
    localShortVideoResult.a = -1;
    a(paramInt, -1, localShortVideoResult);
    if (paramErrInfo != null)
    {
      Logger.b(this.e, this.d, paramErrInfo.a, paramErrInfo.b);
      return;
    }
    Logger.b(this.e, this.d, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    Object localObject = paramShortVideoResult;
    if (paramShortVideoResult == null) {
      localObject = new ShortVideoResult();
    }
    ((ShortVideoResult)localObject).a = 0;
    ((ShortVideoResult)localObject).c = this.b;
    a(paramInt, 0, localObject);
    paramShortVideoResult = this.e;
    localObject = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("what:");
    localStringBuilder.append(paramInt);
    Logger.a(paramShortVideoResult, (String)localObject, "handleSuccess", localStringBuilder.toString());
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((IOrderMediaMsgService)this.a.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    Object localObject = this.e;
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resut:");
    localStringBuilder.append(paramSendResult);
    Logger.a((String)localObject, str, "updateMsg", localStringBuilder.toString());
    if (paramSendResult != null)
    {
      localObject = (MessageForShortVideo)this.f;
      ((MessageForShortVideo)localObject).videoFileSize = ((int)paramSendResult.e);
      ((MessageForShortVideo)localObject).uuid = paramSendResult.f;
      ((MessageForShortVideo)localObject).md5 = paramSendResult.g;
      ((MessageForShortVideo)localObject).serial();
      ((IMessageFacade)this.a.getRuntimeService(IMessageFacade.class)).updateMsgContentByUniseq(this.f.frienduin, this.f.istroop, this.f.uniseq, ((MessageForShortVideo)localObject).msgData);
    }
  }
  
  public void a(ShortVideoReq paramShortVideoReq)
  {
    this.b = paramShortVideoReq;
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.c = paramUiCallBack;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(ArrayList<ShortVideoForwardInfo> paramArrayList) {}
  
  public ShortVideoForwardInfo b(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return null;
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null)
    {
      a(2, null);
      return;
    }
    if (paramSendResult.a == 0)
    {
      a(paramSendResult);
      localObject = new ShortVideoResult();
      ((ShortVideoResult)localObject).a = 0;
      ((ShortVideoResult)localObject).d = paramSendResult;
      a(2, (ShortVideoResult)localObject);
      return;
    }
    Object localObject = new PicInfoInterface.ErrInfo();
    ((PicInfoInterface.ErrInfo)localObject).b = paramSendResult.c;
    a(2, (PicInfoInterface.ErrInfo)localObject);
  }
  
  public void b(ShortVideoForwardInfo paramShortVideoForwardInfo) {}
  
  public void b(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    Logger.a(this.e, this.d, "sendPic.start", "");
    c(paramShortVideoUploadInfo);
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DevShortVideoSendOperator
 * JD-Core Version:    0.7.0.1
 */