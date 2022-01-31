package com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bdgm;
import bdin;
import bdjz;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import oxb;
import qtp;
import qtq;
import qtr;
import qtv;

public class EditColumnFragment
  extends AbsPublishColumnFragment
{
  private ColumnInfo a;
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo == null) {}
    while ((TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.coverUrl, this.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.title, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a())) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.intro, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a()))) {
      return false;
    }
    return true;
  }
  
  public void b(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean)
  {
    super.b(paramColumnInfo, paramBoolean);
    oxb.a().f();
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_publish_result", true);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localIntent.putExtra("arg_callback", this.jdField_b_of_type_JavaLangString);
      }
      localIntent.putExtra("key_column_info", paramColumnInfo);
      getActivity().setResult(1, localIntent);
      i();
    }
    QLog.i("RIJUGC.PublishTopicFragment", 1, "onColumnEdited, result = " + paramBoolean + ", id= " + paramColumnInfo.columnID + ", title = " + paramColumnInfo.title);
  }
  
  protected boolean b()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a() > 0) && (a());
  }
  
  public void e()
  {
    super.e();
    bdgm.a(getActivity(), 230).setMessage(2131718774).setNegativeButton(2131718770, new qtr(this)).setPositiveButton(2131718773, new qtq(this)).show();
  }
  
  public void f()
  {
    super.f();
    if (!bdin.a())
    {
      QQToast.a(getActivity(), 0, getString(2131694766), 0).a();
      return;
    }
    this.jdField_a_of_type_Qtv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, a());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo = ((ColumnInfo)getActivity().getIntent().getParcelableExtra("key_column_info"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo == null) {
      QLog.e("RIJUGC.PublishTopicFragment", 1, "EditTopicFragment, mEditedTopicInfo == null");
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718773);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718884);
    b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountChangeListener(new qtp(this));
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.EditColumnFragment
 * JD-Core Version:    0.7.0.1
 */