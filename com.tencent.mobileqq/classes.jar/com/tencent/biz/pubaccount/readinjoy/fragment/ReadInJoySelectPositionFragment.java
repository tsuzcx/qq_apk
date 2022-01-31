package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoySelectPositionHeader;
import com.tencent.biz.pubaccount.readinjoy.view.widget.WordNavView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import onh;
import osg;
import osj;
import ovl;
import ovm;
import ozo;
import pck;
import pcm;
import pco;
import pcp;
import qgo;
import rtp;

public class ReadInJoySelectPositionFragment
  extends IphoneTitleBarFragment
  implements pcp, rtp
{
  private SelectPositionModule.PositionData jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
  private ReadInJoySelectPositionHeader jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader;
  private WordNavView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<pcm> jdField_a_of_type_JavaUtilList;
  private pck jdField_a_of_type_Pck;
  private pco jdField_a_of_type_Pco;
  
  private void a()
  {
    this.vg.a(true);
    setTitle("城市");
    if (ThemeUtil.isInNightMode(onh.a())) {
      View.inflate(getActivity(), 2131559985, this.titleRoot);
    }
  }
  
  private void a(String paramString)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((((pcm)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int != 1) || (!((pcm)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString))) {}
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
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.mContentView.findViewById(2131364218));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView = ((WordNavView)this.mContentView.findViewById(2131368070));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView.setOnTouchingWordChangedListener(new ovl(this));
      this.jdField_a_of_type_Pck = new pck(getActivity());
      c();
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Pck);
      this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(new ovm(this));
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
    Object localObject = osg.a().a();
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
      this.jdField_a_of_type_Pco = new pco(this);
      this.jdField_a_of_type_Pco.a();
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
      SelectPositionModule localSelectPositionModule = osg.a().a();
      if (localSelectPositionModule != null)
      {
        localSelectPositionModule.a(paramPositionData);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader.setSelectedCity(paramPositionData.city);
      }
      osg.a().a(41695, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.city);
      paramPositionData = osg.a().a();
      if (paramPositionData != null) {
        paramPositionData.b(41695);
      }
      osj.a().g(41695);
    }
    onBackEvent();
  }
  
  public void a(List<pcm> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Pck.a(this.jdField_a_of_type_JavaUtilList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((pcm)paramList.get(i)).jdField_a_of_type_Int == 1) {
        localArrayList.add(((pcm)paramList.get(i)).jdField_a_of_type_JavaLangString);
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
  }
  
  public int getContentLayoutId()
  {
    return 2131560011;
  }
  
  public void onResume()
  {
    super.onResume();
    qgo.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelectPositionFragment
 * JD-Core Version:    0.7.0.1
 */