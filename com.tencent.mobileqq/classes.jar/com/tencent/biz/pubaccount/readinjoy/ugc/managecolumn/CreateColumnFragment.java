package com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bdcd;
import bdee;
import bdfq;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import oxb;
import qok;
import qtn;
import qto;
import qtv;
import smk;

public class CreateColumnFragment
  extends AbsPublishColumnFragment
{
  private int a;
  
  public void a(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean)
  {
    super.a(paramColumnInfo, paramBoolean);
    oxb.a().f();
    if (paramBoolean)
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("key_publish_result", true);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        ((Intent)localObject).putExtra("arg_callback", this.jdField_b_of_type_JavaLangString);
      }
      ((Intent)localObject).putExtra("key_column_info", paramColumnInfo);
      getActivity().setResult(2, (Intent)localObject);
      i();
      if ((this.jdField_a_of_type_Int == 1) && (qok.f() == 2))
      {
        localObject = qok.a() + paramColumnInfo.columnID;
        smk.a(getActivity(), "", (String)localObject, null, false);
      }
    }
    QLog.i("RIJUGC.PublishTopicFragment", 1, "onColumnCreated, result = " + paramBoolean + ", id= " + paramColumnInfo.columnID + ", title = " + paramColumnInfo.title);
  }
  
  protected boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a() > 0) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a() > 0);
  }
  
  protected boolean b()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a() > 0);
  }
  
  public void e()
  {
    super.e();
    bdcd.a(getActivity(), 230).setMessage(2131718760).setNegativeButton(2131718757, new qto(this)).setPositiveButton(2131718759, new qtn(this)).show();
  }
  
  public void f()
  {
    super.f();
    if (!bdee.a())
    {
      QQToast.a(getActivity(), 0, getString(2131694764), 0).a();
      return;
    }
    this.jdField_a_of_type_Qtv.b(a());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718801);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718796);
    this.jdField_a_of_type_Qtv.b();
    paramViewGroup = getArguments();
    if (paramViewGroup != null) {
      this.jdField_a_of_type_Int = paramViewGroup.getInt("key_from", 0);
    }
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.CreateColumnFragment
 * JD-Core Version:    0.7.0.1
 */