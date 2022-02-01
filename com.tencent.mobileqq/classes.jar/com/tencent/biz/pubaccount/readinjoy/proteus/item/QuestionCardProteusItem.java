package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ProteusItemDataBuilder;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.Util;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.BiuCommentView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.BindViewHelper;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.util.Pair;
import java.util.ArrayList;
import org.json.JSONObject;

public class QuestionCardProteusItem
  implements ProteusItem
{
  public static Pair<Boolean, String> a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        paramArticleInfo = "https://sqimg.qq.com/qq_product_operations/kan/images/super_wenda_default.png";
      }
      for (boolean bool = true;; bool = false)
      {
        Object localObject = paramArticleInfo;
        if (!TextUtils.isEmpty(paramArticleInfo))
        {
          localObject = paramArticleInfo;
          if (paramArticleInfo.contains("https")) {
            localObject = paramArticleInfo.replaceFirst("https", "http");
          }
        }
        return new Pair(Boolean.valueOf(bool), localObject);
        paramArticleInfo = ((SocializeFeedsInfo.UGCPicInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
      }
    }
    return null;
  }
  
  private void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramViewBase == null) || (paramIReadInJoyModel == null) || (paramIReadInJoyModel.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    paramViewBase.setOnClickListener(new QuestionCardProteusItem.2(this, paramViewBase.getContext(), paramIReadInJoyModel.a()));
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l = 0L;
    ProteusItemDataBuilder localProteusItemDataBuilder;
    if (paramInt == 75)
    {
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      localProteusItemDataBuilder = new ProteusItemDataBuilder();
      localProteusItemDataBuilder.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).p(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).m(paramBaseArticleInfo).x(paramBaseArticleInfo).C(paramBaseArticleInfo).A(paramBaseArticleInfo).E(paramBaseArticleInfo).B(paramBaseArticleInfo);
      if (paramInt != 75) {
        break label172;
      }
      localProteusItemDataBuilder.a("ReadInjoy_biu_small_pgc_cell").n(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").G(paramBaseArticleInfo);
    }
    for (;;)
    {
      return localProteusItemDataBuilder.a();
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) {
        break;
      }
      l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long;
      break;
      label172:
      localProteusItemDataBuilder.a("ReadInjoy_biu_small_pgc_cell").a(paramBaseArticleInfo, HardCodeUtil.a(2131711198));
    }
  }
  
  protected void a(int paramInt1, Context paramContext, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2)
  {
    paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.setOnClickListener(new QuestionCardProteusItem.1(this, paramIReadInJoyModel, paramContext, paramInt1));
    paramNativeMiddleBodyView.a(paramIReadInJoyModel);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    ReadInJoyMiddleBodyView localReadInJoyMiddleBodyView = (ReadInJoyMiddleBodyView)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    PgcSmallView localPgcSmallView;
    if (localReadInJoyMiddleBodyView != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localReadInJoyMiddleBodyView.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localPgcSmallView = new PgcSmallView(paramInt1, paramContainer.getContext());
        if ((localPgcSmallView == null) || (!(localPgcSmallView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label192;
        }
      }
    }
    label192:
    for (RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localPgcSmallView.getLayoutParams();; localLayoutParams = new RelativeLayout.LayoutParams(-2, -2))
    {
      localReadInJoyMiddleBodyView.a(localLayoutParams);
      if (localPgcSmallView != null) {
        localNativeMiddleBodyView.a(localPgcSmallView, localLayoutParams);
      }
      a(paramInt1, paramContainer.getContext(), paramIReadInJoyModel, localNativeMiddleBodyView, paramInt2);
      localReadInJoyMiddleBodyView.setVisibility(0);
      BindViewHelper.f(localViewBase, paramIReadInJoyModel);
      if (paramInt1 == 75)
      {
        paramContainer = (BiuCommentView)localViewBase.findViewBaseByName("id_biu_comment");
        if (paramContainer != null) {
          paramContainer.a(paramIReadInJoyModel);
        }
        Util.b(localViewBase, paramIReadInJoyModel);
      }
      BindViewHelper.a(localViewBase, paramIReadInJoyModel.a());
      Util.a(localViewBase, paramIReadInJoyModel);
      a(localViewBase, paramIReadInJoyModel);
      BindViewHelper.c(localViewBase, paramIReadInJoyModel);
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.QuestionCardProteusItem
 * JD-Core Version:    0.7.0.1
 */