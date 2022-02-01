package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.view.IReadInJoyListItemLifeCycle;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class PgcShortContentProteusItem$9
  implements View.OnAttachStateChangeListener
{
  PgcShortContentProteusItem$9(PgcShortContentProteusItem paramPgcShortContentProteusItem, IReadInJoyModel paramIReadInJoyModel, VideoView paramVideoView, PgcShortContentProteusItem.Bool paramBool, BroadcastReceiver paramBroadcastReceiver) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    PgcShortContentProteusItem.9.1 local1 = new PgcShortContentProteusItem.9.1(this);
    localReadInJoyBaseAdapter.b(local1);
    paramView.setTag(2131376585, local1);
    paramView = new IntentFilter();
    paramView.addAction("android.media.VOLUME_CHANGED_ACTION");
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramView);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemPgcShortContentProteusItem$Bool.a(false);
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    paramView = (IReadInJoyListItemLifeCycle)paramView.getTag(2131376585);
    if (paramView != null) {
      localReadInJoyBaseAdapter.c(paramView);
    }
    try
    {
      BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception paramView)
    {
      QLog.e("PgcShortContentProteusItem", 2, QLog.getStackTraceString(paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcShortContentProteusItem.9
 * JD-Core Version:    0.7.0.1
 */