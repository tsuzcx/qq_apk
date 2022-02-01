import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class bokr
  implements boko
{
  private static final Double jdField_a_of_type_JavaLangDouble = Double.valueOf(0.005D);
  private static final Double b = Double.valueOf(0.01D);
  private static final Double c = Double.valueOf(0.35D);
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  private boks a(Bitmap paramBitmap, ArrayList<bokp> paramArrayList)
  {
    boks localboks = new boks(this);
    if ((paramBitmap == null) || (paramArrayList == null)) {
      return localboks;
    }
    double d1 = paramBitmap.getWidth() * paramBitmap.getHeight();
    int i = 0;
    while (i < paramArrayList.size())
    {
      paramBitmap = (bokp)paramArrayList.get(i);
      int j = paramBitmap.jdField_b_of_type_Int;
      double d2 = paramBitmap.jdField_a_of_type_Int * j;
      double d3 = localboks.jdField_a_of_type_Double;
      localboks.jdField_a_of_type_Double = (d2 / d1 + d3);
      if (localboks.jdField_a_of_type_Double > jdField_a_of_type_JavaLangDouble.doubleValue()) {
        localboks.jdField_a_of_type_Boolean = true;
      }
      i += 1;
    }
    if ((paramArrayList.size() > 1) && (localboks.jdField_a_of_type_Double > b.doubleValue())) {
      localboks.b = true;
    }
    return localboks;
  }
  
  private boku a(String paramString)
  {
    boku localboku = new boku();
    if (paramString == null) {}
    do
    {
      return null;
      if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
        break;
      }
      this.jdField_a_of_type_OrgJsonJSONObject = a();
    } while (this.jdField_a_of_type_OrgJsonJSONObject == null);
    JSONArray localJSONArray1 = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("sceneList");
    int i = 0;
    while (i < localJSONArray1.length())
    {
      JSONObject localJSONObject1 = localJSONArray1.optJSONObject(i);
      JSONArray localJSONArray2 = localJSONObject1.optJSONArray("sceneLvTwoList");
      int j = 0;
      JSONObject localJSONObject2;
      if (j < localJSONArray2.length())
      {
        localJSONObject2 = localJSONArray2.optJSONObject(j);
        if (localJSONObject2.optString("sceneName").equals(paramString))
        {
          localboku.jdField_a_of_type_Int = localJSONObject1.optInt("sceneLvOne");
          localboku.jdField_b_of_type_Int = localJSONObject2.optInt("sceneLvTwo");
          localboku.jdField_a_of_type_JavaLangString = localJSONObject2.optString("sceneName");
          localboku.jdField_b_of_type_JavaLangString = localJSONObject2.optString("sceneFilterID");
          localboku.jdField_a_of_type_Double = localJSONObject2.optDouble("sceneFilterPercent");
        }
      }
      else
      {
        i += 1;
        continue;
      }
      JSONArray localJSONArray3 = localJSONObject2.optJSONArray("sceneLabels");
      String[] arrayOfString = new String[localJSONArray3.length()];
      int k = 0;
      while (k < localJSONArray3.length())
      {
        arrayOfString[k] = localJSONArray3.optString(k);
        k += 1;
      }
      int m = arrayOfString.length;
      k = 0;
      for (;;)
      {
        if (k < m)
        {
          if (arrayOfString[k].equals(paramString))
          {
            localboku.jdField_a_of_type_Int = localJSONObject1.optInt("sceneLvOne");
            localboku.jdField_b_of_type_Int = localJSONObject2.optInt("sceneLvTwo");
            localboku.jdField_a_of_type_JavaLangString = localJSONObject2.optString("sceneName");
            localboku.jdField_b_of_type_JavaLangString = localJSONObject2.optString("sceneFilterID");
            localboku.jdField_a_of_type_Double = localJSONObject2.optDouble("sceneFilterPercent");
          }
        }
        else
        {
          j += 1;
          break;
        }
        k += 1;
      }
    }
    return localboku;
  }
  
  private boku a(JSONArray paramJSONArray)
  {
    double d2 = -1.0D;
    Object localObject1 = new boku();
    Object localObject2 = localObject1;
    if (paramJSONArray.length() > 0)
    {
      int i = 0;
      double d3 = -1.0D;
      localObject2 = localObject1;
      if (i < paramJSONArray.length())
      {
        localObject2 = paramJSONArray.optJSONObject(i);
        Object localObject3 = ((JSONObject)localObject2).optString("label");
        double d4 = ((JSONObject)localObject2).optDouble("confidence");
        boku localboku = a((String)localObject3);
        double d6;
        double d5;
        if (localboku == null)
        {
          d6 = d3;
          d5 = d2;
          localObject2 = localObject1;
        }
        for (;;)
        {
          i += 1;
          localObject1 = localObject2;
          d2 = d5;
          d3 = d6;
          break;
          localObject2 = localObject1;
          d5 = d2;
          d6 = d3;
          if (localboku.jdField_b_of_type_Int != -1)
          {
            localObject3 = localObject1;
            double d1 = d2;
            if (localboku.jdField_a_of_type_Int == 3)
            {
              localObject3 = localObject1;
              d1 = d2;
              if (d4 > c.doubleValue())
              {
                localObject3 = localObject1;
                d1 = d2;
                if (d4 > d2)
                {
                  d1 = d4;
                  localObject3 = localboku;
                }
              }
            }
            localObject2 = localObject3;
            d5 = d1;
            d6 = d3;
            if (d4 > d3)
            {
              localObject2 = localObject3;
              d5 = d1;
              d6 = d3;
              if (d1 <= 0.0D)
              {
                localObject2 = localboku;
                d5 = d1;
                d6 = d4;
              }
            }
          }
        }
      }
    }
    return localObject2;
  }
  
  private String a(Bitmap paramBitmap, int paramInt)
  {
    int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    if (i > paramInt)
    {
      paramBitmap = azet.a(paramBitmap, i / paramInt);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
      return bokm.a(localByteArrayOutputStream.toByteArray());
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    return bokm.a(localByteArrayOutputStream.toByteArray());
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(bhmi.d("video_story_aiSceneParams.json"));
      return localJSONObject2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  private JSONObject a(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("raw_base64", paramString);
      localJSONObject2.put("only_gender", 0);
      localJSONObject2.put("token", b(paramString));
      paramString = bokn.a("https://tu.qq.com/cgi-bin/qq/get_face_detail.fcg", localJSONObject2.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localJSONObject1;
  }
  
  private String b(String paramString)
  {
    int i = paramString.length();
    int j = i / 2;
    paramString = paramString.substring(j, (int)(i * 0.1D) + j);
    return a(paramString + "9996ef4aa4fb4378826bc1f1a8409dd7");
  }
  
  private JSONObject b(String paramString)
  {
    long l = System.currentTimeMillis() / 1000L;
    String str = String.valueOf(l).hashCode() + "";
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("request_id", str);
      localJSONObject2.put("appid", "10301");
      localJSONObject2.put("raw_base64", paramString);
      localJSONObject2.put("user", "PTU");
      localJSONObject2.put("token", b(paramString));
      paramString = bokn.a("https://tu.qq.com/cgi-bin/qq/do_image_classify.fcg", localJSONObject2.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = String.format("%032x", new Object[] { new BigInteger(1, MessageDigest.getInstance("MD5").digest(paramString.getBytes())) });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void a(Bitmap paramBitmap, ArrayList<bokp> paramArrayList, bokq parambokq)
  {
    if (paramBitmap == null)
    {
      parambokq.a("image is null");
      return;
    }
    long l = System.currentTimeMillis();
    boku localboku = new boku();
    paramArrayList = a(paramBitmap, paramArrayList);
    paramBitmap = a(paramBitmap, 256);
    if (paramArrayList.jdField_a_of_type_Boolean) {
      if (paramArrayList.b) {
        paramBitmap = a(anzj.a(2131714612));
      }
    }
    while (paramBitmap == null)
    {
      parambokq.a("unknown error");
      bokn.a(System.currentTimeMillis() - l, 1);
      return;
      paramBitmap = a(paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.isNull("retcode")))
      {
        parambokq.a("network error");
        bokn.a(System.currentTimeMillis() - l, 1);
        return;
      }
      if ((paramBitmap != null) && (paramBitmap.has("retcode")) && (paramBitmap.optInt("retcode") == 0))
      {
        paramBitmap = paramBitmap.optJSONObject("retdata");
        int i = paramBitmap.optInt("age");
        int j = paramBitmap.optInt("gender");
        if (i <= 5) {
          paramBitmap = a(anzj.a(2131714615));
        } else if (j < 50) {
          paramBitmap = a(anzj.a(2131714613));
        } else {
          paramBitmap = a(anzj.a(2131714610));
        }
      }
      else
      {
        paramBitmap = a(anzj.a(2131714614));
        continue;
        paramArrayList = b(paramBitmap);
        if ((paramArrayList == null) || (paramArrayList.isNull("retcode")))
        {
          parambokq.a("network error");
          l = System.currentTimeMillis() - l;
          bokn.a(l, 1);
          abbe.a("record_smart_filter", abbe.a(1L, l));
          return;
        }
        paramBitmap = localboku;
        if (paramArrayList != null)
        {
          paramBitmap = localboku;
          if (paramArrayList.has("retcode"))
          {
            paramBitmap = localboku;
            if (paramArrayList.optInt("retcode") == 0)
            {
              paramArrayList = paramArrayList.optJSONObject("retdata");
              paramBitmap = localboku;
              if (paramArrayList.has("message"))
              {
                paramBitmap = localboku;
                if (paramArrayList.optString("message").equals("ok")) {
                  paramBitmap = a(paramArrayList.optJSONObject("data").optJSONArray("tags"));
                }
              }
            }
          }
        }
      }
    }
    parambokq.a(paramBitmap);
    l = System.currentTimeMillis() - l;
    bokn.a(l, 0);
    abbe.a("record_smart_filter", abbe.a(0L, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bokr
 * JD-Core Version:    0.7.0.1
 */