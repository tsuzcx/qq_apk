package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import ajjy;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import nmn;
import nmo;
import nmw;
import org.json.JSONException;
import org.json.JSONObject;
import qxg;

public class AdData
  extends ProteusItemData
  implements Parcelable
{
  public static final Parcelable.Creator<AdData> CREATOR = new qxg();
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
  public String L = ajjy.a(2131634027);
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
  public nmn a;
  public nmo a;
  public nmw a;
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
    //   7: ifnull +2088 -> 2095
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
    //   378: if_icmpne +874 -> 1252
    //   381: aload_0
    //   382: aload_2
    //   383: iconst_0
    //   384: invokevirtual 359	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   387: iconst_1
    //   388: invokestatic 364	rac:a	(Ljava/lang/String;Z)Ljava/lang/String;
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
    //   413: invokestatic 364	rac:a	(Ljava/lang/String;Z)Ljava/lang/String;
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
    //   438: invokestatic 364	rac:a	(Ljava/lang/String;Z)Ljava/lang/String;
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
    //   463: invokestatic 364	rac:a	(Ljava/lang/String;Z)Ljava/lang/String;
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
    //   797: new 411	nmn
    //   800: dup
    //   801: invokespecial 412	nmn:<init>	()V
    //   804: putfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmn	Lnmn;
    //   807: aload_1
    //   808: ldc_w 416
    //   811: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   814: ifeq +570 -> 1384
    //   817: aload_1
    //   818: ldc_w 416
    //   821: invokevirtual 420	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   824: astore_2
    //   825: aload_0
    //   826: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmn	Lnmn;
    //   829: aload_2
    //   830: invokevirtual 423	nmn:a	(Lorg/json/JSONObject;)V
    //   833: aload_0
    //   834: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmn	Lnmn;
    //   837: getfield 425	nmn:b	Ljava/lang/String;
    //   840: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   843: ifne +25 -> 868
    //   846: aload_0
    //   847: aload_0
    //   848: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmn	Lnmn;
    //   851: getfield 425	nmn:b	Ljava/lang/String;
    //   854: putfield 131	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:p	Ljava/lang/String;
    //   857: aload_0
    //   858: aload_0
    //   859: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmn	Lnmn;
    //   862: getfield 425	nmn:b	Ljava/lang/String;
    //   865: putfield 192	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:D	Ljava/lang/String;
    //   868: aload_0
    //   869: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmn	Lnmn;
    //   872: aload_0
    //   873: getfield 184	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:A	Ljava/lang/String;
    //   876: putfield 427	nmn:f	Ljava/lang/String;
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
    //   917: new 435	nmo
    //   920: dup
    //   921: invokespecial 436	nmo:<init>	()V
    //   924: putfield 438	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmo	Lnmo;
    //   927: aload_0
    //   928: getfield 438	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmo	Lnmo;
    //   931: aload_1
    //   932: aload_0
    //   933: getfield 438	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmo	Lnmo;
    //   936: aload_0
    //   937: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmn	Lnmn;
    //   940: invokevirtual 441	nmo:a	(Lorg/json/JSONObject;Lnmo;Lnmn;)V
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
    //   1069: aload_0
    //   1070: aload_2
    //   1071: invokevirtual 433	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1074: putfield 228	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:U	Ljava/lang/String;
    //   1077: aload_0
    //   1078: new 462	nmw
    //   1081: dup
    //   1082: aload_0
    //   1083: getfield 228	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:U	Ljava/lang/String;
    //   1086: invokespecial 463	nmw:<init>	(Ljava/lang/String;)V
    //   1089: putfield 465	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmw	Lnmw;
    //   1092: aload_1
    //   1093: ldc_w 467
    //   1096: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1099: ifeq +14 -> 1113
    //   1102: aload_0
    //   1103: aload_1
    //   1104: ldc_w 467
    //   1107: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1110: putfield 224	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_l_of_type_Int	I
    //   1113: aload_1
    //   1114: ldc_w 469
    //   1117: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1120: ifeq +25 -> 1145
    //   1123: aload_0
    //   1124: aload_1
    //   1125: ldc_w 469
    //   1128: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1131: putfield 471	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_o_of_type_Int	I
    //   1134: aload_0
    //   1135: getfield 465	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmw	Lnmw;
    //   1138: aload_0
    //   1139: getfield 471	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_o_of_type_Int	I
    //   1142: putfield 472	nmw:h	I
    //   1145: aload_1
    //   1146: ldc_w 474
    //   1149: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1152: ifeq +328 -> 1480
    //   1155: aload_1
    //   1156: ldc_w 474
    //   1159: invokevirtual 352	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1162: astore_2
    //   1163: new 143	java/util/ArrayList
    //   1166: dup
    //   1167: invokespecial 144	java/util/ArrayList:<init>	()V
    //   1170: astore 8
    //   1172: aload_2
    //   1173: ifnull +307 -> 1480
    //   1176: new 143	java/util/ArrayList
    //   1179: dup
    //   1180: invokespecial 144	java/util/ArrayList:<init>	()V
    //   1183: pop
    //   1184: iconst_0
    //   1185: istore_3
    //   1186: iload_3
    //   1187: aload_2
    //   1188: invokevirtual 357	org/json/JSONArray:length	()I
    //   1191: if_icmpge +283 -> 1474
    //   1194: new 166	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo
    //   1197: dup
    //   1198: invokespecial 475	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:<init>	()V
    //   1201: astore 9
    //   1203: aload_2
    //   1204: iload_3
    //   1205: invokevirtual 479	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1208: astore 10
    //   1210: aload 9
    //   1212: aload 10
    //   1214: ldc_w 481
    //   1217: invokevirtual 484	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1220: i2l
    //   1221: putfield 486	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:jdField_a_of_type_Long	J
    //   1224: aload 9
    //   1226: aload 10
    //   1228: ldc_w 488
    //   1231: invokevirtual 491	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1234: putfield 493	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1237: aload 8
    //   1239: aload 9
    //   1241: invokevirtual 497	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1244: pop
    //   1245: iload_3
    //   1246: iconst_1
    //   1247: iadd
    //   1248: istore_3
    //   1249: goto -63 -> 1186
    //   1252: aload_0
    //   1253: getfield 121	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_c_of_type_Int	I
    //   1256: iconst_3
    //   1257: if_icmpne -863 -> 394
    //   1260: aload_0
    //   1261: new 143	java/util/ArrayList
    //   1264: dup
    //   1265: invokespecial 144	java/util/ArrayList:<init>	()V
    //   1268: putfield 146	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1271: aload_2
    //   1272: invokevirtual 357	org/json/JSONArray:length	()I
    //   1275: istore 5
    //   1277: iconst_0
    //   1278: istore_3
    //   1279: iload_3
    //   1280: iload 5
    //   1282: if_icmpge +27 -> 1309
    //   1285: aload_0
    //   1286: getfield 146	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1289: aload_2
    //   1290: iload_3
    //   1291: invokevirtual 359	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   1294: iconst_1
    //   1295: invokestatic 364	rac:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1298: invokevirtual 497	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1301: pop
    //   1302: iload_3
    //   1303: iconst_1
    //   1304: iadd
    //   1305: istore_3
    //   1306: goto -27 -> 1279
    //   1309: iload 5
    //   1311: iconst_3
    //   1312: if_icmpge -918 -> 394
    //   1315: iload 5
    //   1317: iconst_2
    //   1318: if_icmpne +23 -> 1341
    //   1321: aload_0
    //   1322: getfield 146	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1325: aload_2
    //   1326: iconst_0
    //   1327: invokevirtual 359	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   1330: iconst_1
    //   1331: invokestatic 364	rac:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1334: invokevirtual 497	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1337: pop
    //   1338: goto -944 -> 394
    //   1341: iload 5
    //   1343: iconst_1
    //   1344: if_icmpne -950 -> 394
    //   1347: aload_0
    //   1348: getfield 146	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1351: aload_2
    //   1352: iconst_0
    //   1353: invokevirtual 359	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   1356: iconst_1
    //   1357: invokestatic 364	rac:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1360: invokevirtual 497	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1363: pop
    //   1364: aload_0
    //   1365: getfield 146	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1368: aload_2
    //   1369: iconst_0
    //   1370: invokevirtual 359	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   1373: iconst_1
    //   1374: invokestatic 364	rac:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1377: invokevirtual 497	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1380: pop
    //   1381: goto -987 -> 394
    //   1384: aload_0
    //   1385: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmn	Lnmn;
    //   1388: aload_0
    //   1389: getfield 131	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:p	Ljava/lang/String;
    //   1392: putfield 425	nmn:b	Ljava/lang/String;
    //   1395: aload_0
    //   1396: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmn	Lnmn;
    //   1399: aload_0
    //   1400: getfield 184	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:A	Ljava/lang/String;
    //   1403: putfield 427	nmn:f	Ljava/lang/String;
    //   1406: aload_0
    //   1407: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmn	Lnmn;
    //   1410: aload_0
    //   1411: getfield 194	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:E	Ljava/lang/String;
    //   1414: putfield 499	nmn:e	Ljava/lang/String;
    //   1417: aload_0
    //   1418: getfield 414	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Nmn	Lnmn;
    //   1421: aload_0
    //   1422: getfield 196	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_c_of_type_Long	J
    //   1425: invokestatic 503	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1428: putfield 505	nmn:c	Ljava/lang/String;
    //   1431: goto -552 -> 879
    //   1434: astore_2
    //   1435: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1438: ifeq -361 -> 1077
    //   1441: ldc_w 507
    //   1444: iconst_2
    //   1445: new 263	java/lang/StringBuilder
    //   1448: dup
    //   1449: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1452: ldc_w 509
    //   1455: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: aload_2
    //   1459: invokevirtual 510	java/lang/Exception:toString	()Ljava/lang/String;
    //   1462: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1465: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1468: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1471: goto -394 -> 1077
    //   1474: aload_0
    //   1475: aload 8
    //   1477: putfield 164	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1480: aload_1
    //   1481: ldc_w 514
    //   1484: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1487: ifeq +23 -> 1510
    //   1490: aload_1
    //   1491: ldc_w 514
    //   1494: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1497: iconst_1
    //   1498: if_icmpne +298 -> 1796
    //   1501: iconst_1
    //   1502: istore 6
    //   1504: aload_0
    //   1505: iload 6
    //   1507: putfield 516	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_c_of_type_Boolean	Z
    //   1510: aload_1
    //   1511: ldc_w 518
    //   1514: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1517: ifeq +74 -> 1591
    //   1520: new 248	org/json/JSONObject
    //   1523: dup
    //   1524: aload_1
    //   1525: ldc_w 518
    //   1528: invokevirtual 292	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1531: invokespecial 458	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1534: astore_2
    //   1535: aload_2
    //   1536: ldc_w 520
    //   1539: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1542: ifeq +49 -> 1591
    //   1545: aload_2
    //   1546: ldc_w 520
    //   1549: invokevirtual 491	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1552: astore_2
    //   1553: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1556: ifeq +30 -> 1586
    //   1559: ldc_w 507
    //   1562: iconst_2
    //   1563: new 263	java/lang/StringBuilder
    //   1566: dup
    //   1567: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1570: ldc_w 522
    //   1573: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1576: aload_2
    //   1577: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1583: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1586: aload_0
    //   1587: aload_2
    //   1588: putfield 524	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:K	Ljava/lang/String;
    //   1591: aload_1
    //   1592: ldc_w 526
    //   1595: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1598: ifeq +66 -> 1664
    //   1601: aload_1
    //   1602: ldc_w 526
    //   1605: ldc 84
    //   1607: invokevirtual 432	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1610: astore_2
    //   1611: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1614: ifeq +30 -> 1644
    //   1617: ldc_w 507
    //   1620: iconst_2
    //   1621: new 263	java/lang/StringBuilder
    //   1624: dup
    //   1625: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1628: ldc_w 528
    //   1631: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1634: aload_2
    //   1635: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1641: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1644: aload_2
    //   1645: ldc_w 530
    //   1648: invokevirtual 533	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1651: ifne +191 -> 1842
    //   1654: iload 7
    //   1656: istore 6
    //   1658: aload_0
    //   1659: iload 6
    //   1661: putfield 88	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_d_of_type_Boolean	Z
    //   1664: aload_1
    //   1665: ldc_w 535
    //   1668: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1671: ifeq +14 -> 1685
    //   1674: aload_0
    //   1675: aload_1
    //   1676: ldc_w 535
    //   1679: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1682: putfield 214	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:h	I
    //   1685: aload_1
    //   1686: ldc_w 537
    //   1689: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1692: ifeq +202 -> 1894
    //   1695: aload_1
    //   1696: ldc_w 537
    //   1699: invokevirtual 352	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1702: astore_2
    //   1703: aload_2
    //   1704: ifnull +190 -> 1894
    //   1707: aload_2
    //   1708: invokevirtual 357	org/json/JSONArray:length	()I
    //   1711: ifle +183 -> 1894
    //   1714: aload_2
    //   1715: invokevirtual 357	org/json/JSONArray:length	()I
    //   1718: istore 5
    //   1720: new 143	java/util/ArrayList
    //   1723: dup
    //   1724: invokespecial 144	java/util/ArrayList:<init>	()V
    //   1727: astore 8
    //   1729: iconst_0
    //   1730: istore_3
    //   1731: iload_3
    //   1732: iload 5
    //   1734: if_icmpge +154 -> 1888
    //   1737: aload_2
    //   1738: iload_3
    //   1739: invokevirtual 540	org/json/JSONArray:opt	(I)Ljava/lang/Object;
    //   1742: checkcast 148	java/lang/String
    //   1745: astore 9
    //   1747: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1750: ifeq +31 -> 1781
    //   1753: ldc_w 542
    //   1756: iconst_2
    //   1757: new 263	java/lang/StringBuilder
    //   1760: dup
    //   1761: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1764: ldc_w 544
    //   1767: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1770: aload 9
    //   1772: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1778: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1781: aload 8
    //   1783: aload 9
    //   1785: invokevirtual 497	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1788: pop
    //   1789: iload_3
    //   1790: iconst_1
    //   1791: iadd
    //   1792: istore_3
    //   1793: goto -62 -> 1731
    //   1796: iconst_0
    //   1797: istore 6
    //   1799: goto -295 -> 1504
    //   1802: astore_2
    //   1803: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1806: ifeq -215 -> 1591
    //   1809: ldc_w 507
    //   1812: iconst_2
    //   1813: new 263	java/lang/StringBuilder
    //   1816: dup
    //   1817: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1820: ldc_w 266
    //   1823: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: aload_2
    //   1827: invokevirtual 510	java/lang/Exception:toString	()Ljava/lang/String;
    //   1830: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1833: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1836: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1839: goto -248 -> 1591
    //   1842: iconst_0
    //   1843: istore 6
    //   1845: goto -187 -> 1658
    //   1848: astore_2
    //   1849: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1852: ifeq -188 -> 1664
    //   1855: ldc_w 507
    //   1858: iconst_2
    //   1859: new 263	java/lang/StringBuilder
    //   1862: dup
    //   1863: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1866: ldc_w 266
    //   1869: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1872: aload_2
    //   1873: invokevirtual 510	java/lang/Exception:toString	()Ljava/lang/String;
    //   1876: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1879: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1882: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1885: goto -221 -> 1664
    //   1888: aload_0
    //   1889: aload 8
    //   1891: putfield 546	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1894: aload_1
    //   1895: ldc_w 548
    //   1898: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1901: ifeq +111 -> 2012
    //   1904: aload_1
    //   1905: ldc_w 548
    //   1908: invokevirtual 352	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1911: astore_2
    //   1912: aload_2
    //   1913: ifnull +99 -> 2012
    //   1916: aload_2
    //   1917: invokevirtual 357	org/json/JSONArray:length	()I
    //   1920: ifle +92 -> 2012
    //   1923: aload_2
    //   1924: invokevirtual 357	org/json/JSONArray:length	()I
    //   1927: istore 5
    //   1929: new 143	java/util/ArrayList
    //   1932: dup
    //   1933: invokespecial 144	java/util/ArrayList:<init>	()V
    //   1936: astore 8
    //   1938: iload 4
    //   1940: istore_3
    //   1941: iload_3
    //   1942: iload 5
    //   1944: if_icmpge +62 -> 2006
    //   1947: aload_2
    //   1948: iload_3
    //   1949: invokevirtual 540	org/json/JSONArray:opt	(I)Ljava/lang/Object;
    //   1952: checkcast 148	java/lang/String
    //   1955: astore 9
    //   1957: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1960: ifeq +31 -> 1991
    //   1963: ldc_w 542
    //   1966: iconst_2
    //   1967: new 263	java/lang/StringBuilder
    //   1970: dup
    //   1971: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1974: ldc_w 550
    //   1977: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: aload 9
    //   1982: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1985: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1988: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1991: aload 8
    //   1993: aload 9
    //   1995: invokevirtual 497	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1998: pop
    //   1999: iload_3
    //   2000: iconst_1
    //   2001: iadd
    //   2002: istore_3
    //   2003: goto -62 -> 1941
    //   2006: aload_0
    //   2007: aload 8
    //   2009: putfield 552	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_d_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2012: aload_1
    //   2013: ldc_w 554
    //   2016: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2019: ifeq +14 -> 2033
    //   2022: aload_0
    //   2023: aload_1
    //   2024: ldc_w 554
    //   2027: invokevirtual 286	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2030: putfield 226	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_m_of_type_Int	I
    //   2033: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2036: ifeq +59 -> 2095
    //   2039: ldc_w 542
    //   2042: iconst_2
    //   2043: new 263	java/lang/StringBuilder
    //   2046: dup
    //   2047: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   2050: ldc_w 556
    //   2053: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2056: aload_0
    //   2057: getfield 208	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:I	Ljava/lang/String;
    //   2060: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2063: ldc_w 558
    //   2066: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2069: aload_0
    //   2070: getfield 162	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:u	Ljava/lang/String;
    //   2073: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: ldc_w 560
    //   2079: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: aload_0
    //   2083: getfield 214	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:h	I
    //   2086: invokevirtual 563	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2089: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2092: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2095: return
    //   2096: astore_1
    //   2097: return
    //   2098: astore_2
    //   2099: goto -619 -> 1480
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2102	0	this	AdData
    //   0	2102	1	paramJSONObject	JSONObject
    //   0	2102	2	paramString	String
    //   1185	818	3	i1	int
    //   1	1938	4	i2	int
    //   1275	670	5	i3	int
    //   1502	342	6	bool1	boolean
    //   4	1651	7	bool2	boolean
    //   1170	838	8	localArrayList	ArrayList
    //   1201	793	9	localObject	Object
    //   1208	19	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   1045	1077	1434	java/lang/Exception
    //   1510	1586	1802	java/lang/Exception
    //   1586	1591	1802	java/lang/Exception
    //   1591	1644	1848	java/lang/Exception
    //   1644	1654	1848	java/lang/Exception
    //   1658	1664	1848	java/lang/Exception
    //   1664	1685	2096	java/lang/Exception
    //   1685	1703	2096	java/lang/Exception
    //   1707	1729	2096	java/lang/Exception
    //   1737	1781	2096	java/lang/Exception
    //   1781	1789	2096	java/lang/Exception
    //   1888	1894	2096	java/lang/Exception
    //   1894	1912	2096	java/lang/Exception
    //   1916	1938	2096	java/lang/Exception
    //   1947	1991	2096	java/lang/Exception
    //   1991	1999	2096	java/lang/Exception
    //   2006	2012	2096	java/lang/Exception
    //   2012	2033	2096	java/lang/Exception
    //   2033	2095	2096	java/lang/Exception
    //   1145	1172	2098	java/lang/Exception
    //   1176	1184	2098	java/lang/Exception
    //   1186	1245	2098	java/lang/Exception
    //   1474	1480	2098	java/lang/Exception
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