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
import ntv;
import ntx;
import onh;
import ppc;
import ppd;
import ppe;
import ppf;
import pqe;
import pqf;

public class PTSFragment
  extends PublicBaseFragment
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private PTSAppInstance jdField_a_of_type_ComTencentPtsCorePTSAppInstance;
  public final String a;
  ntx jdField_a_of_type_Ntx = new ppe(this);
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
    ntv.a().a(9999, this.jdField_a_of_type_Ntx);
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.addOnRecyclerViewScrollListener(new ppf(this));
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {}
    while (!TextUtils.equals(this.b, "daily_feeds")) {
      return;
    }
    paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131559900, paramViewGroup);
    View localView1 = paramViewGroup.findViewById(2131369625);
    View localView2 = paramViewGroup.findViewById(2131369634);
    ((TextView)paramViewGroup.findViewById(2131378389)).setVisibility(8);
    localView1.setOnClickListener(new ppc(this));
    localView2.setOnClickListener(new ppd(this));
  }
  
  private void b()
  {
    pqe.a("0X800A7C7", "", "", "", new pqf().a("page_name", this.b).a());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    a();
    paramViewGroup = paramLayoutInflater.inflate(2131559995, paramViewGroup, false);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramViewGroup.setFitsSystemWindows(true);
      paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (ViewGroup)paramViewGroup.findViewById(2131364708);
    a((ViewGroup)paramViewGroup.findViewById(2131377373));
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
    ntv.a().b(9999, this.jdField_a_of_type_Ntx);
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
    onh.a(this.jdField_a_of_type_AndroidAppActivity, true, onh.a(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_ComTencentPtsCorePTSAppInstance.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment
 * JD-Core Version:    0.7.0.1
 */