package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import bhmv;
import bhql;
import bidh;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.qphone.base.util.QLog;
import ost;
import pog;

public class ReadInJoyAdPopSheetBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  private static final String a = ReadInJoyAdPopSheetBrowserFragment.class.getName();
  private String b;
  private String c;
  private String d;
  
  private void a()
  {
    Object localObject = getActivity().getIntent();
    if (localObject != null)
    {
      this.b = ((Intent)localObject).getStringExtra("h5url");
      this.c = ((Intent)localObject).getStringExtra("adrl");
      this.d = ((Intent)localObject).getStringExtra("traceId");
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onCreate h5Url: " + this.b);
    }
    if (TextUtils.isEmpty(this.b))
    {
      getActivity().finish();
      return;
    }
    localObject = ost.a(getActivity(), this.b, this.c, this.d);
    ((ost)localObject).a(new pog(this));
    ((ost)localObject).show();
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    if ((this.mSwiftTitleUI != null) && (this.mSwiftTitleUI.a != null)) {
      this.mSwiftTitleUI.a.setVisibility(8);
    }
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setVisibility(8);
    }
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.a != null)) {
      this.mUIStyleHandler.a.a(false);
    }
    getActivity().getWindow().getDecorView().setSystemUiVisibility(514);
    return i;
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdPopSheetBrowserFragment
 * JD-Core Version:    0.7.0.1
 */