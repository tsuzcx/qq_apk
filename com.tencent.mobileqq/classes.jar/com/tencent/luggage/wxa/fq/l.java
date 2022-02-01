package com.tencent.luggage.wxa.fq;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.FileObserver;
import android.util.Log;
import com.eclipsesource.mmv8.V8;
import com.tencent.ilinkservice.ad;
import com.tencent.ilinkservice.ad.a;
import com.tencent.luggage.wxa.hg.f.a;
import com.tencent.luggage.wxa.ql.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.w;
import com.tencent.luggage.wxa.standalone_open_runtime.OpenRuntimeJNI;
import com.tencent.luggage.wxaapi.InitDynamicPkgResult;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.graphics.MMBitmapFactory.a;
import com.tencent.xweb.skia_canvas.IXWebLibraryLoader;
import com.tencent.xweb.skia_canvas.XWebLibraryLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/WxaDynamicPkgMgr;", "", "()V", "TAG", "", "abiType", "", "getAbiType", "()I", "setAbiType", "(I)V", "sCacheLibInfoMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getSCacheLibInfoMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "sCacheLibInfoMMKV$delegate", "Lkotlin/Lazy;", "sDynamicLibNames", "", "[Ljava/lang/String;", "sExcludeLibNames", "sFileObserver", "Landroid/os/FileObserver;", "sLibDirPath", "sLoadedCallbacks", "Ljava/util/LinkedHashSet;", "Lkotlin/Function0;", "", "Lkotlin/collections/LinkedHashSet;", "checkLibCacheValid", "", "libName", "checkLibDir", "createSubFolders", "filename", "path", "deleteLibFile", "genFileName", "genLibName", "fileName", "genPrivateFilePath", "getDynamicLibList", "context", "Landroid/content/Context;", "(Landroid/content/Context;)[Ljava/lang/String;", "getExcludeLibList", "()[Ljava/lang/String;", "initDynamicPkg", "Lcom/tencent/luggage/wxaapi/InitDynamicPkgResult;", "dynamicPkgPath", "initLoadLibrary", "isLoaded", "isPrivateLibValid", "loadLibraryInner", "logIfNeed", "message", "processLibName", "setupV8Flags", "unZipFile", "unZipPath", "zipPath", "waitForLoaded", "block", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class l
{
  public static final l a = new l();
  private static final String b = "WxaDynamicPkgMgr";
  private static String[] c;
  private static String[] d;
  private static int e = 2;
  private static String f = "";
  private static FileObserver g;
  private static LinkedHashSet<Function0<Unit>> h = new LinkedHashSet();
  private static final Lazy i = LazyKt.lazy((Function0)l.i.a);
  
  /* Error */
  private final boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 103	com/tencent/luggage/wxa/fq/l:f	Ljava/lang/String;
    //   3: astore 7
    //   5: aload 7
    //   7: ifnonnull +6 -> 13
    //   10: invokestatic 140	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   13: getstatic 145	java/io/File:separator	Ljava/lang/String;
    //   16: astore 8
    //   18: aload 8
    //   20: ldc 147
    //   22: invokestatic 151	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   25: iconst_0
    //   26: istore 6
    //   28: iconst_0
    //   29: istore 5
    //   31: aload 7
    //   33: aload 8
    //   35: iconst_0
    //   36: iconst_2
    //   37: aconst_null
    //   38: invokestatic 157	kotlin/text/StringsKt:endsWith$default	(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
    //   41: ifne +38 -> 79
    //   44: new 159	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   51: astore 7
    //   53: aload 7
    //   55: getstatic 103	com/tencent/luggage/wxa/fq/l:f	Ljava/lang/String;
    //   58: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 7
    //   64: getstatic 145	java/io/File:separator	Ljava/lang/String;
    //   67: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 7
    //   73: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: putstatic 103	com/tencent/luggage/wxa/fq/l:f	Ljava/lang/String;
    //   79: aconst_null
    //   80: checkcast 170	java/util/zip/ZipInputStream
    //   83: astore 10
    //   85: aconst_null
    //   86: checkcast 172	java/io/BufferedOutputStream
    //   89: astore 7
    //   91: aload 10
    //   93: astore 9
    //   95: aload 7
    //   97: astore 8
    //   99: new 170	java/util/zip/ZipInputStream
    //   102: dup
    //   103: new 174	java/io/BufferedInputStream
    //   106: dup
    //   107: new 176	java/io/FileInputStream
    //   110: dup
    //   111: aload_2
    //   112: invokespecial 178	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   115: checkcast 180	java/io/InputStream
    //   118: invokespecial 183	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   121: checkcast 180	java/io/InputStream
    //   124: invokespecial 184	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   127: astore_2
    //   128: aload 7
    //   130: astore 9
    //   132: aload 7
    //   134: astore 8
    //   136: new 186	kotlin/jvm/internal/Ref$ObjectRef
    //   139: dup
    //   140: invokespecial 187	kotlin/jvm/internal/Ref$ObjectRef:<init>	()V
    //   143: astore 10
    //   145: aload 7
    //   147: astore 9
    //   149: aload 7
    //   151: astore 8
    //   153: sipush 2048
    //   156: newarray byte
    //   158: astore 11
    //   160: aload 7
    //   162: astore 9
    //   164: aload 7
    //   166: astore 8
    //   168: new 189	kotlin/jvm/internal/Ref$IntRef
    //   171: dup
    //   172: invokespecial 190	kotlin/jvm/internal/Ref$IntRef:<init>	()V
    //   175: astore 12
    //   177: aload 7
    //   179: astore 9
    //   181: aload 7
    //   183: astore 8
    //   185: aload_2
    //   186: invokevirtual 194	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   189: astore 13
    //   191: aload 7
    //   193: astore 9
    //   195: aload 7
    //   197: astore 8
    //   199: aload 10
    //   201: aload 13
    //   203: putfield 198	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   206: aload 13
    //   208: ifnull +409 -> 617
    //   211: aload 7
    //   213: astore 9
    //   215: aload 7
    //   217: astore 8
    //   219: aload 10
    //   221: getfield 198	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   224: checkcast 200	java/util/zip/ZipEntry
    //   227: astore 13
    //   229: aload 13
    //   231: ifnonnull +14 -> 245
    //   234: aload 7
    //   236: astore 9
    //   238: aload 7
    //   240: astore 8
    //   242: invokestatic 140	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   245: aload 7
    //   247: astore 9
    //   249: aload 7
    //   251: astore 8
    //   253: aload 13
    //   255: invokevirtual 203	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   258: astore 13
    //   260: aload 7
    //   262: astore 9
    //   264: aload 7
    //   266: astore 8
    //   268: aload 13
    //   270: ldc 205
    //   272: invokestatic 151	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   275: aload 7
    //   277: astore 9
    //   279: aload 7
    //   281: astore 8
    //   283: aload 13
    //   285: checkcast 207	java/lang/CharSequence
    //   288: ldc 209
    //   290: checkcast 207	java/lang/CharSequence
    //   293: iconst_0
    //   294: iconst_2
    //   295: aconst_null
    //   296: invokestatic 213	kotlin/text/StringsKt:contains$default	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
    //   299: ifne -122 -> 177
    //   302: aload 7
    //   304: astore 9
    //   306: aload 7
    //   308: astore 8
    //   310: aload 13
    //   312: checkcast 207	java/lang/CharSequence
    //   315: ldc 215
    //   317: checkcast 207	java/lang/CharSequence
    //   320: iconst_0
    //   321: iconst_2
    //   322: aconst_null
    //   323: invokestatic 213	kotlin/text/StringsKt:contains$default	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
    //   326: ifeq +6 -> 332
    //   329: goto -152 -> 177
    //   332: aload 7
    //   334: astore 9
    //   336: aload 7
    //   338: astore 8
    //   340: aload_0
    //   341: aload 13
    //   343: aload_1
    //   344: invokespecial 218	com/tencent/luggage/wxa/fq/l:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload 7
    //   349: astore 9
    //   351: aload 7
    //   353: astore 8
    //   355: aload 10
    //   357: getfield 198	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   360: checkcast 200	java/util/zip/ZipEntry
    //   363: astore 14
    //   365: aload 14
    //   367: ifnonnull +14 -> 381
    //   370: aload 7
    //   372: astore 9
    //   374: aload 7
    //   376: astore 8
    //   378: invokestatic 140	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   381: aload 7
    //   383: astore 9
    //   385: aload 7
    //   387: astore 8
    //   389: aload 14
    //   391: invokevirtual 222	java/util/zip/ZipEntry:isDirectory	()Z
    //   394: ifeq +78 -> 472
    //   397: aload 7
    //   399: astore 9
    //   401: aload 7
    //   403: astore 8
    //   405: new 159	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   412: astore 14
    //   414: aload 7
    //   416: astore 9
    //   418: aload 7
    //   420: astore 8
    //   422: aload 14
    //   424: aload_1
    //   425: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 7
    //   431: astore 9
    //   433: aload 7
    //   435: astore 8
    //   437: aload 14
    //   439: aload 13
    //   441: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload 7
    //   447: astore 9
    //   449: aload 7
    //   451: astore 8
    //   453: new 142	java/io/File
    //   456: dup
    //   457: aload 14
    //   459: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   465: invokevirtual 226	java/io/File:mkdirs	()Z
    //   468: pop
    //   469: goto -292 -> 177
    //   472: aload 7
    //   474: astore 9
    //   476: aload 7
    //   478: astore 8
    //   480: new 159	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   487: astore 14
    //   489: aload 7
    //   491: astore 9
    //   493: aload 7
    //   495: astore 8
    //   497: aload 14
    //   499: aload_1
    //   500: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 7
    //   506: astore 9
    //   508: aload 7
    //   510: astore 8
    //   512: aload 14
    //   514: aload 13
    //   516: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload 7
    //   522: astore 9
    //   524: aload 7
    //   526: astore 8
    //   528: new 172	java/io/BufferedOutputStream
    //   531: dup
    //   532: new 228	java/io/FileOutputStream
    //   535: dup
    //   536: aload 14
    //   538: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokespecial 229	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   544: checkcast 231	java/io/OutputStream
    //   547: invokespecial 234	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   550: astore 7
    //   552: aload_2
    //   553: aload 11
    //   555: invokevirtual 238	java/util/zip/ZipInputStream:read	([B)I
    //   558: istore_3
    //   559: aload 12
    //   561: iload_3
    //   562: putfield 240	kotlin/jvm/internal/Ref$IntRef:element	I
    //   565: iload_3
    //   566: iconst_m1
    //   567: if_icmpeq +19 -> 586
    //   570: aload 7
    //   572: aload 11
    //   574: iconst_0
    //   575: aload 12
    //   577: getfield 240	kotlin/jvm/internal/Ref$IntRef:element	I
    //   580: invokevirtual 244	java/io/BufferedOutputStream:write	([BII)V
    //   583: goto -31 -> 552
    //   586: aload 7
    //   588: invokevirtual 247	java/io/BufferedOutputStream:flush	()V
    //   591: aload 7
    //   593: invokevirtual 250	java/io/BufferedOutputStream:close	()V
    //   596: goto -419 -> 177
    //   599: astore_1
    //   600: aload 7
    //   602: astore 8
    //   604: goto +152 -> 756
    //   607: astore 8
    //   609: aload_2
    //   610: astore_1
    //   611: aload 8
    //   613: astore_2
    //   614: goto +86 -> 700
    //   617: iconst_1
    //   618: istore 6
    //   620: iconst_1
    //   621: istore 5
    //   623: iload 5
    //   625: istore 4
    //   627: aload_2
    //   628: invokevirtual 253	java/util/zip/ZipInputStream:closeEntry	()V
    //   631: iload 5
    //   633: istore 4
    //   635: aload_2
    //   636: invokevirtual 254	java/util/zip/ZipInputStream:close	()V
    //   639: iload 6
    //   641: istore 4
    //   643: aload 7
    //   645: ifnull +108 -> 753
    //   648: iload 5
    //   650: istore 4
    //   652: aload 7
    //   654: invokevirtual 250	java/io/BufferedOutputStream:close	()V
    //   657: iconst_1
    //   658: ireturn
    //   659: astore_1
    //   660: aload_1
    //   661: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   664: iload 4
    //   666: ireturn
    //   667: astore_1
    //   668: aload 9
    //   670: astore 8
    //   672: goto +84 -> 756
    //   675: astore 9
    //   677: aload_2
    //   678: astore_1
    //   679: aload 8
    //   681: astore 7
    //   683: aload 9
    //   685: astore_2
    //   686: goto +14 -> 700
    //   689: astore_1
    //   690: aload 9
    //   692: astore_2
    //   693: goto +63 -> 756
    //   696: astore_2
    //   697: aload 10
    //   699: astore_1
    //   700: aload_1
    //   701: astore 9
    //   703: aload 7
    //   705: astore 8
    //   707: aload_2
    //   708: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   711: aload_1
    //   712: ifnull +19 -> 731
    //   715: iload 5
    //   717: istore 4
    //   719: aload_1
    //   720: invokevirtual 253	java/util/zip/ZipInputStream:closeEntry	()V
    //   723: iload 5
    //   725: istore 4
    //   727: aload_1
    //   728: invokevirtual 254	java/util/zip/ZipInputStream:close	()V
    //   731: iload 6
    //   733: istore 4
    //   735: aload 7
    //   737: ifnull +16 -> 753
    //   740: iload 5
    //   742: istore 4
    //   744: aload 7
    //   746: invokevirtual 250	java/io/BufferedOutputStream:close	()V
    //   749: iload 6
    //   751: istore 4
    //   753: iload 4
    //   755: ireturn
    //   756: aload_2
    //   757: ifnull +14 -> 771
    //   760: aload_2
    //   761: invokevirtual 253	java/util/zip/ZipInputStream:closeEntry	()V
    //   764: aload_2
    //   765: invokevirtual 254	java/util/zip/ZipInputStream:close	()V
    //   768: goto +3 -> 771
    //   771: aload 8
    //   773: ifnull +15 -> 788
    //   776: aload 8
    //   778: invokevirtual 250	java/io/BufferedOutputStream:close	()V
    //   781: goto +7 -> 788
    //   784: aload_2
    //   785: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   788: goto +5 -> 793
    //   791: aload_1
    //   792: athrow
    //   793: goto -2 -> 791
    //   796: astore_2
    //   797: goto -13 -> 784
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	800	0	this	l
    //   0	800	1	paramString1	String
    //   0	800	2	paramString2	String
    //   558	10	3	j	int
    //   625	129	4	bool1	boolean
    //   29	712	5	bool2	boolean
    //   26	724	6	bool3	boolean
    //   3	742	7	localObject1	Object
    //   16	587	8	localObject2	Object
    //   607	5	8	localIOException1	java.io.IOException
    //   670	107	8	localObject3	Object
    //   93	576	9	localObject4	Object
    //   675	16	9	localIOException2	java.io.IOException
    //   701	1	9	str	String
    //   83	615	10	localObject5	Object
    //   158	415	11	arrayOfByte	byte[]
    //   175	401	12	localIntRef	kotlin.jvm.internal.Ref.IntRef
    //   189	326	13	localObject6	Object
    //   363	174	14	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   552	565	599	finally
    //   570	583	599	finally
    //   586	596	599	finally
    //   552	565	607	java/io/IOException
    //   570	583	607	java/io/IOException
    //   586	596	607	java/io/IOException
    //   627	631	659	java/io/IOException
    //   635	639	659	java/io/IOException
    //   652	657	659	java/io/IOException
    //   719	723	659	java/io/IOException
    //   727	731	659	java/io/IOException
    //   744	749	659	java/io/IOException
    //   136	145	667	finally
    //   153	160	667	finally
    //   168	177	667	finally
    //   185	191	667	finally
    //   199	206	667	finally
    //   219	229	667	finally
    //   242	245	667	finally
    //   253	260	667	finally
    //   268	275	667	finally
    //   283	302	667	finally
    //   310	329	667	finally
    //   340	347	667	finally
    //   355	365	667	finally
    //   378	381	667	finally
    //   389	397	667	finally
    //   405	414	667	finally
    //   422	429	667	finally
    //   437	445	667	finally
    //   453	469	667	finally
    //   480	489	667	finally
    //   497	504	667	finally
    //   512	520	667	finally
    //   528	552	667	finally
    //   136	145	675	java/io/IOException
    //   153	160	675	java/io/IOException
    //   168	177	675	java/io/IOException
    //   185	191	675	java/io/IOException
    //   199	206	675	java/io/IOException
    //   219	229	675	java/io/IOException
    //   242	245	675	java/io/IOException
    //   253	260	675	java/io/IOException
    //   268	275	675	java/io/IOException
    //   283	302	675	java/io/IOException
    //   310	329	675	java/io/IOException
    //   340	347	675	java/io/IOException
    //   355	365	675	java/io/IOException
    //   378	381	675	java/io/IOException
    //   389	397	675	java/io/IOException
    //   405	414	675	java/io/IOException
    //   422	429	675	java/io/IOException
    //   437	445	675	java/io/IOException
    //   453	469	675	java/io/IOException
    //   480	489	675	java/io/IOException
    //   497	504	675	java/io/IOException
    //   512	520	675	java/io/IOException
    //   528	552	675	java/io/IOException
    //   99	128	689	finally
    //   707	711	689	finally
    //   99	128	696	java/io/IOException
    //   760	768	796	java/io/IOException
    //   776	781	796	java/io/IOException
  }
  
  private final void b(String paramString)
  {
    String str = b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load library ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(getClass().getClassLoader());
    o.d(str, ((StringBuilder)localObject).toString());
    str = c(paramString);
    localObject = c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("sDynamicLibNames");
    }
    if (ArraysKt.contains((Object[])localObject, str))
    {
      if (e(str))
      {
        localObject = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load library succss: ");
        localStringBuilder.append(paramString);
        o.c((String)localObject, localStringBuilder.toString());
        System.load(f(str));
        return;
      }
      str = b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load library fail: ");
      ((StringBuilder)localObject).append(paramString);
      o.b(str, ((StringBuilder)localObject).toString());
      return;
    }
    paramString = d;
    if (paramString == null) {
      Intrinsics.throwUninitializedPropertyAccessException("sExcludeLibNames");
    }
    if (!ArraysKt.contains(paramString, str)) {
      System.loadLibrary(str);
    }
  }
  
  private final void b(String paramString1, String paramString2)
  {
    paramString1 = (CharSequence)paramString1;
    int j = 0;
    paramString1 = ((Collection)StringsKt.split$default(paramString1, new String[] { "/" }, false, 0, 6, null)).toArray(new String[0]);
    if (paramString1 != null)
    {
      paramString1 = (String[])paramString1;
      if (paramString1.length <= 1) {
        return;
      }
      int k = paramString1.length;
      while (j < k - 1)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(paramString1[j]);
        ((StringBuilder)localObject).append("/");
        paramString2 = ((StringBuilder)localObject).toString();
        localObject = new File(paramString2);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        j += 1;
      }
      return;
    }
    paramString1 = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramString1;
    }
  }
  
  private final String[] b(Context paramContext)
  {
    if (e == 1) {
      paramContext = "armeabi-v7a";
    } else {
      paramContext = "arm64-v8a";
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = OpenRuntimeJNI.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "config");
    localObject1 = ((Iterable)StringsKt.split$default((CharSequence)localObject1, new String[] { "|" }, false, 0, 6, null)).iterator();
    int j = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (j < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject2 = (String)localObject2;
      if (j % 3 == 0)
      {
        Object localObject3 = (CharSequence)localObject2;
        if (StringsKt.contains$default((CharSequence)localObject3, (CharSequence)paramContext, false, 2, null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("DynamicPkg-");
          localStringBuilder.append(paramContext);
          if (!StringsKt.contains$default((CharSequence)localObject3, (CharSequence)localStringBuilder.toString(), false, 2, null))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append('-');
            ((StringBuilder)localObject3).append(paramContext);
            localArrayList.add(StringsKt.replace$default((String)localObject2, ((StringBuilder)localObject3).toString(), "", false, 4, null));
          }
        }
      }
      j += 1;
    }
    paramContext = ((Collection)localArrayList).toArray(new String[0]);
    if (paramContext != null) {
      return (String[])paramContext;
    }
    paramContext = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramContext;
    }
  }
  
  private final String c(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      return paramString;
    case 1573188013: 
      if (!paramString.equals("magicbrush")) {
        return paramString;
      }
      b("mmvulkan");
      b("commonimgdec");
      b("native-iv");
      b("mmnode");
      return paramString;
    case 1187197227: 
      if (!paramString.equals("mmwcwss")) {
        return paramString;
      }
      b("wcwss");
      return paramString;
    case 1180883462: 
      if (!paramString.equals("mmphysx")) {
        return paramString;
      }
      break;
    case 1179474958: 
      if (!paramString.equals("wmpfcommonjni")) {
        return paramString;
      }
      b("FFmpeg");
      b("wechatpack");
      return paramString;
    case 1168159709: 
      if (!paramString.equals("mmbox2d")) {
        return paramString;
      }
      c();
      b("mmv8");
      return paramString;
    case -80394285: 
      if (!paramString.equals("mmimgcodec")) {
        return paramString;
      }
      b("commonimgdec");
      return paramString;
    }
    if (paramString.equals("qm_native_decoder_ffmpeg")) {
      b("FFmpeg");
    }
    return paramString;
  }
  
  private final void c()
  {
    if (((StringsKt.equals(Build.MANUFACTURER, "Xiaomi", true)) || (StringsKt.equals(Build.MANUFACTURER, "Vivo", true))) && ((Build.VERSION.SDK_INT == 27) || (Build.VERSION.SDK_INT == 28))) {
      V8.setFlags("--single-threaded-gc");
    }
  }
  
  private final w d()
  {
    return (w)i.getValue();
  }
  
  private final boolean d(String paramString)
  {
    if (d().e(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" checkLibCacheValid true");
      i(localStringBuilder.toString());
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" checkLibCacheValid false");
    i(localStringBuilder.toString());
    return false;
  }
  
  private final void e()
  {
    Object localObject1 = new File(f);
    if (!((File)localObject1).exists())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sLibDir:");
      ((StringBuilder)localObject2).append(f);
      ((StringBuilder)localObject2).append(" is null, err return");
      o.b((String)localObject1, ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject2 = ((File)localObject1).listFiles();
    localObject1 = new StringBuffer();
    if (localObject2 != null)
    {
      int k = localObject2.length;
      int j = 0;
      while (j < k)
      {
        localStringBuilder1 = localObject2[j];
        if (localStringBuilder1 != null)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(" [");
          localStringBuilder2.append(localStringBuilder1.getName());
          localStringBuilder2.append(' ');
          localStringBuilder2.append(localStringBuilder1.length());
          localStringBuilder2.append("] ");
          ((StringBuffer)localObject1).append(localStringBuilder2.toString());
        }
        j += 1;
      }
    }
    localObject2 = b;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("libs: ");
    localStringBuilder1.append((StringBuffer)localObject1);
    o.d((String)localObject2, localStringBuilder1.toString());
  }
  
  private final boolean e(String paramString)
  {
    Object localObject;
    if (d(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" isPrivateLibValid true");
      i(((StringBuilder)localObject).toString());
      return true;
    }
    boolean bool = OpenRuntimeJNI.a(f(paramString), paramString, e);
    if (bool)
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" sCacheLibInfoMMKV save");
      ((l)localObject).i(localStringBuilder.toString());
      a.d().putInt(paramString, 0).commit();
    }
    return bool;
  }
  
  private final String f(String paramString)
  {
    if (StringsKt.contains$default((CharSequence)paramString, (CharSequence)"wxa_library", false, 2, null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(f);
      localStringBuilder.append(paramString);
      localStringBuilder.append(".zip");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(f);
    localStringBuilder.append(g(paramString));
    return localStringBuilder.toString();
  }
  
  private final String[] f()
  {
    return new String[0];
  }
  
  private final String g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return localStringBuilder.toString();
  }
  
  private final String h(String paramString)
  {
    int j = paramString.length();
    if (paramString != null)
    {
      paramString = paramString.substring(3, j - 3);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final void i(String paramString)
  {
    if (f.a.b()) {
      o.d(b, paramString);
    }
  }
  
  @NotNull
  public final InitDynamicPkgResult a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "dynamicPkgPath");
    Object localObject = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDynamicPkg dirPath:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", sLibDirPath:");
    localStringBuilder.append(f);
    localStringBuilder.append(", abiType:");
    localStringBuilder.append(e);
    o.d((String)localObject, localStringBuilder.toString());
    if (!new File(paramString).exists())
    {
      o.b(b, "dirPath isn't exist, return");
      return InitDynamicPkgResult.FailDynamicPkgPathNotExist;
    }
    if (!OpenRuntimeJNI.a(paramString, e))
    {
      o.b(b, "checkMd5 fail");
      return InitDynamicPkgResult.FailCheckInvalid;
    }
    if (b()) {
      return InitDynamicPkgResult.OK;
    }
    localObject = g;
    if (localObject != null) {
      ((FileObserver)localObject).stopWatching();
    }
    e();
    a(f, paramString);
    localObject = c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("sDynamicLibNames");
    }
    int k = localObject.length;
    int j = 0;
    while (j < k)
    {
      paramString = localObject[j];
      if (!e(paramString))
      {
        localObject = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initDynamicPkg fail: ");
        localStringBuilder.append(paramString);
        o.b((String)localObject, localStringBuilder.toString());
        return InitDynamicPkgResult.FailCheckInvalid;
      }
      j += 1;
    }
    e();
    paramString = new LinkedHashSet();
    try
    {
      paramString.addAll((Collection)h);
      h.clear();
      localObject = Unit.INSTANCE;
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext()) {
        ((Function0)paramString.next()).invoke();
      }
      paramString = g;
      if (paramString != null) {
        paramString.startWatching();
      }
      return InitDynamicPkgResult.OK;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public final void a()
  {
    Object localObject1 = new File(f);
    if (!((File)localObject1).exists())
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(f);
      ((StringBuilder)localObject2).append(" is empty");
      o.b((String)localObject1, ((StringBuilder)localObject2).toString());
      return;
    }
    localObject1 = ((File)localObject1).list();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "names");
    int j;
    if (localObject1.length == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(f);
      ((StringBuilder)localObject2).append(" is empty, names is null");
      o.b((String)localObject1, ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(f);
    ((StringBuilder)localObject2).append(localObject1[0]);
    localObject2 = new File(((StringBuilder)localObject2).toString());
    if (!((File)localObject2).exists())
    {
      localObject2 = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject1[0]);
      localStringBuilder.append(" not exist");
      o.b((String)localObject2, localStringBuilder.toString());
      return;
    }
    ((File)localObject2).delete();
  }
  
  public final void a(int paramInt)
  {
    e = paramInt;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (r.h()) {
      d().d();
    }
    OpenRuntimeJNI.a(paramContext);
    c = b(paramContext);
    d = f();
    Object localObject1 = paramContext.getDir("libs", 0);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.getDir(\"libs\", Context.MODE_PRIVATE)");
    localObject1 = ((File)localObject1).getAbsolutePath();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.getDir(\"libs\", C…ODE_PRIVATE).absolutePath");
    f = (String)localObject1;
    localObject1 = f;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    Object localObject2 = File.separator;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "File.separator");
    if (!StringsKt.endsWith$default((String)localObject1, (String)localObject2, false, 2, null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(f);
      ((StringBuilder)localObject1).append(File.separator);
      f = ((StringBuilder)localObject1).toString();
    }
    localObject1 = new File(f);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdir();
    }
    g = (FileObserver)new l.a(this, f, 514);
    localObject1 = b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initLoadLibrary abiType:");
    ((StringBuilder)localObject2).append(e);
    Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initLoadLibrary abiType:");
    ((StringBuilder)localObject2).append(e);
    o.d((String)localObject1, ((StringBuilder)localObject2).toString());
    d.a.a(paramContext, f);
    com.tencent.luggage.wxa.hg.f.a((f.a)l.b.a);
    ad.a((ad.a)l.c.a);
    com.tencent.mm.websocket.libwcwss.a.a((com.tencent.mm.websocket.libwcwss.a.a)l.d.a);
    XWebLibraryLoader.initXWebLibraryLoader((IXWebLibraryLoader)new l.e());
    com.tencent.luggage.wxa.ql.a.a((c)new l.f());
    com.tencent.luggage.wxa.ns.a.a((com.tencent.luggage.wxa.ns.a.a)l.g.a);
    MMBitmapFactory.a((MMBitmapFactory.a)l.h.a);
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    if (b())
    {
      paramFunction0.invoke();
      return;
    }
    try
    {
      h.add(paramFunction0);
      return;
    }
    finally
    {
      paramFunction0 = finally;
      throw paramFunction0;
    }
  }
  
  public final boolean b()
  {
    long l = System.currentTimeMillis();
    Object localObject = c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("sDynamicLibNames");
    }
    int k = localObject.length;
    int j = 0;
    while (j < k)
    {
      if (!e(localObject[j])) {
        return false;
      }
      j += 1;
    }
    localObject = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isLoaded: ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    localStringBuilder.append(" ms");
    o.d((String)localObject, localStringBuilder.toString());
    localObject = g;
    if (localObject != null) {
      ((FileObserver)localObject).startWatching();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.l
 * JD-Core Version:    0.7.0.1
 */