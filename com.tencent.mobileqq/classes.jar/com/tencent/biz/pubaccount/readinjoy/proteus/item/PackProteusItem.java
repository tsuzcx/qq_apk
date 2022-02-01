package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ProteusItemDataBuilder;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.Util;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.BindViewHelper;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericPullAnimatorView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PackProteusItem
  implements ProteusItem
{
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {}
    switch (paramBaseArticleInfo.mNewPolymericInfo.a)
    {
    default: 
      if (!RIJFeedsType.b(paramBaseArticleInfo)) {
        break;
      }
    }
    while ((RIJFeedsType.d(paramBaseArticleInfo)) || (paramBaseArticleInfo.mSinglePicture != null))
    {
      return 2;
      return 1;
    }
    return 0;
  }
  
  private ProteusItemDataBuilder a(ProteusItemDataBuilder paramProteusItemDataBuilder, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramProteusItemDataBuilder;
    int i;
    if (paramBaseArticleInfo != null)
    {
      localObject = paramProteusItemDataBuilder;
      if (paramBaseArticleInfo.mGroupSubArticleList != null)
      {
        localObject = paramProteusItemDataBuilder;
        if (paramBaseArticleInfo.mGroupSubArticleList.size() > 0)
        {
          QLog.d("PackProteusItem", 2, "mGroupSubArticleList: " + paramBaseArticleInfo.mGroupSubArticleList.size());
          localObject = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0);
          i = a((BaseArticleInfo)localObject);
          localObject = a((ArticleInfo)localObject, paramInt);
        }
      }
    }
    try
    {
      paramProteusItemDataBuilder.a("jump_url", localObject);
      if (i == 1)
      {
        localObject = b(paramProteusItemDataBuilder, paramInt, paramBaseArticleInfo);
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      do
      {
        for (;;)
        {
          QLog.e("PackProteusItem", 1, "[buildProteusCollectionView], e = " + localJSONException);
        }
        ProteusItemDataBuilder localProteusItemDataBuilder = paramProteusItemDataBuilder;
      } while (i != 2);
    }
    return c(paramProteusItemDataBuilder, paramInt, paramBaseArticleInfo);
  }
  
  private String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null)
    {
      QLog.i("PackProteusItem", 1, "[getJumpUrl], articleInfo is null.");
      return "";
    }
    Object localObject3 = "";
    long l2 = 0L;
    long l1;
    Object localObject1;
    if ((RIJItemViewType.a(paramArticleInfo)) || (RIJItemViewType.h(paramArticleInfo)) || (paramInt == 77) || (paramInt == 78))
    {
      l1 = l2;
      localObject1 = localObject3;
      if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {}
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramArticleInfo.mSubscribeID);
        localObject1 = ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(l1).getBytes(), 2);
        l2 = l1;
        localObject3 = localObject1;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(paramArticleInfo.mSubscribeID))) {
          break label376;
        }
        try
        {
          l2 = Long.parseLong(paramArticleInfo.mSubscribeID);
          l1 = l2;
        }
        catch (NumberFormatException paramArticleInfo)
        {
          QLog.i("PackProteusItem", 1, "[getJumpUrl], e = " + paramArticleInfo);
          continue;
        }
        localObject3 = ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(l1).getBytes(), 2);
        l2 = l1;
        QLog.i("PackProteusItem", 1, "[getJumpUlr], url = " + (String)localObject3 + ", uin = " + l2);
        return localObject3;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.i("PackProteusItem", 1, "[getJumpUrl], e = " + localNumberFormatException);
        l1 = l2;
        continue;
      }
      Object localObject2;
      if (!RIJItemViewType.g(paramArticleInfo))
      {
        l1 = l2;
        localObject2 = localObject3;
        if (paramInt != 76) {}
      }
      else
      {
        l1 = l2;
        localObject2 = localObject3;
        if (paramArticleInfo.mSocialFeedInfo != null)
        {
          l1 = l2;
          localObject2 = localObject3;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null)
          {
            l1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a;
            localObject2 = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(l1).getBytes(), 2);
            continue;
            label376:
            if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null))
            {
              l2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a;
              localObject3 = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(l2).getBytes(), 2);
            }
            else
            {
              l2 = l1;
              localObject3 = localObject2;
              if (paramArticleInfo.mSocialFeedInfo != null)
              {
                l2 = l1;
                localObject3 = localObject2;
                if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null)
                {
                  l2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a;
                  localObject3 = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(l2).getBytes(), 2);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, Context paramContext, ComponentPolymericView paramComponentPolymericView)
  {
    if (paramIReadInJoyModel.e() == 56)
    {
      paramComponentPolymericView.setDividerWidth(AIOUtils.a(3.0F, paramContext.getResources()));
      paramComponentPolymericView.setPadding(DisplayUtil.a(paramContext, 6.0F), 0, DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 5.0F));
    }
    for (;;)
    {
      paramComponentPolymericView.setClipToPadding(false);
      paramComponentPolymericView.setClipChildren(false);
      return;
      paramComponentPolymericView.setDividerWidth(AIOUtils.a(3.0F, paramContext.getResources()));
      if (RIJFeedsType.m(paramIReadInJoyModel.a())) {
        paramComponentPolymericView.setPadding(DisplayUtil.a(paramContext, 6.0F), 0, DisplayUtil.a(paramContext, 12.0F), DisplayUtil.a(paramContext, 2.0F));
      } else {
        paramComponentPolymericView.setPadding(DisplayUtil.a(paramContext, 6.0F), 0, DisplayUtil.a(paramContext, 12.0F), 0);
      }
    }
  }
  
  private void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramViewBase == null) || (paramIReadInJoyModel == null) || (paramIReadInJoyModel.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_topic_avator");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    Context localContext = paramViewBase.getContext();
    paramViewBase.setOnClickListener(new PackProteusItem.1(this, paramIReadInJoyModel.a(), localContext));
  }
  
  private void a(ViewBase paramViewBase, ArticleInfo paramArticleInfo, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramArticleInfo == null) || (paramViewBase == null) || (paramIReadInJoyModel == null))
    {
      QLog.i("PackProteusItem", 1, "[bindItemClickListener], articleInfo or parent is null.");
      return;
    }
    paramViewBase = (RvPolymericContainer)paramViewBase.findViewBaseByName("id_proteus_collection_view");
    if (paramViewBase == null)
    {
      QLog.i("PackProteusItem", 1, "[bindItemClickListener], proteus_collection_view is null.");
      return;
    }
    List localList = paramArticleInfo.mGroupSubArticleList;
    if ((localList == null) || (localList.isEmpty()))
    {
      QLog.i("PackProteusItem", 1, "[bindItemClickListener], dataList is empty");
      return;
    }
    paramViewBase.a(new PackProteusItem.2(this, localList, paramArticleInfo, paramIReadInJoyModel));
  }
  
  private ProteusItemDataBuilder b(ProteusItemDataBuilder paramProteusItemDataBuilder, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Util.a(paramBaseArticleInfo, paramInt, localJSONArray);
      paramProteusItemDataBuilder.a("datas", localJSONArray);
      return paramProteusItemDataBuilder;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("PackProteusItem", 2, paramBaseArticleInfo.getMessage());
    }
    return paramProteusItemDataBuilder;
  }
  
  private ProteusItemDataBuilder c(ProteusItemDataBuilder paramProteusItemDataBuilder, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Util.b(paramBaseArticleInfo, paramInt, localJSONArray);
      paramProteusItemDataBuilder.a("datas", localJSONArray);
      return paramProteusItemDataBuilder;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("PackProteusItem", 2, paramBaseArticleInfo.getMessage());
    }
    return paramProteusItemDataBuilder;
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder();
    if (paramBaseArticleInfo == null)
    {
      QLog.e("PackProteusItem", 2, "newpolymeric getDataJson info = null");
      return null;
    }
    long l1 = 0L;
    if (paramInt == 79) {
      return localProteusItemDataBuilder.c(paramBaseArticleInfo).j(paramBaseArticleInfo).r(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_topic_cell").a();
    }
    if ((RIJFeedsType.o(paramBaseArticleInfo)) || (RIJFeedsType.p(paramBaseArticleInfo))) {
      return localProteusItemDataBuilder.r(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_cell").a();
    }
    long l2;
    if (paramInt == 76)
    {
      l2 = l1;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        l2 = l1;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null) {
          l2 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a;
        }
      }
      paramBaseArticleInfo = a(localProteusItemDataBuilder, paramInt, paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l2).g(paramBaseArticleInfo).f(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_cell").a();
      QLog.d("PackProteusItem", 2, "result is " + paramBaseArticleInfo);
      return paramBaseArticleInfo;
    }
    if ((paramInt == 77) || (paramInt == 78))
    {
      try
      {
        l2 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("PackProteusItem", 2, "newpolymeric card pgc parse uin error uin = " + 0L + " error = " + localNumberFormatException);
        }
      }
      paramBaseArticleInfo = a(localProteusItemDataBuilder, paramInt, paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).g(paramBaseArticleInfo).d(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).z(paramBaseArticleInfo).a("ReadInjoy_pack_cell").a();
      QLog.d("PackProteusItem", 2, "result is " + paramBaseArticleInfo);
      return paramBaseArticleInfo;
    }
    QLog.e("PackProteusItem", 2, "newpolymeric card wrong articleinfo and viewType articleinfo = " + paramBaseArticleInfo);
    return null;
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (ReadInJoyMiddleBodyView)localViewBase.findViewBaseByName("id_middle_body_content");
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = (NativeMiddleBodyView)((ReadInJoyMiddleBodyView)localObject1).getNativeView();
      if (((NativeMiddleBodyView)localObject2).a() == null)
      {
        localObject3 = new ComponentPolymericPullAnimatorView(paramContainer.getContext(), paramIReadInJoyModel);
        if ((localObject3 == null) || (!(((View)localObject3).getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label199;
        }
        localObject1 = (RelativeLayout.LayoutParams)((View)localObject3).getLayoutParams();
        if (localObject3 != null)
        {
          a(paramIReadInJoyModel, paramContainer.getContext(), ((ComponentPolymericPullAnimatorView)localObject3).a());
          ((NativeMiddleBodyView)localObject2).a((View)localObject3, (RelativeLayout.LayoutParams)localObject1);
        }
      }
      a(paramIReadInJoyModel, (NativeMiddleBodyView)localObject2);
    }
    else
    {
      localObject1 = paramIReadInJoyModel.a();
      if (RIJFeedsType.u((BaseArticleInfo)localObject1)) {
        break label214;
      }
      BindViewHelper.f(localViewBase, paramIReadInJoyModel);
      BindViewHelper.a(localViewBase, paramIReadInJoyModel.a());
      if (paramInt1 == 76) {
        Util.a(localViewBase, paramIReadInJoyModel);
      }
    }
    for (;;)
    {
      paramContainer = localViewBase.findViewBaseByName("id_proteus_collection_view");
      if ((paramContainer instanceof RvPolymericContainer)) {
        ((RvPolymericContainer)paramContainer).a(paramIReadInJoyModel);
      }
      a(localViewBase, (ArticleInfo)localObject1, paramIReadInJoyModel);
      return;
      label199:
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      break;
      label214:
      a(localViewBase, paramIReadInJoyModel);
      localObject2 = (NativeText)localViewBase.findViewBaseByName("id_topic_recommend_biu_time");
      if ((localObject2 != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a.size() > 0))
      {
        localObject3 = (TopicRecommendFeedsInfo.TopicRecommendInfo)((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a.get(0);
        ((NativeText)localObject2).setText(String.format(paramContainer.getContext().getString(2131718399), new Object[] { ReadInJoyHelper.b(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject3).b) }));
        if (QLog.isColorLevel()) {
          QLog.d("PackProteusItem", 2, "PackProteusItem update articleInfo UI articleID = " + ((ArticleInfo)localObject1).mArticleID + ", mRecommendSeq =" + ((ArticleInfo)localObject1).mRecommendSeq + "，followType=" + ((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject3).c);
        }
      }
    }
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramIReadInJoyModel.a() == null)) {
      return;
    }
    paramNativeMiddleBodyView = (ComponentPolymericPullAnimatorView)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a().a(paramIReadInJoyModel);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PackProteusItem
 * JD-Core Version:    0.7.0.1
 */