import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class amsi
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
  
  public amsi()
  {
    this.jdField_a_of_type_JavaLangString = "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083";
    this.jdField_b_of_type_JavaLangString = "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 80;
    this.jdField_b_of_type_Int = 100;
    this.jdField_c_of_type_Int = 80;
  }
  
  public static amsi a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      amsi localamsi = new amsi();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("isUpgradeOpen", 0) == 1) {}
      for (;;)
      {
        localamsi.jdField_a_of_type_Boolean = bool;
        localamsi.jdField_a_of_type_JavaLangString = paramString.optString("managePageURL", "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083");
        if (TextUtils.isEmpty(localamsi.jdField_a_of_type_JavaLangString)) {
          localamsi.jdField_a_of_type_JavaLangString = "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083";
        }
        localamsi.jdField_b_of_type_JavaLangString = paramString.optString("bindPageURL", "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083");
        if (TextUtils.isEmpty(localamsi.jdField_b_of_type_JavaLangString)) {
          localamsi.jdField_b_of_type_JavaLangString = "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083";
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
              localamsi.jdField_c_of_type_JavaLangString = localJSONArray.getString(0);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localamsi.d = localJSONArray.getString(0);
              localamsi.e = localJSONArray.getString(1);
              localamsi.f = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localamsi.g = localJSONArray.getString(0);
              localamsi.h = localJSONArray.getString(1);
              localamsi.i = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
          {
            localObject = ((JSONObject)localObject).optJSONArray("relationLover");
            if ((localObject != null) && (((JSONArray)localObject).length() > 2))
            {
              localamsi.j = ((JSONArray)localObject).getString(0);
              localamsi.k = ((JSONArray)localObject).getString(1);
              localamsi.l = ((JSONArray)localObject).getString(2);
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
              localamsi.m = localJSONArray.getString(0);
              localamsi.n = localJSONArray.getString(1);
              localamsi.o = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localamsi.p = localJSONArray.getString(0);
              localamsi.q = localJSONArray.getString(1);
              localamsi.r = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
          {
            localObject = ((JSONObject)localObject).optJSONArray("relationLover");
            if ((localObject != null) && (((JSONArray)localObject).length() > 2))
            {
              localamsi.s = ((JSONArray)localObject).getString(0);
              localamsi.t = ((JSONArray)localObject).getString(1);
              localamsi.u = ((JSONArray)localObject).getString(2);
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
              localamsi.v = localJSONArray.getString(0);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localamsi.w = localJSONArray.getString(0);
              localamsi.x = localJSONArray.getString(1);
              localamsi.y = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localamsi.z = localJSONArray.getString(0);
              localamsi.A = localJSONArray.getString(1);
              localamsi.B = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
          {
            localObject = ((JSONObject)localObject).optJSONArray("relationLover");
            if ((localObject != null) && (((JSONArray)localObject).length() > 2))
            {
              localamsi.C = ((JSONArray)localObject).getString(0);
              localamsi.D = ((JSONArray)localObject).getString(1);
              localamsi.E = ((JSONArray)localObject).getString(2);
            }
          }
        }
        if (paramString.has("scoreAnimation")) {
          localamsi.H = paramString.optString("scoreAnimation");
        }
        if (paramString.has("scoreAnimationMd5")) {
          localamsi.I = paramString.optString("scoreAnimationMd5");
        }
        if (paramString.has("scoreRuleURL")) {
          localamsi.J = paramString.optString("scoreRuleURL");
        }
        if (paramString.has("scoreDisplayIntimateMin")) {
          localamsi.jdField_a_of_type_Int = paramString.optInt("scoreDisplayIntimateMin");
        }
        if (paramString.has("scoreDisplayFriendMin")) {
          localamsi.jdField_b_of_type_Int = paramString.optInt("scoreDisplayFriendMin");
        }
        if (paramString.has("scoreDisplayFriendMin818")) {
          localamsi.jdField_c_of_type_Int = paramString.optInt("scoreDisplayFriendMin818");
        }
        localamsi.F = paramString.optString("gifNormalUrl");
        localamsi.G = paramString.optString("gifNightUrl");
        return localamsi;
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
    localStringBuilder.append("FriendIntimateRelationshipBean isUpgradeOpen:").append(this.jdField_a_of_type_Boolean).append(" managePageURL:").append(this.jdField_a_of_type_JavaLangString).append(" bindPageURL:").append(this.jdField_b_of_type_JavaLangString).append(" relationNoBgUrl:").append(this.jdField_c_of_type_JavaLangString).append(" relationGuimiBg0Url:").append(this.d).append(" relationGuimiBg1Url:").append(this.e).append(" relationGuimiBg2Url:").append(this.f).append(" relationJiyouBg0Url:").append(this.g).append(" relationJiyouBg1Url:").append(this.h).append(" relationJiyouBg2Url:").append(this.i).append(" relationLoverBg0Url:").append(this.j).append(" relationLoverBg1Url:").append(this.k).append(" relationLoverBg2Url:").append(this.l).append(" relationGuimiDarkBg0Url:").append(this.m).append(" relationGuimiDarkBg1Url:").append(this.n).append(" relationGuimiDarkBg2Url:").append(this.o).append(" relationJiyouDarkBg0Url:").append(this.p).append(" relationJiyouDarkBg1Url:").append(this.q).append(" relationJiyouDarkBg2Url:").append(this.r).append(" relationLoverDarkBg0Url:").append(this.s).append(" relationLoverDarkBg1Url:").append(this.t).append(" relationLoverDarkBg2Url:").append(this.u).append(" relationNoShareUrl:").append(this.v).append(" relationGuimiShare0Url:").append(this.w).append(" relationGuimiShare1Url:").append(this.x).append(" relationGuimiShare2Url:").append(this.y).append(" relationJiyouShare0Url:").append(this.z).append(" relationJiyouShare1Url:").append(this.A).append(" relationJiyouShare2Url:").append(this.B).append(" relationLoverShare0Url:").append(this.C).append(" relationLoverShare1Url:").append(this.D).append(" relationLoverShare2Url:").append(this.E).append(" gifNormalUrl:").append(this.F).append(" gifNightUrl:").append(this.G);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amsi
 * JD-Core Version:    0.7.0.1
 */