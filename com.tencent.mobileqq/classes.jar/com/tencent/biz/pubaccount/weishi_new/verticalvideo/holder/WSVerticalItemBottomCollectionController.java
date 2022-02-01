package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stFeedBarInfo;
import UserGrowth.stSimpleMetaFeed;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSCollectionJumpUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import java.util.Map;

public class WSVerticalItemBottomCollectionController
  extends AbsWsVerticalUIGroup
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected WSVerticalPageFragment a;
  private String jdField_a_of_type_JavaLangString;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private int d = -1;
  private int e = -1;
  
  public WSVerticalItemBottomCollectionController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void a(String paramString)
  {
    paramString = WeishiUtils.b(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(WSFeedUtils.b(2131165336));
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor(paramString));
  }
  
  private boolean b()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    return (localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.feedBarInfo != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feedBarInfo.switchOpen == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feedBarInfo.text));
  }
  
  private boolean c()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    return (localView != null) && (localView.getVisibility() == 0) && (!a());
  }
  
  private void g()
  {
    stFeedBarInfo localstFeedBarInfo = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feedBarInfo;
    if (localstFeedBarInfo == null) {
      return;
    }
    Map localMap = ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b();
    String str;
    if (a()) {
      str = "1";
    } else {
      str = "0";
    }
    localMap.put("bar_status", str);
    WSCollectionJumpUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, localstFeedBarInfo.jump, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.c(), localMap);
  }
  
  private void h()
  {
    Map localMap = ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b();
    String str;
    if (a()) {
      str = "1";
    } else {
      str = "0";
    }
    localMap.put("bar_status", str);
    WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, localMap);
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if (localWSVerticalItemData != null) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = localWSVerticalItemData.a();
    }
  }
  
  public boolean a()
  {
    return (a() != null) && (((WSVerticalItemData)a()).c());
  }
  
  protected int b()
  {
    return 2131560033;
  }
  
  protected void b()
  {
    if (b())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feedBarInfo.text);
      this.d = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feedBarInfo.changeTime;
      this.e = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feedBarInfo.progressPercentage;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feedBarInfo.beginColor;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feedBarInfo.endColor;
      if (a())
      {
        a(this.jdField_b_of_type_JavaLangString);
        return;
      }
      a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public int c()
  {
    int i = this.d;
    if (i == -1) {
      return 2000;
    }
    return i * 1000;
  }
  
  protected void c() {}
  
  protected void c(int paramInt)
  {
    if (b()) {
      h();
    }
  }
  
  public int d()
  {
    int j = this.e;
    int i = j;
    if (j == -1) {
      i = 20;
    }
    return i;
  }
  
  protected void d(int paramInt) {}
  
  protected void e()
  {
    this.jdField_b_of_type_AndroidViewView = a(2131380447);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new WSVerticalItemBottomCollectionController.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380449));
  }
  
  public void f()
  {
    if (!c())
    {
      WSLog.d("AbsWsUIGroup", "fail to meet the requirement of playing collection animation");
      return;
    }
    if (a() != null) {
      ((WSVerticalItemData)a()).c(true);
    }
    Object localObject = WeishiUtils.b(this.jdField_a_of_type_JavaLangString);
    String str = WeishiUtils.b(this.jdField_b_of_type_JavaLangString);
    int i;
    if (WeishiUIUtil.a((String)localObject)) {
      i = Color.parseColor((String)localObject);
    } else {
      i = -2147483648;
    }
    int j;
    if (WeishiUIUtil.a(str)) {
      j = Color.parseColor(str);
    } else {
      j = -2139470081;
    }
    localObject = ObjectAnimator.ofInt(this.jdField_b_of_type_AndroidViewView, "backgroundColor", new int[] { i, j });
    ((ObjectAnimator)localObject).addListener(new WSVerticalItemBottomCollectionController.2(this));
    ((ObjectAnimator)localObject).setDuration(500L);
    ((ObjectAnimator)localObject).setEvaluator(new ArgbEvaluator());
    ((ObjectAnimator)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomCollectionController
 * JD-Core Version:    0.7.0.1
 */