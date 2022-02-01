package com.tencent.mobileqq.apollo.game.process.data;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameOpenIdFinder
{
  private int jdField_a_of_type_Int;
  public SparseArray<WeakReference<CmGameOpenIdFinder.OpenIdListener>> a;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, String> b = new ConcurrentHashMap();
  
  public CmGameOpenIdFinder(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static String a(long paramLong, String paramString1, String paramString2)
  {
    if (!a(paramString1)) {
      return paramString2;
    }
    try
    {
      if (CmGameUtil.a() == null) {
        return paramString2;
      }
      paramString1 = new JSONObject(paramString2);
      String str = paramString1.optString("openId");
      paramString1.optInt("gameId");
      CmGameOpenIdFinder localCmGameOpenIdFinder = CmGameUtil.a(paramLong);
      if (localCmGameOpenIdFinder != null)
      {
        str = localCmGameOpenIdFinder.b(str);
        if (!TextUtils.isEmpty(str))
        {
          paramString1.put("uin", str);
          return paramString1.toString();
        }
        QLog.w("cmgame_process.CmGameOpenIdFinder", 1, "logic error happens.");
        return paramString2;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmgame_process.CmGameOpenIdFinder", 1, paramString1, new Object[0]);
    }
    return paramString2;
  }
  
  @NotNull
  private JSONObject a(@NonNull ArrayList<Long> paramArrayList, @NonNull ArrayList<String> paramArrayList1, int paramInt)
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject1 = new JSONObject();
    int i = 0;
    while (i < paramArrayList.size())
    {
      this.b.put(paramArrayList.get(i), paramArrayList1.get(i));
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("identifier", paramArrayList1.get(i));
        localJSONArray.put(localJSONObject2);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tinyId json error");
        localStringBuilder.append(localException.toString());
        QLog.e("cmgame_process.CmGameOpenIdFinder", 1, localStringBuilder.toString());
      }
      i += 1;
    }
    try
    {
      localJSONObject1.put("eventId", paramInt);
      localJSONObject1.put("userInfo", localJSONArray);
      return localJSONObject1;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("cmgame_process.CmGameOpenIdFinder", 1, "onIdentifierResp error", paramArrayList);
    }
    return localJSONObject1;
  }
  
  public static void a(long paramLong, int paramInt, String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      CmGameOpenIdFinder localCmGameOpenIdFinder = CmGameUtil.a(paramLong);
      if (localCmGameOpenIdFinder == null) {
        return;
      }
      Object localObject = localCmGameOpenIdFinder.b(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("type", paramInt);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString);
        localCmGameOpenIdFinder.a(2, localArrayList, null, 3, paramLong, true, ((JSONObject)localObject).toString(), "");
        return;
      }
      a(paramLong, paramInt, (String)localObject, paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameOpenIdFinder", 1, paramString, new Object[0]);
    }
  }
  
  public static void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putString("uin", paramString1);
    paramString1 = new CmGameOpenIdFinder.1(paramString2, paramLong);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_get_accountInfo", localBundle, paramString1);
  }
  
  private void a(String arg1, String paramString2)
  {
    if (!TextUtils.isEmpty(???))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(???);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      localObject = ((StringBuilder)localObject).toString();
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, paramString2);
        return;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return ("cs.join_room.local".equals(paramString)) || ("cs.get_dress_path.local".equals(paramString));
  }
  
  public String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (localConcurrentHashMap != null) {
        try
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            String str = ((String)((Map.Entry)localObject).getValue()).trim();
            if ((!TextUtils.isEmpty(str)) && (str.equals(paramString)))
            {
              localObject = (String)((Map.Entry)localObject).getKey();
              int i = ((String)localObject).indexOf("_");
              if (i != -1)
              {
                int j = i + 1;
                if (j < ((String)localObject).length())
                {
                  str = ((String)localObject).substring(j);
                  if (String.valueOf(this.jdField_a_of_type_Int).equals(str))
                  {
                    paramString = ((String)localObject).substring(0, i);
                    return paramString;
                  }
                }
              }
            }
          }
          return "";
        }
        finally {}
      }
    }
    return "";
  }
  
  /* Error */
  public void a(int paramInt1, ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1, int paramInt2, long paramLong, boolean paramBoolean, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +52 -> 55
    //   6: ldc 78
    //   8: iconst_2
    //   9: bipush 6
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 258
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload_1
    //   23: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: ldc_w 265
    //   32: aastore
    //   33: dup
    //   34: iconst_3
    //   35: iload 4
    //   37: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aastore
    //   41: dup
    //   42: iconst_4
    //   43: ldc_w 267
    //   46: aastore
    //   47: dup
    //   48: iconst_5
    //   49: aload 8
    //   51: aastore
    //   52: invokestatic 271	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   55: invokestatic 274	com/tencent/mobileqq/apollo/game/process/CmGameUtil:a	()Lcom/tencent/mobileqq/apollo/game/process/sso/CmGameSSoHandler;
    //   58: astore 10
    //   60: aload 10
    //   62: ifnonnull +13 -> 75
    //   65: ldc 78
    //   67: iconst_1
    //   68: ldc_w 276
    //   71: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: return
    //   75: new 40	org/json/JSONObject
    //   78: dup
    //   79: invokespecial 99	org/json/JSONObject:<init>	()V
    //   82: astore 11
    //   84: new 119	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   91: astore 12
    //   93: aload 12
    //   95: ldc_w 278
    //   98: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 12
    //   104: iload 4
    //   106: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 11
    //   112: ldc_w 280
    //   115: aload 12
    //   117: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   123: pop
    //   124: aload 11
    //   126: ldc 51
    //   128: aload_0
    //   129: getfield 26	com/tencent/mobileqq/apollo/game/process/data/CmGameOpenIdFinder:jdField_a_of_type_Int	I
    //   132: invokevirtual 135	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload 11
    //   138: ldc_w 282
    //   141: iload_1
    //   142: invokevirtual 135	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   145: pop
    //   146: iconst_2
    //   147: iload_1
    //   148: if_icmpne +67 -> 215
    //   151: aload_2
    //   152: ifnull +264 -> 416
    //   155: aload_2
    //   156: invokevirtual 105	java/util/ArrayList:size	()I
    //   159: ifne +4 -> 163
    //   162: return
    //   163: new 97	org/json/JSONArray
    //   166: dup
    //   167: invokespecial 98	org/json/JSONArray:<init>	()V
    //   170: astore_3
    //   171: aload_2
    //   172: invokevirtual 283	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   175: astore_2
    //   176: aload_2
    //   177: invokeinterface 222 1 0
    //   182: ifeq +20 -> 202
    //   185: aload_3
    //   186: aload_2
    //   187: invokeinterface 226 1 0
    //   192: checkcast 201	java/lang/String
    //   195: invokevirtual 117	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   198: pop
    //   199: goto -23 -> 176
    //   202: aload 11
    //   204: ldc_w 285
    //   207: aload_3
    //   208: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   211: pop
    //   212: goto +72 -> 284
    //   215: iconst_1
    //   216: iload_1
    //   217: if_icmpne +67 -> 284
    //   220: aload_3
    //   221: ifnull +196 -> 417
    //   224: aload_3
    //   225: invokevirtual 105	java/util/ArrayList:size	()I
    //   228: ifne +4 -> 232
    //   231: return
    //   232: new 97	org/json/JSONArray
    //   235: dup
    //   236: invokespecial 98	org/json/JSONArray:<init>	()V
    //   239: astore_2
    //   240: aload_3
    //   241: invokevirtual 283	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   244: astore_3
    //   245: aload_3
    //   246: invokeinterface 222 1 0
    //   251: ifeq +20 -> 271
    //   254: aload_2
    //   255: aload_3
    //   256: invokeinterface 226 1 0
    //   261: checkcast 287	java/lang/Long
    //   264: invokevirtual 117	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   267: pop
    //   268: goto -23 -> 245
    //   271: aload 11
    //   273: ldc_w 289
    //   276: aload_2
    //   277: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   280: pop
    //   281: goto +3 -> 284
    //   284: aload 11
    //   286: ldc_w 291
    //   289: iload 7
    //   291: invokevirtual 294	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   294: pop
    //   295: aload 11
    //   297: ldc_w 296
    //   300: lload 5
    //   302: invokevirtual 299	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   305: pop
    //   306: aload 8
    //   308: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   311: ifne +14 -> 325
    //   314: aload 11
    //   316: ldc_w 301
    //   319: aload 8
    //   321: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   324: pop
    //   325: aload 9
    //   327: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   330: ifne +65 -> 395
    //   333: aload 11
    //   335: ldc_w 303
    //   338: aload 9
    //   340: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   343: pop
    //   344: goto +51 -> 395
    //   347: astore_2
    //   348: goto +8 -> 356
    //   351: astore_2
    //   352: goto +4 -> 356
    //   355: astore_2
    //   356: aload_2
    //   357: invokevirtual 306	java/lang/Exception:printStackTrace	()V
    //   360: new 119	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   367: astore_3
    //   368: aload_3
    //   369: ldc_w 308
    //   372: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_3
    //   377: aload_2
    //   378: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   381: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: ldc 78
    //   387: iconst_1
    //   388: aload_3
    //   389: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 86	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload 10
    //   397: ldc_w 313
    //   400: aload 11
    //   402: invokevirtual 76	org/json/JSONObject:toString	()Ljava/lang/String;
    //   405: ldc2_w 314
    //   408: iload 4
    //   410: iconst_0
    //   411: aconst_null
    //   412: invokevirtual 320	com/tencent/mobileqq/apollo/game/process/sso/CmGameSSoHandler:a	(Ljava/lang/String;Ljava/lang/String;JIZ[B)V
    //   415: return
    //   416: return
    //   417: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	CmGameOpenIdFinder
    //   0	418	1	paramInt1	int
    //   0	418	2	paramArrayList	ArrayList<String>
    //   0	418	3	paramArrayList1	ArrayList<Long>
    //   0	418	4	paramInt2	int
    //   0	418	5	paramLong	long
    //   0	418	7	paramBoolean	boolean
    //   0	418	8	paramString1	String
    //   0	418	9	paramString2	String
    //   58	338	10	localCmGameSSoHandler	com.tencent.mobileqq.apollo.game.process.sso.CmGameSSoHandler
    //   82	319	11	localJSONObject	JSONObject
    //   91	25	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   124	146	347	java/lang/Exception
    //   155	162	347	java/lang/Exception
    //   163	176	347	java/lang/Exception
    //   176	199	347	java/lang/Exception
    //   202	212	347	java/lang/Exception
    //   224	231	347	java/lang/Exception
    //   232	245	347	java/lang/Exception
    //   245	268	347	java/lang/Exception
    //   271	281	347	java/lang/Exception
    //   284	325	347	java/lang/Exception
    //   325	344	347	java/lang/Exception
    //   102	124	351	java/lang/Exception
    //   84	102	355	java/lang/Exception
  }
  
  public void a(int paramInt1, ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1, int paramInt2, long paramLong, boolean paramBoolean, String paramString1, String paramString2, CmGameOpenIdFinder.OpenIdListener paramOpenIdListener)
  {
    a(paramInt1, paramArrayList, paramArrayList1, paramInt2, paramLong, paramBoolean, paramString1, paramString2);
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt2, new WeakReference(paramOpenIdListener));
  }
  
  public void a(@NonNull ArrayList<Long> paramArrayList, @NonNull ArrayList<String> paramArrayList1, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onIdentifierResp], tinyIds:");
      localStringBuilder.append(paramArrayList.toString());
      localStringBuilder.append(", identifiers:");
      QLog.d("cmgame_process.CmGameOpenIdFinder", 2, new Object[] { localStringBuilder.toString(), paramArrayList1.toString() });
    }
    if (paramArrayList.size() > 0)
    {
      if (paramArrayList1.size() <= 0) {
        return;
      }
      if (paramArrayList.size() != paramArrayList1.size()) {
        QLog.e("cmgame_process.CmGameOpenIdFinder", 2, "onIdentifierResp size is error");
      }
      paramArrayList = a(paramArrayList, paramArrayList1, paramInt);
      ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 0, "cs.audioRoom_update_userinfo.local", paramArrayList.toString());
    }
  }
  
  /* Error */
  public void a(JSONObject paramJSONObject, int paramInt, String paramString)
  {
    // Byte code:
    //   0: ldc_w 360
    //   3: astore 10
    //   5: ldc 156
    //   7: astore 15
    //   9: ldc 45
    //   11: astore 14
    //   13: ldc 68
    //   15: astore 13
    //   17: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +36 -> 56
    //   23: ldc 78
    //   25: iconst_2
    //   26: iconst_4
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: ldc_w 362
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: iload_2
    //   39: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: aastore
    //   43: dup
    //   44: iconst_2
    //   45: ldc_w 364
    //   48: aastore
    //   49: dup
    //   50: iconst_3
    //   51: aload_3
    //   52: aastore
    //   53: invokestatic 271	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   56: aload_1
    //   57: ifnonnull +4 -> 61
    //   60: return
    //   61: aload 10
    //   63: astore 12
    //   65: aload 14
    //   67: astore 11
    //   69: aload_1
    //   70: ldc_w 366
    //   73: invokevirtual 370	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   76: ldc_w 372
    //   79: invokevirtual 376	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   82: astore 16
    //   84: aload 10
    //   86: astore 12
    //   88: aload 14
    //   90: astore 11
    //   92: aload 16
    //   94: invokevirtual 377	org/json/JSONArray:length	()I
    //   97: istore 4
    //   99: iconst_0
    //   100: istore 5
    //   102: aload 14
    //   104: astore_1
    //   105: aload 16
    //   107: astore 14
    //   109: iload 5
    //   111: iload 4
    //   113: if_icmpge +397 -> 510
    //   116: aload 10
    //   118: astore 12
    //   120: aload_1
    //   121: astore 11
    //   123: aload 14
    //   125: iload 5
    //   127: invokevirtual 380	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   130: astore 17
    //   132: aload 10
    //   134: astore 12
    //   136: aload_1
    //   137: astore 11
    //   139: aload 17
    //   141: aload 13
    //   143: invokevirtual 383	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   146: ifeq +355 -> 501
    //   149: aload 10
    //   151: astore 12
    //   153: aload_1
    //   154: astore 11
    //   156: aload 17
    //   158: aload_1
    //   159: invokevirtual 383	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   162: ifeq +339 -> 501
    //   165: aload 10
    //   167: astore 12
    //   169: aload_1
    //   170: astore 11
    //   172: aload 17
    //   174: aload 13
    //   176: invokevirtual 386	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   179: astore 16
    //   181: aload 10
    //   183: astore 12
    //   185: aload_1
    //   186: astore 11
    //   188: aload 17
    //   190: aload_1
    //   191: invokevirtual 386	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   194: astore 18
    //   196: aload 10
    //   198: astore 12
    //   200: aload_1
    //   201: astore 11
    //   203: aload 18
    //   205: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   208: ifne +273 -> 481
    //   211: aload 10
    //   213: astore 12
    //   215: aload_1
    //   216: astore 11
    //   218: aload 16
    //   220: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   223: ifeq +6 -> 229
    //   226: goto +255 -> 481
    //   229: aload 10
    //   231: astore 12
    //   233: aload_1
    //   234: astore 11
    //   236: aload_0
    //   237: aload 18
    //   239: aload 16
    //   241: invokespecial 388	com/tencent/mobileqq/apollo/game/process/data/CmGameOpenIdFinder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 10
    //   246: astore 12
    //   248: aload_1
    //   249: astore 11
    //   251: new 40	org/json/JSONObject
    //   254: dup
    //   255: aload_3
    //   256: invokespecial 43	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   259: astore 17
    //   261: aload 10
    //   263: astore 12
    //   265: aload_1
    //   266: astore 11
    //   268: iload_2
    //   269: bipush 9
    //   271: if_icmpne +94 -> 365
    //   274: new 40	org/json/JSONObject
    //   277: dup
    //   278: aload 17
    //   280: ldc_w 301
    //   283: invokevirtual 49	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   286: invokespecial 43	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   289: astore 18
    //   291: aload 17
    //   293: ldc_w 291
    //   296: invokevirtual 391	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   299: istore 7
    //   301: aload 17
    //   303: ldc_w 296
    //   306: invokevirtual 395	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   309: lstore 8
    //   311: aload 17
    //   313: ldc_w 303
    //   316: invokevirtual 49	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   319: astore 17
    //   321: aload 18
    //   323: aload 13
    //   325: aload 16
    //   327: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   330: pop
    //   331: aload 18
    //   333: ldc 51
    //   335: aload_0
    //   336: getfield 26	com/tencent/mobileqq/apollo/game/process/data/CmGameOpenIdFinder:jdField_a_of_type_Int	I
    //   339: invokevirtual 135	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   342: pop
    //   343: invokestatic 351	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:getInstance	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel;
    //   346: lload 8
    //   348: aload 17
    //   350: aload 18
    //   352: invokevirtual 76	org/json/JSONObject:toString	()Ljava/lang/String;
    //   355: iload 7
    //   357: iconst_1
    //   358: invokevirtual 399	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:requestData	(JLjava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   361: pop
    //   362: goto +139 -> 501
    //   365: iload_2
    //   366: iconst_3
    //   367: if_icmpne +45 -> 412
    //   370: new 40	org/json/JSONObject
    //   373: dup
    //   374: aload 17
    //   376: ldc_w 301
    //   379: invokevirtual 49	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   382: invokespecial 43	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   385: ldc 149
    //   387: invokevirtual 55	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   390: istore 6
    //   392: aload 17
    //   394: ldc_w 296
    //   397: invokevirtual 395	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   400: iload 6
    //   402: aload 16
    //   404: aload 18
    //   406: invokestatic 162	com/tencent/mobileqq/apollo/game/process/data/CmGameOpenIdFinder:a	(JILjava/lang/String;Ljava/lang/String;)V
    //   409: goto +92 -> 501
    //   412: iload_2
    //   413: bipush 10
    //   415: if_icmpne +86 -> 501
    //   418: aload_0
    //   419: getfield 324	com/tencent/mobileqq/apollo/game/process/data/CmGameOpenIdFinder:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   422: ifnull +79 -> 501
    //   425: aload_0
    //   426: getfield 324	com/tencent/mobileqq/apollo/game/process/data/CmGameOpenIdFinder:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   429: iload_2
    //   430: invokevirtual 400	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   433: checkcast 329	java/lang/ref/WeakReference
    //   436: astore 17
    //   438: aload 17
    //   440: ifnull +61 -> 501
    //   443: aload 17
    //   445: invokevirtual 402	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   448: checkcast 404	com/tencent/mobileqq/apollo/game/process/data/CmGameOpenIdFinder$OpenIdListener
    //   451: astore 17
    //   453: aload 17
    //   455: ifnull +46 -> 501
    //   458: aload 17
    //   460: iconst_0
    //   461: ldc 156
    //   463: aload 16
    //   465: invokeinterface 407 4 0
    //   470: aload_0
    //   471: getfield 324	com/tencent/mobileqq/apollo/game/process/data/CmGameOpenIdFinder:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   474: iload_2
    //   475: invokevirtual 410	android/util/SparseArray:remove	(I)V
    //   478: goto +23 -> 501
    //   481: ldc 78
    //   483: iconst_1
    //   484: ldc_w 412
    //   487: invokestatic 86	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: goto +11 -> 501
    //   493: astore 12
    //   495: aload_1
    //   496: astore 11
    //   498: goto +23 -> 521
    //   501: iload 5
    //   503: iconst_1
    //   504: iadd
    //   505: istore 5
    //   507: goto -398 -> 109
    //   510: goto +55 -> 565
    //   513: astore_1
    //   514: aload 12
    //   516: astore 10
    //   518: aload_1
    //   519: astore 12
    //   521: aload 12
    //   523: invokevirtual 306	java/lang/Exception:printStackTrace	()V
    //   526: new 119	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   533: astore_1
    //   534: aload_1
    //   535: ldc_w 414
    //   538: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_1
    //   543: aload 12
    //   545: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   548: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: ldc 78
    //   554: iconst_1
    //   555: aload_1
    //   556: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 86	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: aload 11
    //   564: astore_1
    //   565: iconst_0
    //   566: istore 4
    //   568: iload_2
    //   569: bipush 8
    //   571: if_icmpne +304 -> 875
    //   574: aload_3
    //   575: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   578: ifeq +4 -> 582
    //   581: return
    //   582: new 40	org/json/JSONObject
    //   585: dup
    //   586: new 40	org/json/JSONObject
    //   589: dup
    //   590: aload_3
    //   591: invokespecial 43	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   594: ldc_w 301
    //   597: invokevirtual 49	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   600: invokespecial 43	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   603: astore 11
    //   605: aload 11
    //   607: ldc 132
    //   609: invokevirtual 383	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   612: ifeq +272 -> 884
    //   615: aload 11
    //   617: ldc 132
    //   619: invokevirtual 55	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   622: istore_2
    //   623: goto +3 -> 626
    //   626: aload 15
    //   628: astore_3
    //   629: aload 11
    //   631: ldc_w 416
    //   634: invokevirtual 383	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   637: ifeq +12 -> 649
    //   640: aload 11
    //   642: ldc_w 416
    //   645: invokevirtual 49	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   648: astore_3
    //   649: new 97	org/json/JSONArray
    //   652: dup
    //   653: aload_3
    //   654: invokespecial 417	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   657: astore 12
    //   659: aload 12
    //   661: invokevirtual 377	org/json/JSONArray:length	()I
    //   664: ifgt +4 -> 668
    //   667: return
    //   668: new 40	org/json/JSONObject
    //   671: dup
    //   672: invokespecial 99	org/json/JSONObject:<init>	()V
    //   675: astore 13
    //   677: new 97	org/json/JSONArray
    //   680: dup
    //   681: invokespecial 98	org/json/JSONArray:<init>	()V
    //   684: astore 14
    //   686: new 101	java/util/ArrayList
    //   689: dup
    //   690: invokespecial 150	java/util/ArrayList:<init>	()V
    //   693: astore_3
    //   694: iload 4
    //   696: aload 12
    //   698: invokevirtual 377	org/json/JSONArray:length	()I
    //   701: if_icmpge +76 -> 777
    //   704: new 40	org/json/JSONObject
    //   707: dup
    //   708: invokespecial 99	org/json/JSONObject:<init>	()V
    //   711: astore 15
    //   713: aload 12
    //   715: iload 4
    //   717: invokevirtual 418	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   720: invokevirtual 419	java/lang/Object:toString	()Ljava/lang/String;
    //   723: astore 16
    //   725: aload_0
    //   726: aload 16
    //   728: invokevirtual 421	com/tencent/mobileqq/apollo/game/process/data/CmGameOpenIdFinder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   731: astore 17
    //   733: aload 17
    //   735: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   738: ifeq +19 -> 757
    //   741: aload_3
    //   742: aload 16
    //   744: invokestatic 424	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   747: invokestatic 427	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   750: invokevirtual 154	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   753: pop
    //   754: goto +135 -> 889
    //   757: aload 15
    //   759: aload_1
    //   760: aload 17
    //   762: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   765: pop
    //   766: aload 14
    //   768: aload 15
    //   770: invokevirtual 117	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   773: pop
    //   774: goto +115 -> 889
    //   777: aload 13
    //   779: ldc 137
    //   781: aload 14
    //   783: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   786: pop
    //   787: aload 11
    //   789: aload 10
    //   791: invokevirtual 383	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   794: ifeq +81 -> 875
    //   797: aload 11
    //   799: aload 10
    //   801: invokevirtual 430	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   804: lstore 8
    //   806: aload 14
    //   808: invokevirtual 377	org/json/JSONArray:length	()I
    //   811: ifle +20 -> 831
    //   814: invokestatic 351	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:getInstance	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel;
    //   817: lload 8
    //   819: iconst_0
    //   820: ldc_w 353
    //   823: aload 13
    //   825: invokevirtual 76	org/json/JSONObject:toString	()Ljava/lang/String;
    //   828: invokevirtual 356	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:callbackFromRequest	(JILjava/lang/String;Ljava/lang/String;)V
    //   831: aload_3
    //   832: invokevirtual 105	java/util/ArrayList:size	()I
    //   835: ifle +40 -> 875
    //   838: iload_2
    //   839: iconst_3
    //   840: if_icmpne +35 -> 875
    //   843: invokestatic 274	com/tencent/mobileqq/apollo/game/process/CmGameUtil:a	()Lcom/tencent/mobileqq/apollo/game/process/sso/CmGameSSoHandler;
    //   846: astore_1
    //   847: aload_1
    //   848: ifnull +27 -> 875
    //   851: aload_1
    //   852: aload_3
    //   853: iload_2
    //   854: lload 8
    //   856: aload_0
    //   857: getfield 26	com/tencent/mobileqq/apollo/game/process/data/CmGameOpenIdFinder:jdField_a_of_type_Int	I
    //   860: invokevirtual 433	com/tencent/mobileqq/apollo/game/process/sso/CmGameSSoHandler:a	(Ljava/util/ArrayList;IJI)V
    //   863: return
    //   864: astore_1
    //   865: ldc 78
    //   867: iconst_1
    //   868: ldc_w 414
    //   871: aload_1
    //   872: invokestatic 142	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   875: return
    //   876: astore_1
    //   877: aload 12
    //   879: astore 10
    //   881: goto -363 -> 518
    //   884: iconst_0
    //   885: istore_2
    //   886: goto -260 -> 626
    //   889: iload 4
    //   891: iconst_1
    //   892: iadd
    //   893: istore 4
    //   895: goto -201 -> 694
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	898	0	this	CmGameOpenIdFinder
    //   0	898	1	paramJSONObject	JSONObject
    //   0	898	2	paramInt	int
    //   0	898	3	paramString	String
    //   97	797	4	i	int
    //   100	406	5	j	int
    //   390	11	6	k	int
    //   299	57	7	bool	boolean
    //   309	546	8	l	long
    //   3	877	10	localObject1	Object
    //   67	731	11	localObject2	Object
    //   63	201	12	localObject3	Object
    //   493	22	12	localException	Exception
    //   519	359	12	localObject4	Object
    //   15	809	13	localObject5	Object
    //   11	796	14	localObject6	Object
    //   7	762	15	localObject7	Object
    //   82	661	16	localObject8	Object
    //   130	631	17	localObject9	Object
    //   194	211	18	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   458	478	493	java/lang/Exception
    //   481	490	493	java/lang/Exception
    //   69	84	513	java/lang/Exception
    //   92	99	513	java/lang/Exception
    //   123	132	513	java/lang/Exception
    //   139	149	513	java/lang/Exception
    //   156	165	513	java/lang/Exception
    //   172	181	513	java/lang/Exception
    //   188	196	513	java/lang/Exception
    //   203	211	513	java/lang/Exception
    //   218	226	513	java/lang/Exception
    //   236	244	513	java/lang/Exception
    //   251	261	513	java/lang/Exception
    //   574	581	864	java/lang/Exception
    //   582	623	864	java/lang/Exception
    //   629	649	864	java/lang/Exception
    //   649	667	864	java/lang/Exception
    //   668	694	864	java/lang/Exception
    //   694	754	864	java/lang/Exception
    //   757	774	864	java/lang/Exception
    //   777	831	864	java/lang/Exception
    //   831	838	864	java/lang/Exception
    //   843	847	864	java/lang/Exception
    //   851	863	864	java/lang/Exception
    //   274	362	876	java/lang/Exception
    //   370	409	876	java/lang/Exception
    //   418	438	876	java/lang/Exception
    //   443	453	876	java/lang/Exception
  }
  
  public boolean a(long paramLong, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!a(paramString1)) {
      return false;
    }
    try
    {
      Object localObject = new JSONObject(paramString2);
      String str1 = ((JSONObject)localObject).optString("openId");
      boolean bool = TextUtils.isEmpty(str1);
      if (bool) {
        return false;
      }
      try
      {
        String str2 = b(str1);
        if (TextUtils.isEmpty(str2))
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).add(str1);
          a(2, (ArrayList)localObject, null, 9, paramLong, paramBoolean, paramString2, paramString1);
          return true;
        }
        ((JSONObject)localObject).put("uin", str2);
        return false;
      }
      catch (Throwable paramString1) {}
      QLog.e("cmgame_process.CmGameOpenIdFinder", 1, paramString1, new Object[0]);
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  public String b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      paramString = localStringBuilder.toString();
      return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameOpenIdFinder
 * JD-Core Version:    0.7.0.1
 */