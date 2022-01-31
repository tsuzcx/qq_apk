package com.tencent.ark.open.security;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.ArkAppInfo.ArkWhiteUrlItem;
import com.tencent.ark.open.ArkUtil;
import java.util.ArrayList;

public class ArkBaseUrlChecker
  implements Parcelable
{
  public static final Parcelable.Creator<ArkBaseUrlChecker> CREATOR = new ArkBaseUrlChecker.1();
  private static final ArkEnvironmentManager ENV = ;
  private static final String TAG = "ArkApp.ArkBaseUrlChecker";
  public static final int TYPE_INVALID_BLACK = 1;
  public static final int TYPE_INVALID_WHITE = 2;
  public static final int TYPE_VALID = 0;
  private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mGlobalBlackList = null;
  private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mGlobalWhiteList = null;
  protected Object mLock = new Object();
  protected ArrayList<ArkAppInfo.ArkWhiteUrlItem> mWhiteList = null;
  
  protected ArkBaseUrlChecker(Parcel paramParcel)
  {
    this.mWhiteList = paramParcel.createTypedArrayList(ArkAppInfo.ArkWhiteUrlItem.CREATOR);
    this.mGlobalWhiteList = paramParcel.createTypedArrayList(ArkAppInfo.ArkWhiteUrlItem.CREATOR);
    this.mGlobalBlackList = paramParcel.createTypedArrayList(ArkAppInfo.ArkWhiteUrlItem.CREATOR);
  }
  
  public ArkBaseUrlChecker(ArrayList<ArkAppInfo.ArkWhiteUrlItem> paramArrayList1, ArrayList<ArkAppInfo.ArkWhiteUrlItem> paramArrayList2, ArrayList<ArkAppInfo.ArkWhiteUrlItem> paramArrayList3)
  {
    Object localObject = this.mLock;
    if (paramArrayList1 != null) {}
    try
    {
      if (paramArrayList1.size() > 0)
      {
        this.mWhiteList = new ArrayList();
        this.mWhiteList.addAll(paramArrayList1);
      }
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
      {
        this.mGlobalWhiteList = new ArrayList();
        this.mGlobalWhiteList.addAll(paramArrayList2);
      }
      if ((paramArrayList3 != null) && (paramArrayList3.size() > 0))
      {
        this.mGlobalBlackList = new ArrayList();
        this.mGlobalBlackList.addAll(paramArrayList3);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private static boolean isUrlValidInList(String paramString, ArrayList<ArkAppInfo.ArkWhiteUrlItem> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +19 -> 27
    //   11: getstatic 39	com/tencent/ark/open/security/ArkBaseUrlChecker:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   14: ldc 15
    //   16: ldc 94
    //   18: invokevirtual 98	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: iconst_1
    //   22: istore 8
    //   24: iload 8
    //   26: ireturn
    //   27: new 100	java/net/URL
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   35: astore 13
    //   37: aload 13
    //   39: invokevirtual 107	java/net/URL:getAuthority	()Ljava/lang/String;
    //   42: astore 12
    //   44: aload 13
    //   46: invokevirtual 110	java/net/URL:getPath	()Ljava/lang/String;
    //   49: astore 13
    //   51: getstatic 39	com/tencent/ark/open/security/ArkBaseUrlChecker:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   54: ldc 15
    //   56: bipush 6
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: ldc 112
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: aload_0
    //   69: iconst_0
    //   70: anewarray 114	java/lang/String
    //   73: invokestatic 120	com/tencent/ark/open/ArkUtil:filterKeyForLog	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: ldc 122
    //   81: aastore
    //   82: dup
    //   83: iconst_3
    //   84: aload 12
    //   86: aastore
    //   87: dup
    //   88: iconst_4
    //   89: ldc 124
    //   91: aastore
    //   92: dup
    //   93: iconst_5
    //   94: aload 13
    //   96: aastore
    //   97: invokevirtual 128	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: iconst_0
    //   101: istore 10
    //   103: iconst_0
    //   104: istore 7
    //   106: iconst_0
    //   107: istore 9
    //   109: iconst_0
    //   110: istore 6
    //   112: iconst_1
    //   113: istore 8
    //   115: iconst_1
    //   116: istore 5
    //   118: aload_1
    //   119: invokevirtual 132	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   122: astore_1
    //   123: iload 5
    //   125: istore 8
    //   127: iload 6
    //   129: istore 9
    //   131: iload 7
    //   133: istore 10
    //   135: aload_1
    //   136: invokeinterface 138 1 0
    //   141: ifeq +564 -> 705
    //   144: iload 5
    //   146: istore 8
    //   148: iload 6
    //   150: istore 9
    //   152: iload 7
    //   154: istore 10
    //   156: aload_1
    //   157: invokeinterface 142 1 0
    //   162: checkcast 59	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem
    //   165: astore 14
    //   167: aload 14
    //   169: ifnull +521 -> 690
    //   172: iload 5
    //   174: istore 8
    //   176: iload 6
    //   178: istore 9
    //   180: iload 7
    //   182: istore 10
    //   184: getstatic 39	com/tencent/ark/open/security/ArkBaseUrlChecker:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   187: ldc 15
    //   189: iconst_4
    //   190: anewarray 4	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: ldc 144
    //   197: aastore
    //   198: dup
    //   199: iconst_1
    //   200: aload 14
    //   202: getfield 147	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem:ruleDomain	Ljava/lang/String;
    //   205: aastore
    //   206: dup
    //   207: iconst_2
    //   208: ldc 149
    //   210: aastore
    //   211: dup
    //   212: iconst_3
    //   213: aload 14
    //   215: getfield 152	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem:rulePath	Ljava/lang/String;
    //   218: aastore
    //   219: invokevirtual 128	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: iload 5
    //   224: istore 8
    //   226: iload 6
    //   228: istore 9
    //   230: iload 7
    //   232: istore 10
    //   234: aload 14
    //   236: getfield 147	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem:ruleDomain	Ljava/lang/String;
    //   239: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: istore 11
    //   244: iload 11
    //   246: ifeq +160 -> 406
    //   249: iconst_1
    //   250: istore 7
    //   252: aload 14
    //   254: getfield 152	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem:rulePath	Ljava/lang/String;
    //   257: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   260: istore 8
    //   262: iload 8
    //   264: ifeq +284 -> 548
    //   267: iconst_1
    //   268: istore 5
    //   270: iload 7
    //   272: ifeq +346 -> 618
    //   275: iload 5
    //   277: ifeq +341 -> 618
    //   280: iconst_1
    //   281: istore 8
    //   283: iload 5
    //   285: istore 6
    //   287: iload 8
    //   289: istore 5
    //   291: iload 5
    //   293: istore 8
    //   295: iload 5
    //   297: ifne -273 -> 24
    //   300: getstatic 39	com/tencent/ark/open/security/ArkBaseUrlChecker:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   303: ldc 15
    //   305: bipush 8
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: ldc 154
    //   314: aastore
    //   315: dup
    //   316: iconst_1
    //   317: aload_0
    //   318: iconst_0
    //   319: anewarray 114	java/lang/String
    //   322: invokestatic 120	com/tencent/ark/open/ArkUtil:filterKeyForLog	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   325: aastore
    //   326: dup
    //   327: iconst_2
    //   328: ldc 156
    //   330: aastore
    //   331: dup
    //   332: iconst_3
    //   333: iload 5
    //   335: invokestatic 162	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   338: aastore
    //   339: dup
    //   340: iconst_4
    //   341: ldc 164
    //   343: aastore
    //   344: dup
    //   345: iconst_5
    //   346: iload 7
    //   348: invokestatic 162	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   351: aastore
    //   352: dup
    //   353: bipush 6
    //   355: ldc 166
    //   357: aastore
    //   358: dup
    //   359: bipush 7
    //   361: iload 6
    //   363: invokestatic 162	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   366: aastore
    //   367: invokevirtual 128	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: iload 5
    //   372: ireturn
    //   373: astore_0
    //   374: getstatic 39	com/tencent/ark/open/security/ArkBaseUrlChecker:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   377: ldc 15
    //   379: new 168	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   386: ldc 171
    //   388: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_0
    //   392: invokevirtual 178	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   395: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokevirtual 98	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: iconst_1
    //   405: ireturn
    //   406: iload 5
    //   408: istore 8
    //   410: iload 6
    //   412: istore 9
    //   414: iload 7
    //   416: istore 10
    //   418: aload 14
    //   420: getfield 147	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem:ruleDomain	Ljava/lang/String;
    //   423: ldc 181
    //   425: invokevirtual 185	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   428: ifeq +93 -> 521
    //   431: aload 12
    //   433: ifnull +88 -> 521
    //   436: iload 5
    //   438: istore 8
    //   440: iload 6
    //   442: istore 9
    //   444: iload 7
    //   446: istore 10
    //   448: aload 14
    //   450: getfield 147	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem:ruleDomain	Ljava/lang/String;
    //   453: invokevirtual 188	java/lang/String:length	()I
    //   456: iconst_1
    //   457: isub
    //   458: istore 4
    //   460: iload 5
    //   462: istore 8
    //   464: iload 6
    //   466: istore 9
    //   468: iload 7
    //   470: istore 10
    //   472: aload 12
    //   474: invokevirtual 188	java/lang/String:length	()I
    //   477: iload 4
    //   479: isub
    //   480: istore_3
    //   481: iload_3
    //   482: istore_2
    //   483: iload_3
    //   484: ifge +5 -> 489
    //   487: iconst_0
    //   488: istore_2
    //   489: iload 5
    //   491: istore 8
    //   493: iload 6
    //   495: istore 9
    //   497: iload 7
    //   499: istore 10
    //   501: aload 12
    //   503: iconst_1
    //   504: iload_2
    //   505: aload 14
    //   507: getfield 147	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem:ruleDomain	Ljava/lang/String;
    //   510: iconst_1
    //   511: iload 4
    //   513: invokevirtual 192	java/lang/String:regionMatches	(ZILjava/lang/String;II)Z
    //   516: istore 7
    //   518: goto -266 -> 252
    //   521: iload 5
    //   523: istore 8
    //   525: iload 6
    //   527: istore 9
    //   529: iload 7
    //   531: istore 10
    //   533: aload 14
    //   535: getfield 147	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem:ruleDomain	Ljava/lang/String;
    //   538: aload 12
    //   540: invokevirtual 195	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   543: istore 7
    //   545: goto -293 -> 252
    //   548: aload 14
    //   550: getfield 152	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem:rulePath	Ljava/lang/String;
    //   553: ldc 181
    //   555: invokevirtual 198	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   558: ifeq +41 -> 599
    //   561: aload 13
    //   563: ifnull +36 -> 599
    //   566: aload 14
    //   568: getfield 152	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem:rulePath	Ljava/lang/String;
    //   571: invokevirtual 188	java/lang/String:length	()I
    //   574: istore_2
    //   575: aload 13
    //   577: iconst_0
    //   578: aload 14
    //   580: getfield 152	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem:rulePath	Ljava/lang/String;
    //   583: iconst_0
    //   584: iload_2
    //   585: iconst_1
    //   586: isub
    //   587: invokevirtual 201	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   590: istore 8
    //   592: iload 8
    //   594: istore 5
    //   596: goto -326 -> 270
    //   599: aload 14
    //   601: getfield 152	com/tencent/ark/open/ArkAppInfo$ArkWhiteUrlItem:rulePath	Ljava/lang/String;
    //   604: aload 13
    //   606: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   609: istore 8
    //   611: iload 8
    //   613: istore 5
    //   615: goto -345 -> 270
    //   618: iconst_0
    //   619: istore 6
    //   621: iload 5
    //   623: istore 8
    //   625: iload 6
    //   627: istore 5
    //   629: iload 8
    //   631: istore 6
    //   633: goto -510 -> 123
    //   636: astore_1
    //   637: iload 9
    //   639: istore 6
    //   641: iload 8
    //   643: istore 5
    //   645: getstatic 39	com/tencent/ark/open/security/ArkBaseUrlChecker:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   648: ldc 15
    //   650: new 168	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   657: ldc 207
    //   659: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: aload_1
    //   663: invokevirtual 208	java/lang/Exception:toString	()Ljava/lang/String;
    //   666: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokevirtual 98	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   675: iload 10
    //   677: istore 7
    //   679: goto -388 -> 291
    //   682: astore_1
    //   683: iload 7
    //   685: istore 10
    //   687: goto -42 -> 645
    //   690: iload 6
    //   692: istore 8
    //   694: iload 5
    //   696: istore 6
    //   698: iload 8
    //   700: istore 5
    //   702: goto -81 -> 621
    //   705: iload 5
    //   707: istore 8
    //   709: goto -422 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	712	0	paramString	String
    //   0	712	1	paramArrayList	ArrayList<ArkAppInfo.ArkWhiteUrlItem>
    //   482	105	2	i	int
    //   480	4	3	j	int
    //   458	54	4	k	int
    //   116	590	5	bool1	boolean
    //   110	587	6	bool2	boolean
    //   104	580	7	bool3	boolean
    //   22	686	8	bool4	boolean
    //   107	531	9	bool5	boolean
    //   101	585	10	bool6	boolean
    //   242	3	11	bool7	boolean
    //   42	497	12	str	String
    //   35	570	13	localObject	Object
    //   165	435	14	localArkWhiteUrlItem	ArkAppInfo.ArkWhiteUrlItem
    // Exception table:
    //   from	to	target	type
    //   27	51	373	java/net/MalformedURLException
    //   118	123	636	java/lang/Exception
    //   135	144	636	java/lang/Exception
    //   156	167	636	java/lang/Exception
    //   184	222	636	java/lang/Exception
    //   234	244	636	java/lang/Exception
    //   418	431	636	java/lang/Exception
    //   448	460	636	java/lang/Exception
    //   472	481	636	java/lang/Exception
    //   501	518	636	java/lang/Exception
    //   533	545	636	java/lang/Exception
    //   252	262	682	java/lang/Exception
    //   548	561	682	java/lang/Exception
    //   566	592	682	java/lang/Exception
    //   599	611	682	java/lang/Exception
  }
  
  public int checkURLLoose(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ENV.logE("ArkApp.ArkBaseUrlChecker", "ArkSafe.checkURLLoose return TYPE_VALID for null url");
      return 0;
    }
    synchronized (this.mLock)
    {
      if ((this.mGlobalBlackList == null) || (this.mGlobalBlackList.size() <= 0)) {
        break label160;
      }
      if (!isUrlValidInList(paramString, this.mGlobalBlackList))
      {
        ENV.logD("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLLoose.not in black list.type=", Integer.valueOf(0), ", url=", ArkUtil.filterKeyForLog(paramString, new String[0]) });
        return 0;
      }
    }
    if (!isUrlValidInList(paramString, this.mWhiteList)) {}
    label160:
    for (int i = 1;; i = 0)
    {
      ENV.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLLoose.type=", Integer.valueOf(i), ", url=", ArkUtil.filterKeyForLog(paramString, new String[0]) });
      return i;
    }
  }
  
  public int checkURLStrict(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ENV.logE("ArkApp.ArkBaseUrlChecker", "ArkSafe.checkURLStrict return TYPE_VALID for null url");
      return 0;
    }
    for (;;)
    {
      boolean bool;
      synchronized (this.mLock)
      {
        if ((this.mGlobalBlackList != null) && (this.mGlobalBlackList.size() > 0))
        {
          if (isUrlValidInList(paramString, this.mGlobalBlackList)) {
            break label234;
          }
          bool = true;
          ENV.logD("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLStrict.isGlobalBlackValid=", Boolean.valueOf(bool) });
          if (!bool)
          {
            ENV.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLStrict.type=", Integer.valueOf(1), ",url=", ArkUtil.filterKeyForLog(paramString, new String[0]) });
            return 1;
          }
        }
        if ((this.mGlobalWhiteList == null) || (this.mGlobalWhiteList.size() <= 0) || (!isUrlValidInList(paramString, this.mGlobalWhiteList))) {
          if (isUrlValidInList(paramString, this.mWhiteList))
          {
            break label239;
            label173:
            ENV.logI("ArkApp.ArkBaseUrlChecker", new Object[] { "ArkSafe.checkURLStrict.type=", Integer.valueOf(i), ", url=", ArkUtil.filterKeyForLog(paramString, new String[0]) });
            return i;
          }
          else
          {
            i = 0;
          }
        }
      }
      label234:
      label239:
      do
      {
        i = 0;
        break label173;
        bool = false;
        break;
        i = 1;
      } while (i != 0);
      int i = 2;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    if (this.mWhiteList != null) {
      localStringBuilder.append("list:").append(this.mWhiteList.toString());
    }
    if (this.mGlobalWhiteList != null) {
      localStringBuilder.append("gloablwhite:").append(this.mGlobalWhiteList.toString());
    }
    if (this.mGlobalBlackList != null) {
      localStringBuilder.append("gloablblack:").append(this.mGlobalBlackList.toString());
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.mWhiteList);
    paramParcel.writeTypedList(this.mGlobalWhiteList);
    paramParcel.writeTypedList(this.mGlobalBlackList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.open.security.ArkBaseUrlChecker
 * JD-Core Version:    0.7.0.1
 */