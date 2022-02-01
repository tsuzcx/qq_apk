package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.commercial.WSBigCardCommercialInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSBezierInterpolator;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.utils.ViewUtils;

public class WSVerticalItemWidgetAdvBigCardController
  extends AbsWsVerticalUIGroup
  implements View.OnClickListener
{
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSBigCardCommercialInfo jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private WSVerticalItemWidgetAdvBigCardController.BigCardStatusChangeListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetAdvBigCardController$BigCardStatusChangeListener;
  private WSBezierInterpolator jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoUtilsWSBezierInterpolator;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private boolean jdField_a_of_type_Boolean = false;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private WSBezierInterpolator jdField_b_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoUtilsWSBezierInterpolator;
  private View c;
  private int d;
  
  public WSVerticalItemWidgetAdvBigCardController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder, View paramView)
  {
    super(paramContext);
    this.c = paramView;
    if (paramWSVerticalVideoHolder != null) {
      paramContext = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    } else {
      paramContext = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoUtilsWSBezierInterpolator = new WSBezierInterpolator(0.42F, 0.0F, 1.0F, 1.0F);
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoUtilsWSBezierInterpolator = new WSBezierInterpolator(0.0F, 0.0F, 0.58F, 1.0F);
  }
  
  private boolean a()
  {
    WSBigCardCommercialInfo localWSBigCardCommercialInfo = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo;
    return (localWSBigCardCommercialInfo != null) && (localWSBigCardCommercialInfo.a());
  }
  
  private int c()
  {
    if (this.d <= ViewUtils.a(92.0F))
    {
      Object localObject = this.c;
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((View)localObject).getMeasuredHeight();
      }
      int j = ViewUtils.a(92.0F);
      this.d = (i + j);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initTransitionDistance:");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(", bottomHeight:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", selfHeight:");
      ((StringBuilder)localObject).append(j);
      WSLog.a("WSAdvBigCardController", ((StringBuilder)localObject).toString());
    }
    return this.d;
  }
  
  private void e(int paramInt)
  {
    if (!a())
    {
      WSLog.a("WSAdvBigCardController", "planToHideCard return");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("planToHideCard delayTime:");
    localStringBuilder.append(paramInt);
    WSLog.a("WSAdvBigCardController", localStringBuilder.toString());
    i();
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setStartDelay(paramInt);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void f()
  {
    if (WeishiUtils.c()) {
      return;
    }
    e(0);
  }
  
  private void g()
  {
    WSVerticalJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, (WSVerticalItemData)a(), true);
  }
  
  private void h()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    int i = c();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { i, 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoUtilsWSBezierInterpolator);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new WSVerticalItemWidgetAdvBigCardController.1(this, i, 0));
  }
  
  private void i()
  {
    ValueAnimator localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    int i = c();
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { 0, i });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoUtilsWSBezierInterpolator);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new WSVerticalItemWidgetAdvBigCardController.2(this, 0, i));
  }
  
  private void j()
  {
    Object localObject = (WSVerticalItemData)a();
    if ((localObject != null) && (((WSVerticalItemData)localObject).a() != null)) {
      localObject = ((WSVerticalItemData)localObject).a().feed_desc;
    } else {
      localObject = null;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("feedDesc:");
    localStringBuilder2.append((String)localObject);
    localStringBuilder1.append(localStringBuilder2.toString());
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo != null)
    {
      localStringBuilder1.append(", wsCommercialInfo:[");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bigCardIcon:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo.d());
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(",bigCardTitle:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo.c());
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(",bigCardBtnText:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo.e());
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(",smallCardText:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo.b());
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(",smallCardIcon:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo.a());
      ((StringBuilder)localObject).append("]");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
    }
    else
    {
      localStringBuilder1.append(", wsCommercialInfo empty");
    }
    WSLog.a("WSAdvBigCardController", localStringBuilder1.toString());
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      WSLog.a("WSAdvBigCardController", "resetCardStatus view null");
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setTranslationY(c());
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void l()
  {
    if (!a())
    {
      WSLog.a("WSAdvBigCardController", "planToShowCard return");
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    h();
    int i = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo.b();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(i);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("planToShowCard delayStartTime:");
    localStringBuilder.append(i);
    WSLog.a("WSAdvBigCardController", localStringBuilder.toString());
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if ((localWSVerticalItemData.a() instanceof WSBigCardCommercialInfo))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo = ((WSBigCardCommercialInfo)localWSVerticalItemData.a());
      j();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo = null;
  }
  
  public void a(WSVerticalItemWidgetAdvBigCardController.BigCardStatusChangeListener paramBigCardStatusChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetAdvBigCardController$BigCardStatusChangeListener = paramBigCardStatusChangeListener;
  }
  
  protected int b()
  {
    return 2131559987;
  }
  
  protected void b()
  {
    if (a())
    {
      WSLog.b("WSAdvBigCardController", "onUpdateUI");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo.c());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo.e());
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage(WeishiUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialWSBigCardCommercialInfo.d()));
      k();
      if (this.jdField_a_of_type_Boolean) {
        l();
      }
    }
    a(8);
  }
  
  protected void c()
  {
    WSLog.b("WSAdvBigCardController", "onRecycle");
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
  }
  
  protected void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageSelected， position:");
    localStringBuilder.append(paramInt);
    WSLog.b("WSAdvBigCardController", localStringBuilder.toString());
    if (!a())
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    l();
  }
  
  protected void d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageUnselected， position:");
    localStringBuilder.append(paramInt);
    WSLog.b("WSAdvBigCardController", localStringBuilder.toString());
    if (!a()) {
      return;
    }
    e(0);
  }
  
  protected void e()
  {
    this.jdField_b_of_type_AndroidViewView = a(2131363523);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131363525));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131363522));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)a(2131363526));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidViewView)
    {
      f();
      return;
    }
    if (paramView == this.jdField_b_of_type_AndroidWidgetTextView) {
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemWidgetAdvBigCardController
 * JD-Core Version:    0.7.0.1
 */