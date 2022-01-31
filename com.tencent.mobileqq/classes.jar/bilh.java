import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class bilh
  implements bile
{
  private static final Double jdField_a_of_type_JavaLangDouble = Double.valueOf(0.005D);
  private static final Double b = Double.valueOf(0.01D);
  private static final Double c = Double.valueOf(0.35D);
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  private bili a(Bitmap paramBitmap, ArrayList<bilf> paramArrayList)
  {
    bili localbili = new bili(this);
    if ((paramBitmap == null) || (paramArrayList == null)) {
      return localbili;
    }
    double d1 = paramBitmap.getWidth() * paramBitmap.getHeight();
    int i = 0;
    while (i < paramArrayList.size())
    {
      paramBitmap = (bilf)paramArrayList.get(i);
      int j = paramBitmap.jdField_b_of_type_Int;
      double d2 = paramBitmap.jdField_a_of_type_Int * j;
      double d3 = localbili.jdField_a_of_type_Double;
      localbili.jdField_a_of_type_Double = (d2 / d1 + d3);
      if (localbili.jdField_a_of_type_Double > jdField_a_of_type_JavaLangDouble.doubleValue()) {
        localbili.jdField_a_of_type_Boolean = true;
      }
      i += 1;
    }
    if ((paramArrayList.size() > 1) && (localbili.jdField_a_of_type_Double > b.doubleValue())) {
      localbili.b = true;
    }
    return localbili;
  }
  
  private bilk a(String paramString)
  {
    bilk localbilk = new bilk();
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
          localbilk.jdField_a_of_type_Int = localJSONObject1.optInt("sceneLvOne");
          localbilk.jdField_b_of_type_Int = localJSONObject2.optInt("sceneLvTwo");
          localbilk.jdField_a_of_type_JavaLangString = localJSONObject2.optString("sceneName");
          localbilk.jdField_b_of_type_JavaLangString = localJSONObject2.optString("sceneFilterID");
          localbilk.jdField_a_of_type_Double = localJSONObject2.optDouble("sceneFilterPercent");
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
            localbilk.jdField_a_of_type_Int = localJSONObject1.optInt("sceneLvOne");
            localbilk.jdField_b_of_type_Int = localJSONObject2.optInt("sceneLvTwo");
            localbilk.jdField_a_of_type_JavaLangString = localJSONObject2.optString("sceneName");
            localbilk.jdField_b_of_type_JavaLangString = localJSONObject2.optString("sceneFilterID");
            localbilk.jdField_a_of_type_Double = localJSONObject2.optDouble("sceneFilterPercent");
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
    return localbilk;
  }
  
  private bilk a(JSONArray paramJSONArray)
  {
    double d2 = -1.0D;
    Object localObject1 = new bilk();
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
        bilk localbilk = a((String)localObject3);
        double d6;
        double d5;
        if (localbilk == null)
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
          if (localbilk.jdField_b_of_type_Int != -1)
          {
            localObject3 = localObject1;
            double d1 = d2;
            if (localbilk.jdField_a_of_type_Int == 3)
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
                  localObject3 = localbilk;
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
                localObject2 = localbilk;
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
      paramBitmap = augv.a(paramBitmap, i / paramInt);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
      return bilc.a(localByteArrayOutputStream.toByteArray());
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    return bilc.a(localByteArrayOutputStream.toByteArray());
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(bbdx.d("video_story_aiSceneParams.json"));
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
      paramString = bild.a("https://tu.qq.com/cgi-bin/qq/get_face_detail.fcg", localJSONObject2.toString());
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
      paramString = bild.a("https://tu.qq.com/cgi-bin/qq/do_image_classify.fcg", localJSONObject2.toString());
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
  
  public void a(Bitmap paramBitmap, ArrayList<bilf> paramArrayList, bilg parambilg)
  {
    if (paramBitmap == null)
    {
      parambilg.a("image is null");
      return;
    }
    long l = System.currentTimeMillis();
    bilk localbilk = new bilk();
    paramArrayList = a(paramBitmap, paramArrayList);
    paramBitmap = a(paramBitmap, 256);
    if (paramArrayList.jdField_a_of_type_Boolean) {
      if (paramArrayList.b) {
        paramBitmap = a(ajya.a(2131715838));
      }
    }
    while (paramBitmap == null)
    {
      parambilg.a("unknown error");
      bild.a(System.currentTimeMillis() - l, 1);
      return;
      paramBitmap = a(paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.isNull("retcode")))
      {
        parambilg.a("network error");
        bild.a(System.currentTimeMillis() - l, 1);
        return;
      }
      if ((paramBitmap != null) && (paramBitmap.has("retcode")) && (paramBitmap.optInt("retcode") == 0))
      {
        paramBitmap = paramBitmap.optJSONObject("retdata");
        int i = paramBitmap.optInt("age");
        int j = paramBitmap.optInt("gender");
        if (i <= 5) {
          paramBitmap = a(ajya.a(2131715841));
        } else if (j < 50) {
          paramBitmap = a(ajya.a(2131715839));
        } else {
          paramBitmap = a(ajya.a(2131715836));
        }
      }
      else
      {
        paramBitmap = a(ajya.a(2131715840));
        continue;
        paramArrayList = b(paramBitmap);
        if ((paramArrayList == null) || (paramArrayList.isNull("retcode")))
        {
          parambilg.a("network error");
          l = System.currentTimeMillis() - l;
          bild.a(l, 1);
          xhb.a("record_smart_filter", xhb.a(1L, l));
          return;
        }
        paramBitmap = localbilk;
        if (paramArrayList != null)
        {
          paramBitmap = localbilk;
          if (paramArrayList.has("retcode"))
          {
            paramBitmap = localbilk;
            if (paramArrayList.optInt("retcode") == 0)
            {
              paramArrayList = paramArrayList.optJSONObject("retdata");
              paramBitmap = localbilk;
              if (paramArrayList.has("message"))
              {
                paramBitmap = localbilk;
                if (paramArrayList.optString("message").equals("ok")) {
                  paramBitmap = a(paramArrayList.optJSONObject("data").optJSONArray("tags"));
                }
              }
            }
          }
        }
      }
    }
    parambilg.a(paramBitmap);
    l = System.currentTimeMillis() - l;
    bild.a(l, 0);
    xhb.a("record_smart_filter", xhb.a(0L, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilh
 * JD-Core Version:    0.7.0.1
 */