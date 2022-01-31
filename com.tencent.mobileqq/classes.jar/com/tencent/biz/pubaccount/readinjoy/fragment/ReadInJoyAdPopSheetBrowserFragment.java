package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import bccj;
import bcfx;
import bcsr;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.qphone.base.util.QLog;
import ocf;
import otp;

public class ReadInJoyAdPopSheetBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  private static final String a;
  private String b;
  private String c;
  private String t;
  
  static
  {
    jdField_a_of_type_JavaLangString = ReadInJoyAdPopSheetBrowserFragment.class.getName();
  }
  
  private void i()
  {
    Object localObject = getActivity().getIntent();
    if (localObject != null)
    {
      this.b = ((Intent)localObject).getStringExtra("h5url");
      this.c = ((Intent)localObject).getStringExtra("adrl");
      this.t = ((Intent)localObject).getStringExtra("traceId");
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate h5Url: " + this.b);
    }
    if (TextUtils.isEmpty(this.b))
    {
      getActivity().finish();
      return;
    }
    localObject = ocf.a(getActivity(), this.b, this.c, this.t);
    ((ocf)localObject).a(new otp(this));
    ((ocf)localObject).show();
  }
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if ((this.jdField_a_of_type_Bccj != null) && (this.jdField_a_of_type_Bccj.a != null)) {
      this.jdField_a_of_type_Bccj.a.setVisibility(8);
    }
    if (this.d != null) {
      this.d.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Bcfx != null) && (this.jdField_a_of_type_Bcfx.a != null)) {
      this.jdField_a_of_type_Bcfx.a.a(false);
    }
    getActivity().getWindow().getDecorView().setSystemUiVisibility(514);
    return i;
  }
  
  public void onResume()
  {
    super.onResume();
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdPopSheetBrowserFragment
 * JD-Core Version:    0.7.0.1
 */