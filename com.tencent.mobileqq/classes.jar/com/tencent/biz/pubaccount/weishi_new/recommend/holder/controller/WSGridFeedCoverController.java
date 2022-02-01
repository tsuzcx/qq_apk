package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.WSItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;

public class WSGridFeedCoverController
  extends AbsWsUIGroup<stSimpleMetaFeed>
{
  private static final int d = WSFeedUtils.a(5.0F);
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private WSRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private final View b;
  private final int e;
  
  public WSGridFeedCoverController(Context paramContext, View paramView, int paramInt, WSRecommendAdapter paramWSRecommendAdapter)
  {
    super(paramContext);
    this.e = paramInt;
    this.b = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter = paramWSRecommendAdapter;
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(d, this.e);
  }
  
  private void g()
  {
    float f2 = 1.333333F;
    Object localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.waterFallCardStyle;
    boolean bool;
    float f1;
    label57:
    label65:
    label73:
    int i;
    if ((localObject != null) && (((stWaterFallCardStyle)localObject).isFullSpan))
    {
      bool = true;
      if ((localObject == null) || (((stWaterFallCardStyle)localObject).ratioW == 0)) {
        break label225;
      }
      f1 = ((stWaterFallCardStyle)localObject).ratioH * 1.0F / ((stWaterFallCardStyle)localObject).ratioW;
      if (f1 <= 2.0F) {
        break label231;
      }
      f1 = f2;
      if (!bool) {
        break label234;
      }
      f1 = 0.5625F;
      ((StaggeredGridLayoutManager.LayoutParams)this.b.getLayoutParams()).setFullSpan(bool);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.getLayoutParams();
      i = WeishiUIUtil.c();
      if (!bool) {
        break label237;
      }
      i -= WSItemDecoration.a * 2;
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(f1 * i));
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      String str = "feeds";
      localObject = str;
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter != null)
      {
        localObject = str;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.a)) {
          localObject = "feeds_" + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.a;
        }
      }
      WeishiUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, WSFeedUtils.a(2131165749), (String)localObject, true, a());
      return;
      bool = false;
      break;
      label225:
      f1 = 1.333333F;
      break label57;
      label231:
      break label65;
      label234:
      break label73;
      label237:
      i = (i - WSItemDecoration.a * 3) / 2;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)a());
  }
  
  public int b()
  {
    return 2131560536;
  }
  
  public void b()
  {
    g();
    f();
  }
  
  public void c() {}
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)a(2131369392));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedCoverController
 * JD-Core Version:    0.7.0.1
 */