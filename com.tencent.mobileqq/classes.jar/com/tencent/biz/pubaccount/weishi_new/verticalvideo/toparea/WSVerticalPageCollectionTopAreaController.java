package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import UserGrowth.stCollection;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSVerticalPageCollectionTopAreaController
  extends AbsWsUIGroup<Object>
{
  private static final int d = (int)(WeishiUIUtil.c() - WeishiUIUtil.l * 1.5F);
  private stCollection jdField_a_of_type_UserGrowthStCollection;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public WSVerticalPageCollectionTopAreaController(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  public void a()
  {
    if ((a() != null) && ((a() instanceof stCollection))) {
      this.jdField_a_of_type_UserGrowthStCollection = ((stCollection)a());
    }
  }
  
  public int b()
  {
    return 2131560128;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_UserGrowthStCollection != null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(d);
      String str = a().getString(2131720703);
      str = str + this.jdField_a_of_type_UserGrowthStCollection.name;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_UserGrowthStCollection != null))
    {
      String str = paramInt + "/" + this.jdField_a_of_type_UserGrowthStCollection.feed_count;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131381213);
    WSVerticalUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), localRelativeLayout);
    this.jdField_b_of_type_AndroidViewView = a(2131381212);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new WSVerticalPageCollectionTopAreaController.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131381205));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380264));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCollectionTopAreaController
 * JD-Core Version:    0.7.0.1
 */