package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import qxk;

public class ProteusAnimationItemData
  extends ProteusItemData
{
  private int jdField_a_of_type_Int = -1;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  @Deprecated
  private View jdField_a_of_type_AndroidViewView;
  
  public ProteusAnimationItemData(ProteusItemData paramProteusItemData)
  {
    super(paramProteusItemData.p);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramProteusItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
    this.e = paramProteusItemData.e;
    this.t = paramProteusItemData.t;
    this.jdField_b_of_type_Float = paramProteusItemData.jdField_b_of_type_Float;
    this.jdField_b_of_type_OrgJsonJSONObject = paramProteusItemData.jdField_b_of_type_OrgJsonJSONObject;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = paramProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
    this.s = paramProteusItemData.s;
    this.q = paramProteusItemData.q;
    this.V = paramProteusItemData.V;
    this.r = paramProteusItemData.r;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    ThreadManager.getUIHandler().post(new ProteusAnimationItemData.1(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    int i = Utils.dp2px(71.0D);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = i;
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (paramBoolean) {}
    for (this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_Int, i });; this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_Int, 1 }))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new qxk(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(350L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData
 * JD-Core Version:    0.7.0.1
 */