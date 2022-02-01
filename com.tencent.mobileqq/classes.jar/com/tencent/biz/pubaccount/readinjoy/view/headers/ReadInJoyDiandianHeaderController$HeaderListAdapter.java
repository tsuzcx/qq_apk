package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyDiandianHeaderController$HeaderListAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private List<DiandianTopConfig> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  ReadInJoyDiandianHeaderController$HeaderListAdapter(List<DiandianTopConfig> paramList, int paramInt)
  {
    this.jdField_a_of_type_Int = i;
    int j = i * 2;
    int i = j;
    while ((i < paramInt.size()) && (i < j + 2))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramInt.get(i));
      i += 1;
    }
  }
  
  public Object a(int paramInt, DiandianTopConfig paramDiandianTopConfig)
  {
    return this.jdField_a_of_type_JavaUtilList.set(paramInt, paramDiandianTopConfig);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  /* Error */
  public android.view.View getView(int paramInt, android.view.View paramView, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$HeaderListAdapter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: iload_1
    //   5: invokeinterface 33 2 0
    //   10: checkcast 57	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig
    //   13: astore 5
    //   15: aload_2
    //   16: ifnonnull +424 -> 440
    //   19: new 59	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder
    //   22: dup
    //   23: aconst_null
    //   24: invokespecial 62	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$1;)V
    //   27: astore 4
    //   29: aload_3
    //   30: invokevirtual 68	android/view/ViewGroup:getContext	()Landroid/content/Context;
    //   33: invokestatic 74	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   36: ldc 75
    //   38: aconst_null
    //   39: invokevirtual 79	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   42: astore_2
    //   43: aload 4
    //   45: aload_2
    //   46: ldc 80
    //   48: invokevirtual 86	android/view/View:findViewById	(I)Landroid/view/View;
    //   51: checkcast 88	com/tencent/image/URLImageView
    //   54: putfield 91	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   57: aload 4
    //   59: aload_2
    //   60: ldc 92
    //   62: invokevirtual 86	android/view/View:findViewById	(I)Landroid/view/View;
    //   65: checkcast 94	android/widget/TextView
    //   68: putfield 97	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   71: aload 4
    //   73: aload_2
    //   74: ldc 98
    //   76: invokevirtual 86	android/view/View:findViewById	(I)Landroid/view/View;
    //   79: checkcast 94	android/widget/TextView
    //   82: putfield 101	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:b	Landroid/widget/TextView;
    //   85: aload 4
    //   87: aload_2
    //   88: ldc 102
    //   90: invokevirtual 86	android/view/View:findViewById	(I)Landroid/view/View;
    //   93: checkcast 94	android/widget/TextView
    //   96: putfield 105	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:c	Landroid/widget/TextView;
    //   99: aload 4
    //   101: new 107	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$OnItemViewClickListener
    //   104: dup
    //   105: aload_0
    //   106: getfield 13	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$HeaderListAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   109: aconst_null
    //   110: invokespecial 110	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$OnItemViewClickListener:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$1;)V
    //   113: putfield 113	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$OnItemViewClickListener	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$OnItemViewClickListener;
    //   116: aload_2
    //   117: aload 4
    //   119: invokevirtual 117	android/view/View:setTag	(Ljava/lang/Object;)V
    //   122: aload_2
    //   123: aload 4
    //   125: getfield 113	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$OnItemViewClickListener	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$OnItemViewClickListener;
    //   128: invokevirtual 121	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   131: aload 4
    //   133: getfield 113	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController$OnItemViewClickListener	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$OnItemViewClickListener;
    //   136: aload_0
    //   137: getfield 23	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$HeaderListAdapter:jdField_a_of_type_Int	I
    //   140: iconst_2
    //   141: imul
    //   142: iload_1
    //   143: iadd
    //   144: putfield 122	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$OnItemViewClickListener:jdField_a_of_type_Int	I
    //   147: invokestatic 128	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   150: astore 6
    //   152: aload 6
    //   154: aload_0
    //   155: getfield 13	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$HeaderListAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   158: getfield 133	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:a	Landroid/graphics/drawable/ColorDrawable;
    //   161: putfield 137	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   164: aload 6
    //   166: aload_0
    //   167: getfield 13	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$HeaderListAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   170: getfield 133	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:a	Landroid/graphics/drawable/ColorDrawable;
    //   173: putfield 140	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   176: aload 6
    //   178: iconst_1
    //   179: putfield 144	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   182: aload 5
    //   184: getfield 148	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:picUrl	Ljava/lang/String;
    //   187: aload 6
    //   189: invokestatic 154	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   192: astore 6
    //   194: aload 6
    //   196: aload_2
    //   197: invokevirtual 155	android/view/View:getContext	()Landroid/content/Context;
    //   200: ldc 156
    //   202: invokestatic 161	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   205: aload_2
    //   206: invokevirtual 155	android/view/View:getContext	()Landroid/content/Context;
    //   209: ldc 156
    //   211: invokestatic 161	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   214: invokestatic 166	com/tencent/mobileqq/urldrawable/URLDrawableDecodeHandler:a	(II)[I
    //   217: invokevirtual 167	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   220: aload 4
    //   222: getfield 91	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   225: aload 6
    //   227: invokevirtual 171	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   230: aload 6
    //   232: invokevirtual 174	com/tencent/image/URLDrawable:getStatus	()I
    //   235: iconst_1
    //   236: if_icmpeq +16 -> 252
    //   239: aload 6
    //   241: invokevirtual 174	com/tencent/image/URLDrawable:getStatus	()I
    //   244: ifeq +8 -> 252
    //   247: aload 6
    //   249: invokevirtual 177	com/tencent/image/URLDrawable:restartDownload	()V
    //   252: aload 5
    //   254: getfield 180	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:type	I
    //   257: iconst_3
    //   258: if_icmpne +194 -> 452
    //   261: aload 4
    //   263: getfield 97	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   266: iconst_0
    //   267: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
    //   270: aload 4
    //   272: getfield 101	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:b	Landroid/widget/TextView;
    //   275: aload 5
    //   277: getfield 187	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:title	Ljava/lang/String;
    //   280: invokevirtual 191	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   283: aload 5
    //   285: getfield 194	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitleColor	Ljava/lang/String;
    //   288: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   291: ifne +244 -> 535
    //   294: aload 4
    //   296: getfield 105	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:c	Landroid/widget/TextView;
    //   299: aload 5
    //   301: getfield 194	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitleColor	Ljava/lang/String;
    //   304: invokestatic 206	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   307: invokevirtual 209	android/widget/TextView:setTextColor	(I)V
    //   310: aload 4
    //   312: getfield 105	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:c	Landroid/widget/TextView;
    //   315: aload 5
    //   317: getfield 212	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitle	Ljava/lang/String;
    //   320: invokevirtual 191	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   323: aload_0
    //   324: getfield 13	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$HeaderListAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   327: invokestatic 215	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:b	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;)Z
    //   330: ifne +94 -> 424
    //   333: new 217	org/json/JSONObject
    //   336: dup
    //   337: invokespecial 218	org/json/JSONObject:<init>	()V
    //   340: astore 4
    //   342: aload 4
    //   344: ldc 220
    //   346: getstatic 223	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/push/RIJKanDianFolderStatus:jdField_a_of_type_Int	I
    //   349: invokevirtual 227	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   352: pop
    //   353: ldc 229
    //   355: invokestatic 235	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   358: checkcast 229	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   361: aconst_null
    //   362: ldc 237
    //   364: ldc 239
    //   366: ldc 239
    //   368: iconst_0
    //   369: iconst_0
    //   370: new 241	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   377: aload_0
    //   378: getfield 13	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$HeaderListAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   381: invokestatic 245	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:b	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;)Ljava/util/List;
    //   384: invokeinterface 29 1 0
    //   389: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: ldc 237
    //   394: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: ldc 237
    //   402: ldc 237
    //   404: aload 4
    //   406: invokevirtual 257	org/json/JSONObject:toString	()Ljava/lang/String;
    //   409: iconst_0
    //   410: invokeinterface 261 12 0
    //   415: aload_0
    //   416: getfield 13	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$HeaderListAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController	Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;
    //   419: iconst_1
    //   420: invokestatic 264	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController;Z)Z
    //   423: pop
    //   424: invokestatic 270	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   427: iload_1
    //   428: aload_2
    //   429: aload_3
    //   430: aload_0
    //   431: iload_1
    //   432: invokevirtual 272	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$HeaderListAdapter:getItemId	(I)J
    //   435: invokevirtual 276	com/tencent/qqlive/module/videoreport/collect/EventCollector:onListGetView	(ILandroid/view/View;Landroid/view/ViewGroup;J)V
    //   438: aload_2
    //   439: areturn
    //   440: aload_2
    //   441: invokevirtual 280	android/view/View:getTag	()Ljava/lang/Object;
    //   444: checkcast 59	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder
    //   447: astore 4
    //   449: goto -318 -> 131
    //   452: aload 4
    //   454: getfield 97	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   457: bipush 8
    //   459: invokevirtual 184	android/widget/TextView:setVisibility	(I)V
    //   462: goto -192 -> 270
    //   465: astore 6
    //   467: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   470: ifeq +48 -> 518
    //   473: ldc_w 288
    //   476: iconst_2
    //   477: new 241	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   484: ldc_w 290
    //   487: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 5
    //   492: getfield 194	com/tencent/biz/pubaccount/readinjoy/model/DiandianTopConfig:subTitleColor	Ljava/lang/String;
    //   495: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: ldc_w 292
    //   501: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload 6
    //   506: invokevirtual 293	java/lang/Exception:toString	()Ljava/lang/String;
    //   509: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: aload 4
    //   520: getfield 105	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:c	Landroid/widget/TextView;
    //   523: ldc_w 299
    //   526: invokestatic 206	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   529: invokevirtual 209	android/widget/TextView:setTextColor	(I)V
    //   532: goto -222 -> 310
    //   535: aload 4
    //   537: getfield 105	com/tencent/biz/pubaccount/readinjoy/view/headers/ReadInJoyDiandianHeaderController$ViewHolder:c	Landroid/widget/TextView;
    //   540: ldc_w 299
    //   543: invokestatic 206	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   546: invokevirtual 209	android/widget/TextView:setTextColor	(I)V
    //   549: goto -239 -> 310
    //   552: astore 4
    //   554: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq -133 -> 424
    //   560: ldc_w 288
    //   563: iconst_2
    //   564: aload 4
    //   566: invokevirtual 300	org/json/JSONException:toString	()Ljava/lang/String;
    //   569: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   572: goto -148 -> 424
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	this	HeaderListAdapter
    //   0	575	1	paramInt	int
    //   0	575	2	paramView	android.view.View
    //   0	575	3	paramViewGroup	android.view.ViewGroup
    //   27	509	4	localObject1	Object
    //   552	13	4	localJSONException	org.json.JSONException
    //   13	478	5	localDiandianTopConfig	DiandianTopConfig
    //   150	98	6	localObject2	Object
    //   465	40	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   294	310	465	java/lang/Exception
    //   333	424	552	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.HeaderListAdapter
 * JD-Core Version:    0.7.0.1
 */