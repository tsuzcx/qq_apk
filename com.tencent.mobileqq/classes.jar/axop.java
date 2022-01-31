import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.netprobe.MtuProbe;
import com.tencent.mobileqq.highway.netprobe.PingProbe;
import com.tencent.mobileqq.highway.netprobe.ProbeChain;
import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.highway.netprobe.ProbeRequest;
import com.tencent.mobileqq.highway.netprobe.ProbeTask;
import com.tencent.mobileqq.highway.netprobe.TracerouteProbe;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;

public class axop
  extends axoo
  implements axru
{
  public static WeakNetLearner a;
  private static final Pattern a;
  protected axvw a;
  protected byte[] a;
  protected byte[] b;
  protected int c;
  private ArrayList<String> c;
  protected boolean c;
  protected boolean d;
  protected String e;
  protected boolean e;
  protected String f;
  protected boolean f;
  protected boolean g;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner = new WeakNetLearner(BaseApplication.getContext(), new axoq());
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(".*//[^/]*/[^/]*/(.*)/.*");
  }
  
  public axop(axvo paramaxvo, axvt paramaxvt)
  {
    super(paramaxvo, paramaxvt);
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
    f();
  }
  
  private boolean a(axsq paramaxsq)
  {
    if (paramaxsq != null) {
      try
      {
        if (paramaxsq.jdField_a_of_type_Axsp.jdField_c_of_type_JavaLangString != null)
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramaxsq.jdField_a_of_type_Axsp.jdField_c_of_type_JavaLangString, localOptions);
          if (localOptions.outHeight > 0)
          {
            int i = localOptions.outWidth;
            if (i > 0) {}
          }
          else
          {
            return false;
          }
        }
      }
      catch (Throwable paramaxsq)
      {
        paramaxsq.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private void b(axsq paramaxsq)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore_3
    //   14: iconst_2
    //   15: newarray byte
    //   17: astore 10
    //   19: aload 10
    //   21: dup
    //   22: iconst_0
    //   23: ldc 124
    //   25: bastore
    //   26: dup
    //   27: iconst_1
    //   28: ldc 125
    //   30: bastore
    //   31: pop
    //   32: aload_1
    //   33: getfield 93	axsq:jdField_a_of_type_Axsp	Laxsp;
    //   36: ifnull +74 -> 110
    //   39: aload_1
    //   40: getfield 93	axsq:jdField_a_of_type_Axsp	Laxsp;
    //   43: getfield 127	axsp:d	Ljava/lang/String;
    //   46: ifnull +64 -> 110
    //   49: aload_1
    //   50: getfield 93	axsq:jdField_a_of_type_Axsp	Laxsp;
    //   53: getfield 127	axsp:d	Ljava/lang/String;
    //   56: invokevirtual 133	java/lang/String:length	()I
    //   59: ifeq +51 -> 110
    //   62: aload_1
    //   63: getfield 93	axsq:jdField_a_of_type_Axsp	Laxsp;
    //   66: getfield 97	axsp:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   69: ifnull +41 -> 110
    //   72: aload_1
    //   73: getfield 93	axsq:jdField_a_of_type_Axsp	Laxsp;
    //   76: getfield 97	axsp:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   79: invokevirtual 133	java/lang/String:length	()I
    //   82: ifeq +28 -> 110
    //   85: aload_1
    //   86: getfield 93	axsq:jdField_a_of_type_Axsp	Laxsp;
    //   89: getfield 127	axsp:d	Ljava/lang/String;
    //   92: astore 9
    //   94: aload_1
    //   95: getfield 93	axsq:jdField_a_of_type_Axsp	Laxsp;
    //   98: getfield 97	axsp:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   101: astore 8
    //   103: aload_0
    //   104: getfield 136	axop:jdField_a_of_type_Axvt	Laxvt;
    //   107: ifnonnull +4 -> 111
    //   110: return
    //   111: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +99 -> 213
    //   117: aload_0
    //   118: getfield 136	axop:jdField_a_of_type_Axvt	Laxvt;
    //   121: getfield 146	axvt:jdField_a_of_type_Int	I
    //   124: aload_0
    //   125: getfield 136	axop:jdField_a_of_type_Axvt	Laxvt;
    //   128: getfield 148	axvt:jdField_a_of_type_Boolean	Z
    //   131: aload_0
    //   132: getfield 136	axop:jdField_a_of_type_Axvt	Laxvt;
    //   135: getfield 150	axvt:jdField_b_of_type_Int	I
    //   138: aload_0
    //   139: getfield 136	axop:jdField_a_of_type_Axvt	Laxvt;
    //   142: getfield 153	axvt:jdField_a_of_type_Long	J
    //   145: invokestatic 157	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   148: ldc 159
    //   150: new 161	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   157: ldc 164
    //   159: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 136	axop:jdField_a_of_type_Axvt	Laxvt;
    //   166: getfield 171	axvt:i	I
    //   169: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: ldc 176
    //   174: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: getfield 136	axop:jdField_a_of_type_Axvt	Laxvt;
    //   181: getfield 179	axvt:j	I
    //   184: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: ldc 181
    //   189: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 9
    //   194: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc 183
    //   199: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 8
    //   204: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 192	axub:a	(IZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 136	axop:jdField_a_of_type_Axvt	Laxvt;
    //   218: invokevirtual 195	axop:a	(Laxvt;)I
    //   221: istore_2
    //   222: iload_2
    //   223: iconst_4
    //   224: if_icmpne +453 -> 677
    //   227: new 161	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   234: aload 8
    //   236: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 197
    //   241: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: astore 6
    //   249: aload 8
    //   251: aload 6
    //   253: invokestatic 202	bace:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   256: pop
    //   257: new 204	java/io/File
    //   260: dup
    //   261: aload 6
    //   263: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   266: astore_1
    //   267: new 204	java/io/File
    //   270: dup
    //   271: aload 9
    //   273: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: astore 7
    //   278: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   281: ifeq +42 -> 323
    //   284: ldc 212
    //   286: iconst_4
    //   287: new 161	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   294: ldc 214
    //   296: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 7
    //   301: invokevirtual 217	java/io/File:length	()J
    //   304: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   307: ldc 222
    //   309: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload 8
    //   314: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_1
    //   324: invokevirtual 228	java/io/File:exists	()Z
    //   327: ifeq -217 -> 110
    //   330: aload 7
    //   332: invokevirtual 228	java/io/File:exists	()Z
    //   335: ifeq -225 -> 110
    //   338: new 230	java/io/RandomAccessFile
    //   341: dup
    //   342: aload_1
    //   343: ldc 232
    //   345: invokespecial 235	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   348: astore_1
    //   349: aload_1
    //   350: aload_0
    //   351: getfield 136	axop:jdField_a_of_type_Axvt	Laxvt;
    //   354: getfield 171	axvt:i	I
    //   357: i2l
    //   358: invokevirtual 239	java/io/RandomAccessFile:seek	(J)V
    //   361: new 241	java/io/FileInputStream
    //   364: dup
    //   365: aload 7
    //   367: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   370: astore 4
    //   372: sipush 1024
    //   375: newarray byte
    //   377: astore_3
    //   378: aload 4
    //   380: aload_3
    //   381: invokevirtual 248	java/io/FileInputStream:read	([B)I
    //   384: istore_2
    //   385: iload_2
    //   386: ifle +75 -> 461
    //   389: aload_1
    //   390: aload_3
    //   391: iconst_0
    //   392: iload_2
    //   393: invokevirtual 252	java/io/RandomAccessFile:write	([BII)V
    //   396: goto -18 -> 378
    //   399: astore_3
    //   400: aload_1
    //   401: astore_3
    //   402: aload 4
    //   404: astore_1
    //   405: aload_3
    //   406: ifnull +7 -> 413
    //   409: aload_3
    //   410: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   413: aload_1
    //   414: ifnull +7 -> 421
    //   417: aload_1
    //   418: invokevirtual 256	java/io/FileInputStream:close	()V
    //   421: aload 7
    //   423: invokevirtual 259	java/io/File:delete	()Z
    //   426: pop
    //   427: aload 6
    //   429: aload 8
    //   431: invokestatic 261	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   434: ifne -324 -> 110
    //   437: aload 6
    //   439: aload 8
    //   441: invokestatic 202	bace:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   444: ifeq +121 -> 565
    //   447: new 204	java/io/File
    //   450: dup
    //   451: aload 6
    //   453: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   456: invokevirtual 259	java/io/File:delete	()Z
    //   459: pop
    //   460: return
    //   461: aload_1
    //   462: ifnull +7 -> 469
    //   465: aload_1
    //   466: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   469: aload 4
    //   471: ifnull +8 -> 479
    //   474: aload 4
    //   476: invokevirtual 256	java/io/FileInputStream:close	()V
    //   479: aload 7
    //   481: invokevirtual 259	java/io/File:delete	()Z
    //   484: pop
    //   485: aload 6
    //   487: aload 8
    //   489: invokestatic 261	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   492: ifne -382 -> 110
    //   495: aload 6
    //   497: aload 8
    //   499: invokestatic 202	bace:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   502: ifeq +33 -> 535
    //   505: new 204	java/io/File
    //   508: dup
    //   509: aload 6
    //   511: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   514: invokevirtual 259	java/io/File:delete	()Z
    //   517: pop
    //   518: return
    //   519: astore_1
    //   520: aload_1
    //   521: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   524: goto -55 -> 469
    //   527: astore_1
    //   528: aload_1
    //   529: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   532: goto -53 -> 479
    //   535: new 204	java/io/File
    //   538: dup
    //   539: aload 6
    //   541: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   544: invokevirtual 259	java/io/File:delete	()Z
    //   547: pop
    //   548: return
    //   549: astore_3
    //   550: aload_3
    //   551: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   554: goto -141 -> 413
    //   557: astore_1
    //   558: aload_1
    //   559: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   562: goto -141 -> 421
    //   565: new 204	java/io/File
    //   568: dup
    //   569: aload 6
    //   571: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   574: invokevirtual 259	java/io/File:delete	()Z
    //   577: pop
    //   578: return
    //   579: astore_3
    //   580: aconst_null
    //   581: astore_1
    //   582: aload 5
    //   584: astore 4
    //   586: aload_1
    //   587: ifnull +7 -> 594
    //   590: aload_1
    //   591: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   594: aload 4
    //   596: ifnull +8 -> 604
    //   599: aload 4
    //   601: invokevirtual 256	java/io/FileInputStream:close	()V
    //   604: aload 7
    //   606: invokevirtual 259	java/io/File:delete	()Z
    //   609: pop
    //   610: aload 6
    //   612: aload 8
    //   614: invokestatic 261	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   617: ifne +26 -> 643
    //   620: aload 6
    //   622: aload 8
    //   624: invokestatic 202	bace:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   627: ifeq +34 -> 661
    //   630: new 204	java/io/File
    //   633: dup
    //   634: aload 6
    //   636: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   639: invokevirtual 259	java/io/File:delete	()Z
    //   642: pop
    //   643: aload_3
    //   644: athrow
    //   645: astore_1
    //   646: aload_1
    //   647: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   650: goto -56 -> 594
    //   653: astore_1
    //   654: aload_1
    //   655: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   658: goto -54 -> 604
    //   661: new 204	java/io/File
    //   664: dup
    //   665: aload 6
    //   667: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   670: invokevirtual 259	java/io/File:delete	()Z
    //   673: pop
    //   674: goto -31 -> 643
    //   677: iload_2
    //   678: iconst_2
    //   679: if_icmpne +231 -> 910
    //   682: new 204	java/io/File
    //   685: dup
    //   686: aload 9
    //   688: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   691: astore_1
    //   692: new 204	java/io/File
    //   695: dup
    //   696: aload 8
    //   698: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   701: astore_3
    //   702: aload_3
    //   703: invokevirtual 228	java/io/File:exists	()Z
    //   706: ifeq +8 -> 714
    //   709: aload_3
    //   710: invokevirtual 259	java/io/File:delete	()Z
    //   713: pop
    //   714: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   717: ifeq +42 -> 759
    //   720: ldc 212
    //   722: iconst_4
    //   723: new 161	java/lang/StringBuilder
    //   726: dup
    //   727: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   730: ldc_w 264
    //   733: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload_1
    //   737: invokevirtual 217	java/io/File:length	()J
    //   740: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   743: ldc 222
    //   745: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: aload 8
    //   750: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   759: aload_1
    //   760: invokevirtual 228	java/io/File:exists	()Z
    //   763: ifeq -653 -> 110
    //   766: new 230	java/io/RandomAccessFile
    //   769: dup
    //   770: aload_1
    //   771: ldc 232
    //   773: invokespecial 235	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   776: astore_3
    //   777: aload_3
    //   778: aload_3
    //   779: invokevirtual 265	java/io/RandomAccessFile:length	()J
    //   782: invokevirtual 239	java/io/RandomAccessFile:seek	(J)V
    //   785: aload_3
    //   786: aload 10
    //   788: invokevirtual 268	java/io/RandomAccessFile:write	([B)V
    //   791: aload_3
    //   792: ifnull +7 -> 799
    //   795: aload_3
    //   796: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   799: aload 9
    //   801: aload 8
    //   803: invokestatic 261	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   806: ifne -696 -> 110
    //   809: aload 9
    //   811: aload 8
    //   813: invokestatic 202	bace:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   816: ifeq +17 -> 833
    //   819: new 204	java/io/File
    //   822: dup
    //   823: aload 9
    //   825: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   828: invokevirtual 259	java/io/File:delete	()Z
    //   831: pop
    //   832: return
    //   833: new 204	java/io/File
    //   836: dup
    //   837: aload 9
    //   839: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   842: invokevirtual 259	java/io/File:delete	()Z
    //   845: pop
    //   846: return
    //   847: astore_1
    //   848: aload 7
    //   850: astore_3
    //   851: aload_3
    //   852: ifnull +7 -> 859
    //   855: aload_3
    //   856: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   859: aload 9
    //   861: aload 8
    //   863: invokestatic 261	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   866: ifne +26 -> 892
    //   869: aload 9
    //   871: aload 8
    //   873: invokestatic 202	bace:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   876: ifeq +18 -> 894
    //   879: new 204	java/io/File
    //   882: dup
    //   883: aload 9
    //   885: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   888: invokevirtual 259	java/io/File:delete	()Z
    //   891: pop
    //   892: aload_1
    //   893: athrow
    //   894: new 204	java/io/File
    //   897: dup
    //   898: aload 9
    //   900: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   903: invokevirtual 259	java/io/File:delete	()Z
    //   906: pop
    //   907: goto -15 -> 892
    //   910: iload_2
    //   911: iconst_3
    //   912: if_icmpne -802 -> 110
    //   915: new 161	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   922: aload 8
    //   924: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: ldc 197
    //   929: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   935: astore 7
    //   937: aload 8
    //   939: aload 7
    //   941: invokestatic 202	bace:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   944: pop
    //   945: new 204	java/io/File
    //   948: dup
    //   949: aload 7
    //   951: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   954: astore_1
    //   955: new 204	java/io/File
    //   958: dup
    //   959: aload 9
    //   961: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   964: astore 9
    //   966: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   969: ifeq +43 -> 1012
    //   972: ldc 212
    //   974: iconst_4
    //   975: new 161	java/lang/StringBuilder
    //   978: dup
    //   979: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   982: ldc_w 270
    //   985: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: aload 9
    //   990: invokevirtual 217	java/io/File:length	()J
    //   993: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   996: ldc 222
    //   998: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: aload 8
    //   1003: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1009: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1012: aload_1
    //   1013: invokevirtual 228	java/io/File:exists	()Z
    //   1016: ifeq -906 -> 110
    //   1019: aload 9
    //   1021: invokevirtual 228	java/io/File:exists	()Z
    //   1024: ifeq -914 -> 110
    //   1027: new 230	java/io/RandomAccessFile
    //   1030: dup
    //   1031: aload_1
    //   1032: ldc 232
    //   1034: invokespecial 235	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1037: astore_1
    //   1038: aload_1
    //   1039: aload_0
    //   1040: getfield 136	axop:jdField_a_of_type_Axvt	Laxvt;
    //   1043: getfield 171	axvt:i	I
    //   1046: i2l
    //   1047: invokevirtual 239	java/io/RandomAccessFile:seek	(J)V
    //   1050: new 241	java/io/FileInputStream
    //   1053: dup
    //   1054: aload 9
    //   1056: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1059: astore_3
    //   1060: sipush 1024
    //   1063: newarray byte
    //   1065: astore 4
    //   1067: aload_3
    //   1068: aload 4
    //   1070: invokevirtual 248	java/io/FileInputStream:read	([B)I
    //   1073: istore_2
    //   1074: iload_2
    //   1075: ifle +72 -> 1147
    //   1078: aload_1
    //   1079: aload 4
    //   1081: iconst_0
    //   1082: iload_2
    //   1083: invokevirtual 252	java/io/RandomAccessFile:write	([BII)V
    //   1086: goto -19 -> 1067
    //   1089: astore 4
    //   1091: aload_1
    //   1092: ifnull +7 -> 1099
    //   1095: aload_1
    //   1096: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   1099: aload_3
    //   1100: ifnull +7 -> 1107
    //   1103: aload_3
    //   1104: invokevirtual 256	java/io/FileInputStream:close	()V
    //   1107: aload 9
    //   1109: invokevirtual 259	java/io/File:delete	()Z
    //   1112: pop
    //   1113: aload 7
    //   1115: aload 8
    //   1117: invokestatic 261	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1120: ifne -1010 -> 110
    //   1123: aload 7
    //   1125: aload 8
    //   1127: invokestatic 202	bace:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1130: ifeq +93 -> 1223
    //   1133: new 204	java/io/File
    //   1136: dup
    //   1137: aload 7
    //   1139: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   1142: invokevirtual 259	java/io/File:delete	()Z
    //   1145: pop
    //   1146: return
    //   1147: aload_1
    //   1148: aload 10
    //   1150: invokevirtual 268	java/io/RandomAccessFile:write	([B)V
    //   1153: aload_1
    //   1154: ifnull +7 -> 1161
    //   1157: aload_1
    //   1158: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   1161: aload_3
    //   1162: ifnull +7 -> 1169
    //   1165: aload_3
    //   1166: invokevirtual 256	java/io/FileInputStream:close	()V
    //   1169: aload 9
    //   1171: invokevirtual 259	java/io/File:delete	()Z
    //   1174: pop
    //   1175: aload 7
    //   1177: aload 8
    //   1179: invokestatic 261	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1182: ifne -1072 -> 110
    //   1185: aload 7
    //   1187: aload 8
    //   1189: invokestatic 202	bace:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1192: ifeq +17 -> 1209
    //   1195: new 204	java/io/File
    //   1198: dup
    //   1199: aload 7
    //   1201: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   1204: invokevirtual 259	java/io/File:delete	()Z
    //   1207: pop
    //   1208: return
    //   1209: new 204	java/io/File
    //   1212: dup
    //   1213: aload 7
    //   1215: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   1218: invokevirtual 259	java/io/File:delete	()Z
    //   1221: pop
    //   1222: return
    //   1223: new 204	java/io/File
    //   1226: dup
    //   1227: aload 7
    //   1229: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   1232: invokevirtual 259	java/io/File:delete	()Z
    //   1235: pop
    //   1236: return
    //   1237: astore_3
    //   1238: aconst_null
    //   1239: astore_1
    //   1240: aload 6
    //   1242: astore 4
    //   1244: aload_1
    //   1245: ifnull +7 -> 1252
    //   1248: aload_1
    //   1249: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   1252: aload 4
    //   1254: ifnull +8 -> 1262
    //   1257: aload 4
    //   1259: invokevirtual 256	java/io/FileInputStream:close	()V
    //   1262: aload 9
    //   1264: invokevirtual 259	java/io/File:delete	()Z
    //   1267: pop
    //   1268: aload 7
    //   1270: aload 8
    //   1272: invokestatic 261	bace:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1275: ifne +26 -> 1301
    //   1278: aload 7
    //   1280: aload 8
    //   1282: invokestatic 202	bace:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1285: ifeq +18 -> 1303
    //   1288: new 204	java/io/File
    //   1291: dup
    //   1292: aload 7
    //   1294: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   1297: invokevirtual 259	java/io/File:delete	()Z
    //   1300: pop
    //   1301: aload_3
    //   1302: athrow
    //   1303: new 204	java/io/File
    //   1306: dup
    //   1307: aload 7
    //   1309: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   1312: invokevirtual 259	java/io/File:delete	()Z
    //   1315: pop
    //   1316: goto -15 -> 1301
    //   1319: astore_1
    //   1320: goto -159 -> 1161
    //   1323: astore_1
    //   1324: goto -155 -> 1169
    //   1327: astore_1
    //   1328: goto -229 -> 1099
    //   1331: astore_1
    //   1332: goto -225 -> 1107
    //   1335: astore_1
    //   1336: goto -84 -> 1252
    //   1339: astore_1
    //   1340: goto -78 -> 1262
    //   1343: astore_3
    //   1344: aload 6
    //   1346: astore 4
    //   1348: goto -104 -> 1244
    //   1351: astore 5
    //   1353: aload_3
    //   1354: astore 4
    //   1356: aload 5
    //   1358: astore_3
    //   1359: goto -115 -> 1244
    //   1362: astore_1
    //   1363: aconst_null
    //   1364: astore_1
    //   1365: aload 4
    //   1367: astore_3
    //   1368: goto -277 -> 1091
    //   1371: astore_3
    //   1372: aload 4
    //   1374: astore_3
    //   1375: goto -284 -> 1091
    //   1378: astore_1
    //   1379: goto -528 -> 851
    //   1382: astore_3
    //   1383: aload 5
    //   1385: astore 4
    //   1387: goto -801 -> 586
    //   1390: astore_3
    //   1391: goto -805 -> 586
    //   1394: astore_1
    //   1395: aconst_null
    //   1396: astore_1
    //   1397: goto -992 -> 405
    //   1400: astore_3
    //   1401: aconst_null
    //   1402: astore 4
    //   1404: aload_1
    //   1405: astore_3
    //   1406: aload 4
    //   1408: astore_1
    //   1409: goto -1004 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1412	0	this	axop
    //   0	1412	1	paramaxsq	axsq
    //   221	862	2	i	int
    //   13	378	3	arrayOfByte1	byte[]
    //   399	1	3	localThrowable1	Throwable
    //   401	9	3	localaxsq1	axsq
    //   549	2	3	localIOException	IOException
    //   579	65	3	localObject1	Object
    //   701	465	3	localObject2	Object
    //   1237	65	3	localObject3	Object
    //   1343	11	3	localObject4	Object
    //   1358	10	3	localObject5	Object
    //   1371	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   1374	1	3	localObject6	Object
    //   1382	1	3	localObject7	Object
    //   1390	1	3	localObject8	Object
    //   1400	1	3	localThrowable2	Throwable
    //   1405	1	3	localaxsq2	axsq
    //   7	1073	4	localObject9	Object
    //   1089	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   1242	165	4	localObject10	Object
    //   1	582	5	localObject11	Object
    //   1351	33	5	localObject12	Object
    //   10	1335	6	str1	String
    //   4	1304	7	localObject13	Object
    //   101	1180	8	str2	String
    //   92	1171	9	localObject14	Object
    //   17	1132	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   372	378	399	java/lang/Throwable
    //   378	385	399	java/lang/Throwable
    //   389	396	399	java/lang/Throwable
    //   465	469	519	java/io/IOException
    //   474	479	527	java/io/IOException
    //   409	413	549	java/io/IOException
    //   417	421	557	java/io/IOException
    //   338	349	579	finally
    //   590	594	645	java/io/IOException
    //   599	604	653	java/io/IOException
    //   766	777	847	finally
    //   1060	1067	1089	java/io/FileNotFoundException
    //   1067	1074	1089	java/io/FileNotFoundException
    //   1078	1086	1089	java/io/FileNotFoundException
    //   1147	1153	1089	java/io/FileNotFoundException
    //   1027	1038	1237	finally
    //   1157	1161	1319	java/io/IOException
    //   1165	1169	1323	java/io/IOException
    //   1095	1099	1327	java/io/IOException
    //   1103	1107	1331	java/io/IOException
    //   1248	1252	1335	java/io/IOException
    //   1257	1262	1339	java/io/IOException
    //   1038	1060	1343	finally
    //   1060	1067	1351	finally
    //   1067	1074	1351	finally
    //   1078	1086	1351	finally
    //   1147	1153	1351	finally
    //   1027	1038	1362	java/io/FileNotFoundException
    //   1038	1060	1371	java/io/FileNotFoundException
    //   777	791	1378	finally
    //   349	372	1382	finally
    //   372	378	1390	finally
    //   378	385	1390	finally
    //   389	396	1390	finally
    //   338	349	1394	java/lang/Throwable
    //   349	372	1400	java/lang/Throwable
  }
  
  int a(axvt paramaxvt)
  {
    if (paramaxvt.i < 0) {}
    do
    {
      return 1;
      if (paramaxvt.i > 0)
      {
        if (paramaxvt.j > 0) {
          return 3;
        }
        return 4;
      }
    } while (paramaxvt.j <= 0);
    return 2;
  }
  
  public String a(String paramString)
  {
    String str2 = b(paramString);
    Cryptor localCryptor = new Cryptor();
    if (str2 != null)
    {
      String str1 = str2 + "&encrypt=";
      if (this.jdField_d_of_type_Boolean) {}
      for (str1 = str1 + "1";; str1 = str1 + "0") {
        return paramString.replace(str2, bakz.a(localCryptor.encrypt(str1.getBytes(), this.jdField_b_of_type_ArrayOfByte)));
      }
    }
    this.jdField_d_of_type_Boolean = false;
    return paramString;
  }
  
  protected String a(String paramString, int paramInt)
  {
    String str = "&rf=other";
    if (this.jdField_a_of_type_Axvt.g == 0)
    {
      str = "&rf=aio";
      str = "cldver=8.2.6.4370" + str;
      paramInt = paramString.indexOf("?");
      if (paramInt <= 0) {
        break label219;
      }
      if (paramString.length() != paramInt + 1) {
        break label136;
      }
      paramString = paramString.substring(0, paramInt + 1) + str;
    }
    for (;;)
    {
      return paramString + "&msgTime=" + this.jdField_a_of_type_Axvt.d;
      if (this.jdField_a_of_type_Axvt.g != 1) {
        break;
      }
      str = "&rf=naio";
      break;
      label136:
      paramInt = paramString.indexOf("#", paramInt);
      if (paramInt > -1)
      {
        paramString = paramString.substring(0, paramInt) + "&" + str + paramString.substring(paramInt);
      }
      else
      {
        paramString = paramString + "&" + str;
        continue;
        label219:
        paramString = paramString + "?" + str;
      }
    }
  }
  
  protected ArrayList<axuh> a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        axuh localaxuh = new axuh();
        localaxuh.jdField_a_of_type_JavaLangString = str;
        localaxuh.jdField_a_of_type_Int = d();
        localaxuh.jdField_a_of_type_Boolean = paramBoolean;
        localArrayList.add(localaxuh);
      }
    }
    return localArrayList;
  }
  
  public void a(axro paramaxro, String paramString)
  {
    if (this.jdField_e_of_type_Boolean)
    {
      paramaxro.jdField_a_of_type_JavaLangString = a(paramString);
      if (!paramString.equals(paramaxro.jdField_a_of_type_JavaLangString))
      {
        paramaxro.jdField_a_of_type_JavaUtilHashMap.put("Cookie", "ST=" + bakz.a(this.jdField_a_of_type_ArrayOfByte));
        if (this.jdField_d_of_type_Boolean)
        {
          PicCryptor localPicCryptor = new PicCryptor(this.jdField_b_of_type_ArrayOfByte);
          localPicCryptor.a = paramaxro;
          paramaxro.jdField_a_of_type_Axrq = localPicCryptor;
          paramaxro.d = (paramaxro.jdField_c_of_type_JavaLangString + "." + MD5.toMD5(axub.a(paramString, false)) + ".tmp");
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_f_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
      {
        paramaxro.d = (paramaxro.jdField_c_of_type_JavaLangString + "." + MD5.toMD5(axub.a(paramString, false)) + ".tmp");
        paramaxro.jdField_a_of_type_JavaLangString = (paramString + "&rollback=1");
      }
      return;
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public void a(axsq paramaxsq)
  {
    a(paramaxsq, false);
  }
  
  protected void a(axsq paramaxsq, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((this.jdField_a_of_type_Axsp instanceof axro))
    {
      localHashMap.put("file_url", ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
      axuh localaxuh = axub.a(((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
      if (localaxuh != null)
      {
        if ((!paramBoolean) && (localaxuh.jdField_a_of_type_JavaLangString != null))
        {
          if (this.jdField_c_of_type_JavaUtilArrayList.contains(localaxuh.jdField_a_of_type_JavaLangString)) {
            return;
          }
          this.jdField_c_of_type_JavaUtilArrayList.add(localaxuh.jdField_a_of_type_JavaLangString);
        }
        localHashMap.put("server_ip", localaxuh.jdField_a_of_type_JavaLangString);
        localHashMap.put("server_port", localaxuh.jdField_a_of_type_Int + "");
      }
    }
    localHashMap.put("transfer_type", "2");
    localHashMap.put("business_type", "1");
    localHashMap.put("http_errorCode", paramaxsq.jdField_c_of_type_Int + "");
    localHashMap.put("param_FailCode", String.valueOf(this.j));
    localHashMap.put("param_errorDesc", this.i);
    localHashMap.put("md5", this.jdField_a_of_type_Axvt.jdField_f_of_type_JavaLangString);
    localHashMap.put("uuid", this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString);
    localHashMap.put("chatType", this.jdField_a_of_type_Axvt.jdField_a_of_type_Int + "");
    localHashMap.put("chatUin", this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString + "");
    awrn.a(BaseApplication.getContext()).a(null, "actRichMediaNetMonitor_picDown", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Axvw.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0))
    {
      this.jdField_c_of_type_Int = 1;
      b(false);
      return;
    }
    ArrayList localArrayList = a(axwx.a().a(paramString, paramInt, true, 28), true);
    paramString = a(axwx.a().a(paramString, paramInt, true, 1), false);
    if (g()) {
      if (h()) {
        localArrayList.addAll(paramString);
      }
    }
    for (this.jdField_a_of_type_JavaUtilArrayList = localArrayList; (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0); this.jdField_a_of_type_JavaUtilArrayList = paramString)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_d_of_type_Axow.a();
      c(false);
      return;
    }
    this.jdField_c_of_type_Int = 2;
    b(false);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, HashMap<String, String> paramHashMap)
  {
    int i;
    String str;
    if (!paramBoolean)
    {
      i = this.j;
      if (this.j != -9527) {
        break label72;
      }
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
      if (str == null) {
        break label72;
      }
    }
    for (;;)
    {
      paramHashMap.put("param_detail_code", str);
      awrn.a(BaseApplication.getContext()).a(null, paramString, true, paramLong, this.jdField_a_of_type_Long, paramHashMap, null);
      return;
      label72:
      str = String.valueOf(i);
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 65537) {
      return true;
    }
    if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
    {
      long l1 = ((MessageForPic)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).size;
      long l2 = Runtime.getRuntime().totalMemory();
      l2 = Runtime.getRuntime().maxMemory() - (l2 - Runtime.getRuntime().freeMemory());
      if (l2 < l1)
      {
        QLog.e("BaseTransProcessor", 1, "checkMemoryForEncrypt : memory is not enough ! remainMemory = " + l2 + ", picSize = " + l1);
        return false;
      }
      if (l1 > 5242880L)
      {
        QLog.e("BaseTransProcessor", 1, "checkMemoryForEncrypt : pic too large, picSize = " + l1);
        return false;
      }
    }
    return true;
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return false;
  }
  
  public String b(String paramString)
  {
    paramString = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return null;
  }
  
  void b(boolean paramBoolean) {}
  
  void c(boolean paramBoolean) {}
  
  void d()
  {
    super.d();
    Object localObject1 = this.jdField_a_of_type_Axvt.jdField_a_of_type_Axwa;
    if (localObject1 != null)
    {
      ((axwa)localObject1).jdField_a_of_type_Int = -1;
      ((axwa)localObject1).jdField_a_of_type_Long = this.j;
      ((axwa)localObject1).jdField_a_of_type_JavaLangString = this.i;
      ((axwa)localObject1).jdField_a_of_type_Axvt = this.jdField_a_of_type_Axvt;
    }
    Object localObject4;
    try
    {
      if (this.jdField_a_of_type_Axqf != null) {
        this.jdField_a_of_type_Axqf.d = 2005;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (atpa)((Iterator)localObject1).next();
        atpb localatpb = new atpb();
        localatpb.jdField_a_of_type_Int = -1;
        localatpb.jdField_b_of_type_Int = this.j;
        localatpb.jdField_a_of_type_JavaLangString = this.i;
        ((atpa)localObject4).a(localatpb);
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "onError ");
        }
      }
      if (this.jdField_a_of_type_Axqf == null) {
        break label174;
      }
    }
    finally {}
    b("notify", "start");
    label174:
    notifyAll();
    if (this.jdField_a_of_type_Axqf != null) {
      b("notify", "end");
    }
    int i;
    if ((this.j == 9014) || (this.j == 9050))
    {
      Object localObject3 = axub.a(((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
      if (localObject3 != null)
      {
        localObject3 = ((axuh)localObject3).jdField_a_of_type_JavaLangString;
        localObject4 = new ProbeChain();
        if (this.j != 9014) {
          break label373;
        }
        ((ProbeChain)localObject4).addProbeItem(new PingProbe());
        ((ProbeChain)localObject4).addProbeItem(new MtuProbe());
        ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
        if (this.j != 9014) {
          break label400;
        }
        i = -1201;
        label308:
        localObject3 = new ProbeRequest((String)localObject3, i, (ProbeItem)localObject4);
        jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner.startProbe(new ProbeTask((ProbeRequest)localObject3));
      }
    }
    d(2005);
    if (this.jdField_a_of_type_Axvt != null)
    {
      if (!arnz.b(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        break label407;
      }
      arnz.a(String.valueOf(this.j), 3);
    }
    label373:
    while (!arnz.a(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
    {
      return;
      ((ProbeChain)localObject4).addProbeItem(new PingProbe());
      ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
      break;
      i = -1202;
      break label308;
    }
    label400:
    label407:
    arnz.a(String.valueOf(this.j), 2);
  }
  
  void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("big_thumb", 2, "onsuccess mUiRequest.mFileType" + this.jdField_a_of_type_Axvt.jdField_b_of_type_Int + "mUiRequest.mOutFilePath=" + this.jdField_a_of_type_Axvt.h + "url=" + ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
    }
    Object localObject1 = this.jdField_a_of_type_Axvt.jdField_a_of_type_Axwa;
    if (localObject1 != null)
    {
      ((axwa)localObject1).jdField_a_of_type_Int = 0;
      ((axwa)localObject1).jdField_a_of_type_Axvt = this.jdField_a_of_type_Axvt;
    }
    label1152:
    label1157:
    label1160:
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      label336:
      boolean bool;
      try
      {
        if (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int != 65537) {
          continue;
        }
        localObject1 = this.jdField_a_of_type_Axvt.h;
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        MessageForPic localMessageForPic;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PIC_TAG", 2, localThrowable.getMessage());
        continue;
        if (babp.d() < 240) {
          continue;
        }
        if (!(localObject4 instanceof MessageForMixedMsg)) {
          break label698;
        }
      }
      try
      {
        if (this.jdField_a_of_type_Axqf != null) {
          this.jdField_a_of_type_Axqf.d = 2003;
        }
        localObject1 = this.jdField_a_of_type_Axvt;
        if (((axvt)localObject1).m != null)
        {
          localObject4 = new File(((axvt)localObject1).m);
          if ((((File)localObject4).exists()) && (((File)localObject4).delete()) && (QLog.isDevelopLevel())) {
            QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():Delete " + ((axvt)localObject1).m);
          }
        }
        int i = a(this.jdField_a_of_type_Axvt);
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label1046;
        }
        localObject4 = (atpa)((Iterator)localObject1).next();
        localObject5 = new atpb();
        ((atpb)localObject5).jdField_a_of_type_Int = 0;
        ((atpb)localObject5).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Axvt.h;
        ((atpb)localObject5).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_f_of_type_JavaLangString;
        ((atpb)localObject5).jdField_c_of_type_Int = this.jdField_a_of_type_Axvt.jdField_b_of_type_Int;
        ((atpb)localObject5).d = this.jdField_a_of_type_Axvt.g;
        if (i == 2) {
          break label1152;
        }
        if (i != 3) {
          break label1041;
        }
      }
      finally {}
      ((atpb)localObject5).jdField_a_of_type_Boolean = bool;
      ((atpa)localObject4).a((atpb)localObject5);
      if ((this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 131075) && (QLog.isDevelopLevel())) {
        QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():" + this.jdField_a_of_type_Axvt.h + ", isPart " + ((atpb)localObject5).jdField_a_of_type_Boolean);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PIC_TAG", 2, "onSuccess ");
        continue;
        if (((this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 131075)) && (this.jdField_a_of_type_Axvt.h != null) && (this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
        {
          localObject4 = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (GifDrawable.isGifFile(new File(this.jdField_a_of_type_Axvt.h)))
          {
            if ((localObject4 != null) && ((localObject4 instanceof MessageForPic)))
            {
              localMessageForPic = (MessageForPic)localObject4;
              if (!localMessageForPic.checkGif())
              {
                localMessageForPic.imageType = 2000;
                localMessageForPic.updateMessage();
              }
            }
          }
          else
          {
            Object localObject3 = ((MessageForMixedMsg)localObject4).getSubMessage(this.jdField_a_of_type_Axvt.jdField_b_of_type_Long);
            for (;;)
            {
              if ((localObject3 != null) && ((localObject3 instanceof MessageForPic)))
              {
                localObject3 = (MessageForPic)localObject3;
                label623:
                if (localObject3 == null) {
                  break label1150;
                }
                if (((ajke.a((MessageRecord)localObject3)) || (ajhz.a((MessageRecord)localObject3))) && (!TextUtils.isEmpty(((MessageForPic)localObject3).md5)))
                {
                  localObject4 = this.jdField_a_of_type_Axvt.h + "_fp";
                  babo.a(this.jdField_a_of_type_Axvt.h, (String)localObject4, ((MessageForPic)localObject3).md5);
                  break;
                  label698:
                  localObject3 = localObject4;
                  if (!(localObject4 instanceof MessageForStructing)) {
                    continue;
                  }
                  localObject5 = (MessageForStructing)localObject4;
                  localObject3 = localObject4;
                  if (!(((MessageForStructing)localObject5).structingMsg instanceof StructMsgForImageShare)) {
                    continue;
                  }
                  localObject5 = ((StructMsgForImageShare)((MessageForStructing)localObject5).structingMsg).getFirstImageElement();
                  localObject3 = localObject4;
                  if (localObject5 == null) {
                    continue;
                  }
                  localObject3 = localObject4;
                  if (((awwr)localObject5).a == null) {
                    continue;
                  }
                  localObject3 = ((awwr)localObject5).a;
                  continue;
                }
                if (((MessageForPic)localObject3).fileSizeFlag != 1) {
                  break label1157;
                }
              }
            }
            for (bool = true;; bool = false)
            {
              if (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int != axwd.a("chatimg", bool)) {
                break label1160;
              }
              localObject5 = new CompressInfo(this.jdField_a_of_type_Axvt.h, 0);
              URL localURL = axwd.a((atqc)localObject3, 65537);
              ((CompressInfo)localObject5).jdField_f_of_type_Boolean = true;
              localObject4 = axoa.d(localURL.toString());
              if (((String)localObject4).endsWith("_hd")) {
                break;
              }
              if (((String)localObject4).endsWith("_big400"))
              {
                ((String)localObject4).replace("_big400", "_hd");
                label874:
                ((CompressInfo)localObject5).jdField_e_of_type_JavaLangString = ((String)localObject4);
                ((CompressInfo)localObject5).a = ((MessageForPic)localObject3).thumbWidthHeightDP;
                atqs.b((CompressInfo)localObject5);
                if (((CompressInfo)localObject5).jdField_e_of_type_JavaLangString == null) {
                  break;
                }
                localObject4 = new File((String)localObject4);
                if (!((CompressInfo)localObject5).jdField_e_of_type_JavaLangString.equals(((CompressInfo)localObject5).jdField_c_of_type_JavaLangString)) {
                  break label1142;
                }
              }
              label1041:
              label1046:
              label1121:
              label1142:
              for (bool = ew.a(new File(((CompressInfo)localObject5).jdField_c_of_type_JavaLangString), (File)localObject4);; bool = true)
              {
                if ((!bool) || (BaseApplicationImpl.sImageCache.get(localURL.toString()) == null)) {
                  break label1145;
                }
                BaseApplicationImpl.sImageCache.remove(localURL.toString());
                localObject4 = URLDrawable.getDrawable(localURL);
                if (localObject4 == null) {
                  break;
                }
                if (((MessageForPic)localObject3).thumbWidthHeightDP == null)
                {
                  ((URLDrawable)localObject4).downloadImediatly(true);
                  break;
                  localObject4 = (String)localObject4 + "_hd";
                  break label874;
                }
                ((URLDrawable)localObject4).invalidateSelf();
                break;
                bool = false;
                break label336;
                if (this.jdField_a_of_type_Axqf != null) {
                  b("notify", "start");
                }
                notifyAll();
                if (this.jdField_a_of_type_Axqf != null) {
                  b("notify", "end");
                }
                d(2003);
                if (this.jdField_a_of_type_Axvt != null)
                {
                  if (!arnz.b(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
                    break label1121;
                  }
                  arnz.a("0", 3);
                }
                while (!arnz.a(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
                  return;
                }
                arnz.a("0", 2);
                return;
              }
              label1145:
              break;
              localObject3 = null;
              break label623;
              label1150:
              break;
              bool = true;
              break label336;
            }
          }
        }
      }
    }
  }
  
  public void f()
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    this.jdField_b_of_type_ArrayOfByte = ((TicketManager)localObject).getStkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1600000226);
    this.jdField_a_of_type_ArrayOfByte = ((TicketManager)localObject).getSt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1600000226);
    subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf localDownloadEncryptConf = axpy.a().a();
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0) && (this.jdField_b_of_type_ArrayOfByte.length > 0) && (localDownloadEncryptConf != null))
    {
      this.jdField_e_of_type_Boolean = localDownloadEncryptConf.bool_enable_encrypt_request.get();
      this.jdField_d_of_type_Boolean = localDownloadEncryptConf.bool_enable_encrypted_pic.get();
      if (this.jdField_b_of_type_ArrayOfByte != null) {
        break label172;
      }
    }
    label172:
    for (localObject = "key or switch can't get!";; localObject = "STKey:" + MD5.toMD5(this.jdField_b_of_type_ArrayOfByte))
    {
      b("ticketInit", (String)localObject);
      if ((!a(localDownloadEncryptConf)) || (!jdField_b_of_type_Boolean))
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_e_of_type_Boolean = false;
      }
      return;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = false;
      break;
    }
  }
  
  public void onResp(axsq paramaxsq)
  {
    super.onResp(paramaxsq);
    Object localObject1 = new StringBuilder().append("directMsgUrlDown:").append(this.jdField_a_of_type_Boolean).append(" isEncrypt:");
    boolean bool;
    if ((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) {
      bool = true;
    }
    for (;;)
    {
      localObject1 = ((StringBuilder)localObject1).append(bool).append(" isRollBack:").append(this.jdField_f_of_type_Boolean).append(" result:");
      if (paramaxsq.jdField_a_of_type_Int == 0)
      {
        bool = true;
        label82:
        b("onHttpResp", bool);
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Axsp != null)) {
          QLog.d("big_thumb", 2, "onResp" + this.jdField_a_of_type_Axvt.jdField_b_of_type_Int + "mUiRequest.mOutFilePath=" + this.jdField_a_of_type_Axvt.h + "url=" + ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label421;
        }
        localObject1 = this.jdField_d_of_type_Axow;
        label190:
        if (paramaxsq.jdField_a_of_type_Int != 0) {
          break label429;
        }
        bool = true;
        label199:
        a((axow)localObject1, paramaxsq, bool);
        this.jdField_a_of_type_Long = paramaxsq.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long <= 0L) {
          this.jdField_a_of_type_Long = (paramaxsq.jdField_b_of_type_Long + paramaxsq.jdField_a_of_type_Axsp.jdField_a_of_type_Long);
        }
        this.jdField_b_of_type_Long += paramaxsq.jdField_c_of_type_Long;
        if ((paramaxsq.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Axsp != null) && (this.jdField_a_of_type_Axsp.j)) {}
      }
      try
      {
        b(paramaxsq);
        if (((this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) && (!a(paramaxsq)))
        {
          this.jdField_d_of_type_Boolean = false;
          this.jdField_e_of_type_Boolean = false;
          this.jdField_f_of_type_Boolean = true;
          if (this.jdField_a_of_type_Axsp != null) {
            this.jdField_f_of_type_JavaLangString = ("checkPicFormat Erro, erroCode:" + paramaxsq.jdField_b_of_type_Int + " ,erroDesc:" + paramaxsq.jdField_a_of_type_JavaLangString + " ,encryptUrl:" + ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString + " ,ST:" + bakz.a(this.jdField_a_of_type_ArrayOfByte));
          }
          b(true);
        }
        for (;;)
        {
          this.jdField_a_of_type_Axsp = null;
          return;
          bool = false;
          break;
          bool = false;
          break label82;
          label421:
          localObject1 = this.jdField_b_of_type_Axow;
          break label190;
          label429:
          bool = false;
          break label199;
          e();
          a(paramaxsq, true);
          continue;
          if ((paramaxsq.jdField_b_of_type_Int == 9364) && (this.l < 3))
          {
            b("[netChg]", "failed.but net change detect.so retry");
            this.jdField_c_of_type_Int = 4;
            this.jdField_e_of_type_JavaLangString = paramaxsq.jdField_a_of_type_JavaLangString;
            this.l += 1;
            m();
            b(false);
            return;
          }
          Object localObject2;
          if ((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean))
          {
            this.jdField_d_of_type_Boolean = false;
            this.jdField_e_of_type_Boolean = false;
            this.jdField_f_of_type_Boolean = true;
            if (paramaxsq.jdField_b_of_type_Int != -9527) {
              break label1021;
            }
            localObject1 = (String)paramaxsq.jdField_a_of_type_JavaUtilHashMap.get(bakw.jdField_f_of_type_JavaLangString);
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).split("_").length < 3)) {
              break label1132;
            }
            Object localObject3 = ((String)localObject1).split("_");
            localObject1 = localObject3[0];
            localObject2 = localObject3[1];
            localObject3 = localObject3[2];
            if ((!"H".equals(localObject1)) || (!"400".equals(localObject2)) || (!((String)localObject3).equals("-106")) || (!this.jdField_d_of_type_Boolean)) {
              break label1132;
            }
            bool = true;
            if (this.jdField_a_of_type_Axsp != null)
            {
              if ("encryptReqError=" + bool + ", ResErroCode:" + paramaxsq.jdField_b_of_type_Int + " ,erroDesc:" + paramaxsq.jdField_a_of_type_JavaLangString + " ,encryptUrl:" + ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString != null) {
                break label1036;
              }
              localObject1 = "null";
              label726:
              this.jdField_f_of_type_JavaLangString = ((String)localObject1);
            }
          }
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_c_of_type_Int = 3;
            this.jdField_e_of_type_JavaLangString = paramaxsq.jdField_a_of_type_JavaLangString;
            if ((this instanceof axqv))
            {
              axpy.a().a().a(2);
              label768:
              if (!this.jdField_f_of_type_Boolean) {
                break label1099;
              }
              b(true);
              label780:
              localObject1 = new HashMap();
              ((HashMap)localObject1).put("param_FailCode", String.valueOf(paramaxsq.jdField_b_of_type_Int));
              ((HashMap)localObject1).put("param_errorDesc", paramaxsq.jdField_a_of_type_JavaLangString);
              if (this.jdField_a_of_type_Axsp != null) {
                ((HashMap)localObject1).put("param_url", ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
              }
              awrn.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Axvt.jdField_b_of_type_JavaLangString, "report_direct_download_fail", false, (System.nanoTime() - this.k) / 1000000L, this.jdField_a_of_type_Long, (HashMap)localObject1, "");
            }
          }
          for (;;)
          {
            localObject1 = new StringBuffer();
            ((StringBuffer)localObject1).append(this.jdField_a_of_type_Axvt.jdField_a_of_type_Int);
            ((StringBuffer)localObject1).append(" isMsgDown:");
            ((StringBuffer)localObject1).append(this.jdField_a_of_type_Boolean);
            ((StringBuffer)localObject1).append(" result:");
            ((StringBuffer)localObject1).append(paramaxsq.jdField_a_of_type_Int);
            ((StringBuffer)localObject1).append(" adr:");
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              break label1114;
            }
            paramaxsq = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (paramaxsq.hasNext())
            {
              localObject2 = (axuh)paramaxsq.next();
              try
              {
                ((StringBuffer)localObject1).append(baip.b(((axuh)localObject2).jdField_a_of_type_JavaLangString) + ",");
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
            label1021:
            if (paramaxsq.jdField_b_of_type_Int != 9058) {
              break label1132;
            }
            bool = true;
            break;
            label1036:
            localObject1 = ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString + " ,ST:" + bakz.a(this.jdField_a_of_type_ArrayOfByte);
            break label726;
            if (!(this instanceof axpb)) {
              break label768;
            }
            axpy.a().a().a(1);
            break label768;
            label1099:
            b(false);
            break label780;
            d();
          }
          label1114:
          QLog.d("BaseTransProcessor", 1, ((StringBuffer)localObject1).toString());
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          continue;
          label1132:
          bool = false;
        }
      }
    }
  }
  
  /* Error */
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc2_w 1028
    //   3: lload_2
    //   4: lmul
    //   5: lload 4
    //   7: ldiv
    //   8: l2i
    //   9: istore 6
    //   11: iload 6
    //   13: aload_0
    //   14: getfield 1030	axop:jdField_b_of_type_Int	I
    //   17: if_icmple +33 -> 50
    //   20: aload_0
    //   21: iload 6
    //   23: putfield 1030	axop:jdField_b_of_type_Int	I
    //   26: aload_0
    //   27: getfield 482	axop:jdField_a_of_type_Axvw	Laxvw;
    //   30: getfield 1033	axvw:jdField_a_of_type_ComTencentImageURLDrawableHandler	Lcom/tencent/image/URLDrawableHandler;
    //   33: ifnull +17 -> 50
    //   36: aload_0
    //   37: getfield 482	axop:jdField_a_of_type_Axvw	Laxvw;
    //   40: getfield 1033	axvw:jdField_a_of_type_ComTencentImageURLDrawableHandler	Lcom/tencent/image/URLDrawableHandler;
    //   43: iload 6
    //   45: invokeinterface 1038 2 0
    //   50: aload_0
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 600	axop:jdField_a_of_type_Axqf	Laxqf;
    //   56: ifnull +13 -> 69
    //   59: aload_0
    //   60: getfield 600	axop:jdField_a_of_type_Axqf	Laxqf;
    //   63: sipush 2002
    //   66: putfield 604	axqf:d	I
    //   69: iconst_0
    //   70: istore 10
    //   72: iconst_0
    //   73: istore 11
    //   75: iconst_0
    //   76: istore 9
    //   78: aload_0
    //   79: getfield 136	axop:jdField_a_of_type_Axvt	Laxvt;
    //   82: astore 13
    //   84: aload 13
    //   86: getfield 1040	axvt:k	I
    //   89: istore 7
    //   91: iload 9
    //   93: istore 8
    //   95: aload 13
    //   97: getfield 171	axvt:i	I
    //   100: ifne +248 -> 348
    //   103: iload 9
    //   105: istore 8
    //   107: iload 7
    //   109: ifle +239 -> 348
    //   112: iload 9
    //   114: istore 8
    //   116: aload 13
    //   118: getfield 692	axvt:m	Ljava/lang/String;
    //   121: ifnull +227 -> 348
    //   124: new 204	java/io/File
    //   127: dup
    //   128: aload 13
    //   130: getfield 692	axvt:m	Ljava/lang/String;
    //   133: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: astore 14
    //   138: new 204	java/io/File
    //   141: dup
    //   142: aload_1
    //   143: getfield 127	axsp:d	Ljava/lang/String;
    //   146: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 16
    //   151: aload 16
    //   153: invokevirtual 217	java/io/File:length	()J
    //   156: lstore_2
    //   157: iload 9
    //   159: istore 8
    //   161: aload 14
    //   163: invokevirtual 228	java/io/File:exists	()Z
    //   166: ifne +182 -> 348
    //   169: iload 9
    //   171: istore 8
    //   173: lload_2
    //   174: lconst_0
    //   175: lcmp
    //   176: ifle +172 -> 348
    //   179: iload 9
    //   181: istore 8
    //   183: iload 7
    //   185: i2l
    //   186: lload_2
    //   187: lcmp
    //   188: ifge +160 -> 348
    //   191: new 204	java/io/File
    //   194: dup
    //   195: new 161	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   202: aload 13
    //   204: getfield 692	axvt:m	Ljava/lang/String;
    //   207: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 1042
    //   213: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore 15
    //   224: aconst_null
    //   225: astore 12
    //   227: aconst_null
    //   228: astore_1
    //   229: aload 16
    //   231: aload 15
    //   233: iconst_0
    //   234: iload 7
    //   236: invokestatic 1045	bace:a	(Ljava/io/File;Ljava/io/File;II)J
    //   239: lstore_2
    //   240: lload_2
    //   241: iload 7
    //   243: i2l
    //   244: lcmp
    //   245: ifeq +146 -> 391
    //   248: aload 15
    //   250: invokevirtual 228	java/io/File:exists	()Z
    //   253: ifeq +138 -> 391
    //   256: aload 15
    //   258: invokevirtual 259	java/io/File:delete	()Z
    //   261: pop
    //   262: iload 9
    //   264: istore 8
    //   266: aload_1
    //   267: ifnull +81 -> 348
    //   270: iload 10
    //   272: istore 9
    //   274: aload_1
    //   275: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   278: iload 10
    //   280: istore 9
    //   282: aload 15
    //   284: aload 14
    //   286: invokestatic 1047	bace:b	(Ljava/io/File;Ljava/io/File;)Z
    //   289: pop
    //   290: iconst_1
    //   291: istore 11
    //   293: iconst_1
    //   294: istore 10
    //   296: iload 10
    //   298: istore 8
    //   300: iload 11
    //   302: istore 9
    //   304: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   307: ifeq +41 -> 348
    //   310: iload 11
    //   312: istore 9
    //   314: ldc 212
    //   316: iconst_4
    //   317: new 161	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 1049
    //   327: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 13
    //   332: getfield 692	axvt:m	Ljava/lang/String;
    //   335: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: iload 10
    //   346: istore 8
    //   348: aload_0
    //   349: getfield 606	axop:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   352: invokevirtual 343	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   355: astore_1
    //   356: aload_1
    //   357: invokeinterface 348 1 0
    //   362: ifeq +250 -> 612
    //   365: aload_1
    //   366: invokeinterface 352 1 0
    //   371: checkcast 608	atpa
    //   374: iload 6
    //   376: iload 8
    //   378: invokeinterface 1052 3 0
    //   383: goto -27 -> 356
    //   386: astore_1
    //   387: aload_0
    //   388: monitorexit
    //   389: aload_1
    //   390: athrow
    //   391: new 230	java/io/RandomAccessFile
    //   394: dup
    //   395: aload 15
    //   397: ldc 232
    //   399: invokespecial 235	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   402: astore_1
    //   403: aload_1
    //   404: lload_2
    //   405: invokevirtual 239	java/io/RandomAccessFile:seek	(J)V
    //   408: aload_1
    //   409: iconst_2
    //   410: newarray byte
    //   412: dup
    //   413: iconst_0
    //   414: ldc 124
    //   416: bastore
    //   417: dup
    //   418: iconst_1
    //   419: ldc 125
    //   421: bastore
    //   422: invokevirtual 268	java/io/RandomAccessFile:write	([B)V
    //   425: goto -163 -> 262
    //   428: astore_1
    //   429: aload_1
    //   430: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   433: iload 9
    //   435: istore 8
    //   437: goto -89 -> 348
    //   440: astore_1
    //   441: aload 12
    //   443: astore_1
    //   444: iload 9
    //   446: istore 8
    //   448: aload_1
    //   449: ifnull -101 -> 348
    //   452: iload 11
    //   454: istore 9
    //   456: aload_1
    //   457: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   460: iload 11
    //   462: istore 9
    //   464: aload 15
    //   466: aload 14
    //   468: invokestatic 1047	bace:b	(Ljava/io/File;Ljava/io/File;)Z
    //   471: pop
    //   472: iconst_1
    //   473: istore 11
    //   475: iconst_1
    //   476: istore 10
    //   478: iload 10
    //   480: istore 8
    //   482: iload 11
    //   484: istore 9
    //   486: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   489: ifeq -141 -> 348
    //   492: iload 11
    //   494: istore 9
    //   496: ldc 212
    //   498: iconst_4
    //   499: new 161	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   506: ldc_w 1049
    //   509: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 13
    //   514: getfield 692	axvt:m	Ljava/lang/String;
    //   517: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: iload 10
    //   528: istore 8
    //   530: goto -182 -> 348
    //   533: astore_1
    //   534: aload_1
    //   535: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   538: iload 9
    //   540: istore 8
    //   542: goto -194 -> 348
    //   545: astore 12
    //   547: aconst_null
    //   548: astore_1
    //   549: aload_1
    //   550: ifnull +51 -> 601
    //   553: aload_1
    //   554: invokevirtual 255	java/io/RandomAccessFile:close	()V
    //   557: aload 15
    //   559: aload 14
    //   561: invokestatic 1047	bace:b	(Ljava/io/File;Ljava/io/File;)Z
    //   564: pop
    //   565: invokestatic 210	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   568: ifeq +33 -> 601
    //   571: ldc 212
    //   573: iconst_4
    //   574: new 161	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   581: ldc_w 1049
    //   584: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 13
    //   589: getfield 692	axvt:m	Ljava/lang/String;
    //   592: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: aload 12
    //   603: athrow
    //   604: astore_1
    //   605: aload_1
    //   606: invokevirtual 262	java/io/IOException:printStackTrace	()V
    //   609: goto -8 -> 601
    //   612: aload_0
    //   613: monitorexit
    //   614: return
    //   615: astore 12
    //   617: goto -68 -> 549
    //   620: astore 12
    //   622: goto -178 -> 444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	625	0	this	axop
    //   0	625	1	paramaxsp	axsp
    //   0	625	2	paramLong1	long
    //   0	625	4	paramLong2	long
    //   9	366	6	i	int
    //   89	153	7	j	int
    //   93	448	8	bool1	boolean
    //   76	463	9	bool2	boolean
    //   70	457	10	bool3	boolean
    //   73	420	11	bool4	boolean
    //   225	217	12	localObject1	Object
    //   545	57	12	localObject2	Object
    //   615	1	12	localObject3	Object
    //   620	1	12	localIOException	IOException
    //   82	506	13	localaxvt	axvt
    //   136	424	14	localFile1	File
    //   222	336	15	localFile2	File
    //   149	81	16	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   52	69	386	finally
    //   78	91	386	finally
    //   95	103	386	finally
    //   116	157	386	finally
    //   161	169	386	finally
    //   191	224	386	finally
    //   274	278	386	finally
    //   282	290	386	finally
    //   304	310	386	finally
    //   314	344	386	finally
    //   348	356	386	finally
    //   356	383	386	finally
    //   387	389	386	finally
    //   429	433	386	finally
    //   456	460	386	finally
    //   464	472	386	finally
    //   486	492	386	finally
    //   496	526	386	finally
    //   534	538	386	finally
    //   553	601	386	finally
    //   601	604	386	finally
    //   605	609	386	finally
    //   612	614	386	finally
    //   274	278	428	java/io/IOException
    //   282	290	428	java/io/IOException
    //   304	310	428	java/io/IOException
    //   314	344	428	java/io/IOException
    //   229	240	440	java/io/IOException
    //   248	262	440	java/io/IOException
    //   391	403	440	java/io/IOException
    //   456	460	533	java/io/IOException
    //   464	472	533	java/io/IOException
    //   486	492	533	java/io/IOException
    //   496	526	533	java/io/IOException
    //   229	240	545	finally
    //   248	262	545	finally
    //   391	403	545	finally
    //   553	601	604	java/io/IOException
    //   403	425	615	finally
    //   403	425	620	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axop
 * JD-Core Version:    0.7.0.1
 */