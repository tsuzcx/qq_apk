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
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;

public class bdss
  extends bdsr
  implements bdvx
{
  private static final Pattern a;
  protected bdzq a;
  public WeakNetLearner a;
  protected byte[] a;
  protected byte[] b;
  protected int c;
  private ArrayList<String> c;
  protected String e = "";
  protected String f;
  protected boolean f;
  protected boolean g;
  protected boolean h;
  protected boolean i;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(".*//[^/]*/[^/]*/(.*)/.*");
  }
  
  public bdss()
  {
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bdss(bdzi parambdzi, bdzn parambdzn)
  {
    super(parambdzi, parambdzn);
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner = bdta.jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner;
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
    g();
  }
  
  /* Error */
  private void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 83	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   13: aload_1
    //   14: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc 90
    //   19: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore 7
    //   27: aload_1
    //   28: aload 7
    //   30: invokestatic 100	bgmg:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   33: pop
    //   34: new 102	java/io/File
    //   37: dup
    //   38: aload 7
    //   40: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore 5
    //   45: new 102	java/io/File
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 8
    //   55: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   58: ifeq +41 -> 99
    //   61: ldc 113
    //   63: iconst_4
    //   64: new 83	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   71: ldc 115
    //   73: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 8
    //   78: invokevirtual 119	java/io/File:length	()J
    //   81: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: ldc 124
    //   86: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload 5
    //   101: invokevirtual 130	java/io/File:exists	()Z
    //   104: ifeq +139 -> 243
    //   107: aload 8
    //   109: invokevirtual 130	java/io/File:exists	()Z
    //   112: ifeq +131 -> 243
    //   115: new 132	java/io/RandomAccessFile
    //   118: dup
    //   119: aload 5
    //   121: ldc 134
    //   123: invokespecial 137	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   126: astore_2
    //   127: aload_2
    //   128: aload_0
    //   129: getfield 140	bdss:jdField_a_of_type_Bdzn	Lbdzn;
    //   132: getfield 144	bdzn:i	I
    //   135: i2l
    //   136: invokevirtual 148	java/io/RandomAccessFile:seek	(J)V
    //   139: new 150	java/io/FileInputStream
    //   142: dup
    //   143: aload 8
    //   145: invokespecial 153	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   148: astore 5
    //   150: sipush 1024
    //   153: newarray byte
    //   155: astore 4
    //   157: aload 5
    //   159: aload 4
    //   161: invokevirtual 157	java/io/FileInputStream:read	([B)I
    //   164: istore_3
    //   165: iload_3
    //   166: ifle +78 -> 244
    //   169: aload_2
    //   170: aload 4
    //   172: iconst_0
    //   173: iload_3
    //   174: invokevirtual 161	java/io/RandomAccessFile:write	([BII)V
    //   177: goto -20 -> 157
    //   180: astore 4
    //   182: aload_2
    //   183: astore 4
    //   185: aload 5
    //   187: astore_2
    //   188: aload 4
    //   190: ifnull +8 -> 198
    //   193: aload 4
    //   195: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   198: aload_2
    //   199: ifnull +7 -> 206
    //   202: aload_2
    //   203: invokevirtual 165	java/io/FileInputStream:close	()V
    //   206: aload 8
    //   208: invokevirtual 168	java/io/File:delete	()Z
    //   211: pop
    //   212: aload 7
    //   214: aload_1
    //   215: invokestatic 170	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   218: ifne +25 -> 243
    //   221: aload 7
    //   223: aload_1
    //   224: invokestatic 100	bgmg:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   227: ifeq +121 -> 348
    //   230: new 102	java/io/File
    //   233: dup
    //   234: aload 7
    //   236: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: invokevirtual 168	java/io/File:delete	()Z
    //   242: pop
    //   243: return
    //   244: aload_2
    //   245: ifnull +7 -> 252
    //   248: aload_2
    //   249: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   252: aload 5
    //   254: ifnull +8 -> 262
    //   257: aload 5
    //   259: invokevirtual 165	java/io/FileInputStream:close	()V
    //   262: aload 8
    //   264: invokevirtual 168	java/io/File:delete	()Z
    //   267: pop
    //   268: aload 7
    //   270: aload_1
    //   271: invokestatic 170	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   274: ifne -31 -> 243
    //   277: aload 7
    //   279: aload_1
    //   280: invokestatic 100	bgmg:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   283: ifeq +33 -> 316
    //   286: new 102	java/io/File
    //   289: dup
    //   290: aload 7
    //   292: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   295: invokevirtual 168	java/io/File:delete	()Z
    //   298: pop
    //   299: return
    //   300: astore_2
    //   301: aload_2
    //   302: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   305: goto -53 -> 252
    //   308: astore_2
    //   309: aload_2
    //   310: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   313: goto -51 -> 262
    //   316: new 102	java/io/File
    //   319: dup
    //   320: aload 7
    //   322: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   325: invokevirtual 168	java/io/File:delete	()Z
    //   328: pop
    //   329: return
    //   330: astore 4
    //   332: aload 4
    //   334: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   337: goto -139 -> 198
    //   340: astore_2
    //   341: aload_2
    //   342: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   345: goto -139 -> 206
    //   348: new 102	java/io/File
    //   351: dup
    //   352: aload 7
    //   354: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   357: invokevirtual 168	java/io/File:delete	()Z
    //   360: pop
    //   361: return
    //   362: astore 4
    //   364: aconst_null
    //   365: astore_2
    //   366: aload 6
    //   368: astore 5
    //   370: aload_2
    //   371: ifnull +7 -> 378
    //   374: aload_2
    //   375: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   378: aload 5
    //   380: ifnull +8 -> 388
    //   383: aload 5
    //   385: invokevirtual 165	java/io/FileInputStream:close	()V
    //   388: aload 8
    //   390: invokevirtual 168	java/io/File:delete	()Z
    //   393: pop
    //   394: aload 7
    //   396: aload_1
    //   397: invokestatic 170	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   400: ifne +25 -> 425
    //   403: aload 7
    //   405: aload_1
    //   406: invokestatic 100	bgmg:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   409: ifeq +35 -> 444
    //   412: new 102	java/io/File
    //   415: dup
    //   416: aload 7
    //   418: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   421: invokevirtual 168	java/io/File:delete	()Z
    //   424: pop
    //   425: aload 4
    //   427: athrow
    //   428: astore_2
    //   429: aload_2
    //   430: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   433: goto -55 -> 378
    //   436: astore_2
    //   437: aload_2
    //   438: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   441: goto -53 -> 388
    //   444: new 102	java/io/File
    //   447: dup
    //   448: aload 7
    //   450: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   453: invokevirtual 168	java/io/File:delete	()Z
    //   456: pop
    //   457: goto -32 -> 425
    //   460: astore 4
    //   462: aload 6
    //   464: astore 5
    //   466: goto -96 -> 370
    //   469: astore 4
    //   471: goto -101 -> 370
    //   474: astore_2
    //   475: aconst_null
    //   476: astore_2
    //   477: goto -289 -> 188
    //   480: astore 4
    //   482: aconst_null
    //   483: astore 5
    //   485: aload_2
    //   486: astore 4
    //   488: aload 5
    //   490: astore_2
    //   491: goto -303 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	bdss
    //   0	494	1	paramString1	String
    //   0	494	2	paramString2	String
    //   164	10	3	j	int
    //   4	167	4	arrayOfByte	byte[]
    //   180	1	4	localThrowable1	Throwable
    //   183	11	4	str1	String
    //   330	3	4	localIOException	java.io.IOException
    //   362	64	4	localObject1	Object
    //   460	1	4	localObject2	Object
    //   469	1	4	localObject3	Object
    //   480	1	4	localThrowable2	Throwable
    //   486	1	4	str2	String
    //   43	446	5	localObject4	Object
    //   1	462	6	localObject5	Object
    //   25	424	7	str3	String
    //   53	336	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   150	157	180	java/lang/Throwable
    //   157	165	180	java/lang/Throwable
    //   169	177	180	java/lang/Throwable
    //   248	252	300	java/io/IOException
    //   257	262	308	java/io/IOException
    //   193	198	330	java/io/IOException
    //   202	206	340	java/io/IOException
    //   115	127	362	finally
    //   374	378	428	java/io/IOException
    //   383	388	436	java/io/IOException
    //   127	150	460	finally
    //   150	157	469	finally
    //   157	165	469	finally
    //   169	177	469	finally
    //   115	127	474	java/lang/Throwable
    //   127	150	480	java/lang/Throwable
  }
  
  private boolean a(bdwt parambdwt)
  {
    if (parambdwt != null) {
      try
      {
        if (parambdwt.jdField_a_of_type_Bdws.jdField_c_of_type_JavaLangString != null)
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(parambdwt.jdField_a_of_type_Bdws.jdField_c_of_type_JavaLangString, localOptions);
          if (localOptions.outHeight > 0)
          {
            int j = localOptions.outWidth;
            if (j > 0) {}
          }
          else
          {
            return false;
          }
        }
      }
      catch (Throwable parambdwt)
      {
        parambdwt.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private void c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 102	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: new 102	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 130	java/io/File:exists	()Z
    //   24: ifeq +9 -> 33
    //   27: aload 4
    //   29: invokevirtual 168	java/io/File:delete	()Z
    //   32: pop
    //   33: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   36: ifeq +40 -> 76
    //   39: ldc 113
    //   41: iconst_4
    //   42: new 83	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   49: ldc 206
    //   51: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_3
    //   55: invokevirtual 119	java/io/File:length	()J
    //   58: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: ldc 124
    //   63: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_3
    //   77: invokevirtual 130	java/io/File:exists	()Z
    //   80: ifeq +87 -> 167
    //   83: new 132	java/io/RandomAccessFile
    //   86: dup
    //   87: aload_3
    //   88: ldc 134
    //   90: invokespecial 137	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   93: astore 4
    //   95: aload 4
    //   97: astore_3
    //   98: aload 4
    //   100: aload 4
    //   102: invokevirtual 207	java/io/RandomAccessFile:length	()J
    //   105: invokevirtual 148	java/io/RandomAccessFile:seek	(J)V
    //   108: aload 4
    //   110: astore_3
    //   111: aload 4
    //   113: iconst_2
    //   114: newarray byte
    //   116: dup
    //   117: iconst_0
    //   118: ldc 208
    //   120: bastore
    //   121: dup
    //   122: iconst_1
    //   123: ldc 209
    //   125: bastore
    //   126: invokevirtual 212	java/io/RandomAccessFile:write	([B)V
    //   129: aload 4
    //   131: ifnull +8 -> 139
    //   134: aload 4
    //   136: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   139: aload_2
    //   140: aload_1
    //   141: invokestatic 170	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   144: ifne +23 -> 167
    //   147: aload_2
    //   148: aload_1
    //   149: invokestatic 100	bgmg:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   152: ifeq +24 -> 176
    //   155: new 102	java/io/File
    //   158: dup
    //   159: aload_2
    //   160: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   163: invokevirtual 168	java/io/File:delete	()Z
    //   166: pop
    //   167: return
    //   168: astore_3
    //   169: aload_3
    //   170: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   173: goto -34 -> 139
    //   176: new 102	java/io/File
    //   179: dup
    //   180: aload_2
    //   181: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   184: invokevirtual 168	java/io/File:delete	()Z
    //   187: pop
    //   188: return
    //   189: astore 5
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 4
    //   196: astore_3
    //   197: aload 5
    //   199: invokevirtual 213	java/io/FileNotFoundException:printStackTrace	()V
    //   202: aload 4
    //   204: ifnull +8 -> 212
    //   207: aload 4
    //   209: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   212: aload_2
    //   213: aload_1
    //   214: invokestatic 170	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   217: ifne -50 -> 167
    //   220: aload_2
    //   221: aload_1
    //   222: invokestatic 100	bgmg:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   225: ifeq +24 -> 249
    //   228: new 102	java/io/File
    //   231: dup
    //   232: aload_2
    //   233: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   236: invokevirtual 168	java/io/File:delete	()Z
    //   239: pop
    //   240: return
    //   241: astore_3
    //   242: aload_3
    //   243: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   246: goto -34 -> 212
    //   249: new 102	java/io/File
    //   252: dup
    //   253: aload_2
    //   254: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   257: invokevirtual 168	java/io/File:delete	()Z
    //   260: pop
    //   261: return
    //   262: astore 5
    //   264: aconst_null
    //   265: astore 4
    //   267: aload 4
    //   269: astore_3
    //   270: aload 5
    //   272: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   275: aload 4
    //   277: ifnull +8 -> 285
    //   280: aload 4
    //   282: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   285: aload_2
    //   286: aload_1
    //   287: invokestatic 170	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   290: ifne -123 -> 167
    //   293: aload_2
    //   294: aload_1
    //   295: invokestatic 100	bgmg:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   298: ifeq +24 -> 322
    //   301: new 102	java/io/File
    //   304: dup
    //   305: aload_2
    //   306: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   309: invokevirtual 168	java/io/File:delete	()Z
    //   312: pop
    //   313: return
    //   314: astore_3
    //   315: aload_3
    //   316: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   319: goto -34 -> 285
    //   322: new 102	java/io/File
    //   325: dup
    //   326: aload_2
    //   327: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   330: invokevirtual 168	java/io/File:delete	()Z
    //   333: pop
    //   334: return
    //   335: astore 4
    //   337: aconst_null
    //   338: astore_3
    //   339: aload_3
    //   340: ifnull +7 -> 347
    //   343: aload_3
    //   344: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   347: aload_2
    //   348: aload_1
    //   349: invokestatic 170	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   352: ifne +23 -> 375
    //   355: aload_2
    //   356: aload_1
    //   357: invokestatic 100	bgmg:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   360: ifeq +26 -> 386
    //   363: new 102	java/io/File
    //   366: dup
    //   367: aload_2
    //   368: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   371: invokevirtual 168	java/io/File:delete	()Z
    //   374: pop
    //   375: aload 4
    //   377: athrow
    //   378: astore_3
    //   379: aload_3
    //   380: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   383: goto -36 -> 347
    //   386: new 102	java/io/File
    //   389: dup
    //   390: aload_2
    //   391: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   394: invokevirtual 168	java/io/File:delete	()Z
    //   397: pop
    //   398: goto -23 -> 375
    //   401: astore 4
    //   403: goto -64 -> 339
    //   406: astore 5
    //   408: goto -141 -> 267
    //   411: astore 5
    //   413: goto -219 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	bdss
    //   0	416	1	paramString1	String
    //   0	416	2	paramString2	String
    //   8	103	3	localObject1	Object
    //   168	2	3	localIOException1	java.io.IOException
    //   196	1	3	localObject2	Object
    //   241	2	3	localIOException2	java.io.IOException
    //   269	1	3	localObject3	Object
    //   314	2	3	localIOException3	java.io.IOException
    //   338	6	3	localObject4	Object
    //   378	2	3	localIOException4	java.io.IOException
    //   17	264	4	localObject5	Object
    //   335	41	4	localObject6	Object
    //   401	1	4	localObject7	Object
    //   189	9	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   262	9	5	localIOException5	java.io.IOException
    //   406	1	5	localIOException6	java.io.IOException
    //   411	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   134	139	168	java/io/IOException
    //   83	95	189	java/io/FileNotFoundException
    //   207	212	241	java/io/IOException
    //   83	95	262	java/io/IOException
    //   280	285	314	java/io/IOException
    //   83	95	335	finally
    //   343	347	378	java/io/IOException
    //   98	108	401	finally
    //   111	129	401	finally
    //   197	202	401	finally
    //   270	275	401	finally
    //   98	108	406	java/io/IOException
    //   111	129	406	java/io/IOException
    //   98	108	411	java/io/FileNotFoundException
    //   111	129	411	java/io/FileNotFoundException
  }
  
  private void d(bdwt parambdwt)
  {
    String str;
    if ((parambdwt.jdField_a_of_type_Bdws != null) && (parambdwt.jdField_a_of_type_Bdws.d != null) && (parambdwt.jdField_a_of_type_Bdws.d.length() != 0) && (parambdwt.jdField_a_of_type_Bdws.jdField_c_of_type_JavaLangString != null) && (parambdwt.jdField_a_of_type_Bdws.jdField_c_of_type_JavaLangString.length() != 0))
    {
      str = parambdwt.jdField_a_of_type_Bdws.d;
      parambdwt = parambdwt.jdField_a_of_type_Bdws.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_Bdzn != null) {
        break label77;
      }
    }
    label77:
    int j;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        bdxz.a(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int, String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long), "handleProgressiveJPEG", "mUiRequest.mRequestOffset: " + this.jdField_a_of_type_Bdzn.i + " mUiRequest.mRequestLength: " + this.jdField_a_of_type_Bdzn.jdField_j_of_type_Int + " tempPath: " + str + " outPath: " + parambdwt);
      }
      j = a(this.jdField_a_of_type_Bdzn);
      if (j == 4)
      {
        a(parambdwt, str);
        return;
      }
      if (j == 2)
      {
        c(parambdwt, str);
        return;
      }
    } while (j != 3);
    d(parambdwt, str);
  }
  
  /* Error */
  private void d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 83	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   13: aload_1
    //   14: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc 90
    //   19: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore 7
    //   27: aload_1
    //   28: aload 7
    //   30: invokestatic 100	bgmg:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   33: pop
    //   34: new 102	java/io/File
    //   37: dup
    //   38: aload 7
    //   40: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore 5
    //   45: new 102	java/io/File
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 8
    //   55: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   58: ifeq +42 -> 100
    //   61: ldc 113
    //   63: iconst_4
    //   64: new 83	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 269
    //   74: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 8
    //   79: invokevirtual 119	java/io/File:length	()J
    //   82: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: ldc 124
    //   87: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload 5
    //   102: invokevirtual 130	java/io/File:exists	()Z
    //   105: ifeq +139 -> 244
    //   108: aload 8
    //   110: invokevirtual 130	java/io/File:exists	()Z
    //   113: ifeq +131 -> 244
    //   116: new 132	java/io/RandomAccessFile
    //   119: dup
    //   120: aload 5
    //   122: ldc 134
    //   124: invokespecial 137	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   127: astore_2
    //   128: aload_2
    //   129: aload_0
    //   130: getfield 140	bdss:jdField_a_of_type_Bdzn	Lbdzn;
    //   133: getfield 144	bdzn:i	I
    //   136: i2l
    //   137: invokevirtual 148	java/io/RandomAccessFile:seek	(J)V
    //   140: new 150	java/io/FileInputStream
    //   143: dup
    //   144: aload 8
    //   146: invokespecial 153	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   149: astore 5
    //   151: sipush 1024
    //   154: newarray byte
    //   156: astore 4
    //   158: aload 5
    //   160: aload 4
    //   162: invokevirtual 157	java/io/FileInputStream:read	([B)I
    //   165: istore_3
    //   166: iload_3
    //   167: ifle +78 -> 245
    //   170: aload_2
    //   171: aload 4
    //   173: iconst_0
    //   174: iload_3
    //   175: invokevirtual 161	java/io/RandomAccessFile:write	([BII)V
    //   178: goto -20 -> 158
    //   181: astore 4
    //   183: aload_2
    //   184: astore 4
    //   186: aload 5
    //   188: astore_2
    //   189: aload 4
    //   191: ifnull +8 -> 199
    //   194: aload 4
    //   196: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   199: aload_2
    //   200: ifnull +7 -> 207
    //   203: aload_2
    //   204: invokevirtual 165	java/io/FileInputStream:close	()V
    //   207: aload 8
    //   209: invokevirtual 168	java/io/File:delete	()Z
    //   212: pop
    //   213: aload 7
    //   215: aload_1
    //   216: invokestatic 170	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   219: ifne +25 -> 244
    //   222: aload 7
    //   224: aload_1
    //   225: invokestatic 100	bgmg:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   228: ifeq +104 -> 332
    //   231: new 102	java/io/File
    //   234: dup
    //   235: aload 7
    //   237: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   240: invokevirtual 168	java/io/File:delete	()Z
    //   243: pop
    //   244: return
    //   245: aload_2
    //   246: iconst_2
    //   247: newarray byte
    //   249: dup
    //   250: iconst_0
    //   251: ldc 208
    //   253: bastore
    //   254: dup
    //   255: iconst_1
    //   256: ldc 209
    //   258: bastore
    //   259: invokevirtual 212	java/io/RandomAccessFile:write	([B)V
    //   262: aload_2
    //   263: ifnull +7 -> 270
    //   266: aload_2
    //   267: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   270: aload 5
    //   272: ifnull +8 -> 280
    //   275: aload 5
    //   277: invokevirtual 165	java/io/FileInputStream:close	()V
    //   280: aload 8
    //   282: invokevirtual 168	java/io/File:delete	()Z
    //   285: pop
    //   286: aload 7
    //   288: aload_1
    //   289: invokestatic 170	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   292: ifne -48 -> 244
    //   295: aload 7
    //   297: aload_1
    //   298: invokestatic 100	bgmg:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   301: ifeq +17 -> 318
    //   304: new 102	java/io/File
    //   307: dup
    //   308: aload 7
    //   310: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   313: invokevirtual 168	java/io/File:delete	()Z
    //   316: pop
    //   317: return
    //   318: new 102	java/io/File
    //   321: dup
    //   322: aload 7
    //   324: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   327: invokevirtual 168	java/io/File:delete	()Z
    //   330: pop
    //   331: return
    //   332: new 102	java/io/File
    //   335: dup
    //   336: aload 7
    //   338: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   341: invokevirtual 168	java/io/File:delete	()Z
    //   344: pop
    //   345: return
    //   346: astore 4
    //   348: aconst_null
    //   349: astore_2
    //   350: aload 6
    //   352: astore 5
    //   354: aload_2
    //   355: ifnull +7 -> 362
    //   358: aload_2
    //   359: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   362: aload 5
    //   364: ifnull +8 -> 372
    //   367: aload 5
    //   369: invokevirtual 165	java/io/FileInputStream:close	()V
    //   372: aload 8
    //   374: invokevirtual 168	java/io/File:delete	()Z
    //   377: pop
    //   378: aload 7
    //   380: aload_1
    //   381: invokestatic 170	bgmg:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   384: ifne +25 -> 409
    //   387: aload 7
    //   389: aload_1
    //   390: invokestatic 100	bgmg:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   393: ifeq +19 -> 412
    //   396: new 102	java/io/File
    //   399: dup
    //   400: aload 7
    //   402: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   405: invokevirtual 168	java/io/File:delete	()Z
    //   408: pop
    //   409: aload 4
    //   411: athrow
    //   412: new 102	java/io/File
    //   415: dup
    //   416: aload 7
    //   418: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   421: invokevirtual 168	java/io/File:delete	()Z
    //   424: pop
    //   425: goto -16 -> 409
    //   428: astore_2
    //   429: goto -159 -> 270
    //   432: astore_2
    //   433: goto -153 -> 280
    //   436: astore 4
    //   438: goto -239 -> 199
    //   441: astore_2
    //   442: goto -235 -> 207
    //   445: astore_2
    //   446: goto -84 -> 362
    //   449: astore_2
    //   450: goto -78 -> 372
    //   453: astore 4
    //   455: aload 6
    //   457: astore 5
    //   459: goto -105 -> 354
    //   462: astore 4
    //   464: goto -110 -> 354
    //   467: astore_2
    //   468: aconst_null
    //   469: astore_2
    //   470: goto -281 -> 189
    //   473: astore 4
    //   475: aconst_null
    //   476: astore 5
    //   478: aload_2
    //   479: astore 4
    //   481: aload 5
    //   483: astore_2
    //   484: goto -295 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	this	bdss
    //   0	487	1	paramString1	String
    //   0	487	2	paramString2	String
    //   165	10	3	j	int
    //   4	168	4	arrayOfByte	byte[]
    //   181	1	4	localIOException1	java.io.IOException
    //   184	11	4	str1	String
    //   346	64	4	localObject1	Object
    //   436	1	4	localIOException2	java.io.IOException
    //   453	1	4	localObject2	Object
    //   462	1	4	localObject3	Object
    //   473	1	4	localIOException3	java.io.IOException
    //   479	1	4	str2	String
    //   43	439	5	localObject4	Object
    //   1	455	6	localObject5	Object
    //   25	392	7	str3	String
    //   53	320	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   151	158	181	java/io/IOException
    //   158	166	181	java/io/IOException
    //   170	178	181	java/io/IOException
    //   245	262	181	java/io/IOException
    //   116	128	346	finally
    //   266	270	428	java/io/IOException
    //   275	280	432	java/io/IOException
    //   194	199	436	java/io/IOException
    //   203	207	441	java/io/IOException
    //   358	362	445	java/io/IOException
    //   367	372	449	java/io/IOException
    //   128	151	453	finally
    //   151	158	462	finally
    //   158	166	462	finally
    //   170	178	462	finally
    //   245	262	462	finally
    //   116	128	467	java/io/IOException
    //   128	151	473	java/io/IOException
  }
  
  int a(bdzn parambdzn)
  {
    if (parambdzn.i < 0) {}
    do
    {
      return 1;
      if (parambdzn.i > 0)
      {
        if (parambdzn.jdField_j_of_type_Int > 0) {
          return 3;
        }
        return 4;
      }
    } while (parambdzn.jdField_j_of_type_Int <= 0);
    return 2;
  }
  
  public String a(String paramString)
  {
    String str2 = b(paramString);
    Cryptor localCryptor = new Cryptor();
    if (str2 != null)
    {
      String str1 = str2 + "&encrypt=";
      if (this.g) {}
      for (str1 = str1 + "1";; str1 = str1 + "0") {
        return paramString.replace(str2, bgva.a(localCryptor.encrypt(str1.getBytes(), this.jdField_b_of_type_ArrayOfByte)));
      }
    }
    this.g = false;
    return paramString;
  }
  
  protected String a(String paramString, int paramInt)
  {
    String str = "&rf=other";
    if (this.jdField_a_of_type_Bdzn.g == 0)
    {
      str = "&rf=aio";
      str = "cldver=8.4.1.4680" + str;
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
      return paramString + "&msgTime=" + this.jdField_a_of_type_Bdzn.d;
      if (this.jdField_a_of_type_Bdzn.g != 1) {
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
  
  protected ArrayList<bdyf> a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        bdyf localbdyf = new bdyf();
        localbdyf.jdField_a_of_type_JavaLangString = str;
        localbdyf.jdField_a_of_type_Int = d();
        localbdyf.jdField_a_of_type_Boolean = paramBoolean;
        localArrayList.add(localbdyf);
      }
    }
    return localArrayList;
  }
  
  public void a(bdvs parambdvs, String paramString)
  {
    if (this.h)
    {
      parambdvs.jdField_a_of_type_JavaLangString = a(paramString);
      if (!paramString.equals(parambdvs.jdField_a_of_type_JavaLangString))
      {
        parambdvs.jdField_a_of_type_JavaUtilHashMap.put("Cookie", "mST=" + bgva.a(this.jdField_a_of_type_ArrayOfByte));
        if (this.g)
        {
          PicCryptor localPicCryptor = new PicCryptor(this.jdField_b_of_type_ArrayOfByte);
          localPicCryptor.a = parambdvs;
          parambdvs.jdField_a_of_type_Bdvt = localPicCryptor;
          parambdvs.d = (parambdvs.jdField_c_of_type_JavaLangString + "." + MD5.toMD5(bdxz.a(paramString, false)) + ".tmp");
        }
      }
    }
    for (;;)
    {
      if ((this.i) && (!this.g))
      {
        parambdvs.d = (parambdvs.jdField_c_of_type_JavaLangString + "." + MD5.toMD5(bdxz.a(paramString, false)) + ".tmp");
        parambdvs.jdField_a_of_type_JavaLangString = (paramString + "&rollback=1");
      }
      return;
      this.g = false;
    }
  }
  
  public void a(bdwt parambdwt)
  {
    int j = 0;
    if (!this.jdField_a_of_type_Bdws.k) {
      d(parambdwt);
    }
    if (((this.h) || (this.g)) && (!a(parambdwt)))
    {
      this.g = false;
      this.h = false;
      this.i = true;
      if (this.jdField_a_of_type_Bdws != null) {
        this.jdField_f_of_type_JavaLangString = ("checkPicFormat Erro, erroCode:" + parambdwt.jdField_b_of_type_Int + " ,erroDesc:" + parambdwt.jdField_a_of_type_JavaLangString + " ,encryptUrl:" + ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString + " ,ST:" + bgva.a(this.jdField_a_of_type_ArrayOfByte));
      }
      f();
      return;
    }
    e();
    bedj localbedj = this.jdField_a_of_type_Bedj;
    long l = this.jdField_b_of_type_Long;
    if (this.jdField_a_of_type_Bdzq == null) {}
    for (;;)
    {
      localbedj.jdField_b_of_type_Long = (l - j);
      a(parambdwt, true, "actRichMediaNetMonitor_picDown", this.jdField_a_of_type_Bdzn.e);
      return;
      j = this.jdField_a_of_type_Bdzq.jdField_a_of_type_Int;
    }
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    CompressInfo localCompressInfo;
    URL localURL;
    Object localObject;
    if (paramMessageForPic.fileSizeFlag == 1)
    {
      bool = true;
      if (this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int == bdzx.a("chatimg", bool))
      {
        localCompressInfo = new CompressInfo(this.jdField_a_of_type_Bdzn.h, 0);
        localURL = bdzx.a(paramMessageForPic, 65537);
        localCompressInfo.jdField_f_of_type_Boolean = true;
        localObject = bdsh.d(localURL.toString());
        if (!((String)localObject).endsWith("_hd"))
        {
          if (!((String)localObject).endsWith("_big400")) {
            break label228;
          }
          ((String)localObject).replace("_big400", "_hd");
          label99:
          localCompressInfo.e = ((String)localObject);
          localCompressInfo.a = paramMessageForPic.thumbWidthHeightDP;
          ayyz.b(localCompressInfo);
          if (localCompressInfo.e != null)
          {
            localObject = new File((String)localObject);
            if (!localCompressInfo.e.equals(localCompressInfo.jdField_c_of_type_JavaLangString)) {
              break label257;
            }
          }
        }
      }
    }
    label257:
    for (boolean bool = fd.a(new File(localCompressInfo.jdField_c_of_type_JavaLangString), (File)localObject);; bool = true)
    {
      if ((bool) && (BaseApplicationImpl.sImageCache.get(localURL.toString()) != null))
      {
        BaseApplicationImpl.sImageCache.remove(localURL.toString());
        localObject = URLDrawable.getDrawable(localURL);
        if (localObject != null)
        {
          if (paramMessageForPic.thumbWidthHeightDP != null) {
            break label252;
          }
          ((URLDrawable)localObject).downloadImediatly(true);
        }
      }
      return;
      bool = false;
      break;
      label228:
      localObject = (String)localObject + "_hd";
      break label99;
      label252:
      ((URLDrawable)localObject).invalidateSelf();
      return;
    }
  }
  
  void a(String paramString, int paramInt)
  {
    boolean bool = false;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bdzq.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0))
    {
      this.jdField_c_of_type_Int = 1;
      f();
      return;
    }
    if (!QLog.isColorLevel()) {}
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = a(a(InnerDns.getInstance().reqDnsForIpList(paramString, paramInt, true, 28, false), true), a(InnerDns.getInstance().reqDnsForIpList(paramString, paramInt, true, 1, false), false));
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break;
      }
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      this.d.a();
      paramString = aqti.a();
      if (paramString != null)
      {
        bool = paramString.a();
        if (QLog.isColorLevel()) {
          QLog.d("BaseTransProcessor", 2, "isHttps: " + bool);
        }
        if (bool)
        {
          this.g = false;
          this.h = false;
        }
      }
      b(bool);
      return;
      if (this.jdField_a_of_type_JavaLangString.contains("com.tencent.mobileqq"))
      {
        bcsz.a("Download_Pic_URL_Invalid", this.jdField_a_of_type_JavaLangString);
        QLog.d("BaseTransProcessor", 1, "directMsgUrlDown Download_Pic_URL_Invalid:" + this.jdField_a_of_type_JavaLangString);
      }
    }
    this.jdField_c_of_type_Int = 2;
    f();
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, HashMap<String, String> paramHashMap)
  {
    int j;
    String str;
    if (!paramBoolean)
    {
      j = this.jdField_j_of_type_Int;
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
      bctj.a(BaseApplication.getContext()).a(null, paramString, true, paramLong, this.jdField_a_of_type_Long, paramHashMap, null);
      return;
      label72:
      str = String.valueOf(j);
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int == 65537) {
      return true;
    }
    if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
    {
      long l1 = ((MessageForPic)this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).size;
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
  
  public void b(bdwt parambdwt)
  {
    if ((parambdwt.jdField_b_of_type_Int == 9364) && (this.l < 3))
    {
      b("[netChg]", "failed.but net change detect.so retry");
      this.jdField_c_of_type_Int = 4;
      this.e = parambdwt.jdField_a_of_type_JavaLangString;
      this.l += 1;
      n();
      f();
      return;
    }
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((this.g) || (this.h))
    {
      this.g = false;
      this.h = false;
      this.i = true;
      if (parambdwt.jdField_b_of_type_Int != -9527) {
        break label548;
      }
      localObject1 = (String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get(bgux.jdField_f_of_type_JavaLangString);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).split("_").length < 3)) {
        break label625;
      }
      Object localObject3 = ((String)localObject1).split("_");
      localObject1 = localObject3[0];
      localObject2 = localObject3[1];
      localObject3 = localObject3[2];
      if ((!"H".equals(localObject1)) || (!"400".equals(localObject2)) || (!((String)localObject3).equals("-106")) || (!this.g)) {
        break label625;
      }
      bool = true;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bdws != null)
      {
        if ("encryptReqError=" + bool + ", ResErroCode:" + parambdwt.jdField_b_of_type_Int + " ,erroDesc:" + parambdwt.jdField_a_of_type_JavaLangString + " ,encryptUrl:" + ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString == null)
        {
          localObject1 = "null";
          label278:
          this.jdField_f_of_type_JavaLangString = ((String)localObject1);
        }
      }
      else
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label606;
        }
        this.jdField_c_of_type_Int = 3;
        this.e = parambdwt.jdField_a_of_type_JavaLangString;
        f();
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_FailCode", String.valueOf(parambdwt.jdField_b_of_type_Int));
        ((HashMap)localObject1).put("param_errorDesc", parambdwt.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_Bdws != null) {
          ((HashMap)localObject1).put("param_url", ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
        }
        bctj.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString, "report_direct_download_fail", false, (System.nanoTime() - this.k) / 1000000L, this.jdField_a_of_type_Long, (HashMap)localObject1, "");
      }
      for (;;)
      {
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int);
        ((StringBuffer)localObject1).append(" isMsgDown:");
        ((StringBuffer)localObject1).append(this.jdField_a_of_type_Boolean);
        ((StringBuffer)localObject1).append(" result:");
        ((StringBuffer)localObject1).append(parambdwt.jdField_a_of_type_Int);
        ((StringBuffer)localObject1).append(" adr:");
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          break label613;
        }
        parambdwt = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (parambdwt.hasNext())
        {
          localObject2 = (bdyf)parambdwt.next();
          try
          {
            ((StringBuffer)localObject1).append(bgsp.b(((bdyf)localObject2).jdField_a_of_type_JavaLangString) + ",");
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        label548:
        if (parambdwt.jdField_b_of_type_Int != 9058) {
          break label625;
        }
        bool = true;
        break;
        localObject1 = ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString + " ,ST:" + bgva.a(this.jdField_a_of_type_ArrayOfByte);
        break label278;
        label606:
        d();
      }
      label613:
      QLog.d("BaseTransProcessor", 1, ((StringBuffer)localObject1).toString());
      return;
      label625:
      bool = false;
    }
  }
  
  void b(boolean paramBoolean) {}
  
  public void c(bdwt parambdwt)
  {
    bedj localbedj = this.jdField_a_of_type_Bedj;
    long l = this.jdField_b_of_type_Long;
    if (this.jdField_a_of_type_Bdzq == null) {}
    for (int j = 0;; j = this.jdField_a_of_type_Bdzq.jdField_a_of_type_Int)
    {
      localbedj.jdField_b_of_type_Long = (l - j);
      a(parambdwt, false, "actRichMediaNetMonitor_picDown", this.jdField_a_of_type_Bdzn.e);
      return;
    }
  }
  
  void d()
  {
    super.d();
    Object localObject1 = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Bdzu;
    if (localObject1 != null)
    {
      ((bdzu)localObject1).jdField_a_of_type_Int = -1;
      ((bdzu)localObject1).jdField_a_of_type_Long = this.jdField_j_of_type_Int;
      ((bdzu)localObject1).jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      ((bdzu)localObject1).jdField_a_of_type_Bdzn = this.jdField_a_of_type_Bdzn;
    }
    Object localObject4;
    try
    {
      if (this.jdField_a_of_type_Bduk != null) {
        this.jdField_a_of_type_Bduk.d = 2005;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (ayxc)((Iterator)localObject1).next();
        ayxd localayxd = new ayxd();
        localayxd.jdField_a_of_type_Int = -1;
        localayxd.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
        localayxd.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        ((ayxc)localObject4).a(localayxd);
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "onError ");
        }
      }
      if (this.jdField_a_of_type_Bduk == null) {
        break label174;
      }
    }
    finally {}
    b("notify", "start");
    label174:
    notifyAll();
    if (this.jdField_a_of_type_Bduk != null) {
      b("notify", "end");
    }
    int j;
    if ((this.jdField_j_of_type_Int == 9014) || (this.jdField_j_of_type_Int == 9050))
    {
      Object localObject3 = bdxz.a(((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
      if (localObject3 != null)
      {
        localObject3 = ((bdyf)localObject3).jdField_a_of_type_JavaLangString;
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
        j = -1201;
        label308:
        localObject3 = new ProbeRequest((String)localObject3, j, (ProbeItem)localObject4);
        if (this.jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner != null) {
          this.jdField_a_of_type_ComTencentMobileqqHighwayNetprobeWeakNetLearner.startProbe(new ProbeTask((ProbeRequest)localObject3));
        }
      }
    }
    d(2005);
    if (this.jdField_a_of_type_Bdzn != null)
    {
      if (!awmr.b(this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        break label415;
      }
      awmr.a(String.valueOf(this.jdField_j_of_type_Int), 3);
    }
    label381:
    while (!awmr.a(this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
    {
      return;
      ((ProbeChain)localObject4).addProbeItem(new PingProbe());
      ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
      break;
      j = -1202;
      break label308;
    }
    label408:
    label415:
    awmr.a(String.valueOf(this.jdField_j_of_type_Int), 2);
  }
  
  void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("big_thumb", 2, "onsuccess mUiRequest.mFileType" + this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int + "mUiRequest.mOutFilePath=" + this.jdField_a_of_type_Bdzn.h + "url=" + ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
    }
    i();
    for (;;)
    {
      Object localObject3;
      ayxd localayxd;
      boolean bool;
      try
      {
        if (this.jdField_a_of_type_Bduk != null) {
          this.jdField_a_of_type_Bduk.d = 2003;
        }
        Object localObject1 = this.jdField_a_of_type_Bdzn;
        if (((bdzn)localObject1).m != null)
        {
          localObject3 = new File(((bdzn)localObject1).m);
          if ((((File)localObject3).exists()) && (((File)localObject3).delete()) && (QLog.isDevelopLevel())) {
            QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():Delete " + ((bdzn)localObject1).m);
          }
        }
        int j = a(this.jdField_a_of_type_Bdzn);
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label399;
        }
        localObject3 = (ayxc)((Iterator)localObject1).next();
        localayxd = new ayxd();
        localayxd.jdField_a_of_type_Int = 0;
        localayxd.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.h;
        localayxd.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_f_of_type_JavaLangString;
        localayxd.jdField_c_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int;
        localayxd.d = this.jdField_a_of_type_Bdzn.g;
        if (j == 2) {
          break label495;
        }
        if (j != 3) {
          break label394;
        }
      }
      finally {}
      localayxd.jdField_a_of_type_Boolean = bool;
      ((ayxc)localObject3).a(localayxd);
      if ((this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int == 131075) && (QLog.isDevelopLevel())) {
        QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():" + this.jdField_a_of_type_Bdzn.h + ", isPart " + localayxd.jdField_a_of_type_Boolean);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PIC_TAG", 2, "onSuccess ");
        continue;
        label394:
        bool = false;
        continue;
        label399:
        if (this.jdField_a_of_type_Bduk != null) {
          b("notify", "start");
        }
        notifyAll();
        if (this.jdField_a_of_type_Bduk != null) {
          b("notify", "end");
        }
        d(2003);
        if (this.jdField_a_of_type_Bdzn != null)
        {
          if (!awmr.b(this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
            break label474;
          }
          awmr.a("0", 3);
        }
        label474:
        while (!awmr.a(this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          return;
        }
        awmr.a("0", 2);
        return;
        label495:
        bool = true;
      }
    }
  }
  
  void f() {}
  
  public void g()
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    this.jdField_b_of_type_ArrayOfByte = ((TicketManager)localObject).getStkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1600000226);
    this.jdField_a_of_type_ArrayOfByte = ((TicketManager)localObject).getSt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1600000226);
    subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf localDownloadEncryptConf = bdud.a().a();
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0) && (this.jdField_b_of_type_ArrayOfByte.length > 0) && (localDownloadEncryptConf != null))
    {
      this.h = localDownloadEncryptConf.bool_enable_encrypt_request.get();
      this.g = localDownloadEncryptConf.bool_enable_encrypted_pic.get();
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
        this.g = false;
        this.h = false;
      }
      return;
      this.g = false;
      this.h = false;
      break;
    }
  }
  
  public void h()
  {
    Object localObject2 = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    Object localObject1;
    if (GifDrawable.isGifFile(new File(this.jdField_a_of_type_Bdzn.h))) {
      if ((localObject2 != null) && ((localObject2 instanceof MessageForPic)))
      {
        localObject1 = (MessageForPic)localObject2;
        if (!((MessageForPic)localObject1).checkGif())
        {
          ((MessageForPic)localObject1).imageType = 2000;
          ((MessageForPic)localObject1).updateMessage();
        }
      }
    }
    label247:
    label250:
    for (;;)
    {
      return;
      if (bgln.d() >= 240)
      {
        if ((localObject2 instanceof MessageForMixedMsg))
        {
          localObject1 = ((MessageForMixedMsg)localObject2).getSubMessage(this.jdField_a_of_type_Bdzn.jdField_b_of_type_Long);
          if ((localObject1 == null) || (!(localObject1 instanceof MessageForPic))) {
            break label247;
          }
        }
        for (localObject1 = (MessageForPic)localObject1;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label250;
          }
          if (((annq.a((MessageRecord)localObject1)) || (anlk.a((MessageRecord)localObject1))) && (!TextUtils.isEmpty(((MessageForPic)localObject1).md5)))
          {
            localObject2 = this.jdField_a_of_type_Bdzn.h + "_fp";
            bglm.a(this.jdField_a_of_type_Bdzn.h, (String)localObject2, ((MessageForPic)localObject1).md5);
            return;
            localObject1 = localObject2;
            if (!(localObject2 instanceof MessageForStructing)) {
              break;
            }
            Object localObject3 = (MessageForStructing)localObject2;
            localObject1 = localObject2;
            if (!(((MessageForStructing)localObject3).structingMsg instanceof StructMsgForImageShare)) {
              break;
            }
            localObject3 = ((StructMsgForImageShare)((MessageForStructing)localObject3).structingMsg).getFirstImageElement();
            localObject1 = localObject2;
            if (localObject3 == null) {
              break;
            }
            localObject1 = localObject2;
            if (((bcxy)localObject3).a == null) {
              break;
            }
            localObject1 = ((bcxy)localObject3).a;
            break;
          }
          a((MessageForPic)localObject1);
          return;
        }
      }
    }
  }
  
  public void i()
  {
    bdzu localbdzu = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Bdzu;
    if (localbdzu != null)
    {
      localbdzu.jdField_a_of_type_Int = 0;
      localbdzu.jdField_a_of_type_Bdzn = this.jdField_a_of_type_Bdzn;
      try
      {
        if ((this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int == 65537) && (this.jdField_a_of_type_Bdzn.h != null)) {
          return;
        }
        if (((this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int == 131075)) && (this.jdField_a_of_type_Bdzn.h != null) && (this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
        {
          h();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PIC_TAG", 2, localThrowable.getMessage());
        }
      }
    }
  }
  
  public void onResp(bdwt parambdwt)
  {
    boolean bool2 = true;
    super.onResp(parambdwt);
    Object localObject = new StringBuilder().append("directMsgUrlDown:").append(this.jdField_a_of_type_Boolean).append(" isEncrypt:");
    boolean bool1;
    if ((this.g) || (this.h))
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(" isRollBack:").append(this.i).append(" result:");
      if (parambdwt.jdField_a_of_type_Int != 0) {
        break label290;
      }
      bool1 = true;
      label87:
      b("onHttpResp", bool1);
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Bdws != null)) {
        QLog.d("big_thumb", 2, "onResp" + this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int + "mUiRequest.mOutFilePath=" + this.jdField_a_of_type_Bdzn.h + "url=" + ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label295;
      }
      localObject = this.d;
      label197:
      if (parambdwt.jdField_a_of_type_Int != 0) {
        break label304;
      }
      bool1 = bool2;
      label206:
      a((bdsz)localObject, parambdwt, bool1);
      this.jdField_a_of_type_Long = parambdwt.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambdwt.jdField_b_of_type_Long + parambdwt.jdField_a_of_type_Bdws.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambdwt.c;
      if ((parambdwt.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_Bdws == null)) {
        break label309;
      }
      a(parambdwt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdws = null;
      return;
      bool1 = false;
      break;
      label290:
      bool1 = false;
      break label87;
      label295:
      localObject = this.jdField_b_of_type_Bdsz;
      break label197;
      label304:
      bool1 = false;
      break label206;
      label309:
      b(parambdwt);
    }
  }
  
  /* Error */
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc2_w 1035
    //   3: lload_2
    //   4: lmul
    //   5: lload 4
    //   7: ldiv
    //   8: l2i
    //   9: istore 6
    //   11: iload 6
    //   13: aload_0
    //   14: getfield 1037	bdss:jdField_b_of_type_Int	I
    //   17: if_icmple +33 -> 50
    //   20: aload_0
    //   21: iload 6
    //   23: putfield 1037	bdss:jdField_b_of_type_Int	I
    //   26: aload_0
    //   27: getfield 451	bdss:jdField_a_of_type_Bdzq	Lbdzq;
    //   30: getfield 1040	bdzq:jdField_a_of_type_ComTencentImageURLDrawableHandler	Lcom/tencent/image/URLDrawableHandler;
    //   33: ifnull +17 -> 50
    //   36: aload_0
    //   37: getfield 451	bdss:jdField_a_of_type_Bdzq	Lbdzq;
    //   40: getfield 1040	bdzq:jdField_a_of_type_ComTencentImageURLDrawableHandler	Lcom/tencent/image/URLDrawableHandler;
    //   43: iload 6
    //   45: invokeinterface 1045 2 0
    //   50: aload_0
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 787	bdss:jdField_a_of_type_Bduk	Lbduk;
    //   56: ifnull +13 -> 69
    //   59: aload_0
    //   60: getfield 787	bdss:jdField_a_of_type_Bduk	Lbduk;
    //   63: sipush 2002
    //   66: putfield 791	bduk:d	I
    //   69: iconst_0
    //   70: istore 10
    //   72: iconst_0
    //   73: istore 11
    //   75: iconst_0
    //   76: istore 9
    //   78: aload_0
    //   79: getfield 140	bdss:jdField_a_of_type_Bdzn	Lbdzn;
    //   82: astore 13
    //   84: aload 13
    //   86: getfield 1047	bdzn:k	I
    //   89: istore 7
    //   91: iload 9
    //   93: istore 8
    //   95: aload 13
    //   97: getfield 144	bdzn:i	I
    //   100: ifne +248 -> 348
    //   103: iload 9
    //   105: istore 8
    //   107: iload 7
    //   109: ifle +239 -> 348
    //   112: iload 9
    //   114: istore 8
    //   116: aload 13
    //   118: getfield 880	bdzn:m	Ljava/lang/String;
    //   121: ifnull +227 -> 348
    //   124: new 102	java/io/File
    //   127: dup
    //   128: aload 13
    //   130: getfield 880	bdzn:m	Ljava/lang/String;
    //   133: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: astore 14
    //   138: new 102	java/io/File
    //   141: dup
    //   142: aload_1
    //   143: getfield 216	bdws:d	Ljava/lang/String;
    //   146: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 16
    //   151: aload 16
    //   153: invokevirtual 119	java/io/File:length	()J
    //   156: lstore_2
    //   157: iload 9
    //   159: istore 8
    //   161: aload 14
    //   163: invokevirtual 130	java/io/File:exists	()Z
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
    //   191: new 102	java/io/File
    //   194: dup
    //   195: new 83	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   202: aload 13
    //   204: getfield 880	bdzn:m	Ljava/lang/String;
    //   207: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 1049
    //   213: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore 15
    //   224: aconst_null
    //   225: astore 12
    //   227: aconst_null
    //   228: astore_1
    //   229: aload 16
    //   231: aload 15
    //   233: iconst_0
    //   234: iload 7
    //   236: invokestatic 1052	bgmg:a	(Ljava/io/File;Ljava/io/File;II)J
    //   239: lstore_2
    //   240: lload_2
    //   241: iload 7
    //   243: i2l
    //   244: lcmp
    //   245: ifeq +146 -> 391
    //   248: aload 15
    //   250: invokevirtual 130	java/io/File:exists	()Z
    //   253: ifeq +138 -> 391
    //   256: aload 15
    //   258: invokevirtual 168	java/io/File:delete	()Z
    //   261: pop
    //   262: iload 9
    //   264: istore 8
    //   266: aload_1
    //   267: ifnull +81 -> 348
    //   270: iload 10
    //   272: istore 9
    //   274: aload_1
    //   275: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   278: iload 10
    //   280: istore 9
    //   282: aload 15
    //   284: aload 14
    //   286: invokestatic 1054	bgmg:b	(Ljava/io/File;Ljava/io/File;)Z
    //   289: pop
    //   290: iconst_1
    //   291: istore 11
    //   293: iconst_1
    //   294: istore 10
    //   296: iload 10
    //   298: istore 8
    //   300: iload 11
    //   302: istore 9
    //   304: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   307: ifeq +41 -> 348
    //   310: iload 11
    //   312: istore 9
    //   314: ldc 113
    //   316: iconst_4
    //   317: new 83	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 1056
    //   327: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 13
    //   332: getfield 880	bdzn:m	Ljava/lang/String;
    //   335: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: iload 10
    //   346: istore 8
    //   348: aload_0
    //   349: getfield 793	bdss:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   352: invokevirtual 342	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   355: astore_1
    //   356: aload_1
    //   357: invokeinterface 347 1 0
    //   362: ifeq +250 -> 612
    //   365: aload_1
    //   366: invokeinterface 351 1 0
    //   371: checkcast 795	ayxc
    //   374: iload 6
    //   376: iload 8
    //   378: invokeinterface 1059 3 0
    //   383: goto -27 -> 356
    //   386: astore_1
    //   387: aload_0
    //   388: monitorexit
    //   389: aload_1
    //   390: athrow
    //   391: new 132	java/io/RandomAccessFile
    //   394: dup
    //   395: aload 15
    //   397: ldc 134
    //   399: invokespecial 137	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   402: astore_1
    //   403: aload_1
    //   404: lload_2
    //   405: invokevirtual 148	java/io/RandomAccessFile:seek	(J)V
    //   408: aload_1
    //   409: iconst_2
    //   410: newarray byte
    //   412: dup
    //   413: iconst_0
    //   414: ldc 208
    //   416: bastore
    //   417: dup
    //   418: iconst_1
    //   419: ldc 209
    //   421: bastore
    //   422: invokevirtual 212	java/io/RandomAccessFile:write	([B)V
    //   425: goto -163 -> 262
    //   428: astore_1
    //   429: aload_1
    //   430: invokevirtual 173	java/io/IOException:printStackTrace	()V
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
    //   457: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   460: iload 11
    //   462: istore 9
    //   464: aload 15
    //   466: aload 14
    //   468: invokestatic 1054	bgmg:b	(Ljava/io/File;Ljava/io/File;)Z
    //   471: pop
    //   472: iconst_1
    //   473: istore 11
    //   475: iconst_1
    //   476: istore 10
    //   478: iload 10
    //   480: istore 8
    //   482: iload 11
    //   484: istore 9
    //   486: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   489: ifeq -141 -> 348
    //   492: iload 11
    //   494: istore 9
    //   496: ldc 113
    //   498: iconst_4
    //   499: new 83	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   506: ldc_w 1056
    //   509: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 13
    //   514: getfield 880	bdzn:m	Ljava/lang/String;
    //   517: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: iload 10
    //   528: istore 8
    //   530: goto -182 -> 348
    //   533: astore_1
    //   534: aload_1
    //   535: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   538: iload 9
    //   540: istore 8
    //   542: goto -194 -> 348
    //   545: astore 12
    //   547: aconst_null
    //   548: astore_1
    //   549: aload_1
    //   550: ifnull +51 -> 601
    //   553: aload_1
    //   554: invokevirtual 164	java/io/RandomAccessFile:close	()V
    //   557: aload 15
    //   559: aload 14
    //   561: invokestatic 1054	bgmg:b	(Ljava/io/File;Ljava/io/File;)Z
    //   564: pop
    //   565: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   568: ifeq +33 -> 601
    //   571: ldc 113
    //   573: iconst_4
    //   574: new 83	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   581: ldc_w 1056
    //   584: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 13
    //   589: getfield 880	bdzn:m	Ljava/lang/String;
    //   592: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: aload 12
    //   603: athrow
    //   604: astore_1
    //   605: aload_1
    //   606: invokevirtual 173	java/io/IOException:printStackTrace	()V
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
    //   0	625	0	this	bdss
    //   0	625	1	parambdws	bdws
    //   0	625	2	paramLong1	long
    //   0	625	4	paramLong2	long
    //   9	366	6	j	int
    //   89	153	7	k	int
    //   93	448	8	bool1	boolean
    //   76	463	9	bool2	boolean
    //   70	457	10	bool3	boolean
    //   73	420	11	bool4	boolean
    //   225	217	12	localObject1	Object
    //   545	57	12	localObject2	Object
    //   615	1	12	localObject3	Object
    //   620	1	12	localIOException	java.io.IOException
    //   82	506	13	localbdzn	bdzn
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdss
 * JD-Core Version:    0.7.0.1
 */