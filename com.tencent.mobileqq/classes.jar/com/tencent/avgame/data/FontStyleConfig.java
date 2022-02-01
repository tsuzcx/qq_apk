package com.tencent.avgame.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class FontStyleConfig
{
  public String A = "#FFFFFF";
  public int B = 14;
  public String C = "#FFFFFF";
  public int D = 14;
  public String E = "#00CF85";
  public String F = "#B0B3BF";
  public String G = "#FFFFFF";
  public String H = "#FFFFFF";
  public String I = "#FFFFFF";
  public String a = "#E9CF9E";
  public int b = 17;
  public String c = "#E9CF9E";
  public int d = 14;
  public String e = "#FFFFFF";
  public int f = 22;
  public String g = "#FFFFFF";
  public int h = 14;
  public String i = "#FFFFFF";
  public String j = "#000000";
  public String k = "#E9CF9E";
  public int l = 14;
  public String m = "#4E8969";
  public int n = 14;
  public String o = "#FFFFFF";
  public String p = "#FFFFFF";
  public String q = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_cj_bg.png";
  public String r = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_win_bg.png";
  public String s = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_suc2.png";
  public String t = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_fail_bg.png";
  public String u = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_fail.png";
  public String v = "#FFFFFF";
  public String w = "#FFFFFF";
  public String x = "#FFFFFF";
  public String y = "#FFFFFF";
  public String z = "#FFFFFF";
  
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
      this.a = a(((JSONObject)localObject).optString("topicTitleColor", this.a), this.a);
      this.b = a(((JSONObject)localObject).optInt("topicTitleColor", this.b), this.b);
      this.c = a(((JSONObject)localObject).optString("countNumColor", this.c), this.c);
      this.d = a(((JSONObject)localObject).optInt("countNumSize", this.d), this.d);
      this.e = a(((JSONObject)localObject).optString("topicContentColor", this.e), this.e);
      this.f = a(((JSONObject)localObject).optInt("topicContentSize", this.f), this.f);
      this.g = a(((JSONObject)localObject).optString("chooseTopicTipColor", this.g), this.g);
      this.h = a(((JSONObject)localObject).optInt("chooseTopicTipSize", this.h), this.h);
      this.i = a(((JSONObject)localObject).optString("audioTopicTipColor", this.i), this.i);
      this.j = a(((JSONObject)localObject).optString("audioTopicTipContentColor", this.j), this.j);
      this.k = a(((JSONObject)localObject).optString("chooseOnColor", this.k), this.k);
      this.l = a(((JSONObject)localObject).optInt("chooseOnSize", this.l), this.l);
      this.m = a(((JSONObject)localObject).optString("chooseOffColor", this.m), this.m);
      this.n = a(((JSONObject)localObject).optInt("chooseOffSize", this.n), this.n);
      this.o = a(((JSONObject)localObject).optString("readyTipColor", this.o), this.o);
      this.p = a(((JSONObject)localObject).optString("conveneTipColor", this.p), this.p);
      this.q = b(((JSONObject)localObject).optString("conveneBg", this.q), this.q);
      this.r = b(((JSONObject)localObject).optString("pkWinBgUrl", this.r), this.r);
      this.s = b(((JSONObject)localObject).optString("pkWinTopUrl", this.s), this.s);
      this.t = b(((JSONObject)localObject).optString("pkLoseBgUrl", this.t), this.t);
      this.u = b(((JSONObject)localObject).optString("pkLoseTopUrl", this.u), this.u);
      this.v = a(((JSONObject)localObject).optString("succScoreBgColor", this.v), this.v);
      this.w = a(((JSONObject)localObject).optString("succScoreTextColor", this.w), this.w);
      this.x = a(((JSONObject)localObject).optString("succScoreAvaterTipTextColor", this.x), this.x);
      this.y = a(((JSONObject)localObject).optString("promotionMyselfTextColor", this.y), this.y);
      this.z = a(((JSONObject)localObject).optString("promotionFriendTextColor", this.z), this.z);
      this.A = a(((JSONObject)localObject).optString("clickSuccColor", this.A), this.A);
      this.B = a(((JSONObject)localObject).optInt("clickSuccSize", this.B), this.B);
      this.C = a(((JSONObject)localObject).optString("clickFailColor", this.C), this.C);
      this.D = a(((JSONObject)localObject).optInt("clickFailSize", this.D), this.D);
      this.E = a(((JSONObject)localObject).optString("clickHeadSuccColor", this.E), this.E);
      this.F = a(((JSONObject)localObject).optString("clickHeadFailColor", this.F), this.F);
      this.G = a(((JSONObject)localObject).optString("clickHeadAnsweringColor", this.G), this.G);
      this.H = a(((JSONObject)localObject).optString("pkRoundWinTitleColor", this.H), this.H);
      this.I = a(((JSONObject)localObject).optString("pkRoundFailTitleColor", this.I), this.I);
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
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTopicTitleSize:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mCountNumColor:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mCountNumSize:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTopicContentColor:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTopicContentSize:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChooseTopicTipColor:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChooseTopicTipSize:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mAudioTopicTipColor:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mAudioTopicTipContentColor:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChooseOnColor:");
    localStringBuilder.append(this.k);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChooseOnSize:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChooseOffColor:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChooseOffSize:");
    localStringBuilder.append(this.n);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mReadyTipColor:");
    localStringBuilder.append(this.o);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mConveneTipColor:");
    localStringBuilder.append(this.p);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mConveneBg:");
    localStringBuilder.append(this.q);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPkWinBgUrl:");
    localStringBuilder.append(this.r);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPkWinTopUrl:");
    localStringBuilder.append(this.s);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPkLoseBgUrl:");
    localStringBuilder.append(this.t);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPkLoseTopUrl:");
    localStringBuilder.append(this.u);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSuccScoreBgColor:");
    localStringBuilder.append(this.v);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSuccScoreTextColor:");
    localStringBuilder.append(this.w);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSuccScoreAvaterTipTextColor:");
    localStringBuilder.append(this.x);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPromotionSuccTextColor:");
    localStringBuilder.append(this.y);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPromotionFailTextColor:");
    localStringBuilder.append(this.z);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickSuccColor:");
    localStringBuilder.append(this.A);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickSuccSize:");
    localStringBuilder.append(this.B);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickFailColor:");
    localStringBuilder.append(this.C);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickFailSize:");
    localStringBuilder.append(this.D);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickHeadSuccColor:");
    localStringBuilder.append(this.E);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickHeadFailColor:");
    localStringBuilder.append(this.F);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mClickHeadAnsweringColor:");
    localStringBuilder.append(this.G);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPkRoundWinTitleColor:");
    localStringBuilder.append(this.H);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPkRoundFailTitleColor:");
    localStringBuilder.append(this.I);
    localStringBuilder.append("|");
    localStringBuffer.append(localStringBuilder.toString());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.data.FontStyleConfig
 * JD-Core Version:    0.7.0.1
 */