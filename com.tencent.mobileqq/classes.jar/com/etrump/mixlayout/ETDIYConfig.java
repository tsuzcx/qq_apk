package com.etrump.mixlayout;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ETDIYConfig
{
  private static int a = 32;
  private static int b = 32;
  
  private int a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return 0;
    }
    int j;
    do
    {
      do
      {
        try
        {
          paramJSONObject.getInt("version");
          paramJSONObject.getInt("font_id");
          int i = paramJSONObject.getInt("theme_style");
          j = paramJSONObject.getInt("color_style");
          if (i >= 0)
          {
            if (i >= 65535)
            {
              return 0;
              paramJSONObject = paramJSONObject.getJSONArray("chars");
              int k = paramJSONObject.length();
              j = k * 8 + 32;
              i = j;
              if (k > 0) {
                i = j + (k + 1) * 4;
              }
              i = a(i, paramJSONObject, k);
              return i;
            }
          }
          else {
            return 0;
          }
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          return 0;
        }
      } while (j < 0);
    } while (j < 65535);
    return 0;
  }
  
  public static long a(ETFont paramETFont, String paramString)
  {
    String str = "theme_style";
    Object localObject2 = "color_style";
    long l = 0L;
    label734:
    label743:
    label748:
    for (;;)
    {
      try
      {
        Object localObject3 = new JSONObject(paramString);
        int i5 = new ETDIYConfig().a((JSONObject)localObject3);
        if (i5 >= a)
        {
          byte[] arrayOfByte = new byte[i5];
          int[] arrayOfInt = new int[6];
          paramString = null;
          if (!((JSONObject)localObject3).has("chars")) {
            break label734;
          }
          localObject1 = ((JSONObject)localObject3).getJSONArray("chars");
          paramString = (String)localObject1;
          if (((JSONArray)localObject1).length() <= 0) {
            break label734;
          }
          k = ((JSONArray)localObject1).length();
          int i = ((JSONObject)localObject3).getInt("version");
          j = ((JSONObject)localObject3).getInt("font_id");
          int m = ((JSONObject)localObject3).getInt("color_style");
          int n = ((JSONObject)localObject3).getInt("theme_style");
          a(arrayOfByte, 0, i);
          a(arrayOfByte, 4, j);
          a(arrayOfByte, 8, (short)m);
          a(arrayOfByte, 10, (short)n);
          a(arrayOfByte, 12, (short)k);
          i = 14;
          if (i < a)
          {
            arrayOfByte[i] = 0;
            i = i + 1 + 1;
            continue;
          }
          if ((k <= 0) || (localObject1 == null)) {
            break label748;
          }
          j = a;
          int i1 = j + k * 8;
          j = (k + 1) * 4 + i1;
          if (j > i5) {
            return 0L;
          }
          int i2 = i;
          i = j;
          m = 0;
          n = 0;
          paramString = (String)localObject2;
          if (m < k) {
            try
            {
              localObject3 = ((JSONArray)localObject1).getJSONObject(m);
              localObject2 = ((JSONObject)localObject3).getJSONArray("components");
              int i6 = ((JSONObject)localObject3).getInt("unicode");
              int i4 = ((JSONObject)localObject3).getInt(paramString);
              int i3 = ((JSONObject)localObject3).getInt(str);
              if (((JSONArray)localObject2).length() <= 0) {
                break label743;
              }
              j = ((JSONArray)localObject2).length();
              a(arrayOfByte, i2, (short)i6);
              i2 += 2;
              a(arrayOfByte, i2, (short)i4);
              i2 += 2;
              a(arrayOfByte, i2, (short)i3);
              i2 += 2;
              a(arrayOfByte, i2, (short)j);
              i2 += 2;
              a(arrayOfByte, i1, n);
              i3 = i1 + 4;
              i4 = n + j * 26;
              n = 0;
              if (n < j)
              {
                localObject3 = ((JSONArray)localObject2).getJSONObject(n);
                i1 = ((JSONObject)localObject3).getInt("component");
                localObject3 = ((JSONObject)localObject3).getString("matrix").split(",");
                if ((localObject3 != null) && (localObject3.length == 6))
                {
                  arrayOfInt[0] = ((int)(Float.parseFloat(localObject3[0].trim()) * 65536.0F));
                  arrayOfInt[1] = ((int)(Float.parseFloat(localObject3[1].trim()) * 65536.0F));
                  arrayOfInt[2] = ((int)(Float.parseFloat(localObject3[2].trim()) * 65536.0F));
                  arrayOfInt[3] = ((int)(Float.parseFloat(localObject3[3].trim()) * 65536.0F));
                  arrayOfInt[4] = ((int)(Float.parseFloat(localObject3[4].trim()) * 64.0F));
                  arrayOfInt[5] = ((int)(Float.parseFloat(localObject3[5].trim()) * 64.0F));
                  if (i + 26 > i5) {
                    return 0L;
                  }
                  a(arrayOfByte, i, (short)i1);
                  i += 2;
                  i1 = 0;
                  if (i1 < 6)
                  {
                    a(arrayOfByte, i, arrayOfInt[i1]);
                    i += 4;
                    i1 += 1;
                    continue;
                  }
                  n += 1;
                  continue;
                }
                return 0L;
              }
              m += 1;
              i1 = i3;
              n = i4;
            }
            catch (JSONException paramETFont)
            {
              continue;
            }
          }
          try
          {
            a(arrayOfByte, i1, n);
            l = ETEngine.getInstance().native_diyFontCreateNativeConfig(paramETFont, arrayOfByte);
          }
          catch (JSONException paramETFont)
          {
            continue;
          }
        }
        return l;
      }
      catch (JSONException paramETFont)
      {
        paramString = new StringBuilder();
        paramString.append("createNativeJsonHandle error: ");
        paramString.append(paramETFont.getMessage());
        QLog.e("ETDIYConfig", 1, paramString.toString());
        return 0L;
      }
      int k = 0;
      Object localObject1 = paramString;
      continue;
      int j = 0;
    }
  }
  
  public static String a(int paramInt, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt != 0))
    {
      ETDIYConfig.DiyFontJson localDiyFontJson = new ETDIYConfig.DiyFontJson();
      localDiyFontJson.fontId = paramInt;
      localDiyFontJson.version = 65536;
      ETDIYConfig.Record localRecord = new ETDIYConfig.Record();
      localRecord.origin = 0;
      localRecord.format = 2;
      localRecord.uuid = paramString;
      localDiyFontJson.records.add(localRecord);
      return new Gson().toJson(localDiyFontJson);
    }
    return null;
  }
  
  /* Error */
  public static String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 193	java/io/File:exists	()Z
    //   4: ifne +6 -> 10
    //   7: ldc 195
    //   9: areturn
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_2
    //   15: new 197	java/io/InputStreamReader
    //   18: dup
    //   19: new 199	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: ldc 204
    //   29: invokespecial 207	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   32: astore_0
    //   33: new 209	java/lang/StringBuffer
    //   36: dup
    //   37: invokespecial 210	java/lang/StringBuffer:<init>	()V
    //   40: astore_2
    //   41: aload_0
    //   42: invokevirtual 213	java/io/InputStreamReader:read	()I
    //   45: istore_1
    //   46: iload_1
    //   47: iconst_m1
    //   48: if_icmpeq +13 -> 61
    //   51: aload_2
    //   52: iload_1
    //   53: i2c
    //   54: invokevirtual 216	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   57: pop
    //   58: goto -17 -> 41
    //   61: aload_2
    //   62: invokevirtual 217	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   65: astore_2
    //   66: aload_0
    //   67: invokevirtual 220	java/io/InputStreamReader:close	()V
    //   70: aload_2
    //   71: areturn
    //   72: astore_0
    //   73: ldc 222
    //   75: aload_0
    //   76: invokevirtual 223	java/io/IOException:getMessage	()Ljava/lang/String;
    //   79: invokestatic 228	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: aload_2
    //   84: areturn
    //   85: astore_3
    //   86: aload_0
    //   87: astore_2
    //   88: aload_3
    //   89: astore_0
    //   90: goto +52 -> 142
    //   93: astore_3
    //   94: goto +11 -> 105
    //   97: astore_0
    //   98: goto +44 -> 142
    //   101: astore_3
    //   102: aload 4
    //   104: astore_0
    //   105: aload_0
    //   106: astore_2
    //   107: ldc 222
    //   109: aload_3
    //   110: invokevirtual 223	java/io/IOException:getMessage	()Ljava/lang/String;
    //   113: invokestatic 228	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   116: pop
    //   117: aload_0
    //   118: ifnull +21 -> 139
    //   121: aload_0
    //   122: invokevirtual 220	java/io/InputStreamReader:close	()V
    //   125: ldc 195
    //   127: areturn
    //   128: astore_0
    //   129: ldc 222
    //   131: aload_0
    //   132: invokevirtual 223	java/io/IOException:getMessage	()Ljava/lang/String;
    //   135: invokestatic 228	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   138: pop
    //   139: ldc 195
    //   141: areturn
    //   142: aload_2
    //   143: ifnull +21 -> 164
    //   146: aload_2
    //   147: invokevirtual 220	java/io/InputStreamReader:close	()V
    //   150: goto +14 -> 164
    //   153: astore_2
    //   154: ldc 222
    //   156: aload_2
    //   157: invokevirtual 223	java/io/IOException:getMessage	()Ljava/lang/String;
    //   160: invokestatic 228	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   163: pop
    //   164: goto +5 -> 169
    //   167: aload_0
    //   168: athrow
    //   169: goto -2 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramFile	java.io.File
    //   45	8	1	i	int
    //   14	133	2	localObject1	Object
    //   153	4	2	localIOException1	java.io.IOException
    //   85	4	3	localObject2	Object
    //   93	1	3	localIOException2	java.io.IOException
    //   101	9	3	localIOException3	java.io.IOException
    //   11	92	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   66	70	72	java/io/IOException
    //   33	41	85	finally
    //   41	46	85	finally
    //   51	58	85	finally
    //   61	66	85	finally
    //   33	41	93	java/io/IOException
    //   41	46	93	java/io/IOException
    //   51	58	93	java/io/IOException
    //   61	66	93	java/io/IOException
    //   15	33	97	finally
    //   107	117	97	finally
    //   15	33	101	java/io/IOException
    //   121	125	128	java/io/IOException
    //   146	150	153	java/io/IOException
  }
  
  public static void a(long paramLong)
  {
    if (0L != paramLong) {
      ETEngine.getInstance().native_diyFontDeleteNativeConfig(paramLong);
    }
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 24 & 0xFF));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 & 0xFF));
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    paramArrayOfByte[(paramInt + 0)] = ((byte)(paramShort >> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(paramShort & 0xFF));
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("unicode");
    int j = paramJSONObject.getInt("theme_style");
    int k = paramJSONObject.getInt("color_style");
    if (i >= 19968)
    {
      if (i > 40869) {
        return true;
      }
      if (j >= 0)
      {
        if (j >= 65535) {
          return true;
        }
        if (k >= 0) {
          return k >= 65535;
        }
      }
    }
    return true;
  }
  
  /* Error */
  public static byte[] b(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 238	java/io/File:isFile	()Z
    //   4: ifeq +195 -> 199
    //   7: new 199	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: sipush 1024
    //   21: newarray byte
    //   23: astore 4
    //   25: aload_3
    //   26: astore_2
    //   27: new 240	java/io/ByteArrayOutputStream
    //   30: dup
    //   31: invokespecial 241	java/io/ByteArrayOutputStream:<init>	()V
    //   34: astore 5
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: aload 4
    //   41: invokevirtual 244	java/io/FileInputStream:read	([B)I
    //   44: istore_1
    //   45: iload_1
    //   46: iconst_m1
    //   47: if_icmpeq +17 -> 64
    //   50: aload_3
    //   51: astore_2
    //   52: aload 5
    //   54: aload 4
    //   56: iconst_0
    //   57: iload_1
    //   58: invokevirtual 247	java/io/ByteArrayOutputStream:write	([BII)V
    //   61: goto -25 -> 36
    //   64: aload_3
    //   65: astore_2
    //   66: aload 5
    //   68: invokevirtual 251	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   71: astore 4
    //   73: aload_3
    //   74: invokevirtual 252	java/io/FileInputStream:close	()V
    //   77: aload 4
    //   79: areturn
    //   80: astore_0
    //   81: ldc 129
    //   83: iconst_1
    //   84: aload_0
    //   85: invokevirtual 223	java/io/IOException:getMessage	()Ljava/lang/String;
    //   88: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload 4
    //   93: areturn
    //   94: astore_0
    //   95: goto +80 -> 175
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_2
    //   101: goto +74 -> 175
    //   104: aconst_null
    //   105: astore_3
    //   106: aload_3
    //   107: astore_2
    //   108: new 117	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   115: astore 4
    //   117: aload_3
    //   118: astore_2
    //   119: aload 4
    //   121: ldc 254
    //   123: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_3
    //   128: astore_2
    //   129: aload 4
    //   131: aload_0
    //   132: invokevirtual 257	java/io/File:getPath	()Ljava/lang/String;
    //   135: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_3
    //   140: astore_2
    //   141: ldc 129
    //   143: iconst_1
    //   144: aload 4
    //   146: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_3
    //   153: ifnull +20 -> 173
    //   156: aload_3
    //   157: invokevirtual 252	java/io/FileInputStream:close	()V
    //   160: aconst_null
    //   161: areturn
    //   162: astore_0
    //   163: ldc 129
    //   165: iconst_1
    //   166: aload_0
    //   167: invokevirtual 223	java/io/IOException:getMessage	()Ljava/lang/String;
    //   170: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aconst_null
    //   174: areturn
    //   175: aload_2
    //   176: ifnull +21 -> 197
    //   179: aload_2
    //   180: invokevirtual 252	java/io/FileInputStream:close	()V
    //   183: goto +14 -> 197
    //   186: astore_2
    //   187: ldc 129
    //   189: iconst_1
    //   190: aload_2
    //   191: invokevirtual 223	java/io/IOException:getMessage	()Ljava/lang/String;
    //   194: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_0
    //   198: athrow
    //   199: new 117	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   206: astore_2
    //   207: aload_2
    //   208: ldc_w 259
    //   211: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_2
    //   216: aload_0
    //   217: invokevirtual 257	java/io/File:getPath	()Ljava/lang/String;
    //   220: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: ldc 129
    //   226: iconst_1
    //   227: aload_2
    //   228: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aconst_null
    //   235: areturn
    //   236: astore_2
    //   237: goto -133 -> 104
    //   240: astore_2
    //   241: goto -135 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramFile	java.io.File
    //   44	14	1	i	int
    //   17	163	2	localFileInputStream1	java.io.FileInputStream
    //   186	5	2	localIOException1	java.io.IOException
    //   206	22	2	localStringBuilder	StringBuilder
    //   236	1	2	localIOException2	java.io.IOException
    //   240	1	2	localIOException3	java.io.IOException
    //   15	142	3	localFileInputStream2	java.io.FileInputStream
    //   23	122	4	localObject	Object
    //   34	33	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   73	77	80	java/io/IOException
    //   18	25	94	finally
    //   27	36	94	finally
    //   38	45	94	finally
    //   52	61	94	finally
    //   66	73	94	finally
    //   108	117	94	finally
    //   119	127	94	finally
    //   129	139	94	finally
    //   141	152	94	finally
    //   7	16	98	finally
    //   156	160	162	java/io/IOException
    //   179	183	186	java/io/IOException
    //   7	16	236	java/io/IOException
    //   18	25	240	java/io/IOException
    //   27	36	240	java/io/IOException
    //   38	45	240	java/io/IOException
    //   52	61	240	java/io/IOException
    //   66	73	240	java/io/IOException
  }
  
  public int a(int paramInt1, JSONArray paramJSONArray, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      Object localObject1 = paramJSONArray.getJSONObject(i);
      if (b((JSONObject)localObject1)) {
        return 0;
      }
      localObject1 = ((JSONObject)localObject1).getJSONArray("components");
      int k = ((JSONArray)localObject1).length();
      int j = 0;
      while (j < k)
      {
        Object localObject2 = ((JSONArray)localObject1).getJSONObject(j);
        int m = ((JSONObject)localObject2).getInt("component");
        if (m >= 0)
        {
          if (m >= 65535) {
            return 0;
          }
          localObject2 = ((JSONObject)localObject2).getString("matrix").split(",");
          if (localObject2 != null)
          {
            if (localObject2.length != 6) {
              return 0;
            }
            paramInt1 += 26;
            j += 1;
            continue;
          }
        }
        return 0;
      }
      i += 1;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETDIYConfig
 * JD-Core Version:    0.7.0.1
 */