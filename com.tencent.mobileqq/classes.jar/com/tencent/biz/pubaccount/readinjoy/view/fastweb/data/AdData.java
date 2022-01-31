package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import ajyc;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import nxy;
import nxz;
import nyh;
import org.json.JSONException;
import org.json.JSONObject;
import rjy;

public class AdData
  extends ProteusItemData
  implements Parcelable
{
  public static final Parcelable.Creator<AdData> CREATOR = new rjy();
  public String A;
  public String B;
  public String C;
  public String D;
  public String E;
  public String F;
  public String G;
  public String H;
  public String I;
  public String J;
  public String K;
  public String L = ajyc.a(2131699815);
  public String M;
  public String N;
  public String O;
  public String P;
  public String Q;
  public String R;
  public String S;
  public String T;
  public String U;
  public ArrayList<String> a;
  public nxy a;
  public nxz a;
  public nyh a;
  public JSONObject a;
  public long b;
  public ArrayList<DislikeInfo> b;
  public boolean b;
  public int c;
  public long c;
  public ArrayList<String> c;
  public boolean c;
  public int d;
  public long d;
  public ArrayList<String> d;
  public boolean d;
  public int e;
  public long e;
  public int f;
  public long f;
  public int g;
  public int h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n;
  public String n;
  public int o;
  public String o;
  public String p;
  public String q = "";
  public String r;
  public String s = "1";
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public AdData(int paramInt)
  {
    super(paramInt);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_k_of_type_Int = 0;
  }
  
  public AdData(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_k_of_type_Int = 0;
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.j = paramParcel.readString();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    this.jdField_l_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_m_of_type_JavaLangString = paramParcel.readString();
    this.jdField_n_of_type_JavaLangString = paramParcel.readString();
    this.jdField_o_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.r = paramParcel.readString();
      this.s = paramParcel.readString();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      paramParcel.readList(this.jdField_a_of_type_JavaUtilArrayList, String.class.getClassLoader());
      this.t = paramParcel.readString();
      this.u = paramParcel.readString();
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      paramParcel.readList(this.jdField_b_of_type_JavaUtilArrayList, DislikeInfo.class.getClassLoader());
      this.v = paramParcel.readString();
      this.w = paramParcel.readString();
      this.x = paramParcel.readString();
      this.y = paramParcel.readString();
      this.jdField_b_of_type_Long = paramParcel.readLong();
      this.z = paramParcel.readString();
      this.A = paramParcel.readString();
      this.B = paramParcel.readString();
      this.C = paramParcel.readString();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.D = paramParcel.readString();
      this.E = paramParcel.readString();
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.F = paramParcel.readString();
      this.G = paramParcel.readString();
      this.H = paramParcel.readString();
      this.jdField_d_of_type_Long = paramParcel.readLong();
      this.g = paramParcel.readInt();
      this.I = paramParcel.readString();
      this.jdField_e_of_type_Long = paramParcel.readLong();
      this.jdField_f_of_type_Long = paramParcel.readLong();
      this.h = paramParcel.readInt();
      this.L = paramParcel.readString();
      this.M = paramParcel.readString();
      this.N = paramParcel.readString();
      this.O = paramParcel.readString();
      this.P = paramParcel.readString();
      this.jdField_l_of_type_Int = paramParcel.readInt();
      this.jdField_m_of_type_Int = paramParcel.readInt();
      this.U = paramParcel.readString();
      this.T = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    switch (paramBaseData.p)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void a() {}
  
  public void a(String paramString, Object paramObject)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramObject == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      }
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramObject);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("addArticleExt", 2, "e:" + paramString.toString());
  }
  
  /* Error */
  public void a(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_1
    //   4: istore 7
    //   6: aload_1
    //   7: ifnull +2213 -> 2220
    //   10: aload_0
    //   11: aload_2
    //   12: putfield 168	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:v	Ljava/lang/String;
    //   15: aload_0
    //   16: aload_1
    //   17: ldc_w 282
    //   20: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   23: putfield 206	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:g	I
    //   26: aload_0
    //   27: aload_1
    //   28: ldc_w 288
    //   31: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   34: putfield 170	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:w	Ljava/lang/String;
    //   37: aload_0
    //   38: aload_1
    //   39: ldc_w 294
    //   42: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: putfield 172	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:x	Ljava/lang/String;
    //   48: aload_0
    //   49: aload_1
    //   50: ldc_w 296
    //   53: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: putfield 174	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:y	Ljava/lang/String;
    //   59: aload_0
    //   60: aload_1
    //   61: ldc_w 298
    //   64: invokevirtual 302	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   67: putfield 180	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_b_of_type_Long	J
    //   70: aload_0
    //   71: aload_1
    //   72: ldc_w 304
    //   75: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: putfield 182	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:z	Ljava/lang/String;
    //   81: aload_0
    //   82: aload_1
    //   83: ldc_w 306
    //   86: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: putfield 184	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:A	Ljava/lang/String;
    //   92: aload_0
    //   93: aload_1
    //   94: ldc_w 308
    //   97: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: putfield 186	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:B	Ljava/lang/String;
    //   103: aload_0
    //   104: aload_1
    //   105: ldc_w 310
    //   108: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: putfield 188	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:C	Ljava/lang/String;
    //   114: aload_0
    //   115: aload_1
    //   116: ldc_w 312
    //   119: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   122: putfield 190	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_f_of_type_Int	I
    //   125: aload_0
    //   126: aload_1
    //   127: ldc_w 314
    //   130: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: putfield 192	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:D	Ljava/lang/String;
    //   136: aload_0
    //   137: aload_1
    //   138: ldc_w 316
    //   141: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: putfield 194	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:E	Ljava/lang/String;
    //   147: aload_0
    //   148: aload_1
    //   149: ldc_w 318
    //   152: invokevirtual 302	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   155: putfield 196	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_c_of_type_Long	J
    //   158: aload_0
    //   159: aload_1
    //   160: ldc_w 320
    //   163: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   166: putfield 198	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:F	Ljava/lang/String;
    //   169: aload_0
    //   170: aload_1
    //   171: ldc_w 322
    //   174: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: putfield 200	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:G	Ljava/lang/String;
    //   180: aload_0
    //   181: aload_1
    //   182: ldc_w 324
    //   185: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   188: putfield 202	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:H	Ljava/lang/String;
    //   191: aload_0
    //   192: aload_1
    //   193: ldc_w 326
    //   196: invokevirtual 302	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   199: putfield 204	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_d_of_type_Long	J
    //   202: aload_0
    //   203: aload_1
    //   204: ldc_w 328
    //   207: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   210: putfield 208	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:I	Ljava/lang/String;
    //   213: aload_0
    //   214: aload_1
    //   215: ldc_w 330
    //   218: invokevirtual 302	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   221: putfield 210	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_e_of_type_Long	J
    //   224: aload_0
    //   225: aload_1
    //   226: ldc_w 332
    //   229: invokevirtual 302	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   232: putfield 212	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_f_of_type_Long	J
    //   235: aload_0
    //   236: aload_1
    //   237: ldc_w 334
    //   240: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   243: putfield 137	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_b_of_type_Boolean	Z
    //   246: aload_0
    //   247: getfield 137	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_b_of_type_Boolean	Z
    //   250: ifeq +14 -> 264
    //   253: aload_0
    //   254: aload_1
    //   255: ldc_w 334
    //   258: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   261: putfield 139	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:r	Ljava/lang/String;
    //   264: aload_1
    //   265: ldc_w 340
    //   268: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   271: ifeq +14 -> 285
    //   274: aload_0
    //   275: aload_1
    //   276: ldc_w 340
    //   279: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   282: putfield 109	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   285: aload_1
    //   286: ldc_w 342
    //   289: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   292: ifeq +14 -> 306
    //   295: aload_0
    //   296: aload_1
    //   297: ldc_w 342
    //   300: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   303: putfield 111	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:j	Ljava/lang/String;
    //   306: aload_1
    //   307: ldc_w 344
    //   310: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   313: ifeq +14 -> 327
    //   316: aload_0
    //   317: aload_1
    //   318: ldc_w 344
    //   321: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   324: putfield 113	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   327: aload_1
    //   328: ldc_w 346
    //   331: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   334: ifeq +14 -> 348
    //   337: aload_0
    //   338: aload_1
    //   339: ldc_w 346
    //   342: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   345: putfield 121	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_c_of_type_Int	I
    //   348: aload_1
    //   349: ldc_w 348
    //   352: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   355: ifeq +39 -> 394
    //   358: aload_1
    //   359: ldc_w 348
    //   362: invokevirtual 352	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   365: astore_2
    //   366: aload_2
    //   367: invokevirtual 357	org/json/JSONArray:length	()I
    //   370: ifle +24 -> 394
    //   373: aload_0
    //   374: getfield 121	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_c_of_type_Int	I
    //   377: iconst_1
    //   378: if_icmpne +999 -> 1377
    //   381: aload_0
    //   382: aload_2
    //   383: iconst_0
    //   384: invokevirtual 359	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   387: iconst_1
    //   388: invokestatic 364	rmu:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   391: putfield 115	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   394: aload_1
    //   395: ldc_w 366
    //   398: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   401: ifeq +18 -> 419
    //   404: aload_0
    //   405: aload_1
    //   406: ldc_w 366
    //   409: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   412: iconst_1
    //   413: invokestatic 364	rmu:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   416: putfield 123	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   419: aload_1
    //   420: ldc_w 368
    //   423: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   426: ifeq +18 -> 444
    //   429: aload_0
    //   430: aload_1
    //   431: ldc_w 368
    //   434: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   437: iconst_1
    //   438: invokestatic 364	rmu:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   441: putfield 125	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_n_of_type_JavaLangString	Ljava/lang/String;
    //   444: aload_1
    //   445: ldc_w 370
    //   448: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   451: ifeq +18 -> 469
    //   454: aload_0
    //   455: aload_1
    //   456: ldc_w 370
    //   459: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   462: iconst_1
    //   463: invokestatic 364	rmu:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   466: putfield 127	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_o_of_type_JavaLangString	Ljava/lang/String;
    //   469: aload_1
    //   470: ldc_w 372
    //   473: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   476: ifeq +14 -> 490
    //   479: aload_0
    //   480: aload_1
    //   481: ldc_w 372
    //   484: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   487: putfield 129	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_d_of_type_Int	I
    //   490: aload_1
    //   491: ldc_w 314
    //   494: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   497: ifeq +14 -> 511
    //   500: aload_0
    //   501: aload_1
    //   502: ldc_w 314
    //   505: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   508: putfield 131	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:p	Ljava/lang/String;
    //   511: aload_1
    //   512: ldc_w 374
    //   515: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   518: ifeq +14 -> 532
    //   521: aload_0
    //   522: aload_1
    //   523: ldc_w 374
    //   526: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   529: putfield 82	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:q	Ljava/lang/String;
    //   532: aload_1
    //   533: ldc_w 376
    //   536: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   539: ifeq +14 -> 553
    //   542: aload_0
    //   543: aload_1
    //   544: ldc_w 376
    //   547: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   550: putfield 86	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:s	Ljava/lang/String;
    //   553: aload_1
    //   554: ldc_w 378
    //   557: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   560: ifeq +14 -> 574
    //   563: aload_0
    //   564: aload_1
    //   565: ldc_w 378
    //   568: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   571: putfield 141	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_e_of_type_Int	I
    //   574: aload_1
    //   575: ldc_w 380
    //   578: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   581: ifeq +14 -> 595
    //   584: aload_0
    //   585: aload_1
    //   586: ldc_w 380
    //   589: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   592: putfield 162	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:u	Ljava/lang/String;
    //   595: aload_1
    //   596: ldc_w 382
    //   599: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   602: ifeq +14 -> 616
    //   605: aload_0
    //   606: aload_1
    //   607: ldc_w 382
    //   610: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   613: putfield 160	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:t	Ljava/lang/String;
    //   616: aload_1
    //   617: ldc_w 384
    //   620: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   623: ifeq +14 -> 637
    //   626: aload_0
    //   627: aload_1
    //   628: ldc_w 384
    //   631: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   634: putfield 141	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_e_of_type_Int	I
    //   637: aload_1
    //   638: ldc_w 386
    //   641: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   644: ifeq +14 -> 658
    //   647: aload_0
    //   648: aload_1
    //   649: ldc_w 386
    //   652: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   655: putfield 388	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:J	Ljava/lang/String;
    //   658: aload_1
    //   659: ldc_w 390
    //   662: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   665: ifeq +14 -> 679
    //   668: aload_0
    //   669: aload_1
    //   670: ldc_w 390
    //   673: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   676: putfield 96	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:L	Ljava/lang/String;
    //   679: aload_1
    //   680: ldc_w 392
    //   683: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   686: ifeq +14 -> 700
    //   689: aload_0
    //   690: aload_1
    //   691: ldc_w 392
    //   694: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   697: putfield 220	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:O	Ljava/lang/String;
    //   700: aload_1
    //   701: ldc_w 394
    //   704: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   707: ifeq +14 -> 721
    //   710: aload_0
    //   711: aload_1
    //   712: ldc_w 394
    //   715: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   718: putfield 216	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:M	Ljava/lang/String;
    //   721: aload_1
    //   722: ldc_w 396
    //   725: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   728: ifeq +14 -> 742
    //   731: aload_0
    //   732: aload_1
    //   733: ldc_w 396
    //   736: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   739: putfield 218	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:N	Ljava/lang/String;
    //   742: aload_1
    //   743: ldc_w 398
    //   746: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   749: ifeq +14 -> 763
    //   752: aload_0
    //   753: aload_1
    //   754: ldc_w 398
    //   757: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   760: putfield 222	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:P	Ljava/lang/String;
    //   763: aload_0
    //   764: aload_1
    //   765: ldc_w 400
    //   768: iconst_0
    //   769: invokevirtual 403	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   772: putfield 405	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_n_of_type_Int	I
    //   775: aload_1
    //   776: ldc_w 407
    //   779: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   782: ifeq +14 -> 796
    //   785: aload_0
    //   786: aload_1
    //   787: ldc_w 407
    //   790: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   793: putfield 409	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_i_of_type_Int	I
    //   796: aload_0
    //   797: new 411	nxy
    //   800: dup
    //   801: invokespecial 412	nxy:<init>	()V
    //   804: putfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxy	Lnxy;
    //   807: aload_1
    //   808: ldc_w 416
    //   811: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   814: ifeq +695 -> 1509
    //   817: aload_1
    //   818: ldc_w 416
    //   821: invokevirtual 420	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   824: astore_2
    //   825: aload_0
    //   826: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxy	Lnxy;
    //   829: aload_2
    //   830: invokevirtual 423	nxy:a	(Lorg/json/JSONObject;)V
    //   833: aload_0
    //   834: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxy	Lnxy;
    //   837: getfield 425	nxy:b	Ljava/lang/String;
    //   840: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   843: ifne +25 -> 868
    //   846: aload_0
    //   847: aload_0
    //   848: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxy	Lnxy;
    //   851: getfield 425	nxy:b	Ljava/lang/String;
    //   854: putfield 131	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:p	Ljava/lang/String;
    //   857: aload_0
    //   858: aload_0
    //   859: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxy	Lnxy;
    //   862: getfield 425	nxy:b	Ljava/lang/String;
    //   865: putfield 192	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:D	Ljava/lang/String;
    //   868: aload_0
    //   869: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxy	Lnxy;
    //   872: aload_0
    //   873: getfield 184	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:A	Ljava/lang/String;
    //   876: putfield 427	nxy:f	Ljava/lang/String;
    //   879: aload_0
    //   880: aload_1
    //   881: ldc_w 429
    //   884: ldc 80
    //   886: invokevirtual 432	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   889: putfield 230	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:T	Ljava/lang/String;
    //   892: aload_0
    //   893: getfield 230	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:T	Ljava/lang/String;
    //   896: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   899: ifeq +17 -> 916
    //   902: aload_0
    //   903: new 248	org/json/JSONObject
    //   906: dup
    //   907: invokespecial 249	org/json/JSONObject:<init>	()V
    //   910: invokevirtual 433	org/json/JSONObject:toString	()Ljava/lang/String;
    //   913: putfield 230	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:T	Ljava/lang/String;
    //   916: aload_0
    //   917: new 435	nxz
    //   920: dup
    //   921: invokespecial 436	nxz:<init>	()V
    //   924: putfield 438	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxz	Lnxz;
    //   927: aload_0
    //   928: getfield 438	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxz	Lnxz;
    //   931: aload_1
    //   932: aload_0
    //   933: getfield 438	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxz	Lnxz;
    //   936: aload_0
    //   937: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxy	Lnxy;
    //   940: invokevirtual 441	nxz:a	(Lorg/json/JSONObject;Lnxz;Lnxy;)V
    //   943: aload_1
    //   944: ldc_w 443
    //   947: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   950: ifeq +14 -> 964
    //   953: aload_0
    //   954: aload_1
    //   955: ldc_w 443
    //   958: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   961: putfield 445	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:R	Ljava/lang/String;
    //   964: aload_1
    //   965: ldc_w 447
    //   968: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   971: ifeq +14 -> 985
    //   974: aload_0
    //   975: aload_1
    //   976: ldc_w 447
    //   979: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   982: putfield 449	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:S	Ljava/lang/String;
    //   985: aload_1
    //   986: ldc_w 451
    //   989: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   992: ifeq +29 -> 1021
    //   995: aload_1
    //   996: ldc_w 451
    //   999: invokevirtual 455	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   1002: astore_2
    //   1003: aload_2
    //   1004: instanceof 248
    //   1007: ifeq +14 -> 1021
    //   1010: aload_0
    //   1011: aload_2
    //   1012: checkcast 248	org/json/JSONObject
    //   1015: invokevirtual 433	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1018: putfield 228	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:U	Ljava/lang/String;
    //   1021: aload_0
    //   1022: getfield 228	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:U	Ljava/lang/String;
    //   1025: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1028: ifeq +17 -> 1045
    //   1031: aload_0
    //   1032: new 248	org/json/JSONObject
    //   1035: dup
    //   1036: invokespecial 249	org/json/JSONObject:<init>	()V
    //   1039: invokevirtual 433	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1042: putfield 228	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:U	Ljava/lang/String;
    //   1045: new 248	org/json/JSONObject
    //   1048: dup
    //   1049: aload_0
    //   1050: getfield 228	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:U	Ljava/lang/String;
    //   1053: invokespecial 458	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1056: astore_2
    //   1057: aload_2
    //   1058: ldc_w 460
    //   1061: aload_0
    //   1062: getfield 168	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:v	Ljava/lang/String;
    //   1065: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1068: pop
    //   1069: aload_1
    //   1070: ldc_w 462
    //   1073: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1076: ifeq +18 -> 1094
    //   1079: aload_2
    //   1080: ldc_w 462
    //   1083: aload_1
    //   1084: ldc_w 462
    //   1087: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1090: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1093: pop
    //   1094: aload_1
    //   1095: ldc_w 464
    //   1098: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1101: ifeq +18 -> 1119
    //   1104: aload_2
    //   1105: ldc_w 464
    //   1108: aload_1
    //   1109: ldc_w 464
    //   1112: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1115: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1118: pop
    //   1119: aload_1
    //   1120: ldc_w 466
    //   1123: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1126: ifeq +18 -> 1144
    //   1129: aload_2
    //   1130: ldc_w 466
    //   1133: aload_1
    //   1134: ldc_w 466
    //   1137: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1140: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1143: pop
    //   1144: aload_1
    //   1145: ldc_w 468
    //   1148: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1151: ifeq +18 -> 1169
    //   1154: aload_2
    //   1155: ldc_w 468
    //   1158: aload_1
    //   1159: ldc_w 468
    //   1162: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1165: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1168: pop
    //   1169: aload_1
    //   1170: ldc_w 470
    //   1173: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1176: ifeq +18 -> 1194
    //   1179: aload_2
    //   1180: ldc_w 470
    //   1183: aload_1
    //   1184: ldc_w 470
    //   1187: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1190: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1193: pop
    //   1194: aload_0
    //   1195: aload_2
    //   1196: invokevirtual 433	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1199: putfield 228	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:U	Ljava/lang/String;
    //   1202: aload_0
    //   1203: new 472	nyh
    //   1206: dup
    //   1207: aload_0
    //   1208: getfield 228	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:U	Ljava/lang/String;
    //   1211: invokespecial 473	nyh:<init>	(Ljava/lang/String;)V
    //   1214: putfield 475	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nyh	Lnyh;
    //   1217: aload_1
    //   1218: ldc_w 477
    //   1221: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1224: ifeq +14 -> 1238
    //   1227: aload_0
    //   1228: aload_1
    //   1229: ldc_w 477
    //   1232: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1235: putfield 224	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_l_of_type_Int	I
    //   1238: aload_1
    //   1239: ldc_w 479
    //   1242: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1245: ifeq +25 -> 1270
    //   1248: aload_0
    //   1249: aload_1
    //   1250: ldc_w 479
    //   1253: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1256: putfield 481	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_o_of_type_Int	I
    //   1259: aload_0
    //   1260: getfield 475	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nyh	Lnyh;
    //   1263: aload_0
    //   1264: getfield 481	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_o_of_type_Int	I
    //   1267: putfield 482	nyh:h	I
    //   1270: aload_1
    //   1271: ldc_w 484
    //   1274: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1277: ifeq +328 -> 1605
    //   1280: aload_1
    //   1281: ldc_w 484
    //   1284: invokevirtual 352	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1287: astore_2
    //   1288: new 143	java/util/ArrayList
    //   1291: dup
    //   1292: invokespecial 144	java/util/ArrayList:<init>	()V
    //   1295: astore 8
    //   1297: aload_2
    //   1298: ifnull +307 -> 1605
    //   1301: new 143	java/util/ArrayList
    //   1304: dup
    //   1305: invokespecial 144	java/util/ArrayList:<init>	()V
    //   1308: pop
    //   1309: iconst_0
    //   1310: istore_3
    //   1311: iload_3
    //   1312: aload_2
    //   1313: invokevirtual 357	org/json/JSONArray:length	()I
    //   1316: if_icmpge +283 -> 1599
    //   1319: new 166	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo
    //   1322: dup
    //   1323: invokespecial 485	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:<init>	()V
    //   1326: astore 9
    //   1328: aload_2
    //   1329: iload_3
    //   1330: invokevirtual 489	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1333: astore 10
    //   1335: aload 9
    //   1337: aload 10
    //   1339: ldc_w 491
    //   1342: invokevirtual 494	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1345: i2l
    //   1346: putfield 496	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:jdField_a_of_type_Long	J
    //   1349: aload 9
    //   1351: aload 10
    //   1353: ldc_w 498
    //   1356: invokevirtual 501	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1359: putfield 503	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1362: aload 8
    //   1364: aload 9
    //   1366: invokevirtual 507	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1369: pop
    //   1370: iload_3
    //   1371: iconst_1
    //   1372: iadd
    //   1373: istore_3
    //   1374: goto -63 -> 1311
    //   1377: aload_0
    //   1378: getfield 121	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_c_of_type_Int	I
    //   1381: iconst_3
    //   1382: if_icmpne -988 -> 394
    //   1385: aload_0
    //   1386: new 143	java/util/ArrayList
    //   1389: dup
    //   1390: invokespecial 144	java/util/ArrayList:<init>	()V
    //   1393: putfield 146	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1396: aload_2
    //   1397: invokevirtual 357	org/json/JSONArray:length	()I
    //   1400: istore 5
    //   1402: iconst_0
    //   1403: istore_3
    //   1404: iload_3
    //   1405: iload 5
    //   1407: if_icmpge +27 -> 1434
    //   1410: aload_0
    //   1411: getfield 146	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1414: aload_2
    //   1415: iload_3
    //   1416: invokevirtual 359	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   1419: iconst_1
    //   1420: invokestatic 364	rmu:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1423: invokevirtual 507	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1426: pop
    //   1427: iload_3
    //   1428: iconst_1
    //   1429: iadd
    //   1430: istore_3
    //   1431: goto -27 -> 1404
    //   1434: iload 5
    //   1436: iconst_3
    //   1437: if_icmpge -1043 -> 394
    //   1440: iload 5
    //   1442: iconst_2
    //   1443: if_icmpne +23 -> 1466
    //   1446: aload_0
    //   1447: getfield 146	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1450: aload_2
    //   1451: iconst_0
    //   1452: invokevirtual 359	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   1455: iconst_1
    //   1456: invokestatic 364	rmu:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1459: invokevirtual 507	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1462: pop
    //   1463: goto -1069 -> 394
    //   1466: iload 5
    //   1468: iconst_1
    //   1469: if_icmpne -1075 -> 394
    //   1472: aload_0
    //   1473: getfield 146	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1476: aload_2
    //   1477: iconst_0
    //   1478: invokevirtual 359	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   1481: iconst_1
    //   1482: invokestatic 364	rmu:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1485: invokevirtual 507	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1488: pop
    //   1489: aload_0
    //   1490: getfield 146	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1493: aload_2
    //   1494: iconst_0
    //   1495: invokevirtual 359	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   1498: iconst_1
    //   1499: invokestatic 364	rmu:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1502: invokevirtual 507	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1505: pop
    //   1506: goto -1112 -> 394
    //   1509: aload_0
    //   1510: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxy	Lnxy;
    //   1513: aload_0
    //   1514: getfield 131	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:p	Ljava/lang/String;
    //   1517: putfield 425	nxy:b	Ljava/lang/String;
    //   1520: aload_0
    //   1521: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxy	Lnxy;
    //   1524: aload_0
    //   1525: getfield 184	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:A	Ljava/lang/String;
    //   1528: putfield 427	nxy:f	Ljava/lang/String;
    //   1531: aload_0
    //   1532: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxy	Lnxy;
    //   1535: aload_0
    //   1536: getfield 194	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:E	Ljava/lang/String;
    //   1539: putfield 509	nxy:e	Ljava/lang/String;
    //   1542: aload_0
    //   1543: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nxy	Lnxy;
    //   1546: aload_0
    //   1547: getfield 196	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_c_of_type_Long	J
    //   1550: invokestatic 513	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1553: putfield 515	nxy:c	Ljava/lang/String;
    //   1556: goto -677 -> 879
    //   1559: astore_2
    //   1560: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1563: ifeq -361 -> 1202
    //   1566: ldc_w 517
    //   1569: iconst_2
    //   1570: new 263	java/lang/StringBuilder
    //   1573: dup
    //   1574: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1577: ldc_w 519
    //   1580: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: aload_2
    //   1584: invokevirtual 520	java/lang/Exception:toString	()Ljava/lang/String;
    //   1587: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1593: invokestatic 522	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1596: goto -394 -> 1202
    //   1599: aload_0
    //   1600: aload 8
    //   1602: putfield 164	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1605: aload_1
    //   1606: ldc_w 524
    //   1609: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1612: ifeq +23 -> 1635
    //   1615: aload_1
    //   1616: ldc_w 524
    //   1619: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1622: iconst_1
    //   1623: if_icmpne +298 -> 1921
    //   1626: iconst_1
    //   1627: istore 6
    //   1629: aload_0
    //   1630: iload 6
    //   1632: putfield 526	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_c_of_type_Boolean	Z
    //   1635: aload_1
    //   1636: ldc_w 528
    //   1639: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1642: ifeq +74 -> 1716
    //   1645: new 248	org/json/JSONObject
    //   1648: dup
    //   1649: aload_1
    //   1650: ldc_w 528
    //   1653: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1656: invokespecial 458	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1659: astore_2
    //   1660: aload_2
    //   1661: ldc_w 530
    //   1664: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1667: ifeq +49 -> 1716
    //   1670: aload_2
    //   1671: ldc_w 530
    //   1674: invokevirtual 501	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1677: astore_2
    //   1678: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1681: ifeq +30 -> 1711
    //   1684: ldc_w 517
    //   1687: iconst_2
    //   1688: new 263	java/lang/StringBuilder
    //   1691: dup
    //   1692: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1695: ldc_w 532
    //   1698: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1701: aload_2
    //   1702: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1708: invokestatic 522	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1711: aload_0
    //   1712: aload_2
    //   1713: putfield 534	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:K	Ljava/lang/String;
    //   1716: aload_1
    //   1717: ldc_w 536
    //   1720: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1723: ifeq +66 -> 1789
    //   1726: aload_1
    //   1727: ldc_w 536
    //   1730: ldc 84
    //   1732: invokevirtual 432	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1735: astore_2
    //   1736: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1739: ifeq +30 -> 1769
    //   1742: ldc_w 517
    //   1745: iconst_2
    //   1746: new 263	java/lang/StringBuilder
    //   1749: dup
    //   1750: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1753: ldc_w 538
    //   1756: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: aload_2
    //   1760: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1766: invokestatic 522	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1769: aload_2
    //   1770: ldc_w 540
    //   1773: invokevirtual 543	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1776: ifne +191 -> 1967
    //   1779: iload 7
    //   1781: istore 6
    //   1783: aload_0
    //   1784: iload 6
    //   1786: putfield 88	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_d_of_type_Boolean	Z
    //   1789: aload_1
    //   1790: ldc_w 545
    //   1793: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1796: ifeq +14 -> 1810
    //   1799: aload_0
    //   1800: aload_1
    //   1801: ldc_w 545
    //   1804: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1807: putfield 214	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:h	I
    //   1810: aload_1
    //   1811: ldc_w 547
    //   1814: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1817: ifeq +202 -> 2019
    //   1820: aload_1
    //   1821: ldc_w 547
    //   1824: invokevirtual 352	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1827: astore_2
    //   1828: aload_2
    //   1829: ifnull +190 -> 2019
    //   1832: aload_2
    //   1833: invokevirtual 357	org/json/JSONArray:length	()I
    //   1836: ifle +183 -> 2019
    //   1839: aload_2
    //   1840: invokevirtual 357	org/json/JSONArray:length	()I
    //   1843: istore 5
    //   1845: new 143	java/util/ArrayList
    //   1848: dup
    //   1849: invokespecial 144	java/util/ArrayList:<init>	()V
    //   1852: astore 8
    //   1854: iconst_0
    //   1855: istore_3
    //   1856: iload_3
    //   1857: iload 5
    //   1859: if_icmpge +154 -> 2013
    //   1862: aload_2
    //   1863: iload_3
    //   1864: invokevirtual 550	org/json/JSONArray:opt	(I)Ljava/lang/Object;
    //   1867: checkcast 148	java/lang/String
    //   1870: astore 9
    //   1872: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1875: ifeq +31 -> 1906
    //   1878: ldc_w 552
    //   1881: iconst_2
    //   1882: new 263	java/lang/StringBuilder
    //   1885: dup
    //   1886: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1889: ldc_w 554
    //   1892: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1895: aload 9
    //   1897: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1900: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1903: invokestatic 522	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1906: aload 8
    //   1908: aload 9
    //   1910: invokevirtual 507	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1913: pop
    //   1914: iload_3
    //   1915: iconst_1
    //   1916: iadd
    //   1917: istore_3
    //   1918: goto -62 -> 1856
    //   1921: iconst_0
    //   1922: istore 6
    //   1924: goto -295 -> 1629
    //   1927: astore_2
    //   1928: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1931: ifeq -215 -> 1716
    //   1934: ldc_w 517
    //   1937: iconst_2
    //   1938: new 263	java/lang/StringBuilder
    //   1941: dup
    //   1942: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1945: ldc_w 266
    //   1948: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1951: aload_2
    //   1952: invokevirtual 520	java/lang/Exception:toString	()Ljava/lang/String;
    //   1955: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1961: invokestatic 522	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1964: goto -248 -> 1716
    //   1967: iconst_0
    //   1968: istore 6
    //   1970: goto -187 -> 1783
    //   1973: astore_2
    //   1974: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1977: ifeq -188 -> 1789
    //   1980: ldc_w 517
    //   1983: iconst_2
    //   1984: new 263	java/lang/StringBuilder
    //   1987: dup
    //   1988: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1991: ldc_w 266
    //   1994: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1997: aload_2
    //   1998: invokevirtual 520	java/lang/Exception:toString	()Ljava/lang/String;
    //   2001: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2004: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2007: invokestatic 522	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2010: goto -221 -> 1789
    //   2013: aload_0
    //   2014: aload 8
    //   2016: putfield 556	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2019: aload_1
    //   2020: ldc_w 558
    //   2023: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2026: ifeq +111 -> 2137
    //   2029: aload_1
    //   2030: ldc_w 558
    //   2033: invokevirtual 352	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2036: astore_2
    //   2037: aload_2
    //   2038: ifnull +99 -> 2137
    //   2041: aload_2
    //   2042: invokevirtual 357	org/json/JSONArray:length	()I
    //   2045: ifle +92 -> 2137
    //   2048: aload_2
    //   2049: invokevirtual 357	org/json/JSONArray:length	()I
    //   2052: istore 5
    //   2054: new 143	java/util/ArrayList
    //   2057: dup
    //   2058: invokespecial 144	java/util/ArrayList:<init>	()V
    //   2061: astore 8
    //   2063: iload 4
    //   2065: istore_3
    //   2066: iload_3
    //   2067: iload 5
    //   2069: if_icmpge +62 -> 2131
    //   2072: aload_2
    //   2073: iload_3
    //   2074: invokevirtual 550	org/json/JSONArray:opt	(I)Ljava/lang/Object;
    //   2077: checkcast 148	java/lang/String
    //   2080: astore 9
    //   2082: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2085: ifeq +31 -> 2116
    //   2088: ldc_w 552
    //   2091: iconst_2
    //   2092: new 263	java/lang/StringBuilder
    //   2095: dup
    //   2096: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   2099: ldc_w 560
    //   2102: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2105: aload 9
    //   2107: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2110: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2113: invokestatic 522	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2116: aload 8
    //   2118: aload 9
    //   2120: invokevirtual 507	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2123: pop
    //   2124: iload_3
    //   2125: iconst_1
    //   2126: iadd
    //   2127: istore_3
    //   2128: goto -62 -> 2066
    //   2131: aload_0
    //   2132: aload 8
    //   2134: putfield 562	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_d_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2137: aload_1
    //   2138: ldc_w 564
    //   2141: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2144: ifeq +14 -> 2158
    //   2147: aload_0
    //   2148: aload_1
    //   2149: ldc_w 564
    //   2152: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2155: putfield 226	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_m_of_type_Int	I
    //   2158: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2161: ifeq +59 -> 2220
    //   2164: ldc_w 552
    //   2167: iconst_2
    //   2168: new 263	java/lang/StringBuilder
    //   2171: dup
    //   2172: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   2175: ldc_w 566
    //   2178: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2181: aload_0
    //   2182: getfield 208	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:I	Ljava/lang/String;
    //   2185: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2188: ldc_w 568
    //   2191: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2194: aload_0
    //   2195: getfield 162	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:u	Ljava/lang/String;
    //   2198: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2201: ldc_w 570
    //   2204: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2207: aload_0
    //   2208: getfield 214	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:h	I
    //   2211: invokevirtual 573	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2214: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2217: invokestatic 522	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2220: return
    //   2221: astore_1
    //   2222: return
    //   2223: astore_2
    //   2224: goto -619 -> 1605
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2227	0	this	AdData
    //   0	2227	1	paramJSONObject	JSONObject
    //   0	2227	2	paramString	String
    //   1310	818	3	i1	int
    //   1	2063	4	i2	int
    //   1400	670	5	i3	int
    //   1627	342	6	bool1	boolean
    //   4	1776	7	bool2	boolean
    //   1295	838	8	localArrayList	ArrayList
    //   1326	793	9	localObject	Object
    //   1333	19	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   1045	1094	1559	java/lang/Exception
    //   1094	1119	1559	java/lang/Exception
    //   1119	1144	1559	java/lang/Exception
    //   1144	1169	1559	java/lang/Exception
    //   1169	1194	1559	java/lang/Exception
    //   1194	1202	1559	java/lang/Exception
    //   1635	1711	1927	java/lang/Exception
    //   1711	1716	1927	java/lang/Exception
    //   1716	1769	1973	java/lang/Exception
    //   1769	1779	1973	java/lang/Exception
    //   1783	1789	1973	java/lang/Exception
    //   1789	1810	2221	java/lang/Exception
    //   1810	1828	2221	java/lang/Exception
    //   1832	1854	2221	java/lang/Exception
    //   1862	1906	2221	java/lang/Exception
    //   1906	1914	2221	java/lang/Exception
    //   2013	2019	2221	java/lang/Exception
    //   2019	2037	2221	java/lang/Exception
    //   2041	2063	2221	java/lang/Exception
    //   2072	2116	2221	java/lang/Exception
    //   2116	2124	2221	java/lang/Exception
    //   2131	2137	2221	java/lang/Exception
    //   2137	2158	2221	java/lang/Exception
    //   2158	2220	2221	java/lang/Exception
    //   1270	1297	2223	java/lang/Exception
    //   1301	1309	2223	java/lang/Exception
    //   1311	1370	2223	java/lang/Exception
    //   1599	1605	2223	java/lang/Exception
  }
  
  public boolean a(JSONObject paramJSONObject, int paramInt)
  {
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_n_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_o_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    if (this.jdField_b_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.r);
      paramParcel.writeString(this.s);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
      paramParcel.writeString(this.t);
      paramParcel.writeString(this.u);
      paramParcel.writeList(this.jdField_b_of_type_JavaUtilArrayList);
      paramParcel.writeString(this.v);
      paramParcel.writeString(this.w);
      paramParcel.writeString(this.x);
      paramParcel.writeString(this.y);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeString(this.z);
      paramParcel.writeString(this.A);
      paramParcel.writeString(this.B);
      paramParcel.writeString(this.C);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeString(this.D);
      paramParcel.writeString(this.E);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeString(this.F);
      paramParcel.writeString(this.G);
      paramParcel.writeString(this.H);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeInt(this.g);
      paramParcel.writeString(this.I);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      paramParcel.writeLong(this.jdField_f_of_type_Long);
      paramParcel.writeInt(this.h);
      paramParcel.writeString(this.L);
      paramParcel.writeString(this.M);
      paramParcel.writeString(this.N);
      paramParcel.writeString(this.O);
      paramParcel.writeString(this.P);
      paramParcel.writeInt(this.jdField_l_of_type_Int);
      paramParcel.writeInt(this.jdField_m_of_type_Int);
      paramParcel.writeString(this.U);
      paramParcel.writeString(this.T);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData
 * JD-Core Version:    0.7.0.1
 */