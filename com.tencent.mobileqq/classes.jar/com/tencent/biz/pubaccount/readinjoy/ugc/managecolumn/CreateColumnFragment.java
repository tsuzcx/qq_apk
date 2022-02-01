package com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bfur;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import org.jetbrains.annotations.NotNull;
import pim;
import pkp;
import rha;
import rmn;
import rmo;
import rmp;
import rmw;
import tgc;

public class CreateColumnFragment
  extends AbsPublishColumnFragment
{
  private int b;
  
  public void a(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean)
  {
    super.a(paramColumnInfo, paramBoolean);
    pkp.a().g();
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
      if ((this.jdField_b_of_type_Int == 1) && (rha.i() == 2))
      {
        localObject = rha.a() + paramColumnInfo.columnID;
        tgc.a(getActivity(), "", (String)localObject, null, false);
      }
      rmp.a(paramColumnInfo);
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
    bfur.a(getActivity(), 230).setMessage(2131717260).setNegativeButton(2131717257, new rmo(this)).setPositiveButton(2131717259, new rmn(this)).show();
  }
  
  public void f()
  {
    super.f();
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.a(getActivity(), 0, getString(2131694062), 0).a();
      return;
    }
    this.jdField_a_of_type_Rmw.b(a());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717307);
    this.c.setText(2131717302);
    this.jdField_a_of_type_Rmw.b();
    paramViewGroup = getArguments();
    if (paramViewGroup != null) {
      this.jdField_b_of_type_Int = paramViewGroup.getInt("key_from", 0);
    }
    pim.a.a(getActivity());
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.CreateColumnFragment
 * JD-Core Version:    0.7.0.1
 */