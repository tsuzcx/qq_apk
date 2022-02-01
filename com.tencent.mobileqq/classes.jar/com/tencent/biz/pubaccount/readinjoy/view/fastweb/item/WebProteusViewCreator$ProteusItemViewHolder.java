package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.KandianUGStatisticUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoReportUtil;
import com.tencent.biz.pubaccount.readinjoy.model.RIJWeChatVideoSeeLaterModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.MiniAppData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRecommendUGInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class WebProteusViewCreator$ProteusItemViewHolder
  extends BaseItemViewHolder
{
  private SparseArray<WebProteusViewCreator.ProteusItemViewOnClickListener> jdField_a_of_type_AndroidUtilSparseArray;
  private WebProteusViewCreator.ProteusItemViewOnClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebProteusViewCreator$ProteusItemViewOnClickListener;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  public WebProteusViewCreator$ProteusItemViewHolder(WebProteusViewCreator paramWebProteusViewCreator, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = ((Container)paramView);
    }
    b();
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener a()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.3(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener a(int paramInt)
  {
    WebProteusViewCreator.ProteusItemViewOnClickListener localProteusItemViewOnClickListener = (WebProteusViewCreator.ProteusItemViewOnClickListener)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localProteusItemViewOnClickListener != null) {
      return localProteusItemViewOnClickListener;
    }
    return k();
  }
  
  private String a(JSONObject paramJSONObject)
  {
    String str2 = "";
    String str1 = str2;
    if (paramJSONObject.opt("card_info") != null) {}
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("card_info");
      str1 = str2;
      if (paramJSONObject.opt("rowKey") != null) {
        str1 = paramJSONObject.getString("rowKey");
      }
      return str1;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return "";
  }
  
  private List<RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem> a(MiniAppData paramMiniAppData)
  {
    ArrayList localArrayList = new ArrayList();
    RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem localWeChatVideoArticleItem = new RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem();
    localWeChatVideoArticleItem.a = paramMiniAppData.c;
    localWeChatVideoArticleItem.b = paramMiniAppData.jdField_a_of_type_Int;
    localArrayList.add(localWeChatVideoArticleItem);
    return localArrayList;
  }
  
  private void a(Context paramContext, ProteusItemData paramProteusItemData)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new WebProteusViewCreator.ProteusItemViewHolder.1(this, paramContext, paramProteusItemData));
  }
  
  private void a(View paramView, BaseData paramBaseData)
  {
    if ((paramView == null) || (paramBaseData == null)) {}
    for (;;)
    {
      return;
      try
      {
        ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
        if (((ProteusItemData)paramBaseData).w == 1)
        {
          paramView.setOnLongClickListener(new WebProteusViewCreator.ProteusItemViewHolder.2(this, paramView, localProteusItemData));
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.d("WebProteusViewCreator", 1, "addLongClickListener error,msg:" + paramView.toString());
      }
    }
  }
  
  private void a(MiniAppData paramMiniAppData)
  {
    if (!paramMiniAppData.jdField_a_of_type_Boolean)
    {
      QLog.d("WebProteusViewCreator", 1, "requestWechatVideoSeelaterProgress: " + paramMiniAppData);
      paramMiniAppData.jdField_a_of_type_Boolean = true;
      ReadInJoyLogicEngine.a().a().a(a(paramMiniAppData));
      QQToast.a(BaseApplicationImpl.getApplication(), 0, HardCodeUtil.a(2131718616), 0).a();
      VideoReportUtil.a.a(paramMiniAppData.b, 0L, paramMiniAppData);
    }
  }
  
  private void a(ProteusItemData paramProteusItemData)
  {
    if (paramProteusItemData.c != null) {}
    try
    {
      paramProteusItemData = paramProteusItemData.c.optJSONObject("card_info");
      if (paramProteusItemData != null)
      {
        paramProteusItemData = paramProteusItemData.optString("rowKey");
        RIJFeedsDynamicInsertController.a.a(paramProteusItemData);
      }
      return;
    }
    catch (Exception paramProteusItemData)
    {
      QLog.d("WebProteusViewCreator", 1, paramProteusItemData.getMessage());
    }
  }
  
  /* Error */
  private void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    // Byte code:
    //   0: aload_3
    //   1: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:c	Lorg/json/JSONObject;
    //   4: astore 4
    //   6: aload_1
    //   7: invokevirtual 256	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getEventAttachedData	()Ljava/lang/String;
    //   10: astore 5
    //   12: aload_0
    //   13: aload 4
    //   15: invokespecial 258	com/tencent/biz/pubaccount/readinjoy/view/fastweb/item/WebProteusViewCreator$ProteusItemViewHolder:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   18: astore 6
    //   20: aload_0
    //   21: invokespecial 261	com/tencent/biz/pubaccount/readinjoy/view/fastweb/item/WebProteusViewCreator$ProteusItemViewHolder:a	()Z
    //   24: ifeq +17 -> 41
    //   27: aload_0
    //   28: aload_1
    //   29: aload_2
    //   30: aload_3
    //   31: aload 5
    //   33: aload 4
    //   35: aload 6
    //   37: invokespecial 264	com/tencent/biz/pubaccount/readinjoy/view/fastweb/item/WebProteusViewCreator$ProteusItemViewHolder:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   40: return
    //   41: new 266	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebRecommendUGInfo
    //   44: dup
    //   45: aload 4
    //   47: ldc_w 268
    //   50: invokevirtual 231	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: aload 6
    //   55: invokespecial 271	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebRecommendUGInfo:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: astore 5
    //   60: aload 5
    //   62: getfield 272	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebRecommendUGInfo:a	Ljava/lang/String;
    //   65: aload 6
    //   67: ldc_w 274
    //   70: invokestatic 279	com/tencent/biz/pubaccount/readinjoy/KandianUGStatisticUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: invokestatic 280	com/tencent/biz/pubaccount/readinjoy/KandianUGStatisticUtils:a	(Ljava/lang/String;)V
    //   76: invokestatic 285	com/tencent/open/appstore/dl/DownloadManagerV2:a	()Lcom/tencent/open/appstore/dl/DownloadManagerV2;
    //   79: aload 5
    //   81: getfield 287	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebRecommendUGInfo:b	Ljava/lang/String;
    //   84: invokevirtual 290	com/tencent/open/appstore/dl/DownloadManagerV2:b	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   87: astore 7
    //   89: aload 7
    //   91: ifnonnull +202 -> 293
    //   94: aload 5
    //   96: getfield 272	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebRecommendUGInfo:a	Ljava/lang/String;
    //   99: aload 6
    //   101: ldc_w 292
    //   104: invokestatic 279	com/tencent/biz/pubaccount/readinjoy/KandianUGStatisticUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 280	com/tencent/biz/pubaccount/readinjoy/KandianUGStatisticUtils:a	(Ljava/lang/String;)V
    //   110: aload 5
    //   112: getfield 272	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebRecommendUGInfo:a	Ljava/lang/String;
    //   115: aload 6
    //   117: ldc_w 294
    //   120: invokestatic 279	com/tencent/biz/pubaccount/readinjoy/KandianUGStatisticUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   123: invokestatic 280	com/tencent/biz/pubaccount/readinjoy/KandianUGStatisticUtils:a	(Ljava/lang/String;)V
    //   126: new 296	com/tencent/open/downloadnew/DownloadInfo
    //   129: dup
    //   130: invokespecial 297	com/tencent/open/downloadnew/DownloadInfo:<init>	()V
    //   133: astore 6
    //   135: aload 6
    //   137: aload 5
    //   139: getfield 287	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebRecommendUGInfo:b	Ljava/lang/String;
    //   142: putfield 299	com/tencent/open/downloadnew/DownloadInfo:d	Ljava/lang/String;
    //   145: aload 6
    //   147: ldc_w 301
    //   150: putfield 304	com/tencent/open/downloadnew/DownloadInfo:m	Ljava/lang/String;
    //   153: aload 6
    //   155: ldc_w 306
    //   158: putfield 309	com/tencent/open/downloadnew/DownloadInfo:e	Ljava/lang/String;
    //   161: invokestatic 285	com/tencent/open/appstore/dl/DownloadManagerV2:a	()Lcom/tencent/open/appstore/dl/DownloadManagerV2;
    //   164: aload 6
    //   166: invokevirtual 312	com/tencent/open/appstore/dl/DownloadManagerV2:b	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   169: aload 4
    //   171: ldc_w 314
    //   174: invokevirtual 68	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   177: astore 6
    //   179: aload 6
    //   181: ldc_w 316
    //   184: ldc_w 318
    //   187: invokevirtual 322	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload 6
    //   193: ldc_w 324
    //   196: iconst_0
    //   197: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   200: pop
    //   201: aload_0
    //   202: getfield 16	com/tencent/biz/pubaccount/readinjoy/view/fastweb/item/WebProteusViewCreator$ProteusItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebProteusViewCreator	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/WebProteusViewCreator;
    //   205: invokestatic 332	com/tencent/biz/pubaccount/readinjoy/view/fastweb/item/WebProteusViewCreator:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/WebProteusViewCreator;)Landroid/widget/BaseAdapter;
    //   208: ifnull +13 -> 221
    //   211: aload_0
    //   212: getfield 16	com/tencent/biz/pubaccount/readinjoy/view/fastweb/item/WebProteusViewCreator$ProteusItemViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebProteusViewCreator	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/WebProteusViewCreator;
    //   215: invokestatic 332	com/tencent/biz/pubaccount/readinjoy/view/fastweb/item/WebProteusViewCreator:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/WebProteusViewCreator;)Landroid/widget/BaseAdapter;
    //   218: invokevirtual 337	android/widget/BaseAdapter:notifyDataSetChanged	()V
    //   221: aload 5
    //   223: getfield 338	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebRecommendUGInfo:d	Ljava/lang/String;
    //   226: ifnull +25 -> 251
    //   229: aload 5
    //   231: getfield 338	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebRecommendUGInfo:d	Ljava/lang/String;
    //   234: astore 5
    //   236: aload_2
    //   237: ldc_w 340
    //   240: invokevirtual 345	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   243: checkcast 347	android/content/ClipboardManager
    //   246: aload 5
    //   248: invokevirtual 351	android/content/ClipboardManager:setText	(Ljava/lang/CharSequence;)V
    //   251: aload_3
    //   252: getfield 354	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:a	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   255: aload_1
    //   256: invokevirtual 357	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   259: invokestatic 362	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/ReportUtil:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Ljava/lang/String;)Lorg/json/JSONObject;
    //   262: astore_2
    //   263: aload_3
    //   264: instanceof 364
    //   267: ifeq +69 -> 336
    //   270: aload_1
    //   271: invokevirtual 357	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   274: aload_3
    //   275: checkcast 364	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData
    //   278: aload_2
    //   279: invokestatic 367	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/ReportUtil:a	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData;Lorg/json/JSONObject;)V
    //   282: return
    //   283: astore 6
    //   285: aload 6
    //   287: invokevirtual 77	org/json/JSONException:printStackTrace	()V
    //   290: goto -69 -> 221
    //   293: aload_0
    //   294: aload 7
    //   296: aload 4
    //   298: aload 6
    //   300: invokespecial 370	com/tencent/biz/pubaccount/readinjoy/view/fastweb/item/WebProteusViewCreator$ProteusItemViewHolder:a	(Lcom/tencent/open/downloadnew/DownloadInfo;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   303: goto -82 -> 221
    //   306: astore_2
    //   307: ldc 146
    //   309: iconst_1
    //   310: new 148	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 372
    //   320: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_2
    //   324: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 374	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: goto -82 -> 251
    //   336: aload_1
    //   337: invokevirtual 357	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   340: aload 4
    //   342: aload_2
    //   343: invokestatic 377	com/tencent/biz/pubaccount/readinjoy/view/fastweb/util/ReportUtil:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   346: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	ProteusItemViewHolder
    //   0	347	1	paramViewBase	ViewBase
    //   0	347	2	paramContext	Context
    //   0	347	3	paramProteusItemData	ProteusItemData
    //   4	337	4	localJSONObject	JSONObject
    //   10	237	5	localObject1	Object
    //   18	174	6	localObject2	Object
    //   283	16	6	localJSONException	JSONException
    //   87	208	7	localDownloadInfo	DownloadInfo
    // Exception table:
    //   from	to	target	type
    //   169	221	283	org/json/JSONException
    //   236	251	306	java/lang/Throwable
  }
  
  private void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    FastWebRecommendUGInfo localFastWebRecommendUGInfo = new FastWebRecommendUGInfo(paramJSONObject.optString("kd_ug_rsp_info"), paramString2);
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(localFastWebRecommendUGInfo.a, paramString2, "3"));
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(localFastWebRecommendUGInfo.a, paramString2, "7"));
    if (!TextUtils.isEmpty(localFastWebRecommendUGInfo.c))
    {
      paramString2 = new Intent();
      paramString2.setAction("android.intent.action.VIEW");
      paramString2.putExtra("big_brother_source_key", "biz_src_kandian_read");
      paramString2.setData(Uri.parse(localFastWebRecommendUGInfo.c));
      if (VideoFeedsHelper.a(paramContext, paramString2)) {
        paramContext.startActivity(paramString2);
      }
    }
    paramContext = ReportUtil.a(paramProteusItemData.a, paramViewBase.getName());
    if ((paramProteusItemData instanceof ProteusRecommendItemData)) {
      ReportUtil.a(paramViewBase.getName(), (ProteusRecommendItemData)paramProteusItemData, paramContext);
    }
    for (;;)
    {
      QLog.d("WebProteusViewCreator", 1, "onClick,schema=" + paramString1 + " viewID=" + paramViewBase.getName());
      return;
      ReportUtil.a(paramViewBase.getName(), paramJSONObject, paramContext);
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = paramJSONObject.getJSONObject("id_recommend_category_txt");
      paramJSONObject = new FastWebRecommendUGInfo(paramJSONObject.optString("kd_ug_rsp_info"), paramString);
      if (paramDownloadInfo.a() == 4)
      {
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(paramJSONObject.a, paramString, "20"));
        if (DownloadManagerV2.a().a(paramDownloadInfo)) {
          return;
        }
        DownloadManagerV2.a().b(paramDownloadInfo);
        return;
      }
      if (a(paramDownloadInfo.a()))
      {
        DownloadManagerV2.a().a(paramJSONObject.b);
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(paramJSONObject.a, paramString, "22"));
        return;
      }
    }
    catch (JSONException paramDownloadInfo)
    {
      paramDownloadInfo.printStackTrace();
      return;
    }
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(paramJSONObject.a, paramString, "10"));
    DownloadManagerV2.a().b(paramDownloadInfo);
    localJSONObject.put("text", paramJSONObject.h + paramDownloadInfo.f + "%");
    localJSONObject.put("label_ug_progress_progress", paramDownloadInfo.f);
    if (WebProteusViewCreator.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebProteusViewCreator) != null) {
      WebProteusViewCreator.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebProteusViewCreator).notifyDataSetChanged();
    }
  }
  
  private boolean a()
  {
    return !PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0");
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 30) || (paramInt == 10) || (paramInt == 20) || (paramInt == 1) || (paramInt == 2);
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramJSONObject != null)
    {
      Object localObject = paramJSONObject.optString("kd_ug_rsp_info");
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = new FastWebRecommendUGInfo((String)localObject, a(paramJSONObject));
        bool1 = bool2;
        if (paramJSONObject.opt("id_recommend_category_txt") != null)
        {
          bool1 = bool2;
          if (paramJSONObject.opt("kd_ug_download_url") != null)
          {
            bool1 = bool2;
            if (((FastWebRecommendUGInfo)localObject).c != null) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener b()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.4(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebProteusViewCreator$ProteusItemViewOnClickListener = null;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1012, b());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1023, c());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1002, d());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1001, e());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1161, f());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1157, g());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1160, h());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1173, i());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1039, i());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1041, j());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1201, a());
    k();
  }
  
  private void b(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    JSONObject localJSONObject = paramProteusItemData.c;
    String str2 = paramViewBase.getEventAttachedData();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = RIJJumpUtils.a(str2, localJSONObject);
      RIJJumpUtils.a(paramContext, str1);
    }
    paramContext = ReportUtil.a(paramProteusItemData.a, paramViewBase.getName());
    if ((paramProteusItemData instanceof ProteusRecommendItemData)) {
      ReportUtil.a(paramViewBase.getName(), (ProteusRecommendItemData)paramProteusItemData, paramContext);
    }
    for (;;)
    {
      QLog.d("WebProteusViewCreator", 1, "[defaultUrlJump], schema = " + str1 + ", viewID = " + paramViewBase.getName());
      return;
      ReportUtil.a(paramViewBase.getName(), localJSONObject, paramContext);
    }
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener c()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.5(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener d()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.6(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener e()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.7(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener f()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.8(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener g()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.9(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener h()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.10(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener i()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.11(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener j()
  {
    return new WebProteusViewCreator.ProteusItemViewHolder.12(this);
  }
  
  private WebProteusViewCreator.ProteusItemViewOnClickListener k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebProteusViewCreator$ProteusItemViewOnClickListener == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebProteusViewCreator$ProteusItemViewOnClickListener = new WebProteusViewCreator.ProteusItemViewHolder.13(this);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebProteusViewCreator$ProteusItemViewOnClickListener;
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null) || (paramBaseData2 == null)) {}
    while (!(paramBaseData2 instanceof ProteusItemData)) {
      return;
    }
    paramBaseData1 = (ProteusItemData)paramBaseData2;
    TemplateBean localTemplateBean = paramBaseData1.a;
    if (localTemplateBean != null) {
      WebProteusViewCreator.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebProteusViewCreator, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
    }
    try
    {
      localTemplateBean.bindData(paramBaseData1.c);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramBaseData1.a.getViewBean());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData1;
      QLog.d("WebProteusViewCreator", 1, "bindWebProteusViewCreator: " + paramBaseData1.c);
      a(WebProteusViewCreator.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebProteusViewCreator), paramBaseData1);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, paramBaseData2);
      if ((paramBaseData2 instanceof ProteusAnimationItemData)) {
        ((ProteusAnimationItemData)paramBaseData2).a(this.jdField_a_of_type_AndroidViewView);
      }
      a((ProteusItemData)paramBaseData2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("WebProteusViewCreator", 1, QLog.getStackTraceString(localException));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder
 * JD-Core Version:    0.7.0.1
 */