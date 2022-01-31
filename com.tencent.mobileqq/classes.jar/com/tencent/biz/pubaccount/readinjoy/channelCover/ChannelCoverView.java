package com.tencent.biz.pubaccount.readinjoy.channelCover;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import lik;
import lil;
import lim;
import lin;

public class ChannelCoverView
  implements AdapterView.OnItemClickListener
{
  public static int a;
  public static int b = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ChannelCoverSimpleAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverChannelCoverSimpleAdapter;
  protected ReadInJoyObserver a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int c;
  
  static
  {
    jdField_a_of_type_Int = 2;
  }
  
  public ChannelCoverView(Context paramContext, int paramInt, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lik(this);
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)ReadInJoyLogicEngine.a().a(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverView", 2, "ChannelCoverView createSimpleView");
    }
    a(paramContext);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      ReadInJoyLogicEngine.a().b(paramInt);
    }
    ReadInJoyLogicEngine.a().a(paramInt);
  }
  
  public static void a(String paramString, ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    ThreadManager.post(new lin(paramChannelCoverInfo, paramInt, paramString), 5, null, true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, ChannelCoverInfo paramChannelCoverInfo)
  {
    ThreadManager.executeOnSubThread(new lim(paramChannelCoverInfo, paramString1, paramString2, paramString3, paramString4));
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void a()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    this.jdField_a_of_type_JavaUtilArrayList = null;
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverView", 2, "onDestroy()");
    }
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(paramContext).inflate(2130968737, null, false));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363490));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(AIOUtils.a(10.0F, paramContext.getResources()));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverChannelCoverSimpleAdapter = new ChannelCoverSimpleAdapter(paramContext, this.jdField_a_of_type_JavaUtilArrayList, this.c);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverChannelCoverSimpleAdapter);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt)
    {
      paramAdapterView = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (!TextUtils.isEmpty(paramAdapterView.mChannelJumpUrl)) {
        break label248;
      }
      paramView = new HashMap();
      paramView.put("param_key_ariticle_id", Long.valueOf(paramAdapterView.mArticleId));
      paramView.put("param_key_channel_cover_style", Integer.valueOf(paramAdapterView.mChannelCoverStyle));
      if (this.c != 56) {
        break label224;
      }
      ReadInJoyActivityHelper.b(this.jdField_a_of_type_AndroidContentContext, paramAdapterView.mChannelCoverId, paramAdapterView.mChannelCoverName, paramAdapterView.mChannelType, 4, paramView);
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "launchChannelActivity info.mArticleId:" + paramAdapterView.mArticleId + " info.mChannelCoverStyle: " + paramAdapterView.mChannelCoverStyle + " info.mChannelCoverId:" + paramAdapterView.mChannelCoverId + " info.mChannelCoverName:" + paramAdapterView.mChannelCoverName + " info.mChannelType: " + paramAdapterView.mChannelType);
      }
      if (this.c == 56) {
        ThreadManager.executeOnSubThread(new lil(this, paramAdapterView));
      }
    }
    for (;;)
    {
      if (this.c == 0) {
        a("0X8007F02", paramAdapterView, jdField_a_of_type_Int);
      }
      return;
      label224:
      ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, paramAdapterView.mChannelCoverId, paramAdapterView.mChannelCoverName, paramAdapterView.mChannelType, 4, paramView);
      break;
      label248:
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", paramAdapterView.mChannelJumpUrl);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "info.mChannelJumpUrl:" + paramAdapterView.mChannelJumpUrl);
      }
      paramAdapterView.mPreUpdateTime = paramAdapterView.mUpdateTime;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView
 * JD-Core Version:    0.7.0.1
 */