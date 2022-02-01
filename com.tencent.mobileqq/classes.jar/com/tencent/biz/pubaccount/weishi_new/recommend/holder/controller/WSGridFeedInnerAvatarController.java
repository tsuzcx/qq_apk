package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;

public class WSGridFeedInnerAvatarController
  extends AbsWsUIGroup<stSimpleMetaFeed>
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSRoundedImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView;
  private TextView b;
  
  public WSGridFeedInnerAvatarController(Context paramContext)
  {
    super(paramContext);
  }
  
  private void f()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster;
    WeishiUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView, localstSimpleMetaPerson.avatar);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(c());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(WSFeedUtils.a(localstSimpleMetaPerson.nick));
    WSFeedUtils.a(this.b, localstSimpleMetaPerson.medal, false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)a());
  }
  
  public int b()
  {
    return 2131560533;
  }
  
  public void b()
  {
    f();
  }
  
  @ColorInt
  protected int c()
  {
    return -1;
  }
  
  public void c() {}
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView = ((WSRoundedImageView)a(2131369389));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369396));
    this.b = ((TextView)a(2131369395));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerAvatarController
 * JD-Core Version:    0.7.0.1
 */