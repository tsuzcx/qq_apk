package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ProteusItemDataBuilder;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.GridProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class ProteusSupportUtilDynamic
{
  private static final Map<Integer, ProteusItem> a = new HashMap();
  
  static
  {
    if (a.isEmpty())
    {
      a(0, new GridProteusItem());
      a(1, new GridProteusItem());
      a(2, new GridProteusItem());
    }
  }
  
  public static ProteusItemView a(VafContext paramVafContext, int paramInt, String paramString)
  {
    TraceUtils.traceBegin("ProteusSupportUtilDynamic.getView");
    Object localObject = null;
    paramString = a(paramVafContext, a(paramInt), paramString);
    Container localContainer = paramVafContext.getViewFactory().inflate(paramVafContext, paramString);
    paramString = localObject;
    if (localContainer != null)
    {
      localContainer.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841884));
      paramString = new ProteusItemView(paramVafContext.getContext());
      paramString.a(localContainer);
    }
    TraceUtils.traceEnd();
    return paramString;
  }
  
  /* Error */
  private static TemplateBean a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    // Byte code:
    //   0: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +37 -> 40
    //   6: ldc 103
    //   8: iconst_2
    //   9: new 105	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   16: ldc 108
    //   18: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc 117
    //   27: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_0
    //   31: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: getstatic 16	com/tencent/biz/pubaccount/readinjoy/dynamicfeeds/compat/ProteusSupportUtilDynamic:a	Ljava/util/Map;
    //   43: iload_0
    //   44: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokeinterface 138 2 0
    //   52: checkcast 140	com/tencent/biz/pubaccount/readinjoy/proteus/item/ProteusItem
    //   55: astore_3
    //   56: aload_3
    //   57: ifnonnull +13 -> 70
    //   60: ldc 103
    //   62: iconst_1
    //   63: ldc 142
    //   65: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aconst_null
    //   69: areturn
    //   70: aload_3
    //   71: iload_0
    //   72: aload_1
    //   73: invokeinterface 145 3 0
    //   78: astore 4
    //   80: aload_3
    //   81: iload_0
    //   82: aload 4
    //   84: invokeinterface 148 3 0
    //   89: astore_3
    //   90: aload_3
    //   91: astore_1
    //   92: aload_3
    //   93: ifnonnull +20 -> 113
    //   96: aload_2
    //   97: iconst_1
    //   98: invokestatic 153	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:a	(Ljava/lang/String;Z)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory;
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +12 -> 115
    //   106: aload_1
    //   107: aload 4
    //   109: invokevirtual 157	com/tencent/biz/pubaccount/readinjoy/view/proteus/factory/TemplateFactory:getTemplateBean	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   112: astore_1
    //   113: aload_1
    //   114: areturn
    //   115: aconst_null
    //   116: astore_1
    //   117: goto -4 -> 113
    //   120: astore_2
    //   121: aconst_null
    //   122: astore_1
    //   123: ldc 103
    //   125: iconst_2
    //   126: ldc 159
    //   128: aload_2
    //   129: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   132: goto -19 -> 113
    //   135: astore_2
    //   136: aconst_null
    //   137: astore_1
    //   138: ldc 103
    //   140: iconst_2
    //   141: ldc 165
    //   143: aload_2
    //   144: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   147: goto -34 -> 113
    //   150: astore_2
    //   151: aload_3
    //   152: astore_1
    //   153: goto -15 -> 138
    //   156: astore_2
    //   157: aload_3
    //   158: astore_1
    //   159: goto -36 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramInt	int
    //   0	162	1	paramBaseArticleInfo	BaseArticleInfo
    //   0	162	2	paramString	String
    //   55	103	3	localObject	Object
    //   78	30	4	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   40	56	120	org/json/JSONException
    //   60	68	120	org/json/JSONException
    //   70	90	120	org/json/JSONException
    //   40	56	135	java/lang/Exception
    //   60	68	135	java/lang/Exception
    //   70	90	135	java/lang/Exception
    //   96	102	150	java/lang/Exception
    //   106	113	150	java/lang/Exception
    //   96	102	156	org/json/JSONException
    //   106	113	156	org/json/JSONException
  }
  
  private static TemplateBean a(VafContext paramVafContext, String paramString1, String paramString2)
  {
    QLog.d("ProteusSupportUtilDynamic", 2, new Object[] { "getTemplateBean, styleID = ", paramString1 });
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder();
    TemplateFactory localTemplateFactory = (TemplateFactory)paramVafContext.getTemplateFactory();
    paramVafContext = localTemplateFactory;
    if (localTemplateFactory == null) {
      paramVafContext = TemplateFactory.a(paramString2, true);
    }
    if (paramVafContext != null) {}
    for (;;)
    {
      try
      {
        paramVafContext = paramVafContext.getTemplateBean(localProteusItemDataBuilder.a(paramString1).a());
        return paramVafContext;
      }
      catch (JSONException paramVafContext)
      {
        QLog.e("ProteusSupportUtilDynamic", 1, new Object[] { "getTemplateBean failed, styleID = ", paramString1, ", e = ", paramVafContext });
      }
      paramVafContext = null;
    }
    return null;
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "ReadInjoy_small_cell";
    case 0: 
    case 1: 
      return "ReadInjoy_small_cell";
    }
    return "ReadInjoy_large_cell";
  }
  
  private static void a(int paramInt, ProteusItem paramProteusItem)
  {
    if (paramProteusItem == null) {
      throw new NullPointerException();
    }
    a.put(Integer.valueOf(paramInt), paramProteusItem);
  }
  
  public static void a(ProteusItemView paramProteusItemView, int paramInt1, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, int paramInt2, String paramString)
  {
    TraceUtils.traceBegin("ProteusSupportUtilDynamic.bindData");
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null))
    {
      TraceUtils.traceEnd();
      if (QLog.isColorLevel()) {
        QLog.d("ProteusSupportUtilDynamic", 2, "bindData : " + paramBaseArticleInfo + " adapterViewType : " + paramInt1);
      }
      return;
    }
    TemplateBean localTemplateBean = paramProteusItemView.a();
    paramString = a(paramInt1, paramBaseArticleInfo, paramString);
    if ((localTemplateBean != null) && (paramString != null) && (!paramString.equals(localTemplateBean)))
    {
      Container localContainer = paramVafContext.getViewFactory().inflate(paramVafContext, paramString);
      if (localContainer != null)
      {
        localContainer.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841884));
        paramProteusItemView.c();
        paramProteusItemView.a(localContainer);
      }
      paramBaseArticleInfo.mProteusTemplateBean = paramString;
    }
    paramProteusItemView = paramProteusItemView.a();
    paramProteusItemView.setTag(2131376604, paramString);
    TraceUtils.traceBegin("ProteusSupportUtilDynamic.bindDataImpl");
    if (paramString != null) {
      ProteusSupportUtil.a(paramProteusItemView, localTemplateBean, paramString);
    }
    TraceUtils.traceEnd();
    ProteusSupportUtil.a(paramProteusItemView, paramVafContext, paramString);
    TraceUtils.traceEnd();
  }
  
  public static boolean a(int paramInt)
  {
    return a.containsKey(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ProteusSupportUtilDynamic
 * JD-Core Version:    0.7.0.1
 */