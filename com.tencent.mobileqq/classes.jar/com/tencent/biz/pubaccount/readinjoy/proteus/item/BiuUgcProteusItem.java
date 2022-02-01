package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ProteusItemDataBuilder;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.Util;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.RIJBiuCardUtil;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.BiuCommentView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.SummaryView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.BindViewHelper;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUGCVoice;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import org.json.JSONObject;

public class BiuUgcProteusItem
  implements ProteusItem
{
  private void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramViewBase == null) || (paramIReadInJoyModel == null) || (paramIReadInJoyModel.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    Context localContext = paramViewBase.getContext();
    paramViewBase.setOnClickListener(new BiuUgcProteusItem.1(this, paramIReadInJoyModel.a(), localContext));
  }
  
  protected View a(int paramInt, Context paramContext)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 25: 
    case 81: 
      return new ComponentContentUgcImage(paramContext);
    case 37: 
      return new ComponentContentGridImage(paramContext);
    case 26: 
      return new ComponentContentUgcVideo(paramContext);
    }
    return new ComponentContentUGCVoice(paramContext);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.a.a;
      }
    }
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).n(paramBaseArticleInfo).m(paramBaseArticleInfo).C(paramBaseArticleInfo).o(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).y(paramBaseArticleInfo).A(paramBaseArticleInfo).D(paramBaseArticleInfo).G(paramBaseArticleInfo).E(paramBaseArticleInfo).B(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).F(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo).O(paramBaseArticleInfo).P(paramBaseArticleInfo);
    if (RIJBiuCardUtil.a((ArticleInfo)paramBaseArticleInfo)) {
      localProteusItemDataBuilder.a("RIJ_biu_small_single_img_cell");
    }
    for (;;)
    {
      return localProteusItemDataBuilder.a();
      localProteusItemDataBuilder.a("RIJ_biu_cell");
    }
  }
  
  protected void a(int paramInt, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramIReadInJoyModel.a() == null)) {
      return;
    }
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = paramIReadInJoyModel.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 25: 
    case 81: 
      ((ComponentContentUgcImage)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
      return;
    case 37: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setMIReadInJoyModel(paramIReadInJoyModel);
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramIReadInJoyModel.a()));
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setOnNoItemClickListener(new BiuUgcProteusItem.2(this, paramIReadInJoyModel, localReadInJoyBaseAdapter));
      return;
    case 26: 
      paramNativeMiddleBodyView = (ComponentContentUgcVideo)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(paramIReadInJoyModel);
      ((ComponentContentUgcVideo)paramNativeMiddleBodyView).setOnClickListener(new BiuUgcProteusItem.3(this, paramIReadInJoyModel, localReadInJoyBaseAdapter));
      return;
    }
    ((ComponentContentUGCVoice)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    ReadInJoyMiddleBodyView localReadInJoyMiddleBodyView = (ReadInJoyMiddleBodyView)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localReadInJoyMiddleBodyView != null)
    {
      NativeMiddleBodyView localNativeMiddleBodyView = (NativeMiddleBodyView)localReadInJoyMiddleBodyView.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localReadInJoyMiddleBodyView.a(localLayoutParams);
        paramContainer = a(paramInt1, paramContainer.getContext());
        if (paramContainer != null) {
          localNativeMiddleBodyView.a(paramContainer, localLayoutParams);
        }
      }
      a(paramInt1, paramIReadInJoyModel, localNativeMiddleBodyView);
    }
    BindViewHelper.f(localViewBase, paramIReadInJoyModel);
    paramContainer = (BiuCommentView)localViewBase.findViewBaseByName("id_biu_comment");
    if (paramContainer != null) {
      paramContainer.a(paramIReadInJoyModel);
    }
    paramContainer = (SummaryView)localViewBase.findViewBaseByName("id_summary");
    if (paramContainer != null) {
      paramContainer.a(paramIReadInJoyModel);
    }
    paramContainer = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)paramContainer.getNativeView()).setTextColor(-1);
    }
    BindViewHelper.a(localViewBase, paramIReadInJoyModel.a());
    Util.a(localViewBase, paramIReadInJoyModel);
    a(localViewBase, paramIReadInJoyModel);
    Util.b(localViewBase, paramIReadInJoyModel);
    BindViewHelper.b(localViewBase, paramIReadInJoyModel);
    BindViewHelper.c(localViewBase, paramIReadInJoyModel);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.BiuUgcProteusItem
 * JD-Core Version:    0.7.0.1
 */