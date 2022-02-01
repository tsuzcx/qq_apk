package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WSCollectionJumpUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalItemBottomCollectionController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private View b;
  
  public WSVerticalItemBottomCollectionController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.collection != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.collection.cid));
  }
  
  private boolean c()
  {
    return (this.b != null) && (this.b.getVisibility() == 0) && (!a());
  }
  
  private void g()
  {
    WSCollectionJumpUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.c());
  }
  
  public void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = localWSVerticalItemData.a();
    }
  }
  
  public boolean a()
  {
    return (a() != null) && (((WSVerticalItemData)a()).b());
  }
  
  public int b()
  {
    return 2131560151;
  }
  
  public void b()
  {
    if (b())
    {
      this.b.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.collection.name);
      if (a())
      {
        this.b.setBackgroundColor(WSFeedUtils.b(2131165753));
        return;
      }
      this.b.setBackgroundColor(WSFeedUtils.b(2131165368));
      return;
    }
    this.b.setVisibility(8);
  }
  
  public void c() {}
  
  public void e()
  {
    this.b = a(2131381194);
    this.b.setOnClickListener(new WSVerticalItemBottomCollectionController.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131381195));
  }
  
  public void f()
  {
    if (!c())
    {
      WSLog.d("AbsWsUIGroup", "fail to meet the requirement of playing collection animation");
      return;
    }
    if (a() != null) {
      ((WSVerticalItemData)a()).b(true);
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.b, "backgroundColor", new int[] { -2147483648, -2139470081 });
    localObjectAnimator.addListener(new WSVerticalItemBottomCollectionController.2(this));
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setEvaluator(new ArgbEvaluator());
    localObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomCollectionController
 * JD-Core Version:    0.7.0.1
 */