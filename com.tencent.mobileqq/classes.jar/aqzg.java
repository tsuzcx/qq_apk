import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqzg
  implements aqwv<String>
{
  public int a;
  public long a;
  public String a;
  public ArrayList<aqzn> a;
  public int b;
  public String b;
  public ArrayList<String> b;
  public int c;
  public String c;
  public ArrayList<aqzk> c;
  public int d;
  public ArrayList<aqzj> d;
  public int e;
  public ArrayList<String> e;
  public int f;
  public ArrayList<String> f;
  public int g;
  public ArrayList<aqzi> g;
  public int h;
  public int i;
  public int j;
  
  public aqzg()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_g_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AiKeywordConfig", 1, "onParse,fileOrRes is null");
      return;
    }
    int k;
    Object localObject2;
    Object localObject3;
    try
    {
      paramString = new JSONObject(paramString);
      localObject1 = paramString.optJSONArray("ark_server_keyword_configs");
      if (localObject1 != null)
      {
        k = 0;
        if (k >= ((JSONArray)localObject1).length()) {
          break label304;
        }
        localObject2 = ((JSONArray)localObject1).optJSONObject(k);
        if (localObject2 == null) {
          break label1802;
        }
        localObject3 = new aqzn();
        ((aqzn)localObject3).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("context", "");
        ((aqzn)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("type", "");
        ((aqzn)localObject3).jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((JSONObject)localObject2).optBoolean("enable", false));
        ((aqzn)localObject3).jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).optString("regex", "");
        ((aqzn)localObject3).d = ((JSONObject)localObject2).optString("tips", "");
        ArkAppCenter.c("AiKeywordConfig", String.format("onParse, ark_server_keyword_configs, name=%s, type=%s, enable=%s, pattern=%s, tip=%s", new Object[] { ((aqzn)localObject3).jdField_a_of_type_JavaLangString, ((aqzn)localObject3).jdField_b_of_type_JavaLangString, Boolean.toString(((aqzn)localObject3).jdField_a_of_type_JavaLangBoolean.booleanValue()), ((aqzn)localObject3).jdField_c_of_type_JavaLangString, ((aqzn)localObject3).d }));
        if ((TextUtils.isEmpty(((aqzn)localObject3).jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(((aqzn)localObject3).jdField_b_of_type_JavaLangString)) || (!((aqzn)localObject3).jdField_a_of_type_JavaLangBoolean.booleanValue()) || (TextUtils.isEmpty(((aqzn)localObject3).jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(((aqzn)localObject3).d))) {
          break label1802;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
      }
    }
    catch (JSONException paramString)
    {
      ArkAppCenter.c("AiKeywordConfig", String.format("onParse AiKeywordConfig onParse, parse json failed, err=%s", new Object[] { paramString.getMessage() }));
      return;
    }
    ArkAppCenter.c("AiKeywordConfig", "onParse, ark_server_keyword_configs is empty");
    label304:
    this.jdField_a_of_type_JavaLangString = paramString.optString("ark_ai_match_graytips_visibility");
    Object localObject1 = paramString.optJSONArray("ark_navi_msg_appnames");
    if (localObject1 != null)
    {
      k = 0;
      label329:
      if (k < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optString(k);
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (this.jdField_b_of_type_JavaUtilArrayList.contains(localObject2))) {
          break label1809;
        }
        QLog.d("AiKeywordConfig", 1, new Object[] { "onParse ark_navi_msg_appnames appName = ", localObject2 });
        this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
        break label1809;
      }
    }
    localObject1 = paramString.optJSONArray("ark_module_api_frequency");
    label414:
    Object localObject4;
    if (localObject1 != null)
    {
      k = 0;
      if (k < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(k);
        if (localObject2 == null) {
          break label1816;
        }
        localObject3 = ((JSONObject)localObject2).optString("module");
        localObject4 = ((JSONObject)localObject2).optString("api");
        long l1 = ((JSONObject)localObject2).optLong("times", -1L);
        long l2 = ((JSONObject)localObject2).optLong("period", -1L);
        QLog.d("AiKeywordConfig", 1, new Object[] { "onParse ark_module_api_frequency module = ", localObject3, "api = ", localObject4, "times = ", Long.valueOf(l1), "period = ", Long.valueOf(l2) });
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject4)) || (l1 == -1L) || (l2 == -1L)) {
          break label1816;
        }
        localObject2 = new aqzk((String)localObject3, (String)localObject4, l1, l2);
        this.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
        break label1816;
      }
    }
    QLog.d("AiKeywordConfig", 1, new Object[] { "onParse,mArkModuleApiFrequencyList list size =", Integer.valueOf(this.jdField_c_of_type_JavaUtilArrayList.size()) });
    localObject1 = paramString.optJSONArray("ark_jsdebugger_download");
    int m;
    if (localObject1 != null)
    {
      m = ((JSONArray)localObject1).length();
      k = 0;
      label650:
      if (k < m)
      {
        localObject4 = ((JSONArray)localObject1).optJSONObject(k);
        if (localObject4 == null) {
          break label1823;
        }
        localObject2 = ((JSONObject)localObject4).optString("jscmd5");
        localObject3 = ((JSONObject)localObject4).optString("url");
        localObject4 = ((JSONObject)localObject4).optString("md5");
        QLog.d("AiKeywordConfig", 1, new Object[] { "onParse jscomd5 = ", localObject2, "ur = ", localObject3, "md5 = ", localObject4 });
        if ((localObject2 == null) || (TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
          break label1823;
        }
        this.jdField_d_of_type_JavaUtilArrayList.add(new aqzj((String)localObject2, (String)localObject3, (String)localObject4));
        break label1823;
      }
    }
    QLog.e("AiKeywordConfig", 1, new Object[] { "mArkJsdebuggerDownloadList list size =", Integer.valueOf(this.jdField_d_of_type_JavaUtilArrayList.size()) });
    this.jdField_a_of_type_Int = paramString.optInt("singlecontext_singleapp_card_limit", 5);
    this.jdField_b_of_type_Int = paramString.optInt("ark_app_limit", 3);
    this.jdField_c_of_type_Int = paramString.optInt("ark_each_app_card_limit", 1);
    this.jdField_d_of_type_Int = paramString.optInt("ark_input_apps_limit", 3);
    this.jdField_e_of_type_Int = paramString.optInt("ark_input_each_context_apps_limit", 3);
    this.jdField_f_of_type_Int = paramString.optInt("ark_babyq_card_limit_total", 10);
    this.jdField_g_of_type_Int = paramString.optInt("ark_babyq_card_limit_per_app", 1);
    this.h = paramString.optInt("ark_babyq_guide_count_limit_per_day", 1);
    this.i = paramString.optInt("ark_babyq_guide_day_limit_total", 3);
    this.jdField_b_of_type_JavaLangString = paramString.optString("ark_babyq_guide_hint_text");
    this.jdField_a_of_type_Long = paramString.optLong("ark_babyq_bubble_disappear_duration", 10000L);
    localObject1 = paramString.optJSONArray("ark_babyq_input_hint_text_list");
    if (localObject1 != null)
    {
      m = ((JSONArray)localObject1).length();
      k = 0;
      label964:
      if (k < m)
      {
        localObject2 = ((JSONArray)localObject1).optString(k);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1830;
        }
        QLog.d("AiKeywordConfig", 1, new Object[] { "onParse ark_babyq_input_hint_text_list itemStr = ", localObject2 });
        this.jdField_e_of_type_JavaUtilArrayList.add(localObject2);
        break label1830;
      }
    }
    QLog.d("AiKeywordConfig", 1, new Object[] { "onParse mArkBabyqInputHintTextList list size =", Integer.valueOf(this.jdField_e_of_type_JavaUtilArrayList.size()) });
    this.jdField_c_of_type_JavaLangString = paramString.optString("ark_babyq_no_result_recommend_title");
    localObject1 = paramString.optJSONArray("ark_babyq_no_result_recommend_items");
    if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
    {
      k = 0;
      label1083:
      if (k < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optString(k);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1837;
        }
        QLog.d("AiKeywordConfig", 1, new Object[] { "onParse ark_babyq_no_result_recommend_items itemStr = ", localObject2 });
        this.jdField_f_of_type_JavaUtilArrayList.add(localObject2);
        break label1837;
      }
    }
    QLog.d("AiKeywordConfig", 1, new Object[] { "onParse mArkBabyqNoResultRecommendItems list size =", Integer.valueOf(this.jdField_f_of_type_JavaUtilArrayList.size()) });
    this.j = paramString.optInt("ark_babyq_gray_tip_total_limit", 1);
    paramString = paramString.optJSONArray("ark_babyq_gray_tip_configs");
    if ((paramString != null) && (paramString.length() > 0)) {
      k = 0;
    }
    for (;;)
    {
      int n;
      int i1;
      if (k < paramString.length())
      {
        localObject1 = paramString.optJSONObject(k);
        if (localObject1 == null) {
          break label1851;
        }
        n = ((JSONObject)localObject1).optInt("type");
        i1 = ((JSONObject)localObject1).optInt("limit");
        QLog.d("AiKeywordConfig", 1, new Object[] { "onParse tipType =", Integer.valueOf(n), "itemLimit = ", Integer.valueOf(i1) });
        if (n == 4)
        {
          localObject1 = ((JSONObject)localObject1).optJSONArray("tips_array");
          if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
            break label1851;
          }
          localObject2 = new ArrayList();
          m = 0;
        }
      }
      for (;;)
      {
        if (m < ((JSONArray)localObject1).length())
        {
          Object localObject5 = ((JSONArray)localObject1).optJSONObject(m);
          if (localObject5 != null)
          {
            localObject3 = ((JSONObject)localObject5).optString("prefix");
            localObject4 = ((JSONObject)localObject5).optString("keyword");
            String str = ((JSONObject)localObject5).optString("postfix");
            localObject5 = ((JSONObject)localObject5).optString("app");
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
            {
              QLog.d("AiKeywordConfig", 1, new Object[] { "onParse prefix =", localObject3, "keyword = ", localObject4, "postfix = ", str, "appName = ", localObject5 });
              ((ArrayList)localObject2).add(new aqzs((String)localObject3, (String)localObject4, str, (String)localObject5));
            }
          }
        }
        else
        {
          this.jdField_g_of_type_JavaUtilArrayList.add(new aqzi(n, i1, null, (ArrayList)localObject2));
          break label1851;
          if (n <= 0) {
            break label1851;
          }
          localObject1 = ((JSONObject)localObject1).optString("tip");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1851;
          }
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse tipText =", localObject1 });
          this.jdField_g_of_type_JavaUtilArrayList.add(new aqzi(n, i1, (String)localObject1, null));
          break label1851;
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse mArkBabyqGrayTipConfigs list size =", Integer.valueOf(this.jdField_g_of_type_JavaUtilArrayList.size()) });
          QLog.i("AiKeywordConfig", 1, "onParse ark_ai_match_graytips_visibility=" + this.jdField_a_of_type_JavaLangString + ", singlecontext_singleapp_card_limit=" + this.jdField_a_of_type_Int + ", ark_app_limit=" + this.jdField_b_of_type_Int + ", ark_each_app_card_limit=" + this.jdField_c_of_type_Int + ", ark_input_apps_limit=" + this.jdField_d_of_type_Int + ", ark_input_each_context_apps_limit=" + this.jdField_e_of_type_Int + ", ark_babyq_card_limit_total=" + this.jdField_f_of_type_Int + ", ark_babyq_card_limit_total=" + this.jdField_g_of_type_Int + ", ark_babyq_guide_count_limit_per_day=" + this.h + ", ark_babyq_guide_hint_text=" + this.jdField_b_of_type_JavaLangString + ", ark_babyq_bubble_disappear_duration=" + this.jdField_a_of_type_Long + ", ark_babyq_no_result_recommend_title=" + this.jdField_c_of_type_JavaLangString + ", ark_babyq_gray_tip_total_limit=" + this.j);
          return;
          label1802:
          k += 1;
          break;
          label1809:
          k += 1;
          break label329;
          label1816:
          k += 1;
          break label414;
          label1823:
          k += 1;
          break label650;
          label1830:
          k += 1;
          break label964;
          label1837:
          k += 1;
          break label1083;
        }
        m += 1;
      }
      label1851:
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzg
 * JD-Core Version:    0.7.0.1
 */