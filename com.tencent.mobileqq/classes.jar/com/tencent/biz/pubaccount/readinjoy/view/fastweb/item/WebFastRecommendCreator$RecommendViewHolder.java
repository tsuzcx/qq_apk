package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.VideoRecommendData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.TimeUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WebFastRecommendCreator$RecommendViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  public WebFastRecommendCreator$RecommendViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369454));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380651));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370380);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369863));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380700));
    this.c = ((TextView)paramView.findViewById(2131380296));
    this.d = ((TextView)paramView.findViewById(2131380180));
  }
  
  private ArticleInfo a(RecommendData paramRecommendData)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    if (paramRecommendData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      localArticleInfo.mChannelID = paramRecommendData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      localArticleInfo.mStrategyId = paramRecommendData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
      localArticleInfo.mAlgorithmID = paramRecommendData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID;
    }
    localArticleInfo.mTitle = paramRecommendData.jdField_a_of_type_JavaLangString;
    localArticleInfo.mFirstPagePicUrl = paramRecommendData.jdField_b_of_type_JavaLangString;
    localArticleInfo.mArticleContentUrl = paramRecommendData.c;
    localArticleInfo.mArticleID = paramRecommendData.jdField_b_of_type_Long;
    localArticleInfo.mSubscribeID = paramRecommendData.jdField_e_of_type_JavaLangString;
    localArticleInfo.mSubscribeName = paramRecommendData.jdField_d_of_type_JavaLangString;
    localArticleInfo.innerUniqueID = paramRecommendData.jdField_f_of_type_JavaLangString;
    return localArticleInfo;
  }
  
  private void a(RecommendData paramRecommendData)
  {
    TimeUtil.b("fast_web_show_light_house_1");
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a();
      if (localObject != null) {
        ((FastWebModule)localObject).a(paramRecommendData.c, paramRecommendData.jdField_f_of_type_JavaLangString, paramRecommendData.jdField_e_of_type_JavaLangString, 1, null);
      }
    }
    a(paramRecommendData, null);
  }
  
  private void a(RecommendData paramRecommendData, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ReadInJoyLogicEngine.a().a(paramRecommendData.jdField_b_of_type_Long, System.currentTimeMillis());
    TimeUtil.a("FastWebActivity.show");
    paramFastWebArticleInfo = new Intent(this.jdField_a_of_type_AndroidViewView.getContext(), FastWebActivity.class);
    paramFastWebArticleInfo.putExtra("fast_web_article_info", a(paramRecommendData));
    paramFastWebArticleInfo.putExtra("fast_web_from_article_recommend", true);
    if ((this.jdField_a_of_type_AndroidViewView.getContext() instanceof FastWebActivity)) {
      ((FastWebActivity)this.jdField_a_of_type_AndroidViewView.getContext()).a(paramFastWebArticleInfo);
    }
  }
  
  private void a(VideoRecommendData paramVideoRecommendData)
  {
    if (paramVideoRecommendData == null) {
      return;
    }
    VideoFeedsHelper.a((Activity)this.jdField_a_of_type_AndroidViewView.getContext(), null, 10, paramVideoRecommendData.jdField_f_of_type_JavaLangString, paramVideoRecommendData.g, paramVideoRecommendData.h, paramVideoRecommendData.jdField_e_of_type_Int, paramVideoRecommendData.jdField_f_of_type_Int, paramVideoRecommendData.jdField_d_of_type_Int, paramVideoRecommendData.jdField_a_of_type_JavaLangString, paramVideoRecommendData.jdField_b_of_type_JavaLangString, paramVideoRecommendData.c, paramVideoRecommendData.jdField_d_of_type_JavaLangString, paramVideoRecommendData.jdField_e_of_type_JavaLangString, 0L, false, 0L, 0, null, null, null, null, null);
  }
  
  private void b()
  {
    switch (((RecommendData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData).jdField_a_of_type_Int)
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      a((RecommendData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
    case 3: 
      return;
    }
    a((VideoRecommendData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
  }
  
  private void c()
  {
    RecommendData localRecommendData = (RecommendData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    switch (paramBaseData2.s)
    {
    default: 
      throw new IllegalArgumentException();
    }
    paramBaseData1 = (RecommendData)paramBaseData2;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1.jdField_a_of_type_JavaLangString);
    paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
    paramBaseData2.mRequestWidth = AIOUtils.a(88.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    paramBaseData2.mRequestHeight = AIOUtils.a(68.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
    paramBaseData2.mPlayGifImage = true;
    paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
    paramBaseData2 = URLDrawable.getDrawable(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramBaseData1.jdField_b_of_type_JavaLangString, 4), paramBaseData2);
    if ((paramBaseData2 != null) && (paramBaseData2.getStatus() == 2)) {
      paramBaseData2.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData2);
    if (paramBaseData1.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    }
    for (;;)
    {
      if (this.c != null) {
        this.c.setText(ReadInJoyTimeUtils.a(paramBaseData1.jdField_a_of_type_Long));
      }
      if (this.d != null) {
        this.d.setText(paramBaseData1.jdField_d_of_type_JavaLangString);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramBaseData1.jdField_a_of_type_Int == 2)
      {
        if (this.jdField_b_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(((VideoRecommendData)paramBaseData1).jdField_d_of_type_Int));
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    c();
    b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastRecommendCreator.RecommendViewHolder
 * JD-Core Version:    0.7.0.1
 */