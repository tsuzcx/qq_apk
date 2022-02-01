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
    int j;
    if (paramJSONObject == null)
    {
      j = 0;
      return j;
    }
    int i1;
    label309:
    label311:
    do
    {
      int m;
      for (;;)
      {
        for (;;)
        {
          int i;
          try
          {
            paramJSONObject.getInt("version");
            paramJSONObject.getInt("font_id");
            i = paramJSONObject.getInt("theme_style");
            j = paramJSONObject.getInt("color_style");
            if ((i < 0) || (i >= 65535)) {
              return 0;
            }
            if ((j < 0) || (j >= 65535)) {
              return 0;
            }
            i = 32;
            j = i;
          }
          catch (JSONException paramJSONObject)
          {
            int n;
            int k;
            Object localObject1;
            Object localObject2;
            int i2;
            i = 0;
            paramJSONObject.printStackTrace();
            return i;
          }
          try
          {
            paramJSONObject = paramJSONObject.getJSONArray("chars");
            j = i;
            n = paramJSONObject.length();
            j = n * 8 + 32;
            i = j;
            if (n > 0) {
              i = j + (n + 1) * 4;
            }
            k = 0;
            j = i;
            if (k >= n) {
              break;
            }
          }
          catch (JSONException paramJSONObject)
          {
            i = j;
          }
        }
        try
        {
          localObject1 = paramJSONObject.getJSONObject(k);
          j = ((JSONObject)localObject1).getInt("unicode");
          m = ((JSONObject)localObject1).getInt("theme_style");
          i1 = ((JSONObject)localObject1).getInt("color_style");
          if (j < 19968) {
            break label309;
          }
          if (j <= 40869) {
            break label311;
          }
        }
        catch (JSONException paramJSONObject)
        {
          continue;
        }
        localObject1 = ((JSONObject)localObject1).getJSONArray("components");
        i1 = ((JSONArray)localObject1).length();
        m = 0;
        if (m < i1)
        {
          j = i;
          localObject2 = ((JSONArray)localObject1).getJSONObject(m);
          j = i;
          i2 = ((JSONObject)localObject2).getInt("component");
          if ((i2 < 0) || (i2 >= 65535)) {
            break label339;
          }
          j = i;
          localObject2 = ((JSONObject)localObject2).getString("matrix").split(",");
          if (localObject2 != null)
          {
            j = i;
            i2 = localObject2.length;
            if (i2 == 6) {}
          }
          else
          {
            return 0;
          }
          i += 26;
          m += 1;
        }
        else
        {
          k += 1;
        }
      }
      return 0;
      if ((m < 0) || (m >= 65535)) {
        return 0;
      }
    } while ((i1 >= 0) && (i1 < 65535));
    return 0;
    label339:
    return 0;
  }
  
  public static long a(ETFont paramETFont, String paramString)
  {
    int j;
    try
    {
      localObject1 = new JSONObject(paramString);
      i4 = new ETDIYConfig().a((JSONObject)localObject1);
      if (i4 < a) {
        break label635;
      }
      arrayOfByte = new byte[i4];
      arrayOfInt = new int[6];
      if (!((JSONObject)localObject1).has("chars")) {
        break label637;
      }
      paramString = ((JSONObject)localObject1).getJSONArray("chars");
      if (paramString.length() <= 0) {
        break label649;
      }
      i = paramString.length();
    }
    catch (JSONException paramETFont)
    {
      Object localObject1;
      int i4;
      byte[] arrayOfByte;
      int[] arrayOfInt;
      QLog.e("ETDIYConfig", 1, "createNativeJsonHandle error: " + paramETFont.getMessage());
    }
    int i = ((JSONObject)localObject1).getInt("version");
    int k = ((JSONObject)localObject1).getInt("font_id");
    int m = ((JSONObject)localObject1).getInt("color_style");
    int n = ((JSONObject)localObject1).getInt("theme_style");
    a(arrayOfByte, 0, i);
    a(arrayOfByte, 4, k);
    a(arrayOfByte, 8, (short)m);
    a(arrayOfByte, 10, (short)n);
    a(arrayOfByte, 12, (short)j);
    i = 14;
    for (;;)
    {
      if (i < a)
      {
        arrayOfByte[i] = 0;
        i = i + 1 + 1;
      }
      else if ((j > 0) && (paramString != null))
      {
        k = a + j * 8;
        n = k + (j + 1) * 4;
        if (n <= i4) {
          break label654;
        }
        return 0L;
      }
    }
    for (;;)
    {
      label217:
      Object localObject2;
      int i5;
      int i3;
      if (m < j)
      {
        localObject2 = paramString.getJSONObject(m);
        localObject1 = ((JSONObject)localObject2).getJSONArray("components");
        int i6 = ((JSONObject)localObject2).getInt("unicode");
        i5 = ((JSONObject)localObject2).getInt("color_style");
        i3 = ((JSONObject)localObject2).getInt("theme_style");
        if (((JSONArray)localObject1).length() <= 0) {
          break label671;
        }
        n = ((JSONArray)localObject1).length();
        label282:
        a(arrayOfByte, i2, (short)i6);
        i2 += 2;
        a(arrayOfByte, i2, (short)i5);
        i2 += 2;
        a(arrayOfByte, i2, (short)i3);
        i5 = i2 + 2;
        a(arrayOfByte, i5, (short)n);
        a(arrayOfByte, k, i1);
        i3 = i1 + n * 26;
        i1 = 0;
      }
      for (;;)
      {
        if (i1 >= n) {
          break label686;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(i1);
        i2 = ((JSONObject)localObject2).getInt("component");
        localObject2 = ((JSONObject)localObject2).getString("matrix").split(",");
        if ((localObject2 != null) && (localObject2.length == 6))
        {
          arrayOfInt[0] = ((int)(Float.parseFloat(localObject2[0].trim()) * 65536.0F));
          arrayOfInt[1] = ((int)(Float.parseFloat(localObject2[1].trim()) * 65536.0F));
          arrayOfInt[2] = ((int)(Float.parseFloat(localObject2[2].trim()) * 65536.0F));
          arrayOfInt[3] = ((int)(Float.parseFloat(localObject2[3].trim()) * 65536.0F));
          arrayOfInt[4] = ((int)(Float.parseFloat(localObject2[4].trim()) * 64.0F));
          arrayOfInt[5] = ((int)(Float.parseFloat(localObject2[5].trim()) * 64.0F));
          if (i + 26 > i4) {
            return 0L;
          }
          a(arrayOfByte, i, (short)i2);
          i += 2;
          i2 = 0;
        }
        for (;;)
        {
          if (i2 < 6)
          {
            a(arrayOfByte, i, arrayOfInt[i2]);
            i += 4;
            i2 += 1;
            continue;
            a(arrayOfByte, k, i1);
            long l = ETEngine.getInstance().native_diyFontCreateNativeConfig(paramETFont, arrayOfByte);
            return l;
            label635:
            return 0L;
            label637:
            paramString = null;
            j = 0;
            break;
            for (;;)
            {
              j = i;
              break;
              label649:
              i = 0;
            }
            label654:
            i1 = 0;
            i2 = i;
            m = 0;
            i = n;
            break label217;
            return 0L;
            label671:
            n = 0;
            break label282;
          }
        }
        i1 += 1;
      }
      label686:
      m += 1;
      k += 4;
      int i2 = i5 + 2;
      int i1 = i3;
    }
  }
  
  public static String a(int paramInt, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt == 0)) {
      return null;
    }
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
  
  /* Error */
  public static String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 192	java/io/File:exists	()Z
    //   4: ifne +8 -> 12
    //   7: ldc 194
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: new 196	java/io/InputStreamReader
    //   15: dup
    //   16: new 198	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 201	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: ldc 203
    //   26: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   29: astore_2
    //   30: aload_2
    //   31: astore_0
    //   32: new 208	java/lang/StringBuffer
    //   35: dup
    //   36: invokespecial 209	java/lang/StringBuffer:<init>	()V
    //   39: astore_3
    //   40: aload_2
    //   41: astore_0
    //   42: aload_2
    //   43: invokevirtual 212	java/io/InputStreamReader:read	()I
    //   46: istore_1
    //   47: iload_1
    //   48: iconst_m1
    //   49: if_icmpeq +39 -> 88
    //   52: aload_2
    //   53: astore_0
    //   54: aload_3
    //   55: iload_1
    //   56: i2c
    //   57: invokevirtual 215	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   60: pop
    //   61: goto -21 -> 40
    //   64: astore_3
    //   65: aload_2
    //   66: astore_0
    //   67: ldc 217
    //   69: aload_3
    //   70: invokevirtual 218	java/io/IOException:getMessage	()Ljava/lang/String;
    //   73: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 226	java/io/InputStreamReader:close	()V
    //   85: ldc 194
    //   87: areturn
    //   88: aload_2
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 227	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   94: astore_3
    //   95: aload_3
    //   96: astore_0
    //   97: aload_0
    //   98: astore_3
    //   99: aload_2
    //   100: ifnull -90 -> 10
    //   103: aload_2
    //   104: invokevirtual 226	java/io/InputStreamReader:close	()V
    //   107: aload_0
    //   108: areturn
    //   109: astore_2
    //   110: ldc 217
    //   112: aload_2
    //   113: invokevirtual 218	java/io/IOException:getMessage	()Ljava/lang/String;
    //   116: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: aload_0
    //   121: areturn
    //   122: astore_0
    //   123: ldc 217
    //   125: aload_0
    //   126: invokevirtual 218	java/io/IOException:getMessage	()Ljava/lang/String;
    //   129: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   132: pop
    //   133: goto -48 -> 85
    //   136: astore_2
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_0
    //   140: ifnull +7 -> 147
    //   143: aload_0
    //   144: invokevirtual 226	java/io/InputStreamReader:close	()V
    //   147: aload_2
    //   148: athrow
    //   149: astore_0
    //   150: ldc 217
    //   152: aload_0
    //   153: invokevirtual 218	java/io/IOException:getMessage	()Ljava/lang/String;
    //   156: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   159: pop
    //   160: goto -13 -> 147
    //   163: astore_2
    //   164: goto -25 -> 139
    //   167: astore_3
    //   168: aconst_null
    //   169: astore_2
    //   170: goto -105 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramFile	java.io.File
    //   46	10	1	i	int
    //   29	75	2	localInputStreamReader	java.io.InputStreamReader
    //   109	4	2	localIOException1	java.io.IOException
    //   136	12	2	localObject1	Object
    //   163	1	2	localObject2	Object
    //   169	1	2	localObject3	Object
    //   9	46	3	localObject4	Object
    //   64	27	3	localIOException2	java.io.IOException
    //   94	5	3	localObject5	Object
    //   167	1	3	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   32	40	64	java/io/IOException
    //   42	47	64	java/io/IOException
    //   54	61	64	java/io/IOException
    //   90	95	64	java/io/IOException
    //   103	107	109	java/io/IOException
    //   81	85	122	java/io/IOException
    //   12	30	136	finally
    //   143	147	149	java/io/IOException
    //   32	40	163	finally
    //   42	47	163	finally
    //   54	61	163	finally
    //   67	77	163	finally
    //   90	95	163	finally
    //   12	30	167	java/io/IOException
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
  
  /* Error */
  public static byte[] a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 235	java/io/File:isFile	()Z
    //   7: ifeq +184 -> 191
    //   10: new 198	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 201	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: sipush 1024
    //   24: newarray byte
    //   26: astore 5
    //   28: aload_3
    //   29: astore_2
    //   30: new 237	java/io/ByteArrayOutputStream
    //   33: dup
    //   34: invokespecial 238	java/io/ByteArrayOutputStream:<init>	()V
    //   37: astore 6
    //   39: aload_3
    //   40: astore_2
    //   41: aload_3
    //   42: aload 5
    //   44: invokevirtual 241	java/io/FileInputStream:read	([B)I
    //   47: istore_1
    //   48: iload_1
    //   49: iconst_m1
    //   50: if_icmpeq +64 -> 114
    //   53: aload_3
    //   54: astore_2
    //   55: aload 6
    //   57: aload 5
    //   59: iconst_0
    //   60: iload_1
    //   61: invokevirtual 244	java/io/ByteArrayOutputStream:write	([BII)V
    //   64: goto -25 -> 39
    //   67: astore_2
    //   68: aload_3
    //   69: astore_2
    //   70: ldc 116
    //   72: iconst_1
    //   73: new 118	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   80: ldc 246
    //   82: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: invokevirtual 249	java/io/File:getPath	()Ljava/lang/String;
    //   89: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload 4
    //   100: astore_0
    //   101: aload_3
    //   102: ifnull +10 -> 112
    //   105: aload_3
    //   106: invokevirtual 250	java/io/FileInputStream:close	()V
    //   109: aload 4
    //   111: astore_0
    //   112: aload_0
    //   113: areturn
    //   114: aload_3
    //   115: astore_2
    //   116: aload 6
    //   118: invokevirtual 254	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   121: astore 5
    //   123: aload 5
    //   125: astore_2
    //   126: aload_2
    //   127: astore_0
    //   128: aload_3
    //   129: ifnull -17 -> 112
    //   132: aload_3
    //   133: invokevirtual 250	java/io/FileInputStream:close	()V
    //   136: aload_2
    //   137: areturn
    //   138: astore_0
    //   139: ldc 116
    //   141: iconst_1
    //   142: aload_0
    //   143: invokevirtual 218	java/io/IOException:getMessage	()Ljava/lang/String;
    //   146: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload_2
    //   150: areturn
    //   151: astore_0
    //   152: ldc 116
    //   154: iconst_1
    //   155: aload_0
    //   156: invokevirtual 218	java/io/IOException:getMessage	()Ljava/lang/String;
    //   159: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aconst_null
    //   163: areturn
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_2
    //   168: ifnull +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 250	java/io/FileInputStream:close	()V
    //   175: aload_0
    //   176: athrow
    //   177: astore_2
    //   178: ldc 116
    //   180: iconst_1
    //   181: aload_2
    //   182: invokevirtual 218	java/io/IOException:getMessage	()Ljava/lang/String;
    //   185: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: goto -13 -> 175
    //   191: ldc 116
    //   193: iconst_1
    //   194: new 118	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 256
    //   204: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_0
    //   208: invokevirtual 249	java/io/File:getPath	()Ljava/lang/String;
    //   211: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aconst_null
    //   221: areturn
    //   222: astore_0
    //   223: goto -56 -> 167
    //   226: astore_2
    //   227: aconst_null
    //   228: astore_3
    //   229: goto -161 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramFile	java.io.File
    //   47	14	1	i	int
    //   20	35	2	localFileInputStream1	java.io.FileInputStream
    //   67	1	2	localIOException1	java.io.IOException
    //   69	103	2	localObject1	Object
    //   177	5	2	localIOException2	java.io.IOException
    //   226	1	2	localIOException3	java.io.IOException
    //   18	211	3	localFileInputStream2	java.io.FileInputStream
    //   1	109	4	localObject2	Object
    //   26	98	5	arrayOfByte	byte[]
    //   37	80	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   21	28	67	java/io/IOException
    //   30	39	67	java/io/IOException
    //   41	48	67	java/io/IOException
    //   55	64	67	java/io/IOException
    //   116	123	67	java/io/IOException
    //   132	136	138	java/io/IOException
    //   105	109	151	java/io/IOException
    //   10	19	164	finally
    //   171	175	177	java/io/IOException
    //   21	28	222	finally
    //   30	39	222	finally
    //   41	48	222	finally
    //   55	64	222	finally
    //   70	98	222	finally
    //   116	123	222	finally
    //   10	19	226	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.ETDIYConfig
 * JD-Core Version:    0.7.0.1
 */