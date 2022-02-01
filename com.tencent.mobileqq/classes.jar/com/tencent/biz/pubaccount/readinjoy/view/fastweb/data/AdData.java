package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import anni;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import omh;
import omi;
import omq;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sxv;
import tbf;

public class AdData
  extends ProteusItemData
  implements Parcelable
{
  public static final Parcelable.Creator<AdData> CREATOR = new sxv();
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
  public String L = anni.a(2131698633);
  public String M;
  public String N;
  public String O;
  public String P;
  public String Q;
  public String R;
  public String S;
  public String T;
  public String U;
  public String V;
  public AdvertisementInfo a;
  public ArrayList<String> a;
  public omh a;
  public omi a;
  public omq a;
  public JSONObject a;
  public long b;
  public ArrayList<DislikeInfo> b;
  public JSONObject b;
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
  public boolean e;
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
  public int p;
  public String p;
  public int q;
  public String q;
  public int r;
  public String r;
  public int s;
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
    this.jdField_q_of_type_JavaLangString = "";
    this.jdField_e_of_type_Boolean = true;
    this.jdField_k_of_type_Int = 0;
  }
  
  public AdData(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_q_of_type_JavaLangString = "";
    this.jdField_e_of_type_Boolean = true;
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
    this.jdField_p_of_type_JavaLangString = paramParcel.readString();
    this.jdField_q_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
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
  
  private void a(JSONObject paramJSONObject)
  {
    this.jdField_i_of_type_Int = paramJSONObject.optInt("appDownLoadStyle");
    this.jdField_a_of_type_Omh = new omh();
    if (paramJSONObject.has("appDownloadInfo"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("appDownloadInfo");
      this.jdField_a_of_type_Omh.a(paramJSONObject);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Omh.b))
      {
        this.jdField_p_of_type_JavaLangString = this.jdField_a_of_type_Omh.b;
        this.D = this.jdField_a_of_type_Omh.b;
      }
      this.jdField_a_of_type_Omh.f = this.A;
      return;
    }
    this.jdField_a_of_type_Omh.b = this.jdField_p_of_type_JavaLangString;
    this.jdField_a_of_type_Omh.f = this.A;
    this.jdField_a_of_type_Omh.e = this.E;
    this.jdField_a_of_type_Omh.c = String.valueOf(this.jdField_c_of_type_Long);
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    switch (paramBaseData.t)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void b(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("img_url");
    if ((!paramJSONObject.has("img_url")) || (localJSONArray.length() < 0)) {}
    int i2;
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_c_of_type_Int == 1)
          {
            this.jdField_l_of_type_JavaLangString = tbf.a(localJSONArray.optString(0), true);
            return;
          }
        } while (this.jdField_c_of_type_Int != 3);
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        i2 = localJSONArray.length();
        int i1 = 0;
        while (i1 < i2)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(tbf.a(localJSONArray.optString(i1), true));
          i1 += 1;
        }
      } while (i2 >= 3);
      if (i2 == 2)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(tbf.a(localJSONArray.optString(0), true));
        return;
      }
    } while (i2 != 1);
    this.jdField_a_of_type_JavaUtilArrayList.add(tbf.a(localJSONArray.optString(0), true));
    this.jdField_a_of_type_JavaUtilArrayList.add(tbf.a(localJSONArray.optString(0), true));
  }
  
  private void c(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("bytes_extra_data"))
      {
        localObject = paramJSONObject.opt("bytes_extra_data");
        if ((localObject instanceof JSONObject)) {
          this.U = localObject.toString();
        }
      }
      if (TextUtils.isEmpty(this.U)) {
        this.U = new JSONObject().toString();
      }
      Object localObject = new JSONObject(this.U);
      ((JSONObject)localObject).put("ad_switchs", this.v);
      if (paramJSONObject.has("wechat_app_username")) {
        ((JSONObject)localObject).put("wechat_app_username", paramJSONObject.optString("wechat_app_username"));
      }
      if (paramJSONObject.has("wxappid")) {
        ((JSONObject)localObject).put("wxappid", paramJSONObject.optString("wxappid"));
      }
      if (paramJSONObject.has("wechat_app_path")) {
        ((JSONObject)localObject).put("wechat_app_path", paramJSONObject.optString("wechat_app_path"));
      }
      if (paramJSONObject.has("wechat_app_token")) {
        ((JSONObject)localObject).put("wechat_app_token", paramJSONObject.optString("wechat_app_token"));
      }
      if (paramJSONObject.has("wechat_ad_trace_data")) {
        ((JSONObject)localObject).put("wechat_ad_trace_data", paramJSONObject.optString("wechat_ad_trace_data"));
      }
      this.U = ((JSONObject)localObject).toString();
      this.jdField_a_of_type_Omq = new omq(this.U);
      if (paramJSONObject.has("ad_source"))
      {
        this.jdField_p_of_type_Int = paramJSONObject.optInt("ad_source");
        this.jdField_a_of_type_Omq.j = this.jdField_p_of_type_Int;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new JSONException("parseAdSwitchInfo JSONException.");
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("negative")) {}
    for (;;)
    {
      return;
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("negative");
        ArrayList localArrayList = new ArrayList();
        if (paramJSONObject == null) {
          continue;
        }
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          DislikeInfo localDislikeInfo = new DislikeInfo();
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i1);
          localDislikeInfo.jdField_a_of_type_Long = localJSONObject.optInt("id");
          localDislikeInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("reason");
          localArrayList.add(localDislikeInfo);
          i1 += 1;
        }
        this.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        return;
      }
      catch (JSONException paramJSONObject)
      {
        throw new JSONException("parseNegativeInfo JSONException.");
      }
    }
  }
  
  private void e(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("pop_sheet")) {
      return;
    }
    try
    {
      paramJSONObject = new JSONObject(paramJSONObject.optString("pop_sheet")).optString("h5Url");
      if (QLog.isColorLevel()) {
        QLog.d("fillCommonData", 2, "h5Url = " + paramJSONObject);
      }
      this.K = paramJSONObject;
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new JSONException("parsePopSheetInfo JSONException.");
    }
  }
  
  private void f(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("button_flag")) {
      return;
    }
    paramJSONObject = paramJSONObject.optString("button_flag", "1");
    if (QLog.isColorLevel()) {
      QLog.d("fillCommonData", 2, "buttonFlag = " + paramJSONObject);
    }
    if (!paramJSONObject.equals("0")) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_e_of_type_Boolean = bool;
      return;
    }
  }
  
  private void g(JSONObject paramJSONObject)
  {
    int i2 = 0;
    this.h = paramJSONObject.optInt("c2s_switch");
    JSONArray localJSONArray;
    int i3;
    ArrayList localArrayList;
    int i1;
    String str;
    if (paramJSONObject.has("c2s_click_url"))
    {
      localJSONArray = paramJSONObject.optJSONArray("c2s_click_url");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i3 = localJSONArray.length();
        localArrayList = new ArrayList();
        i1 = 0;
        while (i1 < i3)
        {
          str = (String)localJSONArray.opt(i1);
          if (QLog.isColorLevel()) {
            QLog.d("fillCommonData_C2S", 2, " fillCommonData_C2S clickUrl = " + str);
          }
          localArrayList.add(str);
          i1 += 1;
        }
        this.jdField_c_of_type_JavaUtilArrayList = localArrayList;
      }
    }
    if (paramJSONObject.has("c2s_exposure_url"))
    {
      localJSONArray = paramJSONObject.optJSONArray("c2s_exposure_url");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i3 = localJSONArray.length();
        localArrayList = new ArrayList();
        i1 = i2;
        while (i1 < i3)
        {
          str = (String)localJSONArray.opt(i1);
          if (QLog.isColorLevel()) {
            QLog.d("fillCommonData_C2S", 2, " fillCommonData_C2S exposureUrl = " + str);
          }
          localArrayList.add(str);
          i1 += 1;
        }
        this.jdField_d_of_type_JavaUtilArrayList = localArrayList;
      }
    }
    this.jdField_m_of_type_Int = paramJSONObject.optInt("phone_component_id");
    this.jdField_q_of_type_Int = paramJSONObject.optInt("experimental_ad_style");
    if (QLog.isColorLevel()) {
      QLog.d("fillCommonData_C2S", 2, " corporateImageName= " + this.I + " traceID = " + this.u + " c2s_switch " + this.h + " experimental_ad_style " + this.jdField_q_of_type_Int);
    }
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
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = false;
    if (paramJSONObject == null) {
      return;
    }
    this.v = paramString;
    this.g = paramJSONObject.optInt("autoplay");
    this.w = paramJSONObject.optString("video");
    this.x = paramJSONObject.optString("effect_url");
    this.y = paramJSONObject.optString("landing_page_report_url");
    this.jdField_b_of_type_Long = paramJSONObject.optLong("cl");
    this.z = paramJSONObject.optString("productid");
    this.A = paramJSONObject.optString("mqq_via");
    this.B = paramJSONObject.optString("trl");
    this.C = paramJSONObject.optString("canvas_json");
    this.jdField_f_of_type_Int = paramJSONObject.optInt("desttype");
    this.D = paramJSONObject.optString("pkg_name");
    this.E = paramJSONObject.optString("pkgurl");
    this.jdField_c_of_type_Long = paramJSONObject.optLong("appid");
    this.F = paramJSONObject.optString("pkg_download_schema");
    this.G = paramJSONObject.optString("invoke_url");
    this.H = paramJSONObject.optString("subordinate_product_id");
    this.jdField_d_of_type_Long = paramJSONObject.optLong("noco_id");
    this.I = paramJSONObject.optString("corporate_image_name");
    this.jdField_e_of_type_Long = paramJSONObject.optLong("algo_id");
    this.jdField_f_of_type_Long = paramJSONObject.optLong("algo_group");
    this.jdField_c_of_type_Boolean = paramJSONObject.has("native");
    if (this.jdField_c_of_type_Boolean) {
      this.r = paramJSONObject.optString("native");
    }
    this.jdField_i_of_type_JavaLangString = paramJSONObject.optString("posid");
    this.j = paramJSONObject.optString("title");
    this.jdField_k_of_type_JavaLangString = paramJSONObject.optString("content");
    this.jdField_c_of_type_Int = paramJSONObject.optInt("img_type");
    b(paramJSONObject);
    this.jdField_m_of_type_JavaLangString = tbf.a(paramJSONObject.optString("click_url"), true);
    this.jdField_n_of_type_JavaLangString = tbf.a(paramJSONObject.optString("jump_url"), true);
    this.jdField_o_of_type_JavaLangString = tbf.a(paramJSONObject.optString("expose_url"), true);
    this.jdField_d_of_type_Int = paramJSONObject.optInt("producttype");
    this.jdField_p_of_type_JavaLangString = paramJSONObject.optString("pkg_name");
    this.jdField_q_of_type_JavaLangString = paramJSONObject.optString("app_name");
    this.s = paramJSONObject.optString("openudid");
    this.jdField_e_of_type_Int = paramJSONObject.optInt("ad_id");
    this.u = paramJSONObject.optString("traceid");
    this.t = paramJSONObject.optString("viewid");
    this.jdField_e_of_type_Int = paramJSONObject.optInt("advertiser_id");
    this.J = paramJSONObject.optString("corporate_logo");
    this.L = paramJSONObject.optString("AdsIconText");
    this.O = paramJSONObject.optString("tags");
    this.M = paramJSONObject.optString("article_id");
    this.N = paramJSONObject.optString("rowkey");
    this.P = paramJSONObject.optString("cash_tag");
    this.jdField_o_of_type_Int = paramJSONObject.optInt("ad_jump_mode", 0);
    this.jdField_n_of_type_Int = paramJSONObject.optInt("show_inner_floating_bar");
    this.jdField_l_of_type_Int = paramJSONObject.optInt("mini_program_type");
    if (paramJSONObject.optInt("has_ams_popsheet") == 1) {
      bool = true;
    }
    this.jdField_d_of_type_Boolean = bool;
    a(paramJSONObject);
    this.jdField_a_of_type_Omi = new omi();
    this.jdField_a_of_type_Omi.a(paramJSONObject, this.jdField_a_of_type_Omi, this.jdField_a_of_type_Omh);
    this.T = paramJSONObject.optString("ext", "");
    if (TextUtils.isEmpty(this.T)) {
      this.T = new JSONObject().toString();
    }
    this.R = paramJSONObject.optString("__ADSTR__");
    this.S = paramJSONObject.optString("adtag");
    try
    {
      c(paramJSONObject);
      d(paramJSONObject);
      e(paramJSONObject);
      f(paramJSONObject);
      g(paramJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("fillCommonData", 1, paramString.toString());
      }
    }
  }
  
  public boolean a(JSONObject paramJSONObject, int paramInt)
  {
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean h()
  {
    return (this.jdField_b_of_type_OrgJsonJSONObject != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_OrgJsonJSONObject.optString("sAdID")));
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
    paramParcel.writeString(this.jdField_p_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_q_of_type_JavaLangString);
    if (this.jdField_c_of_type_Boolean) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData
 * JD-Core Version:    0.7.0.1
 */