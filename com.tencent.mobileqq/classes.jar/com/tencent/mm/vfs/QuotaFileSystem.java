package com.tencent.mm.vfs;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class QuotaFileSystem
  extends DelegateFileSystem
  implements Handler.Callback
{
  public static final Parcelable.Creator<QuotaFileSystem> CREATOR = new QuotaFileSystem.2();
  public static final String STAT_DESTINATION = "destination";
  public static final String STAT_DIR_COUNT = "dirCount";
  public static final String STAT_FILE_COUNT = "fileCount";
  public static final String STAT_TOTAL_SIZE = "totalSize";
  private static final String TAG = "VFS.QuotaFileSystem";
  private static final int VERSION = 2;
  private final long FLUSH_CACHE_DELAY = 60000L;
  private HashMap<String, Long> mAccessTimeCache;
  private final Object mCacheLock = new Object();
  private final long mCleaningThreshold;
  private final boolean mEmulateAccessTime;
  private final long mExpireTime;
  private final FileSystem mFS;
  private final Iterable<FileSystem> mFSList;
  private final Handler mFlushCacheHandler;
  private final long mTargetSize;
  
  protected QuotaFileSystem(Parcel paramParcel)
  {
    VFSUtils.checkFileSystemVersion(paramParcel, QuotaFileSystem.class, 2);
    this.mFS = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    FileSystem localFileSystem = this.mFS;
    if (localFileSystem != null)
    {
      this.mFSList = Collections.singletonList(localFileSystem);
      this.mTargetSize = paramParcel.readLong();
      this.mCleaningThreshold = paramParcel.readLong();
      this.mExpireTime = paramParcel.readLong();
      boolean bool;
      if (paramParcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.mEmulateAccessTime = bool;
      if (this.mEmulateAccessTime)
      {
        this.mAccessTimeCache = new HashMap();
        this.mFlushCacheHandler = new Handler(FileSystemManager.instance().maintenanceLooper(), this);
      }
      else
      {
        this.mAccessTimeCache = null;
        this.mFlushCacheHandler = null;
      }
      checkParameters();
      return;
    }
    throw new IllegalArgumentException("Wrong wrapped filesystem.");
  }
  
  public QuotaFileSystem(FileSystem paramFileSystem, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.mFS = paramFileSystem;
    this.mFSList = Collections.singletonList(this.mFS);
    this.mTargetSize = paramLong1;
    this.mCleaningThreshold = paramLong2;
    this.mExpireTime = paramLong3;
    this.mEmulateAccessTime = paramBoolean;
    if (this.mEmulateAccessTime)
    {
      this.mAccessTimeCache = new HashMap();
      this.mFlushCacheHandler = new Handler(FileSystemManager.instance().maintenanceLooper(), this);
    }
    else
    {
      this.mAccessTimeCache = null;
      this.mFlushCacheHandler = null;
    }
    checkParameters();
  }
  
  private void checkParameters()
  {
    if (this.mCleaningThreshold >= this.mTargetSize) {
      return;
    }
    throw new IllegalArgumentException("Cleaning threshold must not less than target size.");
  }
  
  /* Error */
  private void doMaintenance(CancellationSignalCompat paramCancellationSignalCompat)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 9
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 94	com/tencent/mm/vfs/QuotaFileSystem:mFS	Lcom/tencent/mm/vfs/FileSystem;
    //   10: invokeinterface 168 1 0
    //   15: istore 6
    //   17: iload 6
    //   19: iconst_1
    //   20: iand
    //   21: ifne +41 -> 62
    //   24: new 170	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   31: astore_1
    //   32: aload_1
    //   33: ldc 173
    //   35: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_1
    //   40: aload_0
    //   41: getfield 94	com/tencent/mm/vfs/QuotaFileSystem:mFS	Lcom/tencent/mm/vfs/FileSystem;
    //   44: invokevirtual 181	java/lang/Object:toString	()Ljava/lang/String;
    //   47: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: ldc 25
    //   53: iconst_1
    //   54: aload_1
    //   55: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: return
    //   62: iload 6
    //   64: iconst_4
    //   65: iand
    //   66: ifne +41 -> 107
    //   69: new 170	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   76: astore_1
    //   77: aload_1
    //   78: ldc 190
    //   80: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_1
    //   85: aload_0
    //   86: getfield 94	com/tencent/mm/vfs/QuotaFileSystem:mFS	Lcom/tencent/mm/vfs/FileSystem;
    //   89: invokevirtual 181	java/lang/Object:toString	()Ljava/lang/String;
    //   92: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 25
    //   98: iconst_1
    //   99: aload_1
    //   100: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: return
    //   107: aload_1
    //   108: invokevirtual 195	com/tencent/mm/vfs/CancellationSignalCompat:throwIfCanceled	()V
    //   111: aload_0
    //   112: iconst_1
    //   113: iconst_2
    //   114: anewarray 61	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: ldc 13
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: aload_0
    //   125: getfield 94	com/tencent/mm/vfs/QuotaFileSystem:mFS	Lcom/tencent/mm/vfs/FileSystem;
    //   128: aastore
    //   129: invokevirtual 199	com/tencent/mm/vfs/QuotaFileSystem:statistics	(I[Ljava/lang/Object;)V
    //   132: aload_0
    //   133: getfield 118	com/tencent/mm/vfs/QuotaFileSystem:mEmulateAccessTime	Z
    //   136: istore 15
    //   138: iload 15
    //   140: ifeq +130 -> 270
    //   143: aload_0
    //   144: getfield 64	com/tencent/mm/vfs/QuotaFileSystem:mCacheLock	Ljava/lang/Object;
    //   147: astore 17
    //   149: aload 17
    //   151: monitorenter
    //   152: aload_0
    //   153: getfield 123	com/tencent/mm/vfs/QuotaFileSystem:mAccessTimeCache	Ljava/util/HashMap;
    //   156: invokevirtual 203	java/util/HashMap:isEmpty	()Z
    //   159: ifne +2174 -> 2333
    //   162: aload_0
    //   163: getfield 123	com/tencent/mm/vfs/QuotaFileSystem:mAccessTimeCache	Ljava/util/HashMap;
    //   166: astore 16
    //   168: aload_0
    //   169: new 120	java/util/HashMap
    //   172: dup
    //   173: invokespecial 121	java/util/HashMap:<init>	()V
    //   176: putfield 123	com/tencent/mm/vfs/QuotaFileSystem:mAccessTimeCache	Ljava/util/HashMap;
    //   179: goto +3 -> 182
    //   182: aload 17
    //   184: monitorexit
    //   185: aload 16
    //   187: ifnull +83 -> 270
    //   190: aload 16
    //   192: invokevirtual 207	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   195: invokeinterface 213 1 0
    //   200: astore 16
    //   202: aload 16
    //   204: invokeinterface 218 1 0
    //   209: ifeq +61 -> 270
    //   212: aload 16
    //   214: invokeinterface 222 1 0
    //   219: checkcast 224	java/util/Map$Entry
    //   222: astore 17
    //   224: aload_1
    //   225: invokevirtual 195	com/tencent/mm/vfs/CancellationSignalCompat:throwIfCanceled	()V
    //   228: aload_0
    //   229: getfield 94	com/tencent/mm/vfs/QuotaFileSystem:mFS	Lcom/tencent/mm/vfs/FileSystem;
    //   232: aload 17
    //   234: invokeinterface 227 1 0
    //   239: checkcast 229	java/lang/String
    //   242: aload 17
    //   244: invokeinterface 232 1 0
    //   249: checkcast 234	java/lang/Long
    //   252: invokevirtual 237	java/lang/Long:longValue	()J
    //   255: invokeinterface 241 4 0
    //   260: pop
    //   261: goto -59 -> 202
    //   264: astore_1
    //   265: aload 17
    //   267: monitorexit
    //   268: aload_1
    //   269: athrow
    //   270: aload_1
    //   271: invokevirtual 195	com/tencent/mm/vfs/CancellationSignalCompat:throwIfCanceled	()V
    //   274: new 243	java/util/ArrayList
    //   277: dup
    //   278: invokespecial 244	java/util/ArrayList:<init>	()V
    //   281: astore 19
    //   283: aload_0
    //   284: getfield 94	com/tencent/mm/vfs/QuotaFileSystem:mFS	Lcom/tencent/mm/vfs/FileSystem;
    //   287: ldc 246
    //   289: iconst_1
    //   290: invokeinterface 250 3 0
    //   295: astore 16
    //   297: aload 16
    //   299: ifnonnull +38 -> 337
    //   302: new 170	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   309: astore_1
    //   310: aload_1
    //   311: ldc 252
    //   313: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_1
    //   318: aload_0
    //   319: invokevirtual 253	com/tencent/mm/vfs/QuotaFileSystem:toString	()Ljava/lang/String;
    //   322: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: ldc 25
    //   328: iconst_1
    //   329: aload_1
    //   330: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: return
    //   337: aload 16
    //   339: invokeinterface 256 1 0
    //   344: astore 16
    //   346: lconst_0
    //   347: lstore 9
    //   349: iconst_0
    //   350: istore_3
    //   351: iconst_0
    //   352: istore_2
    //   353: lload 9
    //   355: lstore 11
    //   357: iload_3
    //   358: istore 5
    //   360: iload_2
    //   361: istore 4
    //   363: aload 16
    //   365: invokeinterface 218 1 0
    //   370: ifeq +159 -> 529
    //   373: lload 9
    //   375: lstore 11
    //   377: iload_3
    //   378: istore 5
    //   380: iload_2
    //   381: istore 4
    //   383: aload 16
    //   385: invokeinterface 222 1 0
    //   390: checkcast 258	com/tencent/mm/vfs/FileSystem$FileEntry
    //   393: astore 17
    //   395: lload 9
    //   397: lstore 11
    //   399: iload_3
    //   400: istore 5
    //   402: iload_2
    //   403: istore 4
    //   405: aload_1
    //   406: invokevirtual 195	com/tencent/mm/vfs/CancellationSignalCompat:throwIfCanceled	()V
    //   409: lload 9
    //   411: lstore 11
    //   413: iload_3
    //   414: istore 5
    //   416: iload_2
    //   417: istore 4
    //   419: aload 17
    //   421: getfield 261	com/tencent/mm/vfs/FileSystem$FileEntry:diskSpace	J
    //   424: lconst_0
    //   425: lcmp
    //   426: ifge +27 -> 453
    //   429: lload 9
    //   431: lstore 11
    //   433: iload_3
    //   434: istore 5
    //   436: iload_2
    //   437: istore 4
    //   439: aload 17
    //   441: getfield 264	com/tencent/mm/vfs/FileSystem$FileEntry:size	J
    //   444: lstore 13
    //   446: lload 13
    //   448: lstore 11
    //   450: goto +24 -> 474
    //   453: lload 9
    //   455: lstore 11
    //   457: iload_3
    //   458: istore 5
    //   460: iload_2
    //   461: istore 4
    //   463: aload 17
    //   465: getfield 261	com/tencent/mm/vfs/FileSystem$FileEntry:diskSpace	J
    //   468: lstore 13
    //   470: lload 13
    //   472: lstore 11
    //   474: lload 9
    //   476: lload 11
    //   478: ladd
    //   479: lstore 9
    //   481: lload 9
    //   483: lstore 11
    //   485: iload_3
    //   486: istore 5
    //   488: iload_2
    //   489: istore 4
    //   491: aload 17
    //   493: getfield 267	com/tencent/mm/vfs/FileSystem$FileEntry:isDirectory	Z
    //   496: ifeq +1843 -> 2339
    //   499: iload_2
    //   500: iconst_1
    //   501: iadd
    //   502: istore_2
    //   503: goto +3 -> 506
    //   506: lload 9
    //   508: lstore 11
    //   510: iload_3
    //   511: istore 5
    //   513: iload_2
    //   514: istore 4
    //   516: aload 19
    //   518: aload 17
    //   520: invokeinterface 273 2 0
    //   525: pop
    //   526: goto -173 -> 353
    //   529: lload 9
    //   531: lstore 11
    //   533: iload_3
    //   534: istore 5
    //   536: iload_2
    //   537: istore 4
    //   539: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   542: ifeq +119 -> 661
    //   545: lload 9
    //   547: lstore 11
    //   549: iload_3
    //   550: istore 5
    //   552: iload_2
    //   553: istore 4
    //   555: new 170	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   562: astore 16
    //   564: lload 9
    //   566: lstore 11
    //   568: iload_3
    //   569: istore 5
    //   571: iload_2
    //   572: istore 4
    //   574: aload 16
    //   576: ldc_w 278
    //   579: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: lload 9
    //   585: lstore 11
    //   587: iload_3
    //   588: istore 5
    //   590: iload_2
    //   591: istore 4
    //   593: aload 16
    //   595: lload 9
    //   597: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: lload 9
    //   603: lstore 11
    //   605: iload_3
    //   606: istore 5
    //   608: iload_2
    //   609: istore 4
    //   611: aload 16
    //   613: ldc_w 283
    //   616: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: lload 9
    //   622: lstore 11
    //   624: iload_3
    //   625: istore 5
    //   627: iload_2
    //   628: istore 4
    //   630: aload 16
    //   632: aload_0
    //   633: getfield 110	com/tencent/mm/vfs/QuotaFileSystem:mCleaningThreshold	J
    //   636: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: lload 9
    //   642: lstore 11
    //   644: iload_3
    //   645: istore 5
    //   647: iload_2
    //   648: istore 4
    //   650: ldc 25
    //   652: iconst_2
    //   653: aload 16
    //   655: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokestatic 286	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: lload 9
    //   663: lstore 11
    //   665: iload_3
    //   666: istore 5
    //   668: iload_2
    //   669: istore 4
    //   671: aload_0
    //   672: iconst_2
    //   673: bipush 6
    //   675: anewarray 61	java/lang/Object
    //   678: dup
    //   679: iconst_0
    //   680: ldc 19
    //   682: aastore
    //   683: dup
    //   684: iconst_1
    //   685: iload_3
    //   686: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   689: aastore
    //   690: dup
    //   691: iconst_2
    //   692: ldc 16
    //   694: aastore
    //   695: dup
    //   696: iconst_3
    //   697: iload_2
    //   698: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   701: aastore
    //   702: dup
    //   703: iconst_4
    //   704: ldc 22
    //   706: aastore
    //   707: dup
    //   708: iconst_5
    //   709: lload 9
    //   711: invokestatic 295	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   714: aastore
    //   715: invokevirtual 199	com/tencent/mm/vfs/QuotaFileSystem:statistics	(I[Ljava/lang/Object;)V
    //   718: lload 9
    //   720: lstore 11
    //   722: iload_3
    //   723: istore 5
    //   725: iload_2
    //   726: istore 4
    //   728: lload 9
    //   730: aload_0
    //   731: getfield 110	com/tencent/mm/vfs/QuotaFileSystem:mCleaningThreshold	J
    //   734: lcmp
    //   735: ifgt +97 -> 832
    //   738: lload 9
    //   740: lstore 11
    //   742: iload_3
    //   743: istore 5
    //   745: iload_2
    //   746: istore 4
    //   748: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   751: ifeq +22 -> 773
    //   754: lload 9
    //   756: lstore 11
    //   758: iload_3
    //   759: istore 5
    //   761: iload_2
    //   762: istore 4
    //   764: ldc 25
    //   766: iconst_2
    //   767: ldc_w 297
    //   770: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   773: lload 9
    //   775: lstore 11
    //   777: iload_3
    //   778: istore 5
    //   780: iload_2
    //   781: istore 4
    //   783: aload_0
    //   784: bipush 6
    //   786: bipush 6
    //   788: anewarray 61	java/lang/Object
    //   791: dup
    //   792: iconst_0
    //   793: ldc 19
    //   795: aastore
    //   796: dup
    //   797: iconst_1
    //   798: iload_3
    //   799: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   802: aastore
    //   803: dup
    //   804: iconst_2
    //   805: ldc 16
    //   807: aastore
    //   808: dup
    //   809: iconst_3
    //   810: iload_2
    //   811: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   814: aastore
    //   815: dup
    //   816: iconst_4
    //   817: ldc 22
    //   819: aastore
    //   820: dup
    //   821: iconst_5
    //   822: lload 9
    //   824: invokestatic 295	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   827: aastore
    //   828: invokevirtual 199	com/tencent/mm/vfs/QuotaFileSystem:statistics	(I[Ljava/lang/Object;)V
    //   831: return
    //   832: iload 6
    //   834: bipush 8
    //   836: iand
    //   837: ifeq +1509 -> 2346
    //   840: lload 9
    //   842: lstore 11
    //   844: iload_3
    //   845: istore 5
    //   847: iload_2
    //   848: istore 4
    //   850: new 120	java/util/HashMap
    //   853: dup
    //   854: invokespecial 121	java/util/HashMap:<init>	()V
    //   857: astore 17
    //   859: lload 9
    //   861: lstore 11
    //   863: iload_3
    //   864: istore 5
    //   866: iload_2
    //   867: istore 4
    //   869: aload 19
    //   871: invokeinterface 298 1 0
    //   876: astore 20
    //   878: lload 9
    //   880: lstore 11
    //   882: iload_3
    //   883: istore 5
    //   885: iload_2
    //   886: istore 4
    //   888: aload 20
    //   890: invokeinterface 218 1 0
    //   895: ifeq +221 -> 1116
    //   898: lload 9
    //   900: lstore 11
    //   902: iload_3
    //   903: istore 5
    //   905: iload_2
    //   906: istore 4
    //   908: aload 20
    //   910: invokeinterface 222 1 0
    //   915: checkcast 258	com/tencent/mm/vfs/FileSystem$FileEntry
    //   918: astore 22
    //   920: lload 9
    //   922: lstore 11
    //   924: iload_3
    //   925: istore 5
    //   927: iload_2
    //   928: istore 4
    //   930: aload 22
    //   932: getfield 267	com/tencent/mm/vfs/FileSystem$FileEntry:isDirectory	Z
    //   935: ifeq +56 -> 991
    //   938: lload 9
    //   940: lstore 11
    //   942: iload_3
    //   943: istore 5
    //   945: iload_2
    //   946: istore 4
    //   948: aload 17
    //   950: aload 22
    //   952: getfield 301	com/tencent/mm/vfs/FileSystem$FileEntry:relPath	Ljava/lang/String;
    //   955: invokevirtual 304	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   958: ifne +33 -> 991
    //   961: lload 9
    //   963: lstore 11
    //   965: iload_3
    //   966: istore 5
    //   968: iload_2
    //   969: istore 4
    //   971: aload 17
    //   973: aload 22
    //   975: getfield 301	com/tencent/mm/vfs/FileSystem$FileEntry:relPath	Ljava/lang/String;
    //   978: new 306	com/tencent/mm/vfs/QuotaFileSystem$DirEntry
    //   981: dup
    //   982: aload 22
    //   984: invokespecial 309	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:<init>	(Lcom/tencent/mm/vfs/FileSystem$FileEntry;)V
    //   987: invokevirtual 313	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   990: pop
    //   991: lload 9
    //   993: lstore 11
    //   995: iload_3
    //   996: istore 5
    //   998: iload_2
    //   999: istore 4
    //   1001: aload 22
    //   1003: getfield 301	com/tencent/mm/vfs/FileSystem$FileEntry:relPath	Ljava/lang/String;
    //   1006: invokestatic 317	com/tencent/mm/vfs/VFSUtils:getParentPath	(Ljava/lang/String;)Ljava/lang/String;
    //   1009: astore 21
    //   1011: aload 21
    //   1013: ifnonnull +6 -> 1019
    //   1016: goto -138 -> 878
    //   1019: lload 9
    //   1021: lstore 11
    //   1023: iload_3
    //   1024: istore 5
    //   1026: iload_2
    //   1027: istore 4
    //   1029: aload 17
    //   1031: aload 21
    //   1033: invokevirtual 321	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1036: checkcast 306	com/tencent/mm/vfs/QuotaFileSystem$DirEntry
    //   1039: astore 18
    //   1041: aload 18
    //   1043: astore 16
    //   1045: aload 18
    //   1047: ifnonnull +44 -> 1091
    //   1050: lload 9
    //   1052: lstore 11
    //   1054: iload_3
    //   1055: istore 5
    //   1057: iload_2
    //   1058: istore 4
    //   1060: new 306	com/tencent/mm/vfs/QuotaFileSystem$DirEntry
    //   1063: dup
    //   1064: aload 22
    //   1066: invokespecial 309	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:<init>	(Lcom/tencent/mm/vfs/FileSystem$FileEntry;)V
    //   1069: astore 16
    //   1071: lload 9
    //   1073: lstore 11
    //   1075: iload_3
    //   1076: istore 5
    //   1078: iload_2
    //   1079: istore 4
    //   1081: aload 17
    //   1083: aload 21
    //   1085: aload 16
    //   1087: invokevirtual 313	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1090: pop
    //   1091: lload 9
    //   1093: lstore 11
    //   1095: iload_3
    //   1096: istore 5
    //   1098: iload_2
    //   1099: istore 4
    //   1101: aload 16
    //   1103: aload 16
    //   1105: getfield 324	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:childCount	I
    //   1108: iconst_1
    //   1109: iadd
    //   1110: putfield 324	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:childCount	I
    //   1113: goto -235 -> 878
    //   1116: lload 9
    //   1118: lstore 11
    //   1120: iload_3
    //   1121: istore 5
    //   1123: iload_2
    //   1124: istore 4
    //   1126: aload_1
    //   1127: invokevirtual 195	com/tencent/mm/vfs/CancellationSignalCompat:throwIfCanceled	()V
    //   1130: aload 17
    //   1132: astore 16
    //   1134: goto +3 -> 1137
    //   1137: lload 9
    //   1139: lstore 11
    //   1141: iload_3
    //   1142: istore 5
    //   1144: iload_2
    //   1145: istore 4
    //   1147: new 243	java/util/ArrayList
    //   1150: dup
    //   1151: aload 19
    //   1153: invokeinterface 326 1 0
    //   1158: invokespecial 329	java/util/ArrayList:<init>	(I)V
    //   1161: astore 18
    //   1163: lload 9
    //   1165: lstore 11
    //   1167: iload_3
    //   1168: istore 5
    //   1170: iload_2
    //   1171: istore 4
    //   1173: aload 19
    //   1175: invokeinterface 298 1 0
    //   1180: astore 17
    //   1182: lload 9
    //   1184: lstore 11
    //   1186: iload_3
    //   1187: istore 5
    //   1189: iload_2
    //   1190: istore 4
    //   1192: aload 17
    //   1194: invokeinterface 218 1 0
    //   1199: ifeq +64 -> 1263
    //   1202: lload 9
    //   1204: lstore 11
    //   1206: iload_3
    //   1207: istore 5
    //   1209: iload_2
    //   1210: istore 4
    //   1212: aload 17
    //   1214: invokeinterface 222 1 0
    //   1219: checkcast 258	com/tencent/mm/vfs/FileSystem$FileEntry
    //   1222: astore 19
    //   1224: lload 9
    //   1226: lstore 11
    //   1228: iload_3
    //   1229: istore 5
    //   1231: iload_2
    //   1232: istore 4
    //   1234: aload 19
    //   1236: getfield 267	com/tencent/mm/vfs/FileSystem$FileEntry:isDirectory	Z
    //   1239: ifne -57 -> 1182
    //   1242: lload 9
    //   1244: lstore 11
    //   1246: iload_3
    //   1247: istore 5
    //   1249: iload_2
    //   1250: istore 4
    //   1252: aload 18
    //   1254: aload 19
    //   1256: invokevirtual 330	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1259: pop
    //   1260: goto -78 -> 1182
    //   1263: lload 9
    //   1265: lstore 11
    //   1267: iload_3
    //   1268: istore 5
    //   1270: iload_2
    //   1271: istore 4
    //   1273: aload 18
    //   1275: new 332	com/tencent/mm/vfs/QuotaFileSystem$1
    //   1278: dup
    //   1279: aload_0
    //   1280: invokespecial 335	com/tencent/mm/vfs/QuotaFileSystem$1:<init>	(Lcom/tencent/mm/vfs/QuotaFileSystem;)V
    //   1283: invokestatic 339	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1286: lload 9
    //   1288: lstore 11
    //   1290: iload_3
    //   1291: istore 5
    //   1293: iload_2
    //   1294: istore 4
    //   1296: aload 18
    //   1298: invokevirtual 340	java/util/ArrayList:size	()I
    //   1301: istore 6
    //   1303: iload 6
    //   1305: iconst_1
    //   1306: isub
    //   1307: istore 7
    //   1309: iload_3
    //   1310: istore 4
    //   1312: lload 9
    //   1314: lstore 11
    //   1316: lload 11
    //   1318: lstore 9
    //   1320: iload 4
    //   1322: istore 5
    //   1324: iload_2
    //   1325: istore_3
    //   1326: lload 11
    //   1328: aload_0
    //   1329: getfield 108	com/tencent/mm/vfs/QuotaFileSystem:mTargetSize	J
    //   1332: lcmp
    //   1333: ifle +442 -> 1775
    //   1336: iload 7
    //   1338: iflt +437 -> 1775
    //   1341: lload 11
    //   1343: lstore 9
    //   1345: iload 4
    //   1347: istore 5
    //   1349: iload_2
    //   1350: istore_3
    //   1351: aload_1
    //   1352: invokevirtual 195	com/tencent/mm/vfs/CancellationSignalCompat:throwIfCanceled	()V
    //   1355: lload 11
    //   1357: lstore 9
    //   1359: iload 4
    //   1361: istore 5
    //   1363: iload_2
    //   1364: istore_3
    //   1365: aload 18
    //   1367: iload 7
    //   1369: invokevirtual 343	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1372: checkcast 258	com/tencent/mm/vfs/FileSystem$FileEntry
    //   1375: astore 17
    //   1377: lload 11
    //   1379: lstore 9
    //   1381: iload 4
    //   1383: istore 5
    //   1385: iload_2
    //   1386: istore_3
    //   1387: aload 17
    //   1389: getfield 301	com/tencent/mm/vfs/FileSystem$FileEntry:relPath	Ljava/lang/String;
    //   1392: astore 19
    //   1394: lload 11
    //   1396: lstore 13
    //   1398: iload 4
    //   1400: istore 6
    //   1402: lload 11
    //   1404: lstore 9
    //   1406: iload 4
    //   1408: istore 5
    //   1410: iload_2
    //   1411: istore_3
    //   1412: aload_0
    //   1413: getfield 94	com/tencent/mm/vfs/QuotaFileSystem:mFS	Lcom/tencent/mm/vfs/FileSystem;
    //   1416: aload 19
    //   1418: invokeinterface 347 2 0
    //   1423: ifeq +71 -> 1494
    //   1426: lload 11
    //   1428: lstore 9
    //   1430: iload 4
    //   1432: istore 5
    //   1434: iload_2
    //   1435: istore_3
    //   1436: aload 17
    //   1438: getfield 261	com/tencent/mm/vfs/FileSystem$FileEntry:diskSpace	J
    //   1441: lconst_0
    //   1442: lcmp
    //   1443: ifge +27 -> 1470
    //   1446: lload 11
    //   1448: lstore 9
    //   1450: iload 4
    //   1452: istore 5
    //   1454: iload_2
    //   1455: istore_3
    //   1456: aload 17
    //   1458: getfield 264	com/tencent/mm/vfs/FileSystem$FileEntry:size	J
    //   1461: lstore 13
    //   1463: lload 13
    //   1465: lstore 9
    //   1467: goto +885 -> 2352
    //   1470: lload 11
    //   1472: lstore 9
    //   1474: iload 4
    //   1476: istore 5
    //   1478: iload_2
    //   1479: istore_3
    //   1480: aload 17
    //   1482: getfield 261	com/tencent/mm/vfs/FileSystem$FileEntry:diskSpace	J
    //   1485: lstore 13
    //   1487: lload 13
    //   1489: lstore 9
    //   1491: goto +861 -> 2352
    //   1494: lload 13
    //   1496: lstore 11
    //   1498: iload_2
    //   1499: istore 8
    //   1501: aload 16
    //   1503: ifnull +865 -> 2368
    //   1506: lload 13
    //   1508: lstore 9
    //   1510: iload 6
    //   1512: istore 5
    //   1514: iload_2
    //   1515: istore_3
    //   1516: aload 19
    //   1518: invokestatic 317	com/tencent/mm/vfs/VFSUtils:getParentPath	(Ljava/lang/String;)Ljava/lang/String;
    //   1521: astore 17
    //   1523: lload 13
    //   1525: lstore 11
    //   1527: iload_2
    //   1528: istore 8
    //   1530: aload 17
    //   1532: ifnull +836 -> 2368
    //   1535: lload 13
    //   1537: lstore 9
    //   1539: iload 6
    //   1541: istore 5
    //   1543: iload_2
    //   1544: istore_3
    //   1545: aload 16
    //   1547: aload 17
    //   1549: invokevirtual 321	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1552: checkcast 306	com/tencent/mm/vfs/QuotaFileSystem$DirEntry
    //   1555: astore 19
    //   1557: aload 19
    //   1559: ifnonnull +13 -> 1572
    //   1562: lload 13
    //   1564: lstore 11
    //   1566: iload_2
    //   1567: istore 8
    //   1569: goto +799 -> 2368
    //   1572: lload 13
    //   1574: lstore 9
    //   1576: iload 6
    //   1578: istore 5
    //   1580: iload_2
    //   1581: istore_3
    //   1582: aload 19
    //   1584: getfield 324	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:childCount	I
    //   1587: iconst_1
    //   1588: isub
    //   1589: istore 4
    //   1591: lload 13
    //   1593: lstore 9
    //   1595: iload 6
    //   1597: istore 5
    //   1599: iload_2
    //   1600: istore_3
    //   1601: aload 19
    //   1603: iload 4
    //   1605: putfield 324	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:childCount	I
    //   1608: lload 13
    //   1610: lstore 11
    //   1612: iload_2
    //   1613: istore 8
    //   1615: iload 4
    //   1617: ifne +751 -> 2368
    //   1620: lload 13
    //   1622: lstore 9
    //   1624: iload 6
    //   1626: istore 5
    //   1628: iload_2
    //   1629: istore_3
    //   1630: lload 13
    //   1632: lstore 11
    //   1634: iload_2
    //   1635: istore 8
    //   1637: aload_0
    //   1638: getfield 94	com/tencent/mm/vfs/QuotaFileSystem:mFS	Lcom/tencent/mm/vfs/FileSystem;
    //   1641: aload 17
    //   1643: iconst_0
    //   1644: invokeinterface 351 3 0
    //   1649: ifeq +719 -> 2368
    //   1652: lload 13
    //   1654: lstore 9
    //   1656: iload 6
    //   1658: istore 5
    //   1660: iload_2
    //   1661: istore_3
    //   1662: aload 19
    //   1664: getfield 355	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:entry	Lcom/tencent/mm/vfs/FileSystem$FileEntry;
    //   1667: getfield 261	com/tencent/mm/vfs/FileSystem$FileEntry:diskSpace	J
    //   1670: lconst_0
    //   1671: lcmp
    //   1672: ifge +30 -> 1702
    //   1675: lload 13
    //   1677: lstore 9
    //   1679: iload 6
    //   1681: istore 5
    //   1683: iload_2
    //   1684: istore_3
    //   1685: aload 19
    //   1687: getfield 355	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:entry	Lcom/tencent/mm/vfs/FileSystem$FileEntry;
    //   1690: getfield 264	com/tencent/mm/vfs/FileSystem$FileEntry:size	J
    //   1693: lstore 11
    //   1695: lload 11
    //   1697: lstore 9
    //   1699: goto +27 -> 1726
    //   1702: lload 13
    //   1704: lstore 9
    //   1706: iload 6
    //   1708: istore 5
    //   1710: iload_2
    //   1711: istore_3
    //   1712: aload 19
    //   1714: getfield 355	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:entry	Lcom/tencent/mm/vfs/FileSystem$FileEntry;
    //   1717: getfield 261	com/tencent/mm/vfs/FileSystem$FileEntry:diskSpace	J
    //   1720: lstore 11
    //   1722: lload 11
    //   1724: lstore 9
    //   1726: lload 13
    //   1728: lload 9
    //   1730: lsub
    //   1731: lstore 13
    //   1733: iload_2
    //   1734: iconst_1
    //   1735: isub
    //   1736: istore_2
    //   1737: lload 13
    //   1739: lstore 9
    //   1741: iload 6
    //   1743: istore 5
    //   1745: iload_2
    //   1746: istore_3
    //   1747: aload 16
    //   1749: aload 17
    //   1751: invokevirtual 358	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1754: pop
    //   1755: lload 13
    //   1757: lstore 9
    //   1759: iload 6
    //   1761: istore 5
    //   1763: iload_2
    //   1764: istore_3
    //   1765: aload 17
    //   1767: invokestatic 317	com/tencent/mm/vfs/VFSUtils:getParentPath	(Ljava/lang/String;)Ljava/lang/String;
    //   1770: astore 17
    //   1772: goto -249 -> 1523
    //   1775: lload 11
    //   1777: lstore 13
    //   1779: iload_2
    //   1780: istore 6
    //   1782: aload 16
    //   1784: ifnull +228 -> 2012
    //   1787: lload 11
    //   1789: lstore 9
    //   1791: iload 4
    //   1793: istore 5
    //   1795: iload_2
    //   1796: istore_3
    //   1797: aload 16
    //   1799: invokevirtual 362	java/util/HashMap:values	()Ljava/util/Collection;
    //   1802: invokeinterface 365 1 0
    //   1807: astore 16
    //   1809: lload 11
    //   1811: lstore 13
    //   1813: iload_2
    //   1814: istore 6
    //   1816: lload 11
    //   1818: lstore 9
    //   1820: iload 4
    //   1822: istore 5
    //   1824: iload_2
    //   1825: istore_3
    //   1826: aload 16
    //   1828: invokeinterface 218 1 0
    //   1833: ifeq +179 -> 2012
    //   1836: lload 11
    //   1838: lstore 9
    //   1840: iload 4
    //   1842: istore 5
    //   1844: iload_2
    //   1845: istore_3
    //   1846: aload 16
    //   1848: invokeinterface 222 1 0
    //   1853: checkcast 306	com/tencent/mm/vfs/QuotaFileSystem$DirEntry
    //   1856: astore 17
    //   1858: lload 11
    //   1860: lstore 9
    //   1862: iload 4
    //   1864: istore 5
    //   1866: iload_2
    //   1867: istore_3
    //   1868: aload 17
    //   1870: getfield 324	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:childCount	I
    //   1873: ifne +136 -> 2009
    //   1876: lload 11
    //   1878: lstore 9
    //   1880: iload 4
    //   1882: istore 5
    //   1884: iload_2
    //   1885: istore_3
    //   1886: aload_1
    //   1887: invokevirtual 195	com/tencent/mm/vfs/CancellationSignalCompat:throwIfCanceled	()V
    //   1890: lload 11
    //   1892: lstore 9
    //   1894: iload 4
    //   1896: istore 5
    //   1898: iload_2
    //   1899: istore_3
    //   1900: aload_0
    //   1901: getfield 94	com/tencent/mm/vfs/QuotaFileSystem:mFS	Lcom/tencent/mm/vfs/FileSystem;
    //   1904: aload 17
    //   1906: getfield 355	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:entry	Lcom/tencent/mm/vfs/FileSystem$FileEntry;
    //   1909: getfield 301	com/tencent/mm/vfs/FileSystem$FileEntry:relPath	Ljava/lang/String;
    //   1912: iconst_0
    //   1913: invokeinterface 351 3 0
    //   1918: ifeq +91 -> 2009
    //   1921: lload 11
    //   1923: lstore 9
    //   1925: iload 4
    //   1927: istore 5
    //   1929: iload_2
    //   1930: istore_3
    //   1931: aload 17
    //   1933: getfield 355	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:entry	Lcom/tencent/mm/vfs/FileSystem$FileEntry;
    //   1936: getfield 261	com/tencent/mm/vfs/FileSystem$FileEntry:diskSpace	J
    //   1939: lconst_0
    //   1940: lcmp
    //   1941: ifge +30 -> 1971
    //   1944: lload 11
    //   1946: lstore 9
    //   1948: iload 4
    //   1950: istore 5
    //   1952: iload_2
    //   1953: istore_3
    //   1954: aload 17
    //   1956: getfield 355	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:entry	Lcom/tencent/mm/vfs/FileSystem$FileEntry;
    //   1959: getfield 264	com/tencent/mm/vfs/FileSystem$FileEntry:size	J
    //   1962: lstore 13
    //   1964: lload 13
    //   1966: lstore 9
    //   1968: goto +27 -> 1995
    //   1971: lload 11
    //   1973: lstore 9
    //   1975: iload 4
    //   1977: istore 5
    //   1979: iload_2
    //   1980: istore_3
    //   1981: aload 17
    //   1983: getfield 355	com/tencent/mm/vfs/QuotaFileSystem$DirEntry:entry	Lcom/tencent/mm/vfs/FileSystem$FileEntry;
    //   1986: getfield 261	com/tencent/mm/vfs/FileSystem$FileEntry:diskSpace	J
    //   1989: lstore 13
    //   1991: lload 13
    //   1993: lstore 9
    //   1995: lload 11
    //   1997: lload 9
    //   1999: lsub
    //   2000: lstore 11
    //   2002: iload_2
    //   2003: iconst_1
    //   2004: isub
    //   2005: istore_2
    //   2006: goto -197 -> 1809
    //   2009: goto -200 -> 1809
    //   2012: iload 6
    //   2014: istore_2
    //   2015: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2018: ifeq +65 -> 2083
    //   2021: new 170	java/lang/StringBuilder
    //   2024: dup
    //   2025: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   2028: astore_1
    //   2029: aload_1
    //   2030: ldc_w 367
    //   2033: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2036: pop
    //   2037: aload_1
    //   2038: iload 4
    //   2040: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2043: pop
    //   2044: aload_1
    //   2045: ldc_w 372
    //   2048: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2051: pop
    //   2052: aload_1
    //   2053: iload_2
    //   2054: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2057: pop
    //   2058: aload_1
    //   2059: ldc_w 374
    //   2062: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: pop
    //   2066: aload_1
    //   2067: lload 13
    //   2069: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2072: pop
    //   2073: ldc 25
    //   2075: iconst_2
    //   2076: aload_1
    //   2077: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2080: invokestatic 286	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2083: aload_0
    //   2084: iconst_3
    //   2085: bipush 6
    //   2087: anewarray 61	java/lang/Object
    //   2090: dup
    //   2091: iconst_0
    //   2092: ldc 19
    //   2094: aastore
    //   2095: dup
    //   2096: iconst_1
    //   2097: iload 4
    //   2099: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2102: aastore
    //   2103: dup
    //   2104: iconst_2
    //   2105: ldc 16
    //   2107: aastore
    //   2108: dup
    //   2109: iconst_3
    //   2110: iload_2
    //   2111: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2114: aastore
    //   2115: dup
    //   2116: iconst_4
    //   2117: ldc 22
    //   2119: aastore
    //   2120: dup
    //   2121: iconst_5
    //   2122: lload 13
    //   2124: invokestatic 295	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2127: aastore
    //   2128: invokevirtual 199	com/tencent/mm/vfs/QuotaFileSystem:statistics	(I[Ljava/lang/Object;)V
    //   2131: return
    //   2132: astore_1
    //   2133: lload 13
    //   2135: lstore 9
    //   2137: goto +34 -> 2171
    //   2140: astore_1
    //   2141: iload 5
    //   2143: istore 4
    //   2145: goto +15 -> 2160
    //   2148: astore_1
    //   2149: lload 11
    //   2151: lstore 9
    //   2153: iload 4
    //   2155: istore_3
    //   2156: iload 5
    //   2158: istore 4
    //   2160: iload_3
    //   2161: istore_2
    //   2162: goto +9 -> 2171
    //   2165: astore_1
    //   2166: iconst_0
    //   2167: istore_2
    //   2168: iconst_0
    //   2169: istore 4
    //   2171: aload_1
    //   2172: instanceof 376
    //   2175: ifeq +84 -> 2259
    //   2178: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2181: ifeq +73 -> 2254
    //   2184: new 170	java/lang/StringBuilder
    //   2187: dup
    //   2188: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   2191: astore 16
    //   2193: aload 16
    //   2195: ldc_w 378
    //   2198: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2201: pop
    //   2202: aload 16
    //   2204: iload 4
    //   2206: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2209: pop
    //   2210: aload 16
    //   2212: ldc_w 372
    //   2215: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2218: pop
    //   2219: aload 16
    //   2221: iload_2
    //   2222: invokevirtual 370	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2225: pop
    //   2226: aload 16
    //   2228: ldc_w 374
    //   2231: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2234: pop
    //   2235: aload 16
    //   2237: lload 9
    //   2239: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2242: pop
    //   2243: ldc 25
    //   2245: iconst_2
    //   2246: aload 16
    //   2248: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2251: invokestatic 286	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2254: iconst_4
    //   2255: istore_3
    //   2256: goto +15 -> 2271
    //   2259: ldc 25
    //   2261: iconst_1
    //   2262: ldc_w 380
    //   2265: aload_1
    //   2266: invokestatic 383	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2269: iconst_5
    //   2270: istore_3
    //   2271: aload_0
    //   2272: iload_3
    //   2273: bipush 6
    //   2275: anewarray 61	java/lang/Object
    //   2278: dup
    //   2279: iconst_0
    //   2280: ldc 19
    //   2282: aastore
    //   2283: dup
    //   2284: iconst_1
    //   2285: iload 4
    //   2287: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2290: aastore
    //   2291: dup
    //   2292: iconst_2
    //   2293: ldc 16
    //   2295: aastore
    //   2296: dup
    //   2297: iconst_3
    //   2298: iload_2
    //   2299: invokestatic 292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2302: aastore
    //   2303: dup
    //   2304: iconst_4
    //   2305: ldc 22
    //   2307: aastore
    //   2308: dup
    //   2309: iconst_5
    //   2310: lload 9
    //   2312: invokestatic 295	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2315: aastore
    //   2316: invokevirtual 199	com/tencent/mm/vfs/QuotaFileSystem:statistics	(I[Ljava/lang/Object;)V
    //   2319: goto +5 -> 2324
    //   2322: aload_1
    //   2323: athrow
    //   2324: goto -2 -> 2322
    //   2327: astore_1
    //   2328: iconst_0
    //   2329: istore_2
    //   2330: goto -159 -> 2171
    //   2333: aconst_null
    //   2334: astore 16
    //   2336: goto -2154 -> 182
    //   2339: iload_3
    //   2340: iconst_1
    //   2341: iadd
    //   2342: istore_3
    //   2343: goto -1837 -> 506
    //   2346: aconst_null
    //   2347: astore 16
    //   2349: goto -1212 -> 1137
    //   2352: lload 11
    //   2354: lload 9
    //   2356: lsub
    //   2357: lstore 13
    //   2359: iload 4
    //   2361: iconst_1
    //   2362: isub
    //   2363: istore 6
    //   2365: goto -871 -> 1494
    //   2368: iload 7
    //   2370: iconst_1
    //   2371: isub
    //   2372: istore 7
    //   2374: iload 6
    //   2376: istore 4
    //   2378: iload 8
    //   2380: istore_2
    //   2381: goto -1065 -> 1316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2384	0	this	QuotaFileSystem
    //   0	2384	1	paramCancellationSignalCompat	CancellationSignalCompat
    //   352	2029	2	i	int
    //   350	1993	3	j	int
    //   4	2373	4	k	int
    //   358	1799	5	m	int
    //   15	2360	6	n	int
    //   1307	1066	7	i1	int
    //   1499	880	8	i2	int
    //   1	2354	9	l1	long
    //   355	1998	11	l2	long
    //   444	1914	13	l3	long
    //   136	3	15	bool	boolean
    //   166	2182	16	localObject1	Object
    //   147	1835	17	localObject2	Object
    //   1039	327	18	localObject3	Object
    //   281	1432	19	localObject4	Object
    //   876	33	20	localIterator	Iterator
    //   1009	75	21	str	String
    //   918	147	22	localFileEntry	FileSystem.FileEntry
    // Exception table:
    //   from	to	target	type
    //   152	179	264	finally
    //   182	185	264	finally
    //   265	268	264	finally
    //   2015	2083	2132	java/lang/Exception
    //   2083	2131	2132	java/lang/Exception
    //   1326	1336	2140	java/lang/Exception
    //   1351	1355	2140	java/lang/Exception
    //   1365	1377	2140	java/lang/Exception
    //   1387	1394	2140	java/lang/Exception
    //   1412	1426	2140	java/lang/Exception
    //   1436	1446	2140	java/lang/Exception
    //   1456	1463	2140	java/lang/Exception
    //   1480	1487	2140	java/lang/Exception
    //   1516	1523	2140	java/lang/Exception
    //   1545	1557	2140	java/lang/Exception
    //   1582	1591	2140	java/lang/Exception
    //   1601	1608	2140	java/lang/Exception
    //   1637	1652	2140	java/lang/Exception
    //   1662	1675	2140	java/lang/Exception
    //   1685	1695	2140	java/lang/Exception
    //   1712	1722	2140	java/lang/Exception
    //   1747	1755	2140	java/lang/Exception
    //   1765	1772	2140	java/lang/Exception
    //   1797	1809	2140	java/lang/Exception
    //   1826	1836	2140	java/lang/Exception
    //   1846	1858	2140	java/lang/Exception
    //   1868	1876	2140	java/lang/Exception
    //   1886	1890	2140	java/lang/Exception
    //   1900	1921	2140	java/lang/Exception
    //   1931	1944	2140	java/lang/Exception
    //   1954	1964	2140	java/lang/Exception
    //   1981	1991	2140	java/lang/Exception
    //   363	373	2148	java/lang/Exception
    //   383	395	2148	java/lang/Exception
    //   405	409	2148	java/lang/Exception
    //   419	429	2148	java/lang/Exception
    //   439	446	2148	java/lang/Exception
    //   463	470	2148	java/lang/Exception
    //   491	499	2148	java/lang/Exception
    //   516	526	2148	java/lang/Exception
    //   539	545	2148	java/lang/Exception
    //   555	564	2148	java/lang/Exception
    //   574	583	2148	java/lang/Exception
    //   593	601	2148	java/lang/Exception
    //   611	620	2148	java/lang/Exception
    //   630	640	2148	java/lang/Exception
    //   650	661	2148	java/lang/Exception
    //   671	718	2148	java/lang/Exception
    //   728	738	2148	java/lang/Exception
    //   748	754	2148	java/lang/Exception
    //   764	773	2148	java/lang/Exception
    //   783	831	2148	java/lang/Exception
    //   850	859	2148	java/lang/Exception
    //   869	878	2148	java/lang/Exception
    //   888	898	2148	java/lang/Exception
    //   908	920	2148	java/lang/Exception
    //   930	938	2148	java/lang/Exception
    //   948	961	2148	java/lang/Exception
    //   971	991	2148	java/lang/Exception
    //   1001	1011	2148	java/lang/Exception
    //   1029	1041	2148	java/lang/Exception
    //   1060	1071	2148	java/lang/Exception
    //   1081	1091	2148	java/lang/Exception
    //   1101	1113	2148	java/lang/Exception
    //   1126	1130	2148	java/lang/Exception
    //   1147	1163	2148	java/lang/Exception
    //   1173	1182	2148	java/lang/Exception
    //   1192	1202	2148	java/lang/Exception
    //   1212	1224	2148	java/lang/Exception
    //   1234	1242	2148	java/lang/Exception
    //   1252	1260	2148	java/lang/Exception
    //   1273	1286	2148	java/lang/Exception
    //   1296	1303	2148	java/lang/Exception
    //   6	17	2165	java/lang/Exception
    //   107	138	2165	java/lang/Exception
    //   270	297	2165	java/lang/Exception
    //   337	346	2165	java/lang/Exception
    //   24	61	2327	java/lang/Exception
    //   69	106	2327	java/lang/Exception
    //   143	152	2327	java/lang/Exception
    //   190	202	2327	java/lang/Exception
    //   202	261	2327	java/lang/Exception
    //   268	270	2327	java/lang/Exception
    //   302	336	2327	java/lang/Exception
  }
  
  private static int longSigning(long paramLong)
  {
    if (paramLong == 0L) {
      return 0;
    }
    if (paramLong > 0L) {
      return 1;
    }
    return -1;
  }
  
  private void updateAccessTime(String paramString, boolean paramBoolean)
  {
    if (!this.mEmulateAccessTime) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.mCacheLock)
      {
        this.mAccessTimeCache.remove(paramString);
        return;
      }
    }
    long l = System.currentTimeMillis();
    synchronized (this.mCacheLock)
    {
      paramBoolean = this.mAccessTimeCache.isEmpty();
      this.mAccessTimeCache.put(paramString, Long.valueOf(l));
      if (paramBoolean) {
        this.mFlushCacheHandler.sendMessageDelayed(Message.obtain(), 60000L);
      }
      return;
    }
  }
  
  protected Iterable<FileSystem> allFileSystems()
  {
    return this.mFSList;
  }
  
  protected FileSystem delegate(String paramString, int paramInt)
  {
    return this.mFS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    synchronized (this.mCacheLock)
    {
      if (!this.mAccessTimeCache.isEmpty())
      {
        paramMessage = this.mAccessTimeCache;
        this.mAccessTimeCache = new HashMap();
        if (paramMessage != null)
        {
          ??? = paramMessage.entrySet().iterator();
          while (((Iterator)???).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
            this.mFS.setModifiedTime((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
          }
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("Flush access time cache entries: ");
            ((StringBuilder)???).append(paramMessage.size());
            QLog.i("VFS.QuotaFileSystem", 2, ((StringBuilder)???).toString());
          }
        }
        return true;
      }
    }
  }
  
  public void maintain(CancellationSignalCompat paramCancellationSignalCompat)
  {
    doMaintenance(paramCancellationSignalCompat);
    super.maintain(paramCancellationSignalCompat);
  }
  
  public ParcelFileDescriptor openParcelFd(String paramString1, String paramString2)
  {
    ParcelFileDescriptor localParcelFileDescriptor = this.mFS.openParcelFd(paramString1, paramString2);
    updateAccessTime(paramString1, paramString2.contains("w"));
    return localParcelFileDescriptor;
  }
  
  public InputStream openRead(String paramString)
  {
    InputStream localInputStream = this.mFS.openRead(paramString);
    updateAccessTime(paramString, false);
    return localInputStream;
  }
  
  public ReadableByteChannel openReadChannel(String paramString)
  {
    ReadableByteChannel localReadableByteChannel = this.mFS.openReadChannel(paramString);
    updateAccessTime(paramString, false);
    return localReadableByteChannel;
  }
  
  public ByteChannel openReadWriteChannel(String paramString)
  {
    ByteChannel localByteChannel = this.mFS.openReadWriteChannel(paramString);
    updateAccessTime(paramString, true);
    return localByteChannel;
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    OutputStream localOutputStream = this.mFS.openWrite(paramString, paramBoolean);
    updateAccessTime(paramString, true);
    return localOutputStream;
  }
  
  public WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean)
  {
    WritableByteChannel localWritableByteChannel = this.mFS.openWriteChannel(paramString, paramBoolean);
    updateAccessTime(paramString, true);
    return localWritableByteChannel;
  }
  
  public String toString()
  {
    long l = this.mTargetSize / 1024L / 1024L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QuotaFS [");
    localStringBuilder.append(l);
    localStringBuilder.append("MB | ");
    localStringBuilder.append(this.mFS.toString());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    VFSUtils.writeFileSystemVersion(paramParcel, QuotaFileSystem.class, 2);
    paramParcel.writeParcelable(this.mFS, paramInt);
    paramParcel.writeLong(this.mTargetSize);
    paramParcel.writeLong(this.mCleaningThreshold);
    paramParcel.writeLong(this.mExpireTime);
    paramParcel.writeByte((byte)this.mEmulateAccessTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem
 * JD-Core Version:    0.7.0.1
 */