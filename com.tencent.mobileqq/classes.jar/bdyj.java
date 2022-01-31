import android.text.TextUtils;
import org.json.JSONObject;

public class bdyj
{
  public static final int a;
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  static
  {
    jdField_a_of_type_Int = bdzi.a();
  }
  
  private bdyj(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt3;
    this.g = paramInt4;
  }
  
  public bdyj(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramInt6;
  }
  
  public static int a(int paramInt)
  {
    return Double.valueOf(1.0D * paramInt / 1026.0D * 249.0D).intValue();
  }
  
  public static int a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4)
  {
    if (paramFloat == 0.0F) {
      return paramInt1;
    }
    if (paramInt1 < jdField_a_of_type_Int) {}
    int i;
    int j;
    int i1;
    int n;
    for (int k = jdField_a_of_type_Int;; k = paramInt1)
    {
      i = Math.round(paramInt3 * 1.0F / paramFloat);
      j = Math.round(paramInt4 * 1.0F / paramFloat);
      switch (paramInt2)
      {
      default: 
        i1 = i;
        n = j;
        i = k;
        bdnw.b("BannerAdPosInfo", "buildFormatInfo，deviceOrientation = " + paramInt2 + ", density = " + paramFloat + ", screeWpx = " + paramInt3 + ", screeHpx = " + paramInt4 + ", screenW = " + i1 + ", screenH = " + n + ", originWidth = " + paramInt1 + ", realWidth = " + i);
        return i;
      }
    }
    int m;
    if (i < j)
    {
      m = j;
      j = i;
    }
    for (;;)
    {
      i = k;
      n = j;
      i1 = m;
      if (k <= m / 2) {
        break;
      }
      i = m / 2;
      n = j;
      i1 = m;
      break;
      m = i;
      n = j;
      if (j < i)
      {
        n = i;
        m = j;
      }
      i = k;
      if (k > m) {
        i = m;
      }
      i1 = m;
      break;
      m = i;
    }
  }
  
  public static bdyj a(bdyj parambdyj, int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((parambdyj == null) || (paramFloat == 0.0F)) {
      return null;
    }
    paramInt1 = a(parambdyj.d, paramInt1, paramFloat, paramInt2, paramInt3);
    paramInt2 = Double.valueOf(1.0D * paramInt1 / 1026.0D * 249.0D).intValue();
    return new bdyj(parambdyj.jdField_a_of_type_JavaLangString, parambdyj.b, parambdyj.c, parambdyj.d, parambdyj.e, paramInt1, paramInt2);
  }
  
  public static bdyj a(String paramString)
  {
    int m = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString);
        String str = ((JSONObject)localObject2).getString("adUnitId");
        bdnw.b("BannerAdPosInfo", "parseBannerAdPosInfoFromJson error " + paramString, localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          k = ((JSONObject)localObject2).getJSONObject("style").getInt("left");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            i = 0;
            j = 0;
            int k = 0;
            localObject2 = localObject1;
            localObject1 = localException2;
          }
        }
        try
        {
          j = ((JSONObject)localObject2).getJSONObject("style").getInt("top");
        }
        catch (Exception localException3)
        {
          i = 0;
          j = 0;
          localObject2 = localObject1;
          localObject1 = localException3;
          break label133;
        }
        try
        {
          i = ((JSONObject)localObject2).getJSONObject("style").getInt("width");
        }
        catch (Exception localException4)
        {
          i = 0;
          localObject2 = localObject1;
          localObject1 = localException4;
          break label133;
        }
        try
        {
          if (((JSONObject)localObject2).getJSONObject("style").has("height")) {
            m = ((JSONObject)localObject2).getJSONObject("style").getInt("height");
          }
          if ((!TextUtils.isEmpty(str)) && (k >= 0) && (j >= 0) && (i > 0)) {
            break;
          }
          return null;
        }
        catch (Exception localException5)
        {
          localObject2 = localObject1;
          localObject1 = localException5;
          break label133;
        }
        localException1 = localException1;
        i = 0;
        j = 0;
        localObject2 = "";
        k = 0;
      }
      label133:
      m = 0;
      localObject1 = localObject2;
    }
    return new bdyj(localObject1, k, j, i, m);
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.f > 0) && (this.g > 0);
  }
  
  public String toString()
  {
    return "mAdUnitId = " + this.jdField_a_of_type_JavaLangString + ", left = " + this.b + ", top = " + this.c + ", width = " + this.d + ", height = " + this.e + ", realWidth = " + this.f + ", realHeight = " + this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdyj
 * JD-Core Version:    0.7.0.1
 */