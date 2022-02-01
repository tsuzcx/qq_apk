package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

public class WSVerticalItemBottomWidgetViewController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private stNewIconStyle jdField_a_of_type_UserGrowthStNewIconStyle;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private View jdField_b_of_type_AndroidViewView;
  private KandianUrlImageView jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private KandianUrlImageView c;
  
  public WSVerticalItemBottomWidgetViewController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      stNewIconStyle localstNewIconStyle = this.jdField_a_of_type_UserGrowthStNewIconStyle;
      if ((localstNewIconStyle != null) && (!TextUtils.isEmpty(localstNewIconStyle.title)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStNewIconStyle.title);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStNewIconStyle.iconUrl)) {
          this.c.setImage(WeishiUtils.a(this.jdField_a_of_type_UserGrowthStNewIconStyle.iconUrl));
        } else {
          this.c.setImageResource(2130843332);
        }
        if (!paramBoolean2) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageResource(2130842784);
        return;
      }
    }
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
  }
  
  private void f()
  {
    a(true, true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageResource(2130842784);
  }
  
  protected void a()
  {
    Object localObject = (WSVerticalItemData)a();
    if ((localObject != null) && ((((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed)))
    {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((WSVerticalItemData)localObject).a();
      this.jdField_a_of_type_UserGrowthStNewIconStyle = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.new_icon;
      localObject = this.jdField_a_of_type_UserGrowthStNewIconStyle;
      if (localObject != null) {
        WSReportDC898Vertical.a(((stNewIconStyle)localObject).tag_type, this.jdField_a_of_type_UserGrowthStNewIconStyle.id);
      }
    }
  }
  
  protected int b()
  {
    return 2131560038;
  }
  
  protected void b()
  {
    Object localObject = this.jdField_a_of_type_UserGrowthStNewIconStyle;
    if ((localObject != null) && ((((stNewIconStyle)localObject).tag_type == 1) || (this.jdField_a_of_type_UserGrowthStNewIconStyle.tag_type == 2)))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      int i = this.jdField_a_of_type_UserGrowthStNewIconStyle.tag_type;
      localObject = this.jdField_a_of_type_UserGrowthStNewIconStyle.img_url;
      if (i == 1)
      {
        this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
        f();
        return;
      }
      if (i == 2)
      {
        a(false, false);
        this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage(WeishiUtils.a((String)localObject));
          return;
        }
        this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage(WeishiUtils.a("https://isee.weishi.qq.com/qq/doudi_ban.png"));
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_b_of_type_AndroidViewView = a(2131380477);
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)a(2131380459));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)a(2131380476));
    this.c = ((KandianUrlImageView)a(2131380479));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380478));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131380477) {
      WSVerticalJumpUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomWidgetViewController
 * JD-Core Version:    0.7.0.1
 */