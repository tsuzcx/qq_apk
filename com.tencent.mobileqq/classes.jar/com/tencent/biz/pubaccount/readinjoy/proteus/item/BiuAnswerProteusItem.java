package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ArticleInfoHelper;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ProteusItemDataBuilder;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.Util;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.BiuCommentView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.SummaryView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.BindViewHelper;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import com.tencent.mobileqq.app.HardCodeUtil;
import org.json.JSONObject;

public class BiuAnswerProteusItem
  implements ProteusItem
{
  private void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel, ViewBase.OnClickListener paramOnClickListener)
  {
    if ((paramViewBase == null) || (paramIReadInJoyModel == null) || (paramIReadInJoyModel.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase.setOnClickListener(paramOnClickListener);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l = 0L;
    if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
      l = paramBaseArticleInfo.mSocialFeedInfo.a.a;
    }
    JSONObject localJSONObject = new ProteusItemDataBuilder().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).n(paramBaseArticleInfo).m(paramBaseArticleInfo).o(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).D(paramBaseArticleInfo).C(paramBaseArticleInfo).G(paramBaseArticleInfo).a("ReadInjoy_biu_cell").E(paramBaseArticleInfo).s(paramBaseArticleInfo).I(paramBaseArticleInfo).a();
    if (!ArticleInfoHelper.a(paramBaseArticleInfo)) {
      AnswerProteusItem.a(paramBaseArticleInfo, HardCodeUtil.a(2131701229), localJSONObject);
    }
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (ReadInJoyMiddleBodyView)localViewBase.findViewBaseByName("id_middle_body_content");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (NativeMiddleBodyView)((ReadInJoyMiddleBodyView)localObject1).getNativeView();
      if ((localObject2 != null) && (((NativeMiddleBodyView)localObject2).a() == null))
      {
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        LinearLayout localLinearLayout = new LinearLayout(paramContainer.getContext());
        localLinearLayout.setOrientation(1);
        localLinearLayout.addView(new ComponentContentGridImage(paramContainer.getContext()));
        localLinearLayout.addView(new ComponentContentUgcImage(paramContainer.getContext()));
        ((ReadInJoyMiddleBodyView)localObject1).a((RelativeLayout.LayoutParams)localObject3);
        ((NativeMiddleBodyView)localObject2).a(localLinearLayout, (RelativeLayout.LayoutParams)localObject3);
      }
      if (localObject2 != null)
      {
        localObject1 = (ViewGroup)((NativeMiddleBodyView)localObject2).a();
        localObject2 = paramIReadInJoyModel.a();
        paramInt1 = AnswerProteusItem.a((ArticleInfo)localObject2);
        localObject2 = AnswerProteusItem.a((ArticleInfo)localObject2, paramInt1);
        if (paramInt1 != 0) {
          break label341;
        }
        ((ViewGroup)localObject1).setVisibility(8);
      }
    }
    BindViewHelper.f(localViewBase, paramIReadInJoyModel);
    localObject1 = (BiuCommentView)localViewBase.findViewBaseByName("id_biu_comment");
    if (localObject1 != null) {
      ((BiuCommentView)localObject1).a(paramIReadInJoyModel);
    }
    localObject1 = (SummaryView)localViewBase.findViewBaseByName("id_summary");
    paramContainer = new BiuAnswerProteusItem.2(this, paramIReadInJoyModel, paramContainer);
    if (localObject1 != null)
    {
      ((SummaryView)localObject1).a(paramIReadInJoyModel);
      ((NativeSummaryView)((SummaryView)localObject1).getNativeView()).setShouldCallClick(true);
      ((SummaryView)localObject1).setOnClickListener(paramContainer);
    }
    localObject1 = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((localObject1 != null) && (((NativeButton)localObject1).getNativeView() != null) && ((((NativeButton)localObject1).getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)((NativeButton)localObject1).getNativeView()).setTextColor(-1);
    }
    BindViewHelper.a(localViewBase, paramIReadInJoyModel.a());
    Util.a(localViewBase, paramIReadInJoyModel);
    a(localViewBase, paramIReadInJoyModel, paramContainer);
    Util.b(localViewBase, paramIReadInJoyModel);
    BindViewHelper.c(localViewBase, paramIReadInJoyModel);
    return;
    label341:
    ((ViewGroup)localObject1).setVisibility(0);
    Object localObject3 = (ComponentContentGridImage)((ViewGroup)localObject1).getChildAt(0);
    localObject1 = (ComponentContentUgcImage)((ViewGroup)localObject1).getChildAt(1);
    if (paramInt1 == 1)
    {
      ((ComponentContentGridImage)localObject3).setVisibility(8);
      ((ComponentContentUgcImage)localObject1).setVisibility(0);
      ((ComponentContentUgcImage)localObject1).a(paramIReadInJoyModel);
    }
    for (;;)
    {
      ((ComponentContentUgcImage)localObject1).setPicClickListener(new BiuAnswerProteusItem.1(this, paramIReadInJoyModel));
      break;
      ((ComponentContentGridImage)localObject3).setVisibility(0);
      ((ComponentContentGridImage)localObject3).setMIReadInJoyModel(paramIReadInJoyModel);
      ((ComponentContentUgcImage)localObject1).setVisibility(8);
      ((ComponentContentGridImage)localObject3).a(localObject2);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.BiuAnswerProteusItem
 * JD-Core Version:    0.7.0.1
 */