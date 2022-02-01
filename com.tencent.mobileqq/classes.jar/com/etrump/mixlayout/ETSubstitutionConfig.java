package com.etrump.mixlayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ETSubstitutionConfig
{
  private int a(JSONObject paramJSONObject)
  {
    int k = 0;
    if (paramJSONObject == null) {}
    do
    {
      return k;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("records");
        m = paramJSONObject.length();
        i = 12 + m * 8;
        j = 0;
      }
      catch (JSONException paramJSONObject)
      {
        try
        {
          int m;
          int j;
          k = paramJSONObject.getJSONObject(j).getString("uuid").length();
          j += 1;
          i = k + 1 + i;
        }
        catch (JSONException paramJSONObject)
        {
          int i;
          break;
        }
        paramJSONObject = paramJSONObject;
        i = 12;
      }
      k = i;
    } while (j >= m);
    paramJSONObject.printStackTrace();
    return i;
  }
  
  public static long a(long paramLong)
  {
    if (paramLong == 0L) {
      return 0L;
    }
    return ETEngine.getInstance().native_CloneNativeSubstitutionConfig(paramLong);
  }
  
  public static long a(ETFont paramETFont, String paramString)
  {
    int j = 12;
    try
    {
      Object localObject1 = new JSONObject(paramString);
      int i = new ETSubstitutionConfig().a((JSONObject)localObject1);
      if (i >= 12)
      {
        paramString = new byte[i];
        i = ((JSONObject)localObject1).getInt("version");
        int k = ((JSONObject)localObject1).getInt("fontId");
        if (k != paramETFont.getId()) {
          return 0L;
        }
        localObject1 = ((JSONObject)localObject1).getJSONArray("records");
        int m = ((JSONArray)localObject1).length();
        a(paramString, 0, i);
        a(paramString, 4, k);
        a(paramString, 8, m);
        i = 0;
        while (i < m)
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          k = ((JSONObject)localObject2).getInt("origin");
          int i1 = ((JSONObject)localObject2).getInt("format");
          localObject2 = ((JSONObject)localObject2).getString("uuid");
          int n = ((String)localObject2).length();
          localObject2 = ((String)localObject2).getBytes();
          a(paramString, j, i1);
          j += 4;
          a(paramString, j, k);
          j += 4;
          k = 0;
          while (k < n)
          {
            a(paramString, j, localObject2[k]);
            j += 1;
            k += 1;
          }
          a(paramString, j, (byte)0);
          i += 1;
          j += 1;
        }
        long l = ETEngine.getInstance().native_CreateNativeSubstitutionConfig(paramETFont, paramString);
        return l;
      }
    }
    catch (JSONException paramETFont)
    {
      paramETFont.printStackTrace();
    }
    return 0L;
  }
  
  public static void a(long paramLong)
  {
    if (0L != paramLong) {
      ETEngine.getInstance().native_DeleteNativeSubstitutionConfig(paramLong);
    }
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt, byte paramByte)
  {
    paramArrayOfByte[(paramInt + 0)] = ((byte)(paramByte & 0xFF));
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 24 & 0xFF));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 & 0xFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.ETSubstitutionConfig
 * JD-Core Version:    0.7.0.1
 */