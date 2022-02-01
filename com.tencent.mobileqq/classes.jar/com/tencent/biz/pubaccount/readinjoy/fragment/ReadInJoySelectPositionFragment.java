package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityAdapter;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityAdapter.CityData;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.IView;
import com.tencent.biz.pubaccount.readinjoy.ugc.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoySelectPositionHeader;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoySelectPositionHeader.ISelectCityListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.WordNavView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoySelectPositionFragment
  extends IphoneTitleBarFragment
  implements SelectCityPresenter.IView, ReadInJoySelectPositionHeader.ISelectCityListener
{
  private SelectPositionModule.PositionData jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
  private SelectCityAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyPositionSelectCityAdapter;
  private SelectCityPresenter jdField_a_of_type_ComTencentBizPubaccountReadinjoyPositionSelectCityPresenter;
  private ReadInJoySelectPositionHeader jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader;
  private WordNavView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<SelectCityAdapter.CityData> jdField_a_of_type_JavaUtilList;
  
  private void a()
  {
    this.vg.changeBg(true);
    setTitle("城市");
    if (ThemeUtil.isInNightMode(ReadInJoyUtils.a())) {
      View.inflate(getActivity(), 2131560363, this.titleRoot);
    }
  }
  
  private void a(String paramString)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((((SelectCityAdapter.CityData)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int != 1) || (!((SelectCityAdapter.CityData)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString))) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.setSelection(i + 1);
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  private void b()
  {
    if (this.mContentView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.mContentView.findViewById(2131364758));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView = ((WordNavView)this.mContentView.findViewById(2131369035));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView.setOnTouchingWordChangedListener(new ReadInJoySelectPositionFragment.1(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPositionSelectCityAdapter = new SelectCityAdapter(getActivity());
      c();
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPositionSelectCityAdapter);
      this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(new ReadInJoySelectPositionFragment.2(this));
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader = new ReadInJoySelectPositionHeader(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setSelectCityListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader);
  }
  
  private void d()
  {
    Object localObject = ReadInJoyLogicEngine.a().a();
    if (localObject != null)
    {
      SelectPositionModule.PositionData localPositionData = ((SelectPositionModule)localObject).c();
      localObject = ((SelectPositionModule)localObject).b();
      if (localPositionData == null) {
        break label82;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy(localPositionData);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setSelectedCity(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.city);
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setGPSCity(((SelectPositionModule.PositionData)localObject).cityGPS);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPositionSelectCityPresenter = new SelectCityPresenter(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPositionSelectCityPresenter.a();
      return;
      label82:
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setSelectedCity(((SelectPositionModule.PositionData)localObject).city);
      }
    }
  }
  
  public void a(SelectPositionModule.PositionData paramPositionData)
  {
    if (paramPositionData == null)
    {
      QLog.e("ReadInJoySelectPositionFragment", 2, "selectPosition positionData = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySelectPositionFragment", 2, "selectPosition positionData" + paramPositionData);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.cityCode == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.cityCode.equals(paramPositionData.cityCode)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy(paramPositionData);
      SelectPositionModule localSelectPositionModule = ReadInJoyLogicEngine.a().a();
      if (localSelectPositionModule != null)
      {
        localSelectPositionModule.a(paramPositionData);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setSelectedCity(paramPositionData.city);
      }
      ReadInJoyLogicEngine.a().a(41695, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.city);
      paramPositionData = ReadInJoyLogicEngine.a().a();
      if (paramPositionData != null) {
        paramPositionData.a().b(41695);
      }
      ReadInJoyLogicEngineEventDispatcher.a().h(41695);
    }
    onBackEvent();
  }
  
  public void a(List<SelectCityAdapter.CityData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPositionSelectCityAdapter.a(this.jdField_a_of_type_JavaUtilList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((SelectCityAdapter.CityData)paramList.get(i)).jdField_a_of_type_Int == 1) {
        localArrayList.add(((SelectCityAdapter.CityData)paramList.get(i)).jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView.setIndexList(localArrayList);
  }
  
  public void b(SelectPositionModule.PositionData paramPositionData)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setGPSCity(paramPositionData.cityGPS);
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
    b();
    d();
    RIJDtReportHelper.a.a(getActivity());
  }
  
  public int getContentLayoutId()
  {
    return 2131560388;
  }
  
  public void onResume()
  {
    super.onResume();
    Utils.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelectPositionFragment
 * JD-Core Version:    0.7.0.1
 */