package com.tencent.avgame.gameroom.stage.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
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
    if (((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("#")) && (paramString1.length() % 2 != 1)) || ((!TextUtils.isEmpty(paramString1)) && (!paramString1.contains("#")) && (paramString1.length() % 2 != 0))) {}
    do
    {
      return paramString2;
      if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("#"))) {
        return paramString1;
      }
    } while (TextUtils.isEmpty(paramString1));
    return "#" + paramString1;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontStyleConfig", 2, "json parse " + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = a(paramString.optString("topicTitleColor", this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Int = a(paramString.optInt("topicTitleColor", this.jdField_a_of_type_Int), this.jdField_a_of_type_Int);
      this.jdField_b_of_type_JavaLangString = a(paramString.optString("countNumColor", this.jdField_b_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_Int = a(paramString.optInt("countNumSize", this.jdField_b_of_type_Int), this.jdField_b_of_type_Int);
      this.jdField_c_of_type_JavaLangString = a(paramString.optString("topicContentColor", this.jdField_c_of_type_JavaLangString), this.jdField_c_of_type_JavaLangString);
      this.jdField_c_of_type_Int = a(paramString.optInt("topicContentSize", this.jdField_c_of_type_Int), this.jdField_c_of_type_Int);
      this.jdField_d_of_type_JavaLangString = a(paramString.optString("chooseTopicTipColor", this.jdField_d_of_type_JavaLangString), this.jdField_d_of_type_JavaLangString);
      this.jdField_d_of_type_Int = a(paramString.optInt("chooseTopicTipSize", this.jdField_d_of_type_Int), this.jdField_d_of_type_Int);
      this.jdField_e_of_type_JavaLangString = a(paramString.optString("audioTopicTipColor", this.jdField_e_of_type_JavaLangString), this.jdField_e_of_type_JavaLangString);
      this.jdField_f_of_type_JavaLangString = a(paramString.optString("audioTopicTipContentColor", this.jdField_f_of_type_JavaLangString), this.jdField_f_of_type_JavaLangString);
      this.jdField_g_of_type_JavaLangString = a(paramString.optString("chooseOnColor", this.jdField_g_of_type_JavaLangString), this.jdField_g_of_type_JavaLangString);
      this.jdField_e_of_type_Int = a(paramString.optInt("chooseOnSize", this.jdField_e_of_type_Int), this.jdField_e_of_type_Int);
      this.jdField_h_of_type_JavaLangString = a(paramString.optString("chooseOffColor", this.jdField_h_of_type_JavaLangString), this.jdField_h_of_type_JavaLangString);
      this.jdField_f_of_type_Int = a(paramString.optInt("chooseOffSize", this.jdField_f_of_type_Int), this.jdField_f_of_type_Int);
      this.i = a(paramString.optString("readyTipColor", this.i), this.i);
      this.j = a(paramString.optString("conveneTipColor", this.j), this.j);
      this.k = b(paramString.optString("conveneBg", this.k), this.k);
      this.l = b(paramString.optString("pkWinBgUrl", this.l), this.l);
      this.m = b(paramString.optString("pkWinTopUrl", this.m), this.m);
      this.n = b(paramString.optString("pkLoseBgUrl", this.n), this.n);
      this.o = b(paramString.optString("pkLoseTopUrl", this.o), this.o);
      this.p = a(paramString.optString("succScoreBgColor", this.p), this.p);
      this.q = a(paramString.optString("succScoreTextColor", this.q), this.q);
      this.r = a(paramString.optString("succScoreAvaterTipTextColor", this.r), this.r);
      this.s = a(paramString.optString("promotionMyselfTextColor", this.s), this.s);
      this.t = a(paramString.optString("promotionFriendTextColor", this.t), this.t);
      this.u = a(paramString.optString("clickSuccColor", this.u), this.u);
      this.jdField_g_of_type_Int = a(paramString.optInt("clickSuccSize", this.jdField_g_of_type_Int), this.jdField_g_of_type_Int);
      this.v = a(paramString.optString("clickFailColor", this.v), this.v);
      this.jdField_h_of_type_Int = a(paramString.optInt("clickFailSize", this.jdField_h_of_type_Int), this.jdField_h_of_type_Int);
      this.w = a(paramString.optString("clickHeadSuccColor", this.w), this.w);
      this.x = a(paramString.optString("clickHeadFailColor", this.x), this.x);
      this.y = a(paramString.optString("clickHeadAnsweringColor", this.y), this.y);
      this.z = a(paramString.optString("pkRoundWinTitleColor", this.z), this.z);
      this.A = a(paramString.optString("pkRoundFailTitleColor", this.A), this.A);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FontStyleConfig", 2, "json parse err-->" + paramString.toString());
    }
  }
  
  public String b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  @NonNull
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("mTopicTitleColor:" + this.jdField_a_of_type_JavaLangString + "|");
    localStringBuffer.append("mTopicTitleSize:" + this.jdField_a_of_type_Int + "|");
    localStringBuffer.append("mCountNumColor:" + this.jdField_b_of_type_JavaLangString + "|");
    localStringBuffer.append("mCountNumSize:" + this.jdField_b_of_type_Int + "|");
    localStringBuffer.append("mTopicContentColor:" + this.jdField_c_of_type_JavaLangString + "|");
    localStringBuffer.append("mTopicContentSize:" + this.jdField_c_of_type_Int + "|");
    localStringBuffer.append("mChooseTopicTipColor:" + this.jdField_d_of_type_JavaLangString + "|");
    localStringBuffer.append("mChooseTopicTipSize:" + this.jdField_d_of_type_Int + "|");
    localStringBuffer.append("mAudioTopicTipColor:" + this.jdField_e_of_type_JavaLangString + "|");
    localStringBuffer.append("mAudioTopicTipContentColor:" + this.jdField_f_of_type_JavaLangString + "|");
    localStringBuffer.append("mChooseOnColor:" + this.jdField_g_of_type_JavaLangString + "|");
    localStringBuffer.append("mChooseOnSize:" + this.jdField_e_of_type_Int + "|");
    localStringBuffer.append("mChooseOffColor:" + this.jdField_h_of_type_JavaLangString + "|");
    localStringBuffer.append("mChooseOffSize:" + this.jdField_f_of_type_Int + "|");
    localStringBuffer.append("mReadyTipColor:" + this.i + "|");
    localStringBuffer.append("mConveneTipColor:" + this.j + "|");
    localStringBuffer.append("mConveneBg:" + this.k + "|");
    localStringBuffer.append("mPkWinBgUrl:" + this.l + "|");
    localStringBuffer.append("mPkWinTopUrl:" + this.m + "|");
    localStringBuffer.append("mPkLoseBgUrl:" + this.n + "|");
    localStringBuffer.append("mPkLoseTopUrl:" + this.o + "|");
    localStringBuffer.append("mSuccScoreBgColor:" + this.p + "|");
    localStringBuffer.append("mSuccScoreTextColor:" + this.q + "|");
    localStringBuffer.append("mSuccScoreAvaterTipTextColor:" + this.r + "|");
    localStringBuffer.append("mPromotionSuccTextColor:" + this.s + "|");
    localStringBuffer.append("mPromotionFailTextColor:" + this.t + "|");
    localStringBuffer.append("mClickSuccColor:" + this.u + "|");
    localStringBuffer.append("mClickSuccSize:" + this.jdField_g_of_type_Int + "|");
    localStringBuffer.append("mClickFailColor:" + this.v + "|");
    localStringBuffer.append("mClickFailSize:" + this.jdField_h_of_type_Int + "|");
    localStringBuffer.append("mClickHeadSuccColor:" + this.w + "|");
    localStringBuffer.append("mClickHeadFailColor:" + this.x + "|");
    localStringBuffer.append("mClickHeadAnsweringColor:" + this.y + "|");
    localStringBuffer.append("mPkRoundWinTitleColor:" + this.z + "|");
    localStringBuffer.append("mPkRoundFailTitleColor:" + this.A + "|");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.util.FontStyleConfig
 * JD-Core Version:    0.7.0.1
 */