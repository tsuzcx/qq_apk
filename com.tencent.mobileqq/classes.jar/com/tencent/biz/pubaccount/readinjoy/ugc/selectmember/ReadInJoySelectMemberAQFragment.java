package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import bbfj;
import bcqf;
import bcql;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import onh;
import org.json.JSONObject;
import osg;
import osj;
import osm;
import qhe;
import qhu;

public class ReadInJoySelectMemberAQFragment
  extends ReadInJoySelectMemberFragment
{
  private int jdField_a_of_type_Int;
  protected bcqf a;
  private String jdField_a_of_type_JavaLangString = "";
  osm jdField_a_of_type_Osm = new qhe(this);
  public boolean a;
  private int jdField_b_of_type_Int = 10000;
  private boolean jdField_b_of_type_Boolean;
  private int c = -1;
  
  private String a(ResultRecord paramResultRecord, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ask_rowkey", paramString);
      localJSONObject.put("uin", String.valueOf(onh.a()));
      localJSONObject.put("invite_uin", paramResultRecord.a());
      localJSONObject.put("invite_type", paramResultRecord.a());
      return localJSONObject.toString();
    }
    catch (Exception paramResultRecord)
    {
      for (;;)
      {
        paramResultRecord.printStackTrace();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.executeOnSubThread(new ReadInJoySelectMemberAQFragment.3(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList, this.jdField_a_of_type_Qhu.b()));
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bcqf != null)
    {
      this.jdField_a_of_type_Bcqf.c(paramInt1);
      if (!this.jdField_a_of_type_Bcqf.isShowing())
      {
        this.jdField_a_of_type_Bcqf.show();
        this.rightViewText.postDelayed(new ReadInJoySelectMemberAQFragment.1(this, paramInt2), paramInt3);
      }
    }
  }
  
  protected void b()
  {
    if (getActivity() == null) {
      return;
    }
    e();
    if (!bbfj.g(getActivity()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "network error!");
      }
      bcql.a(getActivity(), 1, getString(2131718402), 0).b(this.jdField_a_of_type_Int);
      return;
    }
    a(2131718564, 2131718561, this.jdField_b_of_type_Int);
    osg.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList, onh.a(), this.jdField_a_of_type_Qhu.b());
  }
  
  public void c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_callback", this.jdField_a_of_type_Qhu.a());
    localIntent.putExtra("result_msg", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("result_code", this.c);
    getActivity().setResult(-1, localIntent);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Int = getActivity().getResources().getDimensionPixelSize(2131298865);
    if (this.jdField_a_of_type_Bcqf == null)
    {
      this.jdField_a_of_type_Bcqf = new bcqf(getActivity(), this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bcqf.setCanceledOnTouchOutside(true);
    }
    osj.a().a(this.jdField_a_of_type_Osm);
  }
  
  public boolean onBackEvent()
  {
    this.c = 1;
    if (this.jdField_b_of_type_Boolean) {
      this.c = 2;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bcqf != null)
    {
      this.jdField_a_of_type_Bcqf.dismiss();
      this.jdField_a_of_type_Bcqf = null;
    }
    osj.a().b(this.jdField_a_of_type_Osm);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment
 * JD-Core Version:    0.7.0.1
 */