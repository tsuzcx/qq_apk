import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;

public class amhm
  extends AsyncTask<Void, Void, Integer>
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  int jdField_f_of_type_Int;
  String jdField_f_of_type_JavaLangString;
  String g;
  
  public amhm(Intent paramIntent)
  {
    this.jdField_b_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
    this.jdField_b_of_type_Long = paramIntent.getExtras().getLong("file_send_duration");
    this.jdField_a_of_type_Long = paramIntent.getExtras().getLong("file_send_size");
    this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("uin");
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("file_source");
    this.jdField_a_of_type_JavaLangString = paramIntent.getExtras().getString("activity_before_enter_send_video");
    this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("send_in_background");
    this.jdField_f_of_type_Int = paramIntent.getExtras().getInt("short_video_msg_tail_type");
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, " SendVideoTask(),  mVideoPath :" + this.jdField_b_of_type_JavaLangString + ", mDuration:" + this.jdField_b_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Long + ",mUin" + this.jdField_c_of_type_JavaLangString + ",mUinType:" + this.jdField_a_of_type_Int + ",mFileSource:" + this.jdField_d_of_type_JavaLangString + ",mSendBackground = " + this.jdField_a_of_type_Boolean + ",mMsgTailType=" + this.jdField_f_of_type_Int);
    }
  }
  
  /* Error */
  int a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: iconst_5
    //   1: istore_3
    //   2: aload_1
    //   3: ifnonnull +7 -> 10
    //   6: iload_3
    //   7: istore_2
    //   8: iload_2
    //   9: ireturn
    //   10: invokestatic 151	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   13: getstatic 157	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:lvcc	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   16: invokevirtual 160	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   19: ldc 162
    //   21: invokevirtual 165	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 7
    //   26: aload 7
    //   28: ifnull +193 -> 221
    //   31: aload 7
    //   33: invokevirtual 171	java/lang/String:length	()I
    //   36: ifle +185 -> 221
    //   39: aload 7
    //   41: ldc 173
    //   43: invokevirtual 177	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   46: astore 7
    //   48: aload 7
    //   50: ifnull +171 -> 221
    //   53: aload 7
    //   55: arraylength
    //   56: istore_2
    //   57: iload_2
    //   58: ifle +163 -> 221
    //   61: aload 7
    //   63: iconst_0
    //   64: aaload
    //   65: invokestatic 183	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   68: invokevirtual 186	java/lang/Integer:intValue	()I
    //   71: istore_2
    //   72: aload_1
    //   73: aload_0
    //   74: getfield 38	amhm:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   77: iload_2
    //   78: invokestatic 191	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   81: astore 7
    //   83: aload 7
    //   85: astore 8
    //   87: aload 7
    //   89: ifnonnull +30 -> 119
    //   92: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +11 -> 106
    //   98: ldc 97
    //   100: iconst_2
    //   101: ldc 193
    //   103: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_0
    //   107: getfield 197	amhm:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   110: ifnull +116 -> 226
    //   113: aload_0
    //   114: getfield 197	amhm:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   117: astore 8
    //   119: aload_0
    //   120: aload 8
    //   122: invokevirtual 202	android/graphics/Bitmap:getWidth	()I
    //   125: putfield 204	amhm:jdField_b_of_type_Int	I
    //   128: aload_0
    //   129: aload 8
    //   131: invokevirtual 207	android/graphics/Bitmap:getHeight	()I
    //   134: putfield 209	amhm:jdField_c_of_type_Int	I
    //   137: aload_0
    //   138: getfield 204	amhm:jdField_b_of_type_Int	I
    //   141: ifeq +10 -> 151
    //   144: aload_0
    //   145: getfield 209	amhm:jdField_c_of_type_Int	I
    //   148: ifne +116 -> 264
    //   151: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +11 -> 165
    //   157: ldc 97
    //   159: iconst_2
    //   160: ldc 211
    //   162: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: iconst_0
    //   166: ifeq +11 -> 177
    //   169: new 213	java/lang/NullPointerException
    //   172: dup
    //   173: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   176: athrow
    //   177: iconst_0
    //   178: ifeq +11 -> 189
    //   181: new 213	java/lang/NullPointerException
    //   184: dup
    //   185: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   188: athrow
    //   189: iconst_0
    //   190: ifeq +11 -> 201
    //   193: new 213	java/lang/NullPointerException
    //   196: dup
    //   197: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   200: athrow
    //   201: iconst_2
    //   202: ireturn
    //   203: astore 7
    //   205: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +13 -> 221
    //   211: ldc 97
    //   213: iconst_2
    //   214: ldc 216
    //   216: aload 7
    //   218: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: iconst_0
    //   222: istore_2
    //   223: goto -151 -> 72
    //   226: iconst_0
    //   227: ifeq +11 -> 238
    //   230: new 213	java/lang/NullPointerException
    //   233: dup
    //   234: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   237: athrow
    //   238: iconst_0
    //   239: ifeq +11 -> 250
    //   242: new 213	java/lang/NullPointerException
    //   245: dup
    //   246: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   249: athrow
    //   250: iconst_0
    //   251: ifeq +11 -> 262
    //   254: new 213	java/lang/NullPointerException
    //   257: dup
    //   258: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   261: athrow
    //   262: iconst_2
    //   263: ireturn
    //   264: new 99	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   271: ldc 221
    //   273: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   279: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   282: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: ldc 229
    //   287: invokestatic 230	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   290: astore 11
    //   292: new 99	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   299: invokestatic 232	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   302: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc 234
    //   307: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 239	bhmi:c	(Ljava/lang/String;)V
    //   316: new 241	java/io/File
    //   319: dup
    //   320: aload 11
    //   322: invokespecial 243	java/io/File:<init>	(Ljava/lang/String;)V
    //   325: astore 12
    //   327: new 241	java/io/File
    //   330: dup
    //   331: aload 12
    //   333: invokevirtual 246	java/io/File:getParent	()Ljava/lang/String;
    //   336: invokespecial 243	java/io/File:<init>	(Ljava/lang/String;)V
    //   339: astore 7
    //   341: aload 7
    //   343: invokevirtual 249	java/io/File:exists	()Z
    //   346: ifeq +11 -> 357
    //   349: aload 7
    //   351: invokevirtual 252	java/io/File:isDirectory	()Z
    //   354: ifne +9 -> 363
    //   357: aload 7
    //   359: invokevirtual 255	java/io/File:mkdirs	()Z
    //   362: pop
    //   363: aload 12
    //   365: invokevirtual 249	java/io/File:exists	()Z
    //   368: ifeq +11 -> 379
    //   371: aload 12
    //   373: invokevirtual 258	java/io/File:isFile	()Z
    //   376: ifne +9 -> 385
    //   379: aload 12
    //   381: invokevirtual 261	java/io/File:createNewFile	()Z
    //   384: pop
    //   385: new 263	java/io/BufferedOutputStream
    //   388: dup
    //   389: new 265	java/io/FileOutputStream
    //   392: dup
    //   393: aload 12
    //   395: invokespecial 268	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   398: invokespecial 271	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   401: astore 7
    //   403: aload 8
    //   405: getstatic 277	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   408: bipush 80
    //   410: aload 7
    //   412: invokevirtual 281	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   415: pop
    //   416: aload 7
    //   418: invokevirtual 284	java/io/BufferedOutputStream:flush	()V
    //   421: new 286	java/io/FileInputStream
    //   424: dup
    //   425: aload 12
    //   427: invokespecial 287	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   430: astore 8
    //   432: aload 7
    //   434: astore 10
    //   436: aload 8
    //   438: astore 9
    //   440: aload 12
    //   442: invokevirtual 289	java/io/File:length	()J
    //   445: lstore 5
    //   447: aload 7
    //   449: astore 10
    //   451: aload 8
    //   453: astore 9
    //   455: aload_0
    //   456: aload 8
    //   458: lload 5
    //   460: invokestatic 295	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   463: invokestatic 301	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   466: putfield 303	amhm:g	Ljava/lang/String;
    //   469: aload 7
    //   471: astore 10
    //   473: aload 8
    //   475: astore 9
    //   477: aload_0
    //   478: getfield 303	amhm:g	Ljava/lang/String;
    //   481: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   484: ifeq +93 -> 577
    //   487: aload 7
    //   489: astore 10
    //   491: aload 8
    //   493: astore 9
    //   495: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   498: ifeq +40 -> 538
    //   501: aload 7
    //   503: astore 10
    //   505: aload 8
    //   507: astore 9
    //   509: ldc 97
    //   511: iconst_2
    //   512: new 99	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   519: ldc_w 311
    //   522: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: aload_0
    //   526: getfield 303	amhm:g	Ljava/lang/String;
    //   529: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: iconst_0
    //   539: ifeq +11 -> 550
    //   542: new 213	java/lang/NullPointerException
    //   545: dup
    //   546: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   549: athrow
    //   550: aload 7
    //   552: ifnull +8 -> 560
    //   555: aload 7
    //   557: invokevirtual 314	java/io/BufferedOutputStream:close	()V
    //   560: iload_3
    //   561: istore_2
    //   562: aload 8
    //   564: ifnull -556 -> 8
    //   567: aload 8
    //   569: invokevirtual 315	java/io/FileInputStream:close	()V
    //   572: iconst_5
    //   573: ireturn
    //   574: astore_1
    //   575: iconst_5
    //   576: ireturn
    //   577: aload 7
    //   579: astore 10
    //   581: aload 8
    //   583: astore 9
    //   585: aload_0
    //   586: aload_0
    //   587: getfield 303	amhm:g	Ljava/lang/String;
    //   590: ldc 229
    //   592: invokestatic 230	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   595: putfield 317	amhm:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   598: aload 7
    //   600: astore 10
    //   602: aload 8
    //   604: astore 9
    //   606: aload 11
    //   608: aload_0
    //   609: getfield 317	amhm:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   612: invokestatic 320	bhmi:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   615: istore 4
    //   617: iload 4
    //   619: ifne +42 -> 661
    //   622: iconst_0
    //   623: ifeq +11 -> 634
    //   626: new 213	java/lang/NullPointerException
    //   629: dup
    //   630: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   633: athrow
    //   634: aload 7
    //   636: ifnull +8 -> 644
    //   639: aload 7
    //   641: invokevirtual 314	java/io/BufferedOutputStream:close	()V
    //   644: iload_3
    //   645: istore_2
    //   646: aload 8
    //   648: ifnull -640 -> 8
    //   651: aload 8
    //   653: invokevirtual 315	java/io/FileInputStream:close	()V
    //   656: iconst_5
    //   657: ireturn
    //   658: astore_1
    //   659: iconst_5
    //   660: ireturn
    //   661: aload 7
    //   663: astore 10
    //   665: aload 8
    //   667: astore 9
    //   669: aload_1
    //   670: lload 5
    //   672: invokestatic 326	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
    //   675: astore_1
    //   676: aload 7
    //   678: astore 10
    //   680: aload 8
    //   682: astore 9
    //   684: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   687: ifeq +37 -> 724
    //   690: aload 7
    //   692: astore 10
    //   694: aload 8
    //   696: astore 9
    //   698: ldc 97
    //   700: iconst_2
    //   701: new 99	java/lang/StringBuilder
    //   704: dup
    //   705: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   708: ldc_w 328
    //   711: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload_1
    //   715: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   724: aload 7
    //   726: astore 10
    //   728: aload 8
    //   730: astore 9
    //   732: aload_0
    //   733: getfield 46	amhm:jdField_b_of_type_Long	J
    //   736: lconst_0
    //   737: lcmp
    //   738: ifne +22 -> 760
    //   741: aload 7
    //   743: astore 10
    //   745: aload 8
    //   747: astore 9
    //   749: aload_0
    //   750: aload_0
    //   751: getfield 38	amhm:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   754: invokestatic 330	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)J
    //   757: putfield 46	amhm:jdField_b_of_type_Long	J
    //   760: iconst_0
    //   761: ifeq +11 -> 772
    //   764: new 213	java/lang/NullPointerException
    //   767: dup
    //   768: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   771: athrow
    //   772: aload 7
    //   774: ifnull +8 -> 782
    //   777: aload 7
    //   779: invokevirtual 314	java/io/BufferedOutputStream:close	()V
    //   782: aload 8
    //   784: ifnull +8 -> 792
    //   787: aload 8
    //   789: invokevirtual 315	java/io/FileInputStream:close	()V
    //   792: iconst_1
    //   793: ireturn
    //   794: astore_1
    //   795: aconst_null
    //   796: astore 7
    //   798: aconst_null
    //   799: astore 8
    //   801: aload 7
    //   803: astore 10
    //   805: aload 8
    //   807: astore 9
    //   809: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   812: ifeq +21 -> 833
    //   815: aload 7
    //   817: astore 10
    //   819: aload 8
    //   821: astore 9
    //   823: ldc 97
    //   825: iconst_2
    //   826: ldc_w 332
    //   829: aload_1
    //   830: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   833: iconst_3
    //   834: istore_2
    //   835: iconst_0
    //   836: ifeq +11 -> 847
    //   839: new 213	java/lang/NullPointerException
    //   842: dup
    //   843: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   846: athrow
    //   847: aload 7
    //   849: ifnull +8 -> 857
    //   852: aload 7
    //   854: invokevirtual 314	java/io/BufferedOutputStream:close	()V
    //   857: aload 8
    //   859: ifnull -851 -> 8
    //   862: aload 8
    //   864: invokevirtual 315	java/io/FileInputStream:close	()V
    //   867: iconst_3
    //   868: ireturn
    //   869: astore_1
    //   870: iconst_3
    //   871: ireturn
    //   872: astore 8
    //   874: aconst_null
    //   875: astore 7
    //   877: aconst_null
    //   878: astore_1
    //   879: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq +14 -> 896
    //   885: ldc 97
    //   887: iconst_2
    //   888: ldc_w 332
    //   891: aload 8
    //   893: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   896: iconst_0
    //   897: ifeq +11 -> 908
    //   900: new 213	java/lang/NullPointerException
    //   903: dup
    //   904: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   907: athrow
    //   908: aload 7
    //   910: ifnull +8 -> 918
    //   913: aload 7
    //   915: invokevirtual 314	java/io/BufferedOutputStream:close	()V
    //   918: iload_3
    //   919: istore_2
    //   920: aload_1
    //   921: ifnull -913 -> 8
    //   924: aload_1
    //   925: invokevirtual 315	java/io/FileInputStream:close	()V
    //   928: iconst_5
    //   929: ireturn
    //   930: astore_1
    //   931: iconst_5
    //   932: ireturn
    //   933: astore_1
    //   934: aconst_null
    //   935: astore 7
    //   937: aconst_null
    //   938: astore 8
    //   940: aload 7
    //   942: astore 10
    //   944: aload 8
    //   946: astore 9
    //   948: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   951: ifeq +21 -> 972
    //   954: aload 7
    //   956: astore 10
    //   958: aload 8
    //   960: astore 9
    //   962: ldc 97
    //   964: iconst_2
    //   965: ldc_w 334
    //   968: aload_1
    //   969: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   972: iconst_4
    //   973: istore_2
    //   974: iconst_0
    //   975: ifeq +11 -> 986
    //   978: new 213	java/lang/NullPointerException
    //   981: dup
    //   982: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   985: athrow
    //   986: aload 7
    //   988: ifnull +8 -> 996
    //   991: aload 7
    //   993: invokevirtual 314	java/io/BufferedOutputStream:close	()V
    //   996: aload 8
    //   998: ifnull -990 -> 8
    //   1001: aload 8
    //   1003: invokevirtual 315	java/io/FileInputStream:close	()V
    //   1006: iconst_4
    //   1007: ireturn
    //   1008: astore_1
    //   1009: iconst_4
    //   1010: ireturn
    //   1011: astore_1
    //   1012: aconst_null
    //   1013: astore 7
    //   1015: aconst_null
    //   1016: astore 9
    //   1018: iconst_0
    //   1019: ifeq +11 -> 1030
    //   1022: new 213	java/lang/NullPointerException
    //   1025: dup
    //   1026: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   1029: athrow
    //   1030: aload 7
    //   1032: ifnull +8 -> 1040
    //   1035: aload 7
    //   1037: invokevirtual 314	java/io/BufferedOutputStream:close	()V
    //   1040: aload 9
    //   1042: ifnull +8 -> 1050
    //   1045: aload 9
    //   1047: invokevirtual 315	java/io/FileInputStream:close	()V
    //   1050: aload_1
    //   1051: athrow
    //   1052: astore_1
    //   1053: goto -815 -> 238
    //   1056: astore_1
    //   1057: goto -807 -> 250
    //   1060: astore_1
    //   1061: goto -799 -> 262
    //   1064: astore_1
    //   1065: goto -888 -> 177
    //   1068: astore_1
    //   1069: goto -880 -> 189
    //   1072: astore_1
    //   1073: goto -872 -> 201
    //   1076: astore_1
    //   1077: goto -527 -> 550
    //   1080: astore_1
    //   1081: goto -521 -> 560
    //   1084: astore_1
    //   1085: goto -451 -> 634
    //   1088: astore_1
    //   1089: goto -445 -> 644
    //   1092: astore_1
    //   1093: goto -321 -> 772
    //   1096: astore_1
    //   1097: goto -315 -> 782
    //   1100: astore_1
    //   1101: goto -309 -> 792
    //   1104: astore_1
    //   1105: goto -258 -> 847
    //   1108: astore_1
    //   1109: goto -252 -> 857
    //   1112: astore 8
    //   1114: goto -206 -> 908
    //   1117: astore 7
    //   1119: goto -201 -> 918
    //   1122: astore_1
    //   1123: goto -137 -> 986
    //   1126: astore_1
    //   1127: goto -131 -> 996
    //   1130: astore 8
    //   1132: goto -102 -> 1030
    //   1135: astore 7
    //   1137: goto -97 -> 1040
    //   1140: astore 7
    //   1142: goto -92 -> 1050
    //   1145: astore_1
    //   1146: aconst_null
    //   1147: astore 9
    //   1149: goto -131 -> 1018
    //   1152: astore_1
    //   1153: aload 10
    //   1155: astore 7
    //   1157: goto -139 -> 1018
    //   1160: astore 8
    //   1162: aload_1
    //   1163: astore 9
    //   1165: aload 8
    //   1167: astore_1
    //   1168: goto -150 -> 1018
    //   1171: astore_1
    //   1172: aconst_null
    //   1173: astore 8
    //   1175: goto -235 -> 940
    //   1178: astore_1
    //   1179: goto -239 -> 940
    //   1182: astore 8
    //   1184: aconst_null
    //   1185: astore_1
    //   1186: goto -307 -> 879
    //   1189: astore 9
    //   1191: aload 8
    //   1193: astore_1
    //   1194: aload 9
    //   1196: astore 8
    //   1198: goto -319 -> 879
    //   1201: astore_1
    //   1202: aconst_null
    //   1203: astore 8
    //   1205: goto -404 -> 801
    //   1208: astore_1
    //   1209: goto -408 -> 801
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1212	0	this	amhm
    //   0	1212	1	paramContext	android.content.Context
    //   7	967	2	i	int
    //   1	918	3	j	int
    //   615	3	4	bool	boolean
    //   445	226	5	l	long
    //   24	64	7	localObject1	java.lang.Object
    //   203	14	7	localNumberFormatException	java.lang.NumberFormatException
    //   339	697	7	localObject2	java.lang.Object
    //   1117	1	7	localIOException1	java.io.IOException
    //   1135	1	7	localIOException2	java.io.IOException
    //   1140	1	7	localIOException3	java.io.IOException
    //   1155	1	7	localObject3	java.lang.Object
    //   85	778	8	localObject4	java.lang.Object
    //   872	20	8	localException1	Exception
    //   938	64	8	localObject5	java.lang.Object
    //   1112	1	8	localIOException4	java.io.IOException
    //   1130	1	8	localIOException5	java.io.IOException
    //   1160	6	8	localObject6	java.lang.Object
    //   1173	1	8	localObject7	java.lang.Object
    //   1182	10	8	localException2	Exception
    //   1196	8	8	localObject8	java.lang.Object
    //   438	726	9	localObject9	java.lang.Object
    //   1189	6	9	localException3	Exception
    //   434	720	10	localObject10	java.lang.Object
    //   290	317	11	str	String
    //   325	116	12	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   61	72	203	java/lang/NumberFormatException
    //   567	572	574	java/io/IOException
    //   651	656	658	java/io/IOException
    //   10	26	794	java/io/IOException
    //   31	48	794	java/io/IOException
    //   53	57	794	java/io/IOException
    //   61	72	794	java/io/IOException
    //   72	83	794	java/io/IOException
    //   92	106	794	java/io/IOException
    //   106	119	794	java/io/IOException
    //   119	151	794	java/io/IOException
    //   151	165	794	java/io/IOException
    //   205	221	794	java/io/IOException
    //   264	357	794	java/io/IOException
    //   357	363	794	java/io/IOException
    //   363	379	794	java/io/IOException
    //   379	385	794	java/io/IOException
    //   385	403	794	java/io/IOException
    //   862	867	869	java/io/IOException
    //   10	26	872	java/lang/Exception
    //   31	48	872	java/lang/Exception
    //   53	57	872	java/lang/Exception
    //   61	72	872	java/lang/Exception
    //   72	83	872	java/lang/Exception
    //   92	106	872	java/lang/Exception
    //   106	119	872	java/lang/Exception
    //   119	151	872	java/lang/Exception
    //   151	165	872	java/lang/Exception
    //   205	221	872	java/lang/Exception
    //   264	357	872	java/lang/Exception
    //   357	363	872	java/lang/Exception
    //   363	379	872	java/lang/Exception
    //   379	385	872	java/lang/Exception
    //   385	403	872	java/lang/Exception
    //   924	928	930	java/io/IOException
    //   10	26	933	java/lang/OutOfMemoryError
    //   31	48	933	java/lang/OutOfMemoryError
    //   53	57	933	java/lang/OutOfMemoryError
    //   61	72	933	java/lang/OutOfMemoryError
    //   72	83	933	java/lang/OutOfMemoryError
    //   92	106	933	java/lang/OutOfMemoryError
    //   106	119	933	java/lang/OutOfMemoryError
    //   119	151	933	java/lang/OutOfMemoryError
    //   151	165	933	java/lang/OutOfMemoryError
    //   205	221	933	java/lang/OutOfMemoryError
    //   264	357	933	java/lang/OutOfMemoryError
    //   357	363	933	java/lang/OutOfMemoryError
    //   363	379	933	java/lang/OutOfMemoryError
    //   379	385	933	java/lang/OutOfMemoryError
    //   385	403	933	java/lang/OutOfMemoryError
    //   1001	1006	1008	java/io/IOException
    //   10	26	1011	finally
    //   31	48	1011	finally
    //   53	57	1011	finally
    //   61	72	1011	finally
    //   72	83	1011	finally
    //   92	106	1011	finally
    //   106	119	1011	finally
    //   119	151	1011	finally
    //   151	165	1011	finally
    //   205	221	1011	finally
    //   264	357	1011	finally
    //   357	363	1011	finally
    //   363	379	1011	finally
    //   379	385	1011	finally
    //   385	403	1011	finally
    //   230	238	1052	java/io/IOException
    //   242	250	1056	java/io/IOException
    //   254	262	1060	java/io/IOException
    //   169	177	1064	java/io/IOException
    //   181	189	1068	java/io/IOException
    //   193	201	1072	java/io/IOException
    //   542	550	1076	java/io/IOException
    //   555	560	1080	java/io/IOException
    //   626	634	1084	java/io/IOException
    //   639	644	1088	java/io/IOException
    //   764	772	1092	java/io/IOException
    //   777	782	1096	java/io/IOException
    //   787	792	1100	java/io/IOException
    //   839	847	1104	java/io/IOException
    //   852	857	1108	java/io/IOException
    //   900	908	1112	java/io/IOException
    //   913	918	1117	java/io/IOException
    //   978	986	1122	java/io/IOException
    //   991	996	1126	java/io/IOException
    //   1022	1030	1130	java/io/IOException
    //   1035	1040	1135	java/io/IOException
    //   1045	1050	1140	java/io/IOException
    //   403	432	1145	finally
    //   440	447	1152	finally
    //   455	469	1152	finally
    //   477	487	1152	finally
    //   495	501	1152	finally
    //   509	538	1152	finally
    //   585	598	1152	finally
    //   606	617	1152	finally
    //   669	676	1152	finally
    //   684	690	1152	finally
    //   698	724	1152	finally
    //   732	741	1152	finally
    //   749	760	1152	finally
    //   809	815	1152	finally
    //   823	833	1152	finally
    //   948	954	1152	finally
    //   962	972	1152	finally
    //   879	896	1160	finally
    //   403	432	1171	java/lang/OutOfMemoryError
    //   440	447	1178	java/lang/OutOfMemoryError
    //   455	469	1178	java/lang/OutOfMemoryError
    //   477	487	1178	java/lang/OutOfMemoryError
    //   495	501	1178	java/lang/OutOfMemoryError
    //   509	538	1178	java/lang/OutOfMemoryError
    //   585	598	1178	java/lang/OutOfMemoryError
    //   606	617	1178	java/lang/OutOfMemoryError
    //   669	676	1178	java/lang/OutOfMemoryError
    //   684	690	1178	java/lang/OutOfMemoryError
    //   698	724	1178	java/lang/OutOfMemoryError
    //   732	741	1178	java/lang/OutOfMemoryError
    //   749	760	1178	java/lang/OutOfMemoryError
    //   403	432	1182	java/lang/Exception
    //   440	447	1189	java/lang/Exception
    //   455	469	1189	java/lang/Exception
    //   477	487	1189	java/lang/Exception
    //   495	501	1189	java/lang/Exception
    //   509	538	1189	java/lang/Exception
    //   585	598	1189	java/lang/Exception
    //   606	617	1189	java/lang/Exception
    //   669	676	1189	java/lang/Exception
    //   684	690	1189	java/lang/Exception
    //   698	724	1189	java/lang/Exception
    //   732	741	1189	java/lang/Exception
    //   749	760	1189	java/lang/Exception
    //   403	432	1201	java/io/IOException
    //   440	447	1208	java/io/IOException
    //   455	469	1208	java/io/IOException
    //   477	487	1208	java/io/IOException
    //   495	501	1208	java/io/IOException
    //   509	538	1208	java/io/IOException
    //   585	598	1208	java/io/IOException
    //   606	617	1208	java/io/IOException
    //   669	676	1208	java/io/IOException
    //   684	690	1208	java/io/IOException
    //   698	724	1208	java/io/IOException
    //   732	741	1208	java/io/IOException
    //   749	760	1208	java/io/IOException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a(BaseApplicationImpl.getApplication()));
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    switch (paramInteger.intValue())
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      return;
    }
    paramInteger = new Intent();
    try
    {
      this.jdField_e_of_type_JavaLangString = bhml.a(MD5.toMD5Byte(new FileInputStream(this.jdField_b_of_type_JavaLangString), this.jdField_a_of_type_Long));
      paramInteger.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      paramInteger.putExtra("uintype", this.jdField_a_of_type_Int);
      paramInteger.putExtra("file_send_path", this.jdField_b_of_type_JavaLangString);
      paramInteger.putExtra("file_send_size", this.jdField_a_of_type_Long);
      paramInteger.putExtra("file_send_duration", (int)(this.jdField_b_of_type_Long / 1000L));
      paramInteger.putExtra("file_source", this.jdField_d_of_type_JavaLangString);
      paramInteger.putExtra("thumbfile_send_path", this.jdField_f_of_type_JavaLangString);
      paramInteger.putExtra("file_shortvideo_md5", this.jdField_e_of_type_JavaLangString);
      paramInteger.putExtra("thumbfile_send_width", this.jdField_b_of_type_Int);
      paramInteger.putExtra("thumbfile_send_height", this.jdField_c_of_type_Int);
      paramInteger.putExtra("thumbfile_md5", this.g);
      paramInteger.putExtra("file_width", this.jdField_d_of_type_Int);
      paramInteger.putExtra("file_height", this.jdField_e_of_type_Int);
      paramInteger.putExtra("short_video_msg_tail_type", this.jdField_f_of_type_Int);
      paramInteger.putExtra("file_send_business_type", 0);
      bcxn localbcxn = bcwu.a(0, 0);
      localbcxn.a(bcwu.a(0, paramInteger, localbcxn));
      bcwu.a(localbcxn, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SendVideoActivity", 2, "", localException);
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhm
 * JD-Core Version:    0.7.0.1
 */