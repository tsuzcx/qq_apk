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
import rjh;
import ror;
import ros;
import rot;
import rpa;
import tlg;

public class CreateColumnFragment
  extends AbsPublishColumnFragment
{
  private int b;
  
  public void a(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean)
  {
    super.a(paramColumnInfo, paramBoolean);
    pmk.a().g();
    if (paramBoolean)
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("key_publish_result", true);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        ((Intent)localObject).putExtra("arg_callback", this.jdField_a_of_type_JavaLangString);
      }
      ((Intent)localObject).putExtra("key_column_info", paramColumnInfo);
      getActivity().setResult(2, (Intent)localObject);
      i();
      if ((this.jdField_b_of_type_Int == 1) && (rjh.h() == 2))
      {
        localObject = rjh.a() + paramColumnInfo.columnID;
        tlg.a(getActivity(), "", (String)localObject, null, false);
      }
      rot.a(paramColumnInfo);
    }
    QLog.i("RIJUGC.PublishTopicFragment", 1, "onColumnCreated, result = " + paramBoolean + ", id= " + paramColumnInfo.columnID + ", title = " + paramColumnInfo.title);
  }
  
  protected boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a() > 0) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a() > 0);
  }
  
  protected boolean b()
  {
    return (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a() > 0);
  }
  
  public void e()
  {
    super.e();
    bglp.a(getActivity(), 230).setMessage(2131716909).setNegativeButton(2131716906, new ros(this)).setPositiveButton(2131716908, new ror(this)).show();
  }
  
  public void f()
  {
    super.f();
    if (!bgnt.a())
    {
      QQToast.a(getActivity(), 0, getString(2131693946), 0).a();
      return;
    }
    this.jdField_a_of_type_Rpa.b(a());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131716954);
    this.c.setText(2131716949);
    this.jdField_a_of_type_Rpa.b();
    paramViewGroup = getArguments();
    if (paramViewGroup != null) {
      this.jdField_b_of_type_Int = paramViewGroup.getInt("key_from", 0);
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.CreateColumnFragment
 * JD-Core Version:    0.7.0.1
 */