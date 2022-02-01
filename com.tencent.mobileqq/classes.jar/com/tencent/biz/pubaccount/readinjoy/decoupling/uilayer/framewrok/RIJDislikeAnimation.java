package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import java.util.List;

public class RIJDislikeAnimation
{
  AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  RIJDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager;
  
  public RIJDislikeAnimation(RIJDataManager paramRIJDataManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager = paramRIJDataManager;
  }
  
  public AnimationSet a()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), 2130772074));
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    List localList = this.jdField_a_of_type_AndroidViewAnimationAnimationSet.getAnimations();
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      localAnimationSet.addAnimation((Animation)localList.get(i));
      i += 1;
    }
    return localAnimationSet;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().remove(paramBaseArticleInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().e(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJDislikeAnimation
 * JD-Core Version:    0.7.0.1
 */