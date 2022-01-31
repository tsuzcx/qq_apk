package com.tencent.biz.pubaccount.readinjoy.pts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.pts.bridge.PTSJSBridgeManager;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSAppInstance.Builder;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import nio;
import niq;
import obz;
import pdn;
import pdo;
import pdp;
import pdq;
import pen;
import peo;

public class PTSFragment
  extends PublicBaseFragment
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private PTSAppInstance jdField_a_of_type_ComTencentPtsCorePTSAppInstance;
  public final String a;
  niq jdField_a_of_type_Niq = new pdp(this);
  private String b;
  private String c;
  
  public PTSFragment()
  {
    this.jdField_a_of_type_JavaLangString = "PTSFragment";
  }
  
  private void a()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.b = localIntent.getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.AppName");
    this.c = localIntent.getStringExtra("com.tencent.biz.pubaccount.readinjoy.pts.AppPath");
    QLog.i("PTSFragment", 1, "[initArguments], mAppName = " + this.b + ", mAppPath = " + this.c);
  }
  
  private void a(View paramView)
  {
    nio.a().a(9999, this.jdField_a_of_type_Niq);
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.addOnRecyclerViewScrollListener(new pdq(this));
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {}
    while (!TextUtils.equals(this.b, "daily_feeds")) {
      return;
    }
    paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131494329, paramViewGroup);
    View localView1 = paramViewGroup.findViewById(2131303952);
    View localView2 = paramViewGroup.findViewById(2131303962);
    ((TextView)paramViewGroup.findViewById(2131312560)).setVisibility(8);
    localView1.setOnClickListener(new pdn(this));
    localView2.setOnClickListener(new pdo(this));
  }
  
  private void b()
  {
    pen.a("0X800A7C7", "", "", "", new peo().a("page_name", this.b).a());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    a();
    paramViewGroup = paramLayoutInflater.inflate(2131494425, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (ViewGroup)paramViewGroup.findViewById(2131299149);
    a((ViewGroup)paramViewGroup.findViewById(2131311557));
    paramBundle = PTSJSBridgeManager.getInstance().getJSBridge(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance = new PTSAppInstance.Builder().withActivity(this.jdField_a_of_type_AndroidAppActivity).withRootView(paramLayoutInflater).withRootNodeType(0).withPTSJSBridge(paramBundle).withAppName(this.b).withAppPath(this.c).build();
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.onCreate();
    a(paramViewGroup);
    b();
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    QLog.i("PTSFragment", 1, "[onDestroy]");
    super.onDestroy();
    PTSThreadUtil.runOnSubThread(new PTSFragment.1(this, this.jdField_a_of_type_AndroidAppActivity));
    nio.a().b(9999, this.jdField_a_of_type_Niq);
  }
  
  public void onFinish()
  {
    QLog.i("PTSFragment", 2, "[onFinish]");
    super.onFinish();
    PTSThreadUtil.runOnSubThread(new PTSFragment.2(this));
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    obz.a(this.jdField_a_of_type_AndroidAppActivity, true, obz.a(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment
 * JD-Core Version:    0.7.0.1
 */