package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stDrama;
import UserGrowth.stDramaFall;
import UserGrowth.stDramaInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWSItemView;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageIntentParams;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import java.util.ArrayList;

public class WSGridDramaItemView
  extends AbsWSItemView<stSimpleMetaFeed>
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = WSFeedUtils.a(5.0F);
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private RoundCornerImageView jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private RoundCornerImageView c;
  private RoundCornerImageView d;
  
  public WSGridDramaItemView(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  private int a()
  {
    return (WeishiUIUtil.c() - WSItemDecoration.jdField_a_of_type_Int * 3) / 2;
  }
  
  private void e()
  {
    stDramaFall localstDramaFall = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.dramaInfo;
    if (localstDramaFall == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((WSRecommendAdapter)localObject1).jdField_a_of_type_JavaLangString)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("feeds_");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "feeds";
    }
    Object localObject2 = localstDramaFall.dramaInfo;
    String str = "";
    if ((localObject2 != null) && (localstDramaFall.dramaInfo.dramaInfo != null))
    {
      str = localstDramaFall.dramaInfo.dramaInfo.coverImg;
      localObject2 = localstDramaFall.dramaInfo.dramaInfo.name;
      this.jdField_a_of_type_JavaLangString = localstDramaFall.dramaInfo.dramaInfo.id;
    }
    else
    {
      localObject2 = "";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    WSPicLoader.a(this.jdField_a_of_type_AndroidContentContext, this.d, WeishiUtils.a(str), WSFeedUtils.a(2131165740), (String)localObject1, this.jdField_b_of_type_Int);
    WSPicLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, localstDramaFall.bgCover, WSFeedUtils.a(2131167394));
    WSPicLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, localstDramaFall.titleCover, WSFeedUtils.a(2131167333));
    if (localstDramaFall.images != null)
    {
      if (localstDramaFall.images.size() > 0) {
        WSPicLoader.a(this.c, (String)localstDramaFall.images.get(0), WSFeedUtils.a(2131165740));
      }
      if (localstDramaFall.images.size() > 1) {
        WSPicLoader.a(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, (String)localstDramaFall.images.get(1), WSFeedUtils.a(2131165740));
      }
    }
  }
  
  private void e(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = ((int)(paramInt * 1.777778F + WSItemDecoration.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    e();
  }
  
  public void a(WSRecommendAdapter paramWSRecommendAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter = paramWSRecommendAdapter;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376625));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379667));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369357));
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376629));
    this.c = ((RoundCornerImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376628));
    this.d = ((RoundCornerImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376626));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(jdField_a_of_type_Int, 0);
    this.d.setCorner(jdField_a_of_type_Int, 0);
    this.c.setCorner(jdField_a_of_type_Int, 1);
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(jdField_a_of_type_Int, 1);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    e(a());
  }
  
  public void b(int paramInt) {}
  
  public void c() {}
  
  public void d() {}
  
  public void d(int paramInt) {}
  
  public void onClick(View paramView)
  {
    WSDramaPageIntentParams localWSDramaPageIntentParams = new WSDramaPageIntentParams("grid_drama_card", this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString);
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
    if (paramView != null) {
      paramView = paramView.jdField_a_of_type_JavaLangString;
    } else {
      paramView = "";
    }
    WSDramaPageFragment.a(localWSDramaPageIntentParams.c(paramView));
    paramView = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    WSGridBeaconReport.a("gzh_click", paramView, UserActionReportPresenter.a(paramView, this.jdField_b_of_type_Int), 1000001, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridDramaItemView
 * JD-Core Version:    0.7.0.1
 */