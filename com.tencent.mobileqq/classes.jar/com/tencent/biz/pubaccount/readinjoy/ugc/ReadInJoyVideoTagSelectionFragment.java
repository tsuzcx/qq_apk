package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFlowLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ReadInJoyVideoTagSelectionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new ReadInJoyVideoTagSelectionFragment.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyVideoTagSelectionFragment.3(this);
  private ReadInJoyVideoTagSelectionFragment.SelectedTagsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter;
  private ReadInJoyVideoTagSelectionFragment.TagsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$TagsAdapter;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private DataSetObserver jdField_b_of_type_AndroidDatabaseDataSetObserver = new ReadInJoyVideoTagSelectionFragment.2(this);
  private View jdField_b_of_type_AndroidViewView;
  private QQToast jdField_b_of_type_ComTencentMobileqqWidgetQQToast;
  private View c;
  
  private void a()
  {
    this.c.setVisibility(0);
  }
  
  private void b()
  {
    this.c = this.mContentView.findViewById(2131378916);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379280));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131365323);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131365318);
    ReadInJoyFlowLayout localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131367241);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter = new ReadInJoyVideoTagSelectionFragment.SelectedTagsAdapter(getActivity(), 2131560421);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter);
    localReadInJoyFlowLayout.setOnItemClickListener(new ReadInJoyVideoTagSelectionFragment.4(this));
    localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131367242);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$TagsAdapter = new ReadInJoyVideoTagSelectionFragment.TagsAdapter(getActivity(), 2131560421);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$TagsAdapter.registerDataSetObserver(this.jdField_b_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$TagsAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$TagsAdapter.notifyDataSetChanged();
    localReadInJoyFlowLayout.setOnItemClickListener(new ReadInJoyVideoTagSelectionFragment.5(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getActivity(), 2131718391, 0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getActivity(), 2131718390, 0);
    c();
  }
  
  private void c()
  {
    Object localObject3 = getActivity().getIntent();
    Object localObject1;
    if (localObject3 != null)
    {
      localObject1 = ((Intent)localObject3).getStringExtra("EXTRA_TOPIC_ID");
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = Long.valueOf((String)localObject1);
        ArrayList localArrayList = ((Intent)localObject3).getParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST");
        localObject3 = localObject1;
        if (localArrayList != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.addAll(localArrayList);
          localObject3 = localObject1;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.notifyDataSetChanged();
        ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
        if (localObject3 == null) {
          break label97;
        }
        ReadInJoyLogicEngine.a().b(((Long)localObject3).longValue());
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyVideoTagSelectionFragment", 2, "handleIntent: fail to get topicId");
      }
      Object localObject2 = null;
      continue;
      label97:
      ReadInJoyLogicEngine.a().f(null);
      return;
      localObject3 = null;
    }
  }
  
  private void d()
  {
    this.vg.changeBg(true);
    setRightButton(2131691144, this);
    this.rightViewText.setTextColor(-16265040);
    this.rightViewText.setBackgroundResource(0);
    setTitle(getString(2131718366));
    this.leftView.setText(2131690601);
    Utils.a(this);
  }
  
  private void e()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.a());
    PublicFragmentActivity.Launcher.a(getActivity(), localIntent, PublicTransFragmentActivity.class, ReadInJoyVideoSearchTagFragment.class, 1000);
  }
  
  private void f()
  {
    Object localObject = new Intent();
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.getCount();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.getItem(i));
      i += 1;
    }
    ((Intent)localObject).putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", localArrayList);
    getActivity().setResult(-1, (Intent)localObject);
    getActivity().finish();
    localObject = Integer.valueOf(localArrayList.size()).toString();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092F2", "0X80092F2", 0, 0, (String)localObject, "", "", RIJTransMergeKanDianReport.c(), false);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    RIJDtReportHelper.a.a(getActivity());
  }
  
  public int getContentLayoutId()
  {
    return 2131560420;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = (TagInfo)paramIntent.getParcelableExtra("SEARCH_TAG_RESULT");
      if ((paramIntent != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$SelectedTagsAdapter.a(paramIntent)) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
      }
    }
  }
  
  public boolean onBackEvent()
  {
    f();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.c.setVisibility(8);
      e();
      continue;
      f();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void onResume()
  {
    super.onResume();
    d();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment
 * JD-Core Version:    0.7.0.1
 */