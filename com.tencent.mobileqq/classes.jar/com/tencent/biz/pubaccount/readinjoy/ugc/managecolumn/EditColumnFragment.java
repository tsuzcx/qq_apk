package com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bglp;
import bgnt;
import bgpa;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import org.jetbrains.annotations.NotNull;
import pmk;
import rou;
import rov;
import row;
import rpa;

public class EditColumnFragment
  extends AbsPublishColumnFragment
{
  private ColumnInfo a;
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo == null) {}
    while ((TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.coverUrl, this.jdField_b_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.title, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a())) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.intro, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a())) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.submitPermission == this.jdField_a_of_type_Int)) {
      return false;
    }
    return true;
  }
  
  public void b(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean)
  {
    super.b(paramColumnInfo, paramBoolean);
    pmk.a().g();
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_publish_result", true);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localIntent.putExtra("arg_callback", this.jdField_a_of_type_JavaLangString);
      }
      localIntent.putExtra("key_column_info", paramColumnInfo);
      getActivity().setResult(1, localIntent);
      i();
    }
    QLog.i("RIJUGC.PublishTopicFragment", 1, "onColumnEdited, result = " + paramBoolean + ", id= " + paramColumnInfo.columnID + ", title = " + paramColumnInfo.title);
  }
  
  protected boolean b()
  {
    return (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a() > 0) && (a());
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo == null)
    {
      QLog.e("RIJUGC.PublishTopicFragment", 1, "EditTopicFragment, mEditedTopicInfo == null");
      return;
    }
    bglp.a(getActivity(), 230).setMessage(2131716911).setNegativeButton(2131716907, new row(this)).setPositiveButton(2131716910, new rov(this)).show();
  }
  
  public void f()
  {
    int i = 0;
    super.f();
    if (!bgnt.a())
    {
      QQToast.a(getActivity(), 0, getString(2131693946), 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo != null) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.columnID;
    }
    this.jdField_a_of_type_Rpa.a(i, a());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo = ((ColumnInfo)getActivity().getIntent().getParcelableExtra("key_column_info"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo == null) {
      QLog.e("RIJUGC.PublishTopicFragment", 1, "EditTopicFragment, mEditedTopicInfo == null");
    }
    this.c.setText(2131716910);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717012);
    b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountChangeListener(new rou(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.EditColumnFragment
 * JD-Core Version:    0.7.0.1
 */