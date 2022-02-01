package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ArticleInfoHelper;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ProteusItemDataBuilder;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.Util;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ArticleCommentView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.BindViewHelper;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.Model;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage.Model.Builder;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView.PicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class AnswerProteusItem
  implements ProteusItem
{
  public static int a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList != null)) {
      return paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public static ComponentContentGridImage.Model a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 0) {
      return new ComponentContentGridImage.Model.Builder().a();
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    SocializeFeedsInfo.UGCPicInfo localUGCPicInfo;
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList != null) && (paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.size() >= 1))
    {
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (paramArticleInfo.hasNext()) {
        localUGCPicInfo = (SocializeFeedsInfo.UGCPicInfo)paramArticleInfo.next();
      }
    }
    for (;;)
    {
      try
      {
        int i = localArrayList1.size();
        if (i == paramInt) {
          return new ComponentContentGridImage.Model.Builder().a(localArrayList1).b(localArrayList2).a();
        }
        i = localUGCPicInfo.a;
        int j = localUGCPicInfo.jdField_b_of_type_Int;
        URL localURL = new URL(localUGCPicInfo.jdField_c_of_type_JavaLangString);
        if (localUGCPicInfo.jdField_c_of_type_Int != 1) {
          break label270;
        }
        bool = true;
        localArrayList1.add(new SquareCornerTextImageView.PicInfo(i, j, localURL, bool));
        localArrayList2.add(new URL(localUGCPicInfo.jdField_b_of_type_JavaLangString));
      }
      catch (MalformedURLException localMalformedURLException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AnswerProteusItem", 2, "Malformed URL: " + localMalformedURLException.getMessage());
      break;
      label270:
      boolean bool = false;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramBaseArticleInfo.mSocialFeedInfo.j == 1)
    {
      if (bool) {
        break label61;
      }
      paramBaseArticleInfo = new JSONObject();
      paramBaseArticleInfo.put("read_article", paramString);
      paramJSONObject.put("id_read_article", paramBaseArticleInfo);
      paramJSONObject.put("id_read_article_wrapper", new JSONObject());
    }
    label61:
    while (!QLog.isColorLevel())
    {
      return;
      bool = false;
      break;
    }
    QLog.i("AnswerProteusItem", 2, "bindReadArticle isDeleted +" + bool);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l = 0L;
    if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
      l = paramBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Long;
    }
    JSONObject localJSONObject = new ProteusItemDataBuilder().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).p(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).A(paramBaseArticleInfo).B(paramBaseArticleInfo).D(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_original_cell").E(paramBaseArticleInfo).I(paramBaseArticleInfo).a(paramBaseArticleInfo, HardCodeUtil.a(2131700351)).a();
    if (!ArticleInfoHelper.a(paramBaseArticleInfo)) {
      a(paramBaseArticleInfo, HardCodeUtil.a(2131700350), localJSONObject);
    }
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (ReadInJoyMiddleBodyView)localViewBase.findViewBaseByName("id_middle_body_content");
    AnswerProteusItem.1 local1 = new AnswerProteusItem.1(this, paramIReadInJoyModel, paramContainer);
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
        paramContainer = (ViewGroup)((NativeMiddleBodyView)localObject2).a();
        localObject2 = paramIReadInJoyModel.a();
        paramInt1 = a((ArticleInfo)localObject2);
        localObject2 = a((ArticleInfo)localObject2, paramInt1);
        if (paramInt1 != 0) {
          break label313;
        }
        paramContainer.setVisibility(8);
        ((ReadInJoyMiddleBodyView)localObject1).setOnClickListener(local1);
      }
    }
    BindViewHelper.a(localViewBase, paramIReadInJoyModel.a());
    BindViewHelper.f(localViewBase, paramIReadInJoyModel);
    paramContainer = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)paramContainer.getNativeView()).setTextColor(-1);
    }
    paramContainer = (ArticleCommentView)localViewBase.findViewBaseByName("id_article_comment");
    if (paramContainer != null)
    {
      localObject1 = (NativeCommentView)paramContainer.getNativeView();
      ((NativeCommentView)localObject1).a = true;
      paramContainer.a(paramIReadInJoyModel);
      ((NativeCommentView)localObject1).setShouldCallClick(true);
      paramContainer.setOnClickListener(local1);
    }
    Util.a(localViewBase, paramIReadInJoyModel);
    BindViewHelper.c(localViewBase, paramIReadInJoyModel);
    return;
    label313:
    paramContainer.setVisibility(0);
    Object localObject3 = (ComponentContentGridImage)paramContainer.getChildAt(0);
    paramContainer = (ComponentContentUgcImage)paramContainer.getChildAt(1);
    if (paramInt1 == 1)
    {
      ((ComponentContentGridImage)localObject3).setVisibility(8);
      paramContainer.setVisibility(0);
      paramContainer.a(paramIReadInJoyModel);
    }
    for (;;)
    {
      paramContainer.setPicClickListener(new AnswerProteusItem.2(this, paramIReadInJoyModel));
      break;
      ((ComponentContentGridImage)localObject3).setVisibility(0);
      ((ComponentContentGridImage)localObject3).setMIReadInJoyModel(paramIReadInJoyModel);
      paramContainer.setVisibility(8);
      ((ComponentContentGridImage)localObject3).a(localObject2);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.AnswerProteusItem
 * JD-Core Version:    0.7.0.1
 */