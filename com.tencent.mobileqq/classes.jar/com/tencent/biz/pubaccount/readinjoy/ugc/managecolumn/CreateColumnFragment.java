package com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bhlq;
import bhnv;
import bhpc;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import org.jetbrains.annotations.NotNull;
import pfd;
import rab;
import rfn;
import rfo;
import rfp;
import rfw;
import tbz;

public class CreateColumnFragment
  extends AbsPublishColumnFragment
{
  private int b;
  
  public void a(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean)
  {
    super.a(paramColumnInfo, paramBoolean);
    pfd.a().g();
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
      if ((this.jdField_b_of_type_Int == 1) && (rab.i() == 2))
      {
        localObject = rab.a() + paramColumnInfo.columnID;
        tbz.a(getActivity(), "", (String)localObject, null, false);
      }
      rfp.a(paramColumnInfo);
    }
    QLog.i("RIJUGC.PublishTopicFragment", 1, "onColumnCreated, result = " + paramBoolean + ", id= " + paramColumnInfo.columnID + ", title = " + paramColumnInfo.title);
  }
  
  protected boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.b() > 0) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.b() > 0);
  }
  
  protected boolean b()
  {
    return (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.b() > 0);
  }
  
  public void e()
  {
    super.e();
    bhlq.a(getActivity(), 230).setMessage(2131717025).setNegativeButton(2131717022, new rfo(this)).setPositiveButton(2131717024, new rfn(this)).show();
  }
  
  public void f()
  {
    super.f();
    if (!bhnv.a())
    {
      QQToast.a(getActivity(), 0, getString(2131693963), 0).a();
      return;
    }
    this.jdField_a_of_type_Rfw.b(a());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717070);
    this.c.setText(2131717065);
    this.jdField_a_of_type_Rfw.b();
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