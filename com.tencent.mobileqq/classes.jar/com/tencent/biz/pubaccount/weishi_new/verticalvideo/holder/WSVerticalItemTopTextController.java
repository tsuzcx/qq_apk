package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSDramaEpisodeInfo;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSVerticalItemTopTextController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private TextView b;
  
  public WSVerticalItemTopTextController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  protected void a() {}
  
  protected int b()
  {
    return 2131560047;
  }
  
  @SuppressLint({"StringFormatMatches"})
  @UiThread
  protected void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdateUI hashcode******************************");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(",position:");
    ((StringBuilder)localObject).append(a());
    WSLog.a("WSVerticalItemTopTextController", ((StringBuilder)localObject).toString());
    localObject = (WSVerticalItemData)a();
    if (localObject != null)
    {
      localObject = ((WSVerticalItemData)localObject).a();
      if (localObject == null) {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((WSDramaEpisodeInfo)localObject).b());
      this.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(1929707522, new Object[] { Integer.valueOf(((WSDramaEpisodeInfo)localObject).a()) }));
    }
  }
  
  protected void c() {}
  
  protected void e()
  {
    WSVerticalUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getBaseActivity(), (ViewGroup)this.jdField_a_of_type_AndroidViewView);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.width = -1;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380453));
    this.b = ((TextView)a(2131380452));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemTopTextController
 * JD-Core Version:    0.7.0.1
 */