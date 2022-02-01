package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import UserGrowth.stCollection;
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
  private static final int d = (int)(WeishiUIUtil.c() - WeishiUIUtil.o * 1.5F);
  private stCollection jdField_a_of_type_UserGrowthStCollection;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  protected void a()
  {
    if ((a() != null) && ((a() instanceof stCollection))) {
      this.jdField_a_of_type_UserGrowthStCollection = ((stCollection)a());
    }
  }
  
  protected int b()
  {
    return 2131560009;
  }
  
  protected void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (this.jdField_a_of_type_UserGrowthStCollection != null))
    {
      ((TextView)localObject).setMaxWidth(d);
      localObject = a().getString(2131720422);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(this.jdField_a_of_type_UserGrowthStCollection.name);
      localObject = localStringBuilder.toString();
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
  }
  
  protected void c() {}
  
  public void c(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_UserGrowthStCollection != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_UserGrowthStCollection.feed_count);
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131380469);
    WSVerticalUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getBaseActivity(), localRelativeLayout);
    this.jdField_b_of_type_AndroidViewView = a(2131380468);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new WSVerticalPageCollectionTopAreaController.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380461));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131379577));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCollectionTopAreaController
 * JD-Core Version:    0.7.0.1
 */