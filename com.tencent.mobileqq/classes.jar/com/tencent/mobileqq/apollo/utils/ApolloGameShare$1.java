package com.tencent.mobileqq.apollo.utils;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApolloGameShare$1
  implements AdapterView.OnItemClickListener
{
  ApolloGameShare$1(ApolloGameShare paramApolloGameShare, String paramString) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameShare.a.obtainMessage();
    localMessage.what = ((int)paramLong);
    localMessage.obj = this.jdField_a_of_type_JavaLangString;
    localMessage.sendToTarget();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameShare.1
 * JD-Core Version:    0.7.0.1
 */