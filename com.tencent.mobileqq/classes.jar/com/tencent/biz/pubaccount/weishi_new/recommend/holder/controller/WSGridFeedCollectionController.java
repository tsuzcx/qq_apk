package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUI;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.collection.WSCollectionItemData;
import com.tencent.biz.pubaccount.weishi_new.util.WSCollectionJumpUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class WSGridFeedCollectionController
  extends AbsWsUI<WSCollectionItemData>
  implements View.OnClickListener
{
  private static final int c = Color.parseColor("#e1e1e1");
  private final stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSRoundedImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView;
  private String jdField_a_of_type_JavaLangString;
  private final Context jdField_b_of_type_AndroidContentContext;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int d;
  
  public WSGridFeedCollectionController(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    super(paramContext);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560535, null);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView = ((WSRoundedImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366765));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setStrokeWidth(WeishiUIUtil.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setStrokeColor(c);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366767));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366766));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a() {}
  
  public void a(ViewGroup paramViewGroup)
  {
    if ((ViewGroup)this.jdField_b_of_type_AndroidViewView.getParent() != null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.b(36.0F));
    int i = ViewUtils.b(7.5F);
    localLayoutParams.bottomMargin = i;
    localLayoutParams.topMargin = i;
    paramViewGroup.addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
  }
  
  public void a(WSCollectionItemData paramWSCollectionItemData)
  {
    super.a(paramWSCollectionItemData);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((WSCollectionItemData)this.jdField_a_of_type_JavaLangObject).b());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(((WSCollectionItemData)this.jdField_a_of_type_JavaLangObject).c());
    WeishiUtils.a(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView, ((WSCollectionItemData)this.jdField_a_of_type_JavaLangObject).a());
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void e()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_b_of_type_AndroidViewView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this.jdField_b_of_type_AndroidViewView);
    }
  }
  
  public void onClick(View paramView)
  {
    WSCollectionJumpUtil.a(a(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, ((WSCollectionItemData)this.jdField_a_of_type_JavaLangObject).a(), this.jdField_a_of_type_Int, this.d, this.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedCollectionController
 * JD-Core Version:    0.7.0.1
 */