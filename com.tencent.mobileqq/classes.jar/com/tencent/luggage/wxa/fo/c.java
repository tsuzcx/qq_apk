package com.tencent.luggage.wxa.fo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rb.b;
import java.util.HashMap;
import java.util.Map;

public abstract class c
  extends ContentProvider
{
  private static UriMatcher a;
  private static SparseArray<String> b;
  private volatile b c;
  private final Map<Class<?>, Object> d = new HashMap();
  
  private <T> T a(Class<T> paramClass)
  {
    return this.d.get(paramClass);
  }
  
  public static void b()
  {
    b = new SparseArray();
    b.put(1, "WxaAttributesTable");
    b.put(2, "LaunchWxaAppPBTable");
    b.put(3, "WxaAppPackageModelTable");
    b.put(4, "DevPkgLaunchExtInfo");
    b.put(5, "AppBrandWxaPkgManifestRecord");
    b.put(6, "WxaPluginCodeVersionInfo");
    a = new UriMatcher(-1);
    int i = 0;
    while (i < b.size())
    {
      a.addURI(a.a, (String)b.valueAt(i), b.keyAt(i));
      i += 1;
    }
  }
  
  private boolean c()
  {
    if (this.c == null) {
      this.c = a();
    }
    return this.c != null;
  }
  
  protected final int a(@NonNull Uri paramUri)
  {
    return a.match(paramUri);
  }
  
  @Nullable
  protected abstract b a();
  
  protected final void a(Class<?> paramClass, Object paramObject)
  {
    this.d.put(paramClass, paramObject);
  }
  
  public int delete(@NonNull Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (!c()) {
      return -1;
    }
    return 0;
  }
  
  public String getType(@NonNull Uri paramUri)
  {
    return null;
  }
  
  /* Error */
  public Uri insert(@NonNull Uri paramUri, ContentValues paramContentValues)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 106	com/tencent/luggage/wxa/fo/c:c	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 116	com/tencent/luggage/wxa/fo/c:a	(Landroid/net/Uri;)I
    //   14: istore 5
    //   16: iload 5
    //   18: iconst_1
    //   19: if_icmpeq +1021 -> 1040
    //   22: iload 5
    //   24: iconst_2
    //   25: if_icmpeq +947 -> 972
    //   28: iload 5
    //   30: iconst_4
    //   31: if_icmpeq +877 -> 908
    //   34: iconst_m1
    //   35: istore_3
    //   36: bipush 6
    //   38: istore 4
    //   40: iload 5
    //   42: iconst_5
    //   43: if_icmpeq +130 -> 173
    //   46: iload 5
    //   48: bipush 6
    //   50: if_icmpeq +5 -> 55
    //   53: aconst_null
    //   54: areturn
    //   55: aload_2
    //   56: ldc 118
    //   58: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokestatic 128	com/tencent/luggage/wxa/qz/af:b	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore 6
    //   66: aload 6
    //   68: invokevirtual 131	java/lang/String:hashCode	()I
    //   71: ldc 132
    //   73: if_icmpeq +6 -> 79
    //   76: goto +15 -> 91
    //   79: aload 6
    //   81: ldc 134
    //   83: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +5 -> 91
    //   89: iconst_0
    //   90: istore_3
    //   91: iload_3
    //   92: ifeq +5 -> 97
    //   95: aconst_null
    //   96: areturn
    //   97: aload_2
    //   98: ldc 140
    //   100: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore 6
    //   105: aload_2
    //   106: ldc 142
    //   108: invokevirtual 146	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   111: invokevirtual 151	java/lang/Integer:intValue	()I
    //   114: istore_3
    //   115: aload_2
    //   116: ldc 153
    //   118: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: astore_2
    //   122: aload_0
    //   123: ldc 155
    //   125: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   128: checkcast 155	com/tencent/mm/plugin/appbrand/appcache/ah
    //   131: aload 6
    //   133: iload_3
    //   134: aload_2
    //   135: invokevirtual 160	com/tencent/mm/plugin/appbrand/appcache/ah:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_1
    //   139: getstatic 166	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   142: ldc 168
    //   144: iconst_2
    //   145: anewarray 170	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload 6
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: iload_3
    //   156: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: invokestatic 178	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokevirtual 131	java/lang/String:hashCode	()I
    //   166: i2l
    //   167: invokestatic 184	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   170: astore_1
    //   171: aload_1
    //   172: areturn
    //   173: aload_2
    //   174: ldc 118
    //   176: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   179: astore 6
    //   181: aload 6
    //   183: invokevirtual 131	java/lang/String:hashCode	()I
    //   186: lookupswitch	default:+66->252, -2005549818:+159->345, -1297425212:+144->330, -946499957:+129->315, -214401522:+114->300, 396944:+99->285, 755152062:+84->270, 1067970480:+69->255
    //   253: nop
    //   254: ldiv
    //   255: aload 6
    //   257: ldc 186
    //   259: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   262: ifeq +99 -> 361
    //   265: iconst_1
    //   266: istore_3
    //   267: goto +96 -> 363
    //   270: aload 6
    //   272: ldc 188
    //   274: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   277: ifeq +84 -> 361
    //   280: iconst_4
    //   281: istore_3
    //   282: goto +81 -> 363
    //   285: aload 6
    //   287: ldc 190
    //   289: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   292: ifeq +69 -> 361
    //   295: iconst_3
    //   296: istore_3
    //   297: goto +66 -> 363
    //   300: aload 6
    //   302: ldc 192
    //   304: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   307: ifeq +54 -> 361
    //   310: iconst_5
    //   311: istore_3
    //   312: goto +51 -> 363
    //   315: aload 6
    //   317: ldc 194
    //   319: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   322: ifeq +39 -> 361
    //   325: iconst_2
    //   326: istore_3
    //   327: goto +36 -> 363
    //   330: aload 6
    //   332: ldc 196
    //   334: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   337: ifeq +24 -> 361
    //   340: iconst_0
    //   341: istore_3
    //   342: goto +21 -> 363
    //   345: aload 6
    //   347: ldc 198
    //   349: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   352: ifeq +9 -> 361
    //   355: iload 4
    //   357: istore_3
    //   358: goto +5 -> 363
    //   361: iconst_m1
    //   362: istore_3
    //   363: iload_3
    //   364: tableswitch	default:+44 -> 408, 0:+450->814, 1:+352->716, 2:+300->664, 3:+274->638, 4:+195->559, 5:+128->492, 6:+46->410
    //   409: areturn
    //   410: aload_2
    //   411: ldc 118
    //   413: invokevirtual 202	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   416: new 204	com/tencent/mm/plugin/appbrand/appcache/ab
    //   419: dup
    //   420: invokespecial 205	com/tencent/mm/plugin/appbrand/appcache/ab:<init>	()V
    //   423: astore 6
    //   425: aload 6
    //   427: aload_2
    //   428: invokevirtual 208	com/tencent/mm/plugin/appbrand/appcache/ab:a	(Landroid/content/ContentValues;)V
    //   431: aload_0
    //   432: ldc 210
    //   434: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   437: checkcast 210	com/tencent/mm/plugin/appbrand/appcache/ae
    //   440: aload 6
    //   442: invokevirtual 213	com/tencent/mm/plugin/appbrand/appcache/ae:a	(Lcom/tencent/mm/plugin/appbrand/appcache/ab;)Z
    //   445: ifeq +791 -> 1236
    //   448: aload_0
    //   449: ldc 210
    //   451: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   454: checkcast 210	com/tencent/mm/plugin/appbrand/appcache/ae
    //   457: iconst_0
    //   458: invokevirtual 216	com/tencent/mm/plugin/appbrand/appcache/ae:a	(I)Ljava/util/List;
    //   461: pop
    //   462: aload_1
    //   463: aload 6
    //   465: getfield 220	com/tencent/mm/plugin/appbrand/appcache/ab:x	J
    //   468: invokestatic 184	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   471: astore_1
    //   472: aload_1
    //   473: areturn
    //   474: astore_1
    //   475: ldc 222
    //   477: ldc 224
    //   479: iconst_1
    //   480: anewarray 170	java/lang/Object
    //   483: dup
    //   484: iconst_0
    //   485: aload_1
    //   486: aastore
    //   487: invokestatic 229	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   490: aload_1
    //   491: athrow
    //   492: aload_2
    //   493: ldc 231
    //   495: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   498: astore_1
    //   499: aload_2
    //   500: ldc 233
    //   502: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   505: astore 6
    //   507: aload_2
    //   508: ldc 235
    //   510: invokevirtual 146	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   513: invokevirtual 151	java/lang/Integer:intValue	()I
    //   516: istore_3
    //   517: aload_2
    //   518: ldc 237
    //   520: invokevirtual 146	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   523: invokevirtual 151	java/lang/Integer:intValue	()I
    //   526: istore 4
    //   528: aload_2
    //   529: ldc 239
    //   531: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   534: astore_2
    //   535: aload_0
    //   536: ldc 210
    //   538: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   541: checkcast 210	com/tencent/mm/plugin/appbrand/appcache/ae
    //   544: aload_1
    //   545: iload_3
    //   546: iload 4
    //   548: aload 6
    //   550: aload_2
    //   551: invokestatic 244	com/tencent/luggage/wxa/jj/s$h:a	(Ljava/lang/String;)Ljava/util/List;
    //   554: invokevirtual 247	com/tencent/mm/plugin/appbrand/appcache/ae:a	(Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)V
    //   557: aconst_null
    //   558: areturn
    //   559: aload_2
    //   560: ldc 231
    //   562: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   565: astore_1
    //   566: aload_2
    //   567: ldc 233
    //   569: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   572: astore 6
    //   574: aload_2
    //   575: ldc 235
    //   577: invokevirtual 146	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   580: invokevirtual 151	java/lang/Integer:intValue	()I
    //   583: istore_3
    //   584: aload_2
    //   585: ldc 237
    //   587: invokevirtual 146	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   590: invokevirtual 151	java/lang/Integer:intValue	()I
    //   593: istore 4
    //   595: aload_2
    //   596: ldc 249
    //   598: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   601: astore 7
    //   603: aload_2
    //   604: ldc 251
    //   606: invokevirtual 146	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   609: invokevirtual 151	java/lang/Integer:intValue	()I
    //   612: istore 5
    //   614: aload_0
    //   615: ldc 210
    //   617: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   620: checkcast 210	com/tencent/mm/plugin/appbrand/appcache/ae
    //   623: aload_1
    //   624: aload 6
    //   626: iload_3
    //   627: iload 4
    //   629: aload 7
    //   631: iload 5
    //   633: invokevirtual 254	com/tencent/mm/plugin/appbrand/appcache/ae:a	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;I)V
    //   636: aconst_null
    //   637: areturn
    //   638: aload_2
    //   639: ldc_w 256
    //   642: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   645: astore_1
    //   646: aload_0
    //   647: ldc 210
    //   649: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   652: checkcast 210	com/tencent/mm/plugin/appbrand/appcache/ae
    //   655: aload_1
    //   656: invokestatic 261	com/tencent/luggage/wxa/jj/s$d:a	(Ljava/lang/Object;)Ljava/util/List;
    //   659: invokevirtual 264	com/tencent/mm/plugin/appbrand/appcache/ae:a	(Ljava/util/List;)V
    //   662: aconst_null
    //   663: areturn
    //   664: aload_2
    //   665: ldc_w 266
    //   668: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   671: invokestatic 271	com/tencent/luggage/wxa/jj/s$f:a	(Ljava/lang/String;)Lcom/tencent/luggage/wxa/jj/s$f;
    //   674: astore_1
    //   675: aload_2
    //   676: ldc 231
    //   678: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   681: astore 6
    //   683: aload_2
    //   684: ldc 251
    //   686: invokevirtual 146	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   689: invokevirtual 151	java/lang/Integer:intValue	()I
    //   692: invokestatic 276	com/tencent/mm/plugin/appbrand/appcache/d$a:a	(I)Z
    //   695: ifeq +541 -> 1236
    //   698: aload_0
    //   699: ldc 210
    //   701: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   704: checkcast 210	com/tencent/mm/plugin/appbrand/appcache/ae
    //   707: aload 6
    //   709: aload_1
    //   710: invokevirtual 279	com/tencent/mm/plugin/appbrand/appcache/ae:a	(Ljava/lang/String;Lcom/tencent/luggage/wxa/jj/s$f;)Z
    //   713: pop
    //   714: aconst_null
    //   715: areturn
    //   716: aload_2
    //   717: ldc 231
    //   719: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   722: astore 6
    //   724: aload_2
    //   725: ldc 251
    //   727: invokevirtual 146	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   730: invokevirtual 151	java/lang/Integer:intValue	()I
    //   733: istore_3
    //   734: aload_2
    //   735: ldc 249
    //   737: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   740: astore 7
    //   742: aload_2
    //   743: ldc_w 281
    //   746: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   749: astore_2
    //   750: aload_0
    //   751: ldc 210
    //   753: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   756: checkcast 210	com/tencent/mm/plugin/appbrand/appcache/ae
    //   759: aload 6
    //   761: iload_3
    //   762: aload_2
    //   763: aload 7
    //   765: lconst_0
    //   766: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   769: invokevirtual 290	com/tencent/mm/plugin/appbrand/appcache/ae:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JJ)Z
    //   772: ifeq +464 -> 1236
    //   775: aload_1
    //   776: getstatic 293	java/util/Locale:US	Ljava/util/Locale;
    //   779: ldc_w 295
    //   782: iconst_3
    //   783: anewarray 170	java/lang/Object
    //   786: dup
    //   787: iconst_0
    //   788: aload 6
    //   790: aastore
    //   791: dup
    //   792: iconst_1
    //   793: iload_3
    //   794: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   797: aastore
    //   798: dup
    //   799: iconst_2
    //   800: aload 7
    //   802: aastore
    //   803: invokestatic 178	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   806: invokevirtual 131	java/lang/String:hashCode	()I
    //   809: i2l
    //   810: invokestatic 184	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   813: areturn
    //   814: aload_2
    //   815: ldc 231
    //   817: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   820: astore 6
    //   822: aload_2
    //   823: ldc 251
    //   825: invokevirtual 146	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   828: invokevirtual 151	java/lang/Integer:intValue	()I
    //   831: istore_3
    //   832: aload_2
    //   833: ldc 235
    //   835: invokevirtual 146	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   838: invokevirtual 151	java/lang/Integer:intValue	()I
    //   841: istore 4
    //   843: aload_2
    //   844: ldc_w 297
    //   847: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   850: astore_1
    //   851: aload_1
    //   852: invokestatic 300	com/tencent/luggage/wxa/jj/s$g:a	(Ljava/lang/String;)Ljava/util/List;
    //   855: astore_1
    //   856: goto +5 -> 861
    //   859: aconst_null
    //   860: astore_1
    //   861: aload_1
    //   862: invokestatic 303	com/tencent/luggage/wxa/qz/af:a	(Ljava/util/List;)Z
    //   865: ifne +371 -> 1236
    //   868: aload_0
    //   869: ldc 210
    //   871: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   874: checkcast 210	com/tencent/mm/plugin/appbrand/appcache/ae
    //   877: aload 6
    //   879: iload_3
    //   880: iload 4
    //   882: aload_1
    //   883: invokevirtual 306	com/tencent/mm/plugin/appbrand/appcache/ae:a	(Ljava/lang/String;IILjava/util/List;)Z
    //   886: pop
    //   887: aconst_null
    //   888: areturn
    //   889: astore_1
    //   890: ldc 222
    //   892: ldc_w 308
    //   895: iconst_1
    //   896: anewarray 170	java/lang/Object
    //   899: dup
    //   900: iconst_0
    //   901: aload_1
    //   902: aastore
    //   903: invokestatic 229	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   906: aconst_null
    //   907: areturn
    //   908: aload_2
    //   909: ldc 231
    //   911: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   914: astore_1
    //   915: aload_2
    //   916: ldc_w 310
    //   919: invokevirtual 146	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   922: invokevirtual 151	java/lang/Integer:intValue	()I
    //   925: istore_3
    //   926: aload_2
    //   927: ldc_w 312
    //   930: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   933: astore_2
    //   934: aload_0
    //   935: ldc_w 314
    //   938: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   941: checkcast 314	com/tencent/luggage/wxa/nl/h
    //   944: aload_1
    //   945: iload_3
    //   946: aload_2
    //   947: invokevirtual 317	com/tencent/luggage/wxa/nl/h:a	(Ljava/lang/String;ILjava/lang/String;)Z
    //   950: pop
    //   951: aconst_null
    //   952: areturn
    //   953: astore_1
    //   954: ldc 222
    //   956: ldc_w 308
    //   959: iconst_1
    //   960: anewarray 170	java/lang/Object
    //   963: dup
    //   964: iconst_0
    //   965: aload_1
    //   966: aastore
    //   967: invokestatic 229	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   970: aconst_null
    //   971: areturn
    //   972: aload_2
    //   973: ldc 231
    //   975: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   978: astore_1
    //   979: aload_2
    //   980: ldc_w 319
    //   983: invokevirtual 323	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   986: astore_2
    //   987: aload_0
    //   988: ldc_w 325
    //   991: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   994: checkcast 325	com/tencent/luggage/wxa/nl/n
    //   997: aload_1
    //   998: new 327	com/tencent/luggage/wxa/qw/fb
    //   1001: dup
    //   1002: invokespecial 328	com/tencent/luggage/wxa/qw/fb:<init>	()V
    //   1005: aload_2
    //   1006: invokevirtual 331	com/tencent/luggage/wxa/qw/fb:a	([B)Lcom/tencent/luggage/wxa/qu/a;
    //   1009: checkcast 327	com/tencent/luggage/wxa/qw/fb
    //   1012: checkcast 327	com/tencent/luggage/wxa/qw/fb
    //   1015: invokevirtual 334	com/tencent/luggage/wxa/nl/n:a	(Ljava/lang/String;Lcom/tencent/luggage/wxa/qw/fb;)Z
    //   1018: pop
    //   1019: aconst_null
    //   1020: areturn
    //   1021: astore_1
    //   1022: ldc 222
    //   1024: ldc_w 336
    //   1027: iconst_1
    //   1028: anewarray 170	java/lang/Object
    //   1031: dup
    //   1032: iconst_0
    //   1033: aload_1
    //   1034: aastore
    //   1035: invokestatic 229	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1038: aconst_null
    //   1039: areturn
    //   1040: aload_2
    //   1041: ldc_w 319
    //   1044: invokevirtual 340	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   1047: ifeq +121 -> 1168
    //   1050: aload_2
    //   1051: ldc 231
    //   1053: invokevirtual 340	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   1056: ifeq +52 -> 1108
    //   1059: aload_2
    //   1060: ldc 231
    //   1062: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1065: astore_1
    //   1066: aload_2
    //   1067: ldc_w 319
    //   1070: invokevirtual 323	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   1073: astore_2
    //   1074: aload_0
    //   1075: ldc_w 342
    //   1078: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   1081: checkcast 342	com/tencent/luggage/wxa/jj/r
    //   1084: aload_1
    //   1085: new 344	com/tencent/luggage/wxa/qw/lv
    //   1088: dup
    //   1089: invokespecial 345	com/tencent/luggage/wxa/qw/lv:<init>	()V
    //   1092: aload_2
    //   1093: invokevirtual 346	com/tencent/luggage/wxa/qw/lv:a	([B)Lcom/tencent/luggage/wxa/qu/a;
    //   1096: checkcast 344	com/tencent/luggage/wxa/qw/lv
    //   1099: checkcast 344	com/tencent/luggage/wxa/qw/lv
    //   1102: invokevirtual 349	com/tencent/luggage/wxa/jj/r:b	(Ljava/lang/String;Lcom/tencent/luggage/wxa/qw/lv;)Z
    //   1105: pop
    //   1106: aconst_null
    //   1107: areturn
    //   1108: aload_2
    //   1109: ldc_w 351
    //   1112: invokevirtual 340	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   1115: ifeq +121 -> 1236
    //   1118: aload_2
    //   1119: ldc_w 351
    //   1122: invokevirtual 124	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1125: astore_1
    //   1126: aload_2
    //   1127: ldc_w 319
    //   1130: invokevirtual 323	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   1133: astore_2
    //   1134: aload_0
    //   1135: ldc_w 342
    //   1138: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   1141: checkcast 342	com/tencent/luggage/wxa/jj/r
    //   1144: aload_1
    //   1145: new 344	com/tencent/luggage/wxa/qw/lv
    //   1148: dup
    //   1149: invokespecial 345	com/tencent/luggage/wxa/qw/lv:<init>	()V
    //   1152: aload_2
    //   1153: invokevirtual 346	com/tencent/luggage/wxa/qw/lv:a	([B)Lcom/tencent/luggage/wxa/qu/a;
    //   1156: checkcast 344	com/tencent/luggage/wxa/qw/lv
    //   1159: checkcast 344	com/tencent/luggage/wxa/qw/lv
    //   1162: invokevirtual 353	com/tencent/luggage/wxa/jj/r:a	(Ljava/lang/String;Lcom/tencent/luggage/wxa/qw/lv;)Z
    //   1165: pop
    //   1166: aconst_null
    //   1167: areturn
    //   1168: aload_2
    //   1169: ldc_w 355
    //   1172: invokevirtual 340	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   1175: ifeq +61 -> 1236
    //   1178: aload_2
    //   1179: ldc_w 355
    //   1182: invokevirtual 323	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   1185: astore_1
    //   1186: aload_0
    //   1187: ldc_w 342
    //   1190: invokespecial 157	com/tencent/luggage/wxa/fo/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   1193: checkcast 342	com/tencent/luggage/wxa/jj/r
    //   1196: new 357	com/tencent/luggage/wxa/qw/ai
    //   1199: dup
    //   1200: invokespecial 358	com/tencent/luggage/wxa/qw/ai:<init>	()V
    //   1203: aload_1
    //   1204: invokevirtual 359	com/tencent/luggage/wxa/qw/ai:a	([B)Lcom/tencent/luggage/wxa/qu/a;
    //   1207: checkcast 357	com/tencent/luggage/wxa/qw/ai
    //   1210: checkcast 357	com/tencent/luggage/wxa/qw/ai
    //   1213: invokevirtual 362	com/tencent/luggage/wxa/jj/r:a	(Lcom/tencent/luggage/wxa/qw/ai;)Z
    //   1216: pop
    //   1217: aconst_null
    //   1218: areturn
    //   1219: astore_1
    //   1220: ldc 222
    //   1222: ldc_w 364
    //   1225: iconst_1
    //   1226: anewarray 170	java/lang/Object
    //   1229: dup
    //   1230: iconst_0
    //   1231: aload_1
    //   1232: aastore
    //   1233: invokestatic 229	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1236: aconst_null
    //   1237: areturn
    //   1238: astore_1
    //   1239: aconst_null
    //   1240: areturn
    //   1241: astore_1
    //   1242: goto -383 -> 859
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1245	0	this	c
    //   0	1245	1	paramUri	Uri
    //   0	1245	2	paramContentValues	ContentValues
    //   35	911	3	i	int
    //   38	843	4	j	int
    //   14	618	5	k	int
    //   64	814	6	localObject	Object
    //   601	200	7	str	String
    // Exception table:
    //   from	to	target	type
    //   410	472	474	java/lang/Throwable
    //   814	851	889	java/lang/Exception
    //   861	887	889	java/lang/Exception
    //   908	951	953	java/lang/Exception
    //   972	1019	1021	java/lang/Exception
    //   1040	1106	1219	java/lang/Exception
    //   1108	1166	1219	java/lang/Exception
    //   1168	1217	1219	java/lang/Exception
    //   122	171	1238	java/lang/Throwable
    //   851	856	1241	java/lang/Exception
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(@NonNull Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (!c()) {
      return null;
    }
    String str = (String)b.get(a.match(paramUri));
    if (TextUtils.isEmpty(str))
    {
      o.c("Luggage.WxaCriticalDataProvider", "query: uri [%s] mismatch", new Object[] { paramUri });
      return null;
    }
    return this.c.b(str, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
  }
  
  public int update(@NonNull Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fo.c
 * JD-Core Version:    0.7.0.1
 */