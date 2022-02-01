package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.text.Html;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.MiniAppData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FastWebPTSDataConverter
{
  public static float a()
  {
    Object localObject = a();
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        localObject = ((JSONObject)localObject).getString(String.valueOf(4));
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          f1 = Float.valueOf((String)localObject).floatValue();
          float f2 = f1;
          if (f1 == -1.0F) {
            f2 = 3.3F;
          }
          return f2;
        }
      }
      catch (Exception localException)
      {
        QLog.d("FastWebPTSDataConverter", 1, "getTextBottomAdWeight error! msg=" + localException);
      }
      float f1 = -1.0F;
    }
  }
  
  public static float a(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 1, 2.0F);
  }
  
  private static float a(SparseArray<Float> paramSparseArray, int paramInt, float paramFloat)
  {
    Object localObject = paramSparseArray;
    if (paramSparseArray == null) {
      localObject = a();
    }
    float f = ((Float)((SparseArray)localObject).get(paramInt, Float.valueOf(-1.0F))).floatValue();
    QLog.d("FastWebPTSDataConverter", 1, "getWeight! moduleType=" + paramInt + "  defaultWeight=" + paramFloat);
    if (-1.0F == f) {
      return paramFloat;
    }
    return f;
  }
  
  public static float a(BaseData paramBaseData, boolean paramBoolean)
  {
    if (paramBaseData == null) {
      return -1000.0F;
    }
    if (paramBaseData.jdField_b_of_type_Float <= 0.0F) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (paramBaseData.jdField_b_of_type_Float = c(null);; paramBaseData.jdField_b_of_type_Float = a()) {
      return paramBaseData.jdField_b_of_type_Float;
    }
  }
  
  private static int a(JSONObject paramJSONObject, ModuleInfo paramModuleInfo)
  {
    int j = -1;
    int i = j;
    if (paramJSONObject != null)
    {
      i = j;
      if (paramModuleInfo == null) {}
    }
    try
    {
      paramModuleInfo.jdField_a_of_type_Int = Integer.parseInt(paramJSONObject.getString("moduleType"));
      paramModuleInfo.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
      i = paramModuleInfo.jdField_a_of_type_Int;
      return i;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebPTSDataConverter", 1, "updateModuleBean,error! msg" + paramJSONObject);
    }
    return -1;
  }
  
  public static SparseArray<Float> a()
  {
    localSparseArray = new SparseArray();
    try
    {
      JSONObject localJSONObject = a();
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = localJSONObject.getString(str1);
          try
          {
            localSparseArray.append(Integer.valueOf(str1).intValue(), Float.valueOf(str2));
          }
          catch (Exception localException2)
          {
            QLog.d("FastWebPTSDataConverter", 1, "getModuleWeight error!! msg" + localException2);
          }
        }
      }
      return localSparseArray;
    }
    catch (Exception localException1)
    {
      QLog.d("FastWebPTSDataConverter", 1, "getModuleWeight error! msg" + localException1);
    }
  }
  
  public static ProteusItemData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    boolean bool = RIJBiuAndCommentAladdinUtils.a();
    QLog.d("FastWebPTSDataConverter", 1, "createOperateAreaData | isCommentBiuMixStyle " + bool);
    if (bool) {
      b(localJSONObject, paramFastWebArticleInfo);
    }
    for (;;)
    {
      ModuleInfo localModuleInfo = (ModuleInfo)paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray.get(999);
      if (localModuleInfo != null) {
        a(localJSONObject, localModuleInfo.jdField_a_of_type_OrgJsonJSONObject);
      }
      return a(localJSONObject, paramArticleInfo, paramFastWebArticleInfo);
      a(localJSONObject, paramFastWebArticleInfo);
    }
  }
  
  /* Error */
  public static ProteusItemData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray)
  {
    // Byte code:
    //   0: new 24	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 161	org/json/JSONObject:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 192
    //   11: ldc 194
    //   13: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   16: pop
    //   17: aload_1
    //   18: aload_3
    //   19: invokestatic 201	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSDataConverter:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;Lorg/json/JSONObject;)V
    //   22: aload_3
    //   23: aload_0
    //   24: aload_1
    //   25: invokestatic 187	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSDataConverter:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   28: astore_0
    //   29: aload_0
    //   30: iconst_1
    //   31: putfield 206	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:x	I
    //   34: aload_0
    //   35: aload_2
    //   36: invokestatic 208	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSDataConverter:a	(Landroid/util/SparseArray;)F
    //   39: putfield 209	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:jdField_b_of_type_Float	F
    //   42: aload_0
    //   43: areturn
    //   44: astore_1
    //   45: aconst_null
    //   46: astore_0
    //   47: ldc 46
    //   49: iconst_1
    //   50: new 48	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   57: ldc 211
    //   59: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_0
    //   73: areturn
    //   74: astore_1
    //   75: goto -28 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramArticleInfo	ArticleInfo
    //   0	78	1	paramFastWebArticleInfo	FastWebArticleInfo
    //   0	78	2	paramSparseArray	SparseArray<Float>
    //   7	16	3	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   8	29	44	java/lang/Exception
    //   29	42	74	java/lang/Exception
  }
  
  /* Error */
  public static ProteusItemData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, int paramInt3, SparseArray<Float> paramSparseArray)
  {
    // Byte code:
    //   0: new 24	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 161	org/json/JSONObject:<init>	()V
    //   7: astore 11
    //   9: aload_2
    //   10: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +132 -> 145
    //   16: aload_3
    //   17: aload 6
    //   19: aload 7
    //   21: aload 8
    //   23: invokestatic 218	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebVideoItemUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_2
    //   27: aload 11
    //   29: aload_2
    //   30: aload_3
    //   31: iload 4
    //   33: iload 5
    //   35: aload 6
    //   37: aload 7
    //   39: aload 8
    //   41: iload 9
    //   43: invokestatic 221	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebVideoItemUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   46: aload 11
    //   48: aload_0
    //   49: aload_1
    //   50: invokestatic 187	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSDataConverter:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   53: astore_0
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 206	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:x	I
    //   59: aload_0
    //   60: aload 10
    //   62: invokestatic 208	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSDataConverter:a	(Landroid/util/SparseArray;)F
    //   65: putfield 209	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:jdField_b_of_type_Float	F
    //   68: aload_0
    //   69: iconst_3
    //   70: putfield 224	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:w	I
    //   73: aload_3
    //   74: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifne +27 -> 104
    //   80: aload 8
    //   82: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifne +19 -> 104
    //   88: aload 6
    //   90: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifne +11 -> 104
    //   96: aload 7
    //   98: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +8 -> 109
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield 228	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:e	Z
    //   109: aload_0
    //   110: areturn
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: ldc 46
    //   116: iconst_1
    //   117: new 48	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   124: ldc 230
    //   126: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_0
    //   140: areturn
    //   141: astore_1
    //   142: goto -28 -> 114
    //   145: goto -118 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramArticleInfo	ArticleInfo
    //   0	148	1	paramFastWebArticleInfo	FastWebArticleInfo
    //   0	148	2	paramString1	String
    //   0	148	3	paramString2	String
    //   0	148	4	paramInt1	int
    //   0	148	5	paramInt2	int
    //   0	148	6	paramString3	String
    //   0	148	7	paramString4	String
    //   0	148	8	paramString5	String
    //   0	148	9	paramInt3	int
    //   0	148	10	paramSparseArray	SparseArray<Float>
    //   7	40	11	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	27	111	java/lang/Exception
    //   27	54	111	java/lang/Exception
    //   54	104	141	java/lang/Exception
    //   104	109	141	java/lang/Exception
  }
  
  /* Error */
  static ProteusItemData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, String paramString1, String paramString2, String paramString3, SparseArray<Float> paramSparseArray)
  {
    // Byte code:
    //   0: new 24	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 161	org/json/JSONObject:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: aload_3
    //   12: aload 4
    //   14: ldc 234
    //   16: invokestatic 240	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   19: checkcast 234	com/tencent/biz/pubaccount/util/api/IPublicAccountHttpDownloader
    //   22: aload_2
    //   23: iconst_4
    //   24: aconst_null
    //   25: iconst_1
    //   26: invokeinterface 244 5 0
    //   31: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   34: invokestatic 252	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebImageItemUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   37: istore 6
    //   39: aload 7
    //   41: aload_0
    //   42: aload_1
    //   43: invokestatic 187	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSDataConverter:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   46: astore_0
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 206	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:x	I
    //   52: aload_0
    //   53: aload 5
    //   55: invokestatic 208	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSDataConverter:a	(Landroid/util/SparseArray;)F
    //   58: putfield 209	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:jdField_b_of_type_Float	F
    //   61: aload_0
    //   62: iconst_2
    //   63: putfield 224	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:w	I
    //   66: aload_0
    //   67: iload 6
    //   69: putfield 228	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:e	Z
    //   72: aload_0
    //   73: areturn
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_0
    //   77: ldc 46
    //   79: iconst_1
    //   80: new 48	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   87: ldc 254
    //   89: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_1
    //   93: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload_0
    //   103: areturn
    //   104: astore_1
    //   105: goto -28 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramArticleInfo	ArticleInfo
    //   0	108	1	paramFastWebArticleInfo	FastWebArticleInfo
    //   0	108	2	paramString1	String
    //   0	108	3	paramString2	String
    //   0	108	4	paramString3	String
    //   0	108	5	paramSparseArray	SparseArray<Float>
    //   37	31	6	bool	boolean
    //   7	33	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	47	74	java/lang/Exception
    //   47	72	104	java/lang/Exception
  }
  
  /* Error */
  public static ProteusItemData a(String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, SparseArray<Float> paramSparseArray)
  {
    // Byte code:
    //   0: new 24	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 161	org/json/JSONObject:<init>	()V
    //   7: astore 5
    //   9: iload_3
    //   10: tableswitch	default:+22 -> 32, 2:+109->119, 3:+102->112
    //   33: aconst_null
    //   34: iconst_m1
    //   35: astore_0
    //   36: aload 5
    //   38: ldc 192
    //   40: aload_0
    //   41: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   44: pop
    //   45: aload 5
    //   47: ldc_w 260
    //   50: iload_2
    //   51: invokestatic 22	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   54: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload 5
    //   60: ldc_w 262
    //   63: aload_1
    //   64: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload 5
    //   70: ldc_w 264
    //   73: invokestatic 267	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSUtils:a	()F
    //   76: invokestatic 270	java/lang/Float:toString	(F)Ljava/lang/String;
    //   79: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   82: pop
    //   83: aload 5
    //   85: aconst_null
    //   86: aconst_null
    //   87: invokestatic 187	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSDataConverter:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   90: astore_0
    //   91: aload_0
    //   92: aload 4
    //   94: invokestatic 208	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSDataConverter:a	(Landroid/util/SparseArray;)F
    //   97: putfield 209	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:jdField_b_of_type_Float	F
    //   100: aload_0
    //   101: iconst_1
    //   102: putfield 206	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:x	I
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield 224	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:w	I
    //   110: aload_0
    //   111: areturn
    //   112: ldc_w 272
    //   115: astore_0
    //   116: goto -80 -> 36
    //   119: ldc_w 274
    //   122: astore_0
    //   123: goto -87 -> 36
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_0
    //   129: ldc 46
    //   131: iconst_1
    //   132: new 48	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 276
    //   142: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: areturn
    //   157: astore_1
    //   158: goto -29 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramString	String
    //   0	161	1	paramCharSequence	CharSequence
    //   0	161	2	paramInt1	int
    //   0	161	3	paramInt2	int
    //   0	161	4	paramSparseArray	SparseArray<Float>
    //   7	77	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   36	91	126	java/lang/Exception
    //   91	110	157	java/lang/Exception
  }
  
  public static ProteusItemData a(String paramString1, String paramString2, SparseArray<Float> paramSparseArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("style_ID", "ReadInjoy_article_link_text_cell");
      localJSONObject.put("id_attribute_text", Html.fromHtml(paramString1));
      localJSONObject.put("jump_url", paramString2);
      localJSONObject.put("attribute_text_size", FastWebPTSUtils.a());
      paramString1 = a(localJSONObject, null, null);
      QLog.d("FastWebPTSDataConverter", 1, "createArticleLinkData error! msg=" + paramString2);
    }
    catch (Exception paramString2)
    {
      try
      {
        paramString1.jdField_b_of_type_Float = a(paramSparseArray);
        paramString1.x = 1;
        paramString1.w = 1;
        return paramString1;
      }
      catch (Exception paramString2)
      {
        break label81;
      }
      paramString2 = paramString2;
      paramString1 = null;
    }
    label81:
    return paramString1;
  }
  
  public static ProteusItemData a(JSONObject paramJSONObject, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ProteusItemData localProteusItemData = b(paramJSONObject, paramArticleInfo, paramFastWebArticleInfo);
    a(localProteusItemData, paramJSONObject, paramArticleInfo, paramFastWebArticleInfo);
    return localProteusItemData;
  }
  
  public static TemplateBean a(ArticleInfo paramArticleInfo)
  {
    try
    {
      if (a(paramArticleInfo))
      {
        paramArticleInfo = a(paramArticleInfo.mRecommendFollowInfos);
        return ProteusParser.getTemplateBean(TemplateFactory.a("native_article", true), paramArticleInfo);
      }
      QLog.d("FastWebPTSDataConverter", 1, "buildFollowWindowTemplateBean error! articleInfo=" + paramArticleInfo);
      return null;
    }
    catch (Exception paramArticleInfo)
    {
      QLog.d("FastWebPTSDataConverter", 1, "buildFollowWindowTemplateBean error! msg=" + paramArticleInfo);
    }
    return null;
  }
  
  private static String a(long paramLong)
  {
    String str = "";
    if (paramLong > 0L) {
      str = HardCodeUtil.a(2131716711) + ReadInJoyHelper.a(paramLong, 99990000L, "9999万+", "");
    }
    return str;
  }
  
  private static JSONObject a()
  {
    Object localObject1 = Aladdin.getConfig(242).getString("module_type_weight", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        QLog.d("FastWebPTSDataConverter", 1, "getAladdinWeightConfig! msg" + localObject1);
        return localObject1;
      }
      catch (Exception localException)
      {
        localObject2 = null;
        continue;
      }
      Object localObject2 = null;
    }
  }
  
  public static JSONObject a(RecommendFollowInfos paramRecommendFollowInfos)
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("style_ID", "ReadInjoy_follow_pack_cell");
      if (paramRecommendFollowInfos.b == 2) {
        localJSONObject.put("bgColor", "#00000000");
      }
      for (;;)
      {
        JSONArray localJSONArray = new JSONArray();
        a(paramRecommendFollowInfos, localJSONArray);
        localJSONObject.put("datas", localJSONArray);
        return localJSONObject;
        localJSONObject.put("bgColor", "#EEEEEE");
      }
      return localJSONObject;
    }
    catch (Exception paramRecommendFollowInfos)
    {
      QLog.d("FastWebPTSDataConverter", 1, "buildFollowWindowJSON error! msg=" + paramRecommendFollowInfos);
    }
  }
  
  private static JSONObject a(RecommendFollowInfos paramRecommendFollowInfos, RecommendFollowInfo paramRecommendFollowInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (paramRecommendFollowInfos.b == 2)
        {
          localJSONObject.put("style_ID", "RIJ_video_feeds_follow_cell");
          localJSONObject.put("author_name", paramRecommendFollowInfo.nickName);
          localJSONObject.put("author_desc", paramRecommendFollowInfo.recommendReason);
          if (paramRecommendFollowInfo.isFollowed)
          {
            paramRecommendFollowInfos = "1";
            localJSONObject.put("selected_status", paramRecommendFollowInfos);
            localJSONObject.put("avatar_uin", String.valueOf(paramRecommendFollowInfo.uin));
            localJSONObject.put("card_position", paramInt);
            return localJSONObject;
          }
        }
        else
        {
          localJSONObject.put("style_ID", "RIJ_follow_cell");
          continue;
        }
        paramRecommendFollowInfos = "0";
      }
      catch (Exception paramRecommendFollowInfos)
      {
        QLog.d("FastWebPTSDataConverter", 1, "buildFollowCardInfo error! msg=" + paramRecommendFollowInfos);
        return localJSONObject;
      }
    }
  }
  
  private static JSONObject a(ArticleTopicData.TopicInfo paramTopicInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("name", "a");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("href", paramTopicInfo.b + "#native_article_topic_tag");
    ((JSONObject)localObject).put("style", "color: #40A0FF;");
    localJSONObject1.put("attrs", localObject);
    localObject = new JSONArray();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("type", "text");
    localJSONObject2.put("text", paramTopicInfo.jdField_a_of_type_JavaLangString);
    ((JSONArray)localObject).put(localJSONObject2);
    localJSONObject1.put("children", localObject);
    return localJSONObject1;
  }
  
  private static JSONObject a(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("name", "text");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("style", "color: #262626;");
    localJSONObject1.put("attrs", localObject);
    localObject = new JSONArray();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("type", "text");
    localJSONObject2.put("text", paramString);
    ((JSONArray)localObject).put(localJSONObject2);
    localJSONObject1.put("children", localObject);
    return localJSONObject1;
  }
  
  public static void a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    String str = paramArticleInfo.getSubscribeUin();
    if (!TextUtils.isEmpty(str)) {
      a(paramArticleInfo, paramJSONObject, ReadInJoyUserInfoModule.a(Long.parseLong(str), null));
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramArticleInfo == null) || (paramJSONObject == null) || (paramReadInJoyUserInfo == null)) {}
    for (;;)
    {
      return;
      try
      {
        if (!TextUtils.isEmpty(paramReadInJoyUserInfo.authorizeDesc))
        {
          paramJSONObject.put("authorizeDesc", paramReadInJoyUserInfo.authorizeDesc);
          return;
        }
      }
      catch (JSONException paramArticleInfo)
      {
        QLog.d("FastWebPTSDataConverter", 1, "bindAuthorizeDesc error! msg=" + paramArticleInfo);
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if ((paramArticleInfo == null) || (paramJSONObject == null)) {
      return;
    }
    paramArticleInfo.bindShowFollowButton = false;
    a(paramJSONObject, paramBoolean, paramArticleInfo);
  }
  
  private static void a(RecommendFollowInfos paramRecommendFollowInfos, JSONArray paramJSONArray)
  {
    List localList = paramRecommendFollowInfos.a;
    if ((localList == null) || (paramJSONArray == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < localList.size())
      {
        paramJSONArray.put(a(paramRecommendFollowInfos, (RecommendFollowInfo)localList.get(i), i));
        i += 1;
      }
    }
  }
  
  private static void a(ProteusItemData paramProteusItemData, JSONObject paramJSONObject, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    try
    {
      paramProteusItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
      paramProteusItemData.a = paramFastWebArticleInfo;
      paramProteusItemData.b(paramJSONObject);
      paramProteusItemData.c();
      return;
    }
    catch (Exception paramProteusItemData)
    {
      QLog.d("FastWebPTSDataConverter", 1, "createCommonDynamicItem error! msg=" + paramProteusItemData);
    }
  }
  
  private static void a(FastWebArticleInfo paramFastWebArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramFastWebArticleInfo == null) || (paramJSONObject == null)) {}
    do
    {
      return;
      paramFastWebArticleInfo = a(paramFastWebArticleInfo.jdField_a_of_type_Long);
    } while (TextUtils.isEmpty(paramFastWebArticleInfo));
    try
    {
      paramJSONObject.put("read_count", paramFastWebArticleInfo);
      return;
    }
    catch (JSONException paramFastWebArticleInfo)
    {
      QLog.d("FastWebPTSDataConverter", 1, "updateReadCountItem error! msg=" + paramFastWebArticleInfo);
    }
  }
  
  public static void a(String paramString, SparseArray<ModuleInfo> paramSparseArray)
  {
    if ((paramString != null) && (paramSparseArray != null)) {
      try
      {
        ModuleInfo localModuleInfo = new ModuleInfo();
        JSONArray localJSONArray = new JSONArray(paramString);
        int i = 0;
        while (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.get(i);
          if ((localObject instanceof JSONObject))
          {
            int j = a((JSONObject)localObject, localModuleInfo);
            if (-1 != j) {
              paramSparseArray.append(j, localModuleInfo);
            }
          }
          i += 1;
        }
        QLog.d("FastWebPTSDataConverter", 1, "parsePTSData! msg" + paramString);
      }
      catch (Exception paramSparseArray)
      {
        QLog.d("FastWebPTSDataConverter", 1, "parsePTSData,error! msg" + paramSparseArray);
      }
    }
  }
  
  public static void a(List<BaseData> paramList, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, ItemShowDispatcher paramItemShowDispatcher, SparseArray<Float> paramSparseArray)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = localObject5;
    for (;;)
    {
      try
      {
        localJSONObject.put("style_ID", "Readinjoy_article_compact_interaction_cell");
        localObject2 = localObject5;
        if (!paramFastWebArticleInfo.jdField_a_of_type_Boolean) {
          continue;
        }
        localObject2 = localObject5;
        localJSONObject.put("dt_actionid", "click_like");
        localObject1 = "NativeArticleLikeEnable";
        localObject2 = localObject5;
        if (paramFastWebArticleInfo.jdField_a_of_type_Int <= 0) {
          continue;
        }
        localObject2 = localObject5;
        localJSONObject.put("interaction_like_count", FastWebDislikeUtils.a(paramFastWebArticleInfo.jdField_a_of_type_Int));
        localObject2 = localObject5;
        if (paramArticleInfo.mShareCount <= 0) {
          continue;
        }
        localObject2 = localObject5;
        localObject3 = FastWebDislikeUtils.b(paramArticleInfo.mShareCount);
      }
      catch (Exception localException)
      {
        Object localObject1;
        QLog.d("FastWebPTSDataConverter", 1, "insertDislikeData error! msg=" + localException);
        continue;
        localObject2 = localObject5;
        Object localObject3 = HardCodeUtil.a(2131715781);
        continue;
        a(localObject2, localJSONObject, paramArticleInfo, paramFastWebArticleInfo);
      }
      localObject2 = localObject5;
      localJSONObject.put("interaction_share_count", localObject3);
      localObject2 = localObject5;
      localJSONObject.put("like_normalstate_image", localObject1);
      localObject2 = localObject5;
      localJSONObject.put("dt_rowkey", paramFastWebArticleInfo.j);
      localObject2 = localObject5;
      localObject3 = paramList.iterator();
      localObject1 = localObject4;
      localObject2 = localObject5;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = localObject5;
        localObject1 = (BaseData)((Iterator)localObject3).next();
        localObject2 = localObject5;
        if ((localObject1 instanceof ProteusItemData))
        {
          localObject2 = localObject5;
          localObject1 = (ProteusItemData)localObject1;
          localObject2 = localObject5;
          if (((ProteusItemData)localObject1).x != 2) {}
        }
      }
      else
      {
        localObject2 = localObject1;
        localObject3 = (ModuleInfo)paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray.get(2);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          a(localJSONObject, ((ModuleInfo)localObject3).jdField_a_of_type_OrgJsonJSONObject);
          localObject2 = localObject1;
        }
        if (localObject2 != null) {
          continue;
        }
        paramArticleInfo = a(localJSONObject, paramArticleInfo, paramFastWebArticleInfo);
        paramArticleInfo.jdField_b_of_type_Float = d(paramSparseArray);
        paramArticleInfo.x = 2;
        ItemDatasListUtils.a(paramList, paramArticleInfo, paramItemShowDispatcher);
        return;
        localObject2 = localObject5;
        localJSONObject.put("dt_actionid", "cancel_like");
        localObject1 = "NativeArticleLikeDisable";
        continue;
        localObject2 = localObject5;
        localJSONObject.put("interaction_like_count", "喜欢");
      }
    }
  }
  
  public static void a(List<BaseData> paramList, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramList == null) || (paramFastWebArticleInfo == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        while (!paramList.hasNext()) {
          paramList = paramList.iterator();
        }
        localObject = (BaseData)paramList.next();
      } while (!(localObject instanceof ProteusItemData));
      localObject = (ProteusItemData)localObject;
    } while ((((ProteusItemData)localObject).c == null) || (!"ReadInjoy_article_read_count_cell".equalsIgnoreCase(((ProteusItemData)localObject).c.optString("style_ID"))));
    a(paramFastWebArticleInfo, ((ProteusItemData)localObject).c);
  }
  
  private static void a(JSONObject paramJSONObject, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramJSONObject == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("dt_rowkey", paramFastWebArticleInfo.j);
        if (paramFastWebArticleInfo.b())
        {
          paramJSONObject.put("style_ID", "ReadInjoy_article_operate_cell");
          if (!paramFastWebArticleInfo.jdField_a_of_type_Boolean) {
            break label218;
          }
          str = "NativeArticleLikeEnable";
          paramJSONObject.put("dt_like_actionid", "click_like");
          paramJSONObject.put("like_normalstate_image", str);
          if (!paramFastWebArticleInfo.a()) {
            break label236;
          }
          str = "NativeArticleCollectionEnable";
          paramJSONObject.put("collect_normalstate_image", str);
          if (paramFastWebArticleInfo.jdField_b_of_type_Long > 0L)
          {
            paramJSONObject.put("comment_count", ReadInJoyHelper.a(paramFastWebArticleInfo.jdField_b_of_type_Long, 99990000L, "9999万+", FastWebPTSConstans.jdField_a_of_type_JavaLangString));
            paramJSONObject.put("count_txt_color", "#FFFFFF");
            paramJSONObject.put("count_bg_color", "#FF4222");
          }
          QLog.d("FastWebPTSDataConverter", 2, "buildNormalCommentBiuOperationData | dynamicData :" + paramJSONObject.toString());
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.d("FastWebPTSDataConverter", 1, "createOperateAreaData error! msg=" + paramJSONObject.getMessage());
        return;
      }
      paramJSONObject.put("style_ID", "ReadInjoy_article_forbid_comment_operate_cell");
      continue;
      label218:
      String str = "NativeArticleLikeDisable";
      paramJSONObject.put("dt_like_actionid", "cancel_like");
      continue;
      label236:
      str = "NativeArticleCollectionDisable";
    }
  }
  
  private static void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {
      return;
    }
    Iterator localIterator = paramJSONObject2.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        paramJSONObject1.put(str, paramJSONObject2.getString(str));
      }
      catch (Exception localException) {}
    }
    QLog.d("FastWebPTSDataConverter", 1, "mergeJSONData! oriData=" + paramJSONObject1 + " mergeData=" + paramJSONObject2);
  }
  
  private static void a(JSONObject paramJSONObject, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    String str;
    if (paramBoolean) {
      str = "1";
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("selected_status", str);
        paramArticleInfo.bindShowFollowButton = true;
        int i;
        if (paramBoolean)
        {
          i = BaseArticleInfo.TYPE_FOLLOWED_BUTTON;
          paramArticleInfo.showFollowButtonType = i;
          if (paramBoolean)
          {
            paramArticleInfo = HardCodeUtil.a(2131716713);
            paramJSONObject.put("button_status", paramArticleInfo);
          }
        }
        else
        {
          i = BaseArticleInfo.TYPE_UNFOLLOW_BUTTON;
          continue;
        }
        paramArticleInfo = HardCodeUtil.a(2131716714);
        continue;
        str = "0";
      }
      catch (Exception paramJSONObject)
      {
        QLog.d("FastWebPTSDataConverter", 1, "addFollowInfo error! msg=" + paramJSONObject);
        return;
      }
    }
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArticleInfo != null)
    {
      bool1 = bool2;
      if (paramArticleInfo.mRecommendFollowInfos != null)
      {
        bool1 = bool2;
        if (!paramArticleInfo.mRecommendFollowInfos.a.isEmpty()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static float b(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 3, 3.7F);
  }
  
  /* Error */
  public static ProteusItemData b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray)
  {
    // Byte code:
    //   0: new 24	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 161	org/json/JSONObject:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 192
    //   11: ldc_w 667
    //   14: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   17: pop
    //   18: aload_1
    //   19: aload_3
    //   20: invokestatic 669	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSDataConverter:b	(Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;Lorg/json/JSONObject;)V
    //   23: aload_3
    //   24: aload_0
    //   25: aload_1
    //   26: invokestatic 187	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSDataConverter:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   29: astore_0
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield 206	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:x	I
    //   35: aload_0
    //   36: aload_2
    //   37: invokestatic 208	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebPTSDataConverter:a	(Landroid/util/SparseArray;)F
    //   40: ldc_w 670
    //   43: fadd
    //   44: putfield 209	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:jdField_b_of_type_Float	F
    //   47: aload_0
    //   48: areturn
    //   49: astore_1
    //   50: aconst_null
    //   51: astore_0
    //   52: ldc 46
    //   54: iconst_1
    //   55: new 48	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   62: ldc_w 672
    //   65: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 674	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: areturn
    //   80: astore_1
    //   81: goto -29 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramArticleInfo	ArticleInfo
    //   0	84	1	paramFastWebArticleInfo	FastWebArticleInfo
    //   0	84	2	paramSparseArray	SparseArray<Float>
    //   7	17	3	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   8	30	49	java/lang/Exception
    //   30	47	80	java/lang/Exception
  }
  
  private static ProteusItemData b(JSONObject paramJSONObject, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("mini_program_name"))))
    {
      paramArticleInfo = new MiniAppData(26);
      paramArticleInfo.b = paramJSONObject.optString("movie_name");
      paramArticleInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("mini_program_name");
      paramArticleInfo.c = paramJSONObject.optString("exRowkey");
      paramArticleInfo.jdField_a_of_type_Int = paramJSONObject.optInt("total_time");
      return paramArticleInfo;
    }
    return new ProteusItemData(26);
  }
  
  private static void b(FastWebArticleInfo paramFastWebArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramFastWebArticleInfo == null) || (paramJSONObject == null)) {}
    while ((paramFastWebArticleInfo.jdField_b_of_type_JavaUtilList == null) || (paramFastWebArticleInfo.jdField_b_of_type_JavaUtilList.size() <= 0)) {
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramFastWebArticleInfo.jdField_b_of_type_JavaUtilList.size())
        {
          localJSONArray.put(a((ArticleTopicData.TopicInfo)paramFastWebArticleInfo.jdField_b_of_type_JavaUtilList.get(i)));
          if (i != paramFastWebArticleInfo.jdField_b_of_type_JavaUtilList.size() - 1) {
            localJSONArray.put(a("  "));
          }
        }
        else
        {
          paramJSONObject.put("rich_text_info", localJSONArray);
          return;
        }
      }
      catch (JSONException paramFastWebArticleInfo)
      {
        QLog.e("FastWebPTSDataConverter", 1, "[insertTopicData] e = " + paramFastWebArticleInfo);
        return;
      }
      i += 1;
    }
  }
  
  private static void b(JSONObject paramJSONObject, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramJSONObject == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    try
    {
      paramJSONObject.put("dt_rowkey", paramFastWebArticleInfo.j);
      if (paramFastWebArticleInfo.b())
      {
        paramJSONObject.put("style_ID", "ReadInjoy_article_operate_cell");
        paramJSONObject.put("biu_text", RIJBiuAndCommentAladdinUtils.a());
        if (!paramFastWebArticleInfo.jdField_a_of_type_Boolean) {
          break label292;
        }
        str = "NativeArticleLikeEnable";
        paramJSONObject.put("dt_like_actionid", "click_like");
        label71:
        if (paramFastWebArticleInfo.jdField_a_of_type_Int > 0)
        {
          paramJSONObject.put("like_count", FastWebDislikeUtils.a(paramFastWebArticleInfo.jdField_a_of_type_Int));
          paramJSONObject.put("like_count_txt_color", "#262626");
        }
        paramJSONObject.put("like_normalstate_image", str);
        if (paramFastWebArticleInfo.c > 0L)
        {
          paramJSONObject.put("biu_count", ReadInJoyHelper.a(paramFastWebArticleInfo.c, 99990000L, "9999万+", "Biu"));
          paramJSONObject.put("biu_count_txt_color", "#262626");
        }
        if (paramFastWebArticleInfo.jdField_b_of_type_Long > 0L)
        {
          paramJSONObject.put("comment_count", ReadInJoyHelper.a(paramFastWebArticleInfo.jdField_b_of_type_Long, 99990000L, "9999万+", FastWebPTSConstans.jdField_a_of_type_JavaLangString));
          paramJSONObject.put("count_txt_color", "#FF4222");
        }
        QLog.d("FastWebPTSDataConverter", 2, "buildNewCommentBiuOperationData | dynamicData : " + paramJSONObject.toString());
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebPTSDataConverter", 1, "createOperateAreaData error! msg=" + paramJSONObject);
      return;
    }
    if (paramFastWebArticleInfo.a()) {}
    for (String str = "NativeArticleCollectionEnable";; str = "NativeArticleCollectionDisable")
    {
      paramJSONObject.put("collect_normalstate_image", str);
      paramJSONObject.put("style_ID", "ReadInjoy_article_forbid_comment_operate_cell");
      break;
      label292:
      str = "NativeArticleLikeDisable";
      paramJSONObject.put("dt_like_actionid", "cancel_like");
      break label71;
    }
  }
  
  public static float c(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 5, 7.0F);
  }
  
  public static float d(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 2, 3.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSDataConverter
 * JD-Core Version:    0.7.0.1
 */