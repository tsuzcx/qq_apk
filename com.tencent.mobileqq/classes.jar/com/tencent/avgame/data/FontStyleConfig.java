package com.tencent.avgame.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class FontStyleConfig
{
  public String A = "#FFFFFF";
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public String i = "#FFFFFF";
  public String j = "#FFFFFF";
  public String k = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_cj_bg.png";
  public String l = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_win_bg.png";
  public String m = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_suc2.png";
  public String n = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_fail_bg.png";
  public String o = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_fail.png";
  public String p = "#FFFFFF";
  public String q = "#FFFFFF";
  public String r = "#FFFFFF";
  public String s = "#FFFFFF";
  public String t = "#FFFFFF";
  public String u = "#FFFFFF";
  public String v = "#FFFFFF";
  public String w = "#00CF85";
  public String x = "#B0B3BF";
  public String y = "#FFFFFF";
  public String z = "#FFFFFF";
  
  public FontStyleConfig()
  {
    this.jdField_a_of_type_JavaLangString = "#E9CF9E";
    this.jdField_a_of_type_Int = 17;
    this.jdField_b_of_type_JavaLangString = "#E9CF9E";
    this.jdField_b_of_type_Int = 14;
    this.jdField_c_of_type_JavaLangString = "#FFFFFF";
    this.jdField_c_of_type_Int = 22;
    this.jdField_d_of_type_JavaLangString = "#FFFFFF";
    this.jdField_d_of_type_Int = 14;
    this.jdField_e_of_type_JavaLangString = "#FFFFFF";
    this.jdField_f_of_type_JavaLangString = "#000000";
    this.jdField_g_of_type_JavaLangString = "#E9CF9E";
    this.jdField_e_of_type_Int = 14;
    this.jdField_h_of_type_JavaLangString = "#4E8969";
    this.jdField_f_of_type_Int = 14;
    this.jdField_g_of_type_Int = 14;
    this.jdField_h_of_type_Int = 14;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("#")) && (paramString1.length() % 2 != 1)) || ((!TextUtils.isEmpty(paramString1)) && (!paramString1.contains("#")) && (paramString1.length() % 2 != 0))) {
      return paramString2;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("#"))) {
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    paramString2 = new StringBuilder();
    paramString2.append("#");
    paramString2.append(paramString1);
    return paramString2.toString();
  }
  
  public void a(String paramString)
  {
    try
    {
      localObject = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = a(((JSONObject)localObject).optString("topicTitleColor", this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Int = a(((JSONObject)localObject).optInt("topicTitleColor", this.jdField_a_of_type_Int), this.jdField_a_of_type_Int);
      this.jdField_b_of_type_JavaLangString = a(((JSONObject)localObject).optString("countNumColor", this.jdField_b_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_Int = a(((JSONObject)localObject).optInt("countNumSize", this.jdField_b_of_type_Int), this.jdField_b_of_type_Int);
      this.jdField_c_of_type_JavaLangString = a(((JSONObject)localObject).optString("topicContentColor", this.jdField_c_of_type_JavaLangString), this.jdField_c_of_type_JavaLangString);
      this.jdField_c_of_type_Int = a(((JSONObject)localObject).optInt("topicContentSize", this.jdField_c_of_type_Int), this.jdField_c_of_type_Int);
      this.jdField_d_of_type_JavaLangString = a(((JSONObject)localObject).optString("chooseTopicTipColor", this.jdField_d_of_type_JavaLangString), this.jdField_d_of_type_JavaLangString);
      this.jdField_d_of_type_Int = a(((JSONObject)localObject).optInt("chooseTopicTipSize", this.jdField_d_of_type_Int), this.jdField_d_of_type_Int);
      this.jdField_e_of_type_JavaLangString = a(((JSONObject)localObject).optString("audioTopicTipColor", this.jdField_e_of_type_JavaLangString), this.jdField_e_of_type_JavaLangString);
      this.jdField_f_of_type_JavaLangString = a(((JSONObject)localObject).optString("audioTopicTipContentColor", this.jdField_f_of_type_JavaLangString), this.jdField_f_of_type_JavaLangString);
      this.jdField_g_of_type_JavaLangString = a(((JSONObject)localObject).optString("chooseOnColor", this.jdField_g_of_type_JavaLangString), this.jdField_g_of_type_JavaLangString);
      this.jdField_e_of_type_Int = a(((JSONObject)localObject).optInt("chooseOnSize", this.jdField_e_of_type_Int), this.jdField_e_of_type_Int);
      this.jdField_h_of_type_JavaLangString = a(((JSONObject)localObject).optString("chooseOffColor", this.jdField_h_of_type_JavaLangString), this.jdField_h_of_type_JavaLangString);
      this.jdField_f_of_type_Int = a(((JSONObject)localObject).optInt("chooseOffSize", this.jdField_f_of_type_Int), this.jdField_f_of_type_Int);
      this.i = a(((JSONObject)localObject).optString("readyTipColor", this.i), this.i);
      this.j = a(((JSONObject)localObject).optString("conveneTipColor", this.j), this.j);
      this.k = b(((JSONObject)localObject).optString("conveneBg", this.k), this.k);
      this.l = b(((JSONObject)localObject).optString("pkWinBgUrl", this.l), this.l);
      this.m = b(((JSONObject)localObject).optString("pkWinTopUrl", this.m), this.m);
      this.n = b(((JSONObject)localObject).optString("pkLoseBgUrl", this.n), this.n);
      this.o = b(((JSONObject)localObject).optString("pkLoseTopUrl", this.o), this.o);
      this.p = a(((JSONObject)localObject).optString("succScoreBgColor", this.p), this.p);
      this.q = a(((JSONObject)localObject).optString("succScoreTextColor", this.q), this.q);
      this.r = a(((JSONObject)localObject).optString("succScoreAvaterTipTextColor", this.r), this.r);
      this.s = a(((JSONObject)localObject).optString("promotionMyselfTextColor", this.s), this.s);
      this.t = a(((JSONObject)localObject).optString("promotionFriendTextColor", this.t), this.t);
      this.u = a(((JSONObject)localObject).optString("clickSuccColor", this.u), this.u);
      this.jdField_g_of_type_Int = a(((JSONObject)localObject).optInt("clickSuccSize", this.jdField_g_of_type_Int), this.jdField_g_of_type_Int);
      this.v = a(((JSONObject)localObject).optString("clickFailColor", this.v), this.v);
      this.jdField_h_of_type_Int = a(((JSONObject)localObject).optInt("clickFailSize", this.jdField_h_of_type_Int), this.jdField_h_of_type_Int);
      this.w = a(((JSONObject)localObject).optString("clickHeadSuccColor", this.w), this.w);
      this.x = a(((JSONObject)localObject).optString("clickHeadFailColor", this.x), this.x);
      this.y = a(((JSONObject)localObject).optString("clickHeadAnsweringColor", this.y), this.y);
      this.z = a(((JSONObject)localObject).optString("pkRoundWinTitleColor", this.z), this.z);
      this.A = a(((JSONObject)localObject).optString("pkRoundFailTitleColor", this.A), this.A);
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      label780:
      break label780;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FontStyleConfig JSONObject parse fail -->");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("FontStyleConfig", 2, ((StringBuilder)localObject).toString());
  }
  
  public String b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTopicTitleColor:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTopicTitleSize:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mCountNumColor:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mCountNumSize:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTopicContentColor:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTopicContentSize:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChooseTopicTipColor:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChooseTopicTipSize:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mAudioTopicTipColor:");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mAudioTopicTipContentColor:");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChooseOnColor:");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChooseOnSize:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChooseOffColor:");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChooseOffSize:");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mReadyTipColor:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mConveneTipColor:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mConveneBg:");
    localStringBuilder.append(this.k);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPkWinBgUrl:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPkWinTopUrl:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPkLoseBgUrl:");
    localStringBuilder.append(this.n);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPkLoseTopUrl:");
    localStringBuilder.append(this.o);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSuccScoreBgColor:");
    localStringBuilder.append(this.p);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSuccScoreTextColor:");
    localStringBuilder.append(this.q);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSuccScoreAvaterTipTextColor:");
    localStringBuilder.append(this.r);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPromotionSuccTextColor:");
    localStringBuilder.append(this.s);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPromotionFailTextColor:");
    localStringBuilder.append(this.t);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickSuccColor:");
    localStringBuilder.append(this.u);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickSuccSize:");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickFailColor:");
    localStringBuilder.append(this.v);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickFailSize:");
    localStringBuilder.append(this.jdField_h_of_type_Int);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickHeadSuccColor:");
    localStringBuilder.append(this.w);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickHeadFailColor:");
    localStringBuilder.append(this.x);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickHeadAnsweringColor:");
    localStringBuilder.append(this.y);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPkRoundWinTitleColor:");
    localStringBuilder.append(this.z);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPkRoundFailTitleColor:");
    localStringBuilder.append(this.A);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.data.FontStyleConfig
 * JD-Core Version:    0.7.0.1
 */