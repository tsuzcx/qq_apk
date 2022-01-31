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

public class ayox
  extends ayow
  implements aysd
{
  private static final Pattern a;
  protected aywf a;
  public WeakNetLearner a;
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
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(".*//[^/]*/[^/]*/(.*)/.*");
  }
  
  public ayox()
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public ayox(ayvx paramayvx, aywc paramaywc)
  {
    super(paramayvx, paramaywc);
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner = aype.jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner;
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
    f();
  }
  
  private boolean a(aysz paramaysz)
  {
    if (paramaysz != null) {
      try
      {
        if (paramaysz.jdField_a_of_type_Aysy.jdField_c_of_type_JavaLangString != null)
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramaysz.jdField_a_of_type_Aysy.jdField_c_of_type_JavaLangString, localOptions);
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
      catch (Throwable paramaysz)
      {
        paramaysz.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private void b(aysz paramaysz)
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
    //   23: ldc 114
    //   25: bastore
    //   26: dup
    //   27: iconst_1
    //   28: ldc 115
    //   30: bastore
    //   31: pop
    //   32: aload_1
    //   33: getfield 83	aysz:jdField_a_of_type_Aysy	Laysy;
    //   36: ifnull +74 -> 110
    //   39: aload_1
    //   40: getfield 83	aysz:jdField_a_of_type_Aysy	Laysy;
    //   43: getfield 117	aysy:d	Ljava/lang/String;
    //   46: ifnull +64 -> 110
    //   49: aload_1
    //   50: getfield 83	aysz:jdField_a_of_type_Aysy	Laysy;
    //   53: getfield 117	aysy:d	Ljava/lang/String;
    //   56: invokevirtual 123	java/lang/String:length	()I
    //   59: ifeq +51 -> 110
    //   62: aload_1
    //   63: getfield 83	aysz:jdField_a_of_type_Aysy	Laysy;
    //   66: getfield 87	aysy:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   69: ifnull +41 -> 110
    //   72: aload_1
    //   73: getfield 83	aysz:jdField_a_of_type_Aysy	Laysy;
    //   76: getfield 87	aysy:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   79: invokevirtual 123	java/lang/String:length	()I
    //   82: ifeq +28 -> 110
    //   85: aload_1
    //   86: getfield 83	aysz:jdField_a_of_type_Aysy	Laysy;
    //   89: getfield 117	aysy:d	Ljava/lang/String;
    //   92: astore 9
    //   94: aload_1
    //   95: getfield 83	aysz:jdField_a_of_type_Aysy	Laysy;
    //   98: getfield 87	aysy:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   101: astore 8
    //   103: aload_0
    //   104: getfield 126	ayox:jdField_a_of_type_Aywc	Laywc;
    //   107: ifnonnull +4 -> 111
    //   110: return
    //   111: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +99 -> 213
    //   117: aload_0
    //   118: getfield 126	ayox:jdField_a_of_type_Aywc	Laywc;
    //   121: getfield 136	aywc:jdField_a_of_type_Int	I
    //   124: aload_0
    //   125: getfield 126	ayox:jdField_a_of_type_Aywc	Laywc;
    //   128: getfield 138	aywc:jdField_a_of_type_Boolean	Z
    //   131: aload_0
    //   132: getfield 126	ayox:jdField_a_of_type_Aywc	Laywc;
    //   135: getfield 140	aywc:jdField_b_of_type_Int	I
    //   138: aload_0
    //   139: getfield 126	ayox:jdField_a_of_type_Aywc	Laywc;
    //   142: getfield 143	aywc:jdField_a_of_type_Long	J
    //   145: invokestatic 147	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   148: ldc 149
    //   150: new 151	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   157: ldc 154
    //   159: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 126	ayox:jdField_a_of_type_Aywc	Laywc;
    //   166: getfield 161	aywc:i	I
    //   169: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: ldc 166
    //   174: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: getfield 126	ayox:jdField_a_of_type_Aywc	Laywc;
    //   181: getfield 169	aywc:jdField_j_of_type_Int	I
    //   184: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: ldc 171
    //   189: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 9
    //   194: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc 173
    //   199: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 8
    //   204: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 182	ayuk:a	(IZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 126	ayox:jdField_a_of_type_Aywc	Laywc;
    //   218: invokevirtual 185	ayox:a	(Laywc;)I
    //   221: istore_2
    //   222: iload_2
    //   223: iconst_4
    //   224: if_icmpne +453 -> 677
    //   227: new 151	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   234: aload 8
    //   236: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 187
    //   241: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: astore 6
    //   249: aload 8
    //   251: aload 6
    //   253: invokestatic 192	bbdx:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   256: pop
    //   257: new 194	java/io/File
    //   260: dup
    //   261: aload 6
    //   263: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   266: astore_1
    //   267: new 194	java/io/File
    //   270: dup
    //   271: aload 9
    //   273: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: astore 7
    //   278: invokestatic 200	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   281: ifeq +42 -> 323
    //   284: ldc 202
    //   286: iconst_4
    //   287: new 151	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   294: ldc 204
    //   296: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 7
    //   301: invokevirtual 207	java/io/File:length	()J
    //   304: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   307: ldc 212
    //   309: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload 8
    //   314: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_1
    //   324: invokevirtual 218	java/io/File:exists	()Z
    //   327: ifeq -217 -> 110
    //   330: aload 7
    //   332: invokevirtual 218	java/io/File:exists	()Z
    //   335: ifeq -225 -> 110
    //   338: new 220	java/io/RandomAccessFile
    //   341: dup
    //   342: aload_1
    //   343: ldc 222
    //   345: invokespecial 225	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   348: astore_1
    //   349: aload_1
    //   350: aload_0
    //   351: getfield 126	ayox:jdField_a_of_type_Aywc	Laywc;
    //   354: getfield 161	aywc:i	I
    //   357: i2l
    //   358: invokevirtual 229	java/io/RandomAccessFile:seek	(J)V
    //   361: new 231	java/io/FileInputStream
    //   364: dup
    //   365: aload 7
    //   367: invokespecial 234	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   370: astore 4
    //   372: sipush 1024
    //   375: newarray byte
    //   377: astore_3
    //   378: aload 4
    //   380: aload_3
    //   381: invokevirtual 238	java/io/FileInputStream:read	([B)I
    //   384: istore_2
    //   385: iload_2
    //   386: ifle +75 -> 461
    //   389: aload_1
    //   390: aload_3
    //   391: iconst_0
    //   392: iload_2
    //   393: invokevirtual 242	java/io/RandomAccessFile:write	([BII)V
    //   396: goto -18 -> 378
    //   399: astore_3
    //   400: aload_1
    //   401: astore_3
    //   402: aload 4
    //   404: astore_1
    //   405: aload_3
    //   406: ifnull +7 -> 413
    //   409: aload_3
    //   410: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   413: aload_1
    //   414: ifnull +7 -> 421
    //   417: aload_1
    //   418: invokevirtual 246	java/io/FileInputStream:close	()V
    //   421: aload 7
    //   423: invokevirtual 249	java/io/File:delete	()Z
    //   426: pop
    //   427: aload 6
    //   429: aload 8
    //   431: invokestatic 251	bbdx:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   434: ifne -324 -> 110
    //   437: aload 6
    //   439: aload 8
    //   441: invokestatic 192	bbdx:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   444: ifeq +121 -> 565
    //   447: new 194	java/io/File
    //   450: dup
    //   451: aload 6
    //   453: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   456: invokevirtual 249	java/io/File:delete	()Z
    //   459: pop
    //   460: return
    //   461: aload_1
    //   462: ifnull +7 -> 469
    //   465: aload_1
    //   466: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   469: aload 4
    //   471: ifnull +8 -> 479
    //   474: aload 4
    //   476: invokevirtual 246	java/io/FileInputStream:close	()V
    //   479: aload 7
    //   481: invokevirtual 249	java/io/File:delete	()Z
    //   484: pop
    //   485: aload 6
    //   487: aload 8
    //   489: invokestatic 251	bbdx:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   492: ifne -382 -> 110
    //   495: aload 6
    //   497: aload 8
    //   499: invokestatic 192	bbdx:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   502: ifeq +33 -> 535
    //   505: new 194	java/io/File
    //   508: dup
    //   509: aload 6
    //   511: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   514: invokevirtual 249	java/io/File:delete	()Z
    //   517: pop
    //   518: return
    //   519: astore_1
    //   520: aload_1
    //   521: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   524: goto -55 -> 469
    //   527: astore_1
    //   528: aload_1
    //   529: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   532: goto -53 -> 479
    //   535: new 194	java/io/File
    //   538: dup
    //   539: aload 6
    //   541: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   544: invokevirtual 249	java/io/File:delete	()Z
    //   547: pop
    //   548: return
    //   549: astore_3
    //   550: aload_3
    //   551: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   554: goto -141 -> 413
    //   557: astore_1
    //   558: aload_1
    //   559: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   562: goto -141 -> 421
    //   565: new 194	java/io/File
    //   568: dup
    //   569: aload 6
    //   571: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   574: invokevirtual 249	java/io/File:delete	()Z
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
    //   591: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   594: aload 4
    //   596: ifnull +8 -> 604
    //   599: aload 4
    //   601: invokevirtual 246	java/io/FileInputStream:close	()V
    //   604: aload 7
    //   606: invokevirtual 249	java/io/File:delete	()Z
    //   609: pop
    //   610: aload 6
    //   612: aload 8
    //   614: invokestatic 251	bbdx:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   617: ifne +26 -> 643
    //   620: aload 6
    //   622: aload 8
    //   624: invokestatic 192	bbdx:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   627: ifeq +34 -> 661
    //   630: new 194	java/io/File
    //   633: dup
    //   634: aload 6
    //   636: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   639: invokevirtual 249	java/io/File:delete	()Z
    //   642: pop
    //   643: aload_3
    //   644: athrow
    //   645: astore_1
    //   646: aload_1
    //   647: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   650: goto -56 -> 594
    //   653: astore_1
    //   654: aload_1
    //   655: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   658: goto -54 -> 604
    //   661: new 194	java/io/File
    //   664: dup
    //   665: aload 6
    //   667: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   670: invokevirtual 249	java/io/File:delete	()Z
    //   673: pop
    //   674: goto -31 -> 643
    //   677: iload_2
    //   678: iconst_2
    //   679: if_icmpne +230 -> 909
    //   682: new 194	java/io/File
    //   685: dup
    //   686: aload 9
    //   688: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   691: astore_1
    //   692: new 194	java/io/File
    //   695: dup
    //   696: aload 8
    //   698: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   701: astore_3
    //   702: aload_3
    //   703: invokevirtual 218	java/io/File:exists	()Z
    //   706: ifeq +8 -> 714
    //   709: aload_3
    //   710: invokevirtual 249	java/io/File:delete	()Z
    //   713: pop
    //   714: invokestatic 200	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   717: ifeq +41 -> 758
    //   720: ldc 202
    //   722: iconst_4
    //   723: new 151	java/lang/StringBuilder
    //   726: dup
    //   727: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   730: ldc 254
    //   732: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload_1
    //   736: invokevirtual 207	java/io/File:length	()J
    //   739: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   742: ldc 212
    //   744: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: aload 8
    //   749: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   758: aload_1
    //   759: invokevirtual 218	java/io/File:exists	()Z
    //   762: ifeq -652 -> 110
    //   765: new 220	java/io/RandomAccessFile
    //   768: dup
    //   769: aload_1
    //   770: ldc 222
    //   772: invokespecial 225	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   775: astore_3
    //   776: aload_3
    //   777: aload_3
    //   778: invokevirtual 255	java/io/RandomAccessFile:length	()J
    //   781: invokevirtual 229	java/io/RandomAccessFile:seek	(J)V
    //   784: aload_3
    //   785: aload 10
    //   787: invokevirtual 258	java/io/RandomAccessFile:write	([B)V
    //   790: aload_3
    //   791: ifnull +7 -> 798
    //   794: aload_3
    //   795: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   798: aload 9
    //   800: aload 8
    //   802: invokestatic 251	bbdx:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   805: ifne -695 -> 110
    //   808: aload 9
    //   810: aload 8
    //   812: invokestatic 192	bbdx:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   815: ifeq +17 -> 832
    //   818: new 194	java/io/File
    //   821: dup
    //   822: aload 9
    //   824: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   827: invokevirtual 249	java/io/File:delete	()Z
    //   830: pop
    //   831: return
    //   832: new 194	java/io/File
    //   835: dup
    //   836: aload 9
    //   838: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   841: invokevirtual 249	java/io/File:delete	()Z
    //   844: pop
    //   845: return
    //   846: astore_1
    //   847: aload 7
    //   849: astore_3
    //   850: aload_3
    //   851: ifnull +7 -> 858
    //   854: aload_3
    //   855: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   858: aload 9
    //   860: aload 8
    //   862: invokestatic 251	bbdx:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   865: ifne +26 -> 891
    //   868: aload 9
    //   870: aload 8
    //   872: invokestatic 192	bbdx:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   875: ifeq +18 -> 893
    //   878: new 194	java/io/File
    //   881: dup
    //   882: aload 9
    //   884: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   887: invokevirtual 249	java/io/File:delete	()Z
    //   890: pop
    //   891: aload_1
    //   892: athrow
    //   893: new 194	java/io/File
    //   896: dup
    //   897: aload 9
    //   899: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   902: invokevirtual 249	java/io/File:delete	()Z
    //   905: pop
    //   906: goto -15 -> 891
    //   909: iload_2
    //   910: iconst_3
    //   911: if_icmpne -801 -> 110
    //   914: new 151	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   921: aload 8
    //   923: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: ldc 187
    //   928: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   934: astore 7
    //   936: aload 8
    //   938: aload 7
    //   940: invokestatic 192	bbdx:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   943: pop
    //   944: new 194	java/io/File
    //   947: dup
    //   948: aload 7
    //   950: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   953: astore_1
    //   954: new 194	java/io/File
    //   957: dup
    //   958: aload 9
    //   960: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   963: astore 9
    //   965: invokestatic 200	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   968: ifeq +43 -> 1011
    //   971: ldc 202
    //   973: iconst_4
    //   974: new 151	java/lang/StringBuilder
    //   977: dup
    //   978: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   981: ldc_w 260
    //   984: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: aload 9
    //   989: invokevirtual 207	java/io/File:length	()J
    //   992: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   995: ldc 212
    //   997: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: aload 8
    //   1002: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1011: aload_1
    //   1012: invokevirtual 218	java/io/File:exists	()Z
    //   1015: ifeq -905 -> 110
    //   1018: aload 9
    //   1020: invokevirtual 218	java/io/File:exists	()Z
    //   1023: ifeq -913 -> 110
    //   1026: new 220	java/io/RandomAccessFile
    //   1029: dup
    //   1030: aload_1
    //   1031: ldc 222
    //   1033: invokespecial 225	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1036: astore_1
    //   1037: aload_1
    //   1038: aload_0
    //   1039: getfield 126	ayox:jdField_a_of_type_Aywc	Laywc;
    //   1042: getfield 161	aywc:i	I
    //   1045: i2l
    //   1046: invokevirtual 229	java/io/RandomAccessFile:seek	(J)V
    //   1049: new 231	java/io/FileInputStream
    //   1052: dup
    //   1053: aload 9
    //   1055: invokespecial 234	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1058: astore_3
    //   1059: sipush 1024
    //   1062: newarray byte
    //   1064: astore 4
    //   1066: aload_3
    //   1067: aload 4
    //   1069: invokevirtual 238	java/io/FileInputStream:read	([B)I
    //   1072: istore_2
    //   1073: iload_2
    //   1074: ifle +72 -> 1146
    //   1077: aload_1
    //   1078: aload 4
    //   1080: iconst_0
    //   1081: iload_2
    //   1082: invokevirtual 242	java/io/RandomAccessFile:write	([BII)V
    //   1085: goto -19 -> 1066
    //   1088: astore 4
    //   1090: aload_1
    //   1091: ifnull +7 -> 1098
    //   1094: aload_1
    //   1095: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   1098: aload_3
    //   1099: ifnull +7 -> 1106
    //   1102: aload_3
    //   1103: invokevirtual 246	java/io/FileInputStream:close	()V
    //   1106: aload 9
    //   1108: invokevirtual 249	java/io/File:delete	()Z
    //   1111: pop
    //   1112: aload 7
    //   1114: aload 8
    //   1116: invokestatic 251	bbdx:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1119: ifne -1009 -> 110
    //   1122: aload 7
    //   1124: aload 8
    //   1126: invokestatic 192	bbdx:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1129: ifeq +93 -> 1222
    //   1132: new 194	java/io/File
    //   1135: dup
    //   1136: aload 7
    //   1138: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   1141: invokevirtual 249	java/io/File:delete	()Z
    //   1144: pop
    //   1145: return
    //   1146: aload_1
    //   1147: aload 10
    //   1149: invokevirtual 258	java/io/RandomAccessFile:write	([B)V
    //   1152: aload_1
    //   1153: ifnull +7 -> 1160
    //   1156: aload_1
    //   1157: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   1160: aload_3
    //   1161: ifnull +7 -> 1168
    //   1164: aload_3
    //   1165: invokevirtual 246	java/io/FileInputStream:close	()V
    //   1168: aload 9
    //   1170: invokevirtual 249	java/io/File:delete	()Z
    //   1173: pop
    //   1174: aload 7
    //   1176: aload 8
    //   1178: invokestatic 251	bbdx:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1181: ifne -1071 -> 110
    //   1184: aload 7
    //   1186: aload 8
    //   1188: invokestatic 192	bbdx:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1191: ifeq +17 -> 1208
    //   1194: new 194	java/io/File
    //   1197: dup
    //   1198: aload 7
    //   1200: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   1203: invokevirtual 249	java/io/File:delete	()Z
    //   1206: pop
    //   1207: return
    //   1208: new 194	java/io/File
    //   1211: dup
    //   1212: aload 7
    //   1214: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   1217: invokevirtual 249	java/io/File:delete	()Z
    //   1220: pop
    //   1221: return
    //   1222: new 194	java/io/File
    //   1225: dup
    //   1226: aload 7
    //   1228: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   1231: invokevirtual 249	java/io/File:delete	()Z
    //   1234: pop
    //   1235: return
    //   1236: astore_3
    //   1237: aconst_null
    //   1238: astore_1
    //   1239: aload 6
    //   1241: astore 4
    //   1243: aload_1
    //   1244: ifnull +7 -> 1251
    //   1247: aload_1
    //   1248: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   1251: aload 4
    //   1253: ifnull +8 -> 1261
    //   1256: aload 4
    //   1258: invokevirtual 246	java/io/FileInputStream:close	()V
    //   1261: aload 9
    //   1263: invokevirtual 249	java/io/File:delete	()Z
    //   1266: pop
    //   1267: aload 7
    //   1269: aload 8
    //   1271: invokestatic 251	bbdx:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1274: ifne +26 -> 1300
    //   1277: aload 7
    //   1279: aload 8
    //   1281: invokestatic 192	bbdx:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1284: ifeq +18 -> 1302
    //   1287: new 194	java/io/File
    //   1290: dup
    //   1291: aload 7
    //   1293: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   1296: invokevirtual 249	java/io/File:delete	()Z
    //   1299: pop
    //   1300: aload_3
    //   1301: athrow
    //   1302: new 194	java/io/File
    //   1305: dup
    //   1306: aload 7
    //   1308: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   1311: invokevirtual 249	java/io/File:delete	()Z
    //   1314: pop
    //   1315: goto -15 -> 1300
    //   1318: astore_1
    //   1319: goto -159 -> 1160
    //   1322: astore_1
    //   1323: goto -155 -> 1168
    //   1326: astore_1
    //   1327: goto -229 -> 1098
    //   1330: astore_1
    //   1331: goto -225 -> 1106
    //   1334: astore_1
    //   1335: goto -84 -> 1251
    //   1338: astore_1
    //   1339: goto -78 -> 1261
    //   1342: astore_3
    //   1343: aload 6
    //   1345: astore 4
    //   1347: goto -104 -> 1243
    //   1350: astore 5
    //   1352: aload_3
    //   1353: astore 4
    //   1355: aload 5
    //   1357: astore_3
    //   1358: goto -115 -> 1243
    //   1361: astore_1
    //   1362: aconst_null
    //   1363: astore_1
    //   1364: aload 4
    //   1366: astore_3
    //   1367: goto -277 -> 1090
    //   1370: astore_3
    //   1371: aload 4
    //   1373: astore_3
    //   1374: goto -284 -> 1090
    //   1377: astore_1
    //   1378: goto -528 -> 850
    //   1381: astore_3
    //   1382: aload 5
    //   1384: astore 4
    //   1386: goto -800 -> 586
    //   1389: astore_3
    //   1390: goto -804 -> 586
    //   1393: astore_1
    //   1394: aconst_null
    //   1395: astore_1
    //   1396: goto -991 -> 405
    //   1399: astore_3
    //   1400: aconst_null
    //   1401: astore 4
    //   1403: aload_1
    //   1404: astore_3
    //   1405: aload 4
    //   1407: astore_1
    //   1408: goto -1003 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1411	0	this	ayox
    //   0	1411	1	paramaysz	aysz
    //   221	861	2	i	int
    //   13	378	3	arrayOfByte1	byte[]
    //   399	1	3	localThrowable1	Throwable
    //   401	9	3	localaysz1	aysz
    //   549	2	3	localIOException	IOException
    //   579	65	3	localObject1	Object
    //   701	464	3	localObject2	Object
    //   1236	65	3	localObject3	Object
    //   1342	11	3	localObject4	Object
    //   1357	10	3	localObject5	Object
    //   1370	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   1373	1	3	localObject6	Object
    //   1381	1	3	localObject7	Object
    //   1389	1	3	localObject8	Object
    //   1399	1	3	localThrowable2	Throwable
    //   1404	1	3	localaysz2	aysz
    //   7	1072	4	localObject9	Object
    //   1088	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   1241	165	4	localObject10	Object
    //   1	582	5	localObject11	Object
    //   1350	33	5	localObject12	Object
    //   10	1334	6	str1	String
    //   4	1303	7	localObject13	Object
    //   101	1179	8	str2	String
    //   92	1170	9	localObject14	Object
    //   17	1131	10	arrayOfByte2	byte[]
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
    //   765	776	846	finally
    //   1059	1066	1088	java/io/FileNotFoundException
    //   1066	1073	1088	java/io/FileNotFoundException
    //   1077	1085	1088	java/io/FileNotFoundException
    //   1146	1152	1088	java/io/FileNotFoundException
    //   1026	1037	1236	finally
    //   1156	1160	1318	java/io/IOException
    //   1164	1168	1322	java/io/IOException
    //   1094	1098	1326	java/io/IOException
    //   1102	1106	1330	java/io/IOException
    //   1247	1251	1334	java/io/IOException
    //   1256	1261	1338	java/io/IOException
    //   1037	1059	1342	finally
    //   1059	1066	1350	finally
    //   1066	1073	1350	finally
    //   1077	1085	1350	finally
    //   1146	1152	1350	finally
    //   1026	1037	1361	java/io/FileNotFoundException
    //   1037	1059	1370	java/io/FileNotFoundException
    //   776	790	1377	finally
    //   349	372	1381	finally
    //   372	378	1389	finally
    //   378	385	1389	finally
    //   389	396	1389	finally
    //   338	349	1393	java/lang/Throwable
    //   349	372	1399	java/lang/Throwable
  }
  
  int a(aywc paramaywc)
  {
    if (paramaywc.i < 0) {}
    do
    {
      return 1;
      if (paramaywc.i > 0)
      {
        if (paramaywc.jdField_j_of_type_Int > 0) {
          return 3;
        }
        return 4;
      }
    } while (paramaywc.jdField_j_of_type_Int <= 0);
    return 2;
  }
  
  protected String a(String paramString, int paramInt)
  {
    String str = "&rf=other";
    if (this.jdField_a_of_type_Aywc.g == 0)
    {
      str = "&rf=aio";
      str = "cldver=8.3.0.4480" + str;
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
      return paramString + "&msgTime=" + this.jdField_a_of_type_Aywc.d;
      if (this.jdField_a_of_type_Aywc.g != 1) {
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
  
  protected ArrayList<ayuq> a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        ayuq localayuq = new ayuq();
        localayuq.jdField_a_of_type_JavaLangString = str;
        localayuq.jdField_a_of_type_Int = d();
        localayuq.jdField_a_of_type_Boolean = paramBoolean;
        localArrayList.add(localayuq);
      }
    }
    return localArrayList;
  }
  
  public void a(ayrx paramayrx, String paramString)
  {
    if (this.jdField_e_of_type_Boolean)
    {
      paramayrx.jdField_a_of_type_JavaLangString = b(paramString);
      if (!paramString.equals(paramayrx.jdField_a_of_type_JavaLangString))
      {
        paramayrx.jdField_a_of_type_JavaUtilHashMap.put("Cookie", "ST=" + bbmx.a(this.jdField_a_of_type_ArrayOfByte));
        if (this.jdField_d_of_type_Boolean)
        {
          PicCryptor localPicCryptor = new PicCryptor(this.jdField_b_of_type_ArrayOfByte);
          localPicCryptor.a = paramayrx;
          paramayrx.jdField_a_of_type_Ayrz = localPicCryptor;
          paramayrx.d = (paramayrx.jdField_c_of_type_JavaLangString + "." + MD5.toMD5(ayuk.a(paramString, false)) + ".tmp");
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_f_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
      {
        paramayrx.d = (paramayrx.jdField_c_of_type_JavaLangString + "." + MD5.toMD5(ayuk.a(paramString, false)) + ".tmp");
        paramayrx.jdField_a_of_type_JavaLangString = (paramString + "&rollback=1");
      }
      return;
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public void a(aysz paramaysz)
  {
    a(paramaysz, false, "actRichMediaNetMonitor_picDown", this.jdField_a_of_type_Aywc.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString, null);
  }
  
  void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aywf.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0))
    {
      this.jdField_c_of_type_Int = 1;
      b(false);
      return;
    }
    ArrayList localArrayList = a(ayxg.a().a(paramString, paramInt, true, 28), true);
    paramString = a(ayxg.a().a(paramString, paramInt, true, 1), false);
    if (g()) {
      if (h()) {
        localArrayList.addAll(paramString);
      }
    }
    for (this.jdField_a_of_type_JavaUtilArrayList = localArrayList; (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0); this.jdField_a_of_type_JavaUtilArrayList = paramString)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_d_of_type_Aypd.a();
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
      i = this.jdField_j_of_type_Int;
      if (this.jdField_j_of_type_Int != -9527) {
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
      axrn.a(BaseApplication.getContext()).a(null, paramString, true, paramLong, this.jdField_a_of_type_Long, paramHashMap, null);
      return;
      label72:
      str = String.valueOf(i);
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 65537) {
      return true;
    }
    if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
    {
      long l1 = ((MessageForPic)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).size;
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
    String str2 = c(paramString);
    Cryptor localCryptor = new Cryptor();
    if (str2 != null)
    {
      String str1 = str2 + "&encrypt=";
      if (this.jdField_d_of_type_Boolean) {}
      for (str1 = str1 + "1";; str1 = str1 + "0") {
        return paramString.replace(str2, bbmx.a(localCryptor.encrypt(str1.getBytes(), this.jdField_b_of_type_ArrayOfByte)));
      }
    }
    this.jdField_d_of_type_Boolean = false;
    return paramString;
  }
  
  void b(boolean paramBoolean) {}
  
  public String c(String paramString)
  {
    paramString = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return null;
  }
  
  void c(boolean paramBoolean) {}
  
  void d()
  {
    super.d();
    Object localObject1 = this.jdField_a_of_type_Aywc.jdField_a_of_type_Aywj;
    if (localObject1 != null)
    {
      ((aywj)localObject1).jdField_a_of_type_Int = -1;
      ((aywj)localObject1).jdField_a_of_type_Long = this.jdField_j_of_type_Int;
      ((aywj)localObject1).jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      ((aywj)localObject1).jdField_a_of_type_Aywc = this.jdField_a_of_type_Aywc;
    }
    Object localObject4;
    try
    {
      if (this.jdField_a_of_type_Ayqo != null) {
        this.jdField_a_of_type_Ayqo.d = 2005;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (auna)((Iterator)localObject1).next();
        aunb localaunb = new aunb();
        localaunb.jdField_a_of_type_Int = -1;
        localaunb.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
        localaunb.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        ((auna)localObject4).a(localaunb);
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "onError ");
        }
      }
      if (this.jdField_a_of_type_Ayqo == null) {
        break label174;
      }
    }
    finally {}
    b("notify", "start");
    label174:
    notifyAll();
    if (this.jdField_a_of_type_Ayqo != null) {
      b("notify", "end");
    }
    int i;
    if ((this.jdField_j_of_type_Int == 9014) || (this.jdField_j_of_type_Int == 9050))
    {
      Object localObject3 = ayuk.a(((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
      if (localObject3 != null)
      {
        localObject3 = ((ayuq)localObject3).jdField_a_of_type_JavaLangString;
        localObject4 = new ProbeChain();
        if (this.jdField_j_of_type_Int != 9014) {
          break label381;
        }
        ((ProbeChain)localObject4).addProbeItem(new PingProbe());
        ((ProbeChain)localObject4).addProbeItem(new MtuProbe());
        ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
        if (this.jdField_j_of_type_Int != 9014) {
          break label408;
        }
        i = -1201;
        label308:
        localObject3 = new ProbeRequest((String)localObject3, i, (ProbeItem)localObject4);
        if (this.jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner != null) {
          this.jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner.startProbe(new ProbeTask((ProbeRequest)localObject3));
        }
      }
    }
    d(2005);
    if (this.jdField_a_of_type_Aywc != null)
    {
      if (!askf.b(this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        break label415;
      }
      askf.a(String.valueOf(this.jdField_j_of_type_Int), 3);
    }
    label381:
    while (!askf.a(this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
    {
      return;
      ((ProbeChain)localObject4).addProbeItem(new PingProbe());
      ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
      break;
      i = -1202;
      break label308;
    }
    label408:
    label415:
    askf.a(String.valueOf(this.jdField_j_of_type_Int), 2);
  }
  
  void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("big_thumb", 2, "onsuccess mUiRequest.mFileType" + this.jdField_a_of_type_Aywc.jdField_b_of_type_Int + "mUiRequest.mOutFilePath=" + this.jdField_a_of_type_Aywc.h + "url=" + ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
    }
    Object localObject1 = this.jdField_a_of_type_Aywc.jdField_a_of_type_Aywj;
    if (localObject1 != null)
    {
      ((aywj)localObject1).jdField_a_of_type_Int = 0;
      ((aywj)localObject1).jdField_a_of_type_Aywc = this.jdField_a_of_type_Aywc;
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
        if (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int != 65537) {
          continue;
        }
        localObject1 = this.jdField_a_of_type_Aywc.h;
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
        if (bbdh.d() < 240) {
          continue;
        }
        if (!(localObject4 instanceof MessageForMixedMsg)) {
          break label698;
        }
      }
      try
      {
        if (this.jdField_a_of_type_Ayqo != null) {
          this.jdField_a_of_type_Ayqo.d = 2003;
        }
        localObject1 = this.jdField_a_of_type_Aywc;
        if (((aywc)localObject1).m != null)
        {
          localObject4 = new File(((aywc)localObject1).m);
          if ((((File)localObject4).exists()) && (((File)localObject4).delete()) && (QLog.isDevelopLevel())) {
            QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():Delete " + ((aywc)localObject1).m);
          }
        }
        int i = a(this.jdField_a_of_type_Aywc);
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label1046;
        }
        localObject4 = (auna)((Iterator)localObject1).next();
        localObject5 = new aunb();
        ((aunb)localObject5).jdField_a_of_type_Int = 0;
        ((aunb)localObject5).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aywc.h;
        ((aunb)localObject5).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_f_of_type_JavaLangString;
        ((aunb)localObject5).jdField_c_of_type_Int = this.jdField_a_of_type_Aywc.jdField_b_of_type_Int;
        ((aunb)localObject5).d = this.jdField_a_of_type_Aywc.g;
        if (i == 2) {
          break label1152;
        }
        if (i != 3) {
          break label1041;
        }
      }
      finally {}
      ((aunb)localObject5).jdField_a_of_type_Boolean = bool;
      ((auna)localObject4).a((aunb)localObject5);
      if ((this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 131075) && (QLog.isDevelopLevel())) {
        QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():" + this.jdField_a_of_type_Aywc.h + ", isPart " + ((aunb)localObject5).jdField_a_of_type_Boolean);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PIC_TAG", 2, "onSuccess ");
        continue;
        if (((this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 131075)) && (this.jdField_a_of_type_Aywc.h != null) && (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
        {
          localObject4 = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (GifDrawable.isGifFile(new File(this.jdField_a_of_type_Aywc.h)))
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
            Object localObject3 = ((MessageForMixedMsg)localObject4).getSubMessage(this.jdField_a_of_type_Aywc.jdField_b_of_type_Long);
            for (;;)
            {
              if ((localObject3 != null) && ((localObject3 instanceof MessageForPic)))
              {
                localObject3 = (MessageForPic)localObject3;
                label623:
                if (localObject3 == null) {
                  break label1150;
                }
                if (((ajyi.a((MessageRecord)localObject3)) || (ajwb.a((MessageRecord)localObject3))) && (!TextUtils.isEmpty(((MessageForPic)localObject3).md5)))
                {
                  localObject4 = this.jdField_a_of_type_Aywc.h + "_fp";
                  bbdg.a(this.jdField_a_of_type_Aywc.h, (String)localObject4, ((MessageForPic)localObject3).md5);
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
                  if (((axwv)localObject5).a == null) {
                    continue;
                  }
                  localObject3 = ((axwv)localObject5).a;
                  continue;
                }
                if (((MessageForPic)localObject3).fileSizeFlag != 1) {
                  break label1157;
                }
              }
            }
            for (bool = true;; bool = false)
            {
              if (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int != aywm.a("chatimg", bool)) {
                break label1160;
              }
              localObject5 = new CompressInfo(this.jdField_a_of_type_Aywc.h, 0);
              URL localURL = aywm.a((auoc)localObject3, 65537);
              ((CompressInfo)localObject5).jdField_f_of_type_Boolean = true;
              localObject4 = ayoi.d(localURL.toString());
              if (((String)localObject4).endsWith("_hd")) {
                break;
              }
              if (((String)localObject4).endsWith("_big400"))
              {
                ((String)localObject4).replace("_big400", "_hd");
                label874:
                ((CompressInfo)localObject5).jdField_e_of_type_JavaLangString = ((String)localObject4);
                ((CompressInfo)localObject5).a = ((MessageForPic)localObject3).thumbWidthHeightDP;
                auos.b((CompressInfo)localObject5);
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
              for (bool = gp.a(new File(((CompressInfo)localObject5).jdField_c_of_type_JavaLangString), (File)localObject4);; bool = true)
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
                if (this.jdField_a_of_type_Ayqo != null) {
                  b("notify", "start");
                }
                notifyAll();
                if (this.jdField_a_of_type_Ayqo != null) {
                  b("notify", "end");
                }
                d(2003);
                if (this.jdField_a_of_type_Aywc != null)
                {
                  if (!askf.b(this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
                    break label1121;
                  }
                  askf.a("0", 3);
                }
                while (!askf.a(this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
                  return;
                }
                askf.a("0", 2);
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
    subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf localDownloadEncryptConf = ayqh.a().a();
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
  
  public void onResp(aysz paramaysz)
  {
    super.onResp(paramaysz);
    Object localObject1 = new StringBuilder().append("directMsgUrlDown:").append(this.jdField_a_of_type_Boolean).append(" isEncrypt:");
    boolean bool;
    if ((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) {
      bool = true;
    }
    for (;;)
    {
      localObject1 = ((StringBuilder)localObject1).append(bool).append(" isRollBack:").append(this.jdField_f_of_type_Boolean).append(" result:");
      if (paramaysz.jdField_a_of_type_Int == 0)
      {
        bool = true;
        label82:
        b("onHttpResp", bool);
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Aysy != null)) {
          QLog.d("big_thumb", 2, "onResp" + this.jdField_a_of_type_Aywc.jdField_b_of_type_Int + "mUiRequest.mOutFilePath=" + this.jdField_a_of_type_Aywc.h + "url=" + ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label421;
        }
        localObject1 = this.jdField_d_of_type_Aypd;
        label190:
        if (paramaysz.jdField_a_of_type_Int != 0) {
          break label429;
        }
        bool = true;
        label199:
        a((aypd)localObject1, paramaysz, bool);
        this.jdField_a_of_type_Long = paramaysz.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long <= 0L) {
          this.jdField_a_of_type_Long = (paramaysz.jdField_b_of_type_Long + paramaysz.jdField_a_of_type_Aysy.jdField_a_of_type_Long);
        }
        this.jdField_b_of_type_Long += paramaysz.c;
        if ((paramaysz.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Aysy != null) && (this.jdField_a_of_type_Aysy.j)) {}
      }
      try
      {
        b(paramaysz);
        if (((this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) && (!a(paramaysz)))
        {
          this.jdField_d_of_type_Boolean = false;
          this.jdField_e_of_type_Boolean = false;
          this.jdField_f_of_type_Boolean = true;
          if (this.jdField_a_of_type_Aysy != null) {
            this.jdField_f_of_type_JavaLangString = ("checkPicFormat Erro, erroCode:" + paramaysz.jdField_b_of_type_Int + " ,erroDesc:" + paramaysz.jdField_a_of_type_JavaLangString + " ,encryptUrl:" + ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString + " ,ST:" + bbmx.a(this.jdField_a_of_type_ArrayOfByte));
          }
          b(true);
        }
        for (;;)
        {
          this.jdField_a_of_type_Aysy = null;
          return;
          bool = false;
          break;
          bool = false;
          break label82;
          label421:
          localObject1 = this.jdField_b_of_type_Aypd;
          break label190;
          label429:
          bool = false;
          break label199;
          e();
          a(paramaysz, true, "actRichMediaNetMonitor_picDown", this.jdField_a_of_type_Aywc.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString, null);
          continue;
          if ((paramaysz.jdField_b_of_type_Int == 9364) && (this.l < 3))
          {
            b("[netChg]", "failed.but net change detect.so retry");
            this.jdField_c_of_type_Int = 4;
            this.jdField_e_of_type_JavaLangString = paramaysz.jdField_a_of_type_JavaLangString;
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
            if (paramaysz.jdField_b_of_type_Int != -9527) {
              break label1039;
            }
            localObject1 = (String)paramaysz.jdField_a_of_type_JavaUtilHashMap.get(bbmu.jdField_f_of_type_JavaLangString);
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).split("_").length < 3)) {
              break label1150;
            }
            Object localObject3 = ((String)localObject1).split("_");
            localObject1 = localObject3[0];
            localObject2 = localObject3[1];
            localObject3 = localObject3[2];
            if ((!"H".equals(localObject1)) || (!"400".equals(localObject2)) || (!((String)localObject3).equals("-106")) || (!this.jdField_d_of_type_Boolean)) {
              break label1150;
            }
            bool = true;
            if (this.jdField_a_of_type_Aysy != null)
            {
              if ("encryptReqError=" + bool + ", ResErroCode:" + paramaysz.jdField_b_of_type_Int + " ,erroDesc:" + paramaysz.jdField_a_of_type_JavaLangString + " ,encryptUrl:" + ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString != null) {
                break label1054;
              }
              localObject1 = "null";
              label744:
              this.jdField_f_of_type_JavaLangString = ((String)localObject1);
            }
          }
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_c_of_type_Int = 3;
            this.jdField_e_of_type_JavaLangString = paramaysz.jdField_a_of_type_JavaLangString;
            if ((this instanceof ayre))
            {
              ayqh.a().a().a(2);
              label786:
              if (!this.jdField_f_of_type_Boolean) {
                break label1117;
              }
              b(true);
              label798:
              localObject1 = new HashMap();
              ((HashMap)localObject1).put("param_FailCode", String.valueOf(paramaysz.jdField_b_of_type_Int));
              ((HashMap)localObject1).put("param_errorDesc", paramaysz.jdField_a_of_type_JavaLangString);
              if (this.jdField_a_of_type_Aysy != null) {
                ((HashMap)localObject1).put("param_url", ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
              }
              axrn.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString, "report_direct_download_fail", false, (System.nanoTime() - this.k) / 1000000L, this.jdField_a_of_type_Long, (HashMap)localObject1, "");
            }
          }
          for (;;)
          {
            localObject1 = new StringBuffer();
            ((StringBuffer)localObject1).append(this.jdField_a_of_type_Aywc.jdField_a_of_type_Int);
            ((StringBuffer)localObject1).append(" isMsgDown:");
            ((StringBuffer)localObject1).append(this.jdField_a_of_type_Boolean);
            ((StringBuffer)localObject1).append(" result:");
            ((StringBuffer)localObject1).append(paramaysz.jdField_a_of_type_Int);
            ((StringBuffer)localObject1).append(" adr:");
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              break label1132;
            }
            paramaysz = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (paramaysz.hasNext())
            {
              localObject2 = (ayuq)paramaysz.next();
              try
              {
                ((StringBuffer)localObject1).append(bbkk.b(((ayuq)localObject2).jdField_a_of_type_JavaLangString) + ",");
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
            label1039:
            if (paramaysz.jdField_b_of_type_Int != 9058) {
              break label1150;
            }
            bool = true;
            break;
            label1054:
            localObject1 = ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString + " ,ST:" + bbmx.a(this.jdField_a_of_type_ArrayOfByte);
            break label744;
            if (!(this instanceof aypk)) {
              break label786;
            }
            ayqh.a().a().a(1);
            break label786;
            label1117:
            b(false);
            break label798;
            d();
          }
          label1132:
          QLog.d("BaseTransProcessor", 1, ((StringBuffer)localObject1).toString());
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          continue;
          label1150:
          bool = false;
        }
      }
    }
  }
  
  /* Error */
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc2_w 1000
    //   3: lload_2
    //   4: lmul
    //   5: lload 4
    //   7: ldiv
    //   8: l2i
    //   9: istore 6
    //   11: iload 6
    //   13: aload_0
    //   14: getfield 1002	ayox:jdField_b_of_type_Int	I
    //   17: if_icmple +33 -> 50
    //   20: aload_0
    //   21: iload 6
    //   23: putfield 1002	ayox:jdField_b_of_type_Int	I
    //   26: aload_0
    //   27: getfield 399	ayox:jdField_a_of_type_Aywf	Laywf;
    //   30: getfield 1005	aywf:jdField_a_of_type_ComTencentImageURLDrawableHandler	Lcom/tencent/image/URLDrawableHandler;
    //   33: ifnull +17 -> 50
    //   36: aload_0
    //   37: getfield 399	ayox:jdField_a_of_type_Aywf	Laywf;
    //   40: getfield 1005	aywf:jdField_a_of_type_ComTencentImageURLDrawableHandler	Lcom/tencent/image/URLDrawableHandler;
    //   43: iload 6
    //   45: invokeinterface 1010 2 0
    //   50: aload_0
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 560	ayox:jdField_a_of_type_Ayqo	Layqo;
    //   56: ifnull +13 -> 69
    //   59: aload_0
    //   60: getfield 560	ayox:jdField_a_of_type_Ayqo	Layqo;
    //   63: sipush 2002
    //   66: putfield 564	ayqo:d	I
    //   69: iconst_0
    //   70: istore 10
    //   72: iconst_0
    //   73: istore 11
    //   75: iconst_0
    //   76: istore 9
    //   78: aload_0
    //   79: getfield 126	ayox:jdField_a_of_type_Aywc	Laywc;
    //   82: astore 13
    //   84: aload 13
    //   86: getfield 1012	aywc:k	I
    //   89: istore 7
    //   91: iload 9
    //   93: istore 8
    //   95: aload 13
    //   97: getfield 161	aywc:i	I
    //   100: ifne +248 -> 348
    //   103: iload 9
    //   105: istore 8
    //   107: iload 7
    //   109: ifle +239 -> 348
    //   112: iload 9
    //   114: istore 8
    //   116: aload 13
    //   118: getfield 658	aywc:m	Ljava/lang/String;
    //   121: ifnull +227 -> 348
    //   124: new 194	java/io/File
    //   127: dup
    //   128: aload 13
    //   130: getfield 658	aywc:m	Ljava/lang/String;
    //   133: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: astore 14
    //   138: new 194	java/io/File
    //   141: dup
    //   142: aload_1
    //   143: getfield 117	aysy:d	Ljava/lang/String;
    //   146: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 16
    //   151: aload 16
    //   153: invokevirtual 207	java/io/File:length	()J
    //   156: lstore_2
    //   157: iload 9
    //   159: istore 8
    //   161: aload 14
    //   163: invokevirtual 218	java/io/File:exists	()Z
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
    //   191: new 194	java/io/File
    //   194: dup
    //   195: new 151	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   202: aload 13
    //   204: getfield 658	aywc:m	Ljava/lang/String;
    //   207: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 1014
    //   213: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore 15
    //   224: aconst_null
    //   225: astore 12
    //   227: aconst_null
    //   228: astore_1
    //   229: aload 16
    //   231: aload 15
    //   233: iconst_0
    //   234: iload 7
    //   236: invokestatic 1017	bbdx:a	(Ljava/io/File;Ljava/io/File;II)J
    //   239: lstore_2
    //   240: lload_2
    //   241: iload 7
    //   243: i2l
    //   244: lcmp
    //   245: ifeq +146 -> 391
    //   248: aload 15
    //   250: invokevirtual 218	java/io/File:exists	()Z
    //   253: ifeq +138 -> 391
    //   256: aload 15
    //   258: invokevirtual 249	java/io/File:delete	()Z
    //   261: pop
    //   262: iload 9
    //   264: istore 8
    //   266: aload_1
    //   267: ifnull +81 -> 348
    //   270: iload 10
    //   272: istore 9
    //   274: aload_1
    //   275: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   278: iload 10
    //   280: istore 9
    //   282: aload 15
    //   284: aload 14
    //   286: invokestatic 1019	bbdx:b	(Ljava/io/File;Ljava/io/File;)Z
    //   289: pop
    //   290: iconst_1
    //   291: istore 11
    //   293: iconst_1
    //   294: istore 10
    //   296: iload 10
    //   298: istore 8
    //   300: iload 11
    //   302: istore 9
    //   304: invokestatic 200	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   307: ifeq +41 -> 348
    //   310: iload 11
    //   312: istore 9
    //   314: ldc 202
    //   316: iconst_4
    //   317: new 151	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 1021
    //   327: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 13
    //   332: getfield 658	aywc:m	Ljava/lang/String;
    //   335: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: iload 10
    //   346: istore 8
    //   348: aload_0
    //   349: getfield 566	ayox:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   352: invokevirtual 300	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   355: astore_1
    //   356: aload_1
    //   357: invokeinterface 305 1 0
    //   362: ifeq +250 -> 612
    //   365: aload_1
    //   366: invokeinterface 309 1 0
    //   371: checkcast 568	auna
    //   374: iload 6
    //   376: iload 8
    //   378: invokeinterface 1024 3 0
    //   383: goto -27 -> 356
    //   386: astore_1
    //   387: aload_0
    //   388: monitorexit
    //   389: aload_1
    //   390: athrow
    //   391: new 220	java/io/RandomAccessFile
    //   394: dup
    //   395: aload 15
    //   397: ldc 222
    //   399: invokespecial 225	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   402: astore_1
    //   403: aload_1
    //   404: lload_2
    //   405: invokevirtual 229	java/io/RandomAccessFile:seek	(J)V
    //   408: aload_1
    //   409: iconst_2
    //   410: newarray byte
    //   412: dup
    //   413: iconst_0
    //   414: ldc 114
    //   416: bastore
    //   417: dup
    //   418: iconst_1
    //   419: ldc 115
    //   421: bastore
    //   422: invokevirtual 258	java/io/RandomAccessFile:write	([B)V
    //   425: goto -163 -> 262
    //   428: astore_1
    //   429: aload_1
    //   430: invokevirtual 252	java/io/IOException:printStackTrace	()V
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
    //   457: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   460: iload 11
    //   462: istore 9
    //   464: aload 15
    //   466: aload 14
    //   468: invokestatic 1019	bbdx:b	(Ljava/io/File;Ljava/io/File;)Z
    //   471: pop
    //   472: iconst_1
    //   473: istore 11
    //   475: iconst_1
    //   476: istore 10
    //   478: iload 10
    //   480: istore 8
    //   482: iload 11
    //   484: istore 9
    //   486: invokestatic 200	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   489: ifeq -141 -> 348
    //   492: iload 11
    //   494: istore 9
    //   496: ldc 202
    //   498: iconst_4
    //   499: new 151	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   506: ldc_w 1021
    //   509: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 13
    //   514: getfield 658	aywc:m	Ljava/lang/String;
    //   517: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: iload 10
    //   528: istore 8
    //   530: goto -182 -> 348
    //   533: astore_1
    //   534: aload_1
    //   535: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   538: iload 9
    //   540: istore 8
    //   542: goto -194 -> 348
    //   545: astore 12
    //   547: aconst_null
    //   548: astore_1
    //   549: aload_1
    //   550: ifnull +51 -> 601
    //   553: aload_1
    //   554: invokevirtual 245	java/io/RandomAccessFile:close	()V
    //   557: aload 15
    //   559: aload 14
    //   561: invokestatic 1019	bbdx:b	(Ljava/io/File;Ljava/io/File;)Z
    //   564: pop
    //   565: invokestatic 200	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   568: ifeq +33 -> 601
    //   571: ldc 202
    //   573: iconst_4
    //   574: new 151	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   581: ldc_w 1021
    //   584: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 13
    //   589: getfield 658	aywc:m	Ljava/lang/String;
    //   592: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: aload 12
    //   603: athrow
    //   604: astore_1
    //   605: aload_1
    //   606: invokevirtual 252	java/io/IOException:printStackTrace	()V
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
    //   0	625	0	this	ayox
    //   0	625	1	paramaysy	aysy
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
    //   82	506	13	localaywc	aywc
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
 * Qualified Name:     ayox
 * JD-Core Version:    0.7.0.1
 */