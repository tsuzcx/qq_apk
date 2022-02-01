package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdAppDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdData
  extends ProteusItemData
  implements Parcelable
{
  public static final Parcelable.Creator<AdData> CREATOR = new AdData.1();
  public String A;
  public String B;
  public String C;
  public String D = HardCodeUtil.a(2131699904);
  public String E;
  public String F;
  public String G;
  public String H;
  public String I;
  public String J;
  public String K;
  public String L;
  public String M = null;
  public String N;
  public String O;
  public String P;
  public String Q;
  public String R = "0";
  public String S;
  public String T;
  public double a;
  public int a;
  public long a;
  public AdvertisementInfo a;
  public AdAppDownloadInfo a;
  public AdGameComponentInfo a;
  public AdvertisementExtInfo a;
  public String a;
  public ArrayList<String> a;
  public JSONObject a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public ArrayList<DislikeInfo> b;
  public JSONObject b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public ArrayList<String> c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public ArrayList<String> d;
  public int e;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i = "";
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
  public String s;
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
    this.jdField_k_of_type_JavaLangString = "1";
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_j_of_type_Int = 0;
  }
  
  public AdData(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_k_of_type_JavaLangString = "1";
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.i = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_j_of_type_JavaLangString = paramParcel.readString();
      this.jdField_k_of_type_JavaLangString = paramParcel.readString();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_Double = paramParcel.readDouble();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      paramParcel.readList(this.jdField_a_of_type_JavaUtilArrayList, String.class.getClassLoader());
      this.jdField_l_of_type_JavaLangString = paramParcel.readString();
      this.jdField_m_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      paramParcel.readList(this.jdField_b_of_type_JavaUtilArrayList, DislikeInfo.class.getClassLoader());
      this.jdField_n_of_type_JavaLangString = paramParcel.readString();
      this.jdField_o_of_type_JavaLangString = paramParcel.readString();
      this.jdField_p_of_type_JavaLangString = paramParcel.readString();
      this.q = paramParcel.readString();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.r = paramParcel.readString();
      this.jdField_s_of_type_JavaLangString = paramParcel.readString();
      this.jdField_t_of_type_JavaLangString = paramParcel.readString();
      this.u = paramParcel.readString();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.v = paramParcel.readString();
      this.w = paramParcel.readString();
      this.jdField_b_of_type_Long = paramParcel.readLong();
      this.x = paramParcel.readString();
      this.y = paramParcel.readString();
      this.z = paramParcel.readString();
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.A = paramParcel.readString();
      this.jdField_d_of_type_Long = paramParcel.readLong();
      this.jdField_e_of_type_Long = paramParcel.readLong();
      this.jdField_g_of_type_Int = paramParcel.readInt();
      this.D = paramParcel.readString();
      this.E = paramParcel.readString();
      this.F = paramParcel.readString();
      this.G = paramParcel.readString();
      this.H = paramParcel.readString();
      this.jdField_k_of_type_Int = paramParcel.readInt();
      this.jdField_l_of_type_Int = paramParcel.readInt();
      this.M = paramParcel.readString();
      this.L = paramParcel.readString();
      this.O = paramParcel.readString();
      this.P = paramParcel.readString();
      this.Q = paramParcel.readString();
      this.S = paramParcel.readString();
      this.T = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public static boolean a(BaseData paramBaseData)
  {
    switch (paramBaseData.jdField_s_of_type_Int)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void c(JSONObject paramJSONObject)
  {
    this.jdField_h_of_type_Int = paramJSONObject.optInt("appDownLoadStyle");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo = new AdAppDownloadInfo();
    if (paramJSONObject.has("appDownloadInfo"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("appDownloadInfo");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.a(paramJSONObject);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_b_of_type_JavaLangString))
      {
        this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_b_of_type_JavaLangString;
        this.v = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_b_of_type_JavaLangString;
        this.i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_d_of_type_JavaLangString;
      }
      try
      {
        this.jdField_b_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_c_of_type_JavaLangString);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_e_of_type_JavaLangString)) {
          this.w = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_e_of_type_JavaLangString;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_f_of_type_JavaLangString = this.jdField_s_of_type_JavaLangString;
        return;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_b_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_f_of_type_JavaLangString = this.jdField_s_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_e_of_type_JavaLangString = this.w;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_b_of_type_Long);
  }
  
  private void d(JSONObject paramJSONObject)
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
          if (this.jdField_a_of_type_Int == 1)
          {
            this.jdField_d_of_type_JavaLangString = FastWebRequestUtil.a(localJSONArray.optString(0), true);
            return;
          }
        } while (this.jdField_a_of_type_Int != 3);
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        i2 = localJSONArray.length();
        int i1 = 0;
        while (i1 < i2)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(FastWebRequestUtil.a(localJSONArray.optString(i1), true));
          i1 += 1;
        }
      } while (i2 >= 3);
      if (i2 == 2)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(FastWebRequestUtil.a(localJSONArray.optString(0), true));
        return;
      }
    } while (i2 != 1);
    this.jdField_a_of_type_JavaUtilArrayList.add(FastWebRequestUtil.a(localJSONArray.optString(0), true));
    this.jdField_a_of_type_JavaUtilArrayList.add(FastWebRequestUtil.a(localJSONArray.optString(0), true));
  }
  
  private void e(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("bytes_extra_data"))
      {
        localObject = paramJSONObject.opt("bytes_extra_data");
        if ((localObject instanceof JSONObject)) {
          this.M = localObject.toString();
        }
      }
      if (TextUtils.isEmpty(this.M)) {
        this.M = new JSONObject().toString();
      }
      Object localObject = new JSONObject(this.M);
      ((JSONObject)localObject).put("ad_switchs", this.jdField_n_of_type_JavaLangString);
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
      if (paramJSONObject.has("ad_source")) {
        this.jdField_o_of_type_Int = paramJSONObject.optInt("ad_source");
      }
      ((JSONObject)localObject).put("AdSource", this.jdField_o_of_type_Int);
      ((JSONObject)localObject).put("jump_type", this.R);
      ((JSONObject)localObject).put("button_flag", paramJSONObject.optInt("button_flag", -1));
      this.M = ((JSONObject)localObject).toString();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdvertisementExtInfo = new AdvertisementExtInfo(this.M);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new JSONException("parseAdSwitchInfo JSONException.");
    }
  }
  
  private void f(JSONObject paramJSONObject)
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
  
  private void g(JSONObject paramJSONObject)
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
      this.C = paramJSONObject;
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new JSONException("parsePopSheetInfo JSONException.");
    }
  }
  
  private void h(JSONObject paramJSONObject)
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
      this.jdField_c_of_type_Boolean = bool;
      return;
    }
  }
  
  private void i(JSONObject paramJSONObject)
  {
    int i2 = 0;
    this.jdField_g_of_type_Int = paramJSONObject.optInt("c2s_switch");
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
    this.jdField_l_of_type_Int = paramJSONObject.optInt("phone_component_id");
    this.jdField_p_of_type_Int = paramJSONObject.optInt("experimental_ad_style");
    if (QLog.isColorLevel()) {
      QLog.d("fillCommonData_C2S", 2, " corporateImageName= " + this.A + " traceID = " + this.jdField_m_of_type_JavaLangString + " c2s_switch " + this.jdField_g_of_type_Int + " experimental_ad_style " + this.jdField_p_of_type_Int);
    }
  }
  
  public int a()
  {
    if ((this.jdField_t_of_type_Int == 2) && (!TextUtils.isEmpty(this.S)))
    {
      if ("1".equals(this.S)) {}
      do
      {
        return 65;
        if ("2".equals(this.S)) {
          return 184;
        }
      } while (!"3".equals(this.S));
      return 194;
    }
    switch (this.jdField_s_of_type_Int)
    {
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    default: 
      return 0;
    case 9: 
    case 11: 
      return 184;
    }
    return 185;
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.v)) {
      return this.v;
    }
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
      return this.jdField_h_of_type_JavaLangString;
    }
    if (a()) {
      try
      {
        String str = this.jdField_b_of_type_OrgJsonJSONObject.optJSONObject("extendInfo").optString("game_pkg_name");
        return str;
      }
      catch (Throwable localThrowable) {}
    }
    return null;
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
    this.jdField_n_of_type_JavaLangString = paramString;
    this.jdField_f_of_type_Int = paramJSONObject.optInt("autoplay");
    this.jdField_o_of_type_JavaLangString = paramJSONObject.optString("video");
    this.jdField_p_of_type_JavaLangString = paramJSONObject.optString("effect_url");
    this.q = paramJSONObject.optString("landing_page_report_url");
    this.jdField_a_of_type_Long = paramJSONObject.optLong("cl");
    this.r = paramJSONObject.optString("productid");
    this.jdField_s_of_type_JavaLangString = paramJSONObject.optString("mqq_via");
    this.jdField_t_of_type_JavaLangString = paramJSONObject.optString("trl");
    this.u = paramJSONObject.optString("canvas_json");
    this.jdField_e_of_type_Int = paramJSONObject.optInt("desttype");
    this.v = paramJSONObject.optString("pkg_name");
    this.w = paramJSONObject.optString("pkgurl");
    this.jdField_b_of_type_Long = paramJSONObject.optLong("appid");
    this.x = paramJSONObject.optString("pkg_download_schema");
    this.y = paramJSONObject.optString("invoke_url");
    this.z = paramJSONObject.optString("subordinate_product_id");
    this.jdField_c_of_type_Long = paramJSONObject.optLong("noco_id");
    this.A = paramJSONObject.optString("corporate_image_name");
    if (paramJSONObject.has("inner_ad")) {
      this.S = paramJSONObject.optJSONObject("inner_ad").optString("style");
    }
    this.jdField_d_of_type_Long = paramJSONObject.optLong("algo_id");
    this.jdField_e_of_type_Long = paramJSONObject.optLong("algo_group");
    this.jdField_a_of_type_Boolean = paramJSONObject.has("native");
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_j_of_type_JavaLangString = paramJSONObject.optString("native");
    }
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("posid");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("title");
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("content");
    this.jdField_a_of_type_Int = paramJSONObject.optInt("img_type");
    d(paramJSONObject);
    this.jdField_e_of_type_JavaLangString = FastWebRequestUtil.a(paramJSONObject.optString("click_url"), true);
    this.jdField_f_of_type_JavaLangString = FastWebRequestUtil.a(paramJSONObject.optString("jump_url"), true);
    this.jdField_g_of_type_JavaLangString = FastWebRequestUtil.a(paramJSONObject.optString("expose_url"), true);
    this.jdField_b_of_type_Int = paramJSONObject.optInt("producttype");
    this.jdField_h_of_type_JavaLangString = paramJSONObject.optString("pkg_name");
    this.i = paramJSONObject.optString("app_name");
    this.jdField_k_of_type_JavaLangString = paramJSONObject.optString("openudid");
    this.jdField_c_of_type_Int = paramJSONObject.optInt("ad_id");
    this.jdField_a_of_type_Double = paramJSONObject.optDouble("ecpm");
    this.jdField_d_of_type_Int = paramJSONObject.optInt("isContract");
    this.jdField_m_of_type_JavaLangString = paramJSONObject.optString("traceid");
    this.jdField_l_of_type_JavaLangString = paramJSONObject.optString("viewid");
    this.jdField_c_of_type_Int = paramJSONObject.optInt("advertiser_id");
    this.B = paramJSONObject.optString("corporate_logo");
    this.D = paramJSONObject.optString("AdsIconText");
    this.G = paramJSONObject.optString("tags");
    this.E = paramJSONObject.optString("article_id");
    this.F = paramJSONObject.optString("rowkey");
    this.H = paramJSONObject.optString("cash_tag");
    this.jdField_n_of_type_Int = paramJSONObject.optInt("ad_jump_mode", 0);
    this.jdField_m_of_type_Int = paramJSONObject.optInt("show_inner_floating_bar");
    this.jdField_k_of_type_Int = paramJSONObject.optInt("mini_program_type");
    if (paramJSONObject.optInt("has_ams_popsheet") == 1) {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    this.R = paramJSONObject.optString("jump_type");
    c(paramJSONObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo = new AdGameComponentInfo();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo.a(paramJSONObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGameComponentInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdAppDownloadInfo);
    this.L = paramJSONObject.optString("ext", "");
    if (TextUtils.isEmpty(this.L)) {
      this.L = new JSONObject().toString();
    }
    this.J = paramJSONObject.optString("__ADSTR__");
    this.K = paramJSONObject.optString("adtag");
    try
    {
      e(paramJSONObject);
      f(paramJSONObject);
      g(paramJSONObject);
      h(paramJSONObject);
      i(paramJSONObject);
      this.O = paramJSONObject.optString("liujin_report_url");
      this.P = paramJSONObject.optString("ticket");
      if (TextUtils.isEmpty(this.P)) {
        this.P = paramJSONObject.optString("ad_encrypted_ticket");
      }
      this.Q = paramJSONObject.optString("ams_nfb_url");
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
  
  public boolean a()
  {
    return (this.jdField_b_of_type_OrgJsonJSONObject != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_OrgJsonJSONObject.optString("sAdID")));
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
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeString(this.i);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeDouble(this.jdField_a_of_type_Double);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
      paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
      paramParcel.writeList(this.jdField_b_of_type_JavaUtilArrayList);
      paramParcel.writeString(this.jdField_n_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_o_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_p_of_type_JavaLangString);
      paramParcel.writeString(this.q);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeString(this.r);
      paramParcel.writeString(this.jdField_s_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_t_of_type_JavaLangString);
      paramParcel.writeString(this.u);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeString(this.v);
      paramParcel.writeString(this.w);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeString(this.x);
      paramParcel.writeString(this.y);
      paramParcel.writeString(this.z);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeString(this.A);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      paramParcel.writeString(this.D);
      paramParcel.writeString(this.E);
      paramParcel.writeString(this.F);
      paramParcel.writeString(this.G);
      paramParcel.writeString(this.H);
      paramParcel.writeInt(this.jdField_k_of_type_Int);
      paramParcel.writeInt(this.jdField_l_of_type_Int);
      paramParcel.writeString(this.M);
      paramParcel.writeString(this.L);
      paramParcel.writeString(this.O);
      paramParcel.writeString(this.P);
      paramParcel.writeString(this.Q);
      paramParcel.writeString(this.S);
      paramParcel.writeString(this.T);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData
 * JD-Core Version:    0.7.0.1
 */