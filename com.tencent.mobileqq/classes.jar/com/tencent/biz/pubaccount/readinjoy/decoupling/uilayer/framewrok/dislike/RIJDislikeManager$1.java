package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.widget.KandianNegativeWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

class RIJDislikeManager$1
  implements KandianNegativeWindow.OnUninterestConfirmListener
{
  RIJDislikeManager$1(RIJDislikeManager paramRIJDislikeManager, int paramInt, RIJDataManager paramRIJDataManager, ViewHolder paramViewHolder, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().f();
      paramView = (Animation)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder.g.getTag(2131369928);
      paramView.setAnimationListener(new RIJDislikeManager.1.1(this, paramArrayList, paramObject));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderViewHolder.g.post(new RIJDislikeManager.1.2(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike.RIJDislikeManager.1
 * JD-Core Version:    0.7.0.1
 */