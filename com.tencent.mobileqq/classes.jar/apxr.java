import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class apxr
{
  public String A = "";
  public String B = "";
  public String C = "";
  public String D = "";
  public String E = "";
  public String F = "";
  public String G = "";
  public String H = "";
  public String I = "";
  public String J = "";
  public String K = "";
  public String L = "";
  public String M = "";
  public String N = "";
  public String O = "";
  public String P = "";
  public String Q = "";
  public String R = "";
  public String S = "";
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  public String v = "";
  public String w = "";
  public String x = "";
  public String y = "";
  public String z = "";
  
  public apxr()
  {
    this.jdField_a_of_type_JavaLangString = "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083";
    this.jdField_b_of_type_JavaLangString = "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 80;
    this.jdField_b_of_type_Int = 100;
    this.jdField_c_of_type_Int = 80;
  }
  
  public static apxr a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      apxr localapxr = new apxr();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("isUpgradeOpen", 0) == 1) {}
      for (;;)
      {
        localapxr.jdField_a_of_type_Boolean = bool;
        localapxr.jdField_a_of_type_JavaLangString = paramString.optString("managePageURL", "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083");
        if (TextUtils.isEmpty(localapxr.jdField_a_of_type_JavaLangString)) {
          localapxr.jdField_a_of_type_JavaLangString = "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083";
        }
        localapxr.jdField_b_of_type_JavaLangString = paramString.optString("bindPageURL", "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083");
        if (TextUtils.isEmpty(localapxr.jdField_b_of_type_JavaLangString)) {
          localapxr.jdField_b_of_type_JavaLangString = "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083";
        }
        Object localObject;
        JSONArray localJSONArray;
        if (paramString.has("bgImg"))
        {
          localObject = paramString.optJSONObject("bgImg");
          if ((localObject != null) && (((JSONObject)localObject).has("relationNo")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationNo");
            if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
              localapxr.jdField_c_of_type_JavaLangString = localJSONArray.getString(0);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localapxr.d = localJSONArray.getString(0);
              localapxr.e = localJSONArray.getString(1);
              localapxr.f = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationBestFriend")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationBestFriend");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localapxr.g = localJSONArray.getString(0);
              localapxr.h = localJSONArray.getString(1);
              localapxr.i = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localapxr.j = localJSONArray.getString(0);
              localapxr.k = localJSONArray.getString(1);
              localapxr.l = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
          {
            localObject = ((JSONObject)localObject).optJSONArray("relationLover");
            if ((localObject != null) && (((JSONArray)localObject).length() > 2))
            {
              localapxr.m = ((JSONArray)localObject).getString(0);
              localapxr.n = ((JSONArray)localObject).getString(1);
              localapxr.o = ((JSONArray)localObject).getString(2);
            }
          }
        }
        if (paramString.has("darkBgImg"))
        {
          localObject = paramString.optJSONObject("darkBgImg");
          if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localapxr.p = localJSONArray.getString(0);
              localapxr.q = localJSONArray.getString(1);
              localapxr.r = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationBestFriend")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationBestFriend");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localapxr.s = localJSONArray.getString(0);
              localapxr.t = localJSONArray.getString(1);
              localapxr.u = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localapxr.v = localJSONArray.getString(0);
              localapxr.w = localJSONArray.getString(1);
              localapxr.x = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
          {
            localObject = ((JSONObject)localObject).optJSONArray("relationLover");
            if ((localObject != null) && (((JSONArray)localObject).length() > 2))
            {
              localapxr.y = ((JSONArray)localObject).getString(0);
              localapxr.z = ((JSONArray)localObject).getString(1);
              localapxr.A = ((JSONArray)localObject).getString(2);
            }
          }
        }
        if (paramString.has("shareImg"))
        {
          localObject = paramString.optJSONObject("shareImg");
          if ((localObject != null) && (((JSONObject)localObject).has("relationNo")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationNo");
            if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
              localapxr.B = localJSONArray.getString(0);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localapxr.C = localJSONArray.getString(0);
              localapxr.D = localJSONArray.getString(1);
              localapxr.E = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationBestFriend")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationBestFriend");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localapxr.F = localJSONArray.getString(0);
              localapxr.G = localJSONArray.getString(1);
              localapxr.H = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localapxr.I = localJSONArray.getString(0);
              localapxr.J = localJSONArray.getString(1);
              localapxr.K = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
          {
            localObject = ((JSONObject)localObject).optJSONArray("relationLover");
            if ((localObject != null) && (((JSONArray)localObject).length() > 2))
            {
              localapxr.L = ((JSONArray)localObject).getString(0);
              localapxr.M = ((JSONArray)localObject).getString(1);
              localapxr.N = ((JSONArray)localObject).getString(2);
            }
          }
        }
        if (paramString.has("scoreAnimation")) {
          localapxr.Q = paramString.optString("scoreAnimation");
        }
        if (paramString.has("scoreAnimationMd5")) {
          localapxr.R = paramString.optString("scoreAnimationMd5");
        }
        if (paramString.has("scoreRuleURL")) {
          localapxr.S = paramString.optString("scoreRuleURL");
        }
        if (paramString.has("scoreDisplayIntimateMin")) {
          localapxr.jdField_a_of_type_Int = paramString.optInt("scoreDisplayIntimateMin");
        }
        if (paramString.has("scoreDisplayFriendMin")) {
          localapxr.jdField_b_of_type_Int = paramString.optInt("scoreDisplayFriendMin");
        }
        if (paramString.has("scoreDisplayFriendMin818")) {
          localapxr.jdField_c_of_type_Int = paramString.optInt("scoreDisplayFriendMin818");
        }
        localapxr.O = paramString.optString("gifNormalUrl");
        localapxr.P = paramString.optString("gifNightUrl");
        return localapxr;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FriendIntimateRelationshipBean isUpgradeOpen:").append(this.jdField_a_of_type_Boolean).append(" managePageURL:").append(this.jdField_a_of_type_JavaLangString).append(" bindPageURL:").append(this.jdField_b_of_type_JavaLangString).append(" relationNoBgUrl:").append(this.jdField_c_of_type_JavaLangString).append(" relationGuimiBg0Url:").append(this.d).append(" relationGuimiBg1Url:").append(this.e).append(" relationGuimiBg2Url:").append(this.f).append(" relationSidangBg0Url:").append(this.g).append(" relationSidangBg1Url:").append(this.h).append(" relationSidangBg2Url:").append(this.i).append(" relationJiyouBg0Url:").append(this.j).append(" relationJiyouBg1Url:").append(this.k).append(" relationJiyouBg2Url:").append(this.l).append(" relationLoverBg0Url:").append(this.m).append(" relationLoverBg1Url:").append(this.n).append(" relationLoverBg2Url:").append(this.o).append(" relationGuimiDarkBg0Url:").append(this.p).append(" relationGuimiDarkBg1Url:").append(this.q).append(" relationGuimiDarkBg2Url:").append(this.r).append(" relationSidangDarkBg0Url:").append(this.s).append(" relationSidangDarkBg1Url:").append(this.t).append(" relationSidangDarkBg2Url:").append(this.u).append(" relationJiyouDarkBg0Url:").append(this.v).append(" relationJiyouDarkBg1Url:").append(this.w).append(" relationJiyouDarkBg2Url:").append(this.x).append(" relationLoverDarkBg0Url:").append(this.y).append(" relationLoverDarkBg1Url:").append(this.z).append(" relationLoverDarkBg2Url:").append(this.A).append(" relationNoShareUrl:").append(this.B).append(" relationGuimiShare0Url:").append(this.C).append(" relationGuimiShare1Url:").append(this.D).append(" relationGuimiShare2Url:").append(this.E).append(" relationSidangShare0Url:").append(this.F).append(" relationSidangShare1Url:").append(this.G).append(" relationSidangShare2Url:").append(this.H).append(" relationJiyouShare0Url:").append(this.I).append(" relationJiyouShare1Url:").append(this.J).append(" relationJiyouShare2Url:").append(this.K).append(" relationLoverShare0Url:").append(this.L).append(" relationLoverShare1Url:").append(this.M).append(" relationLoverShare2Url:").append(this.N).append(" gifNormalUrl:").append(this.O).append(" gifNightUrl:").append(this.P);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apxr
 * JD-Core Version:    0.7.0.1
 */